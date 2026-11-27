package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PipEdgeTest {

    // A page of 1000 x 600 with one PiP at 400,100, 300 x 200
    private static final List<int[]> PIP = Collections.singletonList(new int[] {400, 100, 300, 200});

    @Test
    void aWidgetClearOfThePipStaysWhereItWasLetGo() {
        int[] rect = {50, 50, 200, 100};
        assertSame(rect, PipEdge.clear(rect, PIP, 1000, 600));
        assertSame(rect, PipEdge.clear(rect, Collections.emptyList(), 1000, 600));
        int[] edge = {200, 100, 200, 100};
        assertSame(edge, PipEdge.clear(edge, PIP, 1000, 600), "touching the PiP's edge is not over it");
    }

    @Test
    void overThePipItGoesEdgeToEdgeByTheShortestMove() {
        // its right part over the PiP's left edge by 30: to the left of the PiP
        assertArrayEquals(new int[] {200, 150, 200, 100}, PipEdge.clear(new int[] {230, 150, 200, 100}, PIP, 1000, 600));
        // its top part over the PiP's bottom by 20: below it
        assertArrayEquals(new int[] {450, 300, 200, 100}, PipEdge.clear(new int[] {450, 280, 200, 100}, PIP, 1000, 600));
        // over the right edge by 10: to the right
        assertArrayEquals(new int[] {700, 150, 100, 50}, PipEdge.clear(new int[] {690, 150, 100, 50}, PIP, 1000, 600));
    }

    @Test
    void aMoveThatWouldLeaveThePageIsNotTaken() {
        // a PiP at the page's left edge: the move to its left would leave the page, the next shortest is taken
        List<int[]> pip = Collections.singletonList(new int[] {0, 0, 300, 300});
        assertArrayEquals(new int[] {300, 100, 200, 100}, PipEdge.clear(new int[] {150, 100, 200, 100}, pip, 1000, 600));
    }

    @Test
    void theNewPlaceIsClearOfEveryPip() {
        List<int[]> pips = Arrays.asList(new int[] {400, 100, 300, 200}, new int[] {100, 100, 300, 200});
        // left of the first PiP is the second: below them it goes
        assertArrayEquals(new int[] {300, 300, 200, 100},
                PipEdge.clear(new int[] {300, 250, 200, 100}, pips, 1000, 600));
    }

    @Test
    void noPlaceBesideThePipInThePageIsNone() {
        List<int[]> pip = Collections.singletonList(new int[] {0, 0, 1000, 600});
        assertNull(PipEdge.clear(new int[] {100, 100, 200, 100}, pip, 1000, 600));
    }
}
