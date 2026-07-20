package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.util.Log;
import android.view.KeyEvent;

import com.fyt.car.MusicService;
import com.syu.widget.WidgetProvider;

import java.util.List;

public final class MediaTransportController {
    public static final String ACTION_PREVIOUS = "com.android.launcher66.action.MEDIA_PREVIOUS";
    public static final String ACTION_PLAY_PAUSE = "com.android.launcher66.action.MEDIA_PLAY_PAUSE";
    public static final String ACTION_NEXT = "com.android.launcher66.action.MEDIA_NEXT";
    public static final String ACTION_OPEN_PLAYER = "com.android.launcher66.action.MEDIA_OPEN_PLAYER";

    private static final String TAG = "MediaTransport";
    private static final String STOCK_MUSIC_PACKAGE = "com.syu.music";
    private static final String STOCK_MUSIC_ACTIVITY = "com.syu.music.MAct";

    private MediaTransportController() {
    }

    public static boolean handleAction(Context context, String action) {
        return handleAction(context, action, null);
    }

    public static boolean handleAction(Context context, String action, String preferredPackage) {
        if (context == null || action == null) {
            return false;
        }

        if (ACTION_OPEN_PLAYER.equals(action)) {
            return openActivePlayer(context, preferredPackage);
        }

        MediaController controller = getTargetController(context, preferredPackage);
        if (controller != null && dispatchToController(controller, action)) {
            return true;
        }

        if (dispatchToStockMusic(context, action)) {
            return true;
        }

        boolean sentMediaKey = dispatchMediaKey(context, action);
        return sentMediaKey;
    }

    public static boolean openActivePlayer(Context context) {
        return openActivePlayer(context, null);
    }

    public static boolean openActivePlayer(Context context, String preferredPackage) {
        if (context == null) {
            return false;
        }

        Intent launchIntent = getActivePlayerLaunchIntent(context, preferredPackage);
        return launchIntent != null && startIntent(context, launchIntent);
    }

    public static boolean seekToProgress(Context context, String preferredPackage, int progress, int max) {
        if (context == null || max <= 0) {
            return false;
        }

        MediaController controller = getTargetController(context, preferredPackage);
        if (controller == null) {
            return false;
        }

        MediaMetadata metadata = controller.getMetadata();
        long duration = metadata == null ? 0L : metadata.getLong(MediaMetadata.METADATA_KEY_DURATION);
        if (duration <= 0L) {
            return false;
        }

        PlaybackState state = safePlaybackState(controller);
        if (state != null && (state.getActions() & PlaybackState.ACTION_SEEK_TO) == 0) {
            return false;
        }

        int clampedProgress = Math.max(0, Math.min(progress, max));
        long position = (duration * clampedProgress) / max;
        try {
            controller.getTransportControls().seekTo(position);
            Log.d(TAG, "Sent seek to " + position + " for " + controller.getPackageName());
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to seek " + controller.getPackageName(), e);
            return false;
        }
    }

    public static Intent getActivePlayerLaunchIntent(Context context, String preferredPackage) {
        if (context == null) {
            return null;
        }

        MediaController controller = getTargetController(context, preferredPackage);
        if (controller != null) {
            Intent launchIntent = getPackageLaunchIntent(context, controller.getPackageName());
            if (launchIntent != null) {
                return launchIntent;
            }
        }

        return getStockMusicIntent(context);
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
                if (controller != null && preferredPackage.equals(controller.getPackageName())) {
                    return controller;
                }
            }
        }

        MediaController fallback = null;
        for (MediaController controller : controllers) {
            if (controller == null || STOCK_MUSIC_PACKAGE.equals(controller.getPackageName())) {
                continue;
            }
            PlaybackState state = safePlaybackState(controller);
            if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                return controller;
            }
            if (fallback == null && state != null) {
                fallback = controller;
            }
        }

        if (Boolean.TRUE.equals(MusicService.state)) {
            return null;
        }
        return fallback;
    }

    private static boolean isExternalPackage(String packageName) {
        return packageName != null
                && !packageName.isEmpty()
                && !"null".equals(packageName)
                && !STOCK_MUSIC_PACKAGE.equals(packageName);
    }

    private static PlaybackState safePlaybackState(MediaController controller) {
        try {
            return controller.getPlaybackState();
        } catch (Exception e) {
            Log.w(TAG, "Failed to read playback state for " + controller.getPackageName(), e);
            return null;
        }
    }

    private static boolean dispatchToController(MediaController controller, String action) {
        try {
            MediaController.TransportControls controls = controller.getTransportControls();
            if (ACTION_PREVIOUS.equals(action)) {
                controls.skipToPrevious();
                Log.d(TAG, "Sent previous to " + controller.getPackageName());
                return true;
            }
            if (ACTION_NEXT.equals(action)) {
                controls.skipToNext();
                Log.d(TAG, "Sent next to " + controller.getPackageName());
                return true;
            }
            if (ACTION_PLAY_PAUSE.equals(action)) {
                PlaybackState state = safePlaybackState(controller);
                if (state != null && state.getState() == PlaybackState.STATE_PLAYING) {
                    controls.pause();
                    Log.d(TAG, "Sent pause to " + controller.getPackageName());
                } else {
                    controls.play();
                    Log.d(TAG, "Sent play to " + controller.getPackageName());
                }
                return true;
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to dispatch media transport to " + controller.getPackageName(), e);
        }
        return false;
    }

    private static boolean dispatchToStockMusic(Context context, String action) {
        String stockAction = getStockAction(action);
        if (stockAction == null) {
            return false;
        }

        Intent intent = new Intent(stockAction);
        intent.setPackage(STOCK_MUSIC_PACKAGE);
        if (!ServiceIntentGate.startIfAvailable(context, intent, "stock music " + stockAction)) {
            return false;
        }
        return true;
    }

    private static String getStockAction(String action) {
        if (ACTION_PREVIOUS.equals(action)) {
            return MusicService.PREVMUSIC;
        }
        if (ACTION_PLAY_PAUSE.equals(action)) {
            return MusicService.PLAYPAUSEMUSIC;
        }
        if (ACTION_NEXT.equals(action)) {
            return MusicService.NEXTMUSIC;
        }
        return null;
    }

    private static boolean dispatchMediaKey(Context context, String action) {
        int keyCode = getMediaKeyCode(action);
        if (keyCode == 0) {
            return false;
        }

        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager == null) {
            return false;
        }

        long eventTime = System.currentTimeMillis();
        audioManager.dispatchMediaKeyEvent(new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, keyCode, 0));
        audioManager.dispatchMediaKeyEvent(new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_UP, keyCode, 0));
        Log.d(TAG, "Dispatched media key " + keyCode);
        return true;
    }

    private static int getMediaKeyCode(String action) {
        if (ACTION_PREVIOUS.equals(action)) {
            return KeyEvent.KEYCODE_MEDIA_PREVIOUS;
        }
        if (ACTION_PLAY_PAUSE.equals(action)) {
            return KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE;
        }
        if (ACTION_NEXT.equals(action)) {
            return KeyEvent.KEYCODE_MEDIA_NEXT;
        }
        return 0;
    }

    private static Intent getPackageLaunchIntent(Context context, String packageName) {
        if (packageName == null || packageName.isEmpty() || "null".equals(packageName)) {
            return null;
        }

        PackageManager packageManager = context.getPackageManager();
        return packageManager.getLaunchIntentForPackage(packageName);
    }

    private static boolean startIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to open active music player", e);
            return false;
        }
    }

    private static Intent getStockMusicIntent(Context context) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(STOCK_MUSIC_PACKAGE);
        if (intent == null) {
            intent = new Intent(WidgetProvider.APP_WIDGET_START);
            intent.setComponent(new ComponentName(STOCK_MUSIC_PACKAGE, STOCK_MUSIC_ACTIVITY));
        }
        return intent;
    }
}
