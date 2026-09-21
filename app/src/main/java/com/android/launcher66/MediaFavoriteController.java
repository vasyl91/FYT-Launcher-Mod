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

import com.android.launcher66.settings.AppListCacheDialogFragment;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.FytRating;
import com.android.launcher66.settings.SpotifyRating;
import com.fyt.car.MusicService;
import com.syu.widget.DateMusicProvider;
import com.syu.widget.Widget;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    /**
     * How long the answer below is reused before the bridge state is consulted
     * again. It only changes when the user signs in or grants access, so half a
     * second of lag is nothing; what it saves is a package manager round trip
     * per call, several times per draw.
     */
    private static final long OAUTH_ANSWER_MAX_AGE_MS = 500L;
    private static volatile boolean oauthAnswer;
    private static volatile long oauthAnswerAtMs;

    /**
     * True once the user has granted access to the YouTube Data API.
     *
     * Asked from the rules that decide whether the button is greyed out, which
     * run on the main thread on every draw and several times over, so the
     * answer is held for a moment rather than looked up again each time.
     * FytRating still hears from this often enough to keep refreshing its own
     * state in the background.
     */
    private static boolean isLoggedOAuth() {
        long now = SystemClock.elapsedRealtime();
        if (oauthAnswerAtMs != 0L && now - oauthAnswerAtMs < OAUTH_ANSWER_MAX_AGE_MS) {
            return oauthAnswer;
        }
        boolean answer = FytRating.isLoggedIn(LauncherApplication.sApp);
        oauthAnswer = answer;
        oauthAnswerAtMs = now;
        return answer;
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

    /**
     * The video the last usable like status was published for.
     *
     * Kept so the first publication for a video can be told apart from the
     * ones after it, which is the only thing that distinguishes what YouTube
     * loaded the video with from what the user then did to it.
     */
    private static volatile String lastLikeStatusVideoId;

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
        //
        // Handled here instead, and only ever in the launcher's own cache:
        // the stock player has no session to send anything to. See
        // toggleStockFavorite.
        if (isStockMusicSource(preferredPackage)) {
            return toggleStockFavorite(context);
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
                    + " " + describeFavoriteCache(controller.getPackageName())
                    + " | " + YouTubeRevancedLikeState.describe());
            return false;
        }

        int stateBefore = getCurrentFavoriteState(context, preferredPackage);
        int expected = getExpectedStateAfterToggle(stateBefore);

        // The Data API is the only write that reaches the account, so it is
        // used on its own here. Sending the rating over the media session as
        // well would make YouTube fire its own request, which lands after
        // ours and stores the rating where the API cannot see it.
        //
        // The cache being usable means the opposite is true: the player is on
        // the cache list and no account is signed in - isFavoriteCacheUsable
        // refuses otherwise - so there is nothing to write to and the session
        // rating plus the cache is all this press can amount to.
        if (isYouTubePackage(controller.getPackageName())
                && YouTubeRevancedLikeState.hasFetcher()
                && !isFavoriteCacheUsable(controller.getPackageName())) {
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

        if (isSpotifyPackage(controller.getPackageName())) {
            String libraryUri = findSpotifyLibraryUri(controller);
            noteSpotifyLibraryUri(libraryUri);

            if (isSpotifyLinked() && libraryUri != null) {
                // The session rating is deliberately not sent alongside.
                // Spotify answers its own favorite action by calling the very
                // endpoint we just called, so the two writes would cancel out
                // - the second toggling back what the first one set.
                SpotifyRating.applyRating(
                        context,
                        libraryUri,
                        expected == FAVORITE_STATE_FAVORITED,
                        () -> refreshWidget(context));
                return true;
            }

            // Nothing is sent to the session instead, and this is the whole
            // reason the branch is written this way.
            //
            // Spotify answers a session rating by toggling the like. A press
            // that falls through from here therefore un-likes the song the
            // user was trying to like - silently, and irreversibly as far as
            // the widget is concerned, because the same press then reports
            // success. Refusing is the only safe outcome, and the line below
            // names which precondition failed rather than leaving it to be
            // guessed at.
            Log.w(TAG, "Spotify press refused: uri=" + libraryUri
                    + " linked=" + isSpotifyLinked()
                    + " | " + SpotifyRating.describe());
            return false;
        }

        boolean sent = toggleFavorite(context, controller, toPrivateState(stateBefore));
        if (sent) {
            if (isYouTubePackage(controller.getPackageName())) {
                // No account connected: the session rating is all there is, and
                // it only updates YouTube's own interface. The status is kept
                // here and, when this build is on the cache list, written to
                // the cache - the only copy that survives the track changing.
                String videoId = findVideoId(controller);
                YouTubeRevancedLikeState.setState(videoId, expected);
                cacheYouTubeFavoriteState(
                        context, controller.getPackageName(), videoId, expected);
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
        //
        // What it answers comes from the cache alone, and only with
        // com.syu.music on the cache list - see getStockFavoriteState.
        if (isStockMusicSource(preferredPackage)) {
            return getStockFavoriteState(context);
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
            String packageName = controller.getPackageName();
            String videoId = findVideoId(controller);

            // The session is already in hand here, so this is where the id the
            // greying rule reads comes from; it costs nothing extra. The build
            // goes with it: the cache list is per player, and the rules asked
            // about a video rather than a session need to know which one it is.
            noteRevancedVideoId(packageName, videoId);

            // Read before anything else has a chance to fill the status in.
            // What the launcher recorded itself is worth more than the status
            // YouTube publishes as a video loads, which is a statement about a
            // video it has only just opened.
            if (isFavoriteCacheUsable(packageName)
                    && YouTubeRevancedLikeState.getResolvedState(videoId)
                            == FAVORITE_STATE_UNKNOWN) {
                int cached = getCachedYouTubeFavoriteState(context, packageName, videoId);
                if (cached != FAVORITE_STATE_UNKNOWN) {
                    // Marked as coming from the cache, so it stops counting the
                    // moment the cache stops being usable - an account signed
                    // in while this video is still playing included.
                    YouTubeRevancedLikeState.setCachedState(videoId, cached);
                }
            }

            // The published USER_RATING is never consulted here. A rating sent
            // by the launcher takes a different path inside YouTube than a tap
            // in its own UI, so that value stays stale until the next track and
            // would undo what the user just did. The status is tracked for the
            // current video only and starts over whenever playback moves on.
            applyInAppLikeEvent(context, controller, videoId);

            ensureRatingFetcher(context);
            YouTubeRevancedLikeState.requestRefresh(videoId);

            // Made for kids while the switch keeps those unrated: the button is
            // greyed out and nothing below - neither a resolved status nor the
            // cache - may put a state back on it.
            if (isKidsRatingBlocked(videoId)) {
                // A deliberate refusal is not a stall. Left to the watchdog it
                // would read as a bridge that had stopped answering, and every
                // few minutes it would start rebuilding one that is fine.
                clearStallState();
                return FAVORITE_STATE_UNKNOWN;
            }

            // Nothing here can produce a status: no account to ask, and this
            // build not on the cache list. Reported as unknown so the state the
            // widget draws says the same thing the disabled button does -
            // including for a status left in memory from before the build was
            // taken off the list, which would otherwise keep showing on a dead
            // button until the track changed.
            //
            // "No account" is the wide question here, isFytAccountPresent():
            // while fYT Rating is only momentarily unsure of an account it had
            // confirmed, an answer is on its way, and the stall watchdog has to
            // keep counting instead of being cleared on every draw.
            if (isRevancedFavoriteDisabled(packageName, videoId) && !isFytAccountPresent()) {
                clearStallState();
                return FAVORITE_STATE_UNKNOWN;
            }

            // Kept only for a build on the cache list, and never while an
            // account is signed in.
            if (isFavoriteCacheUsable(packageName)) {
                int known = YouTubeRevancedLikeState.getResolvedState(videoId);
                if (known != FAVORITE_STATE_UNKNOWN) {
                    cacheYouTubeFavoriteState(context, packageName, videoId, known);
                }
            }

            int resolved = YouTubeRevancedLikeState.getState(videoId);
            noteYouTubeState(videoId, resolved);
            return resolved;
        }

        if (isSpotifyPackage(controller.getPackageName())) {
            String libraryUri = findSpotifyLibraryUri(controller);

            // Recorded on every read, including a null, because the greying
            // rule reads it back and has to know a lookup ran at all.
            noteSpotifyLibraryUri(libraryUri);

            if (isSpotifyLinked() && libraryUri != null) {
                ensureSpotifyUpdater(context);

                // Never blocks: answers from the last lookup and refreshes
                // behind itself, the contract YouTubeRevancedLikeState offers
                // for ReVanced. UNKNOWN here means "not resolved yet", which
                // the widget draws as a plain outline.
                int spotifyState = SpotifyRating.getState(context, libraryUri);
                if (spotifyState != FAVORITE_STATE_UNKNOWN) {
                    cachePublicFavoriteState(context, controller, spotifyState);
                    return spotifyState;
                }
                return getCachedPublicFavoriteState(context, controller);
            }

            // No account, or nothing in the catalogue to ask about: fall
            // through to the session, which is what this did before.
        }

        int currentState = toPublicState(getFavoriteState(controller, actions));
        if (currentState != FAVORITE_STATE_UNKNOWN) {
            cachePublicFavoriteState(context, controller, currentState);
            return currentState;
        }

        return getCachedPublicFavoriteState(context, controller);
    }

    /**
     * Whether the favorite button has to be drawn greyed out and refuse presses.
     *
     * The rules are ordered, and the first one that applies decides. Both
     * settings are read here and in {@link #isRevancedFavoriteDisabled},
     * which the read path shares so the two cannot drift apart:
     *
     *   - Keys.YOUTUBE_REVANCED_KIDS off greys the button on a video the bridge
     *     reported as made for kids, and nothing further down may undo that.
     *   - The per-app cache list (AppListCacheDialogFragment) decides ReVanced
     *     only where there is no account to ask, and stock YouTube and the
     *     stock player (com.syu.music) always, since none of them has a rating
     *     the launcher can read off a session. A signed-in account outranks
     *     the list; see isFavoriteCacheUsable.
     */
    public static boolean isFavoriteTemporarilyDisabledPackage(String packageName) {
        // The stock player exposes no rating of any kind, so the only thing the
        // button can act on is the launcher's own cache: greyed out and refusing
        // presses unless com.syu.music is on the cache list and its track can be
        // identified. Checked first, because every rule below is about a media
        // session and it has none.
        if (isStockMusicSource(packageName)) {
            return !isStockFavoriteAvailable();
        }

        if (isYouTubePackage(packageName)) {
            // Read off the session rather than taken from the last state
            // lookup. The id that lookup leaves behind belongs to whichever
            // video was asked about last, so on this path - which the widget
            // reaches without having read a state first, and always does right
            // after a track change - it was routinely the previous video. The
            // made for kids flag was then compared against the wrong id, came
            // back false, and the button was drawn enabled on a video the
            // switch was supposed to grey out.
            return isRevancedFavoriteDisabled(packageName, currentRevancedVideoId());
        }

        if (YOUTUBE_PACKAGE.equals(packageName)) {
            // Stock YouTube publishes nothing the launcher can read a rating
            // from and there is no patch to ask, so its status only ever comes
            // out of the cache - and only once the user has put it on the
            // list. No account can take it over, so the list alone decides.
            return !isFavoriteCacheUsable(packageName);
        }

        if (SPOTIFY_PACKAGE.equals(packageName)) {
            if (!isSpotifyLinked()) {
                // No account: back to whatever the session exposes, which is
                // the behaviour that was there before any of this.
                return false;
            }

            // Greyed only on a lookup that ran recently and positively found
            // nothing in the catalogue - an advert, or a local file. Podcast
            // episodes and audiobooks are saveable and stay lit.
            //
            // Not knowing is not a refusal, and the two are not worth the same
            // here: a button wrongly greyed does nothing and explains nothing,
            // while one wrongly lit costs a single refused press and a line in
            // the log.
            return isSpotifyUriFresh() && spotifyLibraryUri == null;
        }

        return false;
    }

    /**
     * The same rule for a video already in hand.
     *
     * Kept apart so the read path can ask it about the video it is holding,
     * without another session lookup and without the two drifting: the state
     * the widget draws from and the rule that greys the button have to agree,
     * or the button ends up lit with nothing behind it.
     */
    private static boolean isRevancedFavoriteDisabled(String packageName, String videoId) {
        boolean madeForKids = YouTubeRevancedLikeState.isMadeForKids(videoId);

        // Videos made for kids expose no rating at all: YouTube reports "none"
        // however they were rated. Whether that greys the button or shows them
        // as unrated is the switch's decision, and it is taken before anything
        // else so no later rule can override it.
        if (madeForKids && !isKidsRatingAllowed()) {
            pokeRevanced();
            return true;
        }

        if (isLoggedOAuth()) {
            // The account is the only truth about a like, and the status
            // arrives a moment after the track starts. Until it does the button
            // is disabled: an enabled one would send a rating derived from a
            // state nobody has confirmed yet. This is meant to be visible - a
            // greyed out button is how the launcher says it has not heard back
            // from the bridge yet - so nothing here should stand in for the
            // answer to make it light up sooner.
            //
            // Videos made for kids are the exception, and the switch has just
            // said they are wanted. Their status never resolves, so this rule
            // would hold the button grey for good and take the decision back
            // off the switch that had made it.
            if (madeForKids || YouTubeRevancedLikeState.isStateResolved(videoId)) {
                return false;
            }
            pokeRevanced();
            return true;
        }

        // A status resolved for this very video means the bridge answered a
        // request for it moments ago. That is direct evidence, and it outranks
        // the permission flag - which is what goes stale. Without this, one
        // wrong refusal kept the button dead even while the lookups behind it
        // were succeeding.
        //
        // A status seeded from the cache counts here only while the cache is
        // still usable for this build; see YouTubeRevancedLikeState.setCachedState.
        if (YouTubeRevancedLikeState.hasFetcher()
                && YouTubeRevancedLikeState.isStateResolved(videoId)) {
            return false;
        }

        // fYT Rating missing, signed out or not granted access: the cache is
        // the only place a status could come from, so the cache list decides
        // whether the button does anything at all.
        if (isFavoriteCacheUsable(packageName)) {
            return false;
        }

        // Shut - and not always for want of a tick on the list. The cache also
        // stays shut while fYT Rating holds an account it is only momentarily
        // unsure of (see isFytAccountPresent). An answer is on its way then,
        // exactly as in the signed-in branch above, so the lookup is kept
        // running the same way instead of waiting on a button nobody can press.
        if (isFytAccountPresent()) {
            pokeRevanced();
        }
        return true;
    }

    /**
     * Whether the switch keeps this video unrated.
     *
     * Only ever true for a video the bridge reported as made for kids, so an
     * off switch has no effect on anything else.
     */
    private static boolean isKidsRatingBlocked(String videoId) {
        return YouTubeRevancedLikeState.isMadeForKids(videoId) && !isKidsRatingAllowed();
    }

    /** How long a resolved video id is reused before the session is asked again. */
    private static final long REVANCED_VIDEO_ID_MAX_AGE_MS = 1000L;
    private static volatile String revancedVideoId;
    private static volatile long revancedVideoIdAtMs;

    /**
     * The ReVanced build the id above was read from.
     *
     * Needed since the cache list is per player: the rules asked about a video
     * rather than a session - the greying rule and the like state holder's
     * fallback - have to know whose list entry applies. Not aged like the id,
     * because it only changes when the user moves between the two builds.
     */
    private static volatile String revancedPackage;

    /** Records a video id resolved by a caller that had the session in hand. */
    private static void noteRevancedVideoId(String packageName, String videoId) {
        if (isYouTubePackage(packageName)) {
            revancedPackage = packageName;
        }
        if (videoId == null || videoId.isEmpty()) {
            return;
        }
        revancedVideoId = videoId;
        revancedVideoIdAtMs = SystemClock.elapsedRealtime();
    }

    /**
     * The ReVanced build playing right now, as last seen with its session in
     * hand. Falls back to the YouTube build, which is what every rule assumed
     * before the cache became per player.
     */
    private static String currentRevancedPackage() {
        String known = revancedPackage;
        return known != null ? known : YOUTUBE_REVANCED_PACKAGE;
    }

    /**
     * The video ReVanced is playing right now.
     *
     * Answered from what the read path last resolved, which is a moment old at
     * worst: the widget reads the state on every draw and on every metadata
     * change, and that is where the id comes from.
     *
     * Reading it here from the session instead would put two binder round trips
     * - the session list, and the queue behind findVideoId, which reaches into
     * the YouTube process - on a rule the widget asks several times per draw,
     * on the main thread. That is not a cost this rule can carry.
     *
     * Falls back to the id of the last state lookup when the session cannot be
     * read at all, which is the one case where there is nothing better to go on.
     */
    private static String currentRevancedVideoId() {
        long now = SystemClock.elapsedRealtime();
        if (revancedVideoIdAtMs != 0L
                && now - revancedVideoIdAtMs < REVANCED_VIDEO_ID_MAX_AGE_MS) {
            String remembered = revancedVideoId;
            return remembered != null
                    ? remembered
                    : YouTubeRevancedLikeState.getLastQueriedVideoId();
        }

        String videoId = null;
        String packageName = null;
        try {
            MediaController controller = findRevancedController(LauncherApplication.sApp);
            if (controller != null) {
                packageName = controller.getPackageName();
                videoId = findVideoId(controller);
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not read the video id from the ReVanced session", e);
        }

        if (videoId != null && !videoId.isEmpty()) {
            noteRevancedVideoId(packageName, videoId);
            return videoId;
        }

        // Remembered as well, so a session that cannot answer is not asked
        // again on the next draw either.
        revancedVideoId = null;
        revancedVideoIdAtMs = now;
        return YouTubeRevancedLikeState.getLastQueriedVideoId();
    }

    /**
     * The Spotify URI the read path last resolved - a track, a podcast episode
     * or an audiobook chapter, whatever is playing.
     *
     * Two pieces of state rather than one, because the greying rule has to
     * tell "nothing in the catalogue is playing" apart from "no lookup has run
     * lately". Collapsing both into a null uri greys the button on ordinary
     * tracks: the rule is reached on draws where no state lookup has run, so
     * the uri is routinely absent for reasons that say nothing about what is
     * playing.
     */
    private static final long SPOTIFY_URI_MAX_AGE_MS = 2000L;
    private static volatile String spotifyLibraryUri;
    private static volatile long spotifyUriAtMs;

    /** Installed once, so a lookup landing off-tick still redraws the widget. */
    private static volatile boolean spotifyUpdaterInstalled;

    private static void noteSpotifyLibraryUri(String libraryUri) {
        spotifyLibraryUri = libraryUri;
        spotifyUriAtMs = SystemClock.elapsedRealtime();
    }

    /** Whether a state lookup ran recently enough for its uri to be believed. */
    private static boolean isSpotifyUriFresh() {
        return spotifyUriAtMs != 0L
                && SystemClock.elapsedRealtime() - spotifyUriAtMs
                        < SPOTIFY_URI_MAX_AGE_MS;
    }

    private static boolean isSpotifyPackage(String packageName) {
        return SPOTIFY_PACKAGE.equals(packageName);
    }

    /**
     * Whether the Web API can answer for Spotify right now.
     *
     * Both halves matter. A refresh token on file is not the same as a grant
     * the server still honours, and SpotifyRating expires its own refusal
     * rather than latching it, so asking again here costs nothing.
     */
    private static boolean isSpotifyLinked() {
        return SpotifyRating.isLoggedIn(LauncherApplication.sApp)
                && !SpotifyRating.isAuthBroken();
    }

    /**
     * Connects the Spotify state holder to the widget. Cheap and idempotent,
     * so it can be called from the read path.
     */
    private static void ensureSpotifyUpdater(Context context) {
        if (spotifyUpdaterInstalled) {
            return;
        }
        spotifyUpdaterInstalled = true;

        Log.d(TAG, "Installing the Spotify widget updater");

        Context appContext = context.getApplicationContext();
        // SpotifyRating already posts this to the main thread.
        SpotifyRating.setOnUpdated(() -> Widget.widgetUpdate(appContext, DateMusicProvider.class));
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
        if (isYouTubePackage(packageName)) {
            // The session is kept whenever anything could ever produce a status
            // for it - an account or the cache - and whatever the bridge
            // currently says about permissions.
            //
            // Hiding it used to be conditional on a cached "not allowed", and
            // that removed three things at once: the click, the state read and
            // the watchdog. Since the cached answer is itself the thing most
            // likely to be stale, a single wrong "no" left a button that could
            // not be pressed, could not be refreshed, and could not report that
            // anything was wrong - curable only by restarting the launcher,
            // which is exactly what cleared the cached answer.
            //
            // Asked first and unconditionally, because it is what starts a
            // stale status being rechecked in the background -
            // isFytAccountPresent() opens with isLoggedOAuth() for exactly that
            // reason. It is the wide question on purpose: it also keeps the
            // session through the moments fYT Rating is only unsure of an
            // account it had confirmed, when hiding it would take the click,
            // the state read and the watchdog away all over again.
            if (isFytAccountPresent()) {
                return false;
            }
            return !isFavoriteCacheUsable(packageName);
        }

        if (YOUTUBE_PACKAGE.equals(packageName)) {
            // Nothing to read a rating from and no patch to ask, so without it
            // on the cache list there is no status for it anywhere.
            return !isFavoriteCacheUsable(packageName);
        }

        return false;
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
        String revancedSessionPackage = null;

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
                    if (isYouTubePackage(controller.getPackageName())) {
                        revancedPresent = true;
                        if (revancedSessionPackage == null) {
                            revancedSessionPackage = controller.getPackageName();
                        }
                    }
                }
            }
        } catch (Exception e) {
            sessions.append("unreadable: ").append(e);
        }

        // The rules are asked about the build that is actually there: the
        // cache list is per player, so the two builds can answer differently.
        String diagnosed = isYouTubePackage(preferredPackage) ? preferredPackage
                : revancedSessionPackage != null ? revancedSessionPackage
                : currentRevancedPackage();

        String line = "ReVanced " + reason
                + "; preferred=" + preferredPackage
                + " revancedSession=" + revancedPresent
                + " listener=" + (NotificationListener.getInstance() != null)
                + " sessions=[" + sessions.toString().trim() + "]"
                + " diagnosed=" + diagnosed
                + " unsupported=" + isUnsupportedFavoritePackage(diagnosed)
                + " disabled=" + isFavoriteTemporarilyDisabledPackage(diagnosed)
                + " " + describeFavoriteCache(diagnosed)
                + " statusKnown=" + FytRating.isStatusKnown()
                + " signedIn=" + FytRating.isSignedIn()
                + " allowed=" + FytRating.isAllowed()
                + " | " + YouTubeRevancedLikeState.describe();

        // A lookup still running is the ordinary case after a track change and
        // reads as a fault at warning level. What deserves one is a status that
        // is unresolved with nothing on its way to resolve it.
        if (YouTubeRevancedLikeState.isFetchInFlight()) {
            Log.d(TAG, line);
        } else {
            Log.w(TAG, line);
        }
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
        return isYouTubePackage(preferredPackage)
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
                if (controller != null && isYouTubePackage(controller.getPackageName())) {
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
            noteRevancedVideoId(controller.getPackageName(), videoId);

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
            clearStallState();
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

    /**
     * Forgets a stall in progress.
     *
     * Also used where the status is deliberately left unresolved - a video made
     * for kids while the switch keeps those unrated - so the watchdog cannot
     * read a settled refusal as a bridge that has stopped answering and start
     * rebuilding a perfectly healthy one every few minutes.
     */
    private static void clearStallState() {
        stallVideoId = null;
        stallSinceMs = 0L;
        recoveryAttempts = 0;
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

    // =====================================================================================
    // Stock player (com.syu.music): the launcher's cache is all there is
    // =====================================================================================

    /**
     * Whether the favorite button can do anything for the stock player.
     *
     * Only through the cache, and the cache is opt-in: with com.syu.music off the
     * list the button stays greyed out and refuses presses, as it always did. On
     * the list it works whenever the track can be identified. Asks exactly what
     * getStockFavoriteState asks, so the drawn state and the greyed button agree.
     */
    private static boolean isStockFavoriteAvailable() {
        return isFavoriteCacheUsable(STOCK_MUSIC_PACKAGE) && currentStockTrackKey() != null;
    }

    /** The state kept for the stock player's track; unknown whenever unavailable. */
    private static int getStockFavoriteState(Context context) {
        if (context == null || !isFavoriteCacheUsable(STOCK_MUSIC_PACKAGE)) {
            return FAVORITE_STATE_UNKNOWN;
        }
        String key = currentStockTrackKey();
        return key == null ? FAVORITE_STATE_UNKNOWN : readStockFavoriteState(context, key);
    }

    /**
     * A press while the stock player is the source: flips the kept state, and
     * nothing else - there is no player to tell.
     */
    private static boolean toggleStockFavorite(Context context) {
        if (context == null || !isFavoriteCacheUsable(STOCK_MUSIC_PACKAGE)) {
            Log.d(TAG, "Press ignored: the stock player is not on the cache list");
            return false;
        }
        String key = currentStockTrackKey();
        if (key == null) {
            Log.d(TAG, "Press ignored: the stock track is not identified yet");
            return false;
        }

        int expected = getExpectedStateAfterToggle(readStockFavoriteState(context, key));

        // Written here rather than through writeFavoriteCache. The cache is the
        // only copy of this state and the redraw after the press reads it at once:
        // apply() updates the in-memory map before it returns, while the executor
        // would leave that redraw a moment in which it still sees the old state.
        //
        // Un-favoriting removes the entry, since a missing one already reads as
        // not favorited; the file only ever holds the tracks that are liked.
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .edit();
        if (expected == FAVORITE_STATE_FAVORITED) {
            editor.putInt(key, expected);
        } else {
            editor.remove(key);
        }
        editor.apply();

        refreshWidget(context);
        return true;
    }

    /**
     * Nothing kept means never liked. No other source could know better, so it
     * reads as not favorited and the button stays usable - the first press is what
     * puts a state in the cache, as for ReVanced without an account.
     */
    private static int readStockFavoriteState(Context context, String key) {
        int stored = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getInt(key, FAVORITE_STATE_UNKNOWN);
        return stored == FAVORITE_STATE_UNKNOWN ? FAVORITE_STATE_NOT_FAVORITED : stored;
    }

    /** How long a new stock track identity has to hold before it is trusted. */
    private static final long STOCK_KEY_SETTLE_MS = 1500L;

    /** The identity last seen, its key, and when it first appeared - swapped as one. */
    private static final class StockKey {
        final String identity;
        final String key;
        final long firstSeenAtMs;

        StockKey(String identity, String key, long firstSeenAtMs) {
            this.identity = identity;
            this.key = key;
            this.firstSeenAtMs = firstSeenAtMs;
        }
    }

    private static volatile StockKey stockKey;

    /**
     * The cache key of the stock player's current track, or null while it cannot
     * be trusted yet.
     *
     * A new identity counts only once it has held for STOCK_KEY_SETTLE_MS. The
     * player reports a track change as a run of updates, and the first of them may
     * still carry a field of the previous track, or no duration yet; a press landing
     * in that moment would be stored under a key that is gone a second later. The
     * button greys for the moment instead, the way it does for ReVanced while a
     * lookup is on its way. Keep the window above the player's update interval.
     */
    private static String currentStockTrackKey() {
        String identity = currentStockIdentity();
        if (identity == null) {
            return null;
        }

        long now = SystemClock.elapsedRealtime();
        StockKey known = stockKey;
        if (known == null || !identity.equals(known.identity)) {
            stockKey = new StockKey(identity, stockCacheKey(identity), now);
            // Settling needs one more redraw, and a paused player sends nothing
            // that would cause one, so it is booked here - once per new identity.
            new Handler(Looper.getMainLooper()).postDelayed(
                    () -> refreshWidget(LauncherApplication.sApp), STOCK_KEY_SETTLE_MS + 50L);
            return null;
        }
        return now - known.firstSeenAtMs < STOCK_KEY_SETTLE_MS ? null : known.key;
    }

    /**
     * What identifies the stock player's track, before hashing; null while the
     * player has not reported enough to tell.
     *
     * com.syu.music publishes no media session and no id, so the identity is put
     * together from what it reports to MusicService:
     *
     *   - title, artist and duration while the title is a real tag;
     *   - file name and duration otherwise. Only the name: the directory in front
     *     of it is the mount point, which changes from one boot or USB port to the
     *     next, while the name stays.
     *
     * Read from MusicService rather than NotificationListener: its fields are
     * written synchronously by every update the player sends - paused and
     * untagged tracks included, which MusicService never forwards to the
     * listener - and they do not vanish with a listener the system has unbound.
     *
     * The stock player mangles letters outside its own encoding (see
     * NotificationListener.readFytMeta), so the title may be garbage: the same
     * garbage every time for the same file, which is all an identity needs.
     */
    private static String currentStockIdentity() {
        // In whatever unit the player reports it; only equality matters here.
        long duration = MusicService.TOTALMINUTES;
        if (duration <= 0L) {
            return null;
        }

        StringBuilder identity = new StringBuilder(128);
        String title = MusicService.music_name;
        if (isRealStockTitle(title)) {
            identity.append("tag");
            appendIdentityPart(identity, normalize(title));
            appendIdentityPart(identity, normalize(MusicService.author_name));
        } else {
            String fileName = fileNameOf(MusicService.music_path);
            if (fileName == null) {
                return null;
            }
            identity.append("file");
            appendIdentityPart(identity, normalize(fileName));
        }
        identity.append('|').append(duration);
        return identity.toString();
    }

    /** The test NotificationListener applies before it trusts a stock title. */
    private static boolean isRealStockTitle(String title) {
        if (isEmpty(title)) {
            return false;
        }
        String lower = title.toLowerCase(Locale.US);
        return !lower.contains("unknown") && !lower.contains("null");
    }

    /** The last path segment: the part of a stock path that survives a remount. */
    private static String fileNameOf(String path) {
        if (isEmpty(path)) {
            return null;
        }
        String trimmed = path.trim();
        String name = trimmed.substring(trimmed.lastIndexOf('/') + 1);
        return name.isEmpty() ? null : name;
    }

    /** Length-prefixed, so no title or artist can run into the next part. */
    private static void appendIdentityPart(StringBuilder out, String part) {
        out.append('|').append(part.length()).append(':').append(part);
    }

    /**
     * The identity hashed into a cache key.
     *
     * Never the raw text: a mangled title can hold characters that are not valid
     * in the XML file SharedPreferences writes, and a single one of them would
     * make the whole file unreadable - every kept favorite with it. A hash also
     * keeps the key short, whatever the title.
     */
    private static String stockCacheKey(String identity) {
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                    .digest(identity.getBytes(StandardCharsets.UTF_8));
            StringBuilder key = new StringBuilder(PREF_PREFIX.length()
                    + STOCK_MUSIC_PACKAGE.length() + 1 + hash.length * 2);
            key.append(PREF_PREFIX).append(STOCK_MUSIC_PACKAGE).append(':');
            for (byte b : hash) {
                key.append(Character.forDigit((b >> 4) & 0xF, 16))
                        .append(Character.forDigit(b & 0xF, 16));
            }
            return key.toString();
        } catch (NoSuchAlgorithmException e) {
            // Every Android runtime has SHA-256; without it there is no key to trust.
            Log.w(TAG, "No SHA-256; the stock player's favorite stays unavailable", e);
            return null;
        }
    }

    /**
     * Players whose session is worth keeping even when it advertises no rating
     * capability at this instant.
     *
     * For Spotify the entry no longer means the session exposes an action to
     * send. It means the launcher has another way to rate what is playing -
     * the Web API - and needs the session only for the track id. Dropping it
     * from here would hide the session from the picker, and the read path
     * would then never run: the same failure isUnsupportedFavoritePackage
     * describes for ReVanced, reached by a different route.
     */
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
    /**
     * What the extension's like status number means.
     *
     * Written out because these numbers are not the launcher's own: 0 here is
     * "not rated", while 0 in a state is "unknown". Two scales sharing digits
     * in the same log is a way to read it wrong.
     */
    private static String describeLikeStatus(long status) {
        if (status == -1L) {
            return "cleared";
        }
        if (status == 0L) {
            return "none";
        }
        if (status == 1L) {
            return "like";
        }
        if (status == 2L) {
            return "dislike";
        }
        return "unrecognised";
    }

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

    private static void applyInAppLikeEvent(
            Context context, MediaController controller, String videoId) {
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
        // up instead, and until it arrives the button stays disabled. It is
        // also not the publication the baseline below is waiting for.
        long status = readCustomLong(metadata, KEY_LIKE_STATUS);
        if (status < 0L) {
            Log.d(TAG, "Like status cleared for " + videoId + ", waiting for the API");
            return;
        }

        boolean firstForVideo = !videoId.equals(lastLikeStatusVideoId);
        lastLikeStatusVideoId = videoId;

        int state = status == 1L ? FAVORITE_STATE_FAVORITED : FAVORITE_STATE_NOT_FAVORITED;

        // The first status published for a video is the one YouTube loaded it
        // with, and it arrives with a bumped sequence exactly like a tap does -
        // there is nothing in it that says which of the two it was.
        //
        // Where it says "liked" that does not matter: nothing else invents a
        // like, so it can only be true. Anything else cannot be acted on. A
        // video whose rating YouTube has not resolved yet publishes the same 0
        // as one the user has genuinely never rated, and taking that at face
        // value overwrites the like the Data API is in the middle of
        // confirming - which is how a liked video came to be shown as unrated a
        // second after it started playing, and how that same 0 then reached the
        // cache.
        //
        // Nothing stands in for it in the meantime. A status the bridge has not
        // confirmed leaves the button greyed out, deliberately, and a guess put
        // there to fill the gap would take that decision away.
        if (firstForVideo && state != FAVORITE_STATE_FAVORITED) {
            Log.d(TAG, "First like status for " + videoId + " is "
                    + describeLikeStatus(status)
                    + " (event #" + seq + "); kept as a baseline, not applied,"
                    + " the lookup decides");
            return;
        }

        Log.d(TAG, "In-app like event #" + seq
                + ": status=" + describeLikeStatus(status)
                + " -> " + describePublicState(state)
                + " for " + videoId
                + (firstForVideo ? " (first published for it)" : ""));
        YouTubeRevancedLikeState.setState(videoId, state);

        // A like made inside YouTube is a status like any other, so it is kept
        // wherever the current one is kept. Without an account that is the
        // cache, and only for a build on the cache list.
        cacheYouTubeFavoriteState(context, controller.getPackageName(), videoId, state);
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
        return preference(Keys.YOUTUBE_REVANCED_KIDS);
    }

    /**
     * Whether the user put this player on the cache list in
     * {@link AppListCacheDialogFragment}.
     *
     * The opt-in alone, and what replaced the old global switch: nothing is
     * cached for a player that is not on the list. Whether the cache may be
     * used right now is {@link #isFavoriteCacheUsable}, which puts the account
     * block on top of this.
     */
    private static boolean isFavoriteCacheSelected(String packageName) {
        return AppListCacheDialogFragment.isPackageSelected(packageName);
    }

    /**
     * Whether the cache may be read or written for this player.
     *
     * Two conditions, and the second outranks the first:
     *
     *   1. The player is on the cache list. Nothing is kept for a player the
     *      user did not pick.
     *   2. No account owns its like status, see
     *      {@link #isFavoriteCacheBlockedByAccount}. Once fYT Rating (both
     *      ReVanced builds) or SpotifyRating (Spotify) holds an account, the
     *      account is the only truth about a like - it can be changed from any
     *      other device, and a value kept here could only ever contradict it.
     *      A player ticked before the account was connected stays ticked, and
     *      is ignored for as long as the account is there.
     *
     * Answered afresh on every call and never remembered, so a sign-in shuts
     * the cache on the very next read or write, whatever the list still holds.
     * What the cache already put in memory is dropped by the same question;
     * see YouTubeRevancedLikeState.setCachedState.
     */
    private static boolean isFavoriteCacheUsable(String packageName) {
        if (!isFavoriteCacheSelected(packageName)) {
            return false;
        }
        return !isFavoriteCacheBlockedByAccount(packageName);
    }

    /**
     * The hard block: true while a signed-in account owns the like status of
     * this player, so the cache stays shut whatever the list says.
     *
     * Public because AppListCacheDialogFragment hides the same players by the
     * same rule. One predicate for both means the list can never offer a player
     * the controller would refuse.
     */
    public static boolean isFavoriteCacheBlockedByAccount(String packageName) {
        if (isYouTubePackage(packageName)) {
            return isFytAccountPresent();
        }
        if (isSpotifyPackage(packageName)) {
            return isSpotifyAccountPresent();
        }
        return false;
    }

    /**
     * Whether fYT Rating holds an account for the ReVanced builds.
     *
     * {@link #isLoggedOAuth} is asked first and unconditionally - it is what
     * keeps FytRating refreshing a stale answer in the background - and it
     * decides whenever it says yes. Its no is not taken at face value, because
     * it also says no in two situations that have nothing to do with signing
     * out:
     *
     *   - it is held for OAUTH_ANSWER_MAX_AGE_MS, so a sign-in that has just
     *     been reported is not in it yet;
     *   - FytRating.resetTransport() - run after three unanswered exchanges, on
     *     every stall recovery and by revive() - drops statusKnown but keeps the
     *     last answer, and isLoggedIn() stays false until the bridge speaks
     *     again, which takes a while with a bridge that is struggling.
     *
     * Either way the cache would open, briefly or for as long as the bridge
     * stays silent, on an account that is still signed in. So the last answer
     * the bridge actually gave is consulted too: signed in and allowed means
     * the account is there until the bridge says otherwise - the same rule
     * FytRating applies itself when it keeps a positive answer through silence.
     *
     * The two flags are volatile reads and cost nothing. Only the installed
     * check behind them reaches the package manager, and it is rationed like
     * isLoggedOAuth(): an uninstalled bridge keeps its last answer for good,
     * and without the check the block would outlive the app it stands for.
     */
    private static boolean isFytAccountPresent() {
        if (isLoggedOAuth()) {
            return true;
        }
        if (!FytRating.isSignedIn() || !FytRating.isAllowed()) {
            return false;
        }
        return isFytInstalled();
    }

    private static volatile boolean fytInstalledAnswer;
    private static volatile long fytInstalledAnswerAtMs;

    /** FytRating.isInstalled, held for OAUTH_ANSWER_MAX_AGE_MS like isLoggedOAuth(). */
    private static boolean isFytInstalled() {
        long now = SystemClock.elapsedRealtime();
        if (fytInstalledAnswerAtMs != 0L
                && now - fytInstalledAnswerAtMs < OAUTH_ANSWER_MAX_AGE_MS) {
            return fytInstalledAnswer;
        }
        boolean answer = FytRating.isInstalled(LauncherApplication.sApp);
        fytInstalledAnswer = answer;
        fytInstalledAnswerAtMs = now;
        return answer;
    }

    /**
     * Whether a Spotify account is signed in.
     *
     * Deliberately wider than {@link #isSpotifyLinked}, which also turns false
     * while SpotifyRating holds a recent refusal (isAuthBroken). A 401 or 403
     * from the Web API marks the grant broken for two minutes but leaves the
     * refresh token on file: the user is still signed in, and a block built on
     * isSpotifyLinked() would open the cache for exactly those two minutes.
     * The refresh token is the grant, so while it is there the cache stays
     * shut. A grant the server rejects outright is cleared by SpotifyRating
     * itself, and that is a real sign-out.
     *
     * isSpotifyLinked() implies this, so every case it covers stays covered.
     */
    private static boolean isSpotifyAccountPresent() {
        return SpotifyRating.isLoggedIn(LauncherApplication.sApp);
    }

    /** The cache inputs for one player, for the lines that explain a dead button. */
    private static String describeFavoriteCache(String packageName) {
        return "cacheListed=" + isFavoriteCacheSelected(packageName)
                + " cacheBlocked=" + isFavoriteCacheBlockedByAccount(packageName);
    }

    private static boolean preference(String key) {
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        return mPrefs.getBoolean(key, false);
    }

    public static void refreshWidget(Context context) {
        if (context != null) {
            Widget.widgetUpdate(context.getApplicationContext(), DateMusicProvider.class);
        }
    }

    /**
     * True only for the patched YouTube build and YT Music.
     *
     * The entire Data API path relies on the mediaId, which stock YouTube does not publish. 
     * The ReVanced patch for YouTube exposes the mediaId, allowing this path to apply to that build. 
     * YT Music (both stock and ReVanced) publishes the mediaId by default; however, due to 
     * ad interruptions, non-premium users might occasionally fail to retrieve it.
     * All other players fall back to the default behaviour: their state is derived from 
     * standard metadata and exposed custom actions, with ratings handled directly via the media session.
     */
    private static boolean isYouTubePackage(String packageName) {
        return YOUTUBE_REVANCED_PACKAGE.equals(packageName)
                || YOUTUBE_MUSIC_REVANCED_PACKAGE.equals(packageName)
                || YOUTUBE_MUSIC_PACKAGE.equals(packageName);
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
        if (controller == null || context == null) {
            return FAVORITE_STATE_UNKNOWN;
        }

        // ReVanced is keyed by the video being played rather than by the track
        // metadata, so it has a store of its own; see
        // getCachedYouTubeFavoriteState.
        if (isYouTubePackage(controller.getPackageName())) {
            return FAVORITE_STATE_UNKNOWN;
        }

        if (!isFavoriteCacheUsable(controller.getPackageName())) {
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
        if (controller == null || context == null) {
            return;
        }

        if (isYouTubePackage(controller.getPackageName())) {
            return;
        }

        if (!isFavoriteCacheUsable(controller.getPackageName())) {
            return;
        }

        String key = getTrackCacheKey(controller);
        if (key == null) {
            return;
        }

        writeFavoriteCache(context, key, state);
    }

    /**
     * The like status kept for a single ReVanced video.
     *
     * Keyed by the video id rather than by the track metadata, because that is
     * the one thing about a YouTube video that is stable and unambiguous.
     * Guarded by {@link #isFavoriteCacheUsable} for the build asking, so it
     * answers nothing for a build that is not on the cache list, and nothing
     * at all while an account is signed in.
     */
    private static int getCachedYouTubeFavoriteState(
            Context context, String packageName, String videoId) {
        String key = getVideoCacheKey(videoId);
        if (context == null || key == null || !isFavoriteCacheUsable(packageName)) {
            return FAVORITE_STATE_UNKNOWN;
        }
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getInt(key, FAVORITE_STATE_UNKNOWN);
    }

    private static void cacheYouTubeFavoriteState(
            Context context, String packageName, String videoId, int state) {
        String key = getVideoCacheKey(videoId);
        if (context == null || key == null || !isFavoriteCacheUsable(packageName)) {
            return;
        }
        writeFavoriteCache(context, key, state);
    }

    /**
     * One store for both ReVanced builds, as before: a like belongs to the
     * account's video, not to the app it was made in. Which build may use the
     * store is decided per package by the guards above, not by the key - and
     * leaving the key alone keeps every status cached so far.
     */
    private static String getVideoCacheKey(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            return null;
        }
        return PREF_PREFIX + YOUTUBE_REVANCED_PACKAGE + ":video:" + videoId;
    }

    private static void writeFavoriteCache(Context context, String key, int state) {
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

    /**
     * The Spotify URI for whatever a session is playing.
     *
     * Read off the session rather than asked of the API. Spotify publishes the
     * URI as the media id, which is free, immediate and not rate limited;
     * /me/player/currently-playing would cost a request per track change out
     * of the user's own quota, and would answer about the account rather than
     * about this device.
     *
     * Tracks, podcast episodes and audiobook chapters all arrive here the same
     * way and are all saveable, so no kind is filtered out: the library
     * endpoint knows what to do with each, and the one that does not fit -
     * a chapter - is resolved to its audiobook by SpotifyRating.
     *
     * @return null for anything with nothing in the catalogue behind it: an
     *         advert, or a local file
     */
    private static String findSpotifyLibraryUri(MediaController controller) {
        if (controller == null) {
            return null;
        }

        MediaMetadata metadata;
        try {
            metadata = controller.getMetadata();
        } catch (Exception e) {
            Log.w(TAG, "Could not read the Spotify metadata", e);
            return null;
        }
        if (metadata == null) {
            return null;
        }

        String mediaId = null;
        try {
            mediaId = metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID);
            String libraryUri = SpotifyRating.extractLibraryUri(mediaId);
            if (libraryUri != null) {
                return libraryUri;
            }
        } catch (Throwable ignored) {
        }

        // Older builds put it on the description instead.
        try {
            MediaDescription description = metadata.getDescription();
            String libraryUri = SpotifyRating.extractLibraryUri(description.getMediaId());
            if (libraryUri != null) {
                return libraryUri;
            }
            if (mediaId == null) {
                mediaId = description.getMediaId();
            }
        } catch (Throwable ignored) {
        }

        // Reported once per distinct value, because a build that publishes
        // something unexpected here would otherwise look identical to an
        // advert: both end up as a null uri, and only one of them is a bug.
        if (mediaId != null && !mediaId.equals(lastUnusableSpotifyMediaId)) {
            lastUnusableSpotifyMediaId = mediaId;
            Log.d(TAG, "No Spotify library uri in the session media id: " + mediaId);
        }

        return null;
    }

    /** The last media id nothing could be read out of; see findSpotifyLibraryUri. */
    private static volatile String lastUnusableSpotifyMediaId;

    private static String findVideoId(MediaController controller) {
        if (controller == null) {
            return null;
        }

        MediaMetadata metadata = controller.getMetadata();
        if (metadata != null) {
            String mediaId = metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID);
            if (mediaId != null) {
                Matcher m = BARE_VIDEO_ID.matcher(mediaId);
                if (m.matches()) {
                    return mediaId;
                }
                m = VIDEO_ID_IN_URL.matcher(mediaId);
                if (m.find()) {
                    return m.group(1);
                }
            }
        }

        PlaybackState playbackState = controller.getPlaybackState();
        List<MediaSession.QueueItem> queue = controller.getQueue();

        if (playbackState != null && queue != null) {
            long activeItemId = playbackState.getActiveQueueItemId();

            for (MediaSession.QueueItem item : queue) {
                if (item.getQueueId() == activeItemId) {
                    
                    MediaDescription qd = item.getDescription();
                    List<String> candidates = new ArrayList<>();

                    if (qd.getMediaId() != null) {
                        candidates.add(qd.getMediaId());
                    }
                    if (qd.getIconUri() != null) {
                        candidates.add(qd.getIconUri().toString());
                    }
                    for (String s : candidates) {
                        Matcher m = VIDEO_ID_IN_URL.matcher(s);
                        if (m.find()) {
                            return m.group(1);
                        }
                        m = BARE_VIDEO_ID.matcher(s);
                        if (m.matches()) {
                            return s;
                        }
                    }
                    break;
                }
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

        /**
         * A lookup still running after this long is treated as lost.
         *
         * The budget it needs is bounded: two exchanges with the bridge, twelve
         * seconds each, plus whatever a rating the user sent is still waiting
         * on ahead of it in the queue. A minute covers all of that and gets the
         * next attempt away well before the stall watchdog gives up on the
         * bridge entirely - which two minutes did not.
         */
        private static final long FETCH_STUCK_AFTER_MS = 60000L;
        private static volatile long fetchStartedAtMs;
        private static volatile String inFlightVideoId;
        private static volatile long fetchSequence;

        private static volatile String currentVideoId;
        private static volatile int currentState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;

        /**
         * True while the status above was read out of the launcher's cache,
         * rather than resolved by a lookup or produced by something the user did.
         *
         * Such a status is worth exactly what the cache is worth at the moment
         * it is asked about. Once the cache stops being usable for the playing
         * build - an account signed in, or the build taken off the list - it
         * stops counting as resolved. Otherwise it would stay on screen and keep
         * the button lit until the track changed, and a lookup that failed would
         * leave it there for good.
         *
         * Written together with the two fields above under the class monitor,
         * and read with them the same way, so a status is never paired with the
         * wrong origin.
         */
        private static volatile boolean currentStateFromCache;

        /**
         * Bumped on every status change, so a lookup coming back can tell
         * whether the answer it is holding has been overtaken while it ran.
         */
        private static volatile long stateSequence;

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

            // Videos made for kids never report a rating, so claiming anything
            // about them would be a guess.
            //
            // Asked about the video passed in, not about whatever was looked at
            // last, and asked before anything else: a status that arrived from
            // somewhere else - the cache, or a like made inside YouTube - must
            // not put a state back on a button the switch has greyed out.
            if (isMadeForKids(videoId)) {
                if (!isKidsRatingAllowed()) {
                    // UNKNOWN greys the button out, which is what stock YouTube
                    // does when it cannot rate.
                    return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
                }

                // The other behaviour the switch offers: shown as not liked
                // rather than greyed out. Waiting for a status would come to
                // the same thing as greying it out, because none is ever
                // coming - so only one the launcher put there itself counts.
                int known = getResolvedState(videoId);
                return known == MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                        ? MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED
                        : known;
            }

            // Through getResolvedState, so a status seeded from the cache is
            // dropped here as well the moment the cache stops being usable.
            int resolved = getResolvedState(videoId);
            return resolved == MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                    ? unknownState()
                    : resolved;
        }

        /**
         * The status held for a video, with none of the substitutions
         * {@link #getState} makes. UNKNOWN here means nothing is known, which
         * is what the cache needs to hear before it offers an answer.
         */
        public static int getResolvedState(String videoId) {
            if (videoId == null || videoId.isEmpty()) {
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }
            int state;
            boolean fromCache;
            synchronized (YouTubeRevancedLikeState.class) {
                if (!videoId.equals(currentVideoId)) {
                    return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
                }
                state = currentState;
                fromCache = currentStateFromCache;
            }
            // A status the cache supplied is only as good as the cache is right
            // now: the moment an account signs in or the build leaves the list,
            // it is nothing again, whatever it said. Asked outside the monitor,
            // because the answer may reach the package manager and the lookup
            // thread must never wait on that.
            if (fromCache
                    && state != MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                    && !MediaFavoriteController.isFavoriteCacheUsable(
                            MediaFavoriteController.currentRevancedPackage())) {
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }
            return state;
        }

        /** The video the last state read asked about. */
        public static String getLastQueriedVideoId() {
            return lastQueriedVideoId;
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
            // UNKNOWN with a fetcher installed is deliberate and is not a gap
            // to be filled: until the bridge has answered for this video the
            // button is greyed out, rather than showing a status nothing
            // stands behind. Only where no answer is coming at all does it
            // read as something else.
            //
            // With the cache carrying the status there is no answer on its way
            // either, whatever the fetcher was left installed by: a video the
            // cache has never seen reads as not favorited, and the first press
            // is what puts a status in there.
            //
            // Asked for the build that is playing: the cache list is per player.
            if (MediaFavoriteController.isFavoriteCacheUsable(
                    MediaFavoriteController.currentRevancedPackage())) {
                return MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
            }
            return hasFetcher()
                    ? MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                    : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
        }

        /** Records the status of the given video, discarding any previous one. */
        public static void setState(String videoId, int state) {
            if (videoId == null || videoId.isEmpty()) {
                return;
            }
            synchronized (YouTubeRevancedLikeState.class) {
                currentVideoId = videoId;
                currentState = state;
                currentStateFromCache = false;
                stateSequence++;
            }
        }

        /**
         * Seeds the status of a video from the launcher's cache.
         *
         * Not a setState. A value out of the cache is the weakest statement
         * there is about a like, so it is marked as such - it counts only while
         * the cache is usable, see currentStateFromCache - and it does not bump
         * stateSequence. A lookup already in flight therefore still replaces
         * it. Bumping made the account's answer look older than the cache's:
         * the answer was discarded as overtaken, and the cached value stayed on
         * the button as if confirmed, for the rest of the video.
         */
        private static void setCachedState(String videoId, int state) {
            if (videoId == null || videoId.isEmpty()
                    || state == MediaFavoriteController.FAVORITE_STATE_UNKNOWN) {
                return;
            }
            synchronized (YouTubeRevancedLikeState.class) {
                currentVideoId = videoId;
                currentState = state;
                currentStateFromCache = true;
            }
        }

        /**
         * True once the status of the video being asked about is settled,
         * either by a lookup or by an action the user took.
         */
        public static boolean isCurrentStateResolved() {
            return isStateResolved(lastQueriedVideoId);
        }

        /** True once the status of this video is settled, whichever fed it. */
        public static boolean isStateResolved(String videoId) {
            return getResolvedState(videoId)
                    != MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }

        public static boolean isCurrentMadeForKids() {
            return isMadeForKids(lastQueriedVideoId);
        }

        /**
         * Whether this video is the one known to be made for kids.
         *
         * Asked about an explicit id, because the caller that matters most -
         * the rule that greys the button - runs on paths where no state has
         * been read yet, and the id left behind by the last read belongs to
         * whatever was playing before.
         */
        public static boolean isMadeForKids(String videoId) {
            String kidsId = madeForKidsVideoId;
            return kidsId != null && videoId != null && kidsId.equals(videoId);
        }

        /** Forgets everything, e.g. when playback moves to another video. */
        public static void clear() {
            madeForKidsVideoId = null;
            currentVideoId = null;
            currentState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            currentStateFromCache = false;
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
                        + " fromCache=" + currentStateFromCache
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
            final long stateToken;
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
                stateToken = stateSequence;
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
                        // The one place the bridge's own answer is visible.
                        // madeForKids=false on a video that is one means the
                        // bridge did not report it, and no switch here can act
                        // on something it was never told.
                        Log.d(TAG, "Lookup for " + videoId + " answered: rating="
                                + MediaFavoriteController.describePublicState(state)
                                + " madeForKids=" + madeForKids);

                        boolean resolved = false;

                        if (Boolean.TRUE.equals(madeForKids)) {
                            madeForKidsVideoId = videoId;
                            resolved = true;
                        } else if (madeForKids != null && videoId.equals(madeForKidsVideoId)) {
                            madeForKidsVideoId = null;
                        }

                        if (state != MediaFavoriteController.FAVORITE_STATE_UNKNOWN) {
                            // A status that arrived while this lookup was in
                            // flight describes the video later than the lookup
                            // does - a like made inside YouTube, or one the
                            // launcher sent itself. The answer still counts as
                            // resolved, it just does not get to undo it.
                            if (stateSequence != stateToken
                                    && videoId.equals(currentVideoId)) {
                                Log.d(TAG, "Lookup answered " + state + " for " + videoId
                                        + " but the status had already moved on; keeping it");
                            } else {
                                setState(videoId, state);
                            }
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
