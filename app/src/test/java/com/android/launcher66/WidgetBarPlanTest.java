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

    private static float total(WidgetBarPlan.Shares s) {
        return s.apps + s.music + s.date + s.weather;
    }

    @Test
    void aFittedListGivesItsRoomTenPercentToTheDateAndTheWeatherAndTheRestToTheMusic() {
        // Landscape, 2 of 8 icons: the list keeps a quarter of its usual share
        float apps = WidgetBarPlan.appsShare(false, true, 2, 8);
        assertEquals(0.4395f / 4f, apps, 0.0001f);
        WidgetBarPlan.Shares s = WidgetBarPlan.shares(false, false, false, apps);
        float freed = 0.4395f - apps;
        assertTrue(s.appsChanged);
        assertEquals(0.05f + 0.1f * freed, s.date, 0.0001f);
        assertEquals(0.12f + 0.1f * freed, s.weather, 0.0001f);
        assertEquals(0.28f + 0.8f * freed, s.music, 0.0001f);
        assertEquals(0.4395f + 0.28f + 0.05f + 0.12f, total(s), 0.0001f, "the bar's width does not change");
    }

    @Test
    void aWidgetThatIsNotShownGetsNothingAndItsTenPercentGoesToTheMusic() {
        float apps = WidgetBarPlan.appsShare(false, true, 1, 5);
        float freed = 0.4395f - apps;
        // The date hidden: its own share and its 10% to the music
        WidgetBarPlan.Shares noDate = WidgetBarPlan.shares(false, true, false, apps);
        assertEquals(0f, noDate.date, 0.0001f);
        assertEquals(0.12f + 0.1f * freed, noDate.weather, 0.0001f);
        assertEquals(0.28f + 0.05f + 0.9f * freed, noDate.music, 0.0001f);
        // Portrait has no date: the weather 10%, the music 90%
        float portraitApps = WidgetBarPlan.appsShare(true, true, 2, 4);
        float portraitFreed = 0.4385f - portraitApps;
        WidgetBarPlan.Shares portrait = WidgetBarPlan.shares(true, false, false, portraitApps);
        assertEquals(0f, portrait.date, 0.0001f);
        assertEquals(0.15f + 0.1f * portraitFreed, portrait.weather, 0.0001f);
        assertEquals(0.295f + 0.9f * portraitFreed, portrait.music, 0.0001f);
        assertEquals(0.4385f + 0.295f + 0.15f, total(portrait), 0.0001f);
        // Both hidden: all of it to the music
        WidgetBarPlan.Shares both = WidgetBarPlan.shares(false, true, true, apps);
        assertEquals(0.28f + 0.05f + 0.12f + freed, both.music, 0.0001f);
    }

    @Test
    void theListKeepsItsWidthWhenItShowsAllItHasRoomForOrIsNotFitted() {
        assertEquals(0.4395f, WidgetBarPlan.appsShare(false, true, 8, 8), 0.0001f);
        assertEquals(0.4395f, WidgetBarPlan.appsShare(false, false, 2, 8), 0.0001f, "the switch off");
        assertEquals(0.4385f, WidgetBarPlan.appsShare(true, true, 0, 4), 0.0001f, "nothing counted yet");
        WidgetBarPlan.Shares usual = WidgetBarPlan.shares(false, false, false, 0.4395f);
        assertFalse(usual.appsChanged);
        assertEquals(0.28f, usual.music, 0.0001f, "as before: nothing changes");
        assertEquals(0.05f, usual.date, 0.0001f);
        assertEquals(0.12f, usual.weather, 0.0001f);
        // A hidden weather widens the music as it always did
        assertEquals(WidgetBarPlan.musicShare(false, false, true),
                WidgetBarPlan.shares(false, false, true, 0.4395f).music, 0.0001f);
    }

    @Test
    void anElementWhoseHeightComesFromItsWidthKeepsItsHeight() {
        float ratio = WidgetBarPlan.keptRatio(0.295f, 0.4385f, 0.4385f / 2f);
        assertEquals(0.295f * 2f, ratio, 0.0001f);
        // height = width x ratio, the same as at the usual width
        assertEquals(1080 * 0.4385f * 0.295f, 1080 * (0.4385f / 2f) * ratio, 0.01f);
        assertEquals(0.95f, WidgetBarPlan.keptRatio(0.95f, 0.15f, 0f), 0.0001f, "no width: the ratio as it is");
    }
}
