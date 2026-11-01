package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatsWindowSizeTest {

    @Test
    void theSmallWindowIsFivePercentNarrowerThanAQuarter() {
        assertEquals(66, StatsWindowSize.smallWidth(278)); // 69 * 0.95 = 65.55
        assertEquals(100, StatsWindowSize.smallWidth(420)); // 105 * 0.95 = 99.75
        assertEquals(0, StatsWindowSize.smallWidth(0));
    }

    @Test
    void theFontNeverGrowsAboveTheStandardOne() {
        // 40 px of text in a window of 200 px, 20 px lines in 100 px
        assertEquals(1f, StatsWindowSize.fontScale(40f, 20f, 200, 10, 100), 0f);
        assertEquals(1f, StatsWindowSize.fontScale(1f, 1f, 5000, 0, 5000), 0f);
    }

    @Test
    void aTextTooWideShrinksTheFontToNinetyFivePercentOfTheWindow() {
        // (66 - 6) * 0.95 / 76 = 0.75
        assertEquals(0.75f, StatsWindowSize.fontScale(76f, 10f, 66, 6, 100), 1e-6f);
    }

    @Test
    void aWindowTooLowShrinksTheFontToTwoLinesInNinetyPercentOfTheHeight() {
        // 0.9 * 40 / 2 / 24 = 0.75
        assertEquals(0.75f, StatsWindowSize.fontScale(10f, 24f, 200, 0, 40), 1e-6f);
    }

    @Test
    void theSmallerOfTheTwoScalesWins() {
        // width: 0.5, height: 0.75
        assertEquals(0.5f, StatsWindowSize.fontScale(380f, 24f, 200, 0, 40), 1e-6f);
        // width: 0.95 * 100 / 80 = 1.19 -> 1, height: 0.6
        assertEquals(0.6f, StatsWindowSize.fontScale(80f, 30f, 100, 0, 40), 1e-6f);
    }

    @Test
    void aDivisorOfZeroLeavesThatConditionOut() {
        assertEquals(1f, StatsWindowSize.fontScale(0f, 20f, 200, 10, 100), 0f);
        assertEquals(1f, StatsWindowSize.fontScale(40f, 0f, 200, 10, 100), 0f);
        assertEquals(0.5f, StatsWindowSize.fontScale(0f, 40f, 200, 10, 40), 0.1f);
        assertEquals(1f, StatsWindowSize.fontScale(0f, 0f, 0, 0, 0), 0f);
    }

    @Test
    void aLineIsTheLabelTwoSpacesThreeDigitsAndTheUnitAtThreeQuarters() {
        assertEquals(176f, StatsWindowSize.lineWidth(100, 5, 3, 9, 27, 40), 1e-4f);
    }

    @Test
    void theRoomAfterTheSpaceIsAtLeastAsWideAsTheCharacterItIsFor() {
        // the character (a digit) is wider than a space
        assertEquals(164f, StatsWindowSize.lineWidth(100, 5, 11, 0, 33, 20), 1e-4f);
    }

    @Test
    void theLongerLineDecidesTheWidthRoundedUpWithTheBackground() {
        assertEquals(210, StatsWindowSize.textWidth(200f, 150f, 10));
        // the range longer than the consumption, as in Bulgarian
        assertEquals(231, StatsWindowSize.textWidth(150f, 220.2f, 10));
        assertEquals(10 + 100, StatsWindowSize.textWidth(100f, 100f, 10));
        assertEquals(101 + 4, StatsWindowSize.textWidth(100.01f, 90f, 4));
    }

    @Test
    void aWidthIsWithinTheScreenLessTheMargins() {
        assertEquals(430, StatsWindowSize.clampToScreen(500, 450, 10));
        assertEquals(300, StatsWindowSize.clampToScreen(300, 450, 10));
        assertEquals(0, StatsWindowSize.clampToScreen(300, 10, 10));
        assertEquals(0, StatsWindowSize.clampToScreen(300, 15, 10));
    }

    @Test
    void theValuesAreWorkedOutAgainOnlyWhenTheGeometryChanges() {
        String tag = StatsWindowSize.geometryTag("pl-PL", 1280, 64, 160, 1.0f);
        assertEquals(tag, StatsWindowSize.geometryTag("pl-PL", 1280, 64, 160, 1.0f));
        assertFalse(StatsWindowSize.needsRecompute(true, true, true, tag, tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, StatsWindowSize.geometryTag("bg-BG", 1280, 64, 160, 1.0f), tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, StatsWindowSize.geometryTag("pl-PL", 1920, 64, 160, 1.0f), tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, StatsWindowSize.geometryTag("pl-PL", 1280, 96, 160, 1.0f), tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, StatsWindowSize.geometryTag("pl-PL", 1280, 64, 240, 1.0f), tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, StatsWindowSize.geometryTag("pl-PL", 1280, 64, 160, 1.3f), tag));
    }

    @Test
    void aMissingValueOrNoTagMeansWorkingThemOut() {
        String tag = StatsWindowSize.geometryTag("pl-PL", 1280, 64, 160, 1.0f);
        assertTrue(StatsWindowSize.needsRecompute(false, true, true, tag, tag));
        assertTrue(StatsWindowSize.needsRecompute(true, false, true, tag, tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, false, tag, tag));
        assertTrue(StatsWindowSize.needsRecompute(true, true, true, null, tag));
    }

    // The proportions of Roboto Bold in em: a digit 0.56, a dot 0.27, a tilde 0.59, a space 0.25
    private static final float DIGIT = 0.56f, DOT = 0.27f, TILDE = 0.59f, SPACE = 0.25f;

    @Test
    void anEstimateOfTheConsumptionFitsItsLine() {
        float label = 7.5f; // "Fuel consumption:" in em
        float unit = 4.2f; // " L/100km " in em
        float line = StatsWindowSize.lineWidth(label, SPACE, DOT, TILDE, 3 * DIGIT, unit);
        // "~18.8": the tilde, three digits and the dot
        float value = TILDE + 3 * DIGIT + DOT;
        assertTrue(line >= label + SPACE + value + StatsWindowSize.UNIT_SCALE * unit, "line " + line);
    }

    @Test
    void aRangeOfFourDigitsFitsItsLine() {
        float label = 7.0f;
        float unit = 2.0f;
        float line = StatsWindowSize.lineWidth(label, SPACE, DIGIT, 0f, 3 * DIGIT, unit);
        // "1999": without the room being as wide as a digit, two spaces and three digits would be narrower than four digits
        assertTrue(line >= label + SPACE + 4 * DIGIT + StatsWindowSize.UNIT_SCALE * unit, "line " + line);
        float twoSpaces = label + 2 * SPACE + 3 * DIGIT + StatsWindowSize.UNIT_SCALE * unit;
        assertTrue(twoSpaces < label + SPACE + 4 * DIGIT + StatsWindowSize.UNIT_SCALE * unit);
    }

    @Test
    void aWindowAtItsSavedWidthNeedsNoShrinking() {
        // the safety of the window: the saved width is the longer line rounded up, plus the background, so the scale is 1
        float consumption = 213.37f, range = 241.9f;
        int padding = 12;
        int width = StatsWindowSize.textWidth(consumption, range, padding);
        assertEquals(1f, StatsWindowSize.fitScale(Math.max(consumption, range), 1.0, width, padding, 20f, 100), 0f);
        // and a window cut by 10 % does
        assertTrue(StatsWindowSize.fitScale(Math.max(consumption, range), 1.0, (int) (width * 0.9), padding, 20f, 100) < 1f);
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

    @Test
    void theUnitStartsRightAfterTheNumber() {
        assertEquals(3, StatsWindowSize.unitStart("4.5 L/100km ", "4.5"));
        assertEquals(4, StatsWindowSize.unitStart("~4.5 L/100km ", "4.5"));
        assertEquals(2, StatsWindowSize.unitStart("12 km ", "12"));
        assertEquals(4, StatsWindowSize.unitStart("~0.9 L/h ", "0.9"));
        assertEquals(3, StatsWindowSize.unitStart("-.- km ", "-.-"));
    }

    @Test
    void theUnitStartsAfterTheNumberInOtherLanguages() {
        // Polish (values-pl), Greek (values-el) and Arabic (values-ar, right to left)
        assertEquals(3, StatsWindowSize.unitStart("4,5 L/100km\u0020", "4,5"));
        assertEquals(3, StatsWindowSize.unitStart("4.5 \u03bb./100 \u03c7\u03bb\u03bc.\u0020", "4.5"));
        String arabic = "4.5 \u0644\u062a\u0631/100 \u0643\u0645\u0020";
        assertEquals(3, StatsWindowSize.unitStart(arabic, "4.5"));
        assertEquals(" \u0644\u062a\u0631/100 \u0643\u0645\u0020", arabic.substring(3));
    }

    @Test
    void noNumberMeansNoUnit() {
        assertEquals(-1, StatsWindowSize.unitStart("L/100km", "4.5"));
        assertEquals(-1, StatsWindowSize.unitStart("", "4.5"));
        assertEquals(-1, StatsWindowSize.unitStart(null, "4.5"));
        assertEquals(-1, StatsWindowSize.unitStart("4.5", ""));
    }

    @Test
    void aTextThatEndsWithTheNumberHasNoUnit() {
        assertEquals(4, StatsWindowSize.unitStart("~4.5", "4.5"));
        assertEquals("~4.5".length(), StatsWindowSize.unitStart("~4.5", "4.5"));
        assertEquals("8888".length(), StatsWindowSize.unitStart("8888", "8888"));
    }
}
