package com.android.launcher66;

/**
 * The place of the vertical app drawer's list as a fraction of the way it can scroll, for the letter scroller
 * ({@link LetterScroller}).
 *
 * <p>The rules (the owner on the A55, 2026-11-27: the scroller jumped from letter to letter, and it stood in the middle of a
 * list that did not scroll):
 * <ul>
 *   <li>The handle stands for the list's place: 0 at its top, 1 where its last row is at the bottom, in between in
 *       proportion to the pixels scrolled ({@code computeVerticalScrollOffset} of the way {@code range - extent}).</li>
 *   <li>Dragging the handle scrolls the list by pixels to the same fraction, so it moves smoothly with the finger; the
 *       bubble shows the letter of the first app in view.</li>
 *   <li>A list that does not scroll (every row in view) has no scroller.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class ScrollFraction {

    private ScrollFraction() {
    }

    /** Whether the list can scroll at all. */
    static boolean scrolls(int range, int extent) {
        return range > extent;
    }

    /** The fraction 0..1 for a scroll offset; 0 for a list that does not scroll. */
    static float of(int offset, int range, int extent) {
        int room = range - extent;
        if (room <= 0) {
            return 0f;
        }
        return Math.max(0f, Math.min(1f, offset / (float) room));
    }

    /** The scroll offset for a fraction (out of 0..1 is the nearest end). */
    static int offsetFor(float fraction, int range, int extent) {
        int room = Math.max(0, range - extent);
        float f = Math.max(0f, Math.min(1f, fraction));
        return Math.round(f * room);
    }
}
