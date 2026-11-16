package com.android.launcher66;

/**
 * How the launcher asks a widget's app to send the widget again after its content could not be shown.
 *
 * <p>The content most often fails because it shows an image from the app's own content provider that the app
 * has not let the launcher read since the launcher's new install; the app grants it again when it updates the
 * widget. The rule, per widget view, at most {@link #ATTEMPTS} times a moment apart:
 * <ul>
 * <li>a system launcher sends the system's update broadcast (APPWIDGET_UPDATE) for the widget itself;</li>
 * <li>a launcher with a privileged host that may send protected broadcasts (the root module, Shizuku with
 * root) has the host send it;</li>
 * <li>otherwise (Shizuku through ADB, no host) only the host's way of asking is left: the widget's options
 * change, which most apps answer by drawing it again.</li>
 * </ul>
 * The options change is made in every case, so an app that answers only that is reached too. Meanwhile the
 * widget shows its preview (LauncherAppWidgetHostView.getErrorView()). Pure Java, so that it has a test.
 */
final class WidgetRecovery {

    /** How many times a widget view asks. */
    static final int ATTEMPTS = 2;

    enum Way { SELF, HOST, OPTIONS_ONLY, NONE }

    private WidgetRecovery() {
    }

    /**
     * @param attemptsMade     how many times this widget view asked already
     * @param systemApp        the launcher runs as the system
     * @param hostMayBroadcast a privileged host that may send protected broadcasts is attached
     */
    static Way way(int attemptsMade, boolean systemApp, boolean hostMayBroadcast) {
        if (attemptsMade >= ATTEMPTS) {
            return Way.NONE;
        }
        if (systemApp) {
            return Way.SELF;
        }
        return hostMayBroadcast ? Way.HOST : Way.OPTIONS_ONLY;
    }
}
