package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * A swipe sideways on the drawer's list changes the tab (F6): the list follows the finger, the underline with it; a swipe
 * longer than a quarter of the width, or a fling, goes to the next tab (the finger to the left) or the previous one; a
 * short one goes back; a vertical drag is the list's own.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class AppsVerticalSwipeTest {

    private static final class Swipe implements AppsVerticalView.TabSwipe {
        boolean can = true;
        boolean next = true;
        boolean previous = true;
        final List<Float> progress = new ArrayList<>();
        final List<Integer> commits = new ArrayList<>();
        int cancels;

        @Override
        public boolean canSwipe() {
            return can;
        }

        @Override
        public boolean hasTab(int direction) {
            return direction > 0 ? next : previous;
        }

        @Override
        public void onSwipeProgress(float fraction) {
            progress.add(fraction);
        }

        @Override
        public void onSwipeCommit(int direction) {
            commits.add(direction);
        }

        @Override
        public void onSwipeCancel() {
            cancels++;
        }
    }

    private static AppsVerticalView view(Swipe swipe) {
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
        List<AppInfo> apps = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            AppInfo info = new AppInfo();
            info.title = "App" + i;
            apps.add(info);
        }
        view.setGrid(4, 7);
        view.setApps(apps);
        view.setTabSwipe(swipe);
        view.measure(View.MeasureSpec.makeMeasureSpec(1000, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(1400, View.MeasureSpec.EXACTLY));
        view.layout(0, 0, 1000, 1400);
        return view;
    }

    /** A drag from (x0, y0) to (x1, y1) in 200 ms, in steps, and the finger lifted. */
    private static void drag(View view, float x0, float y0, float x1, float y1, long millis) {
        long down = SystemClock.uptimeMillis();
        view.dispatchTouchEvent(MotionEvent.obtain(down, down, MotionEvent.ACTION_DOWN, x0, y0, 0));
        int steps = 10;
        for (int i = 1; i <= steps; i++) {
            long t = down + millis * i / steps;
            float x = x0 + (x1 - x0) * i / steps;
            float y = y0 + (y1 - y0) * i / steps;
            view.dispatchTouchEvent(MotionEvent.obtain(down, t, MotionEvent.ACTION_MOVE, x, y, 0));
        }
        view.dispatchTouchEvent(MotionEvent.obtain(down, down + millis, MotionEvent.ACTION_UP, x1, y1, 0));
    }

    @Test
    public void aLongSwipeToTheLeftGoesToTheNextTabAndTheListFollowedTheFinger() {
        Swipe swipe = new Swipe();
        AppsVerticalView view = view(swipe);
        drag(view, 800f, 700f, 400f, 710f, 800);
        assertEquals(1, swipe.commits.size());
        assertEquals(1, (int) swipe.commits.get(0));
        assertFalse(swipe.progress.isEmpty());
        assertTrue("the list followed the finger to the left", swipe.progress.get(swipe.progress.size() - 1) < -0.3f);
    }

    @Test
    public void aLongSwipeToTheRightGoesToThePreviousTab() {
        Swipe swipe = new Swipe();
        AppsVerticalView view = view(swipe);
        drag(view, 200f, 700f, 700f, 690f, 800);
        assertEquals(1, swipe.commits.size());
        assertEquals(-1, (int) swipe.commits.get(0));
    }

    @Test
    public void aShortSlowSwipeGoesBack() {
        Swipe swipe = new Swipe();
        AppsVerticalView view = view(swipe);
        drag(view, 600f, 700f, 450f, 705f, 1200);
        assertTrue(swipe.commits.isEmpty());
        assertEquals(1, swipe.cancels);
    }

    @Test
    public void aFastShortFlingChangesTheTab() {
        Swipe swipe = new Swipe();
        AppsVerticalView view = view(swipe);
        drag(view, 600f, 700f, 520f, 702f, 60);
        assertEquals(1, swipe.commits.size());
        assertEquals(1, (int) swipe.commits.get(0));
    }

    @Test
    public void nothingChangesPastTheLastTab() {
        Swipe swipe = new Swipe();
        swipe.next = false;
        AppsVerticalView view = view(swipe);
        drag(view, 800f, 700f, 300f, 700f, 400);
        assertTrue(swipe.commits.isEmpty());
        assertEquals(1, swipe.cancels);
    }

    @Test
    public void aVerticalDragIsTheListsOwn() {
        Swipe swipe = new Swipe();
        AppsVerticalView view = view(swipe);
        drag(view, 500f, 1000f, 520f, 300f, 300);
        assertTrue(swipe.commits.isEmpty());
        assertTrue(swipe.progress.isEmpty());
    }

    @Test
    public void withoutAStripNothingIsIntercepted() {
        Swipe swipe = new Swipe();
        swipe.can = false;
        AppsVerticalView view = view(swipe);
        drag(view, 800f, 700f, 200f, 700f, 400);
        assertTrue(swipe.commits.isEmpty());
        assertTrue(swipe.progress.isEmpty());
    }
}
