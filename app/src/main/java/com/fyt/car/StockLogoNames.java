package com.fyt.car;

/**
 * The names of the station logos of com.syu.media's radio, as that app reads them, free of android.* so
 * that it can be tested on the JVM. The 7862's com.syu.radio is more lenient (see
 * {@link StockFreq#parseLogoFileName}); the 7870's com.syu.media (RadioIconCache.coverSave) takes a file in
 * radio_logo only if
 * <ul>
 *   <li>its name split at "_" gives exactly 2 parts,</li>
 *   <li>it ends with ".png" (exactly: ".PNG" is not one),</li>
 *   <li>the second part without ".png" is a frequency whose "." are dropped and which then is a whole
 *       number: "90.40" is 9040, "90.4" is 904 (which is not the FM 90.40 MHz, 9040 in the units of
 *       com.syu.ms), "1008" is 1008.</li>
 * </ul>
 * The widget shows the same logo that app shows, so it asks the same.
 */
public final class StockLogoNames {

    private StockLogoNames() {
    }

    /** A logo file: the name of the station and its frequency in the units of com.syu.ms. */
    public static final class Logo {
        public final String name;
        public final int freq;

        Logo(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    /** @return the name and frequency of a file name, null for a file com.syu.media would not take */
    public static Logo parse(String fileName) {
        if (fileName == null || !fileName.endsWith(".png")) {
            return null;
        }
        String[] parts = fileName.split("_", -1);
        if (parts.length != 2 || parts[0].isEmpty()) {
            return null;
        }
        String freqText = parts[1].substring(0, parts[1].length() - 4).replace(".", "");
        if (freqText.isEmpty()) {
            return null;
        }
        try {
            return new Logo(parts[0], Integer.parseInt(freqText));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * The picture com.syu.media shows for a station without a logo: radio1 .. radio3 of its resources. It
     * picks one at random; the widget needs one that stays the same for a frequency.
     */
    public static String fallbackDrawable(int freq) {
        return "radio" + (1 + Math.floorMod(freq, 3));
    }
}
