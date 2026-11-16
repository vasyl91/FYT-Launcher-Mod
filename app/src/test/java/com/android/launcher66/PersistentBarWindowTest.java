package com.android.launcher66;

import static com.android.launcher66.PersistentBarWindow.Action.ACTIVATE;
import static com.android.launcher66.PersistentBarWindow.Action.BUILD_SHOWN;
import static com.android.launcher66.PersistentBarWindow.Action.BUILD_STANDBY;
import static com.android.launcher66.PersistentBarWindow.Action.NOTHING;
import static com.android.launcher66.PersistentBarWindow.Action.PARK;
import static com.android.launcher66.PersistentBarWindow.Action.REMOVE;
import static com.android.launcher66.PersistentBarWindow.State.NONE;
import static com.android.launcher66.PersistentBarWindow.State.SHOWN;
import static com.android.launcher66.PersistentBarWindow.State.STANDBY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PersistentBarWindowTest {

    private static PersistentBarWindow.State target(boolean mode, boolean permitted, boolean overlay,
                                                    boolean free) {
        return PersistentBarWindow.target(mode, permitted, overlay, free);
    }

    @Test
    void thereIsNoWindowWithoutTheModeOrThePermission() {
        assertEquals(NONE, target(false, true, true, true));
        assertEquals(NONE, target(true, false, true, true));
        assertEquals(NONE, target(false, false, false, false));
        // whatever the bar and the free state say
        for (boolean overlay : new boolean[] {false, true}) {
            for (boolean free : new boolean[] {false, true}) {
                assertEquals(NONE, target(false, true, overlay, free));
                assertEquals(NONE, target(true, false, overlay, free));
            }
        }
    }

    @Test
    void theBarIsShownWhenItIsTheOverlaysAndNothingElseIsInItsPlace() {
        assertEquals(SHOWN, target(true, true, true, true));
    }

    @Test
    void everyOtherCaseWaitsInStandby() {
        // the first page at rest (the page's own bar), and with something in the bar's place:
        // all apps, the overview, a drag, a folder, the list of apps
        assertEquals(STANDBY, target(true, true, false, true));
        assertEquals(STANDBY, target(true, true, true, false));
        assertEquals(STANDBY, target(true, true, false, false));
    }

    @Test
    void anAppInFrontDoesNotTakeTheWindowAway() {
        // nothing in the rule asks whether the launcher is in front: the window goes and comes with the
        // launcher's window, and a decision taken meanwhile is the same as in front
        for (boolean overlay : new boolean[] {false, true}) {
            for (boolean free : new boolean[] {false, true}) {
                assertEquals(overlay && free ? SHOWN : STANDBY, target(true, true, overlay, free));
            }
        }
    }

    @Test
    void everyRowOfTheActionTableAtRest() {
        // target NONE
        assertEquals(NOTHING, PersistentBarWindow.action(NONE, NONE, false));
        assertEquals(REMOVE, PersistentBarWindow.action(STANDBY, NONE, false));
        assertEquals(REMOVE, PersistentBarWindow.action(SHOWN, NONE, false));
        // target STANDBY
        assertEquals(BUILD_STANDBY, PersistentBarWindow.action(NONE, STANDBY, false));
        assertEquals(NOTHING, PersistentBarWindow.action(STANDBY, STANDBY, false));
        assertEquals(PARK, PersistentBarWindow.action(SHOWN, STANDBY, false));
        // target SHOWN
        assertEquals(BUILD_SHOWN, PersistentBarWindow.action(NONE, SHOWN, false));
        assertEquals(ACTIVATE, PersistentBarWindow.action(STANDBY, SHOWN, false));
        assertEquals(NOTHING, PersistentBarWindow.action(SHOWN, SHOWN, false));
    }

    @Test
    void nothingIsBuiltOrShownWhileThePagesMove() {
        for (PersistentBarWindow.State current : PersistentBarWindow.State.values()) {
            for (PersistentBarWindow.State target : PersistentBarWindow.State.values()) {
                PersistentBarWindow.Action moving = PersistentBarWindow.action(current, target, true);
                assertNotEquals(BUILD_STANDBY, moving, current + " -> " + target);
                assertNotEquals(BUILD_SHOWN, moving, current + " -> " + target);
                assertNotEquals(ACTIVATE, moving, current + " -> " + target);
            }
        }
    }

    @Test
    void theWindowGoesAwayWhileThePagesMoveToo() {
        assertEquals(PARK, PersistentBarWindow.action(SHOWN, STANDBY, true));
        assertEquals(REMOVE, PersistentBarWindow.action(SHOWN, NONE, true));
        assertEquals(REMOVE, PersistentBarWindow.action(STANDBY, NONE, true));
    }

    @Test
    void aBarShownAtRestHasNothingToDoWhenAMoveBegins() {
        // every page has the window, the first too: shown at rest, still shown in the move
        PersistentBarWindow.State resting = target(true, true, true, true);
        assertEquals(SHOWN, resting);
        assertEquals(NOTHING, PersistentBarWindow.action(resting, target(true, true, true, true), true));
    }
}
