package com.android.launcher66.settings;

import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A text row directly above a divider keeps 16dp under its last line of text, with or without a summary, on a
 * phone and on an FYT unit. The nested rows carried that space on their summary, so a row without one lost it, and
 * on a phone in portrait (text 1.5 times larger) the divider sat right under the title (the owner, 2026-11-20).
 *
 * <p>The space counted is the padding below the text (its own, and that of the views around it up to the row),
 * not what the row's minimum height may add: that depends on the size of the text, which this runtime measures
 * differently from a device.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class SeparatorSpacingViewTest {

    /** The layouts of the text rows; other rows (PiPs, buttons, sliders) have their own design. */
    private static final List<Integer> TEXT_ROWS = Arrays.asList(
            androidx.preference.R.layout.preference_material,
            R.layout.preference_no_switch,
            R.layout.nested_preference_category_content,
            R.layout.nested_preference_category_switch,
            R.layout.nested_preference_category_no_switch);

    private static void settle(View root) {
        shadowOf(Looper.getMainLooper()).idleFor(Duration.ofMillis(200));
        root.measure(View.MeasureSpec.makeMeasureSpec(root.getWidth(), View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(root.getHeight(), View.MeasureSpec.EXACTLY));
        root.layout(root.getLeft(), root.getTop(), root.getRight(), root.getBottom());
    }

    /** The lowest shown line of text in the row (not a button's): its view, or null. */
    private static TextView lowestText(View view, View row, TextView best) {
        if (view.getVisibility() != View.VISIBLE) {
            return best;
        }
        if (view instanceof TextView && !(view instanceof Button) && ((TextView) view).length() > 0) {
            if (best == null || bottomIn(view, row) > bottomIn(best, row)) {
                best = (TextView) view;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                best = lowestText(group.getChildAt(i), row, best);
            }
        }
        return best;
    }

    private static int bottomIn(View view, View row) {
        int bottom = view.getBottom();
        for (View v = (View) view.getParent(); v != null && v != row; v = (View) v.getParent()) {
            bottom += v.getTop();
        }
        return bottom;
    }

    /** The padding and margins below the text, from the text view up to the row. */
    private static int spaceBelow(TextView text, View row) {
        int space = 0;
        for (View v = text; v != null; v = v == row ? null : (View) v.getParent()) {
            space += v.getPaddingBottom();
            if (v != row && v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                space += ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
            }
        }
        return space;
    }

    /** The rows checked (their keys) go to {@code checked}; the rows too close to a divider are returned. */
    private static List<String> rowsTooCloseToADivider(Fragment screen, List<String> checked) {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        View root = controller.get().getWindow().getDecorView();
        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, screen).commitNow();
        settle(root);
        RecyclerView list = ((androidx.preference.PreferenceFragmentCompat) screen).getListView();
        PreferenceGroupAdapter adapter = (PreferenceGroupAdapter) list.getAdapter();
        List<String> close = new ArrayList<>();
        for (int position = 1; position < adapter.getItemCount(); position++) {
            Preference divider = adapter.getItem(position);
            Preference above = adapter.getItem(position - 1);
            if (divider == null || above == null || !isDivider(divider)
                    || above instanceof PreferenceCategory || !TEXT_ROWS.contains(above.getLayoutResource())) {
                continue;
            }
            ((LinearLayoutManager) list.getLayoutManager()).scrollToPositionWithOffset(position - 1, 0);
            settle(root);
            RecyclerView.ViewHolder holder = list.findViewHolderForAdapterPosition(position - 1);
            if (holder == null) {
                continue;
            }
            View row = holder.itemView;
            TextView text = lowestText(row, row, null);
            if (text == null) {
                continue;
            }
            checked.add(above.getKey());
            float least = 16 * row.getResources().getDisplayMetrics().density - 1;
            int space = spaceBelow(text, row) + dividerTopMargin(divider, list);
            if (space < least) {
                close.add(above.getKey() + ": " + space + " px under its text, at least " + least);
            }
        }
        controller.pause().stop().destroy();
        return close;
    }

    /** The user layout (every row of the second screen) and night mode (its reset row, above a divider) on. */
    private static void prefs() {
        PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication()).edit()
                .putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.NIGHT_MODE, true).commit();
    }

    private static void check() {
        prefs();
        List<String> checked = new ArrayList<>();
        List<String> first = rowsTooCloseToADivider(new SettingsFragmentFirst(), checked);
        assertTrue(first.toString(), first.isEmpty());
        // The rows whose blank summary was taken out (the owner, 2026-11-20); the nested one had no space left
        assertTrue(checked.toString(), checked.contains("reset_night_mode"));
        assertTrue(checked.toString(), checked.contains("baseline_profile_reset"));
        List<String> second = rowsTooCloseToADivider(new SettingsFragmentSecond(), checked);
        assertTrue(second.toString(), second.isEmpty());
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void onAPhoneInPortraitEveryTextRowKeepsItsSpaceAboveADivider() {
        check();
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void onAnFytUnitEveryTextRowKeepsItsSpaceAboveADivider() {
        check();
    }

    private static boolean isDivider(Preference p) {
        int layout = p.getLayoutResource();
        return layout == R.layout.preference_separator
                || layout == R.layout.preference_separator_within;
    }

    /** The margin above a divider, read from its layout. */
    private static int dividerTopMargin(Preference divider, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(divider.getLayoutResource(), parent, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        return params instanceof ViewGroup.MarginLayoutParams
                ? ((ViewGroup.MarginLayoutParams) params).topMargin : 0;
    }
}
