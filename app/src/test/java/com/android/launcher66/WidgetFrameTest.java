package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WidgetFrameTest {

    @Test
    void aFrameIsFractionsOfThePageAndGoesBackToPixels() {
        WidgetFrame f = WidgetFrame.ofPixels(100, 50, 600, 350, 1000, 500);
        assertEquals(0.1f, f.left, 0.0001f);
        assertEquals(0.1f, f.top, 0.0001f);
        assertEquals(0.6f, f.right, 0.0001f);
        assertEquals(0.7f, f.bottom, 0.0001f);
        assertArrayEquals(new int[] {100, 50, 600, 350}, f.toPixels(1000, 500));
        // the screen turned: the same fractions in another area
        assertArrayEquals(new int[] {50, 100, 300, 700}, f.toPixels(500, 1000));
    }

    @Test
    void theFrameIsPushedBackInsideThePageWithItsSizeKept() {
        WidgetFrame outside = new WidgetFrame(0.8f, -0.1f, 1.2f, 0.3f);
        WidgetFrame fit = outside.fit(1000, 500, 0, 0);
        assertEquals(0.4f, fit.width(), 0.0001f);
        assertEquals(0.4f, fit.height(), 0.0001f);
        assertEquals(0.6f, fit.left, 0.0001f);
        assertEquals(1.0f, fit.right, 0.0001f);
        assertEquals(0f, fit.top, 0.0001f);
    }

    @Test
    void theFrameIsNeverSmallerThanTheProvidersMinimumButNotLargerThanThePage() {
        WidgetFrame small = new WidgetFrame(0.1f, 0.1f, 0.15f, 0.15f);
        WidgetFrame fit = small.fit(1000, 500, 200, 100);
        assertEquals(0.2f, fit.width(), 0.0001f);
        assertEquals(0.2f, fit.height(), 0.0001f);
        WidgetFrame huge = small.fit(1000, 500, 5000, 5000);
        assertEquals(1f, huge.width(), 0.0001f);
        assertEquals(1f, huge.height(), 0.0001f);
        assertEquals(0f, huge.left, 0.0001f);
    }

    @Test
    void theNearestCellsAreAtLeastOneEachWayAndInsideTheGrid() {
        // a 10 by 6 grid
        assertArrayEquals(new int[] {1, 1, 4, 3}, new WidgetFrame(0.1f, 1f / 6f, 0.5f, 4f / 6f).snap(10, 6));
        assertArrayEquals(new int[] {3, 2, 1, 1}, new WidgetFrame(0.31f, 0.34f, 0.32f, 0.35f).snap(10, 6));
        assertArrayEquals(new int[] {9, 5, 1, 1}, new WidgetFrame(0.99f, 0.99f, 1f, 1f).snap(10, 6));
        assertArrayEquals(new int[] {0, 0, 10, 6}, new WidgetFrame(0f, 0f, 1f, 1f).snap(10, 6));
    }

    @Test
    void theFrameOfSomeCellsSnapsBackToThem() {
        WidgetFrame f = WidgetFrame.ofCells(2, 1, 3, 2, 10, 6);
        assertArrayEquals(new int[] {2, 1, 3, 2}, f.snap(10, 6));
    }

    @Test
    void theStoredTextRoundTripsAndABadOneIsNoFrame() {
        WidgetFrame f = new WidgetFrame(0.125f, 0.25f, 0.5f, 0.75f);
        assertEquals("0.12500,0.25000,0.50000,0.75000", f.format());
        WidgetFrame back = WidgetFrame.parse(f.format());
        assertEquals(0.125f, back.left, 0.00001f);
        assertEquals(0.75f, back.bottom, 0.00001f);
        assertNull(WidgetFrame.parse(null));
        assertNull(WidgetFrame.parse(""));
        assertNull(WidgetFrame.parse("1,2,3"));
        assertNull(WidgetFrame.parse("a,b,c,d"));
        assertNull(WidgetFrame.parse("0.5,0.5,0.4,0.9"));   // right before left
        assertNull(WidgetFrame.parse("0.1,0.5,0.4,NaN"));
        assertTrue(WidgetFrame.parse(" 0.1, 0.2, 0.3, 0.4 ") != null);
    }
}
