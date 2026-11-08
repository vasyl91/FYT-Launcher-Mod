package com.android.launcher66.settings;

import android.content.SharedPreferences;

import com.android.launcher66.BarLayout;

/**
 * Builds the {@link BarLayout} from the settings: the one place that reads which side the horizontal bar,
 * the vertical bar and the edge handle are on. The rules that depend on these sides (the shifts of the
 * page, the reserved corner cell, the button or the handle, the rectangles of the creators) ask the layout
 * and do not read the preferences each on its own, so that they cannot disagree.
 */
public final class BarLayouts {

    private BarLayouts() {
    }

    /**
     * @param verticalBar whether the vertical bar is on the page the layout is for
     */
    public static BarLayout of(SharedPreferences prefs, int rootWidth, int rootHeight, int barHeight,
                               int verticalBarWidth, boolean verticalBar) {
        return new BarLayout(rootWidth, rootHeight, barHeight, verticalBarWidth,
                prefs.getBoolean(Keys.HORIZONTAL_BAR_TOP, false),
                prefs.getBoolean(Keys.VERTICAL_BAR_RIGHT, false),
                prefs.getBoolean(Keys.EDGE_HANDLE_RIGHT, false),
                verticalBar);
    }

    /** The layout for the rules that need the sides only, not a size. */
    public static BarLayout sides(SharedPreferences prefs, boolean verticalBar) {
        return of(prefs, 0, 0, 0, 0, verticalBar);
    }
}
