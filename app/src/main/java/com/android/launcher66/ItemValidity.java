package com.android.launcher66;

/**
 * Whether an icon of an app on the home screen is shown, mended or kept hidden.
 *
 * <p>The rules:
 * <ul>
 * <li>An icon is shown when its activity can be started: it is in the list of apps (the same query, for its
 * package), or the system resolves it (an activity alias too). That decides alone. The app's "enabled" flag
 * does not: the A55 reported it false for Authenticator, Alior, Anki, Booksy and Bolt while the list of apps
 * showed them and they could be dragged out of it, and the loader hid every such icon at the next load, which a
 * change of the grid brings (2026-11-16). The flag only names the reason when nothing can be started.</li>
 * <li>An icon of an app that is still installed, but whose activity is gone (the app gave its first activity
 * another name in an update), starts the app's current first activity: the row is mended and the icon is
 * shown. Only an icon of an app is mended this way, not a shortcut into an app.</li>
 * <li>Otherwise the icon is hidden and its row kept: the app is not installed (or not yet, at a boot), or the
 * system starts none of its activities. A real uninstall removes the row elsewhere.</li>
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
        if (activityFound) {
            return new Result(Verdict.SHOW, "ok");
        }
        if (!packageFound) {
            return new Result(Verdict.HIDE, "the app is not installed");
        }
        if (launchActivity && mendable) {
            return new Result(Verdict.MEND, "the activity is gone from the app, its first activity is started");
        }
        if (!appEnabled) {
            return new Result(Verdict.HIDE, "the app is disabled and none of its activities can be started");
        }
        return new Result(Verdict.HIDE, launchActivity
                ? "the activity is gone from the app (a shortcut, not mended)"
                : "the activity is gone from the app, which has no first activity");
    }
}
