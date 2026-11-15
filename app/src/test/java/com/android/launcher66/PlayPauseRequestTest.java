package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayPauseRequestTest {

    private final PlayPauseRequest request = new PlayPauseRequest();

    @Test
    void aTapShowsTheOppositeSymbolAtOnce() {
        assertTrue(request.tap(1000, true));
        assertFalse(request.showsPlaying(1000, true));
    }

    @Test
    void aRedrawBeforeThePlayerAnswersKeepsTheTapsSymbol() {
        // 7862, 17:34:51: the redraw at 500 ms still read the session as playing
        request.tap(1000, true);
        assertFalse(request.showsPlaying(1500, true));
        assertFalse(request.showsPlaying(2400, true));
    }

    @Test
    void thePlayersAnswerEndsTheWait() {
        request.tap(1000, true);
        assertFalse(request.showsPlaying(1800, false));
        // From then on the player's own state is shown, whatever it is
        assertTrue(request.showsPlaying(1900, true));
    }

    @Test
    void withoutAnAnswerThePlayersStateComesBackAfterTheHold() {
        request.tap(1000, true);
        assertTrue(request.showsPlaying(1000 + PlayPauseRequest.HOLD_MS, true));
    }

    @Test
    void aSecondTapWhileTheFirstWaitsIsNotTaken() {
        assertTrue(request.tap(1000, true));
        assertFalse(request.tap(1300, true));
        assertFalse(request.showsPlaying(1300, true));
    }

    @Test
    void aTapAfterTheAnswerIsTaken() {
        request.tap(1000, true);
        assertTrue(request.tap(1700, false));   // paused at 1700: the play is taken
        assertTrue(request.showsPlaying(1700, false));
    }
}
