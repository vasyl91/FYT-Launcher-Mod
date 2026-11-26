package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

/** The search field of the app drawer (F3): it tells every change of the text, and closing the drawer empties it. */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class AppSearchBarTest {

    @Test
    public void everyChangeOfTheTextIsToldAsItIsTyped() {
        AppSearchBar bar = new AppSearchBar(RuntimeEnvironment.getApplication());
        final List<String> told = new ArrayList<>();
        bar.setListener(told::add);
        bar.type("map");
        bar.type("maps");
        assertEquals(2, told.size());
        assertEquals("maps", told.get(1));
        assertEquals("maps", bar.query());
    }

    @Test
    public void clearingEmptiesTheFieldAndTellsTheEmptyText() {
        AppSearchBar bar = new AppSearchBar(RuntimeEnvironment.getApplication());
        final List<String> told = new ArrayList<>();
        bar.setListener(told::add);
        bar.type("cam");
        bar.clear();
        assertEquals("", bar.query());
        assertEquals("", told.get(told.size() - 1));
    }

    @Test
    public void theFieldDoesNotTakeTheFocusUntilItIsTouched() {
        AppSearchBar bar = new AppSearchBar(RuntimeEnvironment.getApplication());
        assertFalse("no focus, so no keyboard, before a touch", bar.findFocus() != null);
    }
}
