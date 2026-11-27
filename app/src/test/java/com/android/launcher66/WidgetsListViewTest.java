package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The drawer's widgets as a list of apps (G1): one row for each app, in the order of their names, with its counts; a tap
 * opens a row and closes the one open; the search keeps the apps and entries that match. The entries are plain strings
 * here ("package/label/w" for a widget, "/s" for a shortcut) and the cells plain views, which is what the host is for.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class WidgetsListViewTest {

    private static final class FakeHost implements WidgetsListView.Host {
        @Override
        public View makeCell(Object rawInfo, ViewGroup parent, int width, int height) {
            TextView cell = new TextView(parent.getContext());
            cell.setText(rawInfo.toString());
            return cell;
        }

        @Override
        public void loadPreview(View cell, Object rawInfo) {
        }

        @Override
        public Drawable appIcon(String packageName) {
            return null;
        }

        @Override
        public String appLabel(String packageName) {
            return packageName.equals("p.clock") ? "Clock" : packageName.equals("p.music") ? "Music" : "Weather";
        }

        @Override
        public String entryLabel(Object rawInfo) {
            return rawInfo.toString().split("/")[1];
        }

        @Override
        public String packageOf(Object rawInfo) {
            return rawInfo.toString().split("/")[0];
        }

        @Override
        public boolean isShortcut(Object rawInfo) {
            return rawInfo.toString().endsWith("/s");
        }
    }

    private static WidgetsListView list() {
        Context context = RuntimeEnvironment.getApplication();
        WidgetsListView view = new WidgetsListView(context);
        view.setHost(new FakeHost());
        List<Object> raw = new ArrayList<>(Arrays.asList("p.weather/Forecast/w", "p.clock/Alarm/s", "p.clock/Analog/w",
                "p.clock/Digital/w", "p.music/Player/w", "p.music/Playlist/s", "p.music/Radio/s", "p.music/Album/s"));
        view.setWidgets(raw);
        layOut(view);
        return view;
    }

    private static void layOut(WidgetsListView view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(2340, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, 1080, 2340);
    }

    /** The two lines of the row at a position: the name and the counts. */
    private static String[] row(WidgetsListView view, int position) {
        RecyclerView list = view.list();
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = list.getAdapter();
        RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(list, adapter.getItemViewType(position));
        adapter.onBindViewHolder(holder, position);
        LinearLayout text = (LinearLayout) ((LinearLayout) holder.itemView).getChildAt(1);
        return new String[] {((TextView) text.getChildAt(0)).getText().toString(),
                ((TextView) text.getChildAt(1)).getText().toString()};
    }

    @Test
    public void oneRowForEachAppInTheOrderOfTheirNamesWithTheirCounts() {
        WidgetsListView view = list();
        assertEquals(3, view.groups().size());
        assertEquals("Clock", row(view, 0)[0]);
        assertEquals("Widgets: 2, Shortcuts: 1", row(view, 0)[1]);
        assertEquals("Music", row(view, 1)[0]);
        assertEquals("Widgets: 1, Shortcuts: 3", row(view, 1)[1]);
        assertEquals("Weather", row(view, 2)[0]);
        assertEquals("a count of none is left out", "Widgets: 1", row(view, 2)[1]);
    }

    @Test
    public void aTapOpensARowAndClosesTheOneOpen() {
        WidgetsListView view = list();
        assertNull(view.expanded());
        assertEquals(3, view.list().getAdapter().getItemCount());
        view.toggle("p.clock");
        assertEquals("p.clock", view.expanded());
        assertEquals("its content is a row of the list", 4, view.list().getAdapter().getItemCount());
        view.toggle("p.music");
        assertEquals("one open at a time", "p.music", view.expanded());
        assertEquals(4, view.list().getAdapter().getItemCount());
        view.toggle("p.music");
        assertNull(view.expanded());
        assertEquals(3, view.list().getAdapter().getItemCount());
    }

    @Test
    public void theSearchKeepsTheAppsAndTheEntriesThatMatch() {
        WidgetsListView view = list();
        view.setQuery("radio");
        assertEquals(1, view.groups().size());
        assertEquals("Music", view.groups().get(0).appLabel);
        assertEquals("only the entry that matches", 1, view.groups().get(0).shortcutCount());
        view.setQuery("clock");
        assertEquals("the app's name matches: all of its entries", 3,
                view.groups().get(0).widgetCount() + view.groups().get(0).shortcutCount());
        view.setQuery("");
        assertEquals(3, view.groups().size());
    }
}
