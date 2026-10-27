package com.android.launcher66;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Build;
import android.view.Display;

import com.syu.util.PinnedPipLaunch;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * The top task of the default display, i.e. what is shown full screen.
 *
 * ActivityManager.getRunningTasks() lists the tasks of every display, most recently active first,
 * the PiP panes' virtual displays included. Code that asks what covers the launcher, or what came
 * up full screen, has to skip the panes' tasks: otherwise a pane app is taken for it, and an app
 * that really is in front (a reversing camera, say) goes unrecognised.
 *
 * <p>The pinned PiP is skipped as well. It is a window floating over the home screen on the default
 * display, not what is shown full screen, and counting it as a cover made HomeFrontGuard take the
 * launcher's own pinned PiP for an app that had come over the home screen. On the FYT units that
 * is FYT's own pinned stack, mode 6, not AOSP's mode 2. Where the windowing mode cannot be read,
 * nothing is skipped.
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

    /** TaskInfo.configuration and what leads from it to the windowing mode; null if not readable. */
    private static final Field CONFIGURATION = findField("android.app.TaskInfo", "configuration");
    private static final Field WINDOW_CONFIGURATION =
            findField("android.content.res.Configuration", "windowConfiguration");
    private static final Method GET_WINDOWING_MODE = findMethod("android.app.WindowConfiguration",
            "getWindowingMode");

    /** WindowConfiguration.WINDOWING_MODE_PINNED: the task is in the pinned stack. */
    public static final int WINDOWING_MODE_PINNED = PinnedPipLaunch.WINDOWING_MODE_PINNED;

    /**
     * Whether windowing mode 6 is FYT's pinned stack: up to Android 10, which has no mode 6 of its
     * own (see PinnedPipLaunch.WINDOWING_MODE_FYT_PINNED).
     */
    private static final boolean FYT_PINNED_MODE = Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q;

    private DefaultDisplayTask() {
    }

    /**
     * The task's windowing mode (hidden API, read the way displayId is); -1 if it cannot be read.
     */
    public static int windowingMode(ActivityManager.RunningTaskInfo task) {
        if (CONFIGURATION == null || WINDOW_CONFIGURATION == null || GET_WINDOWING_MODE == null) {
            return -1;
        }
        try {
            Object configuration = CONFIGURATION.get(task);
            Object windowConfiguration = configuration != null
                    ? WINDOW_CONFIGURATION.get(configuration) : null;
            if (windowConfiguration == null) return -1;
            return (Integer) GET_WINDOWING_MODE.invoke(windowConfiguration);
        } catch (ReflectiveOperationException | RuntimeException e) {
            return -1;
        }
    }

    /** The display the task is on; -1 if it cannot be read. */
    public static int displayId(ActivityManager.RunningTaskInfo task) {
        if (DISPLAY_ID == null) return -1;
        try {
            return DISPLAY_ID.getInt(task);
        } catch (IllegalAccessException | RuntimeException e) {
            return -1;
        }
    }

    /**
     * The first task of the package that a force_pip start cannot put in the pinned stack, one on
     * another display than the default one (a retired window pane's virtual display); null if there
     * is none or the display cannot be read. See PinnedPipLaunch.outsidePinned().
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    @SuppressWarnings("deprecation")
    public static ActivityManager.RunningTaskInfo taskOutsidePinnedStack(ActivityManager am,
            String pkg) {
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(Integer.MAX_VALUE);
        if (tasks == null) return null;
        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (!isOfPackage(task, pkg)) continue;
            if (PinnedPipLaunch.outsidePinned(displayId(task))) {
                return task;
            }
        }
        return null;
    }

    private static boolean isOfPackage(ActivityManager.RunningTaskInfo task, String pkg) {
        return (task.baseActivity != null && pkg.equals(task.baseActivity.getPackageName()))
                || (task.topActivity != null && pkg.equals(task.topActivity.getPackageName()));
    }

    /**
     * Top activity of the most recently active task on the default display, the pinned PiP's left
     * out; null if there is no task. Without display information the most recently active task of any display is used, as
     * with getRunningTasks(1). A binder call into system_server: off the main thread at boot.
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    public static ComponentName topActivity(ActivityManager am) {
        ActivityManager.RunningTaskInfo task = topTask(am);
        return task != null ? task.topActivity : null;
    }

    /**
     * The task topActivity() is taken from; null if there is none.
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    @SuppressWarnings("deprecation")
    public static ActivityManager.RunningTaskInfo topTask(ActivityManager am) {
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(SEARCH_LIMIT);
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (isOnDefaultDisplay(task) && canCoverHome(task)) {
                return task;
            }
        }
        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (canCoverHome(task)) {
                return task;
            }
        }
        return null;
    }

    /**
     * The tasks of the default display, most recently active first: the one in front, then the
     * one that was in front before it, and so on. Without display information every task is
     * listed, the panes' included; see knowsDisplays().
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    @SuppressWarnings("deprecation")
    public static List<ActivityManager.RunningTaskInfo> defaultDisplayTasks(ActivityManager am) {
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(SEARCH_LIMIT);
        List<ActivityManager.RunningTaskInfo> result = new ArrayList<>();
        if (tasks != null) {
            for (ActivityManager.RunningTaskInfo task : tasks) {
                if (isOnDefaultDisplay(task) && canCoverHome(task)) {
                    result.add(task);
                }
            }
        }
        return result;
    }

    /** Whether the tasks' displays can be read, i.e. the panes' tasks told apart. */
    public static boolean knowsDisplays() {
        return DISPLAY_ID != null;
    }

    /**
     * Whether the task with this id is still there, on any display.
     *
     * @throws RuntimeException as ActivityManager.getRunningTasks() does
     */
    @SuppressWarnings("deprecation")
    public static boolean isRunning(ActivityManager am, int taskId) {
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(Integer.MAX_VALUE);
        if (tasks != null) {
            for (ActivityManager.RunningTaskInfo task : tasks) {
                if (task.id == taskId) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Whether the task can be what is shown full screen, i.e. it is not in a pinned stack. */
    private static boolean canCoverHome(ActivityManager.RunningTaskInfo task) {
        return PinnedPipLaunch.canCoverHome(windowingMode(task), FYT_PINNED_MODE);
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
        return findField("android.app.TaskInfo", "displayId");
    }

    private static Field findField(String className, String name) {
        try {
            Field field = Class.forName(className).getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (ReflectiveOperationException | RuntimeException e) {
            return null;
        }
    }

    private static Method findMethod(String className, String name) {
        try {
            Method method = Class.forName(className).getMethod(name);
            method.setAccessible(true);
            return method;
        } catch (ReflectiveOperationException | RuntimeException e) {
            return null;
        }
    }
}
