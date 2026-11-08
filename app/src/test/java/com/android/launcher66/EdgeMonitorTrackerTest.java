package com.android.launcher66;

import static com.android.launcher66.EdgeMonitorTracker.ACTION_CANCEL;
import static com.android.launcher66.EdgeMonitorTracker.ACTION_DOWN;
import static com.android.launcher66.EdgeMonitorTracker.ACTION_MOVE;
import static com.android.launcher66.EdgeMonitorTracker.ACTION_POINTER_DOWN;
import static com.android.launcher66.EdgeMonitorTracker.ACTION_UP;
import static com.android.launcher66.EdgeMonitorTracker.Result.NONE;
import static com.android.launcher66.EdgeMonitorTracker.Result.PILFER_AND_OPEN;
import static com.android.launcher66.EdgeMonitorTracker.Result.STOP;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EdgeMonitorTrackerTest {

    private static final float SLOP = 8f;
    private static final long TAP = 100L;

    private EdgeMonitorTracker tracker() {
        return new EdgeMonitorTracker(SLOP, TAP);
    }

    /** The handle's area: the left or the right edge, at the top or the bottom; the finger is put inside. */
    private static final class Spot {
        final boolean right;
        final float x;
        final float y;

        Spot(boolean right, boolean top) {
            this.right = right;
            this.x = right ? 1900f : 20f;
            this.y = top ? 60f : 1000f;
        }

        /** Moves the finger inwards by dx and down by dy. */
        float x(float inwards) {
            return right ? x - inwards : x + inwards;
        }
    }

    private static Spot[] spots() {
        return new Spot[] {new Spot(false, false), new Spot(false, true), new Spot(true, false), new Spot(true, true)};
    }

    private static EdgeMonitorTracker.Result down(EdgeMonitorTracker t, Spot s) {
        return t.onEvent(ACTION_DOWN, s.x, s.y, 0L, 1, true, s.right);
    }

    @Test
    void aClickIsLeftToTheAppBelow() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            assertEquals(NONE, down(t, s));
            // on the strip and in the margin alike: the lift without a swipe is a click
            assertEquals(STOP, t.onEvent(ACTION_UP, s.x, s.y, 40L, 1, false, s.right));
        }
    }

    @Test
    void aLongPressWithoutAMoveIsLeftToTheAppBelow() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            assertEquals(STOP, t.onEvent(ACTION_UP, s.x, s.y, 900L, 1, false, s.right));
        }
    }

    @Test
    void aSwipeAfterALongPressIsStillAPress() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            assertEquals(STOP, t.onEvent(ACTION_MOVE, s.x(60), s.y, 700L, 1, false, s.right));
            // and nothing more is said about this gesture
            assertEquals(NONE, t.onEvent(ACTION_MOVE, s.x(120), s.y, 720L, 1, false, s.right));
        }
    }

    @Test
    void aDragAlongTheEdgeIsLeftToTheAppBelow() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            assertEquals(STOP, t.onEvent(ACTION_MOVE, s.x, s.y + 40f, 30L, 1, false, s.right));
        }
    }

    @Test
    void aMoveToTheEdgeIsLeftToTheAppBelow() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            assertEquals(STOP, t.onEvent(ACTION_MOVE, s.x(-20), s.y, 30L, 1, false, s.right));
        }
    }

    @Test
    void aSwipeInwardsOpensTheBarOnceAtTheSlop() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            // under the slop: still undecided
            assertEquals(NONE, t.onEvent(ACTION_MOVE, s.x(4), s.y, 10L, 1, false, s.right));
            // over it: pilfer, exactly once
            assertEquals(PILFER_AND_OPEN, t.onEvent(ACTION_MOVE, s.x(12), s.y, 20L, 1, false, s.right));
            assertEquals(NONE, t.onEvent(ACTION_MOVE, s.x(80), s.y, 30L, 1, false, s.right));
            assertEquals(NONE, t.onEvent(ACTION_UP, s.x(80), s.y, 40L, 1, false, s.right));
        }
    }

    @Test
    void aSwipeThatIsNotHorizontalEnoughDoesNotOpen() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            // inwards 12, along the edge 20: the vertical move decides
            assertEquals(STOP, t.onEvent(ACTION_MOVE, s.x(12), s.y + 20f, 20L, 1, false, s.right));
        }
    }

    @Test
    void aSecondFingerEndsTheObservation() {
        for (Spot s : spots()) {
            EdgeMonitorTracker t = tracker();
            down(t, s);
            assertEquals(STOP, t.onEvent(ACTION_POINTER_DOWN, s.x, s.y, 10L, 2, false, s.right));
            assertEquals(NONE, t.onEvent(ACTION_MOVE, s.x(40), s.y, 20L, 2, false, s.right));
        }
        // two fingers already at the first event
        EdgeMonitorTracker t = tracker();
        assertEquals(STOP, t.onEvent(ACTION_DOWN, 20f, 1000f, 0L, 2, true, false));
    }

    @Test
    void aTouchOutsideTheAreaIsNothing() {
        EdgeMonitorTracker t = tracker();
        assertEquals(NONE, t.onEvent(ACTION_DOWN, 500f, 500f, 0L, 1, false, false));
        assertEquals(NONE, t.onEvent(ACTION_MOVE, 600f, 500f, 20L, 1, false, false));
        assertEquals(NONE, t.onEvent(ACTION_UP, 600f, 500f, 40L, 1, false, false));
    }

    @Test
    void aCancelEndsTheGestureAndTheNextOneStartsAfresh() {
        Spot s = new Spot(false, false);
        EdgeMonitorTracker t = tracker();
        down(t, s);
        assertEquals(STOP, t.onEvent(ACTION_CANCEL, s.x, s.y, 10L, 1, false, false));
        // the next gesture is a swipe and opens the bar
        assertEquals(NONE, t.onEvent(ACTION_DOWN, s.x, s.y, 1000L, 1, true, false));
        assertEquals(PILFER_AND_OPEN, t.onEvent(ACTION_MOVE, s.x(15), s.y, 1010L, 1, false, false));
    }

    @Test
    void theHandleOnTheOtherEdgeDoesNotTakeTheSwipeTowardsItsEdge() {
        // the handle on the right: a swipe to the right (to the edge) is not ours
        EdgeMonitorTracker t = tracker();
        t.onEvent(ACTION_DOWN, 1900f, 1000f, 0L, 1, true, true);
        assertEquals(STOP, t.onEvent(ACTION_MOVE, 1920f, 1000f, 20L, 1, false, true));
    }
}
