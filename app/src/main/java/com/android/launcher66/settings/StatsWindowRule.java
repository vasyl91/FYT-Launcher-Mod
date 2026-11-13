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
 *   <li>while this launcher is in front nothing is taken away here: its own code decides (the panes' apps are
 *       reported as "in front" by some sources while the home screen is shown);</li>
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
