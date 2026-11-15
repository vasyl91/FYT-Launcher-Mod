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
}
