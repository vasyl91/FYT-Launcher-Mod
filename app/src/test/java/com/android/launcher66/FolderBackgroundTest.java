package com.android.launcher66;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The open folder's background (D4): the picture of the layout until one is chosen, the chosen picture or colour with the
 * creator on, and the layout's picture again with the stock layout.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class FolderBackgroundTest {

    private static SharedPreferences prefs(boolean creatorOn) {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, creatorOn).commit();
        return prefs;
    }

    @Test
    public void withNothingChosenTheFolderKeepsItsPicture() {
        SharedPreferences prefs = prefs(true);
        assertFalse(BarBackground.foldersOwn(prefs));
        assertNotNull(BarBackground.folders(RuntimeEnvironment.getApplication(), prefs));
    }

    @Test
    public void aChosenPictureOrColourIsTheFoldersOwnWithTheCreatorOn() {
        SharedPreferences prefs = prefs(true);
        prefs.edit().putString(Keys.FOLDERS_SELECTED_BACKGROUND, "bg_custom").commit();
        assertTrue(BarBackground.foldersOwn(prefs));
        prefs.edit().putString(Keys.FOLDERS_SELECTED_BACKGROUND, BackgroundChoice.CUSTOM)
                .putInt(Keys.FOLDERS_CUSTOM_BACKGROUND_COLOR, 0xcc223344).commit();
        assertTrue(BarBackground.foldersOwn(prefs));
        Drawable drawable = BarBackground.folders(RuntimeEnvironment.getApplication(), prefs);
        assertTrue("the user's colour is a rounded colour", drawable instanceof RoundedColorDrawable);
    }

    @Test
    public void theStockLayoutHasTheLayoutsPictureWhateverIsChosen() {
        SharedPreferences prefs = prefs(false);
        prefs.edit().putString(Keys.FOLDERS_SELECTED_BACKGROUND, "bg_custom").commit();
        assertFalse(BarBackground.foldersOwn(prefs));
    }
}
