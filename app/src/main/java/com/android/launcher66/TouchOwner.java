package com.android.launcher66;

import android.view.View;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Who owns the touch that is on the screen now, when it is not the home screen's pages.
 *
 * <p>The rule (the owner's, 2026-11-25): a touch that begins on the music widget's position slider, inside the area of
 * its track or its knob ({@link SliderHitArea}), belongs to the slider until the finger is lifted: the pages do not
 * begin to scroll, not even while they are still settling from a swipe (PagedView takes the first touch of
 * a settling pager for its own, so the slider never saw it). A touch beside the slider, or on a slider that only
 * shows the position (disabled), is the widget's and the pages' as always.
 *
 * <p>Two questions are asked here: {@link #wants} (does a touch at this place of the screen begin on a slider that is
 * ready to take it: PagedView asks before it takes a first touch) and {@link #claimed} (is a slider's touch on: PagedView
 * and Workspace do not intercept or start scrolling while it is). Main thread only.
 */
final class TouchOwner {

    private static final List<WeakReference<PositionSeekBar>> SLIDERS = new ArrayList<>();
    private static WeakReference<View> sOwner;

    private TouchOwner() {
    }

    /** A slider is on a window: it may be asked about. */
    static void register(PositionSeekBar slider) {
        for (WeakReference<PositionSeekBar> ref : SLIDERS) {
            if (ref.get() == slider) {
                return;
            }
        }
        SLIDERS.add(new WeakReference<>(slider));
    }

    static void unregister(PositionSeekBar slider) {
        for (Iterator<WeakReference<PositionSeekBar>> it = SLIDERS.iterator(); it.hasNext(); ) {
            PositionSeekBar s = it.next().get();
            if (s == null || s == slider) {
                it.remove();
            }
        }
        release(slider);
    }

    /** The touch that began on this view is the slider's until {@link #release}. */
    static void claim(View owner) {
        sOwner = new WeakReference<>(owner);
    }

    static void release(View owner) {
        View current = sOwner == null ? null : sOwner.get();
        if (current == null || current == owner) {
            sOwner = null;
        }
    }

    /** Forgets every claim and every slider (a test's clean-up). */
    static void reset() {
        sOwner = null;
        SLIDERS.clear();
    }

    /** Whether a slider has the touch that is on the screen. */
    static boolean claimed() {
        return sOwner != null && sOwner.get() != null;
    }

    /**
     * Whether a touch at this place of the screen begins in the area of a slider that is shown and can be moved.
     * Without such a slider this is false, whatever the pages are doing.
     */
    static boolean wants(float rawX, float rawY) {
        int[] at = new int[2];
        for (Iterator<WeakReference<PositionSeekBar>> it = SLIDERS.iterator(); it.hasNext(); ) {
            PositionSeekBar slider = it.next().get();
            if (slider == null) {
                it.remove();
                continue;
            }
            if (!slider.isShown() || !slider.isEnabled()) {
                continue;
            }
            slider.getLocationOnScreen(at);
            if (slider.inHitArea(rawX - at[0], rawY - at[1])) {
                return true;
            }
        }
        return false;
    }
}
