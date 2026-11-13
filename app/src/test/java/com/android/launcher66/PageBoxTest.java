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
    void thePageAtRestStartsAtTheScreenEdgeAlthoughTheWorkspaceStartsFarLeftOfIt() {
        // The phone of the log (1080 x 2340): the pager is 10121 px wide and centred, so its left edge is at
        // -4520; its first page lies 4520 px inside it and the pager rests on it at scroll 0.
        assertEquals(0, PageBox.pageRestLeft(-4520, 4520, 0));
        // The third page lies two pages further and the pager rests on it two pages further too
        assertEquals(0, PageBox.pageRestLeft(-4520, 4520 + 2 * 1130, 2 * 1130));
    }

    @Test
    void theBoxOfThePhoneIsTheScreenNotThePager() {
        PageBox.Box box = PageBox.of(0, 89, 1080, PageBox.pageRestLeft(-4520, 4520, 0));
        assertEquals(0, box.left);
        assertEquals(1080, box.right);
        assertEquals(89, box.top);
    }

    @Test
    void aPageNarrowerThanTheScreenRestsCentred() {
        // 20 px of padding on both sides: the page rests 20 px from the edge
        assertEquals(20, PageBox.pageRestLeft(-4520, 4540, 0));
    }

    @Test
    void aLayoutInsetInItsPageMovesTheBox() {
        PageBox.Box box = PageBox.of(40, 48, 1880, 0);
        assertEquals(40, box.left);
        assertEquals(1920, box.right);
    }
}
