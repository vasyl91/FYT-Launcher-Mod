package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class WindowPlacementTest {

    @Test
    void aBarOnTheRightThatLiesOneBarWidthInsideIsPutBackByMovingItsOffsetDown() {
        // A55, 2026-11-24: put at 952, the system's relayout gave 824 (a bar's width, 128 px, inside the screen)
        WindowPlacement placement = new WindowPlacement();
        // gravity RIGHT: x is the distance from the right edge, so moving right means a smaller x
        assertArrayEquals(new int[] {-128, 0}, placement.check(824, 89, 952, 89, true));
    }

    @Test
    void aBarOnTheLeftIsMovedByTheDifference() {
        WindowPlacement placement = new WindowPlacement();
        assertArrayEquals(new int[] {20, 0}, placement.check(100, 89, 120, 89, false));
        WindowPlacement up = new WindowPlacement();
        assertArrayEquals(new int[] {0, -13}, up.check(0, 102, 0, 89, false));
    }

    @Test
    void aWindowWhereItWasPutOrAPixelOffIsLeftAlone() {
        WindowPlacement placement = new WindowPlacement();
        assertNull(placement.check(952, 89, 952, 89, true));
        assertNull(placement.check(951, 90, 952, 89, true));
    }

    @Test
    void theSameReportTwiceIsOneCorrectionNotTwo() {
        WindowPlacement placement = new WindowPlacement();
        assertArrayEquals(new int[] {-128, 0}, placement.check(824, 89, 952, 89, true));
        // the system has not applied the correction yet: the layout listener and the posted check see the same place
        assertNull(placement.check(824, 89, 952, 89, true));
        assertNull(placement.check(824, 89, 952, 89, true));
    }

    @Test
    void aReportThatStillDiffersAfterACorrectionIsCountedFromItself() {
        WindowPlacement placement = new WindowPlacement();
        assertArrayEquals(new int[] {-128, 0}, placement.check(824, 89, 952, 89, true));
        // the system applied half of it
        assertArrayEquals(new int[] {-64, 0}, placement.check(888, 89, 952, 89, true));
    }

    @Test
    void whenTheWindowLiesRightAgainTheNextMoveIsCorrectedAgain() {
        WindowPlacement placement = new WindowPlacement();
        assertArrayEquals(new int[] {-128, 0}, placement.check(824, 89, 952, 89, true));
        assertNull(placement.check(952, 89, 952, 89, true));
        // moved once more later (a second swipe): the same wrong place is not taken for a stale report
        assertArrayEquals(new int[] {-128, 0}, placement.check(824, 89, 952, 89, true));
    }

    @Test
    void aNewFrameStartsTheCountOver() {
        WindowPlacement placement = new WindowPlacement();
        for (int i = 0; i < WindowPlacement.MAX_ATTEMPTS; i++) {
            // the system keeps moving it: each report is a different place
            placement.check(800 + i, 89, 952, 89, true);
        }
        assertNull(placement.check(700, 89, 952, 89, true));
        assertEquals(WindowPlacement.MAX_ATTEMPTS, placement.attempts());
        placement.frameChanged();
        assertArrayEquals(new int[] {-252, 0}, placement.check(700, 89, 952, 89, true));
    }
}
