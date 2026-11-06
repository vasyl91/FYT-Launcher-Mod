package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CreatorBarToggleTest {

    @Test
    void firstScreenTogglesOnlyWithAutoHide() {
        assertEquals(false, CreatorBarToggle.canToggle(true, false, false));
        assertEquals(false, CreatorBarToggle.canToggle(true, false, true));
        assertEquals(true, CreatorBarToggle.canToggle(true, true, false));
        assertEquals(true, CreatorBarToggle.canToggle(true, true, true));
    }

    @Test
    void otherScreensToggleUnlessTheBarStaysOnEveryPageWithoutAutoHide() {
        assertEquals(true, CreatorBarToggle.canToggle(false, false, false));
        assertEquals(false, CreatorBarToggle.canToggle(false, false, true));
        assertEquals(true, CreatorBarToggle.canToggle(false, true, false));
        assertEquals(true, CreatorBarToggle.canToggle(false, true, true));
    }
}
