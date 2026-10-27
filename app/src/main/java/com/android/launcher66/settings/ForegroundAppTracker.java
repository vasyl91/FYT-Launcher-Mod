package com.android.launcher66.settings;

import com.android.launcher66.SysCalls;
import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;

import com.android.launcher66.ColdStart;
import com.android.launcher66.LauncherApplication;
import com.syu.util.WindowHostVdClient;
import com.syu.vdhost.VdHostProtocol;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Tells CanbusService which app is in front on the main display, from the system's task stack,
 * for a launcher with system privileges -- or, for any other one, from the VD host (the FYT VDHost
 * Magisk module's daemon or Shizuku), which watches the task stack for it (see
 * VdHostProtocol.Proxy.watchForeground()).
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
    /** Not a system app: the host reports the app to this binder. Null otherwise. */
    private static HostCallback sHostCallback;
    /** Watches for a host to (re)attach, while the host reports or is still awaited. */
    private static WindowHostVdClient.Listener sHostListener;

    private static final Runnable CHECK = ForegroundAppTracker::checkForeground;

    private ForegroundAppTracker() {
    }

    /** The task stack listener is registered and replaces the accessibility service. */
    public static boolean isActive() {
        return sActive;
    }

    /**
     * Registers the listener, with system privileges; otherwise has the VD host watch (see
     * startThroughHost()). Returns false when neither works, and the caller keeps the
     * accessibility service then.
     */
    public static synchronized boolean start(Context context) {
        if (sActive) {
            return true;
        }
        if (!LauncherApplication.hasSystemPrivileges()) {
            return startThroughHost(context.getApplicationContext());
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

    /**
     * Without system privileges: the host watches the task stack. With no host attached yet
     * (Shizuku binds a moment after the start) this returns false, the caller keeps the
     * accessibility service, and the tracker takes over as soon as a host attaches
     * (StateAccessibilityService then stays quiet, see isActive()). Main thread.
     */
    private static boolean startThroughHost(Context appContext) {
        sContext = appContext;
        if (sHostListener == null) {
            sHostListener = available -> {
                if (available) watchThroughHost();
            };
            WindowHostVdClient.addListener(sHostListener);
        }
        return watchThroughHost();
    }

    /** Registers the callback with the host now attached, if any. Main thread. */
    private static synchronized boolean watchThroughHost() {
        if (sContext == null || sHostListener == null) {
            return false;   // stopped meanwhile
        }
        if (sHostCallback == null) {
            sHostCallback = new HostCallback();
        }
        try {
            if (!WindowHostVdClient.watchForeground(sHostCallback)) {
                return false;
            }
        } catch (Throwable t) {
            Log.w(TAG, "The VD host cannot report the foreground app: " + t);
            return false;
        }
        sLastPackage = null;
        if (!sActive) {
            sActive = true;
            Log.i(TAG, "The VD host reports the foreground app; the accessibility service is not needed");
        }
        return true;
    }

    public static synchronized void stop() {
        if (sHostListener != null) {
            WindowHostVdClient.removeListener(sHostListener);
            sHostListener = null;
        }
        if (!sActive) {
            sContext = null;
            return;
        }
        sActive = false;
        MAIN.removeCallbacks(CHECK);
        if (sHostCallback != null) {
            // The host keeps calling until this process ends; HostCallback ignores it now.
            sHostCallback = null;
            sContext = null;
            return;
        }
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
        report(context, packageName);
    }

    /** The app last seen in front, null while none has been (main thread; no query is made). */
    public static String lastKnownPackage() {
        return sLastPackage;
    }

    /** Main thread: tells CanbusService about the app in front, when it changed. */
    private static void report(Context context, String packageName) {
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

    /** What the VD host calls with the app in front (VdHostProtocol.FOREGROUND_CHANGED). */
    private static final class HostCallback extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != VdHostProtocol.FOREGROUND_CHANGED) {
                return super.onTransact(code, data, reply, flags);
            }
            final String packageName = data.readString();
            MAIN.post(() -> {
                Context context = sContext;
                if (sActive && sHostCallback == this && context != null) {
                    report(context, packageName);
                }
            });
            return true;
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
