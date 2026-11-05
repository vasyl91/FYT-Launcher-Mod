package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WidgetBarPlanTest {

    @Test
    void theMusicWidgetTakesTheRoomOfTheHiddenWidgetsInLandscape() {
        assertEquals(0.28f, WidgetBarPlan.musicShare(false, false, false), 0.0001f);
        assertEquals(0.33f, WidgetBarPlan.musicShare(false, true, false), 0.0001f);
        assertEquals(0.40f, WidgetBarPlan.musicShare(false, false, true), 0.0001f);
        assertEquals(0.45f, WidgetBarPlan.musicShare(false, true, true), 0.0001f);
    }

    @Test
    void theMusicWidgetTakesTheRoomOfTheWeatherInPortrait() {
        assertEquals(0.295f, WidgetBarPlan.musicShare(true, false, false), 0.0001f);
        assertEquals(0.445f, WidgetBarPlan.musicShare(true, false, true), 0.0001f);
    }

    @Test
    void thePortraitBarHasNoDateToHide() {
        assertFalse(WidgetBarPlan.dateHidden(true, true));
        assertTrue(WidgetBarPlan.dateHidden(true, false));
        assertFalse(WidgetBarPlan.dateHidden(false, false));
    }

    @Test
    void theWideLayoutIsUsedWhenAnyWidgetIsHidden() {
        assertFalse(WidgetBarPlan.wide(false, false));
        assertTrue(WidgetBarPlan.wide(true, false));
        assertTrue(WidgetBarPlan.wide(false, true));
        assertTrue(WidgetBarPlan.wide(true, true));
    }
}
