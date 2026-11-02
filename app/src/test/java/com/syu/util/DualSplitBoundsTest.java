package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DualSplitBoundsTest {

    @Test
    void aWidePipKeepsTheQuarterLimits() {
        // minimum pane 300 is far below a quarter of 2000
        assertArrayEquals(new int[] {500, 1500}, DualSplitBounds.leftRange(2000, 300));
        assertEquals(1000, DualSplitBounds.leftWidth(2000, 0.5f, 300));
        assertEquals(500, DualSplitBounds.leftWidth(2000, 0.1f, 300));
        assertEquals(1500, DualSplitBounds.leftWidth(2000, 0.9f, 300));
    }

    @Test
    void aPipCutToItsMinimumKeepsBothPanesAtLeastTheMinimumPane() {
        int total = 1056; // two panes of 528
        for (float ratio : new float[] {0.25f, 0.4f, 0.5f, 0.6f, 0.75f}) {
            int left = DualSplitBounds.leftWidth(total, ratio, 528);
            assertTrue(left >= 528 && total - left >= 528, ratio + " -> " + left);
        }
        // a quarter of 1200 is 300, the minimum pane 528 wins on both sides
        assertArrayEquals(new int[] {528, 672}, DualSplitBounds.leftRange(1200, 528));
        assertEquals(528, DualSplitBounds.leftWidth(1200, 0.25f, 528));
        assertEquals(672, DualSplitBounds.leftWidth(1200, 0.75f, 528));
    }

    @Test
    void withNoRoomForTwoMinimumPanesEachGetsHalf() {
        assertArrayEquals(new int[] {400, 400}, DualSplitBounds.leftRange(800, 600));
        assertEquals(400, DualSplitBounds.leftWidth(800, 0.3f, 600));
        assertEquals(400, DualSplitBounds.leftWidth(800, 0.7f, 600));
        int odd = DualSplitBounds.leftWidth(801, 0.5f, 600);
        assertTrue(odd == 400 || odd == 401);
    }

    @Test
    void theSavedProportionIsNotAffectedByTheLimit() {
        float saved = 0.7f;
        // squeezed: the applied width is limited, the proportion the caller holds is not
        assertEquals(672, DualSplitBounds.leftWidth(1200, saved, 528));
        // widened again: the same proportion gives the user's split back
        assertEquals(1400, DualSplitBounds.leftWidth(2000, saved, 528));
        assertEquals(0.7f, saved);
    }
}
