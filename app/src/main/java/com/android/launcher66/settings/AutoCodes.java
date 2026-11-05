package com.android.launcher66.settings;

import java.util.List;
import java.util.Map;

/**
 * The fuel and range codes the automatic canbus check found for a car, kept per car id as
 * {@code fuel;range;fuelSilent;rangeSilent} (-1 = none found). "Silent" says the library's code for
 * the car gave no data in the recording while the found one did, which is when the found one is used
 * in place of the library's. A code the user typed always wins, see {@link #choose}.
 *
 * <p>Plain Java (no android.*), so that it runs in JVM tests.
 */
final class AutoCodes {

    final int fuel;
    final int range;
    final boolean fuelSilent;
    final boolean rangeSilent;

    AutoCodes(int fuel, int range, boolean fuelSilent, boolean rangeSilent) {
        this.fuel = fuel;
        this.range = range;
        this.fuelSilent = fuelSilent;
        this.rangeSilent = rangeSilent;
    }

    static String key(int carId) {
        return Keys.AUTO_CODES_PREFIX + carId;
    }

    boolean isEmpty() {
        return fuel < 0 && range < 0;
    }

    String serialize() {
        return fuel + ";" + range + ";" + fuelSilent + ";" + rangeSilent;
    }

    /** null for nothing or a text that is not {@link #serialize()}'s. */
    static AutoCodes parse(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        String[] f = text.split(";", -1);
        if (f.length != 4) {
            return null;
        }
        try {
            return new AutoCodes(Integer.parseInt(f[0]), Integer.parseInt(f[1]),
                    Boolean.parseBoolean(f[2]), Boolean.parseBoolean(f[3]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * What the check found: the guesses of the recording, and whether the library's codes (those of
     * all its pairs for the car) said nothing in it where the guess did. {@code events} is the
     * recording by code, so a code is silent when it has no update.
     */
    static AutoCodes of(int guessFuel, int guessRange, List<CanbusLibrary.CarCodes> libraryPairs,
                        Map<Integer, ? extends List<?>> events) {
        return new AutoCodes(guessFuel, guessRange,
                silent(guessFuel, libraryPairs, events, true), silent(guessRange, libraryPairs, events, false));
    }

    private static boolean silent(int guess, List<CanbusLibrary.CarCodes> pairs, Map<Integer, ? extends List<?>> events,
                                  boolean fuel) {
        if (guess < 0 || !hasData(events, guess) || pairs == null) {
            return false;
        }
        boolean any = false;
        for (CanbusLibrary.CarCodes pair : pairs) {
            int code = fuel ? pair.fuel : pair.range;
            if (code > 0) {
                any = true;
                if (hasData(events, code)) {
                    return false;
                }
            }
        }
        return any;
    }

    private static boolean hasData(Map<Integer, ? extends List<?>> events, int code) {
        List<?> list = events == null ? null : events.get(code);
        return list != null && !list.isEmpty();
    }

    /**
     * The code in use for fuel (or range): the user's if there is one; else the library's, the one
     * that gives data (confirmed by live data, or not known to be silent); else the check's; else
     * whatever the library has.
     *
     * @param user              the code of the settings, 0 = none
     * @param library           the code of the pair of the library in use, 0 = none
     * @param libraryConfirmed  the library's code has delivered data in this run
     * @param candidate         the check's code, -1 or 0 = none
     * @param librarySilent     the check found the library's code silent
     */
    static int choose(int user, int library, boolean libraryConfirmed, int candidate, boolean librarySilent) {
        if (user > 0) {
            return user;
        }
        if (library > 0 && (libraryConfirmed || !librarySilent || candidate <= 0)) {
            return library;
        }
        if (candidate > 0) {
            return candidate;
        }
        return Math.max(library, 0);
    }
}
