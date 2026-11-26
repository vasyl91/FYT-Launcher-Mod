package com.android.launcher66.settings;

/**
 * How long a log capture keeps reading after it was told to end, and what it says when it gives up.
 *
 * <p>The rule (the owner's, 2026-11-25): a stop ends the capture within seconds. Logcat is read past the moment of
 * the stop only for lines older than that moment, for {@link #MAX_MS} at the most; it is let go earlier when it
 * has caught up with the moment (a line newer than it) or has had nothing to say for {@link #IDLE_MS}. Lines
 * newer than the stop are never written. When logcat is still behind after {@link #MAX_MS} (the start-up
 * capture reads whole buffers of 8 MiB through the host, minutes of lines) it is killed, and the file says how far
 * behind it was and that the rest of the buffers were not read. It used to be 120 s, which a restart of the
 * unit turned into minutes of "Saving the log..." and a file of tens of megabytes. Pure Java, so that it has
 * a test.
 */
final class DrainPlan {

    /** The most a capture reads past its end. */
    static final long MAX_MS = 10_000L;
    /** No line for this long: logcat has nothing more up to the end. */
    static final long IDLE_MS = 1_500L;

    /** What the watch does at each look. */
    enum Action { WAIT, CAUGHT_UP, TIMED_OUT }

    private DrainPlan() {
    }

    /**
     * @param sinceDrainStartMs how long the capture has been reading past its end (while logcat runs)
     * @param sinceLastLineMs   how long ago logcat last gave a line
     */
    static Action next(long sinceDrainStartMs, long sinceLastLineMs) {
        if (sinceDrainStartMs >= MAX_MS) {
            return Action.TIMED_OUT;
        }
        if (sinceLastLineMs >= IDLE_MS) {
            return Action.CAUGHT_UP;
        }
        return Action.WAIT;
    }

    /** Whether a line is written: never one newer than the moment of the stop. A line with no readable time is kept. */
    static boolean takesLine(long lineWallMs, long cutoffWallMs) {
        return lineWallMs < 0L || lineWallMs <= cutoffWallMs;
    }

    /**
     * How many seconds logcat was behind the stop when it was killed: the stop's time less the time of the last
     * line it gave; -1 when no line was read (or its time could not be read).
     */
    static long behindSeconds(long cutoffWallMs, long lastLineWallMs) {
        if (lastLineWallMs <= 0L) {
            return -1L;
        }
        return Math.max(0L, (cutoffWallMs - lastLineWallMs) / 1000L);
    }

    /** The closing line of a capture that was cut at {@link #MAX_MS}. */
    static String footer(long afterEndSeconds, long behindSeconds) {
        if (behindSeconds < 0L) {
            return "===== stopped " + afterEndSeconds + " s after the end; logcat gave no line with a time,"
                    + " the rest of the buffers not read =====";
        }
        return "===== stopped " + afterEndSeconds + " s after the end; logcat was " + behindSeconds
                + " s behind, the rest of the buffers not read =====";
    }
}
