package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PageBoxTest {

    @Test
    void theHeadUnitInLandscapeStartsBelowTheStatusBarWithNoSideInset() {
        PageBox.Box box = PageBox.of(0, 48, 1920, 0);
        assertEquals(0, box.left);
        assertEquals(48, box.top);
        assertEquals(1920, box.right);
    }

    @Test
    void thePhoneInPortraitStartsBelowTheStatusBarWithTheCutout() {
        PageBox.Box box = PageBox.of(0, 96, 1080, 0);
        assertEquals(96, box.top);
        assertEquals(0, box.left);
        assertEquals(1080, box.right);
    }

    @Test
    void thePhoneInLandscapeStaysOutOfTheCutoutAtTheSide() {
        // the workspace starts after the cutout (120 px), the layout fills it
        PageBox.Box box = PageBox.of(0, 72, 2280, 120);
        assertEquals(120, box.left);
        assertEquals(2400, box.right);
        assertEquals(72, box.top);
    }

    @Test
    void scrollingThePagesDoesNotChangeTheBox() {
        // the layout's place in its page and the workspace's place on the screen do not depend on the scroll
        PageBox.Box atRest = PageBox.of(0, 48, 1920, 0);
        PageBox.Box scrolled = PageBox.of(0, 48, 1920, 0);
        assertEquals(atRest.left, scrolled.left);
        assertEquals(atRest.right, scrolled.right);
        assertEquals(atRest.top, scrolled.top);
    }

    @Test
    void aLayoutInsetInItsPageMovesTheBox() {
        PageBox.Box box = PageBox.of(40, 48, 1880, 0);
        assertEquals(40, box.left);
        assertEquals(1920, box.right);
    }
}
