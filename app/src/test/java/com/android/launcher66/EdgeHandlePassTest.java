package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class EdgeHandlePassTest {

    @Test
    void aHideWhileAGestureIsPassedWaitsForItsEnd() {
        EdgeHandlePass pass = new EdgeHandlePass();
        assertFalse(pass.requestHide(true), "the hide is deferred");
        assertTrue(pass.hidePending());
        assertTrue(pass.passEnded(), "the end of the gesture completes the hide");
        assertFalse(pass.hidePending());
        assertFalse(pass.passEnded(), "only once");
    }

    @Test
    void showingAgainCallsOffTheWaitingHide() {
        EdgeHandlePass pass = new EdgeHandlePass();
        pass.requestHide(true);
        pass.show();
        assertFalse(pass.passEnded());
    }

    @Test
    void aHideWithoutAPassedGestureIsDoneAtOnce() {
        EdgeHandlePass pass = new EdgeHandlePass();
        assertTrue(pass.requestHide(false), "a gesture that is not decided yet is cancelled");
        assertFalse(pass.hidePending());
        assertFalse(pass.passEnded());
    }

    @Test
    void aGestureThatEndsWithoutAHideWaitingChangesNothing() {
        EdgeHandlePass pass = new EdgeHandlePass();
        assertFalse(pass.passEnded());
    }

    @Test
    void aSecondHideDuringTheSamePassStillWaitsOnce() {
        EdgeHandlePass pass = new EdgeHandlePass();
        assertFalse(pass.requestHide(true));
        assertFalse(pass.requestHide(true));
        assertTrue(pass.passEnded());
        assertFalse(pass.passEnded());
    }

    @Test
    void releaseForgetsAWaitingHide() {
        EdgeHandlePass pass = new EdgeHandlePass();
        pass.requestHide(true);
        pass.release();
        assertFalse(pass.passEnded());
    }

    @Test
    void theReplayGoesThroughEveryEventEvenIfTheSourceIsClearedAndFilledInTheMiddle() {
        List<String> held = new ArrayList<>(Arrays.asList("down", "move1", "move2", "move3"));
        List<String> replay = EdgeHandlePass.take(held);
        assertTrue(held.isEmpty(), "the held list is free for the next gesture at once");
        List<String> seen = new ArrayList<>();
        for (String event : replay) {
            seen.add(event);
            // what the launcher does in the middle of the loop: ends the gesture, begins another
            held.clear();
            held.add("other-down");
            held.add("other-move");
        }
        assertEquals(Arrays.asList("down", "move1", "move2", "move3"), seen);
        assertEquals(Arrays.asList("other-down", "other-move"), held);
    }

    @Test
    void takingAnEmptyListGivesAnEmptyCopy() {
        List<String> held = new ArrayList<>();
        assertTrue(EdgeHandlePass.take(held).isEmpty());
    }
}
