package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class WakeDetectionTest {

    private static final String MAPS = "com.google.android.apps.maps";
    private static final String DOCS = "com.google.android.apps.docs";

    @Test
    void withTheHomeScreenOnTopWhateverComSyuMsNotedGoesBack() {
        assertEquals(Collections.singleton(MAPS),
                WakeDetection.restoreToWatch(Collections.singleton(MAPS), true, DOCS));
        assertEquals(Collections.singleton(MAPS),
                WakeDetection.restoreToWatch(Collections.singleton(MAPS), true, null));
    }

    @Test
    void withTheOptionOffTheAppInFrontAtTheSleepIsWhatTheWakeIsFor() {
        // The home screen was in front, com.syu.ms took the pane app for its top app.
        assertEquals(Collections.singleton(MAPS),
                WakeDetection.restoreToWatch(Collections.singleton(MAPS), false, ""));
        // An app was in front, and com.syu.ms opens it again: as it should.
        assertTrue(WakeDetection.restoreToWatch(Collections.singleton(DOCS), false, DOCS).isEmpty());
        Set<String> both = new HashSet<>(Arrays.asList(MAPS, DOCS));
        assertEquals(Collections.singleton(MAPS), WakeDetection.restoreToWatch(both, false, DOCS));
    }

    @Test
    void whatIsNotKnownIsNotWatchedFor() {
        assertTrue(WakeDetection.restoreToWatch(null, true, "").isEmpty());
        assertTrue(WakeDetection.restoreToWatch(Collections.singleton(MAPS), false, null).isEmpty());
        assertTrue(WakeDetection.restoreToWatch(Collections.emptySet(), true, "").isEmpty());
    }
}
