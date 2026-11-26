package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppsGridTest {

    @Test
    void theDefaultsAreWhatTheDrawerAlwaysHad() {
        assertEquals(7, AppsGrid.rows(false, AppsGrid.DEFAULT_LONG, AppsGrid.DEFAULT_SHORT));
        assertEquals(4, AppsGrid.columns(false, AppsGrid.DEFAULT_LONG, AppsGrid.DEFAULT_SHORT));
        assertEquals(4, AppsGrid.rows(true, AppsGrid.DEFAULT_LONG, AppsGrid.DEFAULT_SHORT));
        assertEquals(7, AppsGrid.columns(true, AppsGrid.DEFAULT_LONG, AppsGrid.DEFAULT_SHORT));
    }

    @Test
    void theSameScreenKeepsTheSameGridWhenItIsTurned() {
        // 9 along the long edge and 3 along the short one: upright 9 rows by 3 columns, across 3 by 9
        assertEquals(9, AppsGrid.rows(false, 9, 3));
        assertEquals(3, AppsGrid.columns(false, 9, 3));
        assertEquals(3, AppsGrid.rows(true, 9, 3));
        assertEquals(9, AppsGrid.columns(true, 9, 3));
    }

    @Test
    void theLimitsAreThreeToTwelveAndTwoToEight() {
        assertEquals(3, AppsGrid.clampLong(0));
        assertEquals(12, AppsGrid.clampLong(40));
        assertEquals(2, AppsGrid.clampShort(-5));
        assertEquals(8, AppsGrid.clampShort(99));
        assertEquals(12, AppsGrid.rows(false, 100, 100));
        assertEquals(8, AppsGrid.columns(false, 100, 100));
    }
}
