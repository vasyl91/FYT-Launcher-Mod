package com.android.launcher66;

import static com.android.launcher66.BarOrder.Element.APPS;
import static com.android.launcher66.BarOrder.Element.DATE;
import static com.android.launcher66.BarOrder.Element.DRAWER;
import static com.android.launcher66.BarOrder.Element.MUSIC;
import static com.android.launcher66.BarOrder.Element.WEATHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BarOrderTest {

    @Test
    void nothingStoredIsTheOrderTheBarAlwaysHad() {
        assertEquals(Arrays.asList(DRAWER, APPS, MUSIC, DATE, WEATHER), BarOrder.parse(null));
        assertEquals(BarOrder.DEFAULT, BarOrder.parse(""));
    }

    @Test
    void aStoredOrderIsReadBackAndKeepsEveryElementOnce() {
        List<BarOrder.Element> order = Arrays.asList(WEATHER, MUSIC, APPS, DRAWER, DATE);
        assertEquals(order, BarOrder.parse(BarOrder.format(order)));
        // Unknown names are dropped, a repeated one counts once, the missing ones follow in the default order
        assertEquals(Arrays.asList(MUSIC, DRAWER, APPS, DATE, WEATHER), BarOrder.parse("music, clock,drawer,music"));
    }

    @Test
    void theBarShowsWhatItsSettingsAndOrientationLeave() {
        List<BarOrder.Element> order = Arrays.asList(WEATHER, DATE, MUSIC, APPS, DRAWER);
        assertEquals(Arrays.asList(WEATHER, DATE, MUSIC, APPS, DRAWER),
                BarOrder.shown(order, true, false, false, false));
        assertEquals(Arrays.asList(WEATHER, MUSIC, APPS, DRAWER), BarOrder.shown(order, true, true, false, false),
                "portrait has no date");
        assertEquals(Arrays.asList(DATE, MUSIC, APPS, DRAWER), BarOrder.shown(order, true, false, false, true));
        assertEquals(Arrays.asList(WEATHER, MUSIC, APPS, DRAWER), BarOrder.shown(order, true, false, true, false));
        assertEquals(Arrays.asList(APPS, DRAWER), BarOrder.shown(order, false, false, false, false),
                "without the widget bar");
    }

    @Test
    void aHiddenElementKeepsItsPlaceWhileTheOthersAreMoved() {
        // Landscape with the date hidden: the dialog shows four, and the date keeps the fourth place of the five
        List<BarOrder.Element> full = BarOrder.DEFAULT;
        List<BarOrder.Element> reordered = Arrays.asList(WEATHER, MUSIC, APPS, DRAWER);
        assertEquals(Arrays.asList(WEATHER, MUSIC, APPS, DATE, DRAWER), BarOrder.merge(full, reordered));
        // Nothing moved: nothing changes
        assertEquals(full, BarOrder.merge(full, BarOrder.shown(full, true, false, true, false)));
    }

    @Test
    void theFirstLiesAtTheLeftEdgeTheOthersAreChainedToTheRightEdge() {
        List<BarOrder.Anchor> anchors = BarOrder.anchors(BarOrder.shown(BarOrder.DEFAULT, true, false, false, false));
        assertEquals(5, anchors.size());
        BarOrder.Anchor drawer = anchors.get(0);
        assertEquals(DRAWER, drawer.element);
        assertNull(drawer.start, "the left edge");
        assertFalse(drawer.endTied, "as the window has it: only its left side");
        BarOrder.Anchor apps = anchors.get(1);
        assertEquals(DRAWER, apps.start);
        assertTrue(apps.endTied);
        assertEquals(MUSIC, apps.end);
        BarOrder.Anchor weather = anchors.get(4);
        assertEquals(DATE, weather.start);
        assertTrue(weather.endTied);
        assertNull(weather.end, "the right edge");
    }

    @Test
    void theDrawerOnTheRightIsTiedToTheRightEdge() {
        List<BarOrder.Anchor> anchors = BarOrder.anchors(Arrays.asList(APPS, DRAWER));
        assertNull(anchors.get(0).start);
        assertFalse(anchors.get(0).endTied);
        assertEquals(APPS, anchors.get(1).start);
        assertTrue(anchors.get(1).endTied);
        assertNull(anchors.get(1).end);
    }
}
