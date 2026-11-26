package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BadgeGeometryTest {

    @Test
    void theHeightIsAShareOfTheIconsHeight() {
        assertEquals(20f, BadgeGeometry.height(BadgeGeometry.Size.SMALL, 100f), 0.001f);
        assertEquals(25f, BadgeGeometry.height(BadgeGeometry.Size.MEDIUM, 100f), 0.001f);
        assertEquals(33.333f, BadgeGeometry.height(BadgeGeometry.Size.LARGE, 100f), 0.01f);
        // the bars' icons are another size
        assertEquals(12.5f, BadgeGeometry.height(BadgeGeometry.Size.MEDIUM, 50f), 0.001f);
    }

    @Test
    void theSizeAndThePositionComeFromTheirStoredValuesAndDefaultToMediumAndTopRight() {
        assertEquals(BadgeGeometry.Size.SMALL, BadgeGeometry.Size.parse("small"));
        assertEquals(BadgeGeometry.Size.LARGE, BadgeGeometry.Size.parse("large"));
        assertEquals(BadgeGeometry.Size.MEDIUM, BadgeGeometry.Size.parse("medium"));
        assertEquals(BadgeGeometry.Size.MEDIUM, BadgeGeometry.Size.parse(null));
        assertEquals(BadgeGeometry.Position.TOP_LEFT, BadgeGeometry.Position.parse("top_left"));
        assertEquals(BadgeGeometry.Position.BOTTOM_LEFT, BadgeGeometry.Position.parse("bottom_left"));
        assertEquals(BadgeGeometry.Position.BOTTOM_RIGHT, BadgeGeometry.Position.parse("bottom_right"));
        assertEquals(BadgeGeometry.Position.TOP_RIGHT, BadgeGeometry.Position.parse("anything"));
    }

    @Test
    void theWidthIsTheHeightOrTheTextAndItsPaddingWhenThatIsMore() {
        assertEquals(25f, BadgeGeometry.width(25f, 10f, 4f), 0.001f);
        assertEquals(42f, BadgeGeometry.width(25f, 34f, 4f), 0.001f);
    }

    @Test
    void theRadiusFollowsTheSliderFromASquareToACircle() {
        assertEquals(0f, BadgeGeometry.radius(0, 24f), 0.001f);
        assertEquals(6f, BadgeGeometry.radius(50, 24f), 0.001f);
        assertEquals(12f, BadgeGeometry.radius(100, 24f), 0.001f);
        assertEquals(12f, BadgeGeometry.radius(250, 24f), 0.001f);
        assertEquals(0f, BadgeGeometry.radius(-4, 24f), 0.001f);
    }

    @Test
    void theBadgeLiesInTheChosenCornerInsideTheIcon() {
        assertArrayEquals(new float[] {75f, 10f, 100f, 35f},
                BadgeGeometry.place(BadgeGeometry.Position.TOP_RIGHT, 0f, 10f, 100f, 110f, 25f, 25f), 0.001f);
        assertArrayEquals(new float[] {0f, 10f, 25f, 35f},
                BadgeGeometry.place(BadgeGeometry.Position.TOP_LEFT, 0f, 10f, 100f, 110f, 25f, 25f), 0.001f);
        assertArrayEquals(new float[] {0f, 85f, 25f, 110f},
                BadgeGeometry.place(BadgeGeometry.Position.BOTTOM_LEFT, 0f, 10f, 100f, 110f, 25f, 25f), 0.001f);
        assertArrayEquals(new float[] {58f, 85f, 100f, 110f},
                BadgeGeometry.place(BadgeGeometry.Position.BOTTOM_RIGHT, 0f, 10f, 100f, 110f, 42f, 25f), 0.001f);
    }

    @Test
    void aBadgeLargerThanTheIconIsCutToIt() {
        assertArrayEquals(new float[] {0f, 0f, 20f, 20f},
                BadgeGeometry.place(BadgeGeometry.Position.TOP_LEFT, 0f, 0f, 20f, 20f, 50f, 40f), 0.001f);
    }
}
