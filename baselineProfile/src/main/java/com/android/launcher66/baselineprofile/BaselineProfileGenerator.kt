package com.android.launcher66.baselineprofile

import android.content.ComponentName
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

internal const val DEFAULT_PACKAGE = "com.android.launcher66"
internal const val LAUNCHER_ACTIVITY = "com.android.launcher66.Launcher"
internal const val SETTINGS_ACTIVITY = "com.android.launcher66.settings.SettingsActivity"
internal const val WALLPAPER_PICKER_ACTIVITY = "com.android.launcher66.WallpaperPickerActivity"

private const val TAG = "BaselineProfileGen"

/** Process that hosts WallpaperPickerActivity / WallpaperCropActivity (android:process). */
private const val WALLPAPER_PROCESS_SUFFIX = ":wallpaper_chooser"

/** Time ART needs to write the profile after SIGUSR1. */
private const val PROFILE_FLUSH_WAIT_MS = 2_000L
private const val UI_TIMEOUT_MS = 15_000L

/**
 * Workspace swipes are performed this far above the bottom edge of the screen.
 * The middle of the workspace hosts embedded (PiP / ActivityView) apps that would
 * otherwise consume the gesture.
 */
private const val SWIPE_BOTTOM_OFFSET_DP = 8f

/**
 * Wallpaper picker: the thumbnail strip is not swipeable. Thumbnails are tapped instead,
 * starting this far from the bottom and left edges, then stepping right.
 */
private const val WALLPAPER_TAP_EDGE_OFFSET_DP = 25f
private const val WALLPAPER_TAP_STEP_DP = 100f
private const val WALLPAPER_TAP_COUNT = 6
private const val WALLPAPER_TAP_INTERVAL_MS = 1_500L

/**
 * Flags for secondary screens: new task placed on top of the home task, so BACK returns
 * straight to the Launcher.
 *
 * These screens are started with a plain "am start" instead of startActivityAndWait():
 * Macrobenchmark always adds FLAG_ACTIVITY_CLEAR_TASK, and because SettingsActivity /
 * WallpaperPickerActivity share the launcher's task affinity, that clears and reuses an
 * existing com.android.launcher66 task in another stack. BACK then returns to whatever
 * that stack exposes (e.g. system Settings) instead of the Launcher.
 */
private const val SECONDARY_SCREEN_FLAGS =
    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME

/** App drawer button position (from the bottom and left edges) and how long the drawer stays open. */
private const val APP_DRAWER_TAP_OFFSET_DP = 40f
private const val APP_DRAWER_OPEN_MS = 2_000L

/** The Baseline Profile Gradle plugin passes the target applicationId as "targetAppId". */
internal val targetPackage: String
    get() = InstrumentationRegistry.getArguments().getString("targetAppId") ?: DEFAULT_PACKAGE

/**
 * Explicit HOME intent with a component. The default startActivityAndWait() is not used,
 * because the manifest declares TWO activities with the LAUNCHER category (Launcher and
 * SettingsActivity), so getLaunchIntentForPackage() could resolve to the settings screen.
 */
internal fun homeIntent(): Intent = Intent(Intent.ACTION_MAIN).apply {
    addCategory(Intent.CATEGORY_HOME)
    component = ComponentName(targetPackage, LAUNCHER_ACTIVITY)
    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}

/** Puts a neutral activity on top, so the launcher is not the resumed activity before a start. */
internal fun MacrobenchmarkScope.bringSystemSettingsToFront() {
    device.executeShellCommand("am start -W -a android.settings.SETTINGS")
    device.waitForIdle(2_000)
}

/** Package of the system Settings app, resolved once per test process. */
private var systemSettingsPackage: String? = null

/**
 * Removes the system Settings task that bringSystemSettingsToFront() left behind.
 * Otherwise BACK from a secondary launcher screen returns to it before reaching the Launcher.
 */
internal fun MacrobenchmarkScope.closeSystemSettings() {
    val pkg = systemSettingsPackage ?: device
        .executeShellCommand("cmd package resolve-activity --brief -a android.settings.SETTINGS")
        .lineSequence()
        .map { it.trim() }
        .lastOrNull { it.contains('/') }
        ?.substringBefore('/')
        ?.also { systemSettingsPackage = it }
    if (pkg.isNullOrEmpty() || pkg == targetPackage) {
        Log.w(TAG, "Could not resolve the system Settings package, it is left running")
        return
    }
    device.executeShellCommand("am force-stop $pkg")
}

/**
 * Flattened components of all currently resumed activities, e.g. "com.android.launcher66/.Launcher".
 *
 * UiAutomator can only filter by package, and SettingsActivity / WallpaperPickerActivity share
 * the launcher package, so resumed activities are read from ActivityManager instead.
 * There can be several: apps embedded in the launcher (PiP / ActivityView) run on their own
 * virtual displays and are resumed at the same time as the Launcher on the main display.
 */
internal fun MacrobenchmarkScope.resumedActivities(): List<String> =
    device.executeShellCommand("dumpsys activity activities")
        .lineSequence()
        .filter { it.contains("ResumedActivity") && it.contains("ActivityRecord{") }
        .mapNotNull { Regex("""\S+/\S+""").find(it.substringAfter("ActivityRecord{"))?.value }
        .distinct()
        .toList()

internal fun MacrobenchmarkScope.isLauncherResumed(): Boolean =
    resumedActivities().any {
        it == "$targetPackage/.Launcher" || it == "$targetPackage/$LAUNCHER_ACTIVITY"
    }

/** Waits until the Launcher activity (not just any activity of the package) is resumed and drawn. */
internal fun MacrobenchmarkScope.waitForLauncher() {
    val deadline = SystemClock.uptimeMillis() + UI_TIMEOUT_MS
    while (!isLauncherResumed()) {
        check(SystemClock.uptimeMillis() < deadline) {
            "Launcher was not resumed within $UI_TIMEOUT_MS ms (resumed: ${resumedActivities()})"
        }
        SystemClock.sleep(250)
    }
    check(device.wait(Until.hasObject(By.pkg(targetPackage).depth(0)), UI_TIMEOUT_MS)) {
        "Launcher window is not visible"
    }
    // The launcher hosts clocks / visualizers and is never fully idle, keep the timeout short.
    device.waitForIdle(2_000)
}

/**
 * Forces ART to write the JIT profile of the given process to disk (SIGUSR1).
 *
 * BaselineProfileRule flushes all processes of the package only at the end of each iteration.
 * A secondary process (":wallpaper_chooser") may already be gone by then, so its profile is
 * flushed explicitly while it is still alive. Requires root; the command goes through
 * "su root", like Macrobenchmark's own root commands.
 */
internal fun MacrobenchmarkScope.flushProcessProfile(processName: String) {
    val pids = device.executeShellCommand("pidof $processName").trim()
        .split(Regex("""\s+""")).filter { it.isNotEmpty() }
    if (pids.isEmpty()) {
        Log.w(TAG, "Profile flush skipped: process $processName is not running")
        return
    }
    pids.forEach { pid ->
        val out = device.executeShellCommand("su root kill -s SIGUSR1 $pid").trim()
        Log.i(TAG, "Profile flush requested for $processName (pid $pid)${if (out.isNotEmpty()) ": $out" else ""}")
    }
    SystemClock.sleep(PROFILE_FLUSH_WAIT_MS)
}

/** Logs the task stack (debug aid for navigation issues). */
internal fun MacrobenchmarkScope.logTaskStack(label: String) {
    val tasks = device.executeShellCommand("dumpsys activity activities")
        .lineSequence()
        .map { it.trim() }
        .filter { it.startsWith("* TaskRecord{") || it.startsWith("ResumedActivity") }
        .joinToString("\n")
    Log.d(TAG, "Task stack ($label):\n$tasks")
}

/**
 * Starts a secondary screen of the launcher package the same way as
 * "adb shell am start -n <component> -f <flags>" and waits until it is resumed.
 */
internal fun MacrobenchmarkScope.startSecondaryScreen(activityClass: String, action: String? = null) {
    val component = "$targetPackage/$activityClass"
    val actionArg = action?.let { "-a $it " } ?: ""
    val result = device.executeShellCommand("am start -W ${actionArg}-n $component -f $SECONDARY_SCREEN_FLAGS")
    Log.i(TAG, "am start $component -> ${result.lineSequence().firstOrNull { it.startsWith("Status") }}")

    val deadline = SystemClock.uptimeMillis() + UI_TIMEOUT_MS
    while (!isSecondaryScreenResumed()) {
        check(SystemClock.uptimeMillis() < deadline) {
            "$component was not resumed within $UI_TIMEOUT_MS ms (resumed: ${resumedActivities()})"
        }
        SystemClock.sleep(250)
    }
    device.waitForIdle(2_000)
}

/** True if an activity of the launcher package other than Launcher itself is resumed. */
internal fun MacrobenchmarkScope.isSecondaryScreenResumed(): Boolean =
    resumedActivities().any {
        it.startsWith("$targetPackage/") &&
            it != "$targetPackage/.Launcher" && it != "$targetPackage/$LAUNCHER_ACTIVITY"
    }

/**
 * Returns to the Launcher from SettingsActivity / WallpaperPickerActivity.
 *
 * BACK is pressed only while one of our own secondary screens is resumed, so the activity is
 * actually finished (HOME alone would just move it behind the launcher). BACK is never pressed
 * past that point: these screens run in their own tasks, and BACK on a task root walks the
 * task history (system Settings, Recents, ...) instead of going home. The final hop to the
 * Launcher is always done with HOME.
 */
internal fun MacrobenchmarkScope.backToLauncher(maxPresses: Int = 3) {
    logTaskStack("before BACK")
    repeat(maxPresses) {
        if (!isSecondaryScreenResumed()) return@repeat
        device.pressBack()
        // Wait for the transition to settle - slow head units need well over 500 ms.
        val deadline = SystemClock.uptimeMillis() + 3_000
        while (isSecondaryScreenResumed() && SystemClock.uptimeMillis() < deadline) {
            SystemClock.sleep(250)
        }
    }
    if (isSecondaryScreenResumed()) {
        Log.w(TAG, "Secondary screen still resumed after BACK: ${resumedActivities()}")
    }
    if (!isLauncherResumed()) pressHome()
    waitForLauncher()
}

@RunWith(AndroidJUnit4::class)
@LargeTest
class BaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    /**
     * Startup journey. Only this test feeds startup-prof.txt, which R8 uses to place
     * startup classes in the primary DEX file, so it is kept limited to the startup path.
     */
    @Test
    fun startup() = rule.collect(
        packageName = targetPackage,
        includeInStartupProfile = true,
        maxIterations = 10,
        stableIterations = 3,
    ) {
        coldStartViaHome()
        swipeWorkspace()
    }

    /**
     * Secondary screens: app drawer, launcher settings and wallpaper picker. Included in the
     * baseline profile (AOT compiled), but excluded from the startup profile so they do not
     * dilute the startup DEX layout.
     * WallpaperPickerActivity runs in the separate ":wallpaper_chooser" process; profiles of
     * all processes of the package are collected (benchmark 1.4+ with profileinstaller 1.4.1+).
     */
    @Test
    fun secondaryScreens() = rule.collect(
        packageName = targetPackage,
        includeInStartupProfile = false,
        maxIterations = 5,
        stableIterations = 2,
    ) {
        coldStartViaHome()

        openAndCloseAppDrawer()

        openAndScrollSettings()
        backToLauncher()

        openWallpaperPicker()
        backToLauncher()
    }

    /** Cold start: system Settings on top -> kill the launcher -> explicit HOME intent. */
    private fun MacrobenchmarkScope.coldStartViaHome() {
        bringSystemSettingsToFront()
        // If the FYT firmware restarts the launcher immediately and killProcess() throws,
        // remove this line - the startup path is still captured when the process restarts.
        killProcess()
        startActivityAndWait(homeIntent())
        waitForLauncher()
        // The launcher is in front now; drop the helper Settings task so it cannot resurface.
        closeSystemSettings()
    }

    /** Swipes between workspace pages along the bottom edge, below the embedded PiP apps. */
    private fun MacrobenchmarkScope.swipeWorkspace() {
        val w = device.displayWidth
        val y = device.displayHeight - 1 - dp(SWIPE_BOTTOM_OFFSET_DP)
        val left = (w * 0.15).toInt()
        val right = (w * 0.85).toInt()

        repeat(2) {
            device.swipe(right, y, left, y, 25)
            device.waitForIdle(1_000)
        }
        repeat(2) {
            device.swipe(left, y, right, y, 25)
            device.waitForIdle(1_000)
        }
    }

    /**
     * Opens the app drawer with the button in the bottom-left corner and closes it with BACK.
     * The drawer is part of the Launcher activity, so no task switch is involved.
     */
    private fun MacrobenchmarkScope.openAndCloseAppDrawer() {
        val offset = dp(APP_DRAWER_TAP_OFFSET_DP)
        device.click(offset, device.displayHeight - 1 - offset)
        // Let the drawer open and load its icons.
        SystemClock.sleep(APP_DRAWER_OPEN_MS)
        device.pressBack()
        device.waitForIdle(2_000)
        if (!isLauncherResumed()) {
            Log.w(TAG, "Unexpected screen after closing the app drawer: ${resumedActivities()}")
            pressHome()
        }
        waitForLauncher()
    }

    /** Opens the launcher settings (exported) and scrolls the list. */
    private fun MacrobenchmarkScope.openAndScrollSettings() {
        startSecondaryScreen(SETTINGS_ACTIVITY)
        findScrollable()?.let { list ->
            list.setGestureMargin(device.displayHeight / 10)
            list.fling(Direction.DOWN)
            device.waitForIdle(1_000)
            list.fling(Direction.UP)
            device.waitForIdle(1_000)
        } ?: Log.w(TAG, "No scrollable view found in SettingsActivity")
    }

    /**
     * Opens the wallpaper picker and taps thumbnails on the bottom strip. Each tap scrolls
     * the strip and loads a full-size preview (decoding / preview code paths). A preview is
     * not applied until confirmed; backToLauncher() leaves with BACK, which discards it.
     */
    private fun MacrobenchmarkScope.openWallpaperPicker() {
        startSecondaryScreen(WALLPAPER_PICKER_ACTIVITY, Intent.ACTION_SET_WALLPAPER)
        // Let the thumbnail strip load.
        device.waitForIdle(3_000)

        val y = device.displayHeight - 1 - dp(WALLPAPER_TAP_EDGE_OFFSET_DP)
        repeat(WALLPAPER_TAP_COUNT) { i ->
            val x = dp(WALLPAPER_TAP_EDGE_OFFSET_DP) + i * dp(WALLPAPER_TAP_STEP_DP)
            if (x >= device.displayWidth) return@repeat
            device.click(x, y)
            SystemClock.sleep(WALLPAPER_TAP_INTERVAL_MS)
        }

        // Save the picker process profile before BACK closes it.
        flushProcessProfile(targetPackage + WALLPAPER_PROCESS_SUFFIX)
    }

    private fun dp(value: Float): Int =
        (value * InstrumentationRegistry.getInstrumentation().context.resources.displayMetrics.density).toInt()

    private fun MacrobenchmarkScope.findScrollable(): UiObject2? =
        device.wait(Until.findObject(By.scrollable(true).pkg(targetPackage)), 5_000)
}
