package com.android.launcher66;

import com.android.launcher66.settings.Keys;

/**
 * How many app icons a bar shows when the user has chosen a number (the sliders "App icons" of the horizontal
 * and the vertical bar).
 *
 * <p><b>Rule.</b> The most a bar can show is what the launcher works out for its room (BarCapacity: the
 * horizontal bar from its width and icon, the vertical bar from its height and icon). A bar shows the number
 * the user chose, at least 1 and never more than that most; with nothing chosen it shows the most. A chosen
 * number is lowered, and stored lowered, only where a newly worked-out most is smaller than it; a smaller one
 * stays as chosen and is shown again in full when the bar has room for it. The icons keep their size: fewer
 * of them are spread over the same bar.
 *
 * <p>The number is stored per bar and per orientation, and counts in the user layout whether the bar's
 * "Resizable" switch is on or off (the owner, 2026-11-21; it counted only with the switch on before). Plain Java,
 * tested on the JVM.
 */
public final class BarIconCount {

    /** Nothing chosen: the bar shows as many icons as it has room for. */
    public static final int UNSET = 0;

    private BarIconCount() {
    }

    /** The icons the bar shows: the chosen number within 1 .. max, or max when nothing is chosen. */
    public static int shown(int chosen, int max) {
        int most = Math.max(1, max);
        return chosen <= UNSET ? most : Math.max(1, Math.min(chosen, most));
    }

    /** The number to keep stored once the most is known: lowered to it where above it, otherwise unchanged. */
    public static int kept(int chosen, int max) {
        if (chosen <= UNSET) {
            return UNSET;
        }
        return Math.max(1, Math.min(chosen, Math.max(1, max)));
    }

    /** The key of the chosen number for a bar and an orientation. */
    public static String key(boolean horizontal, boolean portrait) {
        if (horizontal) {
            return portrait ? Keys.HORIZONTAL_BAR_ICONS_PORT : Keys.HORIZONTAL_BAR_ICONS_LAND;
        }
        return portrait ? Keys.VERTICAL_BAR_ICONS_PORT : Keys.VERTICAL_BAR_ICONS_LAND;
    }
}
