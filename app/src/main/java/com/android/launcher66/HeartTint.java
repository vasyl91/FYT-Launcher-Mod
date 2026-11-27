package com.android.launcher66;

/**
 * The colour of the music widget's heart (the like button), on the home widget and on the widget bar.
 *
 * <p>The rule (the owner, 2026-11-27): <b>a liked track's heart is always its own filled red</b>; "Widget text and
 * button color" and "Horizontal bar text and button color" colour the heart only while the track is not liked (the
 * outline), as they colour the other buttons. Pure Java, so that it has a test.
 */
final class HeartTint {

    private HeartTint() {
    }

    /** The tint for the heart: none (the drawable's own colours) when liked, the buttons' tint otherwise. */
    static int of(boolean liked, int buttonsTint) {
        return liked ? ViewTint.NONE : buttonsTint;
    }
}
