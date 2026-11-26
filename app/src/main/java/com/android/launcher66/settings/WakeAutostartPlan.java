package com.android.launcher66.settings;

/**
 * "Start on wake": when the apps of that list are opened after a wake from sleep, and what comes to the front after
 * them, free of android.* so that it has a test.
 *
 * <p>The rule (the owner, 2026-11-22): a list of its own, under "Start on boot", whose apps are opened at every wake
 * from sleep; "Start on boot" stays for a restart of the device only (ColdStart).
 * <ul>
 *   <li>only a real wake ({@link #runs}): not the start of the launcher's process, which a restart of the device is
 *       too (WakeSignals.RESTART);</li>
 *   <li>the first app {@link #FIRST_MS} after the wake, once the wake's own work is done (its refreshes at 0.9 and
 *       1.8 s, the app from before the sleep brought back), the others {@link #GAP_MS} apart, as at a boot;</li>
 *   <li>after the last one, what the wake itself would show comes back to the front ({@link #returnTo}): the launcher
 *       with "Launcher home on wake" on, or when the home screen was in front at the sleep; else the app that was in
 *       front at the sleep, if it is known; else nothing;</li>
 *   <li>nothing is moved when the user has done something since the wake (DECISIONS D-28), or when none of the apps
 *       opened is in front (one closed itself, or the user opened another);</li>
 *   <li>a sleep in between stops it.</li>
 * </ul>
 */
public final class WakeAutostartPlan {

    /** The first app this long after the wake. */
    public static final long FIRST_MS = 3_000L;
    /** Between two apps, and before the front is put back after the last one. */
    public static final long GAP_MS = 3_000L;

    /** What comes to the front after the apps were opened. */
    public enum ReturnTo { LAUNCHER, APP_BEFORE_SLEEP, NOTHING }

    private WakeAutostartPlan() {
    }

    /** How one app of the list is started. */
    public enum Route { TITLES_BROADCAST, JAMES_BROADCAST, BOOT_COMPLETED, LAUNCH_ACTIVITY, SKIP }

    /**
     * The way an app of the list is started at a wake, the same as at a boot (the owner, 2026-11-25, D-83): Display Media Titles
     * and JamesDSP by their own broadcasts, which try BOOT_COMPLETED first; any other app that has a BOOT_COMPLETED receiver by
     * that broadcast, while the switch "Try to use the BOOT_COMPLETED broadcast" is on and the launcher can send it; the
     * rest by their launch activity. An app none of these fits is skipped.
     *
     * @param hasBootReceiver whether the app has a BOOT_COMPLETED receiver (false where the launcher cannot send it)
     * @param bootSetting     the switch of the broadcast
     * @param canSend         whether the launcher can send BOOT_COMPLETED now
     */
    public static Route route(boolean displayMediaTitles, boolean jamesDsp, boolean hasBootReceiver, boolean bootSetting,
                              boolean canSend, boolean hasLaunchActivity) {
        if (displayMediaTitles) {
            return Route.TITLES_BROADCAST;
        }
        if (jamesDsp) {
            return Route.JAMES_BROADCAST;
        }
        if (hasBootReceiver && bootSetting && canSend) {
            return Route.BOOT_COMPLETED;
        }
        return hasLaunchActivity ? Route.LAUNCH_ACTIVITY : Route.SKIP;
    }

    /** Whether a wake starts the list: not the start of the process. */
    public static boolean runs(boolean processStart) {
        return !processStart;
    }

    /**
     * @param homeOnWake  "Launcher home on wake"
     * @param frontBefore what was in front at the sleep: a package, "" for the home screen, null if not known
     * @param topIsOurs   one of the apps just opened is in front
     * @param userActed   the user has done something since the wake
     */
    public static ReturnTo returnTo(boolean homeOnWake, String frontBefore, boolean topIsOurs, boolean userActed) {
        if (!topIsOurs || userActed) {
            return ReturnTo.NOTHING;
        }
        if (homeOnWake || "".equals(frontBefore)) {
            return ReturnTo.LAUNCHER;
        }
        return frontBefore != null ? ReturnTo.APP_BEFORE_SLEEP : ReturnTo.NOTHING;
    }
}
