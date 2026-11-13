package com.android.launcher66.settings;

import android.graphics.Paint;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Fits the text of a button of the settings (ADJUST, Restart 1 ... 4) into the height the row gives it.
 *
 * <p>The rule: a button whose height is set in code shows its whole line of text. The rows of the settings
 * give their buttons a height counted from the row (55 % of it) and a text half as high. The button kept the
 * vertical padding of its style and the font's own padding inside that height, so on phones (where the row is
 * low) the line needed more room than the button had and its bottom was cut. A button fitted here has no
 * vertical padding, no minimum height and no font padding, its text is centred, and the text is made smaller
 * if even then the line would not fit. The height of the button itself is not changed.
 *
 * <p>The arithmetic is in {@link #textPx}, which has a test.
 */
final class ButtonTextFit {

    /** The share of the button's height the line of text may take; the rest is the room above and below it. */
    static final float LINE_SHARE = 0.86f;

    private ButtonTextFit() {
    }

    /**
     * The text size that fits.
     *
     * @param wantedPx  the size the row asks for
     * @param heightPx  the height of the button
     * @param lineRatio the height of one line of the font (descent minus ascent) per pixel of text size
     */
    static float textPx(float wantedPx, int heightPx, float lineRatio) {
        if (heightPx <= 0 || lineRatio <= 0f) {
            return Math.max(1f, wantedPx);
        }
        float fits = heightPx * LINE_SHARE / lineRatio;
        return Math.max(1f, Math.min(wantedPx, fits));
    }

    /** Sets the text size and takes away what stood between the text and the button's height. */
    static void apply(TextView button, int heightPx, float wantedPx) {
        if (button == null) {
            return;
        }
        Paint.FontMetrics metrics = button.getPaint().getFontMetrics();
        float size = button.getPaint().getTextSize();
        float lineRatio = size > 0f ? (metrics.descent - metrics.ascent) / size : 0f;
        button.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx(wantedPx, heightPx, lineRatio));
        button.setIncludeFontPadding(false);
        button.setMinHeight(0);
        button.setMinimumHeight(0);
        button.setPadding(button.getPaddingLeft(), 0, button.getPaddingRight(), 0);
        button.setGravity(Gravity.CENTER);
    }
}
