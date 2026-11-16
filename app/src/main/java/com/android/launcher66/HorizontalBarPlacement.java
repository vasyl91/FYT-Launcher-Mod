package com.android.launcher66;

/**
 * Which horizontal bar the home screen shows on a page, and which part of the page it takes from the
 * icons and widgets. The rules of 'Horizontal bar on every page' in one place, free of views so that
 * they can be tested; Workspace and CellLayout follow the answers.
 *
 * <p>With the option off the bar belongs to the first page, as it always did:
 * <ul>
 *   <li>without auto-hide the bar is part of the first page and takes its last row(s);</li>
 *   <li>with auto-hide the first page has the button (with the vertical bar on the handle's side) or the
 *       edge handle (without it, or with the vertical bar on the other side), and only one cell of
 *       its bar's row, at the handle's side, is taken for it.</li>
 * </ul>
 * With the option on, every page has what the first one has:
 * <ul>
 *   <li>without auto-hide every page, the first one too, has the persistent overlay, at rest and
 *       while the pages move: the same bar in a window of its own, which stands still while the
 *       pages move under it. The first page's own bar is hidden then; it is seen only where the
 *       window steps aside (the overview, a drag, a folder, all apps). Nothing is swapped while the
 *       pages move: a swap of two windows takes at least one frame, and on the FYT 7862 such a
 *       frame lasted 60 to 280 ms with one of the two bars already moved, so both were seen;</li>
 *   <li>with auto-hide every page has the edge handle (the first one the button, with the left
 *       bar), and the bar that the handle reveals is the overlay with its timer, as today.</li>
 * </ul>
 */
public final class HorizontalBarPlacement {

    /** What is on screen for the bar on a page. */
    public enum Bar { EMBEDDED, PERSISTENT_OVERLAY, HANDLE, BUTTON, NONE }

    /** What the bar takes from the page's cells. */
    public enum Reserve { ROW, CELL, NONE }

    private HorizontalBarPlacement() {
    }

    /**
     * @param page the page that is shown (or being left), 0 for the first
     * @param pageMoving whether the pages are moving, between two pages or back to the same one; it
     *                   matters only to the auto-hide bar's handle and button
     * @param verticalBar whether the vertical bar is on this page (VerticalBarPlacement.onPage): the first one,
     *                    and with 'Vertical bar on every page' the others
     * @param buttonSide the vertical bar and the edge handle are on the same side: the collapsed bar has
     *                   its button in the corner of the vertical bar. On different sides the handle
     *                   stands for the bar, with no button, whatever the vertical bar does
     * @param userLayout whether the user layout is on: the persistent overlay and the handles of the
     *                   other pages exist only there, so without it 'every page' means nothing
     */
    public static Bar bar(int page, boolean everyPage, boolean autoHide, boolean verticalBar, boolean buttonSide,
                   boolean pageMoving, boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage && page != 0) {
            return Bar.NONE;
        }
        if (autoHide) {
            if (pageMoving) {
                return Bar.NONE;
            }
            return verticalBar && buttonSide ? Bar.BUTTON : Bar.HANDLE;
        }
        // With 'every page' the overlay on every page, moving or at rest; without it the first
        // page's own bar, which leaves with its page
        return everyPage ? Bar.PERSISTENT_OVERLAY : Bar.EMBEDDED;
    }

    /**
     * Without the user layout there is no bar on the other pages (see {@link #bar}), so they must
     * not lose their last row or cell to one that is never there.
     */
    public static Reserve reserve(int page, boolean everyPage, boolean autoHide, boolean userLayout) {
        everyPage &= userLayout;
        if (!everyPage && page != 0) {
            return Reserve.NONE;
        }
        return autoHide ? Reserve.CELL : Reserve.ROW;
    }
}
