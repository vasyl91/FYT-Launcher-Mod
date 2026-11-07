package com.syu.util;

/**
 * Flags of the intent that puts an app on the display of a pane. Pure, so that the value has a test.
 *
 * <p>Only {@code NEW_TASK | RESET_TASK_IF_NEEDED}, as the home screen starts an app. With these the
 * system brings the app's existing task to the pane's display exactly as it is (a task that moved to
 * the main screen and back keeps its activities), and makes a new task only if there is none. The
 * flags of an intent built for an ActivityView (CLEAR_TOP, SINGLE_TOP, REORDER_TO_FRONT, ...) look for
 * the app's launcher activity in the task instead, and an app whose launcher activity only starts the
 * player and finishes (DABdream) then gets a second, dead launcher activity on top of its player and
 * crashes while it is resumed.
 */
public final class PaneLaunchFlags {

    /** Intent.FLAG_ACTIVITY_NEW_TASK */
    private static final int NEW_TASK = 0x10000000;
    /** Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED */
    private static final int RESET_TASK_IF_NEEDED = 0x00200000;

    /** The flags that replace the ones the intent came with. */
    public static final int FLAGS = NEW_TASK | RESET_TASK_IF_NEEDED;

    private PaneLaunchFlags() {
    }
}
