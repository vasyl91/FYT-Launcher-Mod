package com.android.launcher66.settings;

import static com.android.launcher66.settings.WallpaperAccess.Level.HOST;
import static com.android.launcher66.settings.WallpaperAccess.Level.OWN_COPY;
import static com.android.launcher66.settings.WallpaperAccess.Level.SYSTEM_API;
import static com.android.launcher66.settings.WallpaperAccess.Level.USER_PICKS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WallpaperAccessTest {

    @Test
    void theSystemVersionUsesTheApiOnEveryAndroid() {
        // the owner's unit: Android 10, the launcher is the system
        assertEquals(Arrays.asList(SYSTEM_API, USER_PICKS), WallpaperAccess.levels(29, true, false, false, false));
        assertEquals(Arrays.asList(SYSTEM_API, USER_PICKS), WallpaperAccess.levels(36, true, false, false, false));
    }

    @Test
    void anOlderAndroidWithTheStoragePermissionUsesTheApi() {
        assertEquals(Arrays.asList(SYSTEM_API, USER_PICKS), WallpaperAccess.levels(31, false, true, false, false));
    }

    @Test
    void anOlderAndroidWithoutThePermissionHasItsOwnCopyAndThePick() {
        assertEquals(Arrays.asList(OWN_COPY, USER_PICKS), WallpaperAccess.levels(31, false, false, false, false));
    }

    @Test
    void android16WithShizukuAsksTheHostAndNotTheApi() {
        // the phone of the report: the API would throw (READ_EXTERNAL_STORAGE denied)
        // ... so the copy of a wallpaper the launcher set itself comes first: it costs nothing and is exact
        assertEquals(Arrays.asList(OWN_COPY, HOST, USER_PICKS), WallpaperAccess.levels(36, false, false, false, true));
    }

    @Test
    void theStoragePermissionOfAnOldInstallDoesNotCountFromAndroid13() {
        assertEquals(Arrays.asList(OWN_COPY, HOST, USER_PICKS), WallpaperAccess.levels(34, false, true, false, true));
    }

    @Test
    void accessToAllFilesMakesTheApiWorkAgain() {
        assertEquals(Arrays.asList(SYSTEM_API, HOST, USER_PICKS),
                WallpaperAccess.levels(36, false, false, true, true));
    }

    @Test
    void withNoHostThereIsTheOwnCopyAndThenTheUsersPick() {
        assertEquals(Arrays.asList(OWN_COPY, USER_PICKS), WallpaperAccess.levels(36, false, false, false, false));
    }

    @Test
    void whereTheApiGivesThePictureNoCopyIsAskedFor() {
        assertFalse(WallpaperAccess.levels(29, true, false, false, false).contains(OWN_COPY));
        assertFalse(WallpaperAccess.levels(36, false, false, true, true).contains(OWN_COPY));
    }

    @Test
    void theOldPermissionIsAskedForOnlyWhereItExists() {
        assertTrue(WallpaperAccess.storagePermissionHelps(29, false));
        assertTrue(WallpaperAccess.storagePermissionHelps(32, false));
        assertFalse(WallpaperAccess.storagePermissionHelps(33, false));
        assertFalse(WallpaperAccess.storagePermissionHelps(36, false));
        assertFalse(WallpaperAccess.storagePermissionHelps(29, true));
    }
}
