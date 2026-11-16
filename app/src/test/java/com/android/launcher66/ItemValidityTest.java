package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemValidityTest {

    @Test
    void anIconWhoseActivityCanBeStartedIsShown() {
        assertEquals(ItemValidity.Verdict.SHOW, ItemValidity.of(true, true, true, true, true).verdict);
    }

    @Test
    void anIconOfAnAppThatRenamedItsActivityIsMended() {
        assertEquals(ItemValidity.Verdict.MEND, ItemValidity.of(true, true, false, true, true).verdict);
    }

    @Test
    void aShortcutIntoAnAppIsNotMended() {
        assertEquals(ItemValidity.Verdict.HIDE, ItemValidity.of(true, true, false, true, false).verdict);
    }

    @Test
    void anAppThatIsMissingOrDisabledIsHiddenWithItsReason() {
        ItemValidity.Result missing = ItemValidity.of(false, false, false, false, true);
        assertEquals(ItemValidity.Verdict.HIDE, missing.verdict);
        assertEquals("the app is not installed", missing.reason);
        assertEquals("the app is disabled and none of its activities can be started",
                ItemValidity.of(true, false, false, false, true).reason);
        assertEquals(ItemValidity.Verdict.HIDE, ItemValidity.of(true, true, false, false, true).verdict);
    }

    @Test
    void anAppReportedDisabledWhoseActivityTheSystemStartsIsShown() {
        // The A55, 2026-11-16 09:11: Authenticator, Alior, Anki reported "enabled == false", yet in the list of apps
        assertEquals(ItemValidity.Verdict.SHOW, ItemValidity.of(true, false, true, true, true).verdict);
    }
}
