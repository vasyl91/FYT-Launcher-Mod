package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.Context;
import android.os.Looper;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.List;

/**
 * "Start on wake" is a list of its own under "Start on boot" (the owner, 2026-11-22): its row opens the app list for
 * the wake, a tick there is stored under the wake list's key, and the boot list stays as it was, also after a turn.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class WakeAutostartRowViewTest {

    private static final String APP = "com.example.wake";

    private static void idle() {
        shadowOf(Looper.getMainLooper()).idle();
    }

    private static AppListAutostartDialogFragment list(ActivityController<SettingsActivity> controller) {
        Fragment f = controller.get().getSupportFragmentManager().findFragmentByTag(AppListAutostartDialogFragment.TAG);
        return (AppListAutostartDialogFragment) f;
    }

    @Test
    public void theWakeRowOpensTheWakeListAndATickStaysOutOfTheBootList() {
        Context app = RuntimeEnvironment.getApplication();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) controller.get().getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
        List<String> bootBefore = AppListAutostartDialogFragment.getSelectedPackages(app);

        Preference row = screen.findPreference(Keys.WAKE_AUTOSTART_APPS);
        assertNotNull(row);
        row.performClick();
        idle();

        AppListAutostartDialogFragment dialog = list(controller);
        assertNotNull("the list is open", dialog);
        assertEquals(AppListAutostartDialogFragment.KEY_WAKE_AUTOSTART_APPS, dialog.listKey());
        TextView title = dialog.requireView().findViewById(R.id.bootlist_title);
        assertEquals(app.getString(R.string.wake_autostart_apps), title.getText().toString());

        dialog.toggleSelection(APP);
        assertTrue("stored under the wake list",
                AppListAutostartDialogFragment.getSelectedPackages(app,
                        AppListAutostartDialogFragment.KEY_WAKE_AUTOSTART_APPS).contains(APP));
        assertEquals("the boot list stays", bootBefore, AppListAutostartDialogFragment.getSelectedPackages(app));

        // A turn of the screen on a phone: the FragmentManager brings the dialog back with its argument
        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();
        AppListAutostartDialogFragment again = list(controller);
        assertNotNull("the list comes back by itself", again);
        assertEquals(AppListAutostartDialogFragment.KEY_WAKE_AUTOSTART_APPS, again.listKey());

        controller.pause().stop().destroy();
    }

    @Test
    public void theBootRowStillOpensTheBootList() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) controller.get().getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
        screen.findPreference(Keys.AUTOSTART_APPS).performClick();
        idle();

        AppListAutostartDialogFragment dialog = list(controller);
        assertNotNull(dialog);
        assertEquals(AppListAutostartDialogFragment.KEY_AUTOSTART_APPS, dialog.listKey());
        TextView title = dialog.requireView().findViewById(R.id.bootlist_title);
        assertEquals(RuntimeEnvironment.getApplication().getString(R.string.autostart_apps),
                title.getText().toString());

        controller.pause().stop().destroy();
    }
}
