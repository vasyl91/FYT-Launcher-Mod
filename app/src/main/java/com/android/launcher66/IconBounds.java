package com.android.launcher66;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * The seen part of an icon's picture (VisibleBounds), worked out once per picture and kept while the picture is: the
 * badges ask it each time they are drawn. A picture that cannot be read (a hardware bitmap, a drawable without a
 * bitmap) is taken whole. Main thread; reading the pixels of one icon is a few tens of thousands of compares, no I/O.
 */
final class IconBounds {

    private static final Map<Bitmap, float[]> sKnown = new WeakHashMap<>();

    private IconBounds() {
    }

    /** The fractions {left, top, right, bottom} of the picture that are seen; null for one that cannot be read. */
    static float[] of(Drawable drawable) {
        Bitmap bitmap = null;
        if (drawable instanceof FastBitmapDrawable) {
            bitmap = ((FastBitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            return null;
        }
        float[] known = sKnown.get(bitmap);
        if (known != null) {
            return known;
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pixels = new int[w * h];
        bitmap.getPixels(pixels, 0, w, 0, 0, w, h);
        float[] fractions = VisibleBounds.of(pixels, w, h);
        sKnown.put(bitmap, fractions);
        return fractions;
    }
}
