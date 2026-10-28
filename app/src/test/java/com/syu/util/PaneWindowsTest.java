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

    @Test
    void movesAreAsynchronousFromAndroid14() {
        assertFalse(PaneWindows.relayoutIsAsync(29)); // the 7862: relayout() waits
        assertFalse(PaneWindows.relayoutIsAsync(33)); // the 7870
        assertTrue(PaneWindows.relayoutIsAsync(34));
        assertTrue(PaneWindows.relayoutIsAsync(36));  // the A55: relayoutAsync=true in the log
    }

    @Test
    void aPaneBesideTheViewportBeforeAndAfterIsLeftWhereItIs() {
        // Log 28-10-2026 01:22, viewport 1080: Fourth at 1085..2155 and on to the right.
        assertTrue(PaneWindows.staysOffScreen(1085, 2155, 1155, 2225, true, 1080));
        // Dual leaving to the left, -933..-5, and going on.
        assertTrue(PaneWindows.staysOffScreen(-933, -5, -1000, -72, true, 1080));
        // From one side to the other in a jump.
        assertTrue(PaneWindows.staysOffScreen(-933, -5, 1200, 2128, true, 1080));
    }

    @Test
    void aPaneThatIsOrComesIntoViewIsMoved() {
        assertFalse(PaneWindows.staysOffScreen(1085, 2155, 1075, 2145, true, 1080)); // comes in
        assertFalse(PaneWindows.staysOffScreen(5, 976, 1085, 2056, true, 1080));     // goes out
        assertFalse(PaneWindows.staysOffScreen(0, 928, 10, 938, true, 1080));        // on screen
    }

    @Test
    void aPaneOffScreenThatChangesSizeIsStillResized() {
        assertFalse(PaneWindows.staysOffScreen(1085, 2155, 1085, 2200, false, 1080));
    }

    @Test
    void theEdgesOfTheViewportCountAsOutside() {
        assertTrue(PaneWindows.staysOffScreen(-928, 0, -900, 0, true, 1080));
        assertTrue(PaneWindows.staysOffScreen(1080, 2008, 1090, 2018, true, 1080));
        assertFalse(PaneWindows.staysOffScreen(-928, 0, -927, 1, true, 1080));
    }

    @Test
    void oneWindowAt80ASecondMovesEvery12AndAHalfMilliseconds() {
        assertTrue(PaneWindows.withinRelayoutBudget(1000, 0, 1, 80, 2));       // the first move
        assertFalse(PaneWindows.withinRelayoutBudget(1008, 1000, 1, 80, 2));   // the next frame at 120 Hz
        assertTrue(PaneWindows.withinRelayoutBudget(1017, 1000, 1, 80, 2));    // the one after
        assertTrue(PaneWindows.withinRelayoutBudget(1011, 1000, 1, 80, 2));    // 90 Hz, 2 ms early allowed
        assertFalse(PaneWindows.withinRelayoutBudget(1010, 1000, 1, 80, 2));   // not 3 ms early
    }

    @Test
    void moreWindowsWaitLongerBetweenTheirMoves() {
        assertFalse(PaneWindows.withinRelayoutBudget(1017, 1000, 2, 80, 2));   // 25 ms for two
        assertTrue(PaneWindows.withinRelayoutBudget(1025, 1000, 2, 80, 2));
        assertFalse(PaneWindows.withinRelayoutBudget(1033, 1000, 3, 80, 2));   // 37 ms for three
        assertTrue(PaneWindows.withinRelayoutBudget(1042, 1000, 3, 80, 2));
    }

    @Test
    void nothingToMoveIsNeverHeldBack() {
        assertTrue(PaneWindows.withinRelayoutBudget(1001, 1000, 0, 80, 2));
    }
}
