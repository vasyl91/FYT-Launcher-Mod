package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CompatReportPolicyTest {

    private static Throwable failure(String cls, String method, int line, Throwable t) {
        t.setStackTrace(new StackTraceElement[]{
                new StackTraceElement("java.util.ArrayList", "get", "ArrayList.java", 1),
                new StackTraceElement(cls, method, "X.java", line)});
        return t;
    }

    @Test
    void theKeyHoldsTheAreaTheClassAndTheFirstFrameOfOurCode() {
        Throwable t = failure("com.syu.module.UiNotifyEvent", "run", 90, new IllegalStateException());
        String key = CompatReportPolicy.key("canbus.notify 5", t);
        assertTrue(key.startsWith("canbus.notify 5|java.lang.IllegalStateException|"));
        assertTrue(key.endsWith("com.syu.module.UiNotifyEvent.run:90"));
    }

    @Test
    void anotherAreaOrFrameIsAnotherKey() {
        Throwable a = failure("com.syu.A", "m", 1, new RuntimeException());
        Throwable b = failure("com.syu.B", "m", 1, new RuntimeException());
        assertNotEquals(CompatReportPolicy.key("x", a), CompatReportPolicy.key("x", b));
        assertNotEquals(CompatReportPolicy.key("x", a), CompatReportPolicy.key("y", a));
    }

    @Test
    void theFirstFailureOfAKeyIsReportedTheNextOnesCounted() {
        CompatReportPolicy p = new CompatReportPolicy();
        assertEquals(CompatReportPolicy.Action.REPORT, p.record("a"));
        assertEquals(CompatReportPolicy.Action.COUNT, p.record("a"));
        assertEquals(CompatReportPolicy.Action.COUNT, p.record("a"));
        assertEquals(3, p.count("a"));
        assertEquals(CompatReportPolicy.Action.REPORT, p.record("b"));
    }

    @Test
    void aProcessWritesAtMostTenReportsThenLogsEveryFiftiethFailure() {
        CompatReportPolicy p = new CompatReportPolicy();
        for (int i = 0; i < CompatReportPolicy.MAX_REPORTS; i++) {
            assertEquals(CompatReportPolicy.Action.REPORT, p.record("k" + i));
        }
        assertEquals(CompatReportPolicy.Action.COUNT, p.record("new"));
        assertEquals(10, p.reports());
        CompatReportPolicy.Action last = null;
        int logged = 0;
        for (int i = 2; i <= 100; i++) {
            last = p.record("new");
            if (last == CompatReportPolicy.Action.LOG_COUNT) logged++;
        }
        assertEquals(2, logged);
        assertEquals(10, p.reports());
    }

    @Test
    void aKeyIsDisabledAfterFiveFailures() {
        CompatReportPolicy p = new CompatReportPolicy();
        for (int i = 0; i < CompatReportPolicy.DISABLE_AFTER - 1; i++) {
            p.record("k");
            assertFalse(p.isDisabled("k"));
        }
        p.record("k");
        assertTrue(p.isDisabled("k"));
        assertFalse(p.isDisabled("other"));
    }

    @Test
    void anAreaIsDisabledWhenOneOfItsKeysIs() {
        CompatReportPolicy p = new CompatReportPolicy();
        for (int i = 0; i < CompatReportPolicy.DISABLE_AFTER; i++) {
            p.record("canbus.notify 5|java.lang.RuntimeException|x");
        }
        assertTrue(p.isAreaDisabled("canbus.notify 5"));
        assertFalse(p.isAreaDisabled("canbus.notify 50"));
        assertFalse(p.isAreaDisabled("canbus"));
    }
}
