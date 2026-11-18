package com.android.launcher66.settings;

/**
 * Where the list of a settings screen was when the user left it for another window, free of android.* so that
 * it has a test. One place for the whole process: there is one settings activity.
 *
 * <p>The rule (the owner, 2026-11-18):
 * <ul>
 *   <li>the position is kept when the user goes from screen 1 or 2 to a window he can come back from: another
 *       activity (the device's settings, a browser, the wallpaper picker, …) or a sub-screen of the settings
 *       (the creator through "ADJUST", the creator of the statistics over apps, the Canbus and Spotify
 *       guides);</li>
 *   <li>on the return the screen opens at that position at once, before its first frame, so nothing moves;</li>
 *   <li>moving between screen 1 and screen 2 keeps nothing and forgets what was kept;</li>
 *   <li>leaving the settings for the home screen forgets it too: a settings activity opened afresh starts
 *       from the top.</li>
 * </ul>
 * Main thread only.
 */
public final class SettingsScrollMemory {

    /** A kept position: the first item seen and how far its top lies from the top of the list. */
    public static final class Position {
        public final int screen;
        public final int item;
        public final int offset;

        Position(int screen, int item, int offset) {
            this.screen = screen;
            this.item = item;
            this.offset = offset;
        }
    }

    private static Position sKept;
    /** The next leaving of a screen keeps nothing: it is the move to the other screen. */
    private static boolean sSkipNext;

    private SettingsScrollMemory() {
    }

    /** A screen is left for a window the user can come back from: its position is kept (unless skipped). */
    public static void left(int screen, int item, int offset) {
        if (sSkipNext) {
            sSkipNext = false;
            return;
        }
        if (item < 0) {
            return;
        }
        sKept = new Position(screen, item, offset);
    }

    /** The user moves between screen 1 and screen 2: nothing is kept, and leaving the screen keeps nothing. */
    public static void betweenScreens() {
        sKept = null;
        sSkipNext = true;
    }

    /** A screen's list is new: the position kept for that screen, given once; null when there is none. */
    public static Position takeFor(int screen) {
        Position kept = sKept;
        sSkipNext = false;
        if (kept == null || kept.screen != screen) {
            return null;
        }
        sKept = null;
        return kept;
    }

    /** The settings are left for the home screen: nothing is kept, and the pause that follows keeps nothing. */
    public static void leftForHome() {
        sKept = null;
        sSkipNext = true;
    }

    /** The settings are opened afresh: nothing is kept. */
    public static void forget() {
        sKept = null;
        sSkipNext = false;
    }
}
