package com.android.launcher66.settings;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * A picture as a view's background, never stretched: the middle of it at the view's proportions, worked out for the
 * bounds the view has at each draw (CenterCrop has the rule). The whole picture is kept, so a view that changes size
 * (a turn of the screen, its first layout) still gets the part that fits it; a BitmapDrawable stretched it instead.
 */
final class CenterCropDrawable extends Drawable {

    private final Bitmap bitmap;
    private final Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG);
    private final Rect source = new Rect();

    CenterCropDrawable(@NonNull Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    /** The part of the picture drawn for the current bounds. */
    Rect sourceRect() {
        Rect bounds = getBounds();
        int[] part = CenterCrop.source(bitmap.getWidth(), bitmap.getHeight(), bounds.width(), bounds.height());
        source.set(part[0], part[1], part[2], part[3]);
        return source;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (bitmap.isRecycled() || getBounds().isEmpty()) {
            return;
        }
        canvas.drawBitmap(bitmap, sourceRect(), getBounds(), paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return bitmap.hasAlpha() ? PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }
}
