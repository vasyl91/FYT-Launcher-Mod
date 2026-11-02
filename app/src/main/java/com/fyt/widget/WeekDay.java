package com.fyt.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.settings.Keys;
import com.syu.widget.util.TimeUtil;

public class WeekDay extends AppCompatTextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static WeekDay mWeekDay;
    private final Context mContext;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private String mFittedText;
    private int mAutoSizeMaxSp = -1;
    private SharedPreferences mPrefs;
    private int mDefaultTextColor;
    private static final int AUTO_SIZE_MIN_SP = 8;

    public WeekDay(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    public static WeekDay getWeekDay() {
        return mWeekDay;
    }

    public WeekDay(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public WeekDay(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    void init() {
        mWeekDay = this;
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
        if (mWeekDay == this) {
            mWeekDay = null;
        }
        
        super.onDetachedFromWindow();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (Keys.BLACK_WIDGETS.equals(key)) {
            updateTextColor();
        }
    }

    private void updateTextColor() {
        boolean blackTintWidgets = mPrefs.getBoolean(Keys.BLACK_WIDGETS, false);
        if (blackTintWidgets) {
            setTextColor(Color.BLACK);
        } else {
            // Reset to default color (could be from XML or theme)
            setTextColor(mDefaultTextColor);
        }
    }

    public void setDate() {
        String mText = TimeUtil.getWeekDay(this.mContext);
        setText(mText);

        if (TextViewCompat.getAutoSizeTextType(this) != TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE) {
            // The layout turned autosize on: it fits the text to the width and height of the view
            // whenever either changes. setTextSize() would switch it off, so only the limits are set.
            configureAutoSize();
            return;
        }

        // No autosize in this layout: fit the text to its line, always starting from the maximum so
        // a shorter text (the week day changes at midnight) is not stuck at the size of a longer one.
        if (mText.equals(mFittedText)) return;
        mFittedText = mText;
        final float targetSize = Launcher.widgetTextSizeBasic;
        setTextSize(TypedValue.COMPLEX_UNIT_SP, targetSize);

        if (mPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
        }
        mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);
                if (mPreDrawListener == this) {
                    mPreDrawListener = null;
                }
                if (isAttachedToWindow()) {
                    adjustTextSize(mText, targetSize);
                }
                return true;
            }
        };
        getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
    }

    /** Uniform autosize between 8 sp (as the radio widget) and the widget text size. */
    private void configureAutoSize() {
        int maxSp = Math.max(Launcher.widgetTextSizeBasic, 1);
        if (maxSp == mAutoSizeMaxSp) return;
        mAutoSizeMaxSp = maxSp;
        int minSp = Math.min(AUTO_SIZE_MIN_SP, maxSp);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                this, minSp, maxSp, 1, TypedValue.COMPLEX_UNIT_SP);
    }

    private void adjustTextSize(String text, float targetSize) {
        // These layouts size the view to its text, so the line is the parent minus some air.
        int maxWidth = 0;
        if (getParent() instanceof View) {
            maxWidth = ((View) getParent()).getWidth() - (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        }
        if (maxWidth <= 0) {
            maxWidth = getWidth();
        }
        int availableWidth = maxWidth - getPaddingLeft() - getPaddingRight();
        if (availableWidth <= 0) {
            // Not laid out yet: let the next setDate() try again.
            mFittedText = null;
            return;
        }
        setMaxWidth(maxWidth);

        // Measured with a copy of the view's paint, so the typeface and letter spacing are the real ones.
        TextPaint paint = new TextPaint(getPaint());
        paint.setTextSize(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, targetSize, getResources().getDisplayMetrics()));
        float fitted = TextFit.fit(targetSize, paint.measureText(text), availableWidth);
        if (fitted != targetSize) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, fitted);
        }
    }

}