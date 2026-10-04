package com.android.launcher66.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.SystemProperties;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Captures this process' logcat output into a text file for a configurable amount of time.
 *
 * Design notes:
 *  - all lifecycle state (running / deadline) lives in this singleton, so leaving and re-entering
 *    the settings screen does not affect the capture and the UI can always re-read the real state;
 *  - the capture never depends on WRITE_EXTERNAL_STORAGE: it falls back to the app-specific
 *    external directory (and finally to internal storage) when the public Downloads folder is
 *    not writable;
 *  - a capture started before shared storage is mounted (the launcher starts that early at boot)
 *    begins in the fallback folder and is moved to Downloads as soon as Downloads can be written;
 *    files earlier runs had to leave there are moved over after the next capture in Downloads;
 *  - the file name comes from the clock at the start, which FYT often has wrong after boot and
 *    corrects only later: a capture never appends to an older file that got the same name, and
 *    its file is renamed to the real start time once the clock has been corrected;
 *  - the capture's own timing (timeout, retries) runs on elapsedRealtime(), so a clock correction
 *    during a capture neither ends it at once nor stalls it;
 *  - while a capture runs, a main thread that stops responding is reported with its stack, so
 *    the capture shows where the app is stuck (see watchMainThread());
 *  - with Keys.LOGCAT_FULL and Keys.BOOT_LOGCAT both on, the capture of a cold start (started
 *    with coldStart = true) holds everything from the start of the boot; logd then gets buffers
 *    big enough for that (see BOOT_LOG_BUFFER_SIZE), it reads them only once the apps started
 *    after the boot have settled (see BOOT_DUMP_SETTLE_MS), and other captures still start only
 *    a minute back;
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
    /** How often a capture waiting for public Downloads checks whether it can be written. */
    private static final long PUBLIC_DIR_RETRY_MS = 1000L;
    /** Failed copies into Downloads after which a capture stays where it is. */
    private static final int MAX_MOVE_FAILURES = 3;
    /**
     * How long the stop/deadline watchdog leaves the worker to report the result itself. Longer
     * than the time a last move into Downloads can take, so its toast (with the path) is not lost.
     */
    private static final long FINISH_WATCHDOG_MS = 5000L;
    /** File name format; the name is the capture's start time. */
    private static final String NAME_PATTERN = "dd-MM-yyyy_HH-mm-ss";
    /**
     * A file name counts as wrong only when it is further off the real start time than this, and
     * further than the capture's own length plus NAME_CLOCK_MARGIN_MS (see nameToleranceMs()).
     * The comparison is with the start time, so the length of the capture does not shift it; the
     * margins only keep ordinary clock adjustments from ever renaming a file.
     */
    private static final long NAME_CLOCK_MIN_TOLERANCE_MS = 10L * 60L * 1000L;
    private static final long NAME_CLOCK_MARGIN_MS = 5L * 60L * 1000L;
    /**
     * How long after a capture a clock correction still renames its file. FYT often sets the
     * time only once GPS has a fix, which can take minutes after boot.
     */
    private static final long NAME_FIX_WINDOW_MS = 30L * 60L * 1000L;
    /** The main thread counts as stuck when it has not run a posted task for this long. */
    private static final long MAIN_STALL_REPORT_MS = 2000L;
    private static final long MAIN_STALL_PING_MS = 500L;
    /** While it stays stuck, its stack is logged again this often, at most MAIN_STALL_MAX_REPORTS times. */
    private static final long MAIN_STALL_REPEAT_MS = 5000L;
    private static final int MAIN_STALL_MAX_REPORTS = 3;

    /*
     * Boot log (Keys.LOGCAT_FULL and Keys.BOOT_LOGCAT both on): the capture started at boot keeps
     * everything from the start of the boot. A full capture already reads every buffer from its
     * oldest line, but logd's default buffers only hold the last moment of a boot: in capture
     * 01-10-2026 20:38 "main" began at 20.6 s of uptime and "system" at 19 s, while "main" took
     * ~160 KB/s (325 KB/s at peak). So the boot log also gives logd buffers big enough. logd reads
     * their size when it starts, at boot: a change works from the next boot on.
     *
     * FYT sets the sizes itself, 128 KiB, also per buffer, and logd prefers a buffer's own
     * property (persist.logd.size.main) to the global one: with only persist.logd.size at 8M,
     * "radio" and "events" got 8 MiB but "main", "system" and "crash" kept 128 KiB (capture
     * 02-10-2026 00:38). So the per-buffer properties are set as well.
     */
    private static final String LOGD_SIZE_PROP = "persist.logd.size";
    private static final String[] LOGD_SIZE_PROPS = {
            LOGD_SIZE_PROP,
            LOGD_SIZE_PROP + ".main",
            LOGD_SIZE_PROP + ".system",
            LOGD_SIZE_PROP + ".crash",
            LOGD_SIZE_PROP + ".radio",
            LOGD_SIZE_PROP + ".events",
    };
    /** The buffers the boot log is about; see anyBufferBelowBootSize(). */
    private static final String[] BOOT_LOG_BUFFERS = {"main", "system", "crash", "radio", "events"};
    /** Per buffer: "main" then holds about 50 s of a boot. */
    private static final String BOOT_LOG_BUFFER_SIZE = "8M";
    private static final long BOOT_LOG_BUFFER_BYTES = 8L * 1024L * 1024L;
    /**
     * Each property's value before the boot log set it ("" = not set), restored when it is off;
     * this name plus the property's suffix (".main" ...). The global one keeps the plain name.
     */
    private static final String PREF_LOGD_SIZE_BEFORE = "logcat_boot_log_logd_size_before";
    /**
     * A cold-start capture holds everything since boot only when it starts within this uptime --
     * later its buffers could no longer reach back to the boot.
     */
    private static final long BOOT_CAPTURE_WINDOW_MS = 3L * 60L * 1000L;
    /**
     * With the large buffers, any other capture (after a wake, or by hand) begins only this far
     * back -- about what the default buffers used to hold -- instead of dumping megabytes of the
     * whole drive first.
     */
    private static final long LARGE_BUFFER_LOOKBACK_MS = 60L * 1000L;
    /*
     * The boot capture reads the buffers only after the apps started after BOOT_COMPLETED: reading
     * megabytes from logd, formatting and writing them costs CPU and disk time exactly while dozens
     * of processes start (~22-40 s of uptime), and the 8 MiB buffers keep the boot meanwhile. It
     * reads them BOOT_DUMP_SETTLE_MS after sys.boot_completed is seen, not before
     * BOOT_DUMP_EARLIEST_UPTIME_MS (the launcher's own deferred work runs at 45 s), and at
     * BOOT_DUMP_LATEST_UPTIME_MS at the latest, completed boot or not. Its time limit counts from
     * then, so a late boot does not leave it too little time to read everything.
     */
    private static final long BOOT_DUMP_SETTLE_MS = 20L * 1000L;
    private static final long BOOT_DUMP_EARLIEST_UPTIME_MS = 50L * 1000L;
    private static final long BOOT_DUMP_LATEST_UPTIME_MS = 120L * 1000L;
    private static final long BOOT_DUMP_POLL_MS = 500L;

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
    /** Ends the stall watch of an earlier capture when a new one starts. */
    private volatile int stallWatchGeneration;
    private final AtomicBoolean finished = new AtomicBoolean(true);

    private HandlerThread thread;
    private Handler handler;
    private SharedPreferences prefs;

    private volatile boolean running;
    /** In elapsedRealtime(), not the wall clock, which FYT corrects in the first minutes after boot. */
    private volatile long deadlineElapsedMs;
    private volatile Process logcatProcess;
    private volatile Context appContext;

    private BufferedWriter fileWriter;   // worker thread only
    private int timeoutSeconds;
    private volatile Mode mode = Mode.FROM_APP_START;
    /** Wall clock of the oldest line we want, 0 = no lower bound (whole buffer). */
    private volatile long captureSinceMs;

    private CountDownTimer countDownTimer; // main thread only
    private StateListener listener;        // main thread only

    /** A finished capture whose file name may still show a wrong clock; see fixNameForClock(). */
    private static final class NameCheck {
        File file;
        final long startElapsedMs;
        final long toleranceMs;
        final long untilElapsedMs;

        NameCheck(File file, long startElapsedMs, long toleranceMs) {
            this.file = file;
            this.startElapsedMs = startElapsedMs;
            this.toleranceMs = toleranceMs;
            this.untilElapsedMs = startElapsedMs + NAME_FIX_WINDOW_MS;
        }
    }

    /** Guarded by itself; also serialises renames with the moves of leftover files. */
    private final List<NameCheck> nameChecks = new ArrayList<>();
    private BroadcastReceiver clockReceiver; // main thread only

    private LogcatWorker() {}

    // ---------------------------------------------------------------- public API

    /** True while a capture is in progress. This is the single source of truth for the UI. */
    public boolean isActive() {
        return running;
    }

    /** Milliseconds left until the capture stops by itself, 0 when nothing is running. */
    public long getRemainingMillis() {
        if (!running) return 0L;
        return Math.max(0L, deadlineElapsedMs - SystemClock.elapsedRealtime());
    }

    public void setStateListener(StateListener l) {
        listener = l;
    }

    public void clearStateListener(StateListener l) {
        if (listener == l) listener = null;
    }

    /** Keeps the old behaviour: captures whatever the buffer holds, i.e. from application start. */
    public void start(Context context) {
        start(context, Mode.FROM_APP_START, false);
    }

    public void start(Context context, boolean coldStart) {
        start(context, Mode.FROM_APP_START, coldStart);
    }

    public void start(Context context, Mode captureMode) {
        start(context, captureMode, false);
    }

    public void start(Context context, Mode captureMode, boolean coldStart) {
        final Context ctx = context.getApplicationContext();
        final Mode requestedMode = captureMode != null ? captureMode : Mode.FROM_APP_START;

        synchronized (lock) {
            if (running) {
                Log.w(TAG, "start() ignored - already running");
                return;
            }

            mode = requestedMode;
            captureSinceMs = (requestedMode == Mode.FROM_NOW) ? System.currentTimeMillis() : 0L;

            prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            timeoutSeconds = parseIntSafe(prefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT,
                    String.valueOf(DEFAULT_TIMEOUT_SECONDS)));
            if (timeoutSeconds <= 0) timeoutSeconds = DEFAULT_TIMEOUT_SECONDS;

            appContext = ctx;
            deadlineElapsedMs = SystemClock.elapsedRealtime() + timeoutSeconds * 1000L;
            running = true;
            finished.set(false);

            thread = new HandlerThread("LogcatWorker");
            thread.start();
            handler = new Handler(thread.getLooper());
            handler.post(() -> runLogging(ctx, coldStart));
            watchMainThread();
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
                showToast ? string(R.string.logcat_service_run_toast) : null), FINISH_WATCHDOG_MS);
    }

    public void stop() {
        stop(false, null);
    }

    // ---------------------------------------------------------------- capture

    private void runLogging(Context ctx, boolean coldStart) {
        final int myPid = android.os.Process.myPid();
        Log.i(TAG, "runLogging entered pid=" + myPid);

        BufferedReader reader = null;
        Process proc = null;
        File logFile = null;
        String error = null;
        long linesWritten = 0L;
        // True while the file is in the fallback folder only because public Downloads could not be
        // written yet. At boot the launcher starts before shared storage is mounted; the capture
        // then used to stay in the app's own folder for good, with Download/Launcher66_Logs empty.
        boolean waitingForPublic = false;
        long nextPublicCheckMs = 0L;
        int moveFailures = 0;
        // When the file name was taken, on the monotonic clock: the real start time can be worked
        // out from it once the wall clock has been corrected.
        long startElapsedMs = 0L;

        try {
            File dir = usablePublicDir(ctx);
            if (dir == null) {
                waitingForPublic = mayUsePublicStorage(ctx);
                dir = resolveFallbackDir(ctx);
            }
            if (dir == null) {
                error = "Cannot create a writable log directory";
                Log.e(TAG, error);
                return;
            }
            if (waitingForPublic) {
                Log.w(TAG, "Public Downloads not writable yet (storage " + externalStorageState()
                        + "), capturing to " + dir + " until it is");
            }

            startElapsedMs = SystemClock.elapsedRealtime();
            String timestamp = new SimpleDateFormat(NAME_PATTERN, Locale.getDefault())
                    .format(new Date());
            // A new file every time, never appended to: FYT often boots with the same wrong clock,
            // and captures of two different boots then got the same name and ended up in one file.
            logFile = uniqueFile(dir, timestamp + LOG_FILE_SUFFIX);
            Log.i(TAG, "Opening log file: " + logFile.getAbsolutePath());

            fileWriter = new BufferedWriter(new FileWriter(logFile, false), 8192);
            writeLine("===== STREAM (PID=" + myPid + ", buffer=" + STREAM_BUFFER
                    + ", timeout=" + timeoutSeconds + "s, mode=" + mode + ") =====");
            writeLine("===== device=" + Build.MANUFACTURER + " " + Build.MODEL
                    + ", android=" + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ") =====");
            fileWriter.flush();

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            }
            boolean fullLog = false;
            boolean bootLog = false;
            if (LauncherApplication.hasSystemPrivileges()) {
                fullLog = prefs.getBoolean(Keys.LOGCAT_FULL, false);
                // The boot log setting: only with both settings on.
                bootLog = fullLog && prefs.getBoolean(Keys.BOOT_LOGCAT, false);
            }
            // On every capture, cold start or not: the buffers follow the setting. Tied to
            // coldStart, a capture after a wake would give the large buffers back (the next boot
            // then had small ones again) and dump all 8 MiB of them (see captureStartMs()).
            syncLogdBufferSize(bootLog);
            // Everything since boot only in the capture of a cold start.
            boolean fromBoot = isBootCapture(bootLog, coldStart, mode, SystemClock.elapsedRealtime());

            // "--pid" exists since Android 7.0; when it is not available we filter by hand.
            boolean usePidFlag = !fullLog;
            // "-T <time>" makes logcat skip everything older than the given timestamp. If the
            // build does not understand it we drop back to comparing timestamps ourselves.
            boolean useSinceFlag = true;
            long sinceMs = captureStartMs(bootLog, fromBoot, captureSinceMs, System.currentTimeMillis());
            if (fromBoot) {
                writeLine("===== boot log: everything logd still holds since boot ("
                        + LOGD_SIZE_PROP + "=" + displaySize(currentLogdSize()) + "), read once the"
                        + " apps started after the boot have settled =====");
                fileWriter.flush();
                long completedSeenAt = waitForBootToSettle();
                if (completedSeenAt < 0L) return; // stopped while waiting; finally reports it
                writeLine("===== reading at " + SystemClock.elapsedRealtime() / 1000L + " s of uptime ("
                        + (completedSeenAt > 0L ? "boot completed by " + completedSeenAt / 1000L + " s"
                                                : "boot not completed") + ") =====");
                for (String sizeLine : runForOutput("logcat", "-b", "all", "-g")) {
                    writeLine("===== " + sizeLine.trim() + " =====");
                }
                fileWriter.flush();
                restartDeadline();
            }
            SimpleDateFormat lineFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
            int restartCount = 0;

            while (running && SystemClock.elapsedRealtime() < deadlineElapsedMs) {
                restartCount++;
                boolean sinceFlagThisRun = useSinceFlag && sinceMs > 0L;
                writeLine("----- logcat start #" + restartCount
                        + " (pidFlag=" + usePidFlag + ", sinceFlag=" + sinceFlagThisRun + ") -----");
                fileWriter.flush();

                proc = startLogcat(myPid, usePidFlag, sinceFlagThisRun ? sinceMs : 0L, lineFormat, fullLog);
                logcatProcess = proc;

                reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line;
                long linesThisRun = 0L;
                try {
                    while (running && (line = reader.readLine()) != null) {
                        long now = SystemClock.elapsedRealtime();
                        if (now >= deadlineElapsedMs) break;
                        if (waitingForPublic && now >= nextPublicCheckMs) {
                            nextPublicCheckMs = now + PUBLIC_DIR_RETRY_MS;
                            try {
                                File moved = moveCaptureToPublic(ctx, logFile);
                                if (moved != null) {
                                    logFile = moved;
                                    waitingForPublic = false;
                                }
                            } catch (IOException moveError) {
                                Log.w(TAG, "Moving the log file to Downloads failed: " + moveError);
                                if (++moveFailures >= MAX_MOVE_FAILURES) {
                                    waitingForPublic = false;   // stays where it is
                                }
                            }
                        }
                        if (!fullLog && !usePidFlag && !lineHasPid(line, myPid)) continue;
                        if (!sinceFlagThisRun && sinceMs > 0L && isOlderThan(lineFormat, line, sinceMs)) continue;
                        if (!fullLog && !shouldWriteAppLine(line)) continue;

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

                if (!running || SystemClock.elapsedRealtime() >= deadlineElapsedMs) break;

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

            if (fileWriter != null) {
                try {
                    fileWriter.write("===== END, lines=" + linesWritten + " =====\n");
                    fileWriter.flush();
                } catch (Throwable ignored) {
                    // the capture written so far is kept
                } finally {
                    // A step of its own: a failed END line (storage full) left the file open.
                    closeQuietly(fileWriter);
                }
            }
            fileWriter = null;

            if (waitingForPublic && logFile != null && logFile.exists()) {
                // Last try, for a log that went quiet before shared storage came up.
                File pubDir = usablePublicDir(ctx);
                File moved = pubDir != null ? moveFileInto(logFile, pubDir) : null;
                if (moved != null) {
                    logFile = moved;
                    waitingForPublic = false;
                }
            }

            if (logFile != null && logFile.exists() && startElapsedMs > 0L) {
                // Right now if the clock has already been corrected (the toast then shows the
                // right name), otherwise as soon as it is.
                long toleranceMs = nameToleranceMs();
                logFile = fixNameForClock(logFile, startElapsedMs, toleranceMs);
                watchClockFor(logFile, startElapsedMs, toleranceMs);
            }

            boolean success = error == null && logFile != null && logFile.exists();
            String message = success
                    ? string(R.string.logcat_service_run_toast) + "\n" + logFile.getAbsolutePath()
                    : "Logcat: " + (error != null ? error : "no log file was created");

            Log.i(TAG, "runLogging finished success=" + success + " lines=" + linesWritten);
            finishOnce(success, message);

            // After the toast: bring over what earlier captures had to leave in the app's own
            // folder (every capture started at boot so far).
            if (success && isPublicDir(logFile.getParentFile())) {
                moveLeftoversInto(ctx, logFile.getParentFile(), logFile);
            }
        }
    }

    // ---------------------------------------------------------------- boot log

    /**
     * Whether this capture keeps the whole buffers, i.e. everything since boot: the capture of a
     * cold start, from application start, early enough for the buffers to reach back to the boot.
     */
    static boolean isBootCapture(boolean bootLog, boolean coldStart, Mode captureMode, long elapsedRealtimeMs) {
        return bootLog && coldStart && captureMode == Mode.FROM_APP_START
                && elapsedRealtimeMs < BOOT_CAPTURE_WINDOW_MS;
    }

    /**
     * Waits until the boot capture should read the buffers (see BOOT_DUMP_SETTLE_MS). Meanwhile
     * the capture's time limit is held at its full length: the hard stop and the countdown are
     * off, and getRemainingMillis() keeps reporting the whole capture. Returns the uptime at which
     * sys.boot_completed was seen (0 = not by the latest moment), or -1 if the capture was stopped.
     */
    private long waitForBootToSettle() {
        deadlineElapsedMs = SystemClock.elapsedRealtime() + timeoutSeconds * 1000L;
        mainHandler.post(() -> {
            mainHandler.removeCallbacks(deadlineRunnable);
            cancelCountdown();
            if (running) helpers.setCountDownLogcat(timeoutSeconds);
        });
        long completedSeenAt = 0L;
        while (running) {
            long now = SystemClock.elapsedRealtime();
            deadlineElapsedMs = now + timeoutSeconds * 1000L;
            if (completedSeenAt == 0L && "1".equals(SystemProperties.get("sys.boot_completed", ""))) {
                completedSeenAt = now;
            }
            if (bootDumpDue(now, completedSeenAt)) return completedSeenAt;
            try {
                Thread.sleep(BOOT_DUMP_POLL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // shutting down
                return -1L;
            }
        }
        return -1L;
    }

    /** Whether the boot capture should read the buffers now (uptimes in ms; 0 = not completed yet). */
    static boolean bootDumpDue(long nowMs, long completedSeenAtMs) {
        if (nowMs >= BOOT_DUMP_LATEST_UPTIME_MS) return true;
        return completedSeenAtMs > 0L
                && nowMs >= Math.max(completedSeenAtMs + BOOT_DUMP_SETTLE_MS, BOOT_DUMP_EARLIEST_UPTIME_MS);
    }

    /** The capture's time limit counts from now: the boot capture starts reading only after its wait. */
    private void restartDeadline() {
        deadlineElapsedMs = SystemClock.elapsedRealtime() + timeoutSeconds * 1000L;
        mainHandler.post(() -> {
            mainHandler.removeCallbacks(deadlineRunnable);
            if (!running) return;
            mainHandler.postDelayed(deadlineRunnable, timeoutSeconds * 1000L);
            startCountdown();
        });
    }

    /**
     * Wall clock of the oldest line wanted, 0 = the whole buffers. With the boot log's large
     * buffers, a capture other than the boot one that would take the whole buffers starts
     * LARGE_BUFFER_LOOKBACK_MS back instead; "from now" captures keep their own start.
     */
    static long captureStartMs(boolean bootLog, boolean fromBoot, long requestedSinceMs, long nowMs) {
        if (bootLog && !fromBoot && requestedSinceMs == 0L) {
            return nowMs - LARGE_BUFFER_LOOKBACK_MS;
        }
        return requestedSinceMs;
    }

    /**
     * Gives logd the buffers the boot log needs, or gives back the sizes it had before. Runs at
     * the start of every capture, on the worker thread; any failure only leaves sizes as they were.
     */
    private void syncLogdBufferSize(boolean bootLog) {
        try {
            if (bootLog) {
                List<String> changed = new ArrayList<>();
                boolean failed = false;
                for (String prop : LOGD_SIZE_PROPS) {
                    String current = logdProp(prop);
                    if (BOOT_LOG_BUFFER_SIZE.equals(current)) continue;
                    String key = beforeKey(prop);
                    if (!prefs.contains(key)) {
                        prefs.edit().putString(key, current).apply();
                    }
                    if (runQuietly("setprop", prop, BOOT_LOG_BUFFER_SIZE)) {
                        changed.add(prop + " " + displaySize(current));
                    } else {
                        failed = true;
                    }
                }
                // What logd read at its start stays until the next boot: anything still smaller now
                // is resized at once, for the rest of this session.
                boolean resized = false;
                if (!changed.isEmpty() || anyBufferBelowBootSize()) {
                    resized = runQuietly("logcat", "-b", "all", "-G", BOOT_LOG_BUFFER_SIZE);
                }
                if (!changed.isEmpty() || resized || failed) {
                    Log.i(TAG, "Boot log: logd buffers -> " + BOOT_LOG_BUFFER_SIZE
                            + (changed.isEmpty() ? "" : " (was: " + changed + ")")
                            + (resized ? ", resized now" : "") + (failed ? ", setprop failed" : "")
                            + "; the start of a boot is kept from the next boot on");
                }
            } else {
                List<String> restored = new ArrayList<>();
                for (String prop : LOGD_SIZE_PROPS) {
                    String key = beforeKey(prop);
                    if (!prefs.contains(key)) continue;
                    String before = prefs.getString(key, "");
                    // Only if it is still the boot log's size: a size set since by someone else stays.
                    if (BOOT_LOG_BUFFER_SIZE.equals(logdProp(prop))) {
                        runQuietly("setprop", prop, before); // "" removes the property
                        restored.add(prop + " " + displaySize(before));
                    }
                    prefs.edit().remove(key).apply();
                }
                if (!restored.isEmpty()) {
                    Log.i(TAG, "Boot log off: logd buffers back to " + restored + " from the next boot on");
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "logd buffer size not changed", t);
        }
    }

    private static String beforeKey(String prop) {
        return PREF_LOGD_SIZE_BEFORE + prop.substring(LOGD_SIZE_PROP.length());
    }

    private static String logdProp(String prop) {
        String value = SystemProperties.get(prop, "");
        return value != null ? value.trim() : "";
    }

    /** Whether logd reports any of BOOT_LOG_BUFFERS smaller than BOOT_LOG_BUFFER_SIZE right now. */
    private static boolean anyBufferBelowBootSize() {
        for (String line : runForOutput("logcat", "-b", "all", "-g")) {
            String l = line.trim();
            for (String buffer : BOOT_LOG_BUFFERS) {
                if (!l.startsWith(buffer + ":")) continue;
                long bytes = ringBufferBytes(l);
                if (bytes >= 0L && bytes < BOOT_LOG_BUFFER_BYTES) return true;
            }
        }
        return false;
    }

    /** "main: ring buffer is 128 KiB (122 KiB consumed) ..." -> 131072; -1 if not understood. */
    static long ringBufferBytes(String line) {
        java.util.regex.Matcher m = java.util.regex.Pattern
                .compile("ring buffer is\\s*(\\d+(?:\\.\\d+)?)\\s*([KMG]?)i?B", java.util.regex.Pattern.CASE_INSENSITIVE)
                .matcher(line);
        if (!m.find()) return -1L;
        double value = Double.parseDouble(m.group(1));
        switch (m.group(2).toUpperCase(Locale.US)) {
            case "K": return (long) (value * 1024L);
            case "M": return (long) (value * 1024L * 1024L);
            case "G": return (long) (value * 1024L * 1024L * 1024L);
            default: return (long) value;
        }
    }

    private static String currentLogdSize() {
        String size = SystemProperties.get(LOGD_SIZE_PROP, "");
        return size != null ? size.trim() : "";
    }

    private static String displaySize(String size) {
        return size == null || size.isEmpty() ? "default" : size;
    }

    /** Runs a short command, 3 s at most; true when it exited with 0. */
    private static boolean runQuietly(String... cmd) {
        return runCommand(cmd, null) == 0;
    }

    /** The output of a short command (3 s at most); empty when it fails. */
    private static List<String> runForOutput(String... cmd) {
        List<String> out = new ArrayList<>();
        if (runCommand(cmd, out) != 0) out.clear();
        return out;
    }

    /** Exit code of the command, -1 on any failure or after 3 s; its output goes to output. */
    private static int runCommand(String[] cmd, List<String> output) {
        Process proc = null;
        try {
            proc = new ProcessBuilder(cmd).redirectErrorStream(true).start();
            // These commands print a few lines at most, which fit the pipe: waiting first cannot
            // block on a full pipe, and a command that hangs costs 3 s, not the capture.
            if (!proc.waitFor(3L, TimeUnit.SECONDS)) return -1;
            if (output != null) {
                try (BufferedReader r = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
                    String line;
                    while ((line = r.readLine()) != null && output.size() < 50) {
                        if (!line.trim().isEmpty()) output.add(line);
                    }
                }
            }
            return proc.exitValue();
        } catch (Throwable t) {
            return -1;
        } finally {
            if (proc != null) destroyAndWait(proc);
        }
    }

    private Process startLogcat(int pid, boolean usePidFlag, long sinceMs, SimpleDateFormat fmt, boolean fullLog)
            throws Exception {
        List<String> cmd = new ArrayList<>();
        cmd.add("logcat");
        if (fullLog) {
            cmd.add("-b");
            cmd.add("all");
        } else {
            cmd.add("-b");
            cmd.add(STREAM_BUFFER);
        }
        cmd.add("-v");
        cmd.add("threadtime");
        if (!fullLog && usePidFlag) {
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

    /** Public Downloads/Launcher66_Logs when it can be written right now, otherwise null. */
    private static File usablePublicDir(Context ctx) {
        try {
            if (!mayUsePublicStorage(ctx)) return null;
            if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) return null;
            File pub = publicLogDir();
            return isUsable(pub) ? pub : null;
        } catch (Throwable t) {
            Log.w(TAG, "Public Downloads check failed: " + t);
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    private static File publicLogDir() {
        return new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                LOG_DIR_NAME);
    }

    private static boolean isPublicDir(File dir) {
        try {
            return dir != null && dir.getCanonicalFile().equals(publicLogDir().getCanonicalFile());
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * Whether public Downloads may be used at all, mounted or not. When it may not, the capture
     * stays in the fallback folder and nothing waits for Downloads.
     */
    private static boolean mayUsePublicStorage(Context ctx) {
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

    /**
     * The app-specific external folder, or internal storage when that is not available either
     * (as at boot, before shared storage is mounted). Neither needs a runtime permission.
     */
    private static File resolveFallbackDir(Context ctx) {
        File ext = null;
        try {
            ext = ctx.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        } catch (Throwable t) {
            Log.w(TAG, "App-specific external folder not available: " + t);
        }
        if (ext != null) {
            File dir = new File(ext, LOG_DIR_NAME);
            if (isUsable(dir)) return dir;
        }
        File internal = new File(ctx.getFilesDir(), LOG_DIR_NAME);
        return isUsable(internal) ? internal : null;
    }

    private static String externalStorageState() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable t) {
            return "unknown";
        }
    }

    /**
     * Moves the capture in progress into public Downloads once that can be written. Returns the
     * new file, or null while Downloads is still unavailable. The copy is made first and the
     * writer switches only once it is open on the copy, so a failure leaves the capture where it
     * was. Worker thread only.
     */
    private File moveCaptureToPublic(Context ctx, File current) throws IOException {
        File pubDir = usablePublicDir(ctx);
        if (pubDir == null) return null;

        fileWriter.flush();
        File target = uniqueFile(pubDir, current.getName());
        copyFile(current, target);
        BufferedWriter movedWriter = null;
        try {
            movedWriter = new BufferedWriter(new FileWriter(target, true), 8192);
            movedWriter.write("----- moved here from " + current.getAbsolutePath()
                    + " when shared storage became writable -----\n");
        } catch (IOException e) {
            closeQuietly(movedWriter);
            //noinspection ResultOfMethodCallIgnored
            target.delete();
            throw e;
        }
        closeQuietly(fileWriter);
        fileWriter = movedWriter;
        if (!current.delete()) Log.w(TAG, "Could not delete " + current + " after copying it");
        Log.i(TAG, "Log file moved to " + target.getAbsolutePath());
        return target;
    }

    /** Copies a closed file into dir under a free name and deletes it. Null on failure. */
    private static File moveFileInto(File file, File dir) {
        File target = uniqueFile(dir, file.getName());
        try {
            copyFile(file, target);
        } catch (IOException e) {
            Log.w(TAG, "Could not move " + file + " to " + dir + ": " + e);
            return null;
        }
        if (!file.delete()) Log.w(TAG, "Could not delete " + file + " after copying it");
        Log.i(TAG, "Log file moved to " + target.getAbsolutePath());
        return target;
    }

    /** Moves captures left in the fallback folders by earlier runs into dir. */
    private void moveLeftoversInto(Context ctx, File dir, File skip) {
        List<File> folders = new ArrayList<>();
        folders.add(new File(ctx.getFilesDir(), LOG_DIR_NAME));
        try {
            File ext = ctx.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (ext != null) folders.add(new File(ext, LOG_DIR_NAME));
        } catch (Throwable ignored) {}

        for (File folder : folders) {
            File[] files = folder.listFiles((d, name) -> name.endsWith(LOG_FILE_SUFFIX));
            if (files == null) continue;
            for (File f : files) {
                if (f.equals(skip)) continue;
                synchronized (nameChecks) {
                    File moved = moveFileInto(f, dir);
                    if (moved != null) {
                        for (NameCheck c : nameChecks) {
                            if (c.file.equals(f)) c.file = moved;
                        }
                    }
                }
            }
        }
    }

    private static File uniqueFile(File dir, String name) {
        File f = new File(dir, name);
        if (!f.exists()) return f;
        int dot = name.lastIndexOf('.');
        String base = dot > 0 ? name.substring(0, dot) : name;
        String ext = dot > 0 ? name.substring(dot) : "";
        for (int i = 1; ; i++) {
            f = new File(dir, base + "_" + i + ext);
            if (!f.exists()) return f;
        }
    }

    /** Copies from into to; a partial copy is deleted. */
    private static void copyFile(File from, File to) throws IOException {
        boolean done = false;
        try {
            try (FileInputStream in = new FileInputStream(from);
                 FileOutputStream out = new FileOutputStream(to)) {
                byte[] buffer = new byte[64 * 1024];
                int n;
                while ((n = in.read(buffer)) != -1) out.write(buffer, 0, n);
            }
            done = true;   // only once both streams are closed
        } finally {
            if (!done) {
                //noinspection ResultOfMethodCallIgnored
                to.delete();
            }
        }
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

    // ---------------------------------------------------------------- file name vs. clock

    /** At least 10 minutes, and at least the capture's length plus 5 minutes. */
    private long nameToleranceMs() {
        return Math.max(NAME_CLOCK_MIN_TOLERANCE_MS, timeoutSeconds * 1000L + NAME_CLOCK_MARGIN_MS);
    }

    /**
     * Renames a finished capture whose name is more than toleranceMs off its real start time,
     * which happens when the clock was still wrong when it started. The real start is
     * worked out from the monotonic clock, so it is right as soon as the wall clock is. The
     * comparison is done in the current time zone, so a zone set only later is fixed as well.
     * Returns the file under its current (possibly new) name.
     */
    private static File fixNameForClock(File file, long startElapsedMs, long toleranceMs) {
        String name = file.getName();
        if (name.length() < NAME_PATTERN.length()) return file;
        SimpleDateFormat fmt = new SimpleDateFormat(NAME_PATTERN, Locale.getDefault());
        fmt.setLenient(false);
        long shownMs;
        try {
            Date shown = fmt.parse(name.substring(0, NAME_PATTERN.length()));
            if (shown == null) return file;
            shownMs = shown.getTime();
        } catch (ParseException e) {
            return file;   // not a name this class gave
        }

        long realStartMs = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - startElapsedMs);
        long offBy = realStartMs - shownMs;
        if (Math.abs(offBy) <= toleranceMs) return file;

        File dir = file.getParentFile();
        File target = uniqueFile(dir, fmt.format(new Date(realStartMs)) + LOG_FILE_SUFFIX);
        if (!file.renameTo(target)) {
            Log.w(TAG, "Could not rename " + file + " to " + target.getName());
            return file;
        }
        String offset = describeOffset(offBy);
        appendNote(target, "===== renamed from " + name + ": the clock was " + offset
                + " when this capture started; times logged before it was corrected are off"
                + " by the same amount =====");
        Log.i(TAG, "Log file renamed to " + target.getName() + " (clock was " + offset + ")");
        return target;
    }

    /** Re-checks the name of a finished capture whenever the time or time zone is set. */
    private void watchClockFor(File file, long startElapsedMs, long toleranceMs) {
        NameCheck check = new NameCheck(file, startElapsedMs, toleranceMs);
        long remaining = check.untilElapsedMs - SystemClock.elapsedRealtime();
        if (remaining <= 0L) return;
        synchronized (nameChecks) {
            nameChecks.add(check);
        }
        mainHandler.post(this::ensureClockReceiver);
        mainHandler.postDelayed(this::dropExpiredNameChecks, remaining + 1000L);
    }

    private void ensureClockReceiver() {   // main thread
        Context ctx = appContext;
        if (clockReceiver != null || ctx == null) return;
        clockReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "Clock changed (" + intent.getAction() + "), checking log file names");
                // Off the main thread: renaming touches the storage.
                new Thread(LogcatWorker.this::fixPendingNames, "LogcatWorker-names").start();
            }
        };
        IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        try {
            ctx.registerReceiver(clockReceiver, filter);
        } catch (Throwable t) {
            Log.w(TAG, "Cannot listen for clock changes: " + t);
            clockReceiver = null;
        }
    }

    private void fixPendingNames() {
        synchronized (nameChecks) {
            long now = SystemClock.elapsedRealtime();
            for (Iterator<NameCheck> it = nameChecks.iterator(); it.hasNext(); ) {
                NameCheck c = it.next();
                if (now >= c.untilElapsedMs || !c.file.exists()) {
                    it.remove();
                    continue;
                }
                c.file = fixNameForClock(c.file, c.startElapsedMs, c.toleranceMs);
            }
        }
    }

    private void dropExpiredNameChecks() {   // main thread
        synchronized (nameChecks) {
            long now = SystemClock.elapsedRealtime();
            for (Iterator<NameCheck> it = nameChecks.iterator(); it.hasNext(); ) {
                if (now >= it.next().untilElapsedMs) it.remove();
            }
            if (!nameChecks.isEmpty()) return;
        }
        Context ctx = appContext;
        if (clockReceiver != null && ctx != null) {
            try {
                ctx.unregisterReceiver(clockReceiver);
            } catch (IllegalArgumentException ignored) {}
        }
        clockReceiver = null;
    }

    private static void appendNote(File file, String note) {
        try (FileWriter w = new FileWriter(file, true)) {
            w.write(note);
            w.write('\n');
        } catch (IOException e) {
            Log.w(TAG, "Could not add a note to " + file + ": " + e);
        }
    }

    /** "behind by 659d 03:40:52" for a clock that showed an earlier time than the real one. */
    private static String describeOffset(long offByMs) {
        long abs = Math.abs(offByMs);
        long days = abs / 86_400_000L;
        long rest = abs % 86_400_000L;
        String hms = String.format(Locale.US, "%02d:%02d:%02d",
                rest / 3_600_000L, (rest / 60_000L) % 60L, (rest / 1000L) % 60L);
        return (offByMs > 0 ? "behind by " : "ahead by ") + (days > 0 ? days + "d " : "") + hms;
    }

    // ---------------------------------------------------------------- main thread stalls

    /**
     * While the capture runs, logs the main thread's stack whenever a task posted to it has not
     * run for MAIN_STALL_REPORT_MS, and how long the stall lasted once it has. At boot this ROM's
     * audioserver hangs and is restarted (TimeCheck on IAudioFlinger), and any audio call then
     * blocks for about ten seconds; this shows which call it was.
     *
     * A new ping is posted only once the previous one has run. The old loop took a waiting ping
     * out and posted it again every MAIN_STALL_PING_MS, which sent it to the back of the queue
     * each time: a main thread that was only busy (a long run of short tasks, as at a launcher
     * start building its panes) never got to it and was reported as not responding.
     *
     * From the moment the ping is late, the thread's stack is sampled every MAIN_STALL_PING_MS.
     * The report says "blocked" when every sample shows the same place (that stack is the
     * culprit) and "busy" when they differ (a run of work, which Choreographer's skipped frames
     * report as well).
     */
    private void watchMainThread() {
        final int generation = ++stallWatchGeneration;
        final Thread mainThread = Looper.getMainLooper().getThread();
        final AtomicLong lastPong = new AtomicLong(SystemClock.uptimeMillis());
        final AtomicBoolean pongPending = new AtomicBoolean(false);
        final Runnable pong = () -> {
            lastPong.set(SystemClock.uptimeMillis());
            pongPending.set(false);
        };
        Thread watcher = new Thread(() -> {
            long stallStart = 0L;
            long lastReport = 0L;
            int reports = 0;
            String lastStack = null;
            int samples = 0;
            int places = 0;
            while (running && generation == stallWatchGeneration) {
                if (pongPending.compareAndSet(false, true)) {
                    mainHandler.post(pong);
                }
                try {
                    Thread.sleep(MAIN_STALL_PING_MS);
                } catch (InterruptedException e) {
                    return;
                }
                long now = SystemClock.uptimeMillis();
                long last = lastPong.get();
                long waited = now - last;
                if (waited >= 2 * MAIN_STALL_PING_MS) {
                    // The ping is late: note where the thread is.
                    String stack = formatStack(mainThread.getStackTrace());
                    samples++;
                    if (!stack.equals(lastStack)) {
                        places++;
                        lastStack = stack;
                    }
                } else {
                    samples = 0;
                    places = 0;
                    lastStack = null;
                }
                if (waited >= MAIN_STALL_REPORT_MS) {
                    if (stallStart == 0L) {
                        stallStart = last;
                        reports = 0;
                        lastReport = 0L;
                    }
                    if (reports < MAIN_STALL_MAX_REPORTS && (reports == 0 || now - lastReport >= MAIN_STALL_REPEAT_MS)) {
                        reports++;
                        lastReport = now;
                        String state = places <= 1
                                ? "blocked in one place (" + samples + " samples)"
                                : "busy, " + places + " different places in " + samples + " samples";
                        Log.w(TAG, "Main thread not responding for " + waited + " ms, " + state
                                + ", it is at:" + lastStack);
                    }
                } else if (stallStart != 0L) {
                    Log.w(TAG, "Main thread responding again after " + (last - stallStart) + " ms");
                    stallStart = 0L;
                }
            }
        }, "LogcatWorker-stall");
        watcher.setDaemon(true);
        watcher.start();
    }

    private static String formatStack(StackTraceElement[] stack) {
        StringBuilder sb = new StringBuilder();
        int shown = Math.min(stack.length, 30);
        for (int i = 0; i < shown; i++) {
            sb.append("\n    at ").append(stack[i]);
        }
        if (stack.length > shown) {
            sb.append("\n    ... ").append(stack.length - shown).append(" more");
        }
        return sb.toString();
    }

    // ---------------------------------------------------------------- teardown

    private final Runnable deadlineRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "deadline reached");
            running = false;
            killProcess(); // unblocks readLine() so runLogging() can finish and report
            mainHandler.postDelayed(() -> finishOnce(false, null), FINISH_WATCHDOG_MS);
        }
    };

    private void finishOnce(boolean success, String message) {
        if (!finished.compareAndSet(false, true)) return;

        running = false;
        deadlineElapsedMs = 0L;

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
        try { p.destroyForcibly(); } catch (Throwable ignored) {}
    }

    private static int destroyAndWait(Process proc) {
        try { proc.destroy(); } catch (Throwable ignored) {}
        try { proc.destroyForcibly(); } catch (Throwable ignored) {}
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
        return !running || SystemClock.elapsedRealtime() >= deadlineElapsedMs;
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
        return !line.contains("Unisoc_Location");
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

    private static int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Throwable ignored) {
            return LogcatWorker.DEFAULT_TIMEOUT_SECONDS;
        }
    }
}
