package com.android.launcher66.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.MediaFavoriteController;
import com.android.launcher66.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Spotify Web API client, owned by the launcher.
 *
 * The counterpart of {@link FytRating}, and deliberately not built like it.
 * fYT Rating keeps the account, the tokens and the consent on the far side of
 * an application boundary; here there is no far side. This class holds the
 * refresh token, performs the OAuth exchange and signs every request, which
 * means it also carries the responsibilities that came free over there: the
 * credentials never leave the device, the access token is refreshed without
 * involving the user, and a revoked grant has to be recognised rather than
 * retried forever.
 *
 * Authorization Code Flow with PKCE, no client secret. The user supplies a
 * Client ID of their own; a secret could not be shipped in an APK without
 * handing it to anyone willing to unzip one, and PKCE exists precisely so that
 * it does not have to be.
 *
 * Two shapes of API, for two callers:
 *
 *   - Blocking calls ({@link #fetchSavedState}, {@link #setRating}) that talk
 *     to the network and must only ever run on a background thread.
 *   - A cached, non-blocking state holder ({@link #getState}) for the widget,
 *     which reads the favorite state on every tick and cannot wait for a round
 *     trip. It answers from the last known value and refreshes behind itself,
 *     the same arrangement YouTubeRevancedLikeState provides for ReVanced.
 */
public final class SpotifyRating {

    private static final String TAG = "SpotifyRating";

    public static final String SPOTIFY_PACKAGE = "com.spotify.music";

    // --------------------------------------------------------------- oauth

    /**
     * Must match in three places: here, the intent filter in the manifest, and
     * the Redirect URI registered in the Spotify developer dashboard. Spotify
     * compares it byte for byte and refuses the whole exchange on a mismatch.
     */
    public static final String REDIRECT_SCHEME = "launcher66";
    public static final String REDIRECT_HOST = "spotify-callback";
    public static final String REDIRECT_URI = REDIRECT_SCHEME + "://" + REDIRECT_HOST;

    private static final String AUTH_ENDPOINT = "https://accounts.spotify.com/authorize";
    private static final String TOKEN_ENDPOINT = "https://accounts.spotify.com/api/token";
    private static final String API_BASE = "https://api.spotify.com/v1";

    /**
     * user-read-currently-playing is what authorises /me/player/currently-playing;
     * user-read-playback-state covers /me/player, which the fallback path does
     * not use today but which is the natural place to go next.
     */
    private static final String SCOPES =
            "user-library-read user-library-modify"
                    + " user-read-playback-state user-read-currently-playing";

    /**
     * How early a token is treated as spent.
     *
     * An access token that expires while a request is in flight costs a 401, a
     * forced refresh and a second request. Refreshing a minute early costs
     * nothing, because it happens on a thread nobody is waiting on.
     */
    private static final long EXPIRY_SKEW_MS = 60000L;

    private static final int CONNECT_TIMEOUT_MS = 10000;
    private static final int READ_TIMEOUT_MS = 15000;

    private static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";

    /** The unreserved character set of RFC 7636; anything else would need escaping. */
    private static final String VERIFIER_ALPHABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~";

    /** Within the 43..128 the specification allows, with room to spare. */
    private static final int VERIFIER_LENGTH = 64;

    /**
     * The scopes the server said it granted, kept only so a refusal can be
     * read.
     *
     * Not in Keys because it is not configuration and nothing outside this
     * class has any business reading it: a grant carries whatever scopes it
     * carries, and the launcher cannot change that by storing a different
     * answer. It is written because the alternative is waiting an hour for the
     * next refresh to say so again.
     */
    private static final String PREF_GRANTED_SCOPE = "spotify_granted_scope";

    // ---------------------------------------------------------- library uris

    /**
     * The kinds a media session can plausibly be playing.
     *
     * Album, artist and playlist are left out deliberately: they are things a
     * session plays *from*, never what it is playing, so recognising them here
     * would only let the heart save a container the user cannot see.
     */
    private static final Pattern SPOTIFY_URI = Pattern.compile(
            "spotify:(track|episode|chapter|audiobook|show):([A-Za-z0-9]{22})");

    /** The same kinds as they appear in an open.spotify.com link. */
    private static final Pattern SPOTIFY_LINK = Pattern.compile(
            "/(track|episode|chapter|audiobook|show)/([A-Za-z0-9]{22})");

    /** A bare id, with nothing to say what kind of thing it names. */
    private static final Pattern BARE_ID =
            Pattern.compile("[A-Za-z0-9]{22}");

    /**
     * The library endpoints take Spotify URIs, not bare ids.
     *
     * Worth stating plainly, because the obvious-looking alternative is a trap
     * that costs days: /me/tracks, /me/tracks/contains and their album
     * equivalents still exist, still accept ?ids=, and answer a valid token
     * carrying user-library-read with 403 Forbidden. Nothing in that reply
     * says the endpoint is deprecated, so it reads exactly like a permissions
     * fault and sends you looking at scopes, dashboards and tokens - none of
     * which are the problem.
     */
    private static String trackUri(String trackId) {
        return "spotify:track:" + trackId;
    }

    /** The kind out of a URI: "track", "episode", and so on. */
    private static String kindOf(String uri) {
        if (uri == null) {
            return null;
        }
        int first = uri.indexOf(':');
        int second = uri.indexOf(':', first + 1);
        return (first < 0 || second < 0) ? null : uri.substring(first + 1, second);
    }

    /** The id out of a URI. */
    private static String idOf(String uri) {
        int last = uri == null ? -1 : uri.lastIndexOf(':');
        return last < 0 ? null : uri.substring(last + 1);
    }

    // --------------------------------------------------------------- state

    /**
     * The item the cached answer describes, and the answer itself.
     *
     * One item deep on purpose. The widget only ever asks about what is
     * playing, and a map would keep answers for things that have since been
     * liked on a phone - the account is the truth, and a stale local copy of
     * it can only be wrong in the direction the user notices.
     */
    private static volatile String knownUri;
    private static volatile int knownState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
    private static volatile long knownAtMs;

    /** How long a resolved state is trusted before it is fetched again. */
    private static final long STATE_MAX_AGE_MS = 30000L;

    /** How soon a failed lookup may be retried for the same track. */
    private static final long RETRY_DELAY_MS = 5000L;

    private static volatile String lastAttemptUri;
    private static volatile long lastAttemptAtMs;

    private static final AtomicBoolean REFRESH_RUNNING = new AtomicBoolean(false);
    private static volatile long refreshStartedAtMs;

    /** A refresh still marked as running after this long never finished. */
    private static final long REFRESH_STUCK_AFTER_MS = 60000L;

    /** Told to redraw the widget once a lookup lands. */
    private static volatile Runnable onUpdated;

    /**
     * Set when the server rejected the grant: a refresh token it refused, or a
     * scope the grant never included. Retrying either on every widget tick
     * would be a request per second against a rate limited API.
     *
     * Given a deadline rather than latched, and for the reason FytRating gives
     * for the same decision: a refusal that cannot be confirmed must not go on
     * acting like one. A wrong "no" that survives until the launcher restarts
     * is a button that cannot be pressed and cannot report why.
     */
    private static volatile boolean authBroken;
    private static volatile long authBrokenAtMs;

    /**
     * What the server said the last time it refused, kept for the log.
     *
     * A refusal that only reports "signed in but not working" is a refusal
     * nobody can act on: a missing scope, a token the server no longer knows
     * and an application that was never granted Web API access all look
     * identical from the outside and need three different fixes.
     */
    private static volatile String lastRefusal;

    /** How often a refusal is put to the question again. */
    private static final long AUTH_BROKEN_RECHECK_MS = 120000L;

    /**
     * All network work runs here, one item at a time.
     *
     * Serialising it is not tidiness. Two threads finding an expired token
     * together would both refresh, and with refresh token rotation the second
     * exchange invalidates the first - which is how a grant silently
     * un-authorises itself overnight.
     */
    private static final ExecutorService IO = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "spotify-rating");
            thread.setDaemon(true);
            return thread;
        }
    });

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private SpotifyRating() {
    }

    // ====================================================================
    // Sign-in state
    // ====================================================================

    /**
     * Whether a usable grant exists.
     *
     * Reads the refresh token only. The access token is disposable and its
     * absence says nothing; the refresh token is the grant.
     */
    public static boolean isLoggedIn(Context context) {
        if (context == null) {
            return false;
        }
        return !TextUtils.isEmpty(
                prefs(context).getString(Keys.SPOTIFY_REFRESH_TOKEN, null));
    }

    /** Whether the user has supplied the one thing they have to supply. */
    public static boolean hasClientId(Context context) {
        return context != null && !TextUtils.isEmpty(clientId(context));
    }

    /**
     * True when the server rejected the grant recently enough to be believed.
     *
     * Expires the refusal rather than holding it: the only thing that could
     * clear it otherwise is a fresh sign-in, so one transient 403 used to
     * disable Spotify for the rest of the process.
     */
    public static boolean isAuthBroken() {
        if (!authBroken) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - authBrokenAtMs > AUTH_BROKEN_RECHECK_MS) {
            Log.d(TAG, "The Spotify refusal went unconfirmed; trying again");
            authBroken = false;
            return false;
        }
        return true;
    }

    /** Drops the grant. The Client ID belongs to the user and is left alone. */
    public static void logout(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences preferences = prefs(context);
        clearTokens(preferences);
        clearPendingAuth(preferences);
        forgetState();

        // Signing out is a decision, not a refusal. Leaving the flag set here
        // made the settings screen report an expired session straight after a
        // deliberate sign-out - and, because the Client ID listener calls this
        // on every edit, straight after typing one in for the first time.
        authBroken = false;

        Log.i(TAG, "Spotify tokens cleared");
    }

    // ====================================================================
    // PKCE: starting the sign-in
    // ====================================================================

    /**
     * Generates the verifier and its challenge, records the verifier, and hands
     * the user to a browser.
     *
     * The verifier has to survive leaving the application, and leaving it is
     * exactly when the launcher is most likely to be killed, so it is written
     * with commit() rather than apply(). It is two short strings; the write
     * costs less than the failure it prevents, which is a sign-in that cannot
     * be completed and gives no reason why.
     *
     * @return false when nothing was opened, and a message has been shown
     */
    public static boolean startLogin(Context context) {
        if (context == null) {
            return false;
        }

        SharedPreferences preferences = prefs(context);
        String clientId = clientId(context);
        if (TextUtils.isEmpty(clientId)) {
            // Callers are expected to have checked, so reaching here is a
            // programming error rather than a user one. Handled anyway,
            // because the alternative is a button that does nothing.
            toast(context, R.string.spotify_client_id_missing);
            return false;
        }

        String verifier = randomString(VERIFIER_LENGTH);
        String challenge = codeChallenge(verifier);
        if (challenge == null) {
            toast(context, R.string.spotify_login_failed);
            return false;
        }

        // Ties the reply to this request. Any application on the device can
        // fire an intent at our redirect scheme; without this there is nothing
        // to tell such an intent apart from the browser's.
        String state = randomString(24);

        preferences.edit()
                .putString(Keys.SPOTIFY_CODE_VERIFIER, verifier)
                .putString(Keys.SPOTIFY_AUTH_STATE, state)
                .commit();

        Uri authorizeUri = Uri.parse(AUTH_ENDPOINT).buildUpon()
                .appendQueryParameter("client_id", clientId)
                .appendQueryParameter("response_type", "code")
                .appendQueryParameter("redirect_uri", REDIRECT_URI)
                .appendQueryParameter("code_challenge_method", "S256")
                .appendQueryParameter("code_challenge", challenge)
                .appendQueryParameter("scope", SCOPES)
                .appendQueryParameter("state", state)
                .build();

        // Logged whole, because every failure so far has been something that
        // could be seen in this string and could not be seen anywhere else.
        Log.i(TAG, "Spotify authorize: " + authorizeUri);

        Intent browser = new Intent(Intent.ACTION_VIEW, authorizeUri);
        browser.addCategory(Intent.CATEGORY_BROWSABLE);
        browser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            context.startActivity(browser);
            return true;
        } catch (ActivityNotFoundException e) {
            // Head units ship without a browser far more often than phones do,
            // and this is the one step that cannot be done without one.
            Log.w(TAG, "No browser to open the Spotify authorisation page", e);
            clearPendingAuth(preferences);
            toast(context, R.string.spotify_no_browser);
            return false;
        }
    }

    /** A random string over the unreserved set; used for the verifier and the state. */
    private static String randomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(VERIFIER_ALPHABET.charAt(random.nextInt(VERIFIER_ALPHABET.length())));
        }
        return builder.toString();
    }

    /** BASE64URL(SHA-256(verifier)), unpadded and unwrapped, per RFC 7636. */
    private static String codeChallenge(String verifier) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(verifier.getBytes("US-ASCII"));
            return Base64.encodeToString(
                    hash, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
        } catch (Exception e) {
            Log.e(TAG, "Could not derive the code challenge", e);
            return null;
        }
    }

    // ====================================================================
    // PKCE: coming back from the browser
    // ====================================================================

    /** Whether this is the redirect we asked for. */
    public static boolean isAuthCallback(Uri uri) {
        return uri != null
                && REDIRECT_SCHEME.equalsIgnoreCase(uri.getScheme())
                && REDIRECT_HOST.equalsIgnoreCase(uri.getHost());
    }

    public interface AuthCallback {
        void onSuccess();

        void onError(String message);
    }

    /**
     * Exchanges the authorization code for tokens.
     *
     * The verifier is single use and is cleared before anything can go wrong
     * with the exchange - one left behind is one that can be replayed against a
     * code somebody else obtained.
     */
    public static void handleAuthorizationResponse(
            Context context, Uri uri, final AuthCallback callback) {
        if (context == null) {
            fail(callback, "no context");
            return;
        }

        final Context appContext = context.getApplicationContext();
        final SharedPreferences preferences = prefs(appContext);

        if (!isAuthCallback(uri)) {
            fail(callback, "unexpected redirect");
            return;
        }

        String error = uri.getQueryParameter("error");
        final String code = uri.getQueryParameter("code");
        String state = uri.getQueryParameter("state");

        final String verifier = preferences.getString(Keys.SPOTIFY_CODE_VERIFIER, null);
        String expectedState = preferences.getString(Keys.SPOTIFY_AUTH_STATE, null);
        final String clientId = clientId(appContext);

        clearPendingAuth(preferences);

        if (!TextUtils.isEmpty(error)) {
            // The user pressed Cancel, or the dashboard is misconfigured.
            fail(callback, error);
            return;
        }
        if (TextUtils.isEmpty(code)) {
            fail(callback, "no authorization code");
            return;
        }
        if (TextUtils.isEmpty(verifier)) {
            fail(callback, "the code verifier is gone; start again");
            return;
        }
        if (!TextUtils.isEmpty(expectedState) && !expectedState.equals(state)) {
            Log.w(TAG, "State mismatch on the Spotify redirect; ignoring it");
            fail(callback, "state mismatch");
            return;
        }
        if (TextUtils.isEmpty(clientId)) {
            fail(callback, "no client id");
            return;
        }

        IO.execute(() -> {
            try {
                String body = form(
                        "grant_type", "authorization_code",
                        "code", code,
                        "redirect_uri", REDIRECT_URI,
                        "client_id", clientId,
                        "code_verifier", verifier);

                Response response = execute(
                        "POST", TOKEN_ENDPOINT, null, body.getBytes("UTF-8"), FORM_CONTENT_TYPE);

                if (response.code != 200) {
                    fail(callback, describeError(response.body));
                    return;
                }

                storeTokens(preferences, new JSONObject(response.body));
                authBroken = false;
                forgetState();
                Log.i(TAG, "Signed in to Spotify");
                MAIN.post(() -> {
                    if (callback != null) {
                        callback.onSuccess();
                    }
                });
            } catch (Exception e) {
                Log.e(TAG, "Token exchange failed", e);
                fail(callback, message(e));
            }
        });
    }

    // ====================================================================
    // Tokens
    // ====================================================================

    /**
     * Blocking. A valid access token, refreshed if need be.
     *
     * Synchronised on top of the single threaded executor, because the settings
     * screen reaches the exchange path from a thread of its own.
     *
     * @throws AuthRequiredException when only the user can put this right
     */
    private static synchronized String getValidAccessToken(Context context, boolean force)
            throws IOException {
        SharedPreferences preferences = prefs(context);
        String token = preferences.getString(Keys.SPOTIFY_ACCESS_TOKEN, null);
        long expiry = preferences.getLong(Keys.SPOTIFY_TOKEN_EXPIRY, 0L);

        boolean usable = !TextUtils.isEmpty(token)
                && System.currentTimeMillis() < expiry - EXPIRY_SKEW_MS;

        if (usable && !force) {
            return token;
        }
        return refreshAccessToken(preferences);
    }

    /**
     * Blocking. Trades the refresh token for a new access token.
     *
     * Spotify rotates refresh tokens under PKCE: the reply may carry a new one,
     * and the old one stops working the moment it does. Missing that is the
     * difference between a grant that lasts and one that dies at the second
     * refresh.
     */
    private static String refreshAccessToken(SharedPreferences preferences) throws IOException {
        String refreshToken = preferences.getString(Keys.SPOTIFY_REFRESH_TOKEN, null);
        String clientId = trim(preferences.getString(Keys.SPOTIFY_CLIENT_ID, ""));

        if (TextUtils.isEmpty(refreshToken) || TextUtils.isEmpty(clientId)) {
            throw new AuthRequiredException("not signed in");
        }

        String body = form(
                "grant_type", "refresh_token",
                "refresh_token", refreshToken,
                "client_id", clientId);

        Response response = execute(
                "POST", TOKEN_ENDPOINT, null, body.getBytes("UTF-8"), FORM_CONTENT_TYPE);

        if (response.code == 400 || response.code == 401) {
            // invalid_grant: access revoked, password changed, or a rotated
            // token lost. Nothing here can recover it, and keeping it would
            // mean retrying a rejected credential forever.
            String refusal = noteRefusal(response.code, response.body);
            Log.w(TAG, "The Spotify grant was rejected: " + refusal);
            clearTokens(preferences);
            authBroken = true;
            authBrokenAtMs = SystemClock.elapsedRealtime();
            throw new AuthRequiredException("the grant was rejected, " + refusal);
        }
        if (response.code != 200) {
            // A server fault or no network. The grant is presumed intact.
            throw new IOException("token refresh returned HTTP " + response.code);
        }

        try {
            storeTokens(preferences, new JSONObject(response.body));
        } catch (JSONException e) {
            throw new IOException("unreadable token response", e);
        }

        String fresh = preferences.getString(Keys.SPOTIFY_ACCESS_TOKEN, null);
        if (TextUtils.isEmpty(fresh)) {
            throw new AuthRequiredException("no access token in the reply");
        }
        Log.d(TAG, "Spotify access token refreshed");
        return fresh;
    }

    private static synchronized void storeTokens(SharedPreferences preferences, JSONObject json) {
        String access = optString(json, "access_token");
        String refresh = optString(json, "refresh_token");
        String granted = optString(json, "scope");
        long expiresIn = json.optLong("expires_in", 3600L);

        // The one field that says what the grant is actually allowed to do.
        // A grant that came back narrower than it was asked for is refused by
        // the API in a way that looks nothing like a scope problem, so it is
        // worth saying out loud the moment it happens.
        Log.i(TAG, "Spotify granted scope: " + granted);
        if (granted != null && !granted.contains("user-library-read")) {
            Log.w(TAG, "The grant carries no user-library-read;"
                    + " reading the saved state will be refused");
        }

        SharedPreferences.Editor editor = preferences.edit();
        if (granted != null) {
            editor.putString(PREF_GRANTED_SCOPE, granted);
        }
        if (!TextUtils.isEmpty(access)) {
            editor.putString(Keys.SPOTIFY_ACCESS_TOKEN, access);
        }
        if (!TextUtils.isEmpty(refresh)) {
            // Overwritten only when one is sent. A refresh reply that omits it
            // means the existing token stands.
            editor.putString(Keys.SPOTIFY_REFRESH_TOKEN, refresh);
        }
        editor.putLong(Keys.SPOTIFY_TOKEN_EXPIRY, System.currentTimeMillis() + expiresIn * 1000L);
        editor.commit();
    }

    /**
     * Only forgets the tokens. Whether that was a refusal or the user's own
     * choice is decided by the caller - conflating the two here is what made a
     * sign-out look like an expired session.
     */
    private static void clearTokens(SharedPreferences preferences) {
        preferences.edit()
                .remove(Keys.SPOTIFY_ACCESS_TOKEN)
                .remove(Keys.SPOTIFY_REFRESH_TOKEN)
                .remove(Keys.SPOTIFY_TOKEN_EXPIRY)
                .remove(PREF_GRANTED_SCOPE)
                .commit();
    }

    private static void clearPendingAuth(SharedPreferences preferences) {
        preferences.edit()
                .remove(Keys.SPOTIFY_CODE_VERIFIER)
                .remove(Keys.SPOTIFY_AUTH_STATE)
                .commit();
    }

    /** Thrown when no amount of retrying will help and the user has to sign in. */
    public static class AuthRequiredException extends IOException {
        public AuthRequiredException(String message) {
            super(message);
        }
    }

    // ====================================================================
    // The widget path: cached and non-blocking
    // ====================================================================

    /** Run on the main thread once a lookup changes what is known. */
    public static void setOnUpdated(Runnable runnable) {
        onUpdated = runnable;
    }

    /**
     * The favorite state for a track, from the last lookup.
     *
     * Never blocks and never touches the network on the calling thread. A stale
     * or missing answer starts a refresh and reports UNKNOWN until it lands,
     * which is what the widget draws as a plain outline.
     */
    public static int getState(Context context, String libraryUri) {
        if (context == null || TextUtils.isEmpty(libraryUri) || !isLoggedIn(context)) {
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }

        requestRefresh(context, libraryUri);

        return libraryUri.equals(knownUri)
                ? knownState
                : MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
    }

    /**
     * Starts a lookup when what is known is missing or stale. Returns at once.
     *
     * Called from the widget tick, so every branch here is a decision not to
     * make a request. The API is rate limited per application, and the
     * application is the user's own - spending their quota on a value that has
     * not changed shows up as the button going dead for minutes at a time.
     */
    public static void requestRefresh(Context context, String libraryUri) {
        if (context == null || TextUtils.isEmpty(libraryUri)) {
            return;
        }
        if (isAuthBroken() || !isLoggedIn(context)) {
            return;
        }

        long now = SystemClock.elapsedRealtime();
        boolean sameItem = libraryUri.equals(knownUri);

        if (sameItem
                && knownState != MediaFavoriteController.FAVORITE_STATE_UNKNOWN
                && now - knownAtMs < STATE_MAX_AGE_MS) {
            return;
        }
        if (libraryUri.equals(lastAttemptUri) && now - lastAttemptAtMs < RETRY_DELAY_MS) {
            // A lookup for this track failed or is still in flight; asking
            // again a tick later would only queue a second one behind it.
            return;
        }

        if (!REFRESH_RUNNING.compareAndSet(false, true)) {
            // A flag nothing clears is a button that never works again, so it
            // gets a deadline of its own rather than being trusted outright.
            if (now - refreshStartedAtMs < REFRESH_STUCK_AFTER_MS) {
                return;
            }
            Log.w(TAG, "The previous Spotify lookup never finished; starting another");
        }

        refreshStartedAtMs = now;
        lastAttemptUri = libraryUri;
        lastAttemptAtMs = now;

        final Context appContext = context.getApplicationContext();
        try {
            IO.execute(() -> {
                try {
                    int state = fetchSavedState(appContext, libraryUri);
                    if (state != MediaFavoriteController.FAVORITE_STATE_UNKNOWN) {
                        noteState(libraryUri, state);
                        notifyUpdated();
                    }
                } finally {
                    REFRESH_RUNNING.set(false);
                }
            });
        } catch (Throwable t) {
            // The task never ran, so nothing else will clear the flag.
            REFRESH_RUNNING.set(false);
            Log.w(TAG, "Could not start the Spotify lookup", t);
        }
    }

    /**
     * Records a state the launcher has just brought about itself.
     *
     * Used after a successful write, so the widget shows the new state without
     * waiting for a read that would only confirm what we already did.
     */
    public static void setState(String libraryUri, int state) {
        if (TextUtils.isEmpty(libraryUri)) {
            return;
        }
        noteState(libraryUri, state);
    }

    private static void noteState(String libraryUri, int state) {
        knownUri = libraryUri;
        knownState = state;
        knownAtMs = SystemClock.elapsedRealtime();
    }

    private static void forgetState() {
        knownUri = null;
        knownState = MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        knownAtMs = 0L;
        lastAttemptUri = null;
        lastAttemptAtMs = 0L;
    }

    private static void notifyUpdated() {
        Runnable runnable = onUpdated;
        if (runnable != null) {
            MAIN.post(runnable);
        }
    }

    /**
     * Writes a rating and redraws the widget once the account has been updated.
     *
     * The new state is recorded first so the heart responds to the press rather
     * than to the network, and rolled back if the write is refused. A button
     * that moves only after a round trip reads as broken on a head unit with a
     * slow connection.
     */
    public static void applyRating(
            Context context, String libraryUri, boolean like, Runnable afterWrite) {
        if (context == null || TextUtils.isEmpty(libraryUri)) {
            return;
        }

        final Context appContext = context.getApplicationContext();
        final int optimistic = like
                ? MediaFavoriteController.FAVORITE_STATE_FAVORITED
                : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
        final int previous = libraryUri.equals(knownUri)
                ? knownState
                : MediaFavoriteController.FAVORITE_STATE_UNKNOWN;

        noteState(libraryUri, optimistic);
        notifyUpdated();

        IO.execute(() -> {
            boolean written = setRating(appContext, libraryUri, like);
            if (!written) {
                noteState(libraryUri, previous);
                Log.w(TAG, "The Spotify write was refused; the state was rolled back");
            }
            notifyUpdated();
            if (afterWrite != null) {
                MAIN.post(afterWrite);
            }
        });
    }

    // ====================================================================
    // The API itself. Blocking; background threads only.
    // ====================================================================

    /**
     * Blocking. Whether an item is in the user's library.
     *
     * @return one of the MediaFavoriteController.FAVORITE_STATE_* values, and
     *         UNKNOWN when the question could not be answered
     */
    public static int fetchSavedState(Context context, String libraryUri) {
        if (context == null || TextUtils.isEmpty(libraryUri)) {
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }

        try {
            String saveable = toSaveableUri(context, libraryUri);
            if (saveable == null) {
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }

            Response response = api(context, "GET",
                    API_BASE + "/me/library/contains?uris=" + encode(saveable));

            if (response.code != 200) {
                Log.w(TAG, "library/contains returned HTTP " + response.code
                        + " for " + saveable + ": " + describeError(response.body));
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }

            JSONArray array = new JSONArray(response.body);
            if (array.length() == 0) {
                return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
            }
            return array.optBoolean(0, false)
                    ? MediaFavoriteController.FAVORITE_STATE_FAVORITED
                    : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
        } catch (AuthRequiredException e) {
            noteAuthBroken(e);
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        } catch (Exception e) {
            Log.w(TAG, "Could not read the saved state: " + message(e));
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }
    }

    /**
     * Blocking. Adds an item to the library or removes it.
     *
     * @return true when the account was updated
     */
    public static boolean setRating(Context context, String libraryUri, boolean like) {
        if (context == null || TextUtils.isEmpty(libraryUri)) {
            return false;
        }

        try {
            String saveable = toSaveableUri(context, libraryUri);
            if (saveable == null) {
                return false;
            }

            Response response = api(context, like ? "PUT" : "DELETE",
                    API_BASE + "/me/library?uris=" + encode(saveable));

            if (response.code / 100 == 2) {
                return true;
            }
            Log.w(TAG, "me/library returned HTTP " + response.code
                    + " " + describeError(response.body));
            return false;
        } catch (AuthRequiredException e) {
            noteAuthBroken(e);
            return false;
        } catch (Exception e) {
            Log.w(TAG, "Could not write the rating: " + message(e));
            return false;
        }
    }

    /**
     * Blocking. The URI of whatever the account is playing, from the server.
     *
     * The slow way round, and a fallback rather than the main path: the URI is
     * normally read straight off the media session, which costs nothing and is
     * not rate limited. This exists for the cases where the session publishes
     * no usable media id - an older Spotify build, or playback that started on
     * another device and is only being controlled from here.
     *
     * @return null when nothing is playing, or what is playing has nothing in
     *         the catalogue behind it: an advert, a local file
     */
    public static String fetchCurrentLibraryUri(Context context) {
        if (context == null) {
            return null;
        }

        try {
            Response response = api(context, "GET",
                    API_BASE + "/me/player/currently-playing?market=from_token");

            // 204 is an active session with nothing playing; 202 is a device
            // still waking up. Neither is an error.
            if (response.code == 204 || response.code == 202
                    || TextUtils.isEmpty(response.body)) {
                return null;
            }
            if (response.code != 200) {
                Log.w(TAG, "currently-playing returned HTTP " + response.code);
                return null;
            }

            JSONObject json = new JSONObject(response.body);
            String type = json.optString("currently_playing_type", "track");

            // "ad" and "unknown" are the two that have nothing behind them.
            if (!"track".equals(type) && !"episode".equals(type)) {
                return null;
            }

            JSONObject item = json.optJSONObject("item");
            String id = item == null ? null : optString(item, "id");
            return id == null ? null : "spotify:" + type + ":" + id;
        } catch (AuthRequiredException e) {
            noteAuthBroken(e);
            return null;
        } catch (Exception e) {
            Log.w(TAG, "Could not read what is playing: " + message(e));
            return null;
        }
    }

    /**
     * The URI the library endpoint will actually accept for what is playing.
     *
     * Everything passes through unchanged except a chapter. Audiobooks are
     * saved whole, and a chapter is a part of one, so the library has nothing
     * to say about a chapter URI - it answers 400. Resolving it costs one
     * request, which is why the answer is kept: a chapter belongs to the same
     * audiobook for as long as it exists, so unlike a saved state there is
     * nothing here that can go stale.
     */
    private static String toSaveableUri(Context context, String libraryUri) throws IOException {
        String kind = kindOf(libraryUri);
        if (!"chapter".equals(kind)) {
            return libraryUri;
        }

        if (libraryUri.equals(chapterUri)) {
            return chapterAudiobookUri;
        }

        try {
            Response response = api(context, "GET",
                    API_BASE + "/chapters/" + encode(idOf(libraryUri)) + "?market=from_token");
            if (response.code != 200) {
                Log.w(TAG, "chapters returned HTTP " + response.code
                        + " " + describeError(response.body));
                return null;
            }

            JSONObject audiobook = new JSONObject(response.body).optJSONObject("audiobook");
            String id = audiobook == null ? null : optString(audiobook, "id");
            if (id == null) {
                return null;
            }

            chapterUri = libraryUri;
            chapterAudiobookUri = "spotify:audiobook:" + id;
            Log.d(TAG, "Chapter " + libraryUri + " belongs to " + chapterAudiobookUri);
            return chapterAudiobookUri;
        } catch (JSONException e) {
            throw new IOException("unreadable chapter response", e);
        }
    }

    /** The last chapter resolved, and what it resolved to. */
    private static volatile String chapterUri;
    private static volatile String chapterAudiobookUri;

    /**
     * One signed request, with a single retry after a forced refresh.
     *
     * A 401 on a token believed good means it was revoked early - a password
     * change, or the user pulling the grant from their Spotify account. One
     * refresh tells that apart from a token that merely expired; a second 401
     * settles it.
     */
    private static Response api(Context context, String method, String url) throws IOException {
        // PUT carries no body, but sending it with no Content-Length at all
        // makes some proxies drop the request.
        byte[] body = "PUT".equals(method) ? new byte[0] : null;

        String token = getValidAccessToken(context, false);
        Response response = execute(method, url, bearer(token), body, null);

        if (response.code == 401) {
            token = getValidAccessToken(context, true);
            response = execute(method, url, bearer(token), body, null);
        }

        if (response.code == 401) {
            // Refused on a token the server had just issued, so the token is
            // not the problem - the grant behind it is.
            throw new AuthRequiredException(
                    "refused twice, " + noteRefusal(401, response.body));
        }
        if (response.code == 403) {
            // A missing scope, an account the application was never cleared
            // for, and an endpoint that no longer serves anyone all arrive
            // here looking the same, so the body is logged whole rather than
            // summarised - the one time it mattered, the summary said only
            // "Forbidden" and the distinguishing detail was which path had
            // been asked.
            Log.w(TAG, "403 on " + url + " body: " + trimTo(response.body, 400));
            throw new AuthRequiredException(noteRefusal(403, response.body));
        }

        if (response.code / 100 == 2) {
            // An answer is proof the grant works, and the surest way out of a
            // refusal that was wrong.
            authBroken = false;
            lastRefusal = null;
        }
        return response;
    }

    /** Records what the server said, and returns it for the exception message. */
    private static String noteRefusal(int code, String body) {
        String text = "HTTP " + code + " " + describeError(body);
        lastRefusal = text;
        return text;
    }

    private static String trimTo(String text, int max) {
        if (text == null) {
            return "";
        }
        return text.length() > max ? text.substring(0, max) : text;
    }

    private static void noteAuthBroken(AuthRequiredException e) {
        if (!authBroken) {
            Log.w(TAG, "Spotify needs signing in again: " + message(e));
        }
        authBroken = true;
        authBrokenAtMs = SystemClock.elapsedRealtime();
        forgetState();
    }

    // ====================================================================
    // Track ids
    // ====================================================================

    /**
     * The bare track id out of whatever Spotify put in the session.
     *
     * Accepts the full URI it normally publishes, an open.spotify.com link, or
     * an id on its own.
     */
    public static String extractLibraryUri(String candidate) {
        if (TextUtils.isEmpty(candidate)) {
            return null;
        }

        Matcher uri = SPOTIFY_URI.matcher(candidate);
        if (uri.find()) {
            return "spotify:" + uri.group(1) + ":" + uri.group(2);
        }

        Matcher link = SPOTIFY_LINK.matcher(candidate);
        if (link.find()) {
            return "spotify:" + link.group(1) + ":" + link.group(2);
        }

        // A bare id names something, but nothing here says what. Tracks are
        // the overwhelming majority of what plays, and a wrong guess costs one
        // refused request rather than a wrong save: the library endpoint
        // answers an id that is not a track with a 400, not with somebody
        // else's episode.
        return BARE_ID.matcher(candidate).matches() ? trackUri(candidate) : null;
    }

    // ====================================================================
    // Settings screen
    // ====================================================================

    /**
     * Checks the Client ID and starts the sign-in, or explains why it cannot.
     *
     * The Client ID is the one thing the user has to fetch for themselves, so
     * the refusal names it rather than reporting a generic failure.
     */
    public static void handlePreferenceClick(Context context) {
        if (context == null) {
            return;
        }
        if (!hasClientId(context)) {
            toast(context, R.string.spotify_client_id_missing);
            return;
        }
        if (isLoggedIn(context)) {
            // Signing in again is how a user recovers from a revoked grant or
            // picks up a new scope, so it is allowed rather than refused.
            Log.d(TAG, "Signing in to Spotify again over an existing grant");
        }
        toast(context, R.string.spotify_opening_browser);
        startLogin(context);
    }

    /**
     * Draws the summaries for the Spotify entries.
     *
     * Everything shown here is local, so unlike {@link FytRating#syncPreference}
     * there is nothing to wait for and no background refresh to start.
     */
    public static void syncPreference(
            Context context, Preference clientIdPreference, Preference oauthPreference) {
        if (context == null) {
            return;
        }

        boolean hasClientId = hasClientId(context);
        boolean loggedIn = isLoggedIn(context);

        if (clientIdPreference != null) {
            clientIdPreference.setSummary(hasClientId
                    ? maskClientId(clientId(context))
                    : context.getString(R.string.spotify_client_id_summary));
        }

        if (oauthPreference != null) {
            int stateLine;
            if (!hasClientId) {
                stateLine = R.string.spotify_state_no_client_id;
            } else if (!loggedIn) {
                stateLine = R.string.spotify_state_not_logged_in;
            } else if (isAuthBroken()) {
                stateLine = R.string.spotify_state_expired;
            } else {
                stateLine = R.string.spotify_state_ready;
            }
            oauthPreference.setSummary(context.getString(stateLine));
        }
    }

    /**
     * A Client ID is not a secret, but a full one across a car screen is noise.
     * Enough is shown to tell two of them apart.
     */
    private static String maskClientId(String id) {
        String value = trim(id);
        if (value.length() <= 8) {
            return value;
        }
        return value.substring(0, 4) + "\u2026" + value.substring(value.length() - 4);
    }

    /** One line of diagnostics, in the shape the rest of the launcher logs. */
    public static String describe() {
        Context app = LauncherApplication.sApp;
        return "spotify clientId=" + (app != null && hasClientId(app))
                + " loggedIn=" + (app != null && isLoggedIn(app))
                + " authBroken=" + authBroken
                + " granted=" + (app == null
                        ? "?" : prefs(app).getString(PREF_GRANTED_SCOPE, "?"))
                + " lastRefusal=" + lastRefusal
                + " uri=" + knownUri
                + " state=" + knownState;
    }

    // ====================================================================
    // HTTP
    // ====================================================================

    private static final class Response {
        final int code;
        final String body;

        Response(int code, String body) {
            this.code = code;
            this.body = body;
        }
    }

    private static Response execute(
            String method, String url, String authorization, byte[] body, String contentType)
            throws IOException {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(CONNECT_TIMEOUT_MS);
            connection.setReadTimeout(READ_TIMEOUT_MS);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Accept", "application/json");
            if (authorization != null) {
                connection.setRequestProperty("Authorization", authorization);
            }

            if (body != null) {
                connection.setDoOutput(true);
                connection.setFixedLengthStreamingMode(body.length);
                if (contentType != null) {
                    connection.setRequestProperty("Content-Type", contentType);
                }
                OutputStream out = connection.getOutputStream();
                try {
                    if (body.length > 0) {
                        out.write(body);
                    }
                    out.flush();
                } finally {
                    closeQuietly(out);
                }
            }

            int code = connection.getResponseCode();
            InputStream in = (code >= 200 && code < 400)
                    ? connection.getInputStream()
                    : connection.getErrorStream();
            return new Response(code, readAll(in));
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String readAll(InputStream in) {
        if (in == null) {
            return "";
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        try {
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            return out.toString("UTF-8");
        } catch (IOException e) {
            return "";
        } finally {
            closeQuietly(in);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException ignored) {
        }
    }

    private static String form(String... pairs) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i + 1 < pairs.length; i += 2) {
            if (builder.length() > 0) {
                builder.append('&');
            }
            builder.append(URLEncoder.encode(pairs[i], "UTF-8"))
                    .append('=')
                    .append(URLEncoder.encode(pairs[i + 1], "UTF-8"));
        }
        return builder.toString();
    }

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }

    private static String bearer(String token) {
        return "Bearer " + token;
    }

    // ====================================================================
    // Small helpers
    // ====================================================================

    private static SharedPreferences prefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    private static String clientId(Context context) {
        return trim(prefs(context).getString(Keys.SPOTIFY_CLIENT_ID, ""));
    }

    private static String trim(String value) {
        return value == null ? "" : value.trim();
    }

    /** optString that answers null for a JSON null rather than the text "null". */
    private static String optString(JSONObject json, String key) {
        if (json == null || json.isNull(key)) {
            return null;
        }
        String value = json.optString(key, null);
        return TextUtils.isEmpty(value) ? null : value;
    }

    private static String describeError(String body) {
        if (TextUtils.isEmpty(body)) {
            return "no detail";
        }
        try {
            JSONObject json = new JSONObject(body);

            // The accounts service reports it flat; the Web API nests it.
            String description = optString(json, "error_description");
            if (description != null) {
                return description;
            }
            JSONObject error = json.optJSONObject("error");
            if (error != null) {
                String nested = optString(error, "message");
                if (nested != null) {
                    return nested;
                }
            }
            String plain = optString(json, "error");
            if (plain != null) {
                return plain;
            }
        } catch (JSONException ignored) {
        }
        return body.length() > 200 ? body.substring(0, 200) : body;
    }

    private static String message(Exception e) {
        String text = e.getMessage();
        return TextUtils.isEmpty(text) ? e.getClass().getSimpleName() : text;
    }

    private static void fail(final AuthCallback callback, final String reason) {
        Log.w(TAG, "Spotify authorisation failed: " + reason);
        if (callback == null) {
            return;
        }
        MAIN.post(() -> callback.onError(reason));
    }

    private static void toast(Context context, final int stringId) {
        final Context appContext = context.getApplicationContext();
        MAIN.post(() -> Toast.makeText(appContext, stringId, Toast.LENGTH_LONG).show());
    }
}
