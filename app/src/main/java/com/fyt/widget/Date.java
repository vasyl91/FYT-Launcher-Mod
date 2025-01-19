package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.widget.util.TimeUtil;

public class Date extends TextView {
    public static Date mDate;
    private IntentFilter filter;
    private final Context mContext;

    public static Date getDate() {
        return mDate;
    }

    public Date(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
    }

    public Date(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public Date(Context context) {
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
        setText(TimeUtil.getDateOfToday(this.mContext, getDateStringFormat(LauncherApplication.sApp.getResources().getInteger(R.integer.apps_timewidget_show))));
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
