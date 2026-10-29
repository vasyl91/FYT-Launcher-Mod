package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Random;

class FuelModelTest {

    /** The "true" consumption of a car, L/h: like the owner's (idle ~1, ~1 L/h slowing down). */
    private static double trueLph(double kmh, double accel, double coastLph) {
        double v = kmh / 3.6;
        if (kmh <= 0.5) {
            return 1.0;
        }
        if (accel < -0.3) {
            return coastLph;
        }
        return 1.0 + 0.45 * (0.15 * v + 0.00031 * v * v * v) + 0.1 * Math.max(accel, 0) * v;
    }

    /**
     * Drives a city for {@code seconds}: speed updates 5 a second (from a canbus code), the car's fuel value
     * once a second, given only above {@code thresholdKmh}, "no value" (65535) below.
     */
    private static long drive(FuelModel m, Random rnd, long t0, int seconds, double thresholdKmh, double coastLph) {
        double kmh = 0;
        double target = 0;
        long t = t0;
        for (int step = 0; step < seconds * 5; step++, t += 200) {
            if (step % 75 == 0) {
                target = rnd.nextInt(4) == 0 ? 0 : 10 + rnd.nextInt(45);
            }
            double accel = Math.max(-1.5, Math.min(1.5, (target - kmh) / 3.6 / 2)) + (rnd.nextDouble() - 0.5) * 0.2;
            kmh = Math.max(0, kmh + accel * 3.6 * 0.2);
            m.onSpeed(t, kmh, true);
            if (step % 5 == 0) {
                double lph = trueLph(kmh, accel, coastLph);
                int value = kmh > thresholdKmh ? (int) Math.round(lph / kmh * 100 * 10) : 65535;
                m.onFuel(t, value);
            }
        }
        return t;
    }

    /** Holds a speed with an acceleration for a few seconds, the car giving no value. */
    private static long hold(FuelModel m, long t, double kmh, double accel) {
        for (int i = 0; i < 15; i++, t += 200) {
            kmh = Math.max(0, kmh + accel * 3.6 * 0.2);
            m.onSpeed(t, kmh, true);
            if (i % 5 == 0) {
                m.onFuel(t, 65535);
            }
        }
        return t;
    }

    @Test
    void calibratedOnTheCarItEstimatesBelowTheCarsThreshold() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.9);
        assertTrue(m.calibrated());
        // below the threshold, steady, speeding up, slowing down: close to the car's true consumption
        for (double[] c : new double[][]{{20, 0}, {25, 0.8}, {15, -1.0}, {10, 0.5}}) {
            long at = hold(m, t, c[0], c[1]);
            double expected = trueLph(c[0] + c[1] * 3.6 * 0.2 * 15, c[1], 0.9);
            double got = m.litresPerHour(at);
            assertEquals(expected, got, 0.25 * expected + 0.2, "at " + c[0] + " km/h, " + c[1] + " m/s²");
            t = at + 10_000;
        }
    }

    @Test
    void speedingUpBurnsMoreThanSteadyAndSteadyMoreThanSlowingDown() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(2), 0, 900, 30, 0.9);
        double up = m.litresPerHour(hold(m, t, 20, 1.0));
        double steady = m.litresPerHour(hold(m, t + 10_000, 20, 0));
        double down = m.litresPerHour(hold(m, t + 20_000, 20, -1.0));
        assertTrue(up > steady && steady > down, up + " / " + steady + " / " + down);
    }

    @Test
    void theLevelWhileSlowingDownIsLearned() {
        FuelModel cut = new FuelModel();
        drive(cut, new Random(3), 0, 900, 0, 0.0);       // a car that cuts the fuel (0 while slowing down), values at any speed
        FuelModel idle = new FuelModel();
        drive(idle, new Random(3), 0, 900, 0, 1.0);
        // the acceleration the model measures over 2 s is not exactly the car's: close, not exact
        assertTrue(cut.coastAt(20) < 0.5, "cut: " + cut.coastAt(20));
        assertEquals(1.0, idle.coastAt(20), 0.25);
        assertTrue(idle.coastAt(20) - cut.coastAt(20) > 0.5);
        // before any sample of slowing down: the starting level
        assertEquals(0.6 + 0.02 * 20 / 3.6, new FuelModel().coastAt(20), 0.05);
    }

    @Test
    void aCarThatAlwaysGivesItsValueNeverSeesTheEstimate() {
        FuelModel m = new FuelModel();
        Random rnd = new Random(4);
        long t = 0;
        double kmh = 0;
        for (int step = 0; step < 900 * 5; step++, t += 200) {
            kmh = Math.max(0, Math.min(60, kmh + rnd.nextInt(3) - 1));
            m.onSpeed(t, kmh, true);
            if (step % 5 == 0) {
                m.onFuel(t, kmh > 1 ? 40 + rnd.nextInt(60) : 0);
                assertNull(m.estimate(t));
            }
        }
        assertTrue(m.calibrated());
        assertFalse(m.carGivesNoValue(t));
    }

    @Test
    void beforeTheCalibrationThereIsNoEstimateEvenWithNoValue() {
        FuelModel m = new FuelModel();
        drive(m, new Random(5), 0, 60, 30, 0.9);       // a minute: too little
        assertFalse(m.calibrated());
        long t = hold(m, 100_000, 15, 0);
        assertTrue(m.carGivesNoValue(t));
        assertNull(m.estimate(t));
        // a car with no fuel code at all: the model never hears from it
        FuelModel none = new FuelModel();
        for (long s = 0; s < 600_000; s += 200) {
            none.onSpeed(s, 30, true);
        }
        assertNull(none.estimate(600_000));
    }

    @Test
    void zeroWhileDrivingAndSilenceCountAsNoValue() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(6), 0, 900, 30, 0.9);
        // 0 while driving
        for (int i = 0; i < 10; i++, t += 200) {
            m.onSpeed(t, 20, true);
        }
        m.onFuel(t, 0);
        assertNotNull(m.estimate(t));
        // a real value: no estimate
        m.onFuel(t, 55);
        assertNull(m.estimate(t));
        // then nothing for more than 5 s while driving
        for (int i = 0; i < 30; i++, t += 200) {
            m.onSpeed(t, 20, true);
        }
        assertNotNull(m.estimate(t));
    }

    @Test
    void atAStopTheEstimateIsInLitresPerHour() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(7), 0, 900, 30, 0.9);
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 0, true);
        }
        m.onFuel(t, 65535);
        FuelModel.Estimate e = m.estimate(t);
        assertNotNull(e);
        assertTrue(e.perHour);
        assertEquals(m.idle(), e.value, 0.3);
        // 3 km/h from a canbus code is driving, from the GPS a stop
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 3, true);
        }
        assertTrue(m.isMoving());
        assertFalse(m.estimate(t).perHour);
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 3, false);
        }
        assertFalse(m.isMoving());
        assertTrue(m.estimate(t).perHour);
    }

    @Test
    void theRpmJoinsTheModelWhenTheCarReportsIt() {
        FuelModel m = new FuelModel();
        Random rnd = new Random(8);
        long t = 0;
        for (int step = 0; step < 900 * 5; step++, t += 200) {
            double kmh = 40;
            int rpm = 1000 + rnd.nextInt(2000);
            m.onRpm(rpm);
            m.onSpeed(t, kmh, true);
            if (step % 5 == 0) {
                double lph = 0.8 + 0.6 * rpm / 1000.0;
                m.onFuel(t, (int) Math.round(lph / kmh * 1000));
            }
        }
        m.onRpm(1000);
        double low = m.litresPerHour(t);
        m.onRpm(3000);
        double high = m.litresPerHour(t);
        assertTrue(high - low > 0.8, low + " -> " + high);
    }

    @Test
    void theScaleOfASpeedCode() {
        FuelModel.SpeedScale gps = new FuelModel.SpeedScale(0);
        for (int i = 0; i < 20; i++) {
            gps.onValue(3000 + i * 100);
            gps.onGps(30 + i);
        }
        assertEquals(100, gps.scale());
        FuelModel.SpeedScale tens = new FuelModel.SpeedScale(0);
        for (int i = 0; i < 20; i++) {
            tens.onValue(500 + i * 10);
        }
        assertEquals(10, tens.scale());
        FuelModel.SpeedScale ones = new FuelModel.SpeedScale(0);
        for (int i = 0; i < 20; i++) {
            ones.onValue(20 + i);
        }
        assertEquals(1, ones.scale());
        FuelModel.SpeedScale early = new FuelModel.SpeedScale(0);
        early.onValue(3000);
        assertEquals(0, early.scale());
        assertEquals(100, new FuelModel.SpeedScale(100).scale());
    }

    @Test
    void whatTheModelLearnedReadsBack() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(9), 0, 900, 30, 0.9);
        FuelModel back = FuelModel.parse(m.serialize());
        assertEquals(m.serialize(), back.serialize());
        assertTrue(back.calibrated());
        long at = hold(m, t, 20, 0.5);
        hold(back, t, 20, 0.5);
        assertEquals(m.litresPerHour(at), back.litresPerHour(at), 1e-9);
        assertFalse(FuelModel.parse("nonsense").calibrated());
        assertFalse(FuelModel.parse(null).calibrated());
        assertFalse(FuelModel.parse("1;2;3").calibrated());
        assertFalse(FuelModel.key(1507667, 91).equals(FuelModel.key(1507667, 102)));
    }
}
