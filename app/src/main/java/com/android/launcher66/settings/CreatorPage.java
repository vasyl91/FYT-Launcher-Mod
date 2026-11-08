package com.android.launcher66.settings;

import com.android.launcher66.BarLayout;
import com.android.launcher66.CreatorBars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * What the layout creator of one page is made of: which elements are on the page, how a double tap treats the
 * bar, and which bars the home screen has on that page (as {@link CreatorBars} shows them). One creator serves
 * every page, and this is where the pages differ, and only where they do on the home screen. Pure Java (no
 * android.*), so that the rules have a test.
 *
 * <p>What does not differ: the keys the rectangles are saved under (every element has one key, whichever page
 * it is on; the page it is on is the element's own setting), the user rectangles, the canvas, the controls.
 */
public final class CreatorPage {

    /** The settings the creator of a page reads. */
    public interface Snapshot extends BarLayouts.BarPrefs {
        /** The page (1-based, as stored) an element is on; 1 when never set. */
        int screenOf(String screenKey);

        /** A switch with the default the creator has always given it (the date, music, radio and stats are on). */
        boolean boolOr(String key, boolean defaultValue);
    }

    /** An element of the layout that has a rectangle in the creator. */
    public static final class Element {
        /** The key of the rectangle: also its key in the user rectangles and the saved corners. */
        public final String key;
        /** The setting that stores the page of the element. */
        final String screenKey;

        Element(String key, String screenKey) {
            this.key = key;
            this.screenKey = screenKey;
        }
    }

    public final int page;
    /** The creator of the first page: the double tap hint and the toggle rule are its own. */
    public final boolean firstScreen;
    /** The keys of the rectangles on this page, in the order they are added. */
    public final List<String> elements;
    /** A double tap hides the controls and shows what stands in their place. */
    public final boolean canToggle;
    public final CreatorBars bars;
    public final boolean verticalOnPage;
    public final boolean horizontalOnPage;

    private CreatorPage(int page, List<String> elements, boolean canToggle, CreatorBars bars,
                        boolean verticalOnPage, boolean horizontalOnPage) {
        this.page = page;
        this.firstScreen = page == 0;
        this.elements = Collections.unmodifiableList(elements);
        this.canToggle = canToggle;
        this.bars = bars;
        this.verticalOnPage = verticalOnPage;
        this.horizontalOnPage = horizontalOnPage;
    }

    /** @param page 0 for the first page */
    public static CreatorPage of(int page, Snapshot prefs) {
        List<String> keys = new ArrayList<>();
        boolean pip = prefs.bool(Keys.DISPLAY_PIP);
        boolean dual = prefs.bool(Keys.PIP_DUAL);
        boolean first = prefs.bool(Keys.PIP_FIRST);
        boolean second = prefs.bool(Keys.PIP_SECOND);
        boolean third = prefs.bool(Keys.PIP_THIRD);
        boolean fourth = prefs.bool(Keys.PIP_FOURTH);
        if (pip && dual && !first && !second && onPage(prefs, Keys.PIP_DUAL_SCREEN, page)) keys.add("pipDual");
        if (pip && first && !dual && onPage(prefs, Keys.PIP_FIRST_SCREEN, page)) keys.add("pipFirst");
        if (pip && second && !dual && onPage(prefs, Keys.PIP_SECOND_SCREEN, page)) keys.add("pipSecond");
        if (pip && third && onPage(prefs, Keys.PIP_THIRD_SCREEN, page)) keys.add("pipThird");
        if (pip && fourth && onPage(prefs, Keys.PIP_FOURTH_SCREEN, page)) keys.add("pipFourth");
        // These default to on in the creator, as they always did
        if (prefs.boolOr(Keys.USER_DATE, true) && onPage(prefs, Keys.DATE_SCREEN, page)) keys.add("date");
        if (prefs.boolOr(Keys.USER_MUSIC, true) && onPage(prefs, Keys.MUSIC_SCREEN, page)) keys.add("music");
        if (prefs.boolOr(Keys.USER_RADIO, true) && onPage(prefs, Keys.RADIO_SCREEN, page)) keys.add("radio");
        if (prefs.boolOr(Keys.USER_STATS, true) && onPage(prefs, Keys.STATS_SCREEN, page)) keys.add("stats");
        boolean autoHide = prefs.bool(Keys.AUTO_HIDE_HORIZONTAL_BAR);
        boolean verticalOnPage = BarLayouts.verticalOnPage(prefs, page);
        boolean horizontalOnPage = BarLayouts.horizontalOnPage(prefs, page);
        BarLayout layout = BarLayouts.of(prefs, 0, 0, 0, 0, verticalOnPage, horizontalOnPage);
        return new CreatorPage(page, keys, CreatorBarToggle.canToggle(page == 0, autoHide,
                prefs.bool(Keys.HORIZONTAL_BAR_EVERY_PAGE)), CreatorBars.of(layout, autoHide), verticalOnPage,
                horizontalOnPage);
    }

    private static boolean onPage(Snapshot prefs, String screenKey, int page) {
        return prefs.screenOf(screenKey) - 1 == page;
    }
}
