package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class LogClockShiftTest {

    private static final ZoneId WARSAW = ZoneId.of("Europe/Warsaw");
    private static final TimeZone TZ = TimeZone.getTimeZone(WARSAW);

    private static long ms(int y, int mo, int d, int h, int mi, int s) {
        return LocalDateTime.of(y, mo, d, h, mi, s).atZone(WARSAW).toInstant().toEpochMilli();
    }

    @Test
    void theLinesShowTheShiftOfTheWallClockAcrossTheEndOfSummerTime() {
        long shown = ms(2026, 10, 24, 4, 35, 44);   // CEST
        long real = ms(2026, 11, 5, 8, 14, 1);      // CET
        long offBy = real - shown;
        assertEquals("12d 04:38:17", LogClockShift.describe(offBy).replace("behind by ", ""));
        assertEquals(offBy - 3_600_000L, LogClockShift.shownShiftMs(offBy, real, shown, TZ));
        assertEquals("behind by 12d 03:38:17 (12d 04:38:17 in real time; a daylight-saving change"
                + " lies in between)", LogClockShift.describe(offBy, real, shown, TZ));
    }

    @Test
    void withoutAChangeInBetweenTheNoteIsPlain() {
        long shown = ms(2026, 11, 1, 10, 0, 0);
        long real = ms(2026, 11, 5, 8, 14, 1);
        String text = LogClockShift.describe(real - shown, real, shown, TZ);
        assertEquals("behind by 3d 22:14:01", text);
        assertFalse(text.contains("daylight"));
    }

    @Test
    void aClockAheadIsDescribedAsAhead() {
        long shown = ms(2026, 11, 5, 10, 0, 0);
        long real = ms(2026, 11, 5, 8, 0, 0);
        String text = LogClockShift.describe(real - shown, real, shown, TZ);
        assertTrue(text.startsWith("ahead by 02:00:00"));
    }

    @Test
    void theStartOfSummerTimeShortensTheShiftOfTheLines() {
        long shown = ms(2026, 3, 20, 12, 0, 0);     // CET
        long real = ms(2026, 4, 2, 12, 0, 0);       // CEST
        long offBy = real - shown;
        assertEquals(offBy + 3_600_000L, LogClockShift.shownShiftMs(offBy, real, shown, TZ));
    }
}
