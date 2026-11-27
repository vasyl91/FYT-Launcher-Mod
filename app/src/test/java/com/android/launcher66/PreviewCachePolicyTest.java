package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PreviewCachePolicyTest {

    private static final long MB = 1024 * 1024;

    @Test
    void theBudgetIsASixteenthOfTheProcesssMemory() {
        assertEquals(16 * MB, PreviewCachePolicy.budgetBytes(256 * MB));
        assertEquals(32 * MB, PreviewCachePolicy.budgetBytes(512 * MB));
    }

    @Test
    void aSmallProcessStillKeepsAPageOfPreviews() {
        assertEquals(PreviewCachePolicy.MIN_BYTES, PreviewCachePolicy.budgetBytes(16 * MB));
        assertEquals(PreviewCachePolicy.MIN_BYTES, PreviewCachePolicy.budgetBytes(0));
    }

    @Test
    void aHugeProcessDoesNotOverflowTheBudget() {
        assertEquals(Integer.MAX_VALUE, PreviewCachePolicy.budgetBytes(Long.MAX_VALUE));
    }

    @Test
    void theSameWidgetAtAnotherSizeIsAnotherPreview() {
        assertNotEquals(PreviewCachePolicy.key("300x200", "Widget:a/b"), PreviewCachePolicy.key("600x400", "Widget:a/b"));
        assertEquals(PreviewCachePolicy.key("300x200", "Widget:a/b"), PreviewCachePolicy.key("300x200", "Widget:a/b"));
    }

    @Test
    void fromRunningLowOnNothingIsKept() {
        for (int level : new int[] {10, 15, 20, 40, 60, 80}) {
            assertEquals(0, PreviewCachePolicy.keepAfterTrim(level, 1000), "level " + level);
        }
    }

    @Test
    void atRunningModerateHalfIsKeptAndBelowItEverything() {
        assertEquals(500, PreviewCachePolicy.keepAfterTrim(5, 1000));
        assertEquals(1000, PreviewCachePolicy.keepAfterTrim(0, 1000));
    }
}
