package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Collections;

/** The drawer's tabs in the preferences: a tick on a list of apps is stored, "Stock layout" shows no tabs. */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class DrawerTabsStoreTest {

    private static SharedPreferences prefs(boolean creator) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, creator).commit();
        return prefs;
    }

    @Test
    public void aTickOnAListOfAppsIsStored() {
        SharedPreferences prefs = prefs(true);
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        int tab = model.add("Tools", false);
        DrawerAppList list = new DrawerAppList(model, tab,
                Arrays.asList(new DrawerAppList.App("a", "A"), new DrawerAppList.App("b", "B")));
        list.toggle("b");
        DrawerTabsStore.save(prefs, model);

        DrawerTabs again = DrawerTabsStore.load(prefs, null);
        assertEquals(Collections.singleton("b"), again.packagesOf(tab));
        assertEquals("Tools", again.nameOf(tab, "Apps", "Tab%1$d"));
    }

    @Test
    public void theHiddenAppsAreStoredToo() {
        SharedPreferences prefs = prefs(true);
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        new DrawerAppList(model, DrawerAppList.HIDDEN, Arrays.asList(new DrawerAppList.App("a", "A"))).toggle("a");
        DrawerTabsStore.save(prefs, model);
        assertTrue(DrawerTabsStore.load(prefs, null).isHidden("a"));
    }

    @Test
    public void theStockLayoutHasOnlyTheMainTabAndHidesNothingAndTheTabsComeBackWithTheCreator() {
        SharedPreferences prefs = prefs(true);
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        model.add("Tools", false);
        model.setHidden(Arrays.asList("a"));
        DrawerTabsStore.save(prefs, model);

        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        DrawerTabs stock = DrawerTabsStore.load(prefs, null);
        assertEquals(1, stock.count());
        assertFalse(stock.isHidden("a"));

        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        DrawerTabs back = DrawerTabsStore.load(prefs, null);
        assertEquals(2, back.count());
        assertTrue(back.isHidden("a"));
    }

    @Test
    public void anAppThatIsNotInstalledAnyMoreLeavesTheModelAtTheNextRead() {
        SharedPreferences prefs = prefs(true);
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        int tab = model.add("Tools", false);
        model.setPackages(tab, Arrays.asList("a", "gone"));
        model.setHidden(Arrays.asList("gone"));
        DrawerTabsStore.save(prefs, model);

        DrawerTabs read = DrawerTabsStore.load(prefs, Arrays.asList("a", "b"));
        assertEquals(Collections.singleton("a"), read.packagesOf(tab));
        assertFalse(read.isHidden("gone"));
    }

    @Test
    public void aListOfAppsThatIsNotLoadedYetForgetsNothing() {
        SharedPreferences prefs = prefs(true);
        DrawerTabs model = DrawerTabsStore.load(prefs, null);
        int tab = model.add("Tools", false);
        model.setPackages(tab, Arrays.asList("a"));
        DrawerTabsStore.save(prefs, model);
        assertEquals(Collections.singleton("a"),
                DrawerTabsStore.load(prefs, Collections.<String>emptyList()).packagesOf(tab));
    }

    @Test
    public void aLongNameIsCutToFiftyCharacters() {
        DrawerTabs model = new DrawerTabs();
        StringBuilder pasted = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            pasted.append('x');
        }
        int tab = model.add(pasted.toString(), false);
        assertEquals(DrawerTabs.MAX_NAME, model.nameOf(tab, "Apps", "Tab%1$d").length());
    }
}
