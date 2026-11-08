package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.CreatorBars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CreatorPageTest {

    /** A settings snapshot with nothing set: every switch off, every element on page 1. */
    private static final class Fake implements CreatorPage.Snapshot {
        final Map<String, Boolean> bools = new HashMap<>();
        final Map<String, Integer> screens = new HashMap<>();

        Fake with(String key, boolean value) {
            bools.put(key, value);
            return this;
        }

        Fake screen(String key, int page) {
            screens.put(key, page);
            return this;
        }

        @Override
        public boolean bool(String key) {
            return Boolean.TRUE.equals(bools.get(key));
        }

        @Override
        public boolean boolOr(String key, boolean defaultValue) {
            return bools.containsKey(key) ? bools.get(key) : defaultValue;
        }

        @Override
        public int screenOf(String screenKey) {
            return screens.containsKey(screenKey) ? screens.get(screenKey) : 1;
        }
    }

    private static Fake bars(boolean top, boolean autoHide, boolean verticalBar, boolean verticalRight,
                             boolean handleRight, boolean everyPage, boolean verticalEveryPage) {
        return new Fake().with(Keys.USER_LAYOUT, true).with(Keys.HORIZONTAL_BAR_TOP, top)
                .with(Keys.AUTO_HIDE_HORIZONTAL_BAR, autoHide).with(Keys.VERTICAL_BAR, verticalBar)
                .with(Keys.VERTICAL_BAR_RIGHT, verticalRight).with(Keys.EDGE_HANDLE_RIGHT, handleRight)
                .with(Keys.HORIZONTAL_BAR_EVERY_PAGE, everyPage).with(Keys.VERTICAL_BAR_EVERY_PAGE, verticalEveryPage);
    }

    @Test
    void theElementsOfAPageAreTheOnesSetToIt() {
        Fake prefs = new Fake().with(Keys.DISPLAY_PIP, true).with(Keys.PIP_FIRST, true).with(Keys.PIP_THIRD, true)
                .screen(Keys.PIP_FIRST_SCREEN, 1).screen(Keys.PIP_THIRD_SCREEN, 3).screen(Keys.DATE_SCREEN, 3)
                .screen(Keys.MUSIC_SCREEN, 1).screen(Keys.RADIO_SCREEN, 2).screen(Keys.STATS_SCREEN, 3)
                .with(Keys.USER_RADIO, false);
        assertEquals(Arrays.asList("pipFirst", "music"), CreatorPage.of(0, prefs).elements);
        // the radio is off: nothing on page 2, the date, the stats and the third PiP are on page 3 (index 2)
        assertEquals(Arrays.asList(), CreatorPage.of(1, prefs).elements);
        assertEquals(Arrays.asList("pipThird", "date", "stats"), CreatorPage.of(2, prefs).elements);
    }

    @Test
    void theDualPipReplacesTheTwoSinglesAndTheDefaultsAreOn() {
        Fake prefs = new Fake().with(Keys.DISPLAY_PIP, true).with(Keys.PIP_DUAL, true).with(Keys.PIP_FIRST, true);
        // the first PiP is on as well: neither is shown (the dual is for when the singles are off, a single when it is not dual)
        assertEquals(Arrays.asList("date", "music", "radio", "stats"), CreatorPage.of(0, prefs).elements);
        Fake dual = new Fake().with(Keys.DISPLAY_PIP, true).with(Keys.PIP_DUAL, true);
        assertEquals("pipDual", CreatorPage.of(0, dual).elements.get(0));
        assertTrue(CreatorPage.of(0, dual).firstScreen);
        assertFalse(CreatorPage.of(1, dual).firstScreen);
    }

    @Test
    void theToggleRuleIsTheFirstScreensOnPageZeroAndTheOthersElsewhere() {
        // without auto-hide the first page's strip cannot be hidden; the other pages' can unless the bar is on them
        assertFalse(CreatorPage.of(0, bars(false, false, false, false, false, false, false)).canToggle);
        assertTrue(CreatorPage.of(0, bars(false, true, false, false, false, false, false)).canToggle);
        assertTrue(CreatorPage.of(2, bars(false, false, false, false, false, false, false)).canToggle);
        assertFalse(CreatorPage.of(2, bars(false, false, false, false, false, true, false)).canToggle);
        assertTrue(CreatorPage.of(2, bars(false, true, false, false, false, true, false)).canToggle);
    }

    @Test
    void theBarsOfAPageFollowTheHomeScreen() {
        for (boolean top : new boolean[] {false, true}) {
            for (boolean autoHide : new boolean[] {false, true}) {
                for (boolean verticalRight : new boolean[] {false, true}) {
                    for (boolean handleRight : new boolean[] {false, true}) {
                        for (boolean everyPage : new boolean[] {false, true}) {
                            for (boolean verticalEvery : new boolean[] {false, true}) {
                                Fake prefs = bars(top, autoHide, true, verticalRight, handleRight, everyPage, verticalEvery);
                                CreatorPage zero = CreatorPage.of(0, prefs);
                                CreatorPage two = CreatorPage.of(2, prefs);
                                // the first page always has both bars
                                assertTrue(zero.verticalOnPage);
                                assertTrue(zero.horizontalOnPage);
                                assertEquals(top, zero.bars.top);
                                boolean buttonOnZero = autoHide && verticalRight == handleRight;
                                assertEquals(buttonOnZero, zero.bars.button != null);
                                assertEquals(autoHide && !buttonOnZero, zero.bars.handle != null);
                                assertEquals(autoHide && !buttonOnZero, zero.bars.verticalFullHeight);
                                // another page has what the options give it
                                assertEquals(verticalEvery, two.verticalOnPage);
                                assertEquals(everyPage, two.horizontalOnPage);
                                if (!everyPage) {
                                    assertNull(two.bars.button);
                                    assertNull(two.bars.handle);
                                }
                                if (everyPage && verticalEvery) {
                                    assertEquals(buttonOnZero, two.bars.button != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    void withoutTheUserLayoutTheOtherPagesHaveNoBars() {
        Fake prefs = bars(false, false, true, true, true, true, true).with(Keys.USER_LAYOUT, false);
        CreatorPage two = CreatorPage.of(2, prefs);
        assertFalse(two.verticalOnPage);
        assertFalse(two.horizontalOnPage);
        assertNotNull(two.bars);
        assertTrue(CreatorPage.of(0, prefs).verticalOnPage);
    }
}
