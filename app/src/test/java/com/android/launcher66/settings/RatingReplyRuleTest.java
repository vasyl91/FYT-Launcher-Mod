package com.android.launcher66.settings;

import static com.android.launcher66.settings.RatingReplyRule.Action.ACCEPT;
import static com.android.launcher66.settings.RatingReplyRule.Action.RETRY;
import static com.android.launcher66.settings.RatingReplyRule.Action.WAKE_THEN_RETRY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RatingReplyRuleTest {

    @Test
    void anAnswerWithARatingIsUsed() {
        assertEquals(ACCEPT, RatingReplyRule.afterAnswer(true, false, true, true, true, -1));
    }

    @Test
    void anAnswerThatSaysWhyThereIsNoneIsUsedToo() {
        // made for kids, not signed in, not allowed: a wake changes none of them
        assertEquals(ACCEPT, RatingReplyRule.afterAnswer(false, true, true, true, true, -1));
    }

    @Test
    void theBridgeOfTheCaptureIsWokenOnceForItsFiveEmptyAnswers() {
        // 17:27:31, signed in, allowed, the home screen in front: the first empty answer wakes it
        assertEquals(WAKE_THEN_RETRY, RatingReplyRule.afterAnswer(false, false, true, true, true, -1));
        // 17:27:35 ... 17:27:55, four more within half a minute: asked again, not woken again
        for (long since : new long[] {4_000, 11_000, 20_000, 24_000}) {
            assertEquals(RETRY, RatingReplyRule.afterAnswer(false, false, true, true, true, since));
        }
    }

    @Test
    void afterFiveMinutesItMayBeWokenAgain() {
        assertEquals(WAKE_THEN_RETRY, RatingReplyRule.afterAnswer(false, false, true, true, true,
                RatingReplyRule.WAKE_AGAIN_MS));
    }

    @Test
    void withoutTheHomeScreenInFrontNoActivityIsStarted() {
        assertEquals(RETRY, RatingReplyRule.afterAnswer(false, false, true, true, false, -1));
    }

    @Test
    void aBridgeThatIsNotSignedInOrDoesNotAllowTheLauncherIsNotWoken() {
        assertEquals(RETRY, RatingReplyRule.afterAnswer(false, false, false, true, true, -1));
        assertEquals(RETRY, RatingReplyRule.afterAnswer(false, false, true, false, true, -1));
    }
}
