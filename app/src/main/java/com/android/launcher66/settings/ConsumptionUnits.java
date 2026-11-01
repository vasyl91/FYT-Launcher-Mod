package com.android.launcher66.settings;

/**
 * In which unit the instantaneous consumption the car gives is shown. The car gives L/100 km × 10; at a stop and at a
 * low speed that is meaningless, and many cars (and canbus protocols) switch to litres per hour there. Plain Java (no
 * android.*), so that it runs in JVM tests.
 *
 * <p>The order:
 * <ol>
 * <li>a car that gives its value from a threshold speed only (the model has learned it): the car's own value is
 * L/100 km, whatever the protocol says; under 10 km/h rule 3 applies;</li>
 * <li>the protocol of the car reports the unit: the value is in it, as it is, with no rule;</li>
 * <li>at a low speed (under 10 km/h, back above 13) with a known speed: the value is converted to litres per hour.</li>
 * </ol>
 */
public final class ConsumptionUnits {

    private ConsumptionUnits() {
        throw new AssertionError("No instances.");
    }

    public enum Unit { L100, LH }

    /** A value and its unit. */
    public static final class Shown {
        public final double value;
        public final Unit unit;

        Shown(double value, Unit unit) {
            this.value = value;
            this.unit = unit;
        }
    }

    /** At a stop, above this raw value (L/100 km × 10) the car left an old L/100 km value, not litres per hour. */
    static final int MAX_STANDING_RAW = 30;
    /** Below this L/h (less than a running engine burns) and under this raw value the car gives litres per hour already. */
    static final double RUNNING_ENGINE_LPH = 0.25;
    static final int MAX_PER_HOUR_RAW = 50;

    /**
     * The value to show and its unit, or null: show it the way it was shown before (L/100 km, as the car gave it).
     *
     * @param value        the car's value, ×10 (the widget shows it for 1..3000; 0 is the car's own zero)
     * @param protocolUnit the unit the protocol reports, null = it does not (or not now)
     * @param thresholdCar the car gives its value only from some speed (the model has learned it)
     * @param lowSpeed     under 10 km/h, back above 13 km/h (the hysteresis of the model)
     * @param speedKnown   there is a recent speed (a code or the GPS)
     * @param kmh          the speed
     * @param moving       the model counts the car as moving
     */
    public static Shown forCarValue(int value, Unit protocolUnit, boolean thresholdCar, boolean lowSpeed,
                                    boolean speedKnown, double kmh, boolean moving) {
        boolean lowAndKnown = lowSpeed && speedKnown;
        if (thresholdCar) {
            if (!lowAndKnown) {
                return new Shown(value / 10.0, Unit.L100);
            }
        } else if (protocolUnit != null) {
            return new Shown(value / 10.0, protocolUnit);
        }
        if (!lowAndKnown) {
            return null;
        }
        if (!moving) {
            if (value == 0) {
                return new Shown(0, Unit.LH);
            }
            // at a stop L/100 km does not exist: a value the car gives there is litres per hour
            return value > 0 && value <= MAX_STANDING_RAW ? new Shown(value / 10.0, Unit.LH) : null;
        }
        if (value == 0) {
            return new Shown(0, Unit.LH);
        }
        double lph = value / 10.0 * kmh / 100.0;
        if (lph < RUNNING_ENGINE_LPH && value <= MAX_PER_HOUR_RAW) {
            return new Shown(value / 10.0, Unit.LH);
        }
        return new Shown(lph, Unit.LH);
    }
}
