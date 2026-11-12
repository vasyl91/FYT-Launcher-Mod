package com.android.launcher66;

/**
 * What a tap on a widget or a bar button opens, decided before anything else is done for it.
 *
 * <p>The rule: a tap that can open nothing changes nothing. Stopping the music, dismissing the PiP panes and
 * touching the vertical bar's cycle are all done <em>for</em> the app that is about to cover the home screen,
 * so they happen only once it is known that an app will start. Before this rule the radio widget on a device
 * without {@code com.syu.radio} started nothing and still dismissed the panes.
 *
 * <p>Pure Java, so that it has a test.
 */
public final class WidgetLaunchRule {

    /** Where a tap on the radio widget (or the radio button) leads. */
    public enum Radio {
        /** The car's own radio, which the MCU reports ({@code com.syu.carradio}). */
        CAR_RADIO,
        /** The app {@code com.syu.radio} of the 7862 family. */
        RADIO_APP,
        /** The radio page of {@code com.syu.media} on the 7870. */
        MEDIA_PAGE,
        /** Nothing can be opened: the tap is ignored, the panes and the music stay. */
        NONE
    }

    private WidgetLaunchRule() {
    }

    /**
     * The order is the one the launcher always used: a car radio reported by the MCU stands for the radio and
     * nothing else is tried beside it; then the radio app; then the media app's page.
     *
     * @param mcuCarRadio       the MCU says the car has its own radio
     * @param carRadioStartable an activity answers the car radio's intent
     * @param radioAppStartable {@code com.syu.radio} is installed and an activity answers its intent
     * @param mediaPage         the media app has a radio page that an activity answers (a 7870)
     */
    public static Radio radio(boolean mcuCarRadio, boolean carRadioStartable, boolean radioAppStartable,
                              boolean mediaPage) {
        if (mcuCarRadio) {
            return carRadioStartable ? Radio.CAR_RADIO : Radio.NONE;
        }
        if (radioAppStartable) {
            return Radio.RADIO_APP;
        }
        return mediaPage ? Radio.MEDIA_PAGE : Radio.NONE;
    }

    /**
     * Whether an intent names something at all. {@code FytPackage.getIntent()} answers a package it cannot find
     * with a bare {@code ACTION_MAIN}: no component, no package, no category. The system would resolve that to
     * any main activity of any app, so it must not count as something to start.
     *
     * @param mainAction the action is {@code android.intent.action.MAIN}
     */
    public static boolean namesTarget(boolean hasComponent, boolean hasPackage, boolean hasCategory,
                                      boolean mainAction) {
        return hasComponent || hasPackage || hasCategory || !mainAction;
    }
}
