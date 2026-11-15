package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarConstraintsWidthTest {

    @Test
    void aPortraitBarWhoseWidthIsAShareOfItsHeightTakesTheLaunchersWidth() {
        // layout-port: app:layout_constraintDimensionRatio="W,0.071"
        assertTrue(BarConstraints.widthReplacesRatio("W,0.071", 155));
    }

    @Test
    void aLandscapeBarInPercentOfTheLayoutKeepsIt() {
        // layout-land gives the width in percent and no ratio
        assertFalse(BarConstraints.widthReplacesRatio(null, 142));
        assertFalse(BarConstraints.widthReplacesRatio("", 142));
    }

    @Test
    void withoutAWidthTheLayoutsRatioStays() {
        // The default layout and the bar's window pass no width
        assertFalse(BarConstraints.widthReplacesRatio("W,0.071", 0));
    }
}
