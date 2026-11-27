package com.android.launcher66;

/**
 * The pages of the horizontal app drawer with tabs: the pages of every tab one after another in one pager, so that a
 * swipe from a tab's last page to the next tab's first is a page's scroll like any other (the owner on the A55,
 * 2026-11-27: the change of the tab jumped, while the change of a page within a tab slid).
 *
 * <p>The rules:
 * <ul>
 *   <li>Each tab has as many pages as its apps fill, at least one: a tab without apps is an empty page.</li>
 *   <li>A tab's apps start on a page of their own: the first app of a page is {@link #offsetOf} into its tab.</li>
 *   <li>The strip of tabs follows the scroll ({@link #stripPosition}): it moves from one tab to the next only while the
 *       pages move from the last page of a tab to the first of the next, and stands still while they move within a
 *       tab.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class TabPages {

    private final int[] mFirstPage;
    private final int[] mPages;
    private final int mCellsPerPage;
    private final int mTotal;

    private TabPages(int[] firstPage, int[] pages, int cellsPerPage, int total) {
        mFirstPage = firstPage;
        mPages = pages;
        mCellsPerPage = cellsPerPage;
        mTotal = total;
    }

    /**
     * @param appsPerTab the number of apps of each tab, in the strip's order
     * @param cellsPerPage the cells of a page (columns times rows)
     */
    static TabPages of(int[] appsPerTab, int cellsPerPage) {
        int cells = Math.max(1, cellsPerPage);
        int tabs = appsPerTab == null ? 0 : appsPerTab.length;
        int[] first = new int[tabs];
        int[] pages = new int[tabs];
        int total = 0;
        for (int t = 0; t < tabs; t++) {
            first[t] = total;
            pages[t] = Math.max(1, (Math.max(0, appsPerTab[t]) + cells - 1) / cells);
            total += pages[t];
        }
        return new TabPages(first, pages, cells, total);
    }

    /** All the pages. */
    int total() {
        return mTotal;
    }

    int tabs() {
        return mFirstPage.length;
    }

    /** The first page of a tab. */
    int firstPage(int tab) {
        if (tabs() == 0) {
            return 0;
        }
        return mFirstPage[Math.max(0, Math.min(tabs() - 1, tab))];
    }

    /** The pages a tab has. */
    int pagesOf(int tab) {
        if (tabs() == 0) {
            return 0;
        }
        return mPages[Math.max(0, Math.min(tabs() - 1, tab))];
    }

    /** The tab a page belongs to. */
    int tabOf(int page) {
        for (int t = tabs() - 1; t >= 0; t--) {
            if (page >= mFirstPage[t]) {
                return t;
            }
        }
        return 0;
    }

    /** The index, in its tab's apps, of the first app of a page. */
    int offsetOf(int page) {
        int t = tabOf(page);
        return Math.max(0, page - firstPage(t)) * mCellsPerPage;
    }

    /**
     * Where the strip of tabs stands while the pages move: the tab of the page, and between it and the next while the
     * pages move from its last page to the next tab's first.
     *
     * @param pagePosition the page shown, with the fraction of the way to the next one
     */
    float stripPosition(float pagePosition) {
        if (tabs() == 0) {
            return 0f;
        }
        float p = Math.max(0f, Math.min(mTotal - 1, pagePosition));
        int page = (int) Math.floor(p);
        float fraction = p - page;
        int tab = tabOf(page);
        boolean lastOfTab = page == firstPage(tab) + pagesOf(tab) - 1;
        return lastOfTab && tab < tabs() - 1 ? tab + fraction : tab;
    }
}
