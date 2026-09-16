package com.android.launcher66.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.android.launcher66.R;

/**
 * Catches the redirect back from the browser after a Spotify sign-in.
 *
 * Draws nothing: it takes the Uri, hands it to {@link SpotifyRating} and
 * finishes. The token exchange runs on a background thread and outlives this
 * activity, so the messages use the application context rather than this one.
 */
public class SpotifyAuthCallbackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    /**
     * The activity is singleTask, so a second redirect arriving while it is
     * still alive comes through here rather than onCreate.
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        final Context appContext = getApplicationContext();
        Uri uri = intent == null ? null : intent.getData();

        if (!SpotifyRating.isAuthCallback(uri)) {
            // Anything can fire an intent at our scheme. Nothing to report:
            // the user never asked for this one.
            finish();
            return;
        }

        SpotifyRating.handleAuthorizationResponse(appContext, uri, new SpotifyRating.AuthCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(appContext, R.string.spotify_logged_in, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String message) {
                Toast.makeText(
                        appContext,
                        appContext.getString(R.string.spotify_login_error, message),
                        Toast.LENGTH_LONG).show();
            }
        });

        finish();
    }
}
