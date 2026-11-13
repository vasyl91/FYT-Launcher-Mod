package com.android.launcher66.settings;

/**
 * What the launcher does when the fYT Rating bridge answers a request for a video's rating.
 *
 * <p>The bridge can be reached and still have no rating to give. A capture of 9 November 2026 (Android 16)
 * shows it: the bridge answered the launcher's ping at the start and at every return to the home screen,
 * signed in and allowing the launcher, and answered five requests for a rating within a second each, every
 * one without a rating; after its own screen had been opened once, the next request got one. The launcher's
 * recovery knew only a bridge that does not answer (reset the connection, start its wake activity, restart
 * it), so nothing happened for a bridge that answers with nothing.
 *
 * <p>The rule: an answer without a rating, from a bridge that is signed in and allows the launcher, is its
 * own case. The launcher starts the bridge's wake activity for it, once, while its own home screen is in
 * front (only then may it start an activity), and asks again; it does not do so again before
 * {@link #WAKE_AGAIN_MS}, so a bridge that the wake does not help is not started over and over. An answer
 * that says why there is no rating (not signed in, the launcher not allowed, the video made for kids, a bad
 * request) is not that case: a wake changes none of them. Pure Java, so that it has a test.
 */
final class RatingReplyRule {

    /** How long after a wake for this case another one may follow. */
    static final long WAKE_AGAIN_MS = 5 * 60 * 1000L;

    enum Action {
        /** The answer is used as it is: a rating, or a reason the launcher can do nothing about. */
        ACCEPT,
        /** No rating: asked again later, as before. */
        RETRY,
        /** No rating although everything says there should be one: wake the bridge, then ask again. */
        WAKE_THEN_RETRY
    }

    private RatingReplyRule() {
    }

    /**
     * @param hasRating       the answer carries a rating
     * @param explained       the answer carries one of the reasons the bridge gives for having none
     * @param signedIn        the bridge is signed in to its account
     * @param allowed         the bridge allows this launcher
     * @param launcherResumed the launcher's home screen is in front
     * @param msSinceWake     the time since the last wake for this case, or a negative number if there was none
     */
    static Action afterAnswer(boolean hasRating, boolean explained, boolean signedIn, boolean allowed,
                              boolean launcherResumed, long msSinceWake) {
        if (hasRating || explained) {
            return Action.ACCEPT;
        }
        if (!signedIn || !allowed) {
            return Action.RETRY;
        }
        boolean mayWake = msSinceWake < 0 || msSinceWake >= WAKE_AGAIN_MS;
        return launcherResumed && mayWake ? Action.WAKE_THEN_RETRY : Action.RETRY;
    }
}
