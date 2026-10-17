package com.syu.vdhost;

import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * What the host does besides the panes, for a launcher that is not a system app: the few things
 * the launcher does itself as android.uid.system (see VdHostProtocol.Proxy). Each one is narrow
 * on purpose: the host runs as system or shell, and the launcher must not get a general way to
 * act as either.
 */
final class HostServices {
    private static final String TAG = "FytVdHost";
    private static final int SHELL_UID = 2000;
    private static final Pattern PACKAGE_NAME = Pattern.compile("[A-Za-z0-9_]+(\\.[A-Za-z0-9_]+)+");
    /** Intent.FLAG_INCLUDE_STOPPED_PACKAGES | Intent.FLAG_RECEIVER_FOREGROUND */
    private static final int BOOT_BROADCAST_FLAGS = 0x00000020 | 0x10000000;
    /** UserHandle.USER_CURRENT, AppOpsManager.OP_NONE, ActivityManager.BROADCAST_SUCCESS (hidden). */
    private static final int USER_CURRENT = -2;
    private static final int OP_NONE = -1;
    private static final int BROADCAST_SUCCESS = 0;
    /** Several task changes arrive together (a launch moves, creates and focuses): one look. */
    private static final long FOREGROUND_DEBOUNCE_MS = 150;

    // ---------------------------------------------------------------------------------------
    // Commands
    // ---------------------------------------------------------------------------------------

    /**
     * Runs a command whose output goes into out; see VdHostProtocol.Proxy.exec(). Only reading
     * the logs (logcat without the options that clear them or write files) and sizing logd's
     * buffers (logcat -G now, setprop persist.logd.size* for the next boot) are allowed.
     */
    IBinder exec(String[] argv, ParcelFileDescriptor out, IBinder client) {
        if (!isAllowedCommand(argv)) {
            closeQuietly(out);
            throw new SecurityException("command not allowed: " + Arrays.toString(argv));
        }
        if (out == null || client == null) {
            closeQuietly(out);
            throw new IllegalArgumentException("output and client token are required");
        }
        String[] command = argv.clone();
        command[0] = "/system/bin/" + argv[0];   // not whatever PATH the host process has
        java.lang.Process proc;
        try {
            proc = new ProcessBuilder(command).redirectErrorStream(true).start();
        } catch (IOException e) {
            closeQuietly(out);
            throw new IllegalStateException(String.valueOf(e));
        }
        ExecHandle handle = new ExecHandle(proc, out, client);
        handle.start();
        return handle;
    }

    static boolean isAllowedCommand(String[] argv) {
        if (argv == null || argv.length == 0) return false;
        if ("setprop".equals(argv[0])) {
            return argv.length == 3 && argv[1] != null && argv[1].startsWith("persist.logd.size");
        }
        if (!"logcat".equals(argv[0])) return false;
        for (int i = 1; i < argv.length; i++) {
            String a = argv[i];
            if (a == null) return false;
            if (a.equals("-b") || a.equals("-v") || a.equals("-T") || a.equals("-G")) {
                i++;                                    // its value
                if (i >= argv.length || argv[i] == null) return false;
            } else if (!a.equals("-g") && !a.equals("-d") && !a.startsWith("--pid=")) {
                return false;
            }
        }
        return true;
    }

    /** A running command: pumps its output to the client, which waits for it or stops it. */
    private static final class ExecHandle extends Binder {
        private final java.lang.Process mProc;
        private final ParcelFileDescriptor mOut;
        private final IBinder mClient;
        private final IBinder.DeathRecipient mDeath = this::destroy;

        ExecHandle(java.lang.Process proc, ParcelFileDescriptor out, IBinder client) {
            mProc = proc;
            mOut = out;
            mClient = client;
        }

        void start() {
            try {
                mClient.linkToDeath(mDeath, 0);
            } catch (RemoteException e) {
                destroy();
                closeQuietly(mOut);
                return;
            }
            Thread t = new Thread(this::pump, "vdhost-exec");
            t.setDaemon(true);
            t.start();
        }

        /** Until the command ends, or the client closes its end of the pipe (or dies). */
        private void pump() {
            try (InputStream in = mProc.getInputStream();
                 OutputStream out = new ParcelFileDescriptor.AutoCloseOutputStream(mOut)) {
                byte[] buf = new byte[8192];
                int n;
                while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
            } catch (IOException ignore) {
                // The client closed its end: the command is not wanted any more.
            } finally {
                destroy();
                try { mClient.unlinkToDeath(mDeath, 0); } catch (Throwable ignore) { }
            }
        }

        void destroy() {
            try { mProc.destroy(); } catch (Throwable ignore) { }
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == VdHostProtocol.EXEC_WAIT_FOR) {
                int exit;
                try {
                    exit = mProc.waitFor();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    exit = -1;
                }
                if (reply != null) reply.writeInt(exit);
                return true;
            }
            if (code == VdHostProtocol.EXEC_DESTROY) {
                destroy();
                return true;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    private static void closeQuietly(ParcelFileDescriptor pfd) {
        if (pfd == null) return;
        try { pfd.close(); } catch (Throwable ignore) { }
    }

    // ---------------------------------------------------------------------------------------
    // BOOT_COMPLETED
    // ---------------------------------------------------------------------------------------

    /**
     * Sends BOOT_COMPLETED to one package, the way the launcher's boot autostart wakes an app as
     * system. It is a protected broadcast: system and root may send it, shell may not.
     *
     * Straight to the activity manager, as am does it, and am only when that call is missing.
     * am from the Magisk daemon ended at once with exit 255 and no output, not even its
     * "Broadcasting:" line: system_server writes am's output into the daemon's pipe, which it
     * may not, and the command gave up before it sent anything.
     */
    String sendBootCompleted(String pkg) {
        if (pkg == null || !PACKAGE_NAME.matcher(pkg).matches()) {
            throw new IllegalArgumentException("bad package name: " + pkg);
        }
        int me = Process.myUid();
        if (me != 0 && me != Process.SYSTEM_UID) {
            return "UNSUPPORTED (only system or root may send BOOT_COMPLETED)";
        }
        String result;
        try {
            result = broadcastBootCompleted(pkg);
        } catch (Throwable t) {
            Throwable cause = t instanceof InvocationTargetException && t.getCause() != null
                    ? t.getCause() : t;
            Log.w(TAG, "BOOT_COMPLETED through the activity manager failed, trying am: " + cause);
            result = VdHostCore.runCommand(null, "/system/bin/am", "broadcast",
                    "-a", Intent.ACTION_BOOT_COMPLETED, "-p", pkg,
                    "-f", String.valueOf(BOOT_BROADCAST_FLAGS));
        }
        Log.i(TAG, "BOOT_COMPLETED to " + pkg + ": " + result);
        return result;
    }

    /**
     * IActivityManager.broadcastIntentWithFeature() (Android 11+) or broadcastIntent(), with no
     * caller, as am calls it. Their parameters differ between releases, but keep their order:
     * the intent, then ints for the result code, the app op and, last, the user.
     */
    private static String broadcastBootCompleted(String pkg) throws ReflectiveOperationException {
        Object am = Hidden.getService("activity", "android.app.IActivityManager");
        Method broadcast = null;
        for (String name : new String[]{ "broadcastIntentWithFeature", "broadcastIntent" }) {
            for (Method m : am.getClass().getMethods()) {
                if (!m.getName().equals(name)
                        || !Arrays.asList(m.getParameterTypes()).contains(Intent.class)) continue;
                if (broadcast == null
                        || m.getParameterTypes().length > broadcast.getParameterTypes().length) {
                    broadcast = m;
                }
            }
            if (broadcast != null) break;
        }
        if (broadcast == null) throw new NoSuchMethodException("IActivityManager.broadcastIntent");

        Intent intent = new Intent(Intent.ACTION_BOOT_COMPLETED)
                .setPackage(pkg)
                .addFlags(BOOT_BROADCAST_FLAGS);
        Class<?>[] types = broadcast.getParameterTypes();
        int ints = 0;
        for (Class<?> type : types) if (type == int.class) ints++;
        Object[] args = new Object[types.length];
        int intIndex = 0;
        for (int i = 0; i < types.length; i++) {
            if (types[i] == Intent.class) {
                args[i] = intent;
            } else if (types[i] == int.class) {
                // resultCode 0, appOp OP_NONE, the current user (UserHandle.USER_CURRENT)
                args[i] = intIndex == 0 ? 0 : intIndex == ints - 1 ? USER_CURRENT : OP_NONE;
                intIndex++;
            } else if (types[i] == boolean.class) {
                args[i] = false;    // neither ordered nor sticky
            }
        }
        Object result = broadcast.invoke(am, args);
        return Integer.valueOf(BROADCAST_SUCCESS).equals(result)
                ? "OK (binder)" : "FAILED (binder, result " + result + ")";
    }

    // ---------------------------------------------------------------------------------------
    // WRITE_SETTINGS
    // ---------------------------------------------------------------------------------------

    /** Allows the caller's package to write the system settings, as the user can in Settings. */
    String allowWriteSettings(int callerUid, String pkg) {
        if (pkg == null || !VdHostCore.isPackageOfUid(pkg, callerUid)) {
            throw new SecurityException(pkg + " is not a package of uid " + callerUid);
        }
        String result = VdHostCore.runCommand(null,
                "/system/bin/cmd", "appops", "set", pkg, "WRITE_SETTINGS", "allow");
        Log.i(TAG, "WRITE_SETTINGS for " + pkg + ": " + result);
        return result;
    }

    // ---------------------------------------------------------------------------------------
    // Foreground app
    // ---------------------------------------------------------------------------------------

    private final Object mForegroundLock = new Object();
    private final List<IBinder> mForegroundWatchers = new ArrayList<>();
    private Handler mForegroundHandler;
    private Object mTaskService;
    private Method mUnregisterListener;
    private Listener mListener;
    private String mLastForeground;

    /**
     * Tells callback the app in front on the main display whenever it changes, from the system's
     * task stack: what the launcher's ForegroundAppTracker gets itself as system. Registering a
     * task stack listener and reading other apps' tasks need MANAGE_ACTIVITY_TASKS (STACKS before
     * Android 12) and REAL_GET_TASKS, which system and shell have.
     *
     * callback gets VdHostProtocol.FOREGROUND_CHANGED (one-way, the package as a String).
     */
    void watchForeground(IBinder callback) {
        if (callback == null) throw new IllegalArgumentException("callback is null");
        synchronized (mForegroundLock) {
            if (mForegroundWatchers.contains(callback)) return;
            if (mListener == null) registerListener();
            try {
                callback.linkToDeath(() -> removeWatcher(callback), 0);
            } catch (RemoteException e) {
                return;
            }
            mForegroundWatchers.add(callback);
            mLastForeground = null;     // the new watcher gets the current app at once
        }
        scheduleForegroundCheck();
    }

    /** Caller holds mForegroundLock. */
    private void registerListener() {
        try {
            HandlerThread t = new HandlerThread("vdhost-foreground");
            t.start();
            mForegroundHandler = new Handler(t.getLooper());
            Object service = VdHostCore.activityTasks();
            Class<?> listenerInterface = Class.forName("android.app.ITaskStackListener");
            Listener listener = new Listener();
            service.getClass().getMethod("registerTaskStackListener", listenerInterface)
                    .invoke(service, listener);
            mUnregisterListener = service.getClass()
                    .getMethod("unregisterTaskStackListener", listenerInterface);
            mTaskService = service;
            mListener = listener;
            Log.i(TAG, "task stack listener registered for the launcher's foreground app");
        } catch (Throwable t) {
            Throwable cause = t.getCause() != null ? t.getCause() : t;
            throw new IllegalStateException("task stack listener refused: " + cause);
        }
    }

    private void removeWatcher(IBinder callback) {
        synchronized (mForegroundLock) {
            mForegroundWatchers.remove(callback);
            if (!mForegroundWatchers.isEmpty() || mListener == null) return;
            try {
                mUnregisterListener.invoke(mTaskService, mListener);
            } catch (Throwable t) {
                Log.w(TAG, "unregisterTaskStackListener failed: " + t);
            }
            mListener = null;
            mForegroundHandler.getLooper().quitSafely();
            mForegroundHandler = null;
        }
    }

    private void scheduleForegroundCheck() {
        Handler h;
        synchronized (mForegroundLock) {
            h = mForegroundHandler;
        }
        if (h == null) return;
        h.removeCallbacks(mForegroundCheck);
        h.postDelayed(mForegroundCheck, FOREGROUND_DEBOUNCE_MS);
    }

    private final Runnable mForegroundCheck = this::reportForeground;

    private void reportForeground() {
        String pkg = topPackageOnMainDisplay();
        if (pkg == null) return;
        IBinder[] watchers;
        synchronized (mForegroundLock) {
            if (pkg.equals(mLastForeground)) return;
            mLastForeground = pkg;
            watchers = mForegroundWatchers.toArray(new IBinder[0]);
        }
        for (IBinder w : watchers) {
            Parcel data = Parcel.obtain();
            try {
                data.writeString(pkg);
                w.transact(VdHostProtocol.FOREGROUND_CHANGED, data, null, IBinder.FLAG_ONEWAY);
            } catch (Throwable t) {
                Log.w(TAG, "foreground report failed: " + t);
            } finally {
                data.recycle();
            }
        }
    }

    /** The package of the top task on the main display: the panes' tasks are on their own. */
    private static String topPackageOnMainDisplay() {
        try {
            List<Object> stacks = VdHostCore.stacksOn(VdHostCore.activityTasks(), 0);
            if (stacks == null) return null;
            for (Object info : stacks) {
                if (info == null || Boolean.FALSE.equals(visibleOf(info))) continue;
                Object top = Hidden.readField(info, "topActivity");
                if (top instanceof ComponentName) return ((ComponentName) top).getPackageName();
            }
        } catch (Throwable t) {
            Log.w(TAG, "reading the top task failed: " + t);
        }
        return null;
    }

    /** RootTaskInfo (Android 12+) has isVisible, StackInfo visible; null when neither. */
    private static Boolean visibleOf(Object info) {
        Object v = Hidden.readField(info, "isVisible");
        if (v == null) v = Hidden.readField(info, "visible");
        return v instanceof Boolean ? (Boolean) v : null;
    }

    /** Called on binder threads. */
    private final class Listener extends TaskStackListener {
        @Override
        public void onTaskStackChanged() {
            scheduleForegroundCheck();
        }

        @Override
        public void onTaskMovedToFront(ActivityManager.RunningTaskInfo taskInfo) {
            scheduleForegroundCheck();
        }

        /** Android 8-9 pass the task id only. */
        public void onTaskMovedToFront(int taskId) {
            scheduleForegroundCheck();
        }
    }
}
