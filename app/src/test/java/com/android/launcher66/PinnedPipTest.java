package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PinnedPipTest {

    @Test
    void aDeviceThatIsNotAnFytUnitHasNoPinnedPip() {
        assertFalse(PinnedPip.supported(false, false));
        assertFalse(PinnedPip.supported(false, true));
    }

    @Test
    void anFytUnitWithTheMusicPlayerHasIt() {
        assertTrue(PinnedPip.supported(true, false)); // 7862, 8581
    }

    @Test
    void the7870DoesNotHaveIt() {
        assertFalse(PinnedPip.supported(true, true));
    }

    @Test
    void aSavedModeCountsOnlyWhereItIsSupported() {
        assertTrue(PinnedPip.mode(true, true));
        assertFalse(PinnedPip.mode(true, false));
        assertFalse(PinnedPip.mode(false, true));
        assertFalse(PinnedPip.mode(false, false));
    }

    @Test
    void anOutsideTouchWithItsCoordinatesZeroedWasOnAnotherApp() {
        assertTrue(PinnedPip.outsideTouchOnOtherApp(0f, 0f)); // the pinned PiP, a window pane
    }

    @Test
    void anOutsideTouchWithCoordinatesWasOnTheLauncher() {
        assertFalse(PinnedPip.outsideTouchOnOtherApp(640f, 360f));
        assertFalse(PinnedPip.outsideTouchOnOtherApp(0f, 360f)); // the left edge
        assertFalse(PinnedPip.outsideTouchOnOtherApp(640f, 0f)); // the top edge
    }
}
