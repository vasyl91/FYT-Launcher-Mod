package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Looper;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.BarOrder;
import com.android.launcher66.BarOrderLayout;
import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDialog;

import java.util.Arrays;
import java.util.List;

/**
 * The row "Order of the bar's elements" and its dialog (the owner, 2026-11-20): the row names the elements in their
 * order, the dialog lists those the settings leave, a move and OK store the order of this orientation, and
 * "Default" puts the old order back (nothing stored).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class BarOrderDialogViewTest {

    private static String names(SettingsActivity activity, List<BarOrder.Element> order) {
        StringBuilder out = new StringBuilder();
        for (BarOrder.Element e : order) {
            if (out.length() > 0) {
                out.append(" · ");
            }
            out.append(activity.getString(BarOrderDialog.nameOf(e)));
        }
        return out.toString();
    }

    @Test
    public void aMoveAndOkStoreTheOrderAndDefaultPutsTheOldOneBack() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putBoolean(Keys.WIDGET_BAR_NO_WEATHER, true).remove(Keys.HORIZONTAL_BAR_ORDER_LAND).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, screen).commitNow();
        shadowOf(Looper.getMainLooper()).idle();

        Preference row = screen.findPreference(Keys.HORIZONTAL_BAR_ORDER);
        assertNotNull(row);
        // Landscape, the weather hidden: four elements, in the old order
        List<BarOrder.Element> shown = Arrays.asList(BarOrder.Element.DRAWER, BarOrder.Element.APPS,
                BarOrder.Element.MUSIC, BarOrder.Element.DATE);
        assertEquals(names(activity, shown), String.valueOf(row.getSummary()));

        row.performClick();
        shadowOf(Looper.getMainLooper()).idle();
        AlertDialog dialog = (AlertDialog) ShadowDialog.getLatestDialog();
        assertNotNull(dialog);
        RecyclerView list = dialog.findViewById(R.id.bar_order_list);
        BarOrderDialog.Adapter adapter = (BarOrderDialog.Adapter) list.getAdapter();
        assertEquals(shown, adapter.items());

        // The drawer button to the right end, then OK
        adapter.move(0, 3);
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        // The hidden weather keeps its place, the last of the five
        assertEquals("apps,music,date,drawer,weather", prefs.getString(Keys.HORIZONTAL_BAR_ORDER_LAND, null));
        assertEquals(names(activity, BarOrderLayout.shown(prefs, false)), String.valueOf(row.getSummary()));
        assertEquals(BarOrder.Element.DRAWER, BarOrderLayout.shown(prefs, false).get(3));

        // "Default" and OK: nothing stored, the old order
        row.performClick();
        shadowOf(Looper.getMainLooper()).idle();
        AlertDialog again = (AlertDialog) ShadowDialog.getLatestDialog();
        again.getButton(DialogInterface.BUTTON_NEUTRAL).performClick();
        assertEquals(shown, ((BarOrderDialog.Adapter) ((RecyclerView) again.findViewById(R.id.bar_order_list))
                .getAdapter()).items());
        again.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertFalse(prefs.contains(Keys.HORIZONTAL_BAR_ORDER_LAND));
        assertEquals(names(activity, shown), String.valueOf(row.getSummary()));

        controller.pause().stop().destroy();
    }

    @Test
    public void oneRowOpensTheListOfTheOrientationTheScreenIsInAlsoAfterATurn() {
        // The owner, 2026-11-20: one row, the list of the orientation the screen is in now
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putBoolean(Keys.WIDGET_BAR_NO_WEATHER, false).putBoolean(Keys.WIDGET_BAR_NO_DATE, false)
                .remove(Keys.HORIZONTAL_BAR_ORDER_LAND).remove(Keys.HORIZONTAL_BAR_ORDER_PORT).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        activity.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, screen).commitNow();
        shadowOf(Looper.getMainLooper()).idle();

        Preference row = screen.findPreference(Keys.HORIZONTAL_BAR_ORDER);
        row.performClick();
        shadowOf(Looper.getMainLooper()).idle();
        AlertDialog landscape = (AlertDialog) ShadowDialog.getLatestDialog();
        assertEquals("landscape: the five, the date among them", 5,
                ((RecyclerView) landscape.findViewById(R.id.bar_order_list)).getAdapter().getItemCount());

        // The screen turns with the dialog open: the settings are not created again (configChanges)
        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.configurationChange(RuntimeEnvironment.getApplication().getResources().getConfiguration());
        shadowOf(Looper.getMainLooper()).idle();
        AlertDialog portrait = (AlertDialog) ShadowDialog.getLatestDialog();
        assertFalse("the landscape list is gone", landscape.isShowing());
        assertEquals("portrait: four, no date", 4,
                ((RecyclerView) portrait.findViewById(R.id.bar_order_list)).getAdapter().getItemCount());
        assertEquals(names(activity, BarOrderLayout.shown(prefs, true)), String.valueOf(row.getSummary()));

        // OK stores the portrait order only
        ((BarOrderDialog.Adapter) ((RecyclerView) portrait.findViewById(R.id.bar_order_list)).getAdapter()).move(0, 3);
        portrait.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        assertNotNull(prefs.getString(Keys.HORIZONTAL_BAR_ORDER_PORT, null));
        assertFalse(prefs.contains(Keys.HORIZONTAL_BAR_ORDER_LAND));

        controller.pause().stop().destroy();
    }
}
