package com.android.launcher66.settings;

import static com.android.launcher66.settings.StatsOverlayAlpha.LimitAction.FORGET;
import static com.android.launcher66.settings.StatsOverlayAlpha.LimitAction.NOTHING;
import static com.android.launcher66.settings.StatsOverlayAlpha.LimitAction.RAISE;
import static com.android.launcher66.settings.StatsOverlayAlpha.LimitAction.RESTORE;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.HOST;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.NOT_NEEDED;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.SU;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.TRUSTED;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.UNAVAILABLE;
import static com.android.launcher66.settings.StatsOverlayAlpha.Route.WRITE_DIRECT;
import static com.android.launcher66.settings.StatsOverlayAlpha.limitAction;
import static com.android.launcher66.settings.StatsOverlayAlpha.parseLimit;
import static com.android.launcher66.settings.StatsOverlayAlpha.route;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatsOverlayAlphaTest {

    @Test
    void routes() {
        assertEquals(TRUSTED, route(34, true, false, false, false, false, 0.8f));
        assertEquals(TRUSTED, route(34, false, true, false, false, false, 0.8f));
        assertEquals(WRITE_DIRECT, route(34, false, false, true, false, false, 0.8f));
        assertEquals(HOST, route(34, false, false, false, true, false, 0.8f));
        assertEquals(SU, route(34, false, false, false, false, true, 0.8f));
        assertEquals(UNAVAILABLE, route(34, false, false, false, false, false, 0.8f));
    }

    @Test
    void routePriorities() {
        assertEquals(TRUSTED, route(34, true, false, true, true, true, 0.8f));
        assertEquals(WRITE_DIRECT, route(34, false, false, true, true, true, 0.8f));
        assertEquals(HOST, route(34, false, false, false, true, true, 0.8f));
    }

    @Test
    void notNeeded() {
        assertEquals(NOT_NEEDED, route(30, true, true, true, true, true, 0.8f));
        assertEquals(NOT_NEEDED, route(34, true, true, true, true, true, 1f));
    }

    @Test
    void raiseWhileShown() {
        assertEquals(RAISE, limitAction(true, false, null));
        assertEquals(RAISE, limitAction(true, false, "0.8"));
        assertEquals(RAISE, limitAction(true, true, "0.5"));
        assertEquals(NOTHING, limitAction(true, false, "1"));
        assertEquals(NOTHING, limitAction(true, true, "1.0"));
    }

    @Test
    void restoreWhenHidden() {
        assertEquals(RESTORE, limitAction(false, true, "1"));
        assertEquals(FORGET, limitAction(false, true, "0.7"));
        for (String v : new String[]{null, "0.8", "1", "1.0", "abc"}) {
            assertEquals(NOTHING, limitAction(false, false, v));
        }
    }

    @Test
    void parse() {
        assertEquals(0.8f, parseLimit(null), 0f);
        assertEquals(0.8f, parseLimit(""), 0f);
        assertEquals(0.8f, parseLimit("abc"), 0f);
        assertEquals(1f, parseLimit("1"), 0f);
        assertEquals(0.75f, parseLimit("0.75"), 0f);
    }

    @Test
    void backWithinThreeSecondsRestoresNothing() {
        HideDebounce d = new HideDebounce();
        d.onHidden(0);
        d.onShown(1000);
        assertFalse(d.due(3000));
        assertFalse(d.due(10000));
    }

    @Test
    void restoresOnceAfterThreeSeconds() {
        HideDebounce d = new HideDebounce();
        d.onHidden(0);
        assertFalse(d.due(2999));
        assertTrue(d.due(3000));
        assertFalse(d.due(3001));
    }

    @Test
    void threeSecondsAfterTheLastHide() {
        HideDebounce d = new HideDebounce();
        d.onShown(0);
        d.onHidden(500);
        d.onShown(1000);
        d.onHidden(2000);
        assertFalse(d.due(4999));
        assertTrue(d.due(5000));
    }

    @Test
    void backJustAfterTheRestore() {
        HideDebounce d = new HideDebounce();
        d.onHidden(0);
        assertTrue(d.due(3000));
        d.onShown(3100);
        assertFalse(d.due(10000));
        assertEquals(RAISE, limitAction(true, false, "0.8"));
    }

    @Test
    void needsRaiseOnlyForAShownUntrustedWindowBelowTheFullLimit() {
        assertTrue(StatsOverlayAlpha.needsRaise(true, false, 0.8f));
        assertFalse(StatsOverlayAlpha.needsRaise(true, false, 1f));
        assertFalse(StatsOverlayAlpha.needsRaise(true, true, 0.8f));
        assertFalse(StatsOverlayAlpha.needsRaise(false, false, 0.8f));
    }
}
