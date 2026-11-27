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
 * The app drawer scrolling vertically (F2): every app is in the list, in the columns of the setting; the scroller of the
 * letters moves the list by pixels to the fraction of the finger (ScrollFraction) and is there only when the list scrolls. The icons are plain text views here (the pager's icon needs the
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
    public void aTouchOnTheTrackGivesThePlaceOfTheFingerAndATouchBesideItNone() {
        AppsVerticalView view = view(3, 2);
        final List<Float> fractions = new ArrayList<>();
        view.scroller().setListener(fractions::add);
        long now = System.currentTimeMillis();
        MotionEvent beside = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, 10f, 700f, 0);
        assertTrue("a touch away from the track is not taken", !view.scroller().onTouchEvent(beside));
        MotionEvent top = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, 790f, 0f, 0);
        assertTrue(view.scroller().onTouchEvent(top));
        MotionEvent bottom = MotionEvent.obtain(now, now + 10, MotionEvent.ACTION_MOVE, 790f, 1400f, 0);
        view.scroller().onTouchEvent(bottom);
        assertEquals(0f, fractions.get(0), 0.001f);
        assertEquals(1f, fractions.get(fractions.size() - 1), 0.001f);
        view.scroller().onTouchEvent(MotionEvent.obtain(now, now + 20, MotionEvent.ACTION_UP, 790f, 1400f, 0));
    }

    @Test
    public void theHandleScrollsTheListSmoothlyByPixelsAndTheBubbleHasTheLetterInView() {
        // six rows of 700 px, two in view: the list can scroll 2800 px
        AppsVerticalView view = view(3, 2);
        RecyclerView list = view.list();
        int room = list.computeVerticalScrollRange() - list.computeVerticalScrollExtent();
        assertTrue("the list scrolls, by " + room, room > 0);
        // A quarter of the way: a place inside a row, not the start of a letter's row
        view.scrollToFraction(0.25f);
        relayout(view);
        assertEquals("by pixels, to the same fraction", Math.round(0.25f * room), list.computeVerticalScrollOffset(), 2);
        assertEquals("the handle follows", 0.25f, view.scroller().fraction(), 0.01f);
        int first = view.firstVisible();
        assertEquals(LetterIndex.letterAt(titles(), first), view.scroller().bubbleLetter());
        view.scrollToFraction(1f);
        relayout(view);
        assertEquals(room, list.computeVerticalScrollOffset(), 2);
        // the last two rows in view: the first app in view is "Music"
        assertEquals(LetterIndex.letterAt(titles(), view.firstVisible()), view.scroller().bubbleLetter());
        assertEquals("M", view.scroller().bubbleLetter());
    }

    @Test
    public void aListThatDoesNotScrollHasNoScroller() {
        // 18 apps in four columns are five rows, seven fit: nothing scrolls
        AppsVerticalView view = view(4, 7);
        assertEquals(View.GONE, view.scroller().getVisibility());
        // fewer rows in view: it scrolls, the scroller comes
        view.setGrid(4, 2);
        relayout(view);
        assertEquals(View.VISIBLE, view.scroller().getVisibility());
    }

    private static List<String> titles() {
        List<String> titles = new ArrayList<>();
        for (AppInfo info : apps()) {
            titles.add(info.title.toString());
        }
        return titles;
    }

    private static void relayout(AppsVerticalView view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(800, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(1400, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, 800, 1400);
    }

    @Test
    public void theRowsInViewAreWhatTheSettingSays() {
        AppsVerticalView view = view(4, 7);
        RecyclerView list = view.list();
        // the list is 1400 px high: seven rows of 200 px
        assertEquals(200, list.getChildAt(0).getLayoutParams().height);
    }
}
