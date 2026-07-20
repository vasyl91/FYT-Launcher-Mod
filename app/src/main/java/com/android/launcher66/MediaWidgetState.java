package com.android.launcher66;

import java.util.Arrays;

public final class MediaWidgetState {
    public static final String SOURCE_MEDIA_CONTROLLER = "mediaController";

    private static Snapshot sSnapshot;

    private MediaWidgetState() {
    }

    public static synchronized void updateExternal(
            String title,
            String artist,
            String album,
            String packageName,
            boolean playing,
            long totalMs,
            long positionMs,
            byte[] albumArt
    ) {
        Snapshot previous = sSnapshot;
        byte[] albumArtForSnapshot;
        if (albumArt == null) {
            albumArtForSnapshot = null;
        } else if (previous != null && Arrays.equals(previous.albumArt, albumArt)) {
            albumArtForSnapshot = previous.albumArt;
        } else {
            albumArtForSnapshot = Arrays.copyOf(albumArt, albumArt.length);
        }

        Snapshot next = new Snapshot(
                SOURCE_MEDIA_CONTROLLER,
                safe(title),
                safe(artist),
                safe(album),
                safe(packageName),
                playing,
                Math.max(0L, totalMs),
                Math.max(0L, positionMs),
                albumArtForSnapshot,
                System.currentTimeMillis()
        );
        sSnapshot = next;
    }

    public static synchronized void clearExternal() {
        if (sSnapshot != null && SOURCE_MEDIA_CONTROLLER.equals(sSnapshot.source)) {
            sSnapshot = null;
        }
    }

    public static synchronized Snapshot getExternalSnapshot() {
        if (sSnapshot == null || !SOURCE_MEDIA_CONTROLLER.equals(sSnapshot.source)) {
            return null;
        }
        return sSnapshot;
    }

    private static String safe(String value) {
        return value == null || "null".equals(value) ? "" : value;
    }

    public static final class Snapshot {
        public final String source;
        public final String title;
        public final String artist;
        public final String album;
        public final String packageName;
        public final boolean playing;
        public final long totalMs;
        public final long positionMs;
        public final byte[] albumArt;
        public final long updatedAtMs;

        private Snapshot(
                String source,
                String title,
                String artist,
                String album,
                String packageName,
                boolean playing,
                long totalMs,
                long positionMs,
                byte[] albumArt,
                long updatedAtMs
        ) {
            this.source = source;
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.packageName = packageName;
            this.playing = playing;
            this.totalMs = totalMs;
            this.positionMs = positionMs;
            this.albumArt = albumArt;
            this.updatedAtMs = updatedAtMs;
        }

        public boolean hasContent() {
            return !title.isEmpty() || !artist.isEmpty() || !album.isEmpty() || !packageName.isEmpty();
        }
    }
}
