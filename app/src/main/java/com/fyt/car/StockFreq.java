package com.fyt.car;

import java.util.Locale;

/**
 * Radio frequencies as com.syu.ms reports them (module 1, code 1): FM in units of 10 kHz (10150
 * is 101.50 MHz), AM in kHz (1008). The same reading as LauncherRadioWidget: above 5000 is FM.
 * No Android classes in here.
 */
public final class StockFreq {

    private StockFreq() {
    }

    public static boolean isFm(int freq) {
        return freq > 5000;
    }

    /** The number as com.syu.radio shows it and names its logo files after: "101.50", "1008". */
    public static String format(int freq) {
        if (!isFm(freq)) {
            return String.valueOf(freq);
        }
        // Integers: a float would turn 10150 into 101.5 and 8750 into 87.5 at times
        return String.format(Locale.US, "%d.%02d", freq / 100, freq % 100);
    }

    /** "FM 101.50" / "AM 1008": a station without a name. */
    public static String title(int freq) {
        return (isFm(freq) ? "FM " : "AM ") + format(freq);
    }

    /** "FM 101.50 MHz" / "AM 1008 kHz". */
    public static String titleWithUnit(int freq) {
        return title(freq) + (isFm(freq) ? " MHz" : " kHz");
    }

    public static String band(int freq) {
        return isFm(freq) ? "FM" : "AM";
    }

    /**
     * Whether a frequency as a file writes it ("101.5", "101.50", "1008") is this one. Compared as
     * numbers, as the files of the users are not all written alike.
     */
    public static boolean sameFrequency(String written, int freq) {
        if (written == null) {
            return false;
        }
        String s = written.trim();
        if (s.isEmpty()) {
            return false;
        }
        try {
            double value = Double.parseDouble(s.replace(',', '.'));
            if (isFm(freq)) {
                return Math.abs(value - freq / 100.0) < 0.005;
            }
            return Math.abs(value - freq) < 0.5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * The name and frequency of a logo file of com.syu.radio, "&lt;Name&gt;_&lt;freq&gt;.png":
     * split at the last underscore (the name may have one).
     *
     * @return {name, freq}, or null for a file that is not one
     */
    public static String[] parseLogoFileName(String fileName) {
        if (fileName == null || !fileName.regionMatches(true, Math.max(0, fileName.length() - 4),
                ".png", 0, 4)) {
            return null;
        }
        String base = fileName.substring(0, fileName.length() - 4);
        int cut = base.lastIndexOf('_');
        if (cut <= 0 || cut == base.length() - 1) {
            return null;
        }
        return new String[]{base.substring(0, cut), base.substring(cut + 1)};
    }
}
