package com.android.launcher66;

/**
 * Where FYT's pinned PiP is offered. It works on the FYT units whose stock player is
 * com.syu.music (7862, 8581 and the older ones), in the fyt and the standard version alike. The
 * 7870 (com.syu.media) has no pinned stack for the launcher to use, so there every pane is a
 * window. Free of android.* so the rule can be tested.
 */
final class PinnedPip {

    private PinnedPip() {}

    /**
     * @param fytUnit an FYT unit at all
     * @param syuMediaUnit a 7870, whose stock player is com.syu.media
     */
    static boolean supported(boolean fytUnit, boolean syuMediaUnit) {
        return fytUnit && !syuMediaUnit;
    }

    /** Whether a pane is the pinned PiP: the user chose it and the device has it. */
    static boolean mode(boolean supported, boolean saved) {
        return supported && saved;
    }
}
