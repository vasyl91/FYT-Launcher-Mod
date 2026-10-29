package com.android.launcher66.settings;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;

/**
 * An estimate of the fuel consumption for the moments the car gives none (many cars report it only above some
 * speed; the owner's PSA from ~30 km/h, "no value" below). It is a fallback only: it is learned from the
 * car's own values and shown only once it has learned enough of them, never for a car that gives none.
 *
 * The model, in L/h, with v the speed (m/s) and a the acceleration (m/s²) over the last ~2 s:
 * <ul>
 * <li>driving (a ≥ -0.3): {@code idle + kc·(0.15·v + 0.00031·v³) + ka·max(a, 0)·v (+ kr·RPM/1000)}: the
 * rolling and air resistance, the power to speed up, and the RPM when the car reports it;</li>
 * <li>slowing down (a &lt; -0.3): {@code c0 + c1·v}, learned apart: some cars cut the fuel then (~0), others
 * burn about the idle;</li>
 * <li>standing: the idle.</li>
 * </ul>
 * Both are weighted least squares over the car's values with a memory of ~30 minutes of driving, and the
 * samples weigh more the closer they are to the speed where the car stops giving values, where the estimate
 * is needed. On the owner's six recordings (each one predicted from the others), at up to 45 km/h, the error
 * is 0.48 L/h against 0.70 L/h for a constant.
 *
 * Plain Java (no android.*), so that it runs in JVM tests. Not thread-safe: the service uses it on the main
 * thread.
 */
public final class FuelModel {

    /** Below this acceleration (m/s²) the car is slowing down. */
    static final double COAST_ACCEL = -0.3;
    /** The car's values needed before the estimate is shown, and the driving time they come from. */
    static final int MIN_SAMPLES = 60;
    static final long MIN_DRIVING_MS = 180_000L;
    /** No value from the car for this long while driving counts as none. */
    static final long NO_UPDATE_MS = 5_000L;
    /** The memory: ~30 minutes of samples at about one a second. */
    static final double FORGET = 1.0 - 1.0 / 1800.0;
    /** How much the starting values weigh, in samples. */
    static final double PRIOR_WEIGHT = 5.0;
    /**
     * The idle weighs much more: a car that gives no value at low speed never shows its idle, and the line
     * through its values at speed would put it at about 0.
     */
    static final double IDLE_PRIOR_WEIGHT = 200.0;
    /** The speed where the car stops giving values, until it is known (km/h), and how fast the weight falls above it. */
    static final double DEFAULT_THRESHOLD_KMH = 30.0;
    static final double WEIGHT_SCALE_KMH = 20.0;
    static final double MAX_L_PER_100KM = 200.0;
    private static final double SMOOTH_RISE = 0.35;
    private static final double SMOOTH_FALL = 0.12;
    private static final long ACCEL_WINDOW_MS = 2000L;

    /** The starting values: a car of ~1300 kg. */
    private static final double[] DRIVE_PRIOR = {0.8, 0.45, 0.1, 0.0};
    private static final double[] COAST_PRIOR = {0.6, 0.02};

    /** An estimate: L/100 km while driving, L/h while standing. */
    public static final class Estimate {
        public final double value;
        public final boolean perHour;

        Estimate(double value, boolean perHour) {
            this.value = value;
            this.perHour = perHour;
        }

        /** {@code 4.2}: one decimal, the way the widget shows the car's value. */
        public String text() {
            return String.format(Locale.ROOT, "%.1f", value);
        }
    }

    /** Weighted least squares with a memory and a pull towards the starting values. */
    static final class Wls {
        final int n;
        final double[] prior;
        /** How much each starting value weighs, in samples. */
        final double[] priorWeight;
        final double[][] a;
        final double[] b;

        Wls(double[] prior, double[] priorWeight) {
            this.n = prior.length;
            this.prior = prior.clone();
            this.priorWeight = priorWeight.clone();
            this.a = new double[n][n];
            this.b = new double[n];
        }

        void add(double[] f, double y, double w) {
            for (int i = 0; i < n; i++) {
                b[i] = b[i] * FORGET + w * f[i] * y;
                for (int j = 0; j < n; j++) {
                    a[i][j] = a[i][j] * FORGET + w * f[i] * f[j];
                }
            }
        }

        /** The coefficients: (A + Λ) p = b + Λ·prior, Λ the weights of the starting values. */
        double[] solve() {
            double[][] m = new double[n][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = a[i][j] + (i == j ? priorWeight[i] : 0);
                }
                m[i][n] = b[i] + priorWeight[i] * prior[i];
            }
            for (int c = 0; c < n; c++) {
                int p = c;
                for (int r = c + 1; r < n; r++) {
                    if (Math.abs(m[r][c]) > Math.abs(m[p][c])) {
                        p = r;
                    }
                }
                double[] tmp = m[c];
                m[c] = m[p];
                m[p] = tmp;
                if (Math.abs(m[c][c]) < 1e-12) {
                    return prior.clone();
                }
                for (int r = 0; r < n; r++) {
                    if (r != c) {
                        double f = m[r][c] / m[c][c];
                        for (int k = c; k <= n; k++) {
                            m[r][k] -= f * m[c][k];
                        }
                    }
                }
            }
            double[] out = new double[n];
            for (int i = 0; i < n; i++) {
                out[i] = m[i][n] / m[i][i];
            }
            return out;
        }

        void write(StringBuilder sb) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(';').append(a[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(';').append(b[i]);
            }
        }

        int read(String[] f, int at) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Double.parseDouble(f[at++]);
                }
            }
            for (int i = 0; i < n; i++) {
                b[i] = Double.parseDouble(f[at++]);
            }
            return at;
        }
    }

    private final Wls drive = new Wls(DRIVE_PRIOR, new double[]{IDLE_PRIOR_WEIGHT, PRIOR_WEIGHT, PRIOR_WEIGHT, PRIOR_WEIGHT});
    private final Wls coast = new Wls(COAST_PRIOR, new double[]{PRIOR_WEIGHT, PRIOR_WEIGHT});
    private int samples;
    private long drivingMs;
    private double thresholdKmh = DEFAULT_THRESHOLD_KMH;
    private boolean rpmSeen;

    // the moment, not saved
    private final ArrayDeque<double[]> speeds = new ArrayDeque<>();      // {t, km/h}
    private boolean speedFromCan;
    private long lastFuelT = -1;
    private boolean fuelSaysNothing;
    private double rpm = -1;
    private double smoothedLph = Double.NaN;

    // ---------------------------------------------------------------------------------------------
    // Input
    // ---------------------------------------------------------------------------------------------

    /** A speed, km/h, from a canbus code (its 0 is exact) or from the GPS (it wanders a few km/h at a stop). */
    public void onSpeed(long t, double kmh, boolean fromCan) {
        double[] last = speeds.peekLast();
        if (last != null && t < last[0]) {
            return;     // out of order
        }
        if (last != null && isMoving()) {
            drivingMs += Math.min(2000L, t - (long) last[0]);
        }
        speedFromCan = fromCan;
        speeds.addLast(new double[]{t, Math.max(0, kmh)});
        while (speeds.size() > 2 && t - (long) speeds.peekFirst()[0] > 3 * ACCEL_WINDOW_MS) {
            speeds.pollFirst();
        }
        if (lastFuelT < 0) {
            lastFuelT = t;      // "no update for 5 s" counts from the first speed
        }
    }

    /** The RPM, when the car reports it. */
    public void onRpm(int value) {
        rpm = value;
        if (value > 0) {
            rpmSeen = true;
        }
    }

    /**
     * A value of the car's fuel code: L/100 km × 10, or "no value" where the car has none. A 0 is the car's own
     * value at a stop and while slowing down (a car that cuts the fuel), and no value while driving on.
     */
    public void onFuel(long t, int value) {
        lastFuelT = t;
        boolean moving = isMoving();
        double a = accel(t);
        boolean slowing = !Double.isNaN(a) && a < COAST_ACCEL;
        if ((value > 0 && value < 3001) || (value == 0 && moving && slowing)) {
            fuelSaysNothing = false;
            smoothedLph = Double.NaN;       // the next estimate starts afresh
            if (moving) {
                learn(t, value / 10.0 * kmh() / 100.0);
            }
        } else if (value == 0 && !moving) {
            fuelSaysNothing = false;        // 0 at a stop: the car's own value
        } else {
            // "no value" (65535 and the like), 0 while driving, or a value the widget would not show
            fuelSaysNothing = true;
            if (moving) {
                // the speed where the car stops giving values: the 90th percentile of the speeds it gives none
                // at, followed a step at a time, so that a single "no value" at speed does not move it far
                thresholdKmh += kmh() > thresholdKmh ? 0.9 : -0.1;
                thresholdKmh = Math.max(5, Math.min(150, thresholdKmh));
            }
        }
    }

    private void learn(long t, double lph) {
        double a = accel(t);
        if (Double.isNaN(a)) {
            return;
        }
        double kmh = kmh();
        double w = Math.exp(-Math.max(0, kmh - thresholdKmh) / WEIGHT_SCALE_KMH);
        double v = kmh / 3.6;
        if (a < COAST_ACCEL) {
            coast.add(new double[]{1, v}, lph, w);
        } else {
            drive.add(driveFeatures(v, a), lph, w);
        }
        samples++;
    }

    private double[] driveFeatures(double v, double a) {
        return new double[]{1, 0.15 * v + 0.00031 * v * v * v, Math.max(a, 0) * v, rpmSeen && rpm > 0 ? rpm / 1000.0 : 0};
    }

    // ---------------------------------------------------------------------------------------------
    // Output
    // ---------------------------------------------------------------------------------------------

    /** Enough of the car's own values to stand for them. */
    public boolean calibrated() {
        return samples >= MIN_SAMPLES && drivingMs >= MIN_DRIVING_MS;
    }

    /** The car gives no value now: "no value", 0 while driving, or nothing for 5 s while driving. */
    public boolean carGivesNoValue(long now) {
        return fuelSaysNothing || (isMoving() && lastFuelT >= 0 && now - lastFuelT > NO_UPDATE_MS);
    }

    /** The estimate to show now, or null: the model is not calibrated, or the car gives a value. */
    public Estimate estimate(long now) {
        if (!calibrated() || !carGivesNoValue(now) || speeds.isEmpty()) {
            return null;
        }
        double lph = litresPerHour(now);
        if (Double.isNaN(smoothedLph)) {
            smoothedLph = lph;
        } else {
            double alpha = lph > smoothedLph ? SMOOTH_RISE : SMOOTH_FALL;
            smoothedLph = alpha * lph + (1 - alpha) * smoothedLph;
        }
        if (!isMoving()) {
            return new Estimate(smoothedLph, true);
        }
        return new Estimate(Math.min(MAX_L_PER_100KM, smoothedLph / kmh() * 100.0), false);
    }

    /** The model's L/h now. */
    double litresPerHour(long now) {
        double[] d = clampDrive(drive.solve());
        if (!isMoving()) {
            return d[0];
        }
        double a = accel(now);
        if (Double.isNaN(a)) {
            a = 0;
        }
        double v = kmh() / 3.6;
        double lph;
        if (a < COAST_ACCEL) {
            double[] c = coast.solve();
            lph = Math.max(0, Math.min(2.5, c[0] + c[1] * v));
        } else {
            double[] f = driveFeatures(v, a);
            lph = 0;
            for (int i = 0; i < f.length; i++) {
                lph += d[i] * f[i];
            }
        }
        return Math.max(0, lph);
    }

    private static double[] clampDrive(double[] p) {
        p[0] = Math.max(0.3, Math.min(2.5, p[0]));
        p[1] = Math.max(0, Math.min(3, p[1]));
        p[2] = Math.max(0, Math.min(1, p[2]));
        p[3] = Math.max(0, Math.min(2, p[3]));
        return p;
    }

    /** The idle, L/h, as learned. */
    double idle() {
        return clampDrive(drive.solve())[0];
    }

    /** The level while slowing down at this speed (km/h), L/h, as learned. */
    double coastAt(double kmh) {
        double[] c = coast.solve();
        return Math.max(0, Math.min(2.5, c[0] + c[1] * kmh / 3.6));
    }

    int samples() {
        return samples;
    }

    /** The coefficients of driving as solved, before the limits: idle, kc, ka, kr. */
    double[] driveCoefficients() {
        return drive.solve();
    }

    double thresholdKmh() {
        return thresholdKmh;
    }

    // ---------------------------------------------------------------------------------------------
    // The speed
    // ---------------------------------------------------------------------------------------------

    private double kmh() {
        double[] last = speeds.peekLast();
        return last == null ? 0 : last[1];
    }

    /** Above 1 km/h from a canbus code, 5 km/h from the GPS. */
    public boolean isMoving() {
        return kmh() > (speedFromCan ? 1.0 : 5.0);
    }

    /** m/s², the slope of the speed over the last ~2 s; NaN with fewer than 3 speeds over at least 0.8 s. */
    double accel(long now) {
        int n = 0;
        double st = 0;
        double sv = 0;
        double first = Double.NaN;
        double last = Double.NaN;
        for (Iterator<double[]> it = speeds.descendingIterator(); it.hasNext(); ) {
            double[] s = it.next();
            if (now - s[0] > ACCEL_WINDOW_MS) {
                break;
            }
            n++;
            st += s[0];
            sv += s[1];
            last = Double.isNaN(last) ? s[0] : last;
            first = s[0];
        }
        if (n < 3 || last - first < 800) {
            return Double.NaN;
        }
        double mt = st / n;
        double mv = sv / n;
        double num = 0;
        double den = 0;
        for (Iterator<double[]> it = speeds.descendingIterator(); it.hasNext(); ) {
            double[] s = it.next();
            if (now - s[0] > ACCEL_WINDOW_MS) {
                break;
            }
            num += (s[0] - mt) * (s[1] - mv);
            den += (s[0] - mt) * (s[0] - mt);
        }
        // km/h per ms -> m/s²
        return den <= 0 ? Double.NaN : num / den * 1000.0 / 3.6;
    }

    /**
     * The scale of a speed code: km/h times 1, 10 or 100. From the GPS when there is one (the ratio of the
     * code to the GPS speed), else from the values (multiples of 100 or 10 that pass 260). 0 until it is known.
     */
    public static final class SpeedScale {
        private int fixed;
        private int gcd;
        private int max;
        private int nonZero;
        private double ratioSum;
        private int ratios;
        private int lastValue = -1;

        /** A scale known beforehand (the code reader's), or 0. */
        public SpeedScale(int known) {
            this.fixed = known;
        }

        public void onValue(int v) {
            lastValue = v;
            if (v > 0) {
                nonZero++;
                max = Math.max(max, v);
                gcd = gcd(gcd, v);
            }
        }

        /** A GPS speed, km/h, against the code's last value. */
        public void onGps(double kmh) {
            if (kmh > 15 && lastValue > 0) {
                ratioSum += lastValue / kmh;
                ratios++;
            }
        }

        public int scale() {
            if (fixed > 0) {
                return fixed;
            }
            if (ratios >= 10) {
                double r = ratioSum / ratios;
                int best = 1;
                for (int s : new int[]{10, 100}) {
                    if (Math.abs(Math.log(r / s)) < Math.abs(Math.log(r / best))) {
                        best = s;
                    }
                }
                return best;
            }
            if (nonZero < 10) {
                return 0;
            }
            if (max > 260 && gcd % 100 == 0) {
                return 100;
            }
            if (max > 260 && gcd % 10 == 0) {
                return 10;
            }
            return max <= 260 ? 1 : 0;
        }

        private static int gcd(int a, int b) {
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            return Math.abs(a);
        }
    }

    // ---------------------------------------------------------------------------------------------
    // The settings
    // ---------------------------------------------------------------------------------------------

    /** The settings key of the model of a car and its fuel code: another code is another model. */
    static String key(int carId, int fuelCode) {
        return "fuel_model_" + carId + "_" + fuelCode;
    }

    /** What the model learned, for the settings. */
    public String serialize() {
        StringBuilder sb = new StringBuilder("1;");
        sb.append(samples).append(';').append(drivingMs).append(';').append(thresholdKmh).append(';')
                .append(rpmSeen ? 1 : 0);
        drive.write(sb);
        coast.write(sb);
        return sb.toString();
    }

    /** A model from {@link #serialize()}'s text; a new one for nothing or a text it does not know. */
    public static FuelModel parse(String text) {
        FuelModel m = new FuelModel();
        if (text == null || !text.startsWith("1;")) {
            return m;
        }
        String[] f = text.split(";", -1);
        try {
            m.samples = Integer.parseInt(f[1]);
            m.drivingMs = Long.parseLong(f[2]);
            m.thresholdKmh = Double.parseDouble(f[3]);
            m.rpmSeen = "1".equals(f[4]);
            int at = m.drive.read(f, 5);
            at = m.coast.read(f, at);
            if (at != f.length) {
                return new FuelModel();
            }
        } catch (RuntimeException e) {
            return new FuelModel();
        }
        return m;
    }
}
