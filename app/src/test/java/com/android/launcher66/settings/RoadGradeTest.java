package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Random;

class RoadGradeTest {

    /**
     * Drives {@code meters} at {@code speed} m/s with a fix every {@code step} s on a road of a given grade (sin θ), the
     * altitudes with noise; returns the grade at the end.
     */
    private static double drive(RoadGrade g, Random rnd, double grade, double noise, double sigma, double speed, double meters,
                                double step) {
        double s = 0;
        long t = 0;
        while (s <= meters) {
            g.onAltitude(t, s, 100 + grade * s + rnd.nextGaussian() * noise, sigma);
            s += speed * step;
            t += (long) (step * 1000);
        }
        return g.grade(t, s - speed * step);
    }

    @Test
    void aFivePercentClimbWithNoiseOfThreeMetres() {
        RoadGrade g = new RoadGrade();
        double got = drive(g, new Random(2), 0.05, 3, 3, 15, 300, 0.5);
        assertEquals(0.05, got, 0.015);
        // it is shrunk a little, never beyond: over many climbs the mean is just under 5 %
        double sum = 0;
        for (int seed = 0; seed < 100; seed++) {
            sum += drive(new RoadGrade(), new Random(seed), 0.05, 3, 3, 15, 300, 0.5);
        }
        assertEquals(0.046, sum / 100, 0.006);
    }

    @Test
    void aFlatRoadWithNoiseOfTenMetresIsFlat() {
        // a fix every 0.5 s at 54 km/h; a climb is not read into the noise. One such drive...
        assertTrue(Math.abs(drive(new RoadGrade(), new Random(0), 0, 10, 10, 15, 300, 0.5)) < 0.01);
        // ...and all of them: the raw slope of such noise has a standard deviation of ~0.05 over 150 m, here it is
        // under half of that, and it is never taken for a hill
        double sumSquares = 0;
        double worst = 0;
        for (int seed = 0; seed < 200; seed++) {
            double got = drive(new RoadGrade(), new Random(seed), 0, 10, 10, 15, 300, 0.5);
            sumSquares += got * got;
            worst = Math.max(worst, Math.abs(got));
        }
        assertTrue(Math.sqrt(sumSquares / 200) < 0.025, "rms " + Math.sqrt(sumSquares / 200));
        assertTrue(worst < 0.07, "worst " + worst);
    }

    @Test
    void aGoodBarometerGivesAClearGradeOnAShortClimb() {
        // 0.5 m of noise: 3 % over 100 m is seen almost whole
        RoadGrade g = new RoadGrade();
        assertEquals(0.03, drive(g, new Random(3), 0.03, 0.5, 0.5, 10, 200, 1.0), 0.004);
        assertEquals(-0.06, drive(new RoadGrade(), new Random(3), -0.06, 0.5, 0.5, 10, 200, 1.0), 0.006);
    }

    @Test
    void tooShortAStretchIsFlat() {
        RoadGrade g = new RoadGrade();
        // 40 m only
        g.onAltitude(0, 0, 100, 3);
        g.onAltitude(1000, 20, 101, 3);
        g.onAltitude(2000, 40, 102, 3);
        assertEquals(0, g.grade(2000, 40), 0);
        // two points over a long stretch
        RoadGrade two = new RoadGrade();
        two.onAltitude(0, 0, 100, 3);
        two.onAltitude(10_000, 120, 106, 3);
        assertEquals(0, two.grade(10_000, 120), 0);
        assertEquals(0, new RoadGrade().grade(0, 0), 0);
    }

    @Test
    void anOldOrADistantPointSaysNothing() {
        RoadGrade g = new RoadGrade();
        drive(g, new Random(2), 0.05, 0.5, 0.5, 10, 200, 1.0);
        long end = 200_000;
        assertTrue(g.grade(21_000, 200) > 0.04);
        // the last point is older than 10 s
        assertEquals(0, g.grade(31_000, 200), 0);
        // the car is more than 100 m from it
        assertEquals(0, g.grade(21_000, 330), 0);
    }

    @Test
    void aBadAltitudeIsNotUsedAndTheGradeIsLimited() {
        RoadGrade g = new RoadGrade();
        // σ of 30 m: not used, so nothing to go on
        for (int i = 0; i < 20; i++) {
            g.onAltitude(i * 1000L, i * 10.0, 100 + i * 5, 30);
        }
        assertEquals(0, g.grade(19_000, 190), 0);
        // a 40 % slope is limited to 12 %
        RoadGrade steep = new RoadGrade();
        for (int i = 0; i < 20; i++) {
            steep.onAltitude(i * 1000L, i * 10.0, 100 + i * 4, 0.5);
        }
        assertEquals(0.12, steep.grade(19_000, 190), 1e-9);
    }

    @Test
    void forgettingThePointsStartsOver() {
        RoadGrade g = new RoadGrade();
        drive(g, new Random(2), 0.05, 0.5, 0.5, 10, 200, 1.0);
        g.reset();
        assertEquals(0, g.grade(20_000, 200), 0);
    }
}
