package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WidgetRecoveryTest {

    @Test
    void aSystemLauncherSendsTheUpdateItself() {
        assertEquals(WidgetRecovery.Way.SELF, WidgetRecovery.way(0, true, false));
    }

    @Test
    void withRootTheHostSendsIt() {
        assertEquals(WidgetRecovery.Way.HOST, WidgetRecovery.way(0, false, true));
    }

    @Test
    void shizukuThroughAdbHasOnlyTheOptions() {
        // The A55: shell may not send a protected broadcast
        assertEquals(WidgetRecovery.Way.OPTIONS_ONLY, WidgetRecovery.way(1, false, false));
    }

    @Test
    void aWidgetAsksTwiceAtMost() {
        assertEquals(WidgetRecovery.Way.NONE, WidgetRecovery.way(WidgetRecovery.ATTEMPTS, true, true));
    }
}
