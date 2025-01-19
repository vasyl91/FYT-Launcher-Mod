package com.android.launcher66;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class FastBitmapDrawable extends Drawable {
    private Bitmap mBitmap;
    private int mHeight;
    private int mWidth;
    private final Paint mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private int mAlpha = 255;

    FastBitmapDrawable(Bitmap b) {
        this.mBitmap = b;
        if (b != null) {
            this.mWidth = this.mBitmap.getWidth();
            this.mHeight = this.mBitmap.getHeight();
        } else {
            this.mHeight = 0;
            this.mWidth = 0;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Rect r = getBounds();
        if (this.mBitmap != null) {
            canvas.drawBitmap(this.mBitmap, (Rect) null, r, this.mPaint);
        }
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        this.mAlpha = alpha;
        this.mPaint.setAlpha(alpha);
    }

    @Override
    public void setFilterBitmap(boolean filterBitmap) {
        this.mPaint.setFilterBitmap(filterBitmap);
    }

    @Override
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override
    public int getMinimumWidth() {
        return this.mWidth;
    }

    @Override
    public int getMinimumHeight() {
        return this.mHeight;
    }

    public void setBitmap(Bitmap b) {
        this.mBitmap = b;
        if (b != null) {
            this.mWidth = this.mBitmap.getWidth();
            this.mHeight = this.mBitmap.getHeight();
        } else {
            this.mHeight = 0;
            this.mWidth = 0;
        }
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }
}
