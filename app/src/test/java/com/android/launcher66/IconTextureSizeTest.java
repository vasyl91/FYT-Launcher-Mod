package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IconTextureSizeTest {

    @Test
    void aRealSizeIsKept() {
        assertEquals(96, IconTextureSize.or(96, 80));
    }

    @Test
    void aProcessStartedForABroadcastGetsTheFallbackNotZero() {
        // Launcher.app_icon_size is 0 until the launcher activity calculates it; -1 is the static's start value
        assertEquals(80, IconTextureSize.or(0, 80));
        assertEquals(80, IconTextureSize.or(-1, 80));
    }

    @Test
    void theResultIsNeverLessThanOnePixel() {
        assertEquals(1, IconTextureSize.or(0, 0));
        assertEquals(1, IconTextureSize.or(-5, -5));
    }

    @Test
    void theFallbackIsTheActivitysShareOfTheLongerSide() {
        // 6.6 % of 2000 and of 2400, whichever way round the screen is
        assertEquals(132, IconTextureSize.fallbackPx(2000, 1200));
        assertEquals(132, IconTextureSize.fallbackPx(1200, 2000));
        assertEquals(158, IconTextureSize.fallbackPx(1080, 2400));
        assertTrue(IconTextureSize.fallbackPx(0, 0) >= 1);
    }
}
