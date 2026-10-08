package com.android.launcher66;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.ActionMode;
import android.view.Display;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.android.launcher66.settings.AppListAutostartDialogFragment;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.LogcatWorker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The launcher's first start after a device restart (a cold boot), as opposed to a wake from
 * sleep, which WakeDetectionService handles.
 *
 * <ul>
 *   <li><b>Boot-time stall:</b> at every boot this ROM blocks all calls into system_server for
 *       about ten seconds; work that can wait is deferred past it, see {@link #bootStallDelayMs()}.
 *   <li><b>Launcher in front:</b> for a while after the restart, whatever comes up over the
 *       launcher is sent back behind it (setting Keys.LAUNCHER_HOME); with it off, the app that
 *       was in front before the restart is opened again.
 *   <li><b>Autostart:</b> the apps picked in AppListAutostartDialogFragment are started once the
 *       stall is over.
 * </ul>
 *
 * LauncherApplication.onCreate() creates it through {@link #start}. In other processes of the app
 * and at later starts of the same boot (crash, update) nothing beyond that happens.
 */
public final class ColdStart {

    private static final String TAG = "ColdStart";

    // =============================================================================================
    // Boot-time stall
    // =============================================================================================

    /**
     * Uptime by which this ROM's boot-time stall is over. Work that is not needed for the first 
     * screen waits for this instead of freezing the launcher in the middle of it.
     */
    public static final long BOOT_STALL_OVER_UPTIME_MS = 45_000L;

    /** Delay for work that can wait: until the boot-time stall is over, 0 when not booting. */
    public static long bootStallDelayMs() {
        return Math.max(0L, BOOT_STALL_OVER_UPTIME_MS - SystemClock.elapsedRealtime());
    }

    // =============================================================================================
    // Start
    // =============================================================================================

    private final Application app;
    /** For what belongs to the main thread: the autostart timer and the input spy's windows. */
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    /** Whether this process start is the first one after a device restart; set in start(). */
    private boolean coldBoot;
    private static boolean bootCompletedAutostart;

    private ColdStart(Application app) {
        this.app = app;
    }

    /**
     * Called once from LauncherApplication.onCreate(), on the main thread. On the first start of
     * the launcher's process after a device restart it keeps the launcher in front (if enabled)
     * and schedules the autostart.
     *
     * The boot is recorded even with Keys.LAUNCHER_HOME off. Otherwise switching it on in the first
     * minutes after a restart would make the next process restart (crash, update) look like the
     * first start of this boot, and the launcher could be pulled over an app the user has opened.
     */
    static ColdStart start(Application app, SharedPreferences settings) {
        ColdStart coldStart = new ColdStart(app);
        coldStart.coldBoot = coldStart.isMainProcess() && coldStart.isFirstStartAfterColdBoot();
        startLogcat(app, coldStart.coldBoot, settings);
        if (coldStart.coldBoot) {
            boolean launcherHome = settings.getBoolean(Keys.LAUNCHER_HOME, true);
            bootCompletedAutostart = settings.getBoolean(Keys.AUTOSTART_APPS_BY_BOOT_COMPLETED, true);
            coldStart.startBootFrontGuard(launcherHome);
            if (!launcherHome) {
                coldStart.scheduleLastAppRestore();
            }
            coldStart.scheduleBootAutostart(launcherHome);
        }
        return coldStart;
    }

    private static void startLogcat(Application app, boolean coldStart, SharedPreferences settings) {
        if (settings.getBoolean(Keys.LOGCAT_SERVICE, true)) {
            LogcatWorker.get().start(app, coldStart);
        }
    }

    /** Whether this process start is the first one after a device restart. */
    boolean isColdBoot() {
        return coldBoot;
    }

    // =============================================================================================
    // Cold boot detection
    // =============================================================================================

    /** A start later than this after the kernel booted is not a boot-time start. */
    private static final long COLD_BOOT_MAX_UPTIME_MS = 3 * 60 * 1000L;
    /** A random id the kernel creates at every boot; sleep and wake keep it. */
    private static final String BOOT_ID_PATH = "/proc/sys/kernel/random/boot_id";
    private static final String BOOT_STATE_PREFS = "launcher_boot_state";
    private static final String KEY_LAST_BOOT_ID = "last_boot_id";

    /**
     * Every process of the app creates LauncherApplication (before Android 9 the wallpaper
     * picker's process also gets this far in onCreate()); only the launcher's own process handles
     * the cold start.
     */
    private boolean isMainProcess() {
        String processName = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            processName = Application.getProcessName();
        } else {
            ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> processes =
                    am != null ? am.getRunningAppProcesses() : null;
            if (processes != null) {
                int pid = android.os.Process.myPid();
                for (ActivityManager.RunningAppProcessInfo info : processes) {
                    if (info.pid == pid) {
                        processName = info.processName;
                        break;
                    }
                }
            }
        }
        return processName == null || processName.equals(app.getPackageName());
    }

    /**
     * True only on the first start after a real restart. A wake from sleep keeps the kernel boot
     * id and does not reset elapsedRealtime(), which also counts the time spent asleep.
     */
    private boolean isFirstStartAfterColdBoot() {
        long uptime = SystemClock.elapsedRealtime();
        if (uptime > COLD_BOOT_MAX_UPTIME_MS) {
            Log.d(TAG, "Not a cold boot (uptime " + uptime + " ms), launcher left where it is");
            return false;
        }
        String bootId = readKernelBootId();
        if (bootId == null) {
            // boot_id not readable on this ROM: the uptime check alone decides.
            return true;
        }
        SharedPreferences prefs = app.getSharedPreferences(BOOT_STATE_PREFS, Context.MODE_PRIVATE);
        if (bootId.equals(prefs.getString(KEY_LAST_BOOT_ID, null))) {
            // Same boot, only the process was restarted (crash, killed): already handled.
            Log.d(TAG, "Boot " + bootId + " already handled, launcher left where it is");
            return false;
        }
        prefs.edit().putString(KEY_LAST_BOOT_ID, bootId).apply();
        return true;
    }

    private static String readKernelBootId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOT_ID_PATH))) {
            String id = reader.readLine();
            return (id == null || id.trim().isEmpty()) ? null : id.trim();
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "Cannot read " + BOOT_ID_PATH + ": " + e);
            return null;
        }
    }

    // =============================================================================================
    // Autostart after the boot-time stall
    //
    // The apps the user picked in AppListAutostartDialogFragment (stored under its
    // "boot_autostart_packages"), started once the boot-time stall is over.
    //
    // FYT SystemUI starts the apps on its own autostart list about three seconds after
    // BOOT_COMPLETED, which is exactly when the stall begins. The app's activity then takes the
    // top while system_server is starved, and the launcher's main thread waits ~11 s inside the
    // framework's own activityTopResumedStateLost() call, which no launcher code can avoid. An app
    // moved from FYT's list to this one starts after the stall instead.
    //
    // Display Media Titles is not opened like the others: it is woken by its own broadcast, under
    // whichever of its package names it is installed (see isDisplayMediaTitles()). The dialog takes
    // the picked apps off the Unisoc power manager's start black lists when it is closed.
    // =============================================================================================

    /** Margin after the stall, so that the pane rebuild has usually finished as well. */
    private static final long BOOT_AUTOSTART_MARGIN_MS = 2000L;
    /**
     * Gap between two autostarted apps, and before the launcher comes back after the last one.
     * Each app gets it to come up on its own (JamesDSP closes its window after ~1.4 s) before the
     * next one competes with it for the CPU and for the top.
     */
    private static final long BOOT_AUTOSTART_GAP_MS = 3000L;
    /**
     * Package names under which Display Media Titles (vasyl.titles) may be installed. Another app
     * installed under one of them is opened as before; only the app's name tells them apart.
     */
    private static final List<String> DISPLAY_MEDIA_TITLES_PACKAGES = Arrays.asList(
            "vasyl.titles",
            "com.syu.widget.music",
            "com.syu.screensaver",
            "com.ava.car",
            "cn.teyes.online");
    /** Name (application label) of Display Media Titles, whatever package it is installed under. */
    private static final String DISPLAY_MEDIA_TITLES_LABEL = "Display Media Titles";
    /** Wakes Display Media Titles without opening it; the same action for every variant. */
    private static final String DISPLAY_MEDIA_TITLES_WAKE_ACTION = "vasyl.titles.action.WAKE";

    private static final String JAMES_DSP_WAKE_ACTION = "james.dsp.action.AUTOSTART";

    /**
     * On the main thread, during the boot-time stall: only whether there is anything to start is
     * checked here, from the stored list without PackageManager calls. The rest runs on its own
     * thread once the stall is over, see runBootAutostart().
     */
    private void scheduleBootAutostart(final boolean returnToLauncher) {
        List<String> stored = AppListAutostartDialogFragment.getSelectedPackages(app);
        if (stored.isEmpty()) {
            return;
        }
        long delay = bootStallDelayMs() + BOOT_AUTOSTART_MARGIN_MS;
        Log.i(TAG, "Boot autostart of " + stored + " in " + delay + " ms, "
                + BOOT_AUTOSTART_GAP_MS + " ms apart");
        mainHandler.postDelayed(() -> new Thread(() -> {
            // An exception escaping this thread would end the whole launcher (CrashHandler).
            try {
                runBootAutostart(returnToLauncher);
            } catch (RuntimeException e) {
                Log.w(TAG, "Boot autostart failed", e);
            }
        }, "BootAutostart").start(), delay);
    }

    /**
     * Off the main thread: checking that an app is installed, resolving it, reading its name and
     * starting or waking it are all calls into system_server, and the gaps are plain sleeps on
     * this thread.
     */
    private void runBootAutostart(boolean returnToLauncher) {
        // Uninstalled apps are removed from the stored list here, so they are neither started nor
        // counted, and the autostart dialog numbers the rest without gaps.
        List<String> packages = AppListAutostartDialogFragment.getInstalledSelectedPackages(app);
        if (packages.isEmpty()) {
            return;
        }
        PackageManager pm = app.getPackageManager();
        List<String> started = new ArrayList<>();
        for (String pkg : packages) {
            try {
                boolean titles = isDisplayMediaTitles(pm, pkg);
                boolean boot = hasBootCompletedReceiver(pkg);
                boolean james = pkg.equals("james.dsp");
                Intent launch = pm.getLaunchIntentForPackage(pkg);
                if (!titles && !james && !boot && launch == null) {
                    Log.w(TAG, "Boot autostart: " + pkg
                            + " has neither BOOT_COMPLETED receiver nor launch activity");
                    continue;
                }

                if (!started.isEmpty()) {
                    SystemClock.sleep(BOOT_AUTOSTART_GAP_MS);
                }

                if (titles) {
                    wakeDisplayMediaTitles(pkg);
                } else if (james) {
                    wakeJamesDSP(pkg);
                } else if (boot && bootCompletedAutostart) {
                    autostartWithIntent(pkg);
                } else {
                    launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    app.startActivity(launch);
                }

                started.add(pkg);

                Log.i(TAG, "Boot autostart: "
                        + (titles ? "woke " + pkg + " by broadcast"
                        : james ? "woke " + pkg + " by broadcast"
                        : boot ? "woke " + pkg + " by BOOT_COMPLETED"
                        : "started " + pkg)
                        + " (" + started.size() + "/" + packages.size() + ")");

            } catch (RuntimeException e) {
                Log.w(TAG, "Boot autostart of " + pkg + " failed", e);
            }
        }
        if (returnToLauncher && !started.isEmpty()) {
            SystemClock.sleep(BOOT_AUTOSTART_GAP_MS);
            returnToLauncherAfterAutostart(started);
        }
    }

    /**
     * Whether pkg is Display Media Titles: one of DISPLAY_MEDIA_TITLES_PACKAGES, installed with
     * DISPLAY_MEDIA_TITLES_LABEL as its name. The name is read only for those package names, as
     * that loads the app's resources.
     */
    private static boolean isDisplayMediaTitles(PackageManager pm, String pkg) {
        if (!DISPLAY_MEDIA_TITLES_PACKAGES.contains(pkg)) {
            return false;
        }
        try {
            CharSequence label = pm.getApplicationLabel(pm.getApplicationInfo(pkg, 0));
            return DISPLAY_MEDIA_TITLES_LABEL.equals(label.toString().trim());
        } catch (PackageManager.NameNotFoundException e) {
            return false; // not installed: the launch path skips it
        }
    }

    /**
     * Wakes Display Media Titles with its broadcast instead of opening its activity. setPackage()
     * makes the broadcast explicit, so it reaches the app's manifest receiver on Android 8+ too.
     * FLAG_INCLUDE_STOPPED_PACKAGES also delivers it in the stopped state (never opened since it
     * was installed, or force-stopped), which broadcasts skip by default, and
     * FLAG_RECEIVER_FOREGROUND lets the receiver run at foreground priority.
     */
    private void wakeDisplayMediaTitles(String pkg) {
        Intent intent;
        if (LauncherApplication.hasSystemPrivileges()) {
            intent = new Intent(Intent.ACTION_BOOT_COMPLETED);
            Log.i(TAG, "Display Media Titles by 'BOOT_COMPLETED' broadcast");
        } else {
            intent = new Intent(DISPLAY_MEDIA_TITLES_WAKE_ACTION);
            Log.i(TAG, "Display Media Titles by 'vasyl.titles.action.WAKE' broadcast");
        }
        SysCalls.sendBroadcast(app, intent
                .setPackage(pkg) // package of the installed variant
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES | Intent.FLAG_RECEIVER_FOREGROUND));
    }

    private void wakeJamesDSP(String pkg) {
        Intent intent;
        if (LauncherApplication.hasSystemPrivileges()) {
            intent = new Intent(Intent.ACTION_BOOT_COMPLETED);
            Log.i(TAG, "JamesDSP by 'BOOT_COMPLETED' broadcast");
        } else {
            intent = new Intent(JAMES_DSP_WAKE_ACTION);
            Log.i(TAG, "JamesDSP by 'james.dsp.action.AUTOSTART' broadcast");
        }
        SysCalls.sendBroadcast(app, intent
                .setPackage(pkg)
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES | Intent.FLAG_RECEIVER_FOREGROUND));
    }

    private boolean hasBootCompletedReceiver(String pkg) {
        if (!LauncherApplication.hasSystemPrivileges()) return false;
        Intent intent = new Intent(Intent.ACTION_BOOT_COMPLETED);
        intent.setPackage(pkg);

        List<ResolveInfo> receivers =
                app.getPackageManager().queryBroadcastReceivers(
                        intent,
                        PackageManager.MATCH_ALL
                );

        for (ResolveInfo info : receivers) {
            if (info.activityInfo != null
                    && pkg.equals(info.activityInfo.packageName)) {
                return true;
            }
        }

        return false;
    }

    private void autostartWithIntent(String pkg) {
        SysCalls.sendBroadcast(app, new Intent(Intent.ACTION_BOOT_COMPLETED)
                .setPackage(pkg)
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES | Intent.FLAG_RECEIVER_FOREGROUND));
    }

    /**
     * The autostarted apps do not need to stay in front, as with FYT's autostart during the
     * front guard. The launcher comes back only over one of them, never over something the user
     * has opened meanwhile, and -- the guard's rule, see checkLauncherInFront() -- only once that
     * app's process is up, or Android would never launch its activity.
     */
    private void returnToLauncherAfterAutostart(List<String> started) {
        ComponentName top = topActivity();
        if (top == null || !started.contains(top.getPackageName())) {
            return;
        }
        long deadline = SystemClock.uptimeMillis() + BOOT_FRONT_MAX_START_WAIT_MS;
        while (!isPackageRunning(top.getPackageName()) && SystemClock.uptimeMillis() < deadline) {
            SystemClock.sleep(BOOT_FRONT_STARTING_POLL_MS);
        }
        SystemClock.sleep(BOOT_FRONT_COVER_GRACE_MS);
        top = topActivity();
        if (top == null || !started.contains(top.getPackageName())) {
            return; // it closed itself meanwhile (JamesDSP does), or the user opened something
        }
        Log.i(TAG, "Boot autostart done, bringing the launcher back over " + top.flattenToShortString());
        bringLauncherToFront();
    }

    // =============================================================================================
    // Launcher in front after a device restart
    //
    // For BOOT_FRONT_WINDOW_MS after a cold boot nothing keeps the launcher down: whatever comes up
    // over it (FYT SystemUI's autostart apps, com.syu.ms restoring the last app, ...) is sent back
    // behind it as soon as it has started, as often as it takes. Left in front are only what the
    // user opens from the launcher and a few protected apps (reversing camera, phone, system
    // dialogs); see isProtectedCover(). The checks run on their own thread, see bootFrontThread.
    // =============================================================================================

    /** How long after the start the launcher is kept in front. */
    private static final long BOOT_FRONT_WINDOW_MS = 20000L;
    /** Regular re-check while the guard runs, besides the checks each pause of the launcher triggers. */
    private static final long BOOT_FRONT_CHECK_INTERVAL_MS = 1000L;
    /** First check after the launcher was paused; the system launches what paused it meanwhile. */
    private static final long BOOT_FRONT_PAUSE_CHECK_MS = 250L;
    /** Re-check interval while the covering app's process is still starting. */
    private static final long BOOT_FRONT_STARTING_POLL_MS = 150L;
    /** Longest wait for the covering app's process; after that the launcher comes back anyway. */
    private static final long BOOT_FRONT_MAX_START_WAIT_MS = 10000L;
    /**
     * Time a covering app gets once its process runs, before the launcher comes back: enough for
     * its onCreate(), where autostart activities (openpanorama, JamesDSP) start their service.
     */
    private static final long BOOT_FRONT_COVER_GRACE_MS = 800L;
    /** Minimum time between two pull-backs, and how many there may be at most. */
    private static final long BOOT_FRONT_MIN_PULL_GAP_MS = 400L;
    private static final int BOOT_FRONT_MAX_PULL_BACKS = 15;
    /** A pause of the launcher this soon after a touch or key press in it is the user's doing. */
    private static final long USER_ACTION_GRACE_MS = 1500L;
    /**
     * Never pulled back over, and checked before anything else: a reversing camera must stay
     * visible and a call reachable; system dialogs, recents and phone projection are opened on
     * purpose; vasyl.fytrating's WakeActivity is started by the launcher itself.
     */
    private static final List<String> PROTECTED_COVER_PACKAGES = Arrays.asList(
            "android",
            "com.android.systemui",
            "com.android.launcher3",                   // recents on this ROM
            "com.android.settings",
            "com.android.permissioncontroller",
            "com.google.android.permissioncontroller",
            "com.android.packageinstaller",
            "com.google.android.packageinstaller",
            "com.android.phone",
            "com.android.dialer",
            "com.android.incallui",
            "com.syu.ms",
            "com.syu.bt",
            "com.syu.canbus",
            "com.syu.carlink",
            "com.google.android.projection.gearhead",
            "vasyl.fytrating");
    /** Package name parts of camera apps (reversing, 360 view), which are protected as well. */
    private static final String[] PROTECTED_COVER_NAME_PARTS = {"camera", "panorama", "backcar", "reverse"};

    /**
     * The checks run on their own thread: each of them calls into system_server, which stalls for
     * seconds at boot while the audioserver hangs, and on the main thread every such call froze
     * the launcher along with it.
     */
    private HandlerThread bootFrontThread;
    private volatile Handler bootFrontHandler;
    private final Object bootFrontLock = new Object();
    private volatile boolean bootFrontGuardActive;
    private long bootFrontDeadline;
    /** Resumed activities of this process, counted on the main thread; above 0 = launcher in front. */
    private volatile int resumedActivities;
    /** uptimeMillis() of the last touch or key press in one of this process' windows. */
    private volatile long lastUserInputUptime;
    /** Windows wrapped by UserInputSpy; main thread only. */
    private final List<WeakReference<Window>> spiedWindows = new ArrayList<>();
    private volatile int bootFrontPullBacks;
    /** Guard thread only, like the three fields below. */
    private long lastPullBackUptime;
    /** What covers the launcher, when it was first seen, and since when its process runs (0 = not yet). */
    private ComponentName currentCover;
    private long coverSeenUptime;
    private long coverRunningUptime;

    /** On the main thread, from start(): keeps the launcher in front for BOOT_FRONT_WINDOW_MS. */
    private void startBootFrontGuard(boolean enabled) {
        if (!enabled) {
            Log.i(TAG, "Cold boot, but LAUNCHER_HOME is off: launcher left where it is");
            return;
        }
        Log.i(TAG, "Cold boot, keeping the launcher in front for " + BOOT_FRONT_WINDOW_MS + " ms");
        bootFrontThread = new HandlerThread("BootFrontGuard");
        bootFrontThread.start();
        bootFrontHandler = new Handler(bootFrontThread.getLooper());
        bootFrontGuardActive = true;
        bootFrontDeadline = SystemClock.elapsedRealtime() + BOOT_FRONT_WINDOW_MS;
        // Lifecycle callbacks rather than LauncherApplication.isAppTop(): the launcher's own
        // resumed state is exact, while getRunningTasks() mixes in the PiP panes' tasks.
        app.registerActivityLifecycleCallbacks(resumeTracker);
        scheduleBootFrontCheck(BOOT_FRONT_CHECK_INTERVAL_MS);
    }

    private boolean userActedRecently() {
        long last = lastUserInputUptime;
        return last > 0L && SystemClock.uptimeMillis() - last < USER_ACTION_GRACE_MS;
    }

    /** From the guard's thread or the main thread; the first call wins. */
    private void stopBootFrontGuard(String reason) {
        synchronized (bootFrontLock) {
            if (!bootFrontGuardActive) {
                return;
            }
            bootFrontGuardActive = false;
        }
        bootFrontHandler.removeCallbacks(bootFrontCheck);
        bootFrontThread.quitSafely();
        app.unregisterActivityLifecycleCallbacks(resumeTracker);
        mainHandler.post(this::stopWatchingUserInput);
        Log.i(TAG, "Boot front guard finished: " + reason + " (pulled the launcher back "
                + bootFrontPullBacks + " time(s))");
    }

    private void scheduleBootFrontCheck(long delayMs) {
        Handler handler = bootFrontHandler;
        if (!bootFrontGuardActive || handler == null) {
            return;
        }
        handler.removeCallbacks(bootFrontCheck);
        handler.postDelayed(bootFrontCheck, delayMs);
    }

    private final Runnable bootFrontCheck = new Runnable() {
        @Override
        public void run() {
            if (!bootFrontGuardActive) {
                return;
            }
            try {
                if (SystemClock.elapsedRealtime() > bootFrontDeadline) {
                    stopBootFrontGuard("time window over");
                    return;
                }
                // The display, not PowerManager.isInteractive(): ACC off on FYT only switches the
                // display off and leaves the interactive state (and ACTION_SCREEN_OFF) alone,
                // which is also why WakeDetectionService watches the display.
                if (!isDefaultDisplayOn()) {
                    stopBootFrontGuard("screen off");
                    return;
                }
                long next = checkLauncherInFront();
                if (bootFrontGuardActive) {
                    scheduleBootFrontCheck(next);
                }
            } catch (RuntimeException e) {
                // An exception escaping the guard's thread would end the whole launcher
                // (CrashHandler); the guard ends instead.
                Log.w(TAG, "Boot front guard check failed", e);
                stopBootFrontGuard("error: " + e);
            }
        }
    };

    /** One check, on the guard's thread. Returns when the next one is due. */
    private long checkLauncherInFront() {
        if (resumedActivities > 0) {
            currentCover = null;
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        long now = SystemClock.uptimeMillis();
        ComponentName cover = topActivity();
        if (cover != null && app.getPackageName().equals(cover.getPackageName())) {
            // Our own task is on top and about to be resumed: at start, or right after a pull-back.
            return BOOT_FRONT_STARTING_POLL_MS;
        }
        String name = cover != null ? cover.flattenToShortString() : "an unknown activity";
        if (cover != null && !cover.equals(currentCover)) {
            currentCover = cover;
            coverSeenUptime = now;
            coverRunningUptime = 0L;
            Log.i(TAG, "Launcher covered by " + name
                    + (isProtectedCover(cover.getPackageName()) ? ", which is left in front" : ""));
        }
        if (cover != null && isProtectedCover(cover.getPackageName())) {
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        if (cover != null) {
            if (coverRunningUptime == 0L) {
                if (isPackageRunning(cover.getPackageName())) {
                    coverRunningUptime = now;
                } else if (now - coverSeenUptime < BOOT_FRONT_MAX_START_WAIT_MS) {
                    // Pulling back now would leave its activity unlaunched for good: Android 10
                    // only launches activities of the focused stack when their process comes up.
                    return BOOT_FRONT_STARTING_POLL_MS;
                } else {
                    Log.w(TAG, name + " did not start within " + BOOT_FRONT_MAX_START_WAIT_MS + " ms");
                    coverRunningUptime = now - BOOT_FRONT_COVER_GRACE_MS;
                }
            }
            long graceLeft = coverRunningUptime + BOOT_FRONT_COVER_GRACE_MS - now;
            if (graceLeft > 0L) {
                return graceLeft;
            }
        }
        if (lastPullBackUptime > 0L && now - lastPullBackUptime < BOOT_FRONT_MIN_PULL_GAP_MS) {
            return lastPullBackUptime + BOOT_FRONT_MIN_PULL_GAP_MS - now;
        }
        if (bootFrontPullBacks >= BOOT_FRONT_MAX_PULL_BACKS) {
            stopBootFrontGuard("keeps being covered by " + name + ", giving up");
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        if (!bootFrontGuardActive) {
            // Ended on the main thread during this check, e.g. because the user opened something.
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        bootFrontPullBacks++;
        lastPullBackUptime = now;
        Log.i(TAG, "Bringing the launcher back over " + name + " (" + bootFrontPullBacks + "/"
                + BOOT_FRONT_MAX_PULL_BACKS + ")");
        bringLauncherToFront();
        return BOOT_FRONT_PAUSE_CHECK_MS;
    }

    private static boolean isProtectedCover(String packageName) {
        return PROTECTED_COVER_PACKAGES.contains(packageName) || isCameraPackage(packageName);
    }

    private static boolean isCameraPackage(String packageName) {
        String lower = packageName.toLowerCase(Locale.ROOT);
        for (String part : PROTECTED_COVER_NAME_PARTS) {
            if (lower.contains(part)) {
                return true;
            }
        }
        return false;
    }

    /** Counts the resumed activities of this process; registered only while the guard runs. */
    private final Application.ActivityLifecycleCallbacks resumeTracker = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityResumed(Activity activity) {
            resumedActivities++;
            watchUserInput(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (resumedActivities > 0) {
                resumedActivities--;
            }
            if (resumedActivities > 0 || !bootFrontGuardActive) {
                return;
            }
            if (userActedRecently()) {
                // The user opened something from the launcher: leave it in front.
                stopBootFrontGuard("the user opened something");
            } else {
                scheduleBootFrontCheck(BOOT_FRONT_PAUSE_CHECK_MS);
            }
        }

        @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}
        @Override public void onActivityStarted(Activity activity) {}
        @Override public void onActivityStopped(Activity activity) {}
        @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
        @Override public void onActivityDestroyed(Activity activity) {}
    };

    /**
     * Notes touches and key presses in the activity's window while the guard runs, so that an app
     * the user opens is told apart from one the system brings up. The wrapper forwards everything
     * unchanged and is taken out again when the guard ends. Main thread.
     */
    private void watchUserInput(Activity activity) {
        Window window = activity.getWindow();
        Window.Callback callback = window != null ? window.getCallback() : null;
        if (callback == null || callback instanceof UserInputSpy) {
            return;
        }
        window.setCallback(new UserInputSpy(callback));
        spiedWindows.add(new WeakReference<>(window));
    }

    /** Main thread. */
    private void stopWatchingUserInput() {
        for (WeakReference<Window> ref : spiedWindows) {
            Window window = ref.get();
            // Only if nothing has wrapped our wrapper in the meantime.
            if (window != null && window.getCallback() instanceof UserInputSpy) {
                window.setCallback(((UserInputSpy) window.getCallback()).base);
            }
        }
        spiedWindows.clear();
    }

    private final class UserInputSpy implements Window.Callback {
        final Window.Callback base;

        UserInputSpy(Window.Callback base) {
            this.base = base;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            int action = event.getActionMasked();
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
                lastUserInputUptime = SystemClock.uptimeMillis();
            }
            return base.dispatchTouchEvent(event);
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            lastUserInputUptime = SystemClock.uptimeMillis();
            return base.dispatchKeyEvent(event);
        }

        @Override public boolean dispatchKeyShortcutEvent(KeyEvent event) { return base.dispatchKeyShortcutEvent(event); }
        @Override public boolean dispatchTrackballEvent(MotionEvent event) { return base.dispatchTrackballEvent(event); }
        @Override public boolean dispatchGenericMotionEvent(MotionEvent event) { return base.dispatchGenericMotionEvent(event); }
        @Override public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) { return base.dispatchPopulateAccessibilityEvent(event); }
        @Override public View onCreatePanelView(int featureId) { return base.onCreatePanelView(featureId); }
        @Override public boolean onCreatePanelMenu(int featureId, Menu menu) { return base.onCreatePanelMenu(featureId, menu); }
        @Override public boolean onPreparePanel(int featureId, View view, Menu menu) { return base.onPreparePanel(featureId, view, menu); }
        @Override public boolean onMenuOpened(int featureId, Menu menu) { return base.onMenuOpened(featureId, menu); }
        @Override public boolean onMenuItemSelected(int featureId, MenuItem item) { return base.onMenuItemSelected(featureId, item); }
        @Override public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) { base.onWindowAttributesChanged(attrs); }
        @Override public void onContentChanged() { base.onContentChanged(); }
        @Override public void onWindowFocusChanged(boolean hasFocus) { base.onWindowFocusChanged(hasFocus); }
        @Override public void onAttachedToWindow() { base.onAttachedToWindow(); }
        @Override public void onDetachedFromWindow() { base.onDetachedFromWindow(); }
        @Override public void onPanelClosed(int featureId, Menu menu) { base.onPanelClosed(featureId, menu); }
        @Override public boolean onSearchRequested() { return base.onSearchRequested(); }
        @Override public boolean onSearchRequested(SearchEvent searchEvent) { return base.onSearchRequested(searchEvent); }
        @Override public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) { return base.onWindowStartingActionMode(callback); }
        @Override public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) { return base.onWindowStartingActionMode(callback, type); }
        @Override public void onActionModeStarted(ActionMode mode) { base.onActionModeStarted(mode); }
        @Override public void onActionModeFinished(ActionMode mode) { base.onActionModeFinished(mode); }
        @Override public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) { base.onProvideKeyboardShortcuts(data, menu, deviceId); }
        @Override public void onPointerCaptureChanged(boolean hasCapture) { base.onPointerCaptureChanged(hasCapture); }
    }

    // =============================================================================================
    // Last app back in front after a device restart (LAUNCHER_HOME off)
    //
    // The stock launcher stays behind the app that was in front when the device went off. After a
    // restart com.syu.ms has nothing to open over this launcher (capture 08-10-2026:
    // sTopAppWhenMcuOff empty at boot, though it was com.syu.carlink at the power-off), so the
    // launcher opens that app itself. ForegroundAppTracker reports each app in front on the main
    // display, noteForegroundApp() keeps the last one.
    // =============================================================================================

    private static final String KEY_LAST_APP = "last_foreground_app";
    /** After com.syu.ms's own restore (~2 s after the start), before the panes are built. */
    private static final long LAST_APP_RESTORE_DELAY_MS = 2500L;
    /** Shown only for a while (system dialogs, recents): the app before them stays noted. */
    private static final List<String> TRANSIENT_PACKAGES = Arrays.asList(
            "android", "com.android.systemui", "com.android.launcher3");

    /** From ForegroundAppTracker, main thread. The launcher itself counts as no app. */
    public static void noteForegroundApp(Context context, String packageName) {
        if (TRANSIENT_PACKAGES.contains(packageName) || isCameraPackage(packageName)) {
            return;
        }
        String last = packageName.equals(context.getPackageName()) ? "" : packageName;
        context.getSharedPreferences(BOOT_STATE_PREFS, Context.MODE_PRIVATE)
                .edit().putString(KEY_LAST_APP, last).apply();
    }

    /** Main thread, from start(): read before ForegroundAppTracker notes the launcher instead. */
    private void scheduleLastAppRestore() {
        final String pkg = app.getSharedPreferences(BOOT_STATE_PREFS, Context.MODE_PRIVATE)
                .getString(KEY_LAST_APP, "");
        if (pkg.isEmpty()) {
            return;
        }
        Log.i(TAG, "Cold boot: bringing back " + pkg + " in " + LAST_APP_RESTORE_DELAY_MS + " ms");
        // Its own thread: both calls go into system_server, which stalls at boot.
        mainHandler.postDelayed(() -> new Thread(() -> {
            try {
                // Only over the home screen: whatever else is in front by then (com.syu.ms's
                // restore, a reversing camera, the user's choice) stays.
                ComponentName top = topActivity();
                Intent launch = app.getPackageManager().getLaunchIntentForPackage(pkg);
                if (launch == null || !new ComponentName(app, Launcher.class).equals(top)) {
                    Log.i(TAG, pkg + " not brought back: " + (launch == null ? "no launch activity"
                            : (top != null ? top.flattenToShortString() : "unknown") + " in front"));
                    return;
                }
                app.startActivity(launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                Log.i(TAG, "Brought back " + pkg);
            } catch (RuntimeException e) {
                // Escaping this thread it would end the whole launcher (CrashHandler).
                Log.w(TAG, "Bringing back " + pkg + " failed", e);
            }
        }, "LastAppRestore").start(), LAST_APP_RESTORE_DELAY_MS);
    }

    // =============================================================================================
    // System state (from the guard's thread and the autostart thread)
    // =============================================================================================

    /**
     * Top activity on the default display; see DefaultDisplayTask for why the PiP panes' tasks are
     * skipped. The launcher runs as uid 1000, so other apps' tasks are included (for an ordinary
     * app getRunningTasks() would hide them).
     */
    private ComponentName topActivity() {
        try {
            ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
            return am != null ? DefaultDisplayTask.topActivity(am) : null;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot read the top task: " + e);
            return null;
        }
    }

    /**
     * Whether a process with this package is up. Only uid 1000 sees other apps' processes here;
     * without it, or on any error, the answer is true so the guard never waits on a guess.
     */
    private boolean isPackageRunning(String packageName) {
        if (android.os.Process.myUid() != android.os.Process.SYSTEM_UID) {
            return true;
        }
        try {
            ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> processes =
                    am != null ? am.getRunningAppProcesses() : null;
            if (processes == null) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo info : processes) {
                if (packageName.equals(info.processName)) {
                    return true;
                }
                if (info.pkgList != null) {
                    for (String pkg : info.pkgList) {
                        if (packageName.equals(pkg)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }

    /** Unknown counts as on, as in WakeDetectionService. */
    private boolean isDefaultDisplayOn() {
        DisplayManager dm = (DisplayManager) app.getSystemService(Context.DISPLAY_SERVICE);
        Display display = dm != null ? dm.getDisplay(Display.DEFAULT_DISPLAY) : null;
        return display == null || display.getState() == Display.STATE_ON;
    }

    /**
     * Same approach as WakeDetectionService.pressHomeButton(), which the wake logs show working on
     * this ROM: a live launcher gets its task moved to the front (no new intent, no second
     * ActivityRecord). The HOME intent is only the fallback when there is no launcher activity;
     * the launcher runs as uid 1000, so the explicit component still counts as a Home start.
     */
    private void bringLauncherToFront() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher != null && !launcher.isFinishing() && !launcher.isDestroyed()) {
            try {
                ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
                if (am != null) {
                    am.moveTaskToFront(launcher.getTaskId(), 0);
                    return;
                }
            } catch (RuntimeException e) {
                Log.w(TAG, "moveTaskToFront failed, falling back to the HOME intent", e);
            }
        }
        Intent home = new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_HOME)
                .setClass(app, Launcher.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            app.startActivity(home);
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot bring the launcher to front", e);
        }
    }
}
