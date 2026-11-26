package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WakeAutostartPlanTest {

    @Test
    void onlyARealWakeStartsTheListNotTheStartOfTheProcess() {
        assertTrue(WakeAutostartPlan.runs(false));
        assertFalse(WakeAutostartPlan.runs(true), "a restart of the device has \"Start on boot\"");
    }

    @Test
    void theLauncherComesBackWithHomeOnWakeOrWhenTheHomeScreenWasInFront() {
        assertEquals(WakeAutostartPlan.ReturnTo.LAUNCHER, WakeAutostartPlan.returnTo(true, "com.maps", true, false));
        assertEquals(WakeAutostartPlan.ReturnTo.LAUNCHER, WakeAutostartPlan.returnTo(false, "", true, false));
    }

    @Test
    void otherwiseTheAppFromBeforeTheSleepIfItIsKnown() {
        assertEquals(WakeAutostartPlan.ReturnTo.APP_BEFORE_SLEEP,
                WakeAutostartPlan.returnTo(false, "com.maps", true, false));
        assertEquals(WakeAutostartPlan.ReturnTo.NOTHING, WakeAutostartPlan.returnTo(false, null, true, false));
    }

    @Test
    void nothingMovesWhenTheUserActedOrNoneOfTheAppsIsInFront() {
        assertEquals(WakeAutostartPlan.ReturnTo.NOTHING, WakeAutostartPlan.returnTo(true, "", true, true));
        assertEquals(WakeAutostartPlan.ReturnTo.NOTHING, WakeAutostartPlan.returnTo(true, "", false, false));
    }

    @Test
    void theFirstAppComesAfterTheWakesOwnWork() {
        assertTrue(WakeAutostartPlan.FIRST_MS > 1_800, "after the late refresh of the wake");
        assertEquals(3_000, WakeAutostartPlan.GAP_MS);
    }

    // ---- the way an app is started (D-83, 2026-11-25): as at a boot

    private static WakeAutostartPlan.Route route(boolean titles, boolean james, boolean receiver, boolean setting,
                                                 boolean canSend, boolean launch) {
        return WakeAutostartPlan.route(titles, james, receiver, setting, canSend, launch);
    }

    @Test
    void anAppWithABootReceiverIsWokenByTheBroadcastWhileTheSwitchIsOnAndItCanBeSent() {
        assertEquals(WakeAutostartPlan.Route.BOOT_COMPLETED, route(false, false, true, true, true, true));
        assertEquals(WakeAutostartPlan.Route.BOOT_COMPLETED, route(false, false, true, true, true, false),
                "an app with no launch activity is woken by the broadcast all the same");
    }

    @Test
    void withTheSwitchOffOrNoWayToSendItTheAppIsOpened() {
        assertEquals(WakeAutostartPlan.Route.LAUNCH_ACTIVITY, route(false, false, true, false, true, true));
        assertEquals(WakeAutostartPlan.Route.LAUNCH_ACTIVITY, route(false, false, true, true, false, true));
        assertEquals(WakeAutostartPlan.Route.LAUNCH_ACTIVITY, route(false, false, false, true, true, true));
    }

    @Test
    void displayMediaTitlesAndJamesDspKeepTheirOwnBroadcasts() {
        assertEquals(WakeAutostartPlan.Route.TITLES_BROADCAST, route(true, false, true, true, true, true));
        assertEquals(WakeAutostartPlan.Route.JAMES_BROADCAST, route(false, true, false, false, false, false));
    }

    @Test
    void anAppThatCannotBeStartedAnyWayIsSkipped() {
        assertEquals(WakeAutostartPlan.Route.SKIP, route(false, false, false, true, true, false));
        assertEquals(WakeAutostartPlan.Route.SKIP, route(false, false, true, false, true, false));
    }
}
