package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HandedWorkTest {

    private final Object job = new Object();
    private final Object oldScreen = new Object();
    private final Object newScreen = new Object();

    @Test
    void theWorkGoesOnThroughATurnAndTheNewScreenGetsItWithTheLastProgress() {
        HandedWork<Object, Object> work = new HandedWork<>();
        work.start(job, "1.2.3", oldScreen);
        work.progress(10);
        assertSame(oldScreen, work.screen());

        work.leave(oldScreen);
        assertTrue(work.running(), "the turn does not stop it");
        assertNull(work.screen(), "nothing shows it between the two screens");
        work.progress(40);

        assertSame(job, work.join(newScreen));
        assertSame(newScreen, work.screen());
        assertEquals("1.2.3", work.what());
        assertArrayEquals(new int[] {40}, work.lastProgress(), "the progress made while no screen was there");
    }

    @Test
    void aScreenThatComesWhenNothingRunsGetsNothing() {
        HandedWork<Object, Object> work = new HandedWork<>();
        assertNull(work.join(newScreen));
        assertNull(work.screen());
        work.progress(5);
        assertNull(work.lastProgress(), "no work, no progress");
    }

    @Test
    void anOldScreenLeavingLateDoesNotTakeTheWorkFromTheNewOne() {
        HandedWork<Object, Object> work = new HandedWork<>();
        work.start(job, null, oldScreen);
        work.join(newScreen);
        work.leave(oldScreen);
        assertSame(newScreen, work.screen());
    }

    @Test
    void theEndForgetsEverything() {
        HandedWork<Object, Object> work = new HandedWork<>();
        work.start(job, "Day", oldScreen);
        work.progress(1, 50, 10, 20);
        work.toBackground();
        work.end();
        assertFalse(work.running());
        assertNull(work.job());
        assertNull(work.what());
        assertNull(work.lastProgress());
        assertFalse(work.inBackground());
        assertNull(work.screen());
    }

    @Test
    void workSentToTheBackgroundStaysThereUntilANewOneStarts() {
        HandedWork<Object, Object> work = new HandedWork<>();
        work.start(job, null, oldScreen);
        work.toBackground();
        work.leave(oldScreen);
        work.join(newScreen);
        assertTrue(work.inBackground(), "a new screen shows no dialog for it");

        work.start(new Object(), null, newScreen);
        assertFalse(work.inBackground());
        assertNull(work.lastProgress());
    }

    @Test
    void theProgressIsACopy() {
        HandedWork<Object, Object> work = new HandedWork<>();
        work.start(job, null, oldScreen);
        int[] values = {2, 30, 5, 9};
        work.progress(values);
        values[1] = 99;
        int[] read = work.lastProgress();
        read[0] = 7;
        assertArrayEquals(new int[] {2, 30, 5, 9}, work.lastProgress());
    }
}
