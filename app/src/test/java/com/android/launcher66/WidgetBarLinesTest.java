package com.android.launcher66;

import static com.android.launcher66.WidgetBarLines.Text.ARTIST_TITLE;
import static com.android.launcher66.WidgetBarLines.Text.TITLE_ARTIST;
import static com.android.launcher66.WidgetBarLines.Text.TWO_LINES;
import static com.android.launcher66.WidgetBarLines.Text.TWO_LINES_ARTIST_FIRST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WidgetBarLinesTest {

    @Test
    void bothOneLineChoicesAreOneLine() {
        assertFalse(TWO_LINES.oneLine());
        assertTrue(ARTIST_TITLE.oneLine());
        assertTrue(TITLE_ARTIST.oneLine());
    }

    @Test
    void bothTwoLineChoicesAreTwoLines() {
        assertFalse(TWO_LINES.oneLine());
        assertFalse(TWO_LINES_ARTIST_FIRST.oneLine());
    }

    @Test
    void onlyTheNewChoicePutsTheArtistAbove() {
        assertTrue(TWO_LINES_ARTIST_FIRST.artistAbove());
        assertFalse(TWO_LINES.artistAbove());
        assertFalse(ARTIST_TITLE.artistAbove());
        assertFalse(TITLE_ARTIST.artistAbove());
    }

    @Test
    void theValueStoredBeforeTheNewChoiceStillMeansTheTitleAbove() {
        assertEquals(TWO_LINES, WidgetBarLines.parse("two", false));
        assertEquals(TWO_LINES_ARTIST_FIRST, WidgetBarLines.parse("two_artist_first", false));
    }

    @Test
    void theStoredValuesAreParsed() {
        assertEquals(TWO_LINES, WidgetBarLines.parse("two", false));
        assertEquals(ARTIST_TITLE, WidgetBarLines.parse("artist_title", false));
        assertEquals(TITLE_ARTIST, WidgetBarLines.parse("title_artist", true));
        assertEquals(TWO_LINES, WidgetBarLines.parse("something else", true));
        for (WidgetBarLines.Text text : WidgetBarLines.Text.values()) {
            assertEquals(text, WidgetBarLines.parse(text.value, false));
        }
    }

    @Test
    void theOldSwitchCountsUntilTheStringIsStored() {
        assertEquals(ARTIST_TITLE, WidgetBarLines.parse(null, true));
        assertEquals(TWO_LINES, WidgetBarLines.parse(null, false));
    }

    @Test
    void theButtonsGoInOneRowOnlyBesideTheText() {
        assertTrue(WidgetBarLines.buttonsInOneRow(true, true));
        assertFalse(WidgetBarLines.buttonsInOneRow(true, false));
        assertFalse(WidgetBarLines.buttonsInOneRow(false, true));
        assertFalse(WidgetBarLines.buttonsInOneRow(false, false));
    }
}
