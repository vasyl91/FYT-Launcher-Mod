package com.android.launcher66;

/**
 * The size of the icons on the pages of the home screen when the user made the grid denser.
 *
 * <p>The rule:
 * <ul>
 * <li>An icon is never larger than its standard size, and with the grid the launcher always had (ten by six)
 * it has exactly that size: nothing changes for a grid that was not changed.</li>
 * <li>With another grid the icon is made smaller only as far as its cell needs it: so that the icon is no
 * wider than the cell, and the icon with its label below it no higher. An icon that fits keeps its standard
 * size, so a sparser grid changes nothing either.</li>
 * <li>All pages of an orientation have icons of one size: the smallest any of their grids needs (the first
 * page and the others can have different cells, where their bars differ).</li>
 * <li>It stops at {@link #MIN_SHARE} of the standard size; below that an icon is not worth showing whole.</li>
 * </ul>
 * Before this the icon had its standard size whatever the cell, and with fourteen cells along the long edge
 * of a phone the cell was lower than the icon: the icon and its label were cut. Only the icon changes; the
 * label keeps the size the user set, and widgets are not touched. Pure Java, so that it has a test.
 */
public final class IconFit {

    /** The smallest icon, as a share of the standard one. */
    static final float MIN_SHARE = 0.4f;

    private IconFit() {
    }

    /**
     * @param standardPx  the standard size of an icon
     * @param cellWidth   the width of a cell
     * @param cellHeight  the height of a cell
     * @param labelPx     the height the label below the icon takes
     * @param defaultGrid the user has not changed the rows and columns
     * @return the size of the icon, never larger than the standard one
     */
    public static int iconPx(int standardPx, int cellWidth, int cellHeight, int labelPx, boolean defaultGrid) {
        if (defaultGrid || standardPx <= 0) {
            return standardPx;
        }
        int fits = Math.min(cellWidth, cellHeight - Math.max(0, labelPx));
        int smallest = Math.max(1, Math.round(standardPx * MIN_SHARE));
        return Math.max(smallest, Math.min(standardPx, fits));
    }
}
