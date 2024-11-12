package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.launcher66.R;
import com.syu.widget.util.TimeUtil;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class Month extends TextView {
    public static Month mDate;
    private IntentFilter filter;
    private Context mContext;

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
        int month = Integer.valueOf(TimeUtil.getDateOfToday(this.mContext, "MM")).intValue();
        String[] months = getResources().getStringArray(R.array.months);
        setText(months[month - 1]);
    }
}
