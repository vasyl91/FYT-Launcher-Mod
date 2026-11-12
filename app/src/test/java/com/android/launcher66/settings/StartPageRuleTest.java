package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StartPageRuleTest {

    @Test
    void everyExistingPageIsAccepted() {
        assertTrue(StartPageRule.accepts(1, 3));
        assertTrue(StartPageRule.accepts(3, 3));
    }

    @Test
    void aPagePastTheLastOneIsRefused() {
        assertFalse(StartPageRule.accepts(4, 3));
        assertFalse(StartPageRule.accepts(99, 3));
    }

    @Test
    void zeroAndNegativeNumbersAreRefused() {
        assertFalse(StartPageRule.accepts(0, 3));
        assertFalse(StartPageRule.accepts(-1, 3));
    }

    @Test
    void theFirstPageIsAlwaysThereEvenBeforeThePagesAreKnown() {
        assertTrue(StartPageRule.accepts(1, 0));
        assertFalse(StartPageRule.accepts(2, 0));
    }

    @Test
    void aStoredPageThatExistsIsUsed() {
        assertEquals(2, StartPageRule.effective("2", 3));
        assertEquals(3, StartPageRule.effective(" 3 ", 3));
    }

    @Test
    void aStoredPageThatIsGoneMeansTheFirstPage() {
        assertEquals(1, StartPageRule.effective("9", 3));
    }

    @Test
    void aBrokenOrMissingValueMeansTheFirstPage() {
        assertEquals(1, StartPageRule.effective(null, 3));
        assertEquals(1, StartPageRule.effective("", 3));
        assertEquals(1, StartPageRule.effective("abc", 3));
        assertEquals(1, StartPageRule.effective("2.5", 3));
    }

    @Test
    void thePagesAnElementWillCreateCount() {
        assertEquals(4, StartPageRule.knownPages(3, 4));
        assertEquals(3, StartPageRule.knownPages(3, 2));
        assertEquals(1, StartPageRule.knownPages(0, 0));
    }
}
