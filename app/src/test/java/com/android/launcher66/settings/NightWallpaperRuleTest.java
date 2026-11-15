package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NightWallpaperRuleTest {

    @Test
    void withTheDefaultsOnTheBuiltInPictureIsSetWhateverWasSaved() {
        assertEquals(NightWallpaperRule.Source.DEFAULT, NightWallpaperRule.decide(true, false));
        assertEquals(NightWallpaperRule.Source.DEFAULT, NightWallpaperRule.decide(true, true));
    }

    @Test
    void aSavedPictureIsSetWhenTheDefaultsAreOff() {
        assertEquals(NightWallpaperRule.Source.FILE, NightWallpaperRule.decide(false, true));
    }

    @Test
    void withNothingSavedTheWallpaperIsLeftAlone() {
        // The phone that cannot read its wallpaper: nothing could be saved, and the user's wallpaper stays
        assertEquals(NightWallpaperRule.Source.KEEP, NightWallpaperRule.decide(false, false));
    }
}
