package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScrollerSizeTest {

    @Test
    void theA55KeepsItsSizes() {
        assertEquals(2.8125f, ScrollerSize.unit(1080, 2.8125f), 0.001f);
    }

    @Test
    void the7862GetsItAsThickAgainstItsScreenAsTheA55() {
        float unit = ScrollerSize.unit(1200, 1.5f);
        assertEquals(3.125f, unit, 0.001f);
        // the handle, 6 dp: the same share of the shorter side as on the A55
        assertEquals(6f * 2.8125f / 1080f, 6f * unit / 1200f, 0.0001f);
    }

    @Test
    void neverThinnerThanItsDp() {
        assertEquals(3f, ScrollerSize.unit(1080, 3f), 0f);
        assertEquals(2f, ScrollerSize.unit(0, 2f), 0f);
        assertTrue(ScrollerSize.unit(1600, 2f) > 2f);
    }
}
