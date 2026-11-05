package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WeatherNeedTest {

    @Test
    void theBarShowsTheWeatherInTheUserLayoutWithTheWidgetBarAndWithoutHidingIt() {
        assertTrue(WeatherNeed.needed(true, true, false, false));
    }

    @Test
    void hidingTheWeatherOrTheBarOrTheUserLayoutMeansNoWeather() {
        assertFalse(WeatherNeed.needed(true, true, true, false));
        assertFalse(WeatherNeed.needed(true, false, false, false));
        assertFalse(WeatherNeed.needed(false, true, false, false));
        assertFalse(WeatherNeed.needed(false, false, false, false));
    }

    @Test
    void theHotseatShowsTheWeatherWhateverTheBarDoes() {
        assertTrue(WeatherNeed.needed(false, false, false, true));
        assertTrue(WeatherNeed.needed(true, true, true, true));
        assertTrue(WeatherNeed.needed(true, false, true, true));
    }
}
