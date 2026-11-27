package com.android.launcher66.settings;

import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * The frame of a list of apps (dialog_piplist, dialog_bootlist, dialog_applist, dialog_cachelist): the window fills the
 * screen and the frame, its first child, takes the share {@link SettingsDialogSize} gives a list of apps, so that the
 * lists are as large as the background selector and the colour picker.
 */
final class DialogFrames {

    private DialogFrames() {
    }

    /** Sizes the frame of a list of apps for this orientation. */
    static void fitAppList(View root, boolean landscape) {
        if (!(root instanceof ConstraintLayout) || ((ViewGroup) root).getChildCount() == 0) {
            return;
        }
        View frame = ((ViewGroup) root).getChildAt(0);
        if (!(frame.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
            return;
        }
        float[] share = SettingsDialogSize.shares(SettingsDialogSize.Kind.APP_LIST, landscape);
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) frame.getLayoutParams();
        lp.matchConstraintPercentWidth = share[0];
        lp.matchConstraintPercentHeight = share[1];
        frame.setLayoutParams(lp);
    }
}
