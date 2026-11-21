package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CenterCropTest {

    /** The part has the view's proportions, to a pixel. */
    private static void sameProportions(int[] part, int dstW, int dstH) {
        double partRatio = (double) (part[2] - part[0]) / (part[3] - part[1]);
        double viewRatio = (double) dstW / dstH;
        double onePixel = (double) (part[2] - part[0] + 1) / (part[3] - part[1]) - partRatio;
        assertTrue(Math.abs(partRatio - viewRatio) <= Math.abs(onePixel) + 1e-9,
                "part " + partRatio + " view " + viewRatio);
    }

    @Test
    void aPortraitWallpaperBehindALandscapeDialogShowsItsMiddleBand() {
        // A 1080 x 2340 phone wallpaper behind the selector in landscape (0.7 x 2340 by 0.8 x 1080)
        int[] part = CenterCrop.source(1080, 2340, 1638, 864);
        assertEquals(0, part[0]);
        assertEquals(1080, part[2], "the full width");
        assertEquals(2340 - part[3], part[1], "the middle: as much cut above as below");
        sameProportions(part, 1638, 864);
    }

    @Test
    void aLandscapeWallpaperBehindAPortraitDialogShowsItsMiddleColumn() {
        int[] part = CenterCrop.source(2000, 1200, 960, 1600);
        assertEquals(0, part[1]);
        assertEquals(1200, part[3], "the full height");
        assertEquals(2000 - part[2], part[0]);
        sameProportions(part, 960, 1600);
    }

    @Test
    void theSameProportionsShowTheWholePicture() {
        assertArrayEquals(new int[] {0, 0, 1080, 2340}, CenterCrop.source(1080, 2340, 540, 1170));
    }

    @Test
    void aViewWithoutASizeYetGetsTheWholePicture() {
        assertArrayEquals(new int[] {0, 0, 1080, 2340}, CenterCrop.source(1080, 2340, 0, 0));
        assertArrayEquals(new int[] {0, 0, 0, 0}, CenterCrop.source(0, 0, 100, 100));
    }

    @Test
    void theViewsSizeAloneDecidesThePartNotTheOrderOfTheSizes() {
        // The view measured small first, then at its final size: each draw takes the part of its own size
        sameProportions(CenterCrop.source(1080, 2340, 300, 900), 300, 900);
        sameProportions(CenterCrop.source(1080, 2340, 1638, 864), 1638, 864);
    }
}
