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
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.profileinstaller.ProfileVerifier
import com.android.launcher66.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
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
 *         device restart - counts if at least [SESSION_MIN_GAP_MS] passed since the previous
 *         counted session (filters quick display off/on and crash restarts).
 *     Wake-ups count because many FYT units sleep instead of rebooting on ACC off, so the
 *     launcher process can live for weeks.
 *     The session counter is only a gate: it stops at the minimum (5/5, 10/10), while ART keeps
 *     recording every further session, so a refresh at the day limit compiles the data of all
 *     sessions since the previous compilation.
 *     If the day limit passes with too few sessions, the limit moves forward one day per day
 *     until the sessions are reached; the refresh then runs without further delay.
 *     Step a is NOT repeated - it would overwrite the recorded usage data.
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
    private const val KEY_LAST_COMPILE_AT = "last_compile_at"
    private const val KEY_SESSIONS_SINCE_COMPILE = "starts_since_compile" // name kept for existing installs
    private const val KEY_LAST_SESSION_AT = "last_session_at"
    private const val KEY_REFRESH_DUE_DAY = "refresh_due_day"
    private const val KEY_REFRESHES = "refreshes"
    private const val MAX_ATTEMPTS = 3

    /** Days after the previous compilation at which each usage refresh becomes due. */
    private val REFRESH_AFTER_DAYS = longArrayOf(3, 14, 30)

    /** Usage sessions since the previous compilation required for each refresh. */
    private val REFRESH_MIN_SESSIONS = intArrayOf(5, 10, 10)

    /** Minimum gap between two counted wake-up / process-restart sessions (device restarts always count). */
    private val SESSION_MIN_GAP_MS = TimeUnit.MINUTES.toMillis(3)

    /** Head unit boot is busy (CAN bus, BT, navigation) - do not compete for CPU. */
    private const val START_DELAY_MS = 90_000L
    private const val INSTALL_TIMEOUT_MS = 30_000L

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

    /** Incremented by every reset; background work started before a reset discards its result. */
    private val generation = AtomicInteger(0)

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
     * (LauncherApplication.isFirstStartAfterColdBoot()); such a start always counts as a session.
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

        val prefs = prefs(app)
        val stamp = apkStamp(app)
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) {
            onUsageSession(app, if (coldBoot) "device restart" else "process restart", coldBoot)
        } else {
            scheduleInitialCompilation(app, prefs, stamp, START_DELAY_MS)
        }
    }

    /**
     * Call from WakeDetectionService when the head unit wakes up (display on after sleep).
     * Counts a usage session, or restarts a pending initial compilation cancelled by the sleep.
     */
    @JvmStatic
    fun onDeviceWake(context: Context) {
        if (!isSupported()) return
        val appContext = context.applicationContext
        val prefs = prefs(appContext)
        val stamp = apkStamp(appContext)
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) {
            onUsageSession(appContext, "wake", countAlways = false)
        } else if (!hasPendingJob()) {
            scheduleInitialCompilation(appContext, prefs, stamp, START_DELAY_MS)
        }
    }

    /** Call from WakeDetectionService when the head unit goes to sleep (ACC off). */
    @JvmStatic
    fun onDeviceSleep() {
        if (cancelPendingJob()) Log.i(TAG, "Sleep: pending compilation postponed to the next wake")
    }

    /** Human-readable status, e.g. for an "About" entry in the launcher settings. Blocking - call off the main thread. */
    @JvmStatic
    @WorkerThread
    fun statusText(context: Context): String {
        val prefs = prefs(context)
        val last = prefs.getString(KEY_LAST_STATUS, "none") ?: "none"
        val lastCompileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        val compiledAt = if (lastCompileAt > 0) formatTime(lastCompileAt) else "never"
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
            "Last compilation: $compiledAt\n" +
            "Usage refreshes: ${refreshScheduleText(prefs)}\n" +
            "Session = device restart, or a wake-up / launcher restart at least " +
            "${TimeUnit.MILLISECONDS.toMinutes(SESSION_MIN_GAP_MS)} min after the previous session\n" +
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
        prefs.edit()
            .putInt(KEY_REFRESHES, 0)
            .putInt(KEY_SESSIONS_SINCE_COMPILE, 0)
            .putLong(KEY_LAST_COMPILE_AT, System.currentTimeMillis())
            .remove(KEY_REFRESH_DUE_DAY)
            .putString(KEY_LAST_STATUS, "Usage refresh schedule reset - ${apkStamp(context)}")
            .apply()
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
        val appContext = context.applicationContext
        val prefs = prefs(appContext)
        prefs.edit()
            .remove(KEY_DONE_FOR)
            .remove(KEY_ATTEMPT_FOR)
            .remove(KEY_ATTEMPTS)
            .remove(KEY_LAST_COMPILE_AT)
            .remove(KEY_LAST_SESSION_AT)
            .remove(KEY_REFRESH_DUE_DAY)
            .putInt(KEY_REFRESHES, 0)
            .putInt(KEY_SESSIONS_SINCE_COMPILE, 0)
            .putString(KEY_LAST_STATUS, "Reset to the baseline profile - recompiling after the restart")
            .commit()

        return try {
            Log.i(TAG, "Full reset: clearing profiles, the launcher process will be killed")
            val pm = systemPackageManager()
            pm.javaClass.getMethod("clearApplicationProfileData", String::class.java)
                .invoke(pm, appContext.packageName)
            // Still alive (the firmware did not kill the package): compile right away instead.
            Log.w(TAG, "Full reset: process was not killed, compiling now")
            scheduleInitialCompilation(appContext, prefs, apkStamp(appContext), 0L)
            true
        } catch (t: Throwable) {
            // Profiles not cleared: at least re-apply the Baseline Profile on top of them now,
            // instead of leaving the state "pending" until the next restart.
            Log.e(TAG, "Full reset failed, re-applying the baseline profile only", t)
            scheduleInitialCompilation(appContext, prefs, apkStamp(appContext), 0L)
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
                editor.putString(KEY_DONE_FOR, stamp)
                    .putLong(KEY_LAST_COMPILE_AT, System.currentTimeMillis())
                    .putInt(KEY_SESSIONS_SINCE_COMPILE, 0)
                    .putInt(KEY_REFRESHES, 0)
                    .remove(KEY_REFRESH_DUE_DAY)
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

    private fun onUsageSession(context: Context, source: String, countAlways: Boolean) {
        val prefs = prefs(context)
        val stamp = apkStamp(context)
        if (prefs.getString(KEY_DONE_FOR, null) != stamp) return // initial compilation pending
        val refreshes = prefs.getInt(KEY_REFRESHES, 0)
        if (refreshes >= REFRESH_AFTER_DAYS.size) return

        val now = System.currentTimeMillis()
        val editor = prefs.edit()

        // Count the session: a device restart always, anything else only SESSION_MIN_GAP_MS after
        // the previous counted session (a clock jump backwards simply counts). The counter is
        // only a gate and stops at the minimum - ART records every session regardless, so the
        // refresh at the day limit compiles the usage of all sessions since the last compilation.
        val minSessions = REFRESH_MIN_SESSIONS[refreshes]
        var sessions = prefs.getInt(KEY_SESSIONS_SINCE_COMPILE, 0)
        val sinceLastSession = now - prefs.getLong(KEY_LAST_SESSION_AT, 0L)
        if (countAlways || sinceLastSession !in 0 until SESSION_MIN_GAP_MS) {
            if (sessions < minSessions) sessions++
            editor.putInt(KEY_SESSIONS_SINCE_COMPILE, sessions).putLong(KEY_LAST_SESSION_AT, now)
        }

        var lastCompileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        if (lastCompileAt < 0 || lastCompileAt > now) {
            // Missing (compiled by a version without refreshes) or in the future (head units
            // often boot with a wrong clock and sync it later) - start the wait now.
            lastCompileAt = now
            editor.putLong(KEY_LAST_COMPILE_AT, now)
        }
        val daysSince = TimeUnit.MILLISECONDS.toDays(now - lastCompileAt)
        var dueDay = maxOf(REFRESH_AFTER_DAYS[refreshes], prefs.getLong(KEY_REFRESH_DUE_DAY, 0L))
        if (daysSince >= dueDay && sessions < minSessions) {
            // Day limit reached without enough usage: move it to today. It advances by one day
            // per day until the sessions are reached, and the refresh then runs right away.
            dueDay = daysSince
            editor.putLong(KEY_REFRESH_DUE_DAY, dueDay)
        }
        editor.apply()
        Log.d(TAG, "Session ($source): day $daysSince/$dueDay, sessions $sessions/$minSessions, refresh ${refreshes + 1}")

        if (daysSince >= dueDay && sessions >= minSessions) {
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

            // On failure the counters are reset too, so the next try comes after another
            // full wait instead of on every session.
            val editor = prefs.edit()
                .putLong(KEY_LAST_COMPILE_AT, System.currentTimeMillis())
                .putInt(KEY_SESSIONS_SINCE_COMPILE, 0)
                .remove(KEY_REFRESH_DUE_DAY)
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

    private fun refreshScheduleText(prefs: SharedPreferences): String {
        val refreshes = prefs.getInt(KEY_REFRESHES, 0)
        val total = REFRESH_AFTER_DAYS.size
        if (refreshes >= total) return "$refreshes/$total - all done"
        val lastCompileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        val now = System.currentTimeMillis()
        val daysSince = if (lastCompileAt in 0..now) TimeUnit.MILLISECONDS.toDays(now - lastCompileAt) else 0
        val dueDay = maxOf(REFRESH_AFTER_DAYS[refreshes], prefs.getLong(KEY_REFRESH_DUE_DAY, 0L))
        val sessions = prefs.getInt(KEY_SESSIONS_SINCE_COMPILE, 0)
        return "$refreshes/$total - next: day $daysSince/$dueDay, " +
            "sessions $sessions/${REFRESH_MIN_SESSIONS[refreshes]}"
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
    // Helpers
    // ---------------------------------------------------------------------------------------

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    private fun attemptsFor(prefs: SharedPreferences, stamp: String): Int =
        if (prefs.getString(KEY_ATTEMPT_FOR, null) == stamp) prefs.getInt(KEY_ATTEMPTS, 0) else 0

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
