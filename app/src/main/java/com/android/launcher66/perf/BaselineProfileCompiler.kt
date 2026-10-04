package com.android.launcher66.perf

import android.app.Activity
import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.SystemClock
import android.provider.Settings
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.annotation.WorkerThread
import androidx.profileinstaller.ProfileVerifier
import com.android.launcher66.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.resume

/**
 * Applies the Baseline Profile on FYT head units without root and without a PC, and later
 * refreshes the compilation with the code paths the user actually uses.
 *
 * Why this is needed:
 *  - ProfileInstaller only copies baseline.prof into the ART profile. The actual AOT compilation
 *    is done by the background dexopt job, which requires "idle maintenance" (screen off,
 *    charging, long inactivity) - a state a car head unit practically never reaches.
 *  - The USB-stick install script runs before the reboot, when PackageManager does not know
 *    the new APK yet and ProfileInstaller has not run, so it cannot compile anything.
 *
 * Why it works without root: the launcher runs as UID 1000 (android.uid.system) and is signed
 * with the platform key, so system_server grants it the same operations as "adb shell".
 *
 * Two phases per installed APK:
 *
 *  1. Initial compilation - once per new APK, [START_DELAY_MS] after the first start:
 *     a. forced write of baseline.prof from the APK into the ART profile (ProfileInstallReceiver)
 *     b. performDexOptMode(speed-profile)  (= cmd package compile -m speed-profile -f)
 *
 *  2. Usage refreshes - while the launcher runs, ART keeps recording hot methods of the user's
 *     own configuration (side bar, auto-hidden bottom bar, widget types, ...) in the same
 *     profile, during EVERY session. The app is compiled again (step b only) when BOTH
 *     conditions are met:
 *       - at least [REFRESH_AFTER_DAYS] days since the previous compilation, and
 *       - at least [REFRESH_MIN_SESSIONS] usage sessions since the previous compilation.
 *     A session is:
 *       - a device restart (cold boot, detected by LauncherApplication) - always counts,
 *       - a wake-up from sleep reported by WakeDetectionService ([onDeviceWake];
 *         ACTION_SCREEN_ON is not delivered on FYT) or a launcher process restart without a
 *         device restart - counts if at least [SESSION_MIN_GAP_MS] of device time passed since
 *         the previous counted session (filters quick display off/on and crash restarts).
 *     The session counter is only a gate: it stops at the minimum (5/5, 10/10), while ART keeps
 *     recording every further session, so a refresh at the day limit compiles the data of all
 *     sessions since the previous compilation.
 *     Step a is NOT repeated - it would overwrite the recorded usage data.
 *
 * Time keeping - independent of the wall clock:
 *   FYT units often boot with a clock that is years behind and only correct it once they are
 *   online. Elapsed time is therefore measured in two ways, and the larger value is used:
 *   - device time: SystemClock.elapsedRealtime() deltas (includes deep sleep), accumulated across
 *     boots. Always valid; misses only the time the unit is fully powered off.
 *   - calendar time: wall clock, but only between two readings that are both "valid"
 *     ([isWallClockValid]: not earlier than [MIN_VALID_WALL_TIME_MS]). A compilation made while
 *     the clock was wrong gets its calendar time fixed later, once the clock has been corrected
 *     (exactly within the same boot, conservatively from the device time across boots).
 *   Session gaps are measured in device time only.
 *
 * Everything runs in the background without any user interaction and without restarting the
 * launcher; freshly compiled code is used from the next start of the launcher process.
 *
 * Resets (launcher settings): [resetUsageRefreshes] restarts the refresh schedule and keeps the
 * collected data; [resetToBaselineProfile] also drops the collected data and recompiles from
 * the Baseline Profile in the APK (this restarts the launcher).
 *
 * IMPORTANT: clearApplicationProfileData() freezes the package, and freezing kills every process
 * of the package. It is therefore used ONLY by the explicit full reset, where the restart is
 * announced to the user - never in the automatic flow. The automatic flow does not need it: the
 * forced write replaces the current profile, and profman discards reference-profile data whose
 * DEX checksums do not match a new APK.
 */
object BaselineProfileCompiler {

    private const val TAG = "BaselineProfile"
    private const val PREFS = "baseline_profile_state"
    private const val KEY_DONE_FOR = "done_for"
    private const val KEY_ATTEMPT_FOR = "attempt_for"
    private const val KEY_ATTEMPTS = "attempts"
    private const val KEY_LAST_STATUS = "last_status"
    private const val KEY_REFRESHES = "refreshes"
    private const val KEY_SESSIONS_SINCE_COMPILE = "starts_since_compile" // name kept for existing installs

    // Last compilation: calendar time if it is known to be correct, otherwise -1 + the device time
    // reference below, until the clock has been corrected.
    private const val KEY_LAST_COMPILE_AT = "last_compile_at"
    private const val KEY_COMPILE_BOOT = "compile_boot"
    private const val KEY_COMPILE_ELAPSED = "compile_elapsed"

    // Device time since the last compilation (elapsedRealtime deltas, accumulated across boots).
    private const val KEY_DEVICE_MS_SINCE_COMPILE = "device_ms_since_compile"
    private const val KEY_CHECKPOINT_BOOT = "checkpoint_boot"
    private const val KEY_CHECKPOINT_ELAPSED = "checkpoint_elapsed"

    // Last counted session, in device time.
    private const val KEY_SESSION_BOOT = "session_boot"
    private const val KEY_SESSION_ELAPSED = "session_elapsed"

    // Keys of older versions (wall-clock based) - removed on first use.
    private val LEGACY_KEYS = listOf("last_session_at", "refresh_due_day")

    private const val MAX_ATTEMPTS = 3

    /** Days after the previous compilation at which each usage refresh becomes due. */
    private val REFRESH_AFTER_DAYS = longArrayOf(3, 14, 30)

    /** Usage sessions since the previous compilation required for each refresh. */
    private val REFRESH_MIN_SESSIONS = intArrayOf(5, 10, 10)

    /** Minimum device time between two counted wake-up / process-restart sessions (device restarts always count). */
    private val SESSION_MIN_GAP_MS = TimeUnit.MINUTES.toMillis(3)

    /**
     * Wall-clock readings earlier than this are certainly wrong (2026-09-01 00:00 UTC, before this
     * code existed). FYT units with a lost clock boot years in the past, far below this value.
     * Can be moved forward in later releases; it only has to stay in the past.
     */
    private const val MIN_VALID_WALL_TIME_MS = 1_788_220_800_000L

    /** Head unit boot is busy (CAN bus, BT, navigation) - do not compete for CPU. */
    private const val START_DELAY_MS = 90_000L
    private const val INSTALL_TIMEOUT_MS = 30_000L

    /** While the clock is wrong: how often to check whether it has been corrected. */
    private const val CLOCK_CHECK_INTERVAL_MS = 60_000L

    /** Device time is saved at least this often, so a power cut loses little of it. */
    private val CHECKPOINT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(15)

    private const val ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE"
    private const val RECEIVER = "androidx.profileinstaller.ProfileInstallReceiver"

    /** ProfileInstaller result codes: 1 = RESULT_INSTALL_SUCCESS, 2 = RESULT_ALREADY_INSTALLED. */
    private val INSTALL_OK = setOf(1, 2)

    /**
     * Build types created by the Baseline Profile Gradle plugin. The profile generator and
     * StartupBenchmark control compilation themselves; compiling behind their back would
     * distort the collected profile and the measurements.
     */
    private val TEST_BUILD_TYPE_PREFIXES = listOf("nonMinified", "benchmark")

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val scheduled = AtomicBoolean(false)

    /**
     * The initial compilation or usage refresh waiting for its [START_DELAY_MS]. Cancelled when
     * the head unit goes to sleep ([onDeviceSleep]): the delay does not advance while the SoC is
     * suspended, so it would otherwise fire right into the busy first seconds after the next wake.
     */
    private var pendingJob: Job? = null
    private val pendingLock = Any()

    /** Saves device time regularly and notices when the wall clock gets corrected. */
    private var tickerJob: Job? = null

    /** Application context, kept for the calls that come without one (onDeviceSleep). */
    @Volatile
    private var appContext: Context? = null

    /** Incremented by every reset; background work started before a reset discards its result. */
    private val generation = AtomicInteger(0)

    /** Time sources: wall clock (may be wrong after boot) and device time. Replaceable in tests. */
    @VisibleForTesting
    internal var wallNow: () -> Long = { System.currentTimeMillis() }

    @VisibleForTesting
    internal var elapsedNow: () -> Long = { SystemClock.elapsedRealtime() }

    /** True if this build / device can use the compiler (fyt system build, Android 8-13). */
    @JvmStatic
    fun isSupported(): Boolean =
        TEST_BUILD_TYPE_PREFIXES.none { BuildConfig.BUILD_TYPE.startsWith(it) } &&
            Process.myUid() == Process.SYSTEM_UID &&
            Build.VERSION.SDK_INT in Build.VERSION_CODES.O..Build.VERSION_CODES.TIRAMISU

    /** True once a compilation finished in this process: its code is used from the next launcher start. */
    @Volatile
    private var compiledInThisProcess = false

    /**
     * Call from LauncherApplication once per process start. Cheap and safe in every process.
     *
     * @param coldBoot true for the first launcher start after a device restart
     * (ColdStart.isColdBoot()); such a start always counts as a session.
     */
    @JvmStatic
    @JvmOverloads
    fun scheduleIfNeeded(app: Application, coldBoot: Boolean = false) {
        if (!isSupported()) return
        // Main process only (LauncherApplication is also created in :wallpaper_chooser).
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P &&
            Application.getProcessName() != app.packageName
        ) return
        if (!scheduled.compareAndSet(false, true)) return
        appContext = app.applicationContext

        val prefs = prefs(app)
        removeLegacyKeys(prefs)
        val stamp = apkStamp(app)
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) {
            onUsageSession(app, if (coldBoot) "device restart" else "process restart", countSession = true, countAlways = coldBoot)
        } else {
            scheduleInitialCompilation(app, prefs, stamp, START_DELAY_MS)
        }
        startTicker(app)
    }

    /**
     * Call from WakeDetectionService when the head unit wakes up (display on after sleep).
     * Counts a usage session, or restarts a pending initial compilation cancelled by the sleep.
     */
    @JvmStatic
    fun onDeviceWake(context: Context) {
        if (!isSupported()) return
        val app = context.applicationContext
        if (appContext == null) appContext = app
        val prefs = prefs(app)
        val stamp = apkStamp(app)
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) {
            onUsageSession(app, "wake", countSession = true, countAlways = false)
        } else if (!hasPendingJob()) {
            scheduleInitialCompilation(app, prefs, stamp, START_DELAY_MS)
        }
    }

    /** Call from WakeDetectionService when the head unit goes to sleep (ACC off). */
    @JvmStatic
    fun onDeviceSleep() {
        if (cancelPendingJob()) Log.i(TAG, "Sleep: pending compilation postponed to the next wake")
        // Save device time now: if the unit is powered off during the sleep, it is not lost.
        appContext?.let { ctx ->
            val prefs = prefs(ctx)
            val editor = prefs.edit()
            updateDeviceTime(prefs, editor)
            editor.apply()
        }
    }

    /** Human-readable status, e.g. for an "About" entry in the launcher settings. Blocking - call off the main thread. */
    @JvmStatic
    @WorkerThread
    fun statusText(context: Context): String {
        val prefs = prefs(context)
        // Bring device time and a pending compile time up to date for the display.
        prefs.edit().also { updateDeviceTime(prefs, it) }.apply()
        prefs.edit().also { resolveCompileTime(prefs, it) }.apply()

        val last = prefs.getString(KEY_LAST_STATUS, "none") ?: "none"
        val clockValid = isWallClockValid(wallNow())
        // Note: ProfileVerifier caches its result per APK, so it may lag until the next restart.
        val verifier = runCatching {
            val s = ProfileVerifier.getCompilationStatusAsync().get()
            "code=${s.profileInstallResultCode}, compiledWithProfile=${s.isCompiledWithProfile}, " +
                "enqueued=${s.hasProfileEnqueuedForCompilation()}"
        }.getOrElse { "unavailable (${it.javaClass.simpleName})" }
        // Whether the compiled code is already in use cannot be stored: it depends on the process
        // that shows the status. Only a compilation done by this very process is still inactive.
        // Older versions stored the activation hint in the status itself.
        val status = last.replace(" (active after the next launcher restart)", "")
        val deployment = when {
            !status.startsWith("OK") -> status
            compiledInThisProcess -> "$status (active after the next launcher start)"
            else -> "$status (active)"
        }
        return "Deployment: $deployment\n" +
            "Last compilation: ${lastCompilationText(prefs)}\n" +
            "Usage refreshes: ${refreshScheduleText(prefs)}\n" +
            "Session = device restart, or a wake-up / launcher restart at least " +
            "${TimeUnit.MILLISECONDS.toMinutes(SESSION_MIN_GAP_MS)} min after the previous session\n" +
            "Clock: " + (if (clockValid) "valid" else "not set yet - days counted from device time") + "\n" +
            "ProfileVerifier: $verifier"
    }

    /** Number of usage refreshes done for the installed APK (for the reset dialog). */
    @JvmStatic
    fun refreshesDone(context: Context): Int = prefs(context).getInt(KEY_REFRESHES, 0)

    /** Number of usage refreshes in the schedule (for the reset dialog). */
    @JvmStatic
    fun refreshesTotal(): Int = REFRESH_AFTER_DAYS.size

    // ---------------------------------------------------------------------------------------
    // Resets (launcher settings)
    // ---------------------------------------------------------------------------------------

    /**
     * Restarts the usage refresh schedule (3 / 14 / 30 days) from now. The data collected so far
     * and the current compilation are kept; the next refreshes keep adding to them.
     */
    @JvmStatic
    fun resetUsageRefreshes(context: Context) {
        if (!isSupported()) return
        generation.incrementAndGet() // a refresh already compiling must not count
        cancelPendingJob()
        val prefs = prefs(context)
        val editor = prefs.edit()
            .putInt(KEY_REFRESHES, 0)
            .putString(KEY_LAST_STATUS, "Usage refresh schedule reset - ${apkStamp(context)}")
        startWaitFromNow(editor)
        editor.apply()
        Log.i(TAG, "Usage refresh schedule reset")
    }

    /**
     * Drops ALL collected profile data and returns to the Baseline Profile shipped in the APK;
     * the initial compilation and the refresh schedule then run again.
     *
     * clearApplicationProfileData() freezes the package, which KILLS this process - the launcher
     * restarts, and on that start the initial compilation runs as for a new APK. The state is
     * committed before the call for that reason. Blocking binder call: call off the main thread.
     *
     * @return false if the profiles could not be cleared (nothing was killed; the Baseline
     * Profile is then re-applied on top of the collected data). Normally the function does not
     * return at all.
     */
    @JvmStatic
    @WorkerThread
    fun resetToBaselineProfile(context: Context): Boolean {
        if (!isSupported()) return false
        generation.incrementAndGet()
        cancelPendingJob()
        val app = context.applicationContext
        val prefs = prefs(app)
        val editor = prefs.edit()
            .remove(KEY_DONE_FOR)
            .remove(KEY_ATTEMPT_FOR)
            .remove(KEY_ATTEMPTS)
            .putInt(KEY_REFRESHES, 0)
            .putString(KEY_LAST_STATUS, "Reset to the baseline profile - recompiling after the restart")
        startWaitFromNow(editor)
        editor.commit()

        return try {
            Log.i(TAG, "Full reset: clearing profiles, the launcher process will be killed")
            val pm = systemPackageManager()
            pm.javaClass.getMethod("clearApplicationProfileData", String::class.java)
                .invoke(pm, app.packageName)
            // Still alive (the firmware did not kill the package): compile right away instead.
            Log.w(TAG, "Full reset: process was not killed, compiling now")
            scheduleInitialCompilation(app, prefs, apkStamp(app), 0L)
            true
        } catch (t: Throwable) {
            // Profiles not cleared: at least re-apply the Baseline Profile on top of them now,
            // instead of leaving the state "pending" until the next restart.
            Log.e(TAG, "Full reset failed, re-applying the baseline profile only", t)
            scheduleInitialCompilation(app, prefs, apkStamp(app), 0L)
            false
        }
    }

    // ---------------------------------------------------------------------------------------
    // Phase 1: initial compilation of a new APK
    // ---------------------------------------------------------------------------------------

    private fun scheduleInitialCompilation(
        context: Context,
        prefs: SharedPreferences,
        stamp: String,
        delayMs: Long,
    ) {
        if (attemptsFor(prefs, stamp) >= MAX_ATTEMPTS) {
            Log.w(TAG, "Skipping - $MAX_ATTEMPTS failed attempts for $stamp")
            return
        }
        val gen = generation.get()

        startPendingJob {
            // If the unit is switched off or goes to sleep during the delay, nothing is counted
            // and the next start / wake simply tries again.
            delay(delayMs)
            if (gen != generation.get()) return@startPendingJob

            // Count the attempt only now that the work really starts. Committed synchronously,
            // so an attempt interrupted by power-off still counts (prevents endless retries).
            val attempt = attemptsFor(prefs, stamp) + 1
            prefs.edit().putString(KEY_ATTEMPT_FOR, stamp).putInt(KEY_ATTEMPTS, attempt).commit()

            val ok = runCatching { installAndCompile(context) }
                .onFailure { Log.e(TAG, "Applying the baseline profile failed", it) }
                .getOrDefault(false)
            if (gen != generation.get()) return@startPendingJob

            val editor = prefs.edit()
            val status = if (ok) {
                editor.putString(KEY_DONE_FOR, stamp).putInt(KEY_REFRESHES, 0)
                startWaitFromNow(editor)
                compiledInThisProcess = true
                "OK - initial compilation - $stamp"
            } else {
                "FAILED - attempt $attempt/$MAX_ATTEMPTS - $stamp"
            }
            editor.putString(KEY_LAST_STATUS, status).apply()
            Log.i(TAG, status)
        }
    }

    private suspend fun installAndCompile(context: Context): Boolean {
        // a) Force-write baseline.prof (assets/dexopt in the APK) into the ART current profile.
        val installCode = forceInstallProfile(context)
        Log.i(TAG, "ProfileInstaller result=$installCode")
        if (installCode !in INSTALL_OK) return false

        // b) AOT compilation driven by the profile.
        return compileWithProfile(context.packageName)
    }

    // ---------------------------------------------------------------------------------------
    // Phase 2: usage refreshes
    // ---------------------------------------------------------------------------------------

    /**
     * Counts a session (if [countSession]) and starts a refresh when it is due.
     * Also called without a session when the wall clock got corrected (see [startTicker]).
     */
    private fun onUsageSession(context: Context, source: String, countSession: Boolean, countAlways: Boolean) {
        val prefs = prefs(context)
        val stamp = apkStamp(context)
        if (prefs.getString(KEY_DONE_FOR, null) != stamp) return // initial compilation pending

        // Time bookkeeping first (device time, then a compile time waiting for a valid clock).
        prefs.edit().also { updateDeviceTime(prefs, it) }.apply()
        prefs.edit().also { resolveCompileTime(prefs, it) }.apply()

        val refreshes = prefs.getInt(KEY_REFRESHES, 0)
        if (refreshes >= REFRESH_AFTER_DAYS.size) return
        val editor = prefs.edit()

        // Count the session: a device restart always, anything else only SESSION_MIN_GAP_MS of
        // device time after the previous counted session (or in a different boot). The counter
        // is only a gate and stops at the minimum - ART records every session regardless.
        val minSessions = REFRESH_MIN_SESSIONS[refreshes]
        var sessions = prefs.getInt(KEY_SESSIONS_SINCE_COMPILE, 0)
        if (countSession) {
            val boot = bootId()
            val elapsed = elapsedNow()
            val sameBoot = prefs.getString(KEY_SESSION_BOOT, null) == boot
            val gap = elapsed - prefs.getLong(KEY_SESSION_ELAPSED, 0L)
            if (countAlways || !sameBoot || gap !in 0 until SESSION_MIN_GAP_MS) {
                if (sessions < minSessions) sessions++
                editor.putInt(KEY_SESSIONS_SINCE_COMPILE, sessions)
                    .putString(KEY_SESSION_BOOT, boot)
                    .putLong(KEY_SESSION_ELAPSED, elapsed)
            }
        }
        editor.apply()

        val daysSince = daysSinceCompile(prefs)
        val minDays = REFRESH_AFTER_DAYS[refreshes]
        Log.d(TAG, "Session ($source): day $daysSince/$minDays, sessions $sessions/$minSessions, refresh ${refreshes + 1}")

        if (daysSince >= minDays && sessions >= minSessions) {
            launchRefresh(context, prefs, stamp, refreshes)
        }
    }

    private fun launchRefresh(context: Context, prefs: SharedPreferences, stamp: String, refreshes: Int) {
        if (hasPendingJob()) return
        val gen = generation.get()

        startPendingJob {
            delay(START_DELAY_MS)
            if (gen != generation.get()) return@startPendingJob
            val ok = runCatching { compileWithProfile(context.packageName) }
                .onFailure { Log.e(TAG, "Usage refresh failed", it) }
                .getOrDefault(false)
            if (gen != generation.get()) return@startPendingJob // reset while compiling

            // On failure the wait starts again too, so the next try comes after another full
            // wait instead of on every session.
            val editor = prefs.edit()
            startWaitFromNow(editor)
            val status = if (ok) {
                val done = refreshes + 1
                editor.putInt(KEY_REFRESHES, done)
                compiledInThisProcess = true
                "OK - usage refresh $done/${REFRESH_AFTER_DAYS.size} - $stamp"
            } else {
                "Usage refresh FAILED (will retry) - $stamp"
            }
            editor.putString(KEY_LAST_STATUS, status).apply()
            Log.i(TAG, status)
        }
    }

    /**
     * Runs while the launcher process lives: saves device time every [CHECKPOINT_INTERVAL_MS], and
     * while the wall clock is wrong checks every [CLOCK_CHECK_INTERVAL_MS] whether it has been
     * corrected - then fixes a pending compile time and re-checks whether a refresh is due.
     * The delays pause while the unit sleeps.
     */
    private fun startTicker(context: Context) {
        synchronized(pendingLock) {
            if (tickerJob?.isActive == true) return
            tickerJob = scope.launch {
                var clockWasValid = isWallClockValid(wallNow())
                var sinceCheckpoint = 0L
                while (true) {
                    delay(CLOCK_CHECK_INTERVAL_MS)
                    sinceCheckpoint += CLOCK_CHECK_INTERVAL_MS
                    val clockValid = isWallClockValid(wallNow())
                    if (clockValid && !clockWasValid) {
                        Log.i(TAG, "Wall clock corrected")
                        // Resolves the compile time and starts a refresh if it is due now.
                        onUsageSession(context, "clock corrected", countSession = false, countAlways = false)
                        sinceCheckpoint = 0L
                    } else if (sinceCheckpoint >= CHECKPOINT_INTERVAL_MS) {
                        val prefs = prefs(context)
                        val editor = prefs.edit()
                        updateDeviceTime(prefs, editor)
                        editor.apply()
                        sinceCheckpoint = 0L
                    }
                    clockWasValid = clockValid
                }
            }
        }
    }

    // ---------------------------------------------------------------------------------------
    // Time keeping (independent of the wall clock)
    // ---------------------------------------------------------------------------------------

    /** A wall-clock reading that can be trusted (not the years-old default of a lost clock). */
    private fun isWallClockValid(wallMs: Long): Boolean = wallMs >= MIN_VALID_WALL_TIME_MS

    /** Starts the wait for the next refresh from now (after a compilation or a reset). */
    private fun startWaitFromNow(editor: SharedPreferences.Editor) {
        val now = wallNow()
        editor.putLong(KEY_LAST_COMPILE_AT, if (isWallClockValid(now)) now else -1L)
            .putString(KEY_COMPILE_BOOT, bootId())
            .putLong(KEY_COMPILE_ELAPSED, elapsedNow())
            .putLong(KEY_DEVICE_MS_SINCE_COMPILE, 0L)
            .putString(KEY_CHECKPOINT_BOOT, bootId())
            .putLong(KEY_CHECKPOINT_ELAPSED, elapsedNow())
            .putInt(KEY_SESSIONS_SINCE_COMPILE, 0)
    }

    /** Adds the device time since the last checkpoint (the whole uptime after a reboot). */
    private fun updateDeviceTime(prefs: SharedPreferences, editor: SharedPreferences.Editor) {
        val boot = bootId()
        val elapsed = elapsedNow()
        var total = prefs.getLong(KEY_DEVICE_MS_SINCE_COMPILE, 0L)
        total += if (prefs.getString(KEY_CHECKPOINT_BOOT, null) == boot) {
            (elapsed - prefs.getLong(KEY_CHECKPOINT_ELAPSED, elapsed)).coerceAtLeast(0L)
        } else {
            elapsed // new boot: everything since this boot started
        }
        editor.putLong(KEY_DEVICE_MS_SINCE_COMPILE, total)
            .putString(KEY_CHECKPOINT_BOOT, boot)
            .putLong(KEY_CHECKPOINT_ELAPSED, elapsed)
    }

    /**
     * The "guard" for a compilation made while the wall clock was wrong: once the clock is valid,
     * its calendar time is set - exactly if it happened in this boot, otherwise conservatively as
     * "now minus the device time since it" (the powered-off time is unknown, so it is not added).
     */
    private fun resolveCompileTime(prefs: SharedPreferences, editor: SharedPreferences.Editor) {
        val stored = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        val now = wallNow()
        if (isWallClockValid(stored) || !isWallClockValid(now)) return
        val sameBoot = prefs.getString(KEY_COMPILE_BOOT, null) == bootId()
        val resolved = if (sameBoot) {
            now - (elapsedNow() - prefs.getLong(KEY_COMPILE_ELAPSED, elapsedNow()))
        } else {
            now - prefs.getLong(KEY_DEVICE_MS_SINCE_COMPILE, 0L)
        }
        editor.putLong(KEY_LAST_COMPILE_AT, resolved)
        Log.i(TAG, "Compile time resolved after the clock was corrected: ${formatTime(resolved)}")
    }

    /**
     * Days since the last compilation: the larger of calendar days (only if both readings are
     * valid) and device days. Both are lower bounds of the real time, so neither can make a
     * refresh come too early, and a wrong clock can never block it.
     */
    private fun daysSinceCompile(prefs: SharedPreferences): Long {
        val deviceDays = TimeUnit.MILLISECONDS.toDays(prefs.getLong(KEY_DEVICE_MS_SINCE_COMPILE, 0L))
        val compileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        val now = wallNow()
        val calendarDays = if (isWallClockValid(compileAt) && isWallClockValid(now) && now >= compileAt) {
            TimeUnit.MILLISECONDS.toDays(now - compileAt)
        } else {
            0L
        }
        return maxOf(deviceDays, calendarDays)
    }

    private fun lastCompilationText(prefs: SharedPreferences): String {
        if (prefs.getString(KEY_DONE_FOR, null) == null) return "never"
        val compileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        if (isWallClockValid(compileAt)) return formatTime(compileAt)
        val hours = TimeUnit.MILLISECONDS.toHours(prefs.getLong(KEY_DEVICE_MS_SINCE_COMPILE, 0L))
        return "${hours} h of device time ago (date set once the clock is valid)"
    }

    private fun refreshScheduleText(prefs: SharedPreferences): String {
        val refreshes = prefs.getInt(KEY_REFRESHES, 0)
        val total = REFRESH_AFTER_DAYS.size
        if (refreshes >= total) return "$refreshes/$total - all done"
        val daysSince = daysSinceCompile(prefs)
        val sessions = prefs.getInt(KEY_SESSIONS_SINCE_COMPILE, 0)
        val minDays = REFRESH_AFTER_DAYS[refreshes]
        val minSessions = REFRESH_MIN_SESSIONS[refreshes]
        // Day limit passed but sessions missing: the limit moves along with the current day.
        val dueDay = if (daysSince >= minDays && sessions < minSessions) daysSince else minDays
        return "$refreshes/$total - next: day $daysSince/$dueDay, sessions $sessions/$minSessions"
    }

    // ---------------------------------------------------------------------------------------
    // System calls
    // ---------------------------------------------------------------------------------------

    /**
     * performDexOptMode(speed-profile) with checkProfiles=true: installd merges the current
     * profile (baseline + methods recorded by ART) into the reference profile and compiles it.
     * Does not kill the running launcher; the new code is used from the next process start.
     * Synchronous binder call - may take tens of seconds.
     */
    private fun compileWithProfile(pkg: String): Boolean {
        val pm = systemPackageManager()
        val boolType = java.lang.Boolean.TYPE
        val dexopt = pm.javaClass.getMethod(
            "performDexOptMode",
            String::class.java, boolType, String::class.java, boolType, boolType, String::class.java,
        )
        val compiled = dexopt.invoke(
            pm,
            pkg,
            /* checkProfiles = */ true,
            /* targetCompilerFilter = */ "speed-profile",
            /* force = */ true,
            /* bootComplete = */ true,
            /* splitName = */ null,
        ) as Boolean
        Log.i(TAG, "performDexOptMode(speed-profile) = $compiled")
        return compiled
    }

    /** IPackageManager proxy to system_server (hidden API - allowed for platform-signed apps). */
    private fun systemPackageManager(): Any =
        Class.forName("android.app.ActivityThread").getMethod("getPackageManager").invoke(null)!!

    /**
     * The same mechanism Macrobenchmark uses: an ordered broadcast to ProfileInstallReceiver
     * (protected by the DUMP permission, which UID 1000 always passes). The receiver writes the
     * profile with force=true and reports the ProfileInstaller result as the result code.
     */
    private suspend fun forceInstallProfile(appContext: Context): Int? = withTimeoutOrNull(INSTALL_TIMEOUT_MS) {
        suspendCancellableCoroutine { cont ->
            val installIntent = Intent(ACTION_INSTALL_PROFILE).setClassName(appContext, RECEIVER)
            appContext.sendOrderedBroadcast(
                installIntent,
                null,
                object : BroadcastReceiver() {
                    override fun onReceive(context: Context, intent: Intent) {
                        if (cont.isActive) cont.resume(resultCode)
                    }
                },
                Handler(Looper.getMainLooper()),
                Activity.RESULT_CANCELED,
                null,
                null,
            )
        }
    }

    // ---------------------------------------------------------------------------------------
    // Pending job
    // ---------------------------------------------------------------------------------------

    private fun hasPendingJob(): Boolean = synchronized(pendingLock) { pendingJob?.isActive == true }

    /** Cancels the job still waiting for its delay. A compilation already running finishes. */
    private fun cancelPendingJob(): Boolean = synchronized(pendingLock) {
        val wasActive = pendingJob?.isActive == true
        pendingJob?.cancel()
        pendingJob = null
        wasActive
    }

    /** Starts [block] as the single pending job (replacing a finished one). */
    private fun startPendingJob(block: suspend () -> Unit) {
        synchronized(pendingLock) {
            if (pendingJob?.isActive == true) return
            pendingJob = scope.launch { block() }
        }
    }

    // ---------------------------------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------------------------------

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    private fun attemptsFor(prefs: SharedPreferences, stamp: String): Int =
        if (prefs.getString(KEY_ATTEMPT_FOR, null) == stamp) prefs.getInt(KEY_ATTEMPTS, 0) else 0

    /**
     * Removes the wall-clock based keys of older versions. A compile time saved while the clock
     * was wrong is treated as unknown and resolved like a new one.
     */
    private fun removeLegacyKeys(prefs: SharedPreferences) {
        val editor = prefs.edit()
        var changed = false
        LEGACY_KEYS.filter { prefs.contains(it) }.forEach { editor.remove(it); changed = true }
        val compileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        if (compileAt != -1L && !isWallClockValid(compileAt)) {
            editor.putLong(KEY_LAST_COMPILE_AT, -1L)
            changed = true
        }
        if (changed) editor.apply()
    }

    /**
     * Identifies the current boot: kernel boot id, or the boot counter if it cannot be read.
     * Cached - it cannot change while this process runs.
     */
    private fun bootId(): String = cachedBootId ?: run {
        val id = runCatching { File("/proc/sys/kernel/random/boot_id").readText().trim() }
            .getOrNull()
            ?.takeIf { it.isNotEmpty() }
            ?: appContext?.let { ctx ->
                runCatching { "count-" + Settings.Global.getInt(ctx.contentResolver, Settings.Global.BOOT_COUNT) }.getOrNull()
            }
            ?: "unknown"
        id.also { if (it != "unknown") cachedBootId = it }
    }

    @Volatile
    private var cachedBootId: String? = null

    /**
     * Identifies the installed APK: version name + APK file time + size. The file time and size
     * also catch a reinstall of the same version (e.g. a rebuilt APK from the USB stick).
     */
    private fun apkStamp(context: Context): String =
        // The APK cannot change while this process runs (an install kills it), so cache it -
        // onUsageSession() runs on the main thread for every wake-up.
        cachedStamp ?: run {
            val apk = File(context.applicationInfo.sourceDir)
            "${BuildConfig.VERSION_NAME}:${apk.lastModified()}:${apk.length()}".also { cachedStamp = it }
        }

    @Volatile
    private var cachedStamp: String? = null

    private fun formatTime(millis: Long): String =
        SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(Date(millis))
}
