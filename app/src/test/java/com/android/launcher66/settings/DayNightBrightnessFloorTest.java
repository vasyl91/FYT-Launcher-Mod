package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DayNightBrightnessFloorTest {

    @Test
    void anFytUnitBut7870KeepsLevelZero() {
        assertEquals(0, DayNightBrightness.floorFytLevel(0, false));
        assertEquals(37, DayNightBrightness.floorFytLevel(37, false));
    }

    @Test
    void the7870NeverGoesBelowTen() {
        assertEquals(10, DayNightBrightness.floorFytLevel(0, true));
        assertEquals(10, DayNightBrightness.floorFytLevel(9, true));
        assertEquals(50, DayNightBrightness.floorFytLevel(50, true));
    }

    @Test
    void aPhoneNeverGoesBelowTen() {
        assertEquals(10, DayNightBrightness.floorSystemValue(0));
        assertEquals(255, DayNightBrightness.floorSystemValue(255));
    }
}
