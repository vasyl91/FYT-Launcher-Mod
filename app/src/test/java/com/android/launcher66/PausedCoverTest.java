package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PausedCoverTest {

    @Test
    void onlyThe7870sMediaSourcesWhileTheyDoNotPlay() {
        assertTrue(PausedCover.applies(true, true, false));
        assertFalse(PausedCover.applies(true, true, true), "playing: drawn as it always was");
        assertFalse(PausedCover.applies(false, true, false), "the 7862 and the other units: as before");
        assertFalse(PausedCover.applies(true, false, false), "another source on the 7870: as before");
    }

    @Test
    void theFilesCoverThenThePublishedOneThenTheSavedOneElseWhatIsShownStays() {
        assertEquals(PausedCover.Pick.FILE, PausedCover.pick(true, true, true));
        assertEquals(PausedCover.Pick.PUBLISHED, PausedCover.pick(false, true, true));
        assertEquals(PausedCover.Pick.SAVED, PausedCover.pick(false, false, true));
        assertEquals(PausedCover.Pick.KEEP, PausedCover.pick(false, false, false),
                "never the default over a cover that is shown");
    }
}
