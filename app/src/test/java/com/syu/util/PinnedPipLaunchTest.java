package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PinnedPipLaunchTest {

    private static final int PINNED = 2;
    private static final int FULLSCREEN = 1;

    @Test
    void aPinnedTaskOnTheDefaultDisplayIsInsideTheStack() {
        assertFalse(PinnedPipLaunch.outsidePinned(PINNED, 0));
    }

    @Test
    void aFullScreenTaskOnTheDefaultDisplayIsOutside() {
        assertTrue(PinnedPipLaunch.outsidePinned(FULLSCREEN, 0));
    }

    @Test
    void aTaskOnAVirtualDisplayIsOutsideWhateverItsModeIsKnownAs() {
        assertTrue(PinnedPipLaunch.outsidePinned(-1, 61));   // the retired ActivityView of log B
        assertTrue(PinnedPipLaunch.outsidePinned(PINNED, 61));
    }

    @Test
    void whatCannotBeReadSaysNothing() {
        assertFalse(PinnedPipLaunch.outsidePinned(-1, -1));
        assertFalse(PinnedPipLaunch.outsidePinned(-1, 0));
        assertFalse(PinnedPipLaunch.outsidePinned(PINNED, -1));
    }

    @Test
    void aChangedPackageOrSizeRestartsWhateverElse() {
        assertTrue(PinnedPipLaunch.needsRestart(true, false, false, false));
        assertTrue(PinnedPipLaunch.needsRestart(false, true, false, false));
        assertTrue(PinnedPipLaunch.needsRestart(true, true, true, true));
        assertTrue(PinnedPipLaunch.needsRestart(true, false, false, true));
        assertTrue(PinnedPipLaunch.needsRestart(false, true, false, true));
    }

    @Test
    void aTaskOutsideThePinnedStackRestartsUnlessAWindowPaneShowsTheApp() {
        assertTrue(PinnedPipLaunch.needsRestart(false, false, true, false));
        assertFalse(PinnedPipLaunch.needsRestart(false, false, true, true));
    }

    @Test
    void nothingChangedAndNoStrayTaskLeavesTheAppRunning() {
        assertFalse(PinnedPipLaunch.needsRestart(false, false, false, false));
        assertFalse(PinnedPipLaunch.needsRestart(false, false, false, true));
    }

    @Test
    void aSlotThatIsOnAndNotPinnedIsAWindowPane() {
        boolean[] on = {true, false, true, false};
        boolean[] pinned = {false, false, true, false};
        String[] pkg = {"yt", "maps", "maps", "yt"};
        assertTrue(PinnedPipLaunch.shownInWindowPane("yt", on, pinned, pkg));
        assertFalse(PinnedPipLaunch.shownInWindowPane("maps", on, pinned, pkg)); // off, or pinned
        assertFalse(PinnedPipLaunch.shownInWindowPane("", on, pinned, pkg));
        assertFalse(PinnedPipLaunch.shownInWindowPane(null, on, pinned, pkg));
    }

    @Test
    void anAppStartedLessThanTheSettleTimeAgoIsStillSettling() {
        assertTrue(PinnedPipLaunch.isSettling(1000, 500, 1500));
        assertTrue(PinnedPipLaunch.isSettling(1999, 500, 1500));   // 1499 ms after
        assertFalse(PinnedPipLaunch.isSettling(2000, 500, 1500));  // exactly 1500 ms after
        assertFalse(PinnedPipLaunch.isSettling(5000, 500, 1500));
    }

    @Test
    void anAppThatWasNeverStartedIsNotSettling() {
        assertFalse(PinnedPipLaunch.isSettling(100, 0, 1500));
    }

    @Test
    void theStartIsAllowedOnlyOnItsPageWithTheDrawerClosedAndThePagesStill() {
        assertTrue(PinnedPipLaunch.mayStartNow(false, 1, 1, false));
        assertFalse(PinnedPipLaunch.mayStartNow(true, 1, 1, false));   // pages moving
        assertFalse(PinnedPipLaunch.mayStartNow(false, 0, 1, false));  // another page
        assertFalse(PinnedPipLaunch.mayStartNow(false, 1, 1, true));   // all apps open
    }

    @Test
    void thePinnedPipDoesNotCoverTheHomeScreen() {
        assertFalse(PinnedPipLaunch.canCoverHome(PINNED));
        assertTrue(PinnedPipLaunch.canCoverHome(FULLSCREEN));
        assertTrue(PinnedPipLaunch.canCoverHome(-1));   // unknown: as before
    }
}
