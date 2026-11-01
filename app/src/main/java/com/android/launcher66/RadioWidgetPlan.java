package com.android.launcher66;

/**
 * How the radio widget divides the room it has, worked out from the widget's own size (not the
 * screen's), as {@link MusicWidgetPlan} does for the music widget. Three columns side by side:
 * band label over the "previous" button, the frequency, unit label over the "next" button. Kept
 * free of views so the arithmetic can be tested; {@link RadioWidgetSizer} applies the result.
 *
 * The text widths come in as "px of width per px of text size" (the sizer measures the widest
 * texts the widget can show with the widget's own font), so the frequency is as large as fits
 * both the height and the width that is left for it.
 */
final class RadioWidgetPlan {

    /** Height of a text row / font size in px (font metrics plus padding). */
    static final float LINE_FACTOR = 1.3f;

    /** Padding on every side, as a share of the shorter side of the widget. */
    static final float PADDING = 0.06f;

    /** Space between the label and the button, and between the columns, as a share of the inner height. */
    static final float GAP = 0.05f;

    /** The label row of a side column, as a share of the inner height. */
    static final float LABEL_ROW = 0.28f;

    /** The button of a side column is at most this share of the inner height ... */
    static final float BUTTON_HEIGHT = 0.6f;

    /** ... and at most this share of the widget's width. */
    static final float BUTTON_WIDTH = 0.2f;

    /** The frequency row is at most this share of the inner height. */
    static final float FREQ_ROW = 0.9f;

    /** Never smaller than this (sp). */
    static final float MIN_TEXT_SP = 8f;

    static final class Plan {
        int paddingPx;
        int gapPx;
        /** Width of each side column. */
        int columnPx;
        int labelRowPx;
        float labelTextPx;
        int buttonPx;
        float freqTextPx;

        @Override
        public String toString() {
            return "padding=" + paddingPx + " gap=" + gapPx + " column=" + columnPx
                    + " label=" + labelRowPx + "/" + labelTextPx + " button=" + buttonPx
                    + " freq=" + freqTextPx;
        }
    }

    private RadioWidgetPlan() {
    }

    /**
     * @param w             inner width of the widget's root in px
     * @param h             inner height of the widget's root in px
     * @param density       px per sp
     * @param labelPerPx    width of the widest label ("MHz", "FM"...) per px of text size
     * @param freqPerPx     width of the widest frequency ("108.00") per px of text size
     */
    static Plan plan(int w, int h, float density, float labelPerPx, float freqPerPx) {
        Plan plan = new Plan();
        float minText = MIN_TEXT_SP * density;
        plan.paddingPx = part(Math.min(w, h), PADDING);
        int innerW = Math.max(0, w - 2 * plan.paddingPx);
        int innerH = Math.max(0, h - 2 * plan.paddingPx);
        plan.gapPx = part(innerH, GAP);

        plan.labelRowPx = part(innerH, LABEL_ROW);
        plan.labelTextPx = Math.max(plan.labelRowPx / LINE_FACTOR, minText);
        int buttonRoom = Math.max(0, innerH - plan.labelRowPx - plan.gapPx);
        plan.buttonPx = Math.min(buttonRoom,
                Math.min(part(innerH, BUTTON_HEIGHT), part(w, BUTTON_WIDTH)));

        // The label must fit its column: a narrow widget makes the label smaller, not wider.
        int labelWidth = Math.round(plan.labelTextPx * labelPerPx);
        plan.columnPx = Math.max(plan.buttonPx, labelWidth);
        int maxColumn = part(innerW, 0.25f);
        if (plan.columnPx > maxColumn && labelPerPx > 0f) {
            plan.columnPx = Math.max(plan.buttonPx, maxColumn);
            plan.labelTextPx = Math.max(Math.min(plan.labelTextPx, plan.columnPx / labelPerPx), minText);
        }

        int freqWidth = Math.max(0, innerW - 2 * plan.columnPx - 2 * plan.gapPx);
        float byHeight = part(innerH, FREQ_ROW) / LINE_FACTOR;
        float byWidth = freqPerPx > 0f ? freqWidth / freqPerPx : byHeight;
        plan.freqTextPx = Math.max(Math.min(byHeight, byWidth), minText);
        return plan;
    }

    private static int part(int size, float share) {
        return Math.round(size * share);
    }
}
