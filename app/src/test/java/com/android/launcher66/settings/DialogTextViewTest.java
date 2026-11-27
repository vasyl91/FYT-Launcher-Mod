package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
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
 * A dialog's text is as large as a settings row's title (DialogText): the owner found it too small, 2026-11-27. It follows
 * "Settings text size" as the rows do.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class DialogTextViewTest {

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    /** The text size of the title of the settings' first row that has one. */
    private static float rowTitlePx(ActivityController<SettingsActivity> controller) {
        FragmentManager manager = controller.get().getSupportFragmentManager();
        SettingsFragmentFirst screen = new SettingsFragmentFirst();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
        RecyclerView list = screen.getListView();
        list.measure(View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(2000, View.MeasureSpec.EXACTLY));
        list.layout(0, 0, 1080, 2000);
        ShadowLooper.idleMainLooper();
        int position = ((PreferenceGroup.PreferencePositionCallback) list.getAdapter())
                .getPreferenceAdapterPosition(Keys.USER_LAYOUT);
        RecyclerView.ViewHolder holder = list.findViewHolderForAdapterPosition(position);
        assertNotNull(holder);
        TextView title = holder.itemView.findViewById(android.R.id.title);
        assertNotNull(title);
        return title.getTextSize();
    }

    @Test
    public void aDialogsTextIsAsLargeAsARowsTitle() {
        prefs().edit().clear().commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        float row = rowTitlePx(controller);
        TextView text = new TextView(controller.get());
        DialogText.body(text);
        assertEquals(row, text.getTextSize(), 0.5f);
        TextView title = new TextView(controller.get());
        DialogText.title(title);
        assertEquals(row * DialogText.TITLE_FACTOR, title.getTextSize(), 0.5f);
        controller.pause().stop().destroy();
    }

    @Test
    public void itFollowsTheSettingsTextSize() {
        prefs().edit().clear().commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        float usual = DialogText.bodyPx(controller.get());
        controller.pause().stop().destroy();
        prefs().edit().putInt(SettingsTextScale.KEY, 150).commit();
        controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        float larger = DialogText.bodyPx(controller.get());
        assertTrue("larger at 150 %: " + usual + " -> " + larger, larger > usual * 1.4f);
        controller.pause().stop().destroy();
    }
}
