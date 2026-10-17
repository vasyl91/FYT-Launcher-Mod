package com.android.launcher66;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import androidx.appcompat.view.ContextThemeWrapper;

import com.android.launcher66.DragLayer.TouchCompleteListener;

/**
 * {@inheritDoc}
 */
public class LauncherAppWidgetHostView extends AppWidgetHostView implements TouchCompleteListener {
    private CheckLongPressHelper mLongPressHelper;
    private LayoutInflater mInflater;
    private Context mContext;
    private int mPreviousOrientation;
    private DragLayer mDragLayer;
    private Launcher mLauncher;
    private LauncherAppWidgetHost.OnWidgetClickListener listener;

    /**
     * The scaleX and scaleY value such that the widget fits within its cellspans, scaleX = scaleY.
     */
    private float mScaleToFit = 1.0f;

    /**
     * The translation values to center the widget within its cellspans.
     */
    private final PointF mTranslationForCentering = new PointF(0, 0);

    public LauncherAppWidgetHostView(Context context, Launcher launcher) {
        super(context);
        mContext = context;
        mLauncher = launcher;
        mLongPressHelper = new CheckLongPressHelper(this);
        Context themedContext = new ContextThemeWrapper(context, R.style.WidgetTheme);
        mInflater = (LayoutInflater) themedContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDragLayer = ((Launcher) mLauncher).getDragLayer();
    }    

    public void setOnWidgetClickListener(LauncherAppWidgetHost.OnWidgetClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected View getErrorView() {
        requestProviderUpdate();
        return mInflater.inflate(R.layout.appwidget_error, this, false);
    }

    /** At most this many update requests per widget view, a moment apart. */
    private static final String UPDATE_TAG = "WidgetUpdate";
    private static final int MAX_UPDATE_REQUESTS = 2;
    private static final long UPDATE_REQUEST_DELAY_MS = 1000L;
    private int mUpdateRequests;

    /**
     * The content could not be shown ("Problem loading widget"): asks the widget's app to send it
     * again. Mostly an image the app shares through its own content provider: the read
     * permission it gave the launcher is dropped whenever the launcher is installed again, and
     * comes back only with the app's next update (a restart of the phone was the cure).
     */
    private void requestProviderUpdate() {
        final AppWidgetProviderInfo info = getAppWidgetInfo();
        final int appWidgetId = getAppWidgetId();
        if (info == null || info.provider == null || appWidgetId <= 0
                || mUpdateRequests >= MAX_UPDATE_REQUESTS) {
            return;
        }
        mUpdateRequests++;
        postDelayed(() -> {
            Intent update = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
                    .setComponent(info.provider)
                    .putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, new int[] { appWidgetId });
            try {
                getContext().sendBroadcast(update);
                Log.i(UPDATE_TAG, "widget " + appWidgetId + " (" + info.provider.flattenToShortString()
                        + ") failed to show: asked its app for an update");
            } catch (RuntimeException e) {
                Log.w(UPDATE_TAG, "widget " + appWidgetId + ": update not requested: " + e);
            }
        }, UPDATE_REQUEST_DELAY_MS);
    }

    @Override
    public void updateAppWidget(RemoteViews remoteViews) {
        // Store the orientation in which the widget was inflated
        mPreviousOrientation = mContext.getResources().getConfiguration().orientation;
        super.updateAppWidget(remoteViews);
        // New content may take another part of the widget.
        requestFit();
    }

    // =====================================================================================
    // Fit to the cells
    // =====================================================================================

    private static final String TAG = "WidgetFit";
    /** Further than this a widget's content is not enlarged: a mostly empty one would blur. */
    private static final float MAX_FIT_SCALE = 4f;
    /** The content is drawn this small to find where it shows (longer side, in pixels). */
    private static final int FIT_PROBE_SIZE = 160;
    /** Pixels fainter than this (of 255) count as empty: soft shadows round a card do too. */
    private static final int FIT_ALPHA_THRESHOLD = 24;
    /** After an update or a layout, before the content is looked at: the burst settles. */
    private static final long FIT_DELAY_MS = 200L;

    /**
     * Whether the widget's content is enlarged to fill its cells. Many widgets lay their visible
     * part out small in the middle of transparent margins of their own layout (a card on a
     * large empty view); this finds the part that shows and scales the content up, evenly, until
     * it fills the cells one way and is centred the other. The widget's own view keeps its size
     * and position (touch, drag and the resize frame go by it) and clips what spills over.
     * Set for each widget by the user from its resize frame (see WidgetFit).
     */
    private boolean mFitContent;
    private final Runnable mFitRunnable = this::applyFit;

    @Override
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        super.setAppWidget(appWidgetId, info);
        setFitContent(WidgetFit.isOn(getContext(), appWidgetId));
    }

    public boolean isFitContent() {
        return mFitContent;
    }

    public void setFitContent(boolean fit) {
        mFitContent = fit;
        if (fit) {
            requestFit();
        } else {
            removeCallbacks(mFitRunnable);
            View content = getChildCount() > 0 ? getChildAt(0) : null;
            if (content != null) resetFit(content);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) requestFit();
    }

    private void requestFit() {
        if (!mFitContent) return;
        removeCallbacks(mFitRunnable);
        postDelayed(mFitRunnable, FIT_DELAY_MS);
    }

    private static void resetFit(View content) {
        content.setScaleX(1f);
        content.setScaleY(1f);
        content.setTranslationX(0f);
        content.setTranslationY(0f);
    }

    private void applyFit() {
        View content = getChildCount() > 0 ? getChildAt(0) : null;
        int w = getWidth();
        int h = getHeight();
        if (!mFitContent || content == null || w <= 0 || h <= 0) return;
        Rect shown = shownBounds(content, w, h);
        if (shown == null || shown.width() <= 0 || shown.height() <= 0) {
            resetFit(content);
            return;
        }
        float k = Math.min(MAX_FIT_SCALE,
                Math.min(w / (float) shown.width(), h / (float) shown.height()));
        if (k <= 1.02f) {
            resetFit(content);
            return;
        }
        // Scaled from the content's top left, then moved so the part that shows is centred.
        int left = content.getLeft();
        int top = content.getTop();
        content.setPivotX(0f);
        content.setPivotY(0f);
        content.setScaleX(k);
        content.setScaleY(k);
        content.setTranslationX((w - shown.width() * k) / 2f - left - (shown.left - left) * k);
        content.setTranslationY((h - shown.height() * k) / 2f - top - (shown.top - top) * k);
    }

    /**
     * Where the content shows, in this view's pixels: the bounds of what it draws that is not
     * (nearly) transparent. Drawn small, untransformed; null when it cannot be drawn.
     */
    private static Rect shownBounds(View content, int w, int h) {
        float f = Math.min(1f, FIT_PROBE_SIZE / (float) Math.max(w, h));
        int bw = Math.max(1, Math.round(w * f));
        int bh = Math.max(1, Math.round(h * f));
        Bitmap probe = Bitmap.createBitmap(bw, bh, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(probe);
            canvas.scale(f, f);
            canvas.translate(content.getLeft(), content.getTop());
            content.draw(canvas);
            int[] px = new int[bw * bh];
            probe.getPixels(px, 0, bw, 0, 0, bw, bh);
            int minX = bw, minY = bh, maxX = -1, maxY = -1;
            for (int y = 0; y < bh; y++) {
                for (int x = 0; x < bw; x++) {
                    if ((px[y * bw + x] >>> 24) > FIT_ALPHA_THRESHOLD) {
                        if (x < minX) minX = x;
                        if (x > maxX) maxX = x;
                        if (y < minY) minY = y;
                        if (y > maxY) maxY = y;
                    }
                }
            }
            if (maxX < 0) return null;
            return new Rect(Math.max(0, (int) Math.floor(minX / f)),
                    Math.max(0, (int) Math.floor(minY / f)),
                    Math.min(w, (int) Math.ceil((maxX + 1) / f)),
                    Math.min(h, (int) Math.ceil((maxY + 1) / f)));
        } catch (Throwable t) {
            // A hardware bitmap in the content cannot be drawn in software, for one.
            Log.w(TAG, "content not measured: " + t);
            return null;
        } finally {
            probe.recycle();
        }
    }

    public boolean orientationChangedSincedInflation() {
        int orientation = mContext.getResources().getConfiguration().orientation;
        if (mPreviousOrientation != orientation) {
           return true;
       }
       return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Consume any touch events for ourselves after longpress is triggered
        if (mLongPressHelper.hasPerformedLongPress()) {
            mLongPressHelper.cancelLongPress();
            return true;
        }

        // Watch for longpress events at this level to make sure
        // users can always pick up this widget
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (listener != null) {
                    listener.onWidgetClicked(getAppWidgetId());
                }
                mLongPressHelper.postCheckForLongPress();
                mDragLayer.setTouchCompleteListener(this);
                break;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLongPressHelper.cancelLongPress();
                break;
        }

        // Otherwise continue letting touch events fall through to children
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        // If the widget does not handle touch, then cancel
        // long press when we release the touch
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLongPressHelper.cancelLongPress();
                break;
        }
        return false;
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mLongPressHelper.cancelLongPress();
    }

    @Override
    public void onTouchComplete() {
        mLongPressHelper.cancelLongPress();
    }

    @Override
    public int getDescendantFocusability() {
        return ViewGroup.FOCUS_BLOCK_DESCENDANTS;
    }

    /**
     * Whether v is a widget laid out at the widget scale (ScreenScale.widgetScale()) and centred
     * by a translation in its cells: every widget, whatever its resize mode, so any of them can
     * be resized.
     */
    public static boolean isScaled(View v) {
        return v instanceof LauncherAppWidgetHostView
                && ((LauncherAppWidgetHostView) v).getAppWidgetInfo() != null;
    }

    /**
     * No default padding round the widget's content (AppWidgetHostView's, for widgets made
     * before Android 12): it fills its cells edge to edge.
     */
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setScaleToFit(float scale) {
        mScaleToFit = scale;
        setScaleX(scale);
        setScaleY(scale);
    }

    public void setTranslationForCentering(float x, float y) {
        mTranslationForCentering.set(x, y);
        setTranslationX(x);
        setTranslationY(y);
    }

    public float getScaleToFit() {
        return mScaleToFit;
    }

    public float getTranslationXForCentering() {
        return mTranslationForCentering.x;
    }

    public float getTranslationYForCentering() {
        return mTranslationForCentering.y;
    }
}
