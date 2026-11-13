package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.android.launcher66.BackgroundChoice;

import org.junit.jupiter.api.Test;

class StatsBackgroundMigrationTest {

    @Test
    void nothingStoredIsNoBackgroundAsTheWindowShowedIt() {
        // the service's own defaults: the background on, but neither the picture nor the colour
        StatsBackgroundMigration.Result result = StatsBackgroundMigration.of(null, null, null, null, null);
        assertEquals(BackgroundChoice.NONE, result.choice);
        assertNull(result.color);
    }

    @Test
    void theBackgroundSwitchedOffIsNoBackground() {
        assertEquals(BackgroundChoice.NONE, StatsBackgroundMigration.of(false, true, false, null, null).choice);
        assertEquals(BackgroundChoice.NONE,
                StatsBackgroundMigration.of(false, false, true, "#FF112233", 100).choice);
    }

    @Test
    void theDefaultPictureIsThePicture() {
        assertEquals("bg_custom", StatsBackgroundMigration.of(true, true, false, null, null).choice);
        // the service looked at the picture first
        assertEquals("bg_custom", StatsBackgroundMigration.of(true, true, true, "#FF112233", 100).choice);
        assertEquals("bg_custom", StatsBackgroundMigration.of(null, true, null, null, null).choice);
    }

    @Test
    void theColourComesWithItsTransparency() {
        StatsBackgroundMigration.Result result = StatsBackgroundMigration.of(true, false, true, "#FF112233", 128);
        assertEquals(BackgroundChoice.CUSTOM, result.choice);
        assertEquals(0x80112233, (int) result.color);
    }

    @Test
    void aColourNeverChosenIsTheBlackTheWindowDrew() {
        StatsBackgroundMigration.Result result = StatsBackgroundMigration.of(true, false, true, null, null);
        assertEquals(BackgroundChoice.CUSTOM, result.choice);
        assertEquals(0xFF000000, (int) result.color);
    }

    @Test
    void aFullyTransparentColourStaysTheUsersColour() {
        StatsBackgroundMigration.Result result = StatsBackgroundMigration.of(true, false, true, "#FF00FF00", 0);
        assertEquals(BackgroundChoice.CUSTOM, result.choice);
        assertEquals(0x0000FF00, (int) result.color);
    }

    @Test
    void onWithNeitherKindChosenIsNoBackground() {
        assertEquals(BackgroundChoice.NONE, StatsBackgroundMigration.of(true, false, false, null, null).choice);
    }

    @Test
    void aColourThatIsNotTheChoiceIsKeptForTheColourTile() {
        StatsBackgroundMigration.Result result = StatsBackgroundMigration.of(true, true, false, "#FF445566", 200);
        assertEquals("bg_custom", result.choice);
        assertEquals(0xC8445566, (int) result.color);
    }

    @Test
    void theColourAsTheOldSettingsStoredItIsTakenAsItIs() {
        // white chosen, stored through the mask as #FF4285F4: that is what the window has shown
        assertEquals(0xFF4285F4, StatsBackgroundMigration.argb("#FF4285F4", 255));
    }

    @Test
    void bothWaysOfWritingAColourAreRead() {
        assertEquals(0xFF112233, StatsBackgroundMigration.parse("#112233"));
        assertEquals(0x80112233, StatsBackgroundMigration.parse("#80112233"));
        assertEquals(0xFF000000, StatsBackgroundMigration.parse("not a colour"));
        assertEquals(0xFF000000, StatsBackgroundMigration.parse(null));
    }
}
