package com.syu.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class WeatherManagerRedactTest {

    @Test
    void theKeyIsHiddenAndTheCoordinatesRoundedToTwoPlaces() {
        String url = "https://api.openweathermap.org/data/2.5/weather?appid=0123456789abcdef&units=metric"
                + "&lat=52.40938271&lon=16.92512345";
        assertEquals("https://api.openweathermap.org/data/2.5/weather?appid=***&units=metric"
                + "&lat=52.41&lon=16.93", WeatherManager.redactUrl(url));
    }

    @Test
    void negativeAndShortValuesKeepTheirSign() {
        assertEquals("x?lat=-33.87&lon=-0.13", WeatherManager.redactUrl("x?lat=-33.8688&lon=-0.1278"));
        assertEquals("x?lat=52.50&lon=17.00", WeatherManager.redactUrl("x?lat=52.5&lon=17"));
    }

    @Test
    void theKeyIsHiddenWhereverItStands() {
        assertEquals("x?appid=***", WeatherManager.redactUrl("x?appid=SECRET"));
        assertEquals("x?units=metric&appid=***&lat=1.00", WeatherManager.redactUrl("x?units=metric&appid=SECRET&lat=1"));
        assertFalse(WeatherManager.redactUrl("a Network error: https://h/p?appid=SECRET - timeout").contains("SECRET"));
    }

    @Test
    void textWithoutAUrlStaysAsItIs() {
        assertEquals("timeout", WeatherManager.redactUrl("timeout"));
        assertEquals("", WeatherManager.redactUrl(""));
        assertNull(WeatherManager.redactUrl(null));
    }
}
