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

    @Test
    void theWidgetsFollowTheirSettingAndTheBarItsOwn() {
        WidgetStyle widgetsOnly = WidgetStyle.of(true, false, (String) null);
        assertTrue(widgetsOnly.black(WIDGET_TEXT));
        assertTrue(widgetsOnly.black(WIDGET_BUTTON));
        assertTrue(widgetsOnly.black(WIDGET_PROGRESS));
        assertFalse(widgetsOnly.black(BAR_TEXT));
        assertFalse(widgetsOnly.black(BAR_BUTTON));
        WidgetStyle barOnly = WidgetStyle.of(false, true, (String) null);
        assertFalse(barOnly.black(WIDGET_TEXT));
        assertTrue(barOnly.black(BAR_TEXT));
        assertTrue(barOnly.black(BAR_BUTTON));
    }

    @Test
    void theDefaultBackgroundIsNamedDefaultWhateverTheStoredNameIs() {
        assertTrue(WidgetStyle.of(false, false, "bg_custom").defaultBackground());
        assertTrue(WidgetStyle.of(false, false, (String) null).defaultBackground());
        assertTrue(WidgetStyle.of(false, false, "").defaultBackground());
        assertEquals(WidgetStyle.DEFAULT_BACKGROUND, WidgetStyle.of(false, false, "bg_custom").background());
        assertEquals("bg_custom_12", WidgetStyle.of(false, false, "bg_custom_12").background());
        assertFalse(WidgetStyle.of(false, false, "bg_custom_12").defaultBackground());
    }

    @Test
    void blackThenDefaultThenBlackAgain() {
        // the setting goes there and back: each state is a function of the settings alone, nothing is left over
        boolean[] sequence = {true, false, true, false, true};
        for (boolean black : sequence) {
            WidgetStyle style = WidgetStyle.of(black, !black, "bg_custom_3");
            assertEquals(black, style.black(WIDGET_BUTTON));
            assertEquals(!black, style.black(BAR_BUTTON));
            assertEquals("bg_custom_3", style.background());
        }
    }

    @Test
    void theUsersOwnColourIsNeitherTheDefaultNorAPicture() {
        WidgetStyle style = WidgetStyle.of(false, false,
                BackgroundChoice.of("custom", "bg_custom", true, 0x80445566));
        assertFalse(style.defaultBackground());
        assertEquals(BackgroundChoice.CUSTOM, style.background());
        assertEquals(BackgroundChoice.Kind.CUSTOM, style.backgroundChoice().kind);
        assertEquals(0x80445566, style.backgroundChoice().color);
    }

    @Test
    void aPictureGivenAsAChoiceIsTheSameAsItsName() {
        WidgetStyle style = WidgetStyle.of(false, false,
                BackgroundChoice.of("bg_custom_12", "bg_custom", false, 0));
        assertEquals("bg_custom_12", style.background());
        assertTrue(WidgetStyle.of(false, false, BackgroundChoice.of(null, "bg_custom", false, 0)).defaultBackground());
    }
}
