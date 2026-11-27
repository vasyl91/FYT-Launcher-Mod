package com.android.launcher66;

/**
 * Whether a long press of an icon in the vertical app drawer starts a drag to the home screen.
 *
 * <p>The rules (the owner on the A55, 2026-11-27: no icon could be dragged out of the vertical list):
 * <ul>
 *   <li>The list has a way of its own into the drag, not the pager's: the pager refused while one of its pages was
 *       still settling ({@code mNextPage}) and after a first drag, since only a touch on the pager itself cleared its
 *       dragging state, and the vertical list never gives it one.</li>
 *   <li>A drag starts from a touch (not from a key), while the drawer is shown and not changing, while dragging is
 *       allowed at all (the workspace is ready), from an app's icon, and when no other drag is under way.</li>
 *   <li>A refusal is logged with its reason ({@link #refusal}).</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class VerticalDrag {

    private VerticalDrag() {
    }

    /** Null when the drag may start, else why not. */
    static String refusal(boolean touchMode, boolean drawerShown, boolean switching, boolean draggingAllowed,
                          boolean appIcon, boolean anotherDrag) {
        if (!touchMode) {
            return "not a touch";
        }
        if (!drawerShown) {
            return "the drawer is not shown";
        }
        if (switching) {
            return "the drawer is opening or closing";
        }
        if (!draggingAllowed) {
            return "dragging is not allowed now";
        }
        if (!appIcon) {
            return "not an app's icon";
        }
        if (anotherDrag) {
            return "another drag is under way";
        }
        return null;
    }
}
