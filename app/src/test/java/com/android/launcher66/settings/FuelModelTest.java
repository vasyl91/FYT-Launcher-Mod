package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleUnaryOperator;

class FuelModelTest {

    /** What the model before v3 learned on {@code drive(m, new Random(9), 0, 900, 30, 0.9)}, in its second format. */
    private static final String TEXT_2 = "2;311;787800;22.899999999999316;0;140.9100621900734;282.38830977995025;432.43666565749083;0.0;282.38830977995025;601.9191901662039;900.3501244673154;0.0;432.43666565749083;900.3501244673155;4897.819070428713;0.0;0.0;0.0;0.0;0.0;298.85342524354195;611.3906627288677;1259.9465166122923;0.0;27.02871354496935;270.86936731088326;270.86936731088326;2762.6536417393067;26.811103015077876;268.61851583837023;0.0;0";
    /** The same without the edge correction: the first format. */
    private static final String TEXT_1 = "1;311;787800;22.899999999999316;0;140.9100621900734;282.38830977995025;432.43666565749083;0.0;282.38830977995025;601.9191901662039;900.3501244673154;0.0;432.43666565749083;900.3501244673155;4897.819070428713;0.0;0.0;0.0;0.0;0.0;298.85342524354195;611.3906627288677;1259.9465166122923;0.0;27.02871354496935;270.86936731088326;270.86936731088326;2762.6536417393067;26.811103015077876;268.61851583837023";
    /** Its L/h at 30, 36 and 42 km/h with an acceleration of 0 and 0.8 m/s², as the old code gave them. */
    private static final double[][] LEGACY_LPH = {
            {30, 0.0, 1.518733}, {30, 0.8, 2.152331}, {36, 0.0, 1.704470}, {36, 0.8, 2.464787}, {42, 0.0, 1.915420}, {42, 0.8, 2.802457}};

    /** The "true" consumption of a car, L/h: like the owner's (idle ~1, ~1 L/h slowing down). */
    private static double trueLph(double kmh, double accel, double coastLph) {
        return trueLph(kmh, accel, k -> coastLph);
    }

    /** The same with a level while slowing down that depends on the speed (km/h). */
    private static double trueLph(double kmh, double accel, DoubleUnaryOperator coastLph) {
        double v = kmh / 3.6;
        if (kmh <= 0.5) {
            return 1.0;
        }
        if (accel < -0.3) {
            return coastLph.applyAsDouble(kmh);
        }
        return 1.0 + 0.45 * (0.15 * v + 0.00031 * v * v * v) + 0.1 * Math.max(accel, 0) * v;
    }

    /**
     * Drives a city for {@code seconds}: speed updates 5 a second (from a canbus code), the car's fuel value
     * once a second, given only above {@code thresholdKmh}, "no value" (65535) below.
     */
    private static long drive(FuelModel m, Random rnd, long t0, int seconds, double thresholdKmh, double coastLph) {
        return drive(m, rnd, t0, seconds, thresholdKmh, k -> coastLph);
    }

    private static long drive(FuelModel m, Random rnd, long t0, int seconds, double thresholdKmh, DoubleUnaryOperator coastLph) {
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


    /**
     * A car with RPM at a speed (km/h) and an acceleration (m/s², over the last 2 s): {consumption L/h, RPM}. In gear
     * the revs follow the speed and the fuel is cut while slowing down; in neutral the revs are the idle and it burns
     * the idle.
     */
    private static double[] rpmCar(double kmh, double accel, boolean neutral, Random rnd) {
        double v = kmh / 3.6;
        double noise = rnd.nextInt(41) - 20;
        if (kmh <= 0.5 || neutral) {
            return new double[]{1.0, 800 + noise};
        }
        double rpm = 800 + 28 * kmh + noise;
        if (accel < -0.3) {
            return new double[]{0.0, rpm};
        }
        return new double[]{1.0 + 0.45 * (0.15 * v + 0.00031 * v * v * v) + 0.1 * Math.max(accel, 0) * v, rpm};
    }

    /** {@link #drive} with the RPM, 5 a second: half of the slowing down is in neutral. */
    private static long driveRpm(FuelModel m, Random rnd, long t0, int seconds, double thresholdKmh) {
        double kmh = 0;
        double target = 0;
        boolean neutral = false;
        double[] recent = new double[10];
        long t = t0;
        for (int step = 0; step < seconds * 5; step++, t += 200) {
            if (step % 75 == 0) {
                target = rnd.nextInt(4) == 0 ? 0 : 10 + rnd.nextInt(45);
                neutral = rnd.nextBoolean();
            }
            double accel = Math.max(-1.5, Math.min(1.5, (target - kmh) / 3.6 / 2)) + (rnd.nextDouble() - 0.5) * 0.2;
            kmh = Math.max(0, kmh + accel * 3.6 * 0.2);
            recent[step % recent.length] = accel;
            double mean = 0;
            for (double r : recent) {
                mean += r / recent.length;
            }
            double[] car = rpmCar(kmh, mean, neutral && mean <= 0.3, rnd);
            m.onRpm(t, (int) car[1]);
            m.onSpeed(t, kmh, true);
            if (step % 5 == 0) {
                m.onFuel(t, kmh > thresholdKmh ? (int) Math.round(car[0] / kmh * 1000) : 65535);
            }
        }
        return t;
    }

    /** The model's L/h at a speed with a slope of the speed (m/s²), after 15 speeds, 200 ms apart; the RPM, if given. */
    private static double litresAt(FuelModel m, long t, double kmh, double accel, int rpm) {
        double step = accel * 3.6 * 0.2;
        long at = t;
        for (int i = 0; i < 15; i++, at += 200) {
            if (rpm >= 0) {
                m.onRpm(at, rpm);
            }
            m.onSpeed(at, kmh - step * (14 - i), true);
        }
        return m.litresPerHour(at - 200);
    }

    /** The estimate after the speeds of {@link #litresAt}, the car giving no value. */
    private static FuelModel.Estimate silentAt(FuelModel m, long t, double kmh, double accel) {
        double step = accel * 3.6 * 0.2;
        long at = t;
        FuelModel.Estimate e = null;
        for (int i = 0; i < 15; i++, at += 200) {
            m.onSpeed(at, kmh - step * (14 - i), true);
            if (i % 5 == 0) {
                m.onFuel(at, 65535);
            }
            e = m.estimate(at);
        }
        return e;
    }

    /** What the car gives at a speed (km/h) and an acceleration (m/s²): L/100 km × 10, or 65535 for no value. */
    private interface Car {
        int value(double kmh, double accel);
    }

    /** The estimates and the car's values of a ride. */
    private static final class Log {
        final List<Double> estimates = new ArrayList<>();
        /** Every estimate with the speed it was made at, in either unit. */
        final List<FuelModel.Estimate> all = new ArrayList<>();
        final List<Double> allKmh = new ArrayList<>();
        double lastCarL100 = Double.NaN;
        double lastCarLph = Double.NaN;
        double firstCarL100 = Double.NaN;
        double estimateBeforeTheCar = Double.NaN;
    }

    /** A car that gives its value (the true one plus {@code extraLph}) above 30 km/h only. */
    private static Car aboveThirty(double coastLph, double extraLph) {
        return aboveThirty(k -> coastLph, extraLph);
    }

    private static Car aboveThirty(DoubleUnaryOperator coastLph, double extraLph) {
        return (kmh, accel) -> kmh > 30
                ? (int) Math.round((trueLph(kmh, accel, coastLph) + extraLph) / kmh * 1000) : 65535;
    }

    /**
     * Rides from {@code kmh[0]} with an acceleration until {@code endKmh} or {@code seconds}: a speed every 200 ms,
     * the car's value every second, an estimate (L/100 km) every 200 ms. Returns the time; {@code kmh[0]} is the speed.
     */
    private static long ride(FuelModel m, long t, double[] kmh, double accel, double endKmh, int seconds, Car car, Log log) {
        for (int step = 0; step < seconds * 5; step++, t += 200) {
            if (accel > 0 ? kmh[0] >= endKmh : accel < 0 && kmh[0] <= endKmh) {
                break;
            }
            kmh[0] = Math.max(0, kmh[0] + accel * 3.6 * 0.2);
            m.onSpeed(t, kmh[0], true);
            if (step % 5 == 0) {
                int value = car.value(kmh[0], accel);
                m.onFuel(t, value);
                if (value != 65535) {
                    log.lastCarL100 = value / 10.0;
                    log.lastCarLph = value / 10.0 * kmh[0] / 100.0;
                    if (Double.isNaN(log.firstCarL100) && !log.estimates.isEmpty()) {
                        log.firstCarL100 = value / 10.0;
                        log.estimateBeforeTheCar = log.estimates.get(log.estimates.size() - 1);
                    }
                }
            }
            FuelModel.Estimate e = m.estimate(t);
            if (e != null) {
                log.all.add(e);
                log.allKmh.add(kmh[0]);
            }
            if (e != null && !e.perHour) {
                log.estimates.add(e.value);
            }
        }
        return t;
    }

    /** The estimate in L/h, whatever its unit, at the speed it was made at. */
    private static double lph(FuelModel.Estimate e, double kmh) {
        return e.perHour ? e.value : e.value * kmh / 100.0;
    }

    @Test
    void slowingDownBelowTheThresholdGoesToTheIdleInLitresPerHour() {
        FuelModel m = new FuelModel();
        // the owner's: ~0.9 L/h while slowing down at 30 km/h, more the faster (a line through it would be ~0.3 at
        // 10 km/h, below the idle), nothing below 30 km/h
        DoubleUnaryOperator owner = k -> 0.9 + 0.03 * (k - 30);
        long t = drive(m, new Random(2), 0, 900, 30, owner);
        double[] kmh = {35};
        Car car = aboveThirty(owner, 0);
        t = ride(m, t, kmh, 0, 0, 6, car, new Log());
        Log log = new Log();
        ride(m, t, kmh, -0.8, 8, 60, car, log);
        assertFalse(log.all.isEmpty());
        for (FuelModel.Estimate e : log.all) {
            assertTrue(e.perHour, "in L/h from the first estimate");
        }
        assertEquals(log.lastCarLph, log.all.get(0).value, 0.1);
        int at10 = 0;
        while (log.allKmh.get(at10) > 10) {
            at10++;
        }
        assertEquals(m.idle(), log.all.get(at10).value, 0.15);
        // and it ends near the idle, not near zero
        assertEquals(m.idle(), log.all.get(log.all.size() - 1).value, 0.35);
    }

    @Test
    void aCarThatCutsTheFuelIsNearZeroAtTheThresholdAndRisesToTheIdle() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.0);
        double[] kmh = {45};
        // 0 once it has been slowing down for a while (the model measures the acceleration over 2 s)
        Car car = (v, a) -> v > 30 ? (a < -0.3 && v < 37 ? 0 : (int) Math.round(trueLph(v, a, 0.9) / v * 1000)) : 65535;
        t = ride(m, t, kmh, 0, 0, 6, car, new Log());
        Log down = new Log();
        ride(m, t, kmh, -0.8, 8, 60, car, down);
        assertEquals(0.0, down.lastCarL100, 0);
        assertFalse(down.all.isEmpty());
        int atTheThreshold = 0;
        while (down.allKmh.get(atTheThreshold) > m.thresholdKmh() && atTheThreshold < down.all.size() - 1) {
            atTheThreshold++;
        }
        assertTrue(down.all.get(atTheThreshold).value < 0.2, "at the threshold: " + down.all.get(atTheThreshold).value);
        assertTrue(down.all.get(down.all.size() - 1).value > 0.5 * m.idle(),
                "at 8 km/h: " + down.all.get(down.all.size() - 1).value + ", idle " + m.idle());
        // and speeding up again: the model, not zero
        Log up = new Log();
        ride(m, t + 100_000, kmh, 0.8, 20, 10, car, up);
        assertTrue(up.all.get(up.all.size() - 1).value > 0);
    }

    @Test
    void theDifferenceToTheModelFadesAway() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.9);
        double[] kmh = {28};
        // the car gives a value 0.5 L/h above the model's for 6 s at 28 km/h, then none
        Car gives = (v, a) -> (int) Math.round((trueLph(v, a, 0.9) + 0.5) / v * 1000);
        t = ride(m, t, kmh, 0, 0, 6, gives, new Log());
        Log log = new Log();
        // the difference fades with a time constant of 60 s: after 5 minutes it is the model's
        t = ride(m, t, kmh, 0, 0, 300, (v, a) -> 65535, log);
        double withoutTheShift = m.litresPerHour(t - 200) / 28 * 100;
        assertEquals(withoutTheShift, log.estimates.get(log.estimates.size() - 1), 0.1);
        // and at first it is the car's last value, well above the model
        assertTrue(log.estimates.get(0) - m.litresPerHour(t) / 28 * 100 > 0.8, "" + log.estimates.get(0));
    }

    /** One crossing of the threshold while speeding up, 20 → 35 km/h, the car burning 1 L/h more there: the jump. */
    private static double speedUpJump(FuelModel m, long[] clock) {
        double[] kmh = {20};
        Car car = aboveThirty(0.9, 1.0);
        Log silent = new Log();
        long t = ride(m, clock[0], kmh, 0, 0, 30, car, silent);     // long enough for an earlier handover to fade
        Log log = new Log();
        t = ride(m, t, kmh, 0.8, 35, 20, car, log);
        t = ride(m, t, kmh, 0, 0, 3, aboveThirty(0.9, 0), new Log());
        t = ride(m, t, kmh, -1.0, 20, 20, aboveThirty(0.9, 0), new Log());
        clock[0] = t;
        return log.firstCarL100 - log.estimateBeforeTheCar;
    }

    @Test
    void speedingUpTheJumpShrinksAsTheEdgeIsLearned() {
        FuelModel m = new FuelModel();
        long[] clock = {drive(m, new Random(1), 0, 900, 30, 0.9)};
        double first = speedUpJump(m, clock);
        double last = 0;
        for (int i = 1; i < 20; i++) {
            double jump = speedUpJump(m, clock);
            if (i >= 15) {
                last += jump / 5;
            }
        }
        assertTrue(first > 1, "the first jump " + first);
        assertTrue(last < first * 0.5, "the first jump " + first + ", the last ones " + last);
    }

    @Test
    void theEdgeCorrectionReadsBack() {
        FuelModel m = new FuelModel();
        long[] clock = {drive(m, new Random(1), 0, 900, 30, 0.9)};
        for (int i = 0; i < 6; i++) {
            speedUpJump(m, clock);
        }
        String text = m.serialize();
        assertTrue(text.startsWith("3;"));
        String[] f = text.split(";", -1);
        assertFalse(f[8].equals("0.0") && f[9].equals("0"), text);
        FuelModel back = FuelModel.parse(text);
        assertEquals(text, back.serialize());
        // the same ride from the same state: the same jump, and a smaller one than with no correction
        double withEdge = speedUpJump(FuelModel.parse(text), new long[]{clock[0]});
        assertEquals(withEdge, speedUpJump(back, new long[]{clock[0]}), 1e-9);

        // the same text with no correction
        f[8] = "0.0";
        f[9] = "0";
        FuelModel none = FuelModel.parse(String.join(";", f));
        assertTrue(none.calibrated());
        assertTrue(speedUpJump(none, new long[]{clock[0]}) > withEdge + 0.3);
        // an unknown format, a cut text and a bad correction: a new model
        assertFalse(FuelModel.parse("4" + text.substring(1)).calibrated());
        assertFalse(FuelModel.parse(text.substring(0, text.lastIndexOf(';'))).calibrated());
        assertFalse(FuelModel.parse(text.substring(0, text.length() - 1) + "x").calibrated());
        f = text.split(";", -1);
        f[8] = "9.0";
        assertFalse(FuelModel.parse(String.join(";", f)).calibrated());
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
        // the acceleration the model measures over 2 s is not exactly the car's: close, not exact. At the
        // threshold, where the learned line applies; below it the level is anchored in the idle
        assertTrue(cut.coastAt(cut.thresholdKmh()) < 0.5, "cut: " + cut.coastAt(cut.thresholdKmh()));
        assertEquals(1.0, idle.coastAt(idle.thresholdKmh()), 0.25);
        assertTrue(idle.coastAt(idle.thresholdKmh()) - cut.coastAt(cut.thresholdKmh()) > 0.5);
        double cutBelow = cut.coastAt(cut.thresholdKmh() / 2);
        assertTrue(cutBelow > cut.coastAt(cut.thresholdKmh()) && cutBelow < cut.idle(), "halfway: " + cutBelow);
        // before any sample of slowing down: from the starting level at the threshold to the starting idle at a stop
        FuelModel fresh = new FuelModel();
        double atTheThreshold = 0.6 + 0.02 * 30 / 3.6;
        assertEquals(0.8 + (atTheThreshold - 0.8) * 20 / 30, fresh.coastAt(20), 0.01);
        assertEquals(0.8, fresh.coastAt(0), 0.01);
        assertEquals(atTheThreshold, fresh.coastAt(30), 0.01);
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
        // 3 km/h from a canbus code is driving, but under 10 km/h it is in litres per hour; from the GPS a stop
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 3, true);
        }
        assertTrue(m.isMoving());
        assertTrue(m.estimate(t).perHour);
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
        // a few seconds at a stop with ~800 RPM first: the RPM passes the checks and the idle RPM is learned
        for (int i = 0; i < 40; i++, t += 200) {
            m.onSpeed(t, 0, true);
            m.onRpm(t, 780 + rnd.nextInt(40));
        }
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

    @Test
    void withTheRpmTheIdleWhileRollingIsTheIdleAndEngineBrakingIsZero() {
        FuelModel m = new FuelModel();
        long t = driveRpm(m, new Random(11), 0, 1800, 30);
        assertTrue(m.calibrated());
        assertTrue(m.rpmValid());
        assertEquals(800, m.idleRpm(), 60);
        // rolling in neutral at ~800 RPM burns the idle
        double rolling = litresAt(m, t, 30, 0, 800);
        assertEquals(m.idle(), rolling, 0.15);
        assertEquals(1.0, rolling, 0.3);
        // slowing down in gear from 1800 RPM: the car cuts the fuel
        double braking = litresAt(m, t + 10_000, 30, -0.8, 1800);
        assertTrue(braking < 0.2, "engine braking: " + braking);
        // the same slowing down at the revs of the idle is rolling, not engine braking
        assertEquals(m.idle(), litresAt(m, t + 20_000, 30, -0.8, 800), 0.15);
    }

    @Test
    void theEngineOffIsZero() {
        FuelModel m = new FuelModel();
        long t = driveRpm(m, new Random(12), 0, 900, 30);
        // stopped, the engine at the idle: the idle; then the engine off: nothing
        FuelModel.Estimate e = null;
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 0, true);
            m.onRpm(t, 800);
            m.onFuel(t, 65535);
            e = m.estimate(t);
        }
        assertTrue(e.perHour);
        assertEquals(m.idle(), e.value, 0.3);
        for (int i = 0; i < 50; i++, t += 200) {
            m.onSpeed(t, 0, true);
            m.onRpm(t, 0);
            m.onFuel(t, 65535);
            e = m.estimate(t);
        }
        assertTrue(e.perHour);
        assertEquals("0.0", e.text());
        // and the RPM that is no longer fresh does not count: the idle again
        t += 10_000;
        for (int i = 0; i < 50; i++, t += 200) {
            m.onSpeed(t, 0, true);
            m.onFuel(t, 65535);
            e = m.estimate(t);
        }
        assertEquals(m.idle(), e.value, 0.3);
    }

    @Test
    void theCarDataMovesThePriorsNotTheLearning() {
        FuelModel light = new FuelModel();
        light.setCar(1000, 1000);
        FuelModel heavy = new FuelModel();
        heavy.setCar(2000, 3000);
        assertTrue(light.idle() < heavy.idle(), light.idle() + " / " + heavy.idle());
        assertEquals(0.5, light.idle(), 1e-9);
        assertEquals(1.1, heavy.idle(), 1e-9);
        assertEquals(light.serialize(), heavy.serialize());
        // before any learning the heavier car burns more at 20 km/h speeding up
        double l = litresAt(light, 0, 20, 0.5, -1);
        double h = litresAt(heavy, 0, 20, 0.5, -1);
        assertTrue(h > l + 0.2, l + " / " + h);
        // the same ride teaches both the same: the text is the same
        drive(light, new Random(1), 100_000, 120, 30, 0.9);
        drive(heavy, new Random(1), 100_000, 120, 30, 0.9);
        assertEquals(light.serialize(), heavy.serialize());
        // outside the limits is unknown: as if it were not given
        FuelModel unknown = new FuelModel();
        unknown.setCar(100, 100000);
        assertEquals(new FuelModel().idle(), unknown.idle(), 1e-9);
        // with both, the calibration is shorter
        FuelModel with = new FuelModel();
        with.setCar(1300, 1600);
        FuelModel without = new FuelModel();
        drive(with, new Random(2), 0, 100, 30, 0.9);
        drive(without, new Random(2), 0, 100, 30, 0.9);
        assertTrue(with.calibrated());
        assertFalse(without.calibrated());
    }

    @Test
    void theBiasOfTheLastValuesCarriesBelowTheThreshold() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 1800, 30, 0.9);
        double[] kmh = {36};
        // for a minute the car burns 0.5 L/h more than the model, then it goes silent while slowing down gently
        t = ride(m, t, kmh, 0, 0, 20, aboveThirty(0.9, 0), new Log());
        t = ride(m, t, kmh, 0, 0, 60, aboveThirty(0.9, 0.5), new Log());
        long silent = t;
        t = ride(m, t, kmh, -0.25, 25, 60, aboveThirty(0.9, 0.5), new Log());
        // steady at 25 km/h; the model without the bias, and the estimate at 10 s, 60 s and 5 minutes
        double[] after = {10, 60, 300};
        double[] diff = new double[3];
        int next = 0;
        long since = t;
        for (long at = t; next < 3; at += 200) {
            m.onSpeed(at, 25, true);
            if ((at - t) % 1000 == 0) {
                m.onFuel(at, 65535);
            }
            FuelModel.Estimate e = m.estimate(at);
            if (at - t >= after[next] * 1000) {
                diff[next] = lph(e, 25) - m.litresPerHour(at);
                next++;
            }
        }
        double fromTheLastValue = (t - silent) / 1000.0;
        for (int i = 0; i < 2; i++) {
            double expected = 0.5 * Math.exp(-(after[i] + fromTheLastValue) / 60.0);
            assertEquals(expected, diff[i], 0.1, "after " + after[i] + " s");
        }
        assertEquals(0, diff[2], 0.05);
    }

    @Test
    void aSilenceAtSpeedIsNoThreshold() {
        // a car that gives its value at any speed and then is silent at 80 km/h: a fault, not a threshold
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 0, 0.9);
        assertTrue(m.calibrated());
        for (int i = 0; i < 100; i++, t += 200) {
            m.onSpeed(t, 80, true);
            if (i % 5 == 0) {
                m.onFuel(t, 65535);
            }
            assertNull(m.estimate(t));
        }
        // and down at 25 km/h it has never been silent below: no estimate either
        m.onFuel(t, 800);
        assertNull(silentAt(m, t, 25, 0));
        assertFalse(m.thresholdCar());
        // a car silent below 30 km/h is a threshold car, and silent at 80 km/h still no estimate
        FuelModel c = new FuelModel();
        t = drive(c, new Random(1), 0, 900, 30, 0.9);
        assertTrue(c.thresholdCar());
        assertNotNull(silentAt(c, t, 20, 0));
        for (int i = 0; i < 25; i++, t += 200) {
            c.onSpeed(t, 80, true);
            if (i % 5 == 0) {
                c.onFuel(t, 65535);
            }
        }
        assertNull(c.estimate(t));
    }

    @Test
    void theUnitFollowsTheSpeedWithAHysteresis() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.9);
        double[] kmh = {9};
        Car silent = (v, a) -> 65535;
        // steadily 9 km/h: in litres per hour; 12 on the way up: still; 14: litres per 100 km; 12 on the way down: still
        t = ride(m, t, kmh, 0, 0, 12, silent, new Log());
        FuelModel.Estimate e = m.estimate(t);
        assertTrue(m.lowSpeed());
        assertTrue(e.perHour, "9 km/h");
        t = ride(m, t, kmh, 0.1, 12, 60, silent, new Log());
        t = ride(m, t, kmh, 0, 0, 12, silent, new Log());
        assertTrue(m.lowSpeed());
        assertTrue(m.estimate(t).perHour, "12 km/h on the way up");
        t = ride(m, t, kmh, 0.1, 14, 60, silent, new Log());
        t = ride(m, t, kmh, 0, 0, 12, silent, new Log());
        assertFalse(m.lowSpeed());
        assertFalse(m.estimate(t).perHour, "14 km/h");
        t = ride(m, t, kmh, -0.1, 12, 60, silent, new Log());
        t = ride(m, t, kmh, 0, 0, 12, silent, new Log());
        assertFalse(m.lowSpeed());
        assertFalse(m.estimate(t).perHour, "12 km/h on the way down");
    }

    @Test
    void theOldFormatsReadBackCalibrated() {
        FuelModel first = FuelModel.parse(TEXT_1);
        FuelModel second = FuelModel.parse(TEXT_2);
        for (FuelModel m : new FuelModel[]{first, second}) {
            assertTrue(m.calibrated());
            assertTrue(m.thresholdCar());
            assertEquals(22.899999999999316, m.thresholdKmh(), 1e-9);
            assertTrue(m.serialize().startsWith("3;"));
            assertEquals(m.serialize(), FuelModel.parse(m.serialize()).serialize());
            for (double[] ref : LEGACY_LPH) {
                double got = litresAt(FuelModel.parse(m.serialize()), 20_000_000L, ref[0], ref[1], -1);
                assertEquals(ref[2], got, 0.3, "at " + ref[0] + " km/h, " + ref[1] + " m/s²");
            }
        }
        // the learning of the old model carries over as it is for the slowing down
        assertEquals(first.coastAt(25), second.coastAt(25), 1e-9);
        // an unknown format is a new model
        assertFalse(FuelModel.parse("4" + TEXT_2.substring(1)).calibrated());
        assertFalse(FuelModel.parse("2;1;2;3").calibrated());
    }

    @Test
    void anImplausibleRpmIsNotUsed() {
        FuelModel m = new FuelModel();
        Random rnd = new Random(13);
        long t = 0;
        // a code of 0-255, such as a counter: it fails at a stop and at speed
        for (int step = 0; step < 900 * 5; step++, t += 200) {
            double kmh = step % 150 < 40 ? 0 : 40;
            m.onSpeed(t, kmh, true);
            m.onRpm(t, rnd.nextInt(256));
            if (step % 5 == 0) {
                m.onFuel(t, kmh > 30 ? (int) Math.round(trueLph(kmh, 0, 0.9) / kmh * 1000) : 65535);
            }
        }
        assertFalse(m.rpmValid());
        assertEquals(0, m.driveCoefficients()[5], 1e-6);
        // plausible RPM is used
        FuelModel good = new FuelModel();
        driveRpm(good, new Random(13), 0, 300, 30);
        assertTrue(good.rpmValid());
    }

    @Test
    void aSpeedCodeThatDoesNotFollowTheGpsIsDropped() {
        // the revs (700-3000) against a GPS speed of 30-90 km/h: not a speed, whatever scale it would have
        FuelModel.SpeedScale revs = new FuelModel.SpeedScale(0);
        FuelModel.SpeedScale known = new FuelModel.SpeedScale(100);
        for (int i = 0; i < 30; i++) {
            double gps = 30 + 2 * i;
            int rpm = 700 + 80 * i;
            revs.onValue(rpm);
            revs.onGps(gps);
            known.onValue(rpm);
            known.onGps(gps);
            if (i == 8) {
                // too early to judge: the known scale stands, the unknown one is not known yet
                assertEquals(100, known.scale());
                assertEquals(0, revs.scale());
            }
        }
        assertEquals(0, revs.scale());
        assertEquals(0, known.scale());
        // a code that follows it, 100 times the speed within 20 %, stays; 30 % off does not
        FuelModel.SpeedScale good = new FuelModel.SpeedScale(100);
        FuelModel.SpeedScale off = new FuelModel.SpeedScale(100);
        for (int i = 0; i < 30; i++) {
            double gps = 30 + 2 * i;
            good.onValue((int) Math.round(gps * 100 * (i % 2 == 0 ? 1.1 : 0.9)));
            good.onGps(gps);
            off.onValue((int) Math.round(gps * 100 * 1.3));
            off.onGps(gps);
        }
        assertEquals(100, good.scale());
        assertEquals(0, off.scale());
        // and the scale found from the GPS is the one of a code that follows it, as before
        FuelModel.SpeedScale tens = new FuelModel.SpeedScale(0);
        for (int i = 0; i < 30; i++) {
            tens.onValue((30 + i) * 10);
            tens.onGps(30 + i);
        }
        assertEquals(10, tens.scale());
    }

    @Test
    void theRpmChecksFollowTheRanges() {
        // at a stop (3 s and more): 0 or 450-1500; 1800 revs standing still fail
        FuelModel standing = new FuelModel();
        long t = 0;
        for (int i = 0; i < 80; i++, t += 200) {
            standing.onSpeed(t, 0, true);
            standing.onRpm(t, i < 15 ? 3000 : 1800);      // the first 3 s are not checked
        }
        assertFalse(standing.rpmValid());
        FuelModel idle = new FuelModel();
        t = 0;
        for (int i = 0; i < 80; i++, t += 200) {
            idle.onSpeed(t, 0, true);
            idle.onRpm(t, i % 3 == 0 ? 0 : 450 + i);
        }
        assertTrue(idle.rpmValid());
        // above 20 km/h: 600-7000; 300 is not revs
        FuelModel slow = new FuelModel();
        FuelModel fast = new FuelModel();
        t = 0;
        for (int i = 0; i < 80; i++, t += 200) {
            slow.onSpeed(t, 40, true);
            slow.onRpm(t, 300);
            fast.onSpeed(t, 40, true);
            fast.onRpm(t, 600 + 80 * i);
        }
        assertFalse(slow.rpmValid());
        assertTrue(fast.rpmValid());
        // under 20 km/h there is nothing to check it against: not valid yet
        FuelModel creeping = new FuelModel();
        t = 0;
        for (int i = 0; i < 80; i++, t += 200) {
            creeping.onSpeed(t, 10, true);
            creeping.onRpm(t, 1500);
        }
        assertFalse(creeping.rpmValid());
        // 80 % of the first 30 must pass: 24 do, 23 do not
        for (int passing : new int[]{24, 23}) {
            FuelModel m = new FuelModel();
            t = 0;
            for (int i = 0; i < 30; i++, t += 200) {
                m.onSpeed(t, 40, true);
                m.onRpm(t, i < passing ? 2000 : 100);
            }
            assertEquals(passing == 24, m.rpmValid(), passing + " of 30");
        }
        // out of 0-8000 fails anywhere
        FuelModel wild = new FuelModel();
        t = 0;
        for (int i = 0; i < 40; i++, t += 200) {
            wild.onSpeed(t, 40, true);
            wild.onRpm(t, i % 2 == 0 ? 9000 : 2000);
        }
        assertFalse(wild.rpmValid());
    }

    /** Feeds 40 s at a speed with altitudes along a road of a given grade (fix every 1 s, σ 0.5 m, a barometer); returns the time. */
    private static long onTheRoad(FuelModel m, long t0, double kmh, double grade) {
        long t = t0;
        double metres = 0;
        for (int i = 0; i < 40 * 5; i++, t += 200) {
            m.onSpeed(t, kmh, true);
            metres += kmh / 3.6 * 0.2;
            if (i % 5 == 0) {
                m.onBarometer(t, 300 + grade * metres);
            }
        }
        return t;
    }

    @Test
    void uphillAtASteadySpeedBurnsMoreThanOnTheFlat() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.9);
        FuelModel flat = FuelModel.parse(m.serialize());
        FuelModel hill = FuelModel.parse(m.serialize());
        double onTheFlat = flat.litresPerHour(onTheRoad(flat, t + 100_000, 20, 0) - 200);
        double uphill = hill.litresPerHour(onTheRoad(hill, t + 100_000, 20, 0.06) - 200);
        // 6 % at 20 km/h is a lift of 0.59 m/s², an acceleration as far as the engine goes: 0.1·0.59·5.6 = 0.33 L/h more
        // in this car
        assertEquals(onTheFlat + 0.33, uphill, 0.1);
    }

    @Test
    void aSteepDescentAtASteadySpeedIsOverrun() {
        FuelModel cut = new FuelModel();
        long t = drive(cut, new Random(1), 0, 900, 30, 0.0);
        FuelModel flat = FuelModel.parse(cut.serialize());
        FuelModel down = FuelModel.parse(cut.serialize());
        double onTheFlat = flat.litresPerHour(onTheRoad(flat, t + 100_000, 25, 0) - 200);
        double downhill = down.litresPerHour(onTheRoad(down, t + 100_000, 25, -0.06) - 200);
        // -6 % at 25 km/h is -0.59 m/s² with no braking at all: the engine brakes, and the fuel is cut
        assertTrue(onTheFlat > 1.0, "flat " + onTheFlat);
        assertTrue(downhill < onTheFlat - 0.7, onTheFlat + " -> " + downhill);
        // and without altitudes the same drive is just steady
        FuelModel none = FuelModel.parse(cut.serialize());
        long end = t + 100_000;
        for (int i = 0; i < 200; i++, end += 200) {
            none.onSpeed(end, 25, true);
        }
        assertEquals(onTheFlat, none.litresPerHour(end - 200), 0.05);
    }

    @Test
    void theBarometerReplacesTheGpsAltitudeAndIsReplacedByItOnceItIsGone() {
        FuelModel m = new FuelModel();
        long t = drive(m, new Random(1), 0, 900, 30, 0.9) + 100_000;
        // a barometer on a 6 % climb; a GPS altitude on a flat road 4 s later is not taken into the regression
        t = onTheRoad(m, t, 20, 0.06);
        double withBaro = m.litresPerHour(t - 200);
        for (int i = 0; i < 20; i++, t += 200) {
            m.onSpeed(t, 20, true);
            m.onAltitude(t, 50, 10);        // nothing like the barometer's level, and σ of 10 m
        }
        assertEquals(withBaro, m.litresPerHour(t - 200), 0.2);
        // 6 s without the barometer: the GPS goes on from a clean start (a flat road, noisy): no grade
        t += 6000;
        for (int i = 0; i < 300; i++, t += 200) {
            m.onSpeed(t, 20, true);
            if (i % 5 == 0) {
                m.onAltitude(t, 50 + ((i / 5) % 2 == 0 ? 2 : -2), 10);
            }
        }
        FuelModel flat = FuelModel.parse(m.serialize());
        long ft = onTheRoad(flat, 50_000_000L, 20, 0);
        assertEquals(flat.litresPerHour(ft - 200), m.litresPerHour(t - 200), 0.3);
    }
}
