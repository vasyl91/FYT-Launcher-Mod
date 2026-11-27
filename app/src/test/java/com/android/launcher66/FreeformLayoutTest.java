package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FreeformLayoutTest {

    private static void drawnInItsFrame(int left, int top, int w, int h, float scale) {
        int[] drawn = FreeformLayout.of(left, top, w, h, scale).drawn();
        assertTrue(Math.abs(drawn[0] - left) <= 1, "left " + drawn[0] + " for " + left + " at " + scale);
        assertTrue(Math.abs(drawn[1] - top) <= 1, "top " + drawn[1] + " for " + top + " at " + scale);
        assertTrue(Math.abs(drawn[2] - w) <= 2, "width " + drawn[2] + " for " + w + " at " + scale);
        assertTrue(Math.abs(drawn[3] - h) <= 2, "height " + drawn[3] + " for " + h + " at " + scale);
    }

    @Test
    void aWidgetIsDrawnExactlyInItsFrameOnAnFytUnitAndOnAPhone() {
        drawnInItsFrame(258, 1308, 447, 643, 0.84f);   // the A55's widget of the owner's log
        drawnInItsFrame(107, 768, 543, 731, 0.84f);
        drawnInItsFrame(400, 120, 700, 420, 1.75f);   // an FYT unit
        drawnInItsFrame(0, 0, 1, 1, 1.75f);
        drawnInItsFrame(31, 47, 333, 222, 1f);
    }

    @Test
    void itIsLaidOutAtTheFramesSizeDividedByTheScale() {
        FreeformLayout layout = FreeformLayout.of(400, 120, 700, 420, 1.75f);
        assertEquals(400, layout.x);
        assertEquals(120, layout.y);
        assertEquals(400, layout.width);
        assertEquals(240, layout.height);
        assertEquals(1.75f, layout.scale, 0f);
    }

    @Test
    void withoutAScaleTheLayoutIsTheFrame() {
        FreeformLayout layout = FreeformLayout.of(10, 20, 300, 200, 1f);
        assertArrayEquals(new int[] {10, 20, 300, 200}, new int[] {layout.x, layout.y, layout.width, layout.height});
        assertEquals(0f, layout.translationX, 0f);
        assertEquals(0f, layout.translationY, 0f);
    }

    @Test
    void theProviderIsToldTheLaidOutSizeInDp() {
        assertArrayEquals(new int[] {267, 160}, FreeformLayout.of(0, 0, 700, 420, 1.75f).sizeDp(1.5f));
    }
}
