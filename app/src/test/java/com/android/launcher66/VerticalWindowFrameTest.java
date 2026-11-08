package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VerticalWindowFrameTest {

    // the box 1920 x 672 from y = 48, the bar 137 wide; the band of the layout, in the box
    private static final int[] BAND_LEFT = {0, 0, 137, 560};
    private static final int[] BAND_RIGHT = {1783, 0, 1920, 560};

    @Test
    void beforeTheFirstMeasurementTheLayoutDecidesOnBothSides() {
        VerticalWindowFrame.Frame left = VerticalWindowFrame.of(null, BAND_LEFT, 0, 48);
        assertEquals(0, left.x);
        assertEquals(48, left.y);
        assertEquals(137, left.w);
        assertEquals(560, left.h);
        VerticalWindowFrame.Frame right = VerticalWindowFrame.of(null, BAND_RIGHT, 0, 48);
        assertEquals(1783, right.x);
        assertEquals(137, right.w);
    }

    @Test
    void afterItTheBarOfTheFirstPageDecidesTheSide() {
        // the first page's bar is on the right; even a band computed for the left puts the window on the right
        VerticalWindowFrame.Frame f = VerticalWindowFrame.of(new int[] {1783, 1920}, BAND_LEFT, 0, 48);
        assertEquals(1783, f.x);
        assertEquals(137, f.w);
        // the height and the place from the top are the layout's
        assertEquals(48, f.y);
        assertEquals(560, f.h);
        VerticalWindowFrame.Frame onTheLeft = VerticalWindowFrame.of(new int[] {0, 137}, BAND_RIGHT, 0, 48);
        assertEquals(0, onTheLeft.x);
    }

    @Test
    void aCutoutAtTheSideMovesTheMeasuredBarAndTheBox() {
        // the first page starts after a 120 px cut-out: the bar on the right still ends at the edge of the box
        VerticalWindowFrame.Frame f = VerticalWindowFrame.of(new int[] {2263, 2400}, new int[] {2143, 0, 2280, 560}, 120, 72);
        assertEquals(2263, f.x);
        // before the measurement the box's left edge is added to the band
        VerticalWindowFrame.Frame before = VerticalWindowFrame.of(null, new int[] {2143, 0, 2280, 560}, 120, 72);
        assertEquals(2263, before.x);
    }

    @Test
    void anEmptyMeasurementIsNotUsed() {
        VerticalWindowFrame.Frame f = VerticalWindowFrame.of(new int[] {500, 500}, BAND_RIGHT, 0, 48);
        assertEquals(1783, f.x);
    }

    @Test
    void theOffsetIsMeasuredFromTheEdgeTheBarIsOn() {
        VerticalWindowFrame.Frame right = new VerticalWindowFrame.Frame(1783, 48, 137, 560);
        assertEquals(0, VerticalWindowFrame.offset(right, 1920, true));
        VerticalWindowFrame.Frame inset = new VerticalWindowFrame.Frame(2263, 72, 137, 560);
        assertEquals(0, VerticalWindowFrame.offset(inset, 2400, true));
        VerticalWindowFrame.Frame cut = new VerticalWindowFrame.Frame(1700, 48, 137, 560);
        assertEquals(83, VerticalWindowFrame.offset(cut, 1920, true));
        VerticalWindowFrame.Frame left = new VerticalWindowFrame.Frame(120, 72, 137, 560);
        assertEquals(120, VerticalWindowFrame.offset(left, 2400, false));
    }
}
