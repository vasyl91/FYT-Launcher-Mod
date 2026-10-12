package com.android.launcher66.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Display;

import com.android.launcher66.ColdStart;
import com.syu.car.CarStates;
import com.syu.ipc.data.FinalMain;
import com.syu.remote.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * Whether the device is asleep or awake, from every signal there is for it, merged into one state
 * for WakeDetection.
 *
 * Sleep and wake used to come from two signals only, both in WakeDetectionService: the default
 * display's state and ACC from com.syu.ms. Neither is there everywhere -- a phone has no ACC, and
 * not every ROM takes the display through a state change -- and the service did not stay around
 * either (see WakeDetection). Here every source reports to the same state, and whichever reports
 * first switches it; the others then change nothing:
 * <ul>
 *   <li><b>acc</b> -- ACC as com.syu.ms reports it (FinalMain.U_ACC_ON), on FYT only. In the capture
 *       09-10-2026 it came 1.2 s before the display went off and 0.1 s before it came back on.
 *       While it says off, nothing else may report a wake, unless the CPU has been suspended since
 *       (see {@link #screenSignal}): with ACC off the display can still be on for a while.
 *   <li><b>display</b> -- the default display's state (DisplayManager). Only STATE_ON counts as on;
 *       DOZE and the suspended states are the screen off as far as the launcher is concerned.
 *   <li><b>screen</b> -- ACTION_SCREEN_OFF / ACTION_SCREEN_ON, the interactive state. Not sent for
 *       ACC on FYT, sent on phones.
 *   <li><b>unlock</b> -- ACTION_USER_PRESENT: the keyguard has gone, so the screen is on.
 *   <li><b>dream</b> -- ACTION_DREAMING_STOPPED: a dream (screen saver, ambient display) is over.
 *       A dream that starts is not a sleep, the device is still on.
 *   <li><b>poll</b> -- the display state read every {@link #POLL_INTERVAL_MS}, for a change none of
 *       the above reported.
 *   <li><b>suspend</b> -- the time the CPU spent suspended (elapsedRealtime() - uptimeMillis()). A
 *       suspend since the last change means the device has been asleep, whatever was reported.
 *   <li><b>restart</b> -- the process was started, or restarted, during a sleep: the state is kept
 *       in prefs with the kernel's boot id, so that a wake after a restart is not lost. Whether
 *       that restart came right at the wake: see {@link #restartAtTheWake()}.
 * </ul>
 *
 * <p>Not a sleep: the FYT black screen (FinalMain.U_BLACK_SCREEN), the screen blanked from the
 * status bar (or by a key) with everything still running. In the capture 12-10-2026 09:22:08
 * SystemUI sent C_BLACKSCREEN to com.syu.ms, which reported U_BLACK_SCREEN 1 at 11.447 while
 * com.syu.us covered the screen with a black window (11.455); a touch at 12.642 reported 0 and the
 * window went away at 12.750. The display and ACC never changed. While the black screen is on, and
 * for {@link #BLACK_SCREEN_GRACE_MS} after it, the screen signals are ignored, and on a FYT unit a
 * screen-off waits {@link #OFF_SETTLE_MS} for a black screen report that may still be on its way
 * (a unit that blanks the screen by switching the display off). ACC and a suspend of the CPU
 * still count: those are a real sleep.
 *
 * <p>Threads: the state lives on the main thread, where the listener is called. Registering and
 * reading the display state are calls into system_server, which stalls at boot; they run on this
 * class' own thread and post their results.
 */
final class WakeSignals {

    /** Called on the main thread, once per change of the state. */
    interface Listener {
        void onSleep(String source);

        void onWake(String source);

        /**
         * The MCU has gone off during a sleep (com.syu.ms's U_MCU_ON 0). com.syu.ms notes the app
         * it opens again at the wake right after it sends this: 5-31 ms later in the captures of
         * 12-10-2026 (21:47:52.675 here, "MCU OFF sTopAppWhenMcuOff" at 21:47:52.680).
         */
        void onMcuOff();
    }

    static final String ACC = "acc";
    static final String DISPLAY = "display";
    static final String SCREEN = "screen";
    static final String UNLOCK = "unlock";
    static final String DREAM = "dream";
    static final String POLL = "poll";
    static final String SUSPEND = "suspend";
    static final String RESTART = "restart";

    private static final String TAG = "WakeSignals";

    /** The poll: the display state and the suspend time are read this often. */
    static final long POLL_INTERVAL_MS = 3000L;
    /** Polls in a row that must disagree with the state before the poll changes it. */
    static final int POLL_MISMATCHES = 2;
    /** A suspend this long since the last change: the device has been asleep in between. */
    static final long SUSPEND_MIN_MS = 5000L;
    /**
     * A wake reported as RESTART is taken for the wake itself, not for one the user may long have
     * been busy since, only if it provably came at most this long after the display came on; see
     * restartAtTheWake().
     */
    static final long RESTART_AT_WAKE_MS = 5000L;
    /** How long the screen signals stay ignored after a black screen has ended. */
    static final long BLACK_SCREEN_GRACE_MS = 3000L;
    /** On a FYT unit, how long a screen-off waits for a black screen report. */
    static final long OFF_SETTLE_MS = 1000L;

    private static final String PREFS = "wake_state";
    private static final String KEY_ASLEEP = "asleep";
    private static final String KEY_BOOT_ID = "boot_id";
    private static final String KEY_SINCE_ELAPSED = "since_elapsed";
    private static final String KEY_SINCE_UPTIME = "since_uptime";

    private final Context app;
    private final Listener listener;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Handler bg;

    // ---------------------------------------------------------------- main thread
    private boolean started;
    private boolean awake = true;
    /** Total CPU suspend time (see suspendedMs()) at the last change of the state. */
    private long suspendedAtChange;
    /** ACC: -1 until com.syu.ms reported it, the first report being the state, not a change. */
    private int accState = -1;
    private boolean blackScreen;
    /** com.syu.ms has reported something: a FYT unit, which can blank its screen. */
    private boolean carReported;
    private long blackScreenEndedAt;
    private int pollMismatches;
    /** Last value each source reported, for the log and for the screen-off that waits. */
    private final Map<String, Boolean> lastBySource = new HashMap<>();
    /** Last value of the codes that are only logged. */
    private final SparseIntArray loggedCodes = new SparseIntArray();
    private Runnable pendingOff;
    /**
     * For the wake reported as RESTART: the CPU's awake time (uptimeMillis()) since the state was
     * last kept, during the sleep. -1 if not known, or not started during a sleep.
     */
    private long restartAwakeMs = -1L;

    // ---------------------------------------------------------------- own thread
    private DisplayManager displayManager;
    private SharedPreferences state;
    private String bootId;

    WakeSignals(Context context, Listener listener) {
        this.app = context.getApplicationContext();
        this.listener = listener;
        HandlerThread thread = new HandlerThread("WakeSignals");
        thread.start();
        this.bg = new Handler(thread.getLooper());
    }

    /** Main thread. Every source is registered from here on, see the class comment. */
    void start() {
        if (started) {
            return;
        }
        started = true;
        bg.post(this::startInBackground);
    }

    /** Own thread: the first state, then the system's listeners and the poll. */
    private void startInBackground() {
        displayManager = (DisplayManager) app.getSystemService(Context.DISPLAY_SERVICE);
        final boolean displayOn = isDefaultDisplayOn();
        // Read here, with the boot id, as both are file reads.
        state = app.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        final boolean persistedAsleep = state.getBoolean(KEY_ASLEEP, false);
        final String persistedBootId = state.getString(KEY_BOOT_ID, null);
        final long persistedElapsed = state.getLong(KEY_SINCE_ELAPSED, 0L);
        final long persistedUptime = state.getLong(KEY_SINCE_UPTIME, 0L);
        bootId = ColdStart.readKernelBootId();
        final boolean sameBoot = isSameBoot(bootId, persistedBootId, persistedElapsed,
                SystemClock.elapsedRealtime());
        final long awakeSinceKept = persistedUptime > 0L
                ? SystemClock.uptimeMillis() - persistedUptime : -1L;
        main.post(() -> init(displayOn, persistedAsleep && sameBoot, awakeSinceKept));

        if (displayManager != null) {
            try {
                displayManager.registerDisplayListener(displayListener, bg);
            } catch (RuntimeException e) {
                Log.w(TAG, "Display listener not registered: " + e);
            }
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        filter.addAction(Intent.ACTION_DREAMING_STARTED);
        filter.addAction(Intent.ACTION_DREAMING_STOPPED);
        try {
            // System broadcasts only, so not exported; delivered on this thread.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                app.registerReceiver(receiver, filter, null, bg, Context.RECEIVER_NOT_EXPORTED);
            } else {
                app.registerReceiver(receiver, filter, null, bg);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Screen broadcasts not registered: " + e);
        }
        bg.postDelayed(poll, POLL_INTERVAL_MS);
    }

    /**
     * Main thread: the state the process starts in. A process (re)started during a sleep of the
     * same boot starts asleep, and the display that is on now is then the wake it missed.
     * Otherwise the display decides; a service created while the screen was off used to start
     * awake and never saw the next wake, because on -> on is no change.
     */
    private void init(boolean displayOn, boolean asleepBeforeRestart, long awakeSinceKeptMs) {
        awake = !asleepBeforeRestart && displayOn;
        suspendedAtChange = suspendedMs();
        restartAwakeMs = asleepBeforeRestart ? awakeSinceKeptMs : -1L;
        if (asleepBeforeRestart) {
            Log.i(TAG, "Started during a sleep (display " + (displayOn ? "on" : "off")
                    + (restartAwakeMs >= 0L ? ", CPU awake " + restartAwakeMs + " ms since it was noted" : "")
                    + ")");
        } else {
            Log.i(TAG, "Started " + (awake ? "awake" : "asleep, display off"));
        }
        persist();
        setupCarListener();
        if (asleepBeforeRestart && displayOn) {
            screenSignal(RESTART, true);
        }
    }

    // ---------------------------------------------------------------- the state (main thread)

    /** ACC from com.syu.ms: always switches the state. */
    private void accSignal(boolean on) {
        cancelPendingOff();
        Log.i(TAG, "ACC " + (on ? "on" : "off") + " reported by com.syu.ms");
        change(on, ACC);
    }

    /**
     * Every source but ACC. Ignored during a black screen; a wake is also ignored while ACC is off
     * and the CPU has not been suspended since the sleep -- with ACC off the screen of some units
     * stays on for a while, and the display reports changes of it all the same.
     */
    private void screenSignal(String source, boolean on) {
        Boolean previous = lastBySource.put(source, on);
        // The display reports every change of it, not only of its state.
        if (previous == null || previous != on || !DISPLAY.equals(source)) {
            Log.i(TAG, "Signal " + source + ": screen " + (on ? "on" : "off"));
        }
        if (on) {
            cancelPendingOff();
        }
        if (on == awake) {
            return;
        }
        long now = SystemClock.elapsedRealtime();
        if (blackScreenBlocks(blackScreen, blackScreenEndedAt, now)) {
            Log.i(TAG, "Signal " + source + " ignored: black screen");
            return;
        }
        if (on) {
            if (accBlocksWake(accState, suspendedMs() - suspendedAtChange)) {
                Log.i(TAG, "Signal " + source + " ignored: ACC still off");
                return;
            }
            change(true, source);
            return;
        }
        if (!carReported) {
            change(false, source);
            return;
        }
        // The black screen report may still be on its way.
        if (pendingOff != null) {
            return;
        }
        pendingOff = () -> {
            pendingOff = null;
            if (!awake || !Boolean.FALSE.equals(lastBySource.get(source))) {
                return;
            }
            if (blackScreenBlocks(blackScreen, blackScreenEndedAt, SystemClock.elapsedRealtime())) {
                Log.i(TAG, "Signal " + source + " ignored: black screen");
                return;
            }
            change(false, source);
        };
        main.postDelayed(pendingOff, OFF_SETTLE_MS);
    }

    /** Main thread, from the poll on the own thread. */
    private void pollResult(boolean displayOn, long suspended) {
        long suspendedSinceChange = suspended - suspendedAtChange;
        if (suspendedSinceChange >= SUSPEND_MIN_MS) {
            pollMismatches = 0;
            if (awake) {
                // A whole sleep went by with no signal at all.
                Log.w(TAG, "CPU suspended for " + suspendedSinceChange / 1000L
                        + " s with no sleep reported");
                cancelPendingOff();
                change(false, SUSPEND);
                if (displayOn) {
                    change(true, SUSPEND);
                }
            } else if (displayOn) {
                // Asleep, suspended since, and the screen is on again: whatever ACC and the black
                // screen last said, this is a wake.
                Log.i(TAG, "Display on after " + suspendedSinceChange / 1000L + " s suspended");
                change(true, SUSPEND);
            }
            return;
        }
        if (displayOn == awake) {
            pollMismatches = 0;
            return;
        }
        if (++pollMismatches >= POLL_MISMATCHES) {
            pollMismatches = 0;
            screenSignal(POLL, displayOn);
        }
    }

    private void change(boolean on, String source) {
        if (on == awake) {
            return;
        }
        awake = on;
        suspendedAtChange = suspendedMs();
        pollMismatches = 0;
        persist();
        if (on) {
            listener.onWake(source);
        } else {
            listener.onSleep(source);
        }
    }

    private void cancelPendingOff() {
        if (pendingOff != null) {
            main.removeCallbacks(pendingOff);
            pendingOff = null;
        }
    }

    /** Kept for a process that is restarted during the sleep; see init(). */
    private void persist() {
        final boolean asleep = !awake;
        final long since = SystemClock.elapsedRealtime();
        final long sinceUptime = SystemClock.uptimeMillis();
        bg.post(() -> state.edit()
                .putBoolean(KEY_ASLEEP, asleep)
                .putString(KEY_BOOT_ID, bootId)
                .putLong(KEY_SINCE_ELAPSED, since)
                .putLong(KEY_SINCE_UPTIME, sinceUptime)
                .apply());
    }

    /**
     * Main thread, for the wake reported as RESTART: whether the process was started right at the
     * wake. uptimeMillis() stands still while the CPU is suspended and runs all the time the
     * display is on, so the awake time since the state was kept during the sleep is at least the
     * time since the wake -- whatever that sleep was like.
     */
    boolean restartAtTheWake() {
        return restartAtTheWake(restartAwakeMs);
    }

    // ---------------------------------------------------------------- decisions (unit tested)

    /** During a black screen, and for BLACK_SCREEN_GRACE_MS after it, the screen does not count. */
    static boolean blackScreenBlocks(boolean blackScreen, long endedAtElapsed, long nowElapsed) {
        return blackScreen
                || (endedAtElapsed > 0L && nowElapsed - endedAtElapsed < BLACK_SCREEN_GRACE_MS);
    }

    /** ACC reported off and no suspend since the sleep: the screen alone is not a wake. */
    static boolean accBlocksWake(int accState, long suspendedSinceChangeMs) {
        return accState == 0 && suspendedSinceChangeMs < SUSPEND_MIN_MS;
    }

    /** See RESTART_AT_WAKE_MS; a negative time is not known. */
    static boolean restartAtTheWake(long awakeSinceKeptMs) {
        return awakeSinceKeptMs >= 0L && awakeSinceKeptMs <= RESTART_AT_WAKE_MS;
    }

    /**
     * Whether a state kept in prefs belongs to the running boot. The kernel's boot id decides; if
     * it cannot be read, a monotonic clock that is behind the stored one means a restart.
     */
    static boolean isSameBoot(String bootId, String persistedBootId, long persistedElapsed,
                              long nowElapsed) {
        if (bootId != null && persistedBootId != null) {
            return bootId.equals(persistedBootId);
        }
        return persistedElapsed > 0L && nowElapsed >= persistedElapsed;
    }

    // ---------------------------------------------------------------- com.syu.ms (main thread)

    /**
     * ACC and the black screen, plus the codes that are only logged (see CarStates.MAIN_LOOK_CODE).
     * Registered on every device: without com.syu.ms (a phone) nothing is ever reported. The
     * isFytDevice() check this used to have missed FYT units whose build does not say FYT.
     */
    private void setupCarListener() {
        CarStates car = CarStates.getCar(app);
        // Already connected: CarStates has the states, and the next report is a change.
        boolean connected = car.mTools.connected();
        accState = connected ? CarStates.mAccState : -1;
        if (connected) {
            carReported = true;
            setBlackScreen(CarStates.mBlackScreen != 0);
        }
        Callback.OnRefreshLisenter carListener = (updateCode, ints, flts, strs) -> {
            carReported = true;
            if (ints == null || ints.length == 0) {
                return;
            }
            int value = ints[0];
            if (updateCode == FinalMain.U_ACC_ON) {
                int previous = accState;
                accState = value;
                if (previous != -1 && previous != value) {
                    accSignal(value != 0);
                }
            } else if (updateCode == FinalMain.U_BLACK_SCREEN) {
                setBlackScreen(value != 0);
            } else {
                int previous = loggedCodes.get(updateCode, Integer.MIN_VALUE);
                if (previous != value) {
                    loggedCodes.put(updateCode, value);
                    Log.i(TAG, "com.syu.ms " + loggedCodeName(updateCode) + " = " + value
                            + (awake ? " (awake)" : " (asleep)"));
                    // Not the first report, which is the state, not a change.
                    if (updateCode == FinalMain.U_MCU_ON && value == 0
                            && previous != Integer.MIN_VALUE && !awake) {
                        listener.onMcuOff();
                    }
                }
            }
        };
        car.mTools.addRefreshLisenter(0, carListener, FinalMain.U_ACC_ON, FinalMain.U_BLACK_SCREEN,
                FinalMain.U_MCU_ON, FinalMain.U_STANDBY, FinalMain.U_ARM_SLEEP_WAKEUP);
    }

    private static String loggedCodeName(int code) {
        switch (code) {
            case FinalMain.U_MCU_ON:
                return "U_MCU_ON";
            case FinalMain.U_STANDBY:
                return "U_STANDBY";
            case FinalMain.U_ARM_SLEEP_WAKEUP:
                return "U_ARM_SLEEP_WAKEUP";
            default:
                return "main code " + code;
        }
    }

    private void setBlackScreen(boolean on) {
        if (on == blackScreen) {
            return;
        }
        blackScreen = on;
        if (on) {
            cancelPendingOff();
        } else {
            blackScreenEndedAt = SystemClock.elapsedRealtime();
        }
        Log.i(TAG, "Black screen " + (on ? "on" : "off") + " (not a sleep)");
    }

    // ---------------------------------------------------------------- own thread

    private final DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() {
        @Override
        public void onDisplayAdded(int displayId) {
        }

        @Override
        public void onDisplayRemoved(int displayId) {
        }

        @Override
        public void onDisplayChanged(int displayId) {
            if (displayId != Display.DEFAULT_DISPLAY) {
                return;
            }
            Display display = displayManager.getDisplay(displayId);
            if (display == null) {
                Log.w(TAG, "Default display unavailable during display change");
                return;
            }
            final boolean on = display.getState() == Display.STATE_ON;
            main.post(() -> screenSignal(DISPLAY, on));
        }
    };

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            switch (action) {
                case Intent.ACTION_SCREEN_OFF:
                    main.post(() -> screenSignal(SCREEN, false));
                    break;
                case Intent.ACTION_SCREEN_ON:
                    main.post(() -> screenSignal(SCREEN, true));
                    break;
                case Intent.ACTION_USER_PRESENT:
                    main.post(() -> screenSignal(UNLOCK, true));
                    break;
                case Intent.ACTION_DREAMING_STARTED:
                    Log.i(TAG, "Dream started (not a sleep)");
                    break;
                case Intent.ACTION_DREAMING_STOPPED:
                    // Ambient display ends this way when the device wakes; a screen saver too,
                    // with the device awake all along, which the state then already says.
                    if (isDefaultDisplayOn()) {
                        main.post(() -> screenSignal(DREAM, true));
                    }
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * Posted with uptimeMillis(), which stands still while the CPU is suspended: after a sleep the
     * next poll comes at most POLL_INTERVAL_MS into the wake.
     */
    private final Runnable poll = new Runnable() {
        @Override
        public void run() {
            try {
                final boolean displayOn = isDefaultDisplayOn();
                final long suspended = suspendedMs();
                main.post(() -> pollResult(displayOn, suspended));
            } catch (RuntimeException e) {
                Log.w(TAG, "Poll failed: " + e);
            }
            bg.postDelayed(this, POLL_INTERVAL_MS);
        }
    };

    /** Unknown counts as on, as before. A call into system_server on Android 10. */
    private boolean isDefaultDisplayOn() {
        DisplayManager dm = displayManager;
        Display display = dm != null ? dm.getDisplay(Display.DEFAULT_DISPLAY) : null;
        return display == null || display.getState() == Display.STATE_ON;
    }

    /** Time the CPU has spent suspended since boot. */
    private static long suspendedMs() {
        return SystemClock.elapsedRealtime() - SystemClock.uptimeMillis();
    }
}
