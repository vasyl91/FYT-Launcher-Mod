package com.android.launcher66;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Collections;
import java.util.List;

/**
 * The fast scroller of the app drawer's vertical list, on its right: a thin track and a handle in the settings' accent
 * ({@link ThemeAccent}). Touching the track shows a bubble beside the handle, in the accent with a white letter, and dragging
 * the handle scrolls the list smoothly to the same fraction of its way ({@link ScrollFraction}); the bubble shows the
 * letter of the first app in view, follows the handle up and down and fades a moment after the finger is lifted. The
 * list hides the scroller when it does not scroll.
 *
 * <p>The bubble is one shape, a circle and an isosceles triangle whose tip points at the handle, so that it is symmetrical in
 * its cross-section and never an irregular shape ({@code Path}). A touch outside the strip of the track is not taken (the
 * list under it gets it). Main thread.
 */
final class LetterScroller extends View {

    interface Listener {
        /** The finger puts the handle at this fraction of the track, 0 its top, 1 its bottom. */
        void onFraction(float fraction);
    }

    private static final long FADE_DELAY_MS = 350L;
    private static final long FADE_MS = 180L;

    private final float mDensity;
    private final Paint mTrack = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mHandle = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mBubble = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mText = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mBubblePath = new Path();
    private final RectF mRect = new RectF();
    private List<String> mAlphabet = Collections.emptyList();
    private Listener mListener;
    private String mLetter = LetterIndex.OTHER;
    private float mFraction;
    private boolean mTouching;
    private float mBubbleAlpha;

    private final Runnable mFade = new Runnable() {
        @Override
        public void run() {
            animate().cancel();
            // the bubble's own alpha, not the view's (the track stays)
            mBubbleAlpha -= 0.2f;
            if (mBubbleAlpha > 0f) {
                invalidate();
                postDelayed(this, FADE_MS / 5);
            } else {
                mBubbleAlpha = 0f;
                invalidate();
            }
        }
    };

    LetterScroller(Context context) {
        this(context, null);
    }

    LetterScroller(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDensity = context.getResources().getDisplayMetrics().density;
        mTrack.setColor(0x66ffffff);
        mTrack.setStyle(Paint.Style.FILL);
        mHandle.setStyle(Paint.Style.FILL);
        mBubble.setStyle(Paint.Style.FILL);
        mText.setColor(0xffffffff);
        mText.setTextAlign(Paint.Align.CENTER);
        mText.setFakeBoldText(true);
        mText.setTextSize(22f * mDensity);
    }

    void setListener(Listener listener) {
        mListener = listener;
    }

    void setAlphabet(List<String> alphabet) {
        mAlphabet = alphabet == null ? Collections.<String>emptyList() : alphabet;
        invalidate();
    }

    /** The list scrolled: the handle goes to its place (not while the finger is on it, the finger puts it there). */
    void setFraction(float fraction) {
        if (mTouching) {
            return;
        }
        mFraction = Math.max(0f, Math.min(1f, fraction));
        invalidate();
    }

    /** The letter of the first app in view, for the bubble. */
    void setBubbleLetter(String letter) {
        if (letter != null && !letter.equals(mLetter)) {
            mLetter = letter;
            invalidate();
        }
    }

    /** Whether the finger is on the handle. */
    boolean isTouching() {
        return mTouching;
    }

    /** The place of the handle, 0..1 (a test asks). */
    float fraction() {
        return mFraction;
    }

    /** The letter the bubble shows (a test asks). */
    String bubbleLetter() {
        return mLetter;
    }

    /** The width of the strip of the track that takes touches. */
    private float strip() {
        return 32f * mDensity;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (mAlphabet.isEmpty() || event.getX() < getWidth() - strip()) {
                    return false;
                }
                mTouching = true;
                removeCallbacks(mFade);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                mBubbleAlpha = 1f;
                update(event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                if (mTouching) {
                    update(event.getY());
                }
                return mTouching;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (mTouching) {
                    mTouching = false;
                    postDelayed(mFade, FADE_DELAY_MS);
                }
                return true;
            default:
                return mTouching;
        }
    }

    private void update(float y) {
        float top = getPaddingTop();
        float height = Math.max(1f, getHeight() - top - getPaddingBottom());
        float fraction = Math.max(0f, Math.min(1f, (y - top) / height));
        mFraction = fraction;
        if (mListener != null) {
            mListener.onFraction(fraction);
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mAlphabet.isEmpty()) {
            return;
        }
        float top = getPaddingTop();
        float bottom = getHeight() - getPaddingBottom();
        float right = getWidth() - 6f * mDensity;
        float trackWidth = 2f * mDensity;
        mRect.set(right - trackWidth, top, right, bottom);
        canvas.drawRoundRect(mRect, trackWidth / 2f, trackWidth / 2f, mTrack);
        int accent = ThemeAccent.color(getContext());
        mHandle.setColor(accent);
        float handleHeight = 36f * mDensity;
        float handleWidth = 6f * mDensity;
        float cy = top + mFraction * (bottom - top);
        cy = Math.max(top + handleHeight / 2f, Math.min(bottom - handleHeight / 2f, cy));
        mRect.set(right - handleWidth + trackWidth / 2f, cy - handleHeight / 2f, right + trackWidth / 2f, cy + handleHeight / 2f);
        canvas.drawRoundRect(mRect, handleWidth / 2f, handleWidth / 2f, mHandle);
        if (mBubbleAlpha > 0f) {
            drawBubble(canvas, accent, right - handleWidth, cy);
        }
    }

    /** A circle with an isosceles triangle on its right side, the tip at the handle: one {@code Path}, symmetrical about the line of the handle. */
    private void drawBubble(Canvas canvas, int accent, float tipX, float cy) {
        float radius = 28f * mDensity;
        float gap = 4f * mDensity;
        float tip = tipX - gap;
        float centerX = tip - radius * 1.7f;
        mBubblePath.reset();
        mBubblePath.addCircle(centerX, cy, radius, Path.Direction.CW);
        // the triangle: its base is the chord of the circle at 45 degrees above and below the line of the handle
        float chord = radius * 0.7071f;
        Path triangle = new Path();
        triangle.moveTo(centerX + chord, cy - chord);
        triangle.lineTo(tip, cy);
        triangle.lineTo(centerX + chord, cy + chord);
        triangle.close();
        mBubblePath.addPath(triangle);
        mBubble.setColor(accent);
        mBubble.setAlpha(Math.round(255 * mBubbleAlpha));
        canvas.drawPath(mBubblePath, mBubble);
        mText.setAlpha(Math.round(255 * mBubbleAlpha));
        Paint.FontMetrics metrics = mText.getFontMetrics();
        canvas.drawText(mLetter, centerX, cy - (metrics.ascent + metrics.descent) / 2f, mText);
    }
}
