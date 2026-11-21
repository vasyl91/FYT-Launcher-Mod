package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void theFirstSongAfterAStartTakesItsFileWhateverItsAge() {
        // The launcher started in the middle of a song: the file was written when it began, minutes ago
        assertEquals(StockBtCover.TitleChange.FIRST, StockBtCover.titleChange(null, "Song A"));
        assertEquals(StockBtCover.UNKNOWN, StockBtCover.changedAtNow(1_000_000, 50_000, 0));
        assertTrue(StockBtCover.isFresh(1, StockBtCover.UNKNOWN));
        assertFalse(StockBtCover.isFresh(0, StockBtCover.UNKNOWN), "still no file, no cover");
    }

    @Test
    void aTitleClearedForAMomentIsTheSameSong() {
        assertEquals(StockBtCover.TitleChange.CLEARED, StockBtCover.titleChange("Song A", ""));
        assertEquals(StockBtCover.TitleChange.CLEARED, StockBtCover.titleChange("Song A", "  "));
        assertEquals(StockBtCover.TitleChange.CLEARED, StockBtCover.titleChange("Song A", null));
        assertEquals(StockBtCover.TitleChange.SAME, StockBtCover.titleChange("Song A", "Song A "));
        assertEquals(StockBtCover.TitleChange.NEW, StockBtCover.titleChange("Song A", "Song B"));
    }

    @Test
    void aJumpOfTheClockBackDoesNotMakeTheNewFileOld() {
        // The song changed at elapsed 40 s, wall 1 000 000; the clock was set back by 10 minutes after that and the
        // file was written 1 s after the change, on the new clock
        long changedElapsed = 40_000;
        long nowElapsed = 45_000;
        long nowWall = 1_000_000 - 600_000 + 5_000;
        long changedAt = StockBtCover.changedAtNow(nowWall, nowElapsed, changedElapsed);
        assertEquals(1_000_000 - 600_000, changedAt);
        long fileWritten = 1_000_000 - 600_000 + 1_000;
        assertTrue(StockBtCover.isFresh(fileWritten, changedAt));
        // Taken as the raw wall time of the change it looked ten minutes old
        assertFalse(StockBtCover.isFresh(fileWritten, 1_000_000));
        // Without a jump, the time of the change is the one it had
        assertEquals(1_000_000, StockBtCover.changedAtNow(1_005_000, 45_000, 40_000));
    }
}
