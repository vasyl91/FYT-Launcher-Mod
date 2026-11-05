package com.android.launcher66.settings;

import java.util.Locale;
import java.util.TimeZone;

/**
 * The words of the note a renamed log capture gets. The lines of a capture carry local time, so
 * the shift they show is the difference of the two wall-clock readings, not of the two instants:
 * when a daylight-saving change lies between the stamp the clock gave and the real start, the
 * instants are an hour further apart than the readings (25-10-2026: the header said 12d 03:38:16
 * and the note 12d 04:38:17). Pure, so it can be tested.
 */
final class LogClockShift {

    private LogClockShift() {}

    /**
     * The shift of the lines: positive when the clock was behind. {@code offByMs} is the distance
     * of the instants (real start minus the start the file name shows).
     */
    static long shownShiftMs(long offByMs, long realStartMs, long shownMs, TimeZone tz) {
        return offByMs + tz.getOffset(realStartMs) - tz.getOffset(shownMs);
    }

    /**
     * "behind by 12d 03:38:17", and when the instants differ from what the lines show, also
     * "(12d 04:38:17 in real time; a daylight-saving change lies in between)".
     */
    static String describe(long offByMs, long realStartMs, long shownMs, TimeZone tz) {
        long shown = shownShiftMs(offByMs, realStartMs, shownMs, tz);
        String text = describe(shown);
        if (shown != offByMs) {
            text += " (" + duration(offByMs) + " in real time; a daylight-saving change lies in between)";
        }
        return text;
    }

    /** "behind by 659d 03:40:52" for a clock that showed an earlier time than the real one. */
    static String describe(long offByMs) {
        return (offByMs > 0 ? "behind by " : "ahead by ") + duration(offByMs);
    }

    private static String duration(long ms) {
        long abs = Math.abs(ms);
        long days = abs / 86_400_000L;
        long rest = abs % 86_400_000L;
        String hms = String.format(Locale.US, "%02d:%02d:%02d",
                rest / 3_600_000L, (rest / 60_000L) % 60L, (rest / 1000L) % 60L);
        return (days > 0 ? days + "d " : "") + hms;
    }
}
