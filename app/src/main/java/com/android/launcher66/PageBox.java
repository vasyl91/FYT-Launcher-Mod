package com.android.launcher66;

/**
 * The box of the first page on the screen, as the layout of that page fills it: the place where a bar at the
 * top that is part of the page starts. The windows of the auto-hide bar and of its handle take their place
 * from it, so that they lie exactly where the page's own bar lies.
 *
 * <p>It is the root of the page's layout that is measured, not the workspace: the workspace is laid out from the
 * very top of the launcher's window, under the status bar and the cut-out, and only the page's layout starts
 * below them. The left and the right edge are those the page would have if it were shown, whatever the
 * horizontal scroll of the pages is, so the box does not change while the pages are swiped. Pure Java, so that
 * it has a test.
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
     * @param rootLeftInPage         the layout root's left edge in its page (not scrolled)
     * @param rootTopOnScreen        the layout root's top edge on the screen
     * @param rootWidth              its width
     * @param workspaceLeftOnScreen  the left edge of the workspace on the screen, whatever the scroll
     */
    static Box of(int rootLeftInPage, int rootTopOnScreen, int rootWidth, int workspaceLeftOnScreen) {
        int left = workspaceLeftOnScreen + rootLeftInPage;
        return new Box(left, rootTopOnScreen, left + Math.max(0, rootWidth));
    }
}
