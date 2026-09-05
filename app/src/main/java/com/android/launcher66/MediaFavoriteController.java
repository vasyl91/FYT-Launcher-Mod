package com.android.launcher66;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.FytRating;
import com.fyt.car.MusicService;
import com.syu.widget.DateMusicProvider;
import com.syu.widget.Widget;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaFavoriteController {
    public static final String ACTION_FAVORITE = "com.android.launcher66.action.MEDIA_FAVORITE";
    public static final int FAVORITE_STATE_UNKNOWN = 0;
    public static final int FAVORITE_STATE_NOT_FAVORITED = 1;
    public static final int FAVORITE_STATE_FAVORITED = 2;

    private static final String TAG = "MediaFavorite";
    private static final String PREFS_NAME = "media_favorite_state";
    private static final String PREF_PREFIX = "favorite:";
    private static final String STOCK_MUSIC_PACKAGE = "com.syu.music";
    private static final String SPOTIFY_PACKAGE = "com.spotify.music";
    private static final String APPLE_MUSIC_PACKAGE = "com.apple.android.music";
    private static final String YOUTUBE_MUSIC_PACKAGE = "com.google.android.apps.youtube.music";
    private static final String YOUTUBE_PACKAGE = "com.google.android.youtube";
    private static final String YOUTUBE_REVANCED_PACKAGE = "app.revanced.android.youtube";
    private static final String YOUTUBE_MUSIC_REVANCED_PACKAGE = "app.revanced.android.apps.youtube.music";
    private static final ExecutorService FAVORITE_CACHE_EXECUTOR = Executors.newSingleThreadExecutor();

    /** True once the user has granted access to the YouTube Data API. */
    private static boolean isLoggedOAuth() {
        return FytRating.isLoggedIn(LauncherApplication.sApp);
    }

    private static final boolean isMediaDebug = false;

    private static SharedPreferences mPrefs;

    private static final String DEBUG_TAG = "MediaDebug";
    private static final Pattern VIDEO_ID_IN_URL =
            Pattern.compile("(?:/vi/|/vi_webp/|[?&]v=)([A-Za-z0-9_-]{11})");
    private static final Pattern BARE_VIDEO_ID =
            Pattern.compile("^[A-Za-z0-9_-]{11}$");
    private static volatile String lastDebugKey = null;

    /**
     * Keys published by the ReVanced patch. The sequence number is bumped on
     * every like interaction made inside YouTube itself, which is what lets
     * the launcher tell a real event apart from a stale value, and lets it
     * ignore the ratings it sent itself - those never bump the counter.
     */
    private static final String KEY_LIKE_EVENT_SEQ =
            "com.android.launcher66.LIKE_EVENT_SEQ";
    private static final String KEY_LIKE_STATUS =
            "com.android.launcher66.LIKE_STATUS";

    private static volatile long lastSeenLikeEventSeq = 0L;
    private static boolean ratingFetcherReported = false;

    private MediaFavoriteController() {
    }

    public static boolean favoriteCurrent(Context context, String preferredPackage) {
        return toggleFavoriteCurrent(context, preferredPackage);
    }

    public static boolean toggleFavoriteCurrent(Context context, String preferredPackage) {
        // The check further down reads the resolved controller's package, which
        // is never the stock player, so a press would otherwise be sent to an
        // unrelated background session.
        if (isStockMusicSource(preferredPackage)) {
            Log.d(TAG, "Press ignored: the stock player is the active source");
            return false;
        }

        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return false;
        }

        // The session picker no longer applies this rule, because doing so kept
        // the status from ever being resolved. The write path is where it
        // belongs: nothing may be sent for a video whose rating the launcher is
        // not allowed to touch or has not confirmed yet.
        if (isFavoriteTemporarilyDisabledPackage(controller.getPackageName())) {
            // Logged loudly: from the outside this is indistinguishable from a
            // button that simply does nothing.
            Log.w(TAG, "Press ignored for " + controller.getPackageName()
                    + "; statusKnown=" + FytRating.isStatusKnown()
                    + " signedIn=" + FytRating.isSignedIn()
                    + " allowed=" + FytRating.isAllowed()
                    + " | " + YouTubeRevancedLikeState.describe());
            return false;
        }

        int stateBefore = getCurrentFavoriteState(context, preferredPackage);
        int expected = getExpectedStateAfterToggle(stateBefore);

        if (isYouTubePackage(controller.getPackageName())
                && YouTubeRevancedLikeState.hasFetcher()) {
            // The Data API is the only write that reaches the account, so it is
            // used on its own here. Sending the rating over the media session as
            // well would make YouTube fire its own request, which lands after
            // ours and stores the rating where the API cannot see it.
            String videoId = findVideoId(controller);
            if (videoId == null || videoId.isEmpty()) {
                return false;
            }

            YouTubeRevancedLikeState.setState(videoId, expected);

            // The session rating is sent only after the account has been
            // updated. It makes YouTube refresh its own thumb, but it also
            // makes it fire a request of its own - one that stores the rating
            // where the Data API cannot see it. Sending it second means our
            // write is the one that already landed.
            YouTubeRevancedLikeState.applyRating(
                    context,
                    videoId,
                    expected == FAVORITE_STATE_FAVORITED,
                    () -> mirrorRatingToSession(
                            controller, expected == FAVORITE_STATE_FAVORITED)
            );
            return true;
        }

        boolean sent = toggleFavorite(context, controller, toPrivateState(stateBefore));
        if (sent) {
            if (isYouTubePackage(controller.getPackageName())) {
                // No account connected: the session rating is all there is, and
                // it only updates YouTube's own interface.
                YouTubeRevancedLikeState.setState(findVideoId(controller), expected);
            } else {
                cachePublicFavoriteState(context, controller, expected);
            }
        }
        return sent;
    }

    public static int getCurrentFavoriteState(Context context, String preferredPackage) {
        if (isMediaDebug) {
            Log.d(DEBUG_TAG, "getCurrentFavoriteState called");
        }

        // Answered before the picker runs. Falling through would resolve some
        // other player's session - whatever happens to be paused in the
        // background - and paint its state onto a track it has nothing to do
        // with. Returning early also keeps the ReVanced stall watchdog out of
        // this, which has no business firing while the stock player is on.
        if (isStockMusicSource(preferredPackage)) {
            return FAVORITE_STATE_UNKNOWN;
        }

        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            if (isMediaDebug) {
                Log.d(DEBUG_TAG, "getCurrentFavoriteState: no controller");
            }
            noteRevancedUnreachable(context, preferredPackage);
            return FAVORITE_STATE_UNKNOWN;
        }

        // Dump once per track regardless of the resolved state. Previously this
        // sat in the UNKNOWN branch, which stopped being reached once the patch
        // started delivering USER_RATING.
        if (isMediaDebug) {
            dumpMediaDebugOncePerTrack(context, controller);
        }

        PlaybackState state = safePlaybackState(controller);
        FavoriteActions actions = state == null
                ? new FavoriteActions()
                : findFavoriteActions(state.getCustomActions());
        if (isYouTubePackage(controller.getPackageName())) {
            String videoId = findVideoId(controller);

            // The published USER_RATING is never consulted here. A rating sent
            // by the launcher takes a different path inside YouTube than a tap
            // in its own UI, so that value stays stale until the next track and
            // would undo what the user just did. The status is tracked for the
            // current video only and starts over whenever playback moves on.
            applyInAppLikeEvent(controller, videoId);

            ensureRatingFetcher(context);
            YouTubeRevancedLikeState.requestRefresh(videoId);

            int resolved = YouTubeRevancedLikeState.getState(videoId);
            noteYouTubeState(videoId, resolved);
            return resolved;
        }

        int currentState = toPublicState(getFavoriteState(controller, actions));
        if (currentState != FAVORITE_STATE_UNKNOWN) {
            cachePublicFavoriteState(context, controller, currentState);
            return currentState;
        }

        return getCachedPublicFavoriteState(context, controller);
    }

    public static boolean isFavoriteTemporarilyDisabledPackage(String packageName) {
        // The stock player exposes no rating of any kind, so there is nothing
        // the button could act on while it is the source. Checked first,
        // because every rule below is about a media session and it has none.
        if (isStockMusicSource(packageName)) {
            return true;
        }

        // Videos made for kids expose no rating at all: YouTube reports "none"
        // however they were rated. The button is disabled for them, the same
        // way it is for a player whose state cannot be read.
        if (YOUTUBE_REVANCED_PACKAGE.equals(packageName)
                && YouTubeRevancedLikeState.isCurrentMadeForKids()
                && !isKidsRatingAllowed()) {
            return true;
        }

        // With an account connected the status arrives a moment after the track
        // starts. Until then the button is disabled: an enabled one would send
        // a rating derived from a state nobody has confirmed yet.
        //
        // Videos made for kids are the exception. Their status never resolves,
        // because YouTube reports no rating for them at all, so this rule would
        // keep the button disabled for good and override the preference that is
        // supposed to control exactly that.
        if (YOUTUBE_REVANCED_PACKAGE.equals(packageName)
                && YouTubeRevancedLikeState.hasFetcher()
                && !YouTubeRevancedLikeState.isCurrentMadeForKids()
                && !YouTubeRevancedLikeState.isCurrentStateResolved()) {
            pokeRevanced();
            return true;
        }

        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        if (mPrefs.getBoolean(Keys.FAVORITE_CACHE, false)) {
            // A resolved status means the bridge answered a rating request for
            // this very video moments ago. That is direct evidence about the
            // permission, and it outranks the cached flag below - which is what
            // goes stale. Without this, a wrong refusal kept the button dead
            // even while the lookups behind it were succeeding.
            if (YOUTUBE_REVANCED_PACKAGE.equals(packageName)
                    && YouTubeRevancedLikeState.isCurrentStateResolved()) {
                return false;
            }
            if (isLoggedOAuth()) {
                // YouTube ENABLED in settings and user granted permission to OAuth to get like state for YouTube Revanced
                return false;
            } else {
                // YouTube ENABLED in settings, not logged in OAuth
                return YOUTUBE_REVANCED_PACKAGE.equals(packageName);
            }
        } else if (isLoggedOAuth()) {
            // YouTube DISABLED in settings and user granted permission to OAuth to get like state for YouTube Revanced
            return YOUTUBE_PACKAGE.equals(packageName);
        } else {
            // YouTube DISABLED in settings, not logged in OAuth
            return YOUTUBE_PACKAGE.equals(packageName) || YOUTUBE_REVANCED_PACKAGE.equals(packageName);
        }
    }

    private static MediaController getTargetController(Context context, String preferredPackage) {
        MediaSessionManager sessionManager =
                (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
        if (sessionManager == null) {
            return null;
        }

        // An unbound listener is the quiet failure: the permission is still
        // granted, so nothing throws, but no session is ever reported again.
        if (NotificationListener.getInstance() == null) {
            noteListenerMissing(context);
        } else {
            listenerMissingSinceMs = 0L;
        }

        List<MediaController> controllers;
        try {
            controllers = sessionManager.getActiveSessions(new ComponentName(context, NotificationListener.class));
        } catch (SecurityException e) {
            Log.w(TAG, "Notification listener access lost, asking for a rebind", e);
            requestListenerRebind(context);
            return null;
        }

        return pickTargetController(controllers, preferredPackage);
    }

    /**
     * Asks the system to reconnect {@link NotificationListener}.
     *
     * A listener the system has unbound stays unbound for the life of the
     * process, and every media session then disappears at once - which is why
     * force stopping the launcher used to be the only cure. Throttled, since
     * the system ignores repeated requests anyway.
     */
    private static void requestListenerRebind(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            return;
        }

        long now = SystemClock.elapsedRealtime();
        if (now - listenerRebindAtMs < LISTENER_REBIND_INTERVAL_MS) {
            return;
        }
        listenerRebindAtMs = now;

        try {
            Log.w(TAG, "Requesting a NotificationListener rebind");
            NotificationListenerService.requestRebind(
                    new ComponentName(context.getApplicationContext(), NotificationListener.class));
        } catch (Exception e) {
            Log.w(TAG, "Rebind request refused", e);
        }
    }

    private static MediaController pickTargetController(List<MediaController> controllers, String preferredPackage) {
        if (controllers == null || controllers.isEmpty()) {
            return null;
        }

        if (isExternalPackage(preferredPackage)) {
            if (isUnsupportedFavoritePackage(preferredPackage)) {
                return null;
            }
            for (MediaController controller : controllers) {
                if (preferredPackage.equals(controller.getPackageName())) {
                    return controller;
                }
            }
        }

        MediaController fallback = null;
        for (MediaController controller : controllers) {
            if (controller == null || !isExternalPackage(controller.getPackageName())) {
                continue;
            }
            if (isUnsupportedFavoritePackage(controller.getPackageName())) {
                continue;
            }
            PlaybackState state = safePlaybackState(controller);
            boolean favoriteCapable = hasFavoriteCapability(controller, state);
            if (!favoriteCapable && !isKnownFavoritePackage(controller.getPackageName())) {
                continue;
            }
            if (fallback == null) {
                fallback = controller;
            }
            if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                return controller;
            }
        }
        return fallback;
    }

    /**
     * Whether a player can never be a rating target, whatever its current state.
     *
     * Deliberately narrower than {@link #isFavoriteTemporarilyDisabledPackage}.
     * The two rules left out of it - "status not resolved yet" and "made for
     * kids" - describe the button, not the session, and both are decided by
     * state that only {@link #getCurrentFavoriteState} can produce. Applying
     * them here hid the ReVanced session from the picker, which stopped
     * requestRefresh from ever running: an unresolved status could then never
     * resolve, and the button stayed grey until the launcher was restarted.
     */
    private static boolean isUnsupportedFavoritePackage(String packageName) {
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }

        if (mPrefs.getBoolean(Keys.FAVORITE_CACHE, false)) {
            // YouTube enabled in settings: the ReVanced session is kept
            // whatever the bridge currently says about permissions.
            //
            // Hiding it used to be conditional on a cached "not allowed", and
            // that removed three things at once: the click, the state read and
            // the watchdog. Since the cached answer is itself the thing most
            // likely to be stale, a single wrong "no" left a button that could
            // not be pressed, could not be refreshed, and could not report that
            // anything was wrong - curable only by restarting the launcher,
            // which is exactly what cleared the cached answer.
            //
            // Nothing is lost by keeping it. An account that really is missing
            // leaves the status unresolved, the button unlit, and a press
            // refused with a reason in the log.
            //
            // Still asked, because it is what starts a stale status being
            // rechecked in the background.
            isLoggedOAuth();
            return false;
        }

        // YouTube disabled in settings.
        if (isLoggedOAuth()) {
            return YOUTUBE_PACKAGE.equals(packageName);
        }
        return YOUTUBE_PACKAGE.equals(packageName)
                || YOUTUBE_REVANCED_PACKAGE.equals(packageName);
    }

    /** Not more than one rebind request per minute; the system coalesces them anyway. */
    private static final long LISTENER_REBIND_INTERVAL_MS = 60000L;
    private static volatile long listenerRebindAtMs;

    /** How long the listener is given to bind before its absence means anything. */
    private static final long LISTENER_GRACE_MS = 45000L;
    private static volatile long listenerMissingSinceMs;

    /**
     * Notices a listener that is not there, and waits before concluding
     * anything from it.
     *
     * The service binds asynchronously some time after the process starts, so
     * on a cold launcher it is legitimately absent for a while. Asking for a
     * rebind then is at best noise and at worst a request sent into the middle
     * of a bind that was already happening.
     */
    private static void noteListenerMissing(Context context) {
        long now = SystemClock.elapsedRealtime();

        if (listenerMissingSinceMs == 0L) {
            listenerMissingSinceMs = now;
            return;
        }
        if (now - listenerMissingSinceMs < LISTENER_GRACE_MS) {
            return;
        }
        requestListenerRebind(context);
    }

    /** How long the ReVanced status may stay unresolved before it counts as a stall. */
    private static final long YOUTUBE_STALL_LIMIT_MS = 90000L;

    /** Not more than one recovery attempt in this window. */
    private static final long YOUTUBE_RECOVERY_INTERVAL_MS = 300000L;

    private static volatile String stallVideoId;
    private static volatile long stallSinceMs;
    private static volatile long lastRecoveryAtMs;
    private static volatile int recoveryAttempts;

    /** Stands in for a video id when the session was rejected before one could be read. */
    private static final String REVANCED_STALL_KEY = "revanced-session";

    private static final long REVANCED_DIAGNOSTIC_INTERVAL_MS = 30000L;
    private static volatile long lastRevancedDiagnosticAtMs;

    /**
     * Everything the ReVanced button's state depends on, in one line.
     *
     * The grey button has had several different causes and they are impossible
     * to tell apart from the outside, because each one stops the code before it
     * reaches whatever would have reported the next one. So this is emitted
     * from the earliest point that can still see anything, and names the whole
     * chain at once: which sessions exist, which rules rejected them, what the
     * bridge last said, and where the lookup stopped.
     *
     * Rate limited, and only ever emitted while the state is unresolved.
     */
    private static void dumpRevancedDiagnostics(
            Context context, String preferredPackage, String reason) {
        long now = SystemClock.elapsedRealtime();
        if (lastRevancedDiagnosticAtMs != 0L
                && now - lastRevancedDiagnosticAtMs < REVANCED_DIAGNOSTIC_INTERVAL_MS) {
            return;
        }
        lastRevancedDiagnosticAtMs = now;

        StringBuilder sessions = new StringBuilder();
        boolean revancedPresent = false;

        try {
            MediaSessionManager sessionManager =
                    (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
            List<MediaController> controllers = sessionManager == null ? null
                    : sessionManager.getActiveSessions(
                            new ComponentName(context, NotificationListener.class));

            if (controllers == null || controllers.isEmpty()) {
                sessions.append("none");
            } else {
                for (MediaController controller : controllers) {
                    if (controller == null) {
                        continue;
                    }
                    PlaybackState state = safePlaybackState(controller);
                    sessions.append(controller.getPackageName())
                            .append(':')
                            .append(state == null ? "no-state" : state.getState())
                            .append(' ');
                    if (YOUTUBE_REVANCED_PACKAGE.equals(controller.getPackageName())) {
                        revancedPresent = true;
                    }
                }
            }
        } catch (Exception e) {
            sessions.append("unreadable: ").append(e);
        }

        Log.w(TAG, "ReVanced " + reason
                + "; preferred=" + preferredPackage
                + " revancedSession=" + revancedPresent
                + " listener=" + (NotificationListener.getInstance() != null)
                + " sessions=[" + sessions.toString().trim() + "]"
                + " unsupported=" + isUnsupportedFavoritePackage(YOUTUBE_REVANCED_PACKAGE)
                + " disabled=" + isFavoriteTemporarilyDisabledPackage(YOUTUBE_REVANCED_PACKAGE)
                + " statusKnown=" + FytRating.isStatusKnown()
                + " signedIn=" + FytRating.isSignedIn()
                + " allowed=" + FytRating.isAllowed()
                + " | " + YouTubeRevancedLikeState.describe());
    }

    /**
     * Keeps the watchdog running when the ReVanced session has been rejected.
     *
     * The stall check used to sit past the controller lookup, which meant it
     * stopped running in the one situation it exists for. A refused or unknown
     * permission hides the session; hiding the session means nothing reaches
     * the point where a stall would be noticed; and so the launcher settled
     * into a grey button that only a restart cleared. The check belongs before
     * that, not after it.
     *
     * The session is looked up again here with no permission rule applied,
     * purely to answer whether ReVanced is playing at all - there is nothing to
     * recover if it is not.
     */
    private static void noteRevancedUnreachable(Context context, String preferredPackage) {
        if (!hasRevancedSession(context, preferredPackage)) {
            // Nothing to recover - but worth saying so. A session that was
            // there a moment ago and is now gone, while the widget still shows
            // the video, is itself the failure and used to be invisible.
            if (stallSinceMs != 0L) {
                dumpRevancedDiagnostics(context, preferredPackage, "session no longer visible");
            }
            stallVideoId = null;
            stallSinceMs = 0L;
            return;
        }

        dumpRevancedDiagnostics(context, preferredPackage, "session rejected by the picker");
        noteYouTubeState(REVANCED_STALL_KEY, FAVORITE_STATE_UNKNOWN);
    }

    /** Whether ReVanced holds a session right now, permission rules aside. */
    private static boolean hasRevancedSession(Context context, String preferredPackage) {
        return YOUTUBE_REVANCED_PACKAGE.equals(preferredPackage)
                || findRevancedController(context) != null;
    }

    /**
     * The ReVanced session as the system reports it, with none of the favorite
     * rules applied. Deliberately separate from the picker: this answers "is it
     * there", not "may it be used".
     */
    private static MediaController findRevancedController(Context context) {
        if (context == null) {
            return null;
        }

        try {
            MediaSessionManager sessionManager =
                    (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
            if (sessionManager == null) {
                return null;
            }

            List<MediaController> controllers = sessionManager.getActiveSessions(
                    new ComponentName(context, NotificationListener.class));
            if (controllers == null) {
                return null;
            }

            for (MediaController controller : controllers) {
                if (controller != null
                        && YOUTUBE_REVANCED_PACKAGE.equals(controller.getPackageName())) {
                    return controller;
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not look for a ReVanced session", e);
        }
        return null;
    }

    private static final AtomicBoolean POKING = new AtomicBoolean(false);

    /**
     * Keeps the lookup running when nothing else is asking for it.
     *
     * A disabled button is drawn without reading its state, so once the rule
     * above starts returning true the launcher stops calling
     * getCurrentFavoriteState - and that was the only place requestRefresh was
     * ever reached from. The rule then feeds itself: unresolved disables the
     * button, and the disabled button keeps it unresolved. Transport and
     * metadata keep working throughout, because they go through a different
     * picker entirely, which is what made this look like a bridge problem.
     *
     * Driving the lookup from here breaks that. It costs almost nothing:
     * requestRefresh refuses anything already answered, already in flight, or
     * still inside its backoff.
     */
    private static void pokeRevanced() {
        if (!POKING.compareAndSet(false, true)) {
            // Reached again through the diagnostics, which ask this same rule.
            return;
        }

        try {
            Context context = LauncherApplication.sApp;
            MediaController controller = findRevancedController(context);
            if (controller == null) {
                return;
            }

            String videoId = findVideoId(controller);
            if (videoId == null || videoId.isEmpty()) {
                return;
            }

            ensureRatingFetcher(context);
            YouTubeRevancedLikeState.requestRefresh(videoId);

            // Also the only way the stall watchdog hears about any of this now.
            noteYouTubeState(videoId, YouTubeRevancedLikeState.getState(videoId));
        } catch (Exception e) {
            Log.w(TAG, "Could not refresh the ReVanced status", e);
        } finally {
            POKING.set(false);
        }
    }

    /**
     * Watches the one path no other player uses.
     *
     * Every other application's favorite state is read straight off its media
     * session. ReVanced is the only one whose state depends on a round trip to
     * another application, which is why it alone could sit grey for hours while
     * everything else kept working, and why only killing the launcher helped:
     * the state that had gone wrong lived in this process and nothing ever
     * questioned it.
     *
     * So it is questioned here. A status still unresolved long after any
     * ordinary retry should have settled it means something cached is wrong,
     * and everything the launcher believes about the bridge is thrown away -
     * which is what a force stop did, minus the force stop.
     */
    private static void noteYouTubeState(String videoId, int state) {
        if (videoId == null || videoId.isEmpty()) {
            return;
        }

        long now = SystemClock.elapsedRealtime();

        if (state != FAVORITE_STATE_UNKNOWN) {
            stallVideoId = null;
            stallSinceMs = 0L;
            recoveryAttempts = 0;
            return;
        }

        if (!videoId.equals(stallVideoId)) {
            stallVideoId = videoId;
            stallSinceMs = now;
            return;
        }

        dumpRevancedDiagnostics(LauncherApplication.sApp, videoId, "state unresolved");
        if (now - stallSinceMs < YOUTUBE_STALL_LIMIT_MS) {
            return;
        }
        if (now - lastRecoveryAtMs < YOUTUBE_RECOVERY_INTERVAL_MS) {
            return;
        }
        lastRecoveryAtMs = now;
        recoveryAttempts++;

        // Everything needed to tell afterwards which piece had gone stale.
        Log.w(TAG, "Like status for " + videoId + " unresolved for "
                + (now - stallSinceMs) + " ms"
                + "; attempt=" + recoveryAttempts
                + " statusKnown=" + FytRating.isStatusKnown()
                + " signedIn=" + FytRating.isSignedIn()
                + " allowed=" + FytRating.isAllowed()
                + " fetcher=" + YouTubeRevancedLikeState.hasFetcher()
                + " inFlight=" + YouTubeRevancedLikeState.isFetchInFlight()
                + " - rebuilding");

        if (FytRating.isStatusKnown() && !FytRating.isAllowed()) {
            // The bridge answered, and the answer was no. Restarting either side
            // cannot change that, so the ladder below is skipped: the grant is
            // gone and only the user can put it back.
            Log.w(TAG, "The bridge refuses this launcher; access has to be granted"
                    + " again in fYT Rating");
            FytRating.resetTransport();
            stallSinceMs = now;
            return;
        }

        FytRating.resetTransport();
        YouTubeRevancedLikeState.forceRetry();

        if (recoveryAttempts == 2) {
            // Rebuilding this side changed nothing, so what is missing is on
            // the other side of the boundary: most likely a process that is not
            // there at all. Starting it is invisible and costs nothing.
            FytRating.wake(LauncherApplication.sApp);
        } else if (recoveryAttempts >= 3) {
            // It is there and still says nothing, so it is not a missing
            // process but a wedged one. Send it away and let the system build a
            // fresh one for the next request.
            FytRating.revive(LauncherApplication.sApp);
        }

        stallSinceMs = now;
    }

    private static boolean isExternalPackage(String packageName) {
        return packageName != null
                && !packageName.isEmpty()
                && !"null".equals(packageName)
                && !STOCK_MUSIC_PACKAGE.equals(packageName);
    }

    /**
     * Whether the stock player currently owns the widget.
     *
     * It publishes no media session, so it can never be recognised by a
     * package name coming from the session list. The launcher reports it by
     * passing no preferred package at all, and the two pieces of state below
     * are what tell that apart from an external player the caller simply did
     * not name.
     */
    public static boolean isStockMusicSource(String packageName) {
        if (STOCK_MUSIC_PACKAGE.equals(packageName)) {
            return true;
        }
        if (isExternalPackage(packageName)) {
            return false;
        }
        // The snapshot is cleared the moment the stock player takes the widget
        // over, and stays cleared while it holds it - including when paused,
        // which MusicService.state alone does not cover.
        return Boolean.TRUE.equals(MusicService.state)
                || MediaWidgetState.getExternalSnapshot() == null;
    }

    private static boolean isKnownFavoritePackage(String packageName) {
        return SPOTIFY_PACKAGE.equals(packageName)
                || APPLE_MUSIC_PACKAGE.equals(packageName)
                || YOUTUBE_MUSIC_PACKAGE.equals(packageName)
                || YOUTUBE_MUSIC_REVANCED_PACKAGE.equals(packageName);
    }

    private static PlaybackState safePlaybackState(MediaController controller) {
        try {
            return controller.getPlaybackState();
        } catch (Exception e) {
            Log.w(TAG, "Failed to read playback state for " + controller.getPackageName(), e);
            return null;
        }
    }

    private static boolean hasFavoriteCapability(MediaController controller, PlaybackState state) {
        if (state != null) {
            if ((state.getActions() & PlaybackState.ACTION_SET_RATING) != 0) {
                return true;
            }
            FavoriteActions actions = findFavoriteActions(state.getCustomActions());
            if (actions.positive != null || actions.negative != null || actions.toggle != null) {
                return true;
            }
        }
        return getMetadataFavoriteState(controller) != FavoriteState.UNKNOWN;
    }

    private static boolean toggleFavorite(Context context, MediaController controller, FavoriteState assumedState) {
        PlaybackState state = controller.getPlaybackState();
        if (state == null) {
            return false;
        }
        if (isFavoriteTemporarilyDisabledPackage(controller.getPackageName())) {
            Log.d(TAG, "Favorite disabled for " + controller.getPackageName());
            return false;
        }

        FavoriteActions actions = findFavoriteActions(state.getCustomActions());
        FavoriteState observedState = getFavoriteState(controller, actions);
        FavoriteState favoriteState = observedState == FavoriteState.UNKNOWN ? assumedState : observedState;
        Log.d(TAG, "Favorite state for " + controller.getPackageName()
                + ": observed=" + observedState + " assumed=" + assumedState + " effective=" + favoriteState);

        if (isMediaDebug) {
            dumpFavoriteDebug(
                context,
                controller,
                actions,
                observedState,
                favoriteState);
        }

        if (favoriteState == FavoriteState.FAVORITED) {
            if (sendCustomAction(controller, actions.negative, "unfavorite")) return true;
            if (sendRating(controller, state, false)) return true;
            if (sendCustomAction(controller, actions.toggle, "toggle favorite")) return true;
            if (observedState == FavoriteState.UNKNOWN
                    && isKnownFavoritePackage(controller.getPackageName())
                    && sendCustomAction(controller, actions.positive, "single favorite action fallback")) {
                return true;
            }
            Log.d(TAG, "No unfavorite action exposed by " + controller.getPackageName());
            return false;
        }

        if (favoriteState == FavoriteState.NOT_FAVORITED) {
            if (sendCustomAction(controller, actions.positive, "favorite")) return true;
            if (sendRating(controller, state, true)) return true;
            if (sendCustomAction(controller, actions.toggle, "toggle favorite")) return true;
            Log.d(TAG, "No favorite action exposed by " + controller.getPackageName());
            return false;
        }

        if (sendCustomAction(controller, actions.toggle, "toggle favorite")) return true;
        if (sendCustomAction(controller, actions.positive, "favorite")) return true;
        if (sendRating(controller, state, true)) return true;
        Log.d(TAG, "No favorite state or action exposed by " + controller.getPackageName());
        return false;
    }

    private static boolean sendCustomAction(MediaController controller, PlaybackState.CustomAction action, String label) {
        if (action == null) {
            return false;
        }
        try {
            controller.getTransportControls().sendCustomAction(action.getAction(), null);
            Log.d(TAG, "Sent " + label + " custom action for " + controller.getPackageName() + ": " + action.getAction());
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to send " + label + " custom action for " + controller.getPackageName(), e);
            return false;
        }
    }

    /**
     * Repeats the rating over the media session so YouTube redraws its own
     * thumb. The account has already been updated at this point; this call is
     * only about the on-screen state inside the application.
     */
    private static void mirrorRatingToSession(MediaController controller, boolean favorite) {
        try {
            PlaybackState state = safePlaybackState(controller);
            if (state != null) {
                sendRating(controller, state, favorite);
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not mirror the rating to the media session", e);
        }
    }

    private static boolean sendRating(MediaController controller, PlaybackState state, boolean favorite) {
        if ((state.getActions() & PlaybackState.ACTION_SET_RATING) == 0) {
            return false;
        }

        int ratingStyle = getRatingStyle(controller.getMetadata());

        if (ratingStyle == Rating.RATING_THUMB_UP_DOWN) {
            if (!favorite) {
                return sendRatingValue(controller, Rating.newUnratedRating(Rating.RATING_THUMB_UP_DOWN), "thumb unrated");
            }
            return sendRatingValue(controller, Rating.newThumbRating(true), "thumb rating true");
        }

        if (ratingStyle == Rating.RATING_HEART) {
            if (!favorite) {
                return sendRatingValue(controller, Rating.newHeartRating(false), "heart rating false");
            }
            return sendRatingValue(controller, Rating.newHeartRating(true), "heart rating true");
        }

        if (!favorite) {
            if (sendRatingValue(controller, Rating.newUnratedRating(Rating.RATING_THUMB_UP_DOWN), "thumb unrated (fallback)")) return true;
            if (sendRatingValue(controller, Rating.newUnratedRating(Rating.RATING_HEART), "heart unrated (fallback)")) return true;
            return sendRatingValue(controller, Rating.newHeartRating(false), "heart rating false (fallback)");
        }
        if (sendRatingValue(controller, Rating.newThumbRating(true), "thumb rating true (fallback)")) return true;
        return sendRatingValue(controller, Rating.newHeartRating(true), "heart rating true (fallback)");
    }

    private static int getRatingStyle(MediaMetadata metadata) {
        if (metadata == null) {
            return Rating.RATING_NONE;
        }
        Rating userRating = metadata.getRating(MediaMetadata.METADATA_KEY_USER_RATING);
        if (userRating != null) {
            return userRating.getRatingStyle();
        }
        Rating rating = metadata.getRating(MediaMetadata.METADATA_KEY_RATING);
        if (rating != null) {
            return rating.getRatingStyle();
        }
        return Rating.RATING_NONE;
    }

    private static boolean sendRatingValue(MediaController controller, Rating rating, String label) {
        try {
            Log.d(TAG, "Sending rating...");

            controller.getTransportControls().setRating(rating);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {

                MediaMetadata md = controller.getMetadata();

                if (md == null) {
                    Log.d(TAG, "Metadata after rating = null");
                    return;
                }

                Rating ur = md.getRating(MediaMetadata.METADATA_KEY_USER_RATING);
                Rating r = md.getRating(MediaMetadata.METADATA_KEY_RATING);

                Log.d(TAG, "After setRating()");
                Log.d(TAG, "USER_RATING = " + ur);
                Log.d(TAG, "RATING      = " + r);

            }, 1000);

            Log.d(TAG, "Rating object = " + rating);
            Log.d(TAG, "Rating style  = " + rating.getRatingStyle());
            Log.d(TAG, "isRated       = " + rating.isRated());

            try {
                Log.d(TAG, "hasHeart      = " + rating.hasHeart());
            } catch (Exception ignored) {}

            try {
                Log.d(TAG, "thumbUp       = " + rating.isThumbUp());
            } catch (Exception ignored) {}

            Log.d(TAG, "setRating() finished");
            return true;
        } catch (Exception e) {
            Log.w(TAG, label + " failed for " + controller.getPackageName(), e);
            return false;
        }
    }

    private static FavoriteState getFavoriteState(MediaController controller, FavoriteActions actions) {
        FavoriteState metadataState = getMetadataFavoriteState(controller);
        if (metadataState != FavoriteState.UNKNOWN) {
            return metadataState;
        }
        if (actions.negative != null && actions.positive == null) {
            return FavoriteState.FAVORITED;
        }
        if (actions.positive != null && actions.negative == null) {
            return FavoriteState.NOT_FAVORITED;
        }
        return FavoriteState.UNKNOWN;
    }

    private static FavoriteState getMetadataFavoriteState(MediaController controller) {
        MediaMetadata metadata = controller == null ? null : controller.getMetadata();
        if (metadata == null) {
            return FavoriteState.UNKNOWN;
        }

        if (isYouTubePackage(controller.getPackageName())) {
            // The published USER_RATING cannot be trusted at all here. It only
            // reflects taps inside YouTube's own UI, and a rating sent by the
            // launcher takes a different path internally, so the value stays
            // stale until the next track. Reading it made the launcher invert
            // the user's action: a like was treated as an unlike. The status
            // therefore comes solely from YouTubeRevancedLikeState, fed by the Data
            // API and by the launcher's own actions.
            return FavoriteState.UNKNOWN;
        }

        FavoriteState userRatingState =
                ratingToFavoriteState(metadata.getRating(MediaMetadata.METADATA_KEY_USER_RATING));
        if (userRatingState != FavoriteState.UNKNOWN) {
            return userRatingState;
        }
        return ratingToFavoriteState(metadata.getRating(MediaMetadata.METADATA_KEY_RATING));
    }
    /**
     * Reads a long stored under an application specific key.
     *
     * MediaMetadata.getLong is annotated with the set of keys the framework
     * knows about, and custom ones are not part of it. At runtime the value is
     * simply read from the underlying bundle - YouTube publishes its own video
     * dimension keys the same way. Routing the key through a parameter stops
     * the annotation check from firing on a constant it cannot accept.
     */
    private static String describePublicState(int state) {
        return switch (state) {
            case FAVORITE_STATE_FAVORITED -> "FAVORITED";
            case FAVORITE_STATE_NOT_FAVORITED -> "NOT_FAVORITED";
            default -> "UNKNOWN";
        };
    }

    private static long readCustomLong(MediaMetadata metadata, String key) {
        try {
            return metadata.getLong(key);
        } catch (Exception e) {
            return 0L;
        }
    }

    private static void applyInAppLikeEvent(MediaController controller, String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            return;
        }

        MediaMetadata metadata = controller.getMetadata();
        if (metadata == null) {
            return;
        }

        long seq = readCustomLong(metadata, KEY_LIKE_EVENT_SEQ);
        if (seq == 0L || seq == lastSeenLikeEventSeq) {
            return;
        }

        boolean firstReading = lastSeenLikeEventSeq == 0L;
        lastSeenLikeEventSeq = seq;

        // The first number seen after a launcher restart describes whatever
        // YouTube published last, which may predate the current track. Only
        // the sequence is recorded, so a later change is still detected.
        if (firstReading) {
            return;
        }

        // -1 = cleared, 0 = none, 1 = like, 2 = dislike, as published by the
        // extension. A cleared status accompanies a track change rather than a
        // user action, so nothing is decided from it: the real status is looked
        // up instead, and until it arrives the button stays disabled.
        long status = readCustomLong(metadata, KEY_LIKE_STATUS);
        if (status < 0L) {
            Log.d(TAG, "Like status cleared for " + videoId + ", waiting for the API");
            return;
        }

        int state = status == 1L ? FAVORITE_STATE_FAVORITED : FAVORITE_STATE_NOT_FAVORITED;

        Log.d(TAG, "In-app like event #" + seq
                + ": status=" + status
                + " -> " + describePublicState(state)
                + " for " + videoId);
        YouTubeRevancedLikeState.setState(videoId, state);
    }

    /**
     * Connects the like state holder to the YouTube Data API once the user has
     * authorised it. Cheap and idempotent, so it can be called from the read
     * path; it does nothing while no account is connected.
     */
    private static void ensureRatingFetcher(Context context) {
        if (YouTubeRevancedLikeState.hasFetcher()) {
            return;
        }
        if (!isLoggedOAuth()) {
            if (!ratingFetcherReported) {
                ratingFetcherReported = true;
                Log.d(TAG, "No Google account linked, the like status will not be resolved");
            }
            return;
        }

        Log.d(TAG, "Installing the YouTube rating fetcher");

        Context appContext = context.getApplicationContext();

        // The lookup runs on a background thread; the widget has to be told
        // once the answer lands, or the new state waits for the next tick.
        YouTubeRevancedLikeState.setOnUpdated(() -> new Handler(Looper.getMainLooper())
                .post(() -> Widget.widgetUpdate(appContext, DateMusicProvider.class)));

        YouTubeRevancedLikeState.setKidsChecker(
                videoId -> FytRating.isMadeForKids(appContext, videoId));

        YouTubeRevancedLikeState.setFetcher(videoId -> {
            String rating = FytRating.fetchRating(appContext, videoId);
            if ("like".equals(rating)) {
                return FAVORITE_STATE_FAVORITED;
            }
            if ("none".equals(rating) || "dislike".equals(rating)) {
                return FAVORITE_STATE_NOT_FAVORITED;
            }
            return FAVORITE_STATE_UNKNOWN;
        });
    }

    /**
     * Whether the favorite button is greyed out for videos made for kids.
     *
     * YouTube exposes no rating for them, so the alternative is to show them
     * as not liked, which is misleading. On by default; the switch lets the
     * user pick the other behaviour.
     */
    private static boolean isKidsRatingAllowed() {
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        return mPrefs.getBoolean(Keys.YOUTUBE_REVANCED_KIDS, false);
    }

    public static void refreshWidget(Context context) {
        if (context != null) {
            Widget.widgetUpdate(context.getApplicationContext(), DateMusicProvider.class);
        }
    }

    /**
     * True only for the patched YouTube build.
     *
     * The whole Data API path depends on the media id the ReVanced patch
     * publishes, so it applies to that build alone. Stock YouTube, YouTube
     * Music and every other player keep the original behaviour: their state
     * comes from the metadata and the custom actions they expose, and the
     * rating is sent over the media session.
     */
    private static boolean isYouTubePackage(String packageName) {
        return YOUTUBE_REVANCED_PACKAGE.equals(packageName);
    }

    private static FavoriteState ratingToFavoriteState(Rating rating) {
        if (rating == null) {
            return FavoriteState.UNKNOWN;
        }
        if (!rating.isRated()) {
            if (rating.getRatingStyle() == Rating.RATING_HEART
                    || rating.getRatingStyle() == Rating.RATING_THUMB_UP_DOWN) {
                return FavoriteState.NOT_FAVORITED;
            }
            return FavoriteState.UNKNOWN;
        }
        if (rating.getRatingStyle() == Rating.RATING_HEART) {
            return rating.hasHeart() ? FavoriteState.FAVORITED : FavoriteState.NOT_FAVORITED;
        }
        if (rating.getRatingStyle() == Rating.RATING_THUMB_UP_DOWN) {
            return rating.isThumbUp() ? FavoriteState.FAVORITED : FavoriteState.NOT_FAVORITED;
        }
        return FavoriteState.UNKNOWN;
    }

    private static int toPublicState(FavoriteState state) {
        if (state == FavoriteState.FAVORITED) {
            return FAVORITE_STATE_FAVORITED;
        }
        if (state == FavoriteState.NOT_FAVORITED) {
            return FAVORITE_STATE_NOT_FAVORITED;
        }
        return FAVORITE_STATE_UNKNOWN;
    }

    private static FavoriteState toPrivateState(int state) {
        if (state == FAVORITE_STATE_FAVORITED) {
            return FavoriteState.FAVORITED;
        }
        if (state == FAVORITE_STATE_NOT_FAVORITED) {
            return FavoriteState.NOT_FAVORITED;
        }
        return FavoriteState.UNKNOWN;
    }

    private static String publicStateName(int state) {
        if (state == FAVORITE_STATE_FAVORITED) {
            return "favorited";
        }
        if (state == FAVORITE_STATE_NOT_FAVORITED) {
            return "not_favorited";
        }
        return "unknown";
    }

    private static String actionName(PlaybackState.CustomAction action) {
        if (action == null) {
            return "none";
        }
        return action.getAction() + " | " + action.getName();
    }

    private static int getExpectedStateAfterToggle(int stateBefore) {
        if (stateBefore == FAVORITE_STATE_FAVORITED) {
            return FAVORITE_STATE_NOT_FAVORITED;
        }
        return FAVORITE_STATE_FAVORITED;
    }

    private static int getCachedPublicFavoriteState(Context context, MediaController controller) {
        // YouTube is tracked per playing video by YouTubeRevancedLikeState and must not
        // fall back to this store: a status kept across tracks would be a guess,
        // since a like made before playback started is invisible to the launcher.
        if (controller != null && isYouTubePackage(controller.getPackageName())) {
            return FAVORITE_STATE_UNKNOWN;
        }

        String key = getTrackCacheKey(controller);
        if (key == null) {
            return FAVORITE_STATE_UNKNOWN;
        }
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getInt(key, FAVORITE_STATE_UNKNOWN);
    }

    private static void cachePublicFavoriteState(Context context, MediaController controller, int state) {
        if (controller != null && isYouTubePackage(controller.getPackageName())) {
            return;
        }

        String key = getTrackCacheKey(controller);
        if (key == null) {
            return;
        }

        Context appContext = context.getApplicationContext();
        FAVORITE_CACHE_EXECUTOR.execute(() -> {
            if (state == FAVORITE_STATE_UNKNOWN) {
                appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                        .edit()
                        .remove(key)
                        .apply();
            } else {
                appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                        .edit()
                        .putInt(key, state)
                        .apply();
            }
        });
    }

    private static String getTrackCacheKey(MediaController controller) {
        MediaMetadata metadata = controller.getMetadata();
        if (metadata == null) {
            return null;
        }

        String mediaId = metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID);
        if (mediaId != null && !mediaId.isEmpty()) {
            return PREF_PREFIX + controller.getPackageName() + ":id:" + mediaId;
        }

        String title = metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
        String artist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
        String album = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        if (isEmpty(title) && isEmpty(artist) && isEmpty(album)) {
            return null;
        }
        return PREF_PREFIX + controller.getPackageName()
                + ":track:" + normalize(title)
                + ":" + normalize(artist)
                + ":" + normalize(album);
    }

    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String normalize(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toLowerCase(Locale.US);
    }

    private static FavoriteActions findFavoriteActions(List<PlaybackState.CustomAction> actions) {
        FavoriteActions result = new FavoriteActions();
        if (actions == null || actions.isEmpty()) {
            return result;
        }

        for (PlaybackState.CustomAction action : actions) {
            String text = ((action.getAction() == null ? "" : action.getAction())
                    + " " + (action.getName() == null ? "" : action.getName().toString()))
                    .toLowerCase(Locale.US);
            if (isNegativeFavoriteAction(text)) {
                if (result.negative == null) {
                    result.negative = action;
                }
                continue;
            }
            if (isToggleFavoriteAction(text)) {
                if (result.toggle == null) {
                    result.toggle = action;
                }
                continue;
            }
            if ((isStrongFavoriteAction(text) || isPossibleFavoriteAction(text)) && result.positive == null) {
                result.positive = action;
            }
        }
        return result;
    }

    private enum FavoriteState {
        FAVORITED,
        NOT_FAVORITED,
        UNKNOWN
    }

    private static final class FavoriteActions {
        PlaybackState.CustomAction positive;
        PlaybackState.CustomAction negative;
        PlaybackState.CustomAction toggle;
    }

    private static boolean isStrongFavoriteAction(String text) {
        return text.contains("favorite")
                || text.contains("favourite")
                || text.contains("heart")
                || text.contains("love")
                || text.contains("thumbs_up")
                || text.contains("thumbs up")
                || text.contains("thumb_up")
                || text.contains("thumb up")
                || text.contains("thumbup")
                || text.contains("add_to_library")
                || text.contains("add to library")
                || text.contains("addtolibrary")
                || text.contains("add_library")
                || text.contains("save_to_library")
                || text.contains("save to library")
                || text.contains("save_to_collection");
    }

    private static boolean isToggleFavoriteAction(String text) {
        return text.contains("toggle")
                && (text.contains("favorite")
                || text.contains("favourite")
                || text.contains("like")
                || text.contains("heart")
                || text.contains("love")
                || text.contains("library")
                || text.contains("save"));
    }

    private static boolean isPossibleFavoriteAction(String text) {
        return text.contains("like") || text.contains("save") || text.contains("library");
    }

    private static boolean isNegativeFavoriteAction(String text) {
        boolean explicitNegative = text.contains("dislike")
                || text.contains("unlike")
                || text.contains("unfavorite")
                || text.contains("unfavourite")
                || text.contains("unlove")
                || text.contains("thumbs_down")
                || text.contains("thumbs down")
                || text.contains("thumb_down")
                || text.contains("thumb down")
                || text.contains("thumbdown")
                || text.contains("not_interested")
                || text.contains("not interested");
        if (explicitNegative) {
            return true;
        }

        boolean removeLikeAction = text.contains("remove")
                || text.contains("delete")
                || text.contains("hide")
                || text.contains("undo");
        return removeLikeAction && (text.contains("favorite")
                || text.contains("favourite")
                || text.contains("like")
                || text.contains("heart")
                || text.contains("love")
                || text.contains("library")
                || text.contains("save"));
    }

    private static void dumpFavoriteDebug(Context context,
                                          MediaController controller,
                                          FavoriteActions actions,
                                          FavoriteState observedState,
                                          FavoriteState effectiveState) {

        Log.d(TAG, "================== FAVORITE DEBUG ==================");
        Log.d(TAG, "Package        : " + controller.getPackageName());

        PlaybackState state = controller.getPlaybackState();
        Log.d(TAG, "PlaybackState  : " + (state == null ? "null" : state.getState()));

        if (state != null) {
            Log.d(TAG, "Actions mask   : 0x" + Long.toHexString(state.getActions()));
            dumpActions(state.getActions());

            List<PlaybackState.CustomAction> list = state.getCustomActions();
            if (list == null || list.isEmpty()) {
                Log.d(TAG, "CustomActions  : NONE");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    PlaybackState.CustomAction a = list.get(i);

                    Log.d(TAG,
                            "Action[" + i + "]"
                                    + "\n    id    = " + a.getAction()
                                    + "\n    name  = " + a.getName()
                                    + "\n    icon  = " + a.getIcon());
                }
            }
        }

        MediaMetadata md = controller.getMetadata();

        if (md == null) {
            Log.d(TAG, "Metadata       : null");
        } else {

            Log.d(TAG, "MediaId        : " + md.getString(MediaMetadata.METADATA_KEY_MEDIA_ID));
            Log.d(TAG, "Title          : " + md.getString(MediaMetadata.METADATA_KEY_TITLE));
            Log.d(TAG, "Artist         : " + md.getString(MediaMetadata.METADATA_KEY_ARTIST));
            Log.d(TAG, "Album          : " + md.getString(MediaMetadata.METADATA_KEY_ALBUM));

            Rating userRating =
                    md.getRating(MediaMetadata.METADATA_KEY_USER_RATING);

            Rating rating =
                    md.getRating(MediaMetadata.METADATA_KEY_RATING);

            dumpRating("USER_RATING", userRating);
            dumpRating("RATING", rating);
        }

        Log.d(TAG, "Detected positive : " + actionName(actions.positive));
        Log.d(TAG, "Detected negative : " + actionName(actions.negative));
        Log.d(TAG, "Detected toggle   : " + actionName(actions.toggle));

        Log.d(TAG, "Observed state    : " + observedState);
        Log.d(TAG, "Effective state   : " + effectiveState);

        Log.d(TAG, "Cached state      : "
                + publicStateName(
                        getCachedPublicFavoriteState(
                                context,
                                controller)));

        Log.d(TAG, "====================================================");
    }

    private static void dumpNotificationActions(Context context, MediaController controller) {
        NotificationListener listener = NotificationListener.getInstance();
        if (listener == null) {
            Log.d(DEBUG_TAG, "NotificationListener not connected");
            return;
        }

        String pkg = controller.getPackageName();

        StatusBarNotification[] active;
        try {
            active = listener.getActiveNotifications();
        } catch (SecurityException e) {
            Log.w(DEBUG_TAG, "No notification listener access", e);
            return;
        }

        Resources res;
        try {
            res = context.getPackageManager().getResourcesForApplication(pkg);
        } catch (Exception e) {
            return;
        }

        for (StatusBarNotification sbn : active) {
            if (!pkg.equals(sbn.getPackageName())) continue;
            Notification.Action[] actions = sbn.getNotification().actions;
            if (actions == null) continue;
            for (Notification.Action a : actions) {
                String iconName = "?";
                try {
                    Icon icon = a.getIcon();
                    int resId = getResIdFromIcon(icon);

                    if (resId != 0) {
                        iconName = res.getResourceEntryName(resId);
                    }
                } catch (Exception ignored) {}
                Log.d(DEBUG_TAG, "NotifAction title=" + a.title + " icon=" + iconName);
            }
        }
    }

    public static int getResIdFromIcon(Icon icon) {
        if (icon == null) return 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            // API 28+ (Android 9.0+)
            return icon.getResId();
        } else {
            // API 26–27
            try {
                Method method = icon.getClass().getMethod("getResId");
                Object result = method.invoke(icon);
                return result != null ? (Integer) result : 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    private static void dumpRating(String name, Rating rating) {

        if (rating == null) {
            Log.d(TAG, name + " = null");
            return;
        }

        Log.d(TAG, name + ".isRated      = " + rating.isRated());
        Log.d(TAG, name + ".style        = " + rating.getRatingStyle());

        try {
            Log.d(TAG, name + ".hasHeart     = " + rating.hasHeart());
        } catch (Exception ignored) {
        }

        try {
            Log.d(TAG, name + ".isThumbUp    = " + rating.isThumbUp());
        } catch (Exception ignored) {
        }
    }

    private static void dumpActions(long actions) {
        Log.d(TAG, "ACTION_PLAY            = " + ((actions & PlaybackState.ACTION_PLAY) != 0));
        Log.d(TAG, "ACTION_PAUSE           = " + ((actions & PlaybackState.ACTION_PAUSE) != 0));
        Log.d(TAG, "ACTION_PLAY_PAUSE      = " + ((actions & PlaybackState.ACTION_PLAY_PAUSE) != 0));
        Log.d(TAG, "ACTION_SKIP_NEXT       = " + ((actions & PlaybackState.ACTION_SKIP_TO_NEXT) != 0));
        Log.d(TAG, "ACTION_SKIP_PREV       = " + ((actions & PlaybackState.ACTION_SKIP_TO_PREVIOUS) != 0));
        Log.d(TAG, "ACTION_STOP            = " + ((actions & PlaybackState.ACTION_STOP) != 0));
        Log.d(TAG, "ACTION_SET_RATING      = " + ((actions & PlaybackState.ACTION_SET_RATING) != 0));
        Log.d(TAG, "ACTION_SEEK_TO         = " + ((actions & PlaybackState.ACTION_SEEK_TO) != 0));
        Log.d(TAG, "ACTION_FAST_FORWARD    = " + ((actions & PlaybackState.ACTION_FAST_FORWARD) != 0));
        Log.d(TAG, "ACTION_REWIND          = " + ((actions & PlaybackState.ACTION_REWIND) != 0));
    }    

    private static void dumpMediaDebugOncePerTrack(Context context, MediaController controller) {
        String key = getTrackCacheKey(controller);
        if (key != null && key.equals(lastDebugKey)) {
            return;
        }
        lastDebugKey = key;
        dumpMediaDebug(context, controller);
    }

    public static void dumpMediaDebug(Context context, MediaController controller) {
        String pkg = controller.getPackageName();
        Log.d(DEBUG_TAG, "=========== " + pkg + " ===========");

        MediaMetadata md = controller.getMetadata();
        if (md == null) {
            Log.d(DEBUG_TAG, "  metadata = null");
        } else {
            for (String key : md.keySet()) {
                Log.d(DEBUG_TAG, "  META " + key + " = " + describeMetadataValue(md, key));
            }
            MediaDescription d = md.getDescription();
            Log.d(DEBUG_TAG, "  desc.mediaId  = " + d.getMediaId());
            Log.d(DEBUG_TAG, "  desc.iconUri  = " + d.getIconUri());
            try {
                Log.d(DEBUG_TAG, "  desc.mediaUri = " + d.getMediaUri());
            } catch (Throwable ignored) {
            }
            dumpBundle("desc.extras", d.getExtras());
        }

        dumpBundle("controller.extras", controller.getExtras());

        PlaybackState ps = controller.getPlaybackState();
        if (ps == null) {
            Log.d(DEBUG_TAG, "  playbackState = null");
        } else {
            Log.d(DEBUG_TAG, "  state   = " + ps.getState());
            Log.d(DEBUG_TAG, "  actions = 0x" + Long.toHexString(ps.getActions()));
            dumpBundle("playbackState.extras", ps.getExtras());
        }

        List<MediaSession.QueueItem> queue = null;
        try {
            queue = controller.getQueue();
        } catch (Throwable ignored) {
        }
        if (queue == null || queue.isEmpty()) {
            Log.d(DEBUG_TAG, "  queue: empty");
        } else {
            for (MediaSession.QueueItem q : queue) {
                MediaDescription qd = q.getDescription();
                Log.d(DEBUG_TAG, "  queue mediaId=" + qd.getMediaId()
                        + " title=" + qd.getTitle()
                        + " iconUri=" + qd.getIconUri());
            }
        }
        Log.d(DEBUG_TAG, "  queueTitle = " + controller.getQueueTitle());

        dumpNotificationActions(context, controller);

        Log.d(DEBUG_TAG, "  >>> videoId candidate = " + findVideoId(controller));
        Log.d(DEBUG_TAG, "==================================================");
    }

    /**
     * True when the key may hold a CharSequence.
     *
     * MediaMetadata has no way to query a value's type without reading it,
     * and reading a Long, Bitmap or Rating as text makes the framework log a
     * ClassCastException warning. So the non-text keys are excluded by name:
     * the framework ones explicitly, plus the pixel-size and numeric keys
     * that apps such as YouTube add under their own namespace.
     */
    private static boolean isTextMetadataKey(String key) {
        if (key == null) {
            return false;
        }
        if (MediaMetadata.METADATA_KEY_ALBUM_ART.equals(key)
                || MediaMetadata.METADATA_KEY_ART.equals(key)
                || MediaMetadata.METADATA_KEY_DISPLAY_ICON.equals(key)
                || MediaMetadata.METADATA_KEY_USER_RATING.equals(key)
                || MediaMetadata.METADATA_KEY_RATING.equals(key)
                || MediaMetadata.METADATA_KEY_DURATION.equals(key)
                || MediaMetadata.METADATA_KEY_YEAR.equals(key)
                || MediaMetadata.METADATA_KEY_TRACK_NUMBER.equals(key)
                || MediaMetadata.METADATA_KEY_NUM_TRACKS.equals(key)
                || MediaMetadata.METADATA_KEY_DISC_NUMBER.equals(key)
                || MediaMetadata.METADATA_KEY_BT_FOLDER_TYPE.equals(key)) {
            return false;
        }
        return !key.endsWith("_PX") && !key.endsWith("_NUMBER");
    }

    private static String findVideoId(MediaController controller) {
        List<String> candidates = new ArrayList<>();

        MediaMetadata md = controller.getMetadata();
        if (md != null) {
            // Fast path: the ReVanced patch publishes the video id here.
            try {
                String mediaId = md.getString(MediaMetadata.METADATA_KEY_MEDIA_ID);
                if (mediaId != null && BARE_VIDEO_ID.matcher(mediaId).matches()) {
                    return mediaId;
                }
            } catch (Throwable ignored) {
            }

            // Fallback: scan the remaining text keys. Non-text keys are skipped
            // because getString() on them floods logcat with Bundle warnings.
            for (String key : md.keySet()) {
                if (!isTextMetadataKey(key)) {
                    continue;
                }
                try {
                    String s = md.getString(key);
                    if (s != null && !s.isEmpty()) {
                        candidates.add(s);
                    }
                } catch (Throwable ignored) {
                }
            }
            MediaDescription d = md.getDescription();
            if (d.getMediaId() != null) {
                candidates.add(d.getMediaId());
            }
            if (d.getIconUri() != null) {
                candidates.add(d.getIconUri().toString());
            }
            try {
                if (d.getMediaUri() != null) {
                    candidates.add(d.getMediaUri().toString());
                }
            } catch (Throwable ignored) {
            }
        }

        try {
            List<MediaSession.QueueItem> queue = controller.getQueue();
            if (queue != null) {
                for (MediaSession.QueueItem q : queue) {
                    MediaDescription qd = q.getDescription();
                    if (qd.getMediaId() != null) {
                        candidates.add(qd.getMediaId());
                    }
                    if (qd.getIconUri() != null) {
                        candidates.add(qd.getIconUri().toString());
                    }
                }
            }
        } catch (Throwable ignored) {
        }

        for (String s : candidates) {
            Matcher m = VIDEO_ID_IN_URL.matcher(s);
            if (m.find()) {
                return m.group(1);
            }
        }
        for (String s : candidates) {
            if (BARE_VIDEO_ID.matcher(s).matches()) {
                return s;
            }
        }
        return null;
    }

    private static String describeMetadataValue(MediaMetadata md, String key) {
        try {
            CharSequence text = md.getText(key);
            if (text != null) {
                return "Text: " + text;
            }
        } catch (Throwable ignored) {
        }
        try {
            Rating r = md.getRating(key);
            if (r != null) {
                return "Rating: style=" + r.getRatingStyle() + " rated=" + r.isRated();
            }
        } catch (Throwable ignored) {
        }
        try {
            Bitmap b = md.getBitmap(key);
            if (b != null) {
                return "Bitmap " + b.getWidth() + "x" + b.getHeight();
            }
        } catch (Throwable ignored) {
        }
        try {
            long l = md.getLong(key);
            if (l != 0L) {
                return "Long: " + l;
            }
        } catch (Throwable ignored) {
        }
        return "(empty)";
    }

    private static void dumpBundle(String label, Bundle b) {
        if (b == null) {
            Log.d(DEBUG_TAG, "  " + label + " = null");
            return;
        }
        try {
            Set<String> keys = b.keySet();
            if (keys.isEmpty()) {
                Log.d(DEBUG_TAG, "  " + label + " = empty");
                return;
            }
            for (String k : keys) {
                Log.d(DEBUG_TAG, "  " + label + "[" + k + "] = " + b.get(k));
            }
        } catch (Throwable e) {
            Log.w(DEBUG_TAG, "  " + label + " unreadable: " + e.getMessage());
        }
    }

    /**
     * Holds the like status of the video currently playing in YouTube.
     *
     * Deliberately not a cache: only the current video is tracked, and switching
     * to another one drops what was known. Persisting the status across tracks
     * would be guessing, because the launcher cannot see a like made before
     * playback started - YouTube does not expose it at load time.
     *
     * The status is fed from two sources:
     *
     *   - likes and unlikes made inside YouTube, which the patch reports through
     *     a sequence counter in the media metadata
     *   - ratings the launcher sends itself
     *
     * A third source, the YouTube Data API, plugs into {@link Fetcher} and will
     * supply the status of a video that was already liked when playback started.
     * Until then an unknown status is reported as not favorited, so the button
     * stays usable rather than greyed out.
     */
    public static final class YouTubeRevancedLikeState {

        private static final String TAG = "YouTubeRevancedLikeState";

        /** Resolves the like status of a video. Called on a background thread. */
        public interface Fetcher {
            /**
             * @return one of the MediaFavoriteController.FAVORITE_STATE_* values,
             *         or FAVORITE_STATE_UNKNOWN when the status cannot be told
             * @throws Exception on network or authentication failure
             */
            int fetchRating(String videoId) throws Exception;
        }

        /**
         * Replaceable on purpose. A lookup that never returns used to block
         * every later one behind it for the life of the process; when that is
         * detected the executor is abandoned and a fresh one takes over.
         */
        private static volatile ExecutorService executor = Executors.newSingleThreadExecutor();

        /** A lookup still running after this long is treated as lost. */
        private static final long FETCH_STUCK_AFTER_MS = 120000L;
        private static volatile long fetchStartedAtMs;
        private static volatile String inFlightVideoId;
        private static volatile long fetchSequence;

        private static volatile String currentVideoId;
        private static volatile int currentState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;

        private static volatile Fetcher fetcher;
        private static volatile KidsChecker kidsChecker;

        /**
         * Id of the video known to be made for kids, and the id most recently
         * asked about. Keeping both means the flag can never leak onto the
         * next video: it only applies while the two match.
         */
        private static volatile String madeForKidsVideoId;
        private static volatile String lastQueriedVideoId;
        private static volatile String fetchedVideoId;
        private static volatile Runnable onUpdated;
        private static volatile boolean fetchInFlight;

        /**
         * Backoff after a lookup that produced nothing usable, so a single
         * timeout cannot leave the status unresolved for good.
         */
        private static final long RETRY_BASE_DELAY_MS = 3000L;
        private static final long RETRY_MAX_DELAY_MS = 60000L;
        private static volatile String retryVideoId;
        private static volatile long retryNotBeforeMs;
        private static volatile int consecutiveFailures;

        private YouTubeRevancedLikeState() {
        }

        /** Reports whether a video is marked as made for kids. */
        public interface KidsChecker {
            Boolean isMadeForKids(String videoId);
        }

        public static void setKidsChecker(KidsChecker checker) {
            kidsChecker = checker;
        }

        public static void setFetcher(Fetcher newFetcher) {
            fetcher = newFetcher;
        }

        /**
         * Installs the callback fired after a status arrives, so the widget can be
         * redrawn. Runs on a background thread.
         */
        public static void setOnUpdated(Runnable callback) {
            onUpdated = callback;
        }

        public static boolean hasFetcher() {
            return fetcher != null;
        }

        /**
         * Returns the status of the given video. Anything not known is reported as
         * not favorited, which keeps the button usable.
         */
        public static int getState(String videoId) {
            lastQueriedVideoId = videoId;

            if (videoId == null || videoId.isEmpty()) {
                return unknownState();
            }

            if (!videoId.equals(currentVideoId)) {
                return unknownState();
            }

            // Videos made for kids never report a rating, so claiming anything
            // about them would be a guess. Reporting UNKNOWN greys the button
            // out, which is what stock YouTube does when it cannot rate.
            if (isCurrentMadeForKids() && !isKidsRatingAllowed()) {
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }

            return currentState == MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                    ? unknownState()
                    : currentState;
        }

        /**
         * What to report while nothing is known about the current video.
         *
         * With an account connected the answer is on its way, so UNKNOWN is
         * honest and the button greys out until it arrives. Without one no
         * answer is ever coming, and a permanently grey button would just look
         * broken - so it reads as not favorited and stays usable.
         */
        private static int unknownState() {
            return hasFetcher()
                    ? MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                    : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
        }

        /** Records the status of the given video, discarding any previous one. */
        public static void setState(String videoId, int state) {
            if (videoId == null || videoId.isEmpty()) {
                return;
            }
            currentVideoId = videoId;
            currentState = state;
        }

        /**
         * True once the status of the video being asked about is settled,
         * either by a lookup or by an action the user took.
         */
        public static boolean isCurrentStateResolved() {
            String videoId = lastQueriedVideoId;
            return videoId != null
                    && videoId.equals(currentVideoId)
                    && currentState != MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }

        public static boolean isCurrentMadeForKids() {
            String kidsId = madeForKidsVideoId;
            return kidsId != null && kidsId.equals(lastQueriedVideoId);
        }

        /** Forgets everything, e.g. when playback moves to another video. */
        public static void clear() {
            madeForKidsVideoId = null;
            currentVideoId = null;
            currentState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            fetchedVideoId = null;
            retryVideoId = null;
            retryNotBeforeMs = 0L;
            consecutiveFailures = 0;
        }

        /** True while a lookup is outstanding. Exposed for logging only. */
        public static boolean isFetchInFlight() {
            return fetchInFlight;
        }

        /** Every field the resolved state depends on, for one diagnostic line. */
        public static String describe() {
            synchronized (YouTubeRevancedLikeState.class) {
                long wait = retryNotBeforeMs - SystemClock.elapsedRealtime();
                return "current=" + currentVideoId
                        + " state=" + currentState
                        + " lastQueried=" + lastQueriedVideoId
                        + " fetched=" + fetchedVideoId
                        + " kids=" + madeForKidsVideoId
                        + " inFlight=" + fetchInFlight
                        + " inFlightFor=" + inFlightVideoId
                        + " retryFor=" + retryVideoId
                        + " retryIn=" + (wait > 0L ? wait : 0L)
                        + " failures=" + consecutiveFailures
                        + " fetcher=" + (fetcher != null);
            }
        }

        /**
         * Drops the backoff and any lookup believed to be stuck, so the next
         * read starts a request from scratch.
         *
         * The escape hatch for a status that has stopped moving on its own. It
         * deliberately does not clear the state already known for the current
         * video: the point is to ask again, not to blank a working button.
         */
        public static void forceRetry() {
            synchronized (YouTubeRevancedLikeState.class) {
                retryVideoId = null;
                retryNotBeforeMs = 0L;
                consecutiveFailures = 0;
                fetchedVideoId = null;
                if (fetchInFlight) {
                    recycleExecutor();
                }
            }
        }

        /**
         * @param onApplied run on the executor thread once the account has been
         *                  updated, so the caller can mirror the change locally
         */
        public static void applyRating(
                Context context, String videoId, boolean like, Runnable onApplied) {
            if (videoId == null || videoId.isEmpty()) {
                return;
            }

            Context appContext = context.getApplicationContext();
            executor.execute(() -> {
                boolean applied = FytRating.setRating(appContext, videoId, like);
                if (applied && onApplied != null) {
                    onApplied.run();
                }
                if (!applied) {
                    // The account was not updated, so the optimistic value is
                    // wrong; drop it and let the next lookup settle the state.
                    if (videoId.equals(currentVideoId)) {
                        currentState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
                    }
                    fetchedVideoId = null;
                }

                Runnable callback = onUpdated;
                if (callback != null) {
                    callback.run();
                }
            });
        }

        /**
         * Asks the Data API for the status of the given video. Does nothing until
         * a fetcher is installed, and never queues more than one request at a time
         * so the widget refresh loop cannot flood the API.
         *
         * A lookup that produces nothing usable now schedules another attempt
         * instead of simply giving up. Previously one unanswered request left
         * the status unresolved, and an unresolved status used to remove the
         * session from the picker - so this method was never reached again and
         * the button stayed grey for the rest of the launcher's life.
         */
        public static void requestRefresh(String videoId) {
            Fetcher currentFetcher = fetcher;
            if (currentFetcher == null || videoId == null || videoId.isEmpty()) {
                return;
            }

            final long fetchToken;
            final ExecutorService runOn;
            synchronized (YouTubeRevancedLikeState.class) {
                // Asked once per video. Without this the widget refresh loop
                // would fire a request several times per second.
                if (videoId.equals(fetchedVideoId)) {
                    return;
                }
                if (fetchInFlight) {
                    if (SystemClock.elapsedRealtime() - fetchStartedAtMs < FETCH_STUCK_AFTER_MS) {
                        return;
                    }
                    // The previous lookup never came back. Its thread cannot be
                    // recovered, but the queue behind it must not stay blocked
                    // for the rest of the process's life.
                    Log.w(TAG, "Lookup for " + inFlightVideoId
                            + " never finished; abandoning the executor");
                    recycleExecutor();
                }
                if (videoId.equals(retryVideoId)
                        && SystemClock.elapsedRealtime() < retryNotBeforeMs) {
                    // A previous attempt for this video came back empty; wait
                    // out the backoff rather than hammering the bridge.
                    return;
                }

                fetchInFlight = true;
                fetchStartedAtMs = SystemClock.elapsedRealtime();
                inFlightVideoId = videoId;
                fetchToken = ++fetchSequence;
                runOn = executor;
            }

            runOn.execute(() -> {
                int state = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
                Boolean madeForKids = null;
                try {
                    // The rating is asked for first so the kids question can be
                    // answered from that same reply, which halves the number of
                    // round trips through the bridge.
                    state = currentFetcher.fetchRating(videoId);

                    KidsChecker checker = kidsChecker;
                    if (checker != null) {
                        madeForKids = checker.isMadeForKids(videoId);
                    }
                } catch (Exception e) {
                    Log.w(TAG, "Failed to fetch rating for " + videoId, e);
                }

                boolean current;
                long retryInMs = 0L;
                synchronized (YouTubeRevancedLikeState.class) {
                    // A result from a lookup that was given up on must not touch
                    // anything: the state it describes has already been replaced.
                    current = fetchToken == fetchSequence;
                    if (!current) {
                        Log.w(TAG, "Late result for " + videoId + " discarded");
                    } else {
                        boolean resolved = false;

                        if (Boolean.TRUE.equals(madeForKids)) {
                            madeForKidsVideoId = videoId;
                            resolved = true;
                        } else if (madeForKids != null && videoId.equals(madeForKidsVideoId)) {
                            madeForKidsVideoId = null;
                        }

                        if (state != MediaFavoriteController.FAVORITE_STATE_UNKNOWN) {
                            setState(videoId, state);
                            resolved = true;
                        }

                        if (resolved) {
                            fetchedVideoId = videoId;
                            retryVideoId = null;
                            retryNotBeforeMs = 0L;
                            consecutiveFailures = 0;
                        } else {
                            if (!videoId.equals(retryVideoId)) {
                                consecutiveFailures = 0;
                            }
                            retryVideoId = videoId;
                            consecutiveFailures++;
                            int shift = Math.min(consecutiveFailures - 1, 4);
                            retryInMs = Math.min(
                                    RETRY_MAX_DELAY_MS, RETRY_BASE_DELAY_MS * (1L << shift));
                            retryNotBeforeMs = SystemClock.elapsedRealtime() + retryInMs;
                            fetchedVideoId = null;
                            Log.w(TAG, "Rating for " + videoId + " unresolved, attempt "
                                    + consecutiveFailures
                                    + ", retrying in " + retryInMs + " ms");
                        }

                        fetchInFlight = false;
                        inFlightVideoId = null;
                    }
                }

                if (!current) {
                    return;
                }
                if (retryInMs > 0L) {
                    scheduleRetry(retryInMs);
                }

                Runnable callback = onUpdated;
                if (callback != null) {
                    callback.run();
                }
            });
        }

        /**
         * Abandons the executor a lookup is stuck on and installs a new one.
         *
         * Called with the class monitor held. The old executor is interrupted
         * rather than waited for: a thread blocked in a broadcast round trip may
         * never return, and the point is to stop depending on it.
         */
        private static void recycleExecutor() {
            ExecutorService lost = executor;
            executor = Executors.newSingleThreadExecutor();
            fetchInFlight = false;
            inFlightVideoId = null;
            fetchedVideoId = null;
            fetchSequence++;
            try {
                lost.shutdownNow();
            } catch (Exception e) {
                Log.w(TAG, "Could not shut the stalled executor down", e);
            }
        }

        /**
         * Redraws the widget once the backoff has passed. The redraw is what
         * calls getCurrentFavoriteState again, which is what issues the next
         * request - so recovery does not depend on anything else ticking.
         */
        private static void scheduleRetry(long delayMs) {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Runnable callback = onUpdated;
                if (callback != null) {
                    callback.run();
                }
            }, delayMs + 250L);
        }
    }
}
