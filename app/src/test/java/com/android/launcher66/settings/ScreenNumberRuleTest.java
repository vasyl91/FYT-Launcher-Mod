package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScreenNumberRuleTest {

    @Test
    void aNumberPastTheLastScreenGivesOneNewScreen() {
        // From the log: five screens, the other elements end on page 4.
        assertEquals(6, ScreenNumberRule.target(6, 5, 4));
        assertEquals(6, ScreenNumberRule.target(9, 5, 4));
        assertEquals(6, ScreenNumberRule.target(99, 5, 0));
    }

    @Test
    void aNumberOnAnExistingScreenIsKept() {
        assertEquals(3, ScreenNumberRule.target(3, 5, 4));
        assertEquals(5, ScreenNumberRule.target(5, 5, 4));
    }

    @Test
    void anElementBeyondTheSnapshotCountsAsAScreen() {
        assertEquals(7, ScreenNumberRule.target(9, 5, 6));
        assertEquals(6, ScreenNumberRule.target(6, 5, 7));
    }

    @Test
    void musicOnTheFirstNewPageIsKept() {
        assertEquals(4, ScreenNumberRule.target(4, 3, 3));
    }

    @Test
    void aPipRightAfterItIsKept() {
        // Music is already on page 4.
        assertEquals(5, ScreenNumberRule.target(5, 3, 4));
    }

    @Test
    void aPipFurtherOutComesRightAfterIt() {
        assertEquals(5, ScreenNumberRule.target(8, 3, 4));
    }
}
