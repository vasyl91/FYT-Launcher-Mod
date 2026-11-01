package com.android.launcher66.settings;

/**
 * Where a position comes from. The platform's LocationManager is asked first; Google Play
 * services are the way out only when the platform has nothing and they are installed (they log
 * "failed lock verification" warnings for dozens of their classes the first time they are used,
 * and are not on every head unit). Free of android.* so the rules can be tested.
 */
final class LocationChoice {

    private LocationChoice() {}

    enum Source { PLATFORM, PLAY_SERVICES, NONE }

    /** The index of the newest of the times, -1 if there are none. */
    static int newest(long[] times) {
        int best = -1;
        for (int i = 0; i < times.length; i++) {
            if (best < 0 || times[i] > times[best]) {
                best = i;
            }
        }
        return best;
    }

    /** For a last known position. */
    static Source forLastKnown(boolean platformHasFix, boolean playInstalled) {
        if (platformHasFix) {
            return Source.PLATFORM;
        }
        return playInstalled ? Source.PLAY_SERVICES : Source.NONE;
    }

    /** For a stream of fixes; the platform's GPS provider does what a high accuracy request did. */
    static Source forUpdates(boolean platformHasGps, boolean playInstalled) {
        if (platformHasGps) {
            return Source.PLATFORM;
        }
        return playInstalled ? Source.PLAY_SERVICES : Source.NONE;
    }
}
