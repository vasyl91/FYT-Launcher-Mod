package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.syu.widget.util.TimeUtil;

public class Year extends AppCompatTextView {
    public static Year mDate;
    private IntentFilter filter;
    private final Context mContext;

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
        setText(TimeUtil.getDateOfToday(this.mContext, "yyyy"));
    }
}
