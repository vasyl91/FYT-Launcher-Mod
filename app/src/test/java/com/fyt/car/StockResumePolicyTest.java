package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockResumePolicyTest {

    private static final long NOW = 100_000L;

    @Test
    void aPlayerThatPlayedUntilTheChannelWentIsStartedAgain() {
        // playing 0.5 s before the channel went, back after 1.5 s
        long leftAt = NOW - 1500;
        assertTrue(StockResumePolicy.shouldResume(leftAt - 500, leftAt, NOW, 0));
    }

    @Test
    void aPlayerSeenPlayingJustAfterTheChannelWentCountsToo() {
        // a read taken a moment before it paused, delivered after
        long leftAt = NOW - 1000;
        assertTrue(StockResumePolicy.shouldResume(leftAt + 200, leftAt, NOW, 0));
    }

    @Test
    void aPlayerThatWasAlreadyStoppedIsLeftAlone() {
        long leftAt = NOW - 1000;
        assertFalse(StockResumePolicy.shouldResume(leftAt - 3001, leftAt, NOW, 0));
        assertTrue(StockResumePolicy.shouldResume(leftAt - 3000, leftAt, NOW, 0));
    }

    @Test
    void aPlayerThatNeverPlayedIsLeftAlone() {
        assertFalse(StockResumePolicy.shouldResume(0, NOW - 1000, NOW, 0));
    }

    @Test
    void aChannelThatNeverWentMeansNothingToResume() {
        assertFalse(StockResumePolicy.shouldResume(NOW - 500, 0, NOW, 0));
    }

    @Test
    void aChannelBackAfterTenSecondsIsNoRebuildsDoing() {
        long leftAt = NOW - 10_000;
        assertFalse(StockResumePolicy.shouldResume(leftAt - 100, leftAt, NOW, 0));
        assertTrue(StockResumePolicy.shouldResume(leftAt - 100, leftAt + 1, NOW, 0));
    }

    @Test
    void aPauseOfTheUserAroundTheLeavingIsRespected() {
        long leftAt = NOW - 2000;
        long playedAt = leftAt - 1000;
        // pressed in the launcher after it last played
        assertFalse(StockResumePolicy.shouldResume(playedAt, leftAt, NOW, playedAt + 500));
        // pressed just after the channel went
        assertFalse(StockResumePolicy.shouldResume(playedAt, leftAt, NOW, leftAt + 300));
    }

    @Test
    void anOlderPauseBelongsToAnEarlierListening() {
        long leftAt = NOW - 2000;
        long playedAt = leftAt - 1000;
        // paused a minute ago, played again since
        assertTrue(StockResumePolicy.shouldResume(playedAt, leftAt, NOW, NOW - 60_000));
    }
}
