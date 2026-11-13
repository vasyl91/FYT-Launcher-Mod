package com.android.launcher66;

/**
 * The cell grid of a page of the home screen: how many cells it has and where on the page they lie.
 *
 * <p><b>The setting.</b> The user chooses the number of cells along the long edge of the screen and along the
 * short one ({@link #DEFAULT_LONG} and {@link #DEFAULT_SHORT} are the grid the launcher always had: ten by six).
 * Columns are the long edge in landscape and the short one in portrait, rows the other way, so the same screen
 * has the same grid whichever word names an edge. Each number can go two below and four above its default.
 *
 * <p><b>The bars.</b> A bar that stays on a page takes its strip out of the page, and the cells share what is
 * left: a page with the vertical bar has one column fewer, a page with the horizontal bar (one that does not
 * hide itself) one row fewer, and the remaining cells are spread evenly over the remaining area. Nothing can
 * then be put under a bar, on any page, shown or not, while dragging and in the overview alike: the strip is
 * not part of the grid. Before this the bar's row was only left out of the search for a free cell, on the
 * page being looked at, and the vertical bar took nothing at all, so icons lay under both. The size of an
 * icon does not depend on the grid; only the distance between icons does.
 *
 * <p>An auto-hide bar takes no row. Its handle keeps one corner cell ({@link #cornerCell}), unless the
 * vertical bar is on the handle's side: then the handle and the collapsed bar's button lie in the vertical
 * bar's strip, which is no cell.
 *
 * <p><b>Where a cell lies.</b> A cell's number counts from the first cell beside the bars. {@link Cells#offsetX}
 * and {@link Cells#offsetY} say how many columns and rows of the page without bars lie before that first cell
 * (one where a bar is at the left or at the top), which is what lets an item keep its place on the screen
 * when a bar is switched on or moved ({@link GridOverflow}). Pure Java, so that it has a test.
 */
public final class WorkspaceGrid {

    public static final int DEFAULT_LONG = 10;
    public static final int DEFAULT_SHORT = 6;
    public static final int MIN_LONG = DEFAULT_LONG - 2;
    public static final int MAX_LONG = DEFAULT_LONG + 4;
    public static final int MIN_SHORT = DEFAULT_SHORT - 2;
    public static final int MAX_SHORT = DEFAULT_SHORT + 4;

    private WorkspaceGrid() {
    }

    public static int clampLong(int cells) {
        return Math.max(MIN_LONG, Math.min(MAX_LONG, cells));
    }

    public static int clampShort(int cells) {
        return Math.max(MIN_SHORT, Math.min(MAX_SHORT, cells));
    }

    /** The columns of a page without bars. */
    public static int columns(boolean landscape, int longCells, int shortCells) {
        return landscape ? clampLong(longCells) : clampShort(shortCells);
    }

    /** The rows of a page without bars. */
    public static int rows(boolean landscape, int longCells, int shortCells) {
        return landscape ? clampShort(shortCells) : clampLong(longCells);
    }

    /** The cells of one page: their number, and how many columns and rows a bar takes before the first one. */
    public static final class Cells {
        public final int countX;
        public final int countY;
        public final int offsetX;
        public final int offsetY;

        public Cells(int countX, int countY, int offsetX, int offsetY) {
            this.countX = countX;
            this.countY = countY;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        /** Whether an item of this span at this cell lies wholly in the grid. */
        public boolean holds(int cellX, int cellY, int spanX, int spanY) {
            return cellX >= 0 && cellY >= 0 && spanX >= 1 && spanY >= 1
                    && cellX + spanX <= countX && cellY + spanY <= countY;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cells)) {
                return false;
            }
            Cells c = (Cells) o;
            return countX == c.countX && countY == c.countY && offsetX == c.offsetX && offsetY == c.offsetY;
        }

        @Override
        public int hashCode() {
            return ((countX * 31 + countY) * 31 + offsetX) * 31 + offsetY;
        }

        @Override
        public String toString() {
            return countX + "x" + countY + "+" + offsetX + "+" + offsetY;
        }

        /** The reverse of {@link #toString()}; null for anything else. */
        static Cells parse(String text) {
            if (text == null) {
                return null;
            }
            String[] parts = text.split("[x+]");
            if (parts.length != 4) {
                return null;
            }
            try {
                Cells cells = new Cells(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                return cells.countX >= 1 && cells.countY >= 1 && cells.offsetX >= 0 && cells.offsetY >= 0
                        ? cells : null;
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    /**
     * @param columns       the columns of a page without bars
     * @param rows          the rows of a page without bars
     * @param verticalBar   the vertical bar is on this page
     * @param right         the vertical bar is on the right
     * @param horizontalRow the horizontal bar is on this page and does not hide itself
     * @param top           the horizontal bar is at the top
     */
    public static Cells cells(int columns, int rows, boolean verticalBar, boolean right,
                              boolean horizontalRow, boolean top) {
        boolean column = verticalBar && columns > 1;
        boolean row = horizontalRow && rows > 1;
        return new Cells(column ? columns - 1 : columns, row ? rows - 1 : rows,
                column && !right ? 1 : 0, row && top ? 1 : 0);
    }

    /**
     * The strips the bars take from the page, in pixels: {left, top, right, bottom}. The cells share the rest.
     * The parameters are those of {@link #cells}; a bar that takes no column or row there takes no strip here.
     */
    public static int[] insets(int columns, int rows, boolean verticalBar, boolean right, int verticalBarWidth,
                               boolean horizontalRow, boolean top, int barHeight) {
        int width = verticalBar && columns > 1 ? Math.max(0, verticalBarWidth) : 0;
        int height = horizontalRow && rows > 1 ? Math.max(0, barHeight) : 0;
        return new int[] {right ? 0 : width, top ? height : 0, right ? width : 0, top ? 0 : height};
    }

    /**
     * Whether the auto-hide bar keeps the corner cell under its handle.
     *
     * @param reserve     what the horizontal bar takes on this page
     * @param verticalBar the vertical bar is on this page
     * @param sidesAgree  the vertical bar and the handle are on the same side
     */
    public static boolean cornerCell(HorizontalBarPlacement.Reserve reserve, boolean verticalBar,
                                     boolean sidesAgree) {
        return reserve == HorizontalBarPlacement.Reserve.CELL && !(verticalBar && sidesAgree);
    }

    /**
     * The grids of all pages in one orientation: the first page's and the others'. The first page has the
     * bars of its own; the others have the ones that are set to be on every page.
     */
    public static final class Signature {
        public final Cells firstPage;
        public final Cells otherPages;

        public Signature(Cells firstPage, Cells otherPages) {
            this.firstPage = firstPage;
            this.otherPages = otherPages;
        }

        /** The grid of a screen: the first page has a negative id, as the launcher gives it. */
        public Cells of(long screenId) {
            return screenId < 0 ? firstPage : otherPages;
        }

        /** The grid every page had before a bar took a strip: all of it, nothing before the first cell. */
        public static Signature legacy(boolean landscape) {
            Cells all = new Cells(columns(landscape, DEFAULT_LONG, DEFAULT_SHORT),
                    rows(landscape, DEFAULT_LONG, DEFAULT_SHORT), 0, 0);
            return new Signature(all, all);
        }

        public String encode() {
            return firstPage + ";" + otherPages;
        }

        /** The reverse of {@link #encode()}; null for anything else. */
        public static Signature decode(String text) {
            if (text == null) {
                return null;
            }
            String[] parts = text.split(";");
            if (parts.length != 2) {
                return null;
            }
            Cells first = Cells.parse(parts[0]);
            Cells others = Cells.parse(parts[1]);
            return first != null && others != null ? new Signature(first, others) : null;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Signature && firstPage.equals(((Signature) o).firstPage)
                    && otherPages.equals(((Signature) o).otherPages);
        }

        @Override
        public int hashCode() {
            return firstPage.hashCode() * 31 + otherPages.hashCode();
        }

        @Override
        public String toString() {
            return encode();
        }
    }

    /**
     * The grids the items were last arranged for in this orientation, when they differ from the ones now;
     * null when nothing has to be arranged again.
     *
     * <p>The items of the home screen have one cell each, whatever the orientation, so the grid they were
     * arranged for is remembered per orientation. A turn of the screen alone never moves an item: an
     * orientation met for the first time, while the other one is known, only notes its grids. With neither
     * known the items come from a version in which every page had the whole ten by six grid.
     *
     * @param storedHere  what {@link Signature#encode()} gave when the items were last arranged in this
     *                    orientation, or null
     * @param storedOther the same for the other orientation, or null
     */
    public static Signature arrangedFor(String storedHere, String storedOther, boolean landscape, Signature now) {
        Signature here = Signature.decode(storedHere);
        if (here == null) {
            if (Signature.decode(storedOther) != null) {
                return null;
            }
            here = Signature.legacy(landscape);
        }
        return here.equals(now) ? null : here;
    }
}
