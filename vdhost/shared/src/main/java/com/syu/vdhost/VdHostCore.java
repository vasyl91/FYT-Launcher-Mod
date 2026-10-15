package com.syu.vdhost;

import android.app.ActivityOptions;
import android.content.AttributionSource;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.Surface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * What the host actually does. Runs in one of three places:
 *  - inside the launcher when the launcher is android.uid.system;
 *  - in the Magisk daemon (uid 1000, Context = the system context, package "android");
 *  - in a Shizuku UserService (uid 2000, package "com.android.shell").
 *
 * Every display remembers the uid that created it; only that uid may touch it.
 */
public final class VdHostCore {
    private static final String TAG = "FytVdHost";

    /** WindowManager.DISPLAY_IME_POLICY_FALLBACK_DISPLAY: the IME shows on the main screen. */
    private static final int IME_POLICY_FALLBACK_DISPLAY = 1;
    /** InputManager.INJECT_INPUT_EVENT_MODE_ASYNC */
    private static final int INJECT_MODE_ASYNC = 0;
    /** UserHandle.USER_CURRENT */
    private static final int USER_CURRENT = -2;

    /** The package the system sees as the caller; it must belong to this process's uid. */
    private final String mPackageName;
    private final DisplayManager mDisplayManager;
    private final SparseArray<Record> mDisplays = new SparseArray<>();

    // Resolved lazily, once.
    private Object mInputManager;
    private Method mInjectInputEvent;
    private Method mSetDisplayId;
    private Object mActivityTaskManager;
    private Method mStartActivityAsUser;
    private Handler mFocusHandler;
    private boolean mFocusUnavailableLogged;
    private boolean mDisplayStateResolved;
    private Method mSetDisplayState;
    private Method mSetVirtualDisplayState;
    private Object mDisplayManagerGlobal;

    private static final class Record {
        final int displayId;
        final int ownerUid;
        final VirtualDisplay vd;
        final IBinder token;
        final IBinder.DeathRecipient death;
        /**
         * This process' copy of the surface the display renders into (unparcelled from the
         * client). Released as soon as it is replaced or the display goes: the copy holds the
         * client's buffer queue producer, and through it the client's whole BLAST surface --
         * layer, last buffer and all. Left to the garbage collector of a host that hardly
         * allocates, every surface the panes ever had stayed alive in SurfaceFlinger (hundreds
         * of offscreen SurfaceView layers, several MB each).
         */
        Surface surface;

        Record(int displayId, int ownerUid, VirtualDisplay vd, IBinder token, IBinder.DeathRecipient death) {
            this.displayId = displayId;
            this.ownerUid = ownerUid;
            this.vd = vd;
            this.token = token;
            this.death = death;
        }
    }

    public VdHostCore(Context context) {
        this(context, context.getPackageName());
    }

    /**
     * @param packageName the package to act as. DisplayManagerService refuses
     *                    createVirtualDisplay() unless the package belongs to the calling uid, so a
     *                    Shizuku UserService (uid 2000, but loaded from the launcher's APK, whose
     *                    Context says "com.android.launcher66") passes "com.android.shell".
     */
    /** Logged when a host starts, so a log shows which host code actually runs. */
    public static final String REVISION = "detach-sync-drain";

    public VdHostCore(Context context, String packageName) {
        mPackageName = packageName;
        Log.i(TAG, "VD host core revision " + REVISION);
        if (packageName.equals(context.getPackageName())) {
            mDisplayManager = context.getSystemService(DisplayManager.class);
        } else {
            mDisplayManager = newDisplayManager(new PackageContext(context, packageName));
        }
        if (mDisplayManager == null) throw new IllegalStateException("DisplayManager unavailable");
    }

    /** DisplayManager(Context) is @hide; getSystemService() would bind it to the base Context. */
    private static DisplayManager newDisplayManager(Context context) {
        try {
            Constructor<DisplayManager> c = DisplayManager.class.getDeclaredConstructor(Context.class);
            c.setAccessible(true);
            return c.newInstance(context);
        } catch (Throwable t) {
            Log.w(TAG, "DisplayManager(Context) unavailable", t);
            return null;
        }
    }

    /** A Context that reports another package of the same uid. */
    private static final class PackageContext extends ContextWrapper {
        private final String mPackage;

        PackageContext(Context base, String pkg) {
            super(base);
            mPackage = pkg;
        }

        @Override public String getPackageName() { return mPackage; }

        @Override public String getOpPackageName() { return mPackage; }

        @Override public Context getApplicationContext() { return this; }

        @Override public AttributionSource getAttributionSource() {
            return new AttributionSource.Builder(Process.myUid()).setPackageName(mPackage).build();
        }
    }

    // ---------------------------------------------------------------------------------------
    // Displays
    // ---------------------------------------------------------------------------------------

    public int createDisplay(int callerUid, IBinder token, String name, int width, int height,
                             int densityDpi, int flags, Surface surface) {
        if (token == null) throw new IllegalArgumentException("client token is required");
        int w = Math.max(1, width);
        int h = Math.max(1, height);
        int dpi = Math.max(72, densityDpi);
        int f = sanitizeFlags(flags);

        // Not every host holds every permission: shell (Shizuku) has no CAPTURE_SECURE_VIDEO_OUTPUT,
        // and older shells may lack ADD_TRUSTED_DISPLAY. Drop what is refused, step by step.
        final int[] attempts = {
                f,
                f & ~VdHostProtocol.VD_FLAG_SECURE,
                f & ~(VdHostProtocol.VD_FLAG_SECURE | VdHostProtocol.VD_FLAG_TRUSTED
                        | VdHostProtocol.VD_FLAG_ALWAYS_UNLOCKED),
        };
        VirtualDisplay vd = null;
        SecurityException refused = null;
        for (int i = 0; i < attempts.length && vd == null; i++) {
            if (i > 0 && attempts[i] == attempts[i - 1]) continue;
            try {
                vd = mDisplayManager.createVirtualDisplay(
                        name != null ? name : "FytVdHost", w, h, dpi, surface, attempts[i]);
                f = attempts[i];
            } catch (SecurityException e) {
                refused = e;
                Log.w(TAG, "createVirtualDisplay refused flags=0x" + Integer.toHexString(attempts[i])
                        + ": " + e.getMessage());
            }
        }
        if (vd == null) {
            if (refused != null) throw refused;
            throw new IllegalStateException("createVirtualDisplay returned null");
        }
        final int displayId = vd.getDisplay().getDisplayId();

        IBinder.DeathRecipient death = () -> {
            Log.i(TAG, "client of display " + displayId + " died, releasing it");
            releaseDisplayInternal(displayId);
        };
        try {
            token.linkToDeath(death, 0);
        } catch (RemoteException e) {
            vd.release();
            throw new IllegalStateException("client already dead");
        }

        synchronized (mDisplays) {
            Record r = new Record(displayId, callerUid, vd, token, death);
            r.surface = surface;
            mDisplays.put(displayId, r);
        }
        applyImePolicy(displayId);
        scheduleFocusRestore();
        Log.i(TAG, "created display " + displayId + " " + w + "x" + h + "@" + dpi
                + " flags=0x" + Integer.toHexString(f) + " for uid " + callerUid);
        return displayId;
    }

    public void releaseDisplay(int callerUid, int displayId) {
        if (find(callerUid, displayId) == null) return;
        releaseDisplayInternal(displayId);
    }

    public void setSurface(int callerUid, int displayId, Surface surface) {
        Record r = require(callerUid, displayId);
        r.vd.setSurface(surface);
        if (surface == null) waitUntilDetached();
        Surface old;
        synchronized (r) {
            old = r.surface;
            r.surface = surface;
        }
        releaseSurface(old, surface);
    }

    private Object mWindowManager;
    private Method mSyncTransactions;
    private boolean mSyncResolved;

    /**
     * Returns once SurfaceFlinger no longer renders the display into the surface just taken off.
     * The client calls setSurface(null) from SurfaceHolder.Callback.surfaceDestroyed(), and the
     * SurfaceView removes its BLAST layer right after that returns; but the display manager
     * applies a surface change only with the next window traversal. A frame SurfaceFlinger
     * queued in between went to a layer that was already gone, and its buffer queue then waited
     * for that frame's release forever, keeping itself, the layer and its buffers alive -- an
     * offscreen layer of several MB on every pane teardown. IWindowManager.syncInputTransactions()
     * runs the pending traversal (where the display manager hands the change over) and waits for
     * SurfaceFlinger to have applied it.
     */
    private void waitUntilDetached() {
        long start = SystemClock.uptimeMillis();
        boolean synced = false;
        try {
            synchronized (this) {
                if (!mSyncResolved) {
                    mSyncResolved = true;
                    mWindowManager = Hidden.getService("window", "android.view.IWindowManager");
                    mSyncTransactions = Hidden.findMethod(mWindowManager, "syncInputTransactions", 1);
                    Log.i(TAG, mSyncTransactions != null
                            ? "surface detach waits via IWindowManager.syncInputTransactions()"
                            : "no IWindowManager.syncInputTransactions(); surface detach waits a fixed time");
                }
            }
            if (mSyncTransactions != null) {
                mSyncTransactions.invoke(mWindowManager, false);
                synced = true;
            }
        } catch (Throwable t) {
            Log.w(TAG, "syncInputTransactions failed: " + t);
        }
        // A frame SurfaceFlinger queued just before the change still has to pass through the
        // client's buffer queue onto its layer -- which must still be there for that. Displays
        // that cannot be switched off (Android 16) keep rendering until this very moment.
        SystemClock.sleep(synced ? drainMs() : DETACH_FALLBACK_MS);
        long took = SystemClock.uptimeMillis() - start;
        if (took > 150) Log.i(TAG, "surface detach took " + took + " ms");
        else Log.d(TAG, "surface detach in " + took + " ms" + (synced ? "" : " (fixed wait)"));
    }

    /** About two frames for the last queued frame to reach the client's layer. */
    private static final long DETACH_DRAIN_MS = 34;
    /** Overrides DETACH_DRAIN_MS (0..1000 ms) for testing, e.g. adb shell setprop debug.fytvdhost.drain_ms 120 */
    private static final String PROP_DRAIN_MS = "debug.fytvdhost.drain_ms";
    private long mLoggedDrainMs = DETACH_DRAIN_MS;

    private long drainMs() {
        long ms = DETACH_DRAIN_MS;
        try {
            ms = (Long) Class.forName("android.os.SystemProperties")
                    .getMethod("getLong", String.class, long.class)
                    .invoke(null, PROP_DRAIN_MS, DETACH_DRAIN_MS);
        } catch (Throwable ignore) { }
        ms = Math.max(0, Math.min(1000, ms));
        if (ms != mLoggedDrainMs) {
            mLoggedDrainMs = ms;
            Log.i(TAG, "surface detach drain " + ms + " ms (" + PROP_DRAIN_MS + ")");
        }
        return ms;
    }
    /** Without syncInputTransactions(): a traversal or two, plus the drain. */
    private static final long DETACH_FALLBACK_MS = 80;

    private static void releaseSurface(Surface old, Surface keep) {
        if (old == null || old == keep) return;
        try { old.release(); } catch (Throwable t) { Log.w(TAG, "surface release failed", t); }
    }

    public void resize(int callerUid, int displayId, int width, int height, int densityDpi) {
        Record r = require(callerUid, displayId);
        if (width <= 0 || height <= 0) return;
        r.vd.resize(width, height, Math.max(72, densityDpi));
    }

    public void setDisplayState(int callerUid, int displayId, boolean on) {
        Record r = require(callerUid, displayId);
        if (!resolveDisplayState()) return;
        try {
            if (mSetDisplayState != null) {
                mSetDisplayState.invoke(r.vd, on);
            } else {
                Object token = Hidden.readField(r.vd, "mToken");
                mSetVirtualDisplayState.invoke(mDisplayManagerGlobal, token, on);
            }
        } catch (Throwable t) {
            Log.w(TAG, "setDisplayState failed: " + t);
        }
    }

    /**
     * The switch ActivityView flips when its surface comes and goes: VirtualDisplay.setDisplayState()
     * (@hide), or DisplayManagerGlobal.setVirtualDisplayState() behind it. Android 16 has dropped
     * the former; without either the embedded app simply keeps running while its pane is hidden.
     */
    private synchronized boolean resolveDisplayState() {
        if (mDisplayStateResolved) return mSetDisplayState != null || mSetVirtualDisplayState != null;
        mDisplayStateResolved = true;
        try {
            mSetDisplayState = VirtualDisplay.class.getMethod("setDisplayState", boolean.class);
            return true;
        } catch (Throwable ignore) { }
        try {
            Class<?> dmg = Class.forName("android.hardware.display.DisplayManagerGlobal");
            Object global = dmg.getMethod("getInstance").invoke(null);
            for (Method m : dmg.getDeclaredMethods()) {
                if (m.getName().equals("setVirtualDisplayState") && m.getParameterTypes().length == 2
                        && m.getParameterTypes()[1] == boolean.class) {
                    m.setAccessible(true);
                    mSetVirtualDisplayState = m;
                    mDisplayManagerGlobal = global;
                    return true;
                }
            }
        } catch (Throwable ignore) { }
        Log.i(TAG, "no virtual display state switch on this Android version; skipping it");
        return false;
    }

    /** Releases everything, e.g. when the daemon shuts down. */
    public void releaseAll() {
        List<Integer> ids = new ArrayList<>();
        synchronized (mDisplays) {
            for (int i = 0; i < mDisplays.size(); i++) ids.add(mDisplays.keyAt(i));
        }
        for (int id : ids) releaseDisplayInternal(id);
    }

    private void releaseDisplayInternal(int displayId) {
        Record r;
        synchronized (mDisplays) {
            r = mDisplays.get(displayId);
            if (r == null) return;
            mDisplays.remove(displayId);
        }
        try { r.token.unlinkToDeath(r.death, 0); } catch (Throwable ignore) { }
        // Released while still rendering into a pane's surface (a pane set torn down): take the
        // surface off first, the same way as on setSurface(null) -- destroying the display is
        // just as asynchronous, and a last frame into a surface whose layer is going leaks it.
        Surface attached;
        synchronized (r) { attached = r.surface; }
        if (attached != null) {
            try {
                r.vd.setSurface(null);
                waitUntilDetached();
            } catch (Throwable t) {
                Log.w(TAG, "detaching display " + displayId + " before release failed", t);
            }
        }
        try { r.vd.release(); } catch (Throwable t) { Log.w(TAG, "release failed", t); }
        Surface old;
        synchronized (r) {
            old = r.surface;
            r.surface = null;
        }
        releaseSurface(old, null);
        Log.i(TAG, "released display " + displayId);
    }

    private Record find(int callerUid, int displayId) {
        synchronized (mDisplays) {
            Record r = mDisplays.get(displayId);
            return (r != null && r.ownerUid == callerUid) ? r : null;
        }
    }

    private Record require(int callerUid, int displayId) {
        Record r = find(callerUid, displayId);
        if (r == null) throw new IllegalArgumentException("unknown display " + displayId);
        return r;
    }

    private static int sanitizeFlags(int flags) {
        int f = flags;
        if (Build.VERSION.SDK_INT < 30) f &= ~VdHostProtocol.VD_FLAG_TRUSTED;
        if (Build.VERSION.SDK_INT < 33) f &= ~VdHostProtocol.VD_FLAG_ALWAYS_UNLOCKED;
        return f;
    }

    /**
     * Android 12+: show the keyboard of an embedded app on the main screen, where ActivityView's
     * IME also appeared. Android 11 does that by default for displays without system decorations.
     */
    private void applyImePolicy(int displayId) {
        if (Build.VERSION.SDK_INT < 31) return;
        try {
            Object wm = Hidden.getService("window", "android.view.IWindowManager");
            Method m = wm.getClass().getMethod("setDisplayImePolicy", int.class, int.class);
            m.invoke(wm, displayId, IME_POLICY_FALLBACK_DISPLAY);
        } catch (Throwable t) {
            Log.w(TAG, "setDisplayImePolicy failed", t);
        }
    }

    // ---------------------------------------------------------------------------------------
    // Input
    // ---------------------------------------------------------------------------------------

    public void injectInput(int callerUid, int displayId, InputEvent event) {
        if (event == null || find(callerUid, displayId) == null) return;
        if (event instanceof MotionEvent && ((MotionEvent) event).getActionMasked() == MotionEvent.ACTION_DOWN) {
            // The user is working in a pane now: it gets the focus (and with it the IME and
            // Back), so a focus restore still pending from its launch must not take it away.
            cancelFocusRestore();
        }
        try {
            resolveInput();
            mSetDisplayId.invoke(event, displayId);
            if (event instanceof MotionEvent && event.getSource() == InputDevice.SOURCE_UNKNOWN) {
                ((MotionEvent) event).setSource(InputDevice.SOURCE_TOUCHSCREEN);
            }
            mInjectInputEvent.invoke(mInputManager, event, INJECT_MODE_ASYNC);
        } catch (Throwable t) {
            Log.w(TAG, "injectInputEvent failed", t);
        }
    }

    private synchronized void resolveInput() throws ReflectiveOperationException {
        if (mInjectInputEvent != null) return;
        Object im = Hidden.getService("input", "android.hardware.input.IInputManager");
        Method inject = im.getClass().getMethod("injectInputEvent", InputEvent.class, int.class);
        mSetDisplayId = InputEvent.class.getMethod("setDisplayId", int.class);
        mInputManager = im;
        mInjectInputEvent = inject;
    }

    // ---------------------------------------------------------------------------------------
    // Activities
    // ---------------------------------------------------------------------------------------

    /**
     * Starts the intent on the display as this host's uid. As system the launch passes every
     * "may launch on this display" check (INTERNAL_SYSTEM_WINDOW), including for activities
     * without android:allowEmbedded, which is what keeps Google Maps & co. out of an app-owned
     * VirtualDisplay.
     */
    public int startActivity(int callerUid, int displayId, Intent intent, Bundle options) {
        require(callerUid, displayId);
        if (intent == null) throw new IllegalArgumentException("intent is null");

        Intent i = new Intent(intent);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Bundle opts = options != null ? new Bundle(options) : new Bundle();
        opts.putAll(ActivityOptions.makeBasic().setLaunchDisplayId(displayId).toBundle());

        try {
            resolveStartActivity();
            Object[] args = buildStartArgs(mStartActivityAsUser.getParameterTypes(), i, opts);
            Object res = mStartActivityAsUser.invoke(mActivityTaskManager, args);
            int code = res instanceof Integer ? (Integer) res : -1;
            Log.i(TAG, "startActivity " + i.getComponent() + " on display " + displayId + " -> " + code);
            if (code >= 0) scheduleFocusRestore();
            return code;
        } catch (java.lang.reflect.InvocationTargetException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            Log.w(TAG, "startActivity failed", cause);
            throw new IllegalStateException(String.valueOf(cause.getMessage()));
        } catch (ReflectiveOperationException e) {
            Log.w(TAG, "startActivity unavailable", e);
            throw new IllegalStateException("startActivityAsUser unavailable: " + e);
        }
    }

    private synchronized void resolveStartActivity() throws ReflectiveOperationException {
        if (mStartActivityAsUser != null) return;
        Object atm = Hidden.getService("activity_task", "android.app.IActivityTaskManager");
        Method found = null;
        for (Method m : atm.getClass().getMethods()) {
            if (!m.getName().equals("startActivityAsUser")) continue;
            Class<?>[] p = m.getParameterTypes();
            boolean hasIntent = false;
            for (Class<?> c : p) if (c == Intent.class) hasIntent = true;
            if (hasIntent && p.length >= 11 && p[p.length - 1] == int.class) { found = m; break; }
        }
        if (found == null) throw new NoSuchMethodException("IActivityTaskManager.startActivityAsUser");
        mActivityTaskManager = atm;
        mStartActivityAsUser = found;
    }

    /**
     * (IApplicationThread caller, String callingPackage, [String callingFeatureId,] Intent intent,
     *  String resolvedType, IBinder resultTo, String resultWho, int requestCode, int startFlags,
     *  ProfilerInfo profilerInfo, Bundle options, int userId)
     */
    private Object[] buildStartArgs(Class<?>[] types, Intent intent, Bundle options) {
        Object[] args = new Object[types.length];
        int strings = 0;
        int ints = 0;
        for (int k = 0; k < types.length; k++) {
            Class<?> t = types[k];
            if (t == String.class) {
                args[k] = (strings++ == 0) ? mPackageName : null;
            } else if (t == int.class) {
                // requestCode, startFlags, userId
                args[k] = ints == 0 ? -1 : (ints == 1 ? 0 : USER_CURRENT);
                ints++;
            } else if (t == Intent.class) {
                args[k] = intent;
            } else if (t == Bundle.class) {
                args[k] = options;
            } else if (t == boolean.class) {
                args[k] = Boolean.FALSE;
            } else {
                args[k] = null;
            }
        }
        return args;
    }

    // ---------------------------------------------------------------------------------------
    // Focus
    // ---------------------------------------------------------------------------------------

    /**
     * Hands the top focus back to the main screen.
     *
     * A new display, and an activity starting on one, becomes the top focused display -- on
     * Android 16 before it even has a window. Keys (Back above all) then go to a display with
     * nothing to receive them, and the launcher behind the panes stops reacting. The launch is
     * asynchronous, so this runs a little later, twice. Touching a pane still focuses it, which is
     * what typing into an embedded app needs (the IME and Back follow the top focused display);
     * a touch on a pane also cancels a restore still pending (see injectInput()).
     *
     * The launcher itself may call this after starting an activity directly (scheduleFocusRestore()
     * runs on its own after createDisplay() and startActivity()).
     */
    public void scheduleFocusRestore() {
        synchronized (this) {
            if (mFocusHandler == null) {
                HandlerThread t = new HandlerThread("vdhost-focus");
                t.start();
                mFocusHandler = new Handler(t.getLooper());
            }
        }
        mFocusHandler.removeCallbacksAndMessages(null);
        mFocusHandler.postDelayed(this::focusMainDisplay, 400);
        mFocusHandler.postDelayed(this::focusMainDisplay, 1500);
    }

    private void cancelFocusRestore() {
        Handler h;
        synchronized (this) {
            h = mFocusHandler;
        }
        if (h != null) h.removeCallbacksAndMessages(null);
    }

    private void focusMainDisplay() {
        try {
            Object atm = Hidden.getService("activity_task", "android.app.IActivityTaskManager");
            // Android 12+: focusTopTask(displayId) focuses the display's top task and moves the
            // display to the top.
            try {
                atm.getClass().getMethod("focusTopTask", int.class).invoke(atm, 0);
                return;
            } catch (NoSuchMethodException ignore) { }
            // Android 11: setFocusedTask() on the top task of the main display.
            int taskId = topTaskIdOn(atm, 0);
            if (taskId >= 0) {
                atm.getClass().getMethod("setFocusedTask", int.class).invoke(atm, taskId);
                return;
            }
            logFocusUnavailable(null);
        } catch (Throwable t) {
            logFocusUnavailable(t);
        }
    }

    private static int topTaskIdOn(Object atm, int displayId) throws ReflectiveOperationException {
        for (String name : new String[]{ "getAllRootTaskInfosOnDisplay", "getAllStackInfosOnDisplay" }) {
            Method m;
            try { m = atm.getClass().getMethod(name, int.class); }
            catch (NoSuchMethodException e) { continue; }
            Object result = m.invoke(atm, displayId);
            if (!(result instanceof List) || ((List<?>) result).isEmpty()) return -1;
            Object top = ((List<?>) result).get(0);
            Object ids = Hidden.readField(top, "childTaskIds");
            if (ids == null) ids = Hidden.readField(top, "taskIds");
            if (ids instanceof int[] && ((int[]) ids).length > 0) {
                int[] a = (int[]) ids;
                return a[a.length - 1];
            }
            return -1;
        }
        return -1;
    }

    private void logFocusUnavailable(Throwable t) {
        if (mFocusUnavailableLogged) return;
        mFocusUnavailableLogged = true;
        Log.w(TAG, "cannot hand the focus back to the main screen" + (t != null ? ": " + t : ""));
    }

    // ---------------------------------------------------------------------------------------
    // Tasks
    // ---------------------------------------------------------------------------------------

    /** @return number of tasks on the display, -1 when it cannot be determined */
    public int getTaskCount(int callerUid, int displayId) {
        if (find(callerUid, displayId) == null) return -1;
        try {
            Object atm = Hidden.getService("activity_task", "android.app.IActivityTaskManager");
            Method m = null;
            for (String name : new String[]{ "getAllRootTaskInfosOnDisplay", "getAllStackInfosOnDisplay" }) {
                try { m = atm.getClass().getMethod(name, int.class); break; }
                catch (NoSuchMethodException ignore) { }
            }
            if (m == null) return -1;
            Object result = m.invoke(atm, displayId);
            if (!(result instanceof List)) return -1;
            int count = 0;
            for (Object info : (List<?>) result) {
                if (info == null) continue;
                Object ids = Hidden.readField(info, "childTaskIds");     // RootTaskInfo, 12+
                if (ids == null) ids = Hidden.readField(info, "taskIds"); // StackInfo, 11
                count += (ids instanceof int[]) ? ((int[]) ids).length : 1;
            }
            return count;
        } catch (Throwable t) {
            Log.w(TAG, "getTaskCount failed", t);
            return -1;
        }
    }
}
