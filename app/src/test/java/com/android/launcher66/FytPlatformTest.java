package com.android.launcher66;

import static com.android.launcher66.FytPlatform.Chipset.FYT_7862;
import static com.android.launcher66.FytPlatform.Chipset.FYT_7870;
import static com.android.launcher66.FytPlatform.Chipset.FYT_8581;
import static com.android.launcher66.FytPlatform.Chipset.FYT_9853I;
import static com.android.launcher66.FytPlatform.Chipset.NOT_FYT;
import static com.android.launcher66.FytPlatform.Chipset.UNKNOWN_FYT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FytPlatformTest {

    @Test
    void theCodeOfTheUnitTellsItsChipset() {
        assertEquals(FYT_7862, FytPlatform.classify(true, "6315", "ums512_1h10_Natv"));
        assertEquals(FYT_7870, FytPlatform.classify(true, "6318", "uis7870sc_2h10_nosec"));
        assertEquals(FYT_8581, FytPlatform.classify(true, "6316"));
        assertEquals(FYT_9853I, FytPlatform.classify(true, "6521"));
    }

    @Test
    void withoutACodeTheDeviceNamesDo() {
        assertEquals(FYT_7870, FytPlatform.classify(true, "", "uis7870sc_2h10_nosec"));
        assertEquals(FYT_7862, FytPlatform.classify(true, "", "ums512_1h10_Natv"));
        assertEquals(FYT_8581, FytPlatform.classify(true, "", "sp9863a_1h10"));
        assertEquals(FYT_9853I, FytPlatform.classify(true, null, "sp9853i_1h10"));
    }

    @Test
    void theCodeWinsOverTheNames() {
        assertEquals(FYT_7862, FytPlatform.classify(true, "6315", "uis7870sc_2h10_nosec"));
    }

    @Test
    void anFytUnitOfAnotherChipsetIsUnknown() {
        assertEquals(UNKNOWN_FYT, FytPlatform.classify(true, "823", "x"));
        assertEquals(UNKNOWN_FYT, FytPlatform.classify(true, "6312"));
        assertEquals(UNKNOWN_FYT, FytPlatform.classify(true, "", (String) null));
    }

    @Test
    void aChipsetWithoutTheFytMarkIsNotAnFytPlatform() {
        // Teyes units and tablets use the UMS512 (T618) too.
        assertEquals(NOT_FYT, FytPlatform.classify(false, "", "ums512_1h10"));
        assertEquals(NOT_FYT, FytPlatform.classify(false, "6315", "ums512_1h10"));
    }

    @Test
    void eachMarkAloneMakesAnFytUnit() {
        assertTrue(FytPlatform.isFyt("fyt_board", "", "", "", ""));
        assertTrue(FytPlatform.isFyt("", "Fyt", "", "", ""));
        assertTrue(FytPlatform.isFyt("", "", "6315", "", ""));
        assertTrue(FytPlatform.isFyt("", "", "", "UIS7862.fyt.2021", ""));
        assertTrue(FytPlatform.isFyt("", "", "", "", "1234"));
    }

    @Test
    void withoutAMarkItIsNotAnFytUnit() {
        assertFalse(FytPlatform.isFyt("", "", "", "", ""));
        assertFalse(FytPlatform.isFyt(null, null, null, null, null));
        assertFalse(FytPlatform.isFyt("ums512", "unisoc", " ", "TP1A", " "));
    }

    @Test
    void theAndroidVersionComesFromTheSdkLevel() {
        assertEquals("8.1", FytPlatform.androidVersion(27, "8.1.0"));
        assertEquals("10", FytPlatform.androidVersion(29, "13")); // the interface may be faked
        assertEquals("12L", FytPlatform.androidVersion(32, ""));
        assertEquals("13", FytPlatform.androidVersion(33, "13"));
    }

    @Test
    void anUnknownSdkLevelFallsBackToTheReleaseOrTheApiLevel() {
        assertEquals("18", FytPlatform.androidVersion(38, "18"));
        assertEquals("API 38", FytPlatform.androidVersion(38, ""));
        assertEquals("API 38", FytPlatform.androidVersion(38, null));
    }

    @Test
    void aKnownPlatformShowsItsLabelAndModel() {
        assertEquals("FYT 7862 (ums512_1h10_Natv) · Android 10",
                FytPlatform.deviceLine(FYT_7862, "sprd", "ums512_1h10_Natv", "6315", 29, "10"));
        assertEquals("FYT 7870 (uis7870sc_2h10_nosec) · Android 13",
                FytPlatform.deviceLine(FYT_7870, "UNISOC", "uis7870sc_2h10_nosec", "6318", 33, "13"));
    }

    @Test
    void anUnknownFytUnitShowsItsModelAndCode() {
        assertEquals("FYT (xyz, 823) · Android 13",
                FytPlatform.deviceLine(UNKNOWN_FYT, "m", "xyz", "823", 33, "13"));
        assertEquals("FYT (823) · Android 13",
                FytPlatform.deviceLine(UNKNOWN_FYT, "m", "", "823", 33, "13"));
        assertEquals("FYT · Android 13",
                FytPlatform.deviceLine(UNKNOWN_FYT, "m", "", "", 33, "13"));
    }

    @Test
    void anotherDeviceShowsItsMakerAndModel() {
        assertEquals("Xiaomi Redmi Note 8T · Android 14",
                FytPlatform.deviceLine(NOT_FYT, "Xiaomi", "Redmi Note 8T", "", 34, "14"));
        assertEquals("Samsung SM-A556B · Android 16",
                FytPlatform.deviceLine(NOT_FYT, "samsung", "SM-A556B", "", 36, "16"));
    }

    @Test
    void theMakerIsNotRepeated() {
        assertEquals("Xiaomi Redmi Note 8T · Android 14",
                FytPlatform.deviceLine(NOT_FYT, "xiaomi", "Xiaomi Redmi Note 8T", "", 34, "14"));
    }

    @Test
    void thereAreNoEmptyBrackets() {
        assertEquals("FYT 8581 · Android 10",
                FytPlatform.deviceLine(FYT_8581, "m", "", "6316", 29, "10"));
        assertEquals("Android 14", FytPlatform.deviceLine(NOT_FYT, "", "", "", 34, "14"));
    }

    @Test
    void aSavedChipsetIsReadBackOrNull() {
        assertEquals(FYT_7862, FytPlatform.fromSaved("FYT_7862"));
        assertNull(FytPlatform.fromSaved(null));
        assertNull(FytPlatform.fromSaved(""));
        assertNull(FytPlatform.fromSaved("FYT_1234"));
    }
}
