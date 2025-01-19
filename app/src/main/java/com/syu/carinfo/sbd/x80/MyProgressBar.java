package com.syu.carinfo.sbd.x80;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class MyProgressBar extends ProgressBar {
    Paint mPaint;
    String text;

    public MyProgressBar(Context context) {
        super(context);
        initText();
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initText();
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initText();
    }

    @Override
    public synchronized void setProgress(int progress) {
        setText(progress);
        super.setProgress(progress);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.text, 0, this.text.length(), rect);
        int x = (getWidth() / 2) - rect.centerX();
        int y = (getHeight() / 2) - rect.centerY();
        canvas.drawText(this.text, x, y, this.mPaint);
    }

    private void initText() {
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
    }

    private void setText() {
        setText(getProgress());
    }

    private void setText(int progress) {
        int i = (progress * 100) / getMax();
        this.text = String.valueOf(String.valueOf(i)) + "%";
    }
}
