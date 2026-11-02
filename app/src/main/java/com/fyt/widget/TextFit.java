package com.fyt.widget;

/**
 * Size rule for the date / week day text of the widgets that are not set up for the AppCompat
 * autosize. Pure Java so it is unit-tested on the JVM.
 */
public final class TextFit {

    /** Leaves a little air so the glyph edges do not touch the end of the column. */
    private static final float SAFETY = 0.95f;

    private TextFit() {
    }

    /**
     * Text size that fits a line of {@code availableWidth}. The maximum is only ever lowered: a
     * text that fits is returned at the maximum, so a shorter text after a longer one (the week
     * day changing at midnight) grows back.
     *
     * @param maxSize         size the text is allowed to have
     * @param textWidthAtMax  width of the text measured at {@code maxSize}
     * @param availableWidth  width of the line, padding already taken off
     */
    public static float fit(float maxSize, float textWidthAtMax, float availableWidth) {
        if (availableWidth <= 0f || textWidthAtMax <= 0f || textWidthAtMax < availableWidth) {
            return maxSize;
        }
        return maxSize * (availableWidth / textWidthAtMax) * SAFETY;
    }
}
