package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScreenScaleTest {

    @Test
    void thePhoneTheToggleWasTunedOnKeepsItsSize() {
        // 40 dp at 450 dpi on a 1080 px wide screen.
        assertEquals(113, ScreenScale.referencePx(40f, 1080));
        assertEquals(23, ScreenScale.referencePx(8f, 1080));
    }

    @Test
    void theSameShareOfTheShorterSideOnOtherScreens() {
        assertEquals(125, ScreenScale.referencePx(40f, 1200));
        assertEquals(75, ScreenScale.referencePx(40f, 720));
    }
}
