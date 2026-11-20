package com.android.launcher66.settings;

/**
 * How often the fuel statistics ask for the GPS, if at all. Plain Java (no android.*), tested on the JVM.
 *
 * <p><b>Rule.</b> The GPS runs only while something of the statistics needs it, at the rate that thing needs:
 * <ul>
 *   <li>none on a unit without a canbus (a phone: nothing there gives a value to go with a speed), without the
 *       permission, or when nothing below needs it;</li>
 *   <li>every 0.5 s (as before) while the estimate needs the speed (no speed code whose scale is known) or the altitude
 *       (no barometer), while the scale of the speed code is learned, and while the automatic code check starts or
 *       records (its fixes are matched with the codes);</li>
 *   <li>every 5 s while it only has to be seen that the car moves: the code check waiting for a drive, the choice of
 *       the pair of codes counting the driving time (which counts at most 5 s a tick, CodePairChooser.MAX_TICK_MS).
 *       With a speed code whose scale is known the speed comes from the car and the GPS is not needed for that.</li>
 * </ul>
 * The estimate itself is unchanged (D-13): it exists only for a car with a fuel code, is learned from the car's values
 * and shown only where the car gives none, below the speed from which it gives them (FuelSpeedThreshold). Until
 * 2026-11-20 the GPS ran every 0.5 s whenever the service ran, also on a phone (the owner's A55).
 */
public final class LocationNeed {

    public enum Rate {
        NONE(0L), MOTION(5_000L), FAST(500L);

        public final long intervalMs;

        Rate(long intervalMs) {
            this.intervalMs = intervalMs;
        }
    }

    /** Where the automatic code check is (CanbusAutoCheck). */
    public enum Check {
        /** It does not run for this car (no car yet, done, not a FYT unit, the reader on, ...). */
        OFF,
        /** It runs at the next drive: it waits for the car to move. */
        WAITING,
        /** The car moved: it starts after its delay. */
        STARTING,
        RECORDING
    }

    /** What the statistics need now. */
    public static final class Inputs {
        public boolean canbusUnit;
        public boolean permission;
        /** The estimate's model exists: the car has a fuel code. */
        public boolean fuelModel;
        /** A speed code is in use and its scale is known: the speed comes from the car. */
        public boolean speedFromCode;
        /** A speed code is in use and its scale is being learned from the GPS. */
        public boolean learningSpeedScale;
        public boolean barometer;
        /** The library has more than one pair of codes for the car: the choice counts the driving time. */
        public boolean pairNeedsDriving;
        public Check check = Check.OFF;
        /** The code check sees the car move from the speed code too (CanbusAutoCheck.onSpeed). */
        public boolean checkSeesSpeedCode;
    }

    /** The rate, and what asks for it (for the log). */
    public static final class Decision {
        public final Rate rate;
        public final String why;

        Decision(Rate rate, String why) {
            this.rate = rate;
            this.why = why;
        }
    }

    private LocationNeed() {
    }

    public static Decision decide(Inputs in) {
        if (!in.canbusUnit) {
            return new Decision(Rate.NONE, "no canbus on this unit");
        }
        if (!in.permission) {
            return new Decision(Rate.NONE, "no location permission");
        }
        if (in.check == Check.RECORDING) {
            return new Decision(Rate.FAST, "the code check records");
        }
        if (in.check == Check.STARTING) {
            return new Decision(Rate.FAST, "the code check starts");
        }
        if (in.fuelModel && !in.speedFromCode) {
            return new Decision(Rate.FAST, "the estimate's speed");
        }
        if (in.fuelModel && !in.barometer) {
            return new Decision(Rate.FAST, "the estimate's altitude");
        }
        if (in.learningSpeedScale) {
            return new Decision(Rate.FAST, "the scale of the speed code");
        }
        boolean speedSeen = in.speedFromCode;
        if (in.check == Check.WAITING && !(in.checkSeesSpeedCode && speedSeen)) {
            return new Decision(Rate.MOTION, "the code check waits for a drive");
        }
        if (in.pairNeedsDriving && !speedSeen) {
            return new Decision(Rate.MOTION, "the driving time of the pair of codes");
        }
        return new Decision(Rate.NONE, "nothing needs it");
    }
}
