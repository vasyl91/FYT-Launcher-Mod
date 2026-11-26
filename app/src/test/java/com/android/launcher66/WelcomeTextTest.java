package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WelcomeTextTest {

    @Test
    void the7870HasItsOwnTextThoughItIsAnFytUnit() {
        assertEquals(WelcomeText.Kind.UNIT_7870, WelcomeText.kind(true, true));
        assertEquals(WelcomeText.Kind.UNIT_7870, WelcomeText.kind(true, false));
    }

    @Test
    void otherFytUnitsHaveTheFytText() {
        assertEquals(WelcomeText.Kind.FYT, WelcomeText.kind(false, true));
    }

    @Test
    void everyOtherDeviceHasTheTextThatNeedsRootOrShizuku() {
        assertEquals(WelcomeText.Kind.OTHER, WelcomeText.kind(false, false));
    }
}
