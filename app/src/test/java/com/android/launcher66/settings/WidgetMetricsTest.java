package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WidgetMetricsTest {

    private static void assertMinimums(WidgetMetrics.Metrics m, int pipW, int pipH, int dateW, int dateH,
                                       int musicW, int musicH, int radioW, int radioH) {
        assertEquals(pipW, m.pipMinWidth, "pipMinWidth");
        assertEquals(pipH, m.pipMinHeight, "pipMinHeight");
        assertEquals(dateW, m.dateMinWidth, "dateMinWidth");
        assertEquals(dateH, m.dateMinHeight, "dateMinHeight");
        assertEquals(musicW, m.musicMinWidth, "musicMinWidth");
        assertEquals(musicH, m.musicMinHeight, "musicMinHeight");
        assertEquals(radioW, m.radioMinWidth, "radioMinWidth");
        assertEquals(radioH, m.radioMinHeight, "radioMinHeight");
    }

    private static void assertReferenceContent(WidgetMetrics.Metrics m) {
        assertEquals(18, m.textSizeBasic);
        assertEquals(22, m.textSizeTitle);
        assertEquals(16, m.textSizeArtist);
        assertEquals(30, m.radioTextFrequency);
        assertEquals(70, m.radioButtonHeight);
        assertEquals(60, m.radioButtonWidth);
        assertEquals(276, m.analogWidth);
        assertEquals(276, m.analogHeight);
        assertEquals(82, m.digitClockWidth);
        assertEquals(110, m.digitClockHeight);
        assertEquals(52, m.dotClockWidth);
        assertEquals(110, m.dotClockHeight);
    }

    @Test
    void referenceDeviceKeepsItsPixelsInLandscape() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(2000, 1200);
        assertMinimums(m, 528, 360, 528, 144, 301, 360, 301, 144);
        assertReferenceContent(m);
    }

    @Test
    void referenceDeviceKeepsItsPixelsInPortrait() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(1200, 2000);
        assertMinimums(m, 528, 360, 528, 144, 301, 360, 301, 144);
        assertReferenceContent(m);
    }

    @Test
    void orientationDoesNotMatter() {
        WidgetMetrics.Metrics a = WidgetMetrics.compute(1920, 720);
        WidgetMetrics.Metrics b = WidgetMetrics.compute(720, 1920);
        assertMinimums(b, a.pipMinWidth, a.pipMinHeight, a.dateMinWidth, a.dateMinHeight,
                a.musicMinWidth, a.musicMinHeight, a.radioMinWidth, a.radioMinHeight);
        assertEquals(a.textSizeBasic, b.textSizeBasic);
        assertEquals(a.digitClockHeight, b.digitClockHeight);
    }

    @Test
    void ultraWideScreen() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(1920, 720);
        assertMinimums(m, 316, 216, 316, 86, 180, 216, 180, 86);
        // 110 px of digits at the reference edge has to fit the 86 px date widget after scaling.
        assertEquals(66, m.digitClockHeight);
    }

    @Test
    void smallScreen() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(1024, 600);
        assertMinimums(m, 264, 180, 264, 72, 150, 180, 150, 72);
    }

    @Test
    void sameShortEdgeGivesSameResult() {
        WidgetMetrics.Metrics a = WidgetMetrics.compute(1280, 720);
        WidgetMetrics.Metrics b = WidgetMetrics.compute(1920, 720);
        assertMinimums(a, b.pipMinWidth, b.pipMinHeight, b.dateMinWidth, b.dateMinHeight,
                b.musicMinWidth, b.musicMinHeight, b.radioMinWidth, b.radioMinHeight);
        assertMinimums(a, 316, 216, 316, 86, 180, 216, 180, 86);
    }

    @Test
    void tallPhoneLikeScreen() {
        WidgetMetrics.Metrics m = WidgetMetrics.compute(1080, 2400);
        assertMinimums(m, 475, 324, 475, 129, 270, 324, 270, 129);
        assertEquals(17, m.textSizeBasic);
    }

    @Test
    void scalePxUsesIntegerArithmetic() {
        // 12% of 1200 is exactly 144; double math can land on 143.
        assertEquals(144, WidgetMetrics.scalePx(144, 1200));
        assertEquals(0, WidgetMetrics.scalePx(144, 0));
        // Large values must not overflow int.
        assertEquals(Integer.MAX_VALUE / 2, WidgetMetrics.scalePx(Integer.MAX_VALUE / 2, 1200));
    }

    @Test
    void scaleTextFollowsSquareRootCurve() {
        assertEquals(18, WidgetMetrics.scaleText(18, 1200));
        assertEquals(36, WidgetMetrics.scaleText(18, 4800));
    }

    @Test
    void nonPositiveScreenIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> WidgetMetrics.compute(0, 1200));
        assertThrows(IllegalArgumentException.class, () -> WidgetMetrics.compute(1920, -1));
    }
}
