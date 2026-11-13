package com.android.launcher66;

import android.content.res.ColorStateList;
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
 * colour goes both ways: the colour chosen in the settings, or none ({@link #NONE}), which gives the view back the
 * colours it has by itself. Main thread only.
 */
public final class ViewTint {

    /** No tint: the view keeps its own colours. A chosen colour is opaque, so it is never this value. */
    public static final int NONE = 0;

    private ViewTint() {
    }

    private static ColorStateList list(int tint) {
        return tint == NONE ? null : ColorStateList.valueOf(tint);
    }

    /** The background of a button or any view: the colour, or its own colours. */
    public static void tintBackground(View view, int tint) {
        if (view == null) {
            return;
        }
        ViewCompat.setBackgroundTintList(view, list(tint));
        ViewCompat.setBackgroundTintMode(view, PorterDuff.Mode.SRC_IN);
    }

    /** The image of an ImageView: the colour, or its own colours. */
    public static void tintImage(ImageView view, int tint) {
        if (view == null) {
            return;
        }
        ImageViewCompat.setImageTintList(view, list(tint));
        ImageViewCompat.setImageTintMode(view, PorterDuff.Mode.SRC_IN);
    }

    /** The bar of a progress bar: the colour, or its own colours. */
    public static void tintProgress(ProgressBar view, int tint) {
        if (view == null) {
            return;
        }
        view.setProgressTintList(list(tint));
        view.setProgressTintMode(PorterDuff.Mode.SRC_IN);
    }

    /**
     * The text: the colour, or the colour it had the first time it was asked (remembered in the view's tag, so that
     * going back gives the colour the layout or the theme gave).
     */
    public static void tintText(TextView view, int tint) {
        if (view == null) {
            return;
        }
        Object remembered = view.getTag(R.id.view_tint_default_color);
        if (!(remembered instanceof Integer)) {
            remembered = view.getCurrentTextColor();
            view.setTag(R.id.view_tint_default_color, remembered);
        }
        view.setTextColor(tint == NONE ? (Integer) remembered : tint);
    }
}
