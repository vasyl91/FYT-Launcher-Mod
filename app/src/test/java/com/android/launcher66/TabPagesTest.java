package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TabPagesTest {

    // Three tabs of 45, 10 and 0 apps on pages of 20 cells: 3, 1 and 1 pages
    private static final TabPages PAGES = TabPages.of(new int[] {45, 10, 0}, 20);

    @Test
    void theTabsPagesOneAfterAnotherEachAtLeastOne() {
        assertEquals(5, PAGES.total());
        assertEquals(0, PAGES.firstPage(0));
        assertEquals(3, PAGES.firstPage(1));
        assertEquals(4, PAGES.firstPage(2));
        assertEquals(1, PAGES.pagesOf(2), "a tab without apps is an empty page");
    }

    @Test
    void eachPageKnowsItsTabAndWhereItsAppsStart() {
        assertEquals(0, PAGES.tabOf(2));
        assertEquals(40, PAGES.offsetOf(2));
        assertEquals(1, PAGES.tabOf(3));
        assertEquals(0, PAGES.offsetOf(3), "a tab's apps start on a page of their own");
        assertEquals(2, PAGES.tabOf(4));
    }

    @Test
    void theStripMovesOnlyBetweenTheLastPageOfATabAndTheNextTab() {
        assertEquals(0f, PAGES.stripPosition(0.5f), 0.001f, "within a tab it stands still");
        assertEquals(0f, PAGES.stripPosition(1.7f), 0.001f);
        assertEquals(0.25f, PAGES.stripPosition(2.25f), 0.001f, "from the first tab's last page to the second tab");
        assertEquals(1f, PAGES.stripPosition(3f), 0.001f);
        assertEquals(1.5f, PAGES.stripPosition(3.5f), 0.001f);
        assertEquals(2f, PAGES.stripPosition(4f), 0.001f);
        assertEquals(2f, PAGES.stripPosition(9f), 0.001f, "past the end it stays on the last tab");
        assertEquals(0f, PAGES.stripPosition(-0.4f), 0.001f);
    }

    @Test
    void noTabsNoPages() {
        TabPages none = TabPages.of(new int[0], 20);
        assertEquals(0, none.total());
        assertEquals(0f, none.stripPosition(1f), 0f);
    }
}
