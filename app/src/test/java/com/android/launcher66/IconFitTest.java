package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IconFitTest {

    /** The Galaxy A55 in portrait: a page of 1080 x 2116, icons of 154 px, a label line of about 42 px. */
    private static final int PHONE_ICON = 154;
    private static final int PHONE_LABEL = 42;
    /** The FYT 7862: 2000 x 1200, icons of 132 px, a label line of about 38 px. */
    private static final int UNIT_ICON = 132;
    private static final int UNIT_LABEL = 38;

    @Test
    void theGridTheLauncherAlwaysHadKeepsTheStandardIcon() {
        // Whatever the cells are: an unchanged grid is never touched
        assertEquals(PHONE_ICON, IconFit.iconPx(PHONE_ICON, 180, 211, PHONE_LABEL, true));
        assertEquals(UNIT_ICON, IconFit.iconPx(UNIT_ICON, 200, 190, UNIT_LABEL, true));
        assertEquals(UNIT_ICON, IconFit.iconPx(UNIT_ICON, 200, 150, 60, true));
    }

    @Test
    void anIconThatFitsItsCellKeepsItsSize() {
        // Twelve columns on the unit: cells of 166 x 190 still hold an icon of 132 with its label of 38
        assertEquals(UNIT_ICON, IconFit.iconPx(UNIT_ICON, 166, 190, UNIT_LABEL, false));
    }

    @Test
    void aSparserGridNeverMakesTheIconLarger() {
        // Eight rows and four columns on the phone: cells of 270 x 264
        assertEquals(PHONE_ICON, IconFit.iconPx(PHONE_ICON, 270, 264, PHONE_LABEL, false));
    }

    @Test
    void fourteenRowsOnThePhoneMakeTheIconFitWithItsLabel() {
        // 2116 / 14 = 151: lower than the icon alone, which was cut together with its label
        int px = IconFit.iconPx(PHONE_ICON, 180, 151, PHONE_LABEL, false);
        assertEquals(151 - PHONE_LABEL, px);
        assertTrue(px + PHONE_LABEL <= 151);
    }

    @Test
    void tenColumnsOnThePhoneMakeTheIconAsWideAsItsCell() {
        // 1080 / 10 = 108 px of width, plenty of height
        assertEquals(108, IconFit.iconPx(PHONE_ICON, 108, 211, PHONE_LABEL, false));
    }

    @Test
    void theNarrowerOfWidthAndHeightDecides() {
        assertEquals(100, IconFit.iconPx(PHONE_ICON, 100, 151, PHONE_LABEL, false));
        assertEquals(109, IconFit.iconPx(PHONE_ICON, 120, 151, PHONE_LABEL, false));
    }

    @Test
    void itStopsAtTwoFifthsOfTheStandardSize() {
        assertEquals(Math.round(PHONE_ICON * IconFit.MIN_SHARE), IconFit.iconPx(PHONE_ICON, 30, 30, PHONE_LABEL, false));
    }

    @Test
    void withoutAStandardSizeThereIsNothingToFit() {
        assertEquals(0, IconFit.iconPx(0, 100, 100, 20, false));
    }
}
