package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SettingsScrollMemoryTest {

    @BeforeEach
    void start() {
        SettingsScrollMemory.forget();
    }

    @Test
    void aScreenLeftForAnotherWindowComesBackWhereItWas() {
        SettingsScrollMemory.left(2, 14, -37);
        SettingsScrollMemory.Position back = SettingsScrollMemory.takeFor(2);
        assertNotNull(back);
        assertEquals(14, back.item);
        assertEquals(-37, back.offset);
        // given once
        assertNull(SettingsScrollMemory.takeFor(2));
    }

    @Test
    void thePositionBelongsToTheScreenItWasKeptFor() {
        SettingsScrollMemory.left(1, 9, 0);
        assertNull(SettingsScrollMemory.takeFor(2));
    }

    @Test
    void movingBetweenTheScreensKeepsNothingAndForgets() {
        SettingsScrollMemory.left(2, 14, 0);
        SettingsScrollMemory.betweenScreens();
        SettingsScrollMemory.left(2, 20, 0);   // screen 2 is left for screen 1: not kept
        assertNull(SettingsScrollMemory.takeFor(1));
        assertNull(SettingsScrollMemory.takeFor(2));
        // a later leaving is kept again
        SettingsScrollMemory.left(1, 3, -5);
        assertEquals(3, SettingsScrollMemory.takeFor(1).item);
    }

    @Test
    void theSettingsOpenedAfreshStartFromTheTop() {
        SettingsScrollMemory.left(1, 30, -2);
        SettingsScrollMemory.forget();
        assertNull(SettingsScrollMemory.takeFor(1));
    }

    @Test
    void leavingForTheHomeScreenKeepsNothingEvenAtTheFollowingPause() {
        SettingsScrollMemory.left(1, 30, 0);
        SettingsScrollMemory.leftForHome();
        SettingsScrollMemory.left(1, 31, 0);   // the pause that follows the home key
        assertNull(SettingsScrollMemory.takeFor(1));
    }

    @Test
    void anEmptyListKeepsNothing() {
        SettingsScrollMemory.left(1, -1, 0);
        assertNull(SettingsScrollMemory.takeFor(1));
    }
}
