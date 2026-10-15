package com.syu.vdhost.server;

import android.app.ActivityManager;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

import com.syu.vdhost.VdHostProtocol;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hands the host binder to the launcher.
 *
 * The launcher cannot look the daemon up (ServiceManager.getService() of an unlabelled service is
 * blocked for apps by SELinux), so the daemon pushes: it watches for the launcher process and
 * calls the launcher's ContentProvider "<package>.vdhost" with the binder in the extras, the way
 * the `content call` shell command reaches a provider without being an app itself.
 *
 * Polling getRunningAppProcesses() once a second is the only version-independent way to notice
 * a new launcher process (IProcessObserver's transaction codes differ between releases), and it
 * costs next to nothing.
 */
final class BinderDelivery {
    private static final String TAG = "FytVdHost";
    private static final long POLL_MS = 1000;

    interface UidSink {
        void accept(Integer uid);
    }

    private final IBinder mHost;
    private final List<String> mPackages;
    private final String mOwnPackage;
    private final UidSink mAllowUid;
    private final Map<String, Integer> mDeliveredPid = new HashMap<>();
    private final Map<String, Integer> mFailures = new HashMap<>();
    private int mTicks;
    private Handler mHandler;
    private Object mActivityManager;

    BinderDelivery(IBinder host, List<String> packages, String ownPackage, UidSink allowUid) {
        mHost = host;
        mPackages = packages;
        mOwnPackage = ownPackage;
        mAllowUid = allowUid;
    }

    void start() {
        HandlerThread t = new HandlerThread("vdhost-delivery");
        t.start();
        mHandler = new Handler(t.getLooper());
        mHandler.post(this::tick);
    }

    private void tick() {
        try {
            pollOnce();
        } catch (Throwable t) {
            Log.w(TAG, "delivery poll failed", t);
        }
        mHandler.postDelayed(this::tick, POLL_MS);
    }

    @SuppressWarnings("unchecked")
    private void pollOnce() throws ReflectiveOperationException {
        if (mActivityManager == null) {
            mActivityManager = getService("activity", "android.app.IActivityManager");
        }
        List<ActivityManager.RunningAppProcessInfo> procs = (List<ActivityManager.RunningAppProcessInfo>)
                mActivityManager.getClass().getMethod("getRunningAppProcesses").invoke(mActivityManager);
        if (procs == null) return;

        for (String pkg : mPackages) {
            ActivityManager.RunningAppProcessInfo proc = null;
            for (ActivityManager.RunningAppProcessInfo p : procs) {
                if (pkg.equals(p.processName)) { proc = p; break; }
            }
            if (proc == null) {
                mDeliveredPid.remove(pkg);
                mFailures.remove(pkg);
                continue;
            }
            Integer done = mDeliveredPid.get(pkg);
            if (done != null && done == proc.pid) continue;

            // A launcher without the provider (an older build) would be retried, and logged,
            // every second for as long as it runs; after a few misses, try twice a minute.
            Integer failed = mFailures.get(pkg);
            int misses = failed != null ? failed : 0;
            if (misses >= 5 && (++mTicks % 30) != 0) continue;

            // Allow the uid before the launcher can possibly call back.
            mAllowUid.accept(proc.uid);
            if (deliver(pkg, proc.uid / 100000)) {
                mDeliveredPid.put(pkg, proc.pid);
                mFailures.remove(pkg);
                VdHostServer.log("binder delivered to " + pkg + " pid=" + proc.pid + " uid=" + proc.uid);
            } else {
                mFailures.put(pkg, misses + 1);
            }
        }
    }

    private boolean deliver(String pkg, int userId) {
        String authority = pkg + VdHostProtocol.AUTHORITY_SUFFIX;
        IBinder token = new Binder();
        Object holder = null;
        try {
            holder = getContentProviderExternal(authority, userId, token);
            if (holder == null) {
                Log.w(TAG, "no provider " + authority + " (launcher too old?)");
                return false;
            }
            Object provider = readField(holder, "provider");
            if (provider == null) return false;

            Bundle extras = new Bundle();
            extras.putBinder(VdHostProtocol.KEY_BINDER, mHost);
            extras.putInt(VdHostProtocol.KEY_VERSION, VdHostProtocol.VERSION);
            Bundle res = callProvider(provider, authority, extras);
            return res != null && res.getBoolean(VdHostProtocol.KEY_ACCEPTED, false);
        } catch (Throwable t) {
            Log.w(TAG, "delivery to " + pkg + " failed", t);
            return false;
        } finally {
            if (holder != null) removeContentProviderExternal(authority, token, userId);
        }
    }

    private Object getContentProviderExternal(String authority, int userId, IBinder token)
            throws ReflectiveOperationException {
        Object am = mActivityManager;
        for (Method m : am.getClass().getMethods()) {
            if (!m.getName().equals("getContentProviderExternal")) continue;
            Class<?>[] p = m.getParameterTypes();
            if (p.length == 4) return m.invoke(am, authority, userId, token, "fyt_vdhost");
            if (p.length == 3) return m.invoke(am, authority, userId, token);
        }
        throw new NoSuchMethodException("getContentProviderExternal");
    }

    private void removeContentProviderExternal(String authority, IBinder token, int userId) {
        Object am = mActivityManager;
        try {
            for (Method m : am.getClass().getMethods()) {
                if (m.getName().equals("removeContentProviderExternalAsUser") && m.getParameterTypes().length == 3) {
                    m.invoke(am, authority, token, userId);
                    return;
                }
            }
            for (Method m : am.getClass().getMethods()) {
                if (m.getName().equals("removeContentProviderExternal") && m.getParameterTypes().length == 2) {
                    m.invoke(am, authority, token);
                    return;
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "removeContentProviderExternal failed", t);
        }
    }

    /**
     * IContentProvider.call():
     *   Android 8-9: (String callingPkg, String method, String arg, Bundle extras)
     *   Android 10:  (String callingPkg, String authority, String method, String arg, Bundle extras)
     *   Android 11:  (String callingPkg, String featureId, String authority, String method, String arg, Bundle extras)
     *   Android 12+: (AttributionSource source, String authority, String method, String arg, Bundle extras)
     */
    private Bundle callProvider(Object provider, String authority, Bundle extras) throws ReflectiveOperationException {
        for (Method m : provider.getClass().getMethods()) {
            if (!m.getName().equals("call") || m.getReturnType() != Bundle.class) continue;
            Class<?>[] p = m.getParameterTypes();
            Object[] args = new Object[p.length];
            int strings = 0;
            for (Class<?> c : p) if (c == String.class) strings++;
            boolean attribution = p.length > 0 && "android.content.AttributionSource".equals(p[0].getName());

            String[] stringArgs;
            if (attribution) {
                stringArgs = new String[]{ authority, VdHostProtocol.METHOD_ATTACH, null };
            } else if (strings == 5) {
                stringArgs = new String[]{ mOwnPackage, null, authority, VdHostProtocol.METHOD_ATTACH, null };
            } else if (strings == 4) {
                stringArgs = new String[]{ mOwnPackage, authority, VdHostProtocol.METHOD_ATTACH, null };
            } else if (strings == 3) {
                stringArgs = new String[]{ mOwnPackage, VdHostProtocol.METHOD_ATTACH, null };
            } else {
                continue;
            }

            int s = 0;
            for (int i = 0; i < p.length; i++) {
                if (p[i] == String.class) args[i] = stringArgs[s++];
                else if (p[i] == Bundle.class) args[i] = extras;
                else if (attribution && i == 0) args[i] = Attribution.create(mOwnPackage);
                else args[i] = null;
            }
            return (Bundle) m.invoke(provider, args);
        }
        throw new NoSuchMethodException("IContentProvider.call");
    }

    /** Kept apart so AttributionSource (Android 12+) is only resolved where it exists. */
    private static final class Attribution {
        static Object create(String pkg) {
            if (Build.VERSION.SDK_INT < 31) return null;
            return new AttributionSource.Builder(Process.myUid()).setPackageName(pkg).build();
        }
    }

    private static Object getService(String name, String iface) throws ReflectiveOperationException {
        Class<?> sm = Class.forName("android.os.ServiceManager");
        IBinder b = (IBinder) sm.getMethod("getService", String.class).invoke(null, name);
        if (b == null) throw new IllegalStateException("no service " + name);
        return Class.forName(iface + "$Stub").getMethod("asInterface", IBinder.class).invoke(null, b);
    }

    private static Object readField(Object o, String name) {
        Class<?> c = o.getClass();
        while (c != null) {
            try {
                java.lang.reflect.Field f = c.getDeclaredField(name);
                f.setAccessible(true);
                return f.get(o);
            } catch (NoSuchFieldException e) {
                c = c.getSuperclass();
            } catch (Throwable t) {
                return null;
            }
        }
        return null;
    }
}
