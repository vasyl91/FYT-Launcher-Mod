package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockTitlesTest {

    @Test
    void anAbsolutePathIsAFileOfThisDevice() {
        assertTrue(StockTitles.isLocalFile("/storage/usb0/Song.mp3"));
        assertTrue(StockTitles.isLocalFile("/sdcard/track"));
    }

    @Test
    void urlsStationsAndPlaceholdersAreNoFiles() {
        assertFalse(StockTitles.isLocalFile("http://stream.example.com/LT3.mp3"));
        assertFalse(StockTitles.isLocalFile("https://stream.example.com/live"));
        assertFalse(StockTitles.isLocalFile("stock-radio:/10150"));
        assertFalse(StockTitles.isLocalFile("unknown"));
        assertFalse(StockTitles.isLocalFile("//host/share"));
        assertFalse(StockTitles.isLocalFile("/"));
        assertFalse(StockTitles.isLocalFile(""));
        assertFalse(StockTitles.isLocalFile(null));
    }

    @Test
    void aFileNameLosesItsExtension() {
        assertEquals("Song", StockTitles.displayTitle(true, "/storage/usb0/Song.mp3", "Tag title"));
        assertEquals("My.Song.v2", StockTitles.displayTitle(true, "/music/My.Song.v2.flac", "x"));
    }

    @Test
    void aFileNameWithoutADotIsTheWholeName() {
        // substring(0, lastIndexOf(".")) threw for this one
        assertEquals("track01", StockTitles.displayTitle(true, "/storage/usb0/track01", "Tag title"));
    }

    @Test
    void aNameThatStartsWithTheDotKeepsIt() {
        assertEquals(".hidden", StockTitles.displayTitle(true, "/music/.hidden", "Tag title"));
    }

    @Test
    void aStreamIsTitledByWhatThePlayerReports() {
        assertEquals("Radio Nowy Swiat",
                StockTitles.displayTitle(true, "http://stream.example.com/LT3.mp3", "Radio Nowy Swiat"));
    }

    @Test
    void theMetadataTitleIsKeptWhenTheFileNameIsNotWanted() {
        assertEquals("Tag title", StockTitles.displayTitle(false, "/storage/usb0/Song.mp3", "Tag title"));
    }

    @Test
    void missingTextsAreEmptyNotNull() {
        assertEquals("", StockTitles.displayTitle(false, null, null));
        assertEquals("", StockTitles.displayTitle(true, "http://a/b", null));
    }

    @Test
    void theBaseNameOfAFileOnly() {
        assertEquals("Song", StockTitles.fileBaseName("/music/Song.mp3"));
        assertNull(StockTitles.fileBaseName("http://a/b.mp3"));
        assertNull(StockTitles.fileBaseName(null));
    }
}
