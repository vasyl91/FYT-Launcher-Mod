package com.android.launcher66.settings;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * The frame around the chosen tile of a background selector: one look for every selector and every kind of
 * tile (a picture, the user's colour, no background).
 *
 * <p>The rule: the frame is seen on any background. Its band is a gradient of three neighbouring colours that
 * runs across the tile, teal to blue to violet, which no background picture and no plain colour matches along
 * its whole length; and the band lies between two thin lines, a white one outside and a dark one inside, so
 * that one of the two always contrasts with what is beside it, on a light tile, a dark one, or a transparent
 * one with the wallpaper behind it. It is not a rainbow: the colours stay within a third of the colour circle.
 */
final class SelectedFrameDrawable extends Drawable {

    /** Teal, blue, violet. */
    private static final int[] BAND = {0xFF00C2A8, 0xFF2D7FF9, 0xFF8E5CF7};
    private static final int OUTER_LINE = 0xFFFFFFFF;
    private static final int INNER_LINE = 0xCC101418;

    private final Paint band = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint line = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();
    private final float radius;
    private final float bandWidth;
    private final float lineWidth;

    /**
     * @param radiusPx    the rounding of the tile
     * @param bandWidthPx the width of the coloured band
     * @param lineWidthPx the width of each of the two lines beside it
     */
    SelectedFrameDrawable(float radiusPx, float bandWidthPx, float lineWidthPx) {
        radius = radiusPx;
        bandWidth = bandWidthPx;
        lineWidth = lineWidthPx;
        band.setStyle(Paint.Style.STROKE);
        band.setStrokeWidth(bandWidthPx);
        line.setStyle(Paint.Style.STROKE);
        line.setStrokeWidth(lineWidthPx);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        band.setShader(new LinearGradient(bounds.left, bounds.top, bounds.right, bounds.bottom, BAND, null,
                Shader.TileMode.CLAMP));
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            return;
        }
        // from the edge inwards: the white line, the band, the dark line
        float inset = lineWidth / 2f;
        strokeAt(canvas, inset, line, OUTER_LINE);
        inset = lineWidth + bandWidth / 2f;
        rect.set(bounds.left + inset, bounds.top + inset, bounds.right - inset, bounds.bottom - inset);
        float r = Math.max(0f, radius - inset);
        canvas.drawRoundRect(rect, r, r, band);
        inset = lineWidth + bandWidth + lineWidth / 2f;
        strokeAt(canvas, inset, line, INNER_LINE);
    }

    private void strokeAt(Canvas canvas, float inset, Paint paint, int color) {
        Rect bounds = getBounds();
        paint.setColor(color);
        rect.set(bounds.left + inset, bounds.top + inset, bounds.right - inset, bounds.bottom - inset);
        float r = Math.max(0f, radius - inset);
        canvas.drawRoundRect(rect, r, r, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        band.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter filter) {
        band.setColorFilter(filter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
