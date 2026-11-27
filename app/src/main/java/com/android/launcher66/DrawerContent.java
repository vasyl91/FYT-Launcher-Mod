package com.android.launcher66;

/**
 * Which view shows the app drawer's content: the pager of pages, the vertical list of apps (AppsVerticalView) or
 * the list of widgets (WidgetsListView). One rule for both lists, asked every time the content, the setting or the
 * drawer's opening may have changed it (AppsCustomizePagedView.syncVertical), so that exactly one of them is shown.
 *
 * <p>The rules:
 * <ul>
 *   <li>The widgets are shown by their list where the layout has it, else by the pager.</li>
 *   <li>The apps are shown by the vertical list when the drawer scrolls vertically and the layout has the list,
 *       else by the pager.</li>
 *   <li>The pager is left in the layout when a list covers it (INVISIBLE, so its size and pages stay), but its
 *       pages get no icons or previews then: they are filled when it is shown ({@link #fillsPages}).</li>
 * </ul>
 */
public final class DrawerContent {

    public enum Shown { PAGER, APPS_LIST, WIDGETS_LIST }

    private DrawerContent() {
    }

    /**
     * @param widgets        the drawer shows the widgets (else the apps)
     * @param verticalWanted the drawer scrolls vertically (the setting; it means nothing for the widgets)
     * @param hasAppsList    the layout has the vertical list of apps
     * @param hasWidgetsList the layout has the list of widgets
     */
    public static Shown shown(boolean widgets, boolean verticalWanted, boolean hasAppsList, boolean hasWidgetsList) {
        if (widgets) {
            return hasWidgetsList ? Shown.WIDGETS_LIST : Shown.PAGER;
        }
        return verticalWanted && hasAppsList ? Shown.APPS_LIST : Shown.PAGER;
    }

    /** Whether the pager's pages are filled with their icons or previews now. */
    public static boolean fillsPages(Shown shown) {
        return shown == Shown.PAGER;
    }
}
