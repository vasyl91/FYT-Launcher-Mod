package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Which of the fuel/range code pairs of the library (one for each version of the canbus module: the codes moved
 * between them) is the one this radio really reports, decided from the values the codes give.
 *
 * <ul>
 * <li>A value is <b>reliable</b> for a fuel code when it is 1..3000 (L/100 km ×10) or 65535 ("no value", but the code
 * is alive), and for a range code when it is 1..2000 (km). 0 and the rest say nothing.</li>
 * <li>A pair is <b>confirmed</b> when its fuel or its range code gave at least {@link #MIN_VALUES} reliable values,
 * at least two of them different. The first confirmed pair, in the order of the library (the newest module first),
 * is chosen, and stays chosen.</li>
 * <li>The choice changes only when the chosen pair gave nothing reliable for {@link #SWITCH_DRIVING_MS} of driving
 * and another pair is confirmed.</li>
 * <li>Before any pair is confirmed the pair in use is the first one that gave a reliable value, else the first.</li>
 * </ul>
 *
 * Code 0 is "not set" in the settings and is never tracked. Plain Java (no android.*), so that it runs in JVM tests.
 * The values arrive on binder threads and the driving on the main thread: every method is synchronized.
 */
final class CodePairChooser {

    /** Reliable values needed to confirm a pair, and how many of them must differ. */
    static final int MIN_VALUES = 10;
    static final int MIN_DISTINCT = 2;
    /** Driving without a reliable value of the chosen pair before another confirmed pair takes over. */
    static final long SWITCH_DRIVING_MS = 10L * 60_000L;
    /** The most one driving tick counts for, so that a gap (a sleep, a stopped service) is not driving time. */
    static final long MAX_TICK_MS = 5_000L;
    /** "No value" of a fuel code. */
    static final int NO_VALUE = 65535;
    static final int FUEL_MAX = 3000;
    static final int RANGE_MAX = 2000;

    /** The pair in use, for the settings window. */
    static final class Status {
        final List<CanbusLibrary.CarCodes> pairs;
        final int index;
        final boolean confirmed;

        Status(List<CanbusLibrary.CarCodes> pairs, int index, boolean confirmed) {
            this.pairs = Collections.unmodifiableList(new ArrayList<>(pairs));
            this.index = index;
            this.confirmed = confirmed;
        }

        CanbusLibrary.CarCodes pair() {
            return pairs.get(index);
        }

        /** {@code 102/103, 91/92} */
        String pairsText() {
            StringBuilder sb = new StringBuilder();
            for (CanbusLibrary.CarCodes p : pairs) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(pairText(p));
            }
            return sb.toString();
        }
    }

    /** What one code gave: the reliable values it gave, and whether they were not all the same. */
    private static final class Track {
        final int code;
        final boolean fuel;
        int reliable;
        int first = -1;
        boolean differs;

        Track(int code, boolean fuel) {
            this.code = code;
            this.fuel = fuel;
        }

        boolean reliable(int value) {
            return fuel ? (value >= 1 && value <= FUEL_MAX) || value == NO_VALUE : value >= 1 && value <= RANGE_MAX;
        }

        /** True if the value was reliable. */
        boolean add(int value) {
            if (!reliable(value)) {
                return false;
            }
            reliable++;
            if (first < 0) {
                first = value;
            } else if (value != first) {
                differs = true;
            }
            return true;
        }

        boolean confirmed() {
            return reliable >= MIN_VALUES && differs;
        }
    }

    private final List<CanbusLibrary.CarCodes> pairs;
    private final Track[][] tracks;
    /** The chosen (confirmed) pair, or -1 while none is. */
    private int chosen = -1;
    /** Driving time since the chosen pair last gave a reliable value. */
    private long drivingWithoutValueMs;
    private long lastTickAt = -1;

    CodePairChooser(List<CanbusLibrary.CarCodes> pairs) {
        if (pairs.isEmpty()) {
            throw new IllegalArgumentException("no pairs");
        }
        this.pairs = Collections.unmodifiableList(new ArrayList<>(pairs));
        tracks = new Track[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            CanbusLibrary.CarCodes p = pairs.get(i);
            tracks[i][0] = p.fuel > 0 ? new Track(p.fuel, true) : null;
            tracks[i][1] = p.range > 0 ? new Track(p.range, false) : null;
        }
    }

    /** The codes of all the pairs (above 0), to register. */
    synchronized Set<Integer> codes() {
        Set<Integer> out = new LinkedHashSet<>();
        for (Track[] pair : tracks) {
            for (Track t : pair) {
                if (t != null) {
                    out.add(t.code);
                }
            }
        }
        return out;
    }

    /** The choice saved earlier: the pair with these codes, if the library still has it. Returns whether it was set. */
    synchronized boolean restore(CanbusLibrary.CarCodes saved) {
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).equals(saved)) {
                chosen = i;
                drivingWithoutValueMs = 0;
                return true;
            }
        }
        return false;
    }

    /**
     * A value of a code. Returns whether the pair in use or whether it is confirmed changed.
     */
    synchronized boolean onValue(int code, int value) {
        int before = state();
        boolean aliveChosen = false;
        for (int i = 0; i < tracks.length; i++) {
            for (Track t : tracks[i]) {
                if (t != null && t.code == code && t.add(value) && i == chosen) {
                    aliveChosen = true;
                }
            }
        }
        if (aliveChosen) {
            drivingWithoutValueMs = 0;
        }
        if (chosen < 0) {
            chosen = firstConfirmed(-1);
            drivingWithoutValueMs = 0;
        }
        return state() != before;
    }

    /**
     * The car is (not) driving at {@code nowMillis}. Returns whether the pair in use changed.
     */
    synchronized boolean onDriving(long nowMillis, boolean driving) {
        long since = lastTickAt;
        lastTickAt = nowMillis;
        if (!driving || since < 0 || chosen < 0) {
            return false;
        }
        drivingWithoutValueMs += Math.max(0, Math.min(nowMillis - since, MAX_TICK_MS));
        if (drivingWithoutValueMs < SWITCH_DRIVING_MS) {
            return false;
        }
        int before = state();
        int other = firstConfirmed(chosen);
        if (other >= 0) {
            chosen = other;
            drivingWithoutValueMs = 0;
        }
        return state() != before;
    }

    /** The first confirmed pair other than {@code except}, or -1. */
    private int firstConfirmed(int except) {
        for (int i = 0; i < tracks.length; i++) {
            if (i == except) {
                continue;
            }
            for (Track t : tracks[i]) {
                if (t != null && t.confirmed()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /** The pair in use: the chosen one, else the first that gave a reliable value, else the first. */
    synchronized Status status() {
        return new Status(pairs, indexInUse(), chosen >= 0);
    }

    private int indexInUse() {
        if (chosen >= 0) {
            return chosen;
        }
        for (int i = 0; i < tracks.length; i++) {
            for (Track t : tracks[i]) {
                if (t != null && t.reliable > 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    /** The pair in use and whether it is chosen, as one number to compare. */
    private int state() {
        return indexInUse() * 2 + (chosen >= 0 ? 1 : 0);
    }

    // ---------------------------------------------------------------------------------------------
    // The saved choice
    // ---------------------------------------------------------------------------------------------

    /** The settings key of the choice for a car. */
    static String key(int carId) {
        return "code_pair_" + carId;
    }

    /** {@code 1:91/92}: the index of the pair and its codes ({@code -} for an unknown one). */
    static String encode(int index, CanbusLibrary.CarCodes pair) {
        return index + ":" + pairText(pair);
    }

    /** The pair a saved text names, or null if the text is not one. */
    static CanbusLibrary.CarCodes decode(String saved) {
        if (saved == null) {
            return null;
        }
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("\\d{1,2}:(\\d{1,4}|-)/(\\d{1,4}|-)").matcher(saved.trim());
        if (!m.matches()) {
            return null;
        }
        int fuel = m.group(1).equals("-") ? -1 : Integer.parseInt(m.group(1));
        int range = m.group(2).equals("-") ? -1 : Integer.parseInt(m.group(2));
        return fuel < 0 && range < 0 ? null : new CanbusLibrary.CarCodes(fuel, range);
    }

    /** {@code 91/92}, {@code -/92} */
    static String pairText(CanbusLibrary.CarCodes p) {
        return (p.fuel < 0 ? "-" : String.valueOf(p.fuel)) + "/" + (p.range < 0 ? "-" : String.valueOf(p.range));
    }
}
