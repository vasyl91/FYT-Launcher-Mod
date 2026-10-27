package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.WakeDetection.HostWait;

import org.junit.jupiter.api.Test;

class WakeDetectionHostWaitTest {

    // hostWait(vdPanesConfigured, panesAwaitHost, hostExpected)

    @Test
    void panesThatAreNotVdViewsDoNotWaitForAHost() {
        assertEquals(HostWait.NONE, WakeDetection.hostWait(false, true, true));
    }

    @Test
    void withAHostThereTheLoopIsAsBefore() {                          // A55, Redmi, 7862
        assertEquals(HostWait.NONE, WakeDetection.hostWait(true, false, false));
        assertEquals(HostWait.NONE, WakeDetection.hostWait(true, false, true));
    }

    @Test
    void aHostOnItsWayIsWaitedForWithoutUsingAnAttempt() {            // 7870 after a boot
        assertEquals(HostWait.WAIT, WakeDetection.hostWait(true, true, true));
    }

    @Test
    void noHostAndNoneExpectedEndsTheLoopQuietly() {
        assertEquals(HostWait.NO_HOST, WakeDetection.hostWait(true, true, false));
    }

    @Test
    void pinnedThirdAndFourthPanesAreNotVdViews() {
        assertFalse(WakeDetection.vdPanesConfigured(false, false, false, true, true, true, true));
        assertTrue(WakeDetection.vdPanesConfigured(false, false, false, true, false, false, false));
        assertTrue(WakeDetection.vdPanesConfigured(false, false, false, false, false, true, false));
        assertTrue(WakeDetection.vdPanesConfigured(true, false, false, false, false, false, false));
        assertTrue(WakeDetection.vdPanesConfigured(false, true, false, false, false, false, false));
        assertTrue(WakeDetection.vdPanesConfigured(false, false, true, false, false, false, false));
        assertFalse(WakeDetection.vdPanesConfigured(false, false, false, false, false, false, false));
    }
}
