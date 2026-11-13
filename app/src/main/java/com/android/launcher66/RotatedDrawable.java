package com.android.launcher66;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Draws another drawable turned by a multiple of 90 degrees, inside its own bounds. Used for the picture of a
 * bar's background (BackgroundAngle): only what this drawable draws is turned; the view that has it as its
 * background or image, and everything in that view, stays as it is.
 *
 * <p>For a quarter turn the picture is drawn with its width along the height of the bounds, so it still fills
 * them; the size it reports has the sides swapped, for an ImageView that scales it by that size. The picture
 * is a mutated copy, so changing its alpha here cannot show on other users of the same resource.
 */
public final class RotatedDrawable extends Drawable {

    private final Drawable picture;
    private final int degrees;
    private final boolean swapped;

    /** @param degrees clockwise, a multiple of 90 */
    public RotatedDrawable(Drawable picture, int degrees) {
        this.picture = picture.mutate();
        this.degrees = Math.floorMod(degrees, 360);
        this.swapped = BackgroundAngle.swapsSides(this.degrees);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            return;
        }
        int width = swapped ? bounds.height() : bounds.width();
        int height = swapped ? bounds.width() : bounds.height();
        int save = canvas.save();
        canvas.translate(bounds.exactCenterX(), bounds.exactCenterY());
        canvas.rotate(degrees);
        picture.setBounds(-width / 2, -height / 2, width - width / 2, height - height / 2);
        picture.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override
    public int getIntrinsicWidth() {
        return swapped ? picture.getIntrinsicHeight() : picture.getIntrinsicWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return swapped ? picture.getIntrinsicWidth() : picture.getIntrinsicHeight();
    }

    @Override
    public void setAlpha(int alpha) {
        picture.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter filter) {
        picture.setColorFilter(filter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return picture.getOpacity();
    }
}
