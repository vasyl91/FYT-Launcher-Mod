package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VerticalBarDimensionsTest {

    @Test
    void offOrAtTheDefaultTheWidthIsTheOldOne() {
        // 7862 in landscape (2000 wide), the A55 in portrait (2340 high) and in landscape
        assertEquals(142, VerticalBarDimensions.width(false, 2000, false, 0.09f));
        assertEquals(142, VerticalBarDimensions.width(false, 2000, true, VerticalBarDimensions.DEFAULT_SHARE_LANDSCAPE));
        assertEquals(142, VerticalBarDimensions.width(true, 2340, false, 0.05f));
        assertEquals(166, VerticalBarDimensions.width(false, 2340, true, 0.071f));
        // 1920 high: the share of the longer edge would give 116, the old formula 117
        assertEquals(117, VerticalBarDimensions.width(true, 1920, true, VerticalBarDimensions.DEFAULT_SHARE_PORTRAIT));
        assertEquals(117, VerticalBarDimensions.width(true, 1920, true, 0.061f));
    }

    @Test
    void onItIsTheShareOfTheLongerEdgeWithinTheRange() {
        assertEquals(200, VerticalBarDimensions.width(false, 2000, true, 0.10f));
        assertEquals(80, VerticalBarDimensions.width(false, 2000, true, 0.04f));
        assertEquals(200, VerticalBarDimensions.width(false, 2000, true, 0.5f));
        assertEquals(80, VerticalBarDimensions.width(false, 2000, true, 0.01f));
        assertEquals(187, VerticalBarDimensions.width(true, 2340, true, 0.08f));
        assertEquals(142, VerticalBarDimensions.width(true, 2340, true, Float.NaN));
    }

    @Test
    void theStepNearestTheDefaultIsTheDefault() {
        assertEquals(61, VerticalBarDimensions.toStep(VerticalBarDimensions.DEFAULT_SHARE_PORTRAIT));
        assertEquals(VerticalBarDimensions.DEFAULT_SHARE_PORTRAIT, VerticalBarDimensions.fromStep(61, true));
        assertEquals(0.061f, VerticalBarDimensions.fromStep(61, false));
        assertEquals(VerticalBarDimensions.DEFAULT_SHARE_LANDSCAPE, VerticalBarDimensions.fromStep(71, false));
        assertEquals(0.04f, VerticalBarDimensions.fromStep(10, true));
        assertEquals(0.10f, VerticalBarDimensions.fromStep(500, true));
    }

    @Test
    void noScreenNoWidth() {
        assertEquals(0, VerticalBarDimensions.width(true, 0, true, 0.08f));
        assertEquals(0, VerticalBarDimensions.legacyWidth(false, -1));
    }
}
