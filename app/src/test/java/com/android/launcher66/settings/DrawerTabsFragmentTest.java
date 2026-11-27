package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.SharedPreferences;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.DrawerTabs;
import com.android.launcher66.DrawerTabsStore;
import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDialog;

import java.util.Arrays;
import java.util.Collections;

/**
 * The tab creator (F5): the list of the tabs, "+", the gear with its dialog, the bin with its question, the order and
 * the rows of "Miscellaneous". The views are made by the adapter as the list would, without a layout pass.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class DrawerTabsFragmentTest {

    private SharedPreferences prefs;
    private SettingsActivity activity;
    private DrawerTabsFragment screen;
    private RecyclerView list;

    @Before
    public void open() {
        prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).commit();
        activity = Robolectric.buildActivity(SettingsActivity.class).setup().get();
        screen = new DrawerTabsFragment();
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, screen).commitNow();
        shadowOf(Looper.getMainLooper()).idle();
        list = activity.findViewById(R.id.drawer_tabs_list);
        assertNotNull(list);
    }

    /** The view of the row at a position, made and bound as the list does. */
    private View row(int position) {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = list.getAdapter();
        RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(list, adapter.getItemViewType(position));
        adapter.onBindViewHolder(holder, position);
        return holder.itemView;
    }

    private static AlertDialog latestDialog() {
        shadowOf(Looper.getMainLooper()).idle();
        return (AlertDialog) ShadowDialog.getLatestDialog();
    }

    private DrawerTabs stored() {
        return DrawerTabsStore.load(prefs, null);
    }

    private void addTab(String name) {
        row(0).findViewById(R.id.drawer_tabs_add).performClick();
        AlertDialog dialog = latestDialog();
        ((TextView) dialog.findViewById(R.id.drawer_tab_name)).setText(name);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
    }

    @Test
    public void theMainTabIsAloneAtFirstWithAStarAndNoBin() {
        // the category, the main tab, "Miscellaneous", the rule and the placement
        assertEquals(5, list.getAdapter().getItemCount());
        View main = row(1);
        assertEquals("Apps", ((TextView) main.findViewById(R.id.tab_name)).getText().toString());
        assertEquals(View.VISIBLE, main.findViewById(R.id.tab_handle_star).getVisibility());
        assertEquals(View.GONE, main.findViewById(R.id.tab_handle_icon).getVisibility());
        assertEquals(View.INVISIBLE, main.findViewById(R.id.tab_delete).getVisibility());
        assertEquals(View.VISIBLE, row(0).findViewById(R.id.drawer_tabs_add).getVisibility());
        assertEquals(View.GONE, row(2).findViewById(R.id.drawer_tabs_add).getVisibility());
    }

    @Test
    public void thePlusAddsATabWithTheNameAndABlankNameAddsNone() {
        addTab("   ");
        assertEquals(1, stored().count());
        addTab("Tools");
        assertEquals(6, list.getAdapter().getItemCount());
        assertEquals(2, stored().count());
        int id = stored().ids().get(1);
        assertEquals("Tools", stored().nameOf(id, "Apps", "Tab%1$d"));
        View tab = row(2);
        assertEquals("Tools", ((TextView) tab.findViewById(R.id.tab_name)).getText().toString());
        assertEquals(View.VISIBLE, tab.findViewById(R.id.tab_delete).getVisibility());
        assertEquals(View.VISIBLE, tab.findViewById(R.id.tab_handle_icon).getVisibility());
    }

    @Test
    public void theGearRenamesATabAndABlankNameChangesNothing() {
        addTab("Tools");
        row(2).findViewById(R.id.tab_edit).performClick();
        AlertDialog dialog = latestDialog();
        TextView name = dialog.findViewById(R.id.drawer_tab_name);
        assertEquals("Tools", name.getText().toString());
        assertEquals("the dialog is for a tab, so it offers its apps", "Select apps",
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).getText().toString());
        name.setText("Work");
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        int id = stored().ids().get(1);
        assertEquals("Work", stored().nameOf(id, "Apps", "Tab%1$d"));

        row(2).findViewById(R.id.tab_edit).performClick();
        dialog = latestDialog();
        ((TextView) dialog.findViewById(R.id.drawer_tab_name)).setText("  ");
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertEquals("Work", stored().nameOf(id, "Apps", "Tab%1$d"));
    }

    @Test
    public void theGearOfTheMainTabOffersHideAppsAndNoFlag() {
        row(1).findViewById(R.id.tab_edit).performClick();
        AlertDialog dialog = latestDialog();
        assertEquals("Hide apps", dialog.getButton(AlertDialog.BUTTON_NEUTRAL).getText().toString());
        assertEquals(View.GONE, dialog.findViewById(R.id.drawer_tab_keep_row).getVisibility());
    }

    @Test
    public void aNameLongerThanFiftyCharactersIsCutInTheField() {
        row(0).findViewById(R.id.drawer_tabs_add).performClick();
        AlertDialog dialog = latestDialog();
        StringBuilder pasted = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            pasted.append('y');
        }
        TextView name = dialog.findViewById(R.id.drawer_tab_name);
        name.setText(pasted);
        assertEquals(DrawerTabs.MAX_NAME, name.getText().length());
    }

    @Test
    public void theFlagIsAChoiceOfTheRowAndItsCheckboxAndStoredWithOk() {
        row(3).performClick();   // the rule: "except the main tab", where the flag decides (with "all" it is off)
        row(0).findViewById(R.id.drawer_tabs_add).performClick();
        AlertDialog dialog = latestDialog();
        ((TextView) dialog.findViewById(R.id.drawer_tab_name)).setText("Tools");
        dialog.findViewById(R.id.drawer_tab_keep_row).performClick();   // a tap on the row, not on the box
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertTrue(stored().keepInMain(stored().ids().get(1)));
    }

    @Test
    public void theBinAsksFirstAndCancelKeepsTheTab() {
        addTab("Tools");
        row(2).findViewById(R.id.tab_delete).performClick();
        AlertDialog dialog = latestDialog();
        assertTrue(((TextView) dialog.findViewById(android.R.id.message)).getText().toString().contains("Tools"));
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertEquals(2, stored().count());
    }

    @Test
    public void theBinDeletesTheTabAndItsAppsGoBackToTheMainTab() {
        addTab("Tools");
        DrawerTabs model = stored();
        int id = model.ids().get(1);
        model.setPackages(id, Arrays.asList("a"));
        // with "all" every app is in the main tab anyway; with "except the main tab" a tab's apps leave it
        model.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);
        DrawerTabsStore.save(prefs, model);
        // the screen reads the model again when it is made, so a new screen shows it
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new DrawerTabsFragment()).commitNow();
        shadowOf(Looper.getMainLooper()).idle();
        list = activity.findViewById(R.id.drawer_tabs_list);
        assertEquals(Collections.<String>emptyList(), stored().appsOf(DrawerTabs.MAIN, Arrays.asList("a")));

        row(2).findViewById(R.id.tab_delete).performClick();
        AlertDialog dialog = latestDialog();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertEquals(1, stored().count());
        assertEquals(Arrays.asList("a"), stored().appsOf(DrawerTabs.MAIN, Arrays.asList("a")));
    }

    @Test
    public void aDragMovesATabAndTheMainTabStaysFirst() {
        addTab("One");
        addTab("Two");
        addTab("Three");
        java.util.List<Integer> ids = screen.tabIds();
        assertEquals(4, ids.size());
        // the third tab (position 4 in the list) is dragged over the second one (position 3)
        assertTrue(screen.moveTab(4, 3));
        assertEquals(Arrays.asList(ids.get(0), ids.get(1), ids.get(3), ids.get(2)), screen.tabIds());
        // nothing is dragged over the main tab (position 1), and it is not moved itself
        assertFalse(screen.moveTab(3, 1));
        assertFalse(screen.moveTab(1, 3));
        assertEquals(DrawerTabs.MAIN, (int) screen.tabIds().get(0));
    }

    @Test
    public void theRuleStepsThroughTheThreeChoicesAndIsStored() {
        View rule = row(3);
        assertEquals("Allow in all tabs", ((TextView) rule.findViewById(R.id.setting_summary)).getText().toString());
        rule.performClick();
        assertEquals(DrawerTabs.Repeat.EXCEPT_MAIN, stored().repeat());
        row(3).performClick();
        assertEquals(DrawerTabs.Repeat.NONE, stored().repeat());
        assertEquals("Do not allow", ((TextView) row(3).findViewById(R.id.setting_summary)).getText().toString());
        row(3).performClick();
        assertEquals(DrawerTabs.Repeat.ALL, stored().repeat());
    }

    @Test
    public void theRuleNamesTheTabsThatKeepTheirAppsInTheMainTabWhereTheFlagApplies() {
        addTab("Tools");
        addTab("Games");
        DrawerTabs model = stored();
        model.setKeepInMain(model.ids().get(1), true);
        DrawerTabsStore.save(prefs, model);
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new DrawerTabsFragment()).commitNow();
        shadowOf(Looper.getMainLooper()).idle();
        list = activity.findViewById(R.id.drawer_tabs_list);
        // the rows: the category, the main tab, "Tools", "Games", "Miscellaneous", the rule
        // "all": every app is in the main tab, the flag does nothing, so no tab is named (the owner, 2026-11-27)
        assertEquals("Allow in all tabs", summary(5));
        row(5).performClick();
        assertEquals("Allow in all tabs except the main tab.\n“Tools” still keeps its apps in the main tab.", summary(5));
        row(5).performClick();
        assertEquals("Do not allow, except for “Tools”.", summary(5));

        model = stored();
        model.setKeepInMain(model.ids().get(2), true);
        model.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);
        DrawerTabsStore.save(prefs, model);
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new DrawerTabsFragment()).commitNow();
        shadowOf(Looper.getMainLooper()).idle();
        list = activity.findViewById(R.id.drawer_tabs_list);
        assertEquals("Allow in all tabs except the main tab.\n“Tools” and “Games” still keep their apps in the main tab.",
                summary(5));
    }

    private String summary(int row) {
        return ((TextView) row(row).findViewById(R.id.setting_summary)).getText().toString();
    }

    @Test
    public void theFlagIsDimmedInTheDialogWhereTheRuleMakesItDoNothing() {
        addTab("Tools");
        // "all", the first rule: every app is in the main tab anyway
        row(2).findViewById(R.id.tab_edit).performClick();
        AlertDialog dialog = latestDialog();
        assertEquals(View.VISIBLE, dialog.findViewById(R.id.drawer_tab_keep_note).getVisibility());
        assertFalse(dialog.findViewById(R.id.drawer_tab_keep_check).isEnabled());
        dialog.dismiss();
        shadowOf(Looper.getMainLooper()).idle();
        row(4).performClick();   // the rule: "except the main tab", where the flag decides
        row(2).findViewById(R.id.tab_edit).performClick();
        dialog = latestDialog();
        assertTrue(dialog.findViewById(R.id.drawer_tab_keep_check).isEnabled());
    }

    @Test
    public void theTabBarIsAtTheTopAtFirstAndATapPutsItAtTheBottomAndBack() {
        View placement = row(4);
        assertEquals("Top", ((TextView) placement.findViewById(R.id.setting_summary)).getText().toString());
        placement.performClick();
        assertEquals("bottom", prefs.getString(Keys.DRAWER_TAB_BAR_POSITION, "top"));
        assertEquals("Bottom", ((TextView) row(4).findViewById(R.id.setting_summary)).getText().toString());
        row(4).performClick();
        assertEquals("top", prefs.getString(Keys.DRAWER_TAB_BAR_POSITION, "top"));
    }
}
