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

    /** One text row, buttons, gaps. */
    static final float[] BAR_COMPACT = {0.42f, 0.52f, 0.06f};

    // Large text (settings 'Large text' of the widget bar): the text rows get a bigger share of
    // the height and the font a smaller line factor, at the cost of the buttons' row and the gaps.
    /** Two text rows, buttons, gaps. */
    static final float[] BAR_STANDARD_LARGE = {0.30f, 0.30f, 0.35f, 0.05f};

    /** One text row, buttons, gaps. */
    static final float[] BAR_COMPACT_LARGE = {0.50f, 0.44f, 0.06f};

    /** Height of a text row / font size in px with large text. */
    static final float LINE_FACTOR_LARGE = 1.2f;

    /** The wide bar with large text: the rows fill the whole height of the column. */
    static final float[] BAR_WIDE_STANDARD_LARGE = {0.50f, 0.50f, 0.00f};

    static final float[] BAR_WIDE_COMPACT_LARGE = {0.80f, 0.20f};

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

    /** One text row, gaps. */
    static final float[] BAR_WIDE_COMPACT = {0.70f, 0.30f};

    /**
     * With the buttons beside the text, what is left of the widget right of the cover and its gap
     * (R) is divided in these shares: the text (title and artist, or one line) and the block of
     * buttons, which is always 2 x 2. The rounding left over goes to the text.
     */
    static final float BAR_BESIDE_TEXT_SHARE = 0.65f;

    static final float BAR_BESIDE_BUTTONS_SHARE = 0.35f;

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

        /** The wide bar: the buttons are a block beside the text (see planBarWide). */
        boolean wide;
        /** Width of the block of buttons (the wide bar only). */
        int buttonBlockPx;
        /** Rows of buttons in the block: always 2 (2 x 2). */
        int buttonRows;
        /** Width of a cell of the block. */
        int cellWidthPx;

        int rows() {
            return compact ? 1 : 2;
        }

        @Override
        public String toString() {
            if (wide) {
                return "layout=beside oneLine=" + oneLine + " large=" + largeText + " cover=" + coverPx + "+"
                        + coverGapPx + " R=" + restPx + " text=" + columnPx + " buttons=" + buttonBlockPx
                        + "(" + buttonRows + "x2) row=" + rowPx + " textPx=" + textPx + " cell="
                        + cellWidthPx + "x" + buttonRowPx + "/" + buttonSidePx + " gap=" + gapPx;
            }
            if (columnPx > 0) {
                return "layout=below oneLine=" + oneLine + " large=" + largeText + " cover=" + coverPx + "+"
                        + coverGapPx + " R=" + restPx + " text=" + columnPx + " buttons=" + columnPx
                        + "(1x4) row=" + rowPx + " textPx=" + textPx + " buttonRow=" + buttonRowPx + "/"
                        + buttonSidePx + " gap=" + gapPx;
            }
            return "compact=" + compact + " cover=" + cover + "(" + coverPx + ") row=" + rowPx
                    + " text=" + textPx + " progress=" + progressPx + " buttons=" + buttonRowPx
                    + "/" + buttonSidePx + " gap=" + gapPx;
        }
    }

    private MusicWidgetPlan() {
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
        plan.rowPx = part(h, shares[0]);
        plan.buttonRowPx = part(h, plan.compact ? shares[1] : shares[2]);
        plan.gapPx = part(h, shares[shares.length - 1] / (plan.rows() + 1));
        float lineFactor = largeText ? LINE_FACTOR_LARGE : LINE_FACTOR;
        plan.textPx = Math.max(plan.rowPx / lineFactor, MIN_TEXT_SP_FLOOR * density);
        plan.buttonSidePx = Math.round(Math.min(plan.buttonRowPx, plan.columnPx / 4f) * BUTTON_FILL);
        if (largeText) {
            // The buttons are not smaller than today's, as far as their (now lower) row allows.
            float[] usual = plan.compact ? BAR_COMPACT : BAR_STANDARD;
            int usualRow = part(h, plan.compact ? usual[1] : usual[2]);
            int usualSide = Math.round(Math.min(usualRow, plan.columnPx / 4f) * BUTTON_FILL);
            plan.buttonSidePx = Math.max(plan.buttonSidePx, Math.min(usualSide, plan.buttonRowPx));
        }
        return plan;
    }

    /**
     * The bar with the buttons beside the text: cover, then the text (title above artist, or one
     * row with {@code oneLine}) in 65% of what is left (R), then a block of buttons in the other
     * 35%. The block is always 2 x 2 (prev and next above play/pause and favorite), on every bar
     * height and with one line or two. With 'Large text' the rows fill the whole height of the
     * column (two halves, or 0.8 of it with one line) and the font has the smaller line factor.
     */
    static Plan planBarWide(int w, int h, int baseW, float density, boolean largeText, boolean oneLine) {
        Plan plan = new Plan();
        plan.wide = true;
        plan.compact = oneLine;
        plan.oneLine = oneLine;
        plan.largeText = largeText;
        placeCover(plan, w, h, baseW);
        plan.buttonBlockPx = (int) (plan.restPx * BAR_BESIDE_BUTTONS_SHARE);
        plan.buttonRows = 2;
        plan.columnPx = plan.restPx - plan.buttonBlockPx;
        float[] shares = largeText
                ? (plan.compact ? BAR_WIDE_COMPACT_LARGE : BAR_WIDE_STANDARD_LARGE)
                : (plan.compact ? BAR_WIDE_COMPACT : BAR_WIDE_STANDARD);
        plan.rowPx = part(h, shares[0]);
        plan.gapPx = part(h, shares[shares.length - 1] / (plan.rows() + 1));
        float lineFactor = largeText ? LINE_FACTOR_LARGE : LINE_FACTOR;
        plan.textPx = Math.max(plan.rowPx / lineFactor, MIN_TEXT_SP_FLOOR * density);
        plan.cellWidthPx = plan.buttonBlockPx / 2;
        plan.buttonRowPx = h / 2;
        plan.buttonSidePx = Math.round(Math.min(plan.cellWidthPx, plan.buttonRowPx) * BUTTON_FILL);
        return plan;
    }
}
