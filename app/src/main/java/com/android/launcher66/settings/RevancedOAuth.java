package com.android.launcher66.settings;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;

import com.android.launcher66.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Google authorisation for reading the like status of YouTube videos.
 *
 * Authentication is delegated to GmsCore, which already holds the user's
 * Google account: the launcher asks it for an access token through the
 * standard AccountManager API, and Google identifies the caller by its package
 * name and signature. No client id or secret is embedded anywhere, and nothing
 * account specific ships with the application.
 *
 * Everything here is a no-op when GmsCore is absent.
 */
public final class RevancedOAuth {

    private static final String TAG = "RevancedOAuth";

    /**
     * videos.getRating returns the signed in user's own rating, which the
     * read-only scope does not cover - it answers 403 with
     * ACCESS_TOKEN_SCOPE_INSUFFICIENT. This is the scope the YouTube
     * application itself requests.
     */
    private static final String AUTH_TOKEN_TYPE =
            "oauth2:https://www.googleapis.com/auth/youtube.force-ssl";

    private static final String ACCOUNT_TYPE = "com.google";

    /** ReVanced ships its own GmsCore; the stock one works just as well. */
    private static final String[] GMS_PACKAGES = {
            "app.revanced.android.gms",
            "com.google.android.gms",
    };

    private static final String CHANNEL_URL =
            "https://www.googleapis.com/youtube/v3/channels?part=snippet&mine=true";
    private static final String RATING_URL =
            "https://www.googleapis.com/youtube/v3/videos/getRating?id=";
    private static final String STATUS_URL =
            "https://www.googleapis.com/youtube/v3/videos?part=status&id=";
    private static final String RATE_URL =
            "https://www.googleapis.com/youtube/v3/videos/rate?rating=";

    private static final String PREFS_NAME = "revanced_oauth";
    private static final String KEY_ACCOUNT_NAME = "account_name";
    private static final String KEY_DISPLAY_NAME = "display_name";

    /** The patched YouTube build this feature is built around. */
    private static final String YOUTUBE_REVANCED_PACKAGE = "app.revanced.android.youtube";

    /** Two taps closer together than this open the sign out dialog. */
    private static final long DOUBLE_TAP_WINDOW_MS = 600L;

    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private static volatile String cachedToken;
    private static long lastClickAtMs;

    private RevancedOAuth() {
    }

    // ---------------------------------------------------------------- state

    /**
     * True when a provider of Google account services is present. Without one
     * there is nothing to ask for a token, so the feature stays unavailable.
     */
    public static boolean isGmsCoreInstalled(Context context) {
        for (String candidate : GMS_PACKAGES) {
            if (isPackageInstalled(context, candidate)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPackageInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isYouTubeInstalled(Context context) {
        return packageVersion(context) != null;
    }

    /**
     * Identity of an installed package, used to tell an update apart from the
     * build the patch was last seen in.
     *
     * @return version and install time, or null when the package is absent
     */
    private static String packageVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(RevancedOAuth.YOUTUBE_REVANCED_PACKAGE, 0);
            return info.versionName + "/" + info.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean isLoggedIn(Context context) {
        return isGmsCoreInstalled(context)
                && isYouTubeInstalled(context)
                && getAccountName(context) != null;
    }

    /**
     * Signs out when a package the feature depends on has been removed, so a
     * stale grant does not linger behind a summary claiming it is connected.
     */
    public static void dropStaleLogin(Context context) {
        if (getAccountName(context) == null) {
            return;
        }
        if (isGmsCoreInstalled(context) && isYouTubeInstalled(context)) {
            return;
        }
        Log.d(TAG, "A required package is gone, signing out");
        logout(context);
    }

    /** Channel title if it is known, otherwise the account address. */
    public static String getDisplayName(Context context) {
        SharedPreferences prefs = prefs(context);
        String display = prefs.getString(KEY_DISPLAY_NAME, null);
        return display != null ? display : prefs.getString(KEY_ACCOUNT_NAME, null);
    }

    private static String getAccountName(Context context) {
        String name = prefs(context).getString(KEY_ACCOUNT_NAME, null);
        return name == null || name.isEmpty() ? null : name;
    }

    public static void logout(Context context) {
        String token = cachedToken;
        if (token != null) {
            // Drop it on the GmsCore side too, so a later grant starts clean.
            AccountManager.get(context).invalidateAuthToken(ACCOUNT_TYPE, token);
        }
        cachedToken = null;
        prefs(context).edit().remove(KEY_ACCOUNT_NAME).remove(KEY_DISPLAY_NAME).apply();
    }

    // ----------------------------------------------------------- ui entry

    /**
     * Handles a tap on the authorisation preference.
     *
     * Signed out, a tap starts the account picker. Signed in, a tap only
     * reports who is signed in, and a second tap within the double tap window
     * offers to sign out - so a stray tap cannot drop the authorisation.
     */
    public static void handlePreferenceClick(Activity activity, Preference oauthForYoutubeRevanced, Preference youtubeRevancedKids) {
        long now = System.currentTimeMillis();
        boolean doubleTap = now - lastClickAtMs < DOUBLE_TAP_WINDOW_MS;
        lastClickAtMs = now;

        // A package may have gone away since the screen was opened.
        dropStaleLogin(activity);

        if (!isGmsCoreInstalled(activity)) {
            updateSummary(activity, oauthForYoutubeRevanced, youtubeRevancedKids);
            Toast.makeText(activity, R.string.oauth_missing_gmscore, Toast.LENGTH_LONG).show();
            return;
        }

        if (!isYouTubeInstalled(activity)) {
            updateSummary(activity, oauthForYoutubeRevanced, youtubeRevancedKids);
            Toast.makeText(activity, R.string.oauth_missing_youtube, Toast.LENGTH_LONG).show();
            return;
        }

        if (!isLoggedIn(activity)) {
            // A second tap must not open the account picker again.
            if (!doubleTap) {
                requestAccount(activity, oauthForYoutubeRevanced, youtubeRevancedKids);
            }
            return;
        }

        String account = getDisplayName(activity);
        if (account == null) {
            account = activity.getString(R.string.oauth_unknown_account);
        }

        if (doubleTap) {
            confirmLogout(activity, oauthForYoutubeRevanced, youtubeRevancedKids, account);
        } else {
            Toast.makeText(
                    activity,
                    activity.getString(R.string.oauth_already_logged_in, account),
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    /**
     * Shows the linked account in the preference summary. Call from onResume
     * so the entry reflects reality after signing in or out.
     */
    public static void syncPreference(Context context, Preference oauthForYoutubeRevanced, Preference youtubeRevancedKids) {
        dropStaleLogin(context);
        updateSummary(context, oauthForYoutubeRevanced, youtubeRevancedKids);
    }

    /**
     * Three lines: one per package the feature needs, then the account.
     *
     * Only the presence of the patched YouTube build is reported, not whether
     * the patch itself is applied - that cannot be told without the
     * application running, so the requirement is stated in the line instead.
     */
    private static void updateSummary(Context context, Preference oauthForYoutubeRevanced, Preference youtubeRevancedKids) {
        if (oauthForYoutubeRevanced == null) {
            return;
        }

        String installed = context.getString(R.string.oauth_installed);
        String notInstalled = context.getString(R.string.oauth_not_installed);
        String account = getDisplayName(context);

        oauthForYoutubeRevanced.setSummary(
                context.getString(R.string.oauth_status_gmscore,
                        isGmsCoreInstalled(context) ? installed : notInstalled)
                        + "\n"
                        + context.getString(R.string.oauth_status_youtube,
                        isYouTubeInstalled(context) ? installed : notInstalled)
                        + "\n\n"
                        + (account == null
                        ? context.getString(R.string.oauth_status_not_connected)
                        : context.getString(R.string.oauth_status_connected, account))
        );

        if (youtubeRevancedKids == null) {
            return;
        }
        youtubeRevancedKids.setVisible(isLoggedIn(context));
    }

    private static void confirmLogout(Activity activity, Preference oauthForYoutubeRevanced, Preference youtubeRevancedKids, String account) {
        new AlertDialog.Builder(activity)
                .setTitle(R.string.oauth_logout_title)
                .setMessage(activity.getString(R.string.oauth_logout_message, account))
                .setNegativeButton(R.string.oauth_no, (dialog, which) -> dialog.dismiss())
                .setPositiveButton(R.string.oauth_yes, (dialog, which) -> {
                    logout(activity);
                    updateSummary(activity, oauthForYoutubeRevanced, youtubeRevancedKids);
                    dialog.dismiss();
                    Toast.makeText(activity, R.string.oauth_logged_out, Toast.LENGTH_SHORT).show();
                })
                .show();
    }

    // ------------------------------------------------------ account picker

    /**
     * Shows the account picker and the consent screen, both rendered by
     * GmsCore. Using getAuthTokenByFeatures avoids the GET_ACCOUNTS permission
     * entirely: the launcher never enumerates accounts, it only receives the
     * one the user picked.
     */
    private static void requestAccount(Activity activity, Preference oauthForYoutubeRevanced, Preference youtubeRevancedKids) {
        // AccountManager keeps its request objects alive in native code long
        // after they are needed, so nothing here may hold the Activity
        // strongly - the callback would otherwise leak the whole screen.
        Context appContext = activity.getApplicationContext();
        WeakReference<Activity> activityRef = new WeakReference<>(activity);
        WeakReference<Preference> oauthForYoutubeRevancedRef = new WeakReference<>(oauthForYoutubeRevanced);
        WeakReference<Preference> youtubeRevancedKidsRef = new WeakReference<>(youtubeRevancedKids);

        AccountManager.get(appContext).getAuthTokenByFeatures(
                ACCOUNT_TYPE,
                AUTH_TOKEN_TYPE,
                null,
                activity,
                null,
                null,
                future -> EXECUTOR.execute(
                        () -> onAccountPicked(appContext, activityRef, oauthForYoutubeRevancedRef, youtubeRevancedKidsRef, future)),
                MAIN
        );
    }

    private static void onAccountPicked(
            Context appContext,
            WeakReference<Activity> activityRef,
            WeakReference<Preference> oauthForYoutubeRevancedRef,
            WeakReference<Preference> youtubeRevancedKidsRef,
            AccountManagerFuture<Bundle> future
    ) {
        try {
            Bundle result = future.getResult();
            String accountName = result.getString(AccountManager.KEY_ACCOUNT_NAME);
            String token = result.getString(AccountManager.KEY_AUTHTOKEN);

            if (accountName == null || token == null) {
                toast(activityRef, appContext.getString(R.string.oauth_cancelled),
                        Toast.LENGTH_SHORT);
                return;
            }

            cachedToken = token;
            prefs(appContext).edit().putString(KEY_ACCOUNT_NAME, accountName).apply();

            // The channel title is nicer to show than the address, but it is
            // only cosmetic: a failure here must not undo a successful sign in.
            String display = fetchChannelTitle(token);
            if (display != null) {
                prefs(appContext).edit().putString(KEY_DISPLAY_NAME, display).apply();
            }

            String shown = display != null ? display : accountName;
            MAIN.post(() -> {
                Preference preferenceOauth = oauthForYoutubeRevancedRef.get();
                Preference preferenceKids = youtubeRevancedKidsRef.get();
                if (preferenceOauth != null && preferenceKids != null) {
                    updateSummary(appContext, preferenceOauth, preferenceKids);
                }
                Activity activity = activityRef.get();
                if (activity != null && !activity.isFinishing()) {
                    Toast.makeText(activity,
                            activity.getString(R.string.oauth_logged_in, shown),
                            Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Log.w(TAG, "Authorisation failed", e);
            toast(activityRef, describeAuthFailure(e), Toast.LENGTH_LONG);
        }
    }

    private static void toast(WeakReference<Activity> activityRef, String message, int length) {
        MAIN.post(() -> {
            Activity activity = activityRef.get();
            if (activity != null && !activity.isFinishing()) {
                Toast.makeText(activity, message, length).show();
            }
        });
    }

    /**
     * Turns an authorisation failure into something the user can act on.
     *
     * The signing key case matters for anyone building this project: Google
     * identifies the application by its package name and certificate, so a
     * build signed with a different key is an unknown client to it.
     */
    private static String describeAuthFailure(Exception e) {
        String message = e.getMessage() == null ? e.toString() : e.getMessage();

        if (message.contains("UnregisteredOnApiConsole")) {
            return "This build's signing key is not registered with Google. "
                    + "Build with the signing key shipped in the repository, or "
                    + "register your own SHA-1 in the Google Cloud console - "
                    + "see the project README.";
        }
        if (message.contains("NetworkError") || message.contains("ServiceDisabled")) {
            return "Could not reach Google, check the network connection";
        }
        if (message.contains("INVALID_SCOPE") || message.contains("invalid_scope")) {
            return "The YouTube scope is not enabled for this OAuth client";
        }
        if (message.contains("canceled") || message.contains("Cancel")) {
            return "Authorisation cancelled";
        }
        return "Authorisation failed: " + message;
    }

    // ------------------------------------------------------------- tokens

    /**
     * Returns a usable access token. Blocking; call from a background thread.
     *
     * GmsCore caches tokens itself, so asking it every time is cheap. A token
     * rejected by the API is invalidated and fetched again once.
     */
    private static String getToken(Context context, boolean forceRefresh) {
        String accountName = getAccountName(context);
        if (accountName == null || !isGmsCoreInstalled(context)) {
            return null;
        }

        AccountManager accountManager = AccountManager.get(context);

        if (forceRefresh && cachedToken != null) {
            accountManager.invalidateAuthToken(ACCOUNT_TYPE, cachedToken);
            cachedToken = null;
        }
        if (cachedToken != null) {
            return cachedToken;
        }

        try {
            // The account object can be built from the stored name; no lookup
            // and therefore no GET_ACCOUNTS permission is needed.
            Account account = new Account(accountName, ACCOUNT_TYPE);
            Bundle result = accountManager
                    .getAuthToken(account, AUTH_TOKEN_TYPE, null, false, null, null)
                    .getResult();

            cachedToken = result.getString(AccountManager.KEY_AUTHTOKEN);

            if (cachedToken == null) {
                // No token means consent is missing for this scope: the stored
                // grant covers an older one. Returning an Intent is how the
                // account manager asks for the user to approve it, and that
                // cannot happen from here - only from the settings screen.
                if (result.containsKey(AccountManager.KEY_INTENT)) {
                    Log.w(TAG, "Consent required for " + AUTH_TOKEN_TYPE
                            + ". Log out and back in on the settings screen so the "
                            + "account manager can ask for it.");
                } else {
                    Log.w(TAG, "No token returned, bundle keys: " + result.keySet());
                }
            }

            return cachedToken;
        } catch (Exception e) {
            Log.w(TAG, "Could not obtain a token", e);
            return null;
        }
    }

    // ---------------------------------------------------------- api calls

    /**
     * Reads the like status of a video.
     *
     * Blocking; call from a background thread.
     *
     * @return "like", "dislike", "none", or null when it cannot be told
     */
    public static String fetchRating(Context context, String videoId) throws IOException {
        if (videoId == null || videoId.isEmpty() || !isLoggedIn(context)) {
            return null;
        }

        String rating = requestRating(context, videoId, false);
        if (rating == null) {
            // Most likely an expired token or a changed scope: drop it and
            // try once more with a freshly issued one.
            rating = requestRating(context, videoId, true);
        }
        if (rating == null) {
            Log.w(TAG, "No rating for " + videoId + "; the token was rejected twice. "
                    + "If the log shows ACCESS_TOKEN_SCOPE_INSUFFICIENT, add the "
                    + "youtube.force-ssl scope in the Cloud console, then log out "
                    + "and back in so GmsCore asks for consent again.");
        } else {
            Log.d(TAG, "Rating for " + videoId + " is " + rating);
        }
        return rating;
    }

    private static String requestRating(Context context, String videoId, boolean forceRefresh)
            throws IOException {
        String token = getToken(context, forceRefresh);
        if (token == null) {
            return null;
        }

        JSONObject response = get(RATING_URL + encode(videoId), token);
        if (response == null) {
            return null;
        }

        // The raw body, so a disagreement with what the browser shows can be
        // told apart from a parsing problem or a stale cached response.
        Log.d(TAG, "getRating(" + videoId + ") raw: " + response);

        try {
            JSONArray items = response.optJSONArray("items");
            if (items == null || items.length() == 0) {
                return null;
            }
            return items.getJSONObject(0).optString("rating", null);
        } catch (JSONException e) {
            throw new IOException("Malformed rating response", e);
        }
    }

    /**
     * Sets or clears the like on a video.
     *
     * Written through the Data API rather than through the media session:
     * a rating sent to YouTube with MediaController.setRating only lights up
     * its own interface and never reaches the account, so the like would be
     * invisible everywhere else and would vanish on reinstall.
     *
     * Blocking; call from a background thread.
     *
     * @return true when the account was updated
     */
    public static boolean setRating(Context context, String videoId, boolean like) {
        if (videoId == null || videoId.isEmpty() || !isLoggedIn(context)) {
            return false;
        }

        try {
            if (sendRating(context, videoId, like, false)) {
                return true;
            }
            // An expired token or a changed scope: retry once with a new one.
            return sendRating(context, videoId, like, true);
        } catch (IOException e) {
            Log.w(TAG, "Could not set the rating for " + videoId, e);
            return false;
        }
    }

    private static boolean sendRating(Context context, String videoId, boolean like,
                                      boolean forceRefresh) throws IOException {
        String token = getToken(context, forceRefresh);
        if (token == null) {
            return false;
        }

        String url = RATE_URL + (like ? "like" : "none") + "&id=" + encode(videoId);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setFixedLengthStreamingMode(0);
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setUseCaches(false);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Length", "0");

            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_NO_CONTENT || code == HttpURLConnection.HTTP_OK) {
                Log.d(TAG, "Rating for " + videoId + " set to " + (like ? "like" : "none"));
                return true;
            }

            Log.w(TAG, "Rating rejected, HTTP " + code + ": " + readBody(connection));
            return false;
        } finally {
            connection.disconnect();
        }
    }

    /**
     * Tells whether a video is marked as made for kids.
     *
     * YouTube reports no rating at all for such videos - getRating answers
     * "none" however the video was rated, and the account list omits it. The
     * status is therefore worth knowing so the launcher can show that it
     * cannot tell, rather than claiming the video is not liked.
     *
     * Blocking; call from a background thread.
     *
     * @return TRUE, FALSE, or null when the status cannot be read
     */
    public static Boolean isMadeForKids(Context context, String videoId) {
        if (videoId == null || videoId.isEmpty() || !isLoggedIn(context)) {
            return null;
        }

        try {
            String token = getToken(context, false);
            if (token == null) {
                return null;
            }

            JSONObject response = get(STATUS_URL + encode(videoId), token);
            JSONArray items = response == null ? null : response.optJSONArray("items");
            if (items == null || items.length() == 0) {
                return null;
            }

            JSONObject status = items.getJSONObject(0).optJSONObject("status");
            if (status == null || !status.has("madeForKids")) {
                return null;
            }
            return status.optBoolean("madeForKids") ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            Log.w(TAG, "Could not read the kids status of " + videoId, e);
            return null;
        }
    }

    /** Channel title of the signed in account, used only for display. */
    private static String fetchChannelTitle(String token) {
        try {
            JSONObject response = get(CHANNEL_URL, token);
            JSONArray items = response == null ? null : response.optJSONArray("items");
            if (items != null && items.length() > 0) {
                return items.getJSONObject(0)
                        .getJSONObject("snippet")
                        .optString("title", null);
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not read the channel title", e);
        }
        return null;
    }

    // ----------------------------------------------------------- plumbing

    private static JSONObject get(String url, String token) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            // Nothing here may be answered from a cache: the rating changes
            // while the application runs.
            connection.setUseCaches(false);
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setRequestProperty("Pragma", "no-cache");

            int code = connection.getResponseCode();
            String body = readBody(connection);

            if (code == HttpURLConnection.HTTP_UNAUTHORIZED
                    || code == HttpURLConnection.HTTP_FORBIDDEN) {
                // 401 is an expired token; 403 with an insufficient scope means
                // the grant predates a scope change. Both are fixed by asking
                // for a new token, so both signal the caller to retry. Logged
                // because a silent null here is impossible to diagnose.
                Log.w(TAG, "HTTP " + code + " from " + url + ": " + body);
                return null;
            }
            if (code >= 400) {
                throw new IOException("HTTP " + code + ": " + body);
            }

            return new JSONObject(body);
        } catch (JSONException e) {
            throw new IOException("Malformed response", e);
        } finally {
            connection.disconnect();
        }
    }

    /** Reads either stream: Google returns its error details in the body. */
    private static String readBody(HttpURLConnection connection) throws IOException {
        InputStream stream = connection.getResponseCode() >= 400
                ? connection.getErrorStream()
                : connection.getInputStream();
        if (stream == null) {
            return "{}";
        }

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            return value;
        }
    }

    private static SharedPreferences prefs(Context context) {
        return context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}