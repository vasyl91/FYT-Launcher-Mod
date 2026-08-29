package com.android.launcher66.settings;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;

import com.android.launcher66.R;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Client of the fYT Rating application, which owns the Google authorisation and
 * answers questions about the like status of a video.
 *
 * The launcher deliberately holds no credentials of its own. It sends a video
 * id and receives a rating; the account, the tokens and the consent all live in
 * fYT Rating, and the user grants this launcher access there. Nothing about the
 * account crosses the boundary - not its address, not a token, not a scope.
 *
 * Requests block until the reply arrives or the timeout expires, so every call
 * here must be made from a background thread.
 */
public final class FytRating {

    private static final String TAG = "FytRating";

    public static final String BRIDGE_PACKAGE = "vasyl.fytrating";

    private static final String ACTION_GET_RATING = "vasyl.fytrating.action.GET_RATING";
    private static final String ACTION_SET_RATING = "vasyl.fytrating.action.SET_RATING";
    private static final String ACTION_GET_STATUS = "vasyl.fytrating.action.GET_STATUS";

    private static final String EXTRA_VIDEO_ID = "video_id";
    private static final String EXTRA_RATING = "rating";
    private static final String EXTRA_IDENTITY = "identity";
    private static final String EXTRA_CALLBACK = "callback";
    private static final String EXTRA_ERROR = "error";
    private static final String EXTRA_SIGNED_IN = "signed_in";
    private static final String EXTRA_ALLOWED = "allowed";

    public static final String RATING_LIKE = "like";
    public static final String RATING_NONE = "none";

    private static final String ERROR_MADE_FOR_KIDS = "made_for_kids";

    /** Where the replies come back. Unique to the launcher. */
    private static final String ACTION_RESULT = "com.android.launcher66.action.RATING_RESULT";

    // The bridge may have to be woken from a frozen or killed process and then
    // talks to the YouTube Data API before it can answer. Both budgets must sit
    // above the bridge's own HTTP timeouts, or a slow but successful lookup is
    // indistinguishable from a dead bridge.
    private static final long RATING_TIMEOUT_MS = 12000L;
    private static final long STATUS_TIMEOUT_MS = 8000L;

    /** How long a status answer is trusted before it is fetched again. */
    private static final long STATUS_MAX_AGE_MS = 60000L;

    /** Retry interval while the bridge has never answered a status request. */
    private static final long STATUS_RETRY_DELAY_MS = 10000L;

    /** How long a rating reply is reused to answer the made-for-kids question. */
    private static final long LAST_REPLY_MAX_AGE_MS = 15000L;

    private static final String ERROR_NOT_ALLOWED = "not_allowed";
    private static final String ERROR_NOT_SIGNED_IN = "not_signed_in";

    /**
     * Last known state of the bridge, so the settings screen and the widget can
     * be drawn without waiting for a round trip.
     */
    private static volatile boolean signedIn;
    private static volatile boolean allowed;

    /** False until the bridge has answered a status request at least once. */
    private static volatile boolean statusKnown;
    private static volatile long statusCheckedAtMs;
    private static final AtomicBoolean STATUS_REFRESH_RUNNING = new AtomicBoolean(false);

    /**
     * The error carried by the last rating reply, kept so the made-for-kids
     * question can be answered without a second round trip to the bridge.
     */
    private static volatile String lastReplyVideoId;
    private static volatile String lastReplyError;
    private static volatile long lastReplyAtMs;

    private static final String RELEASES_URL = "https://github.com/vasyl91/fYT-Rating/releases/latest";
    private static final long DOUBLE_CLICK_TIMEOUT_MS = 500L;
    private static long lastMissingClickAtMs;
    private static Toast missingToast; 
    private static final AtomicInteger REQUEST_COUNTER = new AtomicInteger(0);

    private FytRating() {
    }

    // ---------------------------------------------------------------- state

    public static boolean isInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(BRIDGE_PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * True when the bridge is installed, signed in, and has granted this
     * launcher access - everything needed for a rating to be resolved.
     *
     * Answers from the cached state and starts a background refresh when that
     * state is stale, so a wrong answer can no longer survive until somebody
     * happens to open the settings screen.
     */
    public static boolean isLoggedIn(Context context) {
        if (!isInstalled(context)) {
            return false;
        }
        ensureFreshStatus(context);
        return statusKnown && signedIn && allowed;
    }

    /**
     * Starts a background status refresh when the cached answer is missing or
     * stale. Returns immediately; callers read the cached values.
     */
    private static void ensureFreshStatus(Context context) {
        long maxAge = statusKnown ? STATUS_MAX_AGE_MS : STATUS_RETRY_DELAY_MS;
        if (statusCheckedAtMs != 0L
                && SystemClock.elapsedRealtime() - statusCheckedAtMs < maxAge) {
            return;
        }
        if (!STATUS_REFRESH_RUNNING.compareAndSet(false, true)) {
            return;
        }

        Context appContext = context.getApplicationContext();
        new Thread(() -> {
            try {
                refreshStatus(appContext);
            } finally {
                STATUS_REFRESH_RUNNING.set(false);
            }
        }, "fyt-rating-status").start();
    }

    /** True once the bridge has answered a status request at least once. */
    public static boolean isStatusKnown() {
        return statusKnown;
    }

    public static boolean isSignedIn() {
        return signedIn;
    }

    public static boolean isAllowed() {
        return allowed;
    }

    /**
     * Blocking. Asks the bridge for its state and caches the answer.
     *
     * Silence is no longer treated as a refusal. An unanswered request means
     * the bridge was busy, frozen or being started; latching "not allowed" onto
     * it used to disable rating support until the settings screen was reopened.
     */
    public static boolean refreshStatus(Context context) {
        if (!isInstalled(context)) {
            signedIn = false;
            allowed = false;
            statusKnown = true;
            statusCheckedAtMs = SystemClock.elapsedRealtime();
            return false;
        }

        Intent request = new Intent(ACTION_GET_STATUS);
        Bundle result = exchange(context, request, STATUS_TIMEOUT_MS);
        statusCheckedAtMs = SystemClock.elapsedRealtime();

        if (result == null) {
            Log.w(TAG, "No status reply; keeping the previous state"
                    + " (known=" + statusKnown
                    + " signedIn=" + signedIn
                    + " allowed=" + allowed + ")");
            return statusKnown && signedIn && allowed;
        }

        signedIn = result.getBoolean(EXTRA_SIGNED_IN, false);
        allowed = result.getBoolean(EXTRA_ALLOWED, false);
        statusKnown = true;
        return signedIn && allowed;
    }

    // ------------------------------------------------------------- ratings

    /**
     * Blocking.
     *
     * @return "like", "dislike", "none", or null when the rating is unknown
     */
    public static String fetchRating(Context context, String videoId) {
        Intent request = new Intent(ACTION_GET_RATING);
        request.putExtra(EXTRA_VIDEO_ID, videoId);

        Bundle result = exchange(context, request, RATING_TIMEOUT_MS);
        if (result == null) {
            // Silence says nothing about the video, so the remembered reply is
            // dropped rather than reused by the made-for-kids question.
            forgetLastReply(videoId);
            return null;
        }

        String error = result.getString(EXTRA_ERROR);
        rememberLastReply(videoId, error);
        noteReplyError(error);

        return result.getString(EXTRA_RATING);
    }

    /**
     * Blocking. True when the bridge reported the video as made for kids.
     *
     * Answered from the reply to the rating request whenever there is a recent
     * one for the same video, so the common path costs one round trip instead
     * of two - halving both the latency and the chance of a timeout.
     */
    public static boolean isMadeForKids(Context context, String videoId) {
        String remembered = cachedErrorFor(videoId);
        if (remembered != null) {
            return ERROR_MADE_FOR_KIDS.equals(remembered);
        }

        Intent request = new Intent(ACTION_GET_RATING);
        request.putExtra(EXTRA_VIDEO_ID, videoId);

        Bundle result = exchange(context, request, RATING_TIMEOUT_MS);
        if (result == null) {
            forgetLastReply(videoId);
            return false;
        }

        String error = result.getString(EXTRA_ERROR);
        rememberLastReply(videoId, error);
        noteReplyError(error);
        return ERROR_MADE_FOR_KIDS.equals(error);
    }

    /**
     * Folds an explicit refusal into the cached status.
     *
     * Worth doing because it is the one thing a timeout can never tell us: the
     * bridge saying "no" is information, the bridge saying nothing is not.
     */
    private static void noteReplyError(String error) {
        if (ERROR_NOT_ALLOWED.equals(error)) {
            allowed = false;
        } else if (ERROR_NOT_SIGNED_IN.equals(error)) {
            signedIn = false;
        } else {
            return;
        }
        statusKnown = true;
        statusCheckedAtMs = SystemClock.elapsedRealtime();
    }

    private static void rememberLastReply(String videoId, String error) {
        lastReplyError = error == null ? "" : error;
        lastReplyVideoId = videoId;
        lastReplyAtMs = SystemClock.elapsedRealtime();
    }

    private static void forgetLastReply(String videoId) {
        if (videoId != null && videoId.equals(lastReplyVideoId)) {
            lastReplyVideoId = null;
        }
    }

    /** @return the recorded error ("" for none), or null when there is nothing to reuse */
    private static String cachedErrorFor(String videoId) {
        String rememberedId = lastReplyVideoId;
        if (rememberedId == null || videoId == null || !rememberedId.equals(videoId)) {
            return null;
        }
        if (SystemClock.elapsedRealtime() - lastReplyAtMs > LAST_REPLY_MAX_AGE_MS) {
            return null;
        }
        return lastReplyError;
    }

    /** Blocking. True when the account was updated. */
    public static boolean setRating(Context context, String videoId, boolean like) {
        Intent request = new Intent(ACTION_SET_RATING);
        request.putExtra(EXTRA_VIDEO_ID, videoId);
        request.putExtra(EXTRA_RATING, like ? RATING_LIKE : RATING_NONE);

        Bundle result = exchange(context, request, RATING_TIMEOUT_MS);
        if (result == null) {
            forgetLastReply(videoId);
            return false;
        }

        String error = result.getString(EXTRA_ERROR);
        noteReplyError(error);

        // The rating has just changed, so the remembered reply describes a
        // state that no longer holds.
        forgetLastReply(videoId);
        return error == null;
    }

    // ------------------------------------------------------------ plumbing

    /**
     * Sends a request and waits for the reply.
     *
     * A PendingIntent carries the launcher's identity: the system records its
     * creator, so the bridge can tell who is asking without trusting anything
     * in the message. A second one carries the reply back, which means neither
     * side has to know the other's package name in advance.
     *
     * @return the reply, or null on timeout
     */
    private static Bundle exchange(Context context, Intent request, long timeoutMs) {
        Context appContext = context.getApplicationContext();
        AtomicReference<Bundle> answer = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);

        int uniqueId = REQUEST_COUNTER.incrementAndGet();
        String uniqueAction = ACTION_RESULT + "_" + uniqueId;

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ignored, Intent intent) {
                answer.set(intent.getExtras());
                latch.countDown();
            }
        };

        PendingIntent callbackIntent = null;
        PendingIntent identityIntent = null;

        try {
            IntentFilter filter = new IntentFilter(uniqueAction);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                appContext.registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
            } else {
                appContext.registerReceiver(receiver, filter);
            }

            request.setPackage(BRIDGE_PACKAGE);
            request.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

            callbackIntent = PendingIntent.getBroadcast(
                    appContext, uniqueId,
                    new Intent(uniqueAction).setPackage(appContext.getPackageName()),
                    PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

            identityIntent = PendingIntent.getBroadcast(
                    appContext, uniqueId + 1000000, 
                    new Intent(),
                    PendingIntent.FLAG_IMMUTABLE);

            request.putExtra(EXTRA_CALLBACK, callbackIntent);
            request.putExtra(EXTRA_IDENTITY, identityIntent);

            appContext.sendBroadcast(request);

            if (!latch.await(timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                Log.w(TAG, "No reply to " + request.getAction() + " within " + timeoutMs + " ms");
                return null;
            }
            return answer.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } catch (Exception e) {
            Log.w(TAG, "Request failed", e);
            return null;
        } finally {
            try {
                appContext.unregisterReceiver(receiver);
            } catch (Exception ignored) {
                // Already gone.
            }
            if (callbackIntent != null) {
                callbackIntent.cancel();
            }
            if (identityIntent != null) {
                identityIntent.cancel();
            }
        }
    }

    // ---------------------------------------------------------- settings ui

    /**
     * Opens fYT Rating so the user can sign in or grant this launcher access.
     * Nothing can be done from here: both are decisions that belong there.
     */
    public static void handlePreferenceClick(
            Activity activity) {
        if (!isInstalled(activity)) {
            long now = SystemClock.elapsedRealtime();
            boolean doubleClick = now - lastMissingClickAtMs <= DOUBLE_CLICK_TIMEOUT_MS;
            lastMissingClickAtMs = doubleClick ? 0L : now;

            if (doubleClick) {
                if (missingToast != null) {
                    missingToast.cancel();
                    missingToast = null;
                }
                openReleasesPage(activity);
            } else {
                missingToast = Toast.makeText(
                        activity, R.string.fyt_rating_missing, Toast.LENGTH_LONG);
                missingToast.show();
            }
            return;
        }

        Intent launch = activity.getPackageManager().getLaunchIntentForPackage(BRIDGE_PACKAGE);
        if (launch == null) {
            Toast.makeText(activity, R.string.fyt_rating_missing, Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(activity, R.string.fyt_rating_opening, Toast.LENGTH_SHORT).show();
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(launch);
    }

    private static void openReleasesPage(Activity activity) {
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(RELEASES_URL));
        browser.addCategory(Intent.CATEGORY_BROWSABLE);
        browser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            activity.startActivity(browser);
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "No browser to open " + RELEASES_URL, e);
            Toast.makeText(activity, R.string.fyt_rating_missing, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Draws the two lines of the summary and hides the kids switch until the
     * bridge can actually answer, since the setting is meaningless before that.
     *
     * The state is fetched in the background; the preference is updated when
     * the answer arrives.
     */
    public static void syncPreference(
            Context context, Preference oauthPreference, Preference kidsPreference) {
        applyState(context, oauthPreference, kidsPreference);

        Context appContext = context.getApplicationContext();
        new Thread(() -> {
            refreshStatus(appContext);
            new Handler(Looper.getMainLooper()).post(() -> {
                if (oauthPreference == null || oauthPreference.getPreferenceManager() != null) {
                    applyState(appContext, oauthPreference, kidsPreference);
                }
            });
        }, "fyt-rating-status").start();
    }

    private static void applyState(
            Context context, Preference oauthPreference, Preference kidsPreference) {
        boolean installed = isInstalled(context);
        boolean ready = installed && signedIn && allowed;

        if (oauthPreference != null) {
            String installedLine = context.getString(installed
                    ? R.string.fyt_rating_installed
                    : R.string.fyt_rating_not_installed);

            int stateLine;
            if (!installed) {
                stateLine = R.string.fyt_rating_state_unavailable;
            } else if (!signedIn) {
                stateLine = R.string.fyt_rating_state_not_logged_in;
            } else if (!allowed) {
                stateLine = R.string.fyt_rating_state_not_allowed;
            } else {
                stateLine = R.string.fyt_rating_state_ready;
            }

            oauthPreference.setSummary(
                    installedLine + "\n" + context.getString(stateLine));
        }

        if (kidsPreference != null) {
            kidsPreference.setVisible(ready);
        }
    }
}