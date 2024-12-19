package com.syu.carinfo.sbd.x80;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MyButton extends LinearLayout {
    private TextView mFreq;
    private TextView mFreqTitle;

    public MyButton(Context context) {
        super(context);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.mFreqTitle = new TextView(context);
        this.mFreq = new TextView(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(param);
        setOrientation(1);
        this.mFreqTitle.setLayoutParams(new LinearLayout.LayoutParams(130, 40));
        this.mFreq.setLayoutParams(new LinearLayout.LayoutParams(130, 63));
        addView(this.mFreqTitle);
        addView(this.mFreq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setText_FreqName(String str) {
        this.mFreqTitle.setText(str);
    }

    public void setTextColor_FreqName(int color) {
        this.mFreqTitle.setTextColor(color);
    }

    public void setTextColor_FreqName(ColorStateList colors) {
        this.mFreqTitle.setTextColor(colors);
    }

    public void setTextSize_FreqName(int size) {
        this.mFreqTitle.setTextSize(size);
    }

    public void setTypeface_FreqName(Typeface tf) {
        this.mFreqTitle.setTypeface(tf);
    }

    public void setGravity_FreqName(int gravity) {
        this.mFreqTitle.setGravity(gravity);
    }

    public void setPadding_FreqName(int left, int top, int right, int bottom) {
        this.mFreqTitle.setPadding(left, top, right, bottom);
    }

    public void setLayoutParams_FreqName(int width, int height) {
        this.mFreqTitle.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public String getText_FreqName() {
        return (String) this.mFreqTitle.getText();
    }

    public void setText_Freq(String str) {
        this.mFreq.setText(str);
    }

    public void setTextColor_Freq(int color) {
        this.mFreq.setTextColor(color);
    }

    public void setTextColor_Freq(ColorStateList colors) {
        this.mFreq.setTextColor(colors);
    }

    public void setTextSize_Freq(int size) {
        this.mFreq.setTextSize(size);
    }

    public void setTypeface_Freq(Typeface tf) {
        this.mFreq.setTypeface(tf);
    }

    public void setGravity_Freq(int gravity) {
        this.mFreq.setGravity(gravity);
    }

    public void setPadding_Freq(int left, int top, int right, int bottom) {
        this.mFreq.setPadding(left, top, right, bottom);
    }

    public void setLayoutParams_Freq(int width, int height) {
        this.mFreq.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public String getText_Freq() {
        return (String) this.mFreq.getText();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
