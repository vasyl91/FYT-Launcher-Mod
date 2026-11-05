package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class AutoCodesTest {

    private static Map<Integer, List<Integer>> events(int... codesWithData) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int c : codesWithData) {
            m.put(c, Collections.singletonList(1));
        }
        return m;
    }

    @Test
    void theTextRoundTrips() {
        AutoCodes a = new AutoCodes(91, -1, true, false);
        AutoCodes back = AutoCodes.parse(a.serialize());
        assertEquals(91, back.fuel);
        assertEquals(-1, back.range);
        assertTrue(back.fuelSilent);
        assertFalse(back.rangeSilent);
        assertNull(AutoCodes.parse(""));
        assertNull(AutoCodes.parse("1;2;true"));
        assertNull(AutoCodes.parse("a;2;true;false"));
    }

    @Test
    void theKeyHoldsTheCar() {
        assertEquals("auto_codes_163", AutoCodes.key(163));
    }

    @Test
    void theLibraryIsSilentWhenItsCodeHasNoDataButTheGuessHas() {
        List<CanbusLibrary.CarCodes> pairs = Arrays.asList(new CanbusLibrary.CarCodes(102, 103));
        AutoCodes found = AutoCodes.of(91, 92, pairs, events(91, 92));
        assertTrue(found.fuelSilent);
        assertTrue(found.rangeSilent);
    }

    @Test
    void theLibraryIsNotSilentWhenOneOfItsPairsDeliveredData() {
        List<CanbusLibrary.CarCodes> pairs = Arrays.asList(new CanbusLibrary.CarCodes(102, 103),
                new CanbusLibrary.CarCodes(91, 92));
        AutoCodes found = AutoCodes.of(91, 92, pairs, events(91, 92));
        assertFalse(found.fuelSilent);
        assertFalse(found.rangeSilent);
    }

    @Test
    void aCarTheLibraryHasNoPairForIsNotSilentItJustHasNoLibraryCode() {
        AutoCodes none = AutoCodes.of(91, 92, Collections.emptyList(), events(91, 92));
        assertFalse(none.fuelSilent);
        assertEquals(91, none.fuel);
        AutoCodes noPair = AutoCodes.of(91, 92, Arrays.asList(new CanbusLibrary.CarCodes(-1, -1)), events(91, 92));
        assertFalse(noPair.fuelSilent);
    }

    @Test
    void aGuessWithoutDataIsNeverTheReasonToCallTheLibrarySilent() {
        List<CanbusLibrary.CarCodes> pairs = Arrays.asList(new CanbusLibrary.CarCodes(102, 103));
        AutoCodes found = AutoCodes.of(91, -1, pairs, events());
        assertFalse(found.fuelSilent);
        assertFalse(found.rangeSilent);
    }

    @Test
    void theUsersCodeWinsOverEverything() {
        assertEquals(7, AutoCodes.choose(7, 102, true, 91, true));
        assertEquals(7, AutoCodes.choose(7, 0, false, 0, false));
    }

    @Test
    void theLibraryWinsUnlessTheCheckFoundItSilent() {
        assertEquals(102, AutoCodes.choose(0, 102, false, 91, false));
        assertEquals(91, AutoCodes.choose(0, 102, false, 91, true));
        // live data from the library's code since then: it is not silent after all
        assertEquals(102, AutoCodes.choose(0, 102, true, 91, true));
    }

    @Test
    void theCheckFillsInWhereTheLibraryHasNoCode() {
        assertEquals(91, AutoCodes.choose(0, 0, false, 91, false));
    }

    @Test
    void theLibraryIsKeptWhenThereIsNoCandidateEvenIfSilent() {
        assertEquals(102, AutoCodes.choose(0, 102, false, -1, true));
        assertEquals(0, AutoCodes.choose(0, 0, false, -1, false));
    }
}
