package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkspaceGridTest {

    @Test
    void theDefaultIsTheGridTheLauncherAlwaysHad() {
        assertEquals(10, WorkspaceGrid.columns(true, 10, 6));
        assertEquals(6, WorkspaceGrid.rows(true, 10, 6));
        assertEquals(6, WorkspaceGrid.columns(false, 10, 6));
        assertEquals(10, WorkspaceGrid.rows(false, 10, 6));
    }

    @Test
    void theSameScreenHasTheSameGridInBothOrientations() {
        // 12 along the long edge and 5 along the short one, whatever the edges are called
        assertEquals(WorkspaceGrid.columns(true, 12, 5), WorkspaceGrid.rows(false, 12, 5));
        assertEquals(WorkspaceGrid.rows(true, 12, 5), WorkspaceGrid.columns(false, 12, 5));
    }

    @Test
    void eachNumberGoesTwoBelowAndFourAboveItsDefault() {
        assertEquals(8, WorkspaceGrid.MIN_LONG);
        assertEquals(14, WorkspaceGrid.MAX_LONG);
        assertEquals(4, WorkspaceGrid.MIN_SHORT);
        assertEquals(10, WorkspaceGrid.MAX_SHORT);
        assertEquals(8, WorkspaceGrid.clampLong(3));
        assertEquals(14, WorkspaceGrid.clampLong(99));
        assertEquals(4, WorkspaceGrid.clampShort(0));
        assertEquals(10, WorkspaceGrid.clampShort(11));
    }

    @Test
    void aPageWithoutBarsHasTheWholeGrid() {
        assertEquals(new WorkspaceGrid.Cells(6, 10, 0, 0), WorkspaceGrid.cells(6, 10, false, false, false, false));
        assertArrayEquals(new int[] {0, 0, 0, 0}, WorkspaceGrid.insets(6, 10, false, false, 142, false, false, 153));
    }

    @Test
    void theBarsTakeOneColumnAndOneRow() {
        // The phone of the screenshot: both bars, the vertical one at the left, the horizontal one at the bottom
        assertEquals(new WorkspaceGrid.Cells(5, 9, 1, 0), WorkspaceGrid.cells(6, 10, true, false, true, false));
        assertArrayEquals(new int[] {142, 0, 0, 153}, WorkspaceGrid.insets(6, 10, true, false, 142, true, false, 153));
    }

    @Test
    void aBarAtTheRightOrAtTheBottomLeavesTheFirstCellWhereItWas() {
        assertEquals(new WorkspaceGrid.Cells(9, 5, 0, 0), WorkspaceGrid.cells(10, 6, true, true, true, false));
        assertArrayEquals(new int[] {0, 0, 90, 100}, WorkspaceGrid.insets(10, 6, true, true, 90, true, false, 100));
    }

    @Test
    void aBarAtTheTopLiesBeforeTheFirstRow() {
        assertEquals(new WorkspaceGrid.Cells(10, 5, 0, 1), WorkspaceGrid.cells(10, 6, false, false, true, true));
        assertArrayEquals(new int[] {0, 100, 0, 0}, WorkspaceGrid.insets(10, 6, false, false, 90, true, true, 100));
    }

    @Test
    void theCellsOfThePhoneAreSpreadEvenlyBesideTheBars() {
        // 1080 x 2116 page, bars 142 and 153: five columns of 187 and nine rows of 218, where six
        // columns of 180 reached under the vertical bar and ten rows of 211 under the horizontal one
        int[] insets = WorkspaceGrid.insets(6, 10, true, false, 142, true, false, 153);
        WorkspaceGrid.Cells cells = WorkspaceGrid.cells(6, 10, true, false, true, false);
        assertEquals(187, (1080 - insets[0] - insets[2]) / cells.countX);
        assertEquals(218, (2116 - insets[1] - insets[3]) / cells.countY);
    }

    @Test
    void anAutoHideBarKeepsOnlyTheCornerUnderItsHandle() {
        assertTrue(WorkspaceGrid.cornerCell(HorizontalBarPlacement.Reserve.CELL, false, true));
        assertTrue(WorkspaceGrid.cornerCell(HorizontalBarPlacement.Reserve.CELL, true, false));
        // The handle and the button lie in the vertical bar's strip, which is no cell
        assertFalse(WorkspaceGrid.cornerCell(HorizontalBarPlacement.Reserve.CELL, true, true));
        assertFalse(WorkspaceGrid.cornerCell(HorizontalBarPlacement.Reserve.ROW, false, true));
        assertFalse(WorkspaceGrid.cornerCell(HorizontalBarPlacement.Reserve.NONE, false, true));
    }

    @Test
    void aGridIsWrittenAndReadBack() {
        WorkspaceGrid.Signature grids = new WorkspaceGrid.Signature(new WorkspaceGrid.Cells(5, 9, 1, 0),
                new WorkspaceGrid.Cells(6, 10, 0, 0));
        assertEquals("5x9+1+0;6x10+0+0", grids.encode());
        assertEquals(grids, WorkspaceGrid.Signature.decode(grids.encode()));
        assertNull(WorkspaceGrid.Signature.decode(null));
        assertNull(WorkspaceGrid.Signature.decode("5x9"));
        assertNull(WorkspaceGrid.Signature.decode("0x9+0+0;6x10+0+0"));
        assertNull(WorkspaceGrid.Signature.decode("ax9+0+0;6x10+0+0"));
    }

    @Test
    void theFirstPageHasANegativeId() {
        WorkspaceGrid.Signature grids = new WorkspaceGrid.Signature(new WorkspaceGrid.Cells(5, 9, 1, 0),
                new WorkspaceGrid.Cells(6, 10, 0, 0));
        assertEquals(grids.firstPage, grids.of(-302));
        assertEquals(grids.otherPages, grids.of(0));
        assertEquals(grids.otherPages, grids.of(7));
    }

    @Test
    void itemsFromAnOlderVersionWereArrangedForTheWholeGrid() {
        WorkspaceGrid.Signature now = new WorkspaceGrid.Signature(new WorkspaceGrid.Cells(5, 9, 1, 0),
                new WorkspaceGrid.Cells(6, 10, 0, 0));
        assertEquals(WorkspaceGrid.Signature.legacy(false), WorkspaceGrid.arrangedFor(null, null, false, now));
        assertEquals("10x6+0+0;10x6+0+0", WorkspaceGrid.Signature.legacy(true).encode());
    }

    @Test
    void nothingIsArrangedAgainWhileTheGridsAreTheSame() {
        WorkspaceGrid.Signature now = WorkspaceGrid.Signature.legacy(true);
        assertNull(WorkspaceGrid.arrangedFor(null, null, true, now));
        assertNull(WorkspaceGrid.arrangedFor(now.encode(), null, true, now));
    }

    @Test
    void aChangedGridIsArrangedFromTheOneRemembered() {
        WorkspaceGrid.Signature before = WorkspaceGrid.Signature.legacy(true);
        WorkspaceGrid.Signature now = new WorkspaceGrid.Signature(new WorkspaceGrid.Cells(9, 5, 1, 0),
                new WorkspaceGrid.Cells(10, 6, 0, 0));
        assertEquals(before, WorkspaceGrid.arrangedFor(before.encode(), "6x10+0+0;6x10+0+0", true, now));
    }

    @Test
    void aTurnOfTheScreenAloneMovesNothing() {
        // Portrait met for the first time, landscape known: its grids are only noted
        WorkspaceGrid.Signature now = new WorkspaceGrid.Signature(new WorkspaceGrid.Cells(5, 9, 1, 0),
                new WorkspaceGrid.Cells(6, 10, 0, 0));
        assertNull(WorkspaceGrid.arrangedFor(null, "9x5+1+0;10x6+0+0", false, now));
    }
}
