package com.android.launcher66;

/**
 * The part of an icon's picture that can be seen: the smallest rectangle round its pixels that are not (nearly)
 * transparent, as fractions of the picture {left, top, right, bottom}, each 0..1.
 *
 * <p>The rule (the owner on the A55, 2026-11-27): a badge is sized and placed by the icon as it is seen on the screen, not
 * by the picture's whole square, which is often wider than the icon in it (a round icon, an icon with a margin). A pixel
 * counts when its alpha is above {@link #ALPHA_THRESHOLD}; a picture with none is taken whole. It is worked out once per
 * picture (IconBounds keeps it). Pure Java, so that it has a test.
 */
final class VisibleBounds {

    /** The alpha a pixel needs to count as seen: about a tenth of opaque, so that a soft shadow's edge does not. */
    static final int ALPHA_THRESHOLD = 24;

    static final float[] WHOLE = {0f, 0f, 1f, 1f};

    private VisibleBounds() {
    }

    /** The seen part of a picture of {@code width} by {@code height} pixels in ARGB, row by row. */
    static float[] of(int[] argb, int width, int height) {
        if (argb == null || width <= 0 || height <= 0 || argb.length < width * height) {
            return WHOLE;
        }
        int left = width;
        int top = height;
        int right = -1;
        int bottom = -1;
        for (int y = 0; y < height; y++) {
            int row = y * width;
            for (int x = 0; x < width; x++) {
                if ((argb[row + x] >>> 24) > ALPHA_THRESHOLD) {
                    if (x < left) {
                        left = x;
                    }
                    if (x > right) {
                        right = x;
                    }
                    if (y < top) {
                        top = y;
                    }
                    bottom = y;
                }
            }
        }
        if (right < 0) {
            return WHOLE;
        }
        return new float[] {left / (float) width, top / (float) height, (right + 1) / (float) width,
                (bottom + 1) / (float) height};
    }

    /**
     * The seen part as pixels {x, y, width, height} of a picture of this size: the fractions of {@link #of} back on its
     * pixels, never empty and never past the picture (the list of widgets crops its previews with it).
     */
    static int[] pixels(float[] fractions, int width, int height) {
        float[] f = fractions == null ? WHOLE : fractions;
        int left = Math.max(0, Math.min(width - 1, Math.round(f[0] * width)));
        int top = Math.max(0, Math.min(height - 1, Math.round(f[1] * height)));
        int right = Math.max(left + 1, Math.min(width, Math.round(f[2] * width)));
        int bottom = Math.max(top + 1, Math.min(height, Math.round(f[3] * height)));
        return new int[] {left, top, right - left, bottom - top};
    }

    /** The seen part of a picture drawn in the rectangle {left, top, right, bottom}: that rectangle, cut by the fractions. */
    static float[] in(float left, float top, float right, float bottom, float[] fractions) {
        float[] f = fractions == null ? WHOLE : fractions;
        float w = right - left;
        float h = bottom - top;
        return new float[] {left + f[0] * w, top + f[1] * h, left + f[2] * w, top + f[3] * h};
    }
}
