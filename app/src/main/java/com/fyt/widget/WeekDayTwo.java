package com.fyt.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.settings.Keys;
import com.syu.widget.util.TimeUtil;

public class WeekDayTwo extends AppCompatTextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static WeekDayTwo mWeekDayTwo;
    private final Context mContext;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean isTextSizeAdjusted = false;
    private SharedPreferences mPrefs;
    private int mDefaultTextColor;

    public WeekDayTwo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    public static WeekDayTwo getWeekDayTwo() {
        return mWeekDayTwo;
    }

    public WeekDayTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public WeekDayTwo(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    void init() {
        mWeekDayTwo = this;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        // Store the default text color for later use
        mDefaultTextColor = getCurrentTextColor();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Register preference change listener
        mPrefs.registerOnSharedPreferenceChangeListener(this);
        setDate();
        updateTextColor();
    }

    @Override
    protected void onDetachedFromWindow() {
        // Remove any pending listeners to prevent memory leaks
        if (mPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
            mPreDrawListener = null;
        }
        
        // Unregister preference change listener
        mPrefs.unregisterOnSharedPreferenceChangeListener(this);
        
        // Clear static reference to prevent context leaks
        if (mWeekDayTwo == this) {
            mWeekDayTwo = null;
        }
        
        super.onDetachedFromWindow();
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

    public void setDate() {
        String weekDay = TimeUtil.getWeekDay(this.mContext);
        String mText = weekDay.length() <= 3 ? weekDay : weekDay.substring(0, 3);
        
        setText(mText);
        
        // Only adjust size once, or when text actually changes
        if (!isTextSizeAdjusted) {            
            // Use a member variable to track the listener
            mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    if (mPreDrawListener != null) {
                        getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
                        mPreDrawListener = null;
                    }
                    
                    if (!isAttachedToWindow()) {
                        return true;
                    }
                    
                    adjustTextSize(mText, 0.55f);
                    isTextSizeAdjusted = true;
                    return true;
                }
            };
            
            getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
        }
    }

    private void adjustTextSize(String text, float targetSize) {
        postDelayed(() -> {
            View parent = getParent() instanceof View ? (View) getParent() : null;
            
            if (parent == null) return;
            
            int parentHeight = parent.getHeight();
            if (parentHeight <= 0) return;
            
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
            if (textViewCount == 0) return;
            
            // Calculate target height for this TextView
            int targetHeight = (int)((parentHeight / textViewCount) * targetSize);
            
            // Set max height to prevent overflow
            setMaxHeight(targetHeight);
            
            // Binary search for best size
            float minSize = 1f;
            float maxSize = 500f;
            float bestSize = minSize;
            
            TextPaint paint = new TextPaint(getPaint());
            int width = getWidth() - getPaddingLeft() - getPaddingRight();
            if (width <= 0) width = 100;
            
            while (maxSize - minSize > 0.5f) {
                float testSize = (minSize + maxSize) / 2f;
                paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, testSize, getResources().getDisplayMetrics()));
                
                StaticLayout layout = new StaticLayout(text, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                
                if (layout.getHeight() <= targetHeight) {
                    bestSize = testSize;
                    minSize = testSize;
                } else {
                    maxSize = testSize;
                }
            }
            
            setTextSize(TypedValue.COMPLEX_UNIT_SP, bestSize);
        }, 50);
    }
}