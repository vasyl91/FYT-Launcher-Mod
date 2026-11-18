package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

/**
 * The first screen of the settings, scrolled down, left for the Spotify guide and come back to: it opens where
 * it was. Moved to the second screen and back instead, it opens at the top (SettingsScrollMemory).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w800dp-h600dp")
public class SettingsScrollViewTest {

    private static void show(FragmentManager manager, Fragment screen) {
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
    }

    private static int firstSeen(SettingsFragmentFirst screen) {
        RecyclerView list = screen.getListView();
        return ((LinearLayoutManager) list.getLayoutManager()).findFirstVisibleItemPosition();
    }

    private static SettingsFragmentFirst scrolledFirstScreen(FragmentManager manager) {
        SettingsFragmentFirst first = new SettingsFragmentFirst();
        show(manager, first);
        ((LinearLayoutManager) first.getListView().getLayoutManager()).scrollToPositionWithOffset(12, 0);
        ShadowLooper.idleMainLooper();
        return first;
    }

    @Test
    public void backFromAGuideTheScreenIsWhereItWas() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        FragmentManager manager = controller.get().getSupportFragmentManager();
        SettingsFragmentFirst first = scrolledFirstScreen(manager);
        int before = firstSeen(first);
        assertTrue("scrolled: " + before, before > 0);

        show(manager, new SpotifyGuide());          // the first screen is left for the guide
        SettingsFragmentFirst back = new SettingsFragmentFirst();
        show(manager, back);                         // what the guide's Back does
        assertEquals(before, firstSeen(back));
        controller.pause().stop().destroy();
    }

    @Test
    public void throughTheSecondScreenItStartsAtTheTop() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        FragmentManager manager = controller.get().getSupportFragmentManager();
        scrolledFirstScreen(manager);

        SettingsScrollMemory.betweenScreens();      // what the row of the second screen does
        show(manager, new SettingsFragmentSecond());
        SettingsScrollMemory.betweenScreens();      // what the second screen's Back does
        SettingsFragmentFirst back = new SettingsFragmentFirst();
        show(manager, back);
        assertEquals(0, firstSeen(back));
        controller.pause().stop().destroy();
    }
}
