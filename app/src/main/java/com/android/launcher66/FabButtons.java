package com.android.launcher66;

/**
 * Whether the floating buttons have anything to control, so that their service is worth starting.
 *
 * <p>The rule: each button needs an app only in the PiPs it controls. The main button swaps all panes, so
 * it needs an app in every PiP; the left one swaps the first and the third, the right one the second and the
 * fourth. The launcher used to ask for an app in all four PiPs whichever button was on, so a left or right
 * button with only its own two PiPs never appeared, while the service that shows the buttons
 * (FabOverlayService) already looked at each button's own PiPs. Pure Java, so that it has a test.
 */
public final class FabButtons {

    private FabButtons() {
    }

    /**
     * @param main   the main button is switched on
     * @param left   the left button is switched on
     * @param right  the right button is switched on
     * @param first  an app is assigned to the first PiP (likewise the others)
     */
    public static boolean anyUsable(boolean main, boolean left, boolean right,
                                    boolean first, boolean second, boolean third, boolean fourth) {
        return (main && first && second && third && fourth)
                || (left && first && third)
                || (right && second && fourth);
    }
}
