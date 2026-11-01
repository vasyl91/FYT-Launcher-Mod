package com.android.launcher66;

import static com.android.launcher66.BarSwipeGesture.CANCEL;
import static com.android.launcher66.BarSwipeGesture.CANCEL_CHILDREN;
import static com.android.launcher66.BarSwipeGesture.DISPATCH;
import static com.android.launcher66.BarSwipeGesture.DOWN;
import static com.android.launcher66.BarSwipeGesture.HIDE_BAR;
import static com.android.launcher66.BarSwipeGesture.MOVE;
import static com.android.launcher66.BarSwipeGesture.STOP_FEEDING;
import static com.android.launcher66.BarSwipeGesture.UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarSwipeGestureTest {

    private static final long LONG_PRESS = 500;
    private static final int POINTER_DOWN = 5;

    private final BarSwipeGesture gesture = new BarSwipeGesture();

    /** What the frame does with one event: shouldFeed(), the feeding, afterFeed(). */
    private int event(int action, long t, boolean fed, boolean paging, boolean disallowed) {
        boolean feed = gesture.shouldFeed(action, t, LONG_PRESS, disallowed);
        return gesture.afterFeed(action, feed && fed, feed && paging, disallowed);
    }

    private int down() {
        return event(DOWN, 0, true, false, false);
    }

    @Test
    void aTapOnlyReachesTheBar() {
        assertEquals(DISPATCH, down());
        assertEquals(0, gesture.afterDownDispatch(false));
        assertEquals(DISPATCH, event(MOVE, 20, true, false, false));
        assertEquals(DISPATCH, event(UP, 80, true, false, false));
        assertFalse(gesture.isFeeding());
    }

    @Test
    void aHorizontalSwipeHidesTheBarOnceAndTakesTheGestureFromIt() {
        down();
        assertEquals(DISPATCH, event(MOVE, 16, true, false, false));
        assertEquals(DISPATCH, event(MOVE, 32, true, false, false));
        assertEquals(CANCEL_CHILDREN | HIDE_BAR, event(MOVE, 48, true, true, false));
        assertEquals(0, event(MOVE, 64, true, true, false));
        assertEquals(0, event(MOVE, 80, true, true, false));
        assertEquals(0, event(UP, 96, true, true, false));
        assertFalse(gesture.isFeeding());
    }

    @Test
    void holdingPastTheLongPressTimeoutLeavesTheGestureToTheBar() {
        down();
        assertEquals(STOP_FEEDING | DISPATCH, event(MOVE, LONG_PRESS, true, true, false));
        assertFalse(gesture.isFeeding());
        assertEquals(DISPATCH, event(MOVE, LONG_PRESS + 16, true, true, false));
        assertEquals(DISPATCH, event(UP, LONG_PRESS + 32, true, true, false));
    }

    @Test
    void movingNeverHidesTheBarAfterALongPress() {
        down();
        int mask = event(MOVE, LONG_PRESS + 1, true, true, false);
        assertEquals(0, mask & HIDE_BAR);
        mask = event(MOVE, LONG_PRESS + 17, true, true, false);
        assertEquals(0, mask & HIDE_BAR);
    }

    @Test
    void aBarViewThatAskedNotToBeInterceptedKeepsTheGesture() {
        down();
        assertEquals(DISPATCH, event(MOVE, 16, true, false, false));
        assertEquals(STOP_FEEDING | DISPATCH, event(MOVE, 32, true, true, true));
        assertEquals(DISPATCH, event(UP, 48, true, false, true));
    }

    @Test
    void aBarViewThatAsksAtOnceStopsTheWorkspaceRightAfterTheDown() {
        assertEquals(DISPATCH, down());
        assertEquals(STOP_FEEDING, gesture.afterDownDispatch(true));
        assertFalse(gesture.isFeeding());
        assertEquals(DISPATCH, event(MOVE, 16, true, true, true));
    }

    @Test
    void whenTheWorkspaceCannotPageTheBarHasTheGestureToItself() {
        assertEquals(DISPATCH, event(DOWN, 0, false, false, false));
        assertEquals(0, gesture.afterDownDispatch(false));
        assertEquals(DISPATCH, event(MOVE, 16, false, false, false));
        assertEquals(DISPATCH, event(UP, 32, false, false, false));
    }

    @Test
    void aDownOnSettlingPagesCatchesThemWithoutTouchingTheBar() {
        assertEquals(0, event(DOWN, 0, true, true, false));
        assertTrue(gesture.isFeeding());
        // Released without moving: the pages settle, the bar stays.
        assertEquals(0, event(UP, 40, true, true, false));
    }

    @Test
    void theBarGoesWhenTheCaughtPagesStartToMove() {
        event(DOWN, 0, true, true, false);
        assertEquals(HIDE_BAR, event(MOVE, 16, true, true, false));
        assertEquals(0, event(MOVE, 32, true, true, false));
        assertEquals(0, event(UP, 48, true, true, false));
    }

    @Test
    void anotherFingerGoingDownDoesNotChangeWhoOwnsTheGesture() {
        down();
        assertEquals(DISPATCH, event(POINTER_DOWN, 20, true, false, false));
        event(MOVE, 30, true, true, false);
        assertEquals(0, event(POINTER_DOWN, 40, true, true, false));
    }

    @Test
    void aFurtherEventCanCancelTheBarsViewsWithoutHidingIt() {
        down();
        assertEquals(CANCEL_CHILDREN, event(POINTER_DOWN, 20, true, true, false));
        // The next move hides it.
        assertEquals(HIDE_BAR, event(MOVE, 30, true, true, false));
    }

    @Test
    void aCancelEndsTheGestureLikeAnUp() {
        down();
        event(MOVE, 16, true, true, false);
        assertEquals(0, event(CANCEL, 32, true, true, false));
        assertFalse(gesture.isFeeding());
    }

    @Test
    void aNewDownForgetsTheGestureBefore() {
        down();
        assertEquals(CANCEL_CHILDREN | HIDE_BAR, event(MOVE, 16, true, true, false));
        // No up: the window got a new touch (the previous one was lost).
        assertEquals(DISPATCH, down());
        assertEquals(CANCEL_CHILDREN | HIDE_BAR, event(MOVE, 16, true, true, false));
    }

    @Test
    void eventsOutsideAGestureOnlyGoToTheBar() {
        assertFalse(gesture.shouldFeed(MOVE, 10, LONG_PRESS, false));
        assertEquals(DISPATCH, gesture.afterFeed(MOVE, false, false, false));
        assertFalse(gesture.isFeeding());
    }
}
