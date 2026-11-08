package com.android.launcher66;

/**
 * The state of one gesture seen by the edge handle's input monitor. The monitor sees every touch of the
 * screen and takes none; this decides, from the events inside the handle's area, whether the gesture is
 * the swipe inwards that opens the bar. Everything else (a tap, a drag along the edge, a long press, two
 * fingers) is left alone, so the window below gets it from the input dispatcher as if the handle were not
 * there. Free of android.* so that the rules have a test; the thresholds are those of
 * {@link HorizontalBarEdgeGesture}, which it uses, with no part of the area treated as the visible strip:
 * a click on the strip does not open the bar here, a swipe does.
 *
 * <p>The answers:
 * <ul>
 *   <li>{@link Result#PILFER_AND_OPEN}: the swipe is recognised, once per gesture. The monitor takes the
 *       pointers away from the window below (it gets a cancel instead of a lift) and the bar opens;</li>
 *   <li>{@link Result#STOP}: the gesture is not a swipe inwards (a lift or a cancel without a decision, a
 *       move along the edge or to it, a press longer than the tap timeout, a second finger), or it is
 *       over; the monitor takes no further interest in it;</li>
 *   <li>{@link Result#NONE}: nothing to do (a touch outside the area, or the events after the answer).</li>
 * </ul>
 * Main-thread free: one instance belongs to the monitor's thread.
 */
final class EdgeMonitorTracker {

    enum Result { NONE, PILFER_AND_OPEN, STOP }

    static final int ACTION_DOWN = 0;
    static final int ACTION_UP = 1;
    static final int ACTION_MOVE = 2;
    static final int ACTION_CANCEL = 3;
    static final int ACTION_POINTER_DOWN = 5;

    private enum State { IDLE, OBSERVING, DONE }

    private final HorizontalBarEdgeGesture gesture;
    private State state = State.IDLE;

    EdgeMonitorTracker(float touchSlop, long tapTimeoutMs) {
        gesture = new HorizontalBarEdgeGesture(touchSlop, tapTimeoutMs);
    }

    /**
     * @param action        the action with the pointer index masked out (MotionEvent.getActionMasked())
     * @param x             of the first pointer, in the coordinates of the display
     * @param y             likewise
     * @param pointerCount  the number of fingers down
     * @param inArea        for a DOWN: the point is in the handle's area (the visible strip and the margin
     *                      beside it); not asked for the other actions
     * @param rightEdge     for a DOWN: the handle is on the right edge
     */
    Result onEvent(int action, float x, float y, long timeMs, int pointerCount, boolean inArea, boolean rightEdge) {
        if (action == ACTION_DOWN) {
            state = State.IDLE;
            if (!inArea) {
                return Result.NONE;
            }
            gesture.setRightEdge(rightEdge);
            // Not on the strip: nothing opens the bar but a swipe
            gesture.onDown(x, y, timeMs, false);
            state = pointerCount > 1 ? State.DONE : State.OBSERVING;
            return pointerCount > 1 ? Result.STOP : Result.NONE;
        }
        if (state != State.OBSERVING) {
            return Result.NONE;
        }
        if (pointerCount > 1 || action == ACTION_POINTER_DOWN) {
            state = State.DONE;
            return Result.STOP;
        }
        switch (action) {
            case ACTION_MOVE: {
                // A press that has gone on for longer than the tap timeout belongs to the app below, even if the
                // finger starts to move later
                HorizontalBarEdgeGesture.Decision late = gesture.onTimeout(timeMs);
                HorizontalBarEdgeGesture.Decision decision = late != HorizontalBarEdgeGesture.Decision.UNDECIDED
                        ? late : gesture.onMove(x, y, timeMs);
                return answer(decision);
            }
            case ACTION_UP:
            case ACTION_CANCEL:
                // A lift without a swipe is a click; whatever it was, the gesture is over
                state = State.DONE;
                return Result.STOP;
            default:
                return Result.NONE;
        }
    }

    private Result answer(HorizontalBarEdgeGesture.Decision decision) {
        switch (decision) {
            case OPEN_BAR:
                state = State.DONE;
                return Result.PILFER_AND_OPEN;
            case PASS:
                state = State.DONE;
                return Result.STOP;
            default:
                return Result.NONE;
        }
    }
}
