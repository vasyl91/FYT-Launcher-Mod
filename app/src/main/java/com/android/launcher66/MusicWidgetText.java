package com.android.launcher66;

import java.util.Set;

/**
 * What the music widget's two text lines say, kept free of views so the rules can be tested:
 * the second line is the artist, "Live" only for a YouTube live stream (or the radio), and the
 * one-line mode of a small widget joins both into "artist – title".
 */
final class MusicWidgetText {

    /** YouTube and its forks. YouTube Music is deliberately not here: it is not a live stream. */
    static final Set<String> YOUTUBE_PACKAGES = Set.of(
            "com.google.android.youtube",
            "app.revanced.android.youtube",
            "app.rvx.android.youtube");

    /**
     * YouTube reports a duration of 0 for a moment at the start of an ordinary video as well, so
     * "Live" is shown only once the 0 has lasted this long under the same title.
     */
    static final long LIVE_CONFIRM_MS = 1500L;

    static final String LIVE = "Live";

    static final String SEPARATOR = " – ";

    static final String LIVE_JOIN = " · ";

    private MusicWidgetText() {
    }

    static boolean isYoutubeLive(String pkg, long durationMs, long zeroDurationForMs) {
        return pkg != null && YOUTUBE_PACKAGES.contains(pkg) && durationMs <= 0
                && zeroDurationForMs >= LIVE_CONFIRM_MS;
    }

    /**
     * The second line. {@code artist} is already normalized (empty means none). The radio shows
     * where it is tuned and "Live" when it says nothing; an empty result for anything else leaves
     * the placeholder to the renderer.
     */
    static String secondLine(boolean radio, String artist, boolean live) {
        boolean hasArtist = artist != null && !artist.isEmpty();
        if (radio) {
            return hasArtist ? artist : LIVE;
        }
        if (live) {
            return hasArtist ? artist + LIVE_JOIN + LIVE : LIVE;
        }
        return hasArtist ? artist : "";
    }

    /**
     * The single line of the one-line mode. No artist placeholder here: "Artist – Song" would
     * say nothing.
     */
    static String compactLine(String title, String second, String titlePlaceholder) {
        boolean hasTitle = title != null && !title.isEmpty();
        boolean hasSecond = second != null && !second.isEmpty();
        if (hasTitle && hasSecond) {
            return second + SEPARATOR + title;
        }
        if (hasTitle) {
            return title;
        }
        if (hasSecond) {
            return second;
        }
        return titlePlaceholder;
    }
}
