package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Captures this process' logcat output into a text file for a configurable amount of time.
 *
 * Design notes:
 *  - all lifecycle state (running / deadline) lives in this singleton, so leaving and re-entering
 *    the settings screen does not affect the capture and the UI can always re-read the real state;
 *  - the capture never depends on WRITE_EXTERNAL_STORAGE: it falls back to the app-specific
 *    external directory (and finally to internal storage) when the public Downloads folder is
 *    not writable;
 *  - the run always ends with a toast (success or failure), so it can never fail silently.
 */
public final class LogcatWorker {

    /** Notifies the UI when the capture ended, no matter why. Called on the main thread. */
    public interface StateListener {
        void onLogcatStopped(boolean success, String message);
    }

    /** How much of the log buffer ends up in the file. */
    public enum Mode {
        /** Everything the buffer still holds, i.e. from application start. */
        FROM_APP_START,
        /** Only lines produced after start() was called. */
        FROM_NOW
    }

    private static final String TAG = "LogcatWorker";
    private static final String LOG_FILE_SUFFIX = ".txt";
    private static final String LOG_DIR_NAME = "Launcher66_Logs";
    private static final String STREAM_BUFFER = "main";
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;

    private static volatile LogcatWorker sInstance;

    public static LogcatWorker get() {
        if (sInstance == null) {
            synchronized (LogcatWorker.class) {
                if (sInstance == null) sInstance = new LogcatWorker();
            }
        }
        return sInstance;
    }

    private final Object lock = new Object();
    private final Helpers helpers = new Helpers();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean finished = new AtomicBoolean(true);

    private HandlerThread thread;
    private Handler handler;

    private volatile boolean running;
    private volatile long deadlineMs;
    private volatile Process logcatProcess;
    private volatile Context appContext;

    private BufferedWriter fileWriter;   // worker thread only
    private int timeoutSeconds;
    private volatile Mode mode = Mode.FROM_APP_START;
    /** Wall clock of the oldest line we want, 0 = no lower bound (whole buffer). */
    private volatile long captureSinceMs;

    private CountDownTimer countDownTimer; // main thread only
    private StateListener listener;        // main thread only

    private LogcatWorker() {}

    // ---------------------------------------------------------------- public API

    /** True while a capture is in progress. This is the single source of truth for the UI. */
    public boolean isActive() {
        return running;
    }

    /** Milliseconds left until the capture stops by itself, 0 when nothing is running. */
    public long getRemainingMillis() {
        if (!running) return 0L;
        return Math.max(0L, deadlineMs - System.currentTimeMillis());
    }

    public void setStateListener(StateListener l) {
        listener = l;
    }

    public void clearStateListener(StateListener l) {
        if (listener == l) listener = null;
    }

    /** Keeps the old behaviour: captures whatever the buffer holds, i.e. from application start. */
    public void start(Context context) {
        start(context, Mode.FROM_APP_START);
    }

    public void start(Context context, Mode captureMode) {
        final Context ctx = context.getApplicationContext();
        final Mode requestedMode = captureMode != null ? captureMode : Mode.FROM_APP_START;

        synchronized (lock) {
            if (running) {
                Log.w(TAG, "start() ignored - already running");
                return;
            }

            mode = requestedMode;
            captureSinceMs = (requestedMode == Mode.FROM_NOW) ? System.currentTimeMillis() : 0L;

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            timeoutSeconds = parseIntSafe(prefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT,
                    String.valueOf(DEFAULT_TIMEOUT_SECONDS)), DEFAULT_TIMEOUT_SECONDS);
            if (timeoutSeconds <= 0) timeoutSeconds = DEFAULT_TIMEOUT_SECONDS;

            appContext = ctx;
            deadlineMs = System.currentTimeMillis() + timeoutSeconds * 1000L;
            running = true;
            finished.set(false);

            thread = new HandlerThread("LogcatWorker");
            thread.start();
            handler = new Handler(thread.getLooper());
            handler.post(() -> runLogging(ctx));
        }

        Log.i(TAG, "start() mode=" + requestedMode + " timeoutSeconds=" + timeoutSeconds);
        helpers.setLogcatRunBoolean(true);

        mainHandler.post(this::startCountdown);
        // Hard stop: unblocks reader.readLine() when the log is quiet.
        mainHandler.postDelayed(deadlineRunnable, timeoutSeconds * 1000L);
    }

    public void stop(boolean showToast, Context contextForToast) {
        if (!running && finished.get()) return;

        Log.i(TAG, "stop() called showToast=" + showToast);
        running = false;
        killProcess();

        // runLogging() normally reports the real result (with the file path) from its finally
        // block. This watchdog only fires if the worker thread is stuck somewhere.
        mainHandler.postDelayed(() -> finishOnce(false,
                showToast ? string(R.string.logcat_service_run_toast) : null), 1500L);
    }

    public void stop() {
        stop(false, null);
    }

    // ---------------------------------------------------------------- capture

    private void runLogging(Context ctx) {
        final int myPid = android.os.Process.myPid();
        Log.i(TAG, "runLogging entered pid=" + myPid);

        BufferedReader reader = null;
        Process proc = null;
        File logFile = null;
        String error = null;
        long linesWritten = 0L;

        try {
            File dir = resolveLogDir(ctx);
            if (dir == null) {
                error = "Cannot create a writable log directory";
                Log.e(TAG, error);
                return;
            }

            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.getDefault())
                    .format(new Date());
            logFile = new File(dir, timestamp + LOG_FILE_SUFFIX);
            Log.i(TAG, "Opening log file: " + logFile.getAbsolutePath());

            fileWriter = new BufferedWriter(new FileWriter(logFile, true), 8192);
            writeLine("===== STREAM (PID=" + myPid + ", buffer=" + STREAM_BUFFER
                    + ", timeout=" + timeoutSeconds + "s, mode=" + mode + ") =====");
            writeLine("===== device=" + Build.MANUFACTURER + " " + Build.MODEL
                    + ", android=" + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ") =====");
            fileWriter.flush();

            // "--pid" exists since Android 7.0; when it is not available we filter by hand.
            boolean usePidFlag = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
            // "-T <time>" makes logcat skip everything older than the given timestamp. If the
            // build does not understand it we drop back to comparing timestamps ourselves.
            boolean useSinceFlag = true;
            long sinceMs = captureSinceMs;
            SimpleDateFormat lineFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
            int restartCount = 0;

            while (running && System.currentTimeMillis() < deadlineMs) {
                restartCount++;
                boolean sinceFlagThisRun = useSinceFlag && sinceMs > 0L;
                writeLine("----- logcat start #" + restartCount
                        + " (pidFlag=" + usePidFlag + ", sinceFlag=" + sinceFlagThisRun + ") -----");
                fileWriter.flush();

                proc = startLogcat(myPid, usePidFlag, sinceFlagThisRun ? sinceMs : 0L, lineFormat);
                logcatProcess = proc;

                reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line;
                long linesThisRun = 0L;
                try {
                    while (running && (line = reader.readLine()) != null) {
                        if (System.currentTimeMillis() >= deadlineMs) break;
                        if (!usePidFlag && !lineHasPid(line, myPid)) continue;
                        if (!sinceFlagThisRun && sinceMs > 0L && isOlderThan(lineFormat, line, sinceMs)) continue;
                        if (!shouldWriteAppLine(line)) continue;

                        fileWriter.write(line);
                        fileWriter.write('\n');
                        linesThisRun++;
                        linesWritten++;
                        if ((linesThisRun & 0x1F) == 0) fileWriter.flush();
                    }
                } catch (IOException ioe) {
                    // Destroying the logcat process closes the stream under a blocked readLine(),
                    // which throws InterruptedIOException. That is the normal way this capture
                    // ends (timeout or user pressed stop), not a failure.
                    if (isShuttingDown()) {
                        Log.i(TAG, "read stream closed on shutdown: " + ioe.getMessage());
                    } else {
                        throw ioe;
                    }
                }

                closeQuietly(reader);
                reader = null;

                int exit = destroyAndWait(proc);
                proc = null;
                logcatProcess = null;

                writeLine("----- logcat ended. exit=" + exit + " lines=" + linesThisRun + " -----");
                fileWriter.flush();

                // A flag this build does not understand makes logcat exit immediately with an
                // error. Drop them one at a time and keep filtering by hand instead.
                if (!isShuttingDown() && exit != 0 && linesThisRun == 0L) {
                    if (sinceFlagThisRun) {
                        Log.w(TAG, "logcat -T unsupported, falling back to manual time filter");
                        useSinceFlag = false;
                    } else if (usePidFlag) {
                        Log.w(TAG, "logcat --pid unsupported, falling back to manual pid filter");
                        usePidFlag = false;
                    }
                }

                if (!running || System.currentTimeMillis() >= deadlineMs) break;

                // Whatever the mode, a restart must not dump the buffer we already wrote.
                sinceMs = System.currentTimeMillis();

                try {
                    Thread.sleep(250L);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

        } catch (IOException ioe) {
            if (isShuttingDown()) {
                Log.i(TAG, "IO closed on shutdown: " + ioe.getMessage());
            } else {
                Log.e(TAG, "runLogging IO exception", ioe);
                error = ioe.getClass().getSimpleName() + ": " + ioe.getMessage();
            }
        } catch (Throwable t) {
            Log.e(TAG, "runLogging exception", t);
            error = t.getClass().getSimpleName() + ": " + t.getMessage();
            try {
                if (fileWriter != null) {
                    fileWriter.write("===== EXCEPTION =====\n");
                    fileWriter.write(Log.getStackTraceString(t));
                    fileWriter.write('\n');
                    fileWriter.flush();
                }
            } catch (Throwable ignored) {}
        } finally {
            running = false;

            closeQuietly(reader);
            if (proc != null) destroyAndWait(proc);
            logcatProcess = null;

            try {
                if (fileWriter != null) {
                    fileWriter.write("===== END, lines=" + linesWritten + " =====\n");
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Throwable ignored) {}
            fileWriter = null;

            boolean success = error == null && logFile != null && logFile.exists();
            String message = success
                    ? string(R.string.logcat_service_run_toast) + "\n" + logFile.getAbsolutePath()
                    : "Logcat: " + (error != null ? error : "no log file was created");

            Log.i(TAG, "runLogging finished success=" + success + " lines=" + linesWritten);
            finishOnce(success, message);
        }
    }

    private Process startLogcat(int pid, boolean usePidFlag, long sinceMs, SimpleDateFormat fmt)
            throws Exception {
        List<String> cmd = new ArrayList<>();
        cmd.add("logcat");
        cmd.add("-b");
        cmd.add(STREAM_BUFFER);
        cmd.add("-v");
        cmd.add("threadtime");
        if (usePidFlag) {
            cmd.add("--pid=" + pid);
        }
        if (sinceMs > 0L) {
            // No shell involved, so the space inside the timestamp needs no quoting.
            cmd.add("-T");
            cmd.add(fmt.format(new Date(sinceMs)));
        }
        return new ProcessBuilder(cmd).redirectErrorStream(true).start();
    }

    /**
     * Compares the "MM-dd HH:mm:ss.SSS" prefix of a threadtime line with the given wall clock.
     * Lines we cannot parse are kept, so a format surprise never empties the whole file.
     */
    private static boolean isOlderThan(SimpleDateFormat fmt, String line, long sinceMs) {
        if (line == null || line.length() < 18) return false;
        try {
            Date parsed = fmt.parse(line.substring(0, 18));
            if (parsed == null) return false;

            Calendar now = Calendar.getInstance();
            Calendar lineTime = Calendar.getInstance();
            lineTime.setTime(parsed);
            lineTime.set(Calendar.YEAR, now.get(Calendar.YEAR));

            long millis = lineTime.getTimeInMillis();
            // Around New Year the line may belong to the previous year.
            if (millis - now.getTimeInMillis() > 7L * 24L * 3600L * 1000L) {
                lineTime.add(Calendar.YEAR, -1);
                millis = lineTime.getTimeInMillis();
            }
            return millis < sinceMs;
        } catch (Throwable ignored) {
            return false;
        }
    }

    // ---------------------------------------------------------------- storage

    /**
     * Picks the first directory we can really write into. Public Downloads is only attempted when
     * it can actually work; otherwise the app-specific external folder is used, which needs no
     * runtime permission on any API level.
     */
    private static File resolveLogDir(Context ctx) {
        if (canUsePublicStorage(ctx)) {
            File pub = new File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    LOG_DIR_NAME);
            if (isUsable(pub)) return pub;
            Log.w(TAG, "Public Downloads not writable, falling back");
        }

        File ext = ctx.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (ext != null) {
            File dir = new File(ext, LOG_DIR_NAME);
            if (isUsable(dir)) return dir;
        }

        File internal = new File(ctx.getFilesDir(), LOG_DIR_NAME);
        return isUsable(internal) ? internal : null;
    }

    private static boolean canUsePublicStorage(Context ctx) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11+: apps may create their own folder inside Downloads without permissions.
            return true;
        }
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q && !Environment.isExternalStorageLegacy()) {
            return false; // scoped storage without the legacy opt-in
        }
        return ContextCompat.checkSelfPermission(ctx,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean isUsable(File dir) {
        try {
            if (!dir.exists() && !dir.mkdirs()) return false;
            if (!dir.isDirectory()) return false;
            File probe = new File(dir, ".write_probe");
            if (!probe.exists() && !probe.createNewFile()) return false;
            //noinspection ResultOfMethodCallIgnored
            probe.delete();
            return true;
        } catch (Throwable t) {
            Log.w(TAG, "Directory not usable: " + dir + " (" + t.getMessage() + ")");
            return false;
        }
    }

    // ---------------------------------------------------------------- teardown

    private final Runnable deadlineRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "deadline reached");
            running = false;
            killProcess(); // unblocks readLine() so runLogging() can finish and report
            mainHandler.postDelayed(() -> finishOnce(false, null), 1500L);
        }
    };

    private void finishOnce(boolean success, String message) {
        if (!finished.compareAndSet(false, true)) return;

        running = false;
        deadlineMs = 0L;

        synchronized (lock) {
            HandlerThread t = thread;
            thread = null;
            handler = null;
            if (t != null) {
                try { t.quitSafely(); } catch (Throwable ignored) {}
            }
        }

        final Context ctx = appContext;
        mainHandler.removeCallbacks(deadlineRunnable);
        mainHandler.post(() -> {
            cancelCountdown();
            helpers.setLogcatRunBoolean(false);
            helpers.setCountDownLogcat(0);

            if (message != null && ctx != null) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
            }
            StateListener l = listener;
            if (l != null) l.onLogcatStopped(success, message);
        });
    }

    private void killProcess() {
        Process p = logcatProcess;
        if (p == null) return;
        try { p.destroy(); } catch (Throwable ignored) {}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try { p.destroyForcibly(); } catch (Throwable ignored) {}
        }
    }

    private static int destroyAndWait(Process proc) {
        try { proc.destroy(); } catch (Throwable ignored) {}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try { proc.destroyForcibly(); } catch (Throwable ignored) {}
        }
        try { return proc.waitFor(); } catch (Throwable ignored) { return -1; }
    }

    // ---------------------------------------------------------------- countdown (UI state)

    private void startCountdown() {
        cancelCountdown();
        long remaining = getRemainingMillis();
        if (remaining <= 0L) return;

        countDownTimer = new CountDownTimer(remaining, 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                helpers.setCountDownLogcat((int) (millisUntilFinished / 1000L));
            }

            @Override
            public void onFinish() {
                helpers.setCountDownLogcat(0);
            }
        }.start();
    }

    private void cancelCountdown() {
        if (countDownTimer != null) {
            try { countDownTimer.cancel(); } catch (Throwable ignored) {}
            countDownTimer = null;
        }
    }

    // ---------------------------------------------------------------- helpers

    /** True when the stream was closed because we asked for it (timeout or stop button). */
    private boolean isShuttingDown() {
        return !running || System.currentTimeMillis() >= deadlineMs;
    }

    private String string(int resId) {
        Context ctx = appContext;
        return ctx != null ? ctx.getString(resId) : "";
    }

    private boolean shouldWriteAppLine(String line) {
        if (line == null) return false;
        if (line.contains("gralloc")) return false;
        if (line.contains("ResourcesManager")) return false;
        if (line.contains("OpenGLRenderer")) return false;
        if (line.contains("StrictMode")) return false;
        if (line.contains("Unisoc_Location")) return false;
        return true;
    }

    private static boolean lineHasPid(String threadtimeLine, int pid) {
        if (threadtimeLine == null) return false;
        return threadtimeLine.contains(" " + pid + " ") || threadtimeLine.contains(" " + pid + "  ");
    }

    private void writeLine(String s) throws Exception {
        if (fileWriter == null) return;
        fileWriter.write(s);
        fileWriter.write('\n');
    }

    private static void closeQuietly(java.io.Closeable c) {
        try { if (c != null) c.close(); } catch (Throwable ignored) {}
    }

    private static int parseIntSafe(String s, int fallback) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Throwable ignored) {
            return fallback;
        }
    }
}
