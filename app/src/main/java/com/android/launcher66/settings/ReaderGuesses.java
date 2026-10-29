package com.android.launcher66.settings;

import com.android.launcher66.settings.CanbusCodeEstimator.Category;
import com.android.launcher66.settings.CanbusCodeEstimator.Guess;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * The codes the code reader found for a car: its best guesses of the fuel consumption, the range, the speed
 * (with its scale) and the RPM, kept in the settings per car id. The Canbus codes window shows them, and an
 * empty speed field uses the reader's speed code. A reading that did not find one of them keeps the one found
 * before.
 *
 * Plain Java (no android.*), so that it runs in JVM tests.
 */
public final class ReaderGuesses {

    /** The scores a guess needs to be kept: a speed only when it followed the GPS. */
    static final double MIN_SCORE = 0.6;
    static final double MIN_SPEED_SCORE = 0.9;

    public final long time;
    /** -1 = not found. */
    public final int fuel;
    public final int range;
    public final int speed;
    /** The speed code is km/h times this. */
    public final int speedScale;
    public final int rpm;

    ReaderGuesses(long time, int fuel, int range, int speed, int speedScale, int rpm) {
        this.time = time;
        this.fuel = fuel;
        this.range = range;
        this.speed = speed;
        this.speedScale = speed < 0 ? 1 : Math.max(1, speedScale);
        this.rpm = rpm;
    }

    /** The settings key for a car. */
    static String key(int carId) {
        return "reader_guesses_" + carId;
    }

    /** The best guesses of a reading; fields without a good enough guess are -1. */
    static ReaderGuesses of(CanbusCodeEstimator.Result result, long time) {
        int fuel = -1;
        int range = -1;
        int speed = -1;
        int scale = 1;
        int rpm = -1;
        if (result != null) {
            // The guesses are by category, the best first: the first of each is the one
            for (Guess g : result.guesses) {
                if (g.category == Category.FUEL_INSTANT && fuel < 0 && g.score >= MIN_SCORE) {
                    fuel = g.code;
                } else if (g.category == Category.RANGE && range < 0 && g.score >= MIN_SCORE) {
                    range = g.code;
                } else if (g.category == Category.SPEED && speed < 0 && g.score >= MIN_SPEED_SCORE) {
                    speed = g.code;
                    scale = g.scale;
                } else if (g.category == Category.RPM && rpm < 0 && g.score >= MIN_SCORE) {
                    rpm = g.code;
                }
            }
        }
        return new ReaderGuesses(time, fuel, range, speed, scale, rpm);
    }

    boolean isEmpty() {
        return fuel < 0 && range < 0 && speed < 0 && rpm < 0;
    }

    /** These guesses, with the ones of {@code older} where this reading found none. */
    ReaderGuesses over(ReaderGuesses older) {
        if (older == null) {
            return this;
        }
        boolean ownSpeed = speed >= 0;
        return new ReaderGuesses(time, fuel >= 0 ? fuel : older.fuel, range >= 0 ? range : older.range,
                ownSpeed ? speed : older.speed, ownSpeed ? speedScale : older.speedScale,
                rpm >= 0 ? rpm : older.rpm);
    }

    /** {@code time;fuel;range;speed;scale;rpm} */
    String serialize() {
        return time + ";" + fuel + ";" + range + ";" + speed + ";" + speedScale + ";" + rpm;
    }

    /** null for nothing or a text that is not {@link #serialize()}'s. */
    static ReaderGuesses parse(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        String[] f = text.split(";", -1);
        if (f.length != 6) {
            return null;
        }
        try {
            return new ReaderGuesses(Long.parseLong(f[0]), Integer.parseInt(f[1]), Integer.parseInt(f[2]),
                    Integer.parseInt(f[3]), Integer.parseInt(f[4]), Integer.parseInt(f[5]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** {@code fuel 91, range 92, speed 510 (/100)}: what was found; an empty text if nothing. */
    String codesText() {
        StringBuilder sb = new StringBuilder();
        append(sb, "fuel", fuel, "");
        append(sb, "range", range, "");
        append(sb, "speed", speed, speedScale > 1 ? " (/" + speedScale + ")" : "");
        append(sb, "RPM", rpm, "");
        return sb.toString();
    }

    /** The date of the reading as the window shows it. */
    String dateText() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(new Date(time));
    }

    private static void append(StringBuilder sb, String name, int code, String suffix) {
        if (code < 0) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(name).append(' ').append(code).append(suffix);
    }
}
