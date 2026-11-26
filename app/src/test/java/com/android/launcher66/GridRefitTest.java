package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class GridRefitTest {

    private static GridRefit.Item icon(long id, int x, int y) {
        return new GridRefit.Item(id, x, y, 1, 1, false);
    }

    private static GridRefit.Item widget(long id, int x, int y, int w, int h) {
        return new GridRefit.Item(id, x, y, w, h, true);
    }

    @Test
    void aWidgetOnFreeCellsStaysWhereItIs() {
        List<GridRefit.Move> moves = GridRefit.refit(
                Arrays.asList(icon(1, 0, 0), widget(10, 2, 1, 2, 2)), 6, 4);
        assertEquals(1, moves.size());
        assertFalse(moves.get(0).moved);
        assertFalse(moves.get(0).removed);
        assertEquals(2, moves.get(0).cellX);
        assertEquals(1, moves.get(0).cellY);
    }

    @Test
    void aWidgetOverAnIconGoesToTheNearestFreePlaceOfItsSizeAndTheIconStays() {
        // a 2 x 2 widget at 0,0 over an icon at 1,1: the nearest free 2 x 2 is at 2,0 (distance 2) -
        // 0,2 is as near, and the higher place wins
        List<GridRefit.Move> moves = GridRefit.refit(
                Arrays.asList(icon(1, 1, 1), widget(10, 0, 0, 2, 2)), 6, 4);
        GridRefit.Move move = moves.get(0);
        assertTrue(move.moved);
        assertFalse(move.removed);
        assertEquals(2, move.cellX);
        assertEquals(0, move.cellY);
    }

    @Test
    void theWidgetsAreTakenFromTheTopLeftAndOneNeverLandsOnAnother() {
        // two 2 x 2 widgets on the same cells of a 4 x 2 grid: the first (higher, more left, lower id) stays,
        // the second goes to the other half
        List<GridRefit.Move> moves = GridRefit.refit(
                Arrays.asList(widget(11, 0, 0, 2, 2), widget(10, 0, 0, 2, 2)), 4, 2);
        Map<Long, GridRefit.Move> byId = GridRefit.byId(moves);
        assertFalse(byId.get(10L).moved);
        assertTrue(byId.get(11L).moved);
        assertEquals(2, byId.get(11L).cellX);
        assertEquals(0, byId.get(11L).cellY);
    }

    @Test
    void aWidgetThatHasNoRoomIsRemoved() {
        // a 2 x 2 grid filled by icons but the widget's own place is taken by an icon too
        List<GridRefit.Move> moves = GridRefit.refit(
                Arrays.asList(icon(1, 0, 0), icon(2, 1, 1), widget(10, 0, 0, 2, 2)), 2, 2);
        assertTrue(moves.get(0).removed);
    }

    @Test
    void aWidgetLargerThanTheGridIsRemoved() {
        List<GridRefit.Move> moves = GridRefit.refit(Arrays.asList(widget(10, 0, 0, 5, 5)), 4, 4);
        assertTrue(moves.get(0).removed);
    }

    @Test
    void theOrderIsTopRowFirstThenLeft() {
        List<GridRefit.Item> ordered = GridRefit.widgetsInOrder(Arrays.asList(
                widget(3, 4, 1, 1, 1), widget(1, 0, 2, 1, 1), widget(2, 2, 1, 1, 1), icon(9, 0, 0)));
        assertEquals(Arrays.asList(2L, 3L, 1L), Arrays.asList(ordered.get(0).id, ordered.get(1).id, ordered.get(2).id));
        assertEquals(3, ordered.size());
    }

    @Test
    void iconsAreNeverMoved() {
        List<GridRefit.Move> moves = GridRefit.refit(
                Arrays.asList(icon(1, 0, 0), icon(2, 1, 0), widget(10, 0, 0, 2, 1)), 4, 1);
        // only widgets are in the result
        assertEquals(1, moves.size());
        assertEquals(10L, moves.get(0).id);
        assertEquals(2, moves.get(0).cellX);
    }
}
