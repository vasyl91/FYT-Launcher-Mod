package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarViewsTest {

    @Test
    void theViewsOfTheWindowThatStaysAreKeptWhenAnAppIsOpened() {
        // the 7862: the bar on every page, its window stays while the app is in front
        assertFalse(BarViews.release(false, true, true, false));
    }

    @Test
    void theyAreLetGoWhenTheLaunchersWindowGoes() {
        assertTrue(BarViews.release(false, true, true, true));
    }

    @Test
    void theAutoHideBarsViewsAreLetGoAsBefore() {
        assertTrue(BarViews.release(true, false, true, false));
        assertTrue(BarViews.release(true, true, true, false));
    }

    @Test
    void theFirstPagesOwnBarAndABarWithoutWidgetsHaveNothingToLetGo() {
        assertFalse(BarViews.release(false, false, true, false));
        assertFalse(BarViews.release(false, true, false, false));
        assertFalse(BarViews.release(true, false, false, true));
    }
}
