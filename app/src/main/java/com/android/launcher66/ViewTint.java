package com.android.launcher66;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/**
 * The one place that sets the colour of a view (R2). The colour is a property of the view, a tint, and not a colour
 * filter on its drawable: drawables from the resources share their state (a BitmapDrawable keeps its Paint with the
 * filter in the constant state, a selector keeps it in its children), so a filter put on one button's drawable showed
 * on every other drawable of that resource in the process, stayed after the setting was changed back, and went only
 * when the cache let the drawable go. A tint of the view is applied by the framework to every background or image
 * the view gets afterwards (setBackground, setBackgroundResource, setImageResource, with a mutated copy), so an
 * icon that changes with the state (favorite, play and pause, the digits of the clock) needs no further call. The
 * colour goes both ways: black, or none. Main thread only.
 */
public final class ViewTint {

    private ViewTint() {
    }

    /** The background of a button or any view: black, or its own colours. */
    public static void tintBackground(View view, boolean black) {
        if (view == null) {
            return;
        }
        ViewCompat.setBackgroundTintList(view, black ? ColorStateList.valueOf(Color.BLACK) : null);
        ViewCompat.setBackgroundTintMode(view, PorterDuff.Mode.SRC_IN);
    }

    /** The image of an ImageView: black, or its own colours. */
    public static void tintImage(ImageView view, boolean black) {
        if (view == null) {
            return;
        }
        ImageViewCompat.setImageTintList(view, black ? ColorStateList.valueOf(Color.BLACK) : null);
        ImageViewCompat.setImageTintMode(view, PorterDuff.Mode.SRC_IN);
    }

    /** The bar of a progress bar: black, or its own colours. */
    public static void tintProgress(ProgressBar view, boolean black) {
        if (view == null) {
            return;
        }
        view.setProgressTintList(black ? ColorStateList.valueOf(Color.BLACK) : null);
        view.setProgressTintMode(PorterDuff.Mode.SRC_IN);
    }

    /**
     * The text: black, or the colour it had the first time it was asked (remembered in the view's tag, so that
     * going back gives the colour the layout or the theme gave).
     */
    public static void tintText(TextView view, boolean black) {
        if (view == null) {
            return;
        }
        Object remembered = view.getTag(R.id.view_tint_default_color);
        if (!(remembered instanceof Integer)) {
            remembered = view.getCurrentTextColor();
            view.setTag(R.id.view_tint_default_color, remembered);
        }
        view.setTextColor(black ? Color.BLACK : (Integer) remembered);
    }
}
