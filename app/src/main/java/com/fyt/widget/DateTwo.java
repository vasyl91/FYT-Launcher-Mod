package com.fyt.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewTreeObserver;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.settings.Keys;
import com.syu.widget.util.TimeUtil;

public class DateTwo extends AppCompatTextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static DateTwo mDateTwo;
    private final Context mContext;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean isTextSizeAdjusted = false;
    private SharedPreferences mPrefs;
    private int mDefaultTextColor;

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
        setDateTwo();
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
        if (mDateTwo == this) {
            mDateTwo = null;
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

    public void setDateTwo() {
        String mText = TimeUtil.getDateOfToday(this.mContext, getDateStringFormat(5));
        float targetSize = Launcher.textSizeBasic;
        
        setText(mText);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        boolean blackTintWidgets = prefs.getBoolean(Keys.BLACK_BAR, false);
        if (blackTintWidgets) {
            setTextColor(Color.BLACK);
        }
        
        // Only adjust size once, or when text actually changes
        if (!isTextSizeAdjusted) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, targetSize);
            
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
                    
                    adjustTextSize(mText, targetSize);
                    isTextSizeAdjusted = true;
                    return true;
                }
            };
            
            getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
        }
    }

    private void adjustTextSize(String text, float targetSize) {
        int maxWidth = 0;
        if (getParent() instanceof android.view.View) {
            android.view.View parent = (android.view.View) getParent();
            maxWidth = parent.getWidth() - (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        }
        
        if (maxWidth <= 0) {
            maxWidth = getWidth();
        }
        
        if (maxWidth > 0) {
            setMaxWidth(maxWidth);
            
            int availableWidth = maxWidth - getPaddingLeft() - getPaddingRight();
            
            if (availableWidth > 0) {
                android.text.TextPaint paint = new android.text.TextPaint();
                paint.setTextSize(TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP, targetSize, getResources().getDisplayMetrics()));
                
                float textWidth = paint.measureText(text);
                
                if (textWidth >= availableWidth) {
                    float scaledSize = targetSize * (availableWidth / textWidth) * 0.95f;
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, scaledSize);
                }
            }
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