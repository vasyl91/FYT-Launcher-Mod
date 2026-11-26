package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DoubleTapTest {

    private static final long TIMEOUT = 300L;
    private static final float SLOP = 100f;

    @Test
    void twoTapsCloseInTimeAndPlaceAreADoubleTap() {
        DoubleTap tap = new DoubleTap();
        assertFalse(tap.onTap(1000L, 500f, 500f, TIMEOUT, SLOP));
        assertTrue(tap.onTap(1250L, 530f, 480f, TIMEOUT, SLOP));
    }

    @Test
    void aSecondTapTooLateIsTheFirstOfANewPair() {
        DoubleTap tap = new DoubleTap();
        assertFalse(tap.onTap(1000L, 500f, 500f, TIMEOUT, SLOP));
        assertFalse(tap.onTap(1301L, 500f, 500f, TIMEOUT, SLOP));
        // and it pairs with the next one
        assertTrue(tap.onTap(1500L, 500f, 500f, TIMEOUT, SLOP));
    }

    @Test
    void aSecondTapTooFarAwayIsTheFirstOfANewPair() {
        DoubleTap tap = new DoubleTap();
        assertFalse(tap.onTap(1000L, 100f, 100f, TIMEOUT, SLOP));
        assertFalse(tap.onTap(1100L, 400f, 100f, TIMEOUT, SLOP));
        assertTrue(tap.onTap(1200L, 410f, 110f, TIMEOUT, SLOP));
    }

    @Test
    void aThirdTapStartsANewPairAfterADoubleTap() {
        DoubleTap tap = new DoubleTap();
        tap.onTap(1000L, 500f, 500f, TIMEOUT, SLOP);
        assertTrue(tap.onTap(1100L, 500f, 500f, TIMEOUT, SLOP));
        assertFalse(tap.onTap(1200L, 500f, 500f, TIMEOUT, SLOP));
        assertTrue(tap.onTap(1300L, 500f, 500f, TIMEOUT, SLOP));
    }

    @Test
    void aTouchThatBecameASwipeForgetsTheFirstTap() {
        DoubleTap tap = new DoubleTap();
        tap.onTap(1000L, 500f, 500f, TIMEOUT, SLOP);
        tap.reset();
        assertFalse(tap.onTap(1100L, 500f, 500f, TIMEOUT, SLOP));
    }

    @Test
    void aClockThatWentBackIsNotADoubleTap() {
        DoubleTap tap = new DoubleTap();
        tap.onTap(1000L, 500f, 500f, TIMEOUT, SLOP);
        assertFalse(tap.onTap(900L, 500f, 500f, TIMEOUT, SLOP));
    }
}
