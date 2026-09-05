package com.android.launcher66.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;

import com.android.launcher66.R;

import java.lang.reflect.Method;
import java.util.List;
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

    /**
     * How often a refusal is put to the question.
     *
     * A negative answer is checked far more eagerly than a positive one. Being
     * wrongly told no costs the user a button that does nothing; being wrongly
     * told yes costs one refused request and a line in the log. The two are not
     * worth the same wait.
     */
    private static final long NEGATIVE_STATUS_RECHECK_MS = 5000L;

    private static final String ERROR_BAD_REQUEST = "bad_request";

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
    private static volatile long statusRefreshStartedAtMs;

    /** A refresh still marked as running after this long never finished. */
    private static final long STATUS_REFRESH_STUCK_AFTER_MS = 60000L;

    /**
     * The error carried by the last rating reply, kept so the made-for-kids
     * question can be answered without a second round trip to the bridge.
     */
    private static volatile String lastReplyVideoId;
    private static volatile String lastReplyError;
    private static volatile long lastReplyAtMs;

    /**
     * How many unanswered exchanges in a row are taken as proof that what the
     * launcher remembers about the bridge is no longer true.
     */
    private static final int MAX_CONSECUTIVE_FAILURES = 3;
    private static final AtomicInteger CONSECUTIVE_FAILURES = new AtomicInteger(0);

    /** The bridge's receiver, resolved once and dropped whenever it stops answering. */
    private static volatile ComponentName bridgeReceiver;

    /** Restarting another application's process is a blunt instrument; rationed accordingly. */
    private static final long REVIVE_MIN_INTERVAL_MS = 900000L;
    private static volatile long lastReviveAtMs;

    /** The bridge's invisible activity, started only to bring its process up. */
    private static final String WAKE_ACTIVITY = BRIDGE_PACKAGE + ".WakeActivity";

    /** Starting an activity is cheap but not free; once in this window is plenty. */
    private static final long WAKE_MIN_INTERVAL_MS = 300000L;

    /** How long the woken process is given before it is asked anything. */
    private static final long WAKE_SETTLE_MS = 1500L;

    private static volatile long lastWakeAtMs;

    /**
     * Whether the installed bridge has a wake activity, and when that was last
     * established.
     *
     * Looked up again rather than remembered for good: the bridge is a separate
     * application and can be updated underneath a running launcher. A single
     * "not there" recorded at startup would otherwise keep waking switched off
     * until the launcher itself was restarted - which is the very thing all of
     * this exists to avoid.
     */
    private static volatile boolean wakeActivityPresent = true;
    private static volatile long wakeActivityCheckedAtMs;
    private static final long WAKE_ACTIVITY_RECHECK_MS = 600000L;

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
        long maxAge;
        if (!statusKnown) {
            maxAge = STATUS_RETRY_DELAY_MS;
        } else if (signedIn && allowed) {
            maxAge = STATUS_MAX_AGE_MS;
        } else {
            maxAge = NEGATIVE_STATUS_RECHECK_MS;
        }
        if (statusCheckedAtMs != 0L
                && SystemClock.elapsedRealtime() - statusCheckedAtMs < maxAge) {
            return;
        }
        if (!STATUS_REFRESH_RUNNING.compareAndSet(false, true)) {
            // A flag that never gets cleared is exactly the kind of latch that
            // used to need a force stop, so it is given a deadline of its own.
            if (SystemClock.elapsedRealtime() - statusRefreshStartedAtMs
                    < STATUS_REFRESH_STUCK_AFTER_MS) {
                return;
            }
            Log.w(TAG, "Previous status refresh never finished; starting another");
        }
        statusRefreshStartedAtMs = SystemClock.elapsedRealtime();

        Context appContext = context.getApplicationContext();
        try {
            new Thread(() -> {
                try {
                    refreshStatus(appContext);
                } finally {
                    STATUS_REFRESH_RUNNING.set(false);
                }
            }, "fyt-rating-status").start();
        } catch (Throwable t) {
            // The thread never ran, so nothing will clear the flag for us.
            STATUS_REFRESH_RUNNING.set(false);
            Log.w(TAG, "Could not start the status refresh", t);
        }
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
            if (statusKnown && !(signedIn && allowed)) {
                // Silence confirms nothing, and a refusal that cannot be
                // confirmed must not go on acting like one. A positive answer
                // is kept through silence, because losing it needlessly
                // disables a button that was working.
                Log.w(TAG, "A refusal went unconfirmed; back to unknown");
                statusKnown = false;
                return false;
            }

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
     * Reads the permission state out of any answered rating request.
     *
     * This is the fast path back from a wrong refusal, and it is free: the
     * bridge checks the caller against the allow list before it looks at
     * anything else, so what it answers with says exactly where the request
     * got to. Waiting for a separate status round trip to discover the same
     * thing would only add delay.
     */
    private static void noteReplyError(String error) {
        if (ERROR_NOT_ALLOWED.equals(error)) {
            allowed = false;
        } else if (ERROR_BAD_REQUEST.equals(error)) {
            // Refused before the allow list was ever consulted; says nothing.
            return;
        } else {
            // Every other outcome is produced past the allow check, so reaching
            // it proves the caller is accepted.
            if (!allowed) {
                Log.w(TAG, "The bridge answered after all; the refusal was stale");
            }
            allowed = true;
            signedIn = !ERROR_NOT_SIGNED_IN.equals(error);
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
     * Throws away everything the launcher remembers about the bridge.
     *
     * All of it is process-wide state that used to survive until the launcher
     * was force stopped: a component resolved hours ago, a status cached from a
     * reply that never came, request codes the system may still hold a
     * PendingIntent under. Rebuilding them is exactly what a restart did, and
     * there is no reason it has to cost a restart.
     */
    public static void resetTransport() {
        Log.w(TAG, "Bridge unreachable " + CONSECUTIVE_FAILURES.get()
                + " times in a row; rebuilding the transport");

        bridgeReceiver = null;
        statusKnown = false;
        statusCheckedAtMs = 0L;
        lastReplyVideoId = null;
        CONSECUTIVE_FAILURES.set(0);
        STATUS_REFRESH_RUNNING.set(false);
        statusRefreshStartedAtMs = 0L;

        // The bridge may have been replaced by a build that does have one.
        wakeActivityCheckedAtMs = 0L;

        // Fresh request codes, so FLAG_UPDATE_CURRENT cannot hand back a
        // PendingIntent the system kept from an exchange that timed out.
        REQUEST_COUNTER.addAndGet(64);
    }

    /**
     * Last resort: restarts the bridge's process.
     *
     * When everything the launcher caches has been rebuilt and the bridge still
     * says nothing, what is stale is on the other side. A process the system
     * has parked - in the restricted standby bucket, frozen, or stopped by the
     * ROM's own power manager - stops receiving broadcasts, and no amount of
     * retrying from here changes that. Stopping it clears the parked state, and
     * the next explicit request starts it again from nothing.
     *
     * This is what revoking and re-granting access did by hand. Not the list:
     * the entry was never the problem. Opening the bridge was, because it put
     * the process back into a state where it could hear a broadcast at all.
     *
     * Needs the launcher's system privileges, and does nothing without them.
     *
     * @return true when the process was stopped
     */
    public static boolean revive(Context context) {
        if (context == null || !isInstalled(context)) {
            return false;
        }

        long now = SystemClock.elapsedRealtime();
        if (lastReviveAtMs != 0L && now - lastReviveAtMs < REVIVE_MIN_INTERVAL_MS) {
            return false;
        }

        if (isBridgeInForeground(context)) {
            // The user is looking at it. Whatever is wrong can wait.
            Log.d(TAG, "Bridge is in the foreground; leaving it alone");
            return false;
        }

        lastReviveAtMs = now;

        try {
            ActivityManager activityManager =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) {
                return false;
            }

            Method forceStop = activityManager.getClass()
                    .getDeclaredMethod("forceStopPackage", String.class);
            forceStop.invoke(activityManager, BRIDGE_PACKAGE);

            Log.w(TAG, "Bridge process stopped; the next request will start it again");

            // Everything remembered describes the process that has just gone.
            resetTransport();
            return true;
        } catch (ReflectiveOperationException e) {
            Log.w(TAG, "No privilege to restart the bridge", e);
            return false;
        } catch (Exception e) {
            Log.w(TAG, "Could not restart the bridge", e);
            return false;
        }
    }

    private static boolean isBridgeInForeground(Context context) {
        try {
            ActivityManager activityManager =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) {
                return false;
            }

            List<ActivityManager.RunningAppProcessInfo> processes =
                    activityManager.getRunningAppProcesses();
            if (processes == null) {
                return false;
            }

            for (ActivityManager.RunningAppProcessInfo process : processes) {
                if (process == null
                        || process.pkgList == null
                        || process.importance
                                > ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                    continue;
                }
                for (String packageName : process.pkgList) {
                    if (BRIDGE_PACKAGE.equals(packageName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not read the bridge's process state", e);
        }
        return false;
    }

    private static void noteExchangeSucceeded() {
        CONSECUTIVE_FAILURES.set(0);
    }

    private static void noteExchangeFailed() {
        if (CONSECUTIVE_FAILURES.incrementAndGet() >= MAX_CONSECUTIVE_FAILURES) {
            resetTransport();
        }
    }

    /**
     * The bridge receiver as a component, so requests can be addressed to it
     * explicitly.
     *
     * setPackage alone leaves the broadcast implicit, and head unit ROMs are
     * inconsistent about waking a cached or long idle application for one. An
     * explicit component is delivered. It is resolved rather than hard coded so
     * the launcher keeps working if the bridge ever moves the class.
     *
     * @return null when it cannot be resolved, in which case setPackage stands
     */
    private static ComponentName resolveBridgeReceiver(Context context, String action) {
        ComponentName cached = bridgeReceiver;
        if (cached != null) {
            return cached;
        }
        if (action == null) {
            return null;
        }

        try {
            Intent probe = new Intent(action).setPackage(BRIDGE_PACKAGE);
            List<ResolveInfo> matches =
                    context.getPackageManager().queryBroadcastReceivers(probe, 0);
            if (matches == null || matches.isEmpty()) {
                return null;
            }
            ResolveInfo match = matches.get(0);
            if (match.activityInfo == null) {
                return null;
            }
            ComponentName resolved =
                    new ComponentName(match.activityInfo.packageName, match.activityInfo.name);
            bridgeReceiver = resolved;
            Log.d(TAG, "Bridge receiver resolved to " + resolved.flattenToShortString());
            return resolved;
        } catch (Exception e) {
            Log.w(TAG, "Could not resolve the bridge receiver", e);
            return null;
        }
    }

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
            ComponentName componentName = resolveBridgeReceiver(appContext, request.getAction());
            if (componentName != null) {
                request.setComponent(componentName);
            }
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
                noteExchangeFailed();
                return null;
            }
            noteExchangeSucceeded();
            return answer.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } catch (Exception e) {
            Log.w(TAG, "Request failed", e);
            noteExchangeFailed();
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

    // -------------------------------------------------------------- waking

    /**
     * Brings the bridge's process up when it looks like it is not there.
     *
     * Meant to be called from the launcher's onResume. A package that has not
     * run since the device started receives no broadcasts, and on these head
     * units nothing puts it back into a reachable state on its own - which is
     * why the first request after a restart was always lost and why opening the
     * application by hand was the only cure.
     *
     * Starting an activity is the one thing a client can do that clears that
     * state, and the activity it starts draws nothing. Doing it from onResume
     * is also what makes it allowed: the launcher is visible at that moment, so
     * the background activity start restrictions do not apply.
     *
     * Costs one comparison when the bridge is already answering.
     */
    public static void wakeIfNeeded(Context context) {
        if (context == null || !isInstalled(context) || !hasWakeActivity(context)) {
            return;
        }

        long now = SystemClock.elapsedRealtime();
        if (lastWakeAtMs != 0L && now - lastWakeAtMs < WAKE_MIN_INTERVAL_MS) {
            return;
        }

        // Answering and present: leave it alone.
        if (statusKnown && signedIn && allowed && isBridgeRunning(context)) {
            return;
        }

        wake(context);
    }

    /**
     * Starts the bridge's wake activity whatever the current state.
     *
     * @return true when the activity was started
     */
    public static boolean wake(Context context) {
        if (context == null || !isInstalled(context) || !hasWakeActivity(context)) {
            return false;
        }

        lastWakeAtMs = SystemClock.elapsedRealtime();
        Context appContext = context.getApplicationContext();

        try {
            Intent wake = new Intent()
                    .setComponent(new ComponentName(BRIDGE_PACKAGE, WAKE_ACTIVITY))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_NO_ANIMATION
                            | Intent.FLAG_ACTIVITY_NO_USER_ACTION
                            | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                            | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            context.startActivity(wake);
            Log.d(TAG, "Wake activity started");

            // Whatever was cached described a process that was not answering,
            // so it is asked again once the new one has had a moment to settle.
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                statusCheckedAtMs = 0L;
                ensureFreshStatus(appContext);
            }, WAKE_SETTLE_MS);
            return true;
        } catch (ActivityNotFoundException e) {
            // An older build of the bridge. Nothing is broken by this; the
            // ordinary broadcast path still works whenever the process is up.
            wakeActivityPresent = false;
            wakeActivityCheckedAtMs = SystemClock.elapsedRealtime();
            Log.d(TAG, "The installed bridge has no wake activity");
            return false;
        } catch (Exception e) {
            Log.w(TAG, "Could not start the wake activity", e);
            return false;
        }
    }

    /**
     * Whether the installed bridge exposes a wake activity, re-checked every so
     * often so that installing a newer bridge takes effect on its own.
     */
    private static boolean hasWakeActivity(Context context) {
        long now = SystemClock.elapsedRealtime();
        if (wakeActivityCheckedAtMs != 0L
                && now - wakeActivityCheckedAtMs < WAKE_ACTIVITY_RECHECK_MS) {
            return wakeActivityPresent;
        }
        wakeActivityCheckedAtMs = now;

        try {
            Intent probe = new Intent()
                    .setComponent(new ComponentName(BRIDGE_PACKAGE, WAKE_ACTIVITY));
            wakeActivityPresent = context.getPackageManager().resolveActivity(probe, 0) != null;
        } catch (Exception e) {
            wakeActivityPresent = false;
        }

        Log.d(TAG, wakeActivityPresent
                ? "Bridge wake activity available"
                : "The installed bridge has no wake activity");
        return wakeActivityPresent;
    }

    /**
     * @return true when a process of the bridge exists, and also when that
     *         cannot be determined - an unprivileged caller only ever sees its
     *         own processes here, and absence is then not evidence
     */
    private static boolean isBridgeRunning(Context context) {
        try {
            ActivityManager activityManager =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (activityManager == null) {
                return true;
            }

            List<ActivityManager.RunningAppProcessInfo> processes =
                    activityManager.getRunningAppProcesses();
            if (processes == null || processes.isEmpty()) {
                return true;
            }

            boolean sawOthers = false;
            for (ActivityManager.RunningAppProcessInfo process : processes) {
                if (process == null || process.pkgList == null) {
                    continue;
                }
                for (String packageName : process.pkgList) {
                    if (BRIDGE_PACKAGE.equals(packageName)) {
                        return true;
                    }
                    if (!context.getPackageName().equals(packageName)) {
                        sawOthers = true;
                    }
                }
            }
            return !sawOthers;
        } catch (Exception e) {
            Log.w(TAG, "Could not read the bridge's process state", e);
            return true;
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