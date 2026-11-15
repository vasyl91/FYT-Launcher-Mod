package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PageBarSwapTest {

    private static final class FakeView {
        float alpha;

        FakeView(float alpha) {
            this.alpha = alpha;
        }
    }

    private final PageBarSwap<FakeView> swap = new PageBarSwap<>(new PageBarSwap.Alpha<FakeView>() {
        @Override
        public float get(FakeView view) {
            return view.alpha;
        }

        @Override
        public void set(FakeView view, float alpha) {
            view.alpha = alpha;
        }
    });

    private final FakeView bar = new FakeView(1f);
    private final FakeView button = new FakeView(0.4f);
    private final List<FakeView> page = Arrays.asList(bar, button);

    @Test
    void thePagesBarIsHiddenOnlyOnceTheWindowHasDrawn() {
        int token = swap.windowShown();
        assertEquals(1f, bar.alpha);   // both are seen for a frame rather than neither
        assertTrue(swap.windowDrawn(token, page));
        assertEquals(0f, bar.alpha);
        assertEquals(0f, button.alpha);
        assertTrue(swap.pageBarHidden());
    }

    @Test
    void whenTheWindowGoesThePagesBarComesBackWithItsOwnAlpha() {
        swap.windowDrawn(swap.windowShown(), page);
        int token = swap.windowLeaving();
        assertEquals(1f, bar.alpha);
        assertEquals(0.4f, button.alpha);
        assertFalse(swap.pageBarHidden());
        assertTrue(swap.current(token));   // the window may be put away now
    }

    @Test
    void aWindowPutAwayBeforeItDrewLeavesThePagesBarAlone() {
        int token = swap.windowShown();
        swap.windowLeaving();
        assertFalse(swap.windowDrawn(token, page));
        assertEquals(1f, bar.alpha);
    }

    @Test
    void aWindowShownAgainVoidsTheStepThatWouldPutItAway() {
        swap.windowDrawn(swap.windowShown(), page);
        int leaving = swap.windowLeaving();
        int shown = swap.windowShown();
        assertFalse(swap.current(leaving));
        assertTrue(swap.windowDrawn(shown, page));
        assertEquals(0f, bar.alpha);
    }

    @Test
    void hidingTwiceKeepsTheAlphaFromBeforeTheFirstTime() {
        swap.windowDrawn(swap.windowShown(), page);
        swap.windowDrawn(swap.windowShown(), page);
        swap.windowLeaving();
        assertEquals(0.4f, button.alpha);
    }
}
