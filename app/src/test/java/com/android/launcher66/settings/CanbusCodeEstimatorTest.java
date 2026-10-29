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
}
