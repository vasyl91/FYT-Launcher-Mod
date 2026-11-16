package com.android.launcher66;

/**
 * The window of the bar on every page (without auto-hide), free of android.* so that its rules can
 * be tested. The window is built in advance, so that the bar which is to appear at the first moment
 * of a page move is already built and drawn: showing it is a change of alpha and of touchability,
 * no inflation and no addView in the middle of a gesture. Building it there took 144 ms on a fast
 * phone, and the pane under the finger stood still for that long and then jumped.
 *
 * <p>The rule: the window exists for as long as the launcher's window does in that mode, not only
 * while the launcher is in front. It is a sub-window of the launcher's window (BarWindows), which the
 * system hides and shows together with that window, as it does the panes of the PiPs; an app coming to
 * the front changes nothing in it, and what is decided while the launcher is away (all apps closed, the
 * overview left) is done while nothing of the launcher is seen. Until 2026-11-16 the window was removed
 * when an app came to the front and built again 250 ms after the return; until then the first page
 * showed its own bar and the other pages none, and a swipe in that time moved the first page's bar
 * with its page.
 */
final class PersistentBarWindow {

    /** What the window is now (or should be). */
    enum State {
        /** No window. */
        NONE,
        /** The window exists, is invisible and takes no touch; the widgets are bound to the page's own bar. */
        STANDBY,
        /** The bar is shown by the window: visible, touchable, the widgets are bound to it. */
        SHOWN
    }

    /** What to do to get from the current state to the target. */
    enum Action {
        /** NONE to STANDBY, a moment later (the window is not needed this instant). */
        BUILD_LATER,
        /** NONE to SHOWN: the bar is needed now (the only case of building in a gesture). */
        BUILD_NOW,
        /** STANDBY to SHOWN. */
        ACTIVATE,
        /** SHOWN to STANDBY. */
        PARK,
        /** Any state to NONE. */
        REMOVE,
        NOTHING
    }

    private PersistentBarWindow() {
    }

    /**
     * Whether the launcher is in front is not asked: see the class's rule.
     *
     * @param mode 'Horizontal bar on every page' without auto-hide, in the user layout
     * @param permitted the window can be added (the launcher's window is there, BarWindows) and did not fail
     * @param barIsOverlay HorizontalBarPlacement says the bar is the overlay's now (the page moves, or
     *                     rests on another page than the first)
     * @param free nothing else is in the bar's place: the normal state, the workspace (not all
     *             apps or the overview), nothing dragged, no folder or list of apps open
     */
    static State target(boolean mode, boolean permitted, boolean barIsOverlay, boolean free) {
        if (!mode || !permitted) {
            return State.NONE;
        }
        return barIsOverlay && free ? State.SHOWN : State.STANDBY;
    }

    /**
     * @param pageMoving the pages are moving: a window that is not needed yet is not built now, the
     *                   settling of the pages asks again
     */
    static Action action(State current, State target, boolean pageMoving) {
        switch (target) {
            case NONE:
                return current == State.NONE ? Action.NOTHING : Action.REMOVE;
            case STANDBY:
                switch (current) {
                    case NONE:
                        return pageMoving ? Action.NOTHING : Action.BUILD_LATER;
                    case SHOWN:
                        return Action.PARK;
                    default:
                        return Action.NOTHING;
                }
            default:
                switch (current) {
                    case NONE:
                        return Action.BUILD_NOW;
                    case STANDBY:
                        return Action.ACTIVATE;
                    default:
                        return Action.NOTHING;
                }
        }
    }
}
