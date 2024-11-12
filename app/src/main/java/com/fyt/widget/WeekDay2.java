package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import com.syu.widget.util.TimeUtil;

public class WeekDay2 extends TextView {
    public static WeekDay2 mWeekDay;
    private IntentFilter filter;
    private Context mContext;
    private SpannableString msp;

    public WeekDay2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
    }

    public static WeekDay2 getWeekDay() {
        return mWeekDay;
    }

    public WeekDay2(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public WeekDay2(Context context) {
        super(context);
        init();
        this.mContext = context;
    }

    void init() {
        mWeekDay = this;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setDate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setDate() {
        setText(TimeUtil.getWeekDay(this.mContext));
    }
}
