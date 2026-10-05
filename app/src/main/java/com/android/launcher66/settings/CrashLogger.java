package com.android.launcher66.settings;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Writes every crash of the launcher to Launcher66_Logs (crash_<time>.txt): the stack trace of
 * each thread's uncaught exception plus the process's last log lines. A crash used to leave a
 * trace only when a logcat capture happened to be running. The previous handler runs afterwards,
 * so the system still ends the process and restarts it as before.
 */
public final class CrashLogger implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashLogger";
    /** Lines of this process's log written along with the trace. */
    private static final int LOG_TAIL_LINES = 600;
    /** The process is dying: reading the log may not hold it up for long. */
    private static final long LOG_TAIL_TIMEOUT_MS = 2000L;

    private final Context mContext;
    private final Thread.UncaughtExceptionHandler mPrevious;
    private volatile boolean mHandling;

    private CrashLogger(Context context, Thread.UncaughtExceptionHandler previous) {
        mContext = context.getApplicationContext();
        mPrevious = previous;
    }

    /** From Application.onCreate(), once per process. */
    public static void install(Context context) {
        Thread.UncaughtExceptionHandler current = Thread.getDefaultUncaughtExceptionHandler();
        if (current instanceof CrashLogger) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new CrashLogger(context, current));
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // A crash while writing the crash: straight to the system's handler.
        if (!mHandling) {
            mHandling = true;
            try {
                write(thread, throwable);
            } catch (Throwable t) {
                Log.e(TAG, "Could not write the crash file", t);
            }
        }
        if (mPrevious != null) {
            mPrevious.uncaughtException(thread, throwable);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    private void write(Thread thread, Throwable throwable) throws Exception {
        File dir = LogcatWorker.usablePublicDir(mContext);
        if (dir == null) {
            dir = LogcatWorker.resolveFallbackDir(mContext);
        }
        if (dir == null) {
            return;
        }
        String time = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.US).format(new Date());
        File file = new File(dir, "crash_" + time + ".txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
            out.println("===== CRASH " + time + " pid=" + Process.myPid() + " thread=" + thread.getName() + " =====");
            out.println("===== device=" + Build.MANUFACTURER + " " + Build.MODEL
                    + ", android=" + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ") =====");
            throwable.printStackTrace(out);
            out.println();
            out.println("===== last " + LOG_TAIL_LINES + " log lines of this process =====");
            out.flush();
            appendLogTail(out);
        }
        Log.e(TAG, "Crash written to " + file.getAbsolutePath());
    }

    private static void appendLogTail(PrintWriter out) {
        java.lang.Process logcat = null;
        try {
            logcat = new ProcessBuilder("logcat", "-d", "-v", "threadtime",
                    "-t", String.valueOf(LOG_TAIL_LINES), "--pid", String.valueOf(Process.myPid()))
                    .redirectErrorStream(true)
                    .start();
            long deadline = System.currentTimeMillis() + LOG_TAIL_TIMEOUT_MS;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(logcat.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                    if (System.currentTimeMillis() > deadline) {
                        out.println("===== log cut off after " + LOG_TAIL_TIMEOUT_MS + " ms =====");
                        break;
                    }
                }
            }
            logcat.waitFor(200, TimeUnit.MILLISECONDS);
        } catch (Throwable t) {
            out.println("===== log not available: " + t + " =====");
        } finally {
            if (logcat != null) {
                logcat.destroy();
            }
        }
    }
}
