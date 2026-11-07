package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.android.launcher66.settings.PipEdgeTrim;

import org.junit.jupiter.api.Test;

class EdgeHandleGeometryTest {

    @Test
    void landscapeWindowIsAsWideAsTheVerticalBar() {
        float verticalBar = PipEdgeTrim.computeVerticalBarWidth(false, 1280, 720, 100);
        assertEquals(91, Math.round(verticalBar));
        assertEquals(91, EdgeHandleGeometry.touchWidth(13, verticalBar));
    }

    @Test
    void portraitWindowIsAsWideAsTheVerticalBar() {
        float verticalBar = PipEdgeTrim.computeVerticalBarWidth(true, 1080, 2340, 105);
        // 7.1 % of the height above the bar: (2340 - 105) * 0.071
        assertEquals(159, Math.round(verticalBar));
        assertEquals(159, EdgeHandleGeometry.touchWidth(23, verticalBar));
    }

    @Test
    void windowIsNeverNarrowerThanTheStrip() {
        assertEquals(13, EdgeHandleGeometry.touchWidth(13, 5f));
        assertEquals(13, EdgeHandleGeometry.touchWidth(13, 0f));
    }
}
