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
    void horizontalBarCutsOnlyTheBottomEdge() {
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
        // the bar rule counts a shared edge as a collision.
        assertEquals(999, PipEdgeTrim.maxBottom(1000, 0));
        assertEquals(995, PipEdgeTrim.maxBottom(1000, 5));
    }

    @Test
    void verticalBarCutsOnlyTheRightEdge() {
        // box 2000 wide, vertical bar 142, margin 5 -> right edge limited to 1853
        int maxRight = PipEdgeTrim.maxRight(2000, 142f, 5);
        assertEquals(1853, maxRight);
        assertTrue(maxRight + 142 <= 2000 - 5);
        assertArrayEquals(new int[] {1000, 100, 1853, 600},
                PipEdgeTrim.trim(1000, 100, 1900, 600, maxRight, NO, 528, 360));
    }

    @Test
    void fractionalVerticalBarWidthRoundsTheLimitDown() {
        int maxRight = PipEdgeTrim.maxRight(1920, 136.32f, 5);
        assertEquals(1778, maxRight);
        assertTrue(maxRight + 136.32f <= 1920 - 5);
        assertTrue((maxRight + 1) + 136.32f > 1920 - 5);
    }

    @Test
    void verticalBarCutBelowTheMinimumWidthFallsBack() {
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
    void landscapeVerticalBarIs7Point1PercentOfTheBoxWidth() {
        assertEquals(142f, PipEdgeTrim.computeVerticalBarWidth(false, 2000, 1200, 196), 0f);
        // Must stay bit-identical to the previous screenWidth * 0.071f.
        assertEquals(1920 * 0.071f, PipEdgeTrim.computeVerticalBarWidth(false, 1920, 720, 118), 0f);
        assertEquals((int) (1920 * 0.071f), (int) PipEdgeTrim.computeVerticalBarWidth(false, 1920, 720, 118));
    }

    @Test
    void portraitVerticalBarIs7Point1PercentOfTheHeightAboveTheBar() {
        // XML: W,0.071 with the bar running from the top of the box down to the horizontal bar.
        int rootWidth = 1200;
        int rootHeight = 1900;
        int barHeight = (int) (rootWidth * 0.142);
        assertEquals((rootHeight - barHeight) * 0.071f,
                PipEdgeTrim.computeVerticalBarWidth(true, rootWidth, rootHeight, barHeight), 0.0001f);
        assertEquals(0f, PipEdgeTrim.computeVerticalBarWidth(true, rootWidth, 100, 500), 0f);
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

    @Test
    void trimmableKeys() {
        for (String key : new String[] {"pipDual", "pipFirst", "pipSecond", "pipThird", "pipFourth",
                "date", "music", "radio"}) {
            assertTrue(PipEdgeTrim.isTrimmableKey(key), key);
        }
        for (String key : new String[] {"stats", "appStats", "", null}) {
            assertFalse(PipEdgeTrim.isTrimmableKey(key), String.valueOf(key));
        }
    }

    @Test
    void dateWidgetCutAtTheHorizontalBarKeepsItsMinimumHeight() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(2000, 1200);
        int maxBottom = PipEdgeTrim.maxBottom(1000, 5);
        // 400 high, bar eats 45 of it: still above the minimum height (144)
        assertArrayEquals(new int[] {10, 600, 10 + m.dateMinWidth, 995},
                PipEdgeTrim.trim(10, 600, 10 + m.dateMinWidth, 1040, NO, maxBottom,
                        m.dateMinWidth, m.dateMinHeight));
    }

    @Test
    void radioWidgetThatWouldDropBelowItsMinimumIsNotCut() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(2000, 1200);
        int maxBottom = PipEdgeTrim.maxBottom(1000, 5);
        int top = maxBottom - m.radioMinHeight + 1; // one pixel short after the cut
        assertNull(PipEdgeTrim.trim(10, top, 10 + m.radioMinWidth, top + m.radioMinHeight + 40,
                NO, maxBottom, m.radioMinWidth, m.radioMinHeight));
        // exactly the minimum is still fine
        assertArrayEquals(new int[] {10, top - 1, 10 + m.radioMinWidth, maxBottom},
                PipEdgeTrim.trim(10, top - 1, 10 + m.radioMinWidth, top + m.radioMinHeight + 40,
                        NO, maxBottom, m.radioMinWidth, m.radioMinHeight));
    }

    @Test
    void musicWidgetCutAtTheVerticalBarWithinItsMinimumWidth() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(2000, 1200);
        int maxRight = PipEdgeTrim.maxRight(2000, 142f, 5); // 1853
        assertArrayEquals(new int[] {1500, 100, maxRight, 100 + m.musicMinHeight},
                PipEdgeTrim.trim(1500, 100, 1900, 100 + m.musicMinHeight, maxRight, NO,
                        m.musicMinWidth, m.musicMinHeight));
        // left edge so far right that the cut leaves less than the minimum width
        int left = maxRight - m.musicMinWidth + 1;
        assertNull(PipEdgeTrim.trim(left, 100, left + 400, 100 + m.musicMinHeight, maxRight, NO,
                m.musicMinWidth, m.musicMinHeight));
    }

    @Test
    void widgetEntirelyUnderTheBarIsNotCut() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(2000, 1200);
        int maxBottom = PipEdgeTrim.maxBottom(1000, 5);
        assertNull(PipEdgeTrim.trim(10, 1010, 10 + m.dateMinWidth, 1200, NO, maxBottom, 0, 0));
    }
}
