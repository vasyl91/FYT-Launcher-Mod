package com.android.launcher66;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.SharedPreferences;

import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

/**
 * "Freeform widgets" (D6; "Free widget placement" up to round 28): a widget of the home screen at the pixels the user put
 * it, not in the cells nearest to them.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>It is a creator setting, off by default, so off with "Stock layout" too ({@link CreatorPrefs}). Off, every
 *       widget is in its cells, those of the database.</li>
 *   <li>A widget has a {@link WidgetFrame} once it was added, moved or resized with the setting on; until then it is in
 *       its cells. A widget added from the list gets the frame of its cells at once ({@link #frameNew}), so its resize
 *       frame is free from the start. The frame lies wholly in the page and is no smaller than the widget's least
 *       size.</li>
 *   <li>A drop puts the widget at the pixels it was let go, its size kept, inside the page; it is not limited to the
 *       cells the grid found (FreePlace, the owner on the A55, 2026-11-27).</li>
 *   <li>The database always has the cells the frame lies over, so that turning the setting off puts the widget where
 *       it was, as near as the grid allows. Without "Allow widgets to overlap" the widget keeps to free cells: a drop
 *       over a held cell goes to the nearest place over free cells only, a resize is refused where it would reach a
 *       cell that another item holds, and the cells the widget lies over are taken, so icons keep out of its way.
 *       With it, neither is limited by other items.</li>
 *   <li>While it is resized the frame stays round the widget (ResizeGeometry): a refused or limited size puts the frame
 *       back round the widget in the same move.</li>
 *   <li>The widget is told its size in pixels, not the size of its cells.</li>
 * </ul>
 * Main thread.
 */
final class FreeformWidgets {

    private static final String TAG = "FreeformWidgets";

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
     * A widget dropped on a page: its frame at the pixels it was let go (FreePlace), and the cells for the database.
     *
     * @param visualCenter the centre of the dragged widget in the page's coordinates
     * @param cell         the cells found for the drop {cellX, cellY}; {@code spanX/spanY} their size: the place when
     *                     no free place exists, and the size when the widget had to shrink to them
     * @param sizeKept     the widget keeps the size it had (it was not made to fit other cells)
     * @return {cellX, cellY, spanX, spanY} for the database: the cells the widget lies over
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
        int left = Math.round(visualCenter[0] - container.getLeft() - w / 2f);
        int top = Math.round(visualCenter[1] - container.getTop() - h / 2f);
        int[][] edges = page.cellEdges();
        boolean overlap = overlapOn(view.getContext());
        int[] rect = FreePlace.place(left, top, w, h, cw, ch, edges[0], edges[1], edges[2], edges[3],
                overlap ? null : page.occupiedWithout(view));
        String how = "at the drop";
        if (rect == null) {
            // No place over free cells only: the cells the grid found, as a widget in cells
            rect = new int[] {area[0], area[1], Math.min(w, area[2]), Math.min(h, area[3])};
            how = "in the cells found, no free place nearer";
        } else if (rect[0] != Math.max(0, Math.min(left, cw - rect[2]))
                || rect[1] != Math.max(0, Math.min(top, ch - rect[3]))) {
            how = "at the nearest place over free cells";
        }
        WidgetFrame frame = WidgetFrame.ofPixels(rect[0], rect[1], rect[0] + rect[2], rect[1] + rect[3], cw, ch);
        WidgetFrames.put(view.getContext(), view.getAppWidgetId(), frame);
        updateSize(view, rect[2], rect[3]);
        int[] cells = FreePlace.cellsTouched(rect[0], rect[1], rect[2], rect[3], edges[0], edges[1], edges[2], edges[3]);
        if (cells == null) {
            cells = new int[] {cell[0], cell[1], spanX, spanY};
        }
        Log.i(TAG, "Freeform widget " + view.getAppWidgetId() + ": dropped " + how + ", let go at " + left + "," + top
                + ", frame " + rect[0] + "," + rect[1] + " " + rect[2] + "x" + rect[3] + ", cells " + cells[0] + ","
                + cells[1] + " " + cells[2] + "x" + cells[3] + (overlap ? " (overlap allowed)" : ""));
        return cells;
    }

    /**
     * A widget just added from the list, with freeform widgets on: its frame is that of its cells at once, so that it
     * is moved and resized freely from the start. Done after the page has laid it out.
     */
    static void frameNew(final CellLayout page, final LauncherAppWidgetHostView view, final int cellX, final int cellY,
                         final int spanX, final int spanY) {
        if (page == null || view == null || !enabled(view.getContext())
                || WidgetFrames.get(view.getContext(), view.getAppWidgetId()) != null) {
            return;
        }
        page.post(() -> {
            ShortcutAndWidgetContainer container = page.getShortcutsAndWidgets();
            int cw = container.getWidth();
            int ch = container.getHeight();
            if (cw <= 0 || ch <= 0 || view.getParent() != container) {
                return;
            }
            int[] area = container.cellAreaRect(cellX, cellY, spanX, spanY);
            WidgetFrames.put(view.getContext(), view.getAppWidgetId(),
                    WidgetFrame.ofPixels(area[0], area[1], area[0] + area[2], area[1] + area[3], cw, ch));
            Log.i(TAG, "Freeform widget " + view.getAppWidgetId() + ": added, frame of its cells " + area[0] + ","
                    + area[1] + " " + area[2] + "x" + area[3]);
        });
    }

    /**
     * The widget's frame while its resize frame is dragged, and when it is let go.
     *
     * @param left,top,width,height the widget's new rectangle in its container
     * @param commit                the user let go: the frame is written, the cells go to the database
     * @return the rectangle {left, top, width, height} the widget has now: the one asked for, made to lie in the page
     *         and no smaller than the widget's least size; null when the resize is refused (without "Allow widgets to
     *         overlap", it would reach cells another item holds) and nothing changed
     */
    static int[] resizeTo(CellLayout page, LauncherAppWidgetHostView view, int left, int top, int width, int height,
                          boolean commit) {
        ShortcutAndWidgetContainer container = page.getShortcutsAndWidgets();
        int cw = container.getWidth();
        int ch = container.getHeight();
        if (cw <= 0 || ch <= 0) {
            return null;
        }
        int[] min = minSizePx(view);
        WidgetFrame frame = WidgetFrame.ofPixels(left, top, left + width, top + height, cw, ch)
                .fit(cw, ch, min[0], min[1]);
        int[] px = frame.toPixels(cw, ch);
        int[] rect = {px[0], px[1], px[2] - px[0], px[3] - px[1]};
        int[] cells = page.cellsCovering(rect);
        if (cells == null || (!overlapOn(view.getContext())
                && !page.cellsVacant(cells[0], cells[1], cells[2], cells[3]))) {
            if (commit) {
                Log.i(TAG, "Freeform widget " + view.getAppWidgetId() + ": resize to " + rect[0] + "," + rect[1] + " "
                        + rect[2] + "x" + rect[3] + " refused, another item holds a cell there");
            }
            return null;   // another item holds a cell the widget would reach
        }
        if (commit) {
            WidgetFrames.put(view.getContext(), view.getAppWidgetId(), frame);
            Log.i(TAG, "Freeform widget " + view.getAppWidgetId() + ": resized, frame " + rect[0] + "," + rect[1] + " "
                    + rect[2] + "x" + rect[3] + ", cells " + cells[0] + "," + cells[1] + " " + cells[2] + "x"
                    + cells[3]);
        } else {
            WidgetFrames.hold(view.getAppWidgetId(), frame);
        }
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) view.getLayoutParams();
        lp.cellX = lp.tmpCellX = cells[0];
        lp.cellY = lp.tmpCellY = cells[1];
        lp.cellHSpan = cells[2];
        lp.cellVSpan = cells[3];
        updateSize(view, rect[2], rect[3]);
        view.requestLayout();
        return rect;
    }
}
