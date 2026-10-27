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
import com.syu.util.HostAwait;
import com.syu.util.WindowHostVdClient;

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
 *  - the file name is what started the capture, what it holds and the clock at the start
 *    (reboot_full_27-10-2026_21-51-41.txt, see LogFileName). The scope changes from pid to full
 *    when the VD host attaches during the capture, and the file is renamed then. A capture that a
 *    wake extends keeps the name of its own trigger; the wake is a line in its text. A late full
 *    dump ends in _late.txt. The clock is what FYT often has wrong after boot and corrects only
 *    later: a capture never appends to an older file that got the same name, and its file is
 *    renamed to the real start time once the clock has been corrected, the prefix kept;
 *  - the capture's own timing (timeout, retries) runs on elapsedRealtime(), so a clock correction
 *    during a capture neither ends it at once nor stalls it;
 *  - while a capture runs, a main thread that stops responding is reported with its stack, so
 *    the capture shows where the app is stuck (see watchMainThread());
 *  - with Keys.LOGCAT_FULL and Keys.BOOT_LOGCAT both on, the capture of a cold start (started
 *    with coldStart = true) holds everything from the start of the boot; logd then gets buffers
 *    big enough for that (see BOOT_LOG_BUFFER_SIZE), and other captures still start only a
 *    minute back;
 *  - the time limit counts from the start (the launcher's, for the capture at startup), and its
 *    end, like the stop button, only sets the moment the capture ends at: what logcat has not
 *    read yet up to then (the boot log takes a while) is still read and written, see beginDrain();
 *  - "log everything" without system privileges reads through the VD host (root or Shizuku). When
 *    that host is not there yet but on its way (HostAwait.isExpected(): Shizuku installed, which
 *    on the 7870 starts minutes after the launcher or by hand) the capture does not wait for it:
 *    it reads the launcher's own log at once and switches to everything, from its start, when
 *    the host attaches; a capture that ends before it is followed by a late full dump in a file of
 *    its own (see startPlan(), upgradeToHost() and runLateDump());
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

    /** What started the capture: how long it waits for a VD host that is on its way (see hostWaitMs()). */
    public enum Trigger {
        /** The launcher's first start after a device restart. */
        COLD_START("cold start", "reboot"),
        /** Any other start of the process (crash, update). */
        PROCESS_START("process start", "start"),
        WAKE("wake", "wake"),
        /** The run button in the settings. */
        MANUAL("manual", "user");

        final String label;
        /** The word that starts the capture's file name, see LogFileName. */
        final String fileLabel;

        Trigger(String label, String fileLabel) {
            this.label = label;
            this.fileLabel = fileLabel;
        }
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
     * Ending a capture (time limit or stop button) keeps reading until logcat has caught up with
     * that moment: a line newer than it, or DRAIN_IDLE_MS without any line (it waits for new ones
     * then). Reading the boot log's buffers takes a while -- about 85 000 lines in 30 s through the
     * VD host -- and killing logcat at the stop left only the start of the boot in the file.
     * DRAIN_MAX_MS bounds it if logcat never catches up (a clock set back while it reads).
     */
    private static final long DRAIN_IDLE_MS = 1500L;
    private static final long DRAIN_MAX_MS = 120_000L;
    private static final long DRAIN_POLL_MS = 250L;
    /**
     * A line further after the end than this is not taken as logcat having caught up: FYT may
     * boot with a clock ahead and set it back later, and those boot lines come first.
     */
    private static final long DRAIN_CLOCK_JUMP_MS = 10L * 60L * 1000L;

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
    /** The capture has ended (time limit or stop) and is reading what it still owes; see beginDrain(). */
    private volatile boolean draining;
    /** Wall clock of the end: lines after it are not written. */
    private volatile long cutoffWallMs;
    private volatile long drainStartedElapsedMs;
    /** When logcat last gave a line, while draining: no line for DRAIN_IDLE_MS means caught up. */
    private volatile long lastReadElapsedMs;
    /** logcat was stopped by the drain (caught up, or DRAIN_MAX_MS): its end is no failure. */
    private volatile boolean drainKilled;
    private volatile boolean drainTimedOut;
    /** In elapsedRealtime(), not the wall clock, which FYT corrects in the first minutes after boot. */
    private volatile long deadlineElapsedMs;
    private volatile Process logcatProcess;
    private volatile Context appContext;

    private BufferedWriter fileWriter;   // worker thread only
    private int timeoutSeconds;
    private volatile Mode mode = Mode.FROM_APP_START;
    private volatile Trigger trigger = Trigger.PROCESS_START;
    /**
     * The capture reads the launcher's own log only because the VD host it wants is on its way
     * (see startPlan()): cleared once it has switched to the host. Worker and main thread.
     */
    private volatile boolean awaitingHost;
    /** The host attached while the capture was waiting for it: the worker switches to it, see upgradeToHost(). */
    private volatile boolean upgradeRequested;
    /** The wait for the host of the running capture. Main thread only. */
    private HostAwait.Handle hostWait;
    /** Wall clock of the oldest line we want, 0 = no lower bound (whole buffer). */
    private volatile long captureSinceMs;

    private CountDownTimer countDownTimer; // main thread only
    private StateListener listener;        // main thread only
    /** A wake came while the capture before it was ending; see startForWake(). Guarded by lock. */
    private boolean wakeStartPending;

    /**
     * Lines for the worker to write before the next line it reads: they come from the main thread
     * (a wake extending the capture, a clock change), and the file is the worker's alone.
     */
    private final java.util.concurrent.ConcurrentLinkedQueue<String> pendingNotes =
            new java.util.concurrent.ConcurrentLinkedQueue<>();
    /** The clock as the log lines show it, minus uptime (see clockDisplayOffsetMs()), when last looked at. */
    private volatile long clockDisplayOffsetMs;
    private BroadcastReceiver captureClockReceiver; // main thread only

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
        return running && !draining;
    }

    /** The capture has ended and is still writing what it read up to its end. */
    public boolean isSaving() {
        return running && draining;
    }

    /** Milliseconds left until the capture stops by itself, 0 when nothing is running. */
    public long getRemainingMillis() {
        if (!running || draining) return 0L;
        return Math.max(0L, deadlineElapsedMs - SystemClock.elapsedRealtime());
    }

    public void setStateListener(StateListener l) {
        listener = l;
    }

    public void clearStateListener(StateListener l) {
        if (listener == l) listener = null;
    }

    /** Captures what the buffer holds, i.e. from application start; coldStart: the first start after a boot. */
    public void start(Context context, boolean coldStart) {
        start(context, Mode.FROM_APP_START, coldStart ? Trigger.COLD_START : Trigger.PROCESS_START);
    }

    public void start(Context context, Mode captureMode, Trigger captureTrigger) {
        final Context ctx = context.getApplicationContext();
        final Mode requestedMode = captureMode != null ? captureMode : Mode.FROM_APP_START;
        final Trigger requestedTrigger = captureTrigger != null ? captureTrigger : Trigger.PROCESS_START;

        synchronized (lock) {
            if (running) {
                Log.w(TAG, "start() ignored - already running");
                return;
            }

            mode = requestedMode;
            trigger = requestedTrigger;
            captureSinceMs = (requestedMode == Mode.FROM_NOW) ? System.currentTimeMillis() : 0L;

            prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            timeoutSeconds = parseIntSafe(prefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT,
                    String.valueOf(DEFAULT_TIMEOUT_SECONDS)));
            if (timeoutSeconds <= 0) timeoutSeconds = DEFAULT_TIMEOUT_SECONDS;

            appContext = ctx;
            deadlineElapsedMs = SystemClock.elapsedRealtime() + timeoutSeconds * 1000L;
            draining = false;
            drainKilled = false;
            drainTimedOut = false;
            awaitingHost = false;
            upgradeRequested = false;
            pendingNotes.clear();
            clockDisplayOffsetMs = clockDisplayOffsetMs();
            cutoffWallMs = 0L;
            running = true;
            finished.set(false);

            thread = new HandlerThread("LogcatWorker");
            thread.start();
            handler = new Handler(thread.getLooper());
            handler.post(() -> runLogging(ctx, requestedTrigger));
            watchMainThread();
        }

        Log.i(TAG, "start() mode=" + requestedMode + " trigger=" + requestedTrigger.label
                + " timeoutSeconds=" + timeoutSeconds);
        helpers.setLogcatRunBoolean(true);

        mainHandler.post(this::startCountdown);
        mainHandler.post(this::registerCaptureClockReceiver);
        // Hard stop: unblocks reader.readLine() when the log is quiet.
        mainHandler.postDelayed(deadlineRunnable, timeoutSeconds * 1000L);
    }

    /**
     * The capture of a wake (Keys.LOGCAT_SERVICE_WAKE); main thread.
     *
     * start() is ignored while a capture runs, and one that a sleep interrupted still ran at the
     * next wake: its hard stop counts uptime, which stands still while the device sleeps, and the
     * capture itself only notices its time is up at the next line it reads. So the wake was not
     * captured at all. A capture that still has time left is now extended over the wake, and one
     * that has run out is followed by the wake's own capture as soon as it has finished.
     */
    public void startForWake(Context context) {
        final Context ctx = context.getApplicationContext();
        synchronized (lock) {
            if (!finished.get()) {
                long now = SystemClock.elapsedRealtime();
                if (running && !draining && now < deadlineElapsedMs) {
                    deadlineElapsedMs = Math.max(deadlineElapsedMs, now + timeoutSeconds * 1000L);
                    Log.i(TAG, "startForWake(): capture running, extended over the wake");
                    pendingNotes.add(wakeExtendedLine(SystemClock.elapsedRealtime() / 1000L));
                    mainHandler.removeCallbacks(deadlineRunnable);
                    mainHandler.postDelayed(deadlineRunnable, deadlineElapsedMs - now);
                    startCountdown();
                    return;
                }
                wakeStartPending = true;
                Log.i(TAG, "startForWake(): the previous capture is ending, the wake's follows it");
                return;
            }
        }
        start(ctx, Mode.FROM_APP_START, Trigger.WAKE);
    }

    /**
     * Ends the capture now: what happened up to now still goes into the file (see beginDrain()),
     * and runLogging() reports the result when it is written.
     */
    public void stop(boolean showToast, Context contextForToast) {
        if (!running && finished.get()) return;

        Log.i(TAG, "stop() called showToast=" + showToast);
        beginDrain("stopped");
    }

    public void stop() {
        stop(false, null);
    }

    // ---------------------------------------------------------------- capture

    private void runLogging(Context ctx, Trigger trigger) {
        final int myPid = android.os.Process.myPid();
        final boolean coldStart = trigger == Trigger.COLD_START;
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
        // Whether the VD host attached during the capture, which then holds everything: the file
        // name says so at the end.
        boolean upgraded = false;
        // The wall clock of the start, for a late full dump and the switch to the host: they go
        // back to it.
        final long captureBeganWallMs = System.currentTimeMillis();

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

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            }
            // The scope is worked out before the file is named: the name says what the file holds.
            boolean fullLog = false;
            boolean bootLog = false;
            boolean wantsFullLog = prefs.getBoolean(Keys.LOGCAT_FULL, LogcatDefaults.on(ctx));
            boolean system = LauncherApplication.hasSystemPrivileges();
            boolean hostAttached = !system && wantsFullLog && HostProcess.isAvailable();
            // Without system privileges the VD host (root or Shizuku) reads the whole log. One that
            // is on its way is not waited for: at a cold start Shizuku's binder comes a while
            // after the launcher (the 7870: minutes), and a capture that waits reads nothing
            // meanwhile, so what the launcher logged at the start is gone from logd's small
            // buffers when it finally does.
            StartPlan plan = startPlan(wantsFullLog, system, hostAttached,
                    wantsFullLog && !system && !hostAttached && HostAwait.isExpected(ctx));
            boolean viaHost = plan == StartPlan.HOST;
            if (system || viaHost) {
                fullLog = wantsFullLog;
                // The boot log setting: only with both settings on.
                bootLog = fullLog && prefs.getBoolean(Keys.BOOT_LOGCAT, LogcatDefaults.on(ctx));
            }

            startElapsedMs = SystemClock.elapsedRealtime();
            String timestamp = new SimpleDateFormat(LogFileName.NAME_PATTERN, Locale.getDefault())
                    .format(new Date());
            // A new file every time, never appended to: FYT often boots with the same wrong clock,
            // and captures of two different boots then got the same name and ended up in one file.
            logFile = uniqueFile(dir, LogFileName.name(
                    LogFileName.prefix(trigger.fileLabel, fullLog), timestamp, LOG_FILE_SUFFIX));
            Log.i(TAG, "Opening log file: " + logFile.getAbsolutePath());

            fileWriter = new BufferedWriter(new FileWriter(logFile, false), 8192);
            writeLine(streamHeader(myPid, STREAM_BUFFER, timeoutSeconds, mode, trigger));
            writeLine("===== device=" + Build.MANUFACTURER + " " + Build.MODEL
                    + ", android=" + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ") =====");
            fileWriter.flush();

            // Whether this capture may reach back to the boot is decided by when it started, not
            // by when the VD host came (Shizuku can take a minute or more after the boot).
            final long captureStartedAt = SystemClock.elapsedRealtime();
            if (plan == StartPlan.NO_HOST) {
                writeLine("===== everything: no VD host (root or Shizuku) attached, only the"
                        + " launcher's own log =====");
            } else if (plan == StartPlan.HOST_ON_ITS_WAY) {
                long windowMs = hostWaitMs(trigger);
                writeLine("===== the VD host (Shizuku) is on its way: the launcher's own log until it"
                        + " attaches (up to " + windowMs / 1000L + " s) =====");
                awaitingHost = true;
                mainHandler.post(() -> awaitHostOnMain(windowMs));
            }
            sViaHost = viaHost;
            writeLine(scopeLine(fullLog, viaHost));
            // On every capture, cold start or not: the buffers follow the setting. Tied to
            // coldStart, a capture after a wake would give the large buffers back (the next boot
            // then had small ones again) and dump all 8 MiB of them (see captureStartMs()). A host
            // that is still to come does this when it has arrived, see upgradeToHost().
            if (plan != StartPlan.HOST_ON_ITS_WAY) syncLogdBufferSize(bootLog);
            // Everything since boot only in the capture of a cold start.
            boolean fromBoot = isBootCapture(bootLog, coldStart, mode, captureStartedAt);

            // "--pid" exists since Android 7.0; when it is not available we filter by hand.
            boolean usePidFlag = !fullLog;
            // "-T <time>" makes logcat skip everything older than the given timestamp. If the
            // build does not understand it we drop back to comparing timestamps ourselves.
            boolean useSinceFlag = true;
            long sinceMs = captureStartMs(bootLog, fromBoot, captureSinceMs, System.currentTimeMillis());
            if (fromBoot) writeBootLogHeader();
            SimpleDateFormat lineFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
            int restartCount = 0;
            // logcat runs that failed at once in a row: a command that cannot run at all must not
            // be restarted four times a second until the capture ends.
            int failedRuns = 0;

            // Whether logcat reached a line after the capture's end: everything owed is written.
            boolean caughtUp = false;
            // The last line written, for where a restart goes on from (parsed then only).
            String lastWritten = null;
            while (running) {
                restartCount++;
                if (upgradeRequested) {
                    // The host the capture was waiting for has attached: from here on everything,
                    // from the start of the capture.
                    upgradeRequested = false;
                    awaitingHost = false;
                    upgraded = true;
                    fullLog = true;
                    usePidFlag = false;
                    sViaHost = true;
                    bootLog = prefs.getBoolean(Keys.BOOT_LOGCAT, LogcatDefaults.on(ctx));
                    syncLogdBufferSize(bootLog);
                    fromBoot = isBootCapture(bootLog, coldStart, mode, captureStartedAt);
                    sinceMs = upgradeSinceMs(fromBoot, captureSinceMs, captureBeganWallMs);
                    writeLine(upgradeLine((SystemClock.elapsedRealtime() - captureStartedAt) / 1000L,
                            sinceMs));
                    writeLine(scopeLine(true, true));
                    if (fromBoot) writeBootLogHeader();
                    fileWriter.flush();
                }
                // The VD host went away under the capture (Shizuku Next restarts its server now
                // and then, A16: back after 6 s): logd keeps the lines, so wait for it.
                if (sViaHost && !HostProcess.isAvailable() && !awaitHostBack()) {
                    error = "the VD host did not come back";
                    break;
                }
                boolean sinceFlagThisRun = useSinceFlag && sinceMs > 0L;
                writeLine("----- logcat start #" + restartCount
                        + " (pidFlag=" + usePidFlag + ", sinceFlag=" + sinceFlagThisRun + ") -----");
                fileWriter.flush();

                try {
                    proc = startLogcat(myPid, usePidFlag, sinceFlagThisRun ? sinceMs : 0L, lineFormat, fullLog);
                } catch (IOException noHost) {
                    // Gone again just now: back to the wait at the top.
                    if (!sViaHost || HostProcess.isAvailable()) throw noHost;
                    continue;
                }
                logcatProcess = proc;

                reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line;
                long linesThisRun = 0L;
                try {
                    while (running && (line = reader.readLine()) != null) {
                        long now = SystemClock.elapsedRealtime();
                        lastReadElapsedMs = now;
                        if (draining && isNewerThan(lineFormat, line, cutoffWallMs)
                                && !isNewerThan(lineFormat, line, cutoffWallMs + DRAIN_CLOCK_JUMP_MS)) {
                            caughtUp = true;
                            break;
                        }
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

                        if (!pendingNotes.isEmpty()) flushPendingNotes();
                        fileWriter.write(line);
                        fileWriter.write('\n');
                        lastWritten = line;
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

                flushPendingNotes();
                writeLine("----- logcat ended. exit=" + exit + " lines=" + linesThisRun + " -----");
                fileWriter.flush();

                // Stopped on purpose to go on through the host: no failure, no end (also while
                // the capture is writing what it still owes), unless that is all written.
                if (upgradeRequested && running && !caughtUp && !drainKilled) {
                    failedRuns = 0;
                    continue;
                }

                failedRuns = (exit != 0 && linesThisRun == 0L) ? failedRuns + 1 : 0;
                if (failedRuns >= MAX_FAILED_RUNS && !isShuttingDown()) {
                    error = "logcat could not run (exit " + exit + ")"
                            + (sViaHost ? " in the VD host" : "");
                    writeLine("===== " + error + " " + failedRuns + " times in a row; capture stopped =====");
                    break;
                }

                // A flag this build does not understand makes logcat exit immediately with an
                // error. Drop them one at a time and keep filtering by hand instead.
                boolean flagsRefused = !isShuttingDown() && exit != 0 && linesThisRun == 0L;
                if (flagsRefused) {
                    if (sinceFlagThisRun) {
                        Log.w(TAG, "logcat -T unsupported, falling back to manual time filter");
                        useSinceFlag = false;
                    } else if (usePidFlag) {
                        Log.w(TAG, "logcat --pid unsupported, falling back to manual pid filter");
                        usePidFlag = false;
                    }
                }

                // Ended: once what it owed is read, or once it could not be read (the drain's
                // own limit). A logcat that refused its flags right at the end still gets its
                // retry without them, the capture is owed that much.
                if (!running || caughtUp || drainKilled || (draining && !flagsRefused)) break;

                // Whatever the mode, a restart must not dump the buffer we already wrote, nor
                // skip what came since the last line written (logcat may have been behind, or
                // gone a while with the host): it goes on from that line's time. A line or two
                // of that same millisecond may come twice.
                long now = System.currentTimeMillis();
                long lastMs = lineWallMs(lineFormat, lastWritten, now);
                sinceMs = lastMs > 0L && lastMs <= now ? lastMs : now;

                try {
                    Thread.sleep(250L);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            if (draining && error == null) {
                writeLine(drainTimedOut
                        ? "===== stopped after " + DRAIN_MAX_MS / 1000L + " s of reading past the end:"
                                + " logcat had not caught up with it ====="
                        : "===== written up to the end of the capture ("
                                + new SimpleDateFormat("HH:mm:ss.SSS", Locale.US).format(new Date(cutoffWallMs))
                                + ") =====");
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

            if (upgraded && logFile != null && logFile.exists()) {
                // Named for the scope it started with, pid; from the host's arrival it holds
                // everything. After the move to Downloads, which keeps the name, and before the
                // clock check, the toast and the late dump's watch, which all take the final name.
                String renamed = LogFileName.withScope(logFile.getName(), true);
                if (!renamed.equals(logFile.getName())) {
                    File target = uniqueFile(logFile.getParentFile(), renamed);
                    if (logFile.renameTo(target)) {
                        Log.i(TAG, "Log file renamed to " + target.getName()
                                + " (the VD host attached, the capture holds everything from then on)");
                        logFile = target;
                    } else {
                        Log.w(TAG, "Could not rename " + logFile.getName() + " to " + target.getName());
                    }
                }
            }

            if (logFile != null && logFile.exists() && startElapsedMs > 0L) {
                // Right now if the clock has already been corrected (the toast then shows the
                // right name), otherwise as soon as it is.
                long toleranceMs = nameToleranceMs();
                logFile = fixNameForClock(logFile, startElapsedMs, toleranceMs);
                watchClockFor(logFile, startElapsedMs, toleranceMs);
            }

            // The host never came during the capture: a host that comes soon gets a full dump of it.
            final boolean lateWanted = awaitingHost && logFile != null && logFile.exists() && startElapsedMs > 0L;
            awaitingHost = false;
            final File lateFor = logFile;
            final long lateStartElapsedMs = startElapsedMs;
            mainHandler.post(() -> {
                if (hostWait != null) {
                    hostWait.cancel();
                    hostWait = null;
                }
                if (lateWanted) watchForLateHost(lateFor, lateStartElapsedMs, captureBeganWallMs, trigger);
            });

            boolean success = error == null && logFile != null && logFile.exists();
            String message = success
                    ? string(R.string.logcat_service_run_toast) + "\n" + logFile.getAbsolutePath()
                    : "Logcat: " + (error != null ? error : "no log file was created");

            Log.i(TAG, "runLogging finished success=" + success + " lines=" + linesWritten);
            mainHandler.post(this::unregisterCaptureClockReceiver);
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
                if (failed && sViaHost) {
                    writeLine("===== logd buffers not enlarged for the next boot: the VD host may not"
                            + " set " + LOGD_SIZE_PROP + " (Shizuku without root). Developer options >"
                            + " Logger buffer sizes does the same =====");
                }
                if (!changed.isEmpty() || resized || failed) {
                    Log.i(TAG, "Boot log: logd buffers -> " + BOOT_LOG_BUFFER_SIZE
                            + (changed.isEmpty() ? "" : " (was: " + changed + ")")
                            + (resized ? ", resized now" : "") + (failed ? ", setprop failed" : "")
                            + "; logd starts with its own sizes, before " + LOGD_SIZE_PROP
                            + " is read: the FYT VDHost module grows them before zygote");
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

    /**
     * The commands of the current capture run in the VD host (see HostProcess): the whole log
     * without system privileges. Set at the start of every capture, on its worker thread.
     */
    private static volatile boolean sViaHost;
    private static final int MAX_FAILED_RUNS = 3;

    /** Whether the whole log can be captured here: as system, or through a VD host, there or on its way. */
    public static boolean canCaptureAllLogs(Context context) {
        return LauncherApplication.hasSystemPrivileges() || WindowHostVdClient.canHostPanes()
                || HostAwait.isExpected(context);
    }

    // ---------------------------------------------------------------- the host that is on its way

    /** What a capture does about "log everything" when it starts. */
    enum StartPlan {
        /** The setting is off: the launcher's own log. */
        NOT_WANTED,
        /** The launcher is a system app: everything, as itself. */
        SYSTEM,
        /** A VD host is attached: everything through it. */
        HOST,
        /** No host yet but one is on its way: the launcher's own log now, everything when it attaches. */
        HOST_ON_ITS_WAY,
        /** No host and none expected: the launcher's own log. */
        NO_HOST
    }

    static StartPlan startPlan(boolean wantsFullLog, boolean system, boolean hostAttached,
                               boolean hostExpected) {
        if (!wantsFullLog) return StartPlan.NOT_WANTED;
        if (system) return StartPlan.SYSTEM;
        if (hostAttached) return StartPlan.HOST;
        return hostExpected ? StartPlan.HOST_ON_ITS_WAY : StartPlan.NO_HOST;
    }

    /**
     * How long a running capture waits for the host to switch to it. At a cold start Shizuku
     * (started through wireless ADB) can come minutes after the launcher; after a wake it is
     * usually running already; by hand and after a crash the user is at the screen.
     */
    static long hostWaitMs(Trigger trigger) {
        switch (trigger) {
            case COLD_START: return HostAwait.WAIT_COLD_BOOT_MS;
            case WAKE: return HostAwait.WAIT_WAKE_MS;
            default: return HostAwait.WAIT_SHORT_MS;
        }
    }

    /**
     * How long after the start of a capture a host that attaches gets a full dump of what the
     * capture could not read: ten minutes at a cold start, a minute otherwise.
     */
    static long lateHostWindowMs(Trigger trigger) {
        return trigger == Trigger.COLD_START ? 10L * 60L * 1000L : 60L * 1000L;
    }

    /** The wall clock the switch to the host reads from; 0 = everything logd holds (the boot capture). */
    static long upgradeSinceMs(boolean fromBoot, long requestedSinceMs, long captureBeganWallMs) {
        if (fromBoot) return 0L;
        return requestedSinceMs > 0L ? requestedSinceMs : captureBeganWallMs;
    }

    static String scopeLine(boolean fullLog, boolean viaHost) {
        if (!fullLog) return "===== scope: the launcher's own log (--pid) =====";
        return "===== scope: everything (-b all, " + (viaHost ? "through the VD host" : "as system") + ") =====";
    }

    static String upgradeLine(long waitedSeconds, long sinceMs) {
        String since = sinceMs > 0L
                ? "everything since " + new SimpleDateFormat("HH:mm:ss.SSS", Locale.US).format(new Date(sinceMs))
                : "everything logd still holds";
        return "===== VD host attached after " + waitedSeconds + " s: " + since
                + " follows (the launcher's own lines above repeat) =====";
    }

    /** Main thread: the wait of a running capture for its host. */
    private void awaitHostOnMain(long windowMs) {
        if (!running || !awaitingHost) return;
        if (hostWait != null) hostWait.cancel();
        hostWait = HostAwait.await(windowMs, "logcat capture", attached -> {
            hostWait = null;
            if (attached) requestUpgrade();
        });
    }

    /** The host attached while the capture reads the launcher's own log: ends that run, the worker goes on through the host. */
    private void requestUpgrade() {
        synchronized (lock) {
            if (!running || !awaitingHost) return;
            upgradeRequested = true;
        }
        killProcess();
    }

    /** Main thread: a capture ended before its host came; one that attaches soon gets a dump. */
    private void watchForLateHost(File captureFile, long startElapsedMs, long beganWallMs, Trigger trigger) {
        long remaining = lateHostWindowMs(trigger) - (SystemClock.elapsedRealtime() - startElapsedMs);
        if (remaining <= 0L) return;
        HostAwait.await(remaining, "late full log dump", attached -> {
            if (attached) runLateDump(captureFile, startElapsedMs, beganWallMs, trigger);
        });
    }

    /**
     * The host came after the capture ended: a one-off "logcat -d -b all" through it, into
     * "<capture>_full.txt" beside the capture (from its start, except for a cold start, which gets
     * whatever logd still holds). Goes through the same folders, moves and name corrections as
     * a capture. Own thread; no host, or one that does not run it, only ends it.
     */
    private void runLateDump(File captureFile, long startElapsedMs, long beganWallMs, Trigger trigger) {
        new Thread(() -> {
            File out = null;
            BufferedWriter writer = null;
            Process proc = null;
            long lines = 0L;
            try {
                File dir = captureFile.getParentFile();
                if (dir == null || !dir.isDirectory()) return;
                String name = captureFile.getName();
                // Next to reboot_pid_<stamp>.txt: reboot_full_<stamp>_late.txt, the stamp the same.
                LogFileName.Parts parts = LogFileName.parse(name);
                out = uniqueFile(dir, parts != null
                        ? LogFileName.name(LogFileName.prefix(trigger.fileLabel, true),
                                parts.timestamp, LogFileName.LATE_SUFFIX)
                        : (name.endsWith(LOG_FILE_SUFFIX)
                                ? name.substring(0, name.length() - LOG_FILE_SUFFIX.length()) : name)
                                + LogFileName.LATE_SUFFIX);
                long afterS = (SystemClock.elapsedRealtime() - startElapsedMs) / 1000L;
                List<String> cmd = new ArrayList<>();
                cmd.add("logcat");
                cmd.add("-d");
                cmd.add("-b");
                cmd.add("all");
                cmd.add("-v");
                cmd.add("threadtime");
                if (trigger != Trigger.COLD_START) {
                    cmd.add("-T");
                    cmd.add(new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(beganWallMs)));
                }
                proc = HostProcess.start(cmd.toArray(new String[0]));
                final Process dumping = proc;
                // A dump that never ends is cut: logcat -d returns at once on a healthy host.
                mainHandler.postDelayed(() -> destroyAndWait(dumping), LATE_DUMP_MAX_MS);
                writer = new BufferedWriter(new FileWriter(out, false), 8192);
                writer.write("===== LATE FULL DUMP for " + name + ": the VD host attached " + afterS
                        + " s after the capture started =====\n");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.write('\n');
                        lines++;
                    }
                }
                writer.write("===== END, lines=" + lines + " =====\n");
                Log.i(TAG, "Late full dump written: " + out.getName() + " (" + lines + " lines)");
            } catch (Throwable t) {
                Log.i(TAG, "Late full dump not made: " + t);
            } finally {
                closeQuietly(writer);
                if (proc != null) destroyAndWait(proc);
                if (out != null && out.exists()) {
                    if (lines == 0L && out.length() < 200L) {
                        //noinspection ResultOfMethodCallIgnored
                        out.delete();     // the host did not run it: nothing worth a file
                    } else {
                        long toleranceMs = nameToleranceMs();
                        File named = fixNameForClock(out, startElapsedMs, toleranceMs);
                        watchClockFor(named, startElapsedMs, toleranceMs);
                    }
                }
            }
        }, "LogcatLateDump").start();
    }

    /** How long a late dump may take at the most. */
    private static final long LATE_DUMP_MAX_MS = 2L * 60L * 1000L;

    /** What a boot capture says about what it reads; worker thread. */
    private void writeBootLogHeader() throws Exception {
        writeLine("===== boot log: everything logd still holds since boot ("
                + LOGD_SIZE_PROP + "=" + displaySize(currentLogdSize()) + "), then up to"
                + " the end of the capture =====");
        writeLine("===== reading at " + SystemClock.elapsedRealtime() / 1000L + " s of uptime ("
                + ("1".equals(SystemProperties.get("sys.boot_completed", ""))
                        ? "boot completed" : "boot not completed yet") + ") =====");
        for (String sizeLine : runForOutput("logcat", "-b", "all", "-g")) {
            writeLine("===== " + sizeLine.trim() + " =====");
        }
        fileWriter.flush();
    }

    /** How long a capture waits for a VD host that went away under it. */
    private static final long HOST_RETURN_WAIT_MS = 60_000L;

    /**
     * Waits for the VD host to come back after it went away during the capture. Only a
     * shutdown ends the wait early.
     *
     * @return whether a VD host is attached again
     */
    private boolean awaitHostBack() throws Exception {
        long began = SystemClock.elapsedRealtime();
        writeLine("===== the VD host went away; waiting up to " + HOST_RETURN_WAIT_MS / 1000L
                + " s for it =====");
        fileWriter.flush();
        if (!HostAwait.awaitBlocking(HOST_RETURN_WAIT_MS, () -> running)) {
            writeLine("===== the VD host did not come back =====");
            return false;
        }
        writeLine("===== VD host back after " + (SystemClock.elapsedRealtime() - began) / 1000L
                + " s =====");
        return true;
    }

    private static Process startProcess(List<String> cmd) throws IOException {
        if (sViaHost) return HostProcess.start(cmd.toArray(new String[0]));
        return new ProcessBuilder(cmd).redirectErrorStream(true).start();
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
            proc = startProcess(java.util.Arrays.asList(cmd));
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
        return startProcess(cmd);
    }

    /**
     * Compares the "MM-dd HH:mm:ss.SSS" prefix of a threadtime line with the given wall clock.
     * Lines we cannot parse are kept, so a format surprise never empties the whole file.
     */
    private static boolean isOlderThan(SimpleDateFormat fmt, String line, long sinceMs) {
        long millis = lineWallMs(fmt, line, System.currentTimeMillis());
        return millis >= 0L && millis < sinceMs;
    }

    /** Whether a threadtime line is from after cutoffMs; lines without a time are not. */
    static boolean isNewerThan(SimpleDateFormat fmt, String line, long cutoffMs) {
        long millis = lineWallMs(fmt, line, System.currentTimeMillis());
        return millis >= 0L && millis > cutoffMs;
    }

    /** Wall clock of a threadtime line ("MM-dd HH:mm:ss.SSS" first), -1 when it has none. */
    static long lineWallMs(SimpleDateFormat fmt, String line, long nowMs) {
        if (line == null || line.length() < 18) return -1L;
        try {
            Date parsed = fmt.parse(line.substring(0, 18));
            if (parsed == null) return -1L;

            Calendar now = Calendar.getInstance();
            now.setTimeInMillis(nowMs);
            Calendar lineTime = Calendar.getInstance();
            lineTime.setTime(parsed);
            lineTime.set(Calendar.YEAR, now.get(Calendar.YEAR));

            long millis = lineTime.getTimeInMillis();
            // Around New Year the line may belong to the previous year.
            if (millis - nowMs > 7L * 24L * 3600L * 1000L) {
                lineTime.add(Calendar.YEAR, -1);
                millis = lineTime.getTimeInMillis();
            }
            return millis;
        } catch (Throwable ignored) {
            return -1L;
        }
    }

    // ---------------------------------------------------------------- storage

    /** Public Downloads/Launcher66_Logs when it can be written right now, otherwise null. */
    static File usablePublicDir(Context ctx) {
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
    static File resolveFallbackDir(Context ctx) {
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
        LogFileName.Parts parts = LogFileName.parse(name);
        if (parts == null) return file;   // not a name this class gave
        SimpleDateFormat fmt = new SimpleDateFormat(LogFileName.NAME_PATTERN, Locale.getDefault());
        fmt.setLenient(false);
        long shownMs;
        try {
            Date shown = fmt.parse(parts.timestamp);
            if (shown == null) return file;
            shownMs = shown.getTime();
        } catch (ParseException e) {
            return file;   // not a name this class gave
        }

        long realStartMs = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - startElapsedMs);
        long offBy = realStartMs - shownMs;
        if (Math.abs(offBy) <= toleranceMs) return file;

        File dir = file.getParentFile();
        // The prefix and the kind of file stay, only the stamp is corrected.
        File target = uniqueFile(dir, LogFileName.name(parts.prefix,
                fmt.format(new Date(realStartMs)), parts.suffix));
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

    // ---------------------------------------------------------------- notes inside the file

    static String streamHeader(int pid, String buffer, int timeoutSeconds, Mode mode, Trigger trigger) {
        return "===== STREAM (PID=" + pid + ", buffer=" + buffer + ", timeout=" + timeoutSeconds
                + "s, mode=" + mode + ", trigger=" + trigger.label + ") =====";
    }

    static String wakeExtendedLine(long uptimeSeconds) {
        return "===== wake at " + uptimeSeconds + " s of uptime: capture extended =====";
    }

    /** shiftMs: how far the displayed time jumped, forward positive. */
    static String clockChangedLine(long shiftMs, long uptimeSeconds) {
        return "===== CLOCK CHANGED (was " + describeOffset(shiftMs) + ") at " + uptimeSeconds
                + " s of uptime: the lines below use the new time =====";
    }

    /** A shift smaller than this is the clock being nudged, not a jump worth a line. */
    private static final long CLOCK_NOTE_MIN_SHIFT_MS = 2000L;

    /**
     * The time the log lines show (logcat prints local time) minus the uptime: constant while the
     * clock runs, and it moves when the clock or the time zone is set.
     */
    private static long clockDisplayOffsetMs() {
        long now = System.currentTimeMillis();
        return now + java.util.TimeZone.getDefault().getOffset(now) - SystemClock.elapsedRealtime();
    }

    private void flushPendingNotes() throws Exception {
        String note;
        while ((note = pendingNotes.poll()) != null) {
            writeLine(note);
        }
    }

    /**
     * While a capture runs, a time or time zone set (FYT sets the clock minutes after the boot, the
     * 7870 jumped +2d16h or -1 h in the first minute) is noted at its place in the file; the
     * readers of the log had to guess where the times change. The receiver of a finished capture
     * (see ensureClockReceiver()) renames the file and stays as it is.
     */
    private void registerCaptureClockReceiver() {   // main thread
        Context ctx = appContext;
        if (captureClockReceiver != null || ctx == null || !running) return;
        captureClockReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                long offset = clockDisplayOffsetMs();
                long shift = offset - clockDisplayOffsetMs;
                clockDisplayOffsetMs = offset;
                if (Math.abs(shift) >= CLOCK_NOTE_MIN_SHIFT_MS) {
                    pendingNotes.add(clockChangedLine(shift, SystemClock.elapsedRealtime() / 1000L));
                }
            }
        };
        IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        try {
            ctx.registerReceiver(captureClockReceiver, filter);
        } catch (Throwable t) {
            Log.w(TAG, "Cannot listen for clock changes during the capture: " + t);
            captureClockReceiver = null;
        }
    }

    private void unregisterCaptureClockReceiver() {   // main thread
        Context ctx = appContext;
        if (captureClockReceiver != null && ctx != null) {
            try {
                ctx.unregisterReceiver(captureClockReceiver);
            } catch (IllegalArgumentException ignored) {}
        }
        captureClockReceiver = null;
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

    private final Runnable deadlineRunnable = () -> {
        Log.i(TAG, "deadline reached");
        beginDrain("time limit");
    };

    /**
     * Ends the capture at this moment without losing what logcat has not read yet: lines after
     * now are left out, and logcat is stopped once it has caught up (a line after now, or
     * DRAIN_IDLE_MS without a new line), DRAIN_MAX_MS at the most. The time limit and the stop
     * button end it this way; a stop that kills the stream at once left a boot log with only the
     * start of the boot.
     */
    private void beginDrain(String why) {
        synchronized (lock) {
            if (!running || draining) return;
            long now = SystemClock.elapsedRealtime();
            cutoffWallMs = System.currentTimeMillis();
            drainStartedElapsedMs = now;
            lastReadElapsedMs = now;
            draining = true;
        }
        Log.i(TAG, "capture ended (" + why + "), writing what logcat still owes up to now");
        mainHandler.removeCallbacks(deadlineRunnable);
        mainHandler.post(() -> {
            cancelCountdown();
            helpers.setCountDownLogcat(0);
        });
        mainHandler.postDelayed(drainWatch, DRAIN_POLL_MS);
    }

    /**
     * Stops logcat once it has caught up with the end of the capture, or took too long. Both
     * count only while logcat runs: before it (the VD host still to come) nothing is read yet.
     */
    private final Runnable drainWatch = new Runnable() {
        @Override
        public void run() {
            if (!running || !draining) return;
            long now = SystemClock.elapsedRealtime();
            if (logcatProcess == null) {
                lastReadElapsedMs = now;
                drainStartedElapsedMs = now;
            } else if (now - drainStartedElapsedMs >= DRAIN_MAX_MS) {
                drainTimedOut = true;
                drainKilled = true;
                killProcess();
                // runLogging() reports the result (with the file path) from its finally block;
                // this only fires if the worker thread is stuck somewhere.
                mainHandler.postDelayed(() -> finishOnce(false, null), FINISH_WATCHDOG_MS);
                return;
            } else if (now - lastReadElapsedMs >= DRAIN_IDLE_MS) {
                drainKilled = true;     // waiting for new lines: everything up to the end is read
                killProcess();
                return;
            }
            mainHandler.postDelayed(this, DRAIN_POLL_MS);
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
        mainHandler.removeCallbacks(drainWatch);
        mainHandler.post(() -> {
            cancelCountdown();
            helpers.setLogcatRunBoolean(false);
            helpers.setCountDownLogcat(0);

            if (message != null && ctx != null) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
            }
            StateListener l = listener;
            if (l != null) l.onLogcatStopped(success, message);
            boolean wakePending;
            synchronized (lock) {
                wakePending = wakeStartPending;
                wakeStartPending = false;
            }
            if (wakePending && ctx != null) {
                start(ctx, Mode.FROM_APP_START, Trigger.WAKE);
            }
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

    /** True when the stream was closed because we asked for it (end of the capture read, or shutdown). */
    private boolean isShuttingDown() {
        return !running || drainKilled || upgradeRequested;
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
