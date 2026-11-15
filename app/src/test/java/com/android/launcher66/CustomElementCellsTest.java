package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CustomElementCellsTest {

    @Test
    void theStatisticsWindowLeavesItsCellsFree() {
        assertFalse(CustomElement.STATS.takesCells());
    }

    @Test
    void everyOtherElementTakesItsCells() {
        for (CustomElement element : CustomElement.values()) {
            if (element != CustomElement.STATS) {
                assertTrue(element.takesCells(), element.label);
            }
        }
    }
}
