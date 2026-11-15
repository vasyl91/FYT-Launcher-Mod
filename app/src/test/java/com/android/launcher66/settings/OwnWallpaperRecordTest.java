package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OwnWallpaperRecordTest {

    @Test
    void theIdIsWrittenAndReadBack() {
        assertEquals(1234, OwnWallpaperRecord.parse(OwnWallpaperRecord.format(1234)));
        assertEquals(57, OwnWallpaperRecord.parse(" 57\n"));
    }

    @Test
    void anythingElseIsNoId() {
        assertEquals(-1, OwnWallpaperRecord.parse(null));
        assertEquals(-1, OwnWallpaperRecord.parse(""));
        assertEquals(-1, OwnWallpaperRecord.parse("abc"));
    }

    @Test
    void theCopyStandsForTheWallpaperWhileItIsStillSet() {
        assertTrue(OwnWallpaperRecord.stillSet(57, 57));
    }

    @Test
    void aWallpaperSetSinceByAnyoneElseHasAnotherId() {
        assertFalse(OwnWallpaperRecord.stillSet(57, 58));
    }

    @Test
    void whereTheSystemCannotTellTheIdTheCopyIsNotUsed() {
        assertFalse(OwnWallpaperRecord.stillSet(-1, -1));
        assertFalse(OwnWallpaperRecord.stillSet(0, 0));
    }
}
