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
 * <p>The text is one line, always. A button that has a width of its own (the four "Restart" buttons share a
 * row) had a label too long for it in some languages: the label broke into two lines and the second was cut
 * by the button's height. Such a label is made smaller until it fits the width too; it is never broken and
 * never cut.
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

    /**
     * The text size that fits the height and, for a button with a width of its own, the width.
     *
     * @param roomPx     the width the text may take, or 0 for a button as wide as its text
     * @param widthRatio the width of the button's text per pixel of text size
     */
    static float textPx(float wantedPx, int heightPx, float lineRatio, int roomPx, float widthRatio) {
        float px = textPx(wantedPx, heightPx, lineRatio);
        if (roomPx > 0 && widthRatio > 0f) {
            px = Math.max(1f, Math.min(px, roomPx / widthRatio));
        }
        return px;
    }

    /** The room at each side of the text of a button with a width of its own, as a share of its height. */
    static final float SIDE_SHARE = 0.18f;

    /** Sets the text size and takes away what stood between the text and the button's height. */
    static void apply(TextView button, int heightPx, float wantedPx) {
        apply(button, heightPx, wantedPx, 0);
    }

    /**
     * @param widthPx the width the button is given, or 0 for a button as wide as its text
     */
    static void apply(TextView button, int heightPx, float wantedPx, int widthPx) {
        if (button == null) {
            return;
        }
        Paint paint = button.getPaint();
        Paint.FontMetrics metrics = paint.getFontMetrics();
        float size = paint.getTextSize();
        float lineRatio = size > 0f ? (metrics.descent - metrics.ascent) / size : 0f;
        CharSequence text = button.getText();
        float widthRatio = size > 0f && text != null ? paint.measureText(text, 0, text.length()) / size : 0f;
        int side = widthPx > 0 ? Math.round(heightPx * SIDE_SHARE) : -1;
        int room = widthPx > 0 ? Math.max(1, widthPx - 2 * side) : 0;
        button.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx(wantedPx, heightPx, lineRatio, room, widthRatio));
        button.setIncludeFontPadding(false);
        button.setMinHeight(0);
        button.setMinimumHeight(0);
        button.setMinWidth(0);
        button.setMinimumWidth(0);
        // One line, whole: never broken into a second line that the height would cut, never ended in dots
        button.setSingleLine(true);
        button.setEllipsize(null);
        if (side >= 0) {
            button.setPadding(side, 0, side, 0);
        } else {
            button.setPadding(button.getPaddingLeft(), 0, button.getPaddingRight(), 0);
        }
        button.setGravity(Gravity.CENTER);
    }
}
