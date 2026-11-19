package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarGhostRuleTest {

    @Test
    void atFullSizeTheWindowsShowTheBars() {
        assertFalse(BarGhostRule.shown(false, false, false));
    }

    @Test
    void inTheOverviewAndWhileAnIconIsDraggedThePicturesAreUp() {
        assertTrue(BarGhostRule.shown(true, false, false));
    }

    @Test
    void theyStayUntilThePagesAreAtFullSizeAgain() {
        // On the way in the state is already "small"; on the way back it is already "normal"
        assertTrue(BarGhostRule.shown(true, true, false));
        assertTrue(BarGhostRule.shown(false, true, false));
    }

    @Test
    void whileAnItemOfAPageIsMovedAtFullSizeThePicturesAreUpToo() {
        // The windows step aside for the drag (and a folder, the list of apps of a bar): the owner, 2026-11-19
        assertTrue(BarGhostRule.shown(false, false, true));
    }

    @Test
    void theFirstPageHasItsBarsInItself() {
        assertFalse(BarGhostRule.onPage(true, true));
    }

    @Test
    void aPageAfterTheFirstHasThePictureOfABarThatStaysOnIt() {
        assertTrue(BarGhostRule.onPage(false, true));
    }

    @Test
    void aBarThatIsNotOnEveryPageOrHidesItselfHasNoPicture() {
        assertFalse(BarGhostRule.onPage(false, false));
    }
}
