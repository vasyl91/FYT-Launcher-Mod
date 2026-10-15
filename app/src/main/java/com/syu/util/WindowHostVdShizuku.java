package com.syu.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.BuildConfig;
import com.syu.vdhost.VdHostProtocol;

import rikka.shizuku.Shizuku;

/**
 * The lowest-priority VD host: WindowHostVdShizukuService, run by Shizuku as shell (no root).
 *
 * Bound only when no better host is there: never when the launcher is system (in-process host),
 * and, when the Magisk module is installed, only after its daemon has had DAEMON_GRACE_MS to
 * attach -- at boot the daemon starts later than the launcher. If the daemon shows up after all,
 * WindowHostVdClient switches to it and unbinds this one.
 *
 * Everything here runs on the main thread.
 */
final class WindowHostVdShizuku {
    private static final String TAG = "WindowHostVdShizuku";

    private static final long DAEMON_GRACE_MS = 20_000L;
    private static final int PERMISSION_REQUEST_CODE = 0x7d;

    private static final Handler sMain = new Handler(Looper.getMainLooper());
    private static Context sApp;
    private static boolean sInitialized;
    private static boolean sPermissionAsked;
    private static boolean sBound;
    private static long sGraceStart;
    private static Shizuku.UserServiceArgs sArgs;

    private static final ServiceConnection sConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.i(TAG, "Shizuku VD host connected");
            if (!WindowHostVdClient.onShizukuAttached(binder)) unbind();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // WindowHostVdClient sees the binder die on its own; just allow a new bind.
            sBound = false;
        }
    };

    private WindowHostVdShizuku() {}

    static void init(Context app) {
        if (sInitialized || WindowHostVdClient.isSystemUid()) return;
        sInitialized = true;
        sApp = app;
        sGraceStart = SystemClock.elapsedRealtime();
        try {
            Shizuku.addBinderReceivedListenerSticky(WindowHostVdShizuku::maybeBind, sMain);
            Shizuku.addBinderDeadListener(() -> sBound = false, sMain);
            Shizuku.addRequestPermissionResultListener((requestCode, result) -> {
                if (requestCode != PERMISSION_REQUEST_CODE) return;
                Log.i(TAG, "Shizuku permission " + (result == PackageManager.PERMISSION_GRANTED ? "granted" : "denied"));
                maybeBind();
            }, sMain);
        } catch (Throwable t) {
            // The Shizuku API is part of the APK; this only guards against a broken install.
            Log.w(TAG, "Shizuku API unavailable", t);
        }
    }

    /**
     * Shizuku is running and this launcher may use it, or may still be asked to.
     * False once the user has denied the permission for good.
     */
    static boolean isUsable() {
        if (!sInitialized) return false;
        try {
            if (!Shizuku.pingBinder() || Shizuku.isPreV11()) return false;
            return Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED
                    || !Shizuku.shouldShowRequestPermissionRationale();
        } catch (Throwable t) {
            return false;
        }
    }

    /** A better host went away (or never came): reconsider binding, after a fresh grace period. */
    static void onHostLost() {
        if (!sInitialized) return;
        sGraceStart = SystemClock.elapsedRealtime();
        sMain.post(WindowHostVdShizuku::maybeBind);
    }

    static void maybeBind() {
        if (!sInitialized || sBound) return;
        if (WindowHostVdClient.current() != null) return;           // a host is already there
        try {
            if (!Shizuku.pingBinder()) return;                        // Shizuku not running
            if (Shizuku.isPreV11()) {
                Log.w(TAG, "Shizuku is too old (pre-v11); update it");
                return;
            }

            if (WindowHostVdClient.isModuleInstalled()) {
                long left = DAEMON_GRACE_MS - (SystemClock.elapsedRealtime() - sGraceStart);
                if (left > 0) {
                    sMain.postDelayed(WindowHostVdShizuku::maybeBind, left);
                    return;
                }
                Log.w(TAG, "FYT VDHost module installed but its daemon did not attach; using Shizuku");
            }

            if (Shizuku.checkSelfPermission() != PackageManager.PERMISSION_GRANTED) {
                if (!sPermissionAsked && !Shizuku.shouldShowRequestPermissionRationale()) {
                    sPermissionAsked = true;
                    Log.i(TAG, "requesting Shizuku permission");
                    Shizuku.requestPermission(PERMISSION_REQUEST_CODE);
                }
                return;
            }

            sBound = true;
            Shizuku.bindUserService(args(), sConnection);
            Log.i(TAG, "binding the Shizuku VD host (Shizuku uid " + Shizuku.getUid() + ")");
        } catch (Throwable t) {
            sBound = false;
            Log.w(TAG, "binding the Shizuku VD host failed", t);
        }
    }

    /** A better host took over, or this one was refused. */
    static void unbind() {
        if (!sBound || sArgs == null) return;
        sBound = false;
        try {
            Shizuku.unbindUserService(sArgs, sConnection, true);
        } catch (Throwable t) {
            Log.w(TAG, "unbinding the Shizuku VD host failed", t);
        }
    }

    private static Shizuku.UserServiceArgs args() {
        if (sArgs == null) {
            sArgs = new Shizuku.UserServiceArgs(
                    new ComponentName(sApp.getPackageName(), WindowHostVdShizukuService.class.getName()))
                    .daemon(false)                      // dies with the launcher process
                    .processNameSuffix("vdhost")
                    .debuggable(BuildConfig.DEBUG)
                    // A new launcher build must not keep talking to the old build's service.
                    .version(BuildConfig.VERSION_CODE * 100 + VdHostProtocol.VERSION);
        }
        return sArgs;
    }
}
