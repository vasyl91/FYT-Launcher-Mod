package com.android.launcher66;

/**
 * Every item of a page lies wholly in the part of the page that is seen: an item in cells within the page's grid,
 * an element of the creator (placed by pixels) within the page's box. The page itself is laid out inside the
 * system bars (PagedView takes their insets off), so an item that keeps to this rule is never under the status bar
 * or the navigation bar. Free of android.* so that the rules can be tested.
 *
 * <p>Before 2026-11-16 nothing checked it where items were drawn, and the owner found a widget half under the
 * navigation bar of the A55 after a reorganisation of the page.
 */
final class PageFit {

    private PageFit() {
    }

    /**
     * The height of an item in cells, so that the padding of the first rows (the item is drawn that much lower)
     * never takes it past the grid's bottom. Only what the padding added is taken off: an item whose own cells
     * reach past the grid is not hidden here, it is moved by the check of the page.
     *
     * @param top        the item's top in the grid, with the padding
     * @param height     its height from its cells
     * @param padding    the padding of its row
     * @param gridBottom the bottom of the grid's last row
     */
    static int heightInGrid(int top, int height, int padding, int gridBottom) {
        int over = top + height - gridBottom;
        if (over <= 0 || padding <= 0) {
            return height;
        }
        return Math.max(1, height - Math.min(padding, over));
    }
}
