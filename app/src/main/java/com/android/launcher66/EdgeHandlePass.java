package com.android.launcher66;

import java.util.ArrayList;
import java.util.List;

/**
 * The rules for a gesture the edge handle has handed on to the launcher, free of android.* so
 * that they can be tested.
 *
 * <p>Handing a gesture on moves the page, and moving the page hides the handle (the launcher
 * hides it while its pages move). If that hide cancelled the gesture it would do so in the middle
 * of the replay of the held events, and the gesture would be lost at its first move. So a hide
 * that arrives while a gesture is being passed waits for the end of that gesture (its UP or a
 * CANCEL): the strip only fades, the window stays touchable meanwhile, because the system may cut
 * a gesture off from a window that stops being touchable under it. A gesture that is not decided
 * yet is still cancelled by a hide, at once.
 */
final class EdgeHandlePass {

    private boolean hidePending;

    /**
     * A hide is asked for.
     *
     * @param passing a gesture is being handed on to the launcher
     * @return true if the handle is to be hidden now (and the gesture, if any, cancelled); false
     *         if the hide waits for the end of the gesture that is being passed
     */
    boolean requestHide(boolean passing) {
        hidePending = passing;
        return !passing;
    }

    /** The handle is shown again: a hide that was waiting is called off. */
    void show() {
        hidePending = false;
    }

    /** The passed gesture ended. @return true if a hide was waiting for it and is to be done now. */
    boolean passEnded() {
        boolean pending = hidePending;
        hidePending = false;
        return pending;
    }

    boolean hidePending() {
        return hidePending;
    }

    /** The window goes away: nothing waits any more. */
    void release() {
        hidePending = false;
    }

    /**
     * The held events of a gesture, moved to a list of their own. Replaying them calls into the
     * launcher, which can end the gesture of the handle (and clear and refill its list) in the
     * middle of the loop; the copy cannot be changed by that.
     */
    static <T> List<T> take(List<T> held) {
        List<T> copy = new ArrayList<>(held);
        held.clear();
        return copy;
    }
}
