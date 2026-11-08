package com.android.launcher66;

/**
 * How the edge handle gets the touches of its area: through an input monitor or through its own window.
 * Free of android.* so that the rule has a test.
 *
 * <p>With an input monitor the handle's window takes no touch at all (like the stats window): the input
 * dispatcher gives every touch to the window below, an app in a pane included, with no help from the
 * launcher, and the monitor only watches for the swipe that opens the bar (EdgeSwipeMonitor). A monitor
 * needs a system permission and Android 10; without one the handle's window takes the touches and hands
 * them on itself (EdgeHandlePass), which does not reach an app in a pane on the FYT head units with
 * Android 10.
 */
final class EdgeHandleInput {

    /** Who watches the touches of the handle's area. */
    enum Mode { MONITOR, WINDOW }

    private static final int FIRST_SDK_WITH_MONITOR = 29;

    private EdgeHandleInput() {
    }

    /**
     * @param sdk              Build.VERSION.SDK_INT
     * @param systemPrivileges the launcher is a system app and may monitor input
     * @param monitorStarted   the monitor was started (or is running)
     */
    static Mode mode(int sdk, boolean systemPrivileges, boolean monitorStarted) {
        return sdk >= FIRST_SDK_WITH_MONITOR && systemPrivileges && monitorStarted ? Mode.MONITOR : Mode.WINDOW;
    }

    /** Whether it is worth starting a monitor at all. */
    static boolean monitorPossible(int sdk, boolean systemPrivileges) {
        return sdk >= FIRST_SDK_WITH_MONITOR && systemPrivileges;
    }

    /** The reason for the mode, for the log. */
    static String reason(int sdk, boolean systemPrivileges, boolean monitorStarted) {
        if (sdk < FIRST_SDK_WITH_MONITOR) {
            return "Android " + sdk + " has no input monitor";
        }
        if (!systemPrivileges) {
            return "no system privileges";
        }
        return monitorStarted ? "input monitor started" : "input monitor not available";
    }
}
