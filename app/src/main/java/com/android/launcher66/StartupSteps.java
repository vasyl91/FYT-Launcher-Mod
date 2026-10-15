package com.android.launcher66;

import android.os.SystemClock;

/**
 * Durations of the steps of a start, for one log line: toString() lists the steps of 20 ms or
 * more, in order. Not thread-safe: marked from one thread at a time.
 */
final class StartupSteps {
    private static final long REPORTED_MS = 20;
    private final StringBuilder slow = new StringBuilder();
    private long last;

    StartupSteps(long start) {
        last = start;
    }

    void mark(String step) {
        long now = SystemClock.elapsedRealtime();
        if (now - last >= REPORTED_MS) {
            slow.append(slow.length() == 0 ? " (" : ", ").append(step).append(' ')
                    .append(now - last);
        }
        last = now;
    }

    @Override
    public String toString() {
        return slow.length() == 0 ? "" : slow + ")";
    }
}
