package com.android.launcher66.settings;

import com.android.launcher66.SysCalls;
import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;

import com.android.launcher66.ColdStart;
import com.android.launcher66.LauncherApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Tells CanbusService which app is in front on the main display, from the system's task stack,
 * for a launcher with system privileges.
 *
 * Without them, StateAccessibilityService does this job, which needs the user to switch an
 * accessibility service on, and AccessibilityManager only reports it about 25 s into a boot. The
 * task stack listener is the system's own notification of exactly this change, it needs no
 * setting, and it also says on which display a task is -- the PiP panes' apps, on their virtual
 * displays, are not "in front".
 *
 * The listener class is hidden API (android.app.TaskStackListener, compiled against a stub, see
 * hiddenapi-stubs), and registering it needs MANAGE_ACTIVITY_STACKS. A system app that is not
 * platform signed may get neither; start() then fails and the accessibility service stays in use.
 *
 * The result goes out as the same Keys.ACCESIBILITY_SERVICE broadcast the accessibility service
 * sends, so CanbusService handles both alike.
 */
public final class ForegroundAppTracker {

    private static final String TAG = "ForegroundAppTracker";
    /** Several task changes arrive together (a launch moves, creates and focuses): one look. */
    private static final long CHECK_DEBOUNCE_MS = 150L;
    private static final int MAX_TASKS = 10;

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private static volatile boolean sActive;
    private static Object sService;            // IActivityTaskManager or IActivityManager
    private static Method sUnregister;
    private static Listener sListener;
    private static Context sContext;
    private static String sLastPackage;        // main thread
    private static Field sDisplayIdField;
    private static boolean sDisplayIdResolved;

    private static final Runnable CHECK = ForegroundAppTracker::checkForeground;

    private ForegroundAppTracker() {
    }

    /** The task stack listener is registered and replaces the accessibility service. */
    public static boolean isActive() {
        return sActive;
    }

    /**
     * Registers the listener. Only with system privileges; returns false when the system refuses
     * it, and the caller keeps the accessibility service then.
     */
    public static synchronized boolean start(Context context) {
        if (sActive) {
            return true;
        }
        if (!LauncherApplication.hasSystemPrivileges()) {
            return false;
        }
        Context appContext = context.getApplicationContext();
        Listener listener;
        try {
            listener = new Listener();
        } catch (Throwable t) {
            Log.w(TAG, "TaskStackListener not available: " + t);
            return false;
        }
        // Android 10+: ActivityTaskManager; IActivityManager still forwards it on Android 10.
        String[][] candidates = {
                {"android.app.ActivityTaskManager", "android.app.IActivityTaskManager"},
                {"android.app.ActivityManager", "android.app.IActivityManager"},
        };
        for (String[] candidate : candidates) {
            try {
                Object service = Class.forName(candidate[0]).getMethod("getService").invoke(null);
                if (service == null) {
                    continue;
                }
                Class<?> serviceInterface = Class.forName(candidate[1]);
                Class<?> listenerInterface = Class.forName("android.app.ITaskStackListener");
                serviceInterface.getMethod("registerTaskStackListener", listenerInterface)
                        .invoke(service, listener);
                sUnregister = serviceInterface.getMethod("unregisterTaskStackListener", listenerInterface);
                sService = service;
                sListener = listener;
                sContext = appContext;
                sLastPackage = null;
                sActive = true;
                Log.i(TAG, "Task stack listener registered through " + candidate[0]
                        + "; the accessibility service is not needed");
                scheduleCheck();
                return true;
            } catch (Throwable t) {
                Log.w(TAG, "registerTaskStackListener through " + candidate[0] + " failed: " + t);
            }
        }
        return false;
    }

    public static synchronized void stop() {
        if (!sActive) {
            return;
        }
        sActive = false;
        MAIN.removeCallbacks(CHECK);
        try {
            sUnregister.invoke(sService, sListener);
        } catch (Throwable t) {
            Log.w(TAG, "unregisterTaskStackListener failed: " + t);
        }
        sService = null;
        sUnregister = null;
        sListener = null;
        sContext = null;
    }

    private static void scheduleCheck() {
        MAIN.removeCallbacks(CHECK);
        MAIN.postDelayed(CHECK, CHECK_DEBOUNCE_MS);
    }

    /** Main thread: the top task of the main display, reported when its app changed. */
    private static void checkForeground() {
        Context context = sContext;
        if (!sActive || context == null) {
            return;
        }
        String packageName = null;
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = am != null ? am.getRunningTasks(MAX_TASKS) : null;
            if (tasks != null) {
                // Most recently active first; the panes' tasks are on their virtual displays.
                for (ActivityManager.RunningTaskInfo task : tasks) {
                    if (displayIdOf(task) != Display.DEFAULT_DISPLAY) {
                        continue;
                    }
                    ComponentName top = task.topActivity;
                    if (top != null) {
                        packageName = top.getPackageName();
                        break;
                    }
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "Could not read the running tasks: " + t);
            return;
        }
        if (packageName == null || packageName.equals(sLastPackage)) {
            return;
        }
        sLastPackage = packageName;
        ColdStart.noteForegroundApp(context, packageName);
        Intent intent = new Intent(Keys.ACCESIBILITY_SERVICE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("package_name", packageName);
        SysCalls.sendBroadcast(context, intent);
    }

    /** TaskInfo.displayId is hidden; without it every task counts as the main display's. */
    private static int displayIdOf(ActivityManager.RunningTaskInfo task) {
        if (!sDisplayIdResolved) {
            sDisplayIdResolved = true;
            try {
                sDisplayIdField = task.getClass().getField("displayId");
            } catch (Throwable t) {
                Log.w(TAG, "TaskInfo.displayId not found: " + t);
            }
        }
        if (sDisplayIdField == null) {
            return Display.DEFAULT_DISPLAY;
        }
        try {
            return sDisplayIdField.getInt(task);
        } catch (Throwable t) {
            return Display.DEFAULT_DISPLAY;
        }
    }

    /** Called on a binder thread; only schedules the check on the main thread. */
    private static final class Listener extends TaskStackListener {
        @Override
        public void onTaskStackChanged() {
            scheduleCheck();
        }

        @Override
        public void onTaskMovedToFront(ActivityManager.RunningTaskInfo taskInfo) {
            scheduleCheck();
        }
    }
}
