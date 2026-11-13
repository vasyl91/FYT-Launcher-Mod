package com.android.launcher66;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * A background of one colour, with its transparency, in the shape the pictures of the backgrounds have: a
 * rectangle with rounded corners. The pictures are stretched to their view, so their corners grow with it; the
 * radius here is therefore a share of the shorter side and not a fixed size. Used for the user's own colour
 * (BackgroundChoice).
 */
public final class RoundedColorDrawable extends Drawable {

    /** The corners of the widgets' pictures (bg_custom): about 10 px of 457. */
    public static final float WIDGET_CORNERS = 0.022f;
    /** The corners of the horizontal bar's pictures (app_list_bg): about 13 px of 258. */
    public static final float BAR_CORNERS = 0.05f;
    /** The vertical bar's own picture (hotseat_bg) has square corners. */
    public static final float NO_CORNERS = 0f;

    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();
    private final float cornerShare;
    private final int baseAlpha;
    private int alpha = 255;

    public RoundedColorDrawable(int color, float cornerShare) {
        this.cornerShare = Math.max(0f, cornerShare);
        this.baseAlpha = color >>> 24;
        paint.setColor(color);
    }

    @Override
    public void draw(Canvas canvas) {
        rect.set(getBounds());
        if (rect.isEmpty() || paint.getAlpha() == 0) {
            return;
        }
        float radius = Math.min(rect.width(), rect.height()) * cornerShare;
        canvas.drawRoundRect(rect, radius, radius, paint);
    }

    @Override
    public void setAlpha(int value) {
        alpha = value;
        paint.setAlpha(baseAlpha * value / 255);
        invalidateSelf();
    }

    @Override
    public int getAlpha() {
        return alpha;
    }

    @Override
    public void setColorFilter(ColorFilter filter) {
        paint.setColorFilter(filter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
