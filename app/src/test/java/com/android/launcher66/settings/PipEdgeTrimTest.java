package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PipEdgeTrimTest {

    private static final int NO = PipEdgeTrim.NO_LIMIT;

    @Test
    void rectangleInsideTheLimitsIsReturnedUnchanged() {
        assertArrayEquals(new int[] {10, 20, 500, 400},
                PipEdgeTrim.trim(10, 20, 500, 400, 900, 800, 300, 200));
    }

    @Test
    void bottomBarCutsOnlyTheBottomEdge() {
        // bar top at 1000, margin 5 -> bottom edge limited to 995
        int maxBottom = PipEdgeTrim.maxBottom(1000, 5);
        assertEquals(995, maxBottom);
        assertArrayEquals(new int[] {10, 600, 700, 995},
                PipEdgeTrim.trim(10, 600, 700, 1040, NO, maxBottom, 528, 360));
    }

    @Test
    void cutExactlyToTheMinimumIsStillAllowed() {
        assertArrayEquals(new int[] {10, 635, 700, 995},
                PipEdgeTrim.trim(10, 635, 700, 1040, NO, 995, 528, 360));
    }

    @Test
    void cutBelowTheMinimumHeightFallsBack() {
        assertNull(PipEdgeTrim.trim(10, 636, 700, 1040, NO, 995, 528, 360));
    }

    @Test
    void rectangleLyingEntirelyUnderTheBarFallsBack() {
        assertNull(PipEdgeTrim.trim(10, 1010, 700, 1100, NO, 995, 0, 0));
    }

    @Test
    void zeroMarginKeepsTheBottomEdgeStrictlyAboveTheBar() {
        // overlapsOrTouches() counts a shared edge as a collision.
        assertEquals(999, PipEdgeTrim.maxBottom(1000, 0));
        assertEquals(995, PipEdgeTrim.maxBottom(1000, 5));
    }

    @Test
    void leftBarCutsOnlyTheRightEdge() {
        // box 2000 wide, left bar 142, margin 5 -> right edge limited to 1853
        int maxRight = PipEdgeTrim.maxRight(2000, 142f, 5);
        assertEquals(1853, maxRight);
        assertTrue(maxRight + 142 <= 2000 - 5);
        assertArrayEquals(new int[] {1000, 100, 1853, 600},
                PipEdgeTrim.trim(1000, 100, 1900, 600, maxRight, NO, 528, 360));
    }

    @Test
    void fractionalLeftBarWidthRoundsTheLimitDown() {
        int maxRight = PipEdgeTrim.maxRight(1920, 136.32f, 5);
        assertEquals(1778, maxRight);
        assertTrue(maxRight + 136.32f <= 1920 - 5);
        assertTrue((maxRight + 1) + 136.32f > 1920 - 5);
    }

    @Test
    void leftBarCutBelowTheMinimumWidthFallsBack() {
        assertNull(PipEdgeTrim.trim(1500, 100, 1900, 600, 1853, NO, 528, 360));
    }

    @Test
    void bothBarsAtOnce() {
        assertArrayEquals(new int[] {1000, 300, 1853, 995},
                PipEdgeTrim.trim(1000, 300, 1900, 1040, 1853, 995, 528, 360));
    }

    @Test
    void oneAxisTooSmallIsEnoughToFallBack() {
        assertNull(PipEdgeTrim.trim(1000, 300, 1900, 1040, 1853, 995, 528, 700));
        assertNull(PipEdgeTrim.trim(1500, 300, 1900, 1040, 1853, 995, 528, 360));
    }

    @Test
    void emptyResultIsNeverReturnedEvenWithZeroMinimum() {
        assertNull(PipEdgeTrim.trim(100, 100, 200, 200, 100, NO, 0, 0));
        assertNull(PipEdgeTrim.trim(100, 100, 200, 200, NO, 100, 0, 0));
    }

    @Test
    void landscapeLeftBarIs7Point1PercentOfTheBoxWidth() {
        assertEquals(142f, PipEdgeTrim.computeLeftBarWidth(false, 2000, 1200, 196), 0f);
        // Must stay bit-identical to the previous screenWidth * 0.071f.
        assertEquals(1920 * 0.071f, PipEdgeTrim.computeLeftBarWidth(false, 1920, 720, 118), 0f);
        assertEquals((int) (1920 * 0.071f), (int) PipEdgeTrim.computeLeftBarWidth(false, 1920, 720, 118));
    }

    @Test
    void portraitLeftBarIs7Point1PercentOfTheHeightAboveTheBar() {
        // XML: W,0.071 with the bar running from the top of the box down to the bottom bar.
        int rootWidth = 1200;
        int rootHeight = 1900;
        int barHeight = (int) (rootWidth * 0.142);
        assertEquals((rootHeight - barHeight) * 0.071f,
                PipEdgeTrim.computeLeftBarWidth(true, rootWidth, rootHeight, barHeight), 0.0001f);
        assertEquals(0f, PipEdgeTrim.computeLeftBarWidth(true, rootWidth, 100, 500), 0f);
    }

    @Test
    void dualPipGetsTheFullMinimumWidth() {
        assertEquals(528, PipEdgeTrim.pipMinWidth("pipDual", 528, true, true, true, true));
        assertEquals(528, PipEdgeTrim.pipMinWidth("pipDual", 528, false, false, false, false));
    }

    @Test
    void singlePipsShareTheMinimumByTheNumberOfEnabledOnes() {
        assertEquals(528, PipEdgeTrim.pipMinWidth("pipFirst", 528, true, false, false, false));
        assertEquals(264, PipEdgeTrim.pipMinWidth("pipFirst", 528, true, true, false, false));
        assertEquals(264, PipEdgeTrim.pipMinWidth("pipFourth", 528, true, true, true, true));
        // Nothing enabled never divides by zero.
        assertEquals(528, PipEdgeTrim.pipMinWidth("pipThird", 528, false, false, false, false));
    }

    @Test
    void pipKeys() {
        for (String key : new String[] {"pipDual", "pipFirst", "pipSecond", "pipThird", "pipFourth"}) {
            assertTrue(PipEdgeTrim.isPipKey(key), key);
        }
        for (String key : new String[] {"date", "music", "radio", "stats", "appStats"}) {
            assertFalse(PipEdgeTrim.isPipKey(key), key);
        }
    }
}
