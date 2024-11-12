package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import com.syu.widget.util.TimeUtil;

public class Year extends TextView {
    public static Year mDate;
    private IntentFilter filter;
    private Context mContext;

    public static Year getYear() {
        return mDate;
    }

    public Year(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
    }

    public Year(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public Year(Context context) {
        super(context);
        init();
        this.mContext = context;
    }

    void init() {
        mDate = this;
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
        setText(TimeUtil.getDateOfToday(this.mContext, "yyyy"));
    }
}
