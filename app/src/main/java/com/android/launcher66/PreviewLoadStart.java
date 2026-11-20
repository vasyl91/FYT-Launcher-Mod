package com.android.launcher66;

/**
 * When a page of the widgets list starts loading its previews (AppsCustomizePagedView.syncWidgetPageItems()).
 *
 * <p>The rule: <b>widget previews are never read or drawn on the main thread.</b> Every page loads them in a
 * background task (prepareLoadWidgetPreviewsTask()), the page shown first too. That one read them synchronously on
 * the main thread before, in the layout pass: WidgetPreviewLoader.getPreview() reads the previews' database
 * (readFromDb) or draws a preview from another app's resources, and StrictMode caught four reads of 48 to 102 ms
 * on the 7862 when the widgets tab was opened (log of 2026-11-20 18:21, KI-46).
 *
 * <p>The page shown first starts its task at once, also during the launcher's transition, so its previews are
 * ready when the transition ends; putting them on the page waits for that end as before
 * (AppsCustomizePagedView.onSyncWidgetPageItems()). The other pages wait for the end of a transition before they
 * start, as before, so the transition is not slowed down by them.
 *
 * <p>Plain Java.
 */
final class PreviewLoadStart {

    enum When {
        /** The task is started now. */
        NOW,
        /** The task is started when the launcher's transition has ended. */
        AFTER_TRANSITION
    }

    private PreviewLoadStart() {
    }

    /**
     * @param shownFirst   the page is the one shown now (syncPageItems(page, immediate = true))
     * @param inTransition the launcher is between two of its states (onLauncherTransitionPrepare … End)
     */
    static When of(boolean shownFirst, boolean inTransition) {
        if (shownFirst || !inTransition) {
            return When.NOW;
        }
        return When.AFTER_TRANSITION;
    }
}
