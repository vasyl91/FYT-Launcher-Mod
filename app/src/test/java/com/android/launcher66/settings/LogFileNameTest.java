package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.android.launcher66.settings.LogcatWorker.Trigger;

import org.junit.jupiter.api.Test;

class LogFileNameTest {

    private static final String TS = "27-10-2026_21-51-41";

    @Test
    void thePrefixSaysWhatStartedTheCaptureAndWhatItHolds() {
        for (String trigger : new String[]{"reboot", "start", "wake", "user"}) {
            assertEquals(trigger + "_full_", LogFileName.prefix(trigger, true));
            assertEquals(trigger + "_pid_", LogFileName.prefix(trigger, false));
        }
    }

    @Test
    void aNameIsPrefixStampAndSuffix() {
        assertEquals("reboot_full_" + TS + ".txt",
                LogFileName.name(LogFileName.prefix("reboot", true), TS, LogFileName.TXT));
        assertEquals("reboot_full_" + TS + "_late.txt",
                LogFileName.name(LogFileName.prefix("reboot", true), TS, LogFileName.LATE_SUFFIX));
    }

    @Test
    void aNewNameIsTakenApart() {
        LogFileName.Parts parts = LogFileName.parse("wake_pid_" + TS + ".txt");
        assertEquals("wake_pid_", parts.prefix);
        assertEquals(TS, parts.timestamp);
        assertEquals(LogFileName.TXT, parts.suffix);
    }

    @Test
    void theNumberUniqueFileAddsIsNotPartOfTheSuffix() {
        LogFileName.Parts parts = LogFileName.parse("user_full_" + TS + "_1.txt");
        assertEquals("user_full_", parts.prefix);
        assertEquals(TS, parts.timestamp);
        assertEquals(LogFileName.TXT, parts.suffix);
    }

    @Test
    void aLateDumpIsRecognisedWithAndWithoutANumber() {
        assertEquals(LogFileName.LATE_SUFFIX,
                LogFileName.parse("reboot_full_" + TS + "_late.txt").suffix);
        assertEquals(LogFileName.LATE_SUFFIX,
                LogFileName.parse("reboot_full_" + TS + "_late_2.txt").suffix);
    }

    @Test
    void anOldNameWithoutAPrefixIsStillRecognised() {
        LogFileName.Parts parts = LogFileName.parse(TS + ".txt");
        assertEquals("", parts.prefix);
        assertEquals(TS, parts.timestamp);
        assertEquals(LogFileName.TXT, parts.suffix);
    }

    @Test
    void aNameWithoutAStampIsNotOurs() {
        assertNull(LogFileName.parse("notes.txt"));
        assertNull(LogFileName.parse("reboot_full_27-10-26_21-51.txt"));
        assertNull(LogFileName.withTimestamp("notes.txt", TS));
    }

    @Test
    void theScopeChangesFromPidToFullAndBack() {
        assertEquals("reboot_full_" + TS + ".txt",
                LogFileName.withScope("reboot_pid_" + TS + ".txt", true));
        assertEquals("reboot_full_" + TS + "_1.txt",
                LogFileName.withScope("reboot_pid_" + TS + "_1.txt", true));
        assertEquals("wake_pid_" + TS + ".txt",
                LogFileName.withScope("wake_full_" + TS + ".txt", false));
    }

    @Test
    void aNameAlreadyInThatScopeOrWithoutOneStaysAsItIs() {
        assertEquals("user_full_" + TS + ".txt",
                LogFileName.withScope("user_full_" + TS + ".txt", true));
        assertEquals(TS + ".txt", LogFileName.withScope(TS + ".txt", true));
        assertEquals("notes.txt", LogFileName.withScope("notes.txt", true));
    }

    @Test
    void aClockCorrectionKeepsThePrefixAndTheKindOfFile() {
        String corrected = "27-10-2026_22-03-43";
        assertEquals("reboot_pid_" + corrected + ".txt",
                LogFileName.withTimestamp("reboot_pid_" + TS + ".txt", corrected));
        assertEquals("reboot_full_" + corrected + "_late.txt",
                LogFileName.withTimestamp("reboot_full_" + TS + "_late.txt", corrected));
        assertEquals(corrected + ".txt", LogFileName.withTimestamp(TS + ".txt", corrected));
    }

    @Test
    void theTriggersUseTheWordsTheLegendExplains() {
        assertEquals("reboot", Trigger.COLD_START.fileLabel);
        assertEquals("start", Trigger.PROCESS_START.fileLabel);
        assertEquals("wake", Trigger.WAKE.fileLabel);
        assertEquals("user", Trigger.MANUAL.fileLabel);
    }
}
