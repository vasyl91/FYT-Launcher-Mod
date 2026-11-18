package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertTrue;

import android.view.WindowManager;

import org.junit.jupiter.api.Test;

class BarWindowsTest {

    @Test
    void theBarsAreSubWindowsOfTheLauncherBelowEveryOverlay() {
        assertTrue(BarWindows.TYPE >= WindowManager.LayoutParams.FIRST_SUB_WINDOW
                && BarWindows.TYPE <= WindowManager.LayoutParams.LAST_SUB_WINDOW);
        // The floating buttons and the statistics window are overlays: a system layer above every sub-window
        assertTrue(BarWindows.TYPE < WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW);
        assertTrue(BarWindows.TYPE < WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
    }

    @Test
    void thePanesLieUnderTheStatisticsWhichLieUnderTheBarsOnEveryPage() {
        // The sub-window layers: PANEL 1, SUB_PANEL 2, ABOVE_SUB_PANEL 3 (FIRST_SUB_WINDOW + 0, + 2, + 5)
        assertTrue(BarWindows.HOME_STATS_TYPE == WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
        assertTrue(BarWindows.EVERY_PAGE_TYPE == WindowManager.LayoutParams.FIRST_SUB_WINDOW + 5);
        assertTrue(BarWindows.EVERY_PAGE_TYPE <= WindowManager.LayoutParams.LAST_SUB_WINDOW);
        assertTrue(BarWindows.HOME_STATS_TYPE < WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW);
    }
}
