package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RectOverlapTest {

    @Test
    void aCommonEdgeIsNotOverlapping() {
        // A's right edge and B's left edge on 348
        assertFalse(RectOverlap.overlaps(100, 100, 348, 300, 348, 100, 600, 300));
        assertFalse(RectOverlap.overlaps(348, 100, 600, 300, 100, 100, 348, 300));
        // the top and the bottom
        assertFalse(RectOverlap.overlaps(100, 100, 300, 200, 100, 200, 300, 400));
        assertFalse(RectOverlap.overlaps(100, 200, 300, 400, 100, 100, 300, 200));
    }

    @Test
    void aCommonCornerIsNotOverlapping() {
        assertFalse(RectOverlap.overlaps(100, 100, 200, 200, 200, 200, 300, 300));
        assertFalse(RectOverlap.overlaps(200, 200, 300, 300, 100, 100, 200, 200));
        assertFalse(RectOverlap.overlaps(100, 200, 200, 300, 200, 100, 300, 200));
    }

    @Test
    void anOverlapOfOnePixelIsOverlapping() {
        assertTrue(RectOverlap.overlaps(100, 100, 349, 300, 348, 100, 600, 300));
        assertTrue(RectOverlap.overlaps(100, 100, 300, 201, 100, 200, 300, 400));
        assertTrue(RectOverlap.overlaps(100, 100, 201, 201, 200, 200, 300, 300));
    }

    @Test
    void oneInsideTheOtherIsOverlappingAndAGapIsNot() {
        assertTrue(RectOverlap.overlaps(100, 100, 500, 500, 200, 200, 300, 300));
        assertTrue(RectOverlap.overlaps(200, 200, 300, 300, 100, 100, 500, 500));
        assertFalse(RectOverlap.overlaps(100, 100, 200, 200, 210, 100, 300, 200));
    }
}
