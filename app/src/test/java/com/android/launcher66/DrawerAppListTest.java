package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/** The lists "Select apps" and "Hide apps": what they offer, and what a tick does (the rules of {@link DrawerAppList}). */
class DrawerAppListTest {

    private static List<DrawerAppList.App> apps(String... packages) {
        List<DrawerAppList.App> apps = new ArrayList<>();
        for (String pkg : packages) {
            apps.add(new DrawerAppList.App(pkg, pkg.toUpperCase()));
        }
        return apps;
    }

    private static List<String> names(DrawerAppList list) {
        List<String> names = new ArrayList<>();
        for (DrawerAppList.App app : list.rows()) {
            names.add(app.pkg);
        }
        return names;
    }

    @Test
    void theListOfATabOffersTheAppsThatAreNotHiddenInTheDrawersOrder() {
        DrawerTabs model = new DrawerTabs();
        int tab = model.add("Tools", false);
        model.setHidden(Arrays.asList("b"));
        DrawerAppList list = new DrawerAppList(model, tab, apps("a", "b", "c"));
        assertEquals(Arrays.asList("a", "c"), names(list));
        list.setShowHidden(true);
        assertEquals(Arrays.asList("a", "b", "c"), names(list));
    }

    @Test
    void aTickPutsAnAppInTheTabAndAnotherTickTakesItOut() {
        DrawerTabs model = new DrawerTabs();
        int tab = model.add("Tools", false);
        DrawerAppList list = new DrawerAppList(model, tab, apps("a", "b", "c"));
        assertFalse(list.isChecked("b"));
        list.toggle("b");
        assertTrue(list.isChecked("b"));
        assertTrue(model.packagesOf(tab).contains("b"));
        list.toggle("b");
        assertFalse(list.isChecked("b"));
        assertTrue(model.packagesOf(tab).isEmpty());
    }

    @Test
    void anAppPickedForATabStaysPickedWhileTheListLeavesItOut() {
        DrawerTabs model = new DrawerTabs();
        int tab = model.add("Tools", false);
        model.setPackages(tab, Arrays.asList("b"));
        model.setHidden(Arrays.asList("b"));
        DrawerAppList list = new DrawerAppList(model, tab, apps("a", "b", "c"));
        assertEquals(Arrays.asList("a", "c"), names(list));
        list.toggle("a");
        assertTrue(model.packagesOf(tab).contains("b"), "the hidden app that the list does not show stays in the tab");
        assertTrue(model.packagesOf(tab).contains("a"));
    }

    @Test
    void withTheRuleNoneTheListLeavesOutTheAppsOfAnotherTab() {
        DrawerTabs model = new DrawerTabs();
        int first = model.add("One", false);
        int second = model.add("Two", false);
        model.setRepeat(DrawerTabs.Repeat.NONE);
        model.setPackages(first, Arrays.asList("a"));
        DrawerAppList list = new DrawerAppList(model, second, apps("a", "b", "c"));
        assertEquals(Arrays.asList("b", "c"), names(list));
        DrawerAppList own = new DrawerAppList(model, first, apps("a", "b", "c"));
        assertEquals(Arrays.asList("a", "b", "c"), names(own), "the tab's own apps are on its list");
    }

    @Test
    void theListOfTheHiddenAppsOffersTheOnesThatAreNotHiddenAndWithTheOptionTheHiddenOnesToo() {
        DrawerTabs model = new DrawerTabs();
        model.setHidden(Arrays.asList("c"));
        DrawerAppList list = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b", "c"));
        assertTrue(list.isHiddenList());
        assertEquals(Arrays.asList("a", "b"), names(list));
        list.setShowHidden(true);
        assertEquals(Arrays.asList("a", "b", "c"), names(list));
        assertTrue(list.isChecked("c"));
        assertFalse(list.isChecked("a"));
    }

    @Test
    void anAppTickedWhileTheHiddenOnesAreNotShownStaysOnTheList() {
        DrawerTabs model = new DrawerTabs();
        DrawerAppList list = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b", "c"));
        list.toggle("b");
        assertTrue(model.isHidden("b"));
        assertEquals(Arrays.asList("a", "b", "c"), names(list), "the ticked app is not taken from under the finger");
        list.toggle("b");
        assertFalse(model.isHidden("b"));
        assertEquals(Arrays.asList("a", "b", "c"), names(list), "and it stays when it is unticked again");
    }

    @Test
    void theAppKeptOnTheListGoesWhenTheOptionIsTurnedOnAndOff() {
        DrawerTabs model = new DrawerTabs();
        DrawerAppList list = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b"));
        list.toggle("a");
        list.setShowHidden(true);
        assertEquals(Arrays.asList("a", "b"), names(list));
        list.setShowHidden(false);
        assertEquals(Arrays.asList("b"), names(list), "the hidden app is no longer shown");
    }

    @Test
    void aScreenOpenedAgainStartsWithoutTheKeptApps() {
        DrawerTabs model = new DrawerTabs();
        DrawerAppList list = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b"));
        list.toggle("a");
        DrawerAppList again = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b"));
        assertEquals(Arrays.asList("b"), names(again));
    }

    @Test
    void aHiddenAppIsInNoTabOfTheDrawer() {
        DrawerTabs model = new DrawerTabs();
        int tab = model.add("Tools", false);
        DrawerAppList picks = new DrawerAppList(model, tab, apps("a", "b"));
        picks.toggle("a");
        DrawerAppList hide = new DrawerAppList(model, DrawerAppList.HIDDEN, apps("a", "b"));
        hide.toggle("a");
        assertEquals(Arrays.asList("b"), model.appsOf(DrawerTabs.MAIN, Arrays.asList("a", "b")));
        assertTrue(model.appsOf(tab, Arrays.asList("a", "b")).isEmpty());
    }
}
