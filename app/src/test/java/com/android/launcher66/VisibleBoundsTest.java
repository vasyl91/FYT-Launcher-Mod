package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class VisibleBoundsTest {

    /** A picture of w x h, transparent but for an opaque box from x0,y0 to x1,y1 (exclusive). */
    private static int[] picture(int w, int h, int x0, int y0, int x1, int y1, int argb) {
        int[] pixels = new int[w * h];
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                pixels[y * w + x] = argb;
            }
        }
        return pixels;
    }

    @Test
    void theSeenPartIsTheBoxOfThePixelsThatAreNotTransparent() {
        assertArrayEquals(new float[] {0.25f, 0.1f, 0.75f, 0.9f},
                VisibleBounds.of(picture(20, 10, 5, 1, 15, 9, 0xff336699), 20, 10), 0.0001f);
    }

    @Test
    void aFaintPixelIsNotSeenAndAnEmptyPictureIsTakenWhole() {
        // a soft shadow at alpha 0x10 round the icon does not count
        int[] pixels = picture(10, 10, 0, 0, 10, 10, 0x10000000);
        for (int y = 2; y < 8; y++) {
            for (int x = 2; x < 8; x++) {
                pixels[y * 10 + x] = 0xffffffff;
            }
        }
        assertArrayEquals(new float[] {0.2f, 0.2f, 0.8f, 0.8f}, VisibleBounds.of(pixels, 10, 10), 0.0001f);
        assertArrayEquals(VisibleBounds.WHOLE, VisibleBounds.of(new int[100], 10, 10), 0f);
        assertArrayEquals(VisibleBounds.WHOLE, VisibleBounds.of(null, 10, 10), 0f);
    }

    @Test
    void theSeenPartOfAPictureDrawnInARectangle() {
        assertArrayEquals(new float[] {120f, 220f, 180f, 280f},
                VisibleBounds.in(100f, 200f, 200f, 300f, new float[] {0.2f, 0.2f, 0.8f, 0.8f}), 0.001f);
        assertArrayEquals(new float[] {100f, 200f, 200f, 300f}, VisibleBounds.in(100f, 200f, 200f, 300f, null), 0.001f);
    }
}
