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

public final class MediaFavoriteController {
    public static final String ACTION_FAVORITE = "com.android.launcher66.action.MEDIA_FAVORITE";
    public static final int FAVORITE_STATE_UNKNOWN = 0;
    public static final int FAVORITE_STATE_NOT_FAVORITED = 1;
    public static final int FAVORITE_STATE_FAVORITED = 2;

    private static final String TAG = "MediaFavorite";
    private static final String SPOTIFY_PACKAGE = "com.spotify.music";
    private static final String APPLE_MUSIC_PACKAGE = "com.apple.android.music";

    private MediaFavoriteController() {
    }

    public static boolean favoriteCurrent(Context context, String preferredPackage) {
        return toggleFavoriteCurrent(context, preferredPackage);
    }

    public static boolean toggleFavoriteCurrent(Context context, String preferredPackage) {
        MediaController controller = getTargetController(context, preferredPackage);
        return controller != null && toggleFavorite(controller);
    }

    public static int getCurrentFavoriteState(Context context, String preferredPackage) {
        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return FAVORITE_STATE_UNKNOWN;
        }

        PlaybackState state = controller.getPlaybackState();
        FavoriteActions actions = state == null
                ? new FavoriteActions()
                : findFavoriteActions(state.getCustomActions());
        return toPublicState(getFavoriteState(controller, actions));
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

        if (isTargetPackage(preferredPackage)) {
            for (MediaController controller : controllers) {
                if (preferredPackage.equals(controller.getPackageName())) {
                    return controller;
                }
            }
        }

        MediaController fallback = null;
        for (MediaController controller : controllers) {
            if (!isTargetPackage(controller.getPackageName())) {
                continue;
            }
            if (fallback == null) {
                fallback = controller;
            }
            PlaybackState state = controller.getPlaybackState();
            if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                return controller;
            }
        }
        return fallback;
    }

    private static boolean isTargetPackage(String packageName) {
        return SPOTIFY_PACKAGE.equals(packageName) || APPLE_MUSIC_PACKAGE.equals(packageName);
    }

    private static boolean toggleFavorite(MediaController controller) {
        PlaybackState state = controller.getPlaybackState();
        if (state == null) {
            return false;
        }

        FavoriteActions actions = findFavoriteActions(state.getCustomActions());
        FavoriteState favoriteState = getFavoriteState(controller, actions);
        Log.d(TAG, "Favorite state for " + controller.getPackageName() + ": " + favoriteState);

        if (favoriteState == FavoriteState.FAVORITED) {
            if (sendCustomAction(controller, actions.negative, "unfavorite")) return true;
            if (sendRating(controller, state, false)) return true;
            if (sendCustomAction(controller, actions.toggle, "toggle favorite")) return true;
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

        try {
            controller.getTransportControls().setRating(Rating.newHeartRating(favorite));
            Log.d(TAG, "Sent heart rating " + favorite + " for " + controller.getPackageName());
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Heart rating failed for " + controller.getPackageName(), e);
        }

        try {
            controller.getTransportControls().setRating(Rating.newThumbRating(favorite));
            Log.d(TAG, "Sent thumb rating " + favorite + " for " + controller.getPackageName());
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Thumb rating failed for " + controller.getPackageName(), e);
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
        return ratingToFavoriteState(metadata.getRating(MediaMetadata.METADATA_KEY_USER_RATING));
    }

    private static FavoriteState ratingToFavoriteState(Rating rating) {
        if (rating == null || !rating.isRated()) {
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
                || text.contains("hide");
        return removeLikeAction && (text.contains("favorite")
                || text.contains("favourite")
                || text.contains("like")
                || text.contains("heart")
                || text.contains("love")
                || text.contains("library")
                || text.contains("save"));
    }
}
