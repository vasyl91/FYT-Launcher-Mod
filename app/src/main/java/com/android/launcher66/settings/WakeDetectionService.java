package com.android.launcher66.settings;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.ServiceIntentGate;
import com.android.launcher66.perf.BaselineProfileCompiler;
import com.android.recycler.AppListDialogFragment;
import com.syu.util.WindowHost;
import com.syu.util.WindowUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WakeDetectionService extends Service implements PropertyChangeListener {

    // Intent.ACTION_SCREEN_ON doesn't work on FYT...

    private DisplayManager displayManager;
    private Handler handler;
    private DisplayManager.DisplayListener displayListener;
    private final PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private SharedPreferences mPrefs;

    private static final Object sServiceRunningCacheLock = new Object();
    private static final Map<String, Boolean> sServiceRunningCache = new HashMap<>();
    private static final Map<String, Long> sServiceRunningCacheTime = new HashMap<>();
    private static final long SERVICE_RUNNING_CACHE_MS = 15000L;
    private static final String TAG = "WakeDetection";
    private static final String DISPLAY_ON = "display_on";
    private static final long DISPLAY_ON_DEBOUNCE_MS = 2500L;
    public static final String ACTION_WAKE_REFRESH = "com.android.launcher66.action.WAKE_REFRESH";
    private long lastDisplayOnHandledMs = 0L;

    /**
     * Delays between successive "is PiP actually up?" checks after a wake, in ms.
     * Total budget here is ~13 s, which comfortably covers a slow cold resume.
     */
    /** How long after a wake the launcher keeps pushing back a PiP app restored fullscreen. */
    private static final long WAKE_REASSERT_WINDOW_MS = 5000L;
    private static final long[] PIP_ENSURE_DELAYS_MS = { 2500L, 1500L, 2000L, 3000L, 4000L };
    /**
     * Cheap re-checks while the launcher is in no state to open PiP.
     *
     * After a long sleep the launcher may still be starting, or get pushed straight back to onStop
     * by whatever the ROM brings up on wake. openPip() then returns without doing anything -- it
     * never even reaches its own log line -- so every one of the five attempts above was spent on a
     * launcher that could not act on them. In one capture all five burned between 15.1 s and 25.7 s,
     * "gave up after 5 attempts" followed, and the panes only came back at 32.6 s when
     * onWorkspaceShown() happened to fire. Those 21 seconds are exactly the window in which another
     * app can end up fullscreen with nothing to put it back into a pane.
     */
    private static final int MAX_PIP_ENSURE_LAUNCHER_WAITS = 20;
    private static final long PIP_ENSURE_LAUNCHER_WAIT_MS = 700L;
    private int pipEnsureLauncherWaits = 0;
    /** Same idea for a rebuild that is under way; bounded so a dead rebuild cannot stall us. */
    private static final int MAX_PIP_ENSURE_REBUILD_WAITS = 12;
    private int pipEnsureRebuildWaits = 0;

    /**
     * Bumped whenever a new wake starts an ensure loop, or the screen goes off. Any attempt from
     * an older generation aborts -- this is what stops a queued openPip() from firing after the
     * device has already gone back to sleep.
     */
    private int pipEnsureGeneration = 0;

    /** At most one repair pass per wake -- a repair loop would be worse than the symptom. */
    private boolean repairUsed = false;

    /**
     * At most one cold reset per wake as well. restartPip() starts a fresh ensure loop after the
     * reset while repairUsed stays set, so without this a pane that stays unhealthy was
     * cold-reset again every few seconds until the next sleep.
     */
    private boolean coldResetUsed = false;

    /**
     * Bumped on every handled wake and on every sleep. Delayed widget bar work checks it, so
     * nothing queued by one wake runs after the device has gone back to sleep. Kept separate
     * from pipEnsureGeneration, which restartPip() bumps again within the same wake.
     */
    private int wakeGeneration = 0;
    private static final long WIDGET_BAR_WAKE_FIRST_MS = 2000L;
    /** A long sleep ends in a cold PiP reset, and the layout settles well after the first pass. */
    private static final long WIDGET_BAR_WAKE_SECOND_MS = 6000L;

    @Override
    public void onCreate() {
        super.onCreate();
        // Must be set before any observer or display listener is registered: after the service
        // is (re)created the very first event can be a screen-off, and that path reads the prefs.
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        handler = new Handler(Looper.getMainLooper());
        // Start from the real display state. With the old fixed default (on), a service created
        // while the screen was off never saw the next wake, because on -> on fires no event.
        mPropertyChangeClass.initBoolean(isDefaultDisplayOn());
        mPropertyChangeClass.addObserver(DISPLAY_ON, this);
        setupDisplayListener();
    }

    /**
     * Never returns null. onCreate() sets the prefs up front; the lazy fallback only covers
     * public methods called on an instance that has not been through onCreate().
     */
    private SharedPreferences getPrefs() {
        SharedPreferences prefs = mPrefs;
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            mPrefs = prefs;
        }
        return prefs;
    }

    private boolean isDefaultDisplayOn() {
        Display display = displayManager != null
                ? displayManager.getDisplay(Display.DEFAULT_DISPLAY) : null;
        // Unknown state: keep the previous default (on).
        return display == null || display.getState() == Display.STATE_ON;
    }

    private void setupDisplayListener() {
        displayListener = new DisplayManager.DisplayListener() {
            @Override
            public void onDisplayAdded(int displayId) {
                //
            }

            @Override
            public void onDisplayRemoved(int displayId) {
                //
            }

            @Override
            public void onDisplayChanged(int displayId) {
                if (displayId == Display.DEFAULT_DISPLAY) {
                    Display display = displayManager.getDisplay(displayId);
                    if (display == null) {
                        Log.w(TAG, "Default display unavailable during display change");
                        return;
                    }
                    int state = display.getState();
                    mPropertyChangeClass.setBoolean(DISPLAY_ON, state == Display.STATE_ON);
                }
            }
        };
        displayManager.registerDisplayListener(displayListener, handler);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPropertyChangeClass.deleteObserver(DISPLAY_ON, this);
        if (displayManager != null && displayListener != null) {
            displayManager.unregisterDisplayListener(displayListener);
        }
        // Nothing this instance queued (ensure loop, pressHomeButton, widget bar, night mode)
        // may run after it is gone.
        pipEnsureGeneration++;
        wakeGeneration++;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(DISPLAY_ON)) {
            String val = String.valueOf(evt.getNewValue());
            Helpers helpers = new Helpers();
            // Both branches read the prefs. The screen-off branch used to read mPrefs before
            // assigning it, which crashed on the first sleep after every (re)start of the service.
            final SharedPreferences prefs = getPrefs();
            if (val.contains("true")) {
                helpers.setDisplayStateBoolean(true);
                // elapsedRealtime, not uptimeMillis: the latter stops while the SoC is suspended,
                // so after a real sleep "now" was still within DISPLAY_ON_DEBOUNCE_MS of the
                // previous wake and this returned before doing anything at all -- no cold reset, no
                // PiP ensure, and no "Device awakened from sleep" in the log, because the logcat
                // capture is started further down in this same block.
                long now = SystemClock.elapsedRealtime();
                if (lastDisplayOnHandledMs > 0L
                        && now - lastDisplayOnHandledMs < DISPLAY_ON_DEBOUNCE_MS) {
                    Log.i(TAG, "Ignoring duplicate display-on event after " + (now - lastDisplayOnHandledMs) + " ms");
                    return;
                }
                boolean logcatBoolean = prefs.getBoolean(Keys.LOGCAT_SERVICE_WAKE, true);
                if (logcatBoolean) {
                    LogcatWorker.get().start(LauncherApplication.sApp);
                }
                lastDisplayOnHandledMs = now;
                repairUsed = false;
                coldResetUsed = false;
                final int wakeGen = ++wakeGeneration;
                Log.e(TAG, "Device awakened from sleep");
                // Baseline Profile: a wake is a usage session (ACTION_SCREEN_ON is not delivered
                // on FYT, so BaselineProfileCompiler cannot detect it on its own).
                BaselineProfileCompiler.onDeviceWake(LauncherApplication.sApp);

                // The panes from before the suspend are still in the view hierarchy and report
                // themselves as visible, but their VirtualDisplays did not survive. Without this
                // the debounce sees "same layout, panes on screen" and skips the rebuild entirely,
                // which is why PiP came back after a short sleep but not after a long one.
                WindowUtil.invalidateOpenPipDebounce();

                if (prefs.getBoolean(Keys.LAUNCHER_HOME, true)) {
                    // Starts now and off the main thread: com.syu.ms relaunches the last top app
                    // within a few hundred ms of the wake, and a PiP app restored fullscreen keeps
                    // the launcher paused -- and the panes unbuilt -- until something pushes it back.
                    WindowUtil.reassertHomeOverPipAppsAfterWake(WAKE_REASSERT_WINDOW_MS);
                    postForGeneration(wakeGen, this::pressHomeButton, 500);
                }
                // Everything delayed here belongs to this wake only; see postForGeneration().
                postForGeneration(wakeGen, this::dismissAppListDialog, 500);
                postForGeneration(wakeGen, () -> sendWakeRefresh("early"), 900);
                postForGeneration(wakeGen, () -> sendWakeRefresh("late"), 1800);
                long lastSleepTimestamp = prefs.getLong("sleep_timestamp", -1L);

                if (lastSleepTimestamp > 0) {
                    long currentTime = System.currentTimeMillis();
                    long diff = currentTime - lastSleepTimestamp;

                    // The wall clock is corrected shortly after a wake
                    if (diff < 0) {
                        Log.w(TAG, "Sleep duration negative (" + diff + " ms), clock stepped; treating as long sleep");
                        diff = Long.MAX_VALUE;
                    }

                    // 10 minutes = 10 * 60 * 1000 ms
                    if (diff > 10 * 60 * 1000) {
                        Log.e(TAG, "Sleep duration exceeded 10 minutes: " + diff + " ms");
                        getSharedPreferences("HelpersPrefs", 0).edit().clear().apply();
                    }
                }
                if (prefs.getBoolean(Keys.NIGHT_MODE, false)) {
                    // A sleep within these 10 s has already stopped the service and cancelled its
                    // SunTask; it must not be started again behind that sleep's back.
                    postForGeneration(wakeGen, () -> {
                        Intent nightModeServiceIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                        ServiceIntentGate.startIfAvailable(LauncherApplication.sApp, nightModeServiceIntent, "wake night mode");
                    }, 10000);
                }

                boolean userMap = prefs.getBoolean(Keys.DISPLAY_PIP, true);
                if (userMap) {
                    restartPip();
                } else {
                    // PiP disabled in settings -- make sure nothing from an earlier wake reopens it.
                    pipEnsureGeneration++;
                }

                boolean widgetBar = prefs.getBoolean(Keys.WIDGET_BAR, false);
                if (widgetBar) {
                    // Called directly, not only through ACTION_WAKE_REFRESH: the launcher's
                    // receiver is unregistered while it is stopped, so the broadcast can be lost.
                    handler.postDelayed(() -> {
                        if (wakeGen != wakeGeneration) return;   // device went back to sleep
                        Launcher launcher = Launcher.getLauncher();
                        if (launcher != null) {
                            launcher.updateWeather();
                            launcher.onDeviceWake("wakeService+" + WIDGET_BAR_WAKE_FIRST_MS);
                        }
                    }, WIDGET_BAR_WAKE_FIRST_MS);
                    handler.postDelayed(() -> {
                        if (wakeGen != wakeGeneration) return;
                        Launcher launcher = Launcher.getLauncher();
                        if (launcher != null) {
                            launcher.onDeviceWake("wakeService+" + WIDGET_BAR_WAKE_SECOND_MS);
                        }
                    }, WIDGET_BAR_WAKE_SECOND_MS);
                }
            } else if (val.contains("false")) {
                lastDisplayOnHandledMs = 0L;
                Log.e(TAG, "ACC turned off, device has been put into sleep mode");
                // Baseline Profile: a compilation still waiting for its delay would otherwise
                // fire right into the busy first seconds after the next wake.
                BaselineProfileCompiler.onDeviceSleep();

                // Kill any ensure loop still in flight. Without this a wake followed quickly by a
                // sleep leaves a queued openPip() that fires with the screen already off.
                pipEnsureGeneration++;
                // Same for everything else the last wake queued (widget bar, night mode, ...).
                // Bumped before anything is posted below, so that the next wake cancels it in turn.
                final int sleepGen = ++wakeGeneration;

                if (prefs.getBoolean(Keys.LAUNCHER_HOME, true)) {
                    // Move task to front to leave it as the last top app
                    // FYT often runs full screen the last top app
                    // Dropped if a wake comes first: if the SoC suspends within these 5 s, the
                    // rest of the delay only runs out after the next wake (see postForGeneration).
                    postForGeneration(sleepGen, this::pressHomeButton, 5000);
                }

                WindowUtil.removePip();

                long sleepTimestamp = System.currentTimeMillis();
                prefs.edit().putLong("sleep_timestamp", sleepTimestamp).apply();

                helpers.setDisplayStateBoolean(false);

                // Always, not only when the (cached) check below says NightModeService is running:
                // the DayNightMode job starts its SunTask without the service.
                NightModeService.cancelSunTask();
                // A sunrise/sunset job left pending over the sleep fires late, right after the next
                // wake, next to the refresh NightModeService does on every wake anyway. That is how an
                // already correct wallpaper got set a second time (day -> black -> day). The wake
                // refresh schedules the next job, so nothing is lost by dropping it here.
                SunTask.cancelScheduledJob(LauncherApplication.sApp);

                if (isServiceRunning(NightModeService.class)) {
                    handler.postDelayed(() -> {
                        Intent nightModeIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                        LauncherApplication.sApp.stopService(nightModeIntent);  
                    }, 100);  // Small delay ensures onCancelled() completes    
                }     
            }    
        } 
    }

    private boolean isServiceRunning(Class<? extends Service> serviceClass) {
        String serviceName = serviceClass.getName();
        long now = SystemClock.uptimeMillis();
        synchronized (sServiceRunningCacheLock) {
            Long checkedAt = sServiceRunningCacheTime.get(serviceName);
            Boolean running = sServiceRunningCache.get(serviceName);
            if (checkedAt != null && running != null && now - checkedAt < SERVICE_RUNNING_CACHE_MS) {
                return running;
            }
        }

        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getSystemService(Context.ACTIVITY_SERVICE);
        boolean isRunning = false;
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            for (ActivityManager.RunningServiceInfo service : runningServices) {
                if (serviceName.equals(service.service.getClassName())) {
                    isRunning = true;
                    break;
                }
            }
        }
        setServiceRunningCache(serviceClass, isRunning);
        return isRunning;
    }

    private static void setServiceRunningCache(Class<? extends Service> serviceClass, boolean isRunning) {
        synchronized (sServiceRunningCacheLock) {
            String serviceName = serviceClass.getName();
            sServiceRunningCache.put(serviceName, isRunning);
            sServiceRunningCacheTime.put(serviceName, SystemClock.uptimeMillis());
        }
    }

    /**
     * Brings the launcher to the front after a wake.
     *
     * The HOME intent below is NOT harmless when the launcher is already running. With setClass()
     * plus FLAG_ACTIVITY_NEW_TASK the system answered START_SUCCESS and built a second
     * ActivityRecord instead of reusing the existing one -- the launcher was destroyed and
     * recreated a couple of seconds into the wake. The pane rebuild that had already started was
     * torn down with it, and everything had to be done again on the new instance, which is the
     * ~3.5 s of wasted work before the apps in the panes even began to load.
     *
     * When the launcher is alive, moving its task to the front does the same job without a relaunch.
     */
    public void pressHomeButton() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher != null && !launcher.isDestroyed() && !launcher.isFinishing()) {
            try {
                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                if (am != null) {
                    am.moveTaskToFront(launcher.getTaskId(), 0);
                    Log.i(TAG, "pressHomeButton: launcher already alive, moved its task to front");
                    return;
                }
            } catch (Throwable t) {
                Log.w(TAG, "pressHomeButton: moveTaskToFront failed, falling back to HOME intent", t);
            }
        }

        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        // RESET_TASK_IF_NEEDED so an existing home task is reused rather than replaced.
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        homeIntent.setClass(this, Launcher.class);
        startActivity(homeIntent);
    }

    public void dismissAppListDialog() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        FragmentManager fm = launcher.getSupportFragmentManager();
        DialogFragment dialog = (DialogFragment) fm.findFragmentByTag(AppListDialogFragment.TAG);
        if (dialog != null && dialog.isAdded()) {
            dialog.dismissAllowingStateLoss();
            Log.e(TAG, "AppListDialogFragment dismissed on wake-up");
            Helpers helpers = new Helpers();
            helpers.setListOpen(false);
            Intent intentClose = new Intent(Keys.LIST_CLOSE);
            LauncherApplication.sApp.sendBroadcast(intentClose);
        }
    }

    private void sendWakeRefresh(String phase) {
        Intent intent = new Intent(ACTION_WAKE_REFRESH);
        intent.putExtra("phase", phase);
        LauncherApplication.sApp.sendBroadcast(intent);
    }

    /**
     * Runs task after delayMs, unless a wake or a sleep has happened since the generation was
     * taken (both bump wakeGeneration). The handler counts uptimeMillis(), which stops while the
     * SoC is suspended, so a task posted shortly before a suspend otherwise runs only after the
     * next wake, in the middle of that wake's own work.
     */
    private void postForGeneration(final int generation, final Runnable task, long delayMs) {
        handler.postDelayed(() -> {
            if (generation == wakeGeneration) {
                task.run();
            }
        }, delayMs);
    }

    /**
     * Makes sure PiP really comes back after a wake, instead of firing one openPip() and hoping.
     *
     * Each attempt first asks whether PiP is already healthy; only if it is not does it call
     * openPip() again. WindowUtil has its own debounce, so a redundant call while everything is
     * already on screen costs nothing.
     */
    public void restartPip() {
        final int generation = ++pipEnsureGeneration;
        pipEnsureLauncherWaits = 0;
        pipEnsureRebuildWaits = 0;
        schedulePipEnsureAttempt(generation, 0);
    }

    /** Whether openPip() would currently be able to do anything at all. */
    private boolean launcherCanOpenPip() {
        try {
            Launcher l = Launcher.getLauncher();
            return l != null && l.allowPip;
        } catch (Throwable t) {
            return false;
        }
    }

    private void schedulePipEnsureAttempt(final int generation, final int attempt) {
        schedulePipEnsureAttempt(generation, attempt, -1L);
    }

    private void schedulePipEnsureAttempt(final int generation, final int attempt, final long delayOverrideMs) {
        if (attempt >= PIP_ENSURE_DELAYS_MS.length) {
            Log.w(TAG, "PiP ensure: gave up after " + attempt + " attempts");
            return;
        }
        final long delay = delayOverrideMs >= 0 ? delayOverrideMs : PIP_ENSURE_DELAYS_MS[attempt];

        handler.postDelayed(() -> {
            if (generation != pipEnsureGeneration) return;   // superseded by a newer wake / sleep
            if (!isPipExpected()) return;

            // Do not spend an attempt on a launcher that cannot act on it.
            if (!launcherCanOpenPip() && pipEnsureLauncherWaits < MAX_PIP_ENSURE_LAUNCHER_WAITS) {
                pipEnsureLauncherWaits++;
                Log.i(TAG, "PiP ensure: launcher not ready to open PiP, waiting ("
                        + pipEnsureLauncherWaits + "/" + MAX_PIP_ENSURE_LAUNCHER_WAITS
                        + ", attempt " + attempt + " not consumed)");
                schedulePipEnsureAttempt(generation, attempt, PIP_ENSURE_LAUNCHER_WAIT_MS);
                return;
            }

            if (isPipUp()) {
                // The panes are on screen -- but "on screen" is not the same as "working". A pane
                // whose embedded task ended up on the wrong display, or whose VirtualDisplay never
                // took the new size, renders clipped/partly black and ignores touch. openPip()
                // cannot fix that (the pane is visible, so it gets debounced); only a cold reset can.
                if (!isPipContentHealthy()) {
                    if (repairUsed) {
                        if (coldResetUsed) {
                            // Another reset would only repeat what just did not help.
                            Log.w(TAG, "PiP ensure: still unhealthy after a cold reset, giving up for this wake");
                            return;
                        }
                        coldResetUsed = true;
                        // The per-pane repair did not take, so the displays themselves are the
                        // problem. This is the only place that still needs the full teardown.
                        Log.w(TAG, "PiP ensure: still unhealthy after a repair, cold-resetting the stack");
                        pipEnsureGeneration++;
                        final int coldGen = pipEnsureGeneration;
                        WindowUtil.coldResetPipStack(() -> {
                            if (coldGen != pipEnsureGeneration) return;
                            WindowUtil.startMapPip(false);
                            restartPip();
                        });
                        return;
                    }
                    repairUsed = true;

                    WindowHost host = WindowUtil.getActiveWindowHost();
                    boolean repaired = host != null && host.repairUnhealthyPanes();
                    Log.w(TAG, "PiP ensure: unhealthy pane(s) detected, repair started=" + repaired);

                    // restartPaneApp() re-attaches and relaunches on its own, so nothing else to
                    // do here; the next attempt confirms the result.
                    schedulePipEnsureAttempt(generation, attempt + 1);
                    return;
                }

                // Logged at attempt 0 as well, so that a capture shows how the loop ended.
                Log.i(TAG, attempt > 0
                        ? "PiP ensure: healthy after " + attempt + " retries"
                        : "PiP ensure: healthy");
                return;
            }

            if (WindowUtil.isPipRebuildInProgress()
                    && pipEnsureRebuildWaits < MAX_PIP_ENSURE_REBUILD_WAITS) {
                // openMultiplePips() has not finished, so "not up" means "not finished".
                // Reopening here would throw away the rebuild that is already running -- but this
                // must not spend an attempt either, or the loop exhausts itself waiting and there
                // is nothing left to recover with if that rebuild turns out to be dead.
                pipEnsureRebuildWaits++;
                Log.i(TAG, "PiP ensure: rebuild still in flight, re-checking ("
                        + pipEnsureRebuildWaits + "/" + MAX_PIP_ENSURE_REBUILD_WAITS
                        + ", attempt " + attempt + " not consumed)");
                schedulePipEnsureAttempt(generation, attempt, PIP_ENSURE_LAUNCHER_WAIT_MS);
                return;
            }

            if (Launcher.getLauncher() == null) {
                Log.i(TAG, "PiP ensure: launcher not available yet (attempt " + attempt + ")");
            } else {
                Log.i(TAG, "PiP ensure: PiP not up, calling openPip (attempt " + attempt + ")");
                // startMapPip() hands this to the worker pool. openPip() itself queries the top
                // activity and dismisses panes, which must not happen on the main thread while the
                // panes are being built.
                WindowUtil.startMapPip(false);
            }

            schedulePipEnsureAttempt(generation, attempt + 1);
        }, delay);
    }

    /** Is PiP supposed to be on screen at all? */
    private boolean isPipExpected() {
        try {
            SharedPreferences prefs = getPrefs();
            if (!prefs.getBoolean(Keys.DISPLAY_PIP, true)) return false;

            return prefs.getBoolean(Keys.PIP_DUAL, false)
                    || prefs.getBoolean(Keys.PIP_FIRST, false)
                    || prefs.getBoolean(Keys.PIP_SECOND, false)
                    || prefs.getBoolean(Keys.PIP_THIRD, false)
                    || prefs.getBoolean(Keys.PIP_FOURTH, false);
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * Every enabled, non-pinned pane is on screen and none of them is still waiting for usable
     * bounds. Pinned panes are excluded on purpose: openMultiplePips() does not route those through
     * WindowHost at all, so their visibility says nothing.
     */
    private boolean isPipUp() {
        try {
            WindowHost host = WindowUtil.getActiveWindowHost();
            if (host == null) return false;

            // A pane that still has no real bounds has not launched its app yet.
            if (host.isAnyPaneAwaitingBounds()) return false;

            SharedPreferences prefs = getPrefs();
            boolean dualPip   = prefs.getBoolean(Keys.PIP_DUAL, false);
            boolean firstPip  = prefs.getBoolean(Keys.PIP_FIRST, false);
            boolean secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
            boolean thirdPip  = prefs.getBoolean(Keys.PIP_THIRD, false);
            boolean fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
            boolean thirdPinned  = prefs.getBoolean(Keys.PIP_THIRD_MODE, false);
            boolean fourthPinned = prefs.getBoolean(Keys.PIP_FOURTH_MODE, false);

            if (dualPip) {
                if (!host.isDualVisible()) return false;
            } else {
                if (firstPip && !host.isFirstVisible()) return false;
                if (secondPip && !host.isSecondVisible()) return false;
            }
            if (thirdPip && !thirdPinned && !host.isThirdVisible()) return false;
            if (fourthPip && !fourthPinned && !host.isFourthVisible()) return false;

            return true;
        } catch (Throwable t) {
            Log.w(TAG, "isPipUp check failed", t);
            return false;
        }
    }

    /**
     * Whether every visible pane actually shows a working app: its VirtualDisplay still hosts a
     * task, and that display has the size the pane expects. Both are needed -- a pane can be
     * perfectly visible while the app inside it renders at a stale size (clipped, partly black,
     * unresponsive), which is exactly what happens when a task is relocated between displays.
     */
    private boolean isPipContentHealthy() {
        try {
            WindowHost host = WindowUtil.getActiveWindowHost();
            if (host == null) return true;   // nothing to judge
            return host.isContentHealthy();
        } catch (Throwable t) {
            Log.w(TAG, "isPipContentHealthy check failed", t);
            return true;                     // never cold-reset on an inconclusive reading
        }
    }

    /**
     * Superseded by WindowUtil.coldResetPipStack() on the long-sleep path -- force-stopping on its
     * own leaves the task records (and therefore the stale configuration) intact. Kept because it
     * is public API of this service.
     */
    public void resetPip() {  
        SharedPreferences prefs = getPrefs();
        boolean firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
        boolean dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
        String firstPackage = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        if ((firstPip || dualPip) && !firstPackage.isEmpty()) {
            restartPipApp(Keys.PIP_FIRST_PACKAGE);
        } 
        boolean secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
        String secondPackage = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        if ((secondPip || dualPip) && !secondPackage.isEmpty()) {
            restartPipApp(Keys.PIP_SECOND_PACKAGE);
        }
        boolean thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
        String thirdPackage = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        if (thirdPip && !thirdPackage.isEmpty()) {
            restartPipApp(Keys.PIP_THIRD_PACKAGE);
        }
        boolean fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
        String fourthPackage = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        if (fourthPip && !fourthPackage.isEmpty()) { 
            restartPipApp(Keys.PIP_FOURTH_PACKAGE);  
        }
    }

    public void restartPipApp(String key) {
        String appPackageName = getPrefs().getString(key, "");
        if (!appPackageName.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, appPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                Log.e(TAG, "restartPipApp() failed: " + e);
            }
        }
    }

    public static class PropertyChangeClass {
        private boolean pBoolean = true;
        private final PropertyChangeSupport mPropertyChangeSupport = new  PropertyChangeSupport(this);

        /** Sets the starting value without notifying observers. */
        public void initBoolean(boolean bool) {
            pBoolean = bool;
        }

        public void setBoolean(String name, boolean bool) {
            boolean old = pBoolean;
            pBoolean = bool;
            mPropertyChangeSupport.firePropertyChange(name, old, bool);
        }

        public void addObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.addPropertyChangeListener(name, listener);
        }

        public void deleteObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.removePropertyChangeListener(name, listener);
        }
    }
}
