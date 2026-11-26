package com.android.launcher66;

/**
 * What the launcher does before the user has unlocked the device (direct boot), and when it finishes its start.
 *
 * <p>The rules:
 * <ul>
 *   <li>A launcher that is not direct boot aware is not started before the first unlock: the system shows its
 *       fallback home (a black window on the A55 after a restart, log of 2026-11-25). The launcher's
 *       activity is direct boot aware, so it is started at once, and while the user is locked it only shows
 *       the wallpaper (the theme's window background) and waits for the unlock.</li>
 *   <li>While locked nothing reads credential encrypted storage: no preference file, no database, no file of
 *       the app's files folder, and nothing is started that does (the services, the receivers, the model).
 *       Android refuses those reads with an exception ("not available until the user is unlocked"). Only
 *       the crash handler and the statics that need no storage are set up.</li>
 *   <li>The unlock completes the start once, with the same steps an unlocked start takes at once, and then the
 *       activity is made again so that it loads the home screen.</li>
 *   <li>On a unit whose user is unlocked from the start (the FYT units are not encrypted) the path is the
 *       old one, step for step.</li>
 *   <li><b>No class reads storage when it loads</b> (no static field or static block opens a preference file, a
 *       database or a file), and the Launcher activity's field initializers read none either: they run before
 *       onCreate() and its check of the lock. A static read in Helpers did, and the round 28 build hung the A55 at
 *       boot (the owner, 2026-11-26): the activity could not be made, the home was started again and again.
 *       StorageAtClassLoadTest scans the sources for it; LockedStartViewTest makes the activity while the storage
 *       is locked.</li>
 *   <li>Until the owner confirms it on the A55 the activity is direct boot aware in debug builds only
 *       ({@code launcherDirectBoot} in build.gradle.kts); release builds start after the unlock as before.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class DirectBootPlan {

    /** How the process started. */
    enum Start { FULL, WALLPAPER_ONLY }

    private DirectBootPlan() {
    }

    /** An unlocked user: the whole start. A locked one: the wallpaper only. */
    static Start atStart(boolean userUnlocked) {
        return userUnlocked ? Start.FULL : Start.WALLPAPER_ONLY;
    }

    /**
     * Whether an unlock completes the start now: the start was the wallpaper's only, and it has not been completed
     * already (the unlock is reported by the application's receiver and by the activity's; the first one wins).
     */
    static boolean completeOnUnlock(Start started, boolean alreadyCompleted) {
        return started == Start.WALLPAPER_ONLY && !alreadyCompleted;
    }

    /** Whether the activity is made again at the unlock: it was shown for the wallpaper only. */
    static boolean recreateActivityOnUnlock(Start activityStartedAs) {
        return activityStartedAs == Start.WALLPAPER_ONLY;
    }
}
