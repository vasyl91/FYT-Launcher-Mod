package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MusicWidgetTextTest {

    private static final String YT = "com.google.android.youtube";

    @Test
    void liveNeedsYoutubeZeroDurationAndTheConfirmTime() {
        assertFalse(MusicWidgetText.isYoutubeLive(YT, 0, MusicWidgetText.LIVE_CONFIRM_MS - 1));
        assertTrue(MusicWidgetText.isYoutubeLive(YT, 0, MusicWidgetText.LIVE_CONFIRM_MS));
        assertTrue(MusicWidgetText.isYoutubeLive("app.revanced.android.youtube", 0, 5000));
        assertTrue(MusicWidgetText.isYoutubeLive("app.rvx.android.youtube", -1, 5000));
    }

    @Test
    void aKnownDurationIsNeverLive() {
        assertFalse(MusicWidgetText.isYoutubeLive(YT, 1, 60_000));
        assertFalse(MusicWidgetText.isYoutubeLive(YT, 215_000, 60_000));
    }

    @Test
    void otherPlayersAreNeverLive() {
        assertFalse(MusicWidgetText.isYoutubeLive("com.google.android.apps.youtube.music", 0, 60_000));
        assertFalse(MusicWidgetText.isYoutubeLive("com.spotify.music", 0, 60_000));
        assertFalse(MusicWidgetText.isYoutubeLive(null, 0, 60_000));
    }

    @Test
    void theRadioShowsItsTuningOrLive() {
        assertEquals("FM 101.50 MHz", MusicWidgetText.secondLine(true, "FM 101.50 MHz", false));
        assertEquals("Live", MusicWidgetText.secondLine(true, "", false));
        assertEquals("Live", MusicWidgetText.secondLine(true, null, false));
    }

    @Test
    void aLiveStreamAddsLiveToTheChannel() {
        assertEquals("Channel · Live", MusicWidgetText.secondLine(false, "Channel", true));
        assertEquals("Live", MusicWidgetText.secondLine(false, "", true));
    }

    @Test
    void anythingElseShowsTheArtistOnly() {
        assertEquals("Artist", MusicWidgetText.secondLine(false, "Artist", false));
        assertEquals("", MusicWidgetText.secondLine(false, "", false));
        assertEquals("", MusicWidgetText.secondLine(false, null, false));
    }

    @Test
    void theOneLineModeJoinsArtistAndTitle() {
        assertEquals("Artist – Song", MusicWidgetText.compactLine("Song", "Artist", "Song?"));
        assertEquals("Song", MusicWidgetText.compactLine("Song", "", "Song?"));
        assertEquals("Artist", MusicWidgetText.compactLine("", "Artist", "Song?"));
        assertEquals("Song?", MusicWidgetText.compactLine("", "", "Song?"));
        assertEquals("Song?", MusicWidgetText.compactLine(null, null, "Song?"));
    }
}
