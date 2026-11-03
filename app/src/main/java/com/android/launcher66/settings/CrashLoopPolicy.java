package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.List;

/**
 * When the launcher has crashed too often in a row to be trusted with its custom elements, free of
 * android.* so that it can be tested on the JVM. The history is a text of lines
 * {@code <wall clock millis> <exception, one line>}, one per crash.
 */
final class CrashLoopPolicy {

    /** Crashes older than this do not count. */
    static final long WINDOW_MS = 120_000L;
    /** This many crashes within the window start the safe mode. */
    static final int CRASHES = 3;
    /** The history keeps no more than this many of the newest crashes. */
    static final int MAX_ENTRIES = 10;

    private CrashLoopPolicy() {
    }

    /** The crash times of a history text; a damaged line (a crash can cut a write short) is skipped. */
    static List<Long> parse(String text) {
        List<Long> times = new ArrayList<>();
        if (text == null) {
            return times;
        }
        for (String line : text.split("\n")) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            int space = trimmed.indexOf(' ');
            String number = space < 0 ? trimmed : trimmed.substring(0, space);
            try {
                times.add(Long.parseLong(number));
            } catch (NumberFormatException e) {
                // Damaged line, skipped.
            }
        }
        return times;
    }

    /**
     * The history text with this crash added, cut to the newest {@link #MAX_ENTRIES} lines. The
     * other lines are kept as they are, but only the ones that parse count towards the limit.
     */
    static String append(String history, long now, String oneLine) {
        List<String> lines = new ArrayList<>();
        if (history != null) {
            for (String line : history.split("\n")) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty() && !parse(trimmed).isEmpty()) {
                    lines.add(trimmed);
                }
            }
        }
        lines.add(now + " " + singleLine(oneLine));
        int from = Math.max(0, lines.size() - MAX_ENTRIES);
        StringBuilder out = new StringBuilder();
        for (int i = from; i < lines.size(); i++) {
            out.append(lines.get(i)).append('\n');
        }
        return out.toString();
    }

    /**
     * The crashes within the window ending at {@code now}. A time after {@code now} counts too: the
     * clock may have been set back since.
     */
    static int recent(List<Long> history, long now) {
        int count = 0;
        for (long time : history) {
            if (now - time <= WINDOW_MS) {
                count++;
            }
        }
        return count;
    }

    static boolean safeMode(List<Long> history, long now) {
        return recent(history, now) >= CRASHES;
    }

    /** The description of the newest line of a history text, without its time; null if there is none. */
    static String lastOneLine(String text) {
        if (text == null) {
            return null;
        }
        String[] lines = text.split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            String trimmed = lines[i].trim();
            int space = trimmed.indexOf(' ');
            if (space > 0 && !parse(trimmed).isEmpty()) {
                String rest = trimmed.substring(space + 1).trim();
                return rest.isEmpty() ? null : rest;
            }
        }
        return null;
    }

    private static String singleLine(String text) {
        return text == null ? "?" : text.replace('\n', ' ').replace('\r', ' ').trim();
    }
}
