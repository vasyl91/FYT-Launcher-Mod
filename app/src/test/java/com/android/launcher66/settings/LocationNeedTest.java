package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.android.launcher66.settings.LocationNeed.Check;
import com.android.launcher66.settings.LocationNeed.Inputs;
import com.android.launcher66.settings.LocationNeed.Rate;

import org.junit.jupiter.api.Test;

class LocationNeedTest {

    private static Inputs unit() {
        Inputs in = new Inputs();
        in.canbusUnit = true;
        in.permission = true;
        return in;
    }

    private static Rate rate(Inputs in) {
        return LocationNeed.decide(in).rate;
    }

    @Test
    void aPhoneHasNoGps() {
        // The owner's A55: the service runs for the statistics' window, and nothing gives a value
        Inputs in = unit();
        in.canbusUnit = false;
        in.fuelModel = true;
        in.check = Check.WAITING;
        assertEquals(Rate.NONE, rate(in));
    }

    @Test
    void withoutThePermissionNone() {
        Inputs in = unit();
        in.permission = false;
        in.fuelModel = true;
        assertEquals(Rate.NONE, rate(in));
    }

    @Test
    void theEstimateKeepsItsHalfSecond() {
        // The 7862: a fuel code, the speed from the GPS or no barometer
        Inputs in = unit();
        in.fuelModel = true;
        assertEquals(Rate.FAST, rate(in));
        in.speedFromCode = true;
        assertEquals(Rate.FAST, rate(in), "the altitude without a barometer");
        in.barometer = true;
        assertEquals(Rate.NONE, rate(in), "the speed from the car, the altitude from the barometer");
    }

    @Test
    void theScaleOfTheSpeedCodeIsLearnedFromTheGps() {
        Inputs in = unit();
        in.learningSpeedScale = true;
        assertEquals(Rate.FAST, rate(in));
    }

    @Test
    void theCodeCheckWaitsSlowlyAndRecordsFast() {
        Inputs in = unit();
        in.check = Check.WAITING;
        assertEquals(Rate.MOTION, rate(in));
        assertEquals(5_000L, Rate.MOTION.intervalMs);
        in.check = Check.STARTING;
        assertEquals(Rate.FAST, rate(in));
        in.check = Check.RECORDING;
        assertEquals(Rate.FAST, rate(in));
        in.check = Check.OFF;
        assertEquals(Rate.NONE, rate(in), "done for this car: no GPS");
    }

    @Test
    void aCheckThatSeesTheSpeedCodeWaitsWithoutTheGps() {
        Inputs in = unit();
        in.check = Check.WAITING;
        in.speedFromCode = true;
        assertEquals(Rate.MOTION, rate(in), "without the speed code's movement");
        in.checkSeesSpeedCode = true;
        assertEquals(Rate.NONE, rate(in));
        in.check = Check.STARTING;
        assertEquals(Rate.FAST, rate(in), "its recording still matches the codes with the GPS");
    }

    @Test
    void thePairOfCodesCountsTheDrivingSlowlyAndNotAtAllWithASpeedCode() {
        Inputs in = unit();
        in.pairNeedsDriving = true;
        assertEquals(Rate.MOTION, rate(in));
        in.speedFromCode = true;
        assertEquals(Rate.NONE, rate(in));
    }

    @Test
    void theRatesAreTheOnesOfTheRule() {
        assertEquals(500L, Rate.FAST.intervalMs);
        assertEquals(0L, Rate.NONE.intervalMs);
    }
}
