package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DrainPlanTest {

    @Test
    void aStopReadsPastItsEndForTenSecondsAtMost() {
        assertEquals(10_000L, DrainPlan.MAX_MS);
        assertEquals(DrainPlan.Action.WAIT, DrainPlan.next(9_999L, 0L));
        assertEquals(DrainPlan.Action.TIMED_OUT, DrainPlan.next(10_000L, 0L));
        assertEquals(DrainPlan.Action.TIMED_OUT, DrainPlan.next(60_000L, 0L));
    }

    @Test
    void logcatIdleForASecondAndAHalfHasCaughtUp() {
        assertEquals(DrainPlan.Action.WAIT, DrainPlan.next(2_000L, 1_499L));
        assertEquals(DrainPlan.Action.CAUGHT_UP, DrainPlan.next(2_000L, 1_500L));
    }

    @Test
    void theTimeLimitComesBeforeTheIdleOne() {
        // both at once: the capture was cut, not caught up
        assertEquals(DrainPlan.Action.TIMED_OUT, DrainPlan.next(10_000L, 5_000L));
    }

    @Test
    void aLineNewerThanTheStopIsNeverTaken() {
        assertTrue(DrainPlan.takesLine(1_000L, 1_000L));
        assertTrue(DrainPlan.takesLine(999L, 1_000L));
        assertFalse(DrainPlan.takesLine(1_001L, 1_000L));
        // a line whose time cannot be read is kept, as before: a format surprise must not empty the file
        assertTrue(DrainPlan.takesLine(-1L, 1_000L));
    }

    @Test
    void howFarBehindLogcatWasIsTheStopLessTheLastLine() {
        assertEquals(90L, DrainPlan.behindSeconds(100_000L, 10_000L));
        assertEquals(0L, DrainPlan.behindSeconds(100_000L, 100_400L));
        assertEquals(-1L, DrainPlan.behindSeconds(100_000L, -1L));
        assertEquals(-1L, DrainPlan.behindSeconds(100_000L, 0L));
    }

    @Test
    void theFooterSaysHowFarBehindAndThatTheRestWasNotRead() {
        assertEquals("===== stopped 10 s after the end; logcat was 187 s behind, the rest of the buffers not read =====",
                DrainPlan.footer(10L, 187L));
        assertTrue(DrainPlan.footer(10L, -1L).contains("the rest of the buffers not read"));
    }
}
