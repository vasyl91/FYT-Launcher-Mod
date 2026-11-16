package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerticalBarCornerTest {

    @Test
    void itAppliesToTheVerticalBarOnEveryPageWithTheHorizontalOneOnTheFirstPageOnly() {
        assertTrue(VerticalBarCorner.applies(true, true, false, false, true));
        // both on every page: the corner is the horizontal bar's everywhere
        assertFalse(VerticalBarCorner.applies(true, true, true, false, true));
        // the auto-hide bar has its button in the corner
        assertFalse(VerticalBarCorner.applies(true, true, false, true, true));
        // the vertical bar on the first page only, no vertical bar, no user layout
        assertFalse(VerticalBarCorner.applies(true, false, false, false, true));
        assertFalse(VerticalBarCorner.applies(false, true, false, false, true));
        assertFalse(VerticalBarCorner.applies(true, true, false, false, false));
    }

    @Test
    void theShiftIsHowFarTheFirstPageHasMovedFromItsRest() {
        assertEquals(0, VerticalBarCorner.shift(0, 0));
        assertEquals(-300, VerticalBarCorner.shift(0, 300));
        assertEquals(-1080, VerticalBarCorner.shift(0, 1080));
        assertEquals(500, VerticalBarCorner.shift(1080, 580));
    }

    @Test
    void aBarOnTheRightIsFreeAsSoonAsTheHorizontalBarHasMovedOffItsStrip() {
        // the A55 in portrait: the box 0..1080, the vertical bar 938..1080
        assertTrue(VerticalBarCorner.covered(0, 1080, 938, 1080));       // the first page at rest
        assertTrue(VerticalBarCorner.covered(-100, 980, 938, 1080));     // moving away, still across
        assertFalse(VerticalBarCorner.covered(-142, 938, 938, 1080));    // off the strip: the edges only touch
        assertFalse(VerticalBarCorner.covered(-1080, 0, 938, 1080));     // the next page at rest
        assertTrue(VerticalBarCorner.covered(-141, 939, 938, 1080));     // coming back: onto the strip again
    }

    @Test
    void aBarOnTheLeftIsFreeOnlyWhenTheFirstPageHasAlmostLeft() {
        assertTrue(VerticalBarCorner.covered(0, 1080, 0, 142));
        assertTrue(VerticalBarCorner.covered(-1000, 80, 0, 142));
        assertFalse(VerticalBarCorner.covered(-1080, 0, 0, 142));
        assertTrue(VerticalBarCorner.covered(-1079, 1, 0, 142));
    }

    @Test
    void theInsetIsTheCornersHeight() {
        // the A55: 1976 px on the first page under a horizontal bar of 140 px, 2116 px on the others
        assertEquals(140, VerticalBarCorner.inset(2116, 1976));
        assertEquals(0, VerticalBarCorner.inset(1976, 2116));
        assertEquals(0, VerticalBarCorner.inset(2116, 2116));
    }
}
