package com.android.launcher66.settings;

import android.util.Log;

import com.android.launcher66.LauncherApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * The fuse for code made for FYT units (the callbacks of com.syu.ms, the canbus modules, the radio
 * and music sources): that code was written against one firmware and may meet a unit or an Android
 * version it does not fit. A failure is then reported, not a crash: logged with its stack and, the
 * first time, written to a compat_pid_&lt;time&gt;.txt report (see {@link CompatReportPolicy} for how
 * many), and the launcher goes on without that piece of work.
 *
 * <p>Only RuntimeException and LinkageError (a class of the firmware that differs from the launcher's
 * copy) are caught. A VirtualMachineError (out of memory, stack overflow) and any other Error go on
 * their way: they are not a mismatch with the firmware. Use it at the outermost level of FYT code, not
 * inside its logic.
 */
public final class FytCompat {

    private static final String TAG = "FytCompat";

    private static final CompatReportPolicy POLICY = new CompatReportPolicy();
    /** The report is written here, so that the main thread, with StrictMode on, never touches the disk. */
    private static final ExecutorService WRITER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "FytCompatReport");
        t.setDaemon(true);
        return t;
    });

    private FytCompat() {
    }

    /** Runs {@code r}; a RuntimeException or LinkageError from it is reported. */
    public static void run(String area, Runnable r) {
        try {
            r.run();
        } catch (RuntimeException | LinkageError e) {
            report(area, e);
        }
    }

    /**
     * Like {@link #run(String, Runnable)} with the area {@code prefix + code}, but the text is only
     * built when the work fails. For callers that run often and have a Runnable to pass anyway.
     */
    public static void run(String prefix, int code, Runnable r) {
        try {
            r.run();
        } catch (RuntimeException | LinkageError e) {
            report(prefix + code, e);
        }
    }

    /** Returns what {@code s} gives, or {@code fallback} when it fails (the failure is reported). */
    public static <T> T call(String area, Supplier<T> s, T fallback) {
        try {
            return s.get();
        } catch (RuntimeException | LinkageError e) {
            report(area, e);
            return fallback;
        }
    }

    /** Reports a failure that the caller caught itself. Never throws. */
    public static void report(String area, Throwable t) {
        try {
            String key = CompatReportPolicy.key(area, t);
            switch (POLICY.record(key)) {
                case REPORT:
                    Log.e(TAG, "FYT code failed in " + area + ", reported and ignored", t);
                    final Thread thread = Thread.currentThread();
                    final int occurrence = POLICY.count(key);
                    try {
                        WRITER.execute(() -> {
                            LauncherApplication app = LauncherApplication.sApp;
                            if (app != null) {
                                CrashLogger.writeNonFatal(app, area, thread, t, occurrence);
                            }
                        });
                    } catch (RuntimeException rejected) {
                        // The report is lost, the log line above remains.
                    }
                    break;
                case LOG_COUNT:
                    Log.w(TAG, "FYT code keeps failing in " + area + ": " + POLICY.count(key)
                            + " times (" + t.getClass().getSimpleName() + ")");
                    break;
                default:
                    break;
            }
        } catch (Throwable ignored) {
            // The fuse itself must not be the next failure.
        }
    }

    /**
     * Whether the code of the area has failed so often (5 times with the same error) that its caller
     * may skip it from now on. Only for code that is safe to skip, such as a CAN code's listener.
     */
    public static boolean isDisabled(String area) {
        return POLICY.isAreaDisabled(area);
    }
}
