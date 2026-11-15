package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HiddenApiProbeTest {

    /** Everything is there except what the set names ("class" or "class#method"). */
    private static HiddenApiProbe.Lookup without(String... gone) {
        final Set<String> missing = new HashSet<>(Arrays.asList(gone));
        return new HiddenApiProbe.Lookup() {
            @Override
            public boolean classExists(String className) {
                return !missing.contains(className);
            }

            @Override
            public boolean methodExists(String className, String method) {
                return !missing.contains(className + "#" + method);
            }
        };
    }

    @Test
    void withEverythingThereNothingIsMissing() {
        assertEquals(Collections.emptyList(), HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 29, without()));
        assertEquals(Collections.emptyList(), HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 36, without()));
    }

    @Test
    void thePaneViewIsLookedForOnlyWhereTheLauncherUsesIt() {
        // Android 10: the panes are ActivityView. Android 11 and later: the launcher's own displays.
        List<String> onTen = HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 29, without("android.app.ActivityView"));
        assertEquals(1, onTen.size());
        assertTrue(onTen.get(0).contains("android.app.ActivityView"));
        assertEquals(Collections.emptyList(),
                HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 30, without("android.app.ActivityView")));
    }

    @Test
    void aMethodThatWasRenamedIsNamedWithItsFeature() {
        List<String> missing = HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 34,
                without("android.hardware.input.InputManager#monitorGestureInput"));
        assertEquals(Collections.singletonList(
                "touch monitor: android.hardware.input.InputManager#monitorGestureInput"), missing);
    }

    @Test
    void aMethodOfAClassThatIsGoneIsMissingToo() {
        List<String> missing = HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 34,
                without("android.hardware.input.InputManager"));
        assertEquals(Arrays.asList("touch monitor: android.hardware.input.InputManager#getInstance",
                "touch monitor: android.hardware.input.InputManager#monitorGestureInput"), missing);
    }

    @Test
    void theMonitorIsNotLookedForBeforeAndroid10() {
        assertEquals(Collections.emptyList(), HiddenApiProbe.missing(HiddenApiProbe.CHECKS, 28,
                without("android.hardware.input.InputManager#monitorGestureInput")));
    }

    @Test
    void aReportIsWrittenOncePerChangeOfWhatIsMissing() {
        assertFalse(HiddenApiProbe.reportDue("", ""));
        assertTrue(HiddenApiProbe.reportDue("34:[a]", ""));
        assertFalse(HiddenApiProbe.reportDue("34:[a]", "34:[a]"));
        assertTrue(HiddenApiProbe.reportDue("35:[a]", "34:[a]"));
        // Everything back: nothing to report, and the next loss is reported again
        assertFalse(HiddenApiProbe.reportDue("", "34:[a]"));
    }
}
