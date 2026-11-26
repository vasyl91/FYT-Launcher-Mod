package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.settings.DrawerAppsFragment;
import com.android.launcher66.settings.DrawerTabsFragment;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.SettingsActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * "Select apps" and "Hide apps" (F4): the rows hold a name and a checkbox, a tap on the row ticks it and stores it, the
 * title is the tab's name, and Back goes to the tab creator, or closes the settings when the drawer opened the list.
 * It is in this package because {@code AppInfo} is made here.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class DrawerAppsFragmentTest {

    private SharedPreferences prefs;

    private static AppInfo app(String title, String pkg) {
        AppInfo info = new AppInfo();
        info.title = title;
        info.intent = new Intent().setComponent(new ComponentName(pkg, pkg + ".Main"));
        return info;
    }

    @Before
    public void apps() {
        prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).commit();
        AllAppsList.data = new ArrayList<>(Arrays.asList(app("Maps", "p.maps"), app("Camera", "p.camera"),
                app("Radio", "p.radio")));
    }

    @After
    public void forget() {
        AllAppsList.data = new ArrayList<>();
    }

    private SettingsActivity open(int tab, boolean fromDrawer) {
        SettingsActivity activity = Robolectric.buildActivity(SettingsActivity.class).setup().get();
        activity.getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, DrawerAppsFragment.newInstance(tab, fromDrawer)).commitNow();
        shadowOf(Looper.getMainLooper()).idle();
        return activity;
    }

    private static View row(SettingsActivity activity, int position) {
        RecyclerView list = activity.findViewById(R.id.drawer_apps_list);
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = list.getAdapter();
        RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(list, adapter.getItemViewType(position));
        adapter.onBindViewHolder(holder, position);
        return holder.itemView;
    }

    private static String name(View row) {
        return ((TextView) row.findViewById(R.id.drawer_app_name)).getText().toString();
    }

    private static boolean ticked(View row) {
        return ((CheckBox) row.findViewById(R.id.drawer_app_check)).isChecked();
    }

    private int newTab(String name) {
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        int id = model.add(name, false);
        DrawerTabsStore.save(prefs, model);
        return id;
    }

    @Test
    public void theTitleIsTheTabsNameAndTheRowsAreTheAppsInTheDrawersOrder() {
        int tab = newTab("Tools");
        SettingsActivity activity = open(tab, false);
        assertEquals("Tools", ((TextView) activity.findViewById(R.id.drawer_apps_title)).getText().toString());
        RecyclerView list = activity.findViewById(R.id.drawer_apps_list);
        assertEquals(3, list.getAdapter().getItemCount());
        assertEquals("Camera", name(row(activity, 0)));
        assertEquals("Maps", name(row(activity, 1)));
        assertEquals("Radio", name(row(activity, 2)));
        assertFalse(ticked(row(activity, 0)));
    }

    @Test
    public void aTapOnTheRowTicksTheAppAndStoresItInTheTab() {
        int tab = newTab("Tools");
        SettingsActivity activity = open(tab, false);
        row(activity, 1).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertEquals(Collections.singleton("p.maps"), DrawerTabsStore.load(prefs, null).packagesOf(tab));
        row(activity, 1).performClick();
        assertTrue(DrawerTabsStore.load(prefs, null).packagesOf(tab).isEmpty());
    }

    @Test
    public void theListOfTheHiddenAppsIsTitledHideAppsAndATickHidesTheAppAndKeepsItOnTheList() {
        SettingsActivity activity = open(DrawerAppList.HIDDEN, false);
        assertEquals("Hide apps", ((TextView) activity.findViewById(R.id.drawer_apps_title)).getText().toString());
        RecyclerView list = activity.findViewById(R.id.drawer_apps_list);
        row(activity, 0).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertTrue(DrawerTabsStore.load(prefs, null).isHidden("p.camera"));
        assertEquals(3, list.getAdapter().getItemCount());
        assertTrue(ticked(row(activity, 0)));
    }

    @Test
    public void theMenuButtonOpensTheWindowWithoutAFailure() {
        SettingsActivity activity = open(DrawerAppList.HIDDEN, false);
        activity.findViewById(R.id.drawer_apps_more).performClick();
        shadowOf(Looper.getMainLooper()).idle();
    }

    @Test
    public void backClosesTheSettingsWhenTheDrawerOpenedTheList() {
        SettingsActivity activity = open(DrawerAppList.HIDDEN, true);
        activity.getOnBackPressedDispatcher().onBackPressed();
        shadowOf(Looper.getMainLooper()).idle();
        assertTrue(activity.isFinishing());
    }

    @Test
    public void backGoesToTheTabCreatorWhenItOpenedTheList() {
        SettingsActivity activity = open(DrawerAppList.HIDDEN, false);
        activity.getOnBackPressedDispatcher().onBackPressed();
        shadowOf(Looper.getMainLooper()).idle();
        Fragment shown = activity.getSupportFragmentManager().findFragmentById(android.R.id.content);
        assertTrue(shown instanceof DrawerTabsFragment);
        assertFalse(activity.isFinishing());
    }

    @Test
    public void theSettingsOpenedByTheDrawerStartOnTheList() {
        int tab = newTab("Tools");
        Intent intent = DrawerAppsFragment.intent(RuntimeEnvironment.getApplication(), tab);
        SettingsActivity activity = Robolectric.buildActivity(SettingsActivity.class, intent).setup().get();
        shadowOf(Looper.getMainLooper()).idle();
        Fragment shown = activity.getSupportFragmentManager().findFragmentById(android.R.id.content);
        assertTrue(shown instanceof DrawerAppsFragment);
        assertEquals("Tools", ((TextView) activity.findViewById(R.id.drawer_apps_title)).getText().toString());
    }
}
