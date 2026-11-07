package com.android.launcher66;

/**
 * Who a touch on the edge handle's window belongs to, the handle or whatever is under it. The
 * window is wider than the visible strip so that a swipe to the right is easy to start, but a
 * tap, a vertical drag or a long press in the transparent margin must reach the widget or the
 * pane below. Kept free of android.* so the rules can be tested; the view feeds it the events
 * and acts on the answer.
 *
 * <ul>
 *   <li>a swipe to the right (at least the touch slop, and at least 1.5 times as far as it went
 *       up or down) opens the bar: {@link Decision#OPEN_BAR}, the rest of the gesture is eaten;</li>
 *   <li>a mostly vertical move, or a move to the left, is not ours: {@link Decision#PASS};</li>
 *   <li>a touch in the margin that is undecided for longer than the tap timeout is a press for
 *       the thing below: {@link Decision#PASS}. On the visible strip itself there is no such
 *       timeout, because a slow tap on the strip has to open the bar as it always did;</li>
 *   <li>a lift without a decision opens the bar when the touch began on the strip, and passes
 *       (the whole tap) when it began in the margin.</li>
 * </ul>
 *
 * One instance serves one window, one gesture at a time: {@link #onDown} starts it afresh.
 */
final class HorizontalBarEdgeGesture {

    enum Decision { UNDECIDED, OPEN_BAR, PASS }

    /** How much further to the right than up or down a swipe must go to open the bar. */
    static final float HORIZONTAL_DOMINANCE = 1.5f;

    private final float touchSlop;
    private final long tapTimeoutMs;

    private float downX;
    private float downY;
    private long downTimeMs;
    private boolean onStrip;
    private Decision decision = Decision.UNDECIDED;

    HorizontalBarEdgeGesture(float touchSlop, long tapTimeoutMs) {
        this.touchSlop = touchSlop;
        this.tapTimeoutMs = tapTimeoutMs;
    }

    void onDown(float x, float y, long timeMs, boolean onVisibleStrip) {
        downX = x;
        downY = y;
        downTimeMs = timeMs;
        onStrip = onVisibleStrip;
        decision = Decision.UNDECIDED;
    }

    /** @return the decision so far; the first one made is kept to the end of the gesture */
    Decision onMove(float x, float y, long timeMs) {
        if (decision != Decision.UNDECIDED) {
            return decision;
        }
        float dx = x - downX;
        float dy = y - downY;
        if (dx >= touchSlop && dx >= HORIZONTAL_DOMINANCE * Math.abs(dy)) {
            decision = Decision.OPEN_BAR;
        } else if ((Math.abs(dy) >= touchSlop && Math.abs(dy) > Math.abs(dx)) || dx <= -touchSlop) {
            decision = Decision.PASS;
        } else {
            onTimeout(timeMs);
        }
        return decision;
    }

    /** Asked when the tap timeout has run out without a move, and with every move. */
    Decision onTimeout(long timeMs) {
        if (decision == Decision.UNDECIDED && !onStrip && timeMs - downTimeMs >= tapTimeoutMs) {
            decision = Decision.PASS;
        }
        return decision;
    }

    /** The finger is lifted. @return the final decision, never UNDECIDED */
    Decision onUp(float x, float y, long timeMs) {
        if (decision == Decision.UNDECIDED) {
            onMove(x, y, timeMs);
        }
        if (decision == Decision.UNDECIDED) {
            decision = onStrip ? Decision.OPEN_BAR : Decision.PASS;
        }
        return decision;
    }

    Decision decision() {
        return decision;
    }

    /** Milliseconds after the down at which a timeout is due, or -1 when the touch has none (on the strip). */
    long timeoutAfterMs() {
        return onStrip ? -1L : tapTimeoutMs;
    }
}
