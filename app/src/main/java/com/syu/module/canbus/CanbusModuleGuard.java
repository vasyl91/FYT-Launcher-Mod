package com.syu.module.canbus;

import android.os.SystemClock;
import android.util.Log;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Keeps a canbus module (decompiled code, written for one car) from hurting the launcher when it
 * does not fit the car: an exception in its in() / out() / update() is logged, once per class and
 * method, and goes no further; a slow in() is logged once so that the next log shows what it cost.
 */
public final class CanbusModuleGuard {

    private static final String TAG = "CanbusModuleGuard";

    /** An in() that takes this long is worth a line in the log. */
    static final long SLOW_IN_MS = 100L;

    private static final Set<String> sLogged = ConcurrentHashMap.newKeySet();

    private CanbusModuleGuard() {
    }

    /** Runs the module's in(); {@code canbusId} is only for the log. */
    public static void in(Object module, int canbusId, Runnable in) {
        long start = SystemClock.elapsedRealtime();
        run(module, "in", in);
        long took = SystemClock.elapsedRealtime() - start;
        if (took >= SLOW_IN_MS) {
            Log.i(TAG, "canbus module " + module.getClass().getName() + " (canbus id " + canbusId
                    + "): in() took " + took + " ms");
        }
    }

    /** Runs the module's out(). */
    public static void out(Object module, Runnable out) {
        run(module, "out", out);
    }

    /** Logs a RuntimeException from the module's {@code method}, the first time for that class and method. */
    public static void failed(Object module, String method, RuntimeException e) {
        String name = module.getClass().getName();
        if (sLogged.add(name + "." + method)) {
            Log.w(TAG, "canbus module " + name + " failed in " + method + "()", e);
        }
    }

    private static void run(Object module, String method, Runnable call) {
        try {
            call.run();
        } catch (RuntimeException e) {
            failed(module, method, e);
        }
    }
}
