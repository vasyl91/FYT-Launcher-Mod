package com.android.launcher66;

/**
 * How the music widget divides the room it has: the sizes of the cover, the text rows, the
 * progress bar and the buttons, worked out from the widget's own size (not the screen's). Kept
 * free of views so the arithmetic can be tested; {@link MusicWidgetSizer} applies the result.
 *
 * Every constant here is a value to tune against the tester's screenshots.
 */
final class MusicWidgetPlan {

    /** Height of a text row / font size in px (font metrics plus padding). */
    static final float LINE_FACTOR = 1.3f;

    /** Below this the home widget drops a step (two rows, one row, one row without the cover). */
    static final float MIN_TEXT_SP = 12f;

    /** Never less (as BAR_TEXT_MIN_SP in Workspace). */
    static final float MIN_TEXT_SP_FLOOR = 8f;

    /** A button is this share of the smaller side of its cell. */
    static final float BUTTON_FILL = 0.8f;

    // Home widget, shares of the height (each set adds up to 1):
    /** Cover, two text rows, progress, buttons, gaps. */
    static final float[] HOME_STANDARD = {0.38f, 0.13f, 0.13f, 0.04f, 0.24f, 0.08f};

    /** Cover, one text row, progress, buttons, gaps. */
    static final float[] HOME_COMPACT = {0.44f, 0.17f, 0.04f, 0.27f, 0.08f};

    /** One text row, progress, buttons, gaps. */
    static final float[] HOME_NO_COVER = {0.30f, 0.06f, 0.52f, 0.12f};

    // Bar, the column right of the cover, shares of the height:
    /** Two text rows, buttons, gaps. */
    static final float[] BAR_STANDARD = {0.25f, 0.25f, 0.45f, 0.05f};

    /**
     * One text row, buttons, gaps. The row takes what the buttons and the gap leave (the first
     * number is only that), so that it is centred in the room above the buttons.
     */
    static final float[] BAR_COMPACT = {0.42f, 0.52f, 0.06f};

    // Large text (settings 'Large text' of the widget bar): the text rows get a bigger share of
    // the height and the font a smaller line factor, at the cost of the buttons' row and the gaps.
    /** Two text rows, buttons, gaps. */
    static final float[] BAR_STANDARD_LARGE = {0.30f, 0.30f, 0.35f, 0.05f};

    /** One text row, buttons, gaps. */
    static final float[] BAR_COMPACT_LARGE = {0.50f, 0.44f, 0.06f};

    /** Height of a text row / font size in px with large text. */
    static final float LINE_FACTOR_LARGE = 1.2f;

    /**
     * One line of text: the box of the font (ascent to descent) is this share of the height of the
     * line's row; with 'Large text' in the usual layout it is the share
     * {@link #ONE_LINE_BOX_LARGE} (the whole height that is there to be used). Beside the buttons
     * 'Large text' is the size the text used to have without it (see {@link #planBarWide}).
     */
    static final float ONE_LINE_BOX = 0.60f;

    static final float ONE_LINE_BOX_LARGE = 0.95f;

    /**
     * (descent - ascent) / text size of the usual fonts, for a plan made without the metrics of the
     * view's font (the sizer measures them and calls {@link Plan#withFont}).
     */
    static final float DEFAULT_FONT_RATIO = 1.17f;

    /**
     * The shape of a font per unit of text size: the height of its box (descent - ascent), of a
     * capital letter, and its ascent above the baseline. The sizer measures them once for the
     * typeface of the text view; {@link #DEFAULT_FONT} is Roboto's.
     */
    static final class FontShape {
        final float boxRatio;
        final float capRatio;
        final float ascentRatio;

        FontShape(float boxRatio, float capRatio, float ascentRatio) {
            this.boxRatio = boxRatio;
            this.capRatio = capRatio;
            this.ascentRatio = ascentRatio;
        }
    }

    static final FontShape DEFAULT_FONT = new FontShape(DEFAULT_FONT_RATIO, 0.711f, 0.928f);

    /**
     * The cover of a bar is at most this share of the bar's height and of its usual width W0: the
     * width the widget has with no widget of the bar hidden, so that the cover keeps its size and
     * its place whatever the settings hide.
     */
    static final float BAR_COVER_HEIGHT = 0.86f;

    static final float BAR_COVER_WIDTH = 0.25f;

    /** The space between the cover and the column in a bar, as a share of its usual width W0. */
    static final float BAR_COLUMN_GAP = 0.03f;

    // Bar, wide (the date or the weather is hidden and the widget has their room): the text sits
    // between the cover and a block of buttons on the right. Nothing is below the text, so the
    // rows may use the height of the column.
    /** Two text rows, gaps. */
    static final float[] BAR_WIDE_STANDARD = {0.45f, 0.45f, 0.10f};

    /**
     * With the buttons beside the text, what is left of the widget right of the cover and its gap
     * (R) is divided between the text and the block of buttons. The block is 2 x 2 and takes 35%
     * of R; with 'Buttons in one line' it is one row of four and takes 40% (the text keeps the
     * rest, rounding included).
     */
    static final float BAR_BESIDE_BUTTONS_SHARE = 0.35f;

    static final float BAR_BESIDE_BUTTONS_ONE_ROW_SHARE = 0.40f;

    /** The cover of the home widget is at most this share of its width. */
    static final float HOME_COVER_WIDTH = 0.9f;

    static final class Plan {
        /** One text row ("artist - title") instead of two. */
        boolean compact;
        boolean cover;
        int coverPx;
        int rowPx;
        float textPx;
        int progressPx;
        int buttonRowPx;
        int buttonSidePx;
        int gapPx;
        /**
         * Width of the column right of the cover (the bar only): all of R below the text, the text's
         * share of it with the buttons beside.
         */
        int columnPx;
        /** The space between the cover and the column (the bar only). */
        int coverGapPx;
        /** What is left of the widget right of the cover and its gap (the bar only). */
        int restPx;
        boolean largeText;
        boolean oneLine;
        /** Top margin of a text row: the gap, and none for the one line, which is centred. */
        int rowTopPx;
        /** One line: the height the box of the font (ascent to descent) may have. */
        float fontBoxPx;
        /** One line: top padding of the text view that puts the capital letters in the middle of the row. */
        int textTopPaddingPx;
        /** One line: the distance from the top of the row to the top of a capital letter. */
        int capTopPx;
        /**
         * The row of buttons below the text, in the usual layout: its top margin, its height and
         * its bottom margin. With two lines the row of buttons is {@code buttonRowPx} high with the
         * gap on top; with one line it is as high as the buttons and the room that is left over
         * them below goes to the text (see planBar).
         */
        int buttonsTopPx;
        int buttonsHeightPx;
        int buttonsBottomPx;
        /** One line, usual layout: the top of the visible buttons, which is the height of the text row. */
        int yButtonsPx;

        /** The wide bar: the buttons are a block beside the text (see planBarWide). */
        boolean wide;
        /** Width of the block of buttons (the wide bar only). */
        int buttonBlockPx;
        /** Rows of buttons in the block: 2 (2 x 2), or 1 (a row of four) with 'Buttons in one line'. */
        int buttonRows;
        /** Width of a cell of the block. */
        int cellWidthPx;

        int rows() {
            return compact ? 1 : 2;
        }

        /**
         * The text size and the place of the letters for the one line, from the shape of the font
         * the view really has: the box of the font is {@code boxRatio} times the size, so the size
         * is the box divided by it. Two lines keep the size the plan gave them.
         */
        Plan withFont(FontShape font, float density) {
            if (fontBoxPx > 0f && font.boxRatio > 0f) {
                textPx = textForBox(fontBoxPx, font.boxRatio, density);
            }
            if (oneLine && fontBoxPx > 0f) {
                float capH = font.capRatio * textPx;
                capTopPx = Math.round((rowPx - capH) / 2f);
                textTopPaddingPx = oneLineTopPadding(rowPx, capH, font.ascentRatio * textPx);
            }
            return this;
        }

        @Override
        public String toString() {
            if (wide) {
                return "layout=beside oneLine=" + oneLine + " large=" + largeText + " cover=" + coverPx + "+"
                        + coverGapPx + " R=" + restPx + " text=" + columnPx + " buttons=" + buttonBlockPx
                        + "(" + (buttonRows == 1 ? "1x4" : "2x2") + ") row=" + rowPx + " textPx=" + textPx + " cell="
                        + cellWidthPx + "x" + buttonRowPx + "/" + buttonSidePx + " gap=" + gapPx + " capTop=" + capTopPx;
            }
            if (columnPx > 0) {
                return "layout=below oneLine=" + oneLine + " large=" + largeText + " cover=" + coverPx + "+"
                        + coverGapPx + " R=" + restPx + " text=" + columnPx + " buttons=" + columnPx
                        + "(1x4) row=" + rowPx + " textPx=" + textPx + " buttonRow=" + buttonRowPx + "/"
                        + buttonSidePx + " gap=" + gapPx + " yButtons=" + yButtonsPx + " capTop=" + capTopPx;
            }
            return "compact=" + compact + " cover=" + cover + "(" + coverPx + ") row=" + rowPx
                    + " text=" + textPx + " progress=" + progressPx + " buttons=" + buttonRowPx
                    + "/" + buttonSidePx + " gap=" + gapPx;
        }
    }

    private MusicWidgetPlan() {
    }

    /**
     * The top padding of a text view {@code rowH} high (font padding off, gravity top) that puts
     * the capital letters in the middle of the row: the baseline is at (rowH + capH) / 2 from the
     * top, so the space above the capitals and the space below the baseline are equal. Letters
     * sit high in the box of the font (the descent below the baseline is empty for most of
     * them), so centring the box itself would raise them. Never negative.
     */
    static int oneLineTopPadding(float rowH, float capH, float ascent) {
        float baseline = (rowH + capH) / 2f;
        return Math.max(0, Math.round(baseline - ascent));
    }

    /** The text size whose font box ({@code ratio} times the size) is {@code boxPx} high. */
    static float textForBox(float boxPx, float ratio, float density) {
        return Math.max(boxPx / ratio, MIN_TEXT_SP_FLOOR * density);
    }

    /** The shares are truncated, never rounded, so that the parts never add up to more than h. */
    private static int part(int h, float share) {
        return (int) (h * share);
    }

    /**
     * The home widget. {@code density} is px per sp; {@code maxTextPx} the size a large widget
     * reaches (the artist gets the size of the title).
     */
    static Plan planHome(int w, int h, float density, float maxTextPx) {
        float minText = MIN_TEXT_SP * density;
        Plan plan = new Plan();
        plan.compact = false;
        plan.cover = true;
        plan.rowPx = part(h, HOME_STANDARD[1]);
        plan.textPx = Math.min(plan.rowPx / LINE_FACTOR, maxTextPx);
        float[] shares = HOME_STANDARD;
        int elements = 5;
        if (plan.textPx < minText) {
            plan.compact = true;
            plan.rowPx = part(h, HOME_COMPACT[1]);
            plan.textPx = Math.min(plan.rowPx / LINE_FACTOR, maxTextPx);
            shares = HOME_COMPACT;
            elements = 4;
            if (plan.textPx < minText) {
                plan.cover = false;
                plan.rowPx = part(h, HOME_NO_COVER[0]);
                plan.textPx = Math.min(plan.rowPx / LINE_FACTOR, maxTextPx);
                shares = HOME_NO_COVER;
                elements = 3;
            }
        }
        plan.textPx = Math.max(plan.textPx, MIN_TEXT_SP_FLOOR * density);
        if (!plan.compact) {
            plan.progressPx = part(h, shares[3]);
            plan.buttonRowPx = part(h, shares[4]);
            plan.gapPx = part(h, shares[5] / elements);
        } else if (plan.cover) {
            plan.progressPx = part(h, shares[2]);
            plan.buttonRowPx = part(h, shares[3]);
            plan.gapPx = part(h, shares[4] / elements);
        } else {
            plan.progressPx = part(h, shares[1]);
            plan.buttonRowPx = part(h, shares[2]);
            plan.gapPx = part(h, shares[3] / elements);
        }
        if (plan.cover) {
            plan.coverPx = Math.min(part(h, shares[0]), part(w, HOME_COVER_WIDTH));
        }
        plan.buttonSidePx = Math.round(Math.min(plan.buttonRowPx, w / 4f) * BUTTON_FILL);
        plan.rowTopPx = plan.gapPx;
        return plan;
    }

    /**
     * The usual width W0 of the widget of a bar, from the width it has now: the same widget with no
     * widget of the bar hidden. The cover and the space behind it are worked out from W0, never
     * from the widened width, so they are the same whatever the settings hide.
     */
    static int usualWidth(int w, float baseShare, float musicShare) {
        if (w <= 0 || baseShare <= 0f || musicShare <= baseShare) {
            return w;
        }
        return Math.min(w, Math.round(w * baseShare / musicShare));
    }

    /** The cover of a bar and the space behind it, for a widget of usual width W0 and height h. */
    private static void placeCover(Plan plan, int w, int h, int baseW) {
        int w0 = baseW > 0 ? Math.min(baseW, w) : w;
        plan.cover = true;
        plan.coverPx = Math.min(part(h, BAR_COVER_HEIGHT), part(w0, BAR_COVER_WIDTH));
        plan.coverGapPx = part(w0, BAR_COLUMN_GAP);
        plan.restPx = Math.max(0, w - plan.coverPx - plan.coverGapPx);
    }

    /**
     * The bar with the buttons below the text. {@code oneLine} is the user's choice (the setting
     * 'Title and artist in one line'): one text row ("artist - title") instead of two, on every
     * bar height. {@code baseW} is the usual width W0 of the widget (see {@link #usualWidth}); with
     * nothing hidden it equals {@code w}. The column right of the cover is all that is left of w.
     */
    static Plan planBar(int w, int h, int baseW, float density, boolean largeText, boolean oneLine) {
        Plan plan = new Plan();
        plan.compact = oneLine;
        plan.oneLine = oneLine;
        plan.largeText = largeText;
        placeCover(plan, w, h, baseW);
        plan.columnPx = plan.restPx;
        float[] shares = largeText
                ? (plan.compact ? BAR_COMPACT_LARGE : BAR_STANDARD_LARGE)
                : (plan.compact ? BAR_COMPACT : BAR_STANDARD);
        plan.buttonRowPx = part(h, plan.compact ? shares[1] : shares[2]);
        plan.gapPx = part(h, shares[shares.length - 1] / (plan.rows() + 1));
        float lineFactor = largeText ? LINE_FACTOR_LARGE : LINE_FACTOR;
        plan.buttonSidePx = Math.round(Math.min(plan.buttonRowPx, plan.columnPx / 4f) * BUTTON_FILL);
        if (largeText) {
            // The buttons are not smaller than today's, as far as their (now lower) row allows.
            float[] usual = plan.compact ? BAR_COMPACT : BAR_STANDARD;
            int usualRow = part(h, plan.compact ? usual[1] : usual[2]);
            int usualSide = Math.round(Math.min(usualRow, plan.columnPx / 4f) * BUTTON_FILL);
            plan.buttonSidePx = Math.max(plan.buttonSidePx, Math.min(usualSide, plan.buttonRowPx));
        }
        if (oneLine) {
            // The visible buttons are lower than their row and stand in its middle, so the row has
            // empty room over them. The text takes everything above the buttons themselves: the
            // row of buttons is as high as they are, with the room left over them below it, and
            // they stay exactly where they were. The line is centred in what is above them.
            plan.buttonsHeightPx = plan.buttonSidePx;
            plan.buttonsTopPx = 0;
            plan.buttonsBottomPx = Math.max(0, (plan.buttonRowPx - plan.buttonSidePx) / 2);
            plan.yButtonsPx = Math.max(0, h - plan.buttonsHeightPx - plan.buttonsBottomPx);
            plan.rowTopPx = 0;
            plan.rowPx = plan.yButtonsPx;
            plan.fontBoxPx = plan.rowPx * (largeText ? ONE_LINE_BOX_LARGE : ONE_LINE_BOX);
            plan.textPx = textForBox(plan.fontBoxPx, DEFAULT_FONT_RATIO, density);
        } else {
            plan.rowTopPx = plan.gapPx;
            plan.rowPx = part(h, shares[0]);
            plan.textPx = Math.max(plan.rowPx / lineFactor, MIN_TEXT_SP_FLOOR * density);
            plan.buttonsTopPx = plan.gapPx;
            plan.buttonsHeightPx = plan.buttonRowPx;
            plan.buttonsBottomPx = 0;
        }
        return plan;
    }

    /**
     * The usual text of the bar at this height: the one line of the usual layout without 'Large
     * text'. The layout with the buttons beside the text takes its text size (and the box of its
     * font) from this plan, so that the two cannot drift apart.
     */
    static Plan belowOneLine(int w, int h, int baseW, float density) {
        return planBar(w, h, baseW, density, false, true);
    }

    /**
     * The bar with the buttons beside the text: cover, then the text (title above artist, or one
     * row with {@code oneLine}) in 65% of what is left (R), then a block of buttons in the other
     * 35%. The block is 2 x 2 (prev and next above play/pause and favorite), on every bar height
     * and with one line or two. With {@code buttonsOneRow} ('Buttons in one line') it is one row
     * of four (prev, play/pause, next, favorite) and takes 40% of R, the text 60%. The text is
     * smaller here than the room would allow: the usual size is that of the one line of the usual
     * layout, and 'Large text' is the size the usual text used to have here.
     */
    static Plan planBarWide(int w, int h, int baseW, float density, boolean largeText, boolean oneLine,
                            boolean buttonsOneRow) {
        Plan plan = new Plan();
        plan.wide = true;
        plan.compact = oneLine;
        plan.oneLine = oneLine;
        plan.largeText = largeText;
        placeCover(plan, w, h, baseW);
        // The block is a whole number of cells wide, each a whole number of px. A block of an odd
        // width with cells of 50% each would round both cells up (52.5 -> 53 + 53 = 106 > 105),
        // the second cell would not fit and the flexbox would wrap to one button per row.
        int cells = buttonsOneRow ? 4 : 2;
        float share = buttonsOneRow ? BAR_BESIDE_BUTTONS_ONE_ROW_SHARE : BAR_BESIDE_BUTTONS_SHARE;
        plan.cellWidthPx = (int) (plan.restPx * share) / cells;
        plan.buttonBlockPx = cells * plan.cellWidthPx;
        plan.buttonRows = buttonsOneRow ? 1 : 2;
        plan.columnPx = plan.restPx - plan.buttonBlockPx;
        // The rows keep the heights they always had; the size of the text is what differs, and it
        // is the same for one line and for two. Usual text: the size of the one line of the usual
        // layout at the same h ({@link #belowOneLine}, the very function that sizes it there, so the two
        // layouts cannot drift apart). 'Large text': the size the usual text used to have here: the
        // box of the font is 0.60 of the height with one line, and a row of 0.45 of the height
        // over the line factor with two.
        Plan below = belowOneLine(w, h, baseW, density);
        float[] shares = BAR_WIDE_STANDARD;
        if (oneLine) {
            // The line has the whole height of the column and no margin: it is centred in it.
            plan.rowTopPx = 0;
            plan.rowPx = h;
            plan.gapPx = 0;
        } else {
            plan.rowPx = part(h, shares[0]);
            plan.gapPx = part(h, shares[shares.length - 1] / (plan.rows() + 1));
            plan.rowTopPx = plan.gapPx;
        }
        if (!largeText) {
            plan.fontBoxPx = below.fontBoxPx;
            plan.textPx = below.textPx;
        } else if (oneLine) {
            plan.fontBoxPx = plan.rowPx * ONE_LINE_BOX;
            plan.textPx = textForBox(plan.fontBoxPx, DEFAULT_FONT_RATIO, density);
        } else {
            plan.textPx = Math.max(plan.rowPx / LINE_FACTOR, MIN_TEXT_SP_FLOOR * density);
        }
        plan.buttonRowPx = buttonsOneRow ? h : h / 2;
        plan.buttonSidePx = Math.round(Math.min(plan.cellWidthPx, plan.buttonRowPx) * BUTTON_FILL);
        return plan;
    }
}
