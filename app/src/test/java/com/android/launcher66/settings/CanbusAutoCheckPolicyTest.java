package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusAutoCheckPolicy.Record;
import com.android.launcher66.settings.CanbusAutoCheckPolicy.State;

import org.junit.jupiter.api.Test;

class CanbusAutoCheckPolicyTest {

    @Test
    void aRecordSurvivesItsText() {
        Record r = new Record(State.INTERRUPTED, 1_000L, 2, 5_000L);
        Record back = Record.parse(r.serialize());
        assertEquals(State.INTERRUPTED, back.state);
        assertEquals(1_000L, back.startedAt);
        assertEquals(2, back.attempts);
        assertEquals(5_000L, back.finishedAt);
    }

    @Test
    void nothingOrNonsenseIsNoState() {
        assertSame(Record.NONE, Record.parse(null));
        assertSame(Record.NONE, Record.parse(""));
        assertSame(Record.NONE, Record.parse("DONE;1;2"));
        assertSame(Record.NONE, Record.parse("SOMETHING;1;2;3"));
        assertSame(Record.NONE, Record.parse("DONE;x;2;3"));
    }

    @Test
    void aRunningRecordFoundAtTheStartOfTheServiceWasInterrupted() {
        Record running = Record.NONE.started(10L);
        assertEquals(State.RUNNING, running.state);
        assertEquals(1, running.attempts);
        Record after = CanbusAutoCheckPolicy.afterRestart(running);
        assertEquals(State.INTERRUPTED, after.state);
        assertEquals(1, after.attempts);
        // the others stay as they are
        Record done = running.ended(State.DONE, 99L);
        assertSame(done, CanbusAutoCheckPolicy.afterRestart(done));
        assertSame(Record.NONE, CanbusAutoCheckPolicy.afterRestart(Record.NONE));
    }

    @Test
    void aSecondAttemptCountsUp() {
        Record first = Record.NONE.started(10L).ended(State.INTERRUPTED, 20L);
        assertEquals(2, first.started(30L).attempts);
    }

    @Test
    void itRunsOnlyOnAnFytUnitWithTheStatisticsOnForAKnownCar() {
        Record none = Record.NONE;
        assertTrue(CanbusAutoCheckPolicy.mayRun(true, true, true, 163, false, none));
        assertFalse(CanbusAutoCheckPolicy.mayRun(false, true, true, 163, false, none));
        assertFalse(CanbusAutoCheckPolicy.mayRun(true, false, true, 163, false, none));
        assertFalse(CanbusAutoCheckPolicy.mayRun(true, true, false, 163, false, none));
        assertFalse(CanbusAutoCheckPolicy.mayRun(true, true, true, 0, false, none));
    }

    @Test
    void aReaderStartedByHandExcludesIt() {
        assertFalse(CanbusAutoCheckPolicy.mayRun(true, true, true, 163, true, Record.NONE));
    }

    @Test
    void afterADoneCheckItDoesNotRunAgainButAfterTheOthersItDoes() {
        for (State s : new State[]{State.NONE, State.INTERRUPTED, State.FAILED}) {
            assertTrue(CanbusAutoCheckPolicy.mayRun(true, true, true, 163, false, new Record(s, 1L, 1, 2L)), s.name());
        }
        assertFalse(CanbusAutoCheckPolicy.mayRun(true, true, true, 163, false, new Record(State.DONE, 1L, 1, 2L)));
    }

    @Test
    void movingIsAboveFiveKmh() {
        assertFalse(CanbusAutoCheckPolicy.isMoving(5.0));
        assertTrue(CanbusAutoCheckPolicy.isMoving(5.1));
    }

    @Test
    void theStartNeedsMovementInTheLastThirtySeconds() {
        assertTrue(CanbusAutoCheckPolicy.movedRecently(100_000L, 120_000L));
        assertTrue(CanbusAutoCheckPolicy.movedRecently(100_000L, 130_000L));
        assertFalse(CanbusAutoCheckPolicy.movedRecently(100_000L, 130_001L));
        assertFalse(CanbusAutoCheckPolicy.movedRecently(0L, 10_000L));
    }

    @Test
    void aRecordingIsDoneWithEnoughDrivingAndFixesElseFailed() {
        assertEquals(State.DONE, CanbusAutoCheckPolicy.outcome(120_000L, 60));
        assertEquals(State.FAILED, CanbusAutoCheckPolicy.outcome(119_999L, 60));
        assertEquals(State.FAILED, CanbusAutoCheckPolicy.outcome(300_000L, 59));
    }
}
