package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MainStallPlacesTest {

    private static StackTraceElement f(String cls, String method, int line) {
        return new StackTraceElement(cls, method, cls.substring(cls.lastIndexOf('.') + 1) + ".java", line);
    }

    @Test
    void thePlaceIsTheFirstFrameOfOurOwnCode() {
        StackTraceElement[] stack = {
                f("android.os.BinderProxy", "transact", 1),
                f("com.syu.util.WindowHostVdView", "createDisplay", 469),
                f("com.android.launcher66.Launcher", "onCreate", 10)};
        assertEquals("com.syu.util.WindowHostVdView.createDisplay(WindowHostVdView.java:469)",
                MainStallPlaces.placeOf(stack));
    }

    @Test
    void withoutOurFrameItIsTheTopFrame() {
        StackTraceElement[] stack = {
                f("android.os.BinderProxy", "transact", 1), f("android.os.Looper", "loop", 2)};
        assertEquals("android.os.BinderProxy.transact(BinderProxy.java:1)", MainStallPlaces.placeOf(stack));
    }

    @Test
    void equalPlacesCountOnceAndTheListStopsAtFive() {
        MainStallPlaces p = new MainStallPlaces();
        for (int i = 0; i < 9; i++) {
            p.add(new StackTraceElement[]{f("com.fyt.car.X" + i, "m", i)});
            p.add(new StackTraceElement[]{f("com.fyt.car.X" + i, "m", i)});
        }
        assertEquals(MainStallPlaces.MAX_PLACES, p.list().size());
        assertTrue(p.describe().startsWith("com.fyt.car.X0.m(X0.java:0); com.fyt.car.X1.m"));
        p.clear();
        assertEquals("", p.describe());
    }
}
