package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.LogcatWorker.StartPlan;
import com.android.launcher66.settings.LogcatWorker.Trigger;

import org.junit.jupiter.api.Test;

class LogcatWorkerStartPlanTest {

    // startPlan(wantsFullLog, system, hostAttached, hostExpected)

    @Test
    void withoutTheSettingItIsTheLaunchersOwnLogWhateverTheHost() {
        assertEquals(StartPlan.NOT_WANTED, LogcatWorker.startPlan(false, false, false, true));
        assertEquals(StartPlan.NOT_WANTED, LogcatWorker.startPlan(false, true, true, false));
    }

    @Test
    void aSystemLauncherReadsEverythingItself() {                    // FYT 7862
        assertEquals(StartPlan.SYSTEM, LogcatWorker.startPlan(true, true, false, false));
        assertEquals(StartPlan.SYSTEM, LogcatWorker.startPlan(true, true, true, true));
    }

    @Test
    void anAttachedHostIsUsedAtOnce() {                              // A55, Redmi
        assertEquals(StartPlan.HOST, LogcatWorker.startPlan(true, false, true, false));
        assertEquals(StartPlan.HOST, LogcatWorker.startPlan(true, false, true, true));
    }

    @Test
    void aHostOnItsWayIsNotWaitedForIdly() {                         // 7870 after a boot
        assertEquals(StartPlan.HOST_ON_ITS_WAY, LogcatWorker.startPlan(true, false, false, true));
    }

    @Test
    void noHostAndNoneExpectedIsTheLaunchersOwnLog() {
        assertEquals(StartPlan.NO_HOST, LogcatWorker.startPlan(true, false, false, false));
    }

    @Test
    void hostWindowsFollowTheTrigger() {
        assertEquals(180_000L, LogcatWorker.hostWaitMs(Trigger.COLD_START));
        assertEquals(60_000L, LogcatWorker.hostWaitMs(Trigger.WAKE));
        assertEquals(15_000L, LogcatWorker.hostWaitMs(Trigger.MANUAL));
        assertEquals(15_000L, LogcatWorker.hostWaitMs(Trigger.PROCESS_START));
    }

    @Test
    void aLateDumpWindowIsTenMinutesAtAColdStartAndAMinuteOtherwise() {
        assertEquals(600_000L, LogcatWorker.lateHostWindowMs(Trigger.COLD_START));
        assertEquals(60_000L, LogcatWorker.lateHostWindowMs(Trigger.WAKE));
        assertEquals(60_000L, LogcatWorker.lateHostWindowMs(Trigger.MANUAL));
        assertEquals(60_000L, LogcatWorker.lateHostWindowMs(Trigger.PROCESS_START));
    }

    @Test
    void theSwitchToTheHostReadsFromTheStartOfTheCapture() {
        assertEquals(0L, LogcatWorker.upgradeSinceMs(true, 0L, 5_000L));         // boot capture: all of it
        assertEquals(5_000L, LogcatWorker.upgradeSinceMs(false, 0L, 5_000L));
        assertEquals(7_000L, LogcatWorker.upgradeSinceMs(false, 7_000L, 5_000L)); // "from now"
    }

    @Test
    void scopeLinesNameWhatIsRead() {
        assertEquals("===== scope: the launcher's own log (--pid) =====", LogcatWorker.scopeLine(false, false));
        assertTrue(LogcatWorker.scopeLine(true, true).contains("through the VD host"));
        assertTrue(LogcatWorker.scopeLine(true, false).contains("as system"));
    }
}
