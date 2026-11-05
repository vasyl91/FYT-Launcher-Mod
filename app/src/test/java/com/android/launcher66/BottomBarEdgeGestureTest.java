package com.android.launcher66;

import static com.android.launcher66.BottomBarEdgeGesture.Decision.OPEN_BAR;
import static com.android.launcher66.BottomBarEdgeGesture.Decision.PASS;
import static com.android.launcher66.BottomBarEdgeGesture.Decision.UNDECIDED;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BottomBarEdgeGestureTest {

    private static final float SLOP = 8f;
    private static final long TAP = 100L;

    private final BottomBarEdgeGesture gesture = new BottomBarEdgeGesture(SLOP, TAP);

    private void down(boolean onStrip) {
        gesture.onDown(10f, 100f, 0L, onStrip);
    }

    @Test
    void aSwipeToTheRightOpensTheBar() {
        down(false);
        assertEquals(UNDECIDED, gesture.onMove(14f, 101f, 10L));
        assertEquals(OPEN_BAR, gesture.onMove(30f, 104f, 20L));
        // the decision stays for the rest of the gesture
        assertEquals(OPEN_BAR, gesture.onMove(30f, 300f, 30L));
        assertEquals(OPEN_BAR, gesture.onUp(30f, 300f, 40L));
    }

    @Test
    void aDiagonalMoveIsNotSteepEnoughToOpen() {
        down(false);
        // dx 12 is over the slop but not 1.5 times dy 10: neither a swipe to the right nor vertical
        assertEquals(UNDECIDED, gesture.onMove(22f, 110f, 10L));
        // then it turns into a clear swipe to the right
        assertEquals(OPEN_BAR, gesture.onMove(40f, 112f, 20L));
    }

    @Test
    void aVerticalDragPassesThrough() {
        down(false);
        assertEquals(PASS, gesture.onMove(12f, 130f, 10L));
        assertEquals(PASS, gesture.onMove(200f, 130f, 20L));   // no turning back
    }

    @Test
    void aMoveToTheLeftPassesThrough() {
        down(false);
        assertEquals(PASS, gesture.onMove(-5f, 100f, 10L));
    }

    @Test
    void aLongPressInTheMarginPassesThrough() {
        down(false);
        assertEquals(UNDECIDED, gesture.onTimeout(TAP - 1));
        assertEquals(PASS, gesture.onTimeout(TAP));
    }

    @Test
    void aSlowTapOnTheStripStillOpensTheBar() {
        down(true);
        assertEquals(UNDECIDED, gesture.onTimeout(5 * TAP));
        assertEquals(OPEN_BAR, gesture.onUp(10f, 100f, 5 * TAP));
        assertEquals(-1L, gesture.timeoutAfterMs());
    }

    @Test
    void aTapOnTheStripOpensTheBar() {
        down(true);
        assertEquals(OPEN_BAR, gesture.onUp(11f, 101f, 60L));
    }

    @Test
    void aTapInTheMarginPassesToWhatIsBelow() {
        down(false);
        assertEquals(PASS, gesture.onUp(11f, 101f, 60L));
        assertEquals(TAP, gesture.timeoutAfterMs());
    }

    @Test
    void aNewDownStartsAfresh() {
        down(false);
        gesture.onMove(12f, 130f, 10L);
        assertEquals(PASS, gesture.decision());
        down(true);
        assertEquals(UNDECIDED, gesture.decision());
    }

    @Test
    void aSwipeBeginningOnTheStripOpensToo() {
        down(true);
        assertEquals(OPEN_BAR, gesture.onMove(30f, 100f, 15L));
    }
}
