package com.syu.carinfo.toyota.tangdu;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class VerticalProgressbar extends ProgressBar {
    private int viewHeight;
    private int viewWidth;

    public VerticalProgressbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public VerticalProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VerticalProgressbar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.viewHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.viewWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(this.viewWidth, this.viewHeight);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldw, oldh);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas c) {
        c.rotate(-90.0f);
        c.translate(-this.viewHeight, 0.0f);
        super.onDraw(c);
    }
}
