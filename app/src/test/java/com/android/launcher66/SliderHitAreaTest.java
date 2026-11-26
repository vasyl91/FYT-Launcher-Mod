package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SliderHitAreaTest {

    // a slider 500 x 40 px with a knob of 20 px and a track a quarter of it, 5 px: growth 6 px, 3 px on each side
    private static final int W = 500;
    private static final int H = 40;
    private static final float TRACK = 5f;
    private static final float KNOB = 20f;

    private static boolean hit(float x, float y, float knobX) {
        return SliderHitArea.contains(x, y, W, H, TRACK, KNOB, knobX);
    }

    @Test
    void theTrackIsAStripAlongTheWholeWidth() {
        assertTrue(hit(0f, 20f, 250f));
        assertTrue(hit(500f, 20f, 250f));
        assertTrue(hit(100f, 20f, 250f));
    }

    @Test
    void theStripIsThickerThanTheTrackByAThirtiethOfTheKnobsDiameterOnEachSide() {
        // half of 5 px + 3 px = 5.5 px from the middle line
        assertTrue(hit(100f, 20f + 5.4f, 250f));
        assertTrue(hit(100f, 20f - 5.4f, 250f));
        assertFalse(hit(100f, 20f + 5.6f, 250f));
        assertFalse(hit(100f, 20f - 5.6f, 250f));
    }

    @Test
    void theKnobIsACircleLargerThanItIsDrawn() {
        // drawn radius 10 px, hit radius 13 px
        assertTrue(hit(250f, 20f - 12.9f, 250f));
        assertFalse(hit(250f, 20f - 13.1f, 250f));
        assertTrue(hit(250f + 12.9f, 20f, 250f));
        // the corner of the square around the knob is outside the circle
        assertFalse(hit(250f + 11f, 20f + 11f, 250f));
    }

    @Test
    void aTouchAboveOrBelowTheSliderIsNotTheSliders() {
        assertFalse(hit(100f, 0f, 250f));
        assertFalse(hit(100f, 40f, 250f));
        assertFalse(hit(-1f, 20f, 250f));
        assertFalse(hit(501f, 20f, 250f));
    }

    @Test
    void theKnobAtAnEndReachesBeyondTheSliderByItsGrowth() {
        // the knob's centre at x = 10 (its radius from the left end): its circle goes to -3
        assertTrue(hit(-2f, 20f, 10f));
        assertFalse(hit(-4f, 20f, 10f));
    }

    @Test
    void theOuterRectangleHoldsTheWholeArea() {
        SliderHitArea.Rect outer = SliderHitArea.outer(W, H, TRACK, KNOB);
        assertEquals(20f - 13f, outer.top, 0.001f);
        assertEquals(20f + 13f, outer.bottom, 0.001f);
        assertTrue(outer.left <= -3f);
        assertTrue(outer.right >= W + 3f);
    }
}
