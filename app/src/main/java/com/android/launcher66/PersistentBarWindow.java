package com.android.launcher66;

/**
 * The window of the bar on every page (without auto-hide), free of android.* so that its rules can
 * be tested. The window is the bar on every page, the first one too, and it is built with the page,
 * so that it is already shown when a move begins: nothing is built, shown or swapped in a gesture.
 * Building it there took 144 ms on a fast phone, and the pane under the finger stood still for that
 * long and then jumped; swapping it with the first page's own bar there showed both bars on the FYT
 * 7862 for a frame of 60 to 280 ms.
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
        /** NONE to STANDBY, at rest. */
        BUILD_STANDBY,
        /** NONE to SHOWN, at rest. */
        BUILD_SHOWN,
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
     * The rule: while the pages move no window is built and none is shown; the settling of the pages
     * asks again. The bar on every page is its window on every page, the first one too
     * (HorizontalBarPlacement), so at rest it is already shown when a move begins and nothing changes
     * then. A window is built at once at rest: there is no delay after which a swipe could find the
     * first page's own bar instead of the window. Putting the window away (PARK, REMOVE) is not held back:
     * what takes its place (a drag, a folder) needs it gone.
     *
     * @param pageMoving the pages are moving
     */
    static Action action(State current, State target, boolean pageMoving) {
        switch (target) {
            case NONE:
                return current == State.NONE ? Action.NOTHING : Action.REMOVE;
            case STANDBY:
                switch (current) {
                    case NONE:
                        return pageMoving ? Action.NOTHING : Action.BUILD_STANDBY;
                    case SHOWN:
                        return Action.PARK;
                    default:
                        return Action.NOTHING;
                }
            default:
                if (pageMoving) {
                    return Action.NOTHING;
                }
                switch (current) {
                    case NONE:
                        return Action.BUILD_SHOWN;
                    case STANDBY:
                        return Action.ACTIVATE;
                    default:
                        return Action.NOTHING;
                }
        }
    }
}
