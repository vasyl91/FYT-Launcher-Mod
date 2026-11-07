package com.android.launcher66.settings;

/**
 * The speed from which a car gives its fuel consumption, learned only while the car speeds up. Plain
 * Java (no android.*), so that it runs in JVM tests.
 *
 * <p>Why only while accelerating: a car that cuts the fuel (engine braking) or keeps its last value
 * sends no code or "no value" at any speed, and the code is sent only when it changes. Those
 * silences say nothing of a threshold. While accelerating the real consumption changes with every
 * message, so a car that gives values does it at every message, and "no value" there is real.
 *
 * <p>The speeds are counted in bins of 5 km/h, a count of the car's values and one of "no value"
 * for each. The threshold is the edge that makes the fewest wrong entries (a value below it, "no
 * value" above it), and exists only when both sides are well supported and the wrong entries are
 * few. A bin that grows past {@link #BIN_LIMIT} halves both counts, so the model follows the car
 * as it is now.
 */
public final class FuelSpeedThreshold {

    public static final double BIN_KMH = 5.0;
    public static final int BINS = 30;           // 0..150 km/h
    /** A bin whose two counts together pass this halves them. */
    public static final int BIN_LIMIT = 200;
    /** The "no value" entries below the edge and the values above it that make a threshold. */
    public static final int MIN_SIDE = 20;
    /** The share of the entries that may be on the wrong side. */
    public static final double MAX_WRONG_SHARE = 0.10;

    private final int[] value = new int[BINS];
    private final int[] none = new int[BINS];

    /**
     * One sample while accelerating.
     *
     * @param carValue true = a valid value of the car; false = "no value", or none for 3 s
     */
    public void onAccelerating(double speedKmh, boolean carValue) {
        if (Double.isNaN(speedKmh) || speedKmh < 0) {
            return;
        }
        int b = Math.min(BINS - 1, (int) (speedKmh / BIN_KMH));
        if (carValue) {
            value[b]++;
        } else {
            none[b]++;
        }
        if (value[b] + none[b] > BIN_LIMIT) {
            value[b] /= 2;
            none[b] /= 2;
        }
    }

    /** The threshold, km/h (a multiple of 5), or NaN when the car gives values at every speed or at none. */
    public double threshold() {
        int total = 0;
        for (int b = 0; b < BINS; b++) {
            total += value[b] + none[b];
        }
        if (total == 0) {
            return Double.NaN;
        }
        // cost[e]: the wrong entries when the threshold is the edge e (below bin e, from bin e)
        int bestCost = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;
        for (int e = 1; e < BINS; e++) {
            int noneBelow = 0;
            int valueBelow = 0;
            for (int b = 0; b < e; b++) {
                noneBelow += none[b];
                valueBelow += value[b];
            }
            int valueAbove = 0;
            int noneAbove = 0;
            for (int b = e; b < BINS; b++) {
                valueAbove += value[b];
                noneAbove += none[b];
            }
            if (noneBelow < MIN_SIDE || valueAbove < MIN_SIDE) {
                continue;
            }
            int cost = valueBelow + noneAbove;
            if (cost > MAX_WRONG_SHARE * total) {
                continue;
            }
            if (cost < bestCost) {
                bestCost = cost;
                first = e;
                last = e;
            } else if (cost == bestCost && e == last + 1) {
                last = e;   // the same cost next to the best: the edge is somewhere in the gap
            }
        }
        if (first < 0) {
            return Double.NaN;
        }
        return ((first + last) / 2) * BIN_KMH;
    }

    /** "v0:n0,v1:n1,..." for the settings (no ';', which separates the fields of the model). */
    public String write() {
        StringBuilder sb = new StringBuilder();
        for (int b = 0; b < BINS; b++) {
            if (b > 0) {
                sb.append(',');
            }
            sb.append(value[b]).append(':').append(none[b]);
        }
        return sb.toString();
    }

    /** @return the thresholds from {@link #write()}'s text; throws NumberFormatException when it is not that */
    public static FuelSpeedThreshold read(String text) {
        FuelSpeedThreshold t = new FuelSpeedThreshold();
        if (text.isEmpty()) {
            return t;
        }
        String[] bins = text.split(",", -1);
        if (bins.length != BINS) {
            throw new NumberFormatException("bins: " + bins.length);
        }
        for (int b = 0; b < BINS; b++) {
            String[] vn = bins[b].split(":", -1);
            if (vn.length != 2) {
                throw new NumberFormatException(bins[b]);
            }
            t.value[b] = Integer.parseInt(vn[0]);
            t.none[b] = Integer.parseInt(vn[1]);
            if (t.value[b] < 0 || t.none[b] < 0) {
                throw new NumberFormatException(bins[b]);
            }
        }
        return t;
    }
}
