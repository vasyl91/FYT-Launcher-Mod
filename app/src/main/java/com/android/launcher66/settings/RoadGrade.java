package com.android.launcher66.settings;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * The grade of the road (sin θ ≈ dh/ds) from altitudes along the road: the GPS's (σ of 3-20 m, vertical accuracy as the
 * phone says it) or a barometer's (σ of 0.5 m). A weighted regression of the altitude on the distance travelled over
 * the last 150 m, shrunk towards 0 by how uncertain its slope is, so that noise gives a flat road and a clear climb a
 * grade. Plain Java (no android.*), so that it runs in JVM tests. Not thread-safe: the service uses it on the main thread.
 */
public final class RoadGrade {

    /** The points are the last 150 m of road, no older than 120 s; the ones with a worse σ are not used. */
    static final double WINDOW_M = 150.0;
    static final long WINDOW_MS = 120_000L;
    static final double MAX_SIGMA_M = 25.0;
    /** At least this many points over at least this much road, else the grade is 0. */
    static final int MIN_POINTS = 3;
    static final double MIN_SPAN_M = 50.0;
    /** The standard deviation of the grade of a road (4 %): the shrinking pulls the estimate towards a flat road. */
    static final double TAU = 0.04;
    static final double MAX_GRADE = 0.12;
    /** The last point must be this fresh (ms) and this near (m) to the car now. */
    static final long FRESH_MS = 10_000L;
    static final double NEAR_M = 100.0;

    /** {t, distance, altitude, sigma}. */
    private final ArrayDeque<double[]> points = new ArrayDeque<>();

    /** An altitude (m) with its standard deviation (m) at a time and a distance travelled (m). */
    public void onAltitude(long t, double distanceM, double altitudeM, double sigmaM) {
        if (Double.isNaN(altitudeM) || Double.isNaN(sigmaM) || sigmaM > MAX_SIGMA_M || sigmaM <= 0) {
            return;
        }
        double[] last = points.peekLast();
        if (last != null && (t < (long) last[0] || distanceM < last[1])) {
            return;     // out of order
        }
        points.addLast(new double[]{t, distanceM, altitudeM, sigmaM});
        while (points.size() > 1 && (distanceM - points.peekFirst()[1] > WINDOW_M * 2
                || t - (long) points.peekFirst()[0] > WINDOW_MS)) {
            points.pollFirst();
        }
    }

    /** Forgets the points (the source of the altitudes changed, and the two do not agree on the level). */
    public void reset() {
        points.clear();
    }

    /** sin θ now, at the distance travelled so far (m): 0 when there is not enough to tell. */
    public double grade(long now, double distanceM) {
        double[] last = points.peekLast();
        if (last == null || now - (long) last[0] > FRESH_MS || Math.abs(distanceM - last[1]) > NEAR_M) {
            return 0;
        }
        double sw = 0;
        double sws = 0;
        double swh = 0;
        int n = 0;
        double minS = Double.MAX_VALUE;
        double maxS = -Double.MAX_VALUE;
        for (Iterator<double[]> it = points.descendingIterator(); it.hasNext(); ) {
            double[] p = it.next();
            if (last[1] - p[1] > WINDOW_M || now - (long) p[0] > WINDOW_MS) {
                break;
            }
            double w = 1.0 / (p[3] * p[3]);
            sw += w;
            sws += w * p[1];
            swh += w * p[2];
            n++;
            minS = Math.min(minS, p[1]);
            maxS = Math.max(maxS, p[1]);
        }
        if (n < MIN_POINTS || maxS - minS < MIN_SPAN_M) {
            return 0;
        }
        double ms = sws / sw;
        double mh = swh / sw;
        double sxx = 0;
        double sxy = 0;
        for (Iterator<double[]> it = points.descendingIterator(); it.hasNext(); ) {
            double[] p = it.next();
            if (last[1] - p[1] > WINDOW_M || now - (long) p[0] > WINDOW_MS) {
                break;
            }
            double w = 1.0 / (p[3] * p[3]);
            sxx += w * (p[1] - ms) * (p[1] - ms);
            sxy += w * (p[1] - ms) * (p[2] - mh);
        }
        if (sxx <= 0) {
            return 0;
        }
        double slope = sxy / sxx;
        // the variance of the slope, from the residuals (weighted, n - 2 degrees of freedom)
        double rss = 0;
        for (Iterator<double[]> it = points.descendingIterator(); it.hasNext(); ) {
            double[] p = it.next();
            if (last[1] - p[1] > WINDOW_M || now - (long) p[0] > WINDOW_MS) {
                break;
            }
            double w = 1.0 / (p[3] * p[3]);
            double r = p[2] - (mh + slope * (p[1] - ms));
            rss += w * r * r;
        }
        double variance = rss / (n - 2) / sxx;
        double shrunk = slope * TAU * TAU / (TAU * TAU + variance);
        return Math.max(-MAX_GRADE, Math.min(MAX_GRADE, shrunk));
    }
}
