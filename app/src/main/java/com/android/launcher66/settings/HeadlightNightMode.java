package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.preference.PreferenceManager;

/**
 * Day/night from the car's lights instead of the sun (Keys.NIGHT_MODE_LIGHTS, off by default).
 *
 * The MCU reports the illumination input (ILL, the lights wire) as FinalMain.U_LAMPLET; CarStates
 * passes it here. With the switch on, lights on means night and lights off means day, for the
 * wallpaper and the brightness alike (see DayNightBrightness.isDayState()) -- tunnels and
 * underground car parks included, with cars that switch their lights automatically. Off, and as
 * long as the MCU has not reported the input yet, the sunrise/sunset times decide as before.
 *
 * It is an explicit choice because in some countries the lights must be on in daytime too; with
 * them on all day, this would mean night all day.
 */
public final class HeadlightNightMode {

    private static final String TAG = "HeadlightNightMode";
    /** A lights change is applied once it has held this long (and only once for a burst). */
    private static final long APPLY_DELAY_MS = 1500L;

    private static final int UNKNOWN = -1;
    private static volatile int sLightsOn = UNKNOWN;   // UNKNOWN, 0 or 1

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    private static Context sContext;
    private static final Runnable APPLY = HeadlightNightMode::applyNow;

    private HeadlightNightMode() {
    }

    /** The switch is on (together with the night mode itself). */
    public static boolean isEnabled(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.NIGHT_MODE, false)
                && prefs.getBoolean(Keys.NIGHT_MODE_LIGHTS, false);
    }

    /**
     * Day (TRUE) or night (FALSE) by the lights, or null when the lights do not decide: switch off,
     * or no report from the MCU yet.
     */
    public static Boolean dayByLights(SharedPreferences prefs) {
        int lights = sLightsOn;
        if (lights == UNKNOWN || !isEnabled(prefs)) {
            return null;
        }
        return lights == 0;
    }

    /** From CarStates (main thread), for every report of FinalMain.U_LAMPLET. */
    public static void onLightsReported(Context context, int value) {
        int lights = value != 0 ? 1 : 0;
        int previous = sLightsOn;
        sLightsOn = lights;
        if (previous == lights) {
            return;
        }
        Log.i(TAG, "Lights " + (lights == 1 ? "on" : "off") + " (U_LAMPLET=" + value + ")");
        sContext = context.getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(sContext);
        if (!isEnabled(prefs)) {
            return;
        }
        MAIN.removeCallbacks(APPLY);
        MAIN.postDelayed(APPLY, APPLY_DELAY_MS);
    }

    /** Re-applies wallpaper and brightness; called when the switch is turned on, too. */
    public static void applyNow() {
        Context context = sContext;
        if (context == null || sLightsOn == UNKNOWN) {
            return;
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (!isEnabled(prefs)) {
            return;
        }
        boolean day = sLightsOn == 0;
        // Brightness at once; the wallpaper goes through SunTask, which asks isDayState() as well
        // and skips the wallpaper when it is already the right one.
        DayNightBrightness.apply(context, day, "lights");
        if (!NightModeService.startSunTaskForSavedLocation(context, "lights")) {
            Log.d(TAG, "No saved location for SunTask; only the brightness followed the lights");
        }
    }

    /** For the settings: apply right away when the switch has just been turned on. */
    public static void onSwitchChanged(Context context) {
        if (sContext == null) {
            sContext = context.getApplicationContext();
        }
        MAIN.removeCallbacks(APPLY);
        MAIN.post(APPLY);
    }
}
