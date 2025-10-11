package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

import com.android.launcher66.Launcher;
import com.syu.widget.util.TimeUtil;

public class WeekDay extends AppCompatTextView {
    public static WeekDay mWeekDay;
    private IntentFilter filter;
    private final Context mContext;
    private SpannableString msp;

    public WeekDay(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
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
        init();
        this.mContext = context;
    }

    void init() {
        mWeekDay = this;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setDate();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private boolean isTextSizeAdjusted = false;

    public void setDate() {
        String mText = TimeUtil.getWeekDay(this.mContext);
        float targetSize = Launcher.textSizeBasic;
        
        setText(mText);
        
        // Only adjust size once, or when text actually changes
        if (!isTextSizeAdjusted) {
            setTextSize(TypedValue.COMPLEX_UNIT_SP, targetSize);
            
            getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    getViewTreeObserver().removeOnPreDrawListener(this);
                    
                    if (!isAttachedToWindow()) {
                        return true;
                    }
                    
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
                            
                            float textWidth = paint.measureText(mText);
                            
                            if (textWidth > availableWidth) {
                                float scaledSize = targetSize * (availableWidth / textWidth) * 0.95f;
                                setTextSize(TypedValue.COMPLEX_UNIT_SP, scaledSize);
                            }
                        }
                    }
                    
                    isTextSizeAdjusted = true;
                    return true;
                }
            });
        }
    }
}
