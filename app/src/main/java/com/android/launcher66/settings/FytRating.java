package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;

import com.android.launcher66.R;

import java.util.concurrent.CountDownLatch;
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

    private static final long RATING_TIMEOUT_MS = 6000L;
    private static final long STATUS_TIMEOUT_MS = 2500L;

    /**
     * Last known state of the bridge, so the settings screen and the widget can
     * be drawn without waiting for a round trip.
     */
    private static volatile boolean signedIn;
    private static volatile boolean allowed;

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
     * Answers from the cached state; call {@link #refreshStatus} to update it.
     */
    public static boolean isLoggedIn(Context context) {
        return isInstalled(context) && signedIn && allowed;
    }

    public static boolean isSignedIn() {
        return signedIn;
    }

    public static boolean isAllowed() {
        return allowed;
    }

    /** Blocking. Asks the bridge for its state and caches the answer. */
    public static boolean refreshStatus(Context context) {
        if (!isInstalled(context)) {
            signedIn = false;
            allowed = false;
            return false;
        }

        Intent request = new Intent(ACTION_GET_STATUS);
        Bundle result = exchange(context, request, STATUS_TIMEOUT_MS);

        if (result == null) {
            // Silence means the bridge did not answer: most often it has never
            // been opened, and Android keeps such an application stopped.
            signedIn = false;
            allowed = false;
        } else {
            signedIn = result.getBoolean(EXTRA_SIGNED_IN, false);
            allowed = result.getBoolean(EXTRA_ALLOWED, false);
        }
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
        return result == null ? null : result.getString(EXTRA_RATING);
    }

    /** Blocking. True when the bridge reported the video as made for kids. */
    public static boolean isMadeForKids(Context context, String videoId) {
        Intent request = new Intent(ACTION_GET_RATING);
        request.putExtra(EXTRA_VIDEO_ID, videoId);

        Bundle result = exchange(context, request, RATING_TIMEOUT_MS);
        return result != null && ERROR_MADE_FOR_KIDS.equals(result.getString(EXTRA_ERROR));
    }

    /** Blocking. True when the account was updated. */
    public static boolean setRating(Context context, String videoId, boolean like) {
        Intent request = new Intent(ACTION_SET_RATING);
        request.putExtra(EXTRA_VIDEO_ID, videoId);
        request.putExtra(EXTRA_RATING, like ? RATING_LIKE : RATING_NONE);

        Bundle result = exchange(context, request, RATING_TIMEOUT_MS);
        return result != null && result.getString(EXTRA_ERROR) == null;
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

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private static void registerResultReceiver(Context context, BroadcastReceiver receiver) {
        IntentFilter filter = new IntentFilter(ACTION_RESULT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // The reply is delivered through a PendingIntent created here, so
            // it arrives from this application and needs no export.
            context.registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            context.registerReceiver(receiver, filter);
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