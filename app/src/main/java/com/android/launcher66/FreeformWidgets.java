package com.android.launcher66;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

/**
 * "Free widget placement" (D6): a widget of the home screen at the pixels the user put it, not in the cells nearest to them.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>It is a creator setting, off by default, so off with "Stock layout" too ({@link CreatorPrefs}). Off, every
 *       widget is in its cells, those of the database.</li>
 *   <li>A widget has a {@link WidgetFrame} once it was moved or resized with the setting on; until then it is in its cells
 *       (a widget added from the list starts there, and is free as soon as it is moved). The frame lies wholly in the page
 *       and is no smaller than the widget's least size.</li>
 *   <li>The database always has the cells nearest to the frame, so that turning the setting off puts the widget where
 *       it was, as near as the grid allows. Without "Allow widgets to overlap" the widget keeps to the free cells it lies
 *       over: a drop is limited to the cells found for it, a resize is refused where it would reach a cell that another
 *       item holds, and the cells the widget lies over are taken, so icons keep out of its way.</li>
 *   <li>The widget is told its size in pixels, not the size of its cells.</li>
 * </ul>
 * Main thread.
 */
final class FreeformWidgets {

    private FreeformWidgets() {
    }

    /** Whether widgets are placed freely now. */
    static boolean enabled(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return CreatorPrefs.of(prefs).getBoolean(Keys.WIDGET_FREEFORM, false);
    }

    /**
     * "Allow widgets to overlap" (D7, a creator setting, off by default and with the stock layout): widgets take no cells,
     * so icons, folders and other widgets may lie under them; they are drawn over the icons and take the touch first.
     */
    static boolean overlapOn(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return CreatorPrefs.of(prefs).getBoolean(Keys.WIDGET_OVERLAP, false);
    }

    /** The least size of a widget in pixels {width, height}: what its provider asks for, never less than 48 dp. */
    static int[] minSizePx(LauncherAppWidgetHostView view) {
        float density = view.getResources().getDisplayMetrics().density;
        int floor = Math.round(48f * density);
        AppWidgetProviderInfo info = view.getAppWidgetInfo();
        if (info == null) {
            return new int[] {floor, floor};
        }
        int w = info.minResizeWidth > 0 ? info.minResizeWidth : info.minWidth;
        int h = info.minResizeHeight > 0 ? info.minResizeHeight : info.minHeight;
        return new int[] {Math.max(floor, w), Math.max(floor, h)};
    }

    /** Tells the widget how large it is, in pixels (its provider sees dp). */
    static void updateSize(LauncherAppWidgetHostView view, int widthPx, int heightPx) {
        float density = view.getResources().getDisplayMetrics().density;
        int w = Math.round(widthPx / density);
        int h = Math.round(heightPx / density);
        view.updateAppWidgetSize(null, w, h, w, h);
    }

    /**
     * A widget dropped on a page: its frame from where it was dropped, and the cells for the database.
     *
     * @param visualCenter the centre of the dragged widget in the page's coordinates
     * @param cell         the cells found for the drop {cellX, cellY}; {@code spanX/spanY} their size
     * @param sizeKept     the widget keeps the size it had (it was not made to fit other cells)
     * @return {cellX, cellY, spanX, spanY} for the database
     */
    static int[] placeOnDrop(CellLayout page, LauncherAppWidgetHostView view, float[] visualCenter, int[] cell,
                             int spanX, int spanY, boolean sizeKept) {
        ShortcutAndWidgetContainer container = page.getShortcutsAndWidgets();
        int cw = container.getWidth();
        int ch = container.getHeight();
        if (cw <= 0 || ch <= 0) {
            return new int[] {cell[0], cell[1], spanX, spanY};
        }
        int[] area = container.cellAreaRect(cell[0], cell[1], spanX, spanY);
        int w = sizeKept && view.getWidth() > 0 ? view.getWidth() : area[2];
        int h = sizeKept && view.getHeight() > 0 ? view.getHeight() : area[3];
        w = Math.max(1, Math.min(w, area[2]));
        h = Math.max(1, Math.min(h, area[3]));
        int left = Math.round(visualCenter[0] - container.getLeft() - w / 2f);
        int top = Math.round(visualCenter[1] - container.getTop() - h / 2f);
        left = Math.max(area[0], Math.min(left, area[0] + area[2] - w));
        top = Math.max(area[1], Math.min(top, area[1] + area[3] - h));
        WidgetFrame frame = WidgetFrame.ofPixels(left, top, left + w, top + h, cw, ch);
        WidgetFrames.put(view.getContext(), view.getAppWidgetId(), frame);
        updateSize(view, w, h);
        return new int[] {cell[0], cell[1], spanX, spanY};
    }

    /**
     * The widget's frame while its resize frame is dragged, and when it is let go.
     *
     * @param left,top,width,height the widget's new rectangle in its container
     * @param commit                the user let go: the frame is written, the cells go to the database
     * @return false when the resize is refused (it would reach cells another item holds) and nothing changed
     */
    static boolean resizeTo(CellLayout page, LauncherAppWidgetHostView view, int left, int top, int width, int height,
                            boolean commit) {
        ShortcutAndWidgetContainer container = page.getShortcutsAndWidgets();
        int cw = container.getWidth();
        int ch = container.getHeight();
        if (cw <= 0 || ch <= 0) {
            return false;
        }
        int[] min = minSizePx(view);
        WidgetFrame frame = WidgetFrame.ofPixels(left, top, left + width, top + height, cw, ch)
                .fit(cw, ch, min[0], min[1]);
        int[] px = frame.toPixels(cw, ch);
        int[] cells = page.cellsCovering(new int[] {px[0], px[1], px[2] - px[0], px[3] - px[1]});
        if (cells == null || !page.cellsVacant(cells[0], cells[1], cells[2], cells[3])) {
            return false;   // another item holds a cell the widget would reach
        }
        if (commit) {
            WidgetFrames.put(view.getContext(), view.getAppWidgetId(), frame);
        } else {
            WidgetFrames.hold(view.getAppWidgetId(), frame);
        }
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) view.getLayoutParams();
        lp.cellX = lp.tmpCellX = cells[0];
        lp.cellY = lp.tmpCellY = cells[1];
        lp.cellHSpan = cells[2];
        lp.cellVSpan = cells[3];
        updateSize(view, px[2] - px[0], px[3] - px[1]);
        view.requestLayout();
        return true;
    }
}
