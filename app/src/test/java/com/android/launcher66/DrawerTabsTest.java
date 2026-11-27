package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class DrawerTabsTest {

    private static final List<String> ALL = Arrays.asList("a", "b", "c", "d", "e");

    private static DrawerTabs model() {
        return new DrawerTabs();
    }

    // ---------------------------------------------------------------- names

    @Test
    void aNameOfBlanksAndInvisibleCharactersIsNoName() {
        assertTrue(DrawerTabs.isBlank(null));
        assertTrue(DrawerTabs.isBlank(""));
        assertTrue(DrawerTabs.isBlank("   \t "));
        assertTrue(DrawerTabs.isBlank("​‎  "));   // zero width space, a mark, no-break space, em space
        assertFalse(DrawerTabs.isBlank(" a "));
        assertFalse(DrawerTabs.isBlank("​|"));
    }

    @Test
    void aNameCanBeAnyTextAndIsCutToFiftyCharacters() {
        assertEquals("Mapy|nawigacja & \"co\"", DrawerTabs.cleanName("  Mapy|nawigacja & \"co\"  "));
        StringBuilder longName = new StringBuilder();
        for (int i = 0; i < 70; i++) {
            longName.append((char) ('a' + i % 26));
        }
        assertEquals(50, DrawerTabs.cleanName(longName.toString()).length());
        // a pair of surrogates at the cut is not cut in two
        String pairs = "x".repeat(49) + "😀😀";
        String cut = DrawerTabs.cleanName(pairs);
        assertTrue(cut.length() <= 50);
        assertFalse(Character.isHighSurrogate(cut.charAt(cut.length() - 1)));
    }

    @Test
    void theMainTabIsFirstAndTheDefaultNamesCountFromItsPlace() {
        DrawerTabs m = model();
        int one = m.add("", false);
        assertEquals(-1, one);
        int two = m.add("Maps", false);
        assertEquals(Arrays.asList(DrawerTabs.MAIN, two), m.ids());
        assertEquals("Apps", m.nameOf(DrawerTabs.MAIN, "Apps", "Tab%1$d"));
        assertEquals("Maps", m.nameOf(two, "Apps", "Tab%1$d"));
        m.rename(two, "   ");
        assertEquals("Maps", m.nameOf(two, "Apps", "Tab%1$d"));
        // a tab with no custom name is "Tab" and its place; the main tab is 1
        DrawerTabs parsed = DrawerTabs.parse("v1\tall\t5\t\ntab\t3\t0\t\n");
        assertEquals("Tab2", parsed.nameOf(3, "Apps", "Tab%1$d"));
    }

    @Test
    void aBlankNameAddsNothingAndChangesNothing() {
        DrawerTabs m = model();
        assertEquals(-1, m.add("  ​ ", true));
        assertEquals(1, m.count());
        int id = m.add("Radio", false);
        assertFalse(m.rename(id, "​"));
        assertTrue(m.rename(id, "Radio 2"));
        assertTrue(m.rename(DrawerTabs.MAIN, "Wszystko"));
        assertEquals("Wszystko", m.nameOf(DrawerTabs.MAIN, "Apps", "Tab%1$d"));
    }

    // ---------------------------------------------------------------- the list of tabs

    @Test
    void theMainTabCannotBeDeletedOrMovedAndNothingMovesBeforeIt() {
        DrawerTabs m = model();
        int x = m.add("X", false);
        int y = m.add("Y", false);
        int z = m.add("Z", false);
        assertFalse(m.delete(DrawerTabs.MAIN));
        assertFalse(m.move(0, 2));
        assertFalse(m.move(2, 0));
        assertEquals(Arrays.asList(DrawerTabs.MAIN, x, y, z), m.ids());
        assertTrue(m.move(3, 1));
        assertEquals(Arrays.asList(DrawerTabs.MAIN, z, x, y), m.ids());
        assertTrue(m.move(1, 3));
        assertEquals(Arrays.asList(DrawerTabs.MAIN, x, y, z), m.ids());
        assertTrue(m.delete(y));
        assertEquals(Arrays.asList(DrawerTabs.MAIN, x, z), m.ids());
    }

    @Test
    void thereIsAStripOnlyWithTwoTabsOrMore() {
        DrawerTabs m = model();
        assertFalse(m.hasStrip());
        m.add("A", false);
        assertTrue(m.hasStrip());
    }

    // ---------------------------------------------------------------- the main tab

    @Test
    void withAllEveryAppThatIsNotHiddenIsInTheMainTabAndTheFlagDoesNothing() {
        // the owner, 2026-11-27: "all" repeats every app everywhere, whatever the tabs keep
        DrawerTabs m = model();
        int t = m.add("T", false);
        m.setPackages(t, Arrays.asList("b", "c"));
        m.setHidden(Collections.singleton("e"));
        assertFalse(m.keepApplies());
        assertEquals(Arrays.asList("a", "b", "c", "d"), m.appsOf(DrawerTabs.MAIN, ALL));
        assertEquals(Arrays.asList("b", "c"), m.appsOf(t, ALL));
        m.setKeepInMain(t, true);
        assertEquals(Arrays.asList("a", "b", "c", "d"), m.appsOf(DrawerTabs.MAIN, ALL));
        assertTrue(m.tabsKeepingInMain().isEmpty(), "no line under the rule: the flag does nothing");
    }

    @Test
    void withExceptMainAndNoneTheMainTabShowsTheAppsInNoOtherTab() {
        for (DrawerTabs.Repeat rule : new DrawerTabs.Repeat[] {DrawerTabs.Repeat.EXCEPT_MAIN, DrawerTabs.Repeat.NONE}) {
            DrawerTabs m = model();
            m.setRepeat(rule);
            int t = m.add("T", false);
            m.setPackages(t, Arrays.asList("b", "c"));
            m.setHidden(Collections.singleton("e"));
            assertTrue(m.keepApplies(), rule.value());
            assertEquals(Arrays.asList("a", "d"), m.appsOf(DrawerTabs.MAIN, ALL), rule.value());
            assertEquals(Arrays.asList("b", "c"), m.appsOf(t, ALL), rule.value());
        }
    }

    @Test
    void withExceptMainAndNoneKeepInMainLeavesTheAppsOfThatTabInTheMainTabToo() {
        for (DrawerTabs.Repeat rule : new DrawerTabs.Repeat[] {DrawerTabs.Repeat.EXCEPT_MAIN, DrawerTabs.Repeat.NONE}) {
            DrawerTabs m = model();
            m.setRepeat(rule);
            int t = m.add("T", true);
            int u = m.add("U", false);
            m.setPackages(t, Arrays.asList("b", "c"));
            m.setPackages(u, Collections.singletonList("d"));
            assertEquals(Arrays.asList("a", "b", "c", "e"), m.appsOf(DrawerTabs.MAIN, ALL), rule.value());
            assertEquals(Collections.singletonList(t), m.tabsKeepingInMain(), rule.value());
            // and the flag is still set for when the rule changes to "all" and back
            m.setRepeat(DrawerTabs.Repeat.ALL);
            assertTrue(m.keepInMain(t));
            m.setRepeat(rule);
            assertEquals(Arrays.asList("a", "b", "c", "e"), m.appsOf(DrawerTabs.MAIN, ALL), rule.value());
        }
    }

    @Test
    void aHiddenAppIsInNoTabEvenIfItWasPicked() {
        DrawerTabs m = model();
        int t = m.add("T", true);
        m.setPackages(t, Arrays.asList("b", "c"));
        m.setHidden(Collections.singleton("b"));
        assertEquals(Collections.singletonList("c"), m.appsOf(t, ALL));
        assertEquals(Arrays.asList("a", "c", "d", "e"), m.appsOf(DrawerTabs.MAIN, ALL));
        m.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);
        assertEquals(Arrays.asList("a", "c", "d", "e"), m.appsOf(DrawerTabs.MAIN, ALL));
    }

    @Test
    void deletingATabGivesItsAppsBackToTheMainTab() {
        DrawerTabs m = model();
        m.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);
        int t = m.add("T", false);
        int u = m.add("U", false);
        m.setPackages(t, Arrays.asList("a", "b"));
        m.setPackages(u, Arrays.asList("b"));
        m.delete(t);
        // "a" is in no tab now; "b" is in "U" still
        assertEquals(Arrays.asList("a", "c", "d", "e"), m.appsOf(DrawerTabs.MAIN, ALL));
        m.delete(u);
        assertEquals(ALL, m.appsOf(DrawerTabs.MAIN, ALL));
    }

    // ---------------------------------------------------------------- the rule for several tabs

    @Test
    void withAllAnAppMayBeInSeveralTabsAndTheListOffersEveryApp() {
        DrawerTabs m = model();
        int t = m.add("T", false);
        int u = m.add("U", false);
        m.setPackages(t, Arrays.asList("a", "b"));
        m.setPackages(u, Arrays.asList("b", "c"));
        assertEquals(Arrays.asList("b"), m.appsOf(t, ALL).subList(1, 2));
        assertEquals(Arrays.asList("b", "c"), m.appsOf(u, ALL));
        assertEquals(ALL, m.candidates(u, ALL, false));
    }

    @Test
    void withNoneAnAppIsInOneTabAtMostAndTheListLeavesOutTheOthersApps() {
        DrawerTabs m = model();
        int t = m.add("T", false);
        int u = m.add("U", false);
        m.setRepeat(DrawerTabs.Repeat.NONE);
        m.setPackages(t, Arrays.asList("a", "b"));
        m.setPackages(u, Arrays.asList("b", "c"));
        assertEquals(new HashSet<>(Arrays.asList("c")), m.packagesOf(u));
        // the candidates of U: not "a" and "b" (T's), the rest; of T: its own and the free ones
        assertEquals(Arrays.asList("c", "d", "e"), m.candidates(u, ALL, false));
        assertEquals(Arrays.asList("a", "b", "d", "e"), m.candidates(t, ALL, false));
    }

    @Test
    void switchingToNoneKeepsAnAppInTheFirstTabThatHasIt() {
        DrawerTabs m = model();
        int t = m.add("T", false);
        int u = m.add("U", false);
        m.setPackages(t, Arrays.asList("a", "b"));
        m.setPackages(u, Arrays.asList("b", "c"));
        m.setRepeat(DrawerTabs.Repeat.NONE);
        assertEquals(new HashSet<>(Arrays.asList("a", "b")), m.packagesOf(t));
        assertEquals(new HashSet<>(Arrays.asList("c")), m.packagesOf(u));
    }

    @Test
    void hiddenAppsAreOfferedOnlyWhenAskedFor() {
        DrawerTabs m = model();
        int t = m.add("T", false);
        m.setHidden(Arrays.asList("c", "d"));
        assertEquals(Arrays.asList("a", "b", "e"), m.candidates(t, ALL, false));
        assertEquals(ALL, m.candidates(t, ALL, true));
    }

    // ---------------------------------------------------------------- uninstalled apps and the stored form

    @Test
    void anAppThatIsNoLongerInstalledLeavesTheModel() {
        DrawerTabs m = model();
        int t = m.add("T", false);
        m.setPackages(t, Arrays.asList("a", "gone"));
        m.setHidden(Arrays.asList("gone2", "b"));
        m.prune(new HashSet<>(ALL));
        assertEquals(new HashSet<>(Arrays.asList("a")), m.packagesOf(t));
        assertEquals(new HashSet<>(Arrays.asList("b")), m.hidden());
    }

    @Test
    void theModelComesBackFromItsStoredFormWithEverything() {
        DrawerTabs m = model();
        m.rename(DrawerTabs.MAIN, "Wszystko\tz tabem");
        int t = m.add("Mapy | \"nawigacja\"\nnowa linia", true);
        int u = m.add("Radio ąę", false);
        m.setPackages(t, Arrays.asList("com.a", "com.b"));
        m.setPackages(u, Arrays.asList("com.b"));
        m.setHidden(Arrays.asList("com.h"));
        m.setRepeat(DrawerTabs.Repeat.EXCEPT_MAIN);
        m.delete(m.add("Temp", false));
        DrawerTabs back = DrawerTabs.parse(m.serialize());
        assertEquals(m.ids(), back.ids());
        assertEquals(m.serialize(), back.serialize());
        assertEquals(DrawerTabs.Repeat.EXCEPT_MAIN, back.repeat());
        assertEquals("Wszystko\tz tabem", back.nameOf(DrawerTabs.MAIN, "Apps", "Tab%1$d"));
        assertEquals("Mapy | \"nawigacja\"\nnowa linia", back.nameOf(t, "Apps", "Tab%1$d"));
        assertTrue(back.keepInMain(t));
        assertEquals(m.packagesOf(t), back.packagesOf(t));
        assertEquals(m.hidden(), back.hidden());
        // an id is not used again after a tab was deleted
        int next = back.add("Nowa", false);
        assertNotEquals(u, next);
        assertTrue(next > u + 1);
    }

    @Test
    void aDamagedOrEmptyStoredStringIsTheMainTabAlone() {
        assertEquals(1, DrawerTabs.parse(null).count());
        assertEquals(1, DrawerTabs.parse("").count());
        assertEquals(1, DrawerTabs.parse("garbage\nmore garbage\t\t").count());
        assertEquals(1, DrawerTabs.parse("tab\tx\t1\tname\n").count());
        // a tab with the main tab's id or the id of another is left out
        assertEquals(2, DrawerTabs.parse("v1\tall\t3\t\ntab\t0\t0\tx\ntab\t2\t0\tA\ntab\t2\t0\tB\n").count());
    }
}
