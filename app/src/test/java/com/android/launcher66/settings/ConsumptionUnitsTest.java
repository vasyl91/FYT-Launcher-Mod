package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.android.launcher66.settings.ConsumptionUnits.Shown;
import com.android.launcher66.settings.ConsumptionUnits.Unit;

import org.junit.jupiter.api.Test;

class ConsumptionUnitsTest {

    private static void assertShown(double value, Unit unit, Shown shown) {
        assertNotNull(shown);
        assertEquals(unit, shown.unit);
        assertEquals(value, shown.value, 1e-9);
    }

    @Test
    void theUnitOfTheProtocolIsKeptAsItIs() {
        // L/h at 50 km/h: not converted to L/100 km
        assertShown(3.4, Unit.LH, ConsumptionUnits.forCarValue(34, Unit.LH, false, false, true, 50, true));
        // L/100 km at 8 km/h: not turned into litres per hour by the rule of the low speed
        assertShown(3.4, Unit.L100, ConsumptionUnits.forCarValue(34, Unit.L100, false, true, true, 8, true));
        // and at a stop
        assertShown(0, Unit.LH, ConsumptionUnits.forCarValue(0, Unit.LH, false, true, true, 0, false));
        assertShown(6.3, Unit.L100, ConsumptionUnits.forCarValue(63, Unit.L100, false, true, true, 0, false));
        // with no speed it needs none
        assertShown(3.4, Unit.LH, ConsumptionUnits.forCarValue(34, Unit.LH, false, false, false, 0, false));
    }

    @Test
    void aCarThatGivesItsValueFromAThresholdDecidesItself() {
        // the protocol says L/h, the module has learned a threshold car: L/100 km above 10 km/h
        assertShown(8.1, Unit.L100, ConsumptionUnits.forCarValue(81, Unit.LH, true, false, true, 50, true));
        // and with no protocol
        assertShown(8.1, Unit.L100, ConsumptionUnits.forCarValue(81, null, true, false, true, 50, true));
        // under 10 km/h the rule of the low speed applies, whatever the protocol says
        assertShown(0.9, Unit.LH, ConsumptionUnits.forCarValue(150, Unit.L100, true, true, true, 6, true));
    }

    @Test
    void withNoProtocolTheValueIsInLitresPerHourUnderTenKmh() {
        // at a stop L/100 km does not exist: 0.8 is litres per hour; 6.3 is an old L/100 km value
        assertShown(0.8, Unit.LH, ConsumptionUnits.forCarValue(8, null, false, true, true, 0, false));
        assertNull(ConsumptionUnits.forCarValue(63, null, false, true, true, 0, false));
        assertShown(0, Unit.LH, ConsumptionUnits.forCarValue(0, null, false, true, true, 0, false));
        // moving: 15.0 L/100 km at 6 km/h is 0.9 L/h; 0.8 at 6 km/h is already litres per hour (L/100 km would be 0.05 L/h)
        assertShown(0.9, Unit.LH, ConsumptionUnits.forCarValue(150, null, false, true, true, 6, true));
        assertShown(0.8, Unit.LH, ConsumptionUnits.forCarValue(8, null, false, true, true, 6, true));
        // 3.5 L/100 km at 9 km/h is 0.315 L/h, above what a running engine burns less than
        assertShown(0.315, Unit.LH, ConsumptionUnits.forCarValue(35, null, false, true, true, 9, true));
        // at the speed of 12 km/h on the way up the model is not in the low speed yet: as it was
        assertNull(ConsumptionUnits.forCarValue(35, null, false, false, true, 12, true));
    }

    @Test
    void withNoSpeedThereIsNothingToConvert() {
        assertNull(ConsumptionUnits.forCarValue(8, null, false, true, false, 0, false));
        assertNull(ConsumptionUnits.forCarValue(150, null, false, true, false, 6, true));
        assertNull(ConsumptionUnits.forCarValue(0, null, false, true, false, 0, false));
    }

    @Test
    void theModelKnowsASpeedOnlyWhenItIsRecent() {
        FuelModel m = new FuelModel();
        assertEquals(false, m.speedKnown(0));
        m.onSpeed(1000, 6, true);
        assertEquals(true, m.speedKnown(2000));
        assertEquals(6, m.speedKmh(), 1e-9);
        assertEquals(false, m.speedKnown(10_000));
    }
}
