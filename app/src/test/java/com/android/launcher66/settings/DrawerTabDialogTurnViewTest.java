package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.SharedPreferences;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.DrawerTabs;
import com.android.launcher66.DrawerTabsStore;
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
 * The tab creator's dialogs over a turn of the screen (SettingsDialogMemory, the owner's rule of 2026-11-21): "Add drawer
 * tab" and "Edit drawer tab" are open again on the new screen, with the name typed and the flag as it was.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class DrawerTabDialogTurnViewTest {

    @After
    public void forget() {
        SettingsDialogMemory.forget();
    }

    private static void idle() {
        shadowOf(Looper.getMainLooper()).idle();
    }

    private static View row(ActivityController<SettingsActivity> controller, int position) {
        RecyclerView list = controller.get().findViewById(R.id.drawer_tabs_list);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = list.getAdapter();
        RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(list, adapter.getItemViewType(position));
        adapter.onBindViewHolder(holder, position);
        return holder.itemView;
    }

    private static ActivityController<SettingsActivity> open(SharedPreferences prefs) {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new DrawerTabsFragment()).commitNow();
        idle();
        return controller;
    }

    @Test
    public void theAddDialogComesBackWithTheNameTypedAndTheFlag() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        model.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);   // where the flag decides
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).commit();
        DrawerTabsStore.save(prefs, model);
        ActivityController<SettingsActivity> controller = open(prefs);

        row(controller, 0).findViewById(R.id.drawer_tabs_add).performClick();
        idle();
        AlertDialog before = (AlertDialog) ShadowDialog.getLatestDialog();
        ((TextView) before.findViewById(R.id.drawer_tab_name)).setText("Navigation");
        before.findViewById(R.id.drawer_tab_keep_row).performClick();

        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();

        AlertDialog after = (AlertDialog) ShadowDialog.getLatestDialog();
        assertNotSame(before, after);
        assertFalse("the old screen's dialog went with it", before.isShowing());
        assertTrue("open again", after.isShowing());
        assertEquals("Navigation", ((TextView) after.findViewById(R.id.drawer_tab_name)).getText().toString());
        assertTrue("the flag as it was", ((CheckBox) after.findViewById(R.id.drawer_tab_keep_check)).isChecked());
        // and OK adds the tab as from the first dialog
        after.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        idle();
        DrawerTabs stored = DrawerTabsStore.load(prefs, null);
        assertEquals(2, stored.count());
        assertTrue(stored.keepInMain(stored.ids().get(1)));
        controller.pause().stop().destroy();
    }

    @Test
    public void theEditDialogComesBackForItsTab() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).commit();
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        model.add("Tools", false);
        DrawerTabsStore.save(prefs, model);
        ActivityController<SettingsActivity> controller = open(prefs);

        row(controller, 2).findViewById(R.id.tab_edit).performClick();
        idle();
        AlertDialog before = (AlertDialog) ShadowDialog.getLatestDialog();
        ((TextView) before.findViewById(R.id.drawer_tab_name)).setText("Tools and maps");

        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();

        AlertDialog after = (AlertDialog) ShadowDialog.getLatestDialog();
        assertNotSame(before, after);
        assertTrue(after.isShowing());
        assertEquals("Tools and maps", ((TextView) after.findViewById(R.id.drawer_tab_name)).getText().toString());
        after.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        idle();
        DrawerTabs stored = DrawerTabsStore.load(prefs, null);
        assertEquals("Tools and maps", stored.nameOf(stored.ids().get(1), "Apps", "Tab%1$d"));
        controller.pause().stop().destroy();
    }
}
