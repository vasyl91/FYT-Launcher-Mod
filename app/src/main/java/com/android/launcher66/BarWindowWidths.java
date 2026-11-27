package com.android.launcher66;

/**
 * The widths of the elements of the horizontal bar's window (the bar on every page, the auto-hide bar), which
 * {@code Workspace.forceOriginalSizes} sets in pixels after the layout's own shares.
 *
 * <p>The rule (the owner on the A55, 2026-11-27: "Hide the app drawer button" worked on the first page only): the window
 * shares the room exactly as the page's bar does ({@code WidgetBarLayout.applyPlain}, {@code applyShared}). With the
 * drawer button hidden it is 0 wide; without the widgets its room goes to the apps list, with them every element takes
 * its share by {@link BarShares}. Without anything hidden the usual widths stay. The window set the usual widths again
 * after the layout had given the button no room, and the button came back there. Pure Java, so that it has a test.
 */
final class BarWindowWidths {

    private BarWindowWidths() {
    }

    /** {drawer button, apps list} of the bar without the widgets. */
    static int[] plain(int drawer, int apps, boolean drawerHidden) {
        return drawerHidden ? new int[] {0, apps + drawer} : new int[] {drawer, apps};
    }

    /**
     * {drawer button, apps list, music widget, date, weather} of the widget bar by the one rule, an element that is not
     * shown at 0.
     */
    static int[] shared(int screenWidth, BarShares.Result shares) {
        BarShares.Element[] order = {BarShares.Element.DRAWER, BarShares.Element.APPS, BarShares.Element.MUSIC,
                BarShares.Element.DATE, BarShares.Element.WEATHER};
        int[] widths = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            widths[i] = shares.shown(order[i]) ? Math.round(screenWidth * shares.share(order[i])) : 0;
        }
        return widths;
    }
}
