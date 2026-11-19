package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarConstraintsWidthTest {

    @Test
    void aPortraitBarWhoseWidthIsAShareOfItsHeightTakesTheLaunchersWidth() {
        // layout-port: app:layout_constraintDimensionRatio="W,0.071"
        assertTrue(BarConstraints.widthReplacesLayout("W,0.071", 1f, 155));
    }

    @Test
    void aLandscapeBarInPercentOfTheLayoutTakesTheLaunchersWidthToo() {
        // layout-land: app:layout_constraintWidth_percent="0.071"; "Resizable vertical bar" changes the width
        assertTrue(BarConstraints.widthReplacesLayout(null, 0.071f, 142));
        assertTrue(BarConstraints.widthReplacesLayout("", 0.071f, 200));
    }

    @Test
    void aBarWithAWidthOfItsOwnKeepsIt() {
        assertFalse(BarConstraints.widthReplacesLayout(null, 1f, 142));
        assertFalse(BarConstraints.widthReplacesLayout("", 1f, 142));
    }

    @Test
    void withoutAWidthTheLayoutsStays() {
        // The default layout and the bar's window pass no width
        assertFalse(BarConstraints.widthReplacesLayout("W,0.071", 1f, 0));
        assertFalse(BarConstraints.widthReplacesLayout(null, 0.071f, 0));
    }
}
