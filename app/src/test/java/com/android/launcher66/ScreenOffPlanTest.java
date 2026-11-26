package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScreenOffPlanTest {

    @Test
    void anFytUnitWithItsMainModuleUsesTheStockCommand() {
        assertEquals(ScreenOffPlan.Route.SYSTEM_COMMAND, ScreenOffPlan.route(true, true, true));
        // the permission to draw over other apps is not needed for the command
        assertEquals(ScreenOffPlan.Route.SYSTEM_COMMAND, ScreenOffPlan.route(true, true, false));
    }

    @Test
    void anFytUnitWithoutItsMainModuleAndOtherDevicesUseTheBlackWindow() {
        assertEquals(ScreenOffPlan.Route.OVERLAY, ScreenOffPlan.route(true, false, true));
        assertEquals(ScreenOffPlan.Route.OVERLAY, ScreenOffPlan.route(false, false, true));
        // a main module that is not an FYT unit's is not used
        assertEquals(ScreenOffPlan.Route.OVERLAY, ScreenOffPlan.route(false, true, true));
    }

    @Test
    void withoutThePermissionToDrawOverOtherAppsNothingIsDoneAndItIsAsked() {
        assertEquals(ScreenOffPlan.Route.NEEDS_OVERLAY_PERMISSION, ScreenOffPlan.route(false, false, false));
        assertEquals(ScreenOffPlan.Route.NEEDS_OVERLAY_PERMISSION, ScreenOffPlan.route(true, false, false));
    }
}
