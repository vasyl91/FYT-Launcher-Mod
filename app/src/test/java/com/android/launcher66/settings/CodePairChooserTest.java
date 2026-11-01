package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusLibrary.CarCodes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CodePairChooserTest {

    private static final CarCodes NEW = new CarCodes(102, 103);
    private static final CarCodes OLD = new CarCodes(91, 92);

    private static CodePairChooser chooser() {
        return new CodePairChooser(Arrays.asList(NEW, OLD));
    }

    /** n values of a fuel code that differ (and a few "no value" among them). */
    private static void feedFuel(CodePairChooser c, int code, int n) {
        for (int i = 0; i < n; i++) {
            c.onValue(code, i % 4 == 3 ? CodePairChooser.NO_VALUE : 60 + i);
        }
    }

    private static void feedRange(CodePairChooser c, int code, int n) {
        for (int i = 0; i < n; i++) {
            c.onValue(code, 300 - 10 * (i / 2));
        }
    }

    private static CodePairChooser.Status st(CodePairChooser c) {
        return c.status();
    }

    // ---- the radios

    @Test
    void aRadioWithTheOldModuleKeepsTheOldPair() {
        CodePairChooser c = chooser();
        // 102/103 say nothing but 0, 91/92 are alive
        for (int i = 0; i < 30; i++) {
            c.onValue(102, 0);
            c.onValue(103, 0);
        }
        feedFuel(c, 91, 12);
        feedRange(c, 92, 12);
        CodePairChooser.Status s = st(c);
        assertEquals(1, s.index);
        assertTrue(s.confirmed);
        assertEquals(OLD, s.pair());
    }

    @Test
    void aRadioWithTheNewModuleUsesTheNewPair() {
        CodePairChooser c = chooser();
        feedFuel(c, 102, 12);
        CodePairChooser.Status s = st(c);
        assertEquals(0, s.index);
        assertTrue(s.confirmed);
        assertEquals(NEW, s.pair());
    }

    @Test
    void whenBothPairsLiveTheFirstWins() {
        CodePairChooser c = chooser();
        for (int i = 0; i < 20; i++) {
            c.onValue(102, 60 + i);
            c.onValue(91, 70 + i);
        }
        CodePairChooser.Status s = st(c);
        assertEquals(0, s.index);
        assertTrue(s.confirmed);
        // and it stays, though the other pair goes on
        for (int i = 0; i < 20; i++) {
            c.onValue(91, 100 + i);
        }
        assertEquals(0, st(c).index);
    }

    @Test
    void theRangeCodeAloneConfirmsAPair() {
        CodePairChooser c = chooser();
        feedRange(c, 92, 12);
        assertEquals(1, st(c).index);
        assertTrue(st(c).confirmed);
    }

    // ---- before a pair is confirmed

    @Test
    void beforeAnythingIsReliableTheFirstPairIsShownUnconfirmed() {
        CodePairChooser c = chooser();
        assertEquals(0, st(c).index);
        assertFalse(st(c).confirmed);
        for (int i = 0; i < 50; i++) {
            c.onValue(102, 0);
            c.onValue(91, 0);
            c.onValue(92, 0);
        }
        assertEquals(0, st(c).index);
        assertFalse(st(c).confirmed);
    }

    @Test
    void theFirstPairThatGaveAReliableValueIsShownBeforeTheConfirmation() {
        CodePairChooser c = chooser();
        c.onValue(102, 0);
        c.onValue(92, 310);
        assertEquals(1, st(c).index);
        assertFalse(st(c).confirmed);
        // 5 more are not enough
        feedRange(c, 92, 5);
        assertEquals(1, st(c).index);
        assertFalse(st(c).confirmed);
        // a pair earlier in the list that gave a value takes the display
        c.onValue(102, 85);
        assertEquals(0, st(c).index);
        assertFalse(st(c).confirmed);
    }

    @Test
    void sameValuesAreNotEnoughToConfirm() {
        CodePairChooser c = chooser();
        for (int i = 0; i < 40; i++) {
            c.onValue(92, 300);
        }
        assertFalse(st(c).confirmed);
        assertEquals(1, st(c).index);       // it is alive, so it is the one shown
        c.onValue(92, 290);
        assertTrue(st(c).confirmed);
    }

    @Test
    void noValueCountsAsAliveForTheFuelCodeButNotForTheRange() {
        CodePairChooser c = chooser();
        // 65535 only: alive but never two different values
        for (int i = 0; i < 40; i++) {
            c.onValue(91, CodePairChooser.NO_VALUE);
        }
        assertFalse(st(c).confirmed);
        assertEquals(1, st(c).index);
        // one real value among them makes two different ones
        c.onValue(91, 75);
        assertTrue(st(c).confirmed);
        // the range code: 65535 says nothing
        CodePairChooser r = chooser();
        for (int i = 0; i < 40; i++) {
            r.onValue(92, CodePairChooser.NO_VALUE);
        }
        assertFalse(st(r).confirmed);
        assertEquals(0, st(r).index);
    }

    @Test
    void theLimitsOfAReliableValue() {
        CodePairChooser c = new CodePairChooser(Arrays.asList(new CarCodes(5, 6)));
        // fuel: 1..3000
        for (int i = 0; i < 30; i++) {
            c.onValue(5, i % 2 == 0 ? 3001 : 0);
        }
        assertFalse(st(c).confirmed);
        assertEquals(0, st(c).index);
        for (int i = 0; i < 12; i++) {
            c.onValue(5, i % 2 == 0 ? 3000 : 1);
        }
        assertTrue(st(c).confirmed);
        // range: 1..2000
        CodePairChooser r = new CodePairChooser(Arrays.asList(new CarCodes(5, 6)));
        for (int i = 0; i < 30; i++) {
            r.onValue(6, i % 2 == 0 ? 2001 : 0);
        }
        assertFalse(st(r).confirmed);
        for (int i = 0; i < 12; i++) {
            r.onValue(6, i % 2 == 0 ? 2000 : 1);
        }
        assertTrue(st(r).confirmed);
    }

    @Test
    void aCodeOfZeroIsNeverTracked() {
        CodePairChooser c = new CodePairChooser(Arrays.asList(new CarCodes(0, 5), new CarCodes(-1, 77)));
        assertEquals(new java.util.LinkedHashSet<>(Arrays.asList(5, 77)), c.codes());
        for (int i = 0; i < 30; i++) {
            c.onValue(0, 60 + i);
        }
        assertFalse(st(c).confirmed);
        feedRange(c, 77, 12);
        assertEquals(1, st(c).index);
        assertTrue(st(c).confirmed);
    }

    @Test
    void theCodesOfAllThePairsAreRegistered() {
        assertEquals(new java.util.LinkedHashSet<>(Arrays.asList(102, 103, 91, 92)), chooser().codes());
    }

    // ---- changing the pair

    private static CodePairChooser bothConfirmedFirstChosen() {
        CodePairChooser c = chooser();
        for (int i = 0; i < 20; i++) {
            c.onValue(102, 60 + i);
            c.onValue(91, 70 + i);
        }
        assertEquals(0, st(c).index);
        return c;
    }

    /** Drives for {@code ms}, a tick every second. */
    private static boolean drive(CodePairChooser c, long fromMs, long ms) {
        boolean changed = false;
        for (long t = fromMs; t <= fromMs + ms; t += 1000) {
            changed |= c.onDriving(t, true);
        }
        return changed;
    }

    @Test
    void theChosenPairIsReplacedAfterTenMinutesOfDrivingWithoutAValue() {
        CodePairChooser c = bothConfirmedFirstChosen();
        c.onDriving(0, true);
        assertFalse(drive(c, 1000, 9 * 60_000L));          // 9 minutes: not yet
        assertEquals(0, st(c).index);
        c.onValue(91, 200);                                  // the other pair goes on, the chosen one is silent
        assertTrue(drive(c, 9 * 60_000L + 2000, 90_000L));
        assertEquals(1, st(c).index);
        assertTrue(st(c).confirmed);
    }

    @Test
    void aValueOfTheChosenPairStartsTheTimeAgain() {
        CodePairChooser c = bothConfirmedFirstChosen();
        c.onDriving(0, true);
        drive(c, 1000, 8 * 60_000L);
        c.onValue(103, 310);                                 // the range of the chosen pair
        assertFalse(drive(c, 8 * 60_000L + 1000, 8 * 60_000L));
        assertEquals(0, st(c).index);
    }

    @Test
    void standingStillIsNotDrivingTime() {
        CodePairChooser c = bothConfirmedFirstChosen();
        for (long t = 0; t < 60 * 60_000L; t += 1000) {
            assertFalse(c.onDriving(t, false));
        }
        assertEquals(0, st(c).index);
    }

    @Test
    void aGapInTheTicksCountsForAtMostFiveSeconds() {
        CodePairChooser c = bothConfirmedFirstChosen();
        c.onDriving(0, true);
        // a service that was off for hours
        assertFalse(c.onDriving(5 * 60 * 60_000L, true));
        assertEquals(0, st(c).index);
    }

    @Test
    void theChosenPairStaysWhenNoOtherPairIsConfirmed() {
        CodePairChooser c = chooser();
        feedFuel(c, 102, 12);
        c.onValue(91, 80);                                   // alive, not confirmed
        c.onDriving(0, true);
        assertFalse(drive(c, 1000, 30 * 60_000L));
        assertEquals(0, st(c).index);
        assertTrue(st(c).confirmed);
    }

    // ---- the saved choice

    @Test
    void aSavedChoiceIsInUseAtOnceAndStaysWhileItLives() {
        CodePairChooser c = chooser();
        assertTrue(c.restore(OLD));
        assertEquals(1, st(c).index);
        assertTrue(st(c).confirmed);
        // the first pair is alive too: the saved one stays
        for (int i = 0; i < 30; i++) {
            c.onValue(102, 60 + i);
            c.onValue(91, 70 + i);
        }
        assertEquals(1, st(c).index);
    }

    @Test
    void aSavedPairTheLibraryNoLongerHasIsIgnored() {
        CodePairChooser c = chooser();
        assertFalse(c.restore(new CarCodes(5, 6)));
        assertEquals(0, st(c).index);
        assertFalse(st(c).confirmed);
    }

    @Test
    void theChoiceIsWrittenAndReadBack() {
        assertEquals("1:91/92", CodePairChooser.encode(1, OLD));
        assertEquals(OLD, CodePairChooser.decode("1:91/92"));
        assertEquals(new CarCodes(-1, 77), CodePairChooser.decode("0:-/77"));
        assertEquals(new CarCodes(98, -1), CodePairChooser.decode(CodePairChooser.encode(2, new CarCodes(98, -1))));
        assertNull(CodePairChooser.decode(null));
        assertNull(CodePairChooser.decode(""));
        assertNull(CodePairChooser.decode("91/92"));
        assertNull(CodePairChooser.decode("1:-/-"));
        assertNull(CodePairChooser.decode("1:91/92/93"));
        assertEquals("code_pair_1507667", CodePairChooser.key(1507667));
    }

    @Test
    void theStatusListsThePairs() {
        List<CarCodes> pairs = Arrays.asList(NEW, OLD, new CarCodes(-1, 77));
        CodePairChooser.Status s = new CodePairChooser(pairs).status();
        assertEquals("102/103, 91/92, -/77", s.pairsText());
    }

    @Test
    void onValueReportsWhenTheChoiceChanges() {
        CodePairChooser c = chooser();
        assertFalse(c.onValue(102, 0));
        assertTrue(c.onValue(92, 300));        // the first reliable value is the second pair's: the display moves
        assertFalse(c.onValue(92, 300));
        boolean changed = false;
        for (int i = 0; i < 12; i++) {
            changed |= c.onValue(92, 290 - 10 * i);
        }
        assertTrue(changed);                    // confirmed
        assertFalse(c.onValue(92, 100));
    }
}
