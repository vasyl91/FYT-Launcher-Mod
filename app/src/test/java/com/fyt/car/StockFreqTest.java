package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockFreqTest {

    @Test
    void fmIsInTensOfKilohertz() {
        assertEquals("101.50", StockFreq.format(10150));
        assertEquals("87.50", StockFreq.format(8750));
        assertEquals("108.00", StockFreq.format(10800));
        assertEquals("98.05", StockFreq.format(9805));
    }

    @Test
    void amIsInKilohertz() {
        assertEquals("1008", StockFreq.format(1008));
        assertEquals("531", StockFreq.format(531));
    }

    @Test
    void aboveFiveThousandIsFm() {
        assertTrue(StockFreq.isFm(8750));
        assertTrue(StockFreq.isFm(5001));
        assertFalse(StockFreq.isFm(5000));
        assertFalse(StockFreq.isFm(1008));
    }

    @Test
    void aStationWithoutANameIsItsFrequency() {
        assertEquals("FM 101.50", StockFreq.title(10150));
        assertEquals("AM 1008", StockFreq.title(1008));
        assertEquals("FM 101.50 MHz", StockFreq.titleWithUnit(10150));
        assertEquals("AM 1008 kHz", StockFreq.titleWithUnit(1008));
        assertEquals("FM", StockFreq.band(8750));
        assertEquals("AM", StockFreq.band(603));
    }

    @Test
    void filesWriteAFrequencyInManyWays() {
        assertTrue(StockFreq.sameFrequency("101.50", 10150));
        assertTrue(StockFreq.sameFrequency("101.5", 10150));
        assertTrue(StockFreq.sameFrequency(" 87.5 ", 8750));
        assertTrue(StockFreq.sameFrequency("87,50", 8750));
        assertTrue(StockFreq.sameFrequency("1008", 1008));
        assertFalse(StockFreq.sameFrequency("101.55", 10150));
        assertFalse(StockFreq.sameFrequency("1007", 1008));
        assertFalse(StockFreq.sameFrequency("", 10150));
        assertFalse(StockFreq.sameFrequency(null, 10150));
        assertFalse(StockFreq.sameFrequency("abc", 10150));
    }

    @Test
    void aLogoFileIsNamedAfterTheStationAndItsFrequency() {
        assertArrayEquals(new String[]{"Radio ZET", "101.50"}, StockFreq.parseLogoFileName("Radio ZET_101.50.png"));
        // The name may have an underscore of its own: the last one separates
        assertArrayEquals(new String[]{"RMF_FM", "96.00"}, StockFreq.parseLogoFileName("RMF_FM_96.00.PNG"));
        assertNull(StockFreq.parseLogoFileName("logo.png"));
        assertNull(StockFreq.parseLogoFileName("_101.50.png"));
        assertNull(StockFreq.parseLogoFileName("Name_.png"));
        assertNull(StockFreq.parseLogoFileName("Name_101.50.jpg"));
        assertNull(StockFreq.parseLogoFileName(null));
    }
}
