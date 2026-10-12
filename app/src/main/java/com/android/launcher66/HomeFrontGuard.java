package com.android.launcher66;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
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

import com.syu.car.CarStates;
import com.syu.ipc.data.FinalMain;
import com.syu.util.UserTouches;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Keeps the home screen in front against what the device brings up by itself -- and only against
 * that: whatever the user opens stays in front.
 *
 * <p>Runs after a wake (WakeDetection, Keys.LAUNCHER_HOME_WAKE), and after the launcher itself has
 * stopped a pane's app, which com.syu.ms then opens again full screen (see expectSystemLaunch()).
 * One at a time. Not after a cold boot: the device opens nothing by itself then (com.syu.ms's
 * sTopAppWhenMcuOff is empty after a restart, and nothing came up in any capture), and an app
 * taken for the device's only because it came up early was the user's -- opened with adb or a
 * button, com.syu.filemanager was sent back (12-10-2026).
 *
 * <p>An app that comes up over the launcher (a "cover") is sent back behind it only when both hold:
 * <ul>
 *   <li>it is the very app the device was expected to open just then (see Expectations): after a
 *       wake the app com.syu.ms opens again -- the one it took for the top app when the MCU went
 *       off, noted by WakeDetection at that moment; a pane's app the launcher has just stopped.
 *       Never "any app": a button can open any app, and nothing of it is seen;
 *   <li>nothing says the user opened it: no touch (with system privileges anywhere on the screen,
 *       see UserTouches, otherwise in the launcher's own windows) and no button reported by FYT's
 *       framework, from shortly before it came up on.
 * </ul>
 * Any other cover is left in front -- the user's, or one that cannot be shown to be the device's:
 * a button on the steering wheel opens apps through com.syu.ms, and nothing of it reaches Android
 * (captures 12-10-2026). The guard goes on until nothing more is expected, and what the device
 * opens over such an app is sent back behind that app, not behind the launcher: in one capture the
 * user opened a car info page with a wheel button 0.2 s into a wake, and com.syu.ms's YouTube came
 * up over it 0.7 s later.
 *
 * <p>Never sent back either: the protected apps (reversing camera, phone, system dialogs, and
 * unless they are exactly what the device was expected to open, the apps opened on purpose), see
 * isProtected(), and nothing at all while the reverse gear or a call is on.
 *
 * <p>What is in front is read from the task stack, which only a launcher with system privileges
 * sees whole -- not from the launcher's own lifecycle, which runs on the main thread, and that
 * stalls for about 2 s on the first frame after a wake. Without system privileges it comes from
 * the usage events (if usage access is given) and the lifecycle; an app that cannot be seen is
 * never sent back.
 *
 * <p>The checks run on the guard's own thread: each of them calls into system_server, which stalls
 * for seconds at boot while the audioserver hangs, and on the main thread every such call froze
 * the launcher along with it.
 */
public final class HomeFrontGuard {

    private static final String TAG = "HomeFrontGuard";

    /** Regular re-check while the guard runs, besides the checks each pause of the launcher triggers. */
    static final long CHECK_INTERVAL_MS = 1000L;
    /**
     * The same for a short expectation (a wake, an app the launcher has stopped): what the device
     * opens is to be seen within its window, and before the user can open something over it.
     */
    public static final long FAST_CHECK_INTERVAL_MS = 250L;
    /** First check after the launcher was paused; the system launches what paused it meanwhile. */
    static final long PAUSE_CHECK_MS = 250L;
    /** Re-check interval while the launcher's own task is about to be resumed. */
    static final long STARTING_POLL_MS = 150L;
    /**
     * For ColdStart's boot autostart: the longest wait for an autostarted app's process, and the
     * time it gets once that runs before the launcher comes back -- enough for its onCreate(),
     * where autostart activities (openpanorama, JamesDSP) start their service.
     */
    static final long MAX_START_WAIT_MS = 10000L;
    static final long COVER_GRACE_MS = 800L;
    /** Minimum time between two pull-backs, and how many there may be at most. */
    private static final long MIN_PULL_GAP_MS = 400L;
    private static final int MAX_PULL_BACKS = 15;
    /**
     * An app comes up within this of the touch or button that opened it, including the time the
     * guard takes to notice it: input this long before a cover was first seen makes it the user's.
     */
    static final long USER_LAUNCH_LATENCY_MS = 3000L;
    /** How long the guard goes on after the last expectation has run out. */
    private static final long END_MARGIN_MS = 2000L;
    /**
     * com.syu.ms opens the app it keeps as the top one again ~100 ms after the launcher has stopped
     * it (capture in WindowUtil.coldResetPipStack()).
     */
    public static final long RELAUNCH_EXPECT_MS = 3000L;
    /** While the keyguard is up nothing under it shows; the guard waits for it to go. */
    private static final long KEYGUARD_POLL_MS = 500L;
    /** How far back the usage events are read for the app in front. */
    private static final long USAGE_LOOKBACK_MS = 60_000L;
    /**
     * Never pulled back over, whatever was expected: a reversing camera must stay visible and a
     * call reachable; system dialogs are the system's; vasyl.fytrating's WakeActivity is started
     * by the launcher itself.
     */
    private static final List<String> ALWAYS_PROTECTED_PACKAGES = Arrays.asList(
            "android",
            "com.android.systemui",
            "com.android.permissioncontroller",
            "com.google.android.permissioncontroller",
            "com.android.packageinstaller",
            "com.google.android.packageinstaller",
            "com.android.phone",
            "com.android.dialer",
            "com.android.incallui",
            "com.syu.ms",
            "vasyl.fytrating");
    /**
     * Opened on purpose -- recents, settings, the head unit's Bluetooth and car info apps, phone
     * projection -- and pulled back over only when it is exactly the app the device was expected
     * to open: com.syu.ms opens com.syu.carlink again at a wake if it was in front at the sleep
     * (capture 12-10-2026 04:49:11), and a wheel button opens a com.syu.canbus page.
     */
    private static final List<String> PROTECTED_UNLESS_EXPECTED_PACKAGES = Arrays.asList(
            "com.android.launcher3",                   // recents on this ROM
            "com.android.settings",
            "com.syu.bt",
            "com.syu.canbus",
            "com.syu.carlink",
            "com.google.android.projection.gearhead");
    /**
     * Package name parts of camera apps (reversing, 360 view), which are protected as well.
     * "panoram" for openpanorama and FYT's own 360 view, com.syu.panoramic (FytPackage.INNER360).
     */
    private static final String[] PROTECTED_COVER_NAME_PARTS = {"camera", "panoram", "backcar", "reverse"};

    // =============================================================================================
    // What the device itself is expected to bring up
    // =============================================================================================

    /**
     * The apps the device is expected to open, each until a given time, for the whole process.
     * Pure bookkeeping, any thread; package-private for the tests.
     */
    static final class Expectations {

        /** Matches one cover only. */
        static final class Entry {
            final Set<String> packages;
            final long untilElapsed;
            final String reason;
            boolean used;

            Entry(Set<String> packages, long untilElapsed, String reason) {
                this.packages = packages;
                this.untilElapsed = untilElapsed;
                this.reason = reason;
            }
        }

        /** Entries this long past their end are dropped. */
        private static final long KEEP_MS = 60_000L;

        private final List<Entry> entries = new ArrayList<>();

        synchronized void add(Collection<String> packages, long untilElapsed, String reason,
                              long nowElapsed) {
            for (Iterator<Entry> it = entries.iterator(); it.hasNext(); ) {
                Entry entry = it.next();
                if (entry.used || entry.untilElapsed < nowElapsed - KEEP_MS) {
                    it.remove();
                }
            }
            entries.add(new Entry(new HashSet<>(packages), untilElapsed, reason));
        }

        /**
         * What a cover first seen at seenAt was expected as, null if nothing. "" (a cover that
         * cannot be seen) never matches.
         */
        synchronized Entry match(String pkg, long seenAtElapsed) {
            if (pkg.isEmpty()) {
                return null;
            }
            for (Entry entry : entries) {
                if (!entry.used && seenAtElapsed <= entry.untilElapsed
                        && entry.packages.contains(pkg)) {
                    return entry;
                }
            }
            return null;
        }

        synchronized void use(Entry entry) {
            entry.used = true;
        }

        /** Whether an entry not used yet names this package at that time. */
        synchronized boolean namesUnused(String pkg, long atElapsed) {
            for (Entry entry : entries) {
                if (!entry.used && atElapsed <= entry.untilElapsed && entry.packages.contains(pkg)) {
                    return true;
                }
            }
            return false;
        }

        /** When the last open entry runs out; 0 if there is none. */
        synchronized long lastUntil() {
            long last = 0L;
            for (Entry entry : entries) {
                if (!entry.used) {
                    last = Math.max(last, entry.untilElapsed);
                }
            }
            return last;
        }

        synchronized void clear() {
            entries.clear();
        }
    }

    /**
     * Whether a cover first seen at coverSeen is the user's: there was a touch or button press from
     * USER_LAUNCH_LATENCY_MS before it on (0 = none ever).
     */
    static boolean isUsersLaunch(long lastInputElapsed, long coverSeenElapsed) {
        return lastInputElapsed > 0L && lastInputElapsed >= coverSeenElapsed - USER_LAUNCH_LATENCY_MS;
    }

    private static final Expectations EXPECTED = new Expectations();
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /**
     * Any thread. One of packages may come up within windowMs from now as the device's own; one
     * cover only is taken for it.
     */
    public static void expect(Collection<String> packages, long windowMs, String reason) {
        if (packages.isEmpty()) {
            return;
        }
        long now = SystemClock.elapsedRealtime();
        EXPECTED.add(packages, now + windowMs, reason, now);
        Log.i(TAG, "Expecting " + packages + " within " + windowMs + " ms (" + reason + ")");
    }

    /**
     * Any thread, right before the launcher stops an app that com.syu.ms then opens again full
     * screen (a pane's app). Each package is expected once; a guard is started for it unless one
     * runs, if the launcher is in front -- that is what the app would cover.
     */
    public static void expectSystemLaunch(Context context, Collection<String> packages, String reason) {
        for (String pkg : packages) {
            expect(Collections.singleton(pkg), RELAUNCH_EXPECT_MS, reason);
        }
        final Context app = context.getApplicationContext();
        MAIN.post(() -> {
            if (sCurrent == null && sResumedActivities > 0) {
                start(app, reason, PAUSE_CHECK_MS, FAST_CHECK_INTERVAL_MS);
            }
        });
    }

    /**
     * Any thread: whether the user has touched the screen (as far as UserTouches sees it) or
     * pressed a button FYT's framework reports since sinceElapsed.
     */
    public static boolean userActedSince(long sinceElapsed) {
        long since = UserTouches.sinceLastInputMs();
        return since != Long.MAX_VALUE && SystemClock.elapsedRealtime() - since >= sinceElapsed;
    }

    // =============================================================================================
    // The activities of this process, counted for as long as the process lives (main thread)
    // =============================================================================================

    /** Resumed activities of this process; above 0 = launcher in front. */
    private static volatile int sResumedActivities;
    /** The activity resumed last; its window is watched when a guard starts with it in front. */
    private static WeakReference<Activity> sLastResumed = new WeakReference<>(null);
    private static volatile HomeFrontGuard sCurrent;

    /**
     * From LauncherApplication.onCreate(), before a guard can start. Lifecycle callbacks rather
     * than LauncherApplication.isAppTop(): the launcher's own resumed state is exact, while
     * getRunningTasks() mixes in the PiP panes' tasks. Counted all the time, as a guard started
     * after a wake finds the launcher already resumed.
     */
    static void trackActivities(Application app) {
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityResumed(Activity activity) {
                sResumedActivities++;
                sLastResumed = new WeakReference<>(activity);
                HomeFrontGuard guard = sCurrent;
                if (guard != null) {
                    guard.watchUserInput(activity);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {
                if (sResumedActivities > 0) {
                    sResumedActivities--;
                }
                HomeFrontGuard guard = sCurrent;
                if (guard != null) {
                    guard.onOwnActivityPaused();
                }
            }

            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}
            @Override public void onActivityStarted(Activity activity) {}
            @Override public void onActivityStopped(Activity activity) {}
            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
            @Override public void onActivityDestroyed(Activity activity) {}
        });
    }

    /**
     * Main thread. Starts a guard, ending one that runs; it goes on for as long as something is
     * expected (see expect()), the first check after firstCheckMs, then every intervalMs. name is
     * for the log.
     */
    public static void start(Context context, String name, long firstCheckMs, long intervalMs) {
        HomeFrontGuard previous = sCurrent;
        if (previous != null) {
            previous.stop("replaced by " + name);
        }
        HomeFrontGuard guard = new HomeFrontGuard(context.getApplicationContext(), name, intervalMs);
        synchronized (HomeFrontGuard.class) {
            sCurrent = guard;
        }
        Log.i(TAG, name + ": keeping the home screen in front of what the device opens by itself");
        // After a wake the launcher may already be in front: its touches must count too.
        Activity resumed = sResumedActivities > 0 ? sLastResumed.get() : null;
        if (resumed != null) {
            guard.watchUserInput(resumed);
        }
        guard.scheduleCheck(firstCheckMs);
    }

    /** Any thread: ends the guard that is running, if there is one. */
    public static void stopCurrent(String reason) {
        HomeFrontGuard guard = sCurrent;
        if (guard != null) {
            guard.stop(reason);
        }
    }

    /** Any thread, at a sleep: ends the guard and forgets what was expected. */
    public static void reset(String reason) {
        stopCurrent(reason);
        EXPECTED.clear();
    }

    // =============================================================================================
    // One guard
    // =============================================================================================

    private final Context app;
    private final String name;
    private final long interval;
    private final HandlerThread thread;
    private final Handler handler;
    private final Object lock = new Object();
    private volatile boolean active = true;
    /** elapsedRealtime() of the last touch or key press in one of this process' windows. */
    private volatile long lastUserInput;
    /** Windows wrapped by UserInputSpy; main thread only. */
    private final List<WeakReference<Window>> spiedWindows = new ArrayList<>();
    private volatile int pullBacks;
    /** Guard thread only, like the fields below. */
    private long lastPullBack;
    /**
     * What covers the launcher ("" = not known) and its task (-1 = not known), and when it was
     * first seen.
     */
    private String currentCover;
    private int currentCoverTask = -1;
    private long coverSeen;
    /** What the current cover was expected as; null until that is known. */
    private Expectations.Entry coverExpected;
    /** Whether the current cover is left in front for good: the user's, or not the device's. */
    private boolean coverLeft;
    /** Why the launcher was last left covered, for the log. */
    private String lastProtection;
    /** Tasks left in front for good; they stay so whenever they are in front again. */
    private final Set<Integer> leftTasks = new HashSet<>();
    /**
     * The app last left in front over the launcher (the user's, or a protected one); what the
     * device opens over it is sent back behind it. Null: the launcher.
     */
    private Front leftInFront;
    /** Tasks this guard has sent back: never what another one is sent back behind. */
    private final Set<Integer> pulledBackTasks = new HashSet<>();
    /**
     * Whether the launcher has been seen in front since the guard started: every task in front of
     * it in the task stack's order has come up since then.
     */
    private boolean launcherSeen;

    private HomeFrontGuard(Context app, String name, long interval) {
        this.app = app;
        this.name = name;
        this.interval = interval;
        this.thread = new HandlerThread("HomeFrontGuard");
        this.thread.start();
        this.handler = new Handler(thread.getLooper());
    }

    /** From the guard's thread or the main thread; the first call wins. */
    private void stop(String reason) {
        synchronized (lock) {
            if (!active) {
                return;
            }
            active = false;
        }
        synchronized (HomeFrontGuard.class) {
            if (sCurrent == this) {
                sCurrent = null;
            }
        }
        handler.removeCallbacks(check);
        thread.quitSafely();
        // At once on the main thread: start() wraps the same windows again for the next guard.
        if (Looper.myLooper() == Looper.getMainLooper()) {
            stopWatchingUserInput();
        } else {
            MAIN.post(this::stopWatchingUserInput);
        }
        Log.i(TAG, name + " guard finished: " + reason + " (pulled the launcher back "
                + pullBacks + " time(s))");
    }

    private void scheduleCheck(long delayMs) {
        if (!active) {
            return;
        }
        handler.removeCallbacks(check);
        handler.postDelayed(check, delayMs);
    }

    private final Runnable check = new Runnable() {
        @Override
        public void run() {
            if (!active) {
                return;
            }
            try {
                // A cover already taken for the device's is still dealt with; a sleep ends the
                // guard from WakeDetection.onSleep().
                if (coverExpected == null
                        && SystemClock.elapsedRealtime() > EXPECTED.lastUntil() + END_MARGIN_MS) {
                    stop("nothing more expected from the device");
                    return;
                }
                long next = checkLauncherInFront();
                scheduleCheck(next);
            } catch (RuntimeException e) {
                // An exception escaping the guard's thread would end the whole launcher
                // (CrashHandler); the guard ends instead.
                Log.w(TAG, name + " check failed", e);
                stop("error: " + e);
            }
        }
    };

    /** One check, on the guard's thread. Returns when the next one is due. */
    private long checkLauncherInFront() {
        boolean seesTasks = seesOtherTasks(app);
        // With the task stack, that alone says what is in front; see the class comment.
        if (!seesTasks && sResumedActivities > 0) {
            launcherInFront();
            return interval;
        }
        Front top = front(app);
        if (top != null && app.getPackageName().equals(top.packageName())) {
            // Our own task is on top: in front, or about to be resumed (at start, or right after
            // a pull-back), which without the task stack is waited for. Also with the display
            // still off: what comes up from now on is in front of it in the task stack's order.
            launcherInFront();
            return seesTasks ? interval : STARTING_POLL_MS;
        }
        if (!isDefaultDisplayOn(app)) {
            // Nothing to see. Not the end of the guard: the display alone is not a sleep (the
            // FYT black screen, a display still off early at boot); WakeDetection ends it then.
            // Looked at again as often as usual: a wake's first check came 0.1 s before the
            // display was on, and waiting a whole second missed carlink and Maps coming up
            // (capture 12-10-2026 21:13:23).
            return interval;
        }
        if (isKeyguardLocked()) {
            return KEYGUARD_POLL_MS;    // what is under it does not show
        }
        long now = SystemClock.elapsedRealtime();
        String cover = top != null ? top.packageName() : "";
        int coverTask = top != null ? top.taskId : -1;
        String coverName = top != null ? top.activity.flattenToShortString() : "an app it cannot see";
        if (!cover.equals(currentCover) || coverTask != currentCoverTask) {
            currentCover = cover;
            currentCoverTask = coverTask;
            coverSeen = now;
            coverExpected = null;
            coverLeft = coverTask != -1 && leftTasks.contains(coverTask);
            lastProtection = null;
            Log.i(TAG, name + ": launcher covered by " + coverName
                    + (coverLeft ? " (left in front before)" : ""));
        }
        if (coverLeft) {
            return interval;
        }
        Expectations.Entry expected = coverExpected != null
                ? coverExpected : EXPECTED.match(cover, coverSeen);
        boolean named = expected != null && !cover.isEmpty() && expected.packages.contains(cover);
        String protection = isProtected(cover, named) ? "protected" : protectedState();
        if (protection != null && !protection.equals(lastProtection)) {
            Log.i(TAG, name + ": " + coverName + " left in front (" + protection + ")");
        }
        lastProtection = protection;
        if (protection != null) {
            leftInFront = top;
            return interval;
        }
        if (isUsersLaunch(lastUserInputElapsed(), coverSeen)) {
            leaveCover(top, coverName + " was opened by the user");
            return interval;
        }
        if (expected == null) {
            // A button on the steering wheel, the voice assistant, an app opening another one:
            // what the device was not expected to open is taken for the user's.
            leaveCover(top, coverName + " is not what the device was expected to open");
            return interval;
        }
        if (coverExpected == null) {
            coverExpected = expected;
            Log.i(TAG, name + ": " + coverName + " taken for the device's (" + expected.reason + ")");
        }
        if (lastPullBack > 0L && now - lastPullBack < MIN_PULL_GAP_MS) {
            return lastPullBack + MIN_PULL_GAP_MS - now;
        }
        if (pullBacks >= MAX_PULL_BACKS) {
            stop("keeps being covered by " + coverName + ", giving up");
            return CHECK_INTERVAL_MS;
        }
        if (!active) {
            // Ended meanwhile, by a sleep or by another guard.
            return CHECK_INTERVAL_MS;
        }
        pullBacks++;
        lastPullBack = now;
        EXPECTED.use(coverExpected);
        if (coverTask != -1) {
            pulledBackTasks.add(coverTask);
        }
        Front back = pullBackTarget(coverTask, now);
        if (back != null && moveTaskToFront(app, back.taskId)) {
            Log.i(TAG, name + ": sending " + coverName + " back behind "
                    + back.activity.flattenToShortString() + ", in front before it ("
                    + pullBacks + "/" + MAX_PULL_BACKS + ")");
        } else {
            Log.i(TAG, name + ": bringing the launcher back over " + coverName + " (" + pullBacks
                    + "/" + MAX_PULL_BACKS + ")");
            bringLauncherToFront(app);
        }
        return PAUSE_CHECK_MS;
    }

    /** The launcher is in front (again): what covers it next is new, and goes back behind it. */
    private void launcherInFront() {
        launcherSeen = true;
        currentCover = null;
        currentCoverTask = -1;
        coverExpected = null;
        coverLeft = false;
        lastProtection = null;
        leftInFront = null;
    }

    /** The current cover stays in front for good, and what the device opens over it goes behind it. */
    private void leaveCover(Front top, String why) {
        Log.i(TAG, name + ": " + why + ", left in front");
        coverLeft = true;
        if (top != null && top.taskId != -1) {
            leftTasks.add(top.taskId);
        }
        leftInFront = top;
    }

    /**
     * What a cover the device opened is sent back behind: what was in front before it, null for
     * the launcher.
     *
     * <p>Once the launcher has been seen in front, the task stack's order says it: the first task
     * below the cover, unless it is one this guard has sent back or one the device is still
     * expected to open. A check every 250 ms does not see everything -- in the capture
     * 12-10-2026 20:52:40 carlink, opened with a button 0.3 s into the wake, was in front for
     * 0.2 s before com.syu.ms's Maps came over it, and the launcher was brought over both. Before
     * that, or without the panes' tasks told apart (one would come up full screen), only the app
     * the guard itself saw left in front.
     */
    private Front pullBackTarget(int coverTask, long now) {
        try {
            ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) {
                return null;
            }
            if (launcherSeen && DefaultDisplayTask.knowsDisplays()) {
                for (ActivityManager.RunningTaskInfo task : DefaultDisplayTask.defaultDisplayTasks(am)) {
                    if (task.topActivity == null || task.id == coverTask
                            || pulledBackTasks.contains(task.id)) {
                        continue;
                    }
                    String pkg = task.topActivity.getPackageName();
                    if (pkg.equals(app.getPackageName())) {
                        return null;                // the launcher was in front before it
                    }
                    if (EXPECTED.namesUnused(pkg, now)) {
                        continue;                   // the device's as well
                    }
                    return new Front(task.topActivity, task.id);
                }
                return null;
            }
            Front back = leftInFront;
            if (back == null || back.taskId == -1 || back.taskId == coverTask) {
                return null;
            }
            return DefaultDisplayTask.isRunning(am, back.taskId) ? back : null;
        } catch (RuntimeException e) {
            return null;
        }
    }

    /** The user's last touch or button press as far as it is seen; 0 = none. */
    private long lastUserInputElapsed() {
        long since = UserTouches.sinceLastInputMs();
        long seen = since == Long.MAX_VALUE ? 0L : SystemClock.elapsedRealtime() - since;
        return Math.max(seen, lastUserInput);
    }

    /**
     * Main thread, from the activity tracker: what paused the launcher is looked at soon. Whether
     * the user opened it is up to the check; this runs late when the main thread stalls.
     */
    private void onOwnActivityPaused() {
        if (sResumedActivities > 0 || !active) {
            return;
        }
        scheduleCheck(PAUSE_CHECK_MS);
    }

    /**
     * Why nothing may be pulled back now, whatever covers the launcher; null if nothing stops it.
     * Also covers apps that are not known by name: the reversing camera as com.syu.ms reports it,
     * and a call, as the audio mode (a phone) or the head unit's app id (Bluetooth) shows it.
     */
    private String protectedState() {
        if (CarStates.mBackcarState != 0) {
            return "reversing";
        }
        int appId = CarStates.mAppID;
        if (appId == FinalMain.APP_ID_BTPHONE || appId == FinalMain.APP_ID_CAR_BTPHONE
                || appId == FinalMain.APP_ID_3GPHONE) {
            return "Bluetooth call";
        }
        AudioManager audio = (AudioManager) app.getSystemService(Context.AUDIO_SERVICE);
        int mode = audio != null ? audio.getMode() : AudioManager.MODE_NORMAL;
        if (mode == AudioManager.MODE_RINGTONE || mode == AudioManager.MODE_IN_CALL
                || mode == AudioManager.MODE_IN_COMMUNICATION) {
            return "call";
        }
        return null;
    }

    private boolean isKeyguardLocked() {
        KeyguardManager keyguard = (KeyguardManager) app.getSystemService(Context.KEYGUARD_SERVICE);
        return keyguard != null && keyguard.isKeyguardLocked();
    }

    // =============================================================================================
    // Touches in our own windows (main thread)
    // =============================================================================================

    /**
     * Notes touches and key presses in the activity's window while the guard runs, so that an app
     * the user opens is told apart from one the system brings up. The wrapper forwards everything
     * unchanged and is taken out again when the guard ends.
     */
    private void watchUserInput(Activity activity) {
        if (!active) {
            return;
        }
        Window window = activity.getWindow();
        Window.Callback callback = window != null ? window.getCallback() : null;
        if (callback == null) {
            return;
        }
        if (callback instanceof UserInputSpy) {
            if (((UserInputSpy) callback).guard() == this) {
                return;
            }
            // Left by a guard that has ended, its removal still queued.
            callback = ((UserInputSpy) callback).base;
        }
        window.setCallback(new UserInputSpy(callback));
        spiedWindows.add(new WeakReference<>(window));
    }

    private void stopWatchingUserInput() {
        for (WeakReference<Window> ref : spiedWindows) {
            Window window = ref.get();
            Window.Callback callback = window != null ? window.getCallback() : null;
            // Only if nothing has wrapped our wrapper in the meantime, the next guard included.
            if (callback instanceof UserInputSpy && ((UserInputSpy) callback).guard() == this) {
                window.setCallback(((UserInputSpy) callback).base);
            }
        }
        spiedWindows.clear();
    }

    private final class UserInputSpy implements Window.Callback {
        final Window.Callback base;

        UserInputSpy(Window.Callback base) {
            this.base = base;
        }

        HomeFrontGuard guard() {
            return HomeFrontGuard.this;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            int action = event.getActionMasked();
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
                lastUserInput = SystemClock.elapsedRealtime();
            }
            return base.dispatchTouchEvent(event);
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            lastUserInput = SystemClock.elapsedRealtime();
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
    // System state (from the guard's thread and ColdStart's autostart thread)
    // =============================================================================================

    /** Whether a cover is never pulled back over, when no expectation names it. */
    static boolean isProtected(String packageName) {
        return isProtected(packageName, false);
    }

    /**
     * Whether a cover is never pulled back over. named: an expectation names its package, which
     * lifts the protection of the apps opened on purpose, not that of the others.
     */
    static boolean isProtected(String packageName, boolean named) {
        return ALWAYS_PROTECTED_PACKAGES.contains(packageName) || isCameraPackage(packageName)
                || (!named && PROTECTED_UNLESS_EXPECTED_PACKAGES.contains(packageName));
    }

    static boolean isCameraPackage(String packageName) {
        String lower = packageName.toLowerCase(Locale.ROOT);
        for (String part : PROTECTED_COVER_NAME_PARTS) {
            if (lower.contains(part)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Top activity on the default display, null if it cannot be told. With system privileges the
     * task stack (see DefaultDisplayTask for why the PiP panes' tasks are skipped); without them
     * getRunningTasks() lists only the launcher's own tasks, so the usage events say it instead,
     * if the user has given usage access.
     */
    static ComponentName topActivity(Context app) {
        Front front = front(app);
        return front != null ? front.activity : null;
    }

    /** What is in front on the default display: its activity, and its task (-1 = not known). */
    static final class Front {
        final ComponentName activity;
        final int taskId;

        Front(ComponentName activity, int taskId) {
            this.activity = activity;
            this.taskId = taskId;
        }

        String packageName() {
            return activity.getPackageName();
        }
    }

    /** See topActivity(); the task is only known from the task stack. Null if it cannot be told. */
    @SuppressWarnings("deprecation")
    static Front front(Context app) {
        try {
            if (seesOtherTasks(app)) {
                ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
                ActivityManager.RunningTaskInfo task = am != null ? DefaultDisplayTask.topTask(am) : null;
                return task != null && task.topActivity != null
                        ? new Front(task.topActivity, task.id) : null;
            }
            ComponentName top = topActivityFromUsageEvents(app);
            return top != null ? new Front(top, -1) : null;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot read the top task: " + e);
            return null;
        }
    }

    /**
     * Whether getRunningTasks() lists the other apps' tasks too: REAL_GET_TASKS is what it checks
     * (uid 1000 has it); otherwise only the launcher's own tasks are there.
     */
    public static boolean seesOtherTasks(Context app) {
        return android.os.Process.myUid() == android.os.Process.SYSTEM_UID
                || app.checkSelfPermission("android.permission.REAL_GET_TASKS")
                        == PackageManager.PERMISSION_GRANTED;
    }

    /** The activity resumed last according to the usage events; null without usage access. */
    @SuppressWarnings("deprecation")
    private static ComponentName topActivityFromUsageEvents(Context app) {
        UsageStatsManager usm = (UsageStatsManager) app.getSystemService(Context.USAGE_STATS_SERVICE);
        if (usm == null) {
            return null;
        }
        long now = System.currentTimeMillis();
        UsageEvents events = usm.queryEvents(now - USAGE_LOOKBACK_MS, now);
        if (events == null) {
            return null;
        }
        UsageEvents.Event event = new UsageEvents.Event();
        ComponentName top = null;
        while (events.hasNextEvent()) {
            events.getNextEvent(event);
            if (event.getEventType() == UsageEvents.Event.MOVE_TO_FOREGROUND
                    && event.getPackageName() != null && event.getClassName() != null) {
                top = new ComponentName(event.getPackageName(), event.getClassName());
            }
        }
        return top;
    }

    /**
     * Whether a process with this package is up. Only uid 1000 sees other apps' processes here;
     * without it, or on any error, the answer is true so the guard never waits on a guess.
     */
    static boolean isPackageRunning(Context app, String packageName) {
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

    /** Unknown counts as on, as in WakeSignals. */
    private static boolean isDefaultDisplayOn(Context app) {
        DisplayManager dm = (DisplayManager) app.getSystemService(Context.DISPLAY_SERVICE);
        Display display = dm != null ? dm.getDisplay(Display.DEFAULT_DISPLAY) : null;
        return display == null || display.getState() == Display.STATE_ON;
    }

    /**
     * Whether another app is set as the home app. This process can outlive the launcher being the
     * home app (its services keep it up), and must not bring itself up then. No default at all
     * (the chooser, "android") does not count.
     */
    public static boolean isAnotherHomeDefault(Context app) {
        try {
            Intent home = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME);
            ResolveInfo info = app.getPackageManager().resolveActivity(home, PackageManager.MATCH_DEFAULT_ONLY);
            String pkg = info != null && info.activityInfo != null ? info.activityInfo.packageName : null;
            return pkg != null && !pkg.equals(app.getPackageName()) && !"android".equals(pkg);
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Same approach as WakeDetection.pressHomeButton(), which the wake logs show working on this
     * ROM: a live launcher gets its task moved to the front (no new intent, no second
     * ActivityRecord). The HOME intent is only the fallback when there is no launcher activity;
     * the launcher runs as uid 1000, so the explicit component still counts as a Home start.
     */
    /** Another app's task to the front, as the launcher's own in bringLauncherToFront(); false if that failed. */
    static boolean moveTaskToFront(Context app, int taskId) {
        try {
            ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) {
                return false;
            }
            am.moveTaskToFront(taskId, 0);
            return true;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot move task " + taskId + " to front", e);
            return false;
        }
    }

    static void bringLauncherToFront(Context app) {
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
        if (isAnotherHomeDefault(app)) {
            return;
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
