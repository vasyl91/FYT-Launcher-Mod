package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SampleSizeTest {

    @Test
    void aPictureOfTheScreensSizeIsDecodedWhole() {
        assertEquals(1, SampleSize.toCover(1024, 600, 1024, 600));
        assertEquals(1, SampleSize.toCover(1080, 2340, 1080, 2340));
    }

    @Test
    void aPictureNoBiggerThanTwiceTheScreenIsDecodedWhole() {
        assertEquals(1, SampleSize.toCover(2047, 1200, 1024, 600));
        assertEquals(1, SampleSize.toCover(2048, 1199, 1024, 600));
    }

    @Test
    void aBigPhotoIsDecodedAtTheLargestStepThatStillCoversTheScreen() {
        assertEquals(2, SampleSize.toCover(2048, 1200, 1024, 600));
        assertEquals(4, SampleSize.toCover(4096, 3072, 1024, 600));
        assertEquals(4, SampleSize.toCover(8000, 6000, 1920, 1080));
    }

    @Test
    void theResultAlwaysCoversTheSizeAsked() {
        int[][] sizes = {{4000, 3000}, {12000, 9000}, {1920, 1080}, {7680, 4320}, {3001, 1999}};
        int[][] screens = {{1024, 600}, {1280, 720}, {1920, 1080}, {2340, 1080}};
        for (int[] picture : sizes) {
            for (int[] screen : screens) {
                int sample = SampleSize.toCover(picture[0], picture[1], screen[0], screen[1]);
                assertEquals(0, sample & (sample - 1), "a power of two");
                if (sample > 1) {
                    assertTrue(picture[0] / sample >= screen[0] && picture[1] / sample >= screen[1]);
                }
                assertTrue(picture[0] / (sample * 2) < screen[0] || picture[1] / (sample * 2) < screen[1],
                        "the next step would not cover it");
            }
        }
    }

    @Test
    void anUnknownSizeGivesTheWholePicture() {
        assertEquals(1, SampleSize.toCover(0, 0, 1024, 600));
        assertEquals(1, SampleSize.toCover(-1, 3000, 1024, 600));
        assertEquals(1, SampleSize.toCover(4000, 3000, 0, 600));
    }

    @Test
    void aWallpaperCoversTheScreenTurnedEitherWay() {
        // 4096x2400 on a 1024x600 head unit: 2048x1200 still covers 1024 in both sides, 1024x600 would not
        assertEquals(2, SampleSize.toCoverTurned(4096, 2400, 1024, 600));
        assertEquals(SampleSize.toCoverTurned(4096, 2400, 1024, 600), SampleSize.toCoverTurned(4096, 2400, 600, 1024));
        assertEquals(1, SampleSize.toCoverTurned(1080, 2340, 1080, 2340));
    }
}
