package com.android.launcher66;

/**
 * How the edge handle hands a touch on to what lies under it. Chosen once at the DOWN, for the
 * whole sequence up to UP / CANCEL. Pure, so that the rule has a test.
 *
 * <p>Handing the events to the target's view tree works for the launcher's own views and for a
 * WindowHostVdView, which injects the touch through the VD host itself. The framework's
 * ActivityView forwards touches to its display only on Android 8 and 9; from Android 10 the input
 * dispatcher sends them straight to the window on the virtual display, so a touch dispatched to the
 * view never reaches the app. For such a view the event is injected on its display.
 */
final class EdgePassRoute {

    enum TargetKind { LAUNCHER, VD_VIEW, ACTIVITY_VIEW }

    enum Route { VIEW_TREE, DISPLAY_INJECT }

    private EdgePassRoute() {
    }

    static Route of(int sdk, TargetKind kind) {
        if (kind == TargetKind.ACTIVITY_VIEW && sdk >= 29) {
            return Route.DISPLAY_INJECT;
        }
        return Route.VIEW_TREE;
    }
}
