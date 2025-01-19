package com.syu.carinfo.xp.ziyouguang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

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

    @Override
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener l) {
        this.mOnSeekBarChangeListener = l;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas c) {
        c.rotate(-90.0f);
        c.translate(-getHeight(), 0.0f);
        super.onDraw(c);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        onProgressRefresh(getProgress() / getMax(), true);
    }

    public void onProgressRefresh(float scale, boolean fromUser) {
        Drawable thumb = this.mThumb;
        if (thumb != null) {
            setThumbPos(getHeight(), thumb, scale, Integer.MIN_VALUE);
            invalidate();
        }
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), fromUser);
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

    @Override
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        return true;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            r0 = 0
            boolean r1 = r3.isEnabled()
            if (r1 != 0) goto L8
        L7:
            return r0
        L8:
            int r1 = r4.getAction()
            switch(r1) {
                case 0: goto L11;
                case 1: goto Lc3;
                case 2: goto L69;
                case 3: goto Lc3;
                default: goto Lf;
            }
        Lf:
            r0 = 1
            goto L7
        L11:
            r3.onStartTrackingTouch()
            android.graphics.drawable.Drawable r0 = r3.mThumb
            if (r0 == 0) goto L4f
            android.graphics.drawable.Drawable r0 = r3.getThumb()
            android.graphics.Rect r0 = r0.getBounds()
            int r1 = r3.getHeight()
            float r2 = r4.getY()
            int r2 = (int) r2
            int r1 = r1 - r2
            float r2 = r4.getX()
            int r2 = (int) r2
            boolean r0 = r0.contains(r1, r2)
            if (r0 != 0) goto Lf
            int r0 = r3.getMax()
            int r1 = r3.getMax()
            float r1 = (float) r1
            float r2 = r4.getY()
            float r1 = r1 * r2
            int r2 = r3.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r1 = (int) r1
            int r0 = r0 - r1
            r3.setProgress(r0)
            goto Lf
        L4f:
            int r0 = r3.getMax()
            int r1 = r3.getMax()
            float r1 = (float) r1
            float r2 = r4.getY()
            float r1 = r1 * r2
            int r2 = r3.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r1 = (int) r1
            int r0 = r0 - r1
            r3.setProgress(r0)
            goto Lf
        L69:
            r3.attemptClaimDrag()
            android.graphics.drawable.Drawable r0 = r3.mThumb
            if (r0 == 0) goto La8
            android.graphics.drawable.Drawable r0 = r3.getThumb()
            android.graphics.Rect r0 = r0.getBounds()
            int r1 = r3.getHeight()
            float r2 = r4.getY()
            int r2 = (int) r2
            int r1 = r1 - r2
            float r2 = r4.getX()
            int r2 = (int) r2
            boolean r0 = r0.contains(r1, r2)
            if (r0 != 0) goto Lf
            int r0 = r3.getMax()
            int r1 = r3.getMax()
            float r1 = (float) r1
            float r2 = r4.getY()
            float r1 = r1 * r2
            int r2 = r3.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r1 = (int) r1
            int r0 = r0 - r1
            r3.setProgress(r0)
            goto Lf
        La8:
            int r0 = r3.getMax()
            int r1 = r3.getMax()
            float r1 = (float) r1
            float r2 = r4.getY()
            float r1 = r1 * r2
            int r2 = r3.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r1 = (int) r1
            int r0 = r0 - r1
            r3.setProgress(r0)
            goto Lf
        Lc3:
            r3.onStopTrackingTouch()
            r3.setPressed(r0)
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xp.ziyouguang.WCYuncheVerticalSeekbar.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
