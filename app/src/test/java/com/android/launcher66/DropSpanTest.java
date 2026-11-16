package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DropSpanTest {

    @Test
    void aWidgetCanAlwaysBeDroppedAtTheSizeItHas() {
        // After a denser grid the minimum, counted anew, is larger than the widget
        assertEquals(2, DropSpan.min(3, 2));
        assertEquals(1, DropSpan.min(4, 1));
    }

    @Test
    void aSmallerMinimumIsKept() {
        assertEquals(1, DropSpan.min(1, 3));
        assertEquals(2, DropSpan.min(2, 2));
    }

    @Test
    void withoutAMinimumTheSizeItHasIsTheMinimum() {
        assertEquals(2, DropSpan.min(0, 2));
        assertEquals(1, DropSpan.min(-1, 0));
    }

    @Test
    void anAreaOfNoSizeIsNoArea() {
        // The log of 2026-11-16 01:04:15: "no room at 0,0 (span 0x0)"
        assertFalse(DropSpan.usable(0, 0, 0, 0));
        assertFalse(DropSpan.usable(-1, -1, 2, 2));
        assertTrue(DropSpan.usable(0, 0, 1, 1));
    }
}
