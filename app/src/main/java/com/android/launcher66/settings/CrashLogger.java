package com.android.launcher66.settings;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.BuildConfig;
import com.android.launcher66.DeviceIdentity;
import com.android.launcher66.LauncherApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * The launcher's only handler for uncaught exceptions. It writes the crash to Launcher66_Logs
 * (crash_pid_&lt;time&gt;.txt, the same folder as the logs and named like them): the device, the app,
 * the stack trace with its causes and the process's last log lines. It also records the crash for
 * CrashLoopGuard and ends the process, so the system restarts the launcher without a crash dialog.
 *
 * <p>The crash is logged at error level with "FATAL EXCEPTION": the process ends here before the
 * platform's own handler could log it, so without this line a launcher crash only showed up in
 * logcat as System.err output.
 */
public final class CrashLogger implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashLogger";
    /** Lines of this process's log written along with the trace. */
    private static final int LOG_TAIL_LINES = 600;
    /** The process is dying: reading the log may not hold it up for long. */
    private static final long LOG_TAIL_TIMEOUT_MS = 2000L;
    /** The reports kept in the folder; the oldest are deleted. */
    private static final int MAX_REPORTS = 20;
    private static final String UNKNOWN = "?";

    private final Context mContext;
    private volatile boolean mHandling;

    private CrashLogger(Context context) {
        mContext = context.getApplicationContext();
    }

    /** From Application.onCreate(), once per process. */
    public static void install(Context context) {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof CrashLogger) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new CrashLogger(context));
    }

    /**
     * Synchronized: a second thread crashing at the same time waits for the first report. The
     * process ends in any case, even if the report fails (an OutOfMemoryError while writing it,
     * say): an exception escaping from here would leave the process running with its crashed
     * thread dead, and for the main thread that is a frozen launcher instead of a restarted one.
     * The platform's handler is not called for the same reason: it would show the crash dialog.
     */
    @Override
    public synchronized void uncaughtException(Thread thread, Throwable throwable) {
        try {
            Log.e(TAG, "FATAL EXCEPTION: " + thread.getName() + " (process " + Process.myPid() + ")", throwable);
            // A crash while writing the crash: straight to the end.
            if (!mHandling && throwable != null) {
                mHandling = true;
                try {
                    CrashLoopGuard.recordCrash(mContext, throwable);
                } catch (Throwable t) {
                    Log.e(TAG, "Could not record the crash", t);
                }
                try {
                    write(thread, throwable);
                } catch (Throwable t) {
                    Log.e(TAG, "Could not write the crash file", t);
                }
            }
        } finally {
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
        String time = new SimpleDateFormat(LogFileName.NAME_PATTERN, Locale.US).format(new Date());
        File file = uniqueFile(dir, LogFileName.name(
                LogFileName.prefix(LogFileName.CRASH_LABEL, false), time, LogFileName.TXT));
        try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
            out.println("===== CRASH " + time + " pid=" + Process.myPid() + " thread=" + thread.getName() + " =====");
            out.println("===== device=" + Build.MANUFACTURER + " " + Build.MODEL
                    + ", android=" + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ") =====");
            out.println("===== app=" + versionName() + " (" + versionCode() + "), flavor=" + BuildConfig.FLAVOR
                    + ", platform=" + platform() + ", system=" + system() + " =====");
            out.println("===== uptime=" + uptime() + " ms, crashes in the last "
                    + (CrashLoopPolicy.WINDOW_MS / 1000) + " s: " + recentCrashes() + " =====");
            throwable.printStackTrace(out);
            out.println();
            out.println("===== last " + LOG_TAIL_LINES + " log lines of this process =====");
            out.flush();
            appendLogTail(out);
        }
        Log.e(TAG, "Crash report: " + file.getAbsolutePath());
        deleteOldReports(dir);
    }

    /** The name, or name_2, name_3, ... when a report of the same second exists. */
    private static File uniqueFile(File dir, String name) {
        File file = new File(dir, name);
        String base = name.substring(0, name.length() - LogFileName.TXT.length());
        for (int n = 2; file.exists() && n < 100; n++) {
            file = new File(dir, base + "_" + n + LogFileName.TXT);
        }
        return file;
    }

    /** Keeps the newest MAX_REPORTS reports; a failure here is of no consequence. */
    private static void deleteOldReports(File dir) {
        try {
            File[] files = dir.listFiles((d, name) -> name.startsWith(LogFileName.CRASH_LABEL + "_")
                    && name.endsWith(LogFileName.TXT));
            if (files == null || files.length <= MAX_REPORTS) {
                return;
            }
            Arrays.sort(files, Comparator.comparingLong(File::lastModified)
                    .thenComparing(File::getName));
            for (int i = 0; i < files.length - MAX_REPORTS; i++) {
                if (!files[i].delete()) {
                    Log.w(TAG, "Could not delete the old report " + files[i]);
                }
            }
        } catch (Throwable t) {
            // Ignored, see above.
        }
    }

    private String versionName() {
        try {
            String name = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
            return name != null ? name : UNKNOWN;
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }

    private String versionCode() {
        try {
            PackageInfo info = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            return String.valueOf(Build.VERSION.SDK_INT >= 28 ? info.getLongVersionCode() : info.versionCode);
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }

    private static String platform() {
        try {
            return DeviceIdentity.deviceLine();
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }

    private static String system() {
        try {
            return String.valueOf(LauncherApplication.hasSystemPrivileges());
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }

    private static String uptime() {
        try {
            return String.valueOf(SystemClock.uptimeMillis() - Process.getStartUptimeMillis());
        } catch (Throwable t) {
            return UNKNOWN;
        }
    }

    private String recentCrashes() {
        try {
            return String.valueOf(CrashLoopGuard.recentCrashes(mContext));
        } catch (Throwable t) {
            return UNKNOWN;
        }
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
