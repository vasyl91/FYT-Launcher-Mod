package com.android.launcher66;

/**
 * Which bottom bar the home screen shows on a page, and which part of the page it takes from the
 * icons and widgets. The rules of 'Bottom bar on every page' in one place, free of views so that
 * they can be tested; Workspace and CellLayout follow the answers.
 *
 * <p>With the option off the bar belongs to the first page, as it always did:
 * <ul>
 *   <li>without auto-hide the bar is part of the first page and takes its last row(s);</li>
 *   <li>with auto-hide the first page has the button (with the left bar) or the edge handle
 *       (without it), and only the first cell of its bottom row is taken for it.</li>
 * </ul>
 * With the option on, every page has what the first one has:
 * <ul>
 *   <li>without auto-hide the first page at rest keeps its own bar, every other page (and any
 *       page while the pages move) has the persistent overlay: the same bar in a window of its own,
 *       which stays until the pages are at rest on the first page again;</li>
 *   <li>with auto-hide every page has the edge handle (the first one the button, with the left
 *       bar), and the bar that the handle reveals is the overlay with its timer, as today.</li>
 * </ul>
 */
final class BottomBarPlacement {

    /** What is on screen for the bar on a page. */
    enum Bar { EMBEDDED, PERSISTENT_OVERLAY, HANDLE, BUTTON, NONE }

    /** What the bar takes from the page's cells. */
    enum Reserve { ROW, CELL, NONE }

    private BottomBarPlacement() {
    }

    /**
     * @param page the page that is shown (or being left), 0 for the first
     * @param pageMoving whether the pages are moving, between two pages or back to the same one
     */
    static Bar bar(int page, boolean everyPage, boolean autoHide, boolean leftBar, boolean pageMoving) {
        if (!everyPage && page != 0) {
            return Bar.NONE;
        }
        if (autoHide) {
            if (pageMoving) {
                return Bar.NONE;
            }
            return page == 0 && leftBar ? Bar.BUTTON : Bar.HANDLE;
        }
        if (page == 0 && !pageMoving) {
            return Bar.EMBEDDED;
        }
        // Only with 'every page': the first page's own bar leaves with the page, so the overlay
        // is up from the first moment of the move and stays on the other pages.
        return everyPage ? Bar.PERSISTENT_OVERLAY : Bar.EMBEDDED;
    }

    static Reserve reserve(int page, boolean everyPage, boolean autoHide) {
        if (!everyPage && page != 0) {
            return Reserve.NONE;
        }
        return autoHide ? Reserve.CELL : Reserve.ROW;
    }
}
