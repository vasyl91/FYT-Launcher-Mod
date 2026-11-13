package com.android.launcher66;

import android.view.View;
import android.widget.TextView;

/**
 * Keeps the scrolling of a long title or artist going in the bar that is shown, and only there.
 *
 * <p>The horizontal bar exists twice: as part of the first page, and as a window of its own that is shown
 * on the other pages and while the pages move. The music widget writes into the text views of one of them at
 * a time (LauncherMusicWidget.initMusicBarView binds them). A TextView scrolls its text only while it is
 * "selected", and it starts to scroll when it becomes selected, when its text changes, or when its window
 * gains focus. The bar's window never has focus, its views are bound while it is still hidden and before
 * they have a size, and the text is written only when it changed; so a view that was selected long ago and
 * did not scroll had nothing left that would start it. That is how the title stood still on the other pages
 * and moved again on the first one.
 *
 * <p>The rule: the views that are bound scroll, the views that were bound before do not.
 * <ul>
 *   <li>{@link #watch} is called for a view when it is bound: its scrolling is started again from the
 *       beginning (deselect, select), now and whenever its size changes later (the first size comes with the
 *       first layout of the bar);</li>
 *   <li>{@link #release} is called for the view that was bound before: it is deselected, so that nothing
 *       scrolls in a bar nobody sees.</li>
 * </ul>
 * Main thread only.
 */
final class MarqueeRestart {

    private MarqueeRestart() {
    }

    /** Starts the scrolling of a view that has just been bound, and again when its size changes. */
    static void watch(TextView view) {
        if (view == null) {
            return;
        }
        if (view.getTag(R.id.marquee_restart_listener) == null) {
            View.OnLayoutChangeListener listener = (v, l, t, r, b, ol, ot, or, ob) -> {
                if (r - l != or - ol || b - t != ob - ot) {
                    restart((TextView) v);
                }
            };
            view.addOnLayoutChangeListener(listener);
            view.setTag(R.id.marquee_restart_listener, listener);
        }
        restart(view);
    }

    /** Stops the scrolling of the view that was bound before, unless it is the one bound now. */
    static void release(TextView before, TextView now) {
        if (before != null && before != now) {
            before.setSelected(false);
        }
    }

    /** After the layout that is under way: a view that should scroll starts again from the beginning. */
    private static void restart(TextView view) {
        view.post(() -> {
            if (view.isSelected() && view.getVisibility() == View.VISIBLE) {
                view.setSelected(false);
                view.setSelected(true);
            }
        });
    }
}
