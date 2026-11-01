package com.android.launcher66.settings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The names of the capture files, free of android.* so that they can be tested on the JVM:
 *
 * <pre>
 *   &lt;trigger&gt;_&lt;scope&gt;_&lt;dd-MM-yyyy_HH-mm-ss&gt;[_N].txt            reboot_full_27-10-2026_21-51-41.txt
 *   &lt;trigger&gt;_full_&lt;dd-MM-yyyy_HH-mm-ss&gt;[_N]_late.txt   a late full dump
 * </pre>
 *
 * The trigger says what started the capture (reboot, start, wake, user) and the scope what the file
 * holds (full: all the device's logs, pid: the launcher's own). The words are the ones the legend in
 * the settings explains (R.string.logcat_names_info_summary), so they must not be changed on one side
 * only. Files from before have no prefix, and are still recognised.
 */
final class LogFileName {

    /** The time stamp format; the stamp is the capture's start time. */
    static final String NAME_PATTERN = "dd-MM-yyyy_HH-mm-ss";
    static final String TXT = ".txt";
    /** A late full dump is named like its capture, with this in place of the extension. */
    static final String LATE_SUFFIX = "_late.txt";

    private static final String SCOPE_FULL = "full";
    private static final String SCOPE_PID = "pid";
    private static final Pattern TIMESTAMP = Pattern.compile("\\d{2}-\\d{2}-\\d{4}_\\d{2}-\\d{2}-\\d{2}");
    private static final Pattern LATE_TAIL = Pattern.compile("_late(_\\d+)?\\.txt");

    private LogFileName() {
    }

    /** What a file name is made of. */
    static final class Parts {
        /** Before the time stamp, e.g. "wake_pid_"; empty for a name from before the prefixes. */
        final String prefix;
        final String timestamp;
        /** LATE_SUFFIX or TXT, without the "_N" that uniqueFile() may have put in. */
        final String suffix;

        Parts(String prefix, String timestamp, String suffix) {
            this.prefix = prefix;
            this.timestamp = timestamp;
            this.suffix = suffix;
        }
    }

    /** E.g. "wake_pid_" for the trigger label "wake" and a capture of the launcher's log only. */
    static String prefix(String triggerLabel, boolean full) {
        return triggerLabel + "_" + (full ? SCOPE_FULL : SCOPE_PID) + "_";
    }

    static String name(String prefix, String timestamp, String suffix) {
        return prefix + timestamp + suffix;
    }

    /** The parts of a name; null if it has no time stamp, i.e. is not a name given by the worker. */
    static Parts parse(String fileName) {
        Matcher m = TIMESTAMP.matcher(fileName);
        if (!m.find()) return null;
        String rest = fileName.substring(m.end());
        String suffix = LATE_TAIL.matcher(rest).matches() ? LATE_SUFFIX : TXT;
        return new Parts(fileName.substring(0, m.start()), m.group(), suffix);
    }

    /**
     * The name with the scope in its prefix set to full or pid. A name without a scope (from before
     * the prefixes) is returned as it is.
     */
    static String withScope(String fileName, boolean full) {
        Parts parts = parse(fileName);
        if (parts == null) return fileName;
        String from = "_" + (full ? SCOPE_PID : SCOPE_FULL) + "_";
        String to = "_" + (full ? SCOPE_FULL : SCOPE_PID) + "_";
        if (!parts.prefix.endsWith(from)) return fileName;
        String prefix = parts.prefix.substring(0, parts.prefix.length() - from.length()) + to;
        return prefix + fileName.substring(parts.prefix.length());
    }

    /**
     * The name for a corrected start time: the prefix and the kind of file (ordinary or late) stay,
     * the stamp is replaced. Null if the name has no time stamp.
     */
    static String withTimestamp(String fileName, String newTimestamp) {
        Parts parts = parse(fileName);
        return parts == null ? null : name(parts.prefix, newTimestamp, parts.suffix);
    }
}
