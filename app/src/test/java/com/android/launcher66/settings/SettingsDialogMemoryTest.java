package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SettingsDialogMemoryTest {

    @AfterEach
    void forget() {
        SettingsDialogMemory.forget();
    }

    @Test
    void theDialogOpenAtATurnIsGivenToTheNewScreenOnceWithItsTexts() {
        List<String> typed = new ArrayList<>(Arrays.asList("12", ""));
        SettingsDialogMemory.keep(2, "layout_margin", null, typed);
        typed.set(0, "changed later");

        SettingsDialogMemory.Kept kept = SettingsDialogMemory.takeFor(2);
        assertEquals("layout_margin", kept.dialog);
        assertNull(kept.arg);
        assertEquals(Arrays.asList("12", ""), kept.fields, "the texts as they were when kept");
        assertNull(SettingsDialogMemory.takeFor(2), "once");
    }

    @Test
    void whatItWasOpenedForComesWithIt() {
        SettingsDialogMemory.keep(1, "wallpaper_pick_offer", "Night", null);
        SettingsDialogMemory.Kept kept = SettingsDialogMemory.takeFor(1);
        assertEquals("Night", kept.arg);
        assertEquals(0, kept.fields.size());
    }

    @Test
    void anotherScreenTakesNothingAndTheSettingsOpenedAfreshForgetIt() {
        SettingsDialogMemory.keep(1, "spotify_client_id", null, Arrays.asList("abc"));
        assertNull(SettingsDialogMemory.takeFor(2));
        assertNull(SettingsDialogMemory.takeFor(1), "taken by the screen that was created");

        SettingsDialogMemory.keep(2, "start_page", null, Arrays.asList("3"));
        SettingsDialogMemory.forget();
        assertNull(SettingsDialogMemory.takeFor(2));
    }

    @Test
    void theLastDialogKeptIsTheOneThatComesBack() {
        SettingsDialogMemory.keep(2, "start_page", null, Arrays.asList("3"));
        SettingsDialogMemory.keep(2, "skip_codes", null, Arrays.asList("1,2"));
        assertEquals("skip_codes", SettingsDialogMemory.takeFor(2).dialog);
        SettingsDialogMemory.keep(2, null, null, null);
        assertNull(SettingsDialogMemory.takeFor(2), "no dialog, nothing kept");
    }
}
