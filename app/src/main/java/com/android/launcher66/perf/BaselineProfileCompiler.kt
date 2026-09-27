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
import androidx.profileinstaller.ProfileVerifier
import com.android.launcher66.BuildConfig
import com.android.launcher66.perf.BaselineProfileCompiler.REFRESH_AFTER_DAYS
import com.android.launcher66.perf.BaselineProfileCompiler.REFRESH_MIN_STARTS
import com.android.launcher66.perf.BaselineProfileCompiler.START_DELAY_MS
import kotlinx.coroutines.CoroutineScope
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
 *     profile. After [REFRESH_AFTER_DAYS] days and [REFRESH_MIN_STARTS] launcher starts, the app
 *     is compiled again (step b only), which merges that usage data into the compiled code.
 *     Step a is NOT repeated - it would overwrite the recorded usage data.
 *
 * Everything runs in the background without any user interaction and without restarting the
 * launcher; freshly compiled code is used from the next start of the launcher process.
 *
 * IMPORTANT: do NOT call IPackageManager.clearApplicationProfileData() here. It freezes the
 * package, and freezing kills every process of the package - i.e. the launcher kills itself
 * before it can compile. It is also not needed: the forced write replaces the current profile,
 * and profman discards reference-profile data whose DEX checksums do not match the new APK.
 */
object BaselineProfileCompiler {

    private const val TAG = "BaselineProfile"
    private const val PREFS = "baseline_profile_state"
    private const val KEY_DONE_FOR = "done_for"
    private const val KEY_ATTEMPT_FOR = "attempt_for"
    private const val KEY_ATTEMPTS = "attempts"
    private const val KEY_LAST_STATUS = "last_status"
    private const val KEY_LAST_COMPILE_AT = "last_compile_at"
    private const val KEY_STARTS_SINCE_COMPILE = "starts_since_compile"
    private const val KEY_REFRESHES = "refreshes"
    private const val MAX_ATTEMPTS = 3

    /**
     * Days after the previous compilation at which a usage refresh is due, one entry per refresh.
     * After the last entry the compilation is left as it is until the next APK.
     */
    private val REFRESH_AFTER_DAYS = longArrayOf(3, 14, 30)

    /** Minimum launcher starts since the previous compilation (enough real usage recorded). */
    private const val REFRESH_MIN_STARTS = 10

    /** Head unit boot is busy (CAN bus, BT, navigation) - do not compete for CPU. */
    private const val START_DELAY_MS = 90_000L
    private const val INSTALL_TIMEOUT_MS = 30_000L

    private const val ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE"
    private const val RECEIVER = "androidx.profileinstaller.ProfileInstallReceiver"

    /** ProfileInstaller result codes: 1 = RESULT_INSTALL_SUCCESS, 2 = RESULT_ALREADY_INSTALLED. */
    private val INSTALL_OK = setOf(1, 2)

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val scheduled = AtomicBoolean(false)

    /**
     * Build types created by the Baseline Profile Gradle plugin. The profile generator and
     * StartupBenchmark control compilation themselves; compiling behind their back would
     * distort the collected profile and the measurements.
     */
    private val TEST_BUILD_TYPE_PREFIXES = listOf("nonMinified", "benchmark")

    /** Call from LauncherApplication.onCreate(). Cheap and safe to call in every process. */
    @JvmStatic
    fun scheduleIfNeeded(app: Application) {
        if (TEST_BUILD_TYPE_PREFIXES.any { BuildConfig.BUILD_TYPE.startsWith(it) }) return
        // System UID only (fyt flavor) and Android 8-13 (API 34+ uses ART Service with a different API).
        if (Process.myUid() != Process.SYSTEM_UID) return
        if (Build.VERSION.SDK_INT !in Build.VERSION_CODES.O..Build.VERSION_CODES.TIRAMISU) return
        // Main process only (LauncherApplication is also created in :wallpaper_chooser).
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P &&
            Application.getProcessName() != app.packageName
        ) return
        if (!scheduled.compareAndSet(false, true)) return

        val prefs = app.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val stamp = apkStamp(app)
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) {
            scheduleRefreshIfDue(app, prefs, stamp)
        } else {
            scheduleInitialCompilation(app, prefs, stamp)
        }
    }

    /** Human-readable status, e.g. for an "About" entry in the launcher settings. */
    @JvmStatic
    fun statusText(context: Context): String {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val last = prefs.getString(KEY_LAST_STATUS, "none") ?: "none"
        val lastCompileAt = prefs.getLong(KEY_LAST_COMPILE_AT, 0L)
        val compiledAt = if (lastCompileAt > 0) formatTime(lastCompileAt) else "never"
        val refreshes = "${prefs.getInt(KEY_REFRESHES, 0)}/${REFRESH_AFTER_DAYS.size}"
        val starts = prefs.getInt(KEY_STARTS_SINCE_COMPILE, 0)
        // Note: ProfileVerifier caches its result per APK, so it may lag until the next restart.
        val verifier = runCatching {
            val s = ProfileVerifier.getCompilationStatusAsync().get()
            "code=${s.profileInstallResultCode}, compiledWithProfile=${s.isCompiledWithProfile}, " +
                "enqueued=${s.hasProfileEnqueuedForCompilation()}"
        }.getOrElse { "unavailable (${it.javaClass.simpleName})" }
        return "Deployment: $last\n" +
            "Last compilation: $compiledAt, usage refreshes: $refreshes, starts since: $starts\n" +
            "ProfileVerifier: $verifier"
    }

    // ---------------------------------------------------------------------------------------
    // Phase 1: initial compilation of a new APK
    // ---------------------------------------------------------------------------------------

    private fun scheduleInitialCompilation(app: Application, prefs: SharedPreferences, stamp: String) {
        if (attemptsFor(prefs, stamp) >= MAX_ATTEMPTS) {
            Log.w(TAG, "Skipping - $MAX_ATTEMPTS failed attempts for $stamp")
            return
        }

        scope.launch {
            // If the unit is switched off during the delay, nothing is counted and the
            // next start simply tries again.
            delay(START_DELAY_MS)

            // Count the attempt only now that the work really starts. Committed synchronously,
            // so an attempt interrupted by power-off still counts (prevents endless retries).
            val attempt = attemptsFor(prefs, stamp) + 1
            prefs.edit().putString(KEY_ATTEMPT_FOR, stamp).putInt(KEY_ATTEMPTS, attempt).commit()

            val ok = runCatching { installAndCompile(app) }
                .onFailure { Log.e(TAG, "Applying the baseline profile failed", it) }
                .getOrDefault(false)

            val editor = prefs.edit()
            val status = if (ok) {
                editor.putString(KEY_DONE_FOR, stamp)
                    .putLong(KEY_LAST_COMPILE_AT, System.currentTimeMillis())
                    .putInt(KEY_STARTS_SINCE_COMPILE, 0)
                    .putInt(KEY_REFRESHES, 0)
                "OK (active after the next launcher restart) - $stamp"
            } else {
                "FAILED - attempt $attempt/$MAX_ATTEMPTS - $stamp"
            }
            editor.putString(KEY_LAST_STATUS, status).apply()
            Log.i(TAG, status)
        }
    }

    private suspend fun installAndCompile(app: Application): Boolean {
        // a) Force-write baseline.prof (assets/dexopt in the APK) into the ART current profile.
        val installCode = forceInstallProfile(app)
        Log.i(TAG, "ProfileInstaller result=$installCode")
        if (installCode !in INSTALL_OK) return false

        // b) AOT compilation driven by the profile.
        return compileWithProfile(app.packageName)
    }

    // ---------------------------------------------------------------------------------------
    // Phase 2: usage refreshes
    // ---------------------------------------------------------------------------------------

    private fun scheduleRefreshIfDue(app: Application, prefs: SharedPreferences, stamp: String) {
        val refreshes = prefs.getInt(KEY_REFRESHES, 0)
        if (refreshes >= REFRESH_AFTER_DAYS.size) return

        // Every process start of the launcher counts as usage.
        val starts = prefs.getInt(KEY_STARTS_SINCE_COMPILE, 0) + 1
        prefs.edit().putInt(KEY_STARTS_SINCE_COMPILE, starts).apply()

        val now = System.currentTimeMillis()
        var lastCompileAt = prefs.getLong(KEY_LAST_COMPILE_AT, -1L)
        if (lastCompileAt < 0 || lastCompileAt > now) {
            // Missing (compiled by a version without refreshes) or in the future (head units
            // often boot with a wrong clock and sync it later) - start the wait now.
            lastCompileAt = now
            prefs.edit().putLong(KEY_LAST_COMPILE_AT, now).apply()
        }
        val daysSince = TimeUnit.MILLISECONDS.toDays(now - lastCompileAt)
        if (starts < REFRESH_MIN_STARTS || daysSince < REFRESH_AFTER_DAYS[refreshes]) return

        scope.launch {
            delay(START_DELAY_MS)
            val ok = runCatching { compileWithProfile(app.packageName) }
                .onFailure { Log.e(TAG, "Usage refresh failed", it) }
                .getOrDefault(false)

            // On failure the counters are reset too, so the next try comes after another
            // REFRESH_MIN_STARTS starts instead of on every boot.
            val editor = prefs.edit()
                .putLong(KEY_LAST_COMPILE_AT, System.currentTimeMillis())
                .putInt(KEY_STARTS_SINCE_COMPILE, 0)
            val status = if (ok) {
                val done = refreshes + 1
                editor.putInt(KEY_REFRESHES, done)
                "OK - usage refresh $done/${REFRESH_AFTER_DAYS.size} - $stamp"
            } else {
                "Usage refresh FAILED (will retry) - $stamp"
            }
            editor.putString(KEY_LAST_STATUS, status).apply()
            Log.i(TAG, status)
        }
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

    private fun attemptsFor(prefs: SharedPreferences, stamp: String): Int =
        if (prefs.getString(KEY_ATTEMPT_FOR, null) == stamp) prefs.getInt(KEY_ATTEMPTS, 0) else 0

    /**
     * Identifies the installed APK: version name + APK file time + size. The file time and size
     * also catch a reinstall of the same version (e.g. a rebuilt APK from the USB stick).
     */
    private fun apkStamp(context: Context): String {
        val apk = File(context.applicationInfo.sourceDir)
        return "${BuildConfig.VERSION_NAME}:${apk.lastModified()}:${apk.length()}"
    }

    private fun formatTime(millis: Long): String =
        SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(Date(millis))
}
