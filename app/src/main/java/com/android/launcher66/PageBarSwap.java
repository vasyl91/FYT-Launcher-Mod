package com.android.launcher66;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Which of the two pictures of a bar is seen while a bar's window lies over the first page: the window, or
 * the first page's own bar under it.
 *
 * <p>With a bar on every page, the first page has the bar in itself and the other pages have the bar's
 * window (PersistentBarWindow, VerticalBarWindow). While the pages move, the window is up over the first
 * page too, so that the bar stays where it is. Before this rule the first page's own bar stayed visible
 * under the window and moved away with its page; through the transparent parts of the bar and between its
 * icons both were seen, one sliding over the other.
 *
 * <p>The rule: while the window is shown, the first page's own bar is hidden; only the window is seen, and
 * it does not move. The page's bar is hidden in the frame the window draws itself shown - in that frame, not
 * after the queue of the main thread, which on a busy unit kept both bars for most of a second - so there is
 * no frame without a bar and at most one with both, still in one place; when the window goes, the page's bar is shown first and the window is put away
 * only after the page has drawn its bar again ({@link #windowLeaving()} gives the token that the deferred
 * step checks). A window shown again before a deferred step runs makes that step void. While the launcher is
 * not in front nothing of it is seen, and the window (a sub-window of the launcher's) comes back on screen
 * together with it: there the swap is done at once, both ways ({@link #hideNow}), or the first frames after
 * the return would show both bars. Pure Java (the views are reached through {@link Alpha}), so that it has a
 * test.
 *
 * @param <V> the views of the page's bar
 */
final class PageBarSwap<V> {

    /** How the alpha of a view is read and set. */
    interface Alpha<V> {
        float get(V view);

        void set(V view, float alpha);
    }

    private final Alpha<V> alpha;
    /** The views hidden, with the alpha each had before. */
    private final Map<V, Float> hidden = new IdentityHashMap<>();
    private int generation;

    PageBarSwap(Alpha<V> alpha) {
        this.alpha = alpha;
    }

    /** The window is shown: the token the step after its first frame presents to {@link #windowDrawn}. */
    int windowShown() {
        return ++generation;
    }

    /**
     * The window has drawn itself shown: the page's bar is hidden, unless the window was put away or shown
     * again since.
     *
     * @return whether the views were hidden
     */
    boolean windowDrawn(int token, Iterable<V> pageBar) {
        if (token != generation || pageBar == null) {
            return false;
        }
        for (V view : pageBar) {
            if (view != null && !hidden.containsKey(view)) {
                hidden.put(view, alpha.get(view));
                alpha.set(view, 0f);
            }
        }
        return true;
    }

    /**
     * The window is shown and the page's bar is hidden at once, without waiting for the window's frame: where
     * no frame of the launcher is seen before the window's.
     *
     * @return the token, as {@link #windowShown()} gives it
     */
    int hideNow(Iterable<V> pageBar) {
        int token = windowShown();
        windowDrawn(token, pageBar);
        return token;
    }

    /**
     * The window is about to go: the page's bar is shown again at once, each view with the alpha it had.
     *
     * @return the token the step that puts the window away presents to {@link #current}
     */
    int windowLeaving() {
        generation++;
        for (Map.Entry<V, Float> entry : hidden.entrySet()) {
            alpha.set(entry.getKey(), entry.getValue());
        }
        hidden.clear();
        return generation;
    }

    /** Whether nothing was shown or put away since the token was given. */
    boolean current(int token) {
        return token == generation;
    }

    boolean pageBarHidden() {
        return !hidden.isEmpty();
    }
}
