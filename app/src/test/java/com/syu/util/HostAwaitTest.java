package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HostAwaitTest {

    // expected(systemUid, attached, moduleInstalled, shizukuInstalled, shizukuDeniedForGood)

    @Test
    void aSystemLauncherIsItsOwnHostAndWaitsForNothing() {          // FYT 7862
        assertFalse(HostAwait.expected(true, false, false, false, false));
        assertFalse(HostAwait.expected(true, false, true, true, false));
    }

    @Test
    void aHostThatIsAttachedIsNotOnItsWay() {                       // A55, Redmi after the start
        assertFalse(HostAwait.expected(false, true, true, true, false));
        assertFalse(HostAwait.expected(false, true, false, true, false));
    }

    @Test
    void theModuleDaemonIsAlwaysExpected() {                        // Redmi Note 8T, root
        assertTrue(HostAwait.expected(false, false, true, false, false));
        assertTrue(HostAwait.expected(false, false, true, true, true));
    }

    @Test
    void shizukuInstalledAndNotRefusedIsExpected() {                // the 7870 after a boot
        assertTrue(HostAwait.expected(false, false, false, true, false));
    }

    @Test
    void shizukuRefusedForGoodIsNotWaitedFor() {
        assertFalse(HostAwait.expected(false, false, false, true, true));
    }

    @Test
    void withNothingInstalledNothingIsExpected() {
        assertFalse(HostAwait.expected(false, false, false, false, false));
    }

    @Test
    void theWindowIsTheBootsWhileBootingAndTheWakesAfter() {
        assertTrue(HostAwait.windowForUptime(20_000L) == HostAwait.WAIT_COLD_BOOT_MS);
        assertTrue(HostAwait.windowForUptime(179_999L) == HostAwait.WAIT_COLD_BOOT_MS);
        assertTrue(HostAwait.windowForUptime(180_000L) == HostAwait.WAIT_WAKE_MS);
        assertTrue(HostAwait.windowForUptime(3_600_000L) == HostAwait.WAIT_WAKE_MS);
    }
}
