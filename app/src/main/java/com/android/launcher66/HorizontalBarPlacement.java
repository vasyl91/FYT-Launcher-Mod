package com.android.launcher66;

/**
 * Which horizontal bar the home screen shows on a page, and which part of the page it takes from the
 * icons and widgets. The rules of 'Horizontal bar on every page' in one place, free of views so that
 * they can be tested; Workspace and CellLayout follow the answers.
 *
 * <p>With the option off the bar belongs to the first page, as it always did:
 * <ul>
 *   <li>without auto-hide the bar is part of the first page and takes its last row(s);</li>
 *   <li>with auto-hide the first page has the button (with the vertical bar) or the edge handle
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
final class HorizontalBarPlacement {

    /** What is on screen for the bar on a page. */
    enum Bar { EMBEDDED, PERSISTENT_OVERLAY, HANDLE, BUTTON, NONE }

    /** What the bar takes from the page's cells. */
    enum Reserve { ROW, CELL, NONE }

    private HorizontalBarPlacement() {
    }

    /**
     * @param page the page that is shown (or being left), 0 for the first
     * @param pageMoving whether the pages are moving, between two pages or back to the same one
     * @param userLayout whether the user layout is on: the persistent overlay and the handles of the
     *                   other pages exist only there, so without it 'every page' means nothing
     */
    static Bar bar(int page, boolean everyPage, boolean autoHide, boolean verticalBar, boolean pageMoving,
                   boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage && page != 0) {
            return Bar.NONE;
        }
        if (autoHide) {
            if (pageMoving) {
                return Bar.NONE;
            }
            return page == 0 && verticalBar ? Bar.BUTTON : Bar.HANDLE;
        }
        if (page == 0 && !pageMoving) {
            return Bar.EMBEDDED;
        }
        // Only with 'every page': the first page's own bar leaves with the page, so the overlay
        // is up from the first moment of the move and stays on the other pages.
        return everyPage ? Bar.PERSISTENT_OVERLAY : Bar.EMBEDDED;
    }

    /**
     * Without the user layout there is no bar on the other pages (see {@link #bar}), so they must
     * not lose their last row or cell to one that is never there.
     */
    static Reserve reserve(int page, boolean everyPage, boolean autoHide, boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage && page != 0) {
            return Reserve.NONE;
        }
        return autoHide ? Reserve.CELL : Reserve.ROW;
    }
}
