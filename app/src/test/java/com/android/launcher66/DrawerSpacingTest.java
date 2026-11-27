package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DrawerSpacingTest {

    private static final int GAP = 21;

    @Test
    void theStripOnTopHasTheGapAboveItAndTheAppsTheGapBelowIt() {
        DrawerSpacing withSearch = DrawerSpacing.of(true, true, true, GAP);
        assertEquals(0, withSearch.searchBottom, "the search bar has no gap of its own below it");
        assertEquals(GAP, withSearch.stripTop);
        assertEquals(GAP, withSearch.appsTop, "under the strip's line");
        assertEquals(0, withSearch.appsBottom);
        DrawerSpacing alone = DrawerSpacing.of(false, true, true, GAP);
        assertEquals(GAP, alone.stripTop, "the same from the top");
        assertEquals(GAP, alone.appsTop);
    }

    @Test
    void theStripAtTheBottomIsTheMirror() {
        DrawerSpacing spacing = DrawerSpacing.of(true, true, false, GAP);
        assertEquals(GAP, spacing.appsTop, "under the search bar");
        assertEquals(GAP, spacing.appsBottom, "above the strip's line");
        assertEquals(0, spacing.stripTop);
        assertEquals(GAP, spacing.stripBottom);
        assertEquals(0, DrawerSpacing.of(false, true, false, GAP).appsTop);
    }

    @Test
    void withoutTheStripTheAppsHaveTheGapUnderTheSearchBarOnly() {
        assertEquals(GAP, DrawerSpacing.of(true, false, true, GAP).appsTop);
        DrawerSpacing none = DrawerSpacing.of(false, false, true, GAP);
        assertEquals(0, none.appsTop);
        assertEquals(0, none.appsBottom);
        assertEquals(0, none.stripTop);
    }
}
