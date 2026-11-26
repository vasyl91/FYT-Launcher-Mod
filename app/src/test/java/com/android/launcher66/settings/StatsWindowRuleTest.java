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

    @Test
    void theLauncherSettingsAreItsOwnScreenNotTheHomeScreen() {
        // the settings report the launcher's package while its activity is not resumed
        assertTrue(StatsWindowRule.ownScreen(true, false));
        // the home screen: the same package, the activity resumed
        assertFalse(StatsWindowRule.ownScreen(true, true));
        // another app is not the launcher's screen
        assertFalse(StatsWindowRule.ownScreen(false, false));
    }

    @Test
    void anAppsWindowOverTheSettingsAfterARestartGoesAndSoDoesTheHomeScreensWindow() {
        assertTrue(StatsWindowRule.removeForOwnScreen(APP, true, false));
        assertTrue(StatsWindowRule.removeForOwnScreen(HOME, true, false));
        // nothing shown: nothing to take away
        assertFalse(StatsWindowRule.removeForOwnScreen(NONE, true, false));
        // the home screen in front: its own code decides, as before
        assertFalse(StatsWindowRule.removeForOwnScreen(HOME, true, true));
        assertFalse(StatsWindowRule.removeForOwnScreen(APP, true, true));
        // an app that is not the launcher is the other rule's
        assertFalse(StatsWindowRule.removeForOwnScreen(APP, false, false));
    }

    @Test
    void anAppOfTheListComesBackAfterTheSettingsAreLeft() {
        // the settings took the window away (and noted it); the listed app is reported in front again
        assertTrue(StatsWindowRule.restoreForForeground(NONE, false, true, true));
    }

    @Test
    void theAppOfTheListIsForgottenOnlyWhenAnotherAppIsInFrontForReal() {
        // another app, the launcher not resumed
        assertTrue(StatsWindowRule.forgetForeground(false, false, false, true));
        // the panes' apps are reported while the home screen is in front: the launcher is resumed, nothing is forgotten
        assertFalse(StatsWindowRule.forgetForeground(true, false, false, true));
        // the launcher's own screens and apps of the list are not "another app"
        assertFalse(StatsWindowRule.forgetForeground(false, true, false, true));
        assertFalse(StatsWindowRule.forgetForeground(false, false, true, true));
        // a package with nothing to open (a volume panel) is not in front
        assertFalse(StatsWindowRule.forgetForeground(false, false, false, false));
    }

    @Test
    void anAppsWindowWaitsForTheFirstReportOfAnAppOfTheListAfterTheStart() {
        assertFalse(StatsWindowRule.mayShowAppWindow(false));
        assertTrue(StatsWindowRule.mayShowAppWindow(true));
    }

    @Test
    void anOverlayWindowOfTheLauncherIsNoScreenOfIt() {
        // the activities of the launcher begin with its package's name
        assertTrue(StatsWindowRule.isScreenOf("com.android.launcher66.settings.SettingsActivity", OWN));
        assertTrue(StatsWindowRule.isScreenOf("com.android.launcher66.Launcher", OWN));
        // its overlays (the statistics window, the bars' windows) are reported as views
        assertFalse(StatsWindowRule.isScreenOf("android.widget.FrameLayout", OWN));
        assertFalse(StatsWindowRule.isScreenOf("android.widget.LinearLayout", OWN));
        // a report without a class is the task tracker's: activities only
        assertTrue(StatsWindowRule.isScreenOf(null, OWN));
        assertTrue(StatsWindowRule.isScreenOf("", OWN));
        assertTrue(StatsWindowRule.isScreenOf("com.fyt.launcher.Home", "com.fyt.launcher"));
    }
}
