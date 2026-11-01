package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WakeDetectionSleepPipTest {

    @Test
    void pipWorkIsSkippedInTheFirstSecondsAfterTheSleepSignal() {
        assertTrue(WakeDetection.skipPipForSleep(true, 0L));
        assertTrue(WakeDetection.skipPipForSleep(true, 7_800L));      // onPause came 7.8 s after ACC off
        assertTrue(WakeDetection.skipPipForSleep(true, 29_999L));
    }

    @Test
    void aMissedWakeCannotKeepPipAwayForGood() {
        assertFalse(WakeDetection.skipPipForSleep(true, 30_000L));
        assertFalse(WakeDetection.skipPipForSleep(true, 10L * 60_000L));
    }

    @Test
    void awakeNothingIsSkipped() {
        assertFalse(WakeDetection.skipPipForSleep(false, 0L));
        assertFalse(WakeDetection.skipPipForSleep(false, 5_000L));
    }
}
