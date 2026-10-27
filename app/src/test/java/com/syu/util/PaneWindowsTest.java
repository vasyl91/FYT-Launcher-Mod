package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PaneWindowsTest {

    @Test
    void thePublicApiStartsWithAndroid14() {
        assertFalse(PaneWindows.usesPublicApi(33));
        assertTrue(PaneWindows.usesPublicApi(34));
    }

    @Test
    void androidBeforeAndAfterTheBoundaryIsDecidedBySdkAlone() {
        assertFalse(PaneWindows.usesPublicApi(29)); // the 7862
        assertFalse(PaneWindows.usesPublicApi(33)); // the 7870
        assertTrue(PaneWindows.usesPublicApi(36));  // the A55
    }
}
