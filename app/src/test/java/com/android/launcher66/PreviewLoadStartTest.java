package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PreviewLoadStartTest {

    @Test
    void thePageShownFirstStartsItsTaskAtOnceEvenDuringATransition() {
        // KI-46: it read its previews on the main thread before, in the layout pass
        assertEquals(PreviewLoadStart.When.NOW, PreviewLoadStart.of(true, true));
        assertEquals(PreviewLoadStart.When.NOW, PreviewLoadStart.of(true, false));
    }

    @Test
    void theOtherPagesWaitForTheEndOfATransition() {
        assertEquals(PreviewLoadStart.When.AFTER_TRANSITION, PreviewLoadStart.of(false, true));
        assertEquals(PreviewLoadStart.When.NOW, PreviewLoadStart.of(false, false));
    }
}
