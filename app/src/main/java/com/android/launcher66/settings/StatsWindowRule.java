package com.android.launcher66.settings;

/**
 * Who a statistics window belongs to, and when it has to go because that owner is no longer in front.
 *
 * <p>There is one window, shown in one of two ways: over the launcher's own home screen (HOME), or over an app
 * the user chose in "Apps with the statistics" (APP). The rules:
 * <ul>
 *   <li>the home screen's window belongs to this launcher's home screen. It goes when the launcher has
 *       stopped, whatever else happens (it used to go only with the PiP panes, which are not removed where no
 *       host for them is there, so it stayed over the next app or over another launcher), and when another app
 *       is reported in front while the launcher is not;</li>
 *   <li>an app's window belongs to the apps of the list. It goes when an app that is not in the list comes to
 *       the front, another launcher included, and comes back when a listed app is in front again;</li>
 *   <li>while this launcher's home screen is in front nothing is taken away here: its own code decides (the
 *       panes' apps are reported as "in front" by some sources while the home screen is shown);</li>
 *   <li>the launcher's own other screens (its settings, a dialog activity) are not its home screen, though they
 *       report the same package: while one of them is in front, with the launcher's activity not resumed, no
 *       window is shown over it. The window of an app, shown after a restart over the settings (A55, 2026-11-25),
 *       and the home screen's window go; an app's window comes back when an app of the list is reported
 *       again ({@link #ownScreen}, {@link #removeForOwnScreen});</li>
 *   <li>after the process starts nothing is known about the app in front: an app's window waits for the first
 *       report of an app of the list ({@link #mayShowAppWindow});</li>
 *   <li>only an app counts as "in front": a package with nothing to open (the system's volume panel, a
 *       service's dialog) is no reason to take a window away.</li>
 * </ul>
 * The rule only removes what does not belong, and puts back an app's window it removed itself; when the windows
 * are shown in the first place stays with CanbusService. Pure Java, so that it has a test.
 */
final class StatsWindowRule {

    /** What is on the screen now. */
    enum Shown { NONE, HOME, APP }

    private StatsWindowRule() {
    }

    /** From the tag CanbusService keeps: "main", "app" or nothing. */
    static Shown shown(String tag) {
        if ("main".equals(tag)) {
            return Shown.HOME;
        }
        return "app".equals(tag) ? Shown.APP : Shown.NONE;
    }

    /** The launcher has stopped (not a brief stop): the home screen's window goes, an app's stays. */
    static boolean removeWhenLauncherStopped(Shown shown) {
        return shown == Shown.HOME;
    }

    /**
     * Whether a package is this launcher: its own package, or the one the firmware names as the launcher
     * (FYT's persist.launcher.packagename), which CanbusService has always taken for it.
     */
    static boolean isOwn(String packageName, String ownPackage, String firmwareLauncher) {
        if (packageName == null) {
            return false;
        }
        return packageName.equals(ownPackage)
                || (firmwareLauncher != null && !firmwareLauncher.isEmpty() && packageName.equals(firmwareLauncher));
    }

    /**
     * An app was reported in front: whether the window that is shown has to go.
     *
     * @param launcherResumed this launcher's home screen is in front
     * @param foregroundIsOwn the reported package is this launcher
     * @param foregroundInList the reported package is in the list of apps with the statistics
     * @param foregroundIsApp the reported package is an app (it has something to open, or is a launcher)
     */
    static boolean removeForForeground(Shown shown, boolean launcherResumed, boolean foregroundIsOwn,
                                       boolean foregroundInList, boolean foregroundIsApp) {
        if (shown == Shown.NONE || launcherResumed || foregroundIsOwn || !foregroundIsApp) {
            return false;
        }
        if (shown == Shown.HOME) {
            return true;   // another app, or another launcher, is in front of the home screen's window
        }
        return !foregroundInList;
    }

    /**
     * A screen of this launcher that is not its home screen: the package reported is the launcher's own (or the
     * firmware's launcher) and the launcher's activity is not resumed. The settings share the package of the
     * home screen, so the package alone cannot tell them apart.
     */
    static boolean ownScreen(boolean foregroundIsOwn, boolean launcherResumed) {
        return foregroundIsOwn && !launcherResumed;
    }

    /** Whether the window that is shown goes because the launcher's own screen, not its home screen, is in front. */
    static boolean removeForOwnScreen(Shown shown, boolean foregroundIsOwn, boolean launcherResumed) {
        return shown != Shown.NONE && ownScreen(foregroundIsOwn, launcherResumed);
    }

    /**
     * Whether a report names a screen (an activity) of the package, not a window that the package's overlay put up. The
     * accessibility service reports the windows of this launcher's overlays (the statistics window, the bars' windows,
     * the edge handle) with its package too, as views: their class is a view class. An activity's class begins with the
     * package's name. A report without a class (the task tracker's, which sees activities only) is an activity.
     */
    static boolean isScreenOf(String className, String packageName) {
        if (className == null || className.isEmpty() || packageName == null) {
            return true;
        }
        return className.startsWith(packageName + ".") || className.startsWith(packageName + "/");
    }

    /**
     * Whether the package of the app that was last reported in front is forgotten: an app that is not in the list
     * is in front for real (the launcher is not resumed, it is not this launcher), so the app of the list that was
     * in front before it is not in front any more.
     */
    static boolean forgetForeground(boolean launcherResumed, boolean foregroundIsOwn, boolean foregroundInList,
                                    boolean foregroundIsApp) {
        return !launcherResumed && !foregroundIsOwn && !foregroundInList && foregroundIsApp;
    }

    /**
     * Whether an app's window may be put up: not before an app of the list has been reported in front since the
     * process started, because what was in front before a restart is not known.
     */
    static boolean mayShowAppWindow(boolean foregroundKnown) {
        return foregroundKnown;
    }

    /**
     * Whether an app's window that was taken away for an app outside the list is put back: a listed app is in
     * front again and nothing is shown.
     *
     * @param removedForOtherApp the window was removed by {@link #removeForForeground} and not shown since
     */
    static boolean restoreForForeground(Shown shown, boolean launcherResumed, boolean foregroundInList,
                                        boolean removedForOtherApp) {
        return shown == Shown.NONE && !launcherResumed && foregroundInList && removedForOtherApp;
    }
}
