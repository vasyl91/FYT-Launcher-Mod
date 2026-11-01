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

    /** The bar goes to one text row when it is at most this share of the screen's shorter side. */
    static final float BAR_COMPACT_MAX_FRACTION = 0.12f;

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

    /** The cover of a bar is at most this share of the bar's height and of its width. */
    static final float BAR_COVER_HEIGHT = 0.86f;

    static final float BAR_COVER_WIDTH = 0.25f;

    /** The space between the cover and the column in a bar, as a share of its width. */
    static final float BAR_COLUMN_GAP = 0.03f;

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
        /** Width of the column right of the cover (the bar only). */
        int columnPx;

        int rows() {
            return compact ? 1 : 2;
        }

        @Override
        public String toString() {
            return "compact=" + compact + " cover=" + cover + "(" + coverPx + ") row=" + rowPx
                    + " text=" + textPx + " progress=" + progressPx + " buttons=" + buttonRowPx
                    + "/" + buttonSidePx + " gap=" + gapPx;
        }
    }

    private MusicWidgetPlan() {
    }

    /** Integer arithmetic: 0.12 as a float is off at the boundary. */
    static boolean barCompact(int barHeightPx, int shortSidePx) {
        return shortSidePx > 0 && (long) barHeightPx * 100 <= (long) shortSidePx * 12;
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
     * The bar. {@code barHeightPx} is the bar's height from the settings (what Workspace uses),
     * {@code shortSidePx} the shorter side of the screen; the widget's own h can differ from the
     * bar's while it lays out.
     */
    static Plan planBar(int w, int h, int barHeightPx, int shortSidePx, float density) {
        Plan plan = new Plan();
        plan.compact = barCompact(barHeightPx, shortSidePx);
        plan.cover = true;
        plan.coverPx = Math.min(part(h, BAR_COVER_HEIGHT), part(w, BAR_COVER_WIDTH));
        plan.columnPx = w - plan.coverPx - part(w, BAR_COLUMN_GAP);
        float[] shares = plan.compact ? BAR_COMPACT : BAR_STANDARD;
        plan.rowPx = part(h, shares[0]);
        plan.buttonRowPx = part(h, plan.compact ? shares[1] : shares[2]);
        plan.gapPx = part(h, shares[shares.length - 1] / (plan.rows() + 1));
        plan.textPx = Math.max(plan.rowPx / LINE_FACTOR, MIN_TEXT_SP_FLOOR * density);
        plan.buttonSidePx = Math.round(Math.min(plan.buttonRowPx, plan.columnPx / 4f) * BUTTON_FILL);
        return plan;
    }
}
