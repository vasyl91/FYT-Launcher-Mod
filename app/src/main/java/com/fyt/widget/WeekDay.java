package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;

import com.syu.widget.util.TimeUtil;

import share.ResValue;

public class WeekDay extends TextView {
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

    public void setDate() {
        TextView mTextView = findViewById(ResValue.getInstance().curWeek);
        if (mTextView != null) {
            mTextView.setText(TimeUtil.getWeekDay(this.mContext));
        }
    }
}
