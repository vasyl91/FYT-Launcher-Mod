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
 * Three hosts, most reliable first:
 *  1. LOCAL   -- the launcher runs as android.uid.system (FYT install): the host runs right here.
 *  2. DAEMON  -- the FYT VDHost Magisk module's daemon (uid 1000) pushes its binder into
 *                WindowHostVdProvider shortly after this process starts, and after a restart.
 *  3. SHIZUKU -- WindowHostVdShizukuService, run by Shizuku as shell; no root needed.
 *
 * The first host that attaches is kept until it dies. The order holds because LOCAL is created
 * synchronously, and Shizuku waits for the daemon whenever the module is installed; a daemon that
 * still comes late replaces Shizuku.
 */
public final class WindowHostVdClient {
    private static final String TAG = "WindowHostVdClient";

    enum Source { LOCAL, DAEMON, SHIZUKU }

    interface Listener {
        /** Main thread. available == false: the host died and every display it owned is gone. */
        void onHostChanged(boolean available);
    }

    private static final Object sLock = new Object();
    private static VdHostProtocol.Proxy sHost;
    private static Source sSource;
    private static IBinder.DeathRecipient sDeath;

    private static final CopyOnWriteArrayList<Listener> sListeners = new CopyOnWriteArrayList<>();
    /** Displays created through this client, so the reaper only asks the host about its own. */
    private static final Set<Integer> sDisplays = ConcurrentHashMap.newKeySet();
    private static final Handler sMain = new Handler(Looper.getMainLooper());

    private WindowHostVdClient() {}

    /** From Application.onCreate(): starts listening for Shizuku. */
    public static void init(Context ctx) {
        if (ctx == null) return;
        WindowHostVdShizuku.init(ctx.getApplicationContext());
    }

    static boolean isSystemUid() {
        return Process.myUid() == Process.SYSTEM_UID;
    }

    /** The Magisk module sets ro.fyt.vdhost=1 (system.prop). */
    public static boolean isModuleInstalled() {
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
     *
     * Android 10 keeps the real ActivityView. Android 12+ has no ActivityView at all, so it is
     * always WindowHostVdView there: with no host yet the panes just stay empty instead of
     * crashing. Android 11 still has a framework ActivityView, which is kept as a last resort
     * when no host can be expected.
     */
    static boolean shouldUse() {
        if (Build.VERSION.SDK_INT < 30) return false;
        if (Build.VERSION.SDK_INT >= 31) return true;
        return canHostPanes();
    }

    /**
     * Android 11+: whether some host is there or can be expected. Rooted without the Magisk
     * module and without Shizuku there is nothing that could run the panes.
     */
    public static boolean canHostPanes() {
        if (Build.VERSION.SDK_INT < 30) return false;
        return current() != null || isSystemUid() || isModuleInstalled() || WindowHostVdShizuku.isUsable();
    }

    /** The host, or null while none has attached yet. */
    static VdHostProtocol.Proxy get(Context ctx) {
        synchronized (sLock) {
            if (sHost != null) return sHost;
            if (Build.VERSION.SDK_INT >= 30 && isSystemUid() && ctx != null) {
                try {
                    VdHostCore core = new VdHostCore(ctx.getApplicationContext());
                    final int myUid = Process.myUid();
                    VdHostStub stub = new VdHostStub(core, uid -> uid == myUid);
                    sHost = new VdHostProtocol.Proxy(stub);
                    sSource = Source.LOCAL;
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

    /** WindowHostVdProvider, on a binder thread. @return whether the binder was taken */
    static boolean onDaemonAttached(IBinder binder) {
        return attach(binder, Source.DAEMON);
    }

    /** WindowHostVdShizuku, on the main thread. @return whether the binder was taken */
    static boolean onShizukuAttached(IBinder binder) {
        return attach(binder, Source.SHIZUKU);
    }

    private static boolean attach(IBinder binder, Source source) {
        if (binder == null) return false;
        VdHostProtocol.Proxy proxy = new VdHostProtocol.Proxy(binder);
        int version;
        try {
            version = proxy.getVersion();
        } catch (Throwable t) {
            Log.w(TAG, source + " VD host did not answer", t);
            return false;
        }
        if (version != VdHostProtocol.VERSION) {
            Log.w(TAG, source + " VD host speaks protocol " + version + ", expected "
                    + VdHostProtocol.VERSION + " -- update the Magisk module and the launcher together");
            return false;
        }

        final boolean replaced;
        synchronized (sLock) {
            if (sHost != null && sHost.asBinder() == binder) return true;
            if (sHost != null) {
                // Only a daemon may push Shizuku aside; everything else keeps what it has.
                if (!(source == Source.DAEMON && sSource == Source.SHIZUKU)) {
                    return source == Source.DAEMON;   // tell the daemon to stop retrying
                }
            }
            final IBinder.DeathRecipient death = () -> onHostDied(binder);
            try {
                binder.linkToDeath(death, 0);
            } catch (RemoteException e) {
                return false;
            }
            replaced = sHost != null;
            if (replaced && sDeath != null) {
                try { sHost.asBinder().unlinkToDeath(sDeath, 0); } catch (Throwable ignore) { }
            }
            sHost = proxy;
            sSource = source;
            sDeath = death;
        }

        Log.i(TAG, source + " VD host attached" + (replaced ? ", replacing Shizuku" : ""));
        if (replaced) {
            // The panes drop their Shizuku displays and recreate them on the daemon; unbinding
            // ends the Shizuku service process, which releases the old displays.
            sDisplays.clear();
            notifyListeners(false);
            sMain.post(WindowHostVdShizuku::unbind);
        }
        notifyListeners(true);
        if (!replaced) sMain.post(WindowHostVdClient::openPanesIfMissing);
        return true;
    }

    /**
     * A host can attach after the launcher already decided there was nothing to show the panes
     * with (Shizuku's binder arrives a moment after start-up). Ask once more; openPip() checks
     * on its own whether panes are wanted at all.
     */
    private static void openPanesIfMissing() {
        try {
            if (WindowUtil.getActiveWindowHost() == null) WindowUtil.startMapPip(false);
        } catch (Throwable t) {
            Log.w(TAG, "re-opening the panes failed", t);
        }
    }

    private static void onHostDied(IBinder binder) {
        Source source;
        synchronized (sLock) {
            if (sHost == null || sHost.asBinder() != binder) return;
            source = sSource;
            sHost = null;
            sSource = null;
            sDeath = null;
        }
        sDisplays.clear();
        Log.w(TAG, source + " VD host died; its displays are gone");
        notifyListeners(false);
        // The daemon is restarted by service.sh and redelivers; until then Shizuku may stand in.
        WindowHostVdShizuku.onHostLost();
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
