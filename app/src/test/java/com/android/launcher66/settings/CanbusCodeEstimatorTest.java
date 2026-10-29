package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusCodeEstimator.Category;
import com.android.launcher66.settings.CanbusCodeEstimator.GpsFix;
import com.android.launcher66.settings.CanbusCodeEstimator.Guess;
import com.android.launcher66.settings.CanbusCodeEstimator.Result;
import com.android.launcher66.settings.CanbusCodeEstimator.Sample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class CanbusCodeEstimatorTest {

    private static Guess guessFor(Result r, int code) {
        for (Guess g : r.guesses) {
            if (g.code == code) {
                return g;
            }
        }
        return null;
    }

    private static Map<Integer, List<Sample>> one(int code, List<Sample> samples) {
        Map<Integer, List<Sample>> m = new HashMap<>();
        m.put(code, samples);
        return m;
    }

    @Test
    void instantFuelConsumptionThatVaries() {
        Random rnd = new Random(1);
        List<Sample> s = new ArrayList<>();
        int v = 80;
        for (int i = 0; i < 200; i++) {
            v = Math.max(40, Math.min(130, v + rnd.nextInt(13) - 6));
            s.add(new Sample(i * 1000L, v));
        }
        Result r = CanbusCodeEstimator.estimate(one(91, s), null);
        Guess g = guessFor(r, 91);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.FUEL_INSTANT, g.category);
        assertTrue(g.score >= 0.5);
        assertTrue(g.reason.contains("L/100 km as value/10"), g.reason);
        assertTrue(g.toString().startsWith("Code 91 - fuel consumption, instant ("));
    }

    @Test
    void rangeThatCountsDownEveryFiftySeconds() {
        List<Sample> s = new ArrayList<>();
        for (int sec = 0; sec <= 300; sec++) {
            s.add(new Sample(sec * 1000L, 418 - sec / 50));
        }
        Result r = CanbusCodeEstimator.estimate(one(92, s), null);
        Guess g = guessFor(r, 92);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.RANGE, g.category);
        assertTrue(g.reason.contains("412-418 km"), g.reason);
        assertTrue(g.reason.contains("about every 50 s"), g.reason);
    }

    @Test
    void rangeThatDidNotChangeIsAWeakGuessWithANote() {
        List<Sample> s = new ArrayList<>();
        for (int sec = 0; sec <= 120; sec++) {
            s.add(new Sample(sec * 1000L, 412));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(92, s), null), 92);
        assertNotNull(g);
        assertEquals(Category.RANGE, g.category);
        assertTrue(g.reason.contains("did not change while recording"));
        assertEquals(0.5, g.score, 1e-9);
    }

    @Test
    void rpmWithAnIdleAndThenDriving() {
        Random rnd = new Random(2);
        List<Sample> s = new ArrayList<>();
        long t = 0;
        for (int i = 0; i < 120; i++, t += 1000) {
            s.add(new Sample(t, 750 + rnd.nextInt(41) - 20));
        }
        int v = 900;
        for (int i = 0; i < 60; i++, t += 1000) {
            v = Math.max(900, Math.min(3000, v + rnd.nextInt(401) - 150));
            s.add(new Sample(t, v));
        }
        Result r = CanbusCodeEstimator.estimate(one(103, s), null);
        Guess g = guessFor(r, 103);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.RPM, g.category);
        assertTrue(g.reason.contains("at idle"), g.reason);
        assertTrue(g.reason.contains("about 750 at idle") || g.reason.contains("about 740 at idle")
                || g.reason.contains("about 760 at idle"), g.reason);
    }

    @Test
    void speedThatFollowsTheGps() {
        Random rnd = new Random(3);
        List<Sample> s = new ArrayList<>();
        List<GpsFix> gps = new ArrayList<>();
        double speed = 0;
        for (int sec = 0; sec < 240; sec++) {
            double target = sec < 30 ? 0 : sec < 120 ? 87 : 40;
            speed += Math.max(-6, Math.min(6, target - speed)) + rnd.nextInt(3) - 1;
            speed = Math.max(0, speed);
            s.add(new Sample(sec * 1000L, (int) Math.round(speed)));
            gps.add(new GpsFix(sec * 1000L, (float) Math.round(speed)));
        }
        Result r = CanbusCodeEstimator.estimate(one(45, s), gps);
        Guess g = guessFor(r, 45);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.SPEED, g.category);
        assertTrue(g.score >= 0.9);
        assertTrue(g.reason.contains("follows the GPS speed"), g.reason);
    }

    @Test
    void aSwitchOfZerosAndOnes() {
        List<Sample> s = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            s.add(new Sample(i * 1000L, (i / 10) % 2));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(7, s), null), 7);
        assertNotNull(g);
        assertEquals(Category.SWITCH, g.category);
    }

    @Test
    void aConstantIsNotAssignedAndEverythingIsNotFound() {
        List<Sample> s = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            s.add(new Sample(i * 1000L, 7));
        }
        Result r = CanbusCodeEstimator.estimate(one(5, s), null);
        assertTrue(r.guesses.isEmpty(), r.guesses.toString());
        assertTrue(r.notFoundLine().startsWith("Not found: fuel consumption, instant, fuel consumption, average"),
                r.notFoundLine());
        assertFalse(r.notFoundLine().contains("switch"));
    }

    @Test
    void anEmptySeriesAndNoInputAreHandled() {
        Result none = CanbusCodeEstimator.estimate(null, null);
        assertTrue(none.guesses.isEmpty());
        assertFalse(none.notFound.isEmpty());
        Result empty = CanbusCodeEstimator.estimate(one(1, new ArrayList<Sample>()), new ArrayList<GpsFix>());
        assertTrue(empty.guesses.isEmpty());
        List<Sample> single = new ArrayList<>();
        single.add(new Sample(0, 3));
        assertTrue(CanbusCodeEstimator.estimate(one(1, single), null).guesses.isEmpty());
    }

    @Test
    void severalCodesAreSortedIntoTheirCategoriesAndAtMostThreePerCategory() {
        Random rnd = new Random(4);
        Map<Integer, List<Sample>> m = new HashMap<>();
        for (int code = 10; code < 16; code++) {
            List<Sample> s = new ArrayList<>();
            int v = 60;
            for (int i = 0; i < 100; i++) {
                v = Math.max(40, Math.min(130, v + rnd.nextInt(9) - 4));
                s.add(new Sample(i * 1000L, v));
            }
            m.put(code, s);
        }
        List<Sample> range = new ArrayList<>();
        for (int sec = 0; sec <= 300; sec++) {
            range.add(new Sample(sec * 1000L, 418 - sec / 50));
        }
        m.put(92, range);
        Result r = CanbusCodeEstimator.estimate(m, null);
        int fuel = 0;
        for (Guess g : r.guesses) {
            if (g.category == Category.FUEL_INSTANT) {
                fuel++;
            }
        }
        assertEquals(3, fuel);
        assertEquals(Category.RANGE, guessFor(r, 92).category);
        // ordered by the category, the best first
        for (int i = 1; i < r.guesses.size(); i++) {
            Guess a = r.guesses.get(i - 1);
            Guess b = r.guesses.get(i);
            assertTrue(a.category.ordinal() < b.category.ordinal()
                    || (a.category == b.category && a.score >= b.score));
        }
    }

    // ---- series like the ones of the owner's drives

    /** A drive of 300 s: stands, accelerates in the city, a few stops; the speed in km/h per second. */
    private static double[] cityDrive(Random rnd) {
        double[] kmh = new double[300];
        double v = 0;
        for (int sec = 0; sec < kmh.length; sec++) {
            double target = (sec / 40) % 2 == 0 ? 43 : 0;
            v += Math.max(-8, Math.min(6, target - v)) + rnd.nextInt(3) - 1;
            v = Math.max(0, v);
            kmh[sec] = v;
        }
        return kmh;
    }

    @Test
    void instantConsumptionWithNoValueMarkersBelowFortyKmh() {
        Random rnd = new Random(11);
        double[] kmh = cityDrive(rnd);
        List<Sample> s = new ArrayList<>();
        List<GpsFix> gps = new ArrayList<>();
        int markers = 0;
        for (int sec = 0; sec < kmh.length; sec++) {
            gps.add(new GpsFix(sec * 1000L, (float) kmh[sec]));
            if (kmh[sec] < 40) {
                s.add(new Sample(sec * 1000L, 65535));
                markers++;
            } else {
                s.add(new Sample(sec * 1000L, 60 + rnd.nextInt(60)));
            }
        }
        Result r = CanbusCodeEstimator.estimate(one(91, s), gps);
        Guess g = guessFor(r, 91);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.FUEL_INSTANT, g.category);
        assertTrue(g.reason.contains("65535 = no value " + markers + "×"), g.reason);
    }

    @Test
    void speedInHundredthsOfKmhIsASpeedNotTheRpm() {
        Random rnd = new Random(12);
        double[] kmh = cityDrive(rnd);
        List<Sample> s = new ArrayList<>();
        List<GpsFix> gps = new ArrayList<>();
        for (int sec = 0; sec < kmh.length; sec++) {
            s.add(new Sample(sec * 1000L, (int) Math.round(kmh[sec]) * 100));
            gps.add(new GpsFix(sec * 1000L, (float) Math.round(kmh[sec])));
        }
        Result r = CanbusCodeEstimator.estimate(one(510, s), gps);
        Guess g = guessFor(r, 510);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.SPEED, g.category);
        assertTrue(g.reason.contains("km/h as value/100"), g.reason);
        assertTrue(g.reason.contains("follows the GPS speed"), g.reason);
        assertTrue(g.score >= 0.9);

        // the same series without the GPS is not the RPM either
        Guess noGps = guessFor(CanbusCodeEstimator.estimate(one(510, s), null), 510);
        assertTrue(noGps == null || noGps.category != Category.RPM, String.valueOf(noGps));
    }

    @Test
    void speedOnTheMotorwayInHundredthsHasAScale() {
        Random rnd = new Random(13);
        List<Sample> s = new ArrayList<>();
        List<GpsFix> gps = new ArrayList<>();
        double v = 100;
        for (int sec = 0; sec < 300; sec++) {
            v = Math.max(84, Math.min(124, v + rnd.nextInt(7) - 3));
            s.add(new Sample(sec * 1000L, (int) Math.round(v) * 100));
            gps.add(new GpsFix(sec * 1000L, (float) Math.round(v)));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(510, s), gps), 510);
        assertNotNull(g);
        assertEquals(Category.SPEED, g.category);
    }

    @Test
    void rangeThatMovesInTensIsARangeInTenKmSteps() {
        List<Sample> s = new ArrayList<>();
        for (int sec = 0; sec <= 300; sec++) {
            s.add(new Sample(sec * 1000L, sec < 120 ? 310 : sec < 250 ? 300 : 290));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(92, s), null), 92);
        assertNotNull(g);
        assertEquals(Category.RANGE, g.category);
        assertTrue(g.reason.contains("in 10 km steps"), g.reason);
        assertTrue(g.reason.contains("290-310 km"), g.reason);
    }

    @Test
    void rangeThatWentUpOnceAfterGoingDown() {
        List<Sample> s = new ArrayList<>();
        int[] steps = {310, 300, 290, 300, 290};
        for (int sec = 0; sec <= 300; sec++) {
            s.add(new Sample(sec * 1000L, steps[Math.min(4, sec / 60)]));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(92, s), null), 92);
        assertNotNull(g);
        assertEquals(Category.RANGE, g.category);
    }

    @Test
    void mileageWithALeadingZeroAndStepsOfOne() {
        List<Sample> s = new ArrayList<>();
        s.add(new Sample(0, 0));
        int km = 108782;
        for (int sec = 1; sec <= 300; sec++) {
            if (sec % 40 == 0) {
                km++;
            }
            s.add(new Sample(sec * 1000L, km));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(512, s), null), 512);
        assertNotNull(g);
        assertEquals(Category.ODOMETER, g.category);
        assertTrue(g.score >= 0.8, String.valueOf(g.score));
        assertTrue(g.reason.contains("every step +1"), g.reason);
        assertTrue(g.reason.startsWith("108782-"), g.reason);
    }

    @Test
    void zerosAndOnesWithFewChangesAreASwitchNotATemperature() {
        List<Sample> s = new ArrayList<>();
        for (int sec = 0; sec < 300; sec++) {
            s.add(new Sample(sec * 1000L, sec < 100 || sec >= 200 ? 0 : 1));
        }
        List<Sample> late = new ArrayList<>();
        for (int sec = 0; sec < 300; sec++) {
            late.add(new Sample(sec * 1000L, sec < 100 ? 0 : 1));
        }
        Map<Integer, List<Sample>> m = new HashMap<>();
        m.put(518, s);
        m.put(99, late);
        Result r = CanbusCodeEstimator.estimate(m, null);
        assertEquals(Category.SWITCH, guessFor(r, 518).category);
        assertEquals(Category.SWITCH, guessFor(r, 99).category);
        for (Guess g : r.guesses) {
            assertTrue(g.category == Category.SWITCH, g.toString());
        }
    }

    @Test
    void aSmoothSeriesOfStepsOfOneIsTheAverageConsumption() {
        Random rnd = new Random(14);
        List<Sample> s = new ArrayList<>();
        int v = 150;
        for (int sec = 0; sec < 300; sec++) {
            if (sec % 4 == 0) {
                v = Math.max(119, Math.min(179, v + (rnd.nextBoolean() ? 1 : -1)));
            }
            s.add(new Sample(sec * 1000L, v));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(1033, s), null), 1033);
        assertNotNull(g);
        assertEquals(Category.FUEL_AVERAGE, g.category);
    }

    @Test
    void aJumpySeriesIsNotTheAverageConsumption() {
        Random rnd = new Random(15);
        List<Sample> s = new ArrayList<>();
        for (int sec = 0; sec < 300; sec++) {
            s.add(new Sample(sec * 1000L, 40 + rnd.nextInt(200)));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(1033, s), null), 1033);
        assertNotNull(g);
        assertEquals(Category.FUEL_INSTANT, g.category);
    }

    @Test
    void anIdleRpmWithoutSpeedKeepsBeingTheRpm() {
        // 750 at idle and then up to 2500: the idle cluster says it is an engine, with or without the GPS
        Random rnd = new Random(16);
        List<Sample> s = new ArrayList<>();
        long t = 0;
        for (int i = 0; i < 150; i++, t += 1000) {
            s.add(new Sample(t, 740 + rnd.nextInt(30)));
        }
        for (int i = 0; i < 60; i++, t += 1000) {
            s.add(new Sample(t, 900 + rnd.nextInt(1600)));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(524, s), null), 524);
        assertNotNull(g);
        assertEquals(Category.RPM, g.category);
    }

    @Test
    void theAddOnBlockListsTheCodesThatChanged() {
        Map<Integer, List<Sample>> m = new HashMap<>();
        List<Sample> left = new ArrayList<>();
        List<Sample> rpm = new ArrayList<>();
        for (int sec = 0; sec < 100; sec++) {
            left.add(new Sample(sec * 1000L, (sec / 5) % 2));
            rpm.add(new Sample(sec * 1000L, 0));
        }
        m.put(505, left);
        m.put(524, rpm);
        Result r = CanbusCodeEstimator.estimate(m, null);
        assertTrue(r.addOnLines.get(0).startsWith("Add-on data block 500-559 (names from the canbus app, ConstRzcAddData"),
                r.addOnLines.toString());
        assertEquals(2, r.addOnLines.size());
        assertEquals("Code 505 - left turn signal (19 changes)", r.addOnLines.get(1));
        Result none = CanbusCodeEstimator.estimate(one(7, left), null);
        assertTrue(none.addOnLines.isEmpty());
    }

    // ---- the heading, and a scaled speed without the GPS

    /** A direction of travel that turns now and then, sampled every second; degrees 0..359. */
    private static List<Sample> heading(Random rnd, int start, int seconds) {
        List<Sample> s = new ArrayList<>();
        double h = start;
        double turn = 0;
        for (int sec = 0; sec < seconds; sec++) {
            if (sec % 25 == 0) {
                turn = rnd.nextInt(3) == 0 ? 0 : (rnd.nextBoolean() ? 1 : -1) * (3 + rnd.nextInt(6));
            }
            h = (h + turn + rnd.nextInt(3) - 1 + 360) % 360;
            s.add(new Sample(sec * 1000L, (int) Math.round(h) % 360));
        }
        return s;
    }

    @Test
    void aDirectionThatGoesRoundIsTheHeadingNotTheConsumption() {
        // like code 1033 of the owner's car: 14..329, which the old guesses took for 1.4-32.9 L/100 km
        List<Sample> s = heading(new Random(21), 330, 300);
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(1033, s), null), 1033);
        assertNotNull(g);
        assertEquals(Category.HEADING, g.category);
        assertTrue(g.reason.contains("goes round 359-0"), g.reason);
    }

    @Test
    void aDirectionThatFollowsTheGpsIsTheHeadingWithoutGoingRound() {
        Random rnd = new Random(22);
        List<Sample> s = new ArrayList<>();
        List<GpsFix> gps = new ArrayList<>();
        double h = 95;
        for (int sec = 0; sec < 300; sec++) {
            h = Math.max(88, Math.min(130, h + rnd.nextInt(5) - 2));
            s.add(new Sample(sec * 1000L, (int) Math.round(h)));
            gps.add(new GpsFix(sec * 1000L, 100f, (float) (h + rnd.nextInt(7) - 3)));
        }
        Result r = CanbusCodeEstimator.estimate(one(1033, s), gps);
        Guess g = guessFor(r, 1033);
        assertNotNull(g, r.guesses.toString());
        assertEquals(Category.HEADING, g.category);
        assertTrue(g.reason.contains("follows the GPS direction"), g.reason);
        // the same series without the GPS direction is not a heading
        Guess none = guessFor(CanbusCodeEstimator.estimate(one(1033, s), null), 1033);
        assertTrue(none == null || none.category != Category.HEADING, String.valueOf(none));
        // the heading is not something to look for
        assertFalse(r.notFoundLine().contains("heading"));
    }

    @Test
    void aSpeedInHundredthsOnTheMotorwayIsASpeedWithoutTheGps() {
        Random rnd = new Random(23);
        List<Sample> s = new ArrayList<>();
        double v = 100;
        for (int sec = 0; sec < 300; sec++) {
            v = Math.max(84, Math.min(124, v + rnd.nextInt(7) - 3));
            s.add(new Sample(sec * 1000L, (int) Math.round(v) * 100));
        }
        Guess g = guessFor(CanbusCodeEstimator.estimate(one(510, s), null), 510);
        assertNotNull(g);
        assertEquals(Category.SPEED, g.category);
        assertEquals(100, g.scale);
        assertTrue(g.reason.contains("as value/100, steps of 1 km/h"), g.reason);
    }

    @Test
    void theLibraryCodesThatSaidNothingAreNamedWithTheGuesses() {
        Random rnd = new Random(24);
        Map<Integer, List<Sample>> m = new HashMap<>();
        List<Sample> fuel = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            fuel.add(new Sample(i * 1000L, 40 + rnd.nextInt(80)));
        }
        m.put(91, fuel);
        List<Sample> range = new ArrayList<>();
        for (int sec = 0; sec <= 300; sec++) {
            range.add(new Sample(sec * 1000L, sec < 120 ? 310 : sec < 250 ? 300 : 290));
        }
        m.put(92, range);
        List<Sample> zero = new ArrayList<>();
        zero.add(new Sample(0, 0));
        m.put(102, zero);       // 103 sent nothing at all
        Result r = CanbusCodeEstimator.estimate(m, null);
        assertEquals("Library codes for this car: fuel 102 (no data in this recording, the guess is 91), "
                + "range 103 (no data in this recording, the guess is 92)",
                CanbusCodeEstimator.libraryCodesLine(102, 103, m, r));
        // the codes of the library that are right, or that sent data, say nothing
        assertEquals("", CanbusCodeEstimator.libraryCodesLine(91, 92, m, r));
        assertEquals("", CanbusCodeEstimator.libraryCodesLine(-1, -1, m, r));
        m.put(102, fuel);
        assertEquals("Library codes for this car: range 103 (no data in this recording, the guess is 92)",
                CanbusCodeEstimator.libraryCodesLine(102, 103, m, r));
    }
}
