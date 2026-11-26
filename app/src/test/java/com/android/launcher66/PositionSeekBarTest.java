package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The position slider takes the touches that begin on its track or its knob at once and keeps them until the
 * finger is lifted; a touch beside it, or on a slider that cannot be moved, is not its own. The pager does not
 * start to scroll, nor intercept, while the slider has the touch, also when the pager is still settling.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class PositionSeekBarTest {

    private static final int W = 800;
    private static final int H = 60;

    /** A parent that remembers that it was told not to intercept. */
    private static final class Parent extends FrameLayout {
        boolean disallowed;

        Parent(Context context) {
            super(context);
        }

        @Override
        public void requestDisallowInterceptTouchEvent(boolean disallow) {
            disallowed = disallow;
            super.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    private int startedTracking;
    private int stoppedTracking;

    @After
    public void clean() {
        TouchOwner.reset();
    }

    private PositionSeekBar slider(Parent parent) {
        Context context = parent.getContext();
        PositionSeekBar slider = new PositionSeekBar(context);
        slider.setProgressDrawable(context.getDrawable(R.drawable.music_position_track));
        slider.setMax(PositionSlider.MAX);
        slider.setProgress(0);
        PositionSliderLook.size(slider, H);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                startedTracking++;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                stoppedTracking++;
            }
        });
        parent.addView(slider, new ViewGroup.LayoutParams(W, H));
        slider.measure(View.MeasureSpec.makeMeasureSpec(W, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(H, View.MeasureSpec.EXACTLY));
        slider.layout(0, 0, W, H);
        return slider;
    }

    private static MotionEvent event(int action, float x, float y) {
        long now = SystemClock.uptimeMillis();
        return MotionEvent.obtain(now, now, action, x, y, 0);
    }

    @Test
    public void aTouchOnTheTrackIsTakenAtOnceWithoutWaitingForTheSlop() {
        Parent parent = new Parent(RuntimeEnvironment.getApplication());
        PositionSeekBar slider = slider(parent);
        // the middle of the line, away from the knob (which is at the left end: progress 0)
        assertTrue(slider.dispatchTouchEvent(event(MotionEvent.ACTION_DOWN, 400f, H / 2f)));
        assertEquals("the slider tracks from the first pixel", 1, startedTracking);
        assertTrue(parent.disallowed);
        assertTrue(TouchOwner.claimed());
        assertEquals("the slider's value is where the finger is", PositionSlider.MAX / 2, slider.getProgress(), 40);
        assertTrue(slider.dispatchTouchEvent(event(MotionEvent.ACTION_UP, 400f, H / 2f)));
        assertEquals(1, stoppedTracking);
        assertFalse(TouchOwner.claimed());
    }

    @Test
    public void aTouchInTheRowBeyondTheTrackAndTheKnobIsNotTheSliders() {
        Parent parent = new Parent(RuntimeEnvironment.getApplication());
        PositionSeekBar slider = slider(parent);
        assertFalse(slider.dispatchTouchEvent(event(MotionEvent.ACTION_DOWN, 400f, 1f)));
        assertFalse(slider.dispatchTouchEvent(event(MotionEvent.ACTION_DOWN, 400f, H - 1f)));
        assertEquals(0, startedTracking);
        assertFalse(parent.disallowed);
        assertFalse(TouchOwner.claimed());
    }

    @Test
    public void aSliderThatOnlyShowsThePositionTakesNoTouch() {
        Parent parent = new Parent(RuntimeEnvironment.getApplication());
        PositionSeekBar slider = slider(parent);
        slider.setEnabled(false);
        assertFalse(slider.dispatchTouchEvent(event(MotionEvent.ACTION_DOWN, 400f, H / 2f)));
        assertFalse(TouchOwner.claimed());
        assertFalse(TouchOwner.wants(400f, H / 2f));
    }

    @Test
    public void theSliderOnAWindowIsWantedAtItsPlaceAndNotElsewhere() {
        Activity activity = Robolectric.buildActivity(Activity.class).setup().get();
        Parent parent = new Parent(activity);
        activity.setContentView(parent, new ViewGroup.LayoutParams(W, H));
        PositionSeekBar slider = slider(parent);
        parent.layout(0, 0, W, H);
        int[] at = new int[2];
        slider.getLocationOnScreen(at);
        assertTrue("on the line", TouchOwner.wants(at[0] + 400f, at[1] + H / 2f));
        assertFalse("beside the line, in the row", TouchOwner.wants(at[0] + 400f, at[1] + 1f));
        assertFalse("below the slider", TouchOwner.wants(at[0] + 400f, at[1] + H + 200f));
    }

    @Test
    public void thePagerLeavesAnyTouchAloneWhileTheSliderHasIt() {
        PagerForTest pager = new PagerForTest(RuntimeEnvironment.getApplication());
        pager.addView(new View(pager.getContext()), new ViewGroup.LayoutParams(W, H));
        pager.setScrolling();
        TouchOwner.claim(new View(pager.getContext()));
        // a move that the pager would have intercepted as it is scrolling
        assertFalse(pager.onInterceptTouchEvent(event(MotionEvent.ACTION_MOVE, 100f, 100f)));
        TouchOwner.reset();
        assertTrue(pager.onInterceptTouchEvent(event(MotionEvent.ACTION_MOVE, 100f, 100f)));
    }

    /** A pager with nothing of its own, for the touch handling of PagedView. */
    private static final class PagerForTest extends PagedView {
        PagerForTest(Context context) {
            super(context);
        }

        void setScrolling() {
            mTouchState = TOUCH_STATE_SCROLLING;
        }

        @Override
        public void syncPages() {
        }

        @Override
        public void syncPageItems(int page, boolean immediate) {
        }
    }
}
