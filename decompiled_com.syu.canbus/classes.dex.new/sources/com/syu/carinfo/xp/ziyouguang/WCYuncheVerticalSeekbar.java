package com.syu.carinfo.xp.ziyouguang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCYuncheVerticalSeekbar extends SeekBar {
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
    private Drawable mThumb;

    public WCYuncheVerticalSeekbar(Context context) {
        super(context);
    }

    public WCYuncheVerticalSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WCYuncheVerticalSeekbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener l) {
        this.mOnSeekBarChangeListener = l;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas c) {
        c.rotate(-90.0f);
        c.translate(-getHeight(), 0.0f);
        super.onDraw(c);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        int value = getProgress();
        if (value < 1) {
            value = 1;
        }
        onProgressRefresh(value / getMax(), true);
    }

    public void onProgressRefresh(float scale, boolean fromUser) {
        Drawable thumb = this.mThumb;
        if (thumb != null) {
            setThumbPos(getHeight(), thumb, scale, Integer.MIN_VALUE);
            invalidate();
        }
        if (this.mOnSeekBarChangeListener != null) {
            int value = getProgress();
            if (value < 1) {
                value = 1;
            }
            this.mOnSeekBarChangeListener.onProgressChanged(this, value, fromUser);
        }
    }

    private void setThumbPos(int w, Drawable thumb, float scale, int gap) {
        int topBound;
        int bottomBound;
        int available = (w - getPaddingLeft()) - getPaddingRight();
        int thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight = thumb.getIntrinsicHeight();
        int thumbPos = (int) ((available * scale) + 0.5f);
        if (gap == Integer.MIN_VALUE) {
            Rect oldBounds = thumb.getBounds();
            topBound = oldBounds.top;
            bottomBound = oldBounds.bottom;
        } else {
            topBound = gap;
            bottomBound = gap + thumbHeight;
        }
        thumb.setBounds(thumbPos, topBound, thumbPos + thumbWidth, bottomBound);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable thumb) {
        this.mThumb = thumb;
        super.setThumb(thumb);
    }

    void onStartTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    void onStopTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                onStartTrackingTouch();
                if (this.mThumb != null) {
                    if (!getThumb().getBounds().contains(getHeight() - ((int) event.getY()), (int) event.getX())) {
                        setProgress(getMax() - ((int) ((getMax() * event.getY()) / getHeight())));
                    }
                } else {
                    int value = getMax() - ((int) ((getMax() * event.getY()) / getHeight()));
                    if (value < 1) {
                        value = 1;
                    }
                    setProgress(value);
                }
                break;
            case 1:
            case 3:
                onStopTrackingTouch();
                setPressed(false);
                break;
            case 2:
                attemptClaimDrag();
                if (this.mThumb != null) {
                    if (!getThumb().getBounds().contains(getHeight() - ((int) event.getY()), (int) event.getX())) {
                        setProgress(getMax() - ((int) ((getMax() * event.getY()) / getHeight())));
                    }
                } else {
                    int value2 = getMax() - ((int) ((getMax() * event.getY()) / getHeight()));
                    if (value2 < 1) {
                        value2 = 1;
                    }
                    setProgress(value2);
                }
                break;
        }
        return true;
    }
}
