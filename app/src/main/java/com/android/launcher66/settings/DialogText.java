package com.android.launcher66.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * The size of the text of the settings' dialogs: that of a settings row's title.
 *
 * <p>The rule (the owner, 2026-11-27: the text of the dialogs was still too small and did not go with the settings): a
 * dialog's text is as large as the title of a row of the settings, the theme's {@code android:textAppearanceListItem} in
 * the dialog's own context, so it follows the font scale of the settings and "Settings text size" (SettingsTextScale) as
 * the rows do; a dialog's title is a quarter larger, as an AlertDialog's title is to its text (20 to 16 sp). The size the
 * dialogs had (SettingsActivity.dialogTextView: 16 sp times the root of the screen's width over 2000, about 12 sp on a
 * phone) is gone.
 */
public final class DialogText {

    /** An AlertDialog's title to its text, as androidx's styles have them (20 sp to 16 sp). */
    static final float TITLE_FACTOR = 1.25f;

    private DialogText() {
    }

    /** The size in pixels of a settings row's title in this context. */
    public static float bodyPx(Context context) {
        TypedValue value = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.textAppearanceListItem, value, true)
                && value.resourceId != 0) {
            TypedArray style = context.obtainStyledAttributes(value.resourceId, new int[] {android.R.attr.textSize});
            try {
                float px = style.getDimension(0, 0f);
                if (px > 0f) {
                    return px;
                }
            } finally {
                style.recycle();
            }
        }
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, context.getResources().getDisplayMetrics());
    }

    /** The size in pixels of a dialog's title in this context. */
    public static float titlePx(Context context) {
        return bodyPx(context) * TITLE_FACTOR;
    }

    /** A text of a dialog at the size of a settings row's title. */
    public static void body(TextView text) {
        if (text != null) {
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, bodyPx(text.getContext()));
        }
    }

    /** A dialog's title. */
    public static void title(TextView text) {
        if (text != null) {
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, titlePx(text.getContext()));
        }
    }
}
