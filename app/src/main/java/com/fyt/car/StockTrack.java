package com.fyt.car;

import java.util.Arrays;
import java.util.Objects;

/**
 * What a stock source shows in the music widget, as one immutable value: the track of a
 * com.syu.media player, or the station of the radio / the song of BT audio. Built where the data
 * is read and handed over as it is, so NotificationListener never reads a file or asks a
 * player for it.
 */
public final class StockTrack {

    public final StockKindArbiter.Kind kind;
    /**
     * Identifies the track: the file's path or the stream's URL for a com.syu.media player,
     * "stock-radio:/" + frequency, "stock-bt:/" + hash of the tags. It is what the widget saves
     * the cover under, so it is never empty.
     */
    public final String key;
    public final String title;
    public final String artist;
    public final String album;
    /** 0 for a source without an end (the radio): the widget then shows "Live". */
    public final long durationMs;
    public final long positionMs;
    public final boolean playing;
    /** Whether {@link #key} is a file of this device, whose tags and name can be read. */
    public final boolean localFile;
    /** An image file's bytes (PNG, JPEG), or null for the widget's default cover. Not copied. */
    public final byte[] cover;
    /** The favorite flag; null when the source has none or it is not known (the heart is grey). */
    public final Boolean favorite;

    public StockTrack(StockKindArbiter.Kind kind, String key, String title, String artist,
            String album, long durationMs, long positionMs, boolean playing, boolean localFile,
            byte[] cover, Boolean favorite) {
        this.kind = Objects.requireNonNull(kind);
        this.key = key != null ? key : "";
        this.title = title != null ? title : "";
        this.artist = artist != null ? artist : "";
        this.album = album != null ? album : "";
        this.durationMs = Math.max(durationMs, 0);
        this.positionMs = Math.max(positionMs, 0);
        this.playing = playing;
        this.localFile = localFile;
        this.cover = cover;
        this.favorite = favorite;
    }

    public StockTrack withPlaying(boolean playing) {
        return new StockTrack(kind, key, title, artist, album, durationMs, positionMs, playing,
                localFile, cover, favorite);
    }

    /** Same track, text and play state; the position is left out, it moves every second. */
    public boolean sameShown(StockTrack o) {
        return o != null && kind == o.kind && playing == o.playing && durationMs == o.durationMs
                && key.equals(o.key) && title.equals(o.title) && artist.equals(o.artist)
                && album.equals(o.album) && Arrays.equals(cover, o.cover)
                && Objects.equals(favorite, o.favorite);
    }

    @Override
    public String toString() {
        return kind + " " + (playing ? "playing" : "paused") + " '" + title + "' / '" + artist
                + "' " + positionMs + "/" + durationMs + "ms " + key;
    }
}
