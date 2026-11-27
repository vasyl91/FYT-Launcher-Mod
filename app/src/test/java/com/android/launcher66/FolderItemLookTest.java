package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FolderItemLookTest {

    private static final int HOME = 0xffffff00;
    private static final int GREY = 0xff444444;

    @Test
    void followingTheHomeScreenTheIconsLookAsThere() {
        FolderItemLook look = FolderItemLook.of(true, false, 72, HOME, GREY);
        assertEquals(72, look.iconPx, "the page's size");
        assertEquals(HOME, look.textColor, "the icon text colour, also on the light picture");
        assertTrue(look.shadows, "the page's shadow");
        assertEquals(0, FolderItemLook.of(true, true, 0, HOME, GREY).iconPx, "the standard size where the page has it");
    }

    @Test
    void withoutItTheFolderKeepsItsOwnLook() {
        FolderItemLook look = FolderItemLook.of(false, false, 72, HOME, GREY);
        assertEquals(0, look.iconPx, "the standard picture");
        assertEquals(GREY, look.textColor);
        assertFalse(look.shadows);
        assertEquals(HOME, FolderItemLook.of(false, true, 72, HOME, GREY).textColor,
                "a background of the user's own: the icon text colour");
    }

    @Test
    void aSizeBelowZeroIsTheStandardOne() {
        assertEquals(0, FolderItemLook.of(true, false, -5, HOME, GREY).iconPx);
    }
}
