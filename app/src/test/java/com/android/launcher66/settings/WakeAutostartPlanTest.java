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
}
