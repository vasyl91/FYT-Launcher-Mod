package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrashLoopPolicyTest {

    private static final long NOW = 1_000_000_000L;

    @Test
    void twoCrashesWithinTheWindowAreNoSafeMode() {
        List<Long> history = Arrays.asList(NOW - 30_000L, NOW - 10_000L);
        assertFalse(CrashLoopPolicy.safeMode(history, NOW));
    }

    @Test
    void threeCrashesWithinTheWindowStartTheSafeMode() {
        List<Long> history = Arrays.asList(NOW - 100_000L, NOW - 30_000L, NOW - 10_000L);
        assertTrue(CrashLoopPolicy.safeMode(history, NOW));
    }

    @Test
    void aCrashOlderThanTheWindowDoesNotCount() {
        List<Long> history = Arrays.asList(NOW - 121_000L, NOW - 30_000L, NOW - 10_000L);
        assertEquals(2, CrashLoopPolicy.recent(history, NOW));
        assertFalse(CrashLoopPolicy.safeMode(history, NOW));
    }

    @Test
    void aCrashFromTheFutureCountsBecauseTheClockMayHaveBeenSetBack() {
        List<Long> history = Arrays.asList(NOW + 5_000L, NOW - 30_000L, NOW - 10_000L);
        assertTrue(CrashLoopPolicy.safeMode(history, NOW));
    }

    @Test
    void appendKeepsTheNewestTenEntries() {
        String history = "";
        for (int i = 0; i < 15; i++) {
            history = CrashLoopPolicy.append(history, NOW + i, "Crash " + i);
        }
        List<Long> times = CrashLoopPolicy.parse(history);
        assertEquals(CrashLoopPolicy.MAX_ENTRIES, times.size());
        assertEquals(Long.valueOf(NOW + 5), times.get(0));
        assertEquals(Long.valueOf(NOW + 14), times.get(9));
    }

    @Test
    void appendPutsTheDescriptionOnOneLine() {
        String history = CrashLoopPolicy.append(null, NOW, "A: first\nsecond");
        assertEquals(NOW + " A: first second\n", history);
    }

    @Test
    void damagedLinesAreSkipped() {
        String text = NOW + " A: x\nnot a number\n\n123abc rest\n" + (NOW + 1) + "\n12";
        assertEquals(Arrays.asList(NOW, NOW + 1, 12L), CrashLoopPolicy.parse(text));
        assertTrue(CrashLoopPolicy.parse(null).isEmpty());
    }

    @Test
    void lastOneLineIsTheNewestDescription() {
        String text = NOW + " NumberFormatException: first\n" + (NOW + 1) + " IllegalStateException: second\n";
        assertEquals("IllegalStateException: second", CrashLoopPolicy.lastOneLine(text));
        assertNull(CrashLoopPolicy.lastOneLine(""));
        assertNull(CrashLoopPolicy.lastOneLine(null));
    }
}
