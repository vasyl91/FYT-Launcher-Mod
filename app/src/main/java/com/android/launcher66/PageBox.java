package com.android.launcher66;

/**
 * The box of the first page on the screen, as the layout of that page fills it: the place where a bar at the
 * top that is part of the page starts. The windows of the auto-hide bar and of its handle take their place
 * from it, so that they lie exactly where the page's own bar lies.
 *
 * <p>It is the root of the page's layout that is measured, not the workspace: the workspace is laid out from the
 * very top of the launcher's window, under the status bar and the cut-out, and only the page's layout starts
 * below them. The left and the right edge are those the page would have if it were shown, whatever the
 * horizontal scroll of the pages is, so the box does not change while the pages are swiped.
 *
 * <p>The rule for "if it were shown": the reference is the left edge of the <em>page at rest</em>
 * ({@link #pageRestLeft}), never the left edge of the workspace view. The workspace is a pager that is measured
 * far wider than the screen (so that it still fills it when zoomed out) and is centred, so its own left edge
 * lies thousands of pixels to the left of the screen: -4520 px on a 1080 px wide phone. Taking that edge for
 * the page's put the window of the vertical bar off the screen, and the system then pushed it to the nearest
 * edge, the wrong one for a bar on the right. Pure Java, so that it has a test.
 */
final class PageBox {

    /** The left and right edge and the top, on the screen. */
    static final class Box {
        final int left;
        final int top;
        final int right;

        Box(int left, int top, int right) {
            this.left = left;
            this.top = top;
            this.right = right;
        }
    }

    private PageBox() {
    }

    /**
     * The left edge a page has on the screen when the pager rests on it.
     *
     * @param workspaceLeftOnScreen the left edge of the workspace view on the screen (it does not depend on
     *                              the scroll, and is far negative because the view is wider than the screen)
     * @param pageLeftInWorkspace   the page's left edge in the workspace view
     * @param pageScroll            the scroll at which the pager rests on that page
     */
    static int pageRestLeft(int workspaceLeftOnScreen, int pageLeftInWorkspace, int pageScroll) {
        return workspaceLeftOnScreen + pageLeftInWorkspace - pageScroll;
    }

    /**
     * @param rootLeftInPage         the layout root's left edge in its page (not scrolled)
     * @param rootTopOnScreen        the layout root's top edge on the screen
     * @param rootWidth              its width
     * @param pageRestLeftOnScreen   the left edge of the page on the screen when it is the one shown
     *                               ({@link #pageRestLeft}), whatever the scroll is now
     */
    static Box of(int rootLeftInPage, int rootTopOnScreen, int rootWidth, int pageRestLeftOnScreen) {
        int left = pageRestLeftOnScreen + rootLeftInPage;
        return new Box(left, rootTopOnScreen, left + Math.max(0, rootWidth));
    }
}
