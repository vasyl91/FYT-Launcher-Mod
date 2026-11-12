package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class CellChildIdTest {

    @Test
    void theIdOfTheLogIsNoLongerInTheResourceRange() {
        // 0x9cd20506: the desktop, screen 0xd2, column 5, row 6
        int id = CellChildId.of(true, 0xd2, 5, 6);
        assertEquals(0, id >>> 24);
        assertTrue(id > 0);
    }

    @Test
    void noIdHasATopByteOnAnyScreenOrCell() {
        for (long screen = -3; screen < 300; screen += 7) {
            for (int x = 0; x < 128; x += 9) {
                for (int y = 0; y < 128; y += 5) {
                    assertEquals(0, CellChildId.of(true, screen, x, y) >>> 24);
                    assertEquals(0, CellChildId.of(false, screen, x, y) >>> 24);
                }
            }
        }
    }

    @Test
    void theCellsOfOnePageAllDiffer() {
        Set<Integer> seen = new HashSet<>();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                assertTrue(seen.add(CellChildId.of(true, 4, x, y)));
            }
        }
    }

    @Test
    void theHotseatDiffersFromTheDesktop() {
        assertNotEquals(CellChildId.of(true, 1, 2, 0), CellChildId.of(false, 1, 2, 0));
    }

    @Test
    void theIdsStayAboveTheOnesTheFrameworkGenerates() {
        assertTrue(CellChildId.of(true, 0, 0, 0) >= (1 << 23));
    }
}
