package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;

import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

/**
 * "Choose background for …" is sized for the orientation it is shown in, also after a turn of the screen, and the
 * wallpaper behind its tiles keeps its proportions (the owner, 2026-11-21). The screen here is 2000 x 1200 px in
 * landscape and 1200 x 2000 px in portrait.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class BackgroundSelectorSizeViewTest {

    private static void idle() {
        shadowOf(Looper.getMainLooper()).idle();
    }

    private static BackgroundSelectorDialog selector(ActivityController<SettingsActivity> controller) {
        Fragment f = controller.get().getSupportFragmentManager().findFragmentByTag("widgets");
        return (BackgroundSelectorDialog) f;
    }

    private static WindowManager.LayoutParams layout(BackgroundSelectorDialog selector) {
        return selector.requireDialog().getWindow().getAttributes();
    }

    @Test
    public void inLandscapeTheDialogIsWideAndAfterATurnItFitsPortrait() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        BackgroundSelectorDialog dialog = BackgroundSelectorDialog.create("widgets", "bg_custom");
        // A phone's wallpaper: portrait, as it is behind the landscape dialog
        dialog.setPreloadedBackground(Bitmap.createBitmap(108, 234, Bitmap.Config.ARGB_8888));
        controller.get().getSupportFragmentManager().beginTransaction().add(dialog, "widgets").commitNow();
        idle();

        WindowManager.LayoutParams landscape = layout(dialog);
        assertEquals("0.7 of the window's width", 1400, landscape.width);
        assertEquals("0.9 of its height, as the colour picker and the lists of apps", 1080, landscape.height);
        assertTrue("wider than high", landscape.width > landscape.height);

        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();

        BackgroundSelectorDialog again = selector(controller);
        assertNotNull("the selector comes back by itself", again);
        WindowManager.LayoutParams portrait = layout(again);
        assertEquals("0.8 of the window's width", 960, portrait.width);
        assertEquals(1600, portrait.height);

        controller.pause().stop().destroy();
    }

    @Test
    public void theWallpaperBehindTheTilesKeepsItsProportions() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        idle();
        BackgroundSelectorDialog dialog = BackgroundSelectorDialog.create("widgets", "bg_custom");
        dialog.setPreloadedBackground(Bitmap.createBitmap(108, 234, Bitmap.Config.ARGB_8888));
        controller.get().getSupportFragmentManager().beginTransaction().add(dialog, "widgets").commitNow();
        idle();

        Drawable backdrop = findCenterCrop(dialog.requireDialog().getWindow().getDecorView());
        assertNotNull("the wallpaper as a center-crop backdrop", backdrop);
        // Whatever size the view has, the part of the wallpaper drawn has its proportions
        for (int[] size : new int[][] {{1400, 960}, {300, 900}, {960, 1600}}) {
            backdrop.setBounds(0, 0, size[0], size[1]);
            Rect part = ((CenterCropDrawable) backdrop).sourceRect();
            double partRatio = (double) part.width() / part.height();
            double viewRatio = (double) size[0] / size[1];
            assertEquals("view " + size[0] + " x " + size[1], viewRatio, partRatio, 0.02);
        }

        controller.pause().stop().destroy();
    }

    private static Drawable findCenterCrop(View view) {
        if (view.getBackground() instanceof CenterCropDrawable) {
            return view.getBackground();
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup group = (android.view.ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                Drawable found = findCenterCrop(group.getChildAt(i));
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
