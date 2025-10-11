package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.R;

public class CustomWidgetPreference extends Preference {

    private SwitchCompat mMainSwitch;  
    private TouchDelegateGroup mTouchDelegateGroup;
    private LinearLayout mScreenButtonContainer;   
    private TextView mScreenLabel;
    private EditText mScreenInput;             
    private AppCompatButton mPositionButton;        
    private View mImeMaskOverlay;

    private View mBoundItemView;

    public interface OnPositionClickListener { void onPositionClick(CustomWidgetPreference pref); }
    @Nullable private OnPositionClickListener mPositionListener;

    @Nullable private String mScreenValuePrefKey;

    private int mPendingPositionBtnTextColor = Color.TRANSPARENT;

    public CustomWidgetPreference(Context context) { this(context, null); }
    public CustomWidgetPreference(Context context, AttributeSet attrs) { this(context, attrs, androidx.preference.R.attr.switchPreferenceCompatStyle); }
    public CustomWidgetPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWidgetLayoutResource(R.layout.widget_preference);
    }

    public void setOnPositionClickListener(@Nullable OnPositionClickListener l) { mPositionListener = l; }

    public void setScreenValuePrefKey(@Nullable String key) { mScreenValuePrefKey = key; }

    public void setPositionButtonTextColor(@ColorInt int color) {
        mPendingPositionBtnTextColor = color;
        if (mPositionButton != null) {
            mPositionButton.setTextColor(color);
        }
    }

    @Override public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mBoundItemView = holder.itemView;
        if (mBoundItemView != null) {
            int switchWidth = getSwitchWidthFromSwitchPreference();
            mBoundItemView.setPaddingRelative(
                mBoundItemView.getPaddingStart(),
                mBoundItemView.getPaddingTop(),
                switchWidth, // Right padding to simulate switch space
                mBoundItemView.getPaddingBottom()
            );
        }
        mMainSwitch = (SwitchCompat) holder.findViewById(androidx.preference.R.id.switchWidget);
        mScreenButtonContainer = (LinearLayout) holder.findViewById(R.id.btnScreenContainer);
        mScreenLabel = (TextView) holder.findViewById(R.id.tvScreenLabel);
        mScreenInput = (EditText) holder.findViewById(R.id.etScreenNumber);
        mPositionButton = (AppCompatButton) holder.findViewById(R.id.btnPositionPip);

        if (mMainSwitch != null) {
            ViewGroup.LayoutParams rawLp = mMainSwitch.getLayoutParams();
            ViewGroup.MarginLayoutParams lp = (rawLp instanceof ViewGroup.MarginLayoutParams)
                    ? (ViewGroup.MarginLayoutParams) rawLp
                    : new LinearLayout.LayoutParams(rawLp.width, rawLp.height);
            lp.setMarginStart(SettingsActivity.nestedPaddingStart);
            mMainSwitch.setLayoutParams(lp);
        }

        if (mScreenInput != null) {
            mScreenInput.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
            mScreenInput.setFilters(new InputFilter[] {
                    new InputFilter.LengthFilter(2),
                    new MinMaxFilter(1, 99)
            });
            // Load saved value (default 1)
            int current = 1;
            SharedPreferences sp = getPreferenceManager() != null ? getPreferenceManager().getSharedPreferences() : null;
            if (!TextUtils.isEmpty(mScreenValuePrefKey) && sp != null) {
                current = Math.max(1, Math.min(99, sp.getInt(mScreenValuePrefKey, 1)));
            }
            mScreenInput.setText(String.valueOf(current));

            // Persist on IME action or focus loss
            mScreenInput.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    saveScreenNumberFromInput();
                    // Close the keyboard and remove the transparent mask when saving
                    hideKeyboard();
                    removeImeMaskOverlay();
                    return true;
                }
                return false;
            });
            mScreenInput.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    showImeMaskOverlay();
                } else {
                    saveScreenNumberFromInput();
                    removeImeMaskOverlay();
                }
            });
        }

        if (mPositionButton != null) {
            mPositionButton.setTextColor(Color.WHITE);
            mPositionButton.setAllCaps(false);
            if (mPendingPositionBtnTextColor != Color.TRANSPARENT) {
                mPositionButton.setTextColor(mPendingPositionBtnTextColor);
            }
            mPositionButton.setOnClickListener(v -> {
                if (mPositionListener != null) mPositionListener.onPositionClick(this);
            });
        }

        scheduleRuntimeSizing();
    }

    @Override protected void onClick() { /* keep default: no-op to avoid toggling on row click */ }

    private int getSwitchWidthFromSwitchPreference() {
        // Temporary switch to measure its width
        SwitchCompat tempSwitch = new SwitchCompat(getContext());
        tempSwitch.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        return tempSwitch.getMeasuredWidth() + SettingsActivity.nestedPaddingStart;
    }

    private void scheduleRuntimeSizing() {
        if (mBoundItemView == null) return;
        
        // Always apply fallback sizing immediately so buttons are visible
        applySizing(resolveRowHeightFallback());
        expandMainSwitchHitArea();
        
        // Then improve sizing when actual dimensions are available
        mBoundItemView.post(() -> {
            int actualHeight = mBoundItemView.getHeight();
            if (actualHeight > 0) {
                applySizing(actualHeight);
                expandMainSwitchHitArea();
            } else {
                // If still no height, try again after next layout pass
                ViewTreeObserver vto = mBoundItemView.getViewTreeObserver();
                if (vto.isAlive()) {
                    vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (mBoundItemView != null && mBoundItemView.getHeight() > 0) {
                                applySizing(mBoundItemView.getHeight());
                                expandMainSwitchHitArea();
                                mBoundItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    });
                }
            }
        });
    }

    private int resolveRowHeightFallback() {
        TypedValue tv = new TypedValue();
        if (getContext().getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, tv, true)) {
            if (tv.type == TypedValue.TYPE_DIMENSION) {
                return (int) TypedValue.complexToDimensionPixelSize(tv.data, getContext().getResources().getDisplayMetrics());
            } else if (tv.resourceId != 0) {
                try { return getContext().getResources().getDimensionPixelSize(tv.resourceId); } catch (Exception ignored) {}
            }
        }
        float density = getContext().getResources().getDisplayMetrics().density;
        return Math.round(48 * density);
    }

    private void applySizing(int rowH) {
        // Left controls sizing & colors based on preference width/height
        int prefW = (mBoundItemView != null) ? mBoundItemView.getWidth() : 0;
        if (prefW <= 0) return;

        // Percent specs
        final float BTN_H_PCT_OF_ROW = 0.55f; // 55% of row height
        final float TXT_PCT_OF_BTN_H = 0.50f; // 50% of button height

        int btnH = Math.max(1, Math.round(rowH * BTN_H_PCT_OF_ROW));
        int gapW = SettingsActivity.nestedPaddingStart / 2;
        float txtPx= Math.max(1, btnH * TXT_PCT_OF_BTN_H);

        // Colors
        int accent = ContextCompat.getColor(getContext(), R.color.colorAccent);

        // Screen container
        if (mScreenButtonContainer != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mScreenButtonContainer.getLayoutParams();
            lp.height = btnH;
            lp.setMarginEnd(gapW);           // gap between buttons
            mScreenButtonContainer.setLayoutParams(lp);
            mScreenButtonContainer.setGravity(Gravity.CENTER_VERTICAL);
            GradientDrawable scrBg = new GradientDrawable();
            scrBg.setColor(accent);
            scrBg.setCornerRadius(dp(12));
            mScreenButtonContainer.setBackground(scrBg);
            mScreenButtonContainer.setOnClickListener(v -> focusScreenInputAndShowIme());
        }
        if (mScreenLabel != null) {
            mScreenLabel.setTextColor(Color.WHITE);
            mScreenLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, txtPx);
            mScreenLabel.setIncludeFontPadding(false);
        }
        if (mScreenInput != null) {
            mScreenInput.setTextColor(Color.WHITE);
            mScreenInput.setTextSize(TypedValue.COMPLEX_UNIT_PX, txtPx);
            mScreenInput.setIncludeFontPadding(false);
            mScreenInput.setGravity(Gravity.CENTER);
            // Reserve space for exactly two digits so width doesn't jump between 1Ã¢â€ "2
            mScreenInput.setEms(2);
            // Let the accent container show through cleanly
            mScreenInput.setBackground(null);
        }

        // Position button
        if (mPositionButton != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mPositionButton.getLayoutParams();
            lp.height = btnH;
            mPositionButton.setLayoutParams(lp);
            mPositionButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, txtPx);
            mPositionButton.setAllCaps(false);
            GradientDrawable posBg = new GradientDrawable();
            posBg.setColor(accent);
            posBg.setCornerRadius(dp(12));
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList rippleColor = ColorStateList.valueOf(0x33FFFFFF);
                GradientDrawable mask = new GradientDrawable();
                mask.setColor(Color.WHITE);
                mask.setCornerRadius(dp(12));
                RippleDrawable ripple = new RippleDrawable(rippleColor, posBg, mask);
                mPositionButton.setBackground(ripple);
            } else {
                StateListDrawable sld = new StateListDrawable();
                GradientDrawable pressed = new GradientDrawable();
                pressed.setColor(darkenColor(accent, 0.85f));
                pressed.setCornerRadius(dp(12));
                sld.addState(new int[]{android.R.attr.state_pressed}, pressed);
                sld.addState(new int[]{}, posBg);
                mPositionButton.setBackground(sld);
            }
            mPositionButton.setClickable(true);
            mPositionButton.setFocusable(true);
        }
    }

    private void resize(@Nullable View v, int w, int h) {
        if (v == null) return;
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        if (lp == null) return;
        lp.width = w; lp.height = h; v.setLayoutParams(lp);
    }

    private void expandMainSwitchHitArea() {
        if (mBoundItemView == null) return;

        mBoundItemView.post(() -> {
            try {
                final View parent = mBoundItemView;

                Rect parentRect = new Rect();
                parent.getGlobalVisibleRect(parentRect);

                int rowH = parent.getHeight();
                if (rowH <= 0) return;

                // Extra horizontal cushion: Ã‚Â± 1/2 SettingsActivity.nestedPaddingStart
                final int halfPad = Math.max(0, SettingsActivity.nestedPaddingStart / 2);
                // Keep original half-row extension for the main switch, plus the extra pad.
                final int halfRow = Math.max(1, rowH / 2);
                final int parentW = parent.getWidth();

                // Build a composite delegate
                if (mTouchDelegateGroup == null) {
                    mTouchDelegateGroup = new TouchDelegateGroup(parent);
                    parent.setTouchDelegate(mTouchDelegateGroup);
                } else {
                    mTouchDelegateGroup.clear();
                }

                // Helper to localize a child's rect to the parent
                java.util.function.Function<View, Rect> childRect = (View v) -> {
                    Rect r = new Rect();
                    if (v == null || !v.isShown()) return r;
                    v.getGlobalVisibleRect(r);
                    r.offset(-parentRect.left, -parentRect.top);
                    return r;
                };

                if (mMainSwitch != null && mMainSwitch.isShown()) {
                    Rect r = childRect.apply(mMainSwitch);
                    if (!r.isEmpty()) {
                        r.top = 0;
                        r.bottom = rowH;
                        // extend left/right by half-row + half nested padding
                        r.left = Math.max(0, r.left  - (halfRow + halfPad));
                        r.right = Math.min(parentW, r.right + (halfRow + halfPad));

                        mTouchDelegateGroup.addDelegate(new TouchDelegate(r, mMainSwitch));
                    }
                }

                Rect scr = null, pos = null;

                if (mScreenButtonContainer != null && mScreenButtonContainer.isShown()) {
                    scr = childRect.apply(mScreenButtonContainer);
                    if (!scr.isEmpty()) {
                        scr.top = 0;
                        scr.bottom = rowH;
                        scr.left = Math.max(0, scr.left  - halfPad);
                        scr.right = Math.min(parentW, scr.right + halfPad);
                    }
                }

                if (mPositionButton != null && mPositionButton.isShown()) {
                    pos = childRect.apply(mPositionButton);
                    if (!pos.isEmpty()) {
                        pos.top = 0;
                        pos.bottom = rowH;
                        pos.left = Math.max(0, pos.left  - halfPad);
                        pos.right = Math.min(parentW, pos.right + halfPad);
                    }
                }

                // Prevent overlap between Screen and Position hit areas (split at midpoint if needed)
                if (scr != null && pos != null && !scr.isEmpty() && !pos.isEmpty()) {
                    if (scr.right > pos.left) {
                        int mid = (scr.right + pos.left) / 2;
                        scr.right = mid;
                        pos.left = mid;
                    }
                }

                if (scr != null && !scr.isEmpty() && mScreenButtonContainer != null) {
                    mTouchDelegateGroup.addDelegate(new TouchDelegate(scr, mScreenButtonContainer));
                }
                if (pos != null && !pos.isEmpty() && mPositionButton != null) {
                    mTouchDelegateGroup.addDelegate(new TouchDelegate(pos, mPositionButton));
                }

            } catch (Throwable ignored) {
                // Better to fail silently than crash; default hit areas remain.
            }
        });
    }

    private void saveScreenNumberFromInput() {
        if (mScreenInput == null) return;
        String s = mScreenInput.getText() != null ? mScreenInput.getText().toString() : "";
        int value;
        if (TextUtils.isEmpty(s)) {
            value = 1; // default when empty/null
        } else {
            try {
                value = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                value = 1; // default on parse error
            }
        }
        value = Math.max(1, Math.min(99, value));
        mScreenInput.setText(String.valueOf(value));
        if (!TextUtils.isEmpty(mScreenValuePrefKey) && getPreferenceManager() != null) {
            SharedPreferences sp = getPreferenceManager().getSharedPreferences();
            if (sp != null) sp.edit().putInt(mScreenValuePrefKey, value).apply();
        }
    }

    private float dp(float v) {
        return v * getContext().getResources().getDisplayMetrics().density;
    }

    private void focusScreenInputAndShowIme() {
        if (mScreenInput == null) return;
        mScreenInput.setFocusableInTouchMode(true);
        mScreenInput.requestFocus();
        if (mScreenInput.getText() != null) {
            mScreenInput.setSelection(mScreenInput.getText().length());
        }
        InputMethodManager imm =
                (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) imm.showSoftInput(mScreenInput, InputMethodManager.SHOW_IMPLICIT);
        // Also show the transparent mask while the keyboard is up
        showImeMaskOverlay();
    }

    
    private void showImeMaskOverlay() {
        if (mBoundItemView == null) return;
        if (mImeMaskOverlay != null && mImeMaskOverlay.getParent() != null) return;
        final View overlay = new View(getContext());
        overlay.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        overlay.setClickable(true);
        overlay.setFocusable(true);
        overlay.setAlpha(0f); // fully transparent mask
        overlay.setOnTouchListener((v, ev) -> {
            // Consume all touches and close the keyboard, save, and remove mask
            if (ev.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                saveScreenNumberFromInput();
                hideKeyboard();
                if (mScreenInput != null) mScreenInput.clearFocus();
                removeImeMaskOverlay();
            }
            return true;
        });
        // Attach to the activity content so the status bar remains interactive
        View root = mBoundItemView.getRootView();
        View content = root.findViewById(android.R.id.content);
        if (content instanceof ViewGroup) {
            ((ViewGroup) content).addView(overlay);
            mImeMaskOverlay = overlay;
        }
    }

    private void removeImeMaskOverlay() {
        if (mImeMaskOverlay != null) {
            android.view.ViewParent p = mImeMaskOverlay.getParent();
            if (p instanceof ViewGroup) {
                ((ViewGroup) p).removeView(mImeMaskOverlay);
            }
            mImeMaskOverlay = null;
        }
    }

    private void hideKeyboard() {
        if (mScreenInput == null) return;
        InputMethodManager imm =
                (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) imm.hideSoftInputFromWindow(mScreenInput.getWindowToken(), 0);
    }


    private static int darkenColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a, Math.min(255, r), Math.min(255, g), Math.min(255, b));
    }

    private static class TouchDelegateGroup extends TouchDelegate {
        private final java.util.ArrayList<TouchDelegate> mDelegates = new java.util.ArrayList<>();
        private TouchDelegate mCurrent;

        TouchDelegateGroup(View parent) { super(new Rect(), parent); }

        void clear() { mDelegates.clear(); mCurrent = null; }
        void addDelegate(TouchDelegate td) { if (td != null) mDelegates.add(td); }

        @Override public boolean onTouchEvent(android.view.MotionEvent event) {
            TouchDelegate delegate = null;
            switch (event.getAction()) {
                case android.view.MotionEvent.ACTION_DOWN:
                    for (int i = 0, n = mDelegates.size(); i < n; i++) {
                        TouchDelegate d = mDelegates.get(i);
                        if (d.onTouchEvent(event)) {
                            mCurrent = d;
                            return true;
                        }
                    }
                    break;
                case android.view.MotionEvent.ACTION_MOVE:
                case android.view.MotionEvent.ACTION_UP:
                case android.view.MotionEvent.ACTION_CANCEL:
                    delegate = mCurrent;
                    break;
            }
            return delegate != null && delegate.onTouchEvent(event);
        }
    }
    
    private static class MinMaxFilter implements InputFilter {
        private final int min;
        private final int max;
        MinMaxFilter(int min, int max) { this.min = min; this.max = max; }
        @Override public CharSequence filter(CharSequence source, int start, int end,
                                            Spanned dest, int dstart, int dend) {
            try {
                // What the text would become
                String newVal = dest.subSequence(0, dstart).toString()
                        + source.subSequence(start, end).toString()
                        + dest.subSequence(dend, dest.length()).toString();
                if (newVal.isEmpty()) return null; // allow clearing while editing
                int input = Integer.parseInt(newVal);
                if (input >= min && input <= max) return null; // keep change
            } catch (NumberFormatException ignored) {}
            return ""; // block change
        }
    }
}