package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

public class CustomPipSwitchPreference extends SwitchPreferenceCompat {

    private SwitchCompat mMainSwitch;
    private SwitchCompat mModeSwitch;
    private View mModeContainer;
    private View mModeTrackBg;
    private LinearLayout mModeLabels;
    private TextView mLabelWindow;
    private TextView mLabelPip;
    private View mModeCover;
    private TouchDelegateGroup mTouchDelegateGroup;
    private LinearLayout mScreenButtonContainer;   
    private TextView mScreenLabel;
    private EditText mScreenInput;             
    private AppCompatButton mPositionButton;        
    private View mImeMaskOverlay;
    private View mBoundItemView;
    private WidgetPageManager mPageManager;

    private final int orientation;
    private int mTargetW;
    private int mTargetH;
    private int mCoverW;
    private int mPendingPositionBtnTextColor = Color.TRANSPARENT;

    public CustomPipSwitchPreference(Context context) { this(context, null); }
    public CustomPipSwitchPreference(Context context, AttributeSet attrs) { this(context, attrs, androidx.preference.R.attr.switchPreferenceCompatStyle); }
    public CustomPipSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        orientation = context.getResources().getConfiguration().orientation;
        setLayoutResource(R.layout.nested_preference_pip_switch);
        setWidgetLayoutResource(0);
    }

    // App picker
    @Nullable private OnPreferenceClickListener mClickListener;
    @Override 
    protected void onClick() { 
        if (mClickListener != null) {
            mClickListener.onPreferenceClick(this);
        }
        // Don't call super.onClick() to prevent switch toggle on row click
    }   
    @Override
    public void setOnPreferenceClickListener(@Nullable OnPreferenceClickListener listener) { mClickListener = listener; }

    // PiP / Window switch
    @Nullable private OnModeSwitchChangeListener mModeListener;
    public interface OnModeSwitchChangeListener { void onModeChanged(boolean isPip); }
    public void setOnModeSwitchChangeListener(@Nullable OnModeSwitchChangeListener l) { mModeListener = l; }
    public void setModeChecked(boolean isPip) { 
        if (mModeSwitch != null) mModeSwitch.setChecked(isPip);
        saveModeState(isPip);
    }
    public boolean isModeChecked() { return mModeSwitch != null && mModeSwitch.isChecked(); }
    
    // Page selector  
    @Nullable private OnPreferenceValuesChangedListener mValuesChangedListener;
    @Nullable private String mScreenValuePrefKey;
    public interface OnPreferenceValuesChangedListener { void onPreferenceValuesChanged(); }
    public void setScreenValuePrefKey(@Nullable String key) { mScreenValuePrefKey = key; }
    public void setOnPreferenceValuesChangedListener(@Nullable OnPreferenceValuesChangedListener listener) {
        mValuesChangedListener = listener;
    }

    // Adjust button
    public interface OnPositionClickListener { void onPositionClick(CustomPipSwitchPreference pref); }
    @Nullable private OnPositionClickListener mPositionListener;
    public void setOnPositionClickListener(@Nullable OnPositionClickListener l) { mPositionListener = l; }
    public void setPositionButtonTextColor(@ColorInt int color) {
        mPendingPositionBtnTextColor = color;
        if (mPositionButton != null) {
            mPositionButton.setTextColor(color);
        }
    } 
    
    // Main switch
    @Nullable private OnMainSwitchClickListener mMainSwitchClickListener;
    public interface OnMainSwitchClickListener { void onMainSwitchClick(boolean newValue); }
    public void setOnMainSwitchClickListener(@Nullable OnMainSwitchClickListener listener) { mMainSwitchClickListener = listener; } 
    @Override
    public void setChecked(boolean checked) {
        boolean wasChecked = isChecked();
        super.setChecked(checked);
        
        // Only fire listener if the value actually changed
        if (wasChecked != checked && mMainSwitchClickListener != null) {
            mMainSwitchClickListener.onMainSwitchClick(checked);
        }
    }

    @Override 
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);       
        mBoundItemView = holder.itemView;
        if (mBoundItemView instanceof LinearLayout) {
            mBoundItemView.setPaddingRelative(
                SettingsActivity.nestedPaddingStart,
                mBoundItemView.getPaddingTop(),
                SettingsActivity.nestedPaddingEnd,
                mBoundItemView.getPaddingBottom()
            );
        }  

        int paddingStart;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            paddingStart = SettingsActivity.nestedPaddingStart / 3;
        } else {
            paddingStart = SettingsActivity.nestedPaddingStart;
        }
        
        mMainSwitch = (SwitchCompat) holder.findViewById(androidx.preference.R.id.switchWidget);
        mModeSwitch = (SwitchCompat) holder.findViewById(R.id.pipModeSwitch);
        mModeContainer = holder.findViewById(R.id.pipModeContainer);
        mModeTrackBg = holder.findViewById(R.id.pipModeTrackBg);
        mModeLabels = (LinearLayout) holder.findViewById(R.id.pipModeLabels);
        mLabelWindow = (TextView) holder.findViewById(R.id.labelWindow);
        mLabelPip  = (TextView) holder.findViewById(R.id.labelPip);
        mModeCover = holder.findViewById(R.id.pipModeCover);

        mScreenButtonContainer = (LinearLayout) holder.findViewById(R.id.btnScreenContainer);
        mScreenLabel = (TextView) holder.findViewById(R.id.tvScreenLabel);
        mScreenInput = (EditText) holder.findViewById(R.id.etScreenNumber);
        mPositionButton = (AppCompatButton) holder.findViewById(R.id.btnPositionPip);

        if (mMainSwitch != null) {
            ViewGroup.LayoutParams rawLp = mMainSwitch.getLayoutParams();
            ViewGroup.MarginLayoutParams lp = (rawLp instanceof ViewGroup.MarginLayoutParams)
                    ? (ViewGroup.MarginLayoutParams) rawLp
                    : new LinearLayout.LayoutParams(rawLp.width, rawLp.height);
            lp.setMarginStart(paddingStart);
            mMainSwitch.setLayoutParams(lp);
        }

        if (mModeSwitch != null) {
            mModeSwitch.setShowText(false);
            // Restore saved mode state
            boolean savedModeState = getSavedModeState();
            mModeSwitch.setChecked(savedModeState);
            
            mModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (mModeListener != null) mModeListener.onModeChanged(isChecked);
                applyCoverPosition(true);
                saveModeState(isChecked);
            });
        }
        if (mModeContainer != null) {
            mModeContainer.setClickable(true);
            mModeContainer.setFocusable(true);
            mModeContainer.setOnClickListener(v -> { if (mModeSwitch != null) mModeSwitch.toggle(); });
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

        mBoundItemView.post(() -> scheduleRuntimeSizing());

        super.onBindViewHolder(holder);
    }

    private void saveModeState(boolean isPip) {
        SharedPreferences sp = getPreferenceManager() != null ? getPreferenceManager().getSharedPreferences() : null;
        if (sp != null && getKey() != null) {
            sp.edit().putBoolean(getKey() + "_mode", isPip).apply();
        }
    }

    private boolean getSavedModeState() {
        SharedPreferences sp = getPreferenceManager() != null ? getPreferenceManager().getSharedPreferences() : null;
        if (sp != null && getKey() != null) {
            return sp.getBoolean(getKey() + "_mode", false);
        }
        return false;
    }

    private void scheduleRuntimeSizing() {
        applySizing(resolveRowHeightFallback());
        if (mBoundItemView != null) {
            mBoundItemView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override public void onGlobalLayout() {
                    if (mBoundItemView.getHeight() > 0) {
                        applySizing(resolveRowHeightFallback());
                        mBoundItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
        // Also expand immediately using fallback bounds so it's usable right away
        expandMainSwitchHitArea();
    }

    private int resolveRowHeightFallback() {
        Context context = getContext();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        
        // Try to get text sizes from theme attributes
        TypedValue titleSize = new TypedValue();
        TypedValue summarySize = new TypedValue();
        
        context.getTheme().resolveAttribute(android.R.attr.textAppearanceListItem, titleSize, true);
        context.getTheme().resolveAttribute(android.R.attr.textAppearanceListItemSecondary, summarySize, true);
        
        // Default fallback values
        float titleHeight = 16 * metrics.scaledDensity * 1.3f;
        float summaryHeight = 14 * metrics.scaledDensity * 1.3f;
        
        float density = metrics.density;
        int verticalPadding = Math.round(32 * density);
        
        return (int) (titleHeight + summaryHeight) + verticalPadding;
    }

    private void applySizing(int rowH) {
        // PiP/Window switch sizing
        final float heightFactor = 0.25f;
        mTargetH = Math.max(1, Math.round(rowH * heightFactor));
        mTargetW = Math.max(1, Math.round(mTargetH * 8.0f));
        mCoverW = Math.max(1, mTargetW / 2);

        int vPad = Math.max(0, (rowH - mTargetH) / 2);
        if (mModeContainer != null) {
            mModeContainer.setPadding(mModeContainer.getPaddingLeft(), vPad,
                    mModeContainer.getPaddingRight(), vPad);
        }
        resize(mModeTrackBg, mTargetW, mTargetH);
        resize(mModeLabels,  mTargetW, mTargetH);
        resize(mModeSwitch,  mTargetW, mTargetH);
        resize(mModeCover,   mCoverW,  mTargetH);

        float textPx = mTargetH * 0.95f;
        if (mLabelWindow != null) mLabelWindow.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx);
        if (mLabelPip != null)    mLabelPip.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx);

        mModeLabels.setGravity(Gravity.CENTER);
        mLabelWindow.setGravity(Gravity.CENTER);
        mLabelPip.setGravity(Gravity.CENTER);
        mLabelWindow.setTextColor(Color.WHITE);
        mLabelPip.setTextColor(Color.WHITE);
        mLabelWindow.setIncludeFontPadding(false);
        mLabelPip.setIncludeFontPadding(false);

        applyCoverPosition(false);

        // Left controls sizing & colors based on preference width/height
        int prefW = (mBoundItemView != null) ? mBoundItemView.getWidth() : 0;
        if (prefW <= 0) return;

        // Percent specs
        final float BTN_H_PCT_OF_ROW = 0.55f; // 55% of row height
        final float TXT_PCT_OF_BTN_H = 0.50f; // 50% of button height

        int btnH = Math.max(1, Math.round(rowH * BTN_H_PCT_OF_ROW));
        int gapW;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            gapW = SettingsActivity.nestedPaddingStart / 4;
        } else {
            gapW = SettingsActivity.nestedPaddingStart / 2;
        }
        float txtPx= Math.max(1, btnH * TXT_PCT_OF_BTN_H);

        // Colors
        int accent = ContextCompat.getColor(getContext(), R.color.colorAccent);

        // Screen container
        if (mScreenButtonContainer != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mScreenButtonContainer.getLayoutParams();
            lp.height = btnH;
            lp.setMarginStart(gapW); 
            lp.setMarginEnd(gapW);          
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
            // Reserve space for exactly two digits so width doesn't jump between 1↔2
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
            ColorStateList rippleColor = ColorStateList.valueOf(0x33FFFFFF);
            GradientDrawable mask = new GradientDrawable();
            mask.setColor(Color.WHITE);
            mask.setCornerRadius(dp(12));
            RippleDrawable ripple = new RippleDrawable(rippleColor, posBg, mask);
            mPositionButton.setBackground(ripple);
            mPositionButton.setClickable(true);
            mPositionButton.setFocusable(true);
        }

        // Ensure the mode container itself does not add extra start margin; spacing is handled by the second button's marginEnd.
        if (mModeContainer != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) mModeContainer.getLayoutParams();
            lp.setMarginStart(0);
            mModeContainer.setLayoutParams(lp);
        }
    }

    private void applyCoverPosition(boolean animate) {
        if (mModeCover == null || mModeSwitch == null) return;
        float toX = mModeSwitch.isChecked() ? 0f : (mTargetW - mCoverW);
        if (animate) {
            mModeCover.animate().translationX(toX).setDuration(160).start();
        } else {
            mModeCover.setTranslationX(toX);
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

                // Extra horizontal cushion: ± 1/2 SettingsActivity.nestedPaddingStart
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

                        // Avoid overlapping the custom mode container to the left
                        if (mModeContainer != null && mModeContainer.isShown()) {
                            Rect modeRect = childRect.apply(mModeContainer);
                            if (!modeRect.isEmpty() && r.left < modeRect.right) {
                                r.left = modeRect.right;
                            }
                        }
                        mTouchDelegateGroup.addDelegate(new TouchDelegate(r, mMainSwitch));
                    }
                }

                Rect scr = null, pos = null, mode = null;
                if (mModeContainer != null && mModeContainer.isShown()) {
                    mode = childRect.apply(mModeContainer);
                }

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

                        // Do not spill into the mode container
                        if (mode != null && !mode.isEmpty()) {
                            pos.right = Math.min(pos.right, mode.left);
                        }
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
            value = 1;
        } else {
            try {
                value = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                value = 1;
            }
        }
        
        // Initialize manager if needed
        if (mPageManager == null && !TextUtils.isEmpty(mScreenValuePrefKey)) {
            mPageManager = new WidgetPageManager(LauncherApplication.sApp, mScreenValuePrefKey);
            
            // Set the callback when initializing
            mPageManager.setOnPreferencesUpdatedListener(() -> {
                if (mValuesChangedListener != null) {
                    mValuesChangedListener.onPreferenceValuesChanged();
                }
            });
        }
        
        if (mPageManager == null) return;
        
        // Validate and save the page number
        mPageManager.validateAndSavePage(value);
        int currentPageIndex = mPageManager.getCurrentWidgetPageIndex();
        if (currentPageIndex >= 0) {
            mScreenInput.setText(String.valueOf(currentPageIndex + 1));
        }
    }
    
    /**
     * Refresh the displayed screen number from SharedPreferences
     */
    public void refreshDisplayedValue() {
        if (mScreenInput == null || TextUtils.isEmpty(mScreenValuePrefKey)) return;
        
        SharedPreferences sp = getPreferenceManager() != null ? 
            getPreferenceManager().getSharedPreferences() : null;
        if (sp != null) {
            int current = Math.max(1, Math.min(99, sp.getInt(mScreenValuePrefKey, 1)));
            mScreenInput.setText(String.valueOf(current));
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