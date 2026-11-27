package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/** The frames of the lists of apps take the size of the background selector and the colour picker (SettingsDialogSize). */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class DialogFramesViewTest {

    private static ConstraintLayout.LayoutParams frame(int layout, boolean landscape) {
        View root = LayoutInflater.from(RuntimeEnvironment.getApplication()).inflate(layout, null, false);
        DialogFrames.fitAppList(root, landscape);
        return (ConstraintLayout.LayoutParams) ((ViewGroup) root).getChildAt(0).getLayoutParams();
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land")
    public void inLandscapeEveryListIsAsLargeAsTheOtherDialogs() {
        for (int layout : new int[] {R.layout.dialog_piplist, R.layout.dialog_bootlist, R.layout.dialog_applist,
                R.layout.dialog_cachelist}) {
            ConstraintLayout.LayoutParams lp = frame(layout, true);
            assertEquals(0.7f, lp.matchConstraintPercentWidth, 0.0001f);
            assertEquals(0.9f, lp.matchConstraintPercentHeight, 0.0001f);
        }
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port")
    public void inPortraitEveryListIsAsWideAsTheBackgroundSelectorAndAsHighAsBefore() {
        ConstraintLayout.LayoutParams lp = frame(R.layout.dialog_piplist, false);
        assertEquals(0.8f, lp.matchConstraintPercentWidth, 0.0001f);
        assertEquals(0.9364f, lp.matchConstraintPercentHeight, 0.0001f);
    }
}
