package com.android.launcher66;

import static com.android.launcher66.EdgeHandleInput.Mode.MONITOR;
import static com.android.launcher66.EdgeHandleInput.Mode.WINDOW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EdgeHandleInputTest {

    @Test
    void theMonitorNeedsAndroid10SystemPrivilegesAndAStartedMonitor() {
        for (int sdk = 26; sdk <= 36; sdk++) {
            for (boolean privileges : new boolean[] {false, true}) {
                for (boolean started : new boolean[] {false, true}) {
                    boolean expected = sdk >= 29 && privileges && started;
                    assertEquals(expected ? MONITOR : WINDOW, EdgeHandleInput.mode(sdk, privileges, started),
                            "sdk " + sdk + " privileges " + privileges + " started " + started);
                }
            }
        }
    }

    @Test
    void aMonitorIsOnlyWorthStartingWhereItCanWork() {
        assertFalse(EdgeHandleInput.monitorPossible(28, true));
        assertFalse(EdgeHandleInput.monitorPossible(29, false));
        assertTrue(EdgeHandleInput.monitorPossible(29, true));
        assertTrue(EdgeHandleInput.monitorPossible(34, true));
    }

    @Test
    void theReasonsAreForTheLog() {
        assertEquals("Android 28 has no input monitor", EdgeHandleInput.reason(28, true, false));
        assertEquals("no system privileges", EdgeHandleInput.reason(29, false, false));
        assertEquals("input monitor not available", EdgeHandleInput.reason(29, true, false));
        assertEquals("input monitor started", EdgeHandleInput.reason(29, true, true));
    }
}
