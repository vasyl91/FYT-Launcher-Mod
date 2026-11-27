package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeSwipeTest {

    // a slop of 16 px, the long press after 400 ms, a 1200 px short side: 12 % is 144 px
    private static final int SLOP = 16;
    private static final long LONG_PRESS = 400;
    private static final int SHORT = 1200;

    private static HomeSwipe armed(boolean upOn, boolean downOn) {
        HomeSwipe swipe = new HomeSwipe(SLOP, LONG_PRESS);
        swipe.down(1000, 500f, 600f, true, upOn, downOn, SHORT);
        return swipe;
    }

    @Test
    void theDrawerOpensOnTheMoveThatIsLongEnoughNotWhenTheFingerIsLifted() {
        HomeSwipe swipe = armed(true, true);
        assertEquals(HomeSwipe.Step.TAKE, swipe.move(1050, 502f, 570f));
        assertTrue(swipe.taking());
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1080, 503f, 500f));
        assertEquals(HomeSwipe.Step.UP, swipe.move(1100, 504f, 456f), "144 px up");
        // once per touch, and the lift does not fire it again
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1120, 504f, 300f));
        assertEquals(HomeSwipe.Step.NONE, swipe.up(504f, 300f, 3000f));
    }

    @Test
    void aSwipeDownFiresAtTheSameDistance() {
        HomeSwipe swipe = armed(false, true);
        assertEquals(HomeSwipe.Step.TAKE, swipe.move(1050, 500f, 640f));
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1070, 500f, 743f));
        assertEquals(HomeSwipe.Step.DOWN, swipe.move(1090, 500f, 744f));
    }

    @Test
    void aFastMoveLongEnoughAtOnceFiresOnTheMoveThatTakesIt() {
        HomeSwipe swipe = armed(true, false);
        assertEquals(HomeSwipe.Step.UP, swipe.move(1030, 500f, 400f));
        assertTrue(swipe.taking());
    }

    @Test
    void aShortFastFlickFiresWhenTheFingerIsLifted() {
        HomeSwipe swipe = armed(true, true);
        assertEquals(HomeSwipe.Step.TAKE, swipe.move(1030, 500f, 560f));
        assertEquals(HomeSwipe.Step.UP, swipe.up(500f, 540f, -1500f));
        HomeSwipe slow = armed(true, true);
        slow.move(1030, 500f, 560f);
        assertEquals(HomeSwipe.Step.NONE, slow.up(500f, 540f, -300f));
    }

    @Test
    void aMoveAfterTheLongPressTimeoutIsNoSwipeForTheRestOfTheTouch() {
        HomeSwipe swipe = armed(true, true);
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1200, 501f, 605f), "within the slop");
        // the finger has rested for the long press timeout: an icon is dragged or the overview opens
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1400, 500f, 900f));
        assertFalse(swipe.armed());
        assertFalse(swipe.taking());
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1420, 500f, 1000f));
        assertEquals(HomeSwipe.Step.NONE, swipe.up(500f, 1000f, 5000f));
    }

    @Test
    void aDragThatBeganDisarmsTheTouch() {
        HomeSwipe swipe = armed(true, true);
        swipe.cancel();
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1050, 500f, 300f));
        assertFalse(swipe.taking());
    }

    @Test
    void aDirectionWhoseSettingIsOffDoesNotFire() {
        HomeSwipe swipe = armed(true, false);
        assertEquals(HomeSwipe.Step.TAKE, swipe.move(1050, 500f, 640f));
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1080, 500f, 900f));
        assertEquals(HomeSwipe.Step.NONE, swipe.up(500f, 900f, 4000f));
    }

    @Test
    void aSidewaysMoveStaysThePagesAndATouchNotArmedIsNothing() {
        HomeSwipe swipe = armed(true, true);
        assertEquals(HomeSwipe.Step.NONE, swipe.move(1050, 700f, 640f));
        assertFalse(swipe.taking());
        HomeSwipe off = new HomeSwipe(SLOP, LONG_PRESS);
        off.down(1000, 500f, 600f, false, true, true, SHORT);
        assertFalse(off.armed());
        assertEquals(HomeSwipe.Step.NONE, off.move(1050, 500f, 300f));
        HomeSwipe none = new HomeSwipe(SLOP, LONG_PRESS);
        none.down(1000, 500f, 600f, true, false, false, SHORT);
        assertFalse(none.armed(), "no gesture is on");
    }

    @Test
    void aNewTouchStartsAfresh() {
        HomeSwipe swipe = armed(true, true);
        swipe.move(1030, 500f, 400f);
        assertTrue(swipe.fired());
        swipe.up(500f, 400f, 0f);
        swipe.down(5000, 500f, 600f, true, true, true, SHORT);
        assertFalse(swipe.fired());
        assertEquals(HomeSwipe.Step.UP, swipe.move(5030, 500f, 400f));
    }
}
