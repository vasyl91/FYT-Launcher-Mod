package com.android.launcher66;

/**
 * Which welcome text the stock page shows (the text that was one string, {@code tv_map_str}, for every device).
 *
 * <p>The rule (the owner, 2026-11-25): the text says what the device can do. An FYT unit (not the 7870) is told to make its
 * own layout to show navigation and other apps in windows on the home screen, and what to do when one keeps opening over it.
 * The 7870 is told that windows are shown where the unit supports them (it has no pinned PiP, D-34, and its windows depend on
 * what the unit allows). Any other device is told that windows need root or Shizuku, and that the launcher is an ordinary
 * home screen without them. Pure Java, so that it has a test; Workspace maps the kind to the string.
 */
final class WelcomeText {

    enum Kind { FYT, UNIT_7870, OTHER }

    private WelcomeText() {
    }

    /** The 7870 first (it is an FYT unit too), then the other FYT units, then everything else. */
    static Kind kind(boolean is7870, boolean fytDevice) {
        if (is7870) {
            return Kind.UNIT_7870;
        }
        return fytDevice ? Kind.FYT : Kind.OTHER;
    }
}
