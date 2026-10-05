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
    void bootDumpWaitsForTheBootToSettle() {
        assertFalse(LogcatWorker.bootDumpDue(30_000L, 0L));          // boot not completed yet
        assertFalse(LogcatWorker.bootDumpDue(40_000L, 25_000L));     // completed, not settled
        assertFalse(LogcatWorker.bootDumpDue(45_000L, 20_000L));     // settled, before 50 s
        assertTrue(LogcatWorker.bootDumpDue(50_000L, 20_000L));
        assertTrue(LogcatWorker.bootDumpDue(55_000L, 35_000L));      // 20 s after completion
        assertTrue(LogcatWorker.bootDumpDue(120_000L, 0L));          // latest moment
    }
}
