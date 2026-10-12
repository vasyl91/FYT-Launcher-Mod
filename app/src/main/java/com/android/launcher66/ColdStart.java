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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.AppListAutostartDialogFragment;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.LogcatWorker;
import com.android.launcher66.settings.WakeDetection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The launcher's first start after a device restart (a cold boot), as opposed to a wake from
 * sleep, which WakeDetection handles.
 *
 * <ul>
 *   <li><b>Boot-time stall:</b> at every boot this ROM blocks all calls into system_server for
 *       about ten seconds; work that can wait is deferred past it, see {@link #bootStallDelayMs()}.
 *   <li><b>Launcher in front:</b> for a while after the restart, whatever comes up over the
 *       launcher is sent back behind it (setting Keys.LAUNCHER_HOME_COLD_START, see
 *       HomeFrontGuard); with it off, the app that was in front before the restart is opened again.
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
     * The boot is recorded even with Keys.LAUNCHER_HOME_COLD_START off. Otherwise switching it on in the first
     * minutes after a restart would make the next process restart (crash, update) look like the
     * first start of this boot, and the launcher could be pulled over an app the user has opened.
     */
    static ColdStart start(Application app, SharedPreferences settings) {
        ColdStart coldStart = new ColdStart(app);
        coldStart.coldBoot = coldStart.isMainProcess() && coldStart.isFirstStartAfterColdBoot();
        startLogcat(app, coldStart.coldBoot, settings);
        if (coldStart.coldBoot) {
            boolean launcherHome = settings.getBoolean(Keys.LAUNCHER_HOME_COLD_START, true);
            bootCompletedAutostart = settings.getBoolean(Keys.AUTOSTART_APPS_BY_BOOT_COMPLETED, true);
            coldStart.startBootFrontGuard(launcherHome);
            if (!launcherHome) {
                coldStart.scheduleLastAppRestore(settings);
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

    /** The kernel's id of the running boot; null if it cannot be read. Also used by WakeSignals. */
    public static String readKernelBootId() {
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
        final long began = SystemClock.elapsedRealtime();
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
            returnToLauncherAfterAutostart(started, began);
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
     * has opened meanwhile, nor when the user has touched the screen (or pressed a button FYT
     * reports) since the autostart began -- one of these apps may be in use by then -- and -- the
     * guard's rule, see HomeFrontGuard.checkLauncherInFront() -- only once that app's process is
     * up, or Android would never launch its activity.
     */
    private void returnToLauncherAfterAutostart(List<String> started, long autostartBegan) {
        ComponentName top = HomeFrontGuard.topActivity(app);
        if (top == null || !started.contains(top.getPackageName())) {
            return;
        }
        long deadline = SystemClock.uptimeMillis() + HomeFrontGuard.MAX_START_WAIT_MS;
        while (!HomeFrontGuard.isPackageRunning(app, top.getPackageName())
                && SystemClock.uptimeMillis() < deadline) {
            SystemClock.sleep(HomeFrontGuard.STARTING_POLL_MS);
        }
        SystemClock.sleep(HomeFrontGuard.COVER_GRACE_MS);
        top = HomeFrontGuard.topActivity(app);
        if (top == null || !started.contains(top.getPackageName())) {
            return; // it closed itself meanwhile (JamesDSP does), or the user opened something
        }
        if (HomeFrontGuard.userActedSince(autostartBegan)) {
            Log.i(TAG, "Boot autostart done, but the user has acted since: "
                    + top.flattenToShortString() + " left in front");
            return;
        }
        Log.i(TAG, "Boot autostart done, bringing the launcher back over " + top.flattenToShortString());
        HomeFrontGuard.bringLauncherToFront(app);
    }

    // =============================================================================================
    // Launcher in front after a device restart
    //
    // What the device opens over the launcher after a cold boot (FYT SystemUI's autostart apps,
    // com.syu.ms restoring the last app or opening the navigation, ...) is sent back behind it;
    // what the user opens stays. See HomeFrontGuard.
    // =============================================================================================

    /** How long after the start whatever comes up is taken for the device's own, at least ... */
    private static final long BOOT_FRONT_WINDOW_MS = 20000L;
    /**
     * ... and until this long after the boot-time stall. What the device opens comes before and
     * during the stall (FYT SystemUI's autostart about 3 s after BOOT_COMPLETED, which is when the
     * stall begins) and shows once it is over; a window counted from the start alone had mostly
     * gone by in the stall. The user can hardly open anything before it is over, while anything
     * that comes up later is more likely the user's than the device's -- and with no touch to
     * tell, a button on the steering wheel (FYT reports some, see UserTouches) would be taken for
     * the device's. So only a short margin.
     */
    private static final long BOOT_FRONT_AFTER_STALL_MS = 5000L;

    /** On the main thread, from start(). */
    private void startBootFrontGuard(boolean enabled) {
        if (!enabled) {
            Log.i(TAG, "Cold boot, but LAUNCHER_HOME_COLD_START is off: launcher left where it is");
            return;
        }
        long window = Math.max(BOOT_FRONT_WINDOW_MS, bootStallDelayMs() + BOOT_FRONT_AFTER_STALL_MS);
        Log.i(TAG, "Cold boot, what comes up within " + window + " ms is taken for the device's own");
        HomeFrontGuard.expect(Collections.singleton(HomeFrontGuard.ANY_APP), window, false, "cold boot");
        HomeFrontGuard.start(app, "Boot", HomeFrontGuard.CHECK_INTERVAL_MS,
                HomeFrontGuard.CHECK_INTERVAL_MS, true);
    }

    // =============================================================================================
    // Last app back in front after a device restart or a wake (LAUNCHER_HOME_COLD_START or
    // LAUNCHER_HOME_WAKE off)
    //
    // The stock launcher stays behind the app that was in front when the device went off. After a
    // restart com.syu.ms has nothing to open over this launcher (capture 08-10-2026:
    // sTopAppWhenMcuOff empty at boot, though it was com.syu.carlink at the power-off), so the
    // launcher opens that app itself. ForegroundAppTracker reports each app in front on the main
    // display, noteForegroundApp() keeps the last one. After a wake WakeDetection does the
    // same with the app noted when the device went to sleep.
    // =============================================================================================

    private static final String KEY_LAST_APP = "last_foreground_app";
    /**
     * At a cold boot, for the stock apps (com.syu.*, com.fyt.*) always and for the others with
     * Keys.COLD_START_LAST_APP_DELAY: com.syu.ms starts the services it keeps alive up to 4.1 s
     * after the launcher's start, and com.syu.carlink opened before its service crashed (capture
     * 09-10-2026 01:10:12: launcher 26.5 s, carlink opened 29.0 s, its service only 30.6 s).
     */
    private static final long COLD_BOOT_SAFE_RESTORE_DELAY_MS = 5000L;
    /** With that delay, how long the app is watched for dying right after its start. */
    private static final long LAST_APP_WATCH_MS = 2000L;
    private static final long LAST_APP_WATCH_STEP_MS = 500L;
    /** Shown only for a while (system dialogs, recents): the app before them stays noted. */
    private static final List<String> TRANSIENT_PACKAGES = Arrays.asList(
            "android", "com.android.systemui", "com.android.launcher3");

    /** From ForegroundAppTracker, main thread. The launcher itself counts as no app. */
    public static void noteForegroundApp(Context context, String packageName) {
        if (TRANSIENT_PACKAGES.contains(packageName) || HomeFrontGuard.isCameraPackage(packageName)
                || WakeDetection.isAsleep()) {
            return;
        }
        String last = packageName.equals(context.getPackageName()) ? "" : packageName;
        context.getSharedPreferences(BOOT_STATE_PREFS, Context.MODE_PRIVATE)
                .edit().putString(KEY_LAST_APP, last).apply();
    }

    /** The app noted last; "" for the home screen, or when nothing has been noted. */
    public static String lastApp(Context context) {
        return context.getSharedPreferences(BOOT_STATE_PREFS, Context.MODE_PRIVATE)
                .getString(KEY_LAST_APP, "");
    }

    /** Main thread, from start(): read before ForegroundAppTracker notes the launcher instead. */
    private void scheduleLastAppRestore(SharedPreferences settings) {
        final String pkg = lastApp(app);
        if (pkg.isEmpty()) {
            return;
        }
        boolean safe = pkg.startsWith("com.syu.") || pkg.startsWith("com.fyt.")
                || settings.getBoolean(Keys.COLD_START_LAST_APP_DELAY, false);
        if (safe) {
            Log.i(TAG, "Cold boot: bringing back " + pkg + " in " + COLD_BOOT_SAFE_RESTORE_DELAY_MS
                    + " ms, watched for " + LAST_APP_WATCH_MS + " ms");
            mainHandler.postDelayed(() -> bringBackLastApp(app, pkg, LAST_APP_WATCH_MS),
                    COLD_BOOT_SAFE_RESTORE_DELAY_MS);
            return;
        }
        // No delay: as soon as the home screen is up, the only thing it is opened over.
        Log.i(TAG, "Cold boot: bringing back " + pkg + " once the home screen is up");
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityResumed(Activity activity) {
                if (activity instanceof Launcher) {
                    app.unregisterActivityLifecycleCallbacks(this);
                    bringBackLastApp(app, pkg, 0L);
                }
            }

            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}
            @Override public void onActivityStarted(Activity activity) {}
            @Override public void onActivityPaused(Activity activity) {}
            @Override public void onActivityStopped(Activity activity) {}
            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
            @Override public void onActivityDestroyed(Activity activity) {}
        });
    }

    /**
     * Puts pkg, the app that was in front ("" = the home screen), back in front -- over the
     * launcher's home screen, or over a PiP pane's app that com.syu.ms opened full screen: it
     * takes the panes' apps for the top app (capture 09-10-2026: sTopAppWhenMcuOff Maps, a pane,
     * with the home screen in front). Whatever else is in front (a reversing camera, the user's
     * choice) stays. On its own thread: the calls go into system_server, which stalls at boot.
     * With watchMs above 0 the app is watched that long for dying, see watchLastApp().
     */
    public static void bringBackLastApp(Context context, String pkg, long watchMs) {
        final Context app = context.getApplicationContext();
        new Thread(() -> {
            try {
                ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
                ComponentName top = am != null ? DefaultDisplayTask.topActivity(am) : null;
                if (top != null && top.getPackageName().equals(pkg)) {
                    return; // already back, com.syu.ms's own restore
                }
                boolean overHome = new ComponentName(app, Launcher.class).equals(top);
                boolean overPane = top != null && !top.getPackageName().equals(pkg)
                        && isPipPackage(app, top.getPackageName());
                if (!overHome && !overPane) {
                    Log.i(TAG, (pkg.isEmpty() ? "Home screen" : pkg) + " not brought back: "
                            + (top != null ? top.flattenToShortString() : "unknown") + " in front");
                    return;
                }
                Intent launch = pkg.isEmpty() ? null : app.getPackageManager().getLaunchIntentForPackage(pkg);
                if (launch != null) {
                    app.startActivity(launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    Log.i(TAG, "Brought back " + pkg + " over " + top.flattenToShortString());
                    watchLastApp(app, am, pkg, launch, watchMs);
                } else if (overPane) {
                    Launcher launcher = Launcher.getLauncher();
                    if (launcher != null) {
                        am.moveTaskToFront(launcher.getTaskId(), 0);
                        Log.i(TAG, "Brought back the home screen over " + top.flattenToShortString());
                    }
                }
            } catch (RuntimeException e) {
                // Escaping this thread it would end the whole launcher (CrashHandler).
                Log.w(TAG, "Bringing back " + pkg + " failed", e);
            }
        }, "LastAppRestore").start();
    }

    /**
     * Opens pkg once more if it dies within watchMs of being brought back. com.syu.carlink
     * opened before com.syu.ms had started its service crashed on its own (capture 09-10-2026
     * 29.558, FileNotFoundException for /sdcard/carlink/logo/car_log.png), and once the boot-time
     * stall let go of it, the launcher under it came back. A crash removes the app's task; pressing
     * Home leaves it in the background, so a task still there means the user went home. Kept
     * short, so that an app the user closes on purpose is not opened again.
     */
    private static void watchLastApp(Context app, ActivityManager am, String pkg, Intent launch,
                                     long watchMs) {
        ComponentName home = new ComponentName(app, Launcher.class);
        for (long waited = 0L; waited < watchMs; waited += LAST_APP_WATCH_STEP_MS) {
            SystemClock.sleep(LAST_APP_WATCH_STEP_MS);
            ComponentName top = DefaultDisplayTask.topActivity(am);
            if (top == null || top.getPackageName().equals(pkg)) {
                continue;
            }
            if (home.equals(top) && !hasTask(am, pkg)) {
                app.startActivity(launch);
                Log.i(TAG, "Brought back " + pkg + " again, it died after its start");
            }
            return;
        }
    }

    private static boolean hasTask(ActivityManager am, String pkg) {
        for (ActivityManager.RunningTaskInfo task : am.getRunningTasks(32)) {
            if ((task.baseActivity != null && pkg.equals(task.baseActivity.getPackageName()))
                    || (task.topActivity != null && pkg.equals(task.topActivity.getPackageName()))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPipPackage(Context context, String pkg) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (!prefs.getBoolean(Keys.DISPLAY_PIP, true)) {
            return false;
        }
        for (String key : new String[]{Keys.PIP_FIRST_PACKAGE, Keys.PIP_SECOND_PACKAGE,
                Keys.PIP_THIRD_PACKAGE, Keys.PIP_FOURTH_PACKAGE}) {
            if (pkg.equals(prefs.getString(key, ""))) {
                return true;
            }
        }
        return false;
    }
}
