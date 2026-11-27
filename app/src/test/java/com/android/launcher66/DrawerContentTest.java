package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.DrawerContent.Shown;

import org.junit.jupiter.api.Test;

class DrawerContentTest {

    @Test
    void theWidgetsAreShownByTheirListWhateverTheScrollingOfTheApps() {
        assertEquals(Shown.WIDGETS_LIST, DrawerContent.shown(true, true, true, true));
        assertEquals(Shown.WIDGETS_LIST, DrawerContent.shown(true, false, true, true));
    }

    @Test
    void withoutTheirListTheWidgetsAreOnThePager() {
        assertEquals(Shown.PAGER, DrawerContent.shown(true, true, true, false));
    }

    @Test
    void theAppsFollowTheScrolling() {
        assertEquals(Shown.APPS_LIST, DrawerContent.shown(false, true, true, true));
        assertEquals(Shown.PAGER, DrawerContent.shown(false, false, true, true));
    }

    @Test
    void withoutTheVerticalListTheAppsAreOnThePager() {
        assertEquals(Shown.PAGER, DrawerContent.shown(false, true, false, true));
    }

    @Test
    void onlyAShownPagerFillsItsPages() {
        assertTrue(DrawerContent.fillsPages(Shown.PAGER));
        assertFalse(DrawerContent.fillsPages(Shown.APPS_LIST));
        assertFalse(DrawerContent.fillsPages(Shown.WIDGETS_LIST));
    }
}
