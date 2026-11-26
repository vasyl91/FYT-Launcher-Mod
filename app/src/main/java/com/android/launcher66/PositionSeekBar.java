package com.android.launcher66;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.SeekBar;

/**
 * The music widget's position slider, which owns the touches that begin on it ({@link TouchOwner}).
 *
 * <p>A SeekBar in a pager believes it is in a scrolling container and waits for a movement of 8 dp before it takes a
 * touch, while the pager begins to scroll after a few pixels: the pages won. Here a touch that begins on the track or
 * the knob ({@link SliderHitArea}, a little larger than they are drawn) is taken at once: the parents may not intercept
 * it, the slider tracks it from the first pixel and the touch is the slider's until the finger is lifted. A touch
 * elsewhere in the slider's row is not consumed, so it goes to the widget and to the pages as before; so is any touch
 * while the slider is disabled (the sources that cannot be moved only show their position). Main thread only.
 */
public class PositionSeekBar extends SeekBar {

    /** This slider took the touch that is on now. */
    private boolean mOwned;

    public PositionSeekBar(Context context) {
        super(context);
    }

    public PositionSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PositionSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * {@code View.isInScrollingContainer()} (hidden in the platform's API, called by AbsSeekBar): false, so that the
     * slider does not wait for the touch slop before it tracks a touch. It is not an override in the compiler's eyes
     * (the method is not in the SDK's stubs), the runtime calls it all the same.
     */
    public boolean isInScrollingContainer() {
        return false;
    }

    /** Whether a touch at x, y (this view's coordinates) is on the track or the knob, as drawn and a little more. */
    boolean inHitArea(float x, float y) {
        Drawable thumb = getThumb();
        float knob = thumb == null ? 0f : Math.max(thumb.getIntrinsicWidth(), thumb.getIntrinsicHeight());
        float knobCenterX = thumb == null ? -1f
                : getPaddingLeft() - getThumbOffset() + thumb.getBounds().exactCenterX();
        return SliderHitArea.contains(x, y, getWidth(), getHeight(), Math.max(1, getMaxHeight()), knob, knobCenterX);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            mOwned = inHitArea(event.getX(), event.getY());
            if (!mOwned) {
                return false;
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            TouchOwner.claim(this);
        } else if (!mOwned) {
            return false;
        }
        boolean handled = super.onTouchEvent(event);
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            mOwned = false;
            TouchOwner.release(this);
        }
        return handled || mOwned;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TouchOwner.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        TouchOwner.unregister(this);
        mOwned = false;
        super.onDetachedFromWindow();
    }
}
