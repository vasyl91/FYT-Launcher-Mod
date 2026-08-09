package com.syu.util;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * Reflection facade over the ROM's hidden android.app.ActivityView.
 */
public class WindowHostActivityView {
    private static final String TAG = "WindowHostActivityView";

    private static Class<?> sActivityView, sStateCb;

    /** ActivityViews that already had the IME crash guard installed (see installImeCrashGuard). */
    private static final WeakHashMap<Object, Boolean> sImeGuarded = new WeakHashMap<>();

    // =====================================================================================
    // 1. Class loading / instantiation
    // =====================================================================================

    static void ensureLoaded() {
        if (sActivityView != null) return;
        try { sActivityView = Class.forName("android.app.ActivityView"); }
        catch (Throwable e) { throw new RuntimeException("ActivityView not available", e); }
        try { sStateCb = Class.forName("android.app.ActivityView$StateCallback"); }
        catch (Throwable ignore) { sStateCb = null; }
    }

    /**
     * Creates an ActivityView and immediately installs the IME crash guard on it.
     * Every ActivityView in the app must be created through here -- an unguarded instance will
     * kill its embedded app the first time it is moved between hosts.
     */
    static Object newInstance(Context ctx) {
        ensureLoaded();
        Object av = newInstanceRaw(ctx);
        installImeCrashGuard(av);
        return av;
    }

    private static Object newInstanceRaw(Context ctx) {
        try {
            try {
                Constructor<?> c = sActivityView.getDeclaredConstructor(Context.class, boolean.class);
                c.setAccessible(true);
                return c.newInstance(ctx, Boolean.TRUE);
            } catch (Throwable ignore) {}
            for (Constructor<?> c : sActivityView.getDeclaredConstructors()) {
                try {
                    Class<?>[] p = c.getParameterTypes();
                    c.setAccessible(true);
                    if (p.length == 1 && p[0] == Context.class) return c.newInstance(ctx);
                    if (p.length == 2 && p[0] == Context.class && p[1] == android.util.AttributeSet.class) return c.newInstance(ctx, null);
                    if (p.length == 3 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class) return c.newInstance(ctx, null, 0);
                    if (p.length == 4 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class && p[3] == int.class) return c.newInstance(ctx, null, 0, 0);
                } catch (Throwable ignore) {}
            }
            throw new IllegalStateException("No compatible ActivityView constructor");
        } catch (Throwable e) {
            throw new RuntimeException("No compatible ActivityView constructor", e);
        }
    }

    static View asView(Object av) { return (View) av; }

    static void release(Object av) {
        try { sActivityView.getMethod("release").invoke(av); } catch (Throwable ignore) {}
    }

    // =====================================================================================
    // 2. IME geometry safety
    // =====================================================================================

    static void installImeCrashGuard(final Object av) {
        try {
            if (av == null) return;
            synchronized (sImeGuarded) {
                if (Boolean.TRUE.equals(sImeGuarded.get(av))) return;
            }

            View avView = asView(av);
            SurfaceView sv = findSurfaceView(avView);
            if (sv == null) { Log.w(TAG, "installImeCrashGuard: no SurfaceView"); return; }
            final SurfaceHolder holder = sv.getHolder();
            if (holder == null) return;

            final Field fVd = findField(av.getClass(), "mVirtualDisplay");
            final Field fCb = findField(av.getClass(), "mSurfaceCallback");
            if (fVd == null || fCb == null) {
                Log.w(TAG, "installImeCrashGuard: fields not found (mVirtualDisplay/mSurfaceCallback)");
                return;
            }
            fVd.setAccessible(true);
            fCb.setAccessible(true);

            Object cbObj = fCb.get(av);
            if (!(cbObj instanceof SurfaceHolder.Callback)) return;
            final SurfaceHolder.Callback avCallback = (SurfaceHolder.Callback) cbObj;

            final Object[] parked = new Object[1];

            SurfaceHolder.Callback pre = new SurfaceHolder.Callback() {
                @Override public void surfaceCreated(SurfaceHolder h) { }
                @Override public void surfaceChanged(SurfaceHolder h, int f, int w, int hh) { }
                @Override public void surfaceDestroyed(SurfaceHolder h) {
                    try { parked[0] = fVd.get(av); fVd.set(av, null); } catch (Throwable ignore) { }
                }
            };

            SurfaceHolder.Callback post = new SurfaceHolder.Callback() {
                @Override public void surfaceCreated(SurfaceHolder h) { }
                @Override public void surfaceChanged(SurfaceHolder h, int f, int w, int hh) { }
                @Override public void surfaceDestroyed(SurfaceHolder h) {
                    Object vd = parked[0];
                    parked[0] = null;
                    if (vd == null) return;
                    try { fVd.set(av, vd); } catch (Throwable ignore) { }
                    // Re-do what the framework skipped while the field was temporarily null.
                    try {
                        Method m = vd.getClass().getMethod("setDisplayState", boolean.class);
                        m.setAccessible(true);
                        m.invoke(vd, Boolean.FALSE);
                    } catch (Throwable ignore) { }
                }
            };

            // dispatch order == registration order -> pre, ActivityView's own, post
            holder.removeCallback(avCallback);
            holder.addCallback(pre);
            holder.addCallback(avCallback);
            holder.addCallback(post);

            synchronized (sImeGuarded) { sImeGuarded.put(av, Boolean.TRUE); }
            Log.i(TAG, "installImeCrashGuard: installed");
        } catch (Throwable t) {
            Log.w(TAG, "installImeCrashGuard failed", t);
        }
    }

    /**
     * Forces one non-null InputMethodManager.reportActivityView() for this ActivityView.
     */
    static void primeImeGeometry(Object av) {
        try {
            View v = asView(av);
            if (v == null || !v.isAttachedToWindow()) return;

            Field f = findField(av.getClass(), "mLocationInWindow");
            if (f != null) {
                f.setAccessible(true);
                Object loc = f.get(av);
                if (loc instanceof int[]) {
                    int[] a = (int[]) loc;
                    if (a.length >= 2) { a[0] = Integer.MIN_VALUE; a[1] = Integer.MIN_VALUE; }
                }
            }
            invokeQuietly(av, "updateLocationAndTapExcludeRegion");
        } catch (Throwable ignore) { }
    }

    /** ActivityView.updateLocationAndTapExcludeRegion(), tolerant of the reparent race. */
    static void updateGeometry(Object av) {
        invokeQuietly(av, "updateLocationAndTapExcludeRegion");
    }

    /**
     * Does everything ActivityView.updateLocationAndTapExcludeRegion() does -- EXCEPT reporting
     * the ActivityView->screen matrix to the IME.
     *
     * @return true when the geometry was fully applied without any IME report.
     */
    static boolean syncGeometryWithoutIme(Object av) {
        return syncGeometryWithoutIme(av, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /**
     * Same, but with the caller supplying the position the ActivityView is ABOUT to be laid out at.
     *
     * Needed wherever we move a pane by changing LayoutParams: at that moment neither the view nor
     * its host has been laid out yet, so neither getLocationInWindow() nor the parent's position
     * can tell us where the view will end up. The caller that just wrote those LayoutParams does
     * know -- and it has to claim the position BEFORE the traversal, because
     * gatherTransparentRegion() runs inside that same traversal, ahead of any post-layout callback
     * we could register.
     *
     * @param expectedX,expectedY pass Integer.MIN_VALUE to derive the position instead
     */
    static boolean syncGeometryWithoutIme(Object av, int expectedX, int expectedY) {
        try {
            View v = asView(av);
            if (v == null || !v.isAttachedToWindow()) return false;

            int displayId = getVirtualDisplayId(av);
            if (displayId < 0) return false;

            Field fLoc = findField(av.getClass(), "mLocationInWindow");
            if (fLoc == null) return false;
            fLoc.setAccessible(true);
            Object locObj = fLoc.get(av);
            if (!(locObj instanceof int[]) || ((int[]) locObj).length < 2) return false;
            int[] loc = (int[]) locObj;

            int[] now = (expectedX != Integer.MIN_VALUE && expectedY != Integer.MIN_VALUE)
                    ? new int[]{ expectedX, expectedY }
                    : expectedLocationInWindow(v);

            if (now[0] != loc[0] || now[1] != loc[1]) {
                if (!pushDisplayContentLocation(v, now[0], now[1], displayId)) return false;
                // Claim the move as done, so the framework never sees a change and never reports.
                loc[0] = now[0];
                loc[1] = now[1];
            }

            // The tap-exclude region is derived from getWidth()/getHeight(), so it is only
            // meaningful once the view is laid out. Claiming the location above is the part that
            // has to happen early; the region is refreshed again post-layout by the panes
            // (applyPaneGeometry -> refreshTapRegionSafely).
            if (v.isLaidOut() && v.getWidth() > 0 && v.getHeight() > 0) {
                Method tap = findMethod(av.getClass(), "updateTapExcludeRegion", int.class, int.class);
                if (tap == null) return false;
                tap.setAccessible(true);
                tap.invoke(av, now[0], now[1]);
            }
            return true;
        } catch (Throwable t) {
            Log.w(TAG, "syncGeometryWithoutIme failed, falling back", t);
            return false;
        }
    }

    private static int[] expectedLocationInWindow(View v) {
        int[] out = new int[2];
        try {
            boolean laidOut = v.isLaidOut() && v.getWidth() > 0 && v.getHeight() > 0;
            if (laidOut) {
                v.getLocationInWindow(out);
                return out;
            }
            Object parent = v.getParent();
            if (parent instanceof View) {
                ((View) parent).getLocationInWindow(out);
                out[0] += v.getLeft();
                out[1] += v.getTop();
                return out;
            }
            v.getLocationInWindow(out);
        } catch (Throwable ignore) {
            try { v.getLocationInWindow(out); } catch (Throwable ignore2) { }
        }
        return out;
    }

    private static boolean pushDisplayContentLocation(View v, int x, int y, int displayId) {
        try {
            Method getWindow = findMethod(View.class, "getWindow");
            if (getWindow == null) return false;
            getWindow.setAccessible(true);
            Object window = getWindow.invoke(v);
            if (window == null) return false;

            Class<?> wmg = Class.forName("android.view.WindowManagerGlobal");
            Method getSession = wmg.getMethod("getWindowSession");
            Object session = getSession.invoke(null);
            if (session == null) return false;

            for (Method m : session.getClass().getMethods()) {
                if (!"updateDisplayContentLocation".equals(m.getName())) continue;
                Class<?>[] p = m.getParameterTypes();
                if (p.length != 4) continue;
                if (!p[0].isInstance(window)) continue;
                m.setAccessible(true);
                m.invoke(session, window, x, y, displayId);
                return true;
            }
            return false;
        } catch (Throwable t) {
            return false;
        }
    }

    static Method findMethod(Class<?> cls, String name, Class<?>... params) {
        while (cls != null) {
            try { return cls.getDeclaredMethod(name, params); }
            catch (NoSuchMethodException e) { cls = cls.getSuperclass(); }
        }
        return null;
    }

    /** ActivityView.cleanTapExcludeRegion() -- safe, does not touch the IME. */
    static void clearTapRegion(Object av) {
        invokeQuietly(av, "cleanTapExcludeRegion");
    }

    static int getVirtualDisplayId(Object av) {
        try {
            Method m = av.getClass().getMethod("getVirtualDisplayId");
            Object r = m.invoke(av);
            if (r instanceof Integer) return (Integer) r;
        } catch (Throwable ignore) { }
        return -1;
    }

    /** The ActivityView's VirtualDisplay, or null. */
    static Object getVirtualDisplay(Object av) {
        try {
            View v = asView(av);
            if (v == null) return null;
            Field f = findField(v.getClass(), "mVirtualDisplay");
            if (f == null) return null;
            f.setAccessible(true);
            return f.get(v);
        } catch (Throwable ignore) {
            return null;
        }
    }

    private static void invokeQuietly(Object target, String method) {
        if (target == null) return;
        try {
            Method m;
            try { m = target.getClass().getMethod(method); }
            catch (NoSuchMethodException e) { m = target.getClass().getDeclaredMethod(method); m.setAccessible(true); }
            m.invoke(target);
        } catch (Throwable ignore) { }
    }

    static Field findField(Class<?> cls, String name) {
        while (cls != null) {
            try { return cls.getDeclaredField(name); }
            catch (NoSuchFieldException e) { cls = cls.getSuperclass(); }
        }
        return null;
    }

    // =====================================================================================
    // 3. State callback
    // =====================================================================================

    interface Callback {
        default void onReady() {}
        default void onDestroyed() {}
        default void onTaskCreated(int taskId) {}
    }

    static void trySetCallback(Object av, Callback cb) {
        if (sStateCb == null) {
            // No StateCallback class at all -> polling is the only option.
            startReadinessPolling(av, cb);
            return;
        }

        try {
            Method setCb = sActivityView.getMethod("setCallback", sStateCb);
            Object impl = null;

            if (sStateCb.isInterface()) {
                impl = Proxy.newProxyInstance(sStateCb.getClassLoader(), new Class<?>[]{ sStateCb }, (p, m, a) -> {
                    String n = m.getName();
                    try {
                        if ("onActivityViewReady".equals(n)) cb.onReady();
                        else if ("onActivityViewDestroyed".equals(n)) cb.onDestroyed();
                        else if ("onTaskCreated".equals(n) || "onTaskMovedToFront".equals(n)) {
                            if (a != null && a.length > 0 && a[0] instanceof Integer) cb.onTaskCreated((Integer) a[0]);
                            else cb.onTaskCreated(0);
                        }
                    } catch (Throwable ignore) {}
                    return null;
                });
            } else if (!Modifier.isAbstract(sStateCb.getModifiers())) {
                impl = sStateCb.getDeclaredConstructor().newInstance();
            }

            if (impl == null) {
                startReadinessPolling(av, cb);
                return;
            }

            setCb.invoke(av, impl);
        } catch (Throwable t) {
            Log.i(TAG, "ActivityView.setCallback failed/absent, using polling fallback", t);
            startReadinessPolling(av, cb);
        }
    }

    /** Surface-valid + VirtualDisplay-present polling, used when setCallback() cannot be wired. */
    private static void startReadinessPolling(Object av, Callback cb) {
        {
            final int MAX_MS = 800;       // total max wait
            final int POLL_MS = 25;       // poll step
            final int STABLE_MS = 160;    // require continuous stable window
            final Handler h = new Handler(Looper.getMainLooper());
            final long start = SystemClock.uptimeMillis();
            final View avView = asView(av);

            final SurfaceView sv = findSurfaceView(avView);
            final SurfaceHolder.Callback2 holderCb = new SurfaceHolder.Callback2() {
                @Override public void surfaceCreated(SurfaceHolder holder) { }
                @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }
                @Override public void surfaceDestroyed(SurfaceHolder holder) {
                    try { cb.onDestroyed(); } catch (Throwable ignore) {}
                }
                @Override public void surfaceRedrawNeeded(SurfaceHolder holder) { }
            };
            if (sv != null) {
                try { sv.getHolder().addCallback(holderCb); } catch (Throwable ignore) {}
            }

            final long[] lastGoodStart = new long[]{ -1L };

            final Runnable poll = new Runnable() {
                @Override public void run() {
                    long now = SystemClock.uptimeMillis();
                    long elapsed = now - start;
                    boolean ok = false;
                    SurfaceView s = null;
                    try {
                        s = findSurfaceView(avView);
                        if (s != null) {
                            try {
                                SurfaceHolder holder = s.getHolder();
                                if (holder != null) {
                                    android.view.Surface surface = holder.getSurface();
                                    if (surface != null && surface.isValid()) ok = true;
                                }
                            } catch (Throwable ignore) { ok = false; }
                        }
                        if (ok && getVirtualDisplayId(av) < 0) ok = false;
                    } catch (Throwable ignore) { ok = false; }

                    if (ok) {
                        if (lastGoodStart[0] < 0) lastGoodStart[0] = now;
                        if (now - lastGoodStart[0] >= STABLE_MS) {
                            try { if (s != null) s.getHolder().removeCallback(holderCb); } catch (Throwable ignore) {}
                            try { cb.onReady(); } catch (Throwable ignore) {}
                            return;
                        }
                    } else {
                        lastGoodStart[0] = -1L;
                    }

                    if (elapsed < MAX_MS) {
                        h.postDelayed(this, POLL_MS);
                    } else {
                        try {
                            SurfaceView s2 = findSurfaceView(avView);
                            if (s2 != null) s2.getHolder().removeCallback(holderCb);
                        } catch (Throwable ignore) {}
                    }
                }
            };
            h.post(poll);
        }
    }

    public static SurfaceView findSurfaceView(View v) {
        if (v == null) return null;
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup) {
            ViewGroup g = (ViewGroup) v;
            for (int i = 0; i < g.getChildCount(); i++) {
                SurfaceView res = findSurfaceView(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }

    // =====================================================================================
    // 4. Launch bounds / options
    // =====================================================================================

    /**
     * Real, usable launch bounds. Applies to every package: an embedded app started without
     * meaningful bounds gets a degenerate configuration and falls back to the stripped-down
     * "classic PiP" UI, which is exactly what we never want in a window host.
     */
    static boolean hasRealLaunchBounds(Rect bounds) {
        return bounds != null
                && bounds.width() > 1
                && bounds.height() > 1
                && bounds.right > 0
                && bounds.bottom > 0
                && bounds.left > -1000
                && bounds.top > -1000;
    }

    static boolean shouldWaitForRealBounds(Rect bounds) {
        return !hasRealLaunchBounds(bounds);
    }

    static Object makeOptionsWithBounds(Rect b) {
        return createCompatibleOptions(b);
    }

    /**
     * Kept for source compatibility with WindowUtil. The package argument is ignored -- the
     * launch options are identical for every app now.
     */
    static Object makeOptionsWithBounds(String packageName, Rect b) {
        return createCompatibleOptions(b);
    }

    /**
     * Launch bounds + FREEFORM windowing mode for every app. This is what makes the system
     * associate the task size with the VirtualDisplay container instead of treating the
     * embedded activity as a picture-in-picture task.
     */
    static Object createCompatibleOptions(Rect bounds) {
        try {
            ActivityOptions options = ActivityOptions.makeBasic();

            if (bounds != null) {
                options.setLaunchBounds(bounds);
            }

            try {
                options.getClass()
                        .getMethod("setLaunchWindowingMode", int.class)
                        .invoke(options, 5 /* WINDOWING_MODE_FREEFORM */);
            } catch (Exception ignore) {}

            try {
                options.getClass()
                        .getMethod("setTaskAlwaysOnTop", boolean.class)
                        .invoke(options, false);
            } catch (Exception ignore) {}

            try {
                options.getClass()
                        .getMethod("setLaunchActivityType", int.class)
                        .invoke(options, 0 /* ACTIVITY_TYPE_UNDEFINED */);
            } catch (Exception ignore) {}

            return options;
        } catch (Exception e) {
            Log.e(TAG, "Failed to create compatible options", e);
            return null;
        }
    }

    // =====================================================================================
    // 5. Activity launching
    // =====================================================================================

    static Intent getLaunchIntentForPackage(Context ctx, String pkg) {
        try {
            PackageManager pm = ctx.getPackageManager();
            Intent i = pm.getLaunchIntentForPackage(pkg);
            if (i == null) return null;
            applyStatePreservingFlags(i);
            i.addFlags(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
            return i;
        } catch (Throwable t) {
            Log.w(TAG, "getLaunchIntentForPackage failed for " + pkg, t);
            return null;
        }
    }

    private static void applyStatePreservingFlags(Intent i) {
        i.setFlags(0);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);              // required for ActivityView
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);            // don't recreate if already top
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);             // reuse the existing instance
        i.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        i.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        i.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
    }

    private static Intent createCompatibleIntent(Context ctx, Intent original) {
        Intent intent;
        if (original.getComponent() != null) {
            String pkg = original.getComponent().getPackageName();
            intent = ctx.getPackageManager().getLaunchIntentForPackage(pkg);
            if (intent == null) {
                intent = new Intent(original);
            } else if (original.getExtras() != null) {
                intent.putExtras(original.getExtras());
            }
        } else {
            intent = new Intent(original);
        }
        applyStatePreservingFlags(intent);
        return intent;
    }

    static boolean startActivitySmart(Object av, Context ctx, Intent intent, Object opts) {
        Intent compatIntent = createCompatibleIntent(ctx, intent);

        PendingIntent pi = null;
        try { pi = buildPendingIntent(ctx, compatIntent); } catch (Throwable ignore) {}

        Object bundle = null;
        if (opts instanceof ActivityOptions) {
            try { bundle = ((ActivityOptions) opts).toBundle(); } catch (Throwable ignore) {}
        }

        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class}, new Object[]{pi})) return true;
        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class}, new Object[]{pi, compatIntent})) return true;
        if (pi != null && opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, ActivityOptions.class}, new Object[]{pi, compatIntent, opts})) return true;
        if (pi != null && bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, android.os.Bundle.class}, new Object[]{pi, compatIntent, bundle})) return true;

        if (tryInvokeWithError(av, "startActivity", new Class[]{Intent.class}, new Object[]{compatIntent})) return true;
        if (opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, ActivityOptions.class}, new Object[]{compatIntent, opts})) return true;
        if (bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, android.os.Bundle.class}, new Object[]{compatIntent, bundle})) return true;

        Exception lastException = null;
        for (Method m : sActivityView.getMethods()) {
            if (!"startActivity".equals(m.getName())) continue;
            Class<?>[] p = m.getParameterTypes();
            Object[] args = new Object[p.length];
            boolean ok = true;
            for (int i = 0; i < p.length; i++) {
                Class<?> t = p[i];
                if (t == Intent.class) args[i] = compatIntent;
                else if (t == PendingIntent.class) args[i] = pi;
                else if (t == ActivityOptions.class && opts instanceof ActivityOptions) args[i] = opts;
                else if (t == android.os.Bundle.class && bundle != null) args[i] = bundle;
                else { ok = false; break; }
            }
            if (!ok) continue;
            try {
                m.invoke(av, args);
                Log.i(TAG, "startActivity via sweep: " + sig(m));
                return true;
            } catch (InvocationTargetException ite) {
                Throwable cause = ite.getCause();
                Log.w(TAG, "startActivity sweep ITE: " + sig(m) + " cause=" + (cause != null ? cause.getMessage() : "null"));
                lastException = ite;
            } catch (Throwable ex) {
                Log.w(TAG, "startActivity sweep failed: " + sig(m) + " ex=" + ex);
            }
        }
        Log.e(TAG, "startActivity failed for intent=" + compatIntent + " opts=" + (opts != null)
                + (lastException != null ? " lastError=" + lastException.getMessage() : ""));
        return false;
    }

    /**
     * State-preserving launch.
     */
    static boolean startActivitySmartWithProcessCheck(Object av, Context ctx, String packageName, Rect bounds) {
        Intent intent = getLaunchIntentForPackage(ctx, packageName);
        if (intent == null) {
            Log.e(TAG, "No launch intent for " + packageName);
            return false;
        }
        return startActivitySmart(av, ctx, intent, createCompatibleOptions(bounds));
    }

    private static boolean tryInvokeWithError(Object av, String name, Class<?>[] sig, Object[] args) {
        try {
            Method m = sActivityView.getMethod(name, sig);
            m.invoke(av, args);
            Log.i(TAG, "startActivity using " + name + Arrays.toString(sig));
            return true;
        } catch (InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            Log.w(TAG, "ITE in " + name + Arrays.toString(sig) + ": " + (cause != null ? cause.getMessage() : "null"));
            return false;
        } catch (Throwable t) {
            return false;
        }
    }

    private static String sig(Method m) {
        StringBuilder sb = new StringBuilder(m.getName()).append('(');
        Class<?>[] p = m.getParameterTypes();
        for (int i = 0; i < p.length; i++) { if (i > 0) sb.append(','); sb.append(p[i].getSimpleName()); }
        return sb.append(')').toString();
    }

    private static PendingIntent buildPendingIntent(Context ctx, Intent intent) {
        int flags = 0;
        if (Build.VERSION.SDK_INT >= 23) flags |= PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= 31) flags |= PendingIntent.FLAG_IMMUTABLE;
        try {
            return PendingIntent.getActivity(ctx, 0, intent, flags);
        } catch (Throwable t) {
            int f = flags & ~PendingIntent.FLAG_IMMUTABLE;
            if (Build.VERSION.SDK_INT >= 31) f |= PendingIntent.FLAG_MUTABLE;
            return PendingIntent.getActivity(ctx, 0, intent, f);
        }
    }

    // =====================================================================================
    // 6. Process / task inspection
    // =====================================================================================

    static boolean isProcessAlive(Context ctx, String packageName) {
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            java.util.List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
            if (processes != null) {
                for (ActivityManager.RunningAppProcessInfo process : processes) {
                    if (process.processName.equals(packageName)) return true;
                }
            }
            return false;
        } catch (Throwable t) {
            Log.w(TAG, "Failed to check process state for " + packageName, t);
            return false;
        }
    }

    static int getTaskIdForPackage(Context ctx, String packageName) {
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method getRecentTasks = am.getClass().getMethod("getRecentTasks", int.class, int.class);
                @SuppressWarnings("unchecked")
                java.util.List<ActivityManager.RecentTaskInfo> tasks =
                        (java.util.List<ActivityManager.RecentTaskInfo>) getRecentTasks.invoke(am, 20, 0);
                if (tasks != null) {
                    for (ActivityManager.RecentTaskInfo task : tasks) {
                        if (task.baseIntent != null
                                && task.baseIntent.getComponent() != null
                                && task.baseIntent.getComponent().getPackageName().equals(packageName)) {
                            try {
                                Field idField = task.getClass().getField("id");
                                return idField.getInt(task);
                            } catch (Exception ignore) {}
                        }
                    }
                }
            } catch (Exception ignore) {}
            return -1;
        } catch (Throwable t) {
            Log.w(TAG, "Failed to get task ID for " + packageName, t);
            return -1;
        }
    }
}
