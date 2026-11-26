package com.android.launcher66;

import static com.android.launcher66.BarShares.Element.APPS;
import static com.android.launcher66.BarShares.Element.DATE;
import static com.android.launcher66.BarShares.Element.DRAWER;
import static com.android.launcher66.BarShares.Element.MUSIC;
import static com.android.launcher66.BarShares.Element.WEATHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BarSharesTest {

    private static final float EPS = 0.0005f;

    private static float usualTotal(boolean portrait) {
        return BarShares.usual(DRAWER, portrait) + BarShares.usual(APPS, portrait) + BarShares.usual(MUSIC, portrait)
                + BarShares.usual(DATE, portrait) + BarShares.usual(WEATHER, portrait);
    }

    private static BarShares.Result of(boolean portrait, boolean drawer, boolean apps, float appsActual,
                                       boolean music, boolean date, boolean weather) {
        return BarShares.of(portrait, drawer, apps, appsActual, music, date, weather);
    }

    private static BarShares.Result nothingHidden(boolean portrait) {
        return of(portrait, false, false, BarShares.usual(APPS, portrait), false, false, false);
    }

    @Test
    void nothingHiddenIsTheUsualSharesAndTheUsualTotal() {
        BarShares.Result land = nothingHidden(false);
        assertEquals(0.09f, land.share(DRAWER), EPS);
        assertEquals(0.4395f, land.share(APPS), EPS);
        assertEquals(0.28f, land.share(MUSIC), EPS);
        assertEquals(0.05f, land.share(DATE), EPS);
        assertEquals(0.12f, land.share(WEATHER), EPS);
        BarShares.Result port = nothingHidden(true);
        assertEquals(0.10f, port.share(DRAWER), EPS);
        assertEquals(0.4385f, port.share(APPS), EPS);
        assertEquals(0.295f, port.share(MUSIC), EPS);
        assertEquals(0f, port.share(DATE), EPS);
        assertFalse(port.shown(DATE));
        assertEquals(0.15f, port.share(WEATHER), EPS);
    }

    @Test
    void theDateAndTheWeatherGiveAllTheirRoomToTheMusic() {
        BarShares.Result noDate = of(false, false, false, 0.4395f, false, true, false);
        assertEquals(0.28f + 0.05f, noDate.share(MUSIC), EPS);
        assertEquals(usualTotal(false), noDate.total(), EPS);
        BarShares.Result noWeather = of(true, false, false, 0.4385f, false, false, true);
        assertEquals(0.295f + 0.15f, noWeather.share(MUSIC), EPS);
        assertEquals(usualTotal(true), noWeather.total(), EPS);
    }

    @Test
    void theAppsListThatIsHiddenOrFittedGivesTheDateAndTheWeatherATenthEachAndTheMusicTheRest() {
        // the apps list gives up its whole room: 0.4395
        BarShares.Result hidden = of(false, false, true, 0f, false, false, false);
        assertEquals(0.05f + 0.04395f, hidden.share(DATE), EPS);
        assertEquals(0.12f + 0.04395f, hidden.share(WEATHER), EPS);
        assertEquals(0.28f + 0.4395f * 0.8f, hidden.share(MUSIC), EPS);
        assertEquals(0f, hidden.share(APPS), EPS);
        assertEquals(usualTotal(false), hidden.total(), EPS);
        // fitted to half: it gives half
        BarShares.Result fitted = of(false, false, false, 0.4395f / 2f, false, false, false);
        assertEquals(0.4395f / 2f, fitted.share(APPS), EPS);
        assertEquals(0.05f + 0.4395f / 2f * 0.1f, fitted.share(DATE), EPS);
        assertEquals(usualTotal(false), fitted.total(), EPS);
    }

    @Test
    void aPartForAHiddenDateOrWeatherGoesToTheMusic() {
        // apps hidden and the date hidden: the date's tenth goes to the music
        BarShares.Result r = of(false, false, true, 0f, false, true, false);
        assertEquals(0f, r.share(DATE), EPS);
        assertEquals(0.12f + 0.04395f, r.share(WEATHER), EPS);
        assertEquals(0.28f + 0.05f + 0.4395f * 0.8f + 0.04395f, r.share(MUSIC), EPS);
        assertEquals(usualTotal(false), r.total(), EPS);
    }

    @Test
    void theDrawersButtonHiddenGivesATenthToTheDateAndTheWeatherAndFourTenthsToTheAppsAndTheMusic() {
        BarShares.Result r = of(false, true, false, 0.4395f, false, false, false);
        assertEquals(0.05f + 0.009f, r.share(DATE), EPS);
        assertEquals(0.12f + 0.009f, r.share(WEATHER), EPS);
        assertEquals(0.4395f + 0.036f, r.share(APPS), EPS);
        assertEquals(0.28f + 0.036f, r.share(MUSIC), EPS);
        assertFalse(r.shown(DRAWER));
        assertEquals(usualTotal(false), r.total(), EPS);
    }

    @Test
    void theMusicHiddenGivesATenthToTheDateAndTheWeatherAndEightTenthsToTheApps() {
        BarShares.Result r = of(false, false, false, 0.4395f, true, false, false);
        assertEquals(0.05f + 0.028f, r.share(DATE), EPS);
        assertEquals(0.12f + 0.028f, r.share(WEATHER), EPS);
        assertEquals(0.4395f + 0.224f, r.share(APPS), EPS);
        assertEquals(0f, r.share(MUSIC), EPS);
        assertEquals(usualTotal(false), r.total(), EPS);
    }

    @Test
    void aPartForAnElementThatIsNotThereGoesToTheRestOfTheRule() {
        // portrait, the music and the weather hidden. The weather's room is for the music alone, which is not
        // there: equally to the drawer's button and the apps. The music's room: the date's and the weather's
        // tenth have no element, so the rest of the rule, the apps, gets them with the eight tenths.
        BarShares.Result r = of(true, false, false, 0.4385f, true, false, true);
        assertEquals(0.4385f + 0.15f / 2f + 0.295f, r.share(APPS), EPS);
        assertEquals(0.10f + 0.15f / 2f, r.share(DRAWER), EPS);
        assertEquals(usualTotal(true), r.total(), EPS);
    }

    @Test
    void withNoElementOfTheRuleLeftTheRoomIsSharedEquallyByWhatIsShown() {
        // music hidden, the apps hidden: only the drawer button (and the weather/date) are left; the music's
        // room (apps is the rest) goes equally to what is shown
        BarShares.Result r = of(true, false, true, 0f, true, false, true);
        assertTrue(r.shown(DRAWER));
        assertFalse(r.shown(APPS));
        assertFalse(r.shown(MUSIC));
        assertFalse(r.shown(WEATHER));
        // one element left gets the whole bar
        assertEquals(usualTotal(true), r.share(DRAWER), EPS);
    }

    @Test
    void everythingHiddenButTheDrawersButtonLeavesTheButtonTheWholeBar() {
        BarShares.Result r = of(false, false, true, 0f, true, true, true);
        assertEquals(1, r.shownCount());
        assertTrue(r.shown(DRAWER));
        assertEquals(usualTotal(false), r.share(DRAWER), EPS);
    }

    @Test
    void oneVisibleElementGetsTheWholeBarWhateverItIs() {
        BarShares.Result onlyMusic = of(false, true, true, 0f, false, true, true);
        assertEquals(1, onlyMusic.shownCount());
        assertEquals(usualTotal(false), onlyMusic.share(MUSIC), EPS);
        BarShares.Result onlyApps = of(true, true, false, 0.4385f, true, false, true);
        assertEquals(usualTotal(true), onlyApps.share(APPS), EPS);
    }

    @Test
    void whenTheButtonAndEverythingElseIsHiddenThereIsNothing() {
        BarShares.Result r = of(false, true, true, 0f, true, true, true);
        assertTrue(r.empty());
        assertEquals(0f, r.total(), EPS);
    }

    @Test
    void theTotalIsTheSameForEverySetOfHiddenElements() {
        for (int mask = 0; mask < 32; mask++) {
            for (int portraitBit = 0; portraitBit < 2; portraitBit++) {
                boolean portrait = portraitBit == 1;
                BarShares.Result r = of(portrait, (mask & 1) != 0, (mask & 2) != 0,
                        (mask & 2) != 0 ? 0f : BarShares.usual(APPS, portrait), (mask & 4) != 0, (mask & 8) != 0,
                        (mask & 16) != 0);
                if (r.empty()) {
                    continue;
                }
                assertEquals(usualTotal(portrait), r.total(), EPS, "mask " + mask + " portrait " + portrait);
                for (BarShares.Element e : BarShares.Element.values()) {
                    assertTrue(r.share(e) >= 0f);
                    if (!r.shown(e)) {
                        assertEquals(0f, r.share(e), EPS);
                    }
                }
            }
        }
    }
}
