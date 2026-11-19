package com.android.launcher66;

/**
 * How the launcher opens a widget's configuration screen when the widget is added, and what it does when that
 * cannot be opened.
 *
 * <p><b>Rule.</b> The configuration is started by the system for the launcher as the widget's host
 * (AppWidgetHost.startAppWidgetConfigureActivityForResult()), never with an intent of the launcher's own: the
 * screen may be one its app does not export, which the system opens only for the host it belongs to (the Google
 * app's Stocks widget: "Permission Denial", and the old message "App isn't installed", the owner, 2026-11-19).
 * The system hands the launcher a pending intent; from Android 14 the launcher, in front, lets it open the screen
 * ({@link #backgroundStartMode}). If the screen still cannot be opened, a widget whose configuration is optional is
 * added without it; any other one is not added, its id is freed and the user is told why ({@link #onFailure}).
 *
 * <p>Plain Java, tested on the JVM.
 */
public final class WidgetConfigure {

    /** No option is needed before Android 14. */
    public static final int NO_MODE = Integer.MIN_VALUE;
    /** ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED (Android 14 and 15; deprecated in 16). */
    public static final int MODE_ALLOWED = 1;
    /** ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOW_IF_VISIBLE (Android 16 and later). */
    public static final int MODE_ALLOW_IF_VISIBLE = 4;

    public enum Failure { ADD_WITHOUT_IT, CANCEL }

    private WidgetConfigure() {
    }

    /** The background start mode to pass with the configuration's pending intent, or {@link #NO_MODE}. */
    public static int backgroundStartMode(int sdk) {
        if (sdk >= 36) {
            return MODE_ALLOW_IF_VISIBLE;
        }
        if (sdk >= 34) {
            return MODE_ALLOWED;
        }
        return NO_MODE;
    }

    /** What the launcher does when the configuration could not be opened. */
    public static Failure onFailure(boolean configurationOptional) {
        return configurationOptional ? Failure.ADD_WITHOUT_IT : Failure.CANCEL;
    }
}
