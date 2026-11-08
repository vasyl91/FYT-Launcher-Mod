package com.android.launcher66.settings;

import android.content.SharedPreferences;

import com.android.launcher66.BarLayout;
import com.android.launcher66.HorizontalBarPlacement;
import com.android.launcher66.VerticalBarPlacement;

/**
 * Builds the {@link BarLayout} from the settings: the one place that reads which side the horizontal bar,
 * the vertical bar and the edge handle are on. The rules that depend on these sides (the shifts of the
 * page, the reserved corner cell, the button or the handle, the rectangles of the creators) ask the layout
 * and do not read the preferences each on its own, so that they cannot disagree.
 */
public final class BarLayouts {

    /** The switches the rules read; all of them are off by default. Lets the rules be tested without Android. */
    public interface BarPrefs {
        boolean bool(String key);
    }

    private BarLayouts() {
    }

    /** The preferences as the rules read them. */
    public static BarPrefs prefs(SharedPreferences prefs) {
        return key -> prefs.getBoolean(key, false);
    }

    /**
     * @param verticalBar      whether the vertical bar is on the page the layout is for
     * @param horizontalOnPage whether the horizontal bar (or the place it keeps while collapsed) is on it
     */
    public static BarLayout of(BarPrefs prefs, int rootWidth, int rootHeight, int barHeight,
                               int verticalBarWidth, boolean verticalBar, boolean horizontalOnPage) {
        return new BarLayout(rootWidth, rootHeight, barHeight, verticalBarWidth,
                prefs.bool(Keys.HORIZONTAL_BAR_TOP),
                prefs.bool(Keys.VERTICAL_BAR_RIGHT),
                prefs.bool(Keys.EDGE_HANDLE_RIGHT),
                verticalBar, horizontalOnPage, prefs.bool(Keys.AUTO_HIDE_HORIZONTAL_BAR));
    }

    public static BarLayout of(SharedPreferences prefs, int rootWidth, int rootHeight, int barHeight,
                               int verticalBarWidth, boolean verticalBar, boolean horizontalOnPage) {
        return of(prefs(prefs), rootWidth, rootHeight, barHeight, verticalBarWidth, verticalBar, horizontalOnPage);
    }

    /** The layout for the rules that need the sides only, not a size. */
    public static BarLayout sides(SharedPreferences prefs, boolean verticalBar) {
        return of(prefs, 0, 0, 0, 0, verticalBar, true);
    }

    /**
     * Whether the vertical bar is on a page: the first one, and with 'Vertical bar on every page'
     * (in the user layout) the others. The geometry of a page (the shift of its rectangles, the width
     * left to them) asks this and not "is it page 0".
     */
    public static boolean verticalOnPage(BarPrefs prefs, int page) {
        return VerticalBarPlacement.onPage(prefs.bool(Keys.VERTICAL_BAR), page,
                prefs.bool(Keys.VERTICAL_BAR_EVERY_PAGE), prefs.bool(Keys.USER_LAYOUT));
    }

    public static boolean verticalOnPage(SharedPreferences prefs, int page) {
        return verticalOnPage(prefs(prefs), page);
    }

    /** Whether the horizontal bar (or the place it keeps while collapsed) is on a page. */
    public static boolean horizontalOnPage(BarPrefs prefs, int page) {
        return HorizontalBarPlacement.reserve(page, prefs.bool(Keys.HORIZONTAL_BAR_EVERY_PAGE),
                prefs.bool(Keys.AUTO_HIDE_HORIZONTAL_BAR), prefs.bool(Keys.USER_LAYOUT))
                != HorizontalBarPlacement.Reserve.NONE;
    }

    /** 'Vertical bar on every page' is on; it means nothing without the user layout. */
    public static boolean verticalEveryPage(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.VERTICAL_BAR_EVERY_PAGE, false) && prefs.getBoolean(Keys.USER_LAYOUT, false);
    }
}
