package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Guesses what the canbus codes recorded by the code reader mean, from how their values behave: the
 * range a value moves in, how often and by how much it changes, whether it only goes down, whether it
 * follows the GPS speed. They are guesses, scored 0..1, and the file says so; a car may report a code in
 * a different unit or scale than the ones assumed here.
 *
 * Plain Java (no android.*), so that it runs in JVM tests. The thresholds are a starting point, tuned by
 * the tests with synthetic series.
 */
public final class CanbusCodeEstimator {

    /** Candidates below this score are not listed. */
    public static final double MIN_SCORE = 0.5;
    /** Candidates listed for one category. */
    public static final int MAX_PER_CATEGORY = 3;

    public enum Category {
        FUEL_INSTANT("fuel consumption, instant"),
        FUEL_AVERAGE("fuel consumption, average"),
        RANGE("range"),
        RPM("RPM"),
        SPEED("speed"),
        COOLANT("coolant temperature"),
        BATTERY("battery voltage"),
        OUTSIDE_TEMPERATURE("outside temperature"),
        FUEL_LEVEL("fuel level"),
        ODOMETER("mileage"),
        SWITCH("switch or state");

        public final String label;

        Category(String label) {
            this.label = label;
        }
    }

    /** A value of a code at a time (milliseconds, any origin). */
    public static final class Sample {
        public final long t;
        public final int v;

        public Sample(long t, int v) {
            this.t = t;
            this.v = v;
        }
    }

    /** A GPS speed at a time (the same clock as the samples). */
    public static final class GpsFix {
        public final long t;
        public final float kmh;

        public GpsFix(long t, float kmh) {
            this.t = t;
            this.kmh = kmh;
        }
    }

    public static final class Guess {
        public final int code;
        public final Category category;
        public final double score;
        /** What the value looked like, for the line {@code Code 91 - <label> (<reason>)}. */
        public final String reason;

        Guess(int code, Category category, double score, String reason) {
            this.code = code;
            this.category = category;
            this.score = score;
            this.reason = reason;
        }

        /** {@code Code 91 - fuel consumption, instant (4.1-12.8 L/100 km as value/10, 62 changes)} */
        @Override
        public String toString() {
            return "Code " + code + " - " + category.label + " (" + reason + ")";
        }
    }

    public static final class Result {
        /** By category in the order of {@link Category}, then the best first. */
        public final List<Guess> guesses;
        /** Categories without a candidate that are worth looking for (not the switches: every car has many). */
        public final List<Category> notFound;

        Result(List<Guess> guesses, List<Category> notFound) {
            this.guesses = Collections.unmodifiableList(guesses);
            this.notFound = Collections.unmodifiableList(notFound);
        }

        /** {@code Not found: fuel consumption, average}, or an empty string if everything was found. */
        public String notFoundLine() {
            if (notFound.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder("Not found: ");
            for (int i = 0; i < notFound.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(notFound.get(i).label);
            }
            return sb.toString();
        }
    }

    private CanbusCodeEstimator() {
    }

    // ---------------------------------------------------------------------------------------------
    // Statistics of one code
    // ---------------------------------------------------------------------------------------------

    static final class Stats {
        int events;
        int changes;
        int distinct;
        int min;
        int max;
        double median;
        /** Share of the changes that went down / up. */
        double dropShare;
        double riseShare;
        /** Share of the changes by exactly 1 (either way). */
        double stepOneShare;
        double maxStep;
        double meanAbsStep;
        /** Time between changes (ms): mean and coefficient of variation; 0 if there are fewer than 3 changes. */
        double meanInterval;
        double intervalCv;
        boolean nonDecreasing;
        long[] t;
        int[] v;
        private int[] sorted;

        double fractionIn(int lo, int hi) {
            int n = 0;
            for (int x : v) {
                if (x >= lo && x <= hi) {
                    n++;
                }
            }
            return events == 0 ? 0 : (double) n / events;
        }

        /** Mean of the lowest 20 % of the values, and their spread. */
        double[] lowest20() {
            int k = Math.max(1, sorted.length / 5);
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += sorted[i];
            }
            return new double[]{sum / k, sorted[k - 1] - sorted[0], sorted[0], sorted[k - 1]};
        }
    }

    static Stats statsOf(List<Sample> samples) {
        List<Sample> list = new ArrayList<>(samples);
        Collections.sort(list, new Comparator<Sample>() {
            @Override
            public int compare(Sample a, Sample b) {
                return Long.compare(a.t, b.t);
            }
        });
        Stats s = new Stats();
        s.events = list.size();
        s.t = new long[s.events];
        s.v = new int[s.events];
        for (int i = 0; i < s.events; i++) {
            s.t[i] = list.get(i).t;
            s.v[i] = list.get(i).v;
        }
        if (s.events == 0) {
            return s;
        }
        s.sorted = s.v.clone();
        Arrays.sort(s.sorted);
        s.min = s.sorted[0];
        s.max = s.sorted[s.events - 1];
        s.median = s.events % 2 == 1 ? s.sorted[s.events / 2]
                : (s.sorted[s.events / 2 - 1] + s.sorted[s.events / 2]) / 2.0;
        int distinct = 1;
        for (int i = 1; i < s.events; i++) {
            if (s.sorted[i] != s.sorted[i - 1]) {
                distinct++;
            }
        }
        s.distinct = distinct;

        int drops = 0;
        int rises = 0;
        int ones = 0;
        double sumStep = 0;
        List<Long> changeTimes = new ArrayList<>();
        s.nonDecreasing = true;
        for (int i = 1; i < s.events; i++) {
            int d = s.v[i] - s.v[i - 1];
            if (d == 0) {
                continue;
            }
            s.changes++;
            changeTimes.add(s.t[i]);
            if (d < 0) {
                drops++;
                s.nonDecreasing = false;
            } else {
                rises++;
            }
            if (Math.abs(d) == 1) {
                ones++;
            }
            sumStep += Math.abs(d);
            s.maxStep = Math.max(s.maxStep, Math.abs(d));
        }
        if (s.changes > 0) {
            s.dropShare = (double) drops / s.changes;
            s.riseShare = (double) rises / s.changes;
            s.stepOneShare = (double) ones / s.changes;
            s.meanAbsStep = sumStep / s.changes;
        }
        if (changeTimes.size() >= 3) {
            int m = changeTimes.size() - 1;
            double[] gaps = new double[m];
            double mean = 0;
            for (int i = 0; i < m; i++) {
                gaps[i] = changeTimes.get(i + 1) - changeTimes.get(i);
                mean += gaps[i];
            }
            mean /= m;
            double var = 0;
            for (double g : gaps) {
                var += (g - mean) * (g - mean);
            }
            s.meanInterval = mean;
            s.intervalCv = mean > 0 ? Math.sqrt(var / m) / mean : 0;
        }
        return s;
    }

    /**
     * Pearson correlation of a code with the GPS speed, both as step functions sampled every second over
     * the time they share; NaN if there are fewer than 20 common seconds or one of them does not vary.
     */
    static double correlationWithGps(Stats s, List<GpsFix> gps) {
        if (gps == null || gps.size() < 5 || s.events < 5) {
            return Double.NaN;
        }
        List<GpsFix> fixes = new ArrayList<>(gps);
        Collections.sort(fixes, new Comparator<GpsFix>() {
            @Override
            public int compare(GpsFix a, GpsFix b) {
                return Long.compare(a.t, b.t);
            }
        });
        long from = Math.max(s.t[0], fixes.get(0).t);
        long to = Math.min(s.t[s.events - 1], fixes.get(fixes.size() - 1).t);
        if (to - from < 20_000L) {
            return Double.NaN;
        }
        List<double[]> pairs = new ArrayList<>();
        int iv = 0;
        int ig = 0;
        for (long t = from; t <= to; t += 1000L) {
            while (iv + 1 < s.events && s.t[iv + 1] <= t) {
                iv++;
            }
            while (ig + 1 < fixes.size() && fixes.get(ig + 1).t <= t) {
                ig++;
            }
            pairs.add(new double[]{s.v[iv], fixes.get(ig).kmh});
        }
        return pearson(pairs);
    }

    /** Pearson correlation of two codes' step functions sampled every second over the time they share. */
    static double correlation(Stats a, Stats b) {
        if (a.events < 5 || b.events < 5) {
            return Double.NaN;
        }
        long from = Math.max(a.t[0], b.t[0]);
        long to = Math.min(a.t[a.events - 1], b.t[b.events - 1]);
        if (to - from < 20_000L) {
            return Double.NaN;
        }
        List<double[]> pairs = new ArrayList<>();
        int ia = 0;
        int ib = 0;
        for (long t = from; t <= to; t += 1000L) {
            while (ia + 1 < a.events && a.t[ia + 1] <= t) {
                ia++;
            }
            while (ib + 1 < b.events && b.t[ib + 1] <= t) {
                ib++;
            }
            pairs.add(new double[]{a.v[ia], b.v[ib]});
        }
        return pearson(pairs);
    }

    private static double pearson(List<double[]> pairs) {
        int n = pairs.size();
        if (n < 20) {
            return Double.NaN;
        }
        double mx = 0;
        double my = 0;
        for (double[] p : pairs) {
            mx += p[0];
            my += p[1];
        }
        mx /= n;
        my /= n;
        double sxx = 0;
        double syy = 0;
        double sxy = 0;
        for (double[] p : pairs) {
            sxx += (p[0] - mx) * (p[0] - mx);
            syy += (p[1] - my) * (p[1] - my);
            sxy += (p[0] - mx) * (p[1] - my);
        }
        if (sxx <= 0 || syy <= 0) {
            return Double.NaN;
        }
        return sxy / Math.sqrt(sxx * syy);
    }

    // ---------------------------------------------------------------------------------------------
    // Scores, one function per category: 0 = not this, else 0..1 with the reason
    // ---------------------------------------------------------------------------------------------

    private static final class Scored {
        final double score;
        final String reason;

        Scored(double score, String reason) {
            this.score = Math.min(1.0, score);
            this.reason = reason;
        }
    }

    private static String f1(double x) {
        return String.format(Locale.ROOT, "%.1f", x);
    }

    /** The widget shows value/10 as L/100 km for 0 < value < 3001; the usual values are 2.0-25.0. */
    private static Scored fuelInstant(Stats s, double gpsCorr, double rpmCorr) {
        if (s.min < 0 || s.max > 3000 || s.changes < 10 || s.distinct < 5 || s.fractionIn(20, 250) < 0.7) {
            return null;
        }
        double score = 0.55 + 0.15 * Math.min(1, s.changes / 50.0) + 0.1 * Math.min(1, s.distinct / 20.0);
        if (!Double.isNaN(gpsCorr) && Math.abs(gpsCorr) >= 0.3) {
            score += 0.1;
        }
        if (!Double.isNaN(rpmCorr) && Math.abs(rpmCorr) >= 0.3) {
            score += 0.1;
        }
        if (!Double.isNaN(gpsCorr) && gpsCorr >= 0.9) {
            score *= 0.5;       // it is the speed
        }
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for (int x : s.v) {
            if (x > 0) {
                lo = Math.min(lo, x);
                hi = Math.max(hi, x);
            }
        }
        return new Scored(score, f1(lo / 10.0) + "-" + f1(hi / 10.0) + " L/100 km as value/10, " + s.changes + " changes");
    }

    private static Scored fuelAverage(Stats s) {
        if (s.min < 0 || s.max > 3000 || s.changes < 1 || s.changes > 20 || s.fractionIn(20, 250) < 0.7
                || s.stepOneShare < 0.5) {
            return null;
        }
        if (s.changes >= 4 && (s.dropShare > 0.8 || s.riseShare > 0.8)) {
            return null;        // one way only: a counter, not an average
        }
        double score = 0.6 + 0.2 * s.stepOneShare + (s.changes >= 2 ? 0.1 : 0);
        return new Scored(score, f1(s.min / 10.0) + "-" + f1(s.max / 10.0) + " L/100 km as value/10, " + s.changes + " changes");
    }

    private static Scored range(Stats s) {
        if (s.min < 0 || s.max > 2000) {
            return null;
        }
        if (s.changes == 0) {
            // It did not change while recording: a weak guess, only for a plausible distance
            if (s.min >= 100 && s.max <= 1500) {
                return new Scored(0.5, s.min + " km (did not change while recording)");
            }
            return null;
        }
        if (s.fractionIn(20, 1500) < 0.6 || s.maxStep > 3 || s.changes < 3) {
            return null;
        }
        if (s.dropShare < 0.6) {
            return null;
        }
        double score = 0.55 + 0.15 * s.dropShare + (s.stepOneShare >= 0.8 ? 0.1 : 0.05)
                + (s.meanInterval > 0 && s.intervalCv < 1 ? 0.1 : 0);
        String every = s.meanInterval > 0 ? ", about every " + Math.round(s.meanInterval / 1000.0) + " s" : "";
        return new Scored(score, s.min + "-" + s.max + " km, " + s.changes + " changes" + every);
    }

    private static Scored rpm(Stats s, double gpsCorr) {
        if (s.min < 0 || s.max > 8000 || s.max < 600 || s.changes < 10) {
            return null;
        }
        double score = 0.5 + 0.15 * Math.min(1, s.changes / 30.0);
        String idle = "";
        double[] low = s.lowest20();
        if (low[2] >= 500 && low[3] <= 1100 && low[1] <= 150) {
            score += 0.2;
            idle = ", about " + Math.round(low[0] / 10.0) * 10 + " at idle";
        }
        if (!Double.isNaN(gpsCorr) && gpsCorr >= 0.4) {
            score += 0.1;
        }
        return new Scored(score, s.min + "-" + s.max + idle);
    }

    private static Scored speed(Stats s, double gpsCorr) {
        if (s.min < 0 || s.max > 260 || s.changes < 5) {
            return null;
        }
        String range = s.min + "-" + s.max + " km/h";
        if (!Double.isNaN(gpsCorr) && gpsCorr >= 0.8) {
            return new Scored(0.9 + 0.1 * (gpsCorr - 0.8) / 0.2, range + ", follows the GPS speed (r=" + String.format(Locale.ROOT, "%.2f", gpsCorr) + ")");
        }
        if (!Double.isNaN(gpsCorr) && gpsCorr >= 0.5) {
            return new Scored(0.7, range + ", partly follows the GPS speed");
        }
        // Without the GPS: it stops at 0 and moves in steps of a few km/h
        if (s.min == 0 && s.max >= 20 && s.meanAbsStep <= 15) {
            return new Scored(0.5, range + ", returns to 0");
        }
        return null;
    }

    private static Scored coolant(Stats s) {
        if (s.changes == 0 || s.changes > 30 || s.riseShare < 0.6 || s.stepOneShare < 0.8) {
            return null;
        }
        boolean direct = s.min >= 0 && s.max <= 130 && s.median >= 60 && s.median <= 110;
        boolean offset = s.min >= 40 && s.max <= 170 && s.median >= 100 && s.median <= 150;
        if (!direct && !offset) {
            return null;
        }
        double score = 0.6 + 0.2 * s.riseShare + (s.changes >= 3 ? 0.1 : 0);
        String note = direct ? "" : " (with a +40 offset: " + (s.min - 40) + "-" + (s.max - 40) + ")";
        return new Scored(score, s.min + "-" + s.max + " °C" + note + ", slowly rising, " + s.changes + " changes");
    }

    private static Scored battery(Stats s) {
        if (s.changes == 0 || s.changes > 200) {
            return null;
        }
        if (s.min >= 100 && s.max <= 160 && s.max - s.min <= 15) {
            return new Scored(0.6 + 0.1 * Math.min(1, s.distinct / 5.0),
                    f1(s.min / 10.0) + "-" + f1(s.max / 10.0) + " V as value/10, " + s.changes + " changes");
        }
        if (s.min >= 10 && s.max <= 16 && s.max - s.min <= 3 && s.changes >= 2) {
            return new Scored(0.55, s.min + "-" + s.max + " V, " + s.changes + " changes");
        }
        return null;
    }

    private static Scored outsideTemperature(Stats s) {
        if (s.changes < 1 || s.changes > 5 || s.maxStep > 2) {
            return null;
        }
        if (s.min >= -40 && s.max <= 60 && s.median >= 0 && s.median <= 40) {
            return new Scored(0.5 + (s.changes >= 2 ? 0.05 : 0), s.min + "-" + s.max + " °C, almost constant, " + s.changes + " changes");
        }
        if (s.min >= 0 && s.max <= 100 && s.median >= 40 && s.median <= 80) {
            return new Scored(0.5, s.min + "-" + s.max + " (maybe °C + 40 = " + (s.min - 40) + " to " + (s.max - 40)
                    + "), almost constant, " + s.changes + " changes");
        }
        return null;
    }

    private static Scored fuelLevel(Stats s) {
        if (s.changes < 1 || s.changes > 10 || s.min < 0 || s.max > 100 || s.dropShare < 0.7 || s.maxStep > 5
                || s.median < 5) {
            return null;
        }
        return new Scored(0.6 + 0.1 * s.dropShare, s.min + "-" + s.max + " %, only goes down, " + s.changes + " changes");
    }

    private static Scored odometer(Stats s) {
        if (s.changes < 1 || s.min < 1000 || !s.nonDecreasing || s.maxStep > 10) {
            return null;
        }
        return new Scored(0.6 + 0.1 * Math.min(1, s.changes / 5.0), s.min + "-" + s.max + ", never decreases, " + s.changes + " changes");
    }

    private static Scored switchOrState(Stats s) {
        if (s.changes < 1 || s.distinct > 3 || s.min < 0 || s.max > 2) {
            return null;
        }
        return new Scored(0.5 + (s.changes >= 2 ? 0.05 : 0), "values " + s.min + ".." + s.max + ", " + s.changes + " changes");
    }

    // ---------------------------------------------------------------------------------------------
    // The estimate
    // ---------------------------------------------------------------------------------------------

    /**
     * @param events the recorded values per code, in the order they came
     * @param gps    the GPS speed during the recording, null or empty if there was none
     */
    public static Result estimate(Map<Integer, List<Sample>> events, List<GpsFix> gps) {
        Map<Integer, Stats> stats = new TreeMap<>();
        Map<Integer, Double> gpsCorr = new TreeMap<>();
        if (events != null) {
            for (Map.Entry<Integer, List<Sample>> e : events.entrySet()) {
                if (e.getValue() == null || e.getValue().isEmpty()) {
                    continue;
                }
                Stats s = statsOf(e.getValue());
                stats.put(e.getKey(), s);
                gpsCorr.put(e.getKey(), s.changes >= 3 ? correlationWithGps(s, gps) : Double.NaN);
            }
        }

        // The RPM candidate that stands out, for the correlation of the fuel consumption with it
        Stats rpmSeries = null;
        double bestRpm = 0;
        for (Map.Entry<Integer, Stats> e : stats.entrySet()) {
            Scored r = rpm(e.getValue(), gpsCorr.get(e.getKey()));
            if (r != null && r.score > bestRpm) {
                bestRpm = r.score;
                rpmSeries = e.getValue();
            }
        }

        Map<Category, List<Guess>> byCategory = new EnumMap<>(Category.class);
        for (Category c : Category.values()) {
            byCategory.put(c, new ArrayList<Guess>());
        }
        for (Map.Entry<Integer, Stats> e : stats.entrySet()) {
            int code = e.getKey();
            Stats s = e.getValue();
            double g = gpsCorr.get(code);
            double rc = rpmSeries != null && rpmSeries != s && s.changes >= 10 ? correlation(s, rpmSeries) : Double.NaN;
            Scored[] scored = new Scored[Category.values().length];
            scored[Category.FUEL_INSTANT.ordinal()] = fuelInstant(s, g, rc);
            scored[Category.FUEL_AVERAGE.ordinal()] = fuelAverage(s);
            scored[Category.RANGE.ordinal()] = range(s);
            scored[Category.RPM.ordinal()] = rpm(s, g);
            scored[Category.SPEED.ordinal()] = speed(s, g);
            scored[Category.COOLANT.ordinal()] = coolant(s);
            scored[Category.BATTERY.ordinal()] = battery(s);
            scored[Category.OUTSIDE_TEMPERATURE.ordinal()] = outsideTemperature(s);
            scored[Category.FUEL_LEVEL.ordinal()] = fuelLevel(s);
            scored[Category.ODOMETER.ordinal()] = odometer(s);
            scored[Category.SWITCH.ordinal()] = switchOrState(s);
            // Greedy: the code goes to the category it fits best
            int best = -1;
            for (int i = 0; i < scored.length; i++) {
                if (scored[i] != null && (best < 0 || scored[i].score > scored[best].score)) {
                    best = i;
                }
            }
            if (best >= 0 && scored[best].score >= MIN_SCORE) {
                Category c = Category.values()[best];
                byCategory.get(c).add(new Guess(code, c, scored[best].score, scored[best].reason));
            }
        }

        List<Guess> guesses = new ArrayList<>();
        List<Category> notFound = new ArrayList<>();
        for (Category c : Category.values()) {
            List<Guess> list = byCategory.get(c);
            Collections.sort(list, new Comparator<Guess>() {
                @Override
                public int compare(Guess a, Guess b) {
                    int d = Double.compare(b.score, a.score);
                    return d != 0 ? d : Integer.compare(a.code, b.code);
                }
            });
            if (list.isEmpty()) {
                if (c != Category.SWITCH) {
                    notFound.add(c);
                }
            } else {
                guesses.addAll(list.subList(0, Math.min(MAX_PER_CATEGORY, list.size())));
            }
        }
        return new Result(guesses, notFound);
    }
}
