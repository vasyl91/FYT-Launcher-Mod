package com.android.launcher66;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.view.Display;

import java.lang.reflect.Field;
import java.util.List;

/**
 * The top task of the default display, i.e. what is shown full screen.
 *
 * ActivityManager.getRunningTasks() lists the tasks of every display, most recently active first,
 * the PiP panes' virtual displays included. Code that asks what covers the launcher, or what came
 * up full screen, has to skip the panes' tasks: otherwise a pane app is taken for it, and an app
 * that really is in front (a reversing camera, say) goes unrecognised.
 *
 * <p>Not for code that has to see the top task the way com.syu.ms does. com.syu.ms picks the MCU
 * sound channel and app id from getRunningTasks(1), panes included, and the launcher's
 * counter-moves must judge by the same view: WindowUtil.reassertLauncherTop() and
 * LauncherApplication.isAppTop() (used by HandlerMain) deliberately keep getRunningTasks(1).
 */
public final class DefaultDisplayTask {

    /** Tasks looked at to find the top one on the default display, the panes' tasks in between. */
    private static final int SEARCH_LIMIT = 16;

    /**
     * TaskInfo.displayId: hidden on Android 10, readable with the launcher's system UID. Null if it
     * cannot be read; every task then counts as being on the default display.
     */
    private static final Field DISPLAY_ID = findDisplayIdField();

    private DefaultDisplayTask() {
    }

    /**
     * Top activity of the most recently active task on the default display; null if there is no
     * task. Without display information the most recently active task of any display is used, as
     * with getRunningTasks(1). A binder call into system_server: off the main thread at boot.
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    @SuppressWarnings("deprecation")
    public static ComponentName topActivity(ActivityManager am) {
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(SEARCH_LIMIT);
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (isOnDefaultDisplay(task)) {
                return task.topActivity;
            }
        }
        return tasks.get(0).topActivity;
    }

    private static boolean isOnDefaultDisplay(ActivityManager.RunningTaskInfo task) {
        if (DISPLAY_ID == null) {
            return true;
        }
        try {
            return DISPLAY_ID.getInt(task) == Display.DEFAULT_DISPLAY;
        } catch (IllegalAccessException | RuntimeException e) {
            return true;
        }
    }

    private static Field findDisplayIdField() {
        try {
            Field field = Class.forName("android.app.TaskInfo").getDeclaredField("displayId");
            field.setAccessible(true);
            return field;
        } catch (ReflectiveOperationException | RuntimeException e) {
            return null;
        }
    }
}
