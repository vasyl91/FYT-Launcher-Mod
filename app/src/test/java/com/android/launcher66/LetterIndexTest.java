package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LetterIndexTest {

    @Test
    void aTitleIsFiledUnderItsFirstLetterInCapitalsWithoutAccents() {
        assertEquals("A", LetterIndex.letterOf("Aparat"));
        assertEquals("C", LetterIndex.letterOf("ćma"));
        assertEquals("L", LetterIndex.letterOf("Łódź"));
        assertEquals("E", LetterIndex.letterOf("Élan"));
        assertEquals("O", LetterIndex.letterOf("Øl"));
        assertEquals("Я", LetterIndex.letterOf("яндекс"));
        assertEquals("Α", LetterIndex.letterOf("άλφα"));
    }

    @Test
    void aDigitASymbolOrNothingIsFiledUnderTheHash() {
        assertEquals("#", LetterIndex.letterOf("1Password"));
        assertEquals("#", LetterIndex.letterOf("@home"));
        assertEquals("#", LetterIndex.letterOf("  "));
        assertEquals("#", LetterIndex.letterOf(""));
        assertEquals("#", LetterIndex.letterOf(null));
    }

    @Test
    void blanksBeforeTheLetterAndInvisibleCharactersAreSkipped() {
        assertEquals("B", LetterIndex.letterOf("  Bluetooth"));
        assertEquals("B", LetterIndex.letterOf("​Bluetooth"));
    }

    private static final List<String> TITLES = Arrays.asList(
            "1Password", "Aparat", "Aparat 2", "Ćma", "Calendar", "Chrome", "Zegar", "Żółw");

    @Test
    void theAlphabetIsTheLettersTheListHasInTheOrderTheyAppear() {
        assertEquals(Arrays.asList("#", "A", "C", "Z"), LetterIndex.alphabet(TITLES));
    }

    @Test
    void aLetterHasItsFirstPositionAndAPositionHasItsLetter() {
        assertEquals(0, LetterIndex.positionOf(TITLES, "#"));
        assertEquals(1, LetterIndex.positionOf(TITLES, "A"));
        assertEquals(3, LetterIndex.positionOf(TITLES, "C"));
        assertEquals(6, LetterIndex.positionOf(TITLES, "Z"));
        assertEquals(-1, LetterIndex.positionOf(TITLES, "Q"));
        assertEquals("A", LetterIndex.letterAt(TITLES, 2));
        assertEquals("Z", LetterIndex.letterAt(TITLES, 7));
    }

    @Test
    void thePositionsBeyondTheEndsAreTheNearestEnd() {
        assertEquals("#", LetterIndex.letterAt(TITLES, -5));
        assertEquals("Z", LetterIndex.letterAt(TITLES, 99));
        assertEquals("#", LetterIndex.letterAt(Arrays.<String>asList(), 3));
    }

    @Test
    void aPlaceAlongTheScrollerIsOneOfEqualPartsAndTheEndsHoldTheEndLetters() {
        List<String> alphabet = LetterIndex.alphabet(TITLES);   // # A C Z, a quarter each
        assertEquals("#", LetterIndex.letterAtFraction(alphabet, 0f));
        assertEquals("#", LetterIndex.letterAtFraction(alphabet, 0.24f));
        assertEquals("A", LetterIndex.letterAtFraction(alphabet, 0.26f));
        assertEquals("C", LetterIndex.letterAtFraction(alphabet, 0.6f));
        assertEquals("Z", LetterIndex.letterAtFraction(alphabet, 1f));
        assertEquals("Z", LetterIndex.letterAtFraction(alphabet, 7f));
        assertEquals("#", LetterIndex.letterAtFraction(alphabet, -1f));
        assertNull(LetterIndex.letterAtFraction(Arrays.<String>asList(), 0.5f));
    }

    @Test
    void theMiddleOfALettersPartIsWhereTheHandleStands() {
        List<String> alphabet = LetterIndex.alphabet(TITLES);
        assertEquals(0.125f, LetterIndex.fractionOfLetter(alphabet, "#"), 0.0001f);
        assertEquals(0.875f, LetterIndex.fractionOfLetter(alphabet, "Z"), 0.0001f);
        assertEquals(0f, LetterIndex.fractionOfLetter(alphabet, "Q"), 0.0001f);
    }
}
