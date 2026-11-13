package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CompatInfoTextTest {

    @Test
    void theCompatLineIsTakenOutOfTheNames() {
        String names = "pid \u2013 holds the launcher's logs only\n"
                + "crash \u2013 written the moment the launcher crashed\n"
                + "compat \u2013 written when code made for FYT units failed";
        assertEquals("pid \u2013 holds the launcher's logs only\n"
                + "crash \u2013 written the moment the launcher crashed", CompatInfoText.namesWithoutCompat(names));
    }

    @Test
    void aTextWithoutACompatLineStaysAsItIs() {
        String names = "reboot \u2013 a\nstart \u2013 b";
        assertEquals(names, CompatInfoText.namesWithoutCompat(names));
    }

    @Test
    void theCompatReportIsTakenOutOfTheEnglishList() {
        assertEquals("Download/Launcher66_Logs \u2013 the logs and the crash reports (crash_pid_\u2026)\nsecond line",
                CompatInfoText.locationsWithoutCompat("Download/Launcher66_Logs \u2013 the logs and the crash "
                        + "reports (crash_pid_\u2026, compat_pid_\u2026)\nsecond line"));
    }

    @Test
    void theCommasOfChineseAndJapaneseAreKnown() {
        assertEquals("\uFF08crash_pid_\u2026\uFF09",
                CompatInfoText.locationsWithoutCompat("\uFF08crash_pid_\u2026\uFF0Ccompat_pid_\u2026\uFF09"));
        assertEquals("\uFF08crash_pid_\u2026\uFF09",
                CompatInfoText.locationsWithoutCompat("\uFF08crash_pid_\u2026\u3001compat_pid_\u2026\uFF09"));
    }

    @Test
    void nothingToCleanIsNothing() {
        assertNull(CompatInfoText.namesWithoutCompat(null));
        assertNull(CompatInfoText.locationsWithoutCompat(null));
    }
}
