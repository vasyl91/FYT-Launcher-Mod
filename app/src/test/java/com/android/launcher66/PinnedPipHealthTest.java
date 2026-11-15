package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PinnedPipHealthTest {

    @Test
    void theAppInFrontInPlaceOfTheLauncherIsAFailedStart() {
        assertTrue(PinnedPipHealth.failed(true, false, false));
    }

    @Test
    void aPinnedPipOverTheLauncherIsNoFailure() {
        // The unit where it works: the launcher stays in front, the pinned task covers nothing
        assertFalse(PinnedPipHealth.failed(false, true, false));
        assertFalse(PinnedPipHealth.failed(true, true, false));
    }

    @Test
    void anAppTheUserOpenedFullScreenIsNoFailure() {
        assertFalse(PinnedPipHealth.failed(true, false, true));
    }

    @Test
    void threeFailedStartsInARowAreToldOnce() {
        PinnedPipHealth health = new PinnedPipHealth();
        assertFalse(health.note(true));
        assertFalse(health.note(true));
        assertTrue(health.note(true));
        assertFalse(health.note(true));
        assertEquals(4, health.failuresInARow());
    }

    @Test
    void oneStartThatLandsBeginsTheCountAgain() {
        PinnedPipHealth health = new PinnedPipHealth();
        health.note(true);
        health.note(true);
        assertFalse(health.note(false));
        assertEquals(0, health.failuresInARow());
        assertFalse(health.note(true));
        assertFalse(health.note(true));
        assertTrue(health.note(true));
    }
}
