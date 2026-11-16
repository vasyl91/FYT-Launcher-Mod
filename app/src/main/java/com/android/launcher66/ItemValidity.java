package com.android.launcher66;

/**
 * Whether an icon of an app on the home screen is shown, mended or kept hidden.
 *
 * <p>The rules:
 * <ul>
 * <li>An icon is shown when its activity can be started, found the way the list of apps finds activities
 * (an activity alias too). The loader used to ask for the activity's own entry alone, and the owner saw icons
 * that were dropped from the list of apps disappear at the next load, which a change of the grid brings
 * (2026-11-16).</li>
 * <li>An icon of an app that is still installed, but whose activity is gone (the app gave its first activity
 * another name in an update), starts the app's current first activity: the row is mended and the icon is
 * shown. Only an icon of an app is mended this way, not a shortcut into an app.</li>
 * <li>Otherwise the icon is hidden and its row kept: the app is not installed (or not yet, at a boot), or it is
 * disabled. A real uninstall removes the row elsewhere.</li>
 * </ul>
 * The reason is part of the answer, so the log says why an icon is not shown. Pure Java, so that it has a test.
 */
final class ItemValidity {

    enum Verdict { SHOW, MEND, HIDE }

    /** A verdict and why. */
    static final class Result {
        final Verdict verdict;
        final String reason;

        Result(Verdict verdict, String reason) {
            this.verdict = verdict;
            this.reason = reason;
        }
    }

    private ItemValidity() {
    }

    /**
     * @param packageFound     the app is installed for this user
     * @param appEnabled       the app is enabled
     * @param activityFound    the icon's activity can be started
     * @param launchActivity   the app has a first activity (the one its launch intent starts)
     * @param mendable         the icon is an app's icon, not a shortcut into it
     */
    static Result of(boolean packageFound, boolean appEnabled, boolean activityFound, boolean launchActivity,
                     boolean mendable) {
        if (!packageFound) {
            return new Result(Verdict.HIDE, "the app is not installed");
        }
        if (!appEnabled) {
            return new Result(Verdict.HIDE, "the app is disabled");
        }
        if (activityFound) {
            return new Result(Verdict.SHOW, "ok");
        }
        if (launchActivity && mendable) {
            return new Result(Verdict.MEND, "the activity is gone from the app, its first activity is started");
        }
        return new Result(Verdict.HIDE, launchActivity
                ? "the activity is gone from the app (a shortcut, not mended)"
                : "the activity is gone from the app, which has no first activity");
    }
}
