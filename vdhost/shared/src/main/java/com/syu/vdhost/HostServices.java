package com.syu.vdhost;

import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
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
     */
    String sendBootCompleted(String pkg) {
        if (pkg == null || !PACKAGE_NAME.matcher(pkg).matches()) {
            throw new IllegalArgumentException("bad package name: " + pkg);
        }
        int me = Process.myUid();
        if (me != 0 && me != Process.SYSTEM_UID) {
            return "UNSUPPORTED (only system or root may send BOOT_COMPLETED)";
        }
        String result = VdHostCore.runCommand(null, "/system/bin/am", "broadcast",
                "-a", "android.intent.action.BOOT_COMPLETED", "-p", pkg,
                "-f", String.valueOf(BOOT_BROADCAST_FLAGS));
        Log.i(TAG, "BOOT_COMPLETED to " + pkg + ": " + result);
        return result;
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
