package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** The strip of tabs' measures and the swipes' decisions (the rules of {@link DrawerTabGeometry}). */
class DrawerTabGeometryTest {

    @Test
    void theStripIsFourteenPercentOfTheShorterSide() {
        assertEquals(140, DrawerTabGeometry.stripHeight(1000, 2000));
        assertEquals(140, DrawerTabGeometry.stripHeight(2000, 1000));
        assertEquals(168, DrawerTabGeometry.stripHeight(1200, 1920));
    }

    @Test
    void twoTabsShowInPortraitAndFourInLandscape() {
        assertEquals(2, DrawerTabGeometry.visibleTabs(true));
        assertEquals(4, DrawerTabGeometry.visibleTabs(false));
        assertEquals(500, DrawerTabGeometry.tabWidth(1000, 5, true));
        assertEquals(250, DrawerTabGeometry.tabWidth(1000, 5, false));
    }

    @Test
    void withFewerTabsThanTheBarShowsTheTabsShareTheBar() {
        assertEquals(500, DrawerTabGeometry.tabWidth(1000, 2, false));
        assertEquals(1000, DrawerTabGeometry.tabWidth(1000, 1, true));
        assertEquals(333, DrawerTabGeometry.tabWidth(1000, 3, false));
    }

    @Test
    void theUnderlineIsEightyPercentOfTheTabAndCentred() {
        assertEquals(400f, DrawerTabGeometry.underlineWidth(500), 0.001f);
        assertEquals(50f, DrawerTabGeometry.underlineLeft(0f, 500), 0.001f);
        assertEquals(550f, DrawerTabGeometry.underlineLeft(1f, 500), 0.001f);
        // half way between two tabs: half way between their underlines
        assertEquals(300f, DrawerTabGeometry.underlineLeft(0.5f, 500), 0.001f);
    }

    @Test
    void thePositionStaysBetweenTheFirstAndTheLastTab() {
        assertEquals(0f, DrawerTabGeometry.clampPosition(-0.4f, 4), 0f);
        assertEquals(3f, DrawerTabGeometry.clampPosition(3.7f, 4), 0f);
        assertEquals(1.5f, DrawerTabGeometry.clampPosition(1.5f, 4), 0f);
        assertEquals(0f, DrawerTabGeometry.clampPosition(2f, 1), 0f);
    }

    @Test
    void theBarScrollsByTheLeastThatShowsTheTab() {
        // six tabs of 250 in a bar of 1000: the bar holds four
        assertEquals(0, DrawerTabGeometry.scrollToShow(2, 250, 0, 1000, 6));
        assertEquals(250, DrawerTabGeometry.scrollToShow(4, 250, 0, 1000, 6));
        assertEquals(500, DrawerTabGeometry.scrollToShow(5, 250, 0, 1000, 6), "not past the end of the bar");
        assertEquals(250, DrawerTabGeometry.scrollToShow(1, 250, 500, 1000, 6));
        assertEquals(500, DrawerTabGeometry.scrollToShow(3, 250, 500, 1000, 6), "it shows already: it stays");
    }

    @Test
    void aDragIsSidewaysWhenItIsFarAndMoreSidewaysThanUp() {
        assertTrue(DrawerTabGeometry.sideways(60f, 10f, 16f));
        assertFalse(DrawerTabGeometry.sideways(10f, 0f, 16f), "not past the slop");
        assertFalse(DrawerTabGeometry.sideways(60f, 40f, 16f), "a diagonal is a scroll");
    }

    @Test
    void aSwipeLongerThanAQuarterOfTheWidthChangesTheTab() {
        assertEquals(1, DrawerTabGeometry.swipeDirection(-300f, 0f, 1000, 1500f), "the finger goes left: the next tab");
        assertEquals(-1, DrawerTabGeometry.swipeDirection(300f, 0f, 1000, 1500f));
        assertEquals(0, DrawerTabGeometry.swipeDirection(-200f, 0f, 1000, 1500f), "too short");
    }

    @Test
    void aFlingInTheSameWayChangesTheTabEvenWhenShort() {
        assertEquals(1, DrawerTabGeometry.swipeDirection(-80f, -2500f, 1000, 1500f));
        assertEquals(-1, DrawerTabGeometry.swipeDirection(80f, 2500f, 1000, 1500f));
        assertEquals(0, DrawerTabGeometry.swipeDirection(-80f, -500f, 1000, 1500f), "a slow short move");
    }

    @Test
    void aFlickBackCancelsALongSwipe() {
        assertEquals(0, DrawerTabGeometry.swipeDirection(-400f, 2500f, 1000, 1500f));
        assertEquals(1, DrawerTabGeometry.swipeDirection(-400f, -2500f, 1000, 1500f));
    }

    @Test
    void nothingMovesPastTheFirstOrTheLastTab() {
        assertEquals(2, DrawerTabGeometry.target(1, 1, 4));
        assertEquals(0, DrawerTabGeometry.target(1, -1, 4));
        assertEquals(3, DrawerTabGeometry.target(3, 1, 4));
        assertEquals(0, DrawerTabGeometry.target(0, -1, 4));
        assertEquals(1, DrawerTabGeometry.target(1, 0, 4));
    }

    @Test
    void aTabOpensOnItsFirstPageOrOnItsLastWhenTheSwipeCameBack() {
        assertEquals(0, DrawerTabGeometry.pageAfterTab(false, 4));
        assertEquals(3, DrawerTabGeometry.pageAfterTab(true, 4));
        assertEquals(0, DrawerTabGeometry.pageAfterTab(true, 0), "a tab without pages");
    }
}
