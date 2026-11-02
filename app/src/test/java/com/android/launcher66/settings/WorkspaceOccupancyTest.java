package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkspaceOccupancyTest {

    private static final long CUSTOM = -302;
    private final GridGeometry grid = new GridGeometry(0, 0, 100, 100, 6, 4);

    @Test
    void customPagesComeFirstThenTheRankedScreens() {
        long[] ranked = {7, 3, 12};
        assertEquals(0, WorkspaceOccupancy.pageForScreenId(-302, CUSTOM, 1, ranked));
        assertEquals(1, WorkspaceOccupancy.pageForScreenId(7, CUSTOM, 1, ranked));
        assertEquals(3, WorkspaceOccupancy.pageForScreenId(12, CUSTOM, 1, ranked));
        assertEquals(-1, WorkspaceOccupancy.pageForScreenId(99, CUSTOM, 1, ranked));
        // two custom pages: the ranked ones start at page 2
        assertEquals(1, WorkspaceOccupancy.pageForScreenId(-303, CUSTOM, 2, ranked));
        assertEquals(2, WorkspaceOccupancy.pageForScreenId(7, CUSTOM, 2, ranked));
        // an id of a custom page that does not exist
        assertEquals(-1, WorkspaceOccupancy.pageForScreenId(-303, CUSTOM, 1, ranked));
    }

    @Test
    void itemsMarkTheirSpanAndAreClippedToTheGrid() {
        WorkspaceOccupancy occ = new WorkspaceOccupancy(grid);
        occ.add(1, 1, 2, 2, 2);
        occ.add(1, 5, 3, 3, 3); // sticks out of the grid
        boolean[][] page = occ.page(1);
        assertTrue(page[1][2] && page[2][2] && page[1][3] && page[2][3]);
        assertTrue(page[5][3]);
        assertFalse(page[0][0]);
        assertEquals(6, page.length);
        assertEquals(4, page[0].length);
    }

    @Test
    void anUnknownPageIsEmptyAndPageMinusOneIsIgnored() {
        WorkspaceOccupancy occ = new WorkspaceOccupancy(grid);
        occ.add(-1, 0, 0, 1, 1);
        assertFalse(occ.page(0)[0][0]);
        assertFalse(occ.page(3)[0][0]);
    }
}
