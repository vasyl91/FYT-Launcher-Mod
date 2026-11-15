package com.android.launcher66.settings;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * The tile of the user's own colour in a background selector, and the tile for no background.
 *
 * <p>The rule: a tile shows the choice as it will look. The colour is painted with its transparency straight
 * onto what the selector shows behind its tiles (the wallpaper, or its colours), the way the picture tiles
 * are, so a colour that is half transparent lets half of the wallpaper through. A chequered ground under the
 * colour, as it was first made, showed something that is never on the screen.
 *
 * <p>A thin line around the tile, light with a dark one inside it, keeps a very transparent colour and the
 * tile for no background findable on any wallpaper; the tile for no background also has a line across it.
 * Rounded like the other tiles.
 */
final class ColorTileDrawable extends Drawable {

    private static final int OUTER_LINE = 0xB3FFFFFF;
    private static final int INNER_LINE = 0x66000000;

    private final Paint colour = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint line = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();
    private final float radius;
    private final float lineWidth;
    private final boolean crossed;

    /**
     * @param color       the colour with its alpha
     * @param radiusPx    the rounding of the tile
     * @param lineWidthPx the width of each of the two lines around it
     * @param crossed     a line from corner to corner: the tile for no background
     */
    ColorTileDrawable(int color, float radiusPx, float lineWidthPx, boolean crossed) {
        colour.setColor(color);
        radius = radiusPx;
        lineWidth = Math.max(1f, lineWidthPx);
        this.crossed = crossed;
        line.setStyle(Paint.Style.STROKE);
        line.setStrokeWidth(lineWidth);
        line.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void draw(Canvas canvas) {
        rect.set(getBounds());
        if (rect.isEmpty()) {
            return;
        }
        canvas.drawRoundRect(rect, radius, radius, colour);
        outline(canvas, lineWidth / 2f, OUTER_LINE);
        outline(canvas, lineWidth * 1.5f, INNER_LINE);
        if (crossed) {
            float inset = radius * 0.3f + lineWidth * 2f;
            line.setColor(INNER_LINE);
            line.setStrokeWidth(lineWidth * 3f);
            canvas.drawLine(rect.left + inset, rect.bottom - inset, rect.right - inset, rect.top + inset, line);
            line.setColor(OUTER_LINE);
            line.setStrokeWidth(lineWidth);
            canvas.drawLine(rect.left + inset, rect.bottom - inset, rect.right - inset, rect.top + inset, line);
        }
    }

    private void outline(Canvas canvas, float inset, int color) {
        line.setColor(color);
        line.setStrokeWidth(lineWidth);
        rect.set(getBounds());
        rect.inset(inset, inset);
        float r = Math.max(0f, radius - inset);
        canvas.drawRoundRect(rect, r, r, line);
        rect.set(getBounds());
    }

    @Override
    public void setAlpha(int alpha) {
        // The tile shows the stored transparency; it has none of its own
    }

    @Override
    public void setColorFilter(ColorFilter filter) {
        // not tinted
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
