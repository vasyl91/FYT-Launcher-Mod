package com.android.launcher66.settings;

import static com.android.launcher66.settings.LocationChoice.Source.NONE;
import static com.android.launcher66.settings.LocationChoice.Source.PLATFORM;
import static com.android.launcher66.settings.LocationChoice.Source.PLAY_SERVICES;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationChoiceTest {

    @Test
    void theNewestFixIsChosen() {
        assertEquals(1, LocationChoice.newest(new long[]{100L, 300L, 200L}));
        assertEquals(0, LocationChoice.newest(new long[]{500L}));
    }

    @Test
    void withoutFixesThereIsNoNewest() {
        assertEquals(-1, LocationChoice.newest(new long[0]));
    }

    @Test
    void aPlatformFixIsUsedWhateverPlayServicesDo() {
        assertEquals(PLATFORM, LocationChoice.forLastKnown(true, true));
        assertEquals(PLATFORM, LocationChoice.forLastKnown(true, false));
    }

    @Test
    void playServicesAreTheWayOutOnlyWhenInstalled() {
        assertEquals(PLAY_SERVICES, LocationChoice.forLastKnown(false, true));
        assertEquals(NONE, LocationChoice.forLastKnown(false, false));
    }

    @Test
    void updatesComeFromTheGpsProviderWhenThereIsOne() {
        assertEquals(PLATFORM, LocationChoice.forUpdates(true, true));
        assertEquals(PLATFORM, LocationChoice.forUpdates(true, false));
        assertEquals(PLAY_SERVICES, LocationChoice.forUpdates(false, true));
        assertEquals(NONE, LocationChoice.forUpdates(false, false));
    }
}
