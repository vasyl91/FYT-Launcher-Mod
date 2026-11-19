package com.android.launcher66.settings;

import android.view.View;

/**
 * The rule for the settings rows that size their own controls (the PiP, widget, dual PiP and restart rows):
 * a row is given its final size when it is bound, before its first measure, never a frame later.
 *
 * <p>A row that grows after it came on the screen pushes the rows below it. Scrolling down that happens below
 * what is seen; scrolling up, the row comes in at the top and the whole list jumped down. That was seen on the
 * second screen opened at its remembered place, below rows that had never been bound (the owner, 2026-11-19).
 * The pass after the layout (LayoutSizingWatcher) still runs and gives the same heights.
 */
final class SettingsRowSizing {

    private SettingsRowSizing() {
    }

    /**
     * The width of a row: its own once it is laid out, before that its list's, or the screen's. Only the widths
     * of controls follow it; the row's height does not.
     */
    static int width(View row) {
        if (row.getWidth() > 0) {
            return row.getWidth();
        }
        if (row.getParent() instanceof View && ((View) row.getParent()).getWidth() > 0) {
            View parent = (View) row.getParent();
            return parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight();
        }
        return row.getResources().getDisplayMetrics().widthPixels;
    }
}
