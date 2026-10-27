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
}
