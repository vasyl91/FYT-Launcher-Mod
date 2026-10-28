package com.android.launcher66;

/**
 * Where FYT's pinned PiP is offered. Every FYT platform has it (7862, 8581, 9853i and the ones
 * not known by name) but the 7870, whose pinned stack the launcher has nothing to use (owner's
 * decision); off FYT units there is none. It works in the fyt and the standard version alike.
 * Elsewhere every pane is a window. Also how PinnedPipFocus tells a touch on the PiP from one on
 * the launcher. Free of android.* so the rules can be tested.
 */
final class PinnedPip {

    private PinnedPip() {}

    /** Whether the device has the pinned PiP: an FYT platform, the 7870 excepted. */
    static boolean supported(FytPlatform.Chipset chipset) {
        return chipset != FytPlatform.Chipset.FYT_7870 && chipset != FytPlatform.Chipset.NOT_FYT;
    }

    /** Whether a pane is the pinned PiP: the user chose it and the device has it. */
    static boolean mode(boolean supported, boolean saved) {
        return supported && saved;
    }

    /**
     * Whether the ACTION_OUTSIDE that PinnedPipFocus's window gets comes from a touch on another
     * app's window: the pinned PiP, or a window pane's app. InputDispatcher zeroes all coordinates
     * of it, the raw ones included, when the touched window belongs to another uid than the
     * watching one (FLAG_ZERO_COORDS). A touch on one of the launcher's own windows keeps them, and
     * one at the screen's very corner would land on the status bar, which is above that window and
     * sends it nothing.
     */
    static boolean outsideTouchOnOtherApp(float rawX, float rawY) {
        return rawX == 0f && rawY == 0f;
    }
}
