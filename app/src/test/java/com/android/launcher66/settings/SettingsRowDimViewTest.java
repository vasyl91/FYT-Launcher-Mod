package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

/**
 * A settings row that is off looks off (SettingsRowDim): on the badge screen with "Enable notification badges" off, the
 * rows below it, of androidx.preference's layouts and of their own, are drawn at 38 %; switched on, at full opacity
 * again. On the first screen the creator's row is dimmed with "Stock layout". The owner saw no difference on the A55
 * (2026-11-27).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class SettingsRowDimViewTest {

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    private static <T extends PreferenceFragmentCompat> T open(ActivityController<SettingsActivity> controller, T screen) {
        FragmentManager manager = controller.get().getSupportFragmentManager();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
        return screen;
    }

    /** The view of the row of this key, laid out on the list. */
    private static View row(PreferenceFragmentCompat screen, String key) {
        RecyclerView list = screen.getListView();
        int position = ((PreferenceGroup.PreferencePositionCallback) list.getAdapter())
                .getPreferenceAdapterPosition(key);
        assertTrue("the row " + key + " is on the list", position >= 0);
        list.scrollToPosition(position);
        list.measure(View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(2000, View.MeasureSpec.EXACTLY));
        list.layout(0, 0, 1080, 2000);
        ShadowLooper.idleMainLooper();
        RecyclerView.ViewHolder holder = list.findViewHolderForAdapterPosition(position);
        assertNotNull("the row " + key + " is shown", holder);
        return holder.itemView;
    }

    /** The opacity the row's content is drawn with. */
    private static float alpha(View row) {
        assertTrue(row instanceof ViewGroup && ((ViewGroup) row).getChildCount() > 0);
        ViewGroup group = (ViewGroup) row;
        float alpha = group.getChildAt(0).getAlpha();
        for (int i = 1; i < group.getChildCount(); i++) {
            assertEquals("every part of the row alike", alpha, group.getChildAt(i).getAlpha(), 0.001f);
        }
        return alpha * row.getAlpha();
    }

    private static final String[] BELOW = {Keys.BADGES_POSITION, Keys.BADGES_SIZE_PERCENT, Keys.BADGES_COLOR,
            Keys.BADGES_OUTLINE, Keys.BADGES_CORNER};

    @Test
    public void theRowsBelowTheBadgeSwitchAreDimmedWhileItIsOffAndFullWhenOn() {
        prefs().edit().clear().putBoolean(Keys.BADGES_ENABLED, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        NotificationBadgesFragment screen = open(controller, new NotificationBadgesFragment());
        for (String key : BELOW) {
            assertEquals(key + " is dimmed", SettingsRowDim.DIMMED, alpha(row(screen, key)), 0.001f);
        }
        assertEquals("the switch itself is not", 1f, alpha(row(screen, Keys.BADGES_ENABLED)), 0.001f);

        // The user turns the badges on: the rows are bound again and drawn full
        TwoStatePreference enabled = screen.findPreference(Keys.BADGES_ENABLED);
        enabled.performClick();
        ShadowLooper.idleMainLooper();
        for (String key : BELOW) {
            assertEquals(key + " is full again", 1f, alpha(row(screen, key)), 0.001f);
        }
        controller.pause().stop().destroy();
    }

    @Test
    public void theCreatorsRowIsDimmedWithTheStockLayout() {
        prefs().edit().clear().putBoolean(Keys.USER_LAYOUT, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) controller.get().getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
        ShadowLooper.idleMainLooper();
        assertEquals(SettingsRowDim.DIMMED, alpha(row(screen, Keys.CREATOR_FIRST)), 0.001f);
        controller.pause().stop().destroy();
    }

    @Test
    public void aCategorysTitleIsNeverDimmed() {
        prefs().edit().clear().putBoolean(Keys.BADGES_ENABLED, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        NotificationBadgesFragment screen = open(controller, new NotificationBadgesFragment());
        assertEquals("its rows are off", SettingsRowDim.DIMMED, alpha(row(screen, Keys.BADGES_POSITION)), 0.001f);
        assertEquals("the category's title is not", 1f, alpha(row(screen, "notification_badges_category")), 0.001f);
        controller.pause().stop().destroy();

        prefs().edit().clear().putBoolean(Keys.USER_LAYOUT, true).commit();
        controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond creator = open(controller, new SettingsFragmentSecond());
        assertEquals(1f, alpha(row(creator, "bars_category")), 0.001f);
        controller.pause().stop().destroy();
    }

    @Test
    public void theAlphaOfARow() {
        assertEquals(1f, SettingsRowDim.alpha(true), 0f);
        assertEquals(0.38f, SettingsRowDim.alpha(false), 0f);
    }
}
