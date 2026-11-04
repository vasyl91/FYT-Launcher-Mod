package com.android.launcher66.settings;

/**
 * The rule that turns a screen number typed in the settings into the screen the element is put on.
 * Pure, so it can be tested on the JVM.
 */
final class ScreenNumberRule {

    private ScreenNumberRule() {
    }

    /**
     * A number past the last existing screen always gives exactly one new screen, right after the
     * last one; any other number is kept.
     *
     * <p>The last screen is the larger of the launcher's screen count and the highest screen of the
     * other elements that are switched on. The screen count comes from the model snapshot, which does
     * not change during a settings session. An element that is switched on and was moved past the last
     * screen earlier in the same session already creates a screen that the snapshot does not know yet.
     * Counting it lets the user add new screens one after another instead of every number past the
     * snapshot collapsing onto the same page.
     *
     * @param typed            the number typed by the user (1-based)
     * @param pageCount        the number of screens of the launcher (1-based count)
     * @param highestOtherPage the highest screen (1-based) of the other elements that are switched on,
     *                         0 if there are none
     * @return the screen (1-based) to put the element on
     */
    static int target(int typed, int pageCount, int highestOtherPage) {
        int lastPage = Math.max(pageCount, highestOtherPage);
        return typed > lastPage ? lastPage + 1 : typed;
    }
}
