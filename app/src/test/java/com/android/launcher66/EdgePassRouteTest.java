package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.android.launcher66.EdgePassRoute.Route;
import com.android.launcher66.EdgePassRoute.TargetKind;

import org.junit.jupiter.api.Test;

class EdgePassRouteTest {

    @Test
    void launcherAndVdViewAlwaysUseTheViewTree() {
        for (int sdk = 26; sdk <= 36; sdk++) {
            assertEquals(Route.VIEW_TREE, EdgePassRoute.of(sdk, TargetKind.LAUNCHER));
            assertEquals(Route.VIEW_TREE, EdgePassRoute.of(sdk, TargetKind.VD_VIEW));
        }
    }

    @Test
    void activityViewIsInjectedFromAndroid10() {
        for (int sdk = 26; sdk <= 28; sdk++) {
            assertEquals(Route.VIEW_TREE, EdgePassRoute.of(sdk, TargetKind.ACTIVITY_VIEW));
        }
        for (int sdk = 29; sdk <= 36; sdk++) {
            assertEquals(Route.DISPLAY_INJECT, EdgePassRoute.of(sdk, TargetKind.ACTIVITY_VIEW));
        }
    }
}
