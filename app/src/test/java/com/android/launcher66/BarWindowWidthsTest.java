package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarWindowWidthsTest {

    @Test
    void withTheButtonShownTheUsualWidthsStay() {
        assertArrayEquals(new int[] {118, 950}, BarWindowWidths.plain(118, 950, false));
    }

    @Test
    void aHiddenButtonHasNoRoomAndTheAppsGetIt() {
        assertArrayEquals(new int[] {0, 1068}, BarWindowWidths.plain(118, 950, true));
    }

    @Test
    void theWidgetBarsWindowTakesThePagesShares() {
        // Landscape, the drawer button hidden: BarShares gives its room to the apps and the music widget
        BarShares.Result shares = BarShares.of(false, true, false, WidgetBarPlan.usualApps(false), false, false, false);
        int[] widths = BarWindowWidths.shared(2000, shares);
        assertEquals(0, widths[0], "the button has no room");
        assertEquals(Math.round(2000 * shares.share(BarShares.Element.APPS)), widths[1]);
        assertEquals(Math.round(2000 * shares.share(BarShares.Element.MUSIC)), widths[2]);
        assertTrue(widths[1] > Math.round(2000 * WidgetBarPlan.usualApps(false)), "the apps list is wider than usual");
    }

    @Test
    void aHiddenMusicWidgetHasNoRoomInTheWindow() {
        BarShares.Result shares = BarShares.of(true, false, false, WidgetBarPlan.usualApps(true), true, false, false);
        int[] widths = BarWindowWidths.shared(1080, shares);
        assertEquals(0, widths[2]);
        assertTrue(widths[0] > 0, "the button stays");
    }
}
