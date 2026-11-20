package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScreenIdsMemoryTest {

    @Test
    void theIdsReadAtTheStartServeEveryLauncherOfTheProcess() {
        ScreenIdsMemory memory = new ScreenIdsMemory();
        assertNull(memory.take(), "nothing read yet: the Workspace queries them itself");

        int ticket = memory.readStarts();
        assertTrue(memory.reading());
        assertTrue(memory.readEnds(ticket, new long[] {1, 2, 3}));
        assertFalse(memory.reading());

        long[] first = memory.take();
        assertArrayEquals(new long[] {1, 2, 3}, first);
        first[0] = 99;   // the Workspace's own copy
        assertArrayEquals(new long[] {1, 2, 3}, memory.take(), "the launcher created again gets the same ids");
    }

    @Test
    void aWriteDropsTheIdsAndTheReadAfterItBringsTheNewOnes() {
        ScreenIdsMemory memory = new ScreenIdsMemory();
        memory.readEnds(memory.readStarts(), new long[] {1, 2});

        memory.writing();
        assertNull(memory.take(), "what is in memory is out of date while the table is written");

        int ticket = memory.readStarts();   // given out once the write is committed
        assertTrue(memory.readEnds(ticket, new long[] {2, 1, 3}));
        assertArrayEquals(new long[] {2, 1, 3}, memory.take());
    }

    @Test
    void aReadBegunBeforeALaterWriteIsRefused() {
        ScreenIdsMemory memory = new ScreenIdsMemory();
        int before = memory.readStarts();
        memory.writing();
        int after = memory.readStarts();

        assertFalse(memory.readEnds(before, new long[] {1}), "it may hold the table before the write");
        assertTrue(memory.reading(), "the read after the write is still under way");
        assertNull(memory.take());

        assertTrue(memory.readEnds(after, new long[] {1, 4}));
        assertFalse(memory.reading());
        assertArrayEquals(new long[] {1, 4}, memory.take());
    }

    @Test
    void aFailedReadKeepsNothingAndIsNoLongerUnderWay() {
        ScreenIdsMemory memory = new ScreenIdsMemory();
        int ticket = memory.readStarts();
        assertFalse(memory.readEnds(ticket, null));
        assertFalse(memory.reading());
        assertNull(memory.take());
    }
}
