package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConfigChangesTest {

    @Test
    void noBitsIsNone() {
        assertEquals("none", ConfigChanges.configChangeNames(0));
    }

    @Test
    void knownBitsAreNamedInOrder() {
        assertEquals("uiMode", ConfigChanges.configChangeNames(0x200));
        assertEquals("mcc|mnc|uiMode", ConfigChanges.configChangeNames(0x203));
        assertEquals("density|assetsPaths", ConfigChanges.configChangeNames(0x80001000));
        assertEquals("fontScale", ConfigChanges.configChangeNames(0x40000000));
    }

    @Test
    void unknownBitsAreShownAsHex() {
        assertEquals("orientation|0x4000000", ConfigChanges.configChangeNames(0x80 | 0x4000000));
        assertEquals("0x2000000", ConfigChanges.configChangeNames(0x2000000));
    }
}
