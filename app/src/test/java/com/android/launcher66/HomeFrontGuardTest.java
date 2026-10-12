package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class HomeFrontGuardTest {

    private static final long NOW = 100_000L;

    @Test
    void systemAppsAndHeadUnitAppsAreNeverPulledBackOver() {
        assertTrue(HomeFrontGuard.isProtected("com.android.systemui"));
        assertTrue(HomeFrontGuard.isProtected("com.syu.bt"));
        assertTrue(HomeFrontGuard.isProtected("com.syu.carlink"));
        assertTrue(HomeFrontGuard.isProtected("vasyl.fytrating"));
    }

    @Test
    void cameraAppsAreProtectedByName() {
        assertTrue(HomeFrontGuard.isProtected("com.syu.camera360"));
        assertTrue(HomeFrontGuard.isProtected("com.example.BackCar"));
        assertTrue(HomeFrontGuard.isProtected("com.fyt.reverse.view"));
        assertTrue(HomeFrontGuard.isCameraPackage("com.syu.panoramic"));
    }

    @Test
    void ordinaryAppsAndAnUnknownCoverAreNot() {
        assertFalse(HomeFrontGuard.isProtected("com.google.android.apps.maps"));
        assertFalse(HomeFrontGuard.isProtected("com.syu.music"));
        assertFalse(HomeFrontGuard.isProtected(""));
    }

    @Test
    void aTouchOrButtonShortlyBeforeTheCoverMakesItTheUsers() {
        long latency = HomeFrontGuard.USER_LAUNCH_LATENCY_MS;
        assertTrue(HomeFrontGuard.isUsersLaunch(NOW - 100L, NOW));
        assertTrue(HomeFrontGuard.isUsersLaunch(NOW - latency, NOW));
        assertTrue(HomeFrontGuard.isUsersLaunch(NOW + 500L, NOW));          // touched it since
        assertFalse(HomeFrontGuard.isUsersLaunch(NOW - latency - 1L, NOW));  // long before
        assertFalse(HomeFrontGuard.isUsersLaunch(0L, NOW));                  // never
    }

    @Test
    void onlyTheExpectedAppWithinItsTimeIsTheDevicesOwn() {
        HomeFrontGuard.Expectations expected = new HomeFrontGuard.Expectations();
        expected.add(Arrays.asList("com.google.android.apps.maps", "com.spotify.music"),
                NOW + 3000L, true, "restore", NOW);

        assertNotNull(expected.match("com.spotify.music", NOW + 1000L));
        assertNull(expected.match("com.syu.radio", NOW + 1000L));            // another app
        assertNull(expected.match("com.spotify.music", NOW + 3001L));        // too late
        assertNull(expected.match("", NOW + 1000L));                         // cannot be seen
    }

    @Test
    void anExpectationForOneLaunchIsUsedUp() {
        HomeFrontGuard.Expectations expected = new HomeFrontGuard.Expectations();
        expected.add(Arrays.asList("com.google.android.apps.maps", "com.spotify.music"),
                NOW + 3000L, true, "restore", NOW);

        HomeFrontGuard.Expectations.Entry entry = expected.match("com.google.android.apps.maps", NOW);
        expected.use(entry);
        // The same app opened again (say with a button) is no longer the device's.
        assertNull(expected.match("com.google.android.apps.maps", NOW + 500L));
        assertNull(expected.match("com.spotify.music", NOW + 500L));
        assertEquals(0L, expected.lastUntil());
    }

    @Test
    void theColdBootPhaseTakesAnyAppAndStaysOpen() {
        HomeFrontGuard.Expectations expected = new HomeFrontGuard.Expectations();
        expected.add(Collections.singleton(HomeFrontGuard.ANY_APP), NOW + 20_000L, false,
                "cold boot", NOW);

        HomeFrontGuard.Expectations.Entry entry = expected.match("com.syu.radio", NOW + 5000L);
        assertNotNull(entry);
        expected.use(entry);
        assertNotNull(expected.match("", NOW + 6000L));                      // cannot be seen
        assertNull(expected.match("com.syu.radio", NOW + 20_001L));          // after the boot
        assertEquals(NOW + 20_000L, expected.lastUntil());
    }

    @Test
    void anExpectationNamingTheAppComesBeforeOneForAnyApp() {
        HomeFrontGuard.Expectations expected = new HomeFrontGuard.Expectations();
        expected.add(Collections.singleton(HomeFrontGuard.ANY_APP), NOW + 20_000L, false,
                "cold boot", NOW);
        expected.add(Collections.singleton("com.syu.music"), NOW + 3000L, true, "PiP reset", NOW);

        HomeFrontGuard.Expectations.Entry entry = expected.match("com.syu.music", NOW + 1000L);
        assertNotNull(entry);
        assertEquals("PiP reset", entry.reason);
        HomeFrontGuard.Expectations.Entry any = expected.match("com.syu.radio", NOW + 1000L);
        assertSame(any, expected.match("", NOW + 1000L));
        assertEquals("cold boot", any.reason);
    }

    @Test
    void aSleepForgetsEverything() {
        HomeFrontGuard.Expectations expected = new HomeFrontGuard.Expectations();
        expected.add(Collections.singleton("com.syu.music"), NOW + 3000L, true, "restore", NOW);
        expected.clear();
        assertNull(expected.match("com.syu.music", NOW));
        assertEquals(0L, expected.lastUntil());
    }
}
