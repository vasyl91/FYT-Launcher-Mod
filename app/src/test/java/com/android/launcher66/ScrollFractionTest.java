package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScrollFractionTest {

    @Test
    void theFractionIsTheShareOfTheWayScrolled() {
        // 4200 px of rows, 1400 in view: 2800 px of way
        assertEquals(0f, ScrollFraction.of(0, 4200, 1400), 0f);
        assertEquals(0.25f, ScrollFraction.of(700, 4200, 1400), 0.0001f);
        assertEquals(1f, ScrollFraction.of(2800, 4200, 1400), 0f);
        assertEquals(1f, ScrollFraction.of(3000, 4200, 1400), 0f, "past the end is the end");
    }

    @Test
    void theOffsetOfAFractionIsItsInverse() {
        assertEquals(700, ScrollFraction.offsetFor(0.25f, 4200, 1400));
        assertEquals(1401, ScrollFraction.offsetFor(0.5004f, 4200, 1400), "any pixel, not the start of a row");
        assertEquals(0, ScrollFraction.offsetFor(-1f, 4200, 1400));
        assertEquals(2800, ScrollFraction.offsetFor(2f, 4200, 1400));
    }

    @Test
    void aListWhoseRowsAllShowDoesNotScroll() {
        assertFalse(ScrollFraction.scrolls(1000, 1400));
        assertFalse(ScrollFraction.scrolls(1400, 1400));
        assertTrue(ScrollFraction.scrolls(1401, 1400));
        assertEquals(0f, ScrollFraction.of(0, 1000, 1400), 0f);
        assertEquals(0, ScrollFraction.offsetFor(0.7f, 1000, 1400));
    }
}
