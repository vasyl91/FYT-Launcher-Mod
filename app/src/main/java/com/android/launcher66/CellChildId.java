package com.android.launcher66;

/**
 * The view id of a child of a page (an icon, a folder, a widget), made from where it lies.
 *
 * <p>The rule: such an id never looks like a resource id. Android takes an id whose top byte is not zero for
 * one that aapt generated, and the framework then asks the resources for its name (when it describes the view
 * tree for content capture, autofill, assist or an accessibility service). The id used to carry the container
 * in its top byte; the desktop is container -100, that is 0x9C, so every pass over the pages logged
 * "No package ID 9c found for resource ID 0x9c......" once per child. The top byte is therefore always zero
 * here, which is the range the framework itself uses for ids made at run time.
 *
 * <p>The layout of the 24 bits: bit 23 is always set, so that the ids stay clear of the small numbers
 * {@code View.generateViewId()} hands out; bit 22 tells the hotseat from the desktop; then eight bits of the
 * screen, seven of the column and seven of the row (a grid of up to 128 x 128 cells). Nothing reads the parts
 * back: the id only has to be unique among the children of one page. Pure Java, so that it has a test.
 */
final class CellChildId {

    private static final int MARKER = 1 << 23;
    private static final int NOT_DESKTOP = 1 << 22;

    private CellChildId() {
    }

    static int of(boolean desktop, long screen, int cellX, int cellY) {
        return MARKER
                | (desktop ? 0 : NOT_DESKTOP)
                | (((int) screen & 0xFF) << 14)
                | ((cellX & 0x7F) << 7)
                | (cellY & 0x7F);
    }
}
