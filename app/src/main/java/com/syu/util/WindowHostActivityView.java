package com.syu.util;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Reflection facade over the ROM's hidden android.app.ActivityView.
 */
public class WindowHostActivityView {
    private static final String TAG = "WindowHostActivityView";

    private static Class<?> sActivityView, sStateCb;

    /**
     * The content size each ActivityView had in the pane it is leaving, recorded when that pane
     * puts its handoff cover up.
     *
     * A swap moves the view between panes, so the destination pane reads back the size the view
     * came from and can tell how much the embedded app has to re-layout. Weak keys: an entry for a
     * view that is released instead of swapped must not keep it alive.
     */
    private static final Map<String, int[]> sSizeBeforeHandoff = new ConcurrentHashMap<>();

    /**
     * Keyed by PACKAGE, not by ActivityView.
     *
     * swapActivityViewSurfaces() exchanges the inner surfaces while both ActivityView objects stay
     * in their own panes, so a view's own before/after size is always identical and keying on it
     * measured nothing. What actually moves is the app: the pane that now shows package X needs the
     * size of the pane X came from, and that is what the partner pane recorded here.
     */
    static void noteSizeBeforeHandoff(String pkg, int w, int h) {
        if (pkg == null || pkg.isEmpty() || w <= 0 || h <= 0) return;
        sSizeBeforeHandoff.put(pkg, new int[]{ w, h });
    }

    /** @return {w, h} the package occupied before the handoff, or null. Consumed on read. */
    static int[] takeSizeBeforeHandoff(String pkg) {
        if (pkg == null || pkg.isEmpty()) return null;
        return sSizeBeforeHandoff.remove(pkg);
    }

    /**
     * Extra time a handoff cover should stay up, given how much the pane size changed.
     *
     * The cover comes down as soon as OUR reparent is composited, which is roughly a second before
     * the embedded app has finished re-laying out at the new size -- measured at ~2 s of visible
     * stutter after the reveal when a pane went from 663x717 to 1450x997. Scaled by area ratio, so
     * a swap between similarly sized panes pays nothing and only a real resize is covered.
     *
     * @return 0 when the sizes are close, up to maxExtraMs at twice the area or more.
     */
    static long extraSettleForResize(int[] oldSize, int newW, int newH, long maxExtraMs) {
        if (oldSize == null || oldSize.length < 2) return 0L;
        long oldArea = (long) oldSize[0] * oldSize[1];
        long newArea = (long) newW * newH;
        if (oldArea <= 0 || newArea <= 0) return 0L;

        double ratio = (double) Math.max(oldArea, newArea) / (double) Math.min(oldArea, newArea);
        final double IGNORE_BELOW = 1.15;   // same pane in practice
        final double FULL_AT      = 2.00;   // twice the area or more
        if (ratio <= IGNORE_BELOW) return 0L;

        double t = Math.min(1.0, (ratio - IGNORE_BELOW) / (FULL_AT - IGNORE_BELOW));
        return Math.round(t * maxExtraMs);
    }

    /** ActivityViews that already had the IME crash guard installed (see installImeCrashGuard). */
    private static final WeakHashMap<Object, Boolean> sImeGuarded = new WeakHashMap<>();

    // -------------------------------------------------------------------------------------
    // Reflection cache
    //
    // syncGeometryWithoutIme() runs on every layout pass of every pane. Resolving the same
    // members again each time - and pushDisplayContentLocation() calling getMethods(), which
    // allocates the whole method array - is pure main-thread cost during a rebuild.
    // -------------------------------------------------------------------------------------
    private static Constructor<?> sAvConstructor;
    private static Object[] sAvConstructorArgs;
    private static Field sFieldLocationInWindow;
    private static Method sMethodUpdateTapExclude;
    private static Method sMethodGetWindow;
    private static Method sMethodUpdateDisplayContentLocation;
    private static Object sWindowSession;
    private static boolean sSessionLookupFailed;

    /**
     * Launch intents, resolved once per package.
     *
     * getLaunchIntentForPackage() is a PackageManager query, and the launch path used to run it
     * twice per pane: once in startActivitySmartWithProcessCheck() and again inside
     * createCompatibleIntent(). Stored as templates - every caller gets a fresh copy, because
     * applyStatePreservingFlags() mutates the Intent.
     */
    private static final Map<String, Intent> sLaunchIntents = new ConcurrentHashMap<>();
    private static final Set<String> sLaunchIntentMisses =
            Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
    /** PendingIntent per package; the intent we build for a package is always identical. */
    private static final Map<String, PendingIntent> sPendingIntents = new ConcurrentHashMap<>();

    private static final ExecutorService PREWARM_EXEC = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "AvLaunchPrewarm");
        t.setPriority(Thread.MIN_PRIORITY);
        t.setDaemon(true);
        return t;
    });

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

    // identityHashCode gets recycled across GC cycles, which makes cross-cycle log
    // correlation unreliable. A monotonic counter plus a weak map gives stable IDs.
    private static final AtomicInteger sAvSeq = new AtomicInteger();
    private static final Map<Object, Integer> sAvIds =
            Collections.synchronizedMap(new WeakHashMap<>());

    private static int avId(Object av) {
        if (av == null) return -1;
        synchronized (sAvIds) {
            Integer id = sAvIds.get(av);
            if (id == null) {
                id = sAvSeq.incrementAndGet();
                sAvIds.put(av, id);
            }
            return id;
        }
    }

    private static Object newInstanceRaw(Context ctx) {
        try {
            // Resolved once. The sweep below used to run on every pane creation.
            if (sAvConstructor != null) {
                Object[] args = sAvConstructorArgs.clone();
                args[0] = ctx;
                return sAvConstructor.newInstance(args);
            }

            try {
                Constructor<?> c = sActivityView.getDeclaredConstructor(Context.class, boolean.class);
                c.setAccessible(true);
                Object av = c.newInstance(ctx, Boolean.TRUE);
                sAvConstructor = c;
                sAvConstructorArgs = new Object[]{ ctx, Boolean.TRUE };
                return av;
            } catch (Throwable ignore) {}

            for (Constructor<?> c : sActivityView.getDeclaredConstructors()) {
                try {
                    Class<?>[] p = c.getParameterTypes();
                    c.setAccessible(true);
                    Object[] args = null;
                    if (p.length == 1 && p[0] == Context.class) args = new Object[]{ ctx };
                    else if (p.length == 2 && p[0] == Context.class && p[1] == android.util.AttributeSet.class) args = new Object[]{ ctx, null };
                    else if (p.length == 3 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class) args = new Object[]{ ctx, null, 0 };
                    else if (p.length == 4 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class && p[3] == int.class) args = new Object[]{ ctx, null, 0, 0 };
                    if (args == null) continue;
                    Object av = c.newInstance(args);
                    sAvConstructor = c;
                    sAvConstructorArgs = args;
                    return av;
                } catch (Throwable ignore) {}
            }
            throw new IllegalStateException("No compatible ActivityView constructor");
        } catch (Throwable e) {
            throw new RuntimeException("No compatible ActivityView constructor", e);
        }
    }

    static View asView(Object av) { return (View) av; }

    static void release(Object av) {
        if (av == null) return;
        final int id = System.identityHashCode(av);

        boolean ok = false;
        try {
            sActivityView.getMethod("release").invoke(av);
            ok = true;
        } catch (Throwable t) {
            // release() throws IllegalStateException when mVirtualDisplay == null.
            Log.w(TAG, "AV release id=" + id + " threw, falling back to performRelease()", t);
            try {
                Method m = sActivityView.getDeclaredMethod("performRelease");
                m.setAccessible(true);
                m.invoke(av);
                ok = true;
            } catch (Throwable t2) {
                Log.w(TAG, "AV release id=" + id + " fallback failed", t2);
            }
        }
    }

    /** Reads a private ActivityView field without throwing; returns null on any failure. */
    private static Object readFieldQuietly(Object av, String name) {
        try {
            Field f = findField(av.getClass(), name);
            if (f == null) return null;
            f.setAccessible(true);
            return f.get(av);
        } catch (Throwable ignore) {
            return null;
        }
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

            Field fLoc = sFieldLocationInWindow;
            if (fLoc == null) {
                fLoc = findField(av.getClass(), "mLocationInWindow");
                if (fLoc == null) return false;
                fLoc.setAccessible(true);
                sFieldLocationInWindow = fLoc;
            }
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
                Method tap = sMethodUpdateTapExclude;
                if (tap == null) {
                    tap = findMethod(av.getClass(), "updateTapExcludeRegion", int.class, int.class);
                    if (tap == null) return false;
                    tap.setAccessible(true);
                    sMethodUpdateTapExclude = tap;
                }
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

    /**
     * Everything here is resolved once. The previous version ran Class.forName() plus a full
     * getMethods() sweep of the window session on every geometry sync, i.e. several times per
     * pane per layout pass.
     */
    private static boolean pushDisplayContentLocation(View v, int x, int y, int displayId) {
        try {
            if (sSessionLookupFailed) return false;

            Method getWindow = sMethodGetWindow;
            if (getWindow == null) {
                getWindow = findMethod(View.class, "getWindow");
                if (getWindow == null) { sSessionLookupFailed = true; return false; }
                getWindow.setAccessible(true);
                sMethodGetWindow = getWindow;
            }
            Object window = getWindow.invoke(v);
            if (window == null) return false;

            Object session = sWindowSession;
            if (session == null) {
                Class<?> wmg = Class.forName("android.view.WindowManagerGlobal");
                Method getSession = wmg.getMethod("getWindowSession");
                session = getSession.invoke(null);
                if (session == null) return false;
                sWindowSession = session;
            }

            Method push = sMethodUpdateDisplayContentLocation;
            if (push == null) {
                for (Method m : session.getClass().getMethods()) {
                    if (!"updateDisplayContentLocation".equals(m.getName())) continue;
                    Class<?>[] p = m.getParameterTypes();
                    if (p.length != 4) continue;
                    if (!p[0].isInstance(window)) continue;
                    m.setAccessible(true);
                    push = m;
                    break;
                }
                if (push == null) { sSessionLookupFailed = true; return false; }
                sMethodUpdateDisplayContentLocation = push;
            }

            push.invoke(session, window, x, y, displayId);
            return true;
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

    /**
     * The actual size of this ActivityView's VirtualDisplay (not the size that WE
     * most recently pushed to it).
     * A mismatch with the panel size means that the embedded application is rendering
     * at the wrong resolution -- which is exactly the symptom of "cropped / partially black".
     */
    static Point getVirtualDisplaySize(Object av) {
        try {
            Object vd = getVirtualDisplay(av);
            if (vd == null) return null;
            Object display = vd.getClass().getMethod("getDisplay").invoke(vd);
            if (!(display instanceof android.view.Display)) return null;

            Point p = new Point();
            ((android.view.Display) display).getSize(p);
            return (p.x > 0 && p.y > 0) ? p : null;
        } catch (Throwable t) {
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

    /**
     * Wires up readiness reporting for an ActivityView.
     *
     * ActivityView$StateCallback is an abstract CLASS, not an interface, so it cannot be
     * implemented with java.lang.reflect.Proxy and cannot be instantiated either. On this ROM the
     * setCallback() path therefore never worked and every ActivityView silently fell back to
     * polling -- which also means onTaskCreated() never arrived and the taskId stayed at -1.
     * The Proxy branch is kept for ROMs that declare the callback as an interface; everything else
     * uses startReadinessWatch(), which is event-driven rather than timed.
     */
    static void trySetCallback(Object av, Callback cb) {
        if (sStateCb == null) {
            startReadinessWatch(av, cb);
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
                startReadinessWatch(av, cb);
                return;
            }

            setCb.invoke(av, impl);
        } catch (Throwable t) {
            Log.i(TAG, "ActivityView.setCallback failed/absent, using surface watch", t);
            startReadinessWatch(av, cb);
        }
    }

    /**
     * Reports readiness the moment the ActivityView's surface exists and its VirtualDisplay has
     * been created.
     *
     * ActivityView creates the VirtualDisplay synchronously inside its own surfaceCreated(), and
     * this callback is registered after it, so by the time we are called the display is already
     * there -- no stability window is needed. The previous version polled every 25 ms and demanded
     * 160 ms of continuous stability, which added a quarter of a second per pane before the app
     * was even asked to start, and more than that whenever the main thread was busy.
     *
     * The timed loop is kept only as a backstop for the case where the surface already existed
     * before we registered, or a ROM does not deliver surfaceCreated() to late callbacks.
     */
    private static void startReadinessWatch(final Object av, final Callback cb) {
        final int MAX_MS = 5000;
        final int BACKSTOP_POLL_MS = 50;

        final Handler h = new Handler(Looper.getMainLooper());
        final long start = SystemClock.uptimeMillis();
        final View avView = asView(av);
        final AtomicBoolean readyFired = new AtomicBoolean(false);

        final Runnable signalIfReady = new Runnable() {
            @Override public void run() {
                if (readyFired.get()) return;
                if (!isSurfaceBackedAndDisplayed(avView, av)) return;
                if (!readyFired.compareAndSet(false, true)) return;
                try { cb.onReady(); } catch (Throwable ignore) {}
            }
        };

        SurfaceView sv = findSurfaceView(avView);
        if (sv != null) {
            try {
                sv.getHolder().addCallback(new SurfaceHolder.Callback2() {
                    @Override public void surfaceCreated(SurfaceHolder holder) {
                        signalIfReady.run();
                    }
                    @Override public void surfaceChanged(SurfaceHolder holder, int f, int w, int hh) {
                        signalIfReady.run();
                    }
                    @Override public void surfaceDestroyed(SurfaceHolder holder) {
                        readyFired.set(false);
                        try { cb.onDestroyed(); } catch (Throwable ignore) {}
                    }
                    @Override public void surfaceRedrawNeeded(SurfaceHolder holder) { }
                });
            } catch (Throwable ignore) {}
        }

        final Runnable backstop = new Runnable() {
            @Override public void run() {
                if (readyFired.get()) return;
                signalIfReady.run();
                if (readyFired.get()) return;
                if (SystemClock.uptimeMillis() - start < MAX_MS) {
                    h.postDelayed(this, BACKSTOP_POLL_MS);
                } else {
                    Log.w(TAG, "readiness watch timed out (displayId=" + getVirtualDisplayId(av) + ")");
                }
            }
        };
        h.post(backstop);
    }

    private static boolean isSurfaceBackedAndDisplayed(View avView, Object av) {
        try {
            if (getVirtualDisplayId(av) < 0) return false;
            SurfaceView s = findSurfaceView(avView);
            if (s == null) return false;
            SurfaceHolder holder = s.getHolder();
            if (holder == null) return false;
            android.view.Surface surface = holder.getSurface();
            return surface != null && surface.isValid();
        } catch (Throwable ignore) {
            return false;
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

    /**
     * Resolves the launch intents for the given packages off the main thread.
     * Call before the panes are built so the launch path does no PackageManager work at all.
     */
    static void prewarmLaunchIntents(final Context ctx, final Collection<String> packages) {
        if (ctx == null || packages == null || packages.isEmpty()) return;
        final Context app = ctx.getApplicationContext();
        final java.util.ArrayList<String> todo = new java.util.ArrayList<>();
        for (String pkg : packages) {
            if (pkg == null || pkg.isEmpty()) continue;
            if (sLaunchIntents.containsKey(pkg) || sLaunchIntentMisses.contains(pkg)) continue;
            todo.add(pkg);
        }
        if (todo.isEmpty()) return;
        PREWARM_EXEC.execute(() -> {
            for (String pkg : todo) resolveLaunchTemplate(app, pkg);
        });
    }

    /** Cached, unflagged launch intent template for a package. */
    private static Intent resolveLaunchTemplate(Context ctx, String pkg) {
        if (pkg == null || pkg.isEmpty()) return null;
        Intent cached = sLaunchIntents.get(pkg);
        if (cached != null) return cached;
        if (sLaunchIntentMisses.contains(pkg)) return null;
        try {
            PackageManager pm = ctx.getPackageManager();
            Intent i = pm.getLaunchIntentForPackage(pkg);
            if (i == null) { sLaunchIntentMisses.add(pkg); return null; }
            sLaunchIntents.put(pkg, i);
            return i;
        } catch (Throwable t) {
            Log.w(TAG, "getLaunchIntentForPackage failed for " + pkg, t);
            sLaunchIntentMisses.add(pkg);
            return null;
        }
    }

    /** Drops every cached launch artefact for a package (update / uninstall / start failure). */
    static void invalidateLaunchCache(String pkg) {
        if (pkg == null) return;
        sLaunchIntents.remove(pkg);
        sLaunchIntentMisses.remove(pkg);
        sPendingIntents.remove(pkg);
    }

    static Intent getLaunchIntentForPackage(Context ctx, String pkg) {
        Intent template = resolveLaunchTemplate(ctx, pkg);
        if (template == null) return null;
        Intent i = new Intent(template);
        applyStatePreservingFlags(i);
        i.addFlags(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
        return i;
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

    /**
     * The template lookup is cached, so this no longer repeats the PackageManager query that
     * startActivitySmartWithProcessCheck() has already made for the same package.
     */
    private static Intent createCompatibleIntent(Context ctx, Intent original) {
        Intent intent = null;
        if (original.getComponent() != null) {
            Intent template = resolveLaunchTemplate(ctx, original.getComponent().getPackageName());
            if (template != null) {
                intent = new Intent(template);
                if (original.getExtras() != null) intent.putExtras(original.getExtras());
            }
        }
        if (intent == null) intent = new Intent(original);
        applyStatePreservingFlags(intent);
        return intent;
    }

    static boolean startActivitySmart(Object av, Context ctx, Intent intent, Object opts) {
        Intent compatIntent = createCompatibleIntent(ctx, intent);
        final String targetPkg = compatIntent.getComponent() != null
                ? compatIntent.getComponent().getPackageName()
                : compatIntent.getPackage();

        PendingIntent pi = null;
        try { pi = obtainPendingIntent(ctx, targetPkg, compatIntent); } catch (Throwable ignore) {}

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
        // A stale template or a cancelled PendingIntent would fail every attempt above; drop both
        // so the retry path resolves them again.
        invalidateLaunchCache(targetPkg);
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

    /**
     * PendingIntent.getActivity() is a binder call to ActivityManager, and the intent we build for
     * a given package is byte-for-byte the same on every launch, so it is resolved once.
     */
    private static PendingIntent obtainPendingIntent(Context ctx, String pkg, Intent intent) {
        if (pkg == null || pkg.isEmpty()) return buildPendingIntent(ctx, intent);
        PendingIntent cached = sPendingIntents.get(pkg);
        if (cached != null) return cached;
        PendingIntent pi = buildPendingIntent(ctx, intent);
        if (pi != null) sPendingIntents.put(pkg, pi);
        return pi;
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
