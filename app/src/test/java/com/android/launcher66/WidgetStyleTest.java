package com.android.launcher66;

import static com.android.launcher66.WidgetStyle.Role.BAR_BUTTON;
import static com.android.launcher66.WidgetStyle.Role.BAR_TEXT;
import static com.android.launcher66.WidgetStyle.Role.WIDGET_BUTTON;
import static com.android.launcher66.WidgetStyle.Role.WIDGET_PROGRESS;
import static com.android.launcher66.WidgetStyle.Role.WIDGET_TEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WidgetStyleTest {

    private static final int NONE = WidgetStyle.NO_TINT;
    private static final int RED = 0xFFCC2200;

    @Test
    void theWidgetsFollowTheirColourAndTheBarItsOwn() {
        WidgetStyle widgetsOnly = WidgetStyle.of(RED, NONE, (String) null);
        assertEquals(RED, widgetsOnly.tint(WIDGET_TEXT));
        assertEquals(RED, widgetsOnly.tint(WIDGET_BUTTON));
        assertEquals(RED, widgetsOnly.tint(WIDGET_PROGRESS));
        assertEquals(NONE, widgetsOnly.tint(BAR_TEXT));
        assertEquals(NONE, widgetsOnly.tint(BAR_BUTTON));
        WidgetStyle barOnly = WidgetStyle.of(NONE, RED, (String) null);
        assertEquals(NONE, barOnly.tint(WIDGET_TEXT));
        assertEquals(RED, barOnly.tint(BAR_TEXT));
        assertEquals(RED, barOnly.tint(BAR_BUTTON));
    }

    @Test
    void theDefaultBackgroundIsNamedDefaultWhateverTheStoredNameIs() {
        assertTrue(WidgetStyle.of(NONE, NONE, "bg_custom").defaultBackground());
        assertTrue(WidgetStyle.of(NONE, NONE, (String) null).defaultBackground());
        assertTrue(WidgetStyle.of(NONE, NONE, "").defaultBackground());
        assertEquals(WidgetStyle.DEFAULT_BACKGROUND, WidgetStyle.of(NONE, NONE, "bg_custom").background());
        assertEquals("bg_custom_12", WidgetStyle.of(NONE, NONE, "bg_custom_12").background());
        assertFalse(WidgetStyle.of(NONE, NONE, "bg_custom_12").defaultBackground());
    }

    @Test
    void aColourThenDefaultThenAColourAgain() {
        // the setting goes there and back: each state is a function of the settings alone, nothing is left over
        int[] sequence = {RED, NONE, WidgetStyle.BLACK, NONE, RED};
        for (int tint : sequence) {
            WidgetStyle style = WidgetStyle.of(tint, NONE, "bg_custom_3");
            assertEquals(tint, style.tint(WIDGET_BUTTON));
            assertEquals(NONE, style.tint(BAR_BUTTON));
            assertEquals("bg_custom_3", style.background());
        }
    }

    @Test
    void theOldBlackSettingBecomesBlackAndTheOldWhiteStaysNoColour() {
        assertEquals(0xFF000000, WidgetStyle.tintOfLegacyBlack(true));
        assertEquals(WidgetStyle.NO_TINT, WidgetStyle.tintOfLegacyBlack(false));
    }

    @Test
    void onlyAChosenDarkColourIsDark() {
        assertTrue(WidgetStyle.isDark(0xFF000000));
        assertTrue(WidgetStyle.isDark(0xFF202060));
        assertFalse(WidgetStyle.isDark(0xFFFFFFFF));
        assertFalse(WidgetStyle.isDark(0xFFFFE000));
        assertFalse(WidgetStyle.isDark(WidgetStyle.NO_TINT));
    }

    @Test
    void theUsersOwnColourIsNeitherTheDefaultNorAPicture() {
        WidgetStyle style = WidgetStyle.of(NONE, NONE,
                BackgroundChoice.of("custom", "bg_custom", true, 0x80445566));
        assertFalse(style.defaultBackground());
        assertEquals(BackgroundChoice.CUSTOM, style.background());
        assertEquals(BackgroundChoice.Kind.CUSTOM, style.backgroundChoice().kind);
        assertEquals(0x80445566, style.backgroundChoice().color);
    }

    @Test
    void aPictureGivenAsAChoiceIsTheSameAsItsName() {
        WidgetStyle style = WidgetStyle.of(NONE, NONE,
                BackgroundChoice.of("bg_custom_12", "bg_custom", false, 0));
        assertEquals("bg_custom_12", style.background());
        assertTrue(WidgetStyle.of(NONE, NONE, BackgroundChoice.of(null, "bg_custom", false, 0)).defaultBackground());
    }
}
