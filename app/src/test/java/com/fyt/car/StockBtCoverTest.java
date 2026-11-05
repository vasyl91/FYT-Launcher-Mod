package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockBtCoverTest {

    @Test
    void aFileWrittenAfterTheChangeIsThisSongs() {
        assertTrue(StockBtCover.isFresh(10_000, 9_000));
        assertTrue(StockBtCover.isFresh(9_000, 9_000));
    }

    @Test
    void aFileUpToTwoSecondsOlderStillIs() {
        assertTrue(StockBtCover.isFresh(7_000, 9_000));
        assertFalse(StockBtCover.isFresh(6_999, 9_000));
    }

    @Test
    void aMissingFileIsNoCover() {
        assertFalse(StockBtCover.isFresh(0, 9_000));
        assertFalse(StockBtCover.isFresh(-1, 9_000));
    }

    @Test
    void theReadsAfterATitleChangeAre1500Then3000Then6000() {
        assertArrayEquals(new long[]{1_500, 3_000, 6_000}, StockBtCover.readDelaysAfterTitleChange());
    }
}
