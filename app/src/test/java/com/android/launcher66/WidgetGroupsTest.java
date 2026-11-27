package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class WidgetGroupsTest {

    private static WidgetGroups.Entry widget(String pkg, String app, String label) {
        return new WidgetGroups.Entry(pkg, app, label, false, null);
    }

    private static WidgetGroups.Entry shortcut(String pkg, String app, String label) {
        return new WidgetGroups.Entry(pkg, app, label, true, null);
    }

    private static final List<WidgetGroups.Entry> ENTRIES = Arrays.asList(
            widget("com.zeta", "Zegar", "Zegar cyfrowy"),
            widget("com.maps", "Mapy", "Trasa"),
            shortcut("com.maps", "Mapy", "Dom"),
            shortcut("com.maps", "Mapy", "Praca"),
            widget("com.maps", "Mapy", "Korki"),
            widget("com.cal", "Ćwiczenia", "Plan"),
            widget("com.cal2", "Czas", "Minutnik"),
            shortcut("com.zeta", "Zegar", "Alarm"));

    private static List<String> apps(List<WidgetGroups.Group> groups) {
        List<String> names = new ArrayList<>();
        for (WidgetGroups.Group g : groups) {
            names.add(g.appLabel);
        }
        return names;
    }

    @Test
    void thereIsOneGroupForEachAppInTheAlphabeticalOrderOfTheLanguage() {
        List<WidgetGroups.Group> groups = WidgetGroups.group(ENTRIES, new Locale("pl"), "");
        // Czas, Ćwiczenia (the accent sorts after the letter, not at the end), Mapy, Zegar
        assertEquals(Arrays.asList("Czas", "Ćwiczenia", "Mapy", "Zegar"), apps(groups));
    }

    @Test
    void aGroupCountsItsWidgetsAndItsShortcutsAndSortsThemByName() {
        WidgetGroups.Group maps = WidgetGroups.group(ENTRIES, Locale.ENGLISH, "").get(2);
        assertEquals("Mapy", maps.appLabel);
        assertEquals(2, maps.widgetCount());
        assertEquals(2, maps.shortcutCount());
        assertEquals("Korki", maps.widgets.get(0).label);
        assertEquals("Trasa", maps.widgets.get(1).label);
        assertEquals("Dom", maps.shortcuts.get(0).label);
        assertEquals("Praca", maps.shortcuts.get(1).label);
    }

    @Test
    void theAppsNameKeepsAllItsEntries() {
        List<WidgetGroups.Group> groups = WidgetGroups.group(ENTRIES, Locale.ENGLISH, "mapy");
        assertEquals(1, groups.size());
        assertEquals(2, groups.get(0).widgetCount());
        assertEquals(2, groups.get(0).shortcutCount());
    }

    @Test
    void anEntrysNameKeepsOnlyTheMatchingEntries() {
        List<WidgetGroups.Group> groups = WidgetGroups.group(ENTRIES, Locale.ENGLISH, "praca");
        assertEquals(1, groups.size());
        assertEquals("Mapy", groups.get(0).appLabel);
        assertEquals(0, groups.get(0).widgetCount());
        assertEquals(1, groups.get(0).shortcutCount());
    }

    @Test
    void theSearchIgnoresCapitalsAndAccentsAndNothingFoundIsNoGroup() {
        assertEquals(Arrays.asList("Ćwiczenia"), apps(WidgetGroups.group(ENTRIES, Locale.ENGLISH, "CWICZ")));
        assertTrue(WidgetGroups.group(ENTRIES, Locale.ENGLISH, "nope").isEmpty());
        assertEquals(4, WidgetGroups.group(ENTRIES, Locale.ENGLISH, "   ").size());
    }

    @Test
    void theTitlesForTheScrollerAreTheAppNamesInTheOrderOfTheGroups() {
        List<WidgetGroups.Group> groups = WidgetGroups.group(ENTRIES, Locale.ENGLISH, "");
        assertEquals(apps(groups), WidgetGroups.titles(groups));
    }

    @Test
    void thePluralFormOfEachCountJoinedLeavingNoneOut() {
        assertEquals("1 widget, 3 shortcuts", WidgetGroups.counts(1, 3, "%d widget", "%d shortcuts", ", "));
        assertEquals("2 widgets", WidgetGroups.counts(2, 0, "%d widgets", "%d shortcuts", ", "));
        assertEquals("1 shortcut", WidgetGroups.counts(0, 1, "%d widgets", "%d shortcut", ", "));
    }

    @Test
    void aPreviewIsScaledDownToItsBoxNeverUp() {
        assertArrayEquals(new int[] {300, 200}, WidgetGroups.fitIn(300, 200, 700, 900));
        assertArrayEquals(new int[] {700, 350}, WidgetGroups.fitIn(1400, 700, 700, 900));
        assertArrayEquals(new int[] {450, 900}, WidgetGroups.fitIn(500, 1000, 700, 900));
    }

    @Test
    void theRowsAreNinetyPercentOfTheSearchFieldAndCentredUnderIt() {
        // a list 1080 wide under a field whose box is 1016 wide: rows 914 wide, 83 on each side
        assertEquals(83, WidgetGroups.sidePadding(1080, 1016, 0.9f));
        assertEquals(0, WidgetGroups.sidePadding(100, 200, 0.9f));
    }
}
