package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.app.Dialog;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDialog;

/**
 * Work started in the settings goes on through a turn of the screen, and the new screen shows its dialog with the
 * last progress and gets its end (the owner, 2026-11-21; HandedWork). On a phone a turn creates the settings again
 * (recreate()), as {@code controller.recreate()} does here. The download and the import are driven by their own
 * callbacks, as the network and the file would drive them.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class SettingsWorkTurnViewTest {

    @After
    public void forget() {
        SettingsFragmentFirst.DOWNLOAD.end();
        SettingsFragmentSecond.IMPORT.end();
        SettingsDialogMemory.forget();
    }

    private static Fragment shown(ActivityController<SettingsActivity> controller) {
        return controller.get().getSupportFragmentManager().findFragmentById(android.R.id.content);
    }

    private static void idle() {
        shadowOf(Looper.getMainLooper()).idle();
    }

    @Test
    public void aDownloadGoesOnThroughATurnWithItsProgressDialog() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) shown(controller);
        VersionChecker download = new VersionChecker();
        SettingsFragmentFirst.DOWNLOAD.start(download, "9.9.9", screen);
        SettingsFragmentFirst.DownloadToScreen callbacks = new SettingsFragmentFirst.DownloadToScreen(download);
        callbacks.onDownloadStarted("system_release_9.9.9.apk");
        callbacks.onDownloadProgress(30);
        idle();
        Dialog before = ShadowDialog.getLatestDialog();
        assertTrue(before.isShowing());

        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();

        SettingsFragmentFirst again = (SettingsFragmentFirst) shown(controller);
        assertNotSame(screen, again);
        assertTrue("the turn does not stop the download", SettingsFragmentFirst.DOWNLOAD.running());
        assertSame(again, SettingsFragmentFirst.DOWNLOAD.screen());
        Dialog after = ShadowDialog.getLatestDialog();
        assertNotSame(before, after);
        assertFalse(before.isShowing());
        assertTrue("its dialog again", after.isShowing());
        ProgressBar bar = after.findViewById(R.id.progress_dialog_bar);
        assertEquals("with the percent reached", 30, bar.getProgress());

        callbacks.onDownloadProgress(55);
        idle();
        assertEquals("the progress goes to the new screen", 55, bar.getProgress());
        callbacks.onDownloadComplete();
        idle();
        assertFalse(after.isShowing());
        assertFalse(SettingsFragmentFirst.DOWNLOAD.running());

        controller.pause().stop().destroy();
    }

    @Test
    public void aDownloadIsCancelledWhenItsScreenIsLeftForGood() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) shown(controller);
        VersionChecker download = new VersionChecker();
        SettingsFragmentFirst.DOWNLOAD.start(download, "9.9.9", screen);

        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentSecond()).commitNow();
        idle();
        assertFalse("as before: leaving the screen cancels it", SettingsFragmentFirst.DOWNLOAD.running());

        controller.pause().stop().destroy();
    }

    private ActivityController<SettingsActivity> secondScreen() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentSecond()).commitNow();
        idle();
        return controller;
    }

    @Test
    public void anImportGoesOnThroughATurnWithItsDialogAndItsEndComesToTheNewScreen() {
        ActivityController<SettingsActivity> controller = secondScreen();
        SettingsFragmentSecond screen = (SettingsFragmentSecond) shown(controller);
        SettingsFragmentSecond.IMPORT.start(new CanbusLibraryImport.Job(), null, screen);
        SettingsFragmentSecond.IMPORT_TO_SCREEN.onProgress(CanbusLibraryImport.PHASE_VALIDATE, 40, 10, 25);
        // A phase without a percent keeps the bar where it was
        SettingsFragmentSecond.IMPORT_TO_SCREEN.onProgress(CanbusLibraryImport.PHASE_VALIDATE, -1, 12, 25);

        controller.recreate();
        idle();

        SettingsFragmentSecond again = (SettingsFragmentSecond) shown(controller);
        assertNotSame(screen, again);
        Dialog dialog = ShadowDialog.getLatestDialog();
        assertTrue("its dialog again", dialog.isShowing());
        ProgressBar bar = dialog.findViewById(R.id.canbus_library_import_progress);
        assertEquals(40, bar.getProgress());
        TextView status = dialog.findViewById(R.id.canbus_library_import_status);
        assertEquals(again.getString(R.string.canbus_library_phase_validate, 12, 25), status.getText().toString());
        Preference importRow = again.findPreference(Keys.CANBUS_LIBRARY_IMPORT);
        if (importRow != null) {
            assertFalse("no second import while one runs", importRow.isEnabled());
        }

        CanbusLibraryImport.Outcome outcome = new CanbusLibraryImport.Outcome();
        outcome.kind = CanbusLibraryImport.Kind.SUCCESS;
        outcome.added = 3;
        SettingsFragmentSecond.IMPORT_TO_SCREEN.onFinished(outcome);
        idle();

        assertFalse(dialog.isShowing());
        Dialog done = ShadowDialog.getLatestDialog();
        assertNotSame("the result on the new screen", dialog, done);
        assertTrue(done.isShowing());
        assertFalse(SettingsFragmentSecond.IMPORT.running());

        controller.pause().stop().destroy();
    }

    @Test
    public void anImportSentToTheBackgroundShowsNoDialogAfterATurn() {
        ActivityController<SettingsActivity> controller = secondScreen();
        SettingsFragmentSecond screen = (SettingsFragmentSecond) shown(controller);
        SettingsFragmentSecond.IMPORT.start(new CanbusLibraryImport.Job(), null, screen);
        SettingsFragmentSecond.IMPORT.toBackground();
        Dialog before = ShadowDialog.getLatestDialog();

        controller.recreate();
        idle();

        assertSame("no dialog opened by the new screen", before, ShadowDialog.getLatestDialog());
        assertSame(shown(controller), SettingsFragmentSecond.IMPORT.screen());
        controller.pause().stop().destroy();
    }

    @Test
    public void anImportGoesToTheBackgroundWhenItsScreenIsLeftForGood() {
        ActivityController<SettingsActivity> controller = secondScreen();
        SettingsFragmentSecond screen = (SettingsFragmentSecond) shown(controller);
        SettingsFragmentSecond.IMPORT.start(new CanbusLibraryImport.Job(), null, screen);

        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentFirst()).commitNow();
        idle();
        assertTrue(SettingsFragmentSecond.IMPORT.running());
        assertTrue("its result comes as a toast", SettingsFragmentSecond.IMPORT.inBackground());

        controller.pause().stop().destroy();
    }
}
