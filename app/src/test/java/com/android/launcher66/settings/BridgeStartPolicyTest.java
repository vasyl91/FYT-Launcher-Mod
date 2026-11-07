package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BridgeStartPolicyTest {

    @Test
    void theDelaysAreFiveFifteenSixtySecondsThenFiveMinutes() {
        BridgeStartPolicy p = new BridgeStartPolicy();
        assertTrue(p.begin());
        assertEquals(5_000L, p.unansweredDelayMs());
        assertEquals(15_000L, p.unansweredDelayMs());
        assertEquals(60_000L, p.unansweredDelayMs());
        assertEquals(300_000L, p.unansweredDelayMs());
        assertEquals(300_000L, p.unansweredDelayMs());
    }

    @Test
    void anAnswerEndsTheSequenceAndResetsTheCounts() {
        BridgeStartPolicy p = new BridgeStartPolicy();
        assertTrue(p.begin());
        p.unansweredDelayMs();
        p.unansweredDelayMs();
        p.answered();
        assertTrue(p.begin());
        assertEquals(5_000L, p.unansweredDelayMs());
    }

    @Test
    void aTriggerDuringASequenceDoesNotDuplicateIt() {
        BridgeStartPolicy p = new BridgeStartPolicy();
        assertTrue(p.begin());
        assertFalse(p.begin());
        assertFalse(p.begin());
        p.stopped();
        assertTrue(p.begin());
    }

    @Test
    void theBroadcastLaunchIsRetriedOncePerMinuteAtMost() {
        BridgeStartPolicy p = new BridgeStartPolicy();
        assertTrue(p.mayRetryBroadcastLaunch(1_000L));
        assertFalse(p.mayRetryBroadcastLaunch(30_000L));
        assertFalse(p.mayRetryBroadcastLaunch(60_999L));
        assertTrue(p.mayRetryBroadcastLaunch(61_000L));
    }

    @Test
    void onlyTheActivityWakeWaitsForTheBootAndNeedsTheLauncher() {
        assertFalse(BridgeStartPolicy.mayWakeByActivity(30_000L, true));
        assertTrue(BridgeStartPolicy.mayWakeByActivity(90_000L, true));
        assertFalse(BridgeStartPolicy.mayWakeByActivity(200_000L, false));
    }
}
