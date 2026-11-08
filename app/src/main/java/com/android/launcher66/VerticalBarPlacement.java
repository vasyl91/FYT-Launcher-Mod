package com.android.launcher66;

/**
 * Which vertical bar the home screen shows on a page. The rules of 'Vertical bar on every page' in one
 * place, free of views so that they can be tested; the mirror of {@link HorizontalBarPlacement}.
 *
 * <p>With the option off the bar belongs to the first page, as it always did: it is part of that page
 * and leaves with it. With the option on every page has it. The first page at rest keeps its own bar
 * and every other page has the same bar in a window of its own, which does not move while the pages
 * do. The first page's bar leaves with its page, so the window is up from the first moment of a move
 * (on any page), in the same place, and covers it without a jump.
 */
public final class VerticalBarPlacement {

    /** What is on screen for the vertical bar on a page. */
    public enum Bar { EMBEDDED, PERSISTENT_OVERLAY, NONE }

    private VerticalBarPlacement() {
    }

    /**
     * @param page the page that is shown (or being left), 0 for the first
     * @param pageMoving whether the pages are moving, between two pages or back to the same one
     * @param userLayout whether the user layout is on: the window of the other pages exists only
     *                   there, so without it 'every page' means nothing
     */
    public static Bar bar(int page, boolean everyPage, boolean pageMoving, boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage) {
            return page == 0 ? Bar.EMBEDDED : Bar.NONE;
        }
        return page == 0 && !pageMoving ? Bar.EMBEDDED : Bar.PERSISTENT_OVERLAY;
    }

    /**
     * Whether the vertical bar is on a page at rest, with all that it takes from it: its width, and the
     * shift of the rectangles of the widgets by it. The bar of a page that is moving counts for the page
     * it is going to rest on.
     */
    public static boolean onPage(boolean verticalBar, int page, boolean everyPage, boolean userLayout) {
        return verticalBar && (page == 0 || (everyPage && userLayout));
    }
}
