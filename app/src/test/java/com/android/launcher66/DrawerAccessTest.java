package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DrawerAccessTest {

    @Test
    void theSwipeUpIsRequiredWithoutTheBarOrWithoutItsButton() {
        assertFalse(DrawerAccess.swipeUpRequired(true, false));
        assertTrue(DrawerAccess.swipeUpRequired(false, false));
        assertTrue(DrawerAccess.swipeUpRequired(true, true));
        assertTrue(DrawerAccess.swipeUpRequired(false, true));
    }

    @Test
    void theLauncherActsOnTheStoredValueOrTheRequirement() {
        assertFalse(DrawerAccess.swipeUpActive(false, true, false));
        assertTrue(DrawerAccess.swipeUpActive(true, true, false));
        // required: on whatever is stored
        assertTrue(DrawerAccess.swipeUpActive(false, false, false));
        assertTrue(DrawerAccess.swipeUpActive(false, true, true));
    }
}
