package com.android.launcher66.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Keeps the launcher from crashing in a loop. CrashLogger records every crash here; when three of
 * them fall within two minutes the next start is a safe one: no custom elements (date, music,
 * radio, PiP and stats placeholders), no PiP panes and no stats window, the things that run right
 * after the bind and were what crashed. The mode lasts until the launcher's settings are left or
 * the process restarts, and the history is cleared after two minutes without a crash.
 */
public final class CrashLoopGuard {

    private static final String TAG = "CrashLoopGuard";
    private static final String HISTORY_FILE = "crash_history";
    private static final int DESCRIPTION_LIMIT = 200;
    /** The folder of the reports, as LogcatWorker names it. */
    private static final String LOG_DIR_NAME = "Launcher66_Logs";

    private static volatile boolean sSafeMode;
    private static volatile String sPreviousCrash;
    private static volatile String sReportPath;
    private static volatile int sCrashesAtStart;
    private static volatile boolean sToastShown;

    private CrashLoopGuard() {
    }

    /**
     * From Application.onCreate(), right after CrashLogger.install(), except in the wallpaper
     * picker's process. Reads a few hundred bytes: StrictMode is enabled at the end of onCreate().
     */
    public static void onProcessStart(Context context) {
        final Context app = context.getApplicationContext();
        String text = readHistory(app);
        long now = System.currentTimeMillis();
        List<Long> history = CrashLoopPolicy.parse(text);
        int recent = CrashLoopPolicy.recent(history, now);
        sCrashesAtStart = recent;
        sSafeMode = CrashLoopPolicy.safeMode(history, now);
        sPreviousCrash = recent > 0 ? CrashLoopPolicy.lastOneLine(text) : null;
        sReportPath = null;
        if (sSafeMode) {
            Log.w(TAG, "Safe mode: " + recent + " crashes within " + (CrashLoopPolicy.WINDOW_MS / 1000)
                    + " s; custom elements, PiP panes and the stats window are off until the settings are left");
        }
        if (recent > 0) {
            Log.i(TAG, "The previous run crashed: " + sPreviousCrash);
        }
        if (text != null && !text.isEmpty()) {
            new Handler(Looper.getMainLooper()).postDelayed(() -> new Thread(() -> {
                File file = historyFile(app);
                if (file.exists() && file.delete()) {
                    Log.i(TAG, "No crash for " + (CrashLoopPolicy.WINDOW_MS / 1000)
                            + " s, crash history cleared");
                }
            }, "CrashHistoryClear").start(), CrashLoopPolicy.WINDOW_MS);
        }
    }

    /**
     * From CrashLogger, on the crashing thread: adds the crash to the history and syncs it, the
     * process ends right after.
     */
    static void recordCrash(Context context, Throwable throwable) {
        File file = historyFile(context);
        String message = throwable.getMessage();
        if (message != null && message.length() > DESCRIPTION_LIMIT) {
            message = message.substring(0, DESCRIPTION_LIMIT);
        }
        String line = throwable.getClass().getSimpleName() + ": " + message;
        String text = CrashLoopPolicy.append(readHistory(context), System.currentTimeMillis(), line);
        try (FileOutputStream out = new FileOutputStream(file, false)) {
            out.write(text.getBytes(StandardCharsets.UTF_8));
            out.flush();
            out.getFD().sync();
        } catch (IOException e) {
            Log.w(TAG, "Could not write the crash history: " + e);
        }
    }

    /** The crashes within the window, counting the one being recorded; for the report's header. */
    static int recentCrashes(Context context) {
        return CrashLoopPolicy.recent(CrashLoopPolicy.parse(readHistory(context)), System.currentTimeMillis());
    }

    /**
     * Finds the newest crash report; from a background thread (StartupWarmUp), as it lists folders.
     * Only needed when the previous run crashed, for the message.
     */
    public static void resolveReportPath(Context context) {
        if (sPreviousCrash == null) {
            return;
        }
        try {
            File newest = null;
            for (File dir : new File[]{LogcatWorker.usablePublicDir(context),
                    LogcatWorker.resolveFallbackDir(context)}) {
                File[] files = dir == null ? null : dir.listFiles();
                if (files == null) {
                    continue;
                }
                for (File file : files) {
                    String name = file.getName();
                    if (name.startsWith(LogFileName.CRASH_LABEL + "_") && name.endsWith(LogFileName.TXT)
                            && (newest == null || file.lastModified() > newest.lastModified())) {
                        newest = file;
                    }
                }
            }
            if (newest != null) {
                sReportPath = newest.getParentFile().getName() + "/" + newest.getName();
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not look for the crash report: " + e);
        }
    }

    public static boolean isSafeMode() {
        return sSafeMode;
    }

    public static void leaveSafeMode(String reason) {
        if (sSafeMode) {
            sSafeMode = false;
            Log.i(TAG, "Safe mode left: " + reason);
        }
    }

    /** The one-line description of the crash that ended the previous run, or null. */
    public static String previousCrash() {
        return sPreviousCrash;
    }

    /** How many crashes within the window the start found in the history. */
    public static int crashesAtStart() {
        return sCrashesAtStart;
    }

    /** Folder and name of the newest crash report; the folder alone while it is not known yet. */
    public static String reportPath() {
        String path = sReportPath;
        return path != null ? path : LOG_DIR_NAME;
    }

    /** True once per process and only if the previous run crashed: the message should be shown. */
    public static synchronized boolean takeToast() {
        if (sToastShown || sPreviousCrash == null) {
            return false;
        }
        sToastShown = true;
        return true;
    }

    private static File historyFile(Context context) {
        return new File(context.getFilesDir(), HISTORY_FILE);
    }

    private static String readHistory(Context context) {
        File file = historyFile(context);
        if (!file.isFile()) {
            return null;
        }
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) Math.min(file.length(), 8192L)];
            int read = in.read(bytes);
            return read <= 0 ? null : new String(bytes, 0, read, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Log.w(TAG, "Could not read the crash history: " + e);
            return null;
        }
    }
}
