package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Random;

class FuelSpeedThresholdTest {

    private static void accelerate(FuelSpeedThreshold t, Random rnd, int samples, double threshold, double from, double to) {
        for (int i = 0; i < samples; i++) {
            double kmh = from + rnd.nextDouble() * (to - from);
            t.onAccelerating(kmh, kmh > threshold);
        }
    }

    @Test
    void aCarWithAThresholdOf30IsFoundWithinOneBin() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        accelerate(t, new Random(1), 400, 30, 0, 80);
        assertEquals(30.0, t.threshold(), 5.0);
    }

    @Test
    void aCarThatGivesValuesAtEverySpeedHasNone() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        accelerate(t, new Random(1), 400, -1, 0, 80);
        assertTrue(Double.isNaN(t.threshold()));
    }

    @Test
    void aCarThatGivesNoValueAtAnySpeedHasNone() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        accelerate(t, new Random(1), 400, 1000, 0, 80);
        assertTrue(Double.isNaN(t.threshold()));
    }

    @Test
    void tooManyWrongEntriesMeanNoThreshold() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        Random rnd = new Random(2);
        for (int i = 0; i < 400; i++) {
            double kmh = rnd.nextDouble() * 80;
            t.onAccelerating(kmh, rnd.nextBoolean());      // no order at all
        }
        assertTrue(Double.isNaN(t.threshold()));
    }

    @Test
    void theThresholdFollowsTheCarAfterManyNewSamples() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        Random rnd = new Random(3);
        accelerate(t, rnd, 400, 30, 0, 80);
        assertEquals(30.0, t.threshold(), 5.0);
        accelerate(t, rnd, 4000, 50, 0, 80);
        assertEquals(50.0, t.threshold(), 5.0);
    }

    @Test
    void theCountsReadBack() {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        accelerate(t, new Random(4), 400, 30, 0, 80);
        FuelSpeedThreshold back = FuelSpeedThreshold.read(t.write());
        assertEquals(t.write(), back.write());
        assertEquals(t.threshold(), back.threshold(), 0.0);
        assertTrue(Double.isNaN(FuelSpeedThreshold.read("").threshold()));
        assertThrows(NumberFormatException.class, () -> FuelSpeedThreshold.read("1:2,3"));
        assertThrows(NumberFormatException.class, () -> FuelSpeedThreshold.read(t.write().replace("0:", "x:")));
    }
}
