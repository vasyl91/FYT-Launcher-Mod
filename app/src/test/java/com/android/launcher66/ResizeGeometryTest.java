package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ResizeGeometryTest {

    private static final int FRAME_PAD = 24;
    private static final int[] PAD = {8, 6, 10, 4};

    @Test
    void theFrameLiesRoundTheWidgetByItsPaddingLessTheWidgetsOwn() {
        int[] widget = {100, 200, 300, 150};
        // x = 100 - 24 + 8 + 50, y = 200 - 24 + 6 + 70, width = 300 + 48 - 18, height = 150 + 48 - 10
        assertArrayEquals(new int[] {134, 252, 330, 188},
                ResizeGeometry.frameOf(widget, FRAME_PAD, PAD, 1f, 50, 70));
    }

    @Test
    void frameAndWidgetAreEachOthersInverse() {
        for (int[] widget : new int[][] {{0, 0, 48, 48}, {100, 200, 300, 150}, {-5, 7, 999, 1}}) {
            int[] frame = ResizeGeometry.frameOf(widget, FRAME_PAD, PAD, 1f, 50, 70);
            assertArrayEquals(widget, ResizeGeometry.widgetOf(frame, FRAME_PAD, PAD, 1f, 50, 70));
        }
        int[] frame = {40, 60, 500, 300};
        int[] widget = ResizeGeometry.widgetOf(frame, FRAME_PAD, PAD, 1f, 0, 0);
        assertArrayEquals(frame, ResizeGeometry.frameOf(widget, FRAME_PAD, PAD, 1f, 0, 0));
    }

    @Test
    void aScaledWidgetIsAsLargeAsItIsDrawnWithNoPaddingCounted() {
        int[] none = new int[4];
        int[] widget = {10, 20, 200, 100};
        // drawn at half: 100 x 50, the frame round it
        assertArrayEquals(new int[] {-14, -4, 148, 98}, ResizeGeometry.frameOf(widget, FRAME_PAD, none, 0.5f, 0, 0));
        assertArrayEquals(widget, ResizeGeometry.widgetOf(new int[] {-14, -4, 148, 98}, FRAME_PAD, none, 0.5f, 0, 0));
    }
}
