package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.os.Looper;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * The second screen of the settings, opened at its end (as on the way back from a guide, SettingsScrollMemory)
 * and scrolled up: a row has its height from the moment it comes onto the screen. A row that grew a frame later
 * pushed the rows below it down, and the list jumped while it was scrolled up (the owner, 2026-11-19).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class SettingsRowHeightViewTest {

    private static void settle(View root) {
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofMillis(200));
        root.measure(View.MeasureSpec.makeMeasureSpec(root.getWidth(), View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(root.getHeight(), View.MeasureSpec.EXACTLY));
        root.layout(root.getLeft(), root.getTop(), root.getRight(), root.getBottom());
    }

    /**
     * What decides a row's height, for each row on the screen: the heights its views are given, their padding
     * and the size of their text. The height itself on a device follows them (the text is measured differently here).
     */
    private static Map<Integer, String> heights(RecyclerView list) {
        Map<Integer, String> sizes = new HashMap<>();
        for (int i = 0; i < list.getChildCount(); i++) {
            View child = list.getChildAt(i);
            StringBuilder out = new StringBuilder();
            describe(child, out);
            sizes.put(list.getChildAdapterPosition(child), out.toString());
        }
        return sizes;
    }

    private static void describe(View view, StringBuilder out) {
        android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
        out.append(view.getClass().getSimpleName()).append('[');
        if (lp != null) {
            // Not the width: the restart buttons take the row's real width after its layout, at the same height
            out.append(lp.height);
        }
        if (view instanceof android.widget.TextView) {
            out.append(" text ").append(((android.widget.TextView) view).getTextSize());
        }
        out.append(view.getPaddingTop()).append('/').append(view.getPaddingBottom());
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup group = (android.view.ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                describe(group.getChildAt(i), out);
            }
        }
        out.append(']');
    }

    @Test
    public void scrolledUpFromItsEndNoRowChangesItsHeight() {
        // The rows of the PiPs, the widgets and the restart buttons are shown in the user layout
        PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication()).edit()
                .putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.DISPLAY_PIP, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        FragmentManager manager = controller.get().getSupportFragmentManager();
        View root = controller.get().getWindow().getDecorView();
        // The second screen scrolled down, left for the Canbus guide, and back: the screen is a new one, opened
        // where the list was (SettingsScrollMemory), with none of the rows above bound yet
        SettingsFragmentSecond before = new SettingsFragmentSecond();
        manager.beginTransaction().replace(android.R.id.content, before).commitNow();
        settle(root);
        RecyclerView old = before.getListView();
        ((LinearLayoutManager) old.getLayoutManager()).scrollToPositionWithOffset(old.getAdapter().getItemCount() - 1, 0);
        settle(root);
        manager.beginTransaction().replace(android.R.id.content, new CanbusGuide()).commitNow();
        settle(root);
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        RecyclerView list = screen.getListView();
        settle(root);
        int count = list.getAdapter().getItemCount();
        assertTrue("opened where it was", ((LinearLayoutManager) list.getLayoutManager())
                .findFirstVisibleItemPosition() > 20);

        int steps = 0;
        boolean atTop = false;
        while (!atTop && steps++ < 400) {
            list.scrollBy(0, -60);                 // the rows that come in are laid out now
            Map<Integer, String> shown = heights(list);
            settle(root);                           // what the rows posted has run
            Map<Integer, String> later = heights(list);
            for (Map.Entry<Integer, String> row : shown.entrySet()) {
                String after = later.get(row.getKey());
                if (after != null) {
                    assertEquals("row " + row.getKey() + " of " + count + " was sized after it came in",
                            row.getValue(), after);
                }
            }
            atTop = ((LinearLayoutManager) list.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0;
        }
        assertTrue("scrolled to the top", atTop);
        controller.pause().stop().destroy();
    }
}
