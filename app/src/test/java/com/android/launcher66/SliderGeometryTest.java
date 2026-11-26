package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SliderGeometryTest {

    @Test
    void theKnobIsSixTenthsOfTheRowAndNeverBelowTwoPixels() {
        assertEquals(24, SliderGeometry.knobPx(40));
        assertEquals(36, SliderGeometry.knobPx(60));
        assertEquals(2, SliderGeometry.knobPx(1));
        assertEquals(2, SliderGeometry.knobPx(0));
    }

    @Test
    void theLineIsAQuarterOfTheKnobButNotThinnerThanTwoDp() {
        // a knob of 48 px: a quarter is 12 px, above two dp at 2.0 (4 px)
        assertEquals(12, SliderGeometry.linePx(48, 2f));
        // a small knob: the two dp are the line
        assertEquals(4, SliderGeometry.linePx(10, 2f));
        assertEquals(6, SliderGeometry.linePx(10, 3f));
        assertTrue(SliderGeometry.linePx(0, 0f) >= 1);
    }
}
