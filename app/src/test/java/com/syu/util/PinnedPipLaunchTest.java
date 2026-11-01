package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PinnedPipLaunchTest {

    private static final int PINNED = 2;
    private static final int FULLSCREEN = 1;
    private static final int FYT_PINNED = 6;

    @Test
    void aTaskOnTheDefaultDisplayIsLeftToTheFramework() {
        // The running PiP in FYT's pinned stack (mode 6, log 27-10-2026 23:31) or a full-screen
        // task, which FYT's ActivityStarter moves into that stack: neither needs a restart.
        assertFalse(PinnedPipLaunch.outsidePinned(0));
    }

    @Test
    void aTaskOnAVirtualDisplayIsOutside() {
        assertTrue(PinnedPipLaunch.outsidePinned(61));   // the retired ActivityView of log B
    }

    @Test
    void anUnreadableDisplaySaysNothing() {
        assertFalse(PinnedPipLaunch.outsidePinned(-1));
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
    void theHideWaitsOnlyForAColdStartThatIsStillSettling() {
        assertTrue(PinnedPipLaunch.hideMustWait(true, 1000, 500, 1500));    // log A
        assertFalse(PinnedPipLaunch.hideMustWait(true, 2000, 500, 1500));   // settled
        assertFalse(PinnedPipLaunch.hideMustWait(true, 100, 0, 1500));      // never started
    }

    @Test
    void aWarmStartIsHiddenAtOnce() {
        // Log 27-10-2026 23:55: swiped away 0.67-0.8 s after a warm start, hidden 0.7-0.8 s later.
        assertFalse(PinnedPipLaunch.hideMustWait(false, 35908, 35241, 1500));
        assertFalse(PinnedPipLaunch.hideMustWait(false, 35242, 35241, 1500));
    }

    @Test
    void aPipDieShortlyAfterTheLaunchersOwnForceStopIsItsAnswer() {
        assertTrue(PinnedPipLaunch.answersOwnForceStop(16804, 16650, 2000));  // log 27-10-2026 23:31
        assertTrue(PinnedPipLaunch.answersOwnForceStop(18649, 16650, 2000));  // 1999 ms after
        assertFalse(PinnedPipLaunch.answersOwnForceStop(18650, 16650, 2000)); // exactly 2000 ms after
        assertFalse(PinnedPipLaunch.answersOwnForceStop(60000, 16650, 2000));
    }

    @Test
    void aPipDieWithoutAForceStopOfTheLauncherIsNotItsAnswer() {
        assertFalse(PinnedPipLaunch.answersOwnForceStop(500, 0, 2000));
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
        assertFalse(PinnedPipLaunch.canCoverHome(PINNED, true));
        assertFalse(PinnedPipLaunch.canCoverHome(PINNED, false));
        assertTrue(PinnedPipLaunch.canCoverHome(FULLSCREEN, true));
        assertTrue(PinnedPipLaunch.canCoverHome(-1, true));   // unknown: as before
    }

    @Test
    void fytsPinnedStackDoesNotCoverTheHomeScreenUpToAndroid10() {
        // The launcher's own pinned YouTube, log 27-10-2026 23:31 (20.707, 27.374).
        assertFalse(PinnedPipLaunch.canCoverHome(FYT_PINNED, true));
    }

    @Test
    void modeSixIsAnyMultiWindowTaskFromAndroid11On() {
        assertTrue(PinnedPipLaunch.canCoverHome(FYT_PINNED, false));
    }
}
