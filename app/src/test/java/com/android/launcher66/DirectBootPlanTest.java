package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DirectBootPlanTest {

    @Test
    void anUnlockedUserGetsTheWholeStartAsAlways() {
        assertEquals(DirectBootPlan.Start.FULL, DirectBootPlan.atStart(true));
    }

    @Test
    void aLockedUserGetsTheWallpaperOnly() {
        assertEquals(DirectBootPlan.Start.WALLPAPER_ONLY, DirectBootPlan.atStart(false));
    }

    @Test
    void theUnlockCompletesAWallpaperStartOnceAndNeverAFullOne() {
        assertTrue(DirectBootPlan.completeOnUnlock(DirectBootPlan.Start.WALLPAPER_ONLY, false));
        // reported twice (the application's receiver and the activity's): the second finds it done
        assertFalse(DirectBootPlan.completeOnUnlock(DirectBootPlan.Start.WALLPAPER_ONLY, true));
        // an unlocked start has nothing to complete
        assertFalse(DirectBootPlan.completeOnUnlock(DirectBootPlan.Start.FULL, false));
    }

    @Test
    void onlyAnActivityShownForTheWallpaperEndsAtTheUnlock() {
        assertTrue(DirectBootPlan.finishActivityOnUnlock(DirectBootPlan.Start.WALLPAPER_ONLY));
        assertFalse(DirectBootPlan.finishActivityOnUnlock(DirectBootPlan.Start.FULL));
    }
}
