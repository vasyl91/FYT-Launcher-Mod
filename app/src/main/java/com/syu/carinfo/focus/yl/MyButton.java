package com.syu.carinfo.focus.yl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private void init(Context context) {
        this.mFreqTitle = new TextView(context);
        this.mFreq = new TextView(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(param);
        setOrientation(0);
        addView(this.mFreq);
        addView(this.mFreqTitle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setEllipsize_FreqName(TextUtils.TruncateAt where) {
        this.mFreqTitle.setEllipsize(where);
    }

    public void setmaxEms_FreqName(int i) {
        this.mFreqTitle.setMaxEms(i);
    }

    public void setSingleLine_FreqName(boolean bool) {
        this.mFreqTitle.setSingleLine(bool);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
