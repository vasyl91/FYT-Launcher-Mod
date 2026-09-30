package com.fyt.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.settings.Keys;
import com.syu.widget.util.TimeUtil;

public class DateTwo extends AppCompatTextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String TAG = "DateTwo";

    /** Share of this view's slot in the parent (parent height / TextView count) the text may fill. */
    private static final float TARGET_HEIGHT_FRACTION = 0.9f;
    /** Floor for the text size: the date can never end up invisible. */
    private static final float MIN_TEXT_SP = 8f;
    /** A parent lower than this fraction of the bar height is a transient layout - do not fit from it. */
    private static final float MIN_PARENT_FRACTION = 0.25f;
    /** Parent size changes up to this many px are layout noise, not a reason to refit. */
    private static final int REFIT_TOLERANCE_PX = 2;
    /** Safety net against a layout feedback loop: at most this many refits per window. */
    private static final int MAX_REFITS_PER_WINDOW = 8;
    private static final long REFIT_WINDOW_MS = 2000L;

    private static DateTwo mDateTwo;
    private final Context mContext;
    private SharedPreferences mPrefs;
    private int mDefaultTextColor;

    /** Parent the layout listener is registered on; null while detached. */
    private View mObservedParent;
    /** Parent size the current text size was fitted to; -1 = not fitted yet. */
    private int mFittedParentWidth = -1;
    private int mFittedParentHeight = -1;
    private long mRefitWindowStartMs = 0L;
    private int mRefitsInWindow = 0;
    private boolean mRefitLimitLogged = false;

    private final Runnable mFitRunnable = this::fitTextSize;

    private final View.OnLayoutChangeListener mParentLayoutListener =
            (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
                if (shouldRefit(right - left, bottom - top)) {
                    // Posted, not run from inside the layout pass: a new text size requests
                    // another layout.
                    scheduleFit();
                }
            };

    public static DateTwo getDateTwo() {
        return mDateTwo;
    }

    public DateTwo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    public DateTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public DateTwo(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    void init() {
        mDateTwo = this;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        // Store the default text color for later use
        mDefaultTextColor = getCurrentTextColor();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Register preference change listener
        mPrefs.registerOnSharedPreferenceChangeListener(this);
        observeParent();
        // A fresh fit for every attach: the parent may have another size by now.
        mFittedParentWidth = -1;
        mFittedParentHeight = -1;
        setDateTwo();
        updateTextColor();
        scheduleFit();
    }

    @Override
    protected void onDetachedFromWindow() {
        removeCallbacks(mFitRunnable);
        stopObservingParent();

        // Unregister preference change listener
        mPrefs.unregisterOnSharedPreferenceChangeListener(this);

        // Clear static reference to prevent context leaks
        if (mDateTwo == this) {
            mDateTwo = null;
        }

        super.onDetachedFromWindow();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == View.VISIBLE) {
            // Back on the screen (e.g. after a wake): refit if the last fit is missing or stale.
            verifyFit();
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (Keys.BLACK_BAR.equals(key)) {
            updateTextColor();
        }
    }

    private void updateTextColor() {
        boolean blackTintWidgets = mPrefs.getBoolean(Keys.BLACK_BAR, false);
        if (blackTintWidgets) {
            setTextColor(Color.BLACK);
        } else {
            // Reset to default color (could be from XML or theme)
            setTextColor(mDefaultTextColor);
        }
    }

    /**
     * Sets today's date. Called on attach and by TimeUpdateReceiver on every time update, so it
     * only touches the text when the date has changed and otherwise just checks the fit.
     */
    public void setDateTwo() {
        String text = TimeUtil.getDateOfToday(this.mContext, getDateStringFormat(5));

        if (!TextUtils.equals(getText(), text)) {
            setText(text);
            // Another text may need another size.
            mFittedParentWidth = -1;
            mFittedParentHeight = -1;
            scheduleFit();
        } else {
            verifyFit();
        }

        if (mPrefs.getBoolean(Keys.BLACK_BAR, false)) {
            setTextColor(Color.BLACK);
        }
    }

    /**
     * Until the first successful fit the text keeps its XML size (0sp for the bar texts). While the
     * parent only has a transient size it is raised to MIN_TEXT_SP, so the date stays on the screen
     * even if the real layout never comes. A normal start is not affected: the fit follows the
     * first real layout, exactly as the old single fit did.
     */
    private void ensureVisibleTextSize() {
        float minPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, MIN_TEXT_SP,
                getResources().getDisplayMetrics());
        if (getTextSize() < minPx - 0.5f) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, MIN_TEXT_SP);
        }
    }

    /** Refits if the text was never fitted or the parent size has changed since. Cheap otherwise. */
    private void verifyFit() {
        View parent = mObservedParent;
        if (parent == null) {
            return;
        }
        if (mFittedParentHeight < 0
                || Math.abs(parent.getHeight() - mFittedParentHeight) > REFIT_TOLERANCE_PX
                || Math.abs(parent.getWidth() - mFittedParentWidth) > REFIT_TOLERANCE_PX) {
            scheduleFit();
        }
    }

    private void scheduleFit() {
        if (!isAttachedToWindow()) {
            return; // onAttachedToWindow() schedules the fit
        }
        removeCallbacks(mFitRunnable);
        post(mFitRunnable);
    }

    private void observeParent() {
        View parent = getParent() instanceof View ? (View) getParent() : null;
        if (parent == mObservedParent) {
            return;
        }
        stopObservingParent();
        if (parent != null) {
            parent.addOnLayoutChangeListener(mParentLayoutListener);
            mObservedParent = parent;
        }
    }

    private void stopObservingParent() {
        if (mObservedParent != null) {
            mObservedParent.removeOnLayoutChangeListener(mParentLayoutListener);
            mObservedParent = null;
        }
    }

    /**
     * Decides whether a parent layout should trigger a refit (same rules as Workspace.BarTextFit).
     * Growth always does - that is the recovery after a transient layout. Shrinking only does when
     * that size of the parent does not depend on its content, otherwise a smaller text could shrink
     * the parent and start a feedback loop. The rate limit is the last safety net.
     */
    private boolean shouldRefit(int parentWidth, int parentHeight) {
        if (parentWidth <= 0 || parentHeight <= 0) {
            return false;
        }
        boolean needed;
        if (mFittedParentWidth < 0 || mFittedParentHeight < 0) {
            needed = true;
        } else {
            ViewGroup.LayoutParams lp = mObservedParent != null ? mObservedParent.getLayoutParams() : null;
            int lpWidth = lp != null ? lp.width : ViewGroup.LayoutParams.MATCH_PARENT;
            int lpHeight = lp != null ? lp.height : ViewGroup.LayoutParams.MATCH_PARENT;
            needed = sizeChangeNeedsRefit(mFittedParentHeight, parentHeight, lpHeight)
                    || sizeChangeNeedsRefit(mFittedParentWidth, parentWidth, lpWidth);
        }
        if (!needed) {
            return false;
        }

        long now = SystemClock.uptimeMillis();
        if (now - mRefitWindowStartMs > REFIT_WINDOW_MS) {
            mRefitWindowStartMs = now;
            mRefitsInWindow = 0;
            mRefitLimitLogged = false;
        }
        if (mRefitsInWindow >= MAX_REFITS_PER_WINDOW) {
            if (!mRefitLimitLogged) {   // once per window, not on every blocked layout
                mRefitLimitLogged = true;
                Log.w(TAG, "Refit limit reached (" + MAX_REFITS_PER_WINDOW + " in "
                        + REFIT_WINDOW_MS + " ms), retrying once the window has passed");
                // The blocked layout may be the last one: without the retry the date would keep
                // whatever size it had until the next layout.
                removeCallbacks(mFitRunnable);
                postDelayed(mFitRunnable, Math.max(0L, REFIT_WINDOW_MS - (now - mRefitWindowStartMs)));
            }
            return false;
        }
        mRefitsInWindow++;
        return true;
    }

    private static boolean sizeChangeNeedsRefit(int fittedSize, int currentSize, int layoutParamSize) {
        if (currentSize > fittedSize + REFIT_TOLERANCE_PX) {
            return true;
        }
        if (currentSize < fittedSize - REFIT_TOLERANCE_PX) {
            return layoutParamSize != ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        return false;
    }

    /**
     * Fits the text into this view's share of the parent height, within the available width (the
     * text may wrap). Leaves the fit pending while the parent has no real size yet: the parent
     * layout listener runs it again as soon as it has one.
     */
    private void fitTextSize() {
        final View parent = mObservedParent;
        if (parent == null || !isAttachedToWindow() || !parent.isLaidOut()) {
            return;
        }
        final int parentWidth = parent.getWidth();
        final int parentHeight = parent.getHeight();
        if (parentWidth <= 0 || parentHeight <= 0) {
            return;
        }
        int expectedBarHeight = getExpectedBarHeight();
        if (expectedBarHeight > 0 && parentHeight < expectedBarHeight * MIN_PARENT_FRACTION) {
            Log.w(TAG, "Fit skipped: parent " + parentHeight + "px, bar " + expectedBarHeight
                    + "px - transient layout, waiting for a real one");
            ensureVisibleTextSize();
            return;
        }

        // Count TextViews in parent
        int textViewCount = 0;
        if (parent instanceof ViewGroup) {
            ViewGroup parentGroup = (ViewGroup) parent;
            for (int i = 0; i < parentGroup.getChildCount(); i++) {
                if (parentGroup.getChildAt(i) instanceof TextView) {
                    textViewCount++;
                }
            }
        }
        if (textViewCount == 0) {
            return;
        }

        // Calculate target height for this TextView
        int targetHeight = (int) ((parentHeight / textViewCount) * TARGET_HEIGHT_FRACTION);
        if (targetHeight <= 0) {
            return;
        }

        DisplayMetrics dm = getResources().getDisplayMetrics();
        // Prepare density-based upper bound (in SP) so we don't pick absurdly large fonts
        float scaledDensity = dm.scaledDensity;
        // Estimate maximum SP that could fit into targetHeight: divide pixel height by scaledDensity
        float maxSpFromHeight = Math.max(MIN_TEXT_SP, targetHeight / Math.max(1f, scaledDensity));
        // Use a reasonable safety multiplier to allow multi-line spacing
        maxSpFromHeight = maxSpFromHeight * 0.9f; // keep a little headroom

        // Binary search for best size (in SP units)
        float minSize = 1f;
        float maxSize = Math.min(500f, maxSpFromHeight);
        float bestSize = Math.max(minSize, Math.min((float) Launcher.textSizeBasic, maxSize)); // start from reasonable default

        String text = getText().toString();
        TextPaint paint = new TextPaint(getPaint());
        int width = getAvailableTextWidth(parent);

        // Narrow the binary search tolerance a bit for stability
        while (maxSize - minSize > 0.25f) {
            float testSize = (minSize + maxSize) / 2f;
            // convert SP to px for paint
            paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, testSize, dm));

            StaticLayout layout = new StaticLayout(text, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);

            if (layout.getHeight() <= targetHeight) {
                bestSize = testSize;
                minSize = testSize;
            } else {
                maxSize = testSize;
            }
        }

        // Clamp final size to safe bounds; the floor also applies in a parent too small for it.
        final float finalBestSize = Math.max(MIN_TEXT_SP, Math.min(bestSize, maxSize));
        final float finalBestPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, finalBestSize, dm);

        // Never clamp below what the chosen size needs - a tiny maxHeight hid the text as well.
        paint.setTextSize(finalBestPx);
        StaticLayout finalLayout = new StaticLayout(text, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int neededHeight = finalLayout.getHeight() + getCompoundPaddingTop() + getCompoundPaddingBottom();
        int maxHeight = Math.max(targetHeight, neededHeight);
        if (getMaxHeight() != maxHeight) {
            setMaxHeight(maxHeight);
        }
        if (Math.abs(getTextSize() - finalBestPx) > 0.5f) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, finalBestSize);
        }
        mFittedParentWidth = parentWidth;
        mFittedParentHeight = parentHeight;
    }

    /**
     * Width the text may use. With a wrap_content width the view's own width follows the text size,
     * so a refit measured against it could only keep the text as small as it already is; the parent
     * width is the real limit then (and is what the old single fit measured against, too, since it
     * started from an empty 0sp view).
     */
    private int getAvailableTextWidth(View parent) {
        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        ViewGroup.LayoutParams lp = getLayoutParams();
        boolean wrapsWidth = lp != null && lp.width == ViewGroup.LayoutParams.WRAP_CONTENT;
        int width = wrapsWidth ? 0 : getWidth() - horizontalPadding;
        if (width <= 0) {
            width = parent.getWidth() - horizontalPadding;
        }
        if (width <= 0) {
            // fallback to a fraction of screen width if nothing else available
            width = getResources().getDisplayMetrics().widthPixels / 3;
        }
        return width;
    }

    /** Height of the bottom bar as the launcher lays it out; 0 if unknown. */
    private static int getExpectedBarHeight() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) {
            return 0;
        }
        try {
            return launcher.getBottomBarHeight();
        } catch (RuntimeException e) {
            return 0;
        }
    }

    private String getDateStringFormat(int timeWidgetShow) {
        switch (timeWidgetShow) {
            case 0:
                return "yyyy-MM-dd";
            case 1:
                return "yyyy/MM/dd";
            case 2:
                return "yyyy.MM.dd";
            case 3:
                return "yyyy - MM - dd";
            case 4:
                return "MM月dd日";
            case 5:
                return "MM-dd";
            default:
                return "yyyy/MM/dd";
        }
    }
}
