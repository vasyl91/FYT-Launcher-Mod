package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BadgeGeometryTest {

    @Test
    void theHeightIsTheSlidersShareOfTheSeenIconsHeight() {
        assertEquals(15f, BadgeGeometry.height(15, 100f), 0.001f);
        assertEquals(25f, BadgeGeometry.height(25, 100f), 0.001f);
        assertEquals(35f, BadgeGeometry.height(35, 100f), 0.001f);
        // the bars' icons are another size
        assertEquals(12.5f, BadgeGeometry.height(25, 50f), 0.001f);
    }

    @Test
    void theSliderIsHeldToFifteenToThirtyFiveAndTheDefaultIsTwentyFive() {
        assertEquals(15, BadgeGeometry.percent(3));
        assertEquals(35, BadgeGeometry.percent(80));
        assertEquals(22, BadgeGeometry.percent(22));
        assertEquals(25, BadgeGeometry.DEFAULT_PERCENT);
        assertEquals(15f, BadgeGeometry.height(0, 100f), 0.001f);
    }

    @Test
    void theNumberIsEightyFivePerCentOfTheBadge() {
        assertEquals(0.85f, BadgeGeometry.TEXT_SHARE, 0f);
    }

    @Test
    void thePositionComesFromItsStoredValueAndDefaultsToTopRight() {
        assertEquals(BadgeGeometry.Position.TOP_LEFT, BadgeGeometry.Position.parse("top_left"));
        assertEquals(BadgeGeometry.Position.BOTTOM_LEFT, BadgeGeometry.Position.parse("bottom_left"));
        assertEquals(BadgeGeometry.Position.BOTTOM_RIGHT, BadgeGeometry.Position.parse("bottom_right"));
        assertEquals(BadgeGeometry.Position.TOP_RIGHT, BadgeGeometry.Position.parse("anything"));
    }

    @Test
    void aWiderBadgeGrowsFromItsCornerTowardsTheMiddle() {
        // the outer edges stay on the corner's: a right corner grows to the left, a left one to the right
        float[] narrow = BadgeGeometry.place(BadgeGeometry.Position.TOP_RIGHT, 0f, 0f, 100f, 100f, 25f, 25f);
        float[] wide = BadgeGeometry.place(BadgeGeometry.Position.TOP_RIGHT, 0f, 0f, 100f, 100f, 45f, 25f);
        assertEquals(narrow[2], wide[2], 0.001f);
        assertEquals(55f, wide[0], 0.001f);
        float[] left = BadgeGeometry.place(BadgeGeometry.Position.BOTTOM_LEFT, 0f, 0f, 100f, 100f, 45f, 25f);
        assertArrayEquals(new float[] {0f, 75f, 45f, 100f}, left, 0.001f);
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
