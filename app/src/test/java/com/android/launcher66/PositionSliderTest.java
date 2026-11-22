package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PositionSliderTest {

    @Test
    void thePositionAsAShareOfTheLength() {
        assertEquals(500, PositionSlider.value(90_000, 180_000));
        assertEquals(0, PositionSlider.value(0, 180_000));
        assertEquals(1000, PositionSlider.value(200_000, 180_000), "never past the end");
        assertEquals(0, PositionSlider.value(5_000, 0), "no length: nothing to show");
        assertEquals(0, PositionSlider.value(-1, 180_000));
    }

    @Test
    void theEndIsKeptASecondAwaySoThePlayerDoesNotGoToTheNextTrack() {
        assertEquals(90_000, PositionSlider.position(500, 180_000));
        assertEquals(179_000, PositionSlider.position(1000, 180_000));
        assertEquals(179_000, PositionSlider.position(1200, 180_000), "a value past the scale is the end");
        assertEquals(0, PositionSlider.position(-5, 180_000));
        assertEquals(0, PositionSlider.position(1000, 500), "a track shorter than the guard: its start");
        assertEquals(0, PositionSlider.position(300, 0));
    }

    @Test
    void aTrackThatCanBeMovedHasAKnobOneThatCannotShowsWhereItIs() {
        assertEquals(PositionSlider.Mode.SEEK, PositionSlider.mode(180_000, false, true));
        assertEquals(PositionSlider.Mode.SHOW, PositionSlider.mode(180_000, false, false),
                "the position as the thin bar showed it");
    }

    @Test
    void withoutALengthOrForALiveStreamTheBarIsGrey() {
        assertEquals(PositionSlider.Mode.GREY, PositionSlider.mode(0, false, true));
        assertEquals(PositionSlider.Mode.GREY, PositionSlider.mode(-1, false, false));
        assertEquals(PositionSlider.Mode.GREY, PositionSlider.mode(180_000, true, true), "a live stream");
    }

    @Test
    void onlyCom_syu_mediasOwnFilesOnThe7870AreMovedThroughIt() {
        assertTrue(PositionSlider.syuMediaFileSeekable(true, true));
        assertFalse(PositionSlider.syuMediaFileSeekable(true, false), "BT and stations");
        assertFalse(PositionSlider.syuMediaFileSeekable(false, true));
    }
}
