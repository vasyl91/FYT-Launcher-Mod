package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
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

import java.util.ArrayList;
import java.util.List;

/**
 * "Settings text size" (SettingsTextScale) at 150 per cent: the settings' font scale is half as large again, the title row
 * shows the value, the creator's screens get a context without it, and no text of the rows of either screen is cut:
 * every title and summary wraps without a limit.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class SettingsTextScaleViewTest {

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    private static void layOut(RecyclerView list, int height) {
        list.measure(View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        list.layout(0, 0, 1080, height);
        ShadowLooper.idleMainLooper();
    }

    private static void texts(View view, List<TextView> found) {
        if (view instanceof TextView && view.getVisibility() == View.VISIBLE) {
            found.add((TextView) view);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                texts(((ViewGroup) view).getChildAt(i), found);
            }
        }
    }

    /** The texts of the rows of a list that are cut (ellipsized), with their words, for the message. */
    private static List<String> cut(PreferenceFragmentCompat screen) {
        RecyclerView list = screen.getListView();
        // tall enough for every row at once: each one is bound and laid out
        layOut(list, 40000);
        List<TextView> found = new ArrayList<>();
        texts(list, found);
        int laidOut = 0;
        for (TextView text : found) {
            if (text.getLayout() != null && text.getText().length() > 0) {
                laidOut++;
            }
        }
        assertTrue("the rows' texts are there to be looked at: " + laidOut, laidOut > 20);
        List<String> cut = new ArrayList<>();
        for (TextView text : found) {
            int id = text.getId();
            if ((id == android.R.id.title || id == android.R.id.summary)
                    && (text.getMaxLines() != Integer.MAX_VALUE || text.getEllipsize() != null)) {
                cut.add("limited: " + text.getText());
            }
            Layout layout = text.getLayout();
            if (layout == null || text.getText().length() == 0) {
                continue;
            }
            for (int line = 0; line < layout.getLineCount(); line++) {
                if (layout.getEllipsisCount(line) > 0) {
                    cut.add(text.getText().toString());
                    break;
                }
            }
        }
        return cut;
    }

    @Test
    public void atOneHundredFiftyTheSettingsTextIsLargerAndTheCreatorKeepsItsScale() {
        float base = RuntimeEnvironment.getApplication().getResources().getConfiguration().fontScale;
        prefs().edit().clear().putInt(SettingsTextScale.KEY, 150).putBoolean(Keys.USER_LAYOUT, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        float scaled = activity.getResources().getConfiguration().fontScale;
        assertTrue("larger than the system's: " + scaled + " against " + base, scaled > base * 1.4f);

        SettingsFragmentFirst first = (SettingsFragmentFirst) activity.getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
        ShadowLooper.idleMainLooper();
        Preference title = first.findPreference(SettingsTextScale.KEY + "_title");
        assertNotNull(title);
        assertEquals(activity.getString(com.android.launcher66.R.string.settings_text_scale_value, 150),
                title.getSummary().toString());

        Context creator = SettingsActivity.withoutTextScale(activity);
        assertEquals("the creator's screens at the scale they had", scaled / 1.5f,
                creator.getResources().getConfiguration().fontScale, 0.001f);
        controller.pause().stop().destroy();
    }

    @Test
    public void atOneHundredFiftyNoTextOfTheRowsIsCut() {
        prefs().edit().clear().putInt(SettingsTextScale.KEY, 150).putBoolean(Keys.USER_LAYOUT, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        ShadowLooper.idleMainLooper();
        SettingsFragmentFirst first = (SettingsFragmentFirst) controller.get().getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
        List<String> cutFirst = cut(first);
        assertTrue("cut on the first screen: " + cutFirst, cutFirst.isEmpty());

        FragmentManager manager = controller.get().getSupportFragmentManager();
        SettingsFragmentSecond second = new SettingsFragmentSecond();
        manager.beginTransaction().replace(android.R.id.content, second).commitNow();
        ShadowLooper.idleMainLooper();
        List<String> cutSecond = cut(second);
        assertTrue("cut on the second screen: " + cutSecond, cutSecond.isEmpty());
        controller.pause().stop().destroy();
    }

    @Test
    public void atOneHundredNothingIsChanged() {
        float base = RuntimeEnvironment.getApplication().getResources().getConfiguration().fontScale;
        prefs().edit().clear().commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        assertEquals(base * scaleOfTheScreen(controller.get()),
                controller.get().getResources().getConfiguration().fontScale, 0.001f);
        assertTrue(SettingsActivity.withoutTextScale(controller.get()) == controller.get());
        controller.pause().stop().destroy();
    }

    /** What the settings do to the font scale without the setting (ScreenScale on a phone in portrait). */
    private static float scaleOfTheScreen(SettingsActivity activity) {
        android.content.res.Configuration config =
                com.android.launcher66.ScreenScale.scaledConfiguration(RuntimeEnvironment.getApplication().getResources());
        float base = RuntimeEnvironment.getApplication().getResources().getConfiguration().fontScale;
        return config == null ? 1f : config.fontScale / base;
    }
}
