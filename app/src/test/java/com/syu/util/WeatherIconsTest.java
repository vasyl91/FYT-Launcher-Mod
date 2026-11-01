package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WeatherIconsTest {

    @Test
    void aNightIconThatIsTheDayOneUsesTheDayFile() {
        assertEquals("weather03d", WeatherIcons.name("03n"));
        assertEquals("weather04d", WeatherIcons.name("04n"));
        assertEquals("weather13d", WeatherIcons.name("13n"));
        assertEquals("weather50d", WeatherIcons.name("50n"));
    }

    @Test
    void theOtherCodesKeepTheirOwnFile() {
        assertEquals("weather01d", WeatherIcons.name("01d"));
        assertEquals("weather01n", WeatherIcons.name("01n"));
        assertEquals("weather02n", WeatherIcons.name("02n"));
        assertEquals("weather09n", WeatherIcons.name("09n"));
        assertEquals("weather10n", WeatherIcons.name("10n"));
        assertEquals("weather11n", WeatherIcons.name("11n"));
    }

    @Test
    void theDayCodesOfTheMergedPairsAreUnchanged() {
        assertEquals("weather03d", WeatherIcons.name("03d"));
        assertEquals("weather50d", WeatherIcons.name("50d"));
    }
}
