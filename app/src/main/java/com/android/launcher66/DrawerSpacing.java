package com.android.launcher66;

/**
 * The room between the app drawer's search bar, its strip of tabs and its apps.
 *
 * <p>The rules (the owner on the A55, 2026-11-27: with the tabs on top the gap under the search bar was too large and the
 * apps had none above them):
 * <ul>
 *   <li>One gap, {@link #GAP_DP}, between each two of them, and none twice: the search bar keeps its gap above it and
 *       has none below it; what follows it (the strip or the apps) has the gap above it.</li>
 *   <li>The strip on top: the gap above it (under the search bar, or from the top), its line, the gap, the apps.</li>
 *   <li>The strip at the bottom, mirrored: the apps, the gap, its line, the strip, the gap to the bottom.</li>
 *   <li>Without the strip the apps have the gap above them only under the search bar, as before.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class DrawerSpacing {

    static final int GAP_DP = 8;

    /** The gaps, in pixels. */
    final int searchBottom;
    final int stripTop;
    final int stripBottom;
    final int appsTop;
    final int appsBottom;

    private DrawerSpacing(int searchBottom, int stripTop, int stripBottom, int appsTop, int appsBottom) {
        this.searchBottom = searchBottom;
        this.stripTop = stripTop;
        this.stripBottom = stripBottom;
        this.appsTop = appsTop;
        this.appsBottom = appsBottom;
    }

    static DrawerSpacing of(boolean search, boolean strip, boolean stripOnTop, int gapPx) {
        if (strip && stripOnTop) {
            return new DrawerSpacing(0, gapPx, 0, gapPx, 0);
        }
        int appsTop = search ? gapPx : 0;
        if (strip) {
            return new DrawerSpacing(0, 0, gapPx, appsTop, gapPx);
        }
        return new DrawerSpacing(0, 0, 0, appsTop, 0);
    }
}
