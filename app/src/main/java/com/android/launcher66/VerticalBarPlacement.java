package com.android.launcher66;

/**
 * Which vertical bar the home screen shows on a page. The rules of 'Vertical bar on every page' in one
 * place, free of views so that they can be tested; the mirror of {@link HorizontalBarPlacement}.
 *
 * <p>With the option off the bar belongs to the first page, as it always did: it is part of that page
 * and leaves with it. With the option on every page has it, the first one too, in a window of its own,
 * at rest and while the pages move: the window stands still and the pages move under it. The first
 * page's own bar is hidden then and seen only where the window steps aside (the overview, a drag, a
 * folder, all apps). Nothing is swapped while the pages move (see HorizontalBarPlacement).
 */
public final class VerticalBarPlacement {

    /** What is on screen for the vertical bar on a page. */
    public enum Bar { EMBEDDED, PERSISTENT_OVERLAY, NONE }

    private VerticalBarPlacement() {
    }

    /**
     * @param page the page that is shown (or being left), 0 for the first
     * @param pageMoving whether the pages are moving, between two pages or back to the same one; with the
     *                   option on it changes nothing
     * @param userLayout whether the user layout is on: the window of the other pages exists only
     *                   there, so without it 'every page' means nothing
     */
    public static Bar bar(int page, boolean everyPage, boolean pageMoving, boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage) {
            return page == 0 ? Bar.EMBEDDED : Bar.NONE;
        }
        return Bar.PERSISTENT_OVERLAY;
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
