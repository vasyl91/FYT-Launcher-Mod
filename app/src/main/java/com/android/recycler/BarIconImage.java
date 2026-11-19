package com.android.recycler;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Puts an app's icon into a row of the bars' lists. The icons are loaded off the main thread and the rows are
 * bound before they arrive: such a row shows nothing until its icon is there (the list binds it again then).
 * ImageView.setImageBitmap(null) made a BitmapDrawable of no bitmap for that, which the system logs every time
 * ("BitmapDrawable created with null Bitmap", 14 times at the A55's start, 2026-11-19); no drawable shows the
 * same nothing.
 */
final class BarIconImage {

    private BarIconImage() {
    }

    static void show(ImageView view, Bitmap icon) {
        if (icon == null) {
            view.setImageDrawable(null);
        } else {
            view.setImageBitmap(icon);
        }
    }
}
