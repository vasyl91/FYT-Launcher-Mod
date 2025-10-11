package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.android.launcher66.R;
import com.syu.widget.util.TimeUtil;

public class Month extends AppCompatTextView {
    public static Month mDate;
    private IntentFilter filter;
    private final Context mContext;

    public static Month getMonth() {
        return mDate;
    }

    public Month(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
    }

    public Month(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public Month(Context context) {
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
        int month = Integer.valueOf(TimeUtil.getDateOfToday(this.mContext, "MM")).intValue();
        String[] months = getResources().getStringArray(R.array.months);
        setText(months[month - 1]);
    }
}
