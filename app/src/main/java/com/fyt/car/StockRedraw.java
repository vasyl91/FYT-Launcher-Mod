package com.fyt.car;

import java.util.Arrays;

/**
 * Whether a stock source's new publication has to be drawn by the music widget again. Pure, so that
 * the rule has a test.
 *
 * <p>The widget draws its icon and cover only when it is told to (NotificationListener.fytStatus()),
 * and a BT song announces its title long before its cover arrives, so the cover, the play state and
 * the other fields must each cause a redraw by themselves. The position moves every second and
 * matters only while the source plays, which is also what the 500 ms loop of the widget draws.
 */
public final class StockRedraw {

    private StockRedraw() {
    }

    public static boolean needsRedraw(StockTrack prev, StockTrack next) {
        if (next == null) {
            return false;
        }
        if (prev == null) {
            return true;
        }
        if (prev.playing != next.playing
                || prev.kind != next.kind
                || prev.durationMs != next.durationMs
                || !prev.title.equals(next.title)
                || !prev.artist.equals(next.artist)
                || !prev.album.equals(next.album)
                || !Arrays.equals(prev.cover, next.cover)) {
            return true;
        }
        return prev.positionMs != next.positionMs && next.playing;
    }
}
