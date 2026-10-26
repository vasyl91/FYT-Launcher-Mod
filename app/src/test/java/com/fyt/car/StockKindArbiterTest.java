package com.fyt.car;

import static com.fyt.car.StockKindArbiter.Kind.MEDIA_BT;
import static com.fyt.car.StockKindArbiter.Kind.MEDIA_MUSIC;
import static com.fyt.car.StockKindArbiter.Kind.MEDIA_ONLINE;
import static com.fyt.car.StockKindArbiter.Kind.RADIO;
import static com.fyt.car.StockKindArbiter.Kind.SYU_MUSIC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockKindArbiterTest {

    // ------------------------------------------------------------------ 7862 / 8581: com.syu.music

    @Test
    void aSyuMusicUnitStartsOnSyuMusic() {
        StockKindArbiter a = new StockKindArbiter(false, 0);
        assertEquals(SYU_MUSIC, a.shown());
        assertNull(a.overlayShown());
    }

    @Test
    void aSyuMusicUnitStartsOnTheSourceOfTheCurrentChannel() {
        assertEquals(RADIO, new StockKindArbiter(false, 1).shown());
        assertEquals(SYU_MUSIC, new StockKindArbiter(false, 8).shown());
        assertEquals(SYU_MUSIC, new StockKindArbiter(false, 10).shown());
    }

    @Test
    void theRadioTakesTheWidgetAndMusicGivesItBack() {
        StockKindArbiter a = new StockKindArbiter(false, 8);
        assertTrue(a.onChannel(1));
        assertEquals(RADIO, a.shown());
        assertEquals(RADIO, a.overlayShown());
        assertTrue(a.onChannel(8));
        assertEquals(SYU_MUSIC, a.shown());
        assertNull(a.overlayShown());
    }

    @Test
    void channelsThatAreNoSourceLeaveTheSourceShown() {
        StockKindArbiter a = new StockKindArbiter(false, 8);
        a.onChannel(1);
        // Paused by the widget (0), a third party player (10), a call: the station stays up, paused
        assertFalse(a.onChannel(0));
        assertFalse(a.onChannel(10));
        assertFalse(a.onChannel(-1));
        assertEquals(RADIO, a.shown());
    }

    @Test
    void btOnASyuMusicUnitOnlyTakesTheRadioOffTheWidget() {
        StockKindArbiter a = new StockKindArbiter(false, 1);
        assertTrue(a.onChannel(3));
        assertEquals(SYU_MUSIC, a.shown());
        assertNull(a.overlayShown());
    }

    @Test
    void channel7MeansNothingOnASyuMusicUnit() {
        StockKindArbiter a = new StockKindArbiter(false, 8);
        assertNull(a.kindForChannel(7));
        assertFalse(a.onChannel(7));
        assertEquals(SYU_MUSIC, a.shown());
    }

    @Test
    void aSyuMusicUnitIgnoresAPlayerThatReportsPlaying() {
        StockKindArbiter a = new StockKindArbiter(false, 1);
        assertFalse(a.onPlayerPlaying(MEDIA_MUSIC));
        assertEquals(RADIO, a.shown());
    }

    // ------------------------------------------------------------------ 7870: com.syu.media

    @Test
    void aSyuMediaUnitStartsOnItsMusicPlayer() {
        StockKindArbiter a = new StockKindArbiter(true, 0);
        assertEquals(MEDIA_MUSIC, a.shown());
    }

    @Test
    void everyChannelOfASyuMediaUnitHasItsSource() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertEquals(MEDIA_MUSIC, a.kindForChannel(8));
        assertEquals(MEDIA_ONLINE, a.kindForChannel(7));
        assertEquals(MEDIA_BT, a.kindForChannel(3));
        assertEquals(RADIO, a.kindForChannel(1));
        assertNull(a.kindForChannel(10));
        assertNull(a.kindForChannel(0));
    }

    @Test
    void usbOnlineBtFmUsbShowsTheRightSourceEachTime() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertEquals(MEDIA_MUSIC, a.shown());
        assertTrue(a.onChannel(7));
        assertEquals(MEDIA_ONLINE, a.shown());
        assertNull(a.overlayShown());
        assertTrue(a.onChannel(3));
        assertEquals(MEDIA_BT, a.shown());
        assertEquals(MEDIA_BT, a.overlayShown());
        assertTrue(a.onChannel(1));
        assertEquals(RADIO, a.shown());
        assertEquals(RADIO, a.overlayShown());
        assertTrue(a.onChannel(8));
        assertEquals(MEDIA_MUSIC, a.shown());
        assertNull(a.overlayShown());
    }

    @Test
    void theSameChannelAgainChangesNothing() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertFalse(a.onChannel(8));
        a.onChannel(3);
        assertFalse(a.onChannel(3));
    }

    @Test
    void aPlayerThatReportsPlayingTakesTheWidgetBeforeTheChannelMoves() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertTrue(a.onPlayerPlaying(MEDIA_ONLINE));
        assertEquals(MEDIA_ONLINE, a.shown());
        // The MCU follows a moment later and finds it as it is
        assertFalse(a.onChannel(7));
        assertEquals(MEDIA_ONLINE, a.shown());
    }

    @Test
    void aPlayerDoesNotTakeTheRadioOrBtOffWhileTheMcuIsOnTheirChannel() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        a.onChannel(1);
        // Read as playing just before it paused for the radio
        assertFalse(a.onPlayerPlaying(MEDIA_MUSIC));
        assertEquals(RADIO, a.shown());
        a.onChannel(3);
        assertFalse(a.onPlayerPlaying(MEDIA_ONLINE));
        assertEquals(MEDIA_BT, a.shown());
    }

    @Test
    void aPlayerTakesOverFromARadioThatLostItsChannel() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        a.onChannel(1);
        a.onChannel(0); // paused from the widget
        assertTrue(a.onPlayerPlaying(MEDIA_MUSIC));
        assertEquals(MEDIA_MUSIC, a.shown());
    }

    @Test
    void thePlayerAlreadyShownTakesNothingOver() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertFalse(a.onPlayerPlaying(MEDIA_MUSIC));
    }

    @Test
    void onlyAPlayerCanTakeOver() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        assertFalse(a.onPlayerPlaying(RADIO));
        assertFalse(a.onPlayerPlaying(MEDIA_BT));
        assertFalse(a.onPlayerPlaying(null));
        assertEquals(MEDIA_MUSIC, a.shown());
    }

    @Test
    void thePlayerThatHasTheWidgetStaysWhenTheChannelIsNone() {
        StockKindArbiter a = new StockKindArbiter(true, 8);
        a.onChannel(7);
        a.onChannel(0);
        a.onChannel(10);
        assertEquals(MEDIA_ONLINE, a.shown());
    }

    // ------------------------------------------------------------------ learning the unit late

    @Test
    void learningThatItIsA7870MovesTheWidgetToItsPlayer() {
        StockKindArbiter a = new StockKindArbiter(false, 8);
        assertEquals(SYU_MUSIC, a.shown());
        assertTrue(a.setSyuMediaUnit(true));
        assertEquals(MEDIA_MUSIC, a.shown());
        assertFalse(a.setSyuMediaUnit(true));
    }

    @Test
    void learningItLateRemembersTheChannelsSeenMeanwhile() {
        StockKindArbiter a = new StockKindArbiter(false, 0);
        a.onChannel(7);  // no source on a unit not yet known to be a 7870
        a.onChannel(3);  // SYU_MUSIC for now
        assertTrue(a.setSyuMediaUnit(true));
        assertEquals(MEDIA_BT, a.shown());
    }

    @Test
    void learningItLateKeepsTheRadioWhenThatIsTheLastChannel() {
        StockKindArbiter a = new StockKindArbiter(false, 1);
        assertEquals(RADIO, a.shown());
        assertFalse(a.setSyuMediaUnit(true));
        assertEquals(RADIO, a.shown());
    }

    @Test
    void theChannelOfAKindIsTheOneItPlaysOn() {
        assertEquals(8, SYU_MUSIC.channel);
        assertEquals(8, MEDIA_MUSIC.channel);
        assertEquals(7, MEDIA_ONLINE.channel);
        assertEquals(3, MEDIA_BT.channel);
        assertEquals(1, RADIO.channel);
        assertTrue(RADIO.overlay);
        assertTrue(MEDIA_BT.overlay);
        assertFalse(MEDIA_MUSIC.overlay);
        assertFalse(SYU_MUSIC.overlay);
    }
}
