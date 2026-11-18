package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

/**
 * The Canbus guide and the Spotify guide lie below the status bar and the app bar, as the screens of the
 * settings do (PreferenceScaleHelper.applySystemBarInsets()); before 2026-11-18 their lists began under them.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class GuideInsetsViewTest {

    private static int topPaddingOf(Fragment guide) {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        activity.getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, guide).commitNow();
        ShadowLooper.idleMainLooper();
        View list = guide.requireView().findViewById(R.id.pictures_recycler_view);
        int top = list.getPaddingTop();
        controller.pause().stop().destroy();
        return top;
    }

    private static int expectedTop() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        int top = activity.getStatusBarHeight() + activity.getActionBarHeight();
        controller.pause().stop().destroy();
        return top;
    }

    @Test
    public void theCanbusGuideLiesBelowTheBars() {
        int top = topPaddingOf(new CanbusGuide());
        assertTrue("top padding " + top, top > 0);
        assertEquals(expectedTop(), top);
    }

    @Test
    public void theSpotifyGuideLiesBelowTheBars() {
        int top = topPaddingOf(new SpotifyGuide());
        assertTrue("top padding " + top, top > 0);
        assertEquals(expectedTop(), top);
    }
}
