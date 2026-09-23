package com.android.launcher66.perf

import android.app.Activity
import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.util.Log
import androidx.profileinstaller.ProfileVerifier
import com.android.launcher66.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.resume

/**
 * Applies the Baseline Profile on FYT head units without root and without a PC.
 *
 * Why this is needed:
 *  - ProfileInstaller only copies baseline.prof into the ART profile. The actual AOT compilation
 *    is done by the background dexopt job, which requires "idle maintenance" (screen off,
 *    charging, long inactivity) - a state a car head unit practically never reaches.
 *  - The USB-stick install script runs before the reboot, when PackageManager does not know
 *    the new APK yet and ProfileInstaller has not run, so it cannot compile anything.
 *
 * Why it works without root: the launcher runs as UID 1000 (android.uid.system) and is signed
 * with the platform key, so system_server grants it the same operations as "adb shell":
 *   1. forced write of baseline.prof from the APK into the ART profile (ProfileInstallReceiver)
 *   2. performDexOptMode(speed-profile)     (= cmd package compile -m speed-profile -f)
 *
 * IMPORTANT: do NOT call IPackageManager.clearApplicationProfileData() here. It freezes the
 * package, and freezing kills every process of the package - i.e. the launcher kills itself
 * before it can compile. It is also not needed: the forced write replaces the current profile,
 * and profman discards reference-profile data whose DEX checksums do not match the new APK.
 *
 * Runs once per new APK (identified by version name + APK file time + size, because
 * versionCode is constant), in the background, after a startup delay. The compiled code is
 * used from the next start of the launcher process (in practice: the next ignition cycle).
 */
object BaselineProfileCompiler {

    private const val TAG = "BaselineProfile"
    private const val PREFS = "baseline_profile_state"
    private const val KEY_DONE_FOR = "done_for"
    private const val KEY_ATTEMPT_FOR = "attempt_for"
    private const val KEY_ATTEMPTS = "attempts"
    private const val KEY_LAST_STATUS = "last_status"
    private const val MAX_ATTEMPTS = 3

    /** Head unit boot is busy (CAN bus, BT, navigation) - do not compete for CPU. */
    private const val START_DELAY_MS = 90_000L
    private const val INSTALL_TIMEOUT_MS = 30_000L

    private const val ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE"
    private const val RECEIVER = "androidx.profileinstaller.ProfileInstallReceiver"

    /** ProfileInstaller result codes: 1 = RESULT_INSTALL_SUCCESS, 2 = RESULT_ALREADY_INSTALLED. */
    private val INSTALL_OK = setOf(1, 2)

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val scheduled = AtomicBoolean(false)

    /** Call from LauncherApplication.onCreate(). Cheap and safe to call in every process. */
    @JvmStatic
    fun scheduleIfNeeded(app: Application) {
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
        if (prefs.getString(KEY_DONE_FOR, null) == stamp) return
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

            val ok = runCatching { run(app) }
                .onFailure { Log.e(TAG, "Applying the baseline profile failed", it) }
                .getOrDefault(false)

            val status = if (ok) {
                "OK - compiled with speed-profile - $stamp"
            } else {
                "FAILED - attempt $attempt/$MAX_ATTEMPTS - $stamp"
            }
            val editor = prefs.edit().putString(KEY_LAST_STATUS, status)
            if (ok) editor.putString(KEY_DONE_FOR, stamp)
            editor.apply()
            Log.i(TAG, status)
        }
    }

    /** Human-readable status, e.g. for an "About" entry in the launcher settings. */
    @JvmStatic
    fun statusText(context: Context): String {
        val last = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_LAST_STATUS, "none") ?: "none"
        // Note: ProfileVerifier caches its result per APK, so it may lag until the next restart.
        val verifier = runCatching {
            val s = ProfileVerifier.getCompilationStatusAsync().get()
            "code=${s.profileInstallResultCode}, compiledWithProfile=${s.isCompiledWithProfile}, " +
                "enqueued=${s.hasProfileEnqueuedForCompilation()}"
        }.getOrElse { "unavailable (${it.javaClass.simpleName})" }
        return "Deployment: $last\nProfileVerifier: $verifier"
    }

    private suspend fun run(app: Application): Boolean {
        val pkg = app.packageName
        val pm = systemPackageManager()

        // 1) Force-write baseline.prof (assets/dexopt in the APK) into the ART current profile.
        val installCode = forceInstallProfile(app)
        Log.i(TAG, "ProfileInstaller result=$installCode")
        if (installCode !in INSTALL_OK) return false

        // 2) AOT compilation driven by the profile. Does not kill the running launcher;
        //    the new code is used from the next process start. Synchronous binder call - may take tens of seconds.
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
    private suspend fun forceInstallProfile(context: Context): Int? = withTimeoutOrNull(INSTALL_TIMEOUT_MS) {
        suspendCancellableCoroutine { cont ->
            val intent = Intent(ACTION_INSTALL_PROFILE).setClassName(context, RECEIVER)
            context.sendOrderedBroadcast(
                intent,
                null,
                object : BroadcastReceiver() {
                    override fun onReceive(c: Context, i: Intent) {
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

    private fun attemptsFor(prefs: android.content.SharedPreferences, stamp: String): Int =
        if (prefs.getString(KEY_ATTEMPT_FOR, null) == stamp) prefs.getInt(KEY_ATTEMPTS, 0) else 0

    private fun apkStamp(context: Context): String {
        val apk = File(context.applicationInfo.sourceDir)
        return "${BuildConfig.VERSION_NAME}:${apk.lastModified()}:${apk.length()}"
    }
}
