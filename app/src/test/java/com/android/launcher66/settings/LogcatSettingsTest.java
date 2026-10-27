package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LogcatSettingsTest {

    @Test
    void aForcingBuildHasEverythingOnWhateverWasStored() {
        assertTrue(LogcatSettings.effective(true, false));
        assertTrue(LogcatSettings.effective(true, true));
    }

    @Test
    void otherwiseTheStoredChoiceStands() {
        assertFalse(LogcatSettings.effective(false, false));
        assertTrue(LogcatSettings.effective(false, true));
    }
}
