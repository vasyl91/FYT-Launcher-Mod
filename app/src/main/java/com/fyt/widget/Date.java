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
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.settings.Keys;
import com.syu.widget.util.TimeUtil;

public class Date extends AppCompatTextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static Date mDate;
    private final Context mContext;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    /** android:tag of a view that sits alone in its box, see absolute_time.xml. */
    private static final String BOX_FIT_TAG = "boxFit";
    private String mFittedText;
    // The date widget layout (absolute_time.xml) marks its views to be fitted to their box.
    private BoxTextFit mBoxFit;
    private SharedPreferences mPrefs;
    private int mDefaultTextColor;

    public static Date getDate() {
        return mDate;
    }

    public Date(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    public Date(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public Date(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    void init() {
        mDate = this;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        // Store the default text color for later use
        mDefaultTextColor = getCurrentTextColor();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Register preference change listener
        mPrefs.registerOnSharedPreferenceChangeListener(this);
        if (BOX_FIT_TAG.equals(getTag())) {
            mBoxFit = new BoxTextFit(this);
            mBoxFit.attach();
        }
        setDate();
        updateTextColor();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mBoxFit != null) {
            mBoxFit.detach();
            mBoxFit = null;
        }
        // Remove any pending listeners to prevent memory leaks
        if (mPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
            mPreDrawListener = null;
        }
        
        // Unregister preference change listener
        mPrefs.unregisterOnSharedPreferenceChangeListener(this);
        
        // Clear static reference to prevent context leaks
        if (mDate == this) {
            mDate = null;
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
        String mText = TimeUtil.getDateOfToday(this.mContext, getDateStringFormat(LauncherApplication.sApp.getResources().getInteger(R.integer.apps_timewidget_show)));
        setText(mText);

        if (mBoxFit != null) {
            // The view has a box of its own in this layout: fit the text to it. Done again by the
            // box fit whenever the box changes size.
            mBoxFit.fit();
            return;
        }

        // No box in this layout: fit the text to its line, always starting from the maximum so
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
            default:
                return "yyyy/MM/dd";
        }
    }
}