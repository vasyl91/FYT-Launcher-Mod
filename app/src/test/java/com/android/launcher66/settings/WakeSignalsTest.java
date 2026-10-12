package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WakeSignalsTest {

    private static final long NOW = 3_600_000L;

    @Test
    void blackScreenBlocksTheScreenSignalsWhileOn() {
        assertTrue(WakeSignals.blackScreenBlocks(true, 0L, NOW));
        assertFalse(WakeSignals.blackScreenBlocks(false, 0L, NOW));   // never had one
    }

    @Test
    void blackScreenStillBlocksForItsGraceAfterItEnded() {
        long grace = WakeSignals.BLACK_SCREEN_GRACE_MS;
        assertTrue(WakeSignals.blackScreenBlocks(false, NOW - 1L, NOW));
        assertTrue(WakeSignals.blackScreenBlocks(false, NOW - grace + 1L, NOW));
        assertFalse(WakeSignals.blackScreenBlocks(false, NOW - grace, NOW));
        assertFalse(WakeSignals.blackScreenBlocks(false, NOW - 60_000L, NOW));
    }

    @Test
    void accOffBlocksAScreenWakeUntilTheCpuHasBeenSuspended() {
        long suspend = WakeSignals.SUSPEND_MIN_MS;
        assertTrue(WakeSignals.accBlocksWake(0, 0L));
        assertTrue(WakeSignals.accBlocksWake(0, suspend - 1L));
        assertFalse(WakeSignals.accBlocksWake(0, suspend));            // slept since: a real wake
        assertFalse(WakeSignals.accBlocksWake(1, 0L));                 // ACC on
        assertFalse(WakeSignals.accBlocksWake(-1, 0L));                // no ACC (a phone)
    }

    @Test
    void theBootIdDecidesWhetherAKeptStateIsOfThisBoot() {
        assertTrue(WakeSignals.isSameBoot("a1", "a1", 50_000L, 10_000L));
        assertFalse(WakeSignals.isSameBoot("b2", "a1", 50_000L, 900_000L));
    }

    @Test
    void withoutABootIdTheMonotonicClockDecides() {
        assertTrue(WakeSignals.isSameBoot(null, "a1", 50_000L, 90_000L));
        assertTrue(WakeSignals.isSameBoot(null, null, 50_000L, 50_000L));
        assertFalse(WakeSignals.isSameBoot(null, null, 50_000L, 40_000L));   // clock went back: rebooted
        assertFalse(WakeSignals.isSameBoot("a1", null, 0L, 90_000L));        // nothing kept yet
    }
}
