package com.android.launcher66.settings;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;

/**
 * An estimate of the fuel consumption for the moments the car gives none (many cars report it only above some
 * speed; the owner's PSA from ~30 km/h, "no value" below). It is a fallback only: it is learned from the
 * car's own values and shown only for a car that gives values from a threshold speed and has learned enough of
 * them, never for a car that gives none or that is silent at speed (that is a fault, not a threshold).
 *
 * <p>The model, in L/h, with v the speed (m/s), aEff the acceleration over the last ~2 s plus the grade, and n the
 * RPM/1000 when the car reports plausible RPM. It follows the power model of Akçelik (ARRB, {@code f = α + β1·P +
 * β2·M·a²·v}), with features that do not depend on the mass, so that the car's mass and engine displacement only
 * move the starting values and what was learned stays valid:
 * <ul>
 * <li>driving: {@code c0 + max(0, c1·0.108·v + c2·v³/1000 + c3·max(aEff, 0)·v + c4·max(aEff, 0)²·v) + c5·n·(1 +
 * 0.15·n + 0.05·n²)}: the idle, the rolling and air resistance, the inertia and the climb, hard acceleration,
 * and the friction of the engine (Heywood's FMEP);</li>
 * <li>slowing down (aEff &lt; -0.3): learned apart, {@code c0 + c1·v}, but anchored in the idle below the
 * threshold. The owner's PSA does not cut the fuel under ~45 km/h: it burns the idle (~0.9 L/h), and a line learned
 * over the motorway would give 0.4 L/h at 10 km/h. Without RPM the level falls linearly from the car's level at
 * the threshold to the idle at a stop; with RPM clearly above the idle (engine braking) it is the learned line,
 * which is ~0 for a car that cuts the fuel;</li>
 * <li>RPM states (they need plausible, fresh RPM): 0 is the engine off (start-stop, hybrid), 0 L/h; the idle
 * RPM, learned at a stop, with no acceleration is rolling in neutral, which burns the idle;</li>
 * <li>standing: the idle (with the learned friction at the idle RPM).</li>
 * </ul>
 * All of it is weighted least squares over the car's values with a memory of ~30 minutes of driving; the samples
 * weigh more the closer they are to the speed where the car stops giving values, where the estimate is needed.
 * The starting values come from the physics (a car of 1300 kg, or the mass and engine displacement from the
 * settings, which also shorten the calibration to 30 samples and 90 s).
 *
 * <p>The bias of the last values: the difference between the car's values and the model (separately for driving
 * and slowing down, at most 1 L/h) is followed and fades away with a time constant of 60 s once the car goes
 * silent. The first estimate is the car's last value, and its difference to the target fades with 3 s. When the
 * car speeds up past its threshold, the model learns how much it falls short just below it (the "edge").
 *
 * <p>The unit: litres per hour at a stop, while slowing down and below 10 km/h (back to L/100 km above 13 km/h);
 * L/100 km otherwise.
 *
 * <p>On the owner's nine recordings (each one predicted from the other eight), at 28-45 km/h, the error is the same
 * as that of the previous model (0.57 L/h; accelerating 0.78, steady 0.58, slowing down 0.25), the level while
 * slowing down is 0.82 and 0.84 L/h at 10 and 20 km/h against 0.46 and 0.65, and the error at the moment the car
 * goes silent falls from 0.58 to 0.52 L/h.
 *
 * <p>Plain Java (no android.*), so that it runs in JVM tests. Not thread-safe: the service uses it on the main
 * thread.
 */
public final class FuelModel {

    /** Below this acceleration (m/s²) the car is slowing down. */
    static final double COAST_ACCEL = -0.3;
    /** The car's values needed before the estimate is shown, and the driving time they come from. */
    static final int MIN_SAMPLES = 60;
    static final long MIN_DRIVING_MS = 180_000L;
    /** The same with the car's mass and engine displacement: the starting values are better. */
    static final int MIN_SAMPLES_CAR = 30;
    static final long MIN_DRIVING_MS_CAR = 90_000L;
    /** No value from the car for this long while driving counts as none. */
    static final long NO_UPDATE_MS = 5_000L;
    /** The memory: ~30 minutes of samples at about one a second. */
    static final double FORGET = 1.0 - 1.0 / 1800.0;
    /** How much the starting values of the engine friction and of slowing down weigh, in samples. */
    static final double PRIOR_WEIGHT = 5.0;
    /**
     * The physical starting values of driving (rolling, air, inertia, hard acceleration) weigh this much, and four
     * times as much when the mass is known. They keep the correlated rolling and air terms from wandering on the few
     * values a car gives below its threshold: on the owner's recordings 5 samples made a steady speed 0.03 L/h worse
     * than the model before, and 30 make it 0.02.
     */
    static final double DRIVE_PRIOR_WEIGHT = 30.0;
    static final double CAR_PRIOR_WEIGHT = 120.0;
    /**
     * The idle weighs much more: a car that gives no value at low speed never shows its idle, and the line
     * through its values at speed would put it at about 0. With the engine displacement it weighs twice as much.
     */
    static final double IDLE_PRIOR_WEIGHT = 200.0;
    static final double IDLE_PRIOR_WEIGHT_CAR = 400.0;
    /** The speed where the car stops giving values, until it is known (km/h), and how fast the weight falls above it. */
    static final double DEFAULT_THRESHOLD_KMH = 30.0;
    static final double WEIGHT_SCALE_KMH = 20.0;
    static final double MAX_L_PER_100KM = 200.0;
    /** The time constant (ms) of the fading of the difference between the car's last value and the target. */
    static final long HANDOVER_TAU_MS = 3_000L;
    /** The bias of the last values: the gain of each value, the limit (L/h) and the time constant (ms) of its fading. */
    static final double BIAS_GAIN = 0.15;
    static final double BIAS_LIMIT_LPH = 1.0;
    static final long BIAS_TAU_MS = 60_000L;
    /** The speed (km/h) above the lowest one since the slowing down began that ends it. */
    static final double SLOWING_END_SPEEDUP_KMH = 2.0;
    /** The acceleration (m/s²) that begins the slowing down, and the one that ends it: the driver speeds up. */
    static final double SLOWING_ENTER_ACCEL = -0.2;
    static final double SLOWING_END_ACCEL = 0.3;
    /** Below this speed (km/h) the consumption is in L/h, and above the other one it is back in L/100 km. */
    static final double LOW_SPEED_ENTER_KMH = 10.0;
    static final double LOW_SPEED_EXIT_KMH = 13.0;
    /** Only a car that goes silent below its threshold has an estimate: "no value" counted this near it, and how many. */
    static final double NO_VALUE_NEAR_KMH = 5.0;
    static final int NO_VALUE_MIN = 20;
    /** Silence above the threshold by more than this (km/h) is a fault, not a threshold: no estimate. */
    static final double NO_ESTIMATE_ABOVE_KMH = 8.0;
    /** The edge correction: the car's values to average, the limit (L/h) and how fast it fades below the threshold. */
    static final int EDGE_MEMORY = 10;
    static final double EDGE_LIMIT_LPH = 1.5;
    static final double EDGE_SCALE_KMH = 10.0;
    /** The car's value must come back within this time (ms) of the last estimate to teach the edge. */
    static final long EDGE_RETURN_MS = 3000L;
    /** The RPM: older than this (ms) it is unknown; the idle RPM until it is learned; the weight of each stop. */
    static final long RPM_FRESH_MS = 5_000L;
    static final double DEFAULT_IDLE_RPM = 800.0;
    static final int IDLE_RPM_SAMPLES = 20;
    static final double IDLE_RPM_ALPHA = 0.05;
    /** The RPM checks: the first verdict after this many, then after each next RPM_RECHECKS; the share that must pass. */
    static final int RPM_CHECKS = 30;
    static final int RPM_RECHECKS = 100;
    static final double RPM_PASS_SHARE = 0.8;
    /** The car's data: the limits of what the settings may say (kg, cm³). */
    static final int MIN_MASS_KG = 500;
    static final int MAX_MASS_KG = 4000;
    static final int MIN_DISPLACEMENT_CC = 600;
    static final int MAX_DISPLACEMENT_CC = 8000;
    /** The starting values: L/h per W of the power at the wheels (Akçelik's 0.09 mL/kJ), a car of 1300 kg. */
    static final double BETA = 3.24e-4;
    static final double DEFAULT_MASS_KG = 1300.0;
    static final double DEFAULT_IDLE_LPH = 0.8;
    private static final double GRAVITY = 9.81;
    private static final double SMOOTH_RISE = 0.35;
    private static final double SMOOTH_FALL = 0.12;
    private static final long ACCEL_WINDOW_MS = 2000L;
    /** The coefficients of driving: the idle, rolling, air, inertia, hard acceleration, engine friction. */
    private static final int DRIVE_N = 6;
    private static final int COAST_N = 2;
    private static final double[] COAST_PRIOR = {0.6, 0.02};

    /** What the car is doing; checked in this order by {@link #mode}. */
    private enum Mode { STANDING, ENGINE_OFF, IDLE_ROLL, OVERRUN, DRIVING }

    /** An estimate: L/100 km while driving, L/h at a stop, while slowing down and at a low speed. */
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

        /** Other starting values; what was learned stays. */
        void setPrior(double[] prior, double[] priorWeight) {
            System.arraycopy(prior, 0, this.prior, 0, n);
            System.arraycopy(priorWeight, 0, this.priorWeight, 0, n);
        }

        void add(double[] f, double y, double w) {
            add(f, y, w, FORGET);
        }

        void add(double[] f, double y, double w, double forget) {
            for (int i = 0; i < n; i++) {
                b[i] = b[i] * forget + w * f[i] * y;
                for (int j = 0; j < n; j++) {
                    a[i][j] = a[i][j] * forget + w * f[i] * f[j];
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
                    a[i][j] = number(f[at++]);
                }
            }
            for (int i = 0; i < n; i++) {
                b[i] = number(f[at++]);
            }
            return at;
        }
    }

    private final Wls drive = new Wls(new double[DRIVE_N], new double[DRIVE_N]);
    private final Wls coast = new Wls(COAST_PRIOR, new double[]{PRIOR_WEIGHT, PRIOR_WEIGHT});
    private int samples;
    private long drivingMs;
    private double thresholdKmh = DEFAULT_THRESHOLD_KMH;
    private boolean rpmSeen;
    private boolean rpmValid;
    private double idleRpm = DEFAULT_IDLE_RPM;
    /** "No value" while driving at or just above the threshold: a car that goes silent below some speed. */
    private int noValueBelow;
    /** How much the model falls short of the car's values when speeding up just under the threshold, L/h. */
    private double edgeUpLph;
    private int edgeUpCount;
    // the car's data, from the settings: only the starting values
    private int massKg;
    private int displacementCc;

    // the moment, not saved
    private final ArrayDeque<double[]> speeds = new ArrayDeque<>();      // {t, km/h}
    private boolean speedFromCan;
    private boolean lowSpeed;
    private long lastSeenT;
    private long stillSinceT = -1;
    private long lastFuelT = -1;
    private boolean fuelSaysNothing;
    private double rpm = -1;
    private long rpmT = -1;
    private int rpmChecks;
    private int rpmPassed;
    private boolean rpmJudged;
    private int idleRpmSamples;
    private double idleRpmSum;
    private double smoothedLph = Double.NaN;
    private long lastCarT = -1;
    private double lastCarLph;
    private double handoverOffset;
    private long handoverT;
    private boolean slowing;
    private double slowingMinKmh;
    private double biasDrive;
    private long biasDriveT = -1;
    private double biasOverrun;
    private long biasOverrunT = -1;
    private long lastEstimateT = -1;
    private double lastEstimateLph;
    private double lastEdgeApplied;

    public FuelModel() {
        applyPriors();
    }

    // ---------------------------------------------------------------------------------------------
    // The car
    // ---------------------------------------------------------------------------------------------

    /**
     * The car's mass (kg) and engine displacement (cm³) from the settings; a value outside 500-4000 kg or
     * 600-8000 cm³ means unknown. They change only the starting values and the calibration, not what was learned.
     */
    public void setCar(int massKg, int displacementCc) {
        this.massKg = massKg >= MIN_MASS_KG && massKg <= MAX_MASS_KG ? massKg : 0;
        this.displacementCc = displacementCc >= MIN_DISPLACEMENT_CC && displacementCc <= MAX_DISPLACEMENT_CC
                ? displacementCc : 0;
        applyPriors();
    }

    private void applyPriors() {
        double m = massKg > 0 ? massKg : DEFAULT_MASS_KG;
        double cdA = 0.45 + 0.00015 * m;
        double idle = displacementCc > 0
                ? Math.max(0.4, Math.min(2.0, 0.2 + 0.30 * displacementCc / 1000.0)) : DEFAULT_IDLE_LPH;
        double w = massKg > 0 ? CAR_PRIOR_WEIGHT : DRIVE_PRIOR_WEIGHT;
        drive.setPrior(
                new double[]{idle, BETA * m, BETA * 0.6 * cdA * 1000.0, 1.05 * BETA * m, 1.08e-4 * m, 0},
                new double[]{displacementCc > 0 ? IDLE_PRIOR_WEIGHT_CAR : IDLE_PRIOR_WEIGHT, w, w, w, w, PRIOR_WEIGHT});
    }

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
        lastSeenT = Math.max(lastSeenT, t);
        speedFromCan = fromCan;
        double v = Math.max(0, kmh);
        speeds.addLast(new double[]{t, v});
        while (speeds.size() > 2 && t - (long) speeds.peekFirst()[0] > 3 * ACCEL_WINDOW_MS) {
            speeds.pollFirst();
        }
        if (lastFuelT < 0) {
            lastFuelT = t;      // "no update for 5 s" counts from the first speed
        }
        if (isMoving()) {
            stillSinceT = -1;
        } else if (stillSinceT < 0) {
            stillSinceT = t;
        }
        if (v < LOW_SPEED_ENTER_KMH) {
            lowSpeed = true;
        } else if (v > LOW_SPEED_EXIT_KMH) {
            lowSpeed = false;
        }
    }

    /** The RPM, when the car reports it, as of the latest time the model has heard of. */
    public void onRpm(int value) {
        onRpm(lastSeenT, value);
    }

    /**
     * The RPM at a time, when the car reports it. It is used once it has passed the checks: 0-8000; at a stop
     * (3 s and more) 0 or 450-1500; above 20 km/h 600-7000; 80 % of the first 30 must pass (a wrong code, such as
     * the speed or a counter, does not).
     */
    public void onRpm(long t, int value) {
        lastSeenT = Math.max(lastSeenT, t);
        rpm = value;
        rpmT = t;
        if (value > 0) {
            rpmSeen = true;
        }
        checkRpm(t, value);
        if (!isMoving() && value > 300 && value <= 1500) {
            learnIdleRpm(value);
        }
    }

    private void checkRpm(long t, int value) {
        boolean pass;
        if (value < 0 || value > 8000) {
            pass = false;
        } else if (!isMoving() && stillSinceT >= 0 && t - stillSinceT >= 3000) {
            pass = value == 0 || (value >= 450 && value <= 1500);
        } else if (kmh() > 20) {
            pass = value >= 600 && value <= 7000;
        } else {
            return;     // nothing to check it against
        }
        rpmChecks++;
        if (pass) {
            rpmPassed++;
        }
        if (rpmChecks >= (rpmJudged ? RPM_RECHECKS : RPM_CHECKS)) {
            rpmValid = rpmPassed >= RPM_PASS_SHARE * rpmChecks;
            rpmJudged = true;
            rpmChecks = 0;
            rpmPassed = 0;
        }
    }

    /** The idle RPM: the mean of the first 20 values at a stop, then an exponential average. */
    private void learnIdleRpm(int value) {
        if (idleRpmSamples < IDLE_RPM_SAMPLES) {
            idleRpmSum += value;
            if (++idleRpmSamples == IDLE_RPM_SAMPLES) {
                idleRpm = idleRpmSum / IDLE_RPM_SAMPLES;
            }
        } else {
            idleRpm += IDLE_RPM_ALPHA * (value - idleRpm);
        }
    }

    /**
     * A value of the car's fuel code: L/100 km × 10, or "no value" where the car has none. A 0 is the car's own
     * value at a stop and while slowing down (a car that cuts the fuel), and no value while driving on.
     */
    public void onFuel(long t, int value) {
        lastFuelT = t;
        lastSeenT = Math.max(lastSeenT, t);
        boolean moving = isMoving();
        double a = aEff(t);
        boolean slowingDown = !Double.isNaN(a) && a < COAST_ACCEL;
        if ((value > 0 && value < 3001) || (value == 0 && moving && slowingDown)) {
            fuelSaysNothing = false;
            double carLph = value / 10.0 * kmh() / 100.0;
            if (moving) {
                learnEdge(t, carLph);
                learnBias(t, carLph, a);
                lastCarT = t;
                lastCarLph = carLph;
            }
            smoothedLph = Double.NaN;       // the next estimate starts afresh, from the car's last value
            slowing = false;
            if (moving) {
                learn(t, carLph, a);
            }
        } else if (value == 0 && !moving) {
            fuelSaysNothing = false;        // 0 at a stop: the car's own value
        } else {
            // "no value" (65535 and the like), 0 while driving, or a value the widget would not show
            fuelSaysNothing = true;
            if (moving) {
                if (kmh() <= thresholdKmh + NO_VALUE_NEAR_KMH) {
                    noValueBelow = Math.min(noValueBelow + 1, 1_000_000);
                }
                // the speed where the car stops giving values: the 90th percentile of the speeds it gives none
                // at, followed a step at a time, so that a single "no value" at speed does not move it far
                thresholdKmh += kmh() > thresholdKmh ? 0.9 : -0.1;
                thresholdKmh = Math.max(5, Math.min(150, thresholdKmh));
            }
        }
    }

    /** The car's value is back while speeding up, soon after an estimate: how far the model was below it. */
    private void learnEdge(long t, double carLph) {
        double a = aEff(t);
        if (lastEstimateT < 0 || t - lastEstimateT > EDGE_RETURN_MS || Double.isNaN(a) || a <= 0) {
            return;
        }
        // against the model alone: what the correction added to the last estimate is not the model's
        double r = carLph - (lastEstimateLph - lastEdgeApplied);
        edgeUpCount = Math.min(edgeUpCount + 1, EDGE_MEMORY);
        edgeUpLph += (r - edgeUpLph) / edgeUpCount;
        edgeUpLph = Math.max(-EDGE_LIMIT_LPH, Math.min(EDGE_LIMIT_LPH, edgeUpLph));
        lastEstimateT = -1;     // one return, one sample
    }

    /** How far the car's value is from the model (nothing added to it), for driving and for slowing down apart. */
    private void learnBias(long t, double carLph, double a) {
        Mode mode = mode(t, a);
        if (mode != Mode.DRIVING && mode != Mode.OVERRUN) {
            return;
        }
        double r = carLph - level(mode, t, a);
        if (mode == Mode.DRIVING) {
            biasDrive = followed(biasDrive, biasDriveT, r, t);
            biasDriveT = t;
        } else {
            biasOverrun = followed(biasOverrun, biasOverrunT, r, t);
            biasOverrunT = t;
        }
    }

    private static double followed(double bias, long biasT, double r, long t) {
        double was = faded(bias, biasT, t);
        return Math.max(-BIAS_LIMIT_LPH, Math.min(BIAS_LIMIT_LPH, was + BIAS_GAIN * (r - was)));
    }

    private static double faded(double bias, long biasT, long now) {
        return biasT < 0 ? 0 : bias * Math.exp(-Math.max(0, now - biasT) / (double) BIAS_TAU_MS);
    }

    private void learn(long t, double lph, double a) {
        if (Double.isNaN(a)) {
            return;
        }
        Mode mode = mode(t, a);
        double kmh = kmh();
        double w = Math.exp(-Math.max(0, kmh - thresholdKmh) / WEIGHT_SCALE_KMH);
        double v = kmh / 3.6;
        switch (mode) {
            case DRIVING:
                drive.add(driveFeatures(v, a, frictionAt(t)), lph, w);
                break;
            case IDLE_ROLL:
                // the engine does not drive the wheels: the idle and the friction at these revs
                drive.add(new double[]{1, 0, 0, 0, 0, frictionAt(t)}, lph, w);
                break;
            case OVERRUN:
                if (rpmUsable(t) && !engineBraking(t)) {
                    return;     // revs below the idle: neither the idle nor engine braking
                }
                coast.add(new double[]{1, v}, lph, w);
                break;
            default:
                return;
        }
        samples++;
    }

    /** {@code [1, 0.108·v, v³/1000, max(aEff, 0)·v, max(aEff, 0)²·v, friction]}: no mass in them. */
    private static double[] driveFeatures(double v, double aEff, double friction) {
        double up = Math.max(aEff, 0);
        return new double[]{1, 0.108 * v, v * v * v / 1000.0, up * v, up * up * v, friction};
    }

    /** The friction feature of the engine, n·(1 + 0.15·n + 0.05·n²) with n = RPM/1000. */
    private static double friction(double rpm) {
        double n = rpm / 1000.0;
        return n * (1 + 0.15 * n + 0.05 * n * n);
    }

    /** The friction feature now: 0 without plausible, fresh RPM. */
    private double frictionAt(long now) {
        return rpmUsable(now) && rpm > 0 ? friction(rpm) : 0;
    }

    // ---------------------------------------------------------------------------------------------
    // The state of the car
    // ---------------------------------------------------------------------------------------------

    /** The RPM is plausible (it passed the checks) and fresh. */
    private boolean rpmUsable(long now) {
        return rpmValid && rpmT >= 0 && rpm >= 0 && now - rpmT <= RPM_FRESH_MS;
    }

    /** The half-width of the band around the idle RPM. */
    private double idleBand() {
        return Math.max(150.0, 0.15 * idleRpm);
    }

    private boolean inIdleBand(long now) {
        return rpmUsable(now) && rpm > 0 && Math.abs(rpm - idleRpm) <= idleBand();
    }

    /** The revs are well above the idle: the engine brakes, and a car that cuts the fuel burns none. */
    private boolean engineBraking(long now) {
        return rpmUsable(now) && rpm > idleRpm + idleBand();
    }

    /** The mode, in this order; a NaN acceleration counts as none. */
    private Mode mode(long now, double aEff) {
        double a = Double.isNaN(aEff) ? 0 : aEff;
        if (rpmUsable(now) && rpm == 0) {
            return Mode.ENGINE_OFF;
        }
        if (!isMoving()) {
            return Mode.STANDING;
        }
        if (inIdleBand(now) && a <= 0.3) {
            return Mode.IDLE_ROLL;
        }
        if (a < COAST_ACCEL) {
            return Mode.OVERRUN;
        }
        return Mode.DRIVING;
    }

    /** m/s²: the acceleration with the grade (sin θ = 0 until the road grade is known). NaN without enough speeds. */
    private double aEff(long now) {
        return accel(now);
    }

    // ---------------------------------------------------------------------------------------------
    // Output
    // ---------------------------------------------------------------------------------------------

    /** Enough of the car's own values to stand for them. */
    public boolean calibrated() {
        boolean car = massKg > 0 && displacementCc > 0;
        return samples >= (car ? MIN_SAMPLES_CAR : MIN_SAMPLES) && drivingMs >= (car ? MIN_DRIVING_MS_CAR : MIN_DRIVING_MS);
    }

    /** The car goes silent below some speed, and the model is calibrated: the only cars with an estimate. */
    public boolean thresholdCar() {
        return noValueBelow >= NO_VALUE_MIN && calibrated();
    }

    /** The speed is under 10 km/h (back above 13): the consumption is in litres per hour. */
    public boolean lowSpeed() {
        return lowSpeed;
    }

    /** The car gives no value now: "no value", 0 while driving, or nothing for 5 s while driving. */
    public boolean carGivesNoValue(long now) {
        return fuelSaysNothing || (isMoving() && lastFuelT >= 0 && now - lastFuelT > NO_UPDATE_MS);
    }

    /** The estimate to show now, or null: not a threshold car, not calibrated, silent at speed, or the car gives a value. */
    public Estimate estimate(long now) {
        if (!thresholdCar() || !carGivesNoValue(now) || speeds.isEmpty()) {
            return null;
        }
        double kmh = kmh();
        if (kmh > thresholdKmh + NO_ESTIMATE_ABOVE_KMH) {
            return null;
        }
        boolean moving = isMoving();
        double a = aEff(now);
        Mode mode = mode(now, a);
        double edge = edgeLph(now);
        lastEdgeApplied = edge;
        double target = Math.max(0, level(mode, now, a) + bias(mode, now) + edge);
        if (Double.isNaN(smoothedLph)) {
            handoverOffset = 0;
            slowing = false;
            smoothedLph = target;
            if (moving && lastCarT >= 0 && now - lastCarT <= NO_UPDATE_MS) {
                // the car has just gone silent: start from its last value, the way to the target is gradual
                handoverOffset = lastCarLph - target;
                handoverT = now;
                smoothedLph = lastCarLph;
                slowingMinKmh = kmh;
                slowing = !Double.isNaN(a) && a < 0;
            }
        }
        double lph = target;
        if (moving) {
            lph = Math.max(0, target + handoverOffset * Math.exp(-(now - handoverT) / (double) HANDOVER_TAU_MS));
        }
        double alpha = lph > smoothedLph ? SMOOTH_RISE : SMOOTH_FALL;
        smoothedLph = alpha * lph + (1 - alpha) * smoothedLph;
        updateSlowing(moving, kmh, a);
        if (!moving) {
            lastEstimateT = -1;
            return new Estimate(smoothedLph, true);
        }
        lastEstimateT = now;
        if (slowing || lowSpeed) {
            lastEstimateLph = smoothedLph;
            return new Estimate(smoothedLph, true);
        }
        double value = Math.min(MAX_L_PER_100KM, smoothedLph / kmh * 100.0);
        lastEstimateLph = value * kmh / 100.0;
        return new Estimate(value, false);
    }

    /** Slowing down lights at -0.2 m/s² and goes out when the speed is 2 km/h above its lowest since, or at +0.3. */
    private void updateSlowing(boolean moving, double kmh, double a) {
        if (!moving) {
            slowing = false;
            return;
        }
        double acc = Double.isNaN(a) ? 0 : a;
        if (slowing) {
            slowingMinKmh = Math.min(slowingMinKmh, kmh);
            if (kmh > slowingMinKmh + SLOWING_END_SPEEDUP_KMH || acc > SLOWING_END_ACCEL) {
                slowing = false;
            }
        } else if (acc < SLOWING_ENTER_ACCEL) {
            slowing = true;
            slowingMinKmh = kmh;
        }
    }

    /** The bias of the last values for a mode, faded; at a stop only the positive part (the air conditioning, a cold engine). */
    private double bias(Mode mode, long now) {
        switch (mode) {
            case DRIVING:
                return faded(biasDrive, biasDriveT, now);
            case OVERRUN:
                return faded(biasOverrun, biasOverrunT, now);
            case STANDING:
                return Math.max(0, faded(biasDrive, biasDriveT, now));
            default:
                return 0;
        }
    }

    /** Speeding up just under the threshold: the learned shortfall, full at the threshold, fading below it. */
    private double edgeLph(long now) {
        if (!isMoving() || edgeUpLph == 0) {
            return 0;
        }
        double a = aEff(now);
        if (Double.isNaN(a) || a < COAST_ACCEL || a <= 0) {
            return 0;
        }
        return edgeUpLph * Math.exp(-Math.max(0, thresholdKmh - kmh()) / EDGE_SCALE_KMH);
    }

    /** The model's L/h now, as learned, with no bias and no edge. */
    double litresPerHour(long now) {
        double a = aEff(now);
        return level(mode(now, a), now, a);
    }

    private double level(Mode mode, long now, double aEff) {
        double[] c = clampDrive(drive.solve());
        double a = Double.isNaN(aEff) ? 0 : aEff;
        switch (mode) {
            case ENGINE_OFF:
                return 0;
            case STANDING:
                return idle();
            case IDLE_ROLL:
                return Math.max(0, c[0] + c[5] * frictionAt(now));
            case OVERRUN:
                return coastLevel(kmh(), engineBraking(now));
            default:
                double[] f = driveFeatures(kmh() / 3.6, a, frictionAt(now));
                double motion = 0;
                for (int i = 1; i <= 4; i++) {
                    motion += c[i] * f[i];
                }
                return Math.max(0, c[0] + Math.max(0, motion) + c[5] * f[5]);
        }
    }

    /**
     * The level while slowing down at a speed (km/h): the learned line, but without RPM that shows engine braking
     * below the threshold it falls linearly from the car's level at the threshold to the idle at a stop.
     */
    private double coastLevel(double kmh, boolean engineBraking) {
        double[] c = coast.solve();
        double learned = Math.max(0, Math.min(2.5, c[0] + c[1] * kmh / 3.6));
        if (engineBraking || kmh >= thresholdKmh) {
            return learned;
        }
        double idle = idle();
        double atTheThreshold = Math.max(0, Math.min(2.5, c[0] + c[1] * thresholdKmh / 3.6));
        return idle + (atTheThreshold - idle) * kmh / thresholdKmh;
    }

    private static double[] clampDrive(double[] p, double[] prior) {
        p[0] = Math.max(0.3, Math.min(2.5, p[0]));
        for (int i = 1; i <= 3; i++) {
            p[i] = Math.max(0, Math.min(3 * prior[i], p[i]));
        }
        p[4] = Math.max(-p[3] / 6, Math.min(3 * prior[4], p[4]));
        p[5] = Math.max(0, Math.min(2, p[5]));
        return p;
    }

    private double[] clampDrive(double[] p) {
        return clampDrive(p, drive.prior);
    }

    /** The idle, L/h, as learned: the constant losses and, with RPM, the friction at the idle RPM. */
    double idle() {
        double[] c = clampDrive(drive.solve());
        return c[0] + (rpmValid ? c[5] * friction(idleRpm) : 0);
    }

    /** The level while slowing down at this speed (km/h), L/h, as learned, with no RPM. */
    double coastAt(double kmh) {
        return coastLevel(kmh, false);
    }

    int samples() {
        return samples;
    }

    /** The coefficients of driving as solved, before the limits: idle, rolling, air, inertia, hard acceleration, friction. */
    double[] driveCoefficients() {
        return drive.solve();
    }

    double thresholdKmh() {
        return thresholdKmh;
    }

    double idleRpm() {
        return idleRpm;
    }

    boolean rpmValid() {
        return rpmValid;
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
     * code to the GPS speed), else from the values (multiples of 100 or 10 that pass 260). 0 until it is known, and
     * when the code does not follow the GPS (then the service uses the GPS).
     */
    public static final class SpeedScale {
        /** The comparisons with the GPS needed to judge the code, and how far off the scale (ln) it may be: 25 %. */
        private static final int MIN_RATIOS = 10;
        private static final double MAX_RATIO_OFF = Math.log(1.25);
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

        /**
         * The scale, or 0 while it is not known or the code does not follow the GPS: after 10 comparisons a ratio
         * more than 25 % off the chosen scale (a known one too) means this is not the speed.
         */
        public int scale() {
            int chosen = chosen();
            if (chosen > 0 && ratios >= MIN_RATIOS && Math.abs(Math.log(ratioSum / ratios / chosen)) > MAX_RATIO_OFF) {
                return 0;
            }
            return chosen;
        }

        private int chosen() {
            if (fixed > 0) {
                return fixed;
            }
            if (ratios >= MIN_RATIOS) {
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

    /** What the model learned, for the settings (the car's data is in the settings already). */
    public String serialize() {
        StringBuilder sb = new StringBuilder("3;");
        sb.append(samples).append(';').append(drivingMs).append(';').append(thresholdKmh).append(';')
                .append(rpmSeen ? 1 : 0).append(';').append(rpmValid ? 1 : 0).append(';').append(idleRpm).append(';')
                .append(noValueBelow).append(';').append(edgeUpLph).append(';').append(edgeUpCount);
        drive.write(sb);
        coast.write(sb);
        return sb.toString();
    }

    /**
     * A model from {@link #serialize()}'s text; the older formats (1 and 2) are read with what they learned moved
     * to the new model; a new one for nothing or a text it does not know.
     */
    public static FuelModel parse(String text) {
        if (text == null) {
            return new FuelModel();
        }
        try {
            if (text.startsWith("3;")) {
                return parseV3(text);
            }
            if (text.startsWith("1;") || text.startsWith("2;")) {
                return parseLegacy(text);
            }
        } catch (RuntimeException e) {
            return new FuelModel();
        }
        return new FuelModel();
    }

    private static FuelModel parseV3(String text) {
        FuelModel m = new FuelModel();
        String[] f = text.split(";", -1);
        m.samples = Integer.parseInt(f[1]);
        m.drivingMs = Long.parseLong(f[2]);
        m.thresholdKmh = number(f[3]);
        m.rpmSeen = "1".equals(f[4]);
        m.rpmValid = "1".equals(f[5]);
        m.rpmJudged = m.rpmValid;
        m.idleRpm = number(f[6]);
        if (m.idleRpm != DEFAULT_IDLE_RPM) {
            m.idleRpmSamples = IDLE_RPM_SAMPLES;      // learned already
        }
        m.noValueBelow = Integer.parseInt(f[7]);
        m.edgeUpLph = number(f[8]);
        m.edgeUpCount = Integer.parseInt(f[9]);
        int at = m.drive.read(f, 10);
        at = m.coast.read(f, at);
        if (at != f.length || m.samples < 0 || m.drivingMs < 0 || m.noValueBelow < 0 || m.edgeUpCount < 0
                || m.thresholdKmh < 5 || m.thresholdKmh > 150 || m.idleRpm < 300 || m.idleRpm > 2000
                || Math.abs(m.edgeUpLph) > EDGE_LIMIT_LPH) {
            return new FuelModel();
        }
        return m;
    }

    /** The starting values and the weights of the model before v3 (4 coefficients: idle, kc, ka, kr). */
    private static final double[] LEGACY_DRIVE_PRIOR = {0.8, 0.45, 0.1, 0.0};
    private static final double[] LEGACY_DRIVE_WEIGHT = {200, 5, 5, 5};
    /** The pseudo-samples that carry the old driving model over: speeds (km/h) and accelerations (m/s²). */
    private static final double[] LEGACY_SPEEDS = {28, 32, 36, 40, 44, 50, 60};
    private static final double[] LEGACY_ACCELS = {-0.25, 0, 0.4, 0.8, 1.2};

    private static FuelModel parseLegacy(String text) {
        boolean v2 = text.startsWith("2;");
        String[] f = text.split(";", -1);
        FuelModel m = new FuelModel();
        m.samples = Integer.parseInt(f[1]);
        m.drivingMs = Long.parseLong(f[2]);
        m.thresholdKmh = number(f[3]);
        m.rpmSeen = "1".equals(f[4]);
        Wls old = new Wls(LEGACY_DRIVE_PRIOR, LEGACY_DRIVE_WEIGHT);
        int at = old.read(f, 5);
        at = m.coast.read(f, at);
        if (v2) {
            // the edge was measured against the old model: dropped
            number(f[at++]);
            if (Integer.parseInt(f[at++]) < 0) {
                return new FuelModel();
            }
        }
        if (at != f.length || m.samples < 0 || m.drivingMs < 0 || m.thresholdKmh < 5 || m.thresholdKmh > 150) {
            return new FuelModel();
        }
        // the old driving model cannot be moved over coefficient by coefficient: its values go in as samples
        double[] p = old.solve();
        double w = Math.min(m.samples, MIN_SAMPLES) / (double) (LEGACY_SPEEDS.length * LEGACY_ACCELS.length);
        for (double kmh : LEGACY_SPEEDS) {
            for (double a : LEGACY_ACCELS) {
                double v = kmh / 3.6;
                m.drive.add(driveFeatures(v, a, 0), legacyDriveLph(p, v, a), w, 1.0);
            }
        }
        m.samples = Math.min(m.samples, MIN_SAMPLES);
        m.drivingMs = Math.min(m.drivingMs, MIN_DRIVING_MS);
        m.noValueBelow = m.thresholdKmh != DEFAULT_THRESHOLD_KMH ? NO_VALUE_MIN : 0;
        return m;
    }

    /** L/h of the model before v3: {@code idle + kc·(0.15·v + 0.00031·v³) + ka·max(a, 0)·v}, as it was limited. */
    private static double legacyDriveLph(double[] p, double v, double a) {
        double idle = Math.max(0.3, Math.min(2.5, p[0]));
        double kc = Math.max(0, Math.min(3, p[1]));
        double ka = Math.max(0, Math.min(1, p[2]));
        return idle + kc * (0.15 * v + 0.00031 * v * v * v) + ka * Math.max(a, 0) * v;
    }

    private static double number(String s) {
        double d = Double.parseDouble(s);
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new NumberFormatException(s);
        }
        return d;
    }
}
