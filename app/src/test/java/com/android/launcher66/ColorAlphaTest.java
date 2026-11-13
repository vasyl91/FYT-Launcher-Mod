package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ColorAlphaTest {

    @Test
    void theEndsAreTransparentAndOpaque() {
        assertEquals(0, ColorAlpha.toAlpha(0));
        assertEquals(255, ColorAlpha.toAlpha(100));
        assertEquals(0, ColorAlpha.toPercent(0));
        assertEquals(100, ColorAlpha.toPercent(255));
    }

    @Test
    void everyPercentComesBackAsItself() {
        for (int percent = 0; percent <= 100; percent++) {
            assertEquals(percent, ColorAlpha.toPercent(ColorAlpha.toAlpha(percent)));
        }
    }

    @Test
    void valuesOutsideTheRangeAreBroughtIntoIt() {
        assertEquals(0, ColorAlpha.toAlpha(-5));
        assertEquals(255, ColorAlpha.toAlpha(140));
        assertEquals(100, ColorAlpha.toPercent(999));
    }

    @Test
    void theColourKeepsItsRedGreenAndBlue() {
        assertEquals(0x80123456, ColorAlpha.withPercent(0xFF123456, 50));
        assertEquals(0x00123456, ColorAlpha.withPercent(0xFF123456, 0));
        assertEquals(0xFF123456, ColorAlpha.withPercent(0x00123456, 100));
    }
}
