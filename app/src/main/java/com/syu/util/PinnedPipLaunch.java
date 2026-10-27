package com.syu.util;

/**
 * The decisions behind starting the pinned PiP app, kept free of android.* so they can be tested
 * on the JVM. WindowUtil and DefaultDisplayTask do the reading and the acting.
 *
 * <p>Public because DefaultDisplayTask, which reads the tasks, lives in another package.
 */
public final class PinnedPipLaunch {

    /** WindowConfiguration.WINDOWING_MODE_PINNED on Android 10. */
    public static final int WINDOWING_MODE_PINNED = 2;

    private PinnedPipLaunch() {
    }

    /**
     * Whether a task is outside the pinned stack: its windowing mode is known and is not pinned, or
     * its display is known and is not the default one (the retired ActivityView of a window pane
     * lives on a virtual display). A negative value means "could not be read" and says nothing.
     */
    public static boolean outsidePinned(int windowingMode, int displayId) {
        return (windowingMode >= 0 && windowingMode != WINDOWING_MODE_PINNED)
                || (displayId >= 0 && displayId != 0);
    }

    /**
     * Whether the pinned PiP app has to be force-stopped before it is started again. A changed
     * package or size always does. A task of the package that lives outside the pinned stack does
     * too: FYT's framework moves it to the default display full screen instead of making a pinned
     * stack, and only a fresh start gets one. Not when the package is also in a window pane, whose
     * window the force-stop would kill on every return to the home screen.
     */
    public static boolean needsRestart(boolean packageChanged, boolean sizeChanged,
            boolean taskOutsidePinned, boolean alsoInWindowPane) {
        return packageChanged || sizeChanged || (taskOutsidePinned && !alsoInWindowPane);
    }

    /**
     * Whether a window pane (a slot that is on and not pinned) shows this package. The arrays hold
     * the four PiP slots in the same order.
     */
    public static boolean shownInWindowPane(String pkg, boolean[] slotOn, boolean[] slotPinned,
            String[] slotPackage) {
        if (pkg == null || pkg.isEmpty()) return false;
        for (int i = 0; i < slotOn.length; i++) {
            if (slotOn[i] && !slotPinned[i] && pkg.equals(slotPackage[i])) return true;
        }
        return false;
    }

    /**
     * Whether the pinned PiP app was started less than settleMs ago and may not have resumed yet.
     * startedAt is an uptime, 0 when it was never started.
     */
    public static boolean isSettling(long now, long startedAt, long settleMs) {
        return startedAt > 0 && now - startedAt < settleMs;
    }

    /**
     * Whether the pinned PiP may be started: not while the pages move (onPageEndMoving asks again),
     * only on the page it belongs to, and not over the app drawer.
     */
    public static boolean mayStartNow(boolean pagesMoving, int currentPage, int pipScreen,
            boolean allAppsVisible) {
        return !pagesMoving && currentPage == pipScreen && !allAppsVisible;
    }

    /**
     * Whether a task of this windowing mode can be what is shown full screen on the default
     * display. The pinned PiP floats over the home screen and is not what covers it. An unknown
     * mode (negative) counts as full screen, as before the mode was read at all.
     */
    public static boolean canCoverHome(int windowingMode) {
        return windowingMode != WINDOWING_MODE_PINNED;
    }
}
