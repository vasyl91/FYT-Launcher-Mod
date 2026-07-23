package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Locale;

import android.os.Handler;
import android.os.Looper;

public final class MediaFavoriteController {
    public static final String ACTION_FAVORITE = "com.android.launcher66.action.MEDIA_FAVORITE";
    public static final int FAVORITE_STATE_UNKNOWN = 0;
    public static final int FAVORITE_STATE_NOT_FAVORITED = 1;
    public static final int FAVORITE_STATE_FAVORITED = 2;

    private static final String TAG = "MediaFavorite";
    private static final String PREFS_NAME = "media_favorite_state";
    private static final String PREF_PREFIX = "favorite:";
    private static final String SPOTIFY_PACKAGE = "com.spotify.music";
    private static final String APPLE_MUSIC_PACKAGE = "com.apple.android.music";
    private static final String YOUTUBE_MUSIC_PACKAGE = "com.google.android.apps.youtube.music";
    private static final String YOUTUBE_PACKAGE = "com.google.android.youtube";
    private static final String YOUTUBE_REVANCED_PACKAGE = "app.revanced.android.youtube";

    private static final boolean isMediaDebug = true;

    private MediaFavoriteController() {
    }

    public static boolean favoriteCurrent(Context context, String preferredPackage) {
        return toggleFavoriteCurrent(context, preferredPackage);
    }

    public static boolean toggleFavoriteCurrent(Context context, String preferredPackage) {
        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return false;
        }

        int stateBefore = getCurrentFavoriteState(context, preferredPackage);
        boolean sent = toggleFavorite(context, controller, toPrivateState(stateBefore));
        if (sent) {
            cachePublicFavoriteState(context, controller, getExpectedStateAfterToggle(stateBefore));
        }
        return sent;
    }

    public static int getCurrentFavoriteState(Context context, String preferredPackage) {
        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return FAVORITE_STATE_UNKNOWN;
        }

        PlaybackState state = safePlaybackState(controller);
        FavoriteActions actions = state == null
                ? new FavoriteActions()
                : findFavoriteActions(state.getCustomActions());
        int currentState = toPublicState(getFavoriteState(controller, actions));
        if (currentState != FAVORITE_STATE_UNKNOWN) {
            cachePublicFavoriteState(context, controller, currentState);
            return currentState;
        }

        if (YOUTUBE_PACKAGE.equals(controller.getPackageName()) || YOUTUBE_REVANCED_PACKAGE.equals(controller.getPackageName())) {
            return getCachedPublicFavoriteState(context, controller);
        }

        return getCachedPublicFavoriteState(context, controller);
    }

    public static String describeCurrentFavoriteState(Context context, String preferredPackage) {
        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return "controller=none";
        }

        PlaybackState state = safePlaybackState(controller);
        FavoriteActions actions = state == null
                ? new FavoriteActions()
                : findFavoriteActions(state.getCustomActions());
        FavoriteState observedState = getFavoriteState(controller, actions);
        int cachedState = getCachedPublicFavoriteState(context, controller);
        boolean ratingAction = state != null && (state.getActions() & PlaybackState.ACTION_SET_RATING) != 0;

        return "observed=" + observedState
                + ", cached=" + publicStateName(cachedState)
                + ", ratingAction=" + ratingAction
                + ", positiveAction=" + actionName(actions.positive)
                + ", negativeAction=" + actionName(actions.negative)
                + ", toggleAction=" + actionName(actions.toggle);
    }

    private static MediaController getTargetController(Context context, String preferredPackage) {
        MediaSessionManager sessionManager =
                (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
        if (sessionManager == null) {
            return null;
        }

        List<MediaController> controllers;
        try {
            controllers = sessionManager.getActiveSessions(new ComponentName(context, NotificationListener.class));
        } catch (SecurityException e) {
            Log.w(TAG, "Notification listener access is not enabled", e);
            return null;
        }

        return pickTargetController(controllers, preferredPackage);
    }

    private static MediaController pickTargetController(List<MediaController> controllers, String preferredPackage) {
        if (controllers == null || controllers.isEmpty()) {
            return null;
        }

        if (isExternalPackage(preferredPackage)) {
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

    private static boolean isExternalPackage(String packageName) {
        return packageName != null
                && !packageName.isEmpty()
                && !"null".equals(packageName)
                && !"com.syu.music".equals(packageName);
    }

    private static boolean isKnownFavoritePackage(String packageName) {
        return SPOTIFY_PACKAGE.equals(packageName)
                || APPLE_MUSIC_PACKAGE.equals(packageName)
                || YOUTUBE_MUSIC_PACKAGE.equals(packageName)
                || YOUTUBE_PACKAGE.equals(packageName)
                || YOUTUBE_REVANCED_PACKAGE.equals(packageName);
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
        return getMetadataFavoriteState(controller.getMetadata()) != FavoriteState.UNKNOWN;
    }

    private static boolean toggleFavorite(Context context, MediaController controller, FavoriteState assumedState) {
        PlaybackState state = controller.getPlaybackState();
        if (state == null) {
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

        String pkg = controller.getPackageName();
        if (YOUTUBE_PACKAGE.equals(pkg) || YOUTUBE_REVANCED_PACKAGE.equals(pkg)) {
            if (actions.positive != null) {
                return sendCustomAction(controller,
                        actions.positive,
                        "youtube like toggle");
            }

            if (favoriteState == FavoriteState.FAVORITED) {
                if (sendRatingValue(controller,
                        Rating.newUnratedRating(Rating.RATING_THUMB_UP_DOWN),
                        "youtube remove like")) {
                    return true;
                }
                return false;
            }

            if (sendRatingValue(controller, Rating.newThumbRating(true), "youtube like")) {
                return true;
            }

            return false;
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
            controller.getTransportControls().sendCustomAction(action.getAction(), (Bundle) null);
            Log.d(TAG, "Sent " + label + " custom action for " + controller.getPackageName() + ": " + action.getAction());
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to send " + label + " custom action for " + controller.getPackageName(), e);
            return false;
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
        FavoriteState metadataState = getMetadataFavoriteState(controller.getMetadata());
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

    private static FavoriteState getMetadataFavoriteState(MediaMetadata metadata) {
        if (metadata == null) {
            return FavoriteState.UNKNOWN;
        }
        FavoriteState userRatingState = ratingToFavoriteState(metadata.getRating(MediaMetadata.METADATA_KEY_USER_RATING));
        if (userRatingState != FavoriteState.UNKNOWN) {
            return userRatingState;
        }
        return ratingToFavoriteState(metadata.getRating(MediaMetadata.METADATA_KEY_RATING));
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
        String key = getTrackCacheKey(controller);
        if (key == null) {
            return FAVORITE_STATE_UNKNOWN;
        }
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getInt(key, FAVORITE_STATE_UNKNOWN);
    }

    private static void cachePublicFavoriteState(Context context, MediaController controller, int state) {
        String key = getTrackCacheKey(controller);
        if (key == null) {
            return;
        }

        if (state == FAVORITE_STATE_UNKNOWN) {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .remove(key)
                    .apply();
        } else {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .putInt(key, state)
                    .apply();
        }
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
}