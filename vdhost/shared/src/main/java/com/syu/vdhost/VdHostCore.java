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
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
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

    private static final class Record {
        final int displayId;
        final int ownerUid;
        final VirtualDisplay vd;
        final IBinder token;
        final IBinder.DeathRecipient death;

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
    public VdHostCore(Context context, String packageName) {
        mPackageName = packageName;
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
            mDisplays.put(displayId, new Record(displayId, callerUid, vd, token, death));
        }
        applyImePolicy(displayId);
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
    }

    public void resize(int callerUid, int displayId, int width, int height, int densityDpi) {
        Record r = require(callerUid, displayId);
        if (width <= 0 || height <= 0) return;
        r.vd.resize(width, height, Math.max(72, densityDpi));
    }

    public void setDisplayState(int callerUid, int displayId, boolean on) {
        Record r = require(callerUid, displayId);
        try {
            // @hide, Android 10+. The same switch ActivityView flips when its surface comes and goes.
            VirtualDisplay.class.getMethod("setDisplayState", boolean.class).invoke(r.vd, on);
        } catch (Throwable t) {
            Log.w(TAG, "setDisplayState failed", t);
        }
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
        try { r.vd.release(); } catch (Throwable t) { Log.w(TAG, "release failed", t); }
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
