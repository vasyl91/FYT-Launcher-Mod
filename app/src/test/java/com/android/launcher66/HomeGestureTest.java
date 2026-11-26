package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeGestureTest {

    // a 1200 px short side: 12 % is 144 px
    private static final int SHORT = 1200;

    @Test
    void aLongSteepSwipeUpIsUpAndDownIsDown() {
        assertEquals(HomeGesture.Result.UP, HomeGesture.classify(10f, -300f, SHORT, 200f));
        assertEquals(HomeGesture.Result.DOWN, HomeGesture.classify(-10f, 300f, SHORT, 200f));
    }

    @Test
    void aSwipeThatIsNotSteepEnoughStaysThePagesOnes() {
        // just under 60 degrees (dx = dy / tan(60) = 173.2): not steeper than 60
        assertEquals(HomeGesture.Result.NONE, HomeGesture.classify(175f, -300f, SHORT, 5000f));
        assertEquals(HomeGesture.Result.NONE, HomeGesture.classify(400f, -300f, SHORT, 5000f));
        assertEquals(HomeGesture.Result.UP, HomeGesture.classify(150f, -300f, SHORT, 0f));
    }

    @Test
    void aShortSlowSwipeIsNothingAndAShortFastOneIsAGesture() {
        assertEquals(HomeGesture.Result.NONE, HomeGesture.classify(0f, -143f, SHORT, 900f));
        assertEquals(HomeGesture.Result.UP, HomeGesture.classify(0f, -144f, SHORT, 900f));
        assertEquals(HomeGesture.Result.UP, HomeGesture.classify(0f, -60f, SHORT, 1000f));
        assertEquals(HomeGesture.Result.DOWN, HomeGesture.classify(0f, 60f, SHORT, -1500f));
    }

    @Test
    void aMoveIsSteepWhenItIsAboveSixtyDegreesFromTheHorizontal() {
        assertTrue(HomeGesture.steep(0f, -20f));
        assertTrue(HomeGesture.steep(100f, 200f));
        assertFalse(HomeGesture.steep(175f, 300f));
        assertFalse(HomeGesture.steep(300f, 0f));
        assertFalse(HomeGesture.steep(0f, 0f));
    }

    @Test
    void noMoveIsNoGesture() {
        assertEquals(HomeGesture.Result.NONE, HomeGesture.classify(0f, 0f, SHORT, 5000f));
        assertEquals(HomeGesture.Result.NONE, HomeGesture.classify(300f, 0f, SHORT, 5000f));
    }

    @Test
    void theGestureDoesNotStartWhereSomethingElseOwnsTheTouch() {
        assertTrue(HomeGesture.mayStart(false, false, false, false, false, false, false));
        assertFalse(HomeGesture.mayStart(true, false, false, false, false, false, false));
        assertFalse(HomeGesture.mayStart(false, true, false, false, false, false, false));
        assertFalse(HomeGesture.mayStart(false, false, true, false, false, false, false));
        assertFalse(HomeGesture.mayStart(false, false, false, true, false, false, false));
        assertFalse(HomeGesture.mayStart(false, false, false, false, true, false, false));
        assertFalse(HomeGesture.mayStart(false, false, false, false, false, true, false));
        assertFalse(HomeGesture.mayStart(false, false, false, false, false, false, true));
    }

    @Test
    void aGestureIsWantedOnlyWhenItsSettingIsOn() {
        assertTrue(HomeGesture.wanted(HomeGesture.Result.UP, true, false));
        assertFalse(HomeGesture.wanted(HomeGesture.Result.UP, false, true));
        assertTrue(HomeGesture.wanted(HomeGesture.Result.DOWN, false, true));
        assertFalse(HomeGesture.wanted(HomeGesture.Result.DOWN, true, false));
        assertFalse(HomeGesture.wanted(HomeGesture.Result.NONE, true, true));
    }
}
