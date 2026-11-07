package com.syu.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PaneLaunchFlagsTest {

    @Test
    void isNewTaskWithResetTaskIfNeeded() {
        assertEquals(0x10200000, PaneLaunchFlags.FLAGS);
    }

    @Test
    void doesNotLookForTheLauncherActivityInTheTask() {
        int clearTop = 0x04000000;
        int singleTop = 0x20000000;
        int reorderToFront = 0x00020000;
        int broughtToFront = 0x00400000;
        int launchedFromHistory = 0x00100000;
        for (int flag : new int[] {clearTop, singleTop, reorderToFront, broughtToFront, launchedFromHistory}) {
            assertEquals(0, PaneLaunchFlags.FLAGS & flag);
        }
    }
}
