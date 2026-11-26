package com.android.launcher66;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.StateAccessibilityService;
import com.syu.ipc.data.FinalMain;
import com.syu.module.main.DataMain;

/**
 * What a double tap on empty space of the home screen does ("Double-tap action": nothing, lock the screen, turn off
 * the screen).
 *
 * <p>The setting is a creator setting, so with "Stock layout" a double tap does nothing. Locking uses the launcher's
 * accessibility service (the system's global action), so choosing it asks for the service in the permission flow
 * ({@code LauncherPermissionFlow}, step ACCESSIBILITY); turning off follows {@link ScreenOffPlan}. Main thread.
 */
public final class DoubleTapActions {

    private static final String TAG = "DoubleTapActions";

    public static final String NONE = "none";
    public static final String LOCK = "lock";
    public static final String SCREEN_OFF = "screen_off";

    private DoubleTapActions() {
    }

    /** What is chosen now; {@link #NONE} with the stock layout. */
    static String chosen(SharedPreferences prefs) {
        String value = CreatorPrefs.of(prefs).getString(Keys.DOUBLE_TAP_ACTION, NONE);
        return value == null ? NONE : value;
    }

    /** Whether "Lock screen" is chosen but the accessibility service that does it is not on: the permission flow asks. */
    static boolean needsAccessibility(SharedPreferences prefs) {
        return LOCK.equals(chosen(prefs)) && !StateAccessibilityService.isRunning();
    }

    /** "Lock screen" was chosen in the settings: the permission flow asks for the service at the next return to the home screen. */
    public static void lockChosen() {
        LauncherPermissionFlow.armAccessibilityStep();
    }

    /** Whether the locking action exists on this Android (the global action is from Android 9). */
    public static boolean lockAvailable() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P;
    }

    static void perform(Launcher launcher, String action) {
        if (LOCK.equals(action)) {
            lock(launcher);
        } else if (SCREEN_OFF.equals(action)) {
            screenOff(launcher);
        }
    }

    private static void lock(Launcher launcher) {
        if (lockAvailable() && StateAccessibilityService.perform(
                AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN)) {
            Log.i(TAG, "Home double tap: the screen locked through the accessibility service");
            return;
        }
        Log.w(TAG, "Home double tap: cannot lock the screen (accessibility service "
                + (StateAccessibilityService.isRunning() ? "refused" : "off") + ")");
        Toast.makeText(launcher, R.string.double_tap_needs_accessibility, Toast.LENGTH_LONG).show();
        armIfOff();
    }

    private static void armIfOff() {
        if (!StateAccessibilityService.isRunning()) {
            LauncherPermissionFlow.armAccessibilityStep();
        }
    }

    private static void screenOff(Launcher launcher) {
        boolean mainModule = DataMain.PROXY.getRemoteModule() != null;
        ScreenOffPlan.Route route = ScreenOffPlan.route(LauncherApplication.isFytDevice(), mainModule,
                Settings.canDrawOverlays(launcher));
        switch (route) {
            case SYSTEM_COMMAND:
                // The stock tile's own command; the system turns the screen back on with its double tap. Asynchronous: a
                // call into another process, not for the main thread
                DataMain.PROXY.cmdAsync(FinalMain.C_BLACKSCREEN, new int[] {2}, null, null);
                Log.i(TAG, "Home double tap: black screen through com.syu.ms");
                break;
            case OVERLAY:
                ScreenOffOverlay.show(launcher);
                break;
            default:
                // The permission flow asks for it at the next return to the home screen (and says so if it is declined)
                Log.w(TAG, "Home double tap: no permission to draw over other apps, the screen stays on");
                LauncherPermissionFlow.armOverlayStep();
                break;
        }
    }
}
