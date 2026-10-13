package com.syu.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.syu.vdhost.VdHostCore;
import com.syu.vdhost.VdHostProtocol;
import com.syu.vdhost.VdHostStub;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Connection to the VD host, which stands in for the framework's ActivityView on Android 11+
 * (see WindowHostVdView).
 *
 * There are two hosts:
 *  - the launcher runs as android.uid.system: the host runs right here, in-process;
 *  - otherwise the FYT VDHost Magisk module's daemon pushes its binder into
 *    WindowHostVdProvider shortly after this process starts, and again if the daemon restarts.
 */
public final class WindowHostVdClient {
    private static final String TAG = "WindowHostVdClient";

    interface Listener {
        /** Main thread. available == false: the daemon died and every display it owned is gone. */
        void onHostChanged(boolean available);
    }

    private static final Object sLock = new Object();
    private static VdHostProtocol.Proxy sHost;
    private static boolean sLocal;
    private static IBinder.DeathRecipient sDeath;

    private static final CopyOnWriteArrayList<Listener> sListeners = new CopyOnWriteArrayList<>();
    /** Displays created through this client, so the reaper only asks the host about its own. */
    private static final Set<Integer> sDisplays = ConcurrentHashMap.newKeySet();
    private static final Handler sMain = new Handler(Looper.getMainLooper());

    private WindowHostVdClient() {}

    static boolean isSystemUid() {
        return Process.myUid() == Process.SYSTEM_UID;
    }

    /** The Magisk module sets ro.fyt.vdhost=1 (system.prop). */
    static boolean isModuleInstalled() {
        try {
            Class<?> sp = Class.forName("android.os.SystemProperties");
            Object v = sp.getMethod("get", String.class, String.class)
                    .invoke(null, VdHostProtocol.PROP_MODULE, "");
            return "1".equals(v);
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * Whether the panes should be WindowHostVdView instead of the framework's ActivityView.
     * Android 10 keeps the real ActivityView. From Android 11 on, the framework class is either
     * gone (12+) or rebuilt around TaskEmbedder (11) without the members WindowHost* relies on.
     */
    static boolean shouldUse() {
        if (Build.VERSION.SDK_INT < 30) return false;
        return isSystemUid() || isModuleInstalled() || current() != null;
    }

    /** The host, or null while the daemon has not attached yet. */
    static VdHostProtocol.Proxy get(Context ctx) {
        synchronized (sLock) {
            if (sHost != null) return sHost;
            if (Build.VERSION.SDK_INT >= 30 && isSystemUid() && ctx != null) {
                try {
                    VdHostCore core = new VdHostCore(ctx.getApplicationContext());
                    final int myUid = Process.myUid();
                    VdHostStub stub = new VdHostStub(core, uid -> uid == myUid);
                    sHost = new VdHostProtocol.Proxy(stub);
                    sLocal = true;
                    Log.i(TAG, "in-process VD host (the launcher runs as system)");
                } catch (Throwable t) {
                    Log.w(TAG, "in-process VD host unavailable", t);
                }
            }
            return sHost;
        }
    }

    static VdHostProtocol.Proxy current() {
        synchronized (sLock) {
            return sHost;
        }
    }

    /**
     * WindowHostVdProvider, on a binder thread.
     *
     * @return whether the binder was taken
     */
    static boolean onDaemonAttached(IBinder binder) {
        if (binder == null) return false;
        VdHostProtocol.Proxy proxy = new VdHostProtocol.Proxy(binder);
        int version;
        try {
            version = proxy.getVersion();
        } catch (Throwable t) {
            Log.w(TAG, "VD host daemon did not answer", t);
            return false;
        }
        if (version != VdHostProtocol.VERSION) {
            Log.w(TAG, "VD host protocol " + version + ", expected " + VdHostProtocol.VERSION
                    + " -- update the Magisk module and the launcher together");
            return false;
        }

        synchronized (sLock) {
            if (sLocal) return true;                                   // in-process host wins
            if (sHost != null && sHost.asBinder() == binder) return true;

            final IBinder.DeathRecipient death = () -> onDaemonDied(binder);
            try {
                binder.linkToDeath(death, 0);
            } catch (RemoteException e) {
                return false;
            }
            if (sHost != null && sDeath != null) {
                try { sHost.asBinder().unlinkToDeath(sDeath, 0); } catch (Throwable ignore) { }
            }
            sHost = proxy;
            sDeath = death;
        }
        Log.i(TAG, "VD host daemon attached");
        notifyListeners(true);
        return true;
    }

    private static void onDaemonDied(IBinder binder) {
        synchronized (sLock) {
            if (sHost == null || sHost.asBinder() != binder) return;
            sHost = null;
            sDeath = null;
        }
        sDisplays.clear();
        Log.w(TAG, "VD host daemon died; its displays are gone");
        notifyListeners(false);
    }

    static void addListener(Listener l) {
        if (l != null) sListeners.addIfAbsent(l);
    }

    static void removeListener(Listener l) {
        sListeners.remove(l);
    }

    private static void notifyListeners(boolean available) {
        sMain.post(() -> {
            for (Listener l : sListeners) {
                try { l.onHostChanged(available); } catch (Throwable t) { Log.w(TAG, "listener failed", t); }
            }
        });
    }

    static void noteDisplay(int displayId, boolean alive) {
        if (alive) sDisplays.add(displayId);
        else sDisplays.remove(displayId);
    }

    /**
     * For WindowHostAvReaper: on Android 11+ the launcher may not list another app's tasks, the
     * host may.
     *
     * @return null when the display is not one of ours or the host cannot tell
     */
    static Boolean isDisplayEmpty(int displayId) {
        if (!sDisplays.contains(displayId)) return null;
        VdHostProtocol.Proxy host = current();
        if (host == null) return null;
        try {
            int n = host.getTaskCount(displayId);
            return n < 0 ? null : n == 0;
        } catch (Throwable t) {
            return null;
        }
    }
}
