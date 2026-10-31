package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatsWindowSizeTest {

    @Test
    void whatTheTextNeedsLessThanTheShareIsTheShare() {
        assertEquals(400, StatsWindowSize.windowWidth(400, 380, 1280, 5));
        assertEquals(400, StatsWindowSize.windowWidth(400, 0, 1280, 5));
        assertEquals(400, StatsWindowSize.windowWidth(400, 400, 1280, 5));
    }

    @Test
    void whatTheTextNeedsBetweenTheShareAndTheLimitIsWhatItNeeds() {
        assertEquals(430, StatsWindowSize.windowWidth(400, 430, 1280, 5));
        assertEquals(460, StatsWindowSize.windowWidth(400, 460, 1280, 5));
    }

    @Test
    void whatTheTextNeedsBeyondFifteenPercentIsThatLimit() {
        assertEquals(460, StatsWindowSize.windowWidth(400, 461, 1280, 5));
        assertEquals(460, StatsWindowSize.windowWidth(400, 900, 1280, 5));
        assertEquals(115, StatsWindowSize.windowWidth(100, 900, 1280, 5));
    }

    @Test
    void aNarrowScreenLimitsTheWindowToTheScreenLessTheMargins() {
        // 1.15 x 400 = 460, but the screen is 450 wide
        assertEquals(430, StatsWindowSize.windowWidth(400, 460, 450, 10));
        // and the share itself is wider than the screen allows
        assertEquals(380, StatsWindowSize.windowWidth(400, 100, 400, 10));
        assertEquals(0, StatsWindowSize.windowWidth(400, 100, 10, 10));
    }

    @Test
    void theMediumAndTheSmallWindowAreExactlyTheirShareWhateverTheTextNeeds() {
        for (int required : new int[]{0, 100, 280, 1000, 5000}) {
            assertEquals(280, StatsWindowSize.widthForSize(1, 420, required, 1280, 5));
            assertEquals(105, StatsWindowSize.widthForSize(2, 420, required, 1280, 5));
        }
        // within the margins of a narrow screen
        assertEquals(180, StatsWindowSize.widthForSize(1, 420, 1000, 200, 10));
        assertEquals(105, StatsWindowSize.widthForSize(2, 420, 1000, 200, 10));
    }

    @Test
    void theLargeWindowGrowsByAtMostFifteenPercent() {
        assertEquals(420, StatsWindowSize.widthForSize(0, 420, 100, 1280, 5));
        assertEquals(450, StatsWindowSize.widthForSize(0, 420, 450, 1280, 5));
        assertEquals(483, StatsWindowSize.widthForSize(0, 420, 1000, 1280, 5));
    }

    @Test
    void theSharesOfTheThreeSizes() {
        assertEquals(420, StatsWindowSize.baseWidth(0, 420));
        assertEquals(280, StatsWindowSize.baseWidth(1, 420));
        assertEquals(105, StatsWindowSize.baseWidth(2, 420));
        assertEquals(420, StatsWindowSize.baseWidth(7, 420));
    }

    @Test
    void theTextSizeIsTheLaunchersForTheScreen() {
        assertEquals(18, StatsWindowSize.textSizeSp(2000));
        assertEquals(14, StatsWindowSize.textSizeSp(1280));
        assertEquals(0, StatsWindowSize.textSizeSp(0));
    }

    @Test
    void theSavedRectangleTakesTheWidthOfTheWindowAndStaysOnTheScreen() {
        // room on the right: the left edge stays
        assertEquals(100, StatsWindowSize.fitRectangle(100, 540, 1280, 5)[0]);
        assertEquals(640, StatsWindowSize.fitRectangle(100, 540, 1280, 5)[1]);
        // against the right edge: it grows to the left
        int[] edge = StatsWindowSize.fitRectangle(1000, 540, 1280, 5);
        assertEquals(1275, edge[1]);
        assertEquals(735, edge[0]);
        // narrower than before: the right edge follows
        assertEquals(380, StatsWindowSize.fitRectangle(100, 280, 1280, 5)[1]);
        // never left of the margin
        int[] wide = StatsWindowSize.fitRectangle(0, 400, 420, 10);
        assertEquals(10, wide[0]);
        assertEquals(410, wide[1]);
    }
}
