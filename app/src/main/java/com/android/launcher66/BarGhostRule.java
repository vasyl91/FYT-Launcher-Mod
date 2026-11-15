package com.android.launcher66;

/**
 * When a page of the home screen shows a picture of the bars in place of the bars themselves.
 *
 * <p>The bars of the pages after the first are windows over the launcher (PersistentBarWindow,
 * VerticalBarWindow). A window cannot be made small with a page, so while the pages are small (the overview,
 * and while an icon is dragged) the windows are put away. The bars' strips are no cells (WorkspaceGrid), so
 * they stayed empty there, where the first page, which has its bars in itself, showed them small with the
 * rest of the page.
 *
 * <p>The rule: while the pages are small, every page after the first shows a picture of each bar that stays
 * on it, in the bar's strip, small with the page and moving with it. The picture is taken of the bar's own
 * window when the pages become small. It stays until the pages are at their full size again: the windows
 * come back at the moment the way back begins, and the pictures are under them until it has ended, so
 * nothing is missing in between. The first page never has a picture: it has the bars. A bar that hides
 * itself (auto-hide) stays on no page and has none either. Pure Java, so that it has a test.
 */
final class BarGhostRule {

    private BarGhostRule() {
    }

    /**
     * Whether the pictures are up.
     *
     * @param small     the pages are small: the overview, or the state in which an icon is dragged
     * @param switching the pages are on their way from one size to another
     */
    static boolean shown(boolean small, boolean switching) {
        return small || switching;
    }

    /**
     * Whether a page has the picture of a bar.
     *
     * @param firstPage  the page is the first one, which has the bars in itself
     * @param barStays   the bar stays on the pages after the first: it is on every page and does not hide
     */
    static boolean onPage(boolean firstPage, boolean barStays) {
        return !firstPage && barStays;
    }
}
