package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeadlightNightModeTest {

    private final SessionPrefs prefs = SessionPrefs.get();   // any SharedPreferences will do

    @BeforeEach
    void setUp() throws Exception {
        prefs.edit().clear().putBoolean(Keys.NIGHT_MODE, true).putBoolean(Keys.NIGHT_MODE_LIGHTS, true).apply();
        setLights(-1);
    }

    @AfterEach
    void tearDown() throws Exception {
        prefs.edit().clear().apply();
        setLights(-1);
    }

    @Test
    void noReportFromTheMcuMeansTheSunDecides() {
        assertNull(HeadlightNightMode.dayByLights(prefs));
    }

    @Test
    void lightsOnIsNightAndOffIsDay() throws Exception {
        setLights(1);
        assertEquals(Boolean.FALSE, HeadlightNightMode.dayByLights(prefs));
        setLights(0);
        assertEquals(Boolean.TRUE, HeadlightNightMode.dayByLights(prefs));
    }

    @Test
    void switchOffOrNightModeOffMeansTheSunDecides() throws Exception {
        setLights(1);
        prefs.edit().putBoolean(Keys.NIGHT_MODE_LIGHTS, false).apply();
        assertNull(HeadlightNightMode.dayByLights(prefs));
        prefs.edit().putBoolean(Keys.NIGHT_MODE_LIGHTS, true).putBoolean(Keys.NIGHT_MODE, false).apply();
        assertNull(HeadlightNightMode.dayByLights(prefs));
    }

    private static void setLights(int value) throws Exception {
        Field f = HeadlightNightMode.class.getDeclaredField("sLightsOn");
        f.setAccessible(true);
        f.setInt(null, value);
    }
}
