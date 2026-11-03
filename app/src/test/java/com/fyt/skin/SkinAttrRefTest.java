package com.fyt.skin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SkinAttrRefTest {

    @Test
    void literalTagIsNotAReference() {
        assertNull(SkinAttrRef.resourceRef("boxFit"));
    }

    @Test
    void resourceReferenceIsParsed() {
        assertEquals(Integer.valueOf(2131755), SkinAttrRef.resourceRef("@2131755"));
    }

    @Test
    void themeReferenceIsParsed() {
        assertEquals(Integer.valueOf(123), SkinAttrRef.resourceRef("?123"));
    }

    @Test
    void everythingElseIsIgnored() {
        assertNull(SkinAttrRef.resourceRef("#ffffff"));
        assertNull(SkinAttrRef.resourceRef(""));
        assertNull(SkinAttrRef.resourceRef(null));
        assertNull(SkinAttrRef.resourceRef("@null"));
        assertNull(SkinAttrRef.resourceRef("@android:color/white"));
    }

    @Test
    void overflowingNumberIsIgnored() {
        assertNull(SkinAttrRef.resourceRef("@99999999999"));
    }

    @Test
    void themeRefDetection() {
        assertTrue(SkinAttrRef.isThemeRef("?1"));
        assertFalse(SkinAttrRef.isThemeRef("@1"));
        assertFalse(SkinAttrRef.isThemeRef(null));
    }
}
