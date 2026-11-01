package com.android.launcher66.settings;

/**
 * The 3 s the stats window may stay gone before the obscuring limit goes back (see
 * StatsOverlayAlpha). Pure: the time is given from outside.
 */
final class HideDebounce {
    static final long DELAY_MS = 3000;

    private boolean pending;
    private long deadline;

    /** The window went away at now: the limit may go back DELAY_MS after the last time this was called. */
    synchronized void onHidden(long now) {
        pending = true;
        deadline = now + DELAY_MS;
    }

    /** The window is back (or on its way): nothing to restore. */
    synchronized void onShown(long now) {
        pending = false;
    }

    /** true once, when the hide is to be carried out. */
    synchronized boolean due(long now) {
        if (pending && now >= deadline) {
            pending = false;
            return true;
        }
        return false;
    }
}
