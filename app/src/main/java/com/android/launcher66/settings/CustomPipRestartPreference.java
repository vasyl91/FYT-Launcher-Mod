package com.android.launcher66.settings;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomPipRestartPreference extends Preference {

    private final Context mContext;
    private SharedPreferences sharedPrefs;
    private View mBoundItemView;
    private List<AppCompatButton> mRestartButtons;
    private AppCompatButton mRestartFirstButton;
    private AppCompatButton mRestartSecondButton;
    private AppCompatButton mRestartThirdButton;
    private AppCompatButton mRestartFourthButton;
    private int accent;

    public CustomPipRestartPreference(Context context) { this(context, null); }
    public CustomPipRestartPreference(Context context, AttributeSet attrs) { this(context, attrs, androidx.preference.R.attr.switchPreferenceCompatStyle); }
    public CustomPipRestartPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setLayoutResource(R.layout.nested_preference_pip_restart);
        setWidgetLayoutResource(0);
    }

    @Override public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        holder.itemView.setFocusable(false);
        holder.itemView.setClickable(false);
        holder.itemView.setBackground(null);
        holder.itemView.setOnClickListener(null);

        int orientation = LauncherApplication.sApp.getResources().getConfiguration().orientation;
        int switchWidth = getSwitchWidthFromSwitchPreference();
        int paddingEnd;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            paddingEnd = switchWidth / 2;
        } else {
            paddingEnd = switchWidth;
        }

        mBoundItemView = holder.itemView;
        if (mBoundItemView instanceof LinearLayout) {
            // Apply relative padding (start, top, end, bottom)
            mBoundItemView.setPaddingRelative(
                SettingsActivity.nestedPaddingStart,
                mBoundItemView.getPaddingTop(),
                paddingEnd, // Right padding to simulate switch space
                mBoundItemView.getPaddingBottom()
            );
        }

        mRestartFirstButton = (AppCompatButton) holder.findViewById(R.id.btnRestartFirst);
        mRestartSecondButton = (AppCompatButton) holder.findViewById(R.id.btnRestartSecond);
        mRestartThirdButton = (AppCompatButton) holder.findViewById(R.id.btnRestartThird);
        mRestartFourthButton = (AppCompatButton) holder.findViewById(R.id.btnRestartFourth);

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        
        if (mRestartFirstButton != null) {
            mRestartFirstButton.setTextColor(Color.WHITE);
            mRestartFirstButton.setAllCaps(false);
        }
        if (mRestartSecondButton != null) {
            mRestartSecondButton.setTextColor(Color.WHITE);
            mRestartSecondButton.setAllCaps(false);
        }
        if (mRestartThirdButton != null) {
            mRestartThirdButton.setTextColor(Color.WHITE); 
            mRestartThirdButton.setAllCaps(false); 
        }
        if (mRestartFourthButton != null) {
            mRestartFourthButton.setTextColor(Color.WHITE); 
            mRestartFourthButton.setAllCaps(false);
        }

        mRestartButtons = new ArrayList<>();
        mRestartButtons.add(mRestartFirstButton);
        mRestartButtons.add(mRestartSecondButton);
        mRestartButtons.add(mRestartThirdButton);
        mRestartButtons.add(mRestartFourthButton);

        mBoundItemView.post(() -> scheduleRuntimeSizing());
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
        // Left controls sizing & colors based on preference width/height
        int prefW = (mBoundItemView != null) ? mBoundItemView.getWidth() : 0;
        if (prefW <= 0) return;

        // Percent specs
        final float BTN_H_PCT_OF_ROW = 0.55f; // 55% of row height
        final float TXT_PCT_OF_BTN_H = 0.50f; // 50% of button height

        int btnH = Math.max(1, Math.round(rowH * BTN_H_PCT_OF_ROW));

        float txtPx= Math.max(1, btnH * TXT_PCT_OF_BTN_H);

        // Colors
        accent = ContextCompat.getColor(getContext(), R.color.colorAccent);

        for (AppCompatButton button : mRestartButtons) {
            if (button != null) {
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
                lp.height = btnH;
                button.setLayoutParams(lp);
                button.setTextSize(TypedValue.COMPLEX_UNIT_PX, txtPx);
                button.setAllCaps(false);
                GradientDrawable posBg = new GradientDrawable();
                if (button == mRestartFirstButton) {
                    boolean firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
                    boolean dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
                    String firstPackage = sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
                    if ((firstPip || dualPip) && !firstPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_FIRST_PACKAGE));
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }   
                } else if (button == mRestartSecondButton) {
                    boolean secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
                    boolean dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
                    String secondPackage = sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
                    if ((secondPip || dualPip) && !secondPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_SECOND_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                } else if (button == mRestartThirdButton) {
                    boolean thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
                    String thirdPackage = sharedPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
                    if (thirdPip && !thirdPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_THIRD_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                } else if (button == mRestartFourthButton) {
                    boolean fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
                    String fourthPackage = sharedPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
                    if (fourthPip && !fourthPackage.isEmpty()) { 
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_FOURTH_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                }
                posBg.setCornerRadius(dp(12));
                ColorStateList rippleColor = ColorStateList.valueOf(0x33FFFFFF);
                GradientDrawable mask = new GradientDrawable();
                mask.setColor(Color.WHITE);
                mask.setCornerRadius(dp(12));
                RippleDrawable ripple = new RippleDrawable(rippleColor, posBg, mask);
                button.setBackground(ripple);
            }
        }
    }

    private float dp(float v) {
        return v * getContext().getResources().getDisplayMetrics().density;
    }

    public void restartPipApp(String key) {
        if (sharedPrefs == null) {
            sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        }
        String appPackageName = sharedPrefs.getString(key, "");
        if (!appPackageName.isEmpty() && appPackageName != null) {
            ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, appPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshButtons() {
        for (AppCompatButton button : mRestartButtons) {
            if (button != null) {
                GradientDrawable posBg = new GradientDrawable();
                if (button == mRestartFirstButton) {
                    boolean firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
                    boolean dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
                    String firstPackage = sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
                    if ((firstPip || dualPip) && !firstPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_FIRST_PACKAGE));
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }   
                } else if (button == mRestartSecondButton) {
                    boolean secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
                    boolean dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
                    String secondPackage = sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
                    if ((secondPip || dualPip) && !secondPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_SECOND_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                } else if (button == mRestartThirdButton) {
                    boolean thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
                    String thirdPackage = sharedPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
                    if (thirdPip && !thirdPackage.isEmpty()) {
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_THIRD_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                } else if (button == mRestartFourthButton) {
                    boolean fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
                    String fourthPackage = sharedPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
                    if (fourthPip && !fourthPackage.isEmpty()) {   
                        button.setOnClickListener(v -> restartPipApp(Keys.PIP_FOURTH_PACKAGE));  
                        posBg.setColor(accent);
                        button.setClickable(true);
                        button.setFocusable(true);
                    } else {
                        posBg.setColor(Color.GRAY);
                        button.setClickable(false);
                        button.setFocusable(false);
                    }
                }
                posBg.setCornerRadius(dp(12));
                ColorStateList rippleColor = ColorStateList.valueOf(0x33FFFFFF);
                GradientDrawable mask = new GradientDrawable();
                mask.setColor(Color.WHITE);
                mask.setCornerRadius(dp(12));
                RippleDrawable ripple = new RippleDrawable(rippleColor, posBg, mask);
                button.setBackground(ripple);
            }
        }
    }
}