package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SettingsDialogSizeTest {

    @Test
    void inLandscapeTheThreeAreOneSize() {
        int[] background = SettingsDialogSize.pixels(SettingsDialogSize.Kind.BACKGROUND, 2000, 1200);
        assertArrayEquals(new int[] {1400, 1080}, background);
        assertArrayEquals(background, SettingsDialogSize.pixels(SettingsDialogSize.Kind.COLOR_PICKER, 2000, 1200));
        assertArrayEquals(background, SettingsDialogSize.pixels(SettingsDialogSize.Kind.APP_LIST, 2000, 1200));
    }

    @Test
    void inPortraitTheyAreAsWideAsTheBackgroundSelectorWithTheirOwnHeights() {
        assertArrayEquals(new int[] {864, 1872}, SettingsDialogSize.pixels(SettingsDialogSize.Kind.BACKGROUND, 1080, 2340));
        assertArrayEquals(new int[] {864, 1404}, SettingsDialogSize.pixels(SettingsDialogSize.Kind.COLOR_PICKER, 1080, 2340));
        assertArrayEquals(new int[] {864, 2191}, SettingsDialogSize.pixels(SettingsDialogSize.Kind.APP_LIST, 1080, 2340));
    }
}
