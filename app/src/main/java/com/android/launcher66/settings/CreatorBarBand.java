package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.launcher66.BarBackground;
import com.android.launcher66.CreatorBars;
import com.android.launcher66.R;

/** The vertical bar of a page in a layout creator: a band beside the canvas, in the background chosen for the bar. */
final class CreatorBarBand {

    private CreatorBarBand() {
    }

    /**
     * The vertical bar of this page, as a band on its side beside the canvas, in the background chosen for it. It
     * is added under the controls (before them), so that the horizontal bar of the creator is always drawn over
     * it. The canvas is then the launcher's area beside the bar (x = 0 is the bar's inner edge, as on the home
     * screen), and nothing can be put into the band.
     */
    static void add(Context context, SharedPreferences sharedPrefs, ConstraintLayout root, View canvasArea,
                    CreatorBars bars, float share, int page) {
        if (canvasArea == null) {
            return;
        }
        final boolean right = bars.arrowRotation == 180f;
        View band = new View(context);
        band.setId(View.generateViewId());
        // As on the home screen: a picture or the user's own colour (BarBackground)
        band.setBackground(BarBackground.vertical(context, sharedPrefs));
        ConstraintLayout.LayoutParams bandParams = new ConstraintLayout.LayoutParams(0, 0);
        bandParams.matchConstraintDefaultWidth = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT;
        bandParams.matchConstraintPercentWidth = share;
        // The whole height of the creator: where the horizontal bar and the corner are taken, the controls (or the
        // button) are drawn over the band, and where the corner is free the band is seen all the way
        bandParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        bandParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        if (right) {
            bandParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        } else {
            bandParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        }
        // Under the controls: the horizontal bar is drawn over the band where they meet
        View controls = root.findViewById(R.id.creator_bar);
        int index = controls != null && controls.getParent() == root ? root.indexOfChild(controls) : -1;
        root.addView(band, index, bandParams);
        ViewGroup.LayoutParams raw = canvasArea.getLayoutParams();
        if (raw instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams area = (ConstraintLayout.LayoutParams) raw;
            area.width = 0;
            area.leftToLeft = right ? ConstraintLayout.LayoutParams.PARENT_ID : ConstraintLayout.LayoutParams.UNSET;
            area.leftToRight = right ? ConstraintLayout.LayoutParams.UNSET : band.getId();
            area.rightToRight = right ? ConstraintLayout.LayoutParams.UNSET : ConstraintLayout.LayoutParams.PARENT_ID;
            area.rightToLeft = right ? band.getId() : ConstraintLayout.LayoutParams.UNSET;
            canvasArea.setLayoutParams(area);
        }
        Log.d("CreatorBarBand", "Vertical bar on page " + (page + 1) + ": " + Math.round(share * 1000) / 10f + " % on the "
                + (right ? "right" : "left") + (bars.verticalFullHeight ? ", whole height" : ""));
    }
}
