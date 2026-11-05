package com.android.launcher66.settings;

/**
 * When the automatic canbus code check runs, free of android.* so that it can be tested on the JVM.
 *
 * <p>The check is a recording of every canbus code, like the code reader's, started by the launcher
 * itself while the car is driven, so that a unit whose codes the library does not know (or has wrong)
 * gets them without the owner starting the reader. It runs once per car: its state is kept per car id
 * as {@code state;startedAtWallMs;attempts;finishedAtWallMs}.
 *
 * <ul>
 *   <li>NONE: no state kept, the check has not run for this car;</li>
 *   <li>RUNNING: it was started and the process ended before it finished; seen at the start of the
 *       service this is an interrupted check;</li>
 *   <li>DONE: it finished with enough driving, it does not run again;</li>
 *   <li>INTERRUPTED: ACC off, a change of the car, the reader started by hand, ...; it runs again at
 *       the next drive;</li>
 *   <li>FAILED: it finished without enough driving; it runs again at the next drive.</li>
 * </ul>
 */
final class CanbusAutoCheckPolicy {

    enum State { NONE, RUNNING, DONE, INTERRUPTED, FAILED }

    /** The first fix above this speed (km/h) schedules the start. */
    static final double MOVING_KMH = 5.0;
    /** The recording starts this long after the movement was seen. */
    static final long START_DELAY_MS = 120_000L;
    /** At the start the car must have moved faster than MOVING_KMH within this time. */
    static final long RECENT_MOVEMENT_MS = 30_000L;
    /** A recording counts only with this much driving (the time between the first and the last fix above MOVING_KMH)... */
    static final long MIN_DRIVE_MS = 120_000L;
    /** ... and this many GPS fixes. */
    static final int MIN_FIXES = 60;

    private CanbusAutoCheckPolicy() {
    }

    /** The state of a car. */
    static final class Record {
        final State state;
        final long startedAt;
        final int attempts;
        final long finishedAt;

        Record(State state, long startedAt, int attempts, long finishedAt) {
            this.state = state;
            this.startedAt = startedAt;
            this.attempts = attempts;
            this.finishedAt = finishedAt;
        }

        static final Record NONE = new Record(State.NONE, 0L, 0, 0L);

        String serialize() {
            return state.name() + ";" + startedAt + ";" + attempts + ";" + finishedAt;
        }

        /** The record of a text, NONE for null, empty or a text that is not {@link #serialize()}'s. */
        static Record parse(String text) {
            if (text == null || text.isEmpty()) {
                return NONE;
            }
            String[] f = text.split(";", -1);
            if (f.length != 4) {
                return NONE;
            }
            try {
                return new Record(State.valueOf(f[0]), Long.parseLong(f[1]), Integer.parseInt(f[2]),
                        Long.parseLong(f[3]));
            } catch (IllegalArgumentException e) {
                return NONE;
            }
        }

        Record started(long now) {
            return new Record(State.RUNNING, now, attempts + 1, 0L);
        }

        Record ended(State end, long now) {
            return new Record(end, startedAt, attempts, now);
        }
    }

    /** What a state kept earlier means at the start of the service: a RUNNING one never finished. */
    static Record afterRestart(Record kept) {
        return kept.state == State.RUNNING ? new Record(State.INTERRUPTED, kept.startedAt, kept.attempts, 0L) : kept;
    }

    /**
     * Whether the check may run at all now. Without the location permission it only says so once, and
     * a code reader started by hand excludes it.
     */
    static boolean mayRun(boolean fytDevice, boolean userLayout, boolean userStats, int carId,
                          boolean readerRunning, Record record) {
        return fytDevice && userLayout && userStats && carId > 0 && !readerRunning
                && record.state != State.DONE && record.state != State.RUNNING;
    }

    /** Whether a GPS speed counts as the car moving. */
    static boolean isMoving(double kmh) {
        return kmh > MOVING_KMH;
    }

    /** At the start: the car must have moved lately, else the start is cancelled and the next movement schedules it. */
    static boolean movedRecently(long lastMovingAtMs, long nowMs) {
        return lastMovingAtMs > 0 && nowMs - lastMovingAtMs <= RECENT_MOVEMENT_MS;
    }

    /** The end of a recording: DONE with enough driving and fixes, else FAILED (it runs again). */
    static State outcome(long drivingMs, int fixes) {
        return drivingMs >= MIN_DRIVE_MS && fixes >= MIN_FIXES ? State.DONE : State.FAILED;
    }
}
