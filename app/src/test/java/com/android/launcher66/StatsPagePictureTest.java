package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatsPagePictureTest {

    @Test
    void theAndroid10UnitsGetThePicture() {
        assertTrue(StatsPagePicture.applies(29, true, true));
        assertTrue(StatsPagePicture.applies(26, true, true));
    }

    @Test
    void newerAndroidVersionsKeepTheirWindow() {
        // The phones: the window moves in step with the pages there
        assertFalse(StatsPagePicture.applies(30, true, true));
        assertFalse(StatsPagePicture.applies(34, true, true));
        assertFalse(StatsPagePicture.applies(36, true, true));
    }

    @Test
    void notInTheOverviewOrWhileDraggingAndNotWithoutTheWindow() {
        assertFalse(StatsPagePicture.applies(29, false, true));
        assertFalse(StatsPagePicture.applies(29, true, false));
    }

    @Test
    void thePictureLiesWhereTheWindowIsInItsPage() {
        // The 7862: the page begins 48 px below the top of the screen (the status bar)
        assertArrayEquals(new int[] {160, 52, 595, 112},
                StatsPagePicture.rectOnPage(160, 100, 48, 435, 60));
    }
}
