package com.android.launcher66;

import static com.android.launcher66.WorkspaceLoadWatch.Decision.RELEASE;
import static com.android.launcher66.WorkspaceLoadWatch.Decision.RESTART;
import static com.android.launcher66.WorkspaceLoadWatch.Decision.WAIT_MORE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkspaceLoadWatchTest {

    private static WorkspaceLoadWatch.Snapshot snap(boolean task, boolean stopped, boolean running, int queued) {
        return new WorkspaceLoadWatch.Snapshot(7, task, stopped, running, true, false, queued, 0L);
    }

    @Test
    void aLoadThatWorksOrHasStepsQueuedIsWaitedForOnce() {
        assertEquals(WAIT_MORE, WorkspaceLoadWatch.decide(snap(true, false, true, 0), 0, 0));
        assertEquals(WAIT_MORE, WorkspaceLoadWatch.decide(snap(true, false, false, 12), 0, 0));
        // the extra wait is used up: it is started again
        assertEquals(RESTART, WorkspaceLoadWatch.decide(snap(true, false, true, 0), 0, 1));
    }

    @Test
    void noLiveLoadIsStartedAgain() {
        // no task at all (it finished or was replaced, and the bind never came)
        assertEquals(RESTART, WorkspaceLoadWatch.decide(snap(false, false, false, 0), 0, 0));
        // stopped
        assertEquals(RESTART, WorkspaceLoadWatch.decide(snap(true, true, true, 3), 0, 0));
        // a task that is not running and has nothing queued
        assertEquals(RESTART, WorkspaceLoadWatch.decide(snap(true, false, false, 0), 0, 0));
    }

    @Test
    void afterTwoRestartsTheStateIsReleased() {
        assertEquals(RESTART, WorkspaceLoadWatch.decide(snap(false, false, false, 0), 1, 0));
        assertEquals(RELEASE, WorkspaceLoadWatch.decide(snap(false, false, false, 0), 2, 0));
        assertEquals(RELEASE, WorkspaceLoadWatch.decide(snap(true, false, true, 5), 2, 0));
    }

    @Test
    void aSkippedReloadRunsOnlyIfTheBindBeganBeforeIt() {
        assertTrue(WorkspaceLoadWatch.mustRunSkippedReload(1000L, 2000L));
        // a bind that began after the request has seen the new settings
        assertFalse(WorkspaceLoadWatch.mustRunSkippedReload(3000L, 2000L));
        // a load that had not begun to bind (0) began before
        assertTrue(WorkspaceLoadWatch.mustRunSkippedReload(0L, 2000L));
        // nothing skipped
        assertFalse(WorkspaceLoadWatch.mustRunSkippedReload(1000L, 0L));
    }

    @Test
    void theSnapshotSaysWhatItIs() {
        assertTrue(snap(true, false, true, 0).alive());
        assertFalse(snap(true, true, true, 0).alive());
        assertTrue(snap(true, false, false, 1).toString().contains("bind steps queued 1"));
    }
}
