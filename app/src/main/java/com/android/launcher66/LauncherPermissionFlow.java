package com.android.launcher66;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * The launcher's permission flow: the runtime permissions, the overlay permission, notification
 * access and WRITE_SETTINGS, asked one after another, each once the resume has settled and only
 * while the launcher is in front. Split out of Launcher, which forwards the activity results.
 */
final class LauncherPermissionFlow {

    private final Launcher mLauncher;

    LauncherPermissionFlow(Launcher launcher) {
        mLauncher = launcher;
    }

    // =====================================================================================
    // PERMISSION FLOW
    // =====================================================================================

    /**
     * Everything the launcher asks the user for, in the order it is asked. The runtime permissions
     * share one system dialog; each of the others has a Settings screen of its own.
     */
    private enum PermissionStep { RUNTIME, OVERLAY, NOTIFICATION_ACCESS, WRITE_SETTINGS }

    /**
     * Lets the resume settle before a dialog or screen goes over it: the PiP rebuild starts 250 ms
     * after the resume and staggers its pane launches over about a second after that.
     */
    private static final long PERMISSION_FLOW_DELAY_MS = 1500L;

    /** How often a runtime request cancelled without an answer is asked again. */
    private static final int MAX_RUNTIME_REQUEST_RETRIES = 2;

    /** Steps asked (or found granted) since the process started; a declined one is not asked again. */
    private static final EnumSet<PermissionStep> sPermissionStepsHandled = EnumSet.noneOf(PermissionStep.class);

    private static int sRuntimeRequestRetries = 0;

    /** Step whose dialog or Settings screen is open right now; null if none. */
    private PermissionStep mPermissionStepInFlight = null;

    private final Runnable mPermissionFlowRunnable = this::runNextPermissionStep;

    /**
     * Called at the start of every onPostResume(): the launcher is in front again, so whatever the
     * previous step opened has been closed, and the next step follows once the resume has settled.
     */
    void schedulePermissionFlow() {
        if (mPermissionStepInFlight != null) {
            Log.i(Launcher.TAG, "Permission flow: back from " + mPermissionStepInFlight);
            mPermissionStepInFlight = null;
        }
        mLauncher.mHandler.removeCallbacks(mPermissionFlowRunnable);
        mLauncher.mHandler.postDelayed(mPermissionFlowRunnable, Math.max(PERMISSION_FLOW_DELAY_MS, Launcher.bootStallDelayMs()));
    }

    void runNextPermissionStep() {
        if (sPermissionStepsHandled.size() == PermissionStep.values().length) {
            return; // everything asked (or found granted) already
        }
        // Not in front (any more): the next onPostResume() schedules the flow again.
        if (mPermissionStepInFlight != null || mLauncher.mPaused || mLauncher.isFinishing() || mLauncher.isDestroyed()) {
            return;
        }
        // Do not pull the user out of a drag, or open a screen over a workspace being rebuilt.
        if (mLauncher.mWorkspace == null || (mLauncher.mDragController != null && mLauncher.mDragController.isDragging())) {
            mLauncher.mHandler.removeCallbacks(mPermissionFlowRunnable);
            mLauncher.mHandler.postDelayed(mPermissionFlowRunnable, PERMISSION_FLOW_DELAY_MS);
            return;
        }
        for (PermissionStep step : PermissionStep.values()) {
            if (sPermissionStepsHandled.contains(step)) {
                continue;
            }
            sPermissionStepsHandled.add(step);
            if (isPermissionStepNeeded(step) && startPermissionStep(step)) {
                mPermissionStepInFlight = step;
                Log.i(Launcher.TAG, "Permission flow: asking for " + step);
                return;
            }
        }
    }

    boolean isPermissionStepNeeded(PermissionStep step) {
        switch (step) {
            case RUNTIME:
                return !getMissingRuntimePermissions().isEmpty();
            case OVERLAY:
                return !mLauncher.hasOverlayPermission();
            case NOTIFICATION_ACCESS:
                return !hasNotificationAccess();
            case WRITE_SETTINGS:
                return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                        && !LauncherApplication.hasSystemPrivileges()
                        && !Settings.System.canWrite(mLauncher);
            default:
                return false;
        }
    }

    /**
     * Opens the dialog or Settings screen of a step, always in the launcher's own task (see the
     * notification access screen above).
     *
     * @return false if there is nothing to ask or the screen does not exist on this ROM; the flow
     *         then goes on with the next step
     */
    boolean startPermissionStep(PermissionStep step) {
        try {
            switch (step) {
                case RUNTIME: {
                    List<String> missing = getMissingRuntimePermissions();
                    if (missing.isEmpty()) {
                        return false;
                    }
                    ActivityCompat.requestPermissions(mLauncher, missing.toArray(new String[0]), Launcher.REQUEST_CODE_STORAGE);
                    return true;
                }
                case OVERLAY:
                    mLauncher.startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                            Uri.parse("package:" + mLauncher.getPackageName())), Launcher.REQUEST_CODE_OVERLAY);
                    return true;
                case NOTIFICATION_ACCESS:
                    mLauncher.startActivityForResult(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS),
                            Launcher.REQUEST_CODE_NOTIFICATION_ACCESS);
                    return true;
                case WRITE_SETTINGS:
                    mLauncher.startActivityForResult(new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                            Uri.parse("package:" + mLauncher.getPackageName())), Launcher.REQUEST_CODE_WRITE_SETTINGS);
                    return true;
                default:
                    return false;
            }
        } catch (ActivityNotFoundException | SecurityException | IllegalArgumentException e) {
            Log.w(Launcher.TAG, "Permission flow: cannot ask for " + step + " on this device", e);
            return false;
        }
    }

    /** Runtime permissions still missing: storage (media images on Android 13+) and location. */
    List<String> getMissingRuntimePermissions() {
        List<String> missing = new ArrayList<>();
        String storage = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
                ? android.Manifest.permission.READ_MEDIA_IMAGES
                : android.Manifest.permission.READ_EXTERNAL_STORAGE;
        if (!isPermissionGranted(storage)) {
            missing.add(storage);
        }
        if (!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Always together: Android 12+ ignores a request for FINE without COARSE - also when
            // COARSE is already granted ("approximate") and only precise location is missing,
            // which the old code asked for alone, so that dialog never showed up.
            missing.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            missing.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        } else if (!isPermissionGranted(android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
            missing.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        return missing;
    }

    boolean isPermissionGranted(String permission) {
        return ContextCompat.checkSelfPermission(mLauncher, permission) == PackageManager.PERMISSION_GRANTED;
    }

    boolean hasNotificationAccess() {
        return NotificationManagerCompat.getEnabledListenerPackages(mLauncher).contains(mLauncher.getPackageName());
    }

    static boolean isPermissionFlowRequest(int requestCode) {
        return requestCode == Launcher.REQUEST_CODE_OVERLAY
                || requestCode == Launcher.REQUEST_CODE_NOTIFICATION_ACCESS
                || requestCode == Launcher.REQUEST_CODE_WRITE_SETTINGS;
    }

    /** Back from a Settings screen of the permission flow; see onActivityResult(). */
    void onPermissionScreenResult(int requestCode) {
        if (requestCode == Launcher.REQUEST_CODE_OVERLAY) {
            boolean granted = mLauncher.hasOverlayPermission();
            Log.i(Launcher.TAG, "Permission flow: SYSTEM_ALERT_WINDOW " + (granted ? "granted" : "not granted"));
            if (!granted && mLauncher.mFab.checkIfFloatingButton()) {
                Toast.makeText(mLauncher, "Overlay permission is required", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == Launcher.REQUEST_CODE_NOTIFICATION_ACCESS) {
            Log.i(Launcher.TAG, "Permission flow: notification access "
                    + (hasNotificationAccess() ? "granted" : "not granted"));
        } else if (requestCode == Launcher.REQUEST_CODE_WRITE_SETTINGS) {
            boolean granted = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.System.canWrite(mLauncher);
            Log.i(Launcher.TAG, "Permission flow: WRITE_SETTINGS " + (granted ? "granted" : "not granted"));
        }
    }
    /** onRequestPermissionsResult() for the runtime permissions' dialog. */
    void onRuntimeRequestResult(String[] permissions, int[] grantResults) {
        if (grantResults.length == 0) {
            // Cancelled without an answer (e.g. the dialog was cleared by a home press while another
            // app covered it). That is no decision, so it is asked again once the launcher is back
            // in front. The old code logged it as "all granted" and did not ask again until the
            // launcher was recreated.
            if (sRuntimeRequestRetries < MAX_RUNTIME_REQUEST_RETRIES) {
                sRuntimeRequestRetries++;
                sPermissionStepsHandled.remove(PermissionStep.RUNTIME);
            }
            Log.w(Launcher.TAG, "Permission flow: runtime request cancelled without an answer");
            return;
        }
        for (int i = 0; i < permissions.length && i < grantResults.length; i++) {
            Log.i(Launcher.TAG, "Permission flow: " + permissions[i]
                    + (grantResults[i] == PackageManager.PERMISSION_GRANTED ? " granted" : " denied"));
        }
        // The next step follows from onPostResume(), once the dialog is gone.
    }

    /**
     * The swap buttons need the overlay permission: its step is asked (again) on the next resume.
     * See Launcher.onPostResume().
     */
    static void armOverlayStep() {
        sPermissionStepsHandled.remove(PermissionStep.OVERLAY);
    }

}
