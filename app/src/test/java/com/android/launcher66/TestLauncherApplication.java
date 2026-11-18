package com.android.launcher66;

/**
 * The launcher's application for the tests of views that need it (SettingsActivity reads it). Robolectric ends
 * every test with onTerminate(), which in the app asks for LauncherAppState; the tests never set that up, so
 * here it is not asked for.
 */
public class TestLauncherApplication extends LauncherApplication {

    @Override
    public void onTerminate() {
        // LauncherAppState was never made in a test
    }
}
