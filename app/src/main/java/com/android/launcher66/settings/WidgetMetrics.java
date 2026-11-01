package com.android.launcher66.settings;

/**
 * Single source of the minimum PiP / widget sizes and of the sizes of the elements drawn inside the
 * date, music and radio widgets.
 *
 * <p>Everything scales from the SHORTER screen edge, so the result is the same in landscape and in
 * portrait and keeps its proportions on non-2000x1200 panels. The reference values are the pixels the
 * launcher produced on the author's 2000x1200 / 1200x2000 unit, which must stay unchanged there.
 *
 * <p>Pure Java on purpose (no Android imports): it is shared by Launcher and SettingsActivity and
 * unit-tested on the JVM.
 */
public final class WidgetMetrics {

    /** Short edge (px) the reference values below were measured on. */
    public static final int REFERENCE_SHORT_EDGE = 1200;

    // Minimum sizes at the reference short edge.
    public static final int PIP_MIN_WIDTH_REF = 528;
    public static final int PIP_MIN_HEIGHT_REF = 360;
    public static final int DATE_MIN_WIDTH_REF = 528;
    public static final int DATE_MIN_HEIGHT_REF = 144;
    public static final int MUSIC_MIN_WIDTH_REF = 301;
    public static final int MUSIC_MIN_HEIGHT_REF = 360;
    public static final int RADIO_MIN_WIDTH_REF = 301;
    public static final int RADIO_MIN_HEIGHT_REF = 144;

    // Widget content at the reference short edge.
    public static final int RADIO_BUTTON_HEIGHT_REF = 70;
    public static final int RADIO_BUTTON_WIDTH_REF = 60;
    public static final int ANALOG_CLOCK_REF = 276;
    public static final int DIGIT_CLOCK_WIDTH_REF = 82;
    public static final int DIGIT_CLOCK_HEIGHT_REF = 110;
    public static final int DOT_CLOCK_WIDTH_REF = 52;
    public static final int DOT_CLOCK_HEIGHT_REF = 110;
    public static final double TEXT_BASIC_REF = 18;
    public static final double TEXT_TITLE_REF = 22;
    public static final double TEXT_ARTIST_REF = 16;
    public static final double TEXT_FREQUENCY_REF = 30;

    /** All values derived from one screen size. */
    public static final class Metrics {
        public final int pipMinWidth;
        public final int pipMinHeight;
        public final int dateMinWidth;
        public final int dateMinHeight;
        public final int musicMinWidth;
        public final int musicMinHeight;
        public final int radioMinWidth;
        public final int radioMinHeight;

        public final int radioButtonHeight;
        public final int radioButtonWidth;
        public final int analogWidth;
        public final int analogHeight;
        public final int digitClockWidth;
        public final int digitClockHeight;
        public final int dotClockWidth;
        public final int dotClockHeight;
        public final int textSizeBasic;
        public final int textSizeTitle;
        public final int textSizeArtist;
        public final int radioTextFrequency;

        private Metrics(int shortEdge) {
            pipMinWidth = scalePx(PIP_MIN_WIDTH_REF, shortEdge);
            pipMinHeight = scalePx(PIP_MIN_HEIGHT_REF, shortEdge);
            dateMinWidth = scalePx(DATE_MIN_WIDTH_REF, shortEdge);
            dateMinHeight = scalePx(DATE_MIN_HEIGHT_REF, shortEdge);
            musicMinWidth = scalePx(MUSIC_MIN_WIDTH_REF, shortEdge);
            musicMinHeight = scalePx(MUSIC_MIN_HEIGHT_REF, shortEdge);
            radioMinWidth = scalePx(RADIO_MIN_WIDTH_REF, shortEdge);
            radioMinHeight = scalePx(RADIO_MIN_HEIGHT_REF, shortEdge);

            radioButtonHeight = scalePx(RADIO_BUTTON_HEIGHT_REF, shortEdge);
            radioButtonWidth = scalePx(RADIO_BUTTON_WIDTH_REF, shortEdge);
            analogWidth = scalePx(ANALOG_CLOCK_REF, shortEdge);
            analogHeight = scalePx(ANALOG_CLOCK_REF, shortEdge);
            digitClockWidth = scalePx(DIGIT_CLOCK_WIDTH_REF, shortEdge);
            digitClockHeight = scalePx(DIGIT_CLOCK_HEIGHT_REF, shortEdge);
            dotClockWidth = scalePx(DOT_CLOCK_WIDTH_REF, shortEdge);
            dotClockHeight = scalePx(DOT_CLOCK_HEIGHT_REF, shortEdge);
            textSizeBasic = scaleText(TEXT_BASIC_REF, shortEdge);
            textSizeTitle = scaleText(TEXT_TITLE_REF, shortEdge);
            textSizeArtist = scaleText(TEXT_ARTIST_REF, shortEdge);
            radioTextFrequency = scaleText(TEXT_FREQUENCY_REF, shortEdge);
        }
    }

    private WidgetMetrics() {
    }

    /**
     * Scales a reference pixel value. Integer arithmetic on purpose: a percentage in floating point
     * truncates exact values (e.g. (int) (0.12 * 1200) is 143).
     */
    public static int scalePx(int referencePx, int shortEdge) {
        return (int) ((long) referencePx * shortEdge / REFERENCE_SHORT_EDGE);
    }

    /** Same square-root curve as the older adaptive text size, based on the short edge. */
    public static int scaleText(double referenceSize, int shortEdge) {
        return (int) (referenceSize * Math.sqrt(shortEdge / (double) REFERENCE_SHORT_EDGE));
    }

    /** Orientation independent: only the shorter of the two edges matters. */
    public static Metrics compute(int screenWidth, int screenHeight) {
        if (screenWidth <= 0 || screenHeight <= 0) {
            throw new IllegalArgumentException("Screen size must be positive: " + screenWidth + "x" + screenHeight);
        }
        return new Metrics(Math.min(screenWidth, screenHeight));
    }
}
