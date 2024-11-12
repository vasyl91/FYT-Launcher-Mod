package com.android.launcher66;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
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

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect r = getBounds();
        if (this.mBitmap != null) {
            canvas.drawBitmap(this.mBitmap, (Rect) null, r, this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mAlpha = alpha;
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filterBitmap) {
        this.mPaint.setFilterBitmap(filterBitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
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
