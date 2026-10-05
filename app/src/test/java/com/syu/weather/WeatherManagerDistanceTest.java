package com.syu.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WeatherManagerDistanceTest {

    @Test
    void samePointIsZero() {
        assertEquals(0f, WeatherManager.distanceMeters(52.4, 16.9, 52.4, 16.9), 0.001f);
    }

    @Test
    void northSouthMatchesTheEarthRadius() {
        // 0.045 deg of latitude = 5003.8 m on a 6371 km sphere.
        assertEquals(5003.8f, WeatherManager.distanceMeters(52.4, 16.9, 52.445, 16.9), 1f);
    }

    @Test
    void eastWestShrinksWithLatitude() {
        // 0.0735 deg of longitude at 52.4 deg N: 6371 km * cos(52.4) * 0.0735 * pi / 180 = 4986 m.
        assertEquals(4986f, WeatherManager.distanceMeters(52.4, 16.9, 52.4, 16.9735), 5f);
    }

    @Test
    void refreshDistanceIsReachedAtFiveKilometres() {
        assertTrue(WeatherManager.distanceMeters(52.4, 16.9, 52.446, 16.9) >= 5000f);
        assertTrue(WeatherManager.distanceMeters(52.4, 16.9, 52.444, 16.9) < 5000f);
    }

    @Test
    void unknownPositionIsInfinitelyFar() {
        assertEquals(Float.MAX_VALUE, WeatherManager.distanceMeters(Double.NaN, Double.NaN, 52.4, 16.9));
        assertEquals(Float.MAX_VALUE, WeatherManager.distanceMeters(52.4, 16.9, Double.NaN, 0));
    }
}
