package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FabButtonsTest {

    @Test
    void noButtonSwitchedOnNeedsNoService() {
        assertFalse(FabButtons.anyUsable(false, false, false, true, true, true, true));
    }

    @Test
    void theMainButtonNeedsAnAppInEveryPip() {
        assertTrue(FabButtons.anyUsable(true, false, false, true, true, true, true));
        assertFalse(FabButtons.anyUsable(true, false, false, true, true, true, false));
        assertFalse(FabButtons.anyUsable(true, false, false, false, true, true, true));
    }

    @Test
    void theLeftButtonNeedsOnlyTheFirstAndTheThird() {
        assertTrue(FabButtons.anyUsable(false, true, false, true, false, true, false));
        assertFalse(FabButtons.anyUsable(false, true, false, true, true, false, true));
    }

    @Test
    void theRightButtonNeedsOnlyTheSecondAndTheFourth() {
        assertTrue(FabButtons.anyUsable(false, false, true, false, true, false, true));
        assertFalse(FabButtons.anyUsable(false, false, true, true, true, true, false));
    }

    @Test
    void oneUsableButtonIsEnoughBesideOneThatIsNot() {
        assertTrue(FabButtons.anyUsable(true, true, false, true, false, true, false));
    }
}
