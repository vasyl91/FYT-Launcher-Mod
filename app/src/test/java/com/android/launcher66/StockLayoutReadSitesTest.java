package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.BarLayouts;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.WorkspaceGrids;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The places where the launcher reads the creator's settings (D-85): with "Stock layout" a stored bar colour, a grid
 * of 12 x 8, a bar at the top and a chosen background do not apply, and with the creator on they do.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class StockLayoutReadSitesTest {

    private static SharedPreferences stored(boolean creatorOn) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear()
                .putBoolean(Keys.USER_LAYOUT, creatorOn)
                .putInt(Keys.BAR_TINT_COLOR, 0xffff0000)
                .putInt(Keys.WIDGETS_TINT_COLOR, 0xff00ff00)
                .putInt(Keys.WORKSPACE_GRID_LONG, 12)
                .putInt(Keys.WORKSPACE_GRID_SHORT, 8)
                .putBoolean(Keys.HORIZONTAL_BAR_TOP, true)
                .putBoolean(Keys.VERTICAL_BAR_RIGHT, true)
                .putString(Keys.WIDGETS_SELECTED_BACKGROUND, BackgroundChoice.CUSTOM)
                .putInt(BackgroundChoice.colorKey(Keys.WIDGETS_SELECTED_BACKGROUND), 0xff123456)
                .commit();
        return prefs;
    }

    @Test
    public void theStockLayoutReadsTheDefaultsAtEveryPlaceOfTheLauncher() {
        SharedPreferences prefs = stored(false);
        assertEquals(ViewTint.NONE, WidgetStyler.barTint(prefs));
        assertEquals(ViewTint.NONE, WidgetStyler.widgetsTint(prefs));
        assertEquals(WorkspaceGrid.DEFAULT_LONG, WorkspaceGrids.longCells(prefs));
        assertEquals(WorkspaceGrid.DEFAULT_SHORT, WorkspaceGrids.shortCells(prefs));
        assertEquals(WorkspaceGrid.columns(false, 10, 6), WorkspaceGrids.columns(prefs, false));
        BarLayout sides = BarLayouts.sides(prefs, true);
        assertFalse("the bar is at the bottom", sides.top);
        assertFalse("the vertical bar is on the left", sides.right);
        BackgroundChoice choice = BarBackground.choice(prefs, Keys.WIDGETS_SELECTED_BACKGROUND, BarBackground.WIDGETS_DEFAULT);
        assertEquals(BackgroundChoice.Kind.PICTURE, choice.kind);
        assertEquals(BarBackground.WIDGETS_DEFAULT, choice.picture);
    }

    @Test
    public void withTheCreatorOnTheStoredValuesApplyAtTheSamePlaces() {
        SharedPreferences prefs = stored(true);
        assertEquals(0xffff0000, WidgetStyler.barTint(prefs));
        assertEquals(0xff00ff00, WidgetStyler.widgetsTint(prefs));
        assertEquals(12, WorkspaceGrids.longCells(prefs));
        assertEquals(8, WorkspaceGrids.shortCells(prefs));
        BarLayout sides = BarLayouts.sides(prefs, true);
        assertTrue(sides.top);
        assertTrue(sides.right);
        BackgroundChoice choice = BarBackground.choice(prefs, Keys.WIDGETS_SELECTED_BACKGROUND, BarBackground.WIDGETS_DEFAULT);
        assertEquals(BackgroundChoice.Kind.CUSTOM, choice.kind);
        assertEquals(0xff123456, choice.color);
    }
}
