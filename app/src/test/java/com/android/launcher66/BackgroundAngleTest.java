package com.android.launcher66;

import static com.android.launcher66.BackgroundAngle.Side.BOTTOM;
import static com.android.launcher66.BackgroundAngle.Side.LEFT;
import static com.android.launcher66.BackgroundAngle.Side.RIGHT;
import static com.android.launcher66.BackgroundAngle.Side.TOP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BackgroundAngleTest {

    @Test
    void theHorizontalBarAtTheBottomIsNotTurned() {
        assertEquals(0, BackgroundAngle.degrees(BOTTOM, false));
    }

    @Test
    void theHorizontalBarAtTheTopIsTurnedHalfWay() {
        assertEquals(180, BackgroundAngle.degrees(TOP, false));
    }

    @Test
    void theVerticalBarOnTheLeftTurnsAPictureOfTheHorizontalBarClockwise() {
        assertEquals(90, BackgroundAngle.degrees(LEFT, false));
    }

    @Test
    void theVerticalBarOnTheRightTurnsItCounterClockwise() {
        // 270 degrees clockwise is 90 degrees counter-clockwise
        assertEquals(270, BackgroundAngle.degrees(RIGHT, false));
    }

    @Test
    void theVerticalBarsOwnPictureIsUprightOnTheLeftAndHalfTurnedOnTheRight() {
        assertEquals(0, BackgroundAngle.degrees(LEFT, true));
        assertEquals(180, BackgroundAngle.degrees(RIGHT, true));
    }

    @Test
    void theTwoSidesOfABarAlwaysDifferByAHalfTurn() {
        for (boolean upright : new boolean[] {false, true}) {
            assertEquals(180, Math.floorMod(BackgroundAngle.degrees(RIGHT, upright)
                    - BackgroundAngle.degrees(LEFT, upright), 360));
        }
        assertEquals(180, BackgroundAngle.degrees(TOP, false) - BackgroundAngle.degrees(BOTTOM, false));
    }

    @Test
    void onlyAQuarterTurnSwapsTheSides() {
        assertTrue(BackgroundAngle.swapsSides(90));
        assertTrue(BackgroundAngle.swapsSides(270));
        assertFalse(BackgroundAngle.swapsSides(0));
        assertFalse(BackgroundAngle.swapsSides(180));
    }

    @Test
    void theSideComesFromTheSetting() {
        assertEquals(TOP, BackgroundAngle.horizontal(true));
        assertEquals(BOTTOM, BackgroundAngle.horizontal(false));
        assertEquals(RIGHT, BackgroundAngle.vertical(true));
        assertEquals(LEFT, BackgroundAngle.vertical(false));
    }
}
