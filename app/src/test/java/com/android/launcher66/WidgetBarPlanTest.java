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
        assertFalse(WidgetBarPlan.widensMusic(false, false));
        assertTrue(WidgetBarPlan.widensMusic(true, false));
        assertTrue(WidgetBarPlan.widensMusic(false, true));
        assertTrue(WidgetBarPlan.widensMusic(true, true));
        // the cover is no widget of the bar: it does not widen the music widget
        assertFalse(WidgetBarPlan.widensMusic(false, false));
        assertFalse(WidgetBarPlan.wide(false, false, false));
        assertTrue(WidgetBarPlan.wide(true, false, false));
        assertTrue(WidgetBarPlan.wide(false, true, false));
        assertTrue(WidgetBarPlan.wide(false, false, true));
        assertTrue(WidgetBarPlan.wide(true, true, true));
    }

    @Test
    void theLargeWeatherSharesDependOnlyOnTheSharesOfTheLayoutFile() {
        float[] once = WidgetBarPlan.largeWeatherShares(0.2f, 0.4f);
        // The rows grow by 15%, the icon gives way twice that growth
        assertEquals(0.23f, once[0], 0.0001f);
        assertEquals(0.34f, once[1], 0.0001f);
        // Ten calls with the same input give the same answer: nothing grows at a refresh
        float[] again = once;
        for (int i = 0; i < 10; i++) {
            again = WidgetBarPlan.largeWeatherShares(0.2f, 0.4f);
        }
        assertEquals(once[0], again[0], 0f);
        assertEquals(once[1], again[1], 0f);
    }

    @Test
    void theIconKeepsMostOfItsHeight() {
        float[] shares = WidgetBarPlan.largeWeatherShares(0.5f, 0.3f);
        assertEquals(0.3f * WidgetBarPlan.WEATHER_ICON_MIN_SHARE, shares[1], 0.0001f);
    }

    @Test
    void theBaseShareIsTheWidthWithNothingHidden() {
        assertEquals(0.28f, WidgetBarPlan.baseShare(false), 0.0001f);
        assertEquals(0.295f, WidgetBarPlan.baseShare(true), 0.0001f);
        assertEquals(WidgetBarPlan.musicShare(false, false, false), WidgetBarPlan.baseShare(false), 0f);
        assertEquals(WidgetBarPlan.musicShare(true, false, false), WidgetBarPlan.baseShare(true), 0f);
    }

    @Test
    void theButtonsGoBesideTheTextOnlyWhenSomethingIsHiddenAndTheSwitchIsOn() {
        assertTrue(WidgetBarPlan.buttonsBeside(true, false, false, true));
        assertTrue(WidgetBarPlan.buttonsBeside(false, true, false, true));
        assertTrue(WidgetBarPlan.buttonsBeside(true, true, false, true));
        assertFalse(WidgetBarPlan.buttonsBeside(true, true, false, false));
        assertFalse(WidgetBarPlan.buttonsBeside(false, true, false, false));
        assertFalse(WidgetBarPlan.buttonsBeside(false, false, false, true));
        assertFalse(WidgetBarPlan.buttonsBeside(false, false, false, false));
    }

    @Test
    void theBlockOfButtonsBesideTheTextTakesItsShareOfTheRoom() {
        assertEquals(0.35f, WidgetBarPlan.besideButtonsShare(false, false), 0f);
        assertEquals(0.35f, WidgetBarPlan.besideButtonsShare(true, false), 0f);
        assertEquals(0.40f, WidgetBarPlan.besideButtonsShare(false, true), 0f);
        assertEquals(0.50f, WidgetBarPlan.besideButtonsShare(true, true), 0f);
    }

    @Test
    void aHiddenCoverAloneLetsTheButtonsGoBesideTheText() {
        assertTrue(WidgetBarPlan.buttonsBeside(false, false, true, true));
        assertFalse(WidgetBarPlan.buttonsBeside(false, false, true, false));
    }
}
