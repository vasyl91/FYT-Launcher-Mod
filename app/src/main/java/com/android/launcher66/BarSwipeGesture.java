package com.android.launcher66;

/**
 * Who a touch gesture on the auto-hide bar's window belongs to, the bar or the workspace pages.
 * The bar is a window of its own, so its touches never reach the workspace; {@link BarSwipeFrame}
 * therefore shows every event to the workspace's paging as well (Workspace.handleExternalSwipe())
 * and asks this class what to do with it. Kept free of android.* so the rules can be tested; the
 * action constants have the values of the MotionEvent ones, so the frame passes getActionMasked()
 * as it is, and every other value (a further finger going down or up) counts as "other".
 *
 * One instance serves one window, one gesture at a time: ACTION_DOWN starts it afresh.
 */
final class BarSwipeGesture {

    static final int DOWN = 0;
    static final int UP = 1;
    static final int MOVE = 2;
    static final int CANCEL = 3;

    /** Hand the event to the bar's views. */
    static final int DISPATCH = 1;
    /** The bar's views get one ACTION_CANCEL: the pages have taken the gesture over. */
    static final int CANCEL_CHILDREN = 2;
    /** The pages started to move: slide the bar away (at most once per gesture). */
    static final int HIDE_BAR = 4;
    /** The workspace is done with this gesture: end its part with a synthetic ACTION_CANCEL. */
    static final int STOP_FEEDING = 8;

    private static final int WATCHING = 0; // the bar's views get the events, the workspace watches
    private static final int PAGING = 1;   // the pages own the gesture
    private static final int BAR_ONLY = 2; // the workspace is out, the bar owns the gesture

    // Also the state between gestures: stray events then go to the bar alone.
    private int phase = BAR_ONLY;
    private boolean barHidden;
    private boolean stopPending;

    /**
     * Asked before the event goes to the workspace.
     *
     * A gesture that did not become a page swipe within the long press timeout belongs to the bar:
     * a held icon opens the app picker, and the pages must not scroll beneath that dialog. A bar
     * view that asked not to be intercepted (a RecyclerView that really scrolled its list) keeps the
     * gesture as well, which is what ViewGroup does for a touch that started on a page.
     */
    boolean shouldFeed(int action, long sinceDownMs, long longPressMs, boolean childDisallowed) {
        stopPending = false;
        if (action == DOWN) {
            phase = WATCHING;
            barHidden = false;
            return true;
        }
        switch (phase) {
            case PAGING:
                return true;
            case WATCHING:
                if (action == UP || action == CANCEL) {
                    return true; // lets the workspace end its part quietly
                }
                if (childDisallowed || sinceDownMs >= longPressMs) {
                    stopPending = true;
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Asked after the event went (or did not go) to the workspace.
     *
     * @param fed whether the workspace took the event
     * @param paging whether the workspace's paging has the gesture now
     * @param childDisallowed a bar view asked not to be intercepted
     * @return what to do with the event, a mask of {@link #DISPATCH}, {@link #CANCEL_CHILDREN},
     *         {@link #HIDE_BAR} and {@link #STOP_FEEDING}
     */
    int afterFeed(int action, boolean fed, boolean paging, boolean childDisallowed) {
        final boolean ends = action == UP || action == CANCEL;
        int result = 0;
        if (action == DOWN) {
            if (!fed) {
                phase = BAR_ONLY;
                return DISPATCH;
            }
            if (paging) {
                // The pages were still settling and this touch caught them, as a touch on the
                // workspace does; the bar's views never see it.
                phase = PAGING;
                return 0;
            }
            phase = WATCHING;
            return DISPATCH;
        }
        switch (phase) {
            case BAR_ONLY:
                result = DISPATCH;
                break;
            case WATCHING:
                if (stopPending) {
                    stopPending = false;
                    phase = BAR_ONLY;
                    result = STOP_FEEDING | DISPATCH;
                } else if (ends) {
                    result = DISPATCH; // the tap reaches the icon
                } else if (!fed) {
                    phase = BAR_ONLY; // the workspace dropped out by itself
                    result = DISPATCH;
                } else if (paging) {
                    phase = PAGING;
                    result = CANCEL_CHILDREN;
                    if (action == MOVE) {
                        barHidden = true;
                        result |= HIDE_BAR;
                    }
                } else {
                    result = DISPATCH;
                }
                break;
            default: // PAGING
                if (action == MOVE && !barHidden) {
                    barHidden = true;
                    result = HIDE_BAR;
                }
                break;
        }
        if (ends) {
            phase = BAR_ONLY;
        }
        return result;
    }

    /**
     * Asked after the bar's views have seen ACTION_DOWN: one that asked not to be intercepted at
     * once owns the gesture, the workspace is not shown any more of it.
     */
    int afterDownDispatch(boolean childDisallowed) {
        if (phase == WATCHING && childDisallowed) {
            phase = BAR_ONLY;
            return STOP_FEEDING;
        }
        return 0;
    }

    /** The workspace has been shown this gesture and has not been told it is over. */
    boolean isFeeding() {
        return phase != BAR_ONLY;
    }
}
