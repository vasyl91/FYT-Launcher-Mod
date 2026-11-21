package com.android.launcher66;

import android.media.MediaMetadataRetriever;
import android.util.Log;

/**
 * The picture in a track's file as com.syu.media reads it (MediaMetadataRetriever.getEmbeddedPicture()): mp3, FLAC,
 * M4A and the rest the platform reads, with a picture of any format. The launcher's own ID3 reader (Lrc) knows mp3
 * with a JPEG only. Used for the 7870's player (StockSources.isSyuMediaUnit()); off the main thread only.
 */
final class FileCover {

    private static final String TAG = "MusicCover";

    /** A read: the picture (null for none) and whether the file could be opened at all (FileCoverRetry). */
    static final class Result {
        final byte[] picture;
        final boolean opened;

        Result(byte[] picture, boolean opened) {
            this.picture = picture;
            this.opened = opened;
        }
    }

    private FileCover() {
    }

    static Result read(String path) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            try {
                retriever.setDataSource(path);
            } catch (RuntimeException e) {
                Log.i(TAG, "file cover " + path + ": not opened (" + e.getClass().getSimpleName() + ")");
                return new Result(null, false);
            }
            byte[] picture = null;
            try {
                picture = retriever.getEmbeddedPicture();
            } catch (RuntimeException e) {
                Log.w(TAG, "file cover " + path + ": unreadable", e);
            }
            Log.i(TAG, "file cover " + path + ": " + (picture != null ? picture.length + " bytes" : "none"));
            return new Result(picture, true);
        } finally {
            try {
                retriever.release();
            } catch (Exception ignored) {
                // Released or never opened: nothing to give back
            }
        }
    }
}
