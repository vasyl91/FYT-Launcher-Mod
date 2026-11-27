package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SettingsTextScaleTest {

    @Test
    void theValueIsHeldToSeventyToOneHundredFiftyOnStepsOfTen() {
        assertEquals(70, SettingsTextScale.percent(10));
        assertEquals(150, SettingsTextScale.percent(400));
        assertEquals(100, SettingsTextScale.percent(100));
        assertEquals(110, SettingsTextScale.percent(106));
        assertEquals(100, SettingsTextScale.percent(104));
        assertEquals(100, SettingsTextScale.DEFAULT);
    }

    @Test
    void theFactorAndTheSlidersPlaces() {
        assertEquals(1.5f, SettingsTextScale.factor(150), 0f);
        assertEquals(0.7f, SettingsTextScale.factor(70), 0.0001f);
        assertEquals(8, SettingsTextScale.maxProgress());
        assertEquals(3, SettingsTextScale.progress(100));
        assertEquals(100, SettingsTextScale.fromProgress(3));
        assertEquals(150, SettingsTextScale.fromProgress(8));
        assertEquals(70, SettingsTextScale.fromProgress(0));
    }
}
