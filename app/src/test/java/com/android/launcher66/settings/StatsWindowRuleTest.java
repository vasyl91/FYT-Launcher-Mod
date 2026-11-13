package com.android.launcher66.settings;

import static com.android.launcher66.settings.StatsWindowRule.Shown.APP;
import static com.android.launcher66.settings.StatsWindowRule.Shown.HOME;
import static com.android.launcher66.settings.StatsWindowRule.Shown.NONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatsWindowRuleTest {

    private static final String OWN = "com.android.launcher66";

    @Test
    void theTagSaysWhatIsShown() {
        assertEquals(HOME, StatsWindowRule.shown("main"));
        assertEquals(APP, StatsWindowRule.shown("app"));
        assertEquals(NONE, StatsWindowRule.shown(""));
        assertEquals(NONE, StatsWindowRule.shown(null));
    }

    @Test
    void theHomeWindowGoesWhenTheLauncherHasStopped() {
        // Home pressed on a phone where another launcher is the default: nothing else removes it there
        assertTrue(StatsWindowRule.removeWhenLauncherStopped(HOME));
    }

    @Test
    void anAppsWindowStaysWhenTheLauncherHasStopped() {
        // the listed app is what covers the launcher
        assertFalse(StatsWindowRule.removeWhenLauncherStopped(APP));
        assertFalse(StatsWindowRule.removeWhenLauncherStopped(NONE));
    }

    @Test
    void theHomeWindowGoesWhenAnotherLauncherIsInFront() {
        assertTrue(StatsWindowRule.removeForForeground(HOME, false, false, false, true));
    }

    @Test
    void theHomeWindowGoesEvenWhenAListedAppIsInFront() {
        // the app gets its own window from CanbusService; the home screen's one is not it
        assertTrue(StatsWindowRule.removeForForeground(HOME, false, false, true, true));
    }

    @Test
    void anAppsWindowGoesWhenAnAppOutsideTheListComesToTheFront() {
        assertTrue(StatsWindowRule.removeForForeground(APP, false, false, false, true));
    }

    @Test
    void anAppsWindowStaysOverAnotherListedApp() {
        assertFalse(StatsWindowRule.removeForForeground(APP, false, false, true, true));
    }

    @Test
    void nothingIsTakenAwayWhileTheLauncherIsInFront() {
        // a pane's app reported "in front" beside the home screen
        assertFalse(StatsWindowRule.removeForForeground(HOME, true, false, false, true));
        assertFalse(StatsWindowRule.removeForForeground(APP, true, false, false, true));
    }

    @Test
    void theLauncherItselfInFrontTakesNothingAway() {
        assertFalse(StatsWindowRule.removeForForeground(HOME, false, true, false, true));
        assertFalse(StatsWindowRule.removeForForeground(APP, false, true, false, true));
    }

    @Test
    void aPackageThatIsNoAppTakesNothingAway() {
        // the volume panel of the system UI, a dialog of a service
        assertFalse(StatsWindowRule.removeForForeground(HOME, false, false, false, false));
        assertFalse(StatsWindowRule.removeForForeground(APP, false, false, false, false));
    }

    @Test
    void anAppsWindowComesBackWhenAListedAppIsInFrontAgain() {
        assertTrue(StatsWindowRule.restoreForForeground(NONE, false, true, true));
    }

    @Test
    void itComesBackOnlyIfThisRuleTookItAway() {
        assertFalse(StatsWindowRule.restoreForForeground(NONE, false, true, false));
        assertFalse(StatsWindowRule.restoreForForeground(NONE, false, false, true));
        assertFalse(StatsWindowRule.restoreForForeground(NONE, true, true, true));
        assertFalse(StatsWindowRule.restoreForForeground(APP, false, true, true));
    }

    @Test
    void theFirmwaresLauncherNameIsThisLauncherToo() {
        assertTrue(StatsWindowRule.isOwn(OWN, OWN, ""));
        assertTrue(StatsWindowRule.isOwn("com.fyt.launcher", OWN, "com.fyt.launcher"));
        assertFalse(StatsWindowRule.isOwn("com.sec.android.app.launcher", OWN, ""));
        assertFalse(StatsWindowRule.isOwn("com.sec.android.app.launcher", OWN, null));
        assertFalse(StatsWindowRule.isOwn(null, OWN, OWN));
    }
}
