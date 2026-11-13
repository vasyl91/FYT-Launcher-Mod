package com.android.launcher66.settings;

/**
 * The texts of the Logcat settings without what only an FYT unit (or a debug build) writes.
 *
 * <p>The rule: the settings name the compat reports only where they are shown, that is on an FYT unit and in
 * debug builds ({@code LauncherApplication.showsFytOptions()}). The two texts are one string each in every
 * language, with the compat report as their last line and as one name in a list. The line starts with the
 * label of the file ("compat") and the name is the file's pattern ("compat_pid_…"); neither is translated,
 * so both can be taken out of the text of any language without a second set of strings. Pure Java, so that
 * it has a test.
 */
final class CompatInfoText {

    private static final String LABEL = "compat";

    private CompatInfoText() {
    }

    /** "What the names of the logs mean" without the line that explains the compat reports. */
    static String namesWithoutCompat(String names) {
        if (names == null) {
            return null;
        }
        StringBuilder kept = new StringBuilder();
        for (String line : names.split("\n", -1)) {
            if (line.trim().startsWith(LABEL)) {
                continue;
            }
            if (kept.length() > 0) {
                kept.append('\n');
            }
            kept.append(line);
        }
        return kept.toString();
    }

    /** "Where the logs are" without the compat report in the list of the reports' names. */
    static String locationsWithoutCompat(String locations) {
        if (locations == null) {
            return null;
        }
        // ", compat_pid_…" with the comma of the language (also the fullwidth and the ideographic one)
        return locations.replaceAll("\\s*[,\uFF0C\u3001]\\s*compat_pid_\u2026?", "");
    }
}
