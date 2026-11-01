package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.android.launcher66.settings.LogcatWorker.Mode;
import com.android.launcher66.settings.LogcatWorker.Trigger;

import org.junit.jupiter.api.Test;

class LogcatWorkerNotesTest {

    @Test
    void theHeaderNamesWhatStartedTheCaptureAndKeepsTheModeAsItWas() {
        assertEquals("===== STREAM (PID=2174, buffer=main, timeout=60s, mode=FROM_APP_START, trigger=cold start) =====",
                LogcatWorker.streamHeader(2174, "main", 60, Mode.FROM_APP_START, Trigger.COLD_START));
        assertEquals("===== STREAM (PID=2680, buffer=main, timeout=30s, mode=FROM_APP_START, trigger=wake) =====",
                LogcatWorker.streamHeader(2680, "main", 30, Mode.FROM_APP_START, Trigger.WAKE));
        assertEquals("===== STREAM (PID=1, buffer=main, timeout=30s, mode=FROM_NOW, trigger=manual) =====",
                LogcatWorker.streamHeader(1, "main", 30, Mode.FROM_NOW, Trigger.MANUAL));
        assertEquals("trigger=process start", "trigger=" + Trigger.PROCESS_START.label);
    }

    @Test
    void aWakeThatExtendsTheCaptureSaysSo() {
        assertEquals("===== wake at 912 s of uptime: capture extended =====", LogcatWorker.wakeExtendedLine(912L));
    }

    @Test
    void aClockJumpIsNamedWithItsSizeAndDirection() {
        long forward = (2L * 24 + 16) * 3_600_000L + 38 * 60_000L + 52_000L;     // capture C: +2d16h38m
        assertEquals("===== CLOCK CHANGED (was behind by 2d 16:38:52) at 46 s of uptime:"
                + " the lines below use the new time =====", LogcatWorker.clockChangedLine(forward, 46L));
        assertEquals("===== CLOCK CHANGED (was ahead by 01:00:00) at 29 s of uptime:"
                + " the lines below use the new time =====", LogcatWorker.clockChangedLine(-3_600_000L, 29L));
    }
}
