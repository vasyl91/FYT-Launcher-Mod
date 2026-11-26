package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * The app drawer scrolling vertically (F2): every app is in the list, in the columns of the setting, and the scroller of the
 * letters puts the list at the first app of a letter. The icons are plain text views here (the pager's icon needs the
 * launcher's grid), which is the point of {@link AppsVerticalView.IconBinder}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class AppsVerticalViewTest {

    private static AppInfo app(String title) {
        AppInfo info = new AppInfo();
        info.title = title;
        return info;
    }

    private static List<AppInfo> apps() {
        List<AppInfo> list = new ArrayList<>();
        for (String title : new String[] {"Alarm", "Amazon", "Bank", "Browser", "Calendar", "Camera", "Clock", "Contacts",
                "Drive", "Files", "Gallery", "Maps", "Music", "Notes", "Phone", "Radio", "Settings", "Weather"}) {
            list.add(app(title));
        }
        return list;
    }

    private static AppsVerticalView view(int columns, int rows) {
        Context context = RuntimeEnvironment.getApplication();
        AppsVerticalView view = new AppsVerticalView(context);
        view.setBinder(new AppsVerticalView.IconBinder() {
            @Override
            public View create(ViewGroup parent) {
                return new TextView(parent.getContext());
            }

            @Override
            public void bind(View icon, AppInfo info, AppsVerticalView.Host host) {
                ((TextView) icon).setText(info.title);
            }
        });
        view.setGrid(columns, rows);
        view.setApps(apps());
        view.measure(View.MeasureSpec.makeMeasureSpec(800, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(1400, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, 800, 1400);
        return view;
    }

    @Test
    public void everyAppIsInTheListInTheColumnsOfTheSetting() {
        AppsVerticalView view = view(4, 7);
        assertEquals(18, view.itemCount());
        assertEquals(4, view.columns());
        assertEquals(18, view.list().getAdapter().getItemCount());
        assertEquals(4, ((androidx.recyclerview.widget.GridLayoutManager) view.list().getLayoutManager()).getSpanCount());
    }

    @Test
    public void theGridFollowsTheSettingWhenItChanges() {
        AppsVerticalView view = view(4, 7);
        view.setGrid(6, 5);
        assertEquals(6, view.columns());
        assertEquals(6, ((androidx.recyclerview.widget.GridLayoutManager) view.list().getLayoutManager()).getSpanCount());
    }

    @Test
    public void theScrollerPutsTheListAtTheFirstAppOfALetter() {
        // 18 apps in three columns are six rows and two of them are in view (700 px each of the 1400), so the list has room
        // to scroll and its rows fill it exactly. Both matter: a list whose rows all fit does not move, and rows that do
        // not divide the height (3 rows of 466 px in 1400 px) leave a gap of a few pixels at the end, which the layout
        // closes by pulling the list back, so that a sliver of the row before shows at the top and is the first in view.
        AppsVerticalView view = view(3, 2);
        view.scrollToLetter("M");
        view.measure(View.MeasureSpec.makeMeasureSpec(800, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(1400, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, 800, 1400);
        // The list starts at the row of "Maps", the first of the M (the 12th app, position 11), which in three columns
        // holds the positions 9, 10 and 11. Each condition is its own assertion, so that the line of a failure on CI
        // (which does not print the message) tells which way it failed.
        int first = view.firstVisible();
        assertTrue("some row is in view, but the first is " + first, first >= 0);
        assertTrue("the list moved, but the first in view is " + first, first > 0);
        assertTrue("the list is not past the row of the first M, but the first in view is " + first, first <= 11);
        assertTrue("the list is not before the row of the first M, but the first in view is " + first, first > 8);
    }

    @Test
    public void aTouchOnTheTrackGivesTheLetterOfThePlaceAndATouchBesideItNone() {
        AppsVerticalView view = view(4, 7);
        final List<String> letters = new ArrayList<>();
        view.scroller().setListener(letters::add);
        long now = System.currentTimeMillis();
        MotionEvent beside = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, 10f, 700f, 0);
        assertTrue("a touch away from the track is not taken", !view.scroller().onTouchEvent(beside));
        MotionEvent top = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, 790f, 2f, 0);
        assertTrue(view.scroller().onTouchEvent(top));
        MotionEvent bottom = MotionEvent.obtain(now, now + 10, MotionEvent.ACTION_MOVE, 790f, 1398f, 0);
        view.scroller().onTouchEvent(bottom);
        assertEquals("A", letters.get(0));
        assertEquals("W", letters.get(letters.size() - 1));
        view.scroller().onTouchEvent(MotionEvent.obtain(now, now + 20, MotionEvent.ACTION_UP, 790f, 1398f, 0));
    }

    @Test
    public void theRowsInViewAreWhatTheSettingSays() {
        AppsVerticalView view = view(4, 7);
        RecyclerView list = view.list();
        // the list is 1400 px high: seven rows of 200 px
        assertEquals(200, list.getChildAt(0).getLayoutParams().height);
    }
}
