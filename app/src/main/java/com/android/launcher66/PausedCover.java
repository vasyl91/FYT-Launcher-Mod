package com.android.launcher66;

/**
 * The picture the music widget shows for the 7870's player (its files, its internet radio) and for BT while they do
 * not play, free of android.* so that it has a test.
 *
 * <p>The rule (2026-11-21, after the 7870 tester's "default picture until the cover or the track changes"): the
 * cover was drawn only while the track played. In a pause, and on a widget built again (back from the settings, a
 * wake), the widget kept the picture saved under the title, or the default one, and nothing gave it the cover again
 * until the player sent a new track. Now, for those sources ({@link #applies}):
 * <ul>
 *   <li>the file's own cover (FileCover), else the one published with the track (BT's, a station's icon), else
 *       the one saved for this very track; none of them: the picture shown stays ({@link #pick});</li>
 *   <li>a widget built again gets the last publication drawn again at once (LauncherMusicWidget).</li>
 * </ul>
 * The other units and sources keep what they did.
 */
public final class PausedCover {

    public enum Pick { FILE, PUBLISHED, SAVED, KEEP }

    private PausedCover() {
    }

    /** Whether the rule is for this publication: the 7870, one of its media sources, and not playing. */
    public static boolean applies(boolean syuMediaUnit, boolean syuMediaKind, boolean playing) {
        return syuMediaUnit && syuMediaKind && !playing;
    }

    public static Pick pick(boolean fileCover, boolean publishedCover, boolean savedForThisTrack) {
        if (fileCover) {
            return Pick.FILE;
        }
        if (publishedCover) {
            return Pick.PUBLISHED;
        }
        return savedForThisTrack ? Pick.SAVED : Pick.KEEP;
    }
}
