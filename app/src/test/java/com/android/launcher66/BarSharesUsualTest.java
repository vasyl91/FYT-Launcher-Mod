package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The usual shares of BarShares are those the rest of the bar's code counts with. */
class BarSharesUsualTest {

    @Test
    void theUsualSharesAreTheOnesOfBarCapacityAndWidgetBarPlan() {
        assertEquals(BarCapacity.RECYCLER_W_WIDGET_LANDSCAPE, BarShares.APPS_LAND);
        assertEquals(BarCapacity.RECYCLER_W_WIDGET_PORTRAIT, BarShares.APPS_PORT);
        assertEquals(WidgetBarPlan.MUSIC_LAND, BarShares.MUSIC_LAND);
        assertEquals(WidgetBarPlan.MUSIC_PORT, BarShares.MUSIC_PORT);
        assertEquals(WidgetBarPlan.DATE_LAND, BarShares.DATE_LAND);
        assertEquals(WidgetBarPlan.WEATHER_LAND, BarShares.WEATHER_LAND);
        assertEquals(WidgetBarPlan.WEATHER_PORT, BarShares.WEATHER_PORT);
    }
}
