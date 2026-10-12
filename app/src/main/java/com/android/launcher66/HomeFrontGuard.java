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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Keeps the launcher in front for a while: whatever comes up over it is sent back behind it as
 * soon as it has started, as often as it takes. Left in front are only what the user opens and a
 * few protected apps (reversing camera, phone, system dialogs); see isProtected(). Started after a
 * cold boot (ColdStart, setting Keys.LAUNCHER_HOME_COLD_START) and after a wake (WakeDetection,
 * Keys.LAUNCHER_HOME_WAKE, where only the first seconds are as strict, see start()); one at a
 * time, a new one ends the one running.
 *
 * <p>Taken out of ColdStart, where it covered the cold boot only. After a wake there was just one
 * look at 500 ms and a guard for the PiP apps (WindowUtil.reassertHomeOverPipAppsAfterWake()), so
 * the app com.syu.ms brings back at the wake stayed in front whenever it came a little later.
 *
 * <p>What covers the launcher is read from the task stack, which only a launcher with system
 * privileges sees whole. Without them it comes from the usage events (if usage access is given),
 * otherwise it is not known: the launcher is then still brought back, unless the reversing camera
 * or a call is up as com.syu.ms and AudioManager report them.
 *
 * <p>The checks run on the guard's own thread: each of them calls into system_server, which stalls
 * for seconds at boot while the audioserver hangs, and on the main thread every such call froze
 * the launcher along with it.
 */
public final class HomeFrontGuard {

    private static final String TAG = "HomeFrontGuard";

    /** Regular re-check while the guard runs, besides the checks each pause of the launcher triggers. */
    static final long CHECK_INTERVAL_MS = 1000L;
    /** First check after the launcher was paused; the system launches what paused it meanwhile. */
    static final long PAUSE_CHECK_MS = 250L;
    /** Re-check interval while the covering app's process is still starting. */
    static final long STARTING_POLL_MS = 150L;
    /** Longest wait for the covering app's process; after that the launcher comes back anyway. */
    static final long MAX_START_WAIT_MS = 10000L;
    /**
     * Time a covering app gets once its process runs, before the launcher comes back: enough for
     * its onCreate(), where autostart activities (openpanorama, JamesDSP) start their service.
     */
    static final long COVER_GRACE_MS = 800L;
    /** Minimum time between two pull-backs, and how many there may be at most. */
    private static final long MIN_PULL_GAP_MS = 400L;
    private static final int MAX_PULL_BACKS = 15;
    /** A pause of the launcher this soon after a touch or key press in it is the user's doing. */
    private static final long USER_ACTION_GRACE_MS = 1500L;
    /** While the keyguard is up nothing under it shows; the guard waits for it to go. */
    private static final long KEYGUARD_POLL_MS = 500L;
    /** How far back the usage events are read for the app in front. */
    private static final long USAGE_LOOKBACK_MS = 60_000L;
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
    /**
     * Package name parts of camera apps (reversing, 360 view), which are protected as well.
     * "panoram" for openpanorama and FYT's own 360 view, com.syu.panoramic (FytPackage.INNER360).
     */
    private static final String[] PROTECTED_COVER_NAME_PARTS = {"camera", "panoram", "backcar", "reverse"};

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
     * Main thread. Keeps the launcher in front for windowMs from now, the first check after
     * firstCheckMs; name is only for the log.
     */
    public static void start(Context context, String name, long windowMs, long firstCheckMs) {
        start(context, name, windowMs, firstCheckMs, windowMs, Collections.<String>emptySet());
    }

    /**
     * Same, but whatever comes up more than anyCoverMs from now is only pulled back over if it is
     * one of lateCovers, and each of those once. After a wake: what com.syu.ms brings back by
     * itself comes at once, or is one of a few known apps, once; an app opened later, say with a
     * key on the steering wheel, which no touch shows, is the user's -- also when it is one of
     * those apps and comes up again.
     */
    public static void start(Context context, String name, long windowMs, long firstCheckMs,
                             long anyCoverMs, Set<String> lateCovers) {
        HomeFrontGuard previous = sCurrent;
        if (previous != null) {
            previous.stop("replaced by " + name);
        }
        HomeFrontGuard guard = new HomeFrontGuard(context.getApplicationContext(), name, windowMs,
                anyCoverMs, lateCovers);
        synchronized (HomeFrontGuard.class) {
            sCurrent = guard;
        }
        Log.i(TAG, name + ": keeping the launcher in front for " + windowMs + " ms");
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

    // =============================================================================================
    // One guard
    // =============================================================================================

    private final Context app;
    private final String name;
    private final long deadline;
    /** A cover first seen after this (elapsedRealtime) is only pulled back over if in lateCovers. */
    private final long anyCoverUntil;
    private final Set<String> lateCovers;
    /** Late covers already pulled back over once; guard thread only. */
    private final Set<String> latePulled = new HashSet<>();
    private final HandlerThread thread;
    private final Handler handler;
    /** For what belongs to the main thread: the input spy's windows. */
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Object lock = new Object();
    private volatile boolean active = true;
    /** elapsedRealtime() of the last touch or key press in one of this process' windows. */
    private volatile long lastUserInput;
    /** Windows wrapped by UserInputSpy; main thread only. */
    private final List<WeakReference<Window>> spiedWindows = new ArrayList<>();
    private volatile int pullBacks;
    /** Guard thread only, like the fields below. */
    private long lastPullBack;
    /** What covers the launcher ("" = not known), when it was first seen, since when its process runs (0 = not yet). */
    private String currentCover;
    private long coverSeen;
    private long coverRunning;
    /** Why the launcher was last left covered, for the log. */
    private String lastProtection;
    private boolean lateCoverLogged;

    private HomeFrontGuard(Context app, String name, long windowMs, long anyCoverMs,
                           Set<String> lateCovers) {
        this.app = app;
        this.name = name;
        long now = SystemClock.elapsedRealtime();
        this.deadline = now + windowMs;
        this.anyCoverUntil = now + anyCoverMs;
        this.lateCovers = new HashSet<>(lateCovers);
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
            mainHandler.post(this::stopWatchingUserInput);
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
                if (SystemClock.elapsedRealtime() > deadline) {
                    stop("time window over");
                    return;
                }
                // A sleep ends the guard from WakeDetection.onSleep().
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
        if (sResumedActivities > 0) {
            currentCover = null;
            return CHECK_INTERVAL_MS;
        }
        if (!isDefaultDisplayOn(app)) {
            // Nothing to see. Not the end of the guard: the display alone is not a sleep (the
            // FYT black screen, a display still off early at boot); WakeDetection ends it then.
            return CHECK_INTERVAL_MS;
        }
        if (isKeyguardLocked()) {
            return KEYGUARD_POLL_MS;    // what is under it does not show
        }
        long now = SystemClock.elapsedRealtime();
        ComponentName top = topActivity(app);
        if (top != null && app.getPackageName().equals(top.getPackageName())) {
            // Our own task is on top and about to be resumed: at start, or right after a pull-back.
            return STARTING_POLL_MS;
        }
        String cover = top != null ? top.getPackageName() : "";
        String coverName = top != null ? top.flattenToShortString() : "an app it cannot see";
        if (!cover.equals(currentCover)) {
            currentCover = cover;
            coverSeen = now;
            coverRunning = 0L;
            lastProtection = null;
            lateCoverLogged = false;
            Log.i(TAG, name + ": launcher covered by " + coverName);
        }
        String protection = isProtected(cover) ? "protected" : protectedState();
        if (protection != null && !protection.equals(lastProtection)) {
            Log.i(TAG, name + ": " + coverName + " left in front (" + protection + ")");
        }
        lastProtection = protection;
        if (protection != null) {
            return CHECK_INTERVAL_MS;
        }
        boolean late = coverSeen > anyCoverUntil;
        if (late && (!lateCovers.contains(cover) || latePulled.contains(cover))) {
            if (!lateCoverLogged) {
                lateCoverLogged = true;
                Log.i(TAG, name + ": " + coverName + " came up too late to be the device's own,"
                        + " left in front");
            }
            return CHECK_INTERVAL_MS;
        }
        if (UserTouches.isMonitoring() && UserTouches.sinceLastTouchMs() < now - coverSeen) {
            // Every touch on the screen is seen: one since it came up means the user is using it.
            stop("the user is using " + coverName);
            return CHECK_INTERVAL_MS;
        }
        if (coverRunning == 0L) {
            if (top == null || isPackageRunning(app, cover)) {
                coverRunning = now;
            } else if (now - coverSeen < MAX_START_WAIT_MS) {
                // Pulling back now would leave its activity unlaunched for good: Android 10
                // only launches activities of the focused stack when their process comes up.
                return STARTING_POLL_MS;
            } else {
                Log.w(TAG, coverName + " did not start within " + MAX_START_WAIT_MS + " ms");
                coverRunning = now - COVER_GRACE_MS;
            }
        }
        long graceLeft = coverRunning + COVER_GRACE_MS - now;
        if (graceLeft > 0L) {
            return graceLeft;
        }
        if (lastPullBack > 0L && now - lastPullBack < MIN_PULL_GAP_MS) {
            return lastPullBack + MIN_PULL_GAP_MS - now;
        }
        if (pullBacks >= MAX_PULL_BACKS) {
            stop("keeps being covered by " + coverName + ", giving up");
            return CHECK_INTERVAL_MS;
        }
        if (!active) {
            // Ended on the main thread during this check, e.g. because the user opened something.
            return CHECK_INTERVAL_MS;
        }
        pullBacks++;
        lastPullBack = now;
        if (late) {
            latePulled.add(cover);
        }
        Log.i(TAG, name + ": bringing the launcher back over " + coverName + " (" + pullBacks + "/"
                + MAX_PULL_BACKS + ")");
        bringLauncherToFront(app);
        return PAUSE_CHECK_MS;
    }

    /** Main thread, from the activity tracker. */
    private void onOwnActivityPaused() {
        if (sResumedActivities > 0 || !active) {
            return;
        }
        if (userActedRecently()) {
            // The user opened something from the launcher: leave it in front.
            stop("the user opened something");
        } else {
            scheduleCheck(PAUSE_CHECK_MS);
        }
    }

    /**
     * A touch or key press in one of our windows, or anywhere on the screen as far as UserTouches
     * sees it (with system privileges every touch, the panes' included).
     */
    private boolean userActedRecently() {
        long last = lastUserInput;
        return (last > 0L && SystemClock.elapsedRealtime() - last < USER_ACTION_GRACE_MS)
                || UserTouches.sinceLastTouchMs() < USER_ACTION_GRACE_MS;
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

    static boolean isProtected(String packageName) {
        return PROTECTED_COVER_PACKAGES.contains(packageName) || isCameraPackage(packageName);
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
        try {
            if (canSeeOtherTasks(app)) {
                ActivityManager am = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
                return am != null ? DefaultDisplayTask.topActivity(am) : null;
            }
            return topActivityFromUsageEvents(app);
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot read the top task: " + e);
            return null;
        }
    }

    /** REAL_GET_TASKS is what getRunningTasks() checks before it shows the other apps' tasks. */
    private static boolean canSeeOtherTasks(Context app) {
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
