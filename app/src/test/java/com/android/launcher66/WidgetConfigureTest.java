package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WidgetConfigureTest {

    @Test
    void theOptionFollowsTheVersion() {
        assertEquals(WidgetConfigure.NO_MODE, WidgetConfigure.backgroundStartMode(29));   // the 7862
        assertEquals(WidgetConfigure.NO_MODE, WidgetConfigure.backgroundStartMode(33));
        assertEquals(WidgetConfigure.MODE_ALLOWED, WidgetConfigure.backgroundStartMode(34));
        assertEquals(WidgetConfigure.MODE_ALLOWED, WidgetConfigure.backgroundStartMode(35));
        assertEquals(WidgetConfigure.MODE_ALLOW_IF_VISIBLE, WidgetConfigure.backgroundStartMode(36)); // the A55
    }

    @Test
    void theModesAreThePlatformsValues() {
        // ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED and ..._ALLOW_IF_VISIBLE
        assertEquals(1, WidgetConfigure.MODE_ALLOWED);
        assertEquals(4, WidgetConfigure.MODE_ALLOW_IF_VISIBLE);
    }

    @Test
    void aWidgetThatCannotBeConfiguredIsAddedOnlyIfItsConfigurationIsOptional() {
        assertEquals(WidgetConfigure.Failure.ADD_WITHOUT_IT, WidgetConfigure.onFailure(true));
        assertEquals(WidgetConfigure.Failure.CANCEL, WidgetConfigure.onFailure(false));
    }
}
