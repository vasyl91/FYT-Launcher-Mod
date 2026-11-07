package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Vertical bar capacity only; bottomCapacity() needs Launcher.screenWidth and is not loaded here. */
class BarCapacityTest {

    @Test
    void phonePortraitKeepsNineSlots() {
        assertEquals(9, BarCapacity.leftCapacity(2119, 110));
    }

    @Test
    void fytLandscapeGetsFiveSlots() {
        assertEquals(5, BarCapacity.leftCapacity(974, 104));
        assertEquals(5, BarCapacity.leftCapacity(582, 66));
    }

    @Test
    void capacityIsClamped() {
        assertEquals(5, BarCapacity.leftCapacity(100, 104));
        assertEquals(12, BarCapacity.leftCapacity(10000, 50));
    }

    @Test
    void missingDataGivesMinimum() {
        assertEquals(5, BarCapacity.leftCapacity(0, 104));
        assertEquals(5, BarCapacity.leftCapacity(974, 0));
    }

    @Test
    void wholeNumberBoundaryIsTolerated() {
        // Exactly 4 pitches of 212.5 px: below the minimum, so the clamp gives 5.
        assertEquals(5, BarCapacity.leftCapacity(850, 100));
        // Exactly 6 pitches.
        assertEquals(6, BarCapacity.leftCapacity(1275, 100));
    }

    @Test
    void iconSizeFollowsWidth() {
        assertEquals(104, BarCapacity.leftIconSize(142));
        assertEquals(110, BarCapacity.leftIconSize(150));
    }
}
