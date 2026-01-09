package com.syu.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class WindowHostReparenter {
    private static final String TAG = "WindowHostReparenter";

    // Cooldown per AV instance (ms)
    private static final long SWAP_COOLDOWN_MS = 1000L; // 1 second cooldown
    private static final long SURFACE_STABLE_WINDOW_MS = 160L; // require surface valid for this window
    private static final WeakHashMap<Object, Long> lastSwapTimestamps = new WeakHashMap<>();

    public static boolean swapActivityViewSurfaces(View avA, View avB, int timeoutMs) {
        if (avA == null || avB == null) {
            Log.w(TAG, "swapActivityViewSurfaces: null arg");
            return false;
        }

        // Cooldown: avoid rapid repeated swaps on same AV
        long now = System.currentTimeMillis();
        synchronized (lastSwapTimestamps) {
            Long la = lastSwapTimestamps.get(avA);
            Long lb = lastSwapTimestamps.get(avB);
            if ((la != null && now - la < SWAP_COOLDOWN_MS) ||
                (lb != null && now - lb < SWAP_COOLDOWN_MS)) {
                Log.w(TAG, "swapActivityViewSurfaces: cooldown prevents swap");
                return false;
            }
        }

        try {
            // 1) Read root SurfaceControls
            Object rootA = getFieldObject(avA, "mRootSurfaceControl");
            Object rootB = getFieldObject(avB, "mRootSurfaceControl");
            if (rootA == null || rootB == null) {
                Log.w(TAG, "swap: missing rootSC (rootA=" + (rootA!=null) + " rootB=" + (rootB!=null) + ")");
                return false;
            }

            // 2) Wait for inner target SurfaceControls to appear AND be stable
            final int halfTimeout = Math.max(50, timeoutMs / 2);
            long startWait = System.currentTimeMillis();
            Object targetA = waitForInnerSurfaceControlStable(avA, halfTimeout);
            Object targetB = waitForInnerSurfaceControlStable(avB, halfTimeout);
            long waited = System.currentTimeMillis() - startWait;

            if (targetA == null || targetB == null) {
                Log.w(TAG, "swap: targets not ready (tA=" + (targetA != null) + " tB=" + (targetB != null)
                        + "), waited=" + waited + "ms");
                return false;
            }

            // 3) Atomic transaction: reparent rootA->targetB and rootB->targetA
            boolean txOk = performAtomicSwapTransaction(rootA, rootB, targetA, targetB);
            if (!txOk) {
                Log.w(TAG, "swap: transaction failure");
                return false;
            }

            // 4) Inform WindowSession about new attachments (best-effort)
            try {
                Class<?> wmGlobalCls = Class.forName("android.view.WindowManagerGlobal");
                Method getWindowSessionM = wmGlobalCls.getMethod("getWindowSession");
                Object windowSession = getWindowSessionM.invoke(null);

                Object windowObjA = tryGetWindowObject(avA);
                int displayIdA = tryGetVirtualDisplayId(avA, -1);
                if (windowSession != null && windowObjA != null && displayIdA >= 0) {
                    invokeReparentDisplayContent(windowSession, windowObjA, rootA, displayIdA);
                } else {
                    Log.d(TAG, "swap: skipping reparentDisplayContent for avA; window/display missing");
                }

                Object windowObjB = tryGetWindowObject(avB);
                int displayIdB = tryGetVirtualDisplayId(avB, -1);
                if (windowSession != null && windowObjB != null && displayIdB >= 0) {
                    invokeReparentDisplayContent(windowSession, windowObjB, rootB, displayIdB);
                } else {
                    Log.d(TAG, "swap: skipping reparentDisplayContent for avB; window/display missing");
                }

            } catch (Throwable t) {
                Log.w(TAG, "swap: WindowSession reparent step failed", t);
            }

            // 5) Geometry / IME updates
            invokeIfExists(avA, "clearActivityViewGeometryForIme");
            invokeIfExists(avB, "clearActivityViewGeometryForIme");
            invokeIfExists(avA, "updateLocationAndTapExcludeRegion");
            invokeIfExists(avB, "updateLocationAndTapExcludeRegion");

            // 6) record swap time for cooldown
            synchronized (lastSwapTimestamps) {
                lastSwapTimestamps.put(avA, System.currentTimeMillis());
                lastSwapTimestamps.put(avB, System.currentTimeMillis());
            }

            Log.i(TAG, "swapActivityViewSurfaces: success (waited " + waited + "ms)");
            return true;

        } catch (Throwable t) {
            Log.w(TAG, "swapActivityViewSurfaces: unexpected error", t);
            return false;
        }
    }

    // Wait for an inner surface control to be available AND stable for SURFACE_STABLE_WINDOW_MS
    private static Object waitForInnerSurfaceControlStable(View avView, int timeoutMs) {
        long deadline = System.currentTimeMillis() + timeoutMs;
        long stableSince = -1;
        Object lastFound = null;

        while (System.currentTimeMillis() < deadline) {
            Object sc = tryGetInnerSurfaceControl(avView);
            // verify holder.surface.isValid when possible
            boolean valid = false;
            try {
                SurfaceView sv = findSurfaceView(avView);
                if (sv != null) {
                    SurfaceHolder holder = sv.getHolder();
                    if (holder != null) {
                        android.view.Surface s = holder.getSurface();
                        valid = (s != null && s.isValid());
                    }
                }
            } catch (Throwable ignore) { }

            if (sc != null && valid) {
                if (stableSince < 0) stableSince = System.currentTimeMillis();
                long stableFor = System.currentTimeMillis() - stableSince;
                lastFound = sc;
                if (stableFor >= SURFACE_STABLE_WINDOW_MS) {
                    // good: object available and surface stable for required window
                    return sc;
                }
            } else {
                stableSince = -1;
                lastFound = sc;
            }
            // short backoff
            try { Thread.sleep(25); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); break; }
        }
        // timed out: return what we found last (if any) only if it seems valid; otherwise null
        return lastFound;
    }

    // Try to return an object appropriate for WindowSession.reparentDisplayContent:
    // prefer a public IBinder token (avView.getWindowToken()), otherwise try getWindow()/mWindow
    // but guard against reflection failures (API 36+ will block some reflective access).
    private static Object tryGetWindowObject(View avView) {
        if (avView == null) return null;

        // 1) Public API: window token (IBinder) — safe on all API levels.
        try {
            IBinder token = avView.getWindowToken();
            if (token != null) return token;
        } catch (Throwable ignore) {
            // Very unlikely; continue to optional reflection if allowed.
        }

        // 2) Reflection fallback only on SDK < 36. On API 36+ reflective access is blocked / will throw.
        if (Build.VERSION.SDK_INT >= 36) {
            Log.d(TAG, "tryGetWindowObject: skipping reflection on API >= 36; using window token only");
            return null;
        }

        try {
            // reflectively try getWindow()
            try {
                @SuppressLint("SoonBlockedPrivateApi") Method getWindowM = avView.getClass().getDeclaredMethod("getWindow");
                getWindowM.setAccessible(true);
                Object w = getWindowM.invoke(avView);
                if (w != null) return w;
            } catch (NoSuchMethodException ns) {
                // ignore - try field fallback
            } catch (Exception e) {
                Log.w(TAG, "tryGetWindowObject: unable to invoke getWindow() reflectively", e);
                return null;
            }

            // reflectively try mWindow field
            try {
                java.lang.reflect.Field wf = findFieldRecursively(avView.getClass(), "mWindow");
                if (wf != null) {
                    wf.setAccessible(true);
                    Object w = wf.get(avView);
                    if (w != null) return w;
                }
            } catch (Exception e) {
                Log.w(TAG, "tryGetWindowObject: unable to access mWindow reflectively", e);
                return null;
            }
        } catch (Throwable t) {
            Log.w(TAG, "tryGetWindowObject: unexpected failure", t);
            return null;
        }
        return null;
    }

    /**
     * Invoke WindowSession.reparentDisplayContent with the right parameter shape.
     * Tries to detect the method signature and pass either an IBinder token or window object.
     * Returns true if invocation succeeded.
     */
    private static boolean invokeReparentDisplayContent(Object windowSession, Object windowObjOrToken, Object rootSurfaceControl, int displayId) {
        if (windowSession == null || rootSurfaceControl == null) return false;
        try {
            Method target = null;
            for (Method m : windowSession.getClass().getMethods()) {
                if (!m.getName().equals("reparentDisplayContent")) continue;
                Class<?>[] pt = m.getParameterTypes();
                if (pt.length == 3) {
                    target = m;
                    break;
                }
            }
            if (target == null) {
                Log.w(TAG, "invokeReparentDisplayContent: method not found on windowSession");
                return false;
            }
            target.setAccessible(true);

            Class<?> p0 = target.getParameterTypes()[0];

            // If first parameter expects IBinder (or is assignable), try to pass IBinder
            if (IBinder.class.isAssignableFrom(p0)) {
                IBinder token = null;
                if (windowObjOrToken instanceof IBinder) {
                    token = (IBinder) windowObjOrToken;
                } else {
                    // try to extract token from provided object
                    try {
                        Method getToken = windowObjOrToken.getClass().getMethod("getWindowToken");
                        Object tok = getToken.invoke(windowObjOrToken);
                        if (tok instanceof IBinder) token = (IBinder) tok;
                    } catch (Exception ignore) {}
                }
                if (token == null) {
                    Log.w(TAG, "invokeReparentDisplayContent: no IBinder token available to pass");
                    return false;
                }
                try {
                    target.invoke(windowSession, token, rootSurfaceControl, displayId);
                    return true;
                } catch (IllegalArgumentException iae) {
                    try { target.invoke(windowSession, token, rootSurfaceControl, displayId); return true; } catch (Throwable t) { Log.w(TAG, "invokeReparentDisplayContent invocation failed", t); return false; }
                } catch (Throwable t) {
                    Log.w(TAG, "invokeReparentDisplayContent invocation failed", t);
                    return false;
                }
            }

            // If the method expects the concrete window object type and we have an instance, pass it
            if (windowObjOrToken != null && p0.isInstance(windowObjOrToken)) {
                try {
                    target.invoke(windowSession, windowObjOrToken, rootSurfaceControl, displayId);
                    return true;
                } catch (IllegalArgumentException iae) {
                    try { target.invoke(windowSession, windowObjOrToken, rootSurfaceControl, displayId); return true; } catch (Throwable t) { Log.w(TAG, "invokeReparentDisplayContent invocation failed", t); return false; }
                } catch (Throwable t) {
                    Log.w(TAG, "invokeReparentDisplayContent invocation failed", t);
                    return false;
                }
            }

            // As a last resort, if we only have an IBinder token and the method might accept it, try that
            if (windowObjOrToken instanceof IBinder) {
                try {
                    target.invoke(windowSession, windowObjOrToken, rootSurfaceControl, displayId);
                    return true;
                } catch (Throwable t) {
                    Log.w(TAG, "invokeReparentDisplayContent: invocation with IBinder failed", t);
                    return false;
                }
            }

            Log.w(TAG, "invokeReparentDisplayContent: no compatible parameter types found to invoke method");
            return false;

        } catch (Exception e) {
            Log.w(TAG, "invokeReparentDisplayContent unexpected failure", e);
            return false;
        } catch (Throwable t) {
            // catch Throwable just in case of unusual runtime errors
            Log.w(TAG, "invokeReparentDisplayContent unexpected throwable", t);
            return false;
        }
    }

    // Get display id from avView.mVirtualDisplay.getDisplay().getDisplayId(), return defaultIfMissing on failure
    private static int tryGetVirtualDisplayId(View avView, int defaultIfMissing) {
        try {
            Object vdisp = getFieldObject(avView, "mVirtualDisplay");
            if (vdisp == null) return defaultIfMissing;
            Method getDisplay = vdisp.getClass().getMethod("getDisplay");
            Object display = getDisplay.invoke(vdisp);
            if (display == null) return defaultIfMissing;
            Method getId = display.getClass().getMethod("getDisplayId");
            Object idObj = getId.invoke(display);
            if (idObj instanceof Integer) return (Integer) idObj;
            if (idObj instanceof Number) return ((Number) idObj).intValue();
        } catch (Throwable t) {
            Log.w(TAG, "tryGetVirtualDisplayId failed", t);
        }
        return defaultIfMissing;
    }

    private static Object getFieldObject(Object obj, String fieldName) {
        if (obj == null) return null;
        try {
            Field f = findFieldRecursively(obj.getClass(), fieldName);
            if (f == null) return null;
            f.setAccessible(true);
            return f.get(obj);
        } catch (Throwable t) {
            Log.w(TAG, "getFieldObject failed for " + fieldName, t);
            return null;
        }
    }

    /**
     * Try multiple strategies to obtain the inner SurfaceControl object backing
     * a SurfaceView contained inside 'avView'.
     * This is a non-blocking attempt; for waiting behavior call waitForInnerSurfaceControl().
     */
    private static Object tryGetInnerSurfaceControl(View avView) {
        try {
            SurfaceView sv = findSurfaceView(avView);
            if (sv == null) return null;

            // 1) try hidden method getSurfaceControl()
            try {
                Method getSC = sv.getClass().getDeclaredMethod("getSurfaceControl");
                getSC.setAccessible(true);
                Object sc = getSC.invoke(sv);
                if (sc != null) return sc;
            } catch (NoSuchMethodException ignored) {
                // method not available on this platform class
            } catch (Throwable t) {
                Log.d(TAG, "tryGetInnerSurfaceControl: getSurfaceControl invocation failed", t);
            }

            // 2) try common field names that may hold a SurfaceControl
            String[] candidates = new String[] {
                    "mSurfaceControl", "mSurfaceControlNative", "mSurfaceControlHandle", "mNativeSurfaceControl"
            };
            for (String name : candidates) {
                Field ff = findFieldRecursively(sv.getClass(), name);
                if (ff != null) {
                    try {
                        ff.setAccessible(true);
                        Object v = ff.get(sv);
                        if (v != null) return v;
                    } catch (Throwable ignore) {}
                }
            }

            // 3) IMPORTANT: do NOT return holder.getSurface() (android.view.Surface).
            // Returning a Surface would later cause Transaction.reparent to be invoked
            // with the wrong type. Treat "only Surface available" as not-ready.
            //
            // We still keep the detection here for logging/diagnostics but do not return it.
            try {
                SurfaceHolder holder = sv.getHolder();
                if (holder != null) {
                    Object surface = holder.getSurface();
                    if (surface != null) {
                        // We found a Surface but NOT a SurfaceControl; log and treat as not-ready.
                        Log.d(TAG, "tryGetInnerSurfaceControl: found android.view.Surface (not SurfaceControl) — surface not suitable for reparent; will wait");
                    }
                }
            } catch (Throwable ignore) {}

        } catch (Throwable t) {
            Log.w(TAG, "tryGetInnerSurfaceControl error", t);
        }
        return null;
    }

    /**
     * Perform the atomic transaction that reparents rootA->targetB and rootB->targetA.
     * This method now early-exits and returns false if the runtime objects are not
     * SurfaceControl instances (we cannot reparent to an android.view.Surface).
     */
    private static boolean performAtomicSwapTransaction(Object rootA, Object rootB, Object targetA, Object targetB) {
        try {
            // Load the SurfaceControl class reflectively
            Class<?> scClass = Class.forName("android.view.SurfaceControl");
            Class<?> txClass = Class.forName("android.view.SurfaceControl$Transaction");

            // Validate parameter types: rootA/rootB/targetA/targetB must be instances of SurfaceControl (or compatible)
            if (!scClass.isInstance(rootA) || !scClass.isInstance(rootB) ||
                !scClass.isInstance(targetA) || !scClass.isInstance(targetB)) {
                // One of the parameters is not a SurfaceControl (likely an android.view.Surface). Bail out.
                Log.w(TAG, "performAtomicSwapTransaction: one or more parameters are not SurfaceControl instances — aborting transaction");
                return false;
            }

            // instantiate new Transaction()
            Constructor<?> ctor = txClass.getDeclaredConstructor();
            ctor.setAccessible(true);
            Object tx = ctor.newInstance();

            // find reparent(SurfaceControl, SurfaceControl)
            Method reparent = null;
            try {
                reparent = txClass.getMethod("reparent", scClass, scClass);
            } catch (NoSuchMethodException ns) {
                // fallback: find any two-arg method named reparent
                for (Method m : txClass.getMethods()) {
                    if (m.getName().equals("reparent") && m.getParameterTypes().length == 2) {
                        reparent = m;
                        break;
                    }
                }
            }
            if (reparent == null) {
                Log.w(TAG, "performAtomicSwapTransaction: reparent method not found on Transaction");
                return false;
            }

            // invoke reparent(rootA, targetB) and reparent(rootB, targetA)
            try {
                reparent.invoke(tx, rootA, targetB);
            } catch (Throwable t) {
                Log.w(TAG, "performAtomicSwapTransaction: reparent invoke failed for rootA->targetB", t);
                return false;
            }
            try {
                reparent.invoke(tx, rootB, targetA);
            } catch (Throwable t) {
                Log.w(TAG, "performAtomicSwapTransaction: reparent invoke failed for rootB->targetA", t);
                return false;
            }

            // optionally call show(root) if available
            try {
                Method show = txClass.getMethod("show", scClass);
                try { show.invoke(tx, rootA); } catch (Throwable ignore) {}
                try { show.invoke(tx, rootB); } catch (Throwable ignore) {}
            } catch (NoSuchMethodException ignored) {}

            // apply()
            try {
                Method apply = txClass.getMethod("apply");
                apply.invoke(tx);
            } catch (Throwable t) {
                Log.w(TAG, "performAtomicSwapTransaction: apply invoke failed", t);
                return false;
            }

            return true;
        } catch (ClassNotFoundException cnf) {
            Log.w(TAG, "performAtomicSwapTransaction: SurfaceControl classes not found", cnf);
            return false;
        } catch (Throwable t) {
            Log.w(TAG, "performAtomicSwapTransaction: unexpected error", t);
            return false;
        }
    }

    /**
     * Reparent an ActivityView's native root to its inner SurfaceView if possible.
     * Best-effort: if we couldn't obtain a SurfaceControl target, do nothing and return false.
     */
    public static void reparentActivityViewSurface(View avView) {
        if (avView == null) return;
        try {
            Object rootSurfaceControl = getFieldObject(avView, "mRootSurfaceControl");
            if (rootSurfaceControl == null) {
                Log.d(TAG, "reparentActivityViewSurface: no mRootSurfaceControl found, skipping");
                return;
            }

            Object targetSurfaceControl = tryGetInnerSurfaceControl(avView);
            if (targetSurfaceControl == null) {
                Log.w(TAG, "reparentActivityViewSurface: Unable to obtain target SurfaceControl for inner SurfaceView — skipping");
                return;
            }

            boolean ok = performAtomicSwapTransaction(rootSurfaceControl, rootSurfaceControl, targetSurfaceControl, targetSurfaceControl);
            if (!ok) {
                Log.w(TAG, "reparentActivityViewSurface: transaction failed or not supported on this platform");
                return;
            }

            // Only attempt to update Location/IME if transaction succeeded.
            try {
                Method clearIme = avView.getClass().getDeclaredMethod("clearActivityViewGeometryForIme");
                clearIme.setAccessible(true);
                clearIme.invoke(avView);
            } catch (NoSuchMethodException ns) {
                // ignore
            } catch (Throwable t) {
                Log.w(TAG, "clearActivityViewGeometryForIme invocation failed (after successful reparent)", t);
            }

            try {
                Method upd = avView.getClass().getDeclaredMethod("updateLocationAndTapExcludeRegion");
                upd.setAccessible(true);
                upd.invoke(avView);
            } catch (NoSuchMethodException ns) {
                // ignore
            } catch (Throwable t) {
                // This can still throw if the window/display mapping is inconsistent.
                Log.w(TAG, "updateLocationAndTapExcludeRegion invocation failed (after successful reparent)", t);
            }

        } catch (Throwable e) {
            Log.w(TAG, "reparentActivityViewSurface failed", e);
        }
    }

    // Helper to find a field recursively (case-sensitive then case-insensitive)
    private static Field findFieldRecursively(Class<?> cls, String name) {
        if (cls == null) return null;
        try {
            return cls.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            for (Field ff : cls.getDeclaredFields()) {
                if (ff.getName().equalsIgnoreCase(name)) return ff;
            }
            return findFieldRecursively(cls.getSuperclass(), name);
        } catch (Throwable t) {
            return null;
        }
    }

    private static SurfaceView findSurfaceView(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup g) {
            for (int i = 0; i < g.getChildCount(); i++) {
                SurfaceView res = findSurfaceView(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }

    private static void invokeIfExists(Object obj, String methodName) {
        if (obj == null) return;
        try {
            Method m = obj.getClass().getDeclaredMethod(methodName);
            m.setAccessible(true);
            m.invoke(obj);
        } catch (NoSuchMethodException ns) {
            // ignore
        } catch (Throwable t) {
            Log.w(TAG, "invokeIfExists failed: " + methodName, t);
        }
    }
}