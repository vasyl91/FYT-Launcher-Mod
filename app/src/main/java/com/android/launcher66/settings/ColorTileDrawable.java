package com.android.launcher66.settings;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * The tile of the user's own colour in a background selector. It shows the colour and its transparency: the
 * colour is painted over a light and dark chequered ground, so a colour that is half transparent lets half of
 * the squares through and one that is fully transparent shows them alone. Rounded like the other tiles.
 */
final class ColorTileDrawable extends Drawable {

    private static final int LIGHT_SQUARE = 0xFFFFFFFF;
    private static final int DARK_SQUARE = 0xFFBDBDBD;

    private final Paint squares = new Paint();
    private final Paint colour = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path clip = new Path();
    private final RectF rect = new RectF();
    private final float radius;
    private final float squareSize;

    ColorTileDrawable(int color, float radiusPx, float squarePx) {
        colour.setColor(color);
        radius = radiusPx;
        squareSize = Math.max(2f, squarePx);
    }

    @Override
    public void draw(Canvas canvas) {
        rect.set(getBounds());
        if (rect.isEmpty()) {
            return;
        }
        int save = canvas.save();
        clip.reset();
        clip.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clip);
        squares.setColor(LIGHT_SQUARE);
        canvas.drawRect(rect, squares);
        squares.setColor(DARK_SQUARE);
        int row = 0;
        for (float y = rect.top; y < rect.bottom; y += squareSize, row++) {
            for (float x = rect.left + (row % 2 == 0 ? 0 : squareSize); x < rect.right; x += 2 * squareSize) {
                canvas.drawRect(x, y, Math.min(x + squareSize, rect.right), Math.min(y + squareSize, rect.bottom),
                        squares);
            }
        }
        canvas.drawRect(rect, colour);
        canvas.restoreToCount(save);
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
