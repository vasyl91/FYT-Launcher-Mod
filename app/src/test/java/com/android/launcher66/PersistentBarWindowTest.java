package com.android.launcher66;

import static com.android.launcher66.PersistentBarWindow.Action.ACTIVATE;
import static com.android.launcher66.PersistentBarWindow.Action.BUILD_LATER;
import static com.android.launcher66.PersistentBarWindow.Action.BUILD_NOW;
import static com.android.launcher66.PersistentBarWindow.Action.NOTHING;
import static com.android.launcher66.PersistentBarWindow.Action.PARK;
import static com.android.launcher66.PersistentBarWindow.Action.REMOVE;
import static com.android.launcher66.PersistentBarWindow.State.NONE;
import static com.android.launcher66.PersistentBarWindow.State.SHOWN;
import static com.android.launcher66.PersistentBarWindow.State.STANDBY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersistentBarWindowTest {

    private static PersistentBarWindow.State target(boolean mode, boolean front, boolean permitted,
                                                    boolean overlay, boolean free) {
        return PersistentBarWindow.target(mode, front, permitted, overlay, free);
    }

    @Test
    void thereIsNoWindowWithoutTheModeTheLauncherInFrontOrThePermission() {
        assertEquals(NONE, target(false, true, true, true, true));
        assertEquals(NONE, target(true, false, true, true, true));
        assertEquals(NONE, target(true, true, false, true, true));
        assertEquals(NONE, target(false, false, false, false, false));
        // whatever the bar and the free state say
        for (boolean overlay : new boolean[] {false, true}) {
            for (boolean free : new boolean[] {false, true}) {
                assertEquals(NONE, target(false, true, true, overlay, free));
                assertEquals(NONE, target(true, false, true, overlay, free));
                assertEquals(NONE, target(true, true, false, overlay, free));
            }
        }
    }

    @Test
    void theBarIsShownWhenItIsTheOverlaysAndNothingElseIsInItsPlace() {
        assertEquals(SHOWN, target(true, true, true, true, true));
    }

    @Test
    void everyOtherCaseWaitsInStandby() {
        // the first page at rest (the page's own bar), and with something in the bar's place:
        // all apps, the overview, a drag, a folder, the list of apps
        assertEquals(STANDBY, target(true, true, true, false, true));
        assertEquals(STANDBY, target(true, true, true, true, false));
        assertEquals(STANDBY, target(true, true, true, false, false));
    }

    @Test
    void everyRowOfTheActionTable() {
        // target NONE
        assertEquals(NOTHING, PersistentBarWindow.action(NONE, NONE, false));
        assertEquals(REMOVE, PersistentBarWindow.action(STANDBY, NONE, false));
        assertEquals(REMOVE, PersistentBarWindow.action(SHOWN, NONE, false));
        // target STANDBY
        assertEquals(BUILD_LATER, PersistentBarWindow.action(NONE, STANDBY, false));
        assertEquals(NOTHING, PersistentBarWindow.action(STANDBY, STANDBY, false));
        assertEquals(PARK, PersistentBarWindow.action(SHOWN, STANDBY, false));
        // target SHOWN
        assertEquals(BUILD_NOW, PersistentBarWindow.action(NONE, SHOWN, false));
        assertEquals(ACTIVATE, PersistentBarWindow.action(STANDBY, SHOWN, false));
        assertEquals(NOTHING, PersistentBarWindow.action(SHOWN, SHOWN, false));
    }

    @Test
    void theActionsDoNotDependOnTheMovingPagesExceptForTheWindowThatIsNotNeededYet() {
        for (PersistentBarWindow.State current : PersistentBarWindow.State.values()) {
            for (PersistentBarWindow.State target : PersistentBarWindow.State.values()) {
                PersistentBarWindow.Action rest = PersistentBarWindow.action(current, target, false);
                PersistentBarWindow.Action moving = PersistentBarWindow.action(current, target, true);
                if (current == NONE && target == STANDBY) {
                    assertEquals(BUILD_LATER, rest);
                    assertEquals(NOTHING, moving, "not built in a gesture");
                } else {
                    assertEquals(rest, moving, current + " -> " + target);
                }
            }
        }
    }

    @Test
    void theBarNeededAtTheFirstMomentOfAMoveIsActivatedNotBuilt() {
        // the first page at rest: standby; the move begins: the target is shown
        PersistentBarWindow.State resting = target(true, true, true, false, true);
        PersistentBarWindow.State moving = target(true, true, true, true, true);
        assertEquals(ACTIVATE, PersistentBarWindow.action(resting, moving, true));
    }

    @Test
    void aMoveThatBeginsDuringTheFadeOutIsAnActivationOfTheExistingWindow() {
        // a window that is still fading out after the return to the first page counts as standby
        assertEquals(ACTIVATE, PersistentBarWindow.action(STANDBY, SHOWN, true));
    }
}
