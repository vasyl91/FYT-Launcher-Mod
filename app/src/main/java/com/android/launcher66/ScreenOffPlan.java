package com.android.launcher66;

/**
 * How the home screen's double tap "Turn off screen" turns the screen off, and what it never does.
 *
 * <p>The rules (the owner, 2026-11-25, D-91):
 * <ul>
 *   <li>On an FYT unit whose main module (com.syu.ms) is connected, the launcher sends the command of the stock
 *       tile, {@code C_BLACKSCREEN} with the argument 2, and the system does the rest: the screen goes black without a
 *       sleep and comes back with a double tap of the system's own ({@code WakeSignals}: "Black screen on (not a
 *       sleep)"). Without the module the route is the other one.</li>
 *   <li>Everywhere else the launcher puts a black window over everything ({@link ScreenOffOverlay}), turns the brightness
 *       of that window to the least and keeps the screen on, and a double tap on it closes it. It does not lock
 *       the device, put it to sleep or wake it; the window goes at once when the user puts the device to sleep with the
 *       power button, so that it is not black on waking. It needs the permission to draw over other apps, which
 *       the permission flow already asks for.</li>
 *   <li>Without that permission nothing is done and the user is told (the setting remains, the permission flow asks
 *       for it again at the next return to the home screen).</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class ScreenOffPlan {

    enum Route { SYSTEM_COMMAND, OVERLAY, NEEDS_OVERLAY_PERMISSION }

    private ScreenOffPlan() {
    }

    static Route route(boolean fytUnit, boolean mainModuleConnected, boolean canDrawOverOthers) {
        if (fytUnit && mainModuleConnected) {
            return Route.SYSTEM_COMMAND;
        }
        return canDrawOverOthers ? Route.OVERLAY : Route.NEEDS_OVERLAY_PERMISSION;
    }
}
