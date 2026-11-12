package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WidgetLaunchRuleTest {

    @Test
    void aPhoneWithoutAnyRadioOpensNothing() {
        assertEquals(WidgetLaunchRule.Radio.NONE, WidgetLaunchRule.radio(false, false, false, false));
    }

    @Test
    void theUnitWithTheRadioAppOpensIt() {
        assertEquals(WidgetLaunchRule.Radio.RADIO_APP, WidgetLaunchRule.radio(false, false, true, false));
    }

    @Test
    void theRadioAppComesBeforeTheMediaPage() {
        assertEquals(WidgetLaunchRule.Radio.RADIO_APP, WidgetLaunchRule.radio(false, false, true, true));
    }

    @Test
    void the7870OpensThePageOfTheMediaApp() {
        assertEquals(WidgetLaunchRule.Radio.MEDIA_PAGE, WidgetLaunchRule.radio(false, false, false, true));
    }

    @Test
    void aCarRadioReportedByTheMcuStandsForTheRadio() {
        assertEquals(WidgetLaunchRule.Radio.CAR_RADIO, WidgetLaunchRule.radio(true, true, true, true));
    }

    @Test
    void aCarRadioThatCannotBeOpenedOpensNothingElse() {
        assertEquals(WidgetLaunchRule.Radio.NONE, WidgetLaunchRule.radio(true, false, true, true));
    }

    @Test
    void aBareMainIntentNamesNothing() {
        assertFalse(WidgetLaunchRule.namesTarget(false, false, false, true));
    }

    @Test
    void aComponentAPackageACategoryOrAnotherActionNameATarget() {
        assertTrue(WidgetLaunchRule.namesTarget(true, false, false, true));
        assertTrue(WidgetLaunchRule.namesTarget(false, true, false, true));
        assertTrue(WidgetLaunchRule.namesTarget(false, false, true, true));
        assertTrue(WidgetLaunchRule.namesTarget(false, false, false, false));
    }
}
