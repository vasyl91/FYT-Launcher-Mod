package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class BackgroundChoiceTest {

    @Test
    void nothingStoredIsTheDefaultPicture() {
        BackgroundChoice choice = BackgroundChoice.of(null, "app_list_bg", false, 0);
        assertEquals(BackgroundChoice.Kind.PICTURE, choice.kind);
        assertEquals("app_list_bg", choice.picture);
    }

    @Test
    void aStoredPictureIsThatPicture() {
        BackgroundChoice choice = BackgroundChoice.of("app_list_bg_7", "app_list_bg", true, 0x80112233);
        assertEquals(BackgroundChoice.Kind.PICTURE, choice.kind);
        assertEquals("app_list_bg_7", choice.picture);
    }

    @Test
    void theOwnColourComesWithItsTransparency() {
        BackgroundChoice choice = BackgroundChoice.of("custom", "app_list_bg", true, 0x80112233);
        assertEquals(BackgroundChoice.Kind.CUSTOM, choice.kind);
        assertEquals(0x80112233, choice.color);
    }

    @Test
    void aFullyTransparentColourIsStillTheOwnColour() {
        BackgroundChoice choice = BackgroundChoice.of("custom", "bg_custom", true, 0x00000000);
        assertEquals(BackgroundChoice.Kind.CUSTOM, choice.kind);
    }

    @Test
    void theOwnColourWithoutAStoredColourIsTheDefaultPicture() {
        BackgroundChoice choice = BackgroundChoice.of("custom", "hotseat_bg", false, 0);
        assertEquals(BackgroundChoice.Kind.PICTURE, choice.kind);
        assertEquals("hotseat_bg", choice.picture);
    }

    @Test
    void noBackgroundIsNone() {
        assertEquals(BackgroundChoice.Kind.NONE, BackgroundChoice.of("none", "bg_custom", true, 1).kind);
    }

    @Test
    void everyComponentHasAColourKeyOfItsOwn() {
        assertEquals("widgets_custom_background_color", BackgroundChoice.colorKey("widgets_selected_background"));
        assertEquals("bar_custom_background_color", BackgroundChoice.colorKey("bar_selected_background"));
        assertEquals("vertical_bar_custom_background_color",
                BackgroundChoice.colorKey("vertical_bar_selected_background"));
        assertEquals("stats_custom_background_color", BackgroundChoice.colorKey("stats_selected_background"));
        assertNotEquals(BackgroundChoice.colorKey("bar_selected_background"),
                BackgroundChoice.colorKey("vertical_bar_selected_background"));
    }
}
