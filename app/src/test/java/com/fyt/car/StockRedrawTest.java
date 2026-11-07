package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockRedrawTest {

    private static StockTrack track(String title, String artist, String album, long duration,
            long position, boolean playing, byte[] cover, StockKindArbiter.Kind kind) {
        return new StockTrack(kind, "stock-bt:/1", title, artist, album, duration, position, playing,
                false, cover, null);
    }

    private static StockTrack base() {
        return track("T", "A", "B", 1000, 10, false, null, StockKindArbiter.Kind.MEDIA_BT);
    }

    @Test
    void nothingBeforeIsDrawn() {
        assertTrue(StockRedraw.needsRedraw(null, base()));
    }

    @Test
    void sameTrackIsNotDrawnAgain() {
        assertFalse(StockRedraw.needsRedraw(base(), base()));
    }

    @Test
    void playStateCoverAndTextsEachCauseARedraw() {
        StockTrack b = base();
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A", "B", 1000, 10, true, null, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A", "B", 1000, 10, false, new byte[] {1}, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T2", "A", "B", 1000, 10, false, null, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A2", "B", 1000, 10, false, null, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A", "B2", 1000, 10, false, null, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A", "B", 2000, 10, false, null, b.kind)));
        assertTrue(StockRedraw.needsRedraw(b, track("T", "A", "B", 1000, 10, false, null,
                StockKindArbiter.Kind.RADIO)));
    }

    @Test
    void positionAloneMattersOnlyWhilePlaying() {
        StockTrack pausedBefore = base();
        assertFalse(StockRedraw.needsRedraw(pausedBefore,
                track("T", "A", "B", 1000, 20, false, null, pausedBefore.kind)));
        StockTrack playingBefore = track("T", "A", "B", 1000, 10, true, null, pausedBefore.kind);
        assertTrue(StockRedraw.needsRedraw(playingBefore,
                track("T", "A", "B", 1000, 20, true, null, pausedBefore.kind)));
    }
}
