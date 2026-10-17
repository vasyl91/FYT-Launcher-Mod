package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LogcatWorkerTimingTest {

    private static final long NOW = 1_800_000_000_000L;

    @Test
    void bootCaptureNeedsBootLogColdStartAndEarlyUptime() {
        LogcatWorker.Mode all = LogcatWorker.Mode.FROM_APP_START;
        assertTrue(LogcatWorker.isBootCapture(true, true, all, 30_000L));
        assertFalse(LogcatWorker.isBootCapture(false, true, all, 30_000L));
        assertFalse(LogcatWorker.isBootCapture(true, false, all, 30_000L));          // a wake
        assertFalse(LogcatWorker.isBootCapture(true, true, LogcatWorker.Mode.FROM_NOW, 30_000L));
        assertFalse(LogcatWorker.isBootCapture(true, true, all, 4L * 60_000L));      // too late
    }

    @Test
    void wakeCaptureWithLargeBuffersLooksOneMinuteBack() {
        assertEquals(NOW - 60_000L, LogcatWorker.captureStartMs(true, false, 0L, NOW));
    }

    @Test
    void bootCaptureTakesTheWholeBuffers() {
        assertEquals(0L, LogcatWorker.captureStartMs(true, true, 0L, NOW));
    }

    @Test
    void withoutBootLogTheRequestStands() {
        assertEquals(0L, LogcatWorker.captureStartMs(false, false, 0L, NOW));
        assertEquals(NOW - 5L, LogcatWorker.captureStartMs(false, false, NOW - 5L, NOW));
        assertEquals(NOW - 5L, LogcatWorker.captureStartMs(true, false, NOW - 5L, NOW)); // "from now"
    }

    @Test
    void endOfCaptureComparesTheLineTime() {
        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("MM-dd HH:mm:ss.SSS", java.util.Locale.US);
        long now = System.currentTimeMillis();
        String line = fmt.format(new java.util.Date(now)) + "  1234  1234 I Tag: text";
        long lineMs = LogcatWorker.lineWallMs(fmt, line, now);
        assertEquals(now, lineMs);
        assertTrue(LogcatWorker.isNewerThan(fmt, line, now - 1L));
        assertFalse(LogcatWorker.isNewerThan(fmt, line, now));
        // Lines without a time (logcat's own headers) never end the capture.
        assertFalse(LogcatWorker.isNewerThan(fmt, "--------- beginning of main", 0L));
        assertEquals(-1L, LogcatWorker.lineWallMs(fmt, "--------- beginning of main", now));
    }
}
