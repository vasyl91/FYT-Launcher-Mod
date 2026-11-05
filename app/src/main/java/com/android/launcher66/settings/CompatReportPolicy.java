package com.android.launcher66.settings;

import java.util.HashMap;
import java.util.Map;

/**
 * Decides which failures of FYT-only code are reported, free of android.* so that it can be tested on
 * the JVM. A failure is identified by its key (area, exception class and the first stack frame in
 * this app's or FYT's packages); the first one of a key in the process gets a log with the stack and a
 * report file, the ones after it are only counted. At most {@link #MAX_REPORTS} reports are written in
 * a process, after that the log only says how many failures there have been, once per
 * {@link #LOG_EVERY} of them. A key that failed {@link #DISABLE_AFTER} times is "disabled": the caller
 * may skip that code from then on, where skipping is safe.
 */
final class CompatReportPolicy {

    static final int MAX_REPORTS = 10;
    static final int LOG_EVERY = 50;
    static final int DISABLE_AFTER = 5;

    /** What to do with one failure. */
    enum Action {
        /** Log the stack and write a report file. */
        REPORT,
        /** Only count it. */
        COUNT,
        /** Log one line with the count. */
        LOG_COUNT
    }

    private final Map<String, Integer> counts = new HashMap<>();
    private int reports;

    /** The key of a failure: the area, the exception class and the first frame of this app's or FYT's code. */
    static String key(String area, Throwable t) {
        StringBuilder sb = new StringBuilder(area).append('|').append(t.getClass().getName());
        StackTraceElement[] stack = t.getStackTrace();
        if (stack != null) {
            for (StackTraceElement e : stack) {
                String cls = e.getClassName();
                if (cls.startsWith("com.android.launcher66") || cls.startsWith("com.syu")
                        || cls.startsWith("com.fyt")) {
                    sb.append('|').append(cls).append('.').append(e.getMethodName())
                            .append(':').append(e.getLineNumber());
                    break;
                }
            }
        }
        return sb.toString();
    }

    /** Records one failure of the key and says what to do with it. */
    synchronized Action record(String key) {
        int n = counts.merge(key, 1, Integer::sum);
        if (n == 1 && reports < MAX_REPORTS) {
            reports++;
            return Action.REPORT;
        }
        if (reports >= MAX_REPORTS && n % LOG_EVERY == 0) {
            return Action.LOG_COUNT;
        }
        return Action.COUNT;
    }

    /** How many times the key has failed. */
    synchronized int count(String key) {
        Integer n = counts.get(key);
        return n == null ? 0 : n;
    }

    /** Whether the key has failed often enough for its caller to skip that code from now on. */
    synchronized boolean isDisabled(String key) {
        return count(key) >= DISABLE_AFTER;
    }

    /** Whether any failure key of the area is disabled (see {@link #isDisabled}). */
    synchronized boolean isAreaDisabled(String area) {
        String prefix = area + "|";
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getKey().startsWith(prefix) && e.getValue() >= DISABLE_AFTER) {
                return true;
            }
        }
        return false;
    }

    /** The number of reports written so far. */
    synchronized int reports() {
        return reports;
    }
}
