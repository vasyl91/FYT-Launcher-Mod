package com.android.launcher66.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.syu.car.CarStates;
import com.syu.ipc.data.FinalMain;
import com.syu.remote.RemoteTools;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * The only place that sets the screen brightness of the night mode ("dynamic brightness").
 *
 * Callers:
 *  - SunTask, on every day/night refresh (sunrise/sunset job, wake, clock change, launcher resume),
 *    with the same day/night decision it uses for the wallpaper;
 *  - SettingsFragmentFirst, when the user changed something related and left the screen.
 *
 * Nothing is applied unless both the night mode and the dynamic brightness switch are on.
 *
 * FYT head units: the backlight is driven by the syu service (com.syu.ms), not by Android. The
 * launcher's own brightness popup (PopWindowBright) sends FinalMain.C_BRIGHT_LEVEL (0-100) to the
 * main module, and so does this class. Writing Settings.System.SCREEN_BRIGHTNESS there succeeds
 * (the fyt build runs as android.uid.system, so there is not even an exception to log) but the
 * screen does not change - which is why the previous implementation had no visible effect.
 *
 * Other devices: Settings.System.SCREEN_BRIGHTNESS, after switching adaptive brightness off,
 * because the stored value is not what the screen shows while adaptive brightness is on.
 */
public final class DayNightBrightness {

    private static final String TAG = "DayNightBrightness";

    /** Used for a value the user has never set; also what "reset night mode" restores. */
    public static final int DEFAULT_DAY = 255;
    public static final int DEFAULT_NIGHT = 0;

    /** Range of BrightnessSeekBarPreference, the same as Settings.System.SCREEN_BRIGHTNESS. */
    private static final int PREF_MAX = 255;
    /** Range of FinalMain.C_BRIGHT_LEVEL, the same as the seek bar of PopWindowBright. */
    private static final int FYT_MAX = 100;

    /** The syu service may not be bound yet, e.g. when the DayNightMode job started the process. */
    private static final int FYT_MAX_RETRIES = 10;
    private static final long FYT_RETRY_DELAY_MS = 1000;

    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    private DayNightBrightness() {
    }

    /** True when the night mode and its dynamic brightness are both switched on. */
    public static boolean isEnabled(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.NIGHT_MODE, false)
                && prefs.getBoolean(Keys.BRIGHTNESS_PREF, false);
    }

    /**
     * Day/night state as last worked out by SunTask. SunTask uses it for the wallpaper as well,
     * so the brightness always matches the wallpaper on the screen.
     */
    public static boolean isDayState(Helpers helpers) {
        // The car's lights, when the user chose them (HeadlightNightMode); otherwise the sun.
        Boolean byLights = HeadlightNightMode.dayByLights(
                PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp));
        if (byLights != null) {
            return byLights;
        }
        if (helpers.isPolarDay()) {
            return true;
        }
        if (helpers.isPerpetualNight()) {
            return false;
        }
        return helpers.isDay();
    }

    /** Applies the brightness for the day/night state stored by the last SunTask run. */
    public static void applyForCurrentState(Context context, String reason) {
        apply(context, isDayState(new Helpers()), reason);
    }

    /**
     * Day or night by the clock and the sunrise/sunset SunTask stored last (with the user's
     * corrections), without the network or a location fix. For the moment of a wake: SunTask only
     * runs ~14 s later (NightModeService is restarted 10 s after the wake, then waits 4 s), and a car
     * parked by day and started after dark kept the day brightness until then.
     */
    public static void applyForSavedTimes(Context context, String reason) {
        Context appContext = context.getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
        if (!isEnabled(prefs)) {
            return;
        }
        Boolean byLights = HeadlightNightMode.dayByLights(prefs);
        if (byLights != null) {
            apply(appContext, byLights, reason + ", lights");
            return;
        }
        Helpers helpers = new Helpers();
        if (helpers.isPolarDay() || helpers.isPerpetualNight()) {
            apply(appContext, helpers.isPolarDay(), reason);
            return;
        }
        LocalTime sunrise = parseTime(prefs.getString("sunrise", null));
        LocalTime sunset = parseTime(prefs.getString("sunset", null));
        if (sunrise == null || sunset == null) {
            applyForCurrentState(appContext, reason);
            return;
        }
        sunrise = sunrise.plusMinutes(prefs.getInt("sunrise_correction", 0));
        sunset = sunset.plusMinutes(prefs.getInt("sunset_correction", 0));
        LocalTime now = LocalTime.now();
        apply(appContext, !now.isBefore(sunrise) && now.isBefore(sunset), reason);
    }

    private static LocalTime parseTime(String value) {
        if (value == null) {
            return null;
        }
        try {
            return LocalTime.parse(value);   // "HH:mm:ss", as SunTask.longToHourZone() writes it
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Applies the day or the night brightness chosen in the settings. Does nothing when the night
     * mode or the dynamic brightness is off. Can be called from any thread.
     *
     * @param reason only for the log
     */
    public static void apply(Context context, boolean day, String reason) {
        final Context appContext = context.getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
        if (!isEnabled(prefs)) {
            Log.d(TAG, "Not applied (" + reason + "): night mode or dynamic brightness is off");
            return;
        }

        final int value = clamp(prefs.getInt(day ? Keys.DAY_SEEK_BAR : Keys.NIGHT_SEEK_BAR,
                day ? DEFAULT_DAY : DEFAULT_NIGHT), 0, PREF_MAX);
        final String state = day ? "day" : "night";

        if (LauncherApplication.isFytDevice()) {
            final int level = Math.round(value * (float) FYT_MAX / PREF_MAX);
            Log.i(TAG, "Applying " + state + " brightness " + value + "/" + PREF_MAX
                    + " as FYT level " + level + "/" + FYT_MAX + " (" + reason + ")");
            MAIN_HANDLER.post(() -> sendToFyt(appContext, level, 0));
        } else {
            Log.i(TAG, "Applying " + state + " brightness " + value + "/" + PREF_MAX + " (" + reason + ")");
            new Thread(() -> writeSystemBrightness(appContext, value), TAG).start();
        }
    }

    /** Runs on the main thread, like the command sent by PopWindowBright. */
    private static void sendToFyt(Context appContext, int level, int attempt) {
        RemoteTools tools = CarStates.getCar(appContext).getTools();
        if (tools == null || !tools.connected()) {
            if (attempt < FYT_MAX_RETRIES) {
                MAIN_HANDLER.postDelayed(() -> sendToFyt(appContext, level, attempt + 1), FYT_RETRY_DELAY_MS);
            } else {
                Log.w(TAG, "syu service not connected, FYT brightness level " + level + " not sent");
            }
            return;
        }
        tools.sendInt(0, FinalMain.C_BRIGHT_LEVEL, level);
    }

    private static void writeSystemBrightness(Context appContext, int value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(appContext)) {
            Log.w(TAG, "WRITE_SETTINGS not granted, brightness not changed");
            return;
        }
        ContentResolver resolver = appContext.getContentResolver();
        try {
            if (Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)
                    == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                Log.i(TAG, "Adaptive brightness switched off, it would override the dynamic brightness");
            }
            Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, value);
        } catch (SecurityException | IllegalArgumentException e) {
            Log.e(TAG, "Error setting brightness", e);
        }
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
