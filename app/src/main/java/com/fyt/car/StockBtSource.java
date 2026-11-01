package com.fyt.car;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.R;
import com.fyt.car.StockKindArbiter.Kind;
import com.syu.car.CarStates;
import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;

import java.util.Objects;

/**
 * BT audio as a source of the music widget, on the 7870: the song of the phone, read from
 * com.syu.ms (module 2, as BluetoothObserver of com.syu.media reads it) and held apart from
 * MusicService's fields, see {@link Kind#overlay}.
 *
 * <pre>
 *   code 0  title (strs)      code 13 state, ints[0] == 1 when it plays
 *   code 1  artist (strs)     code 26 album (strs)
 *   code 2  total time, ms    code 28 position, ms
 * </pre>
 * Nothing in strs means the field was cleared (BluetoothObserver posts an empty text then).
 * Launcher.refreshBtInfo reads the same codes for the BT page of the home screen and is left as
 * it is.
 *
 * Callbacks come on the main thread, so everything here is on it.
 */
final class StockBtSource {

    private static final String TAG = "StockSources";

    private final Context app;
    private final Handler main = new Handler(Looper.getMainLooper());

    // main thread
    private String title = "";
    private String artist = "";
    private String album = "";
    private long totalMs;
    private long positionMs;
    private boolean btPlaying;
    private StockTrack lastPublished;

    private volatile StockTrack current;
    /** When it was last seen playing; 0 if it never was. See StockResumePolicy. */
    private volatile long lastPlayingAtMs;

    StockBtSource(Context app) {
        this.app = app;
    }

    void start(RemoteTools tools) {
        Callback.OnRefreshLisenter listener = this::onBtUpdate;
        tools.addRefreshLisenter(2, listener, 0, 1, 2, 13, 26, 28);
    }

    StockTrack current() {
        return current;
    }

    long lastPlayingAtMs() {
        return lastPlayingAtMs;
    }

    /** Whether the phone's player reports that it plays (code 13). */
    boolean isPhonePlaying() {
        return btPlaying;
    }

    /** BT just became the source shown: read what is there and publish it. */
    void onActivated() {
        lastPublished = null; // published again whatever it was: another source had the widget
        RemoteTools tools = StockSources.tools();
        if (tools != null) {
            // Registering again makes com.syu.ms report the current values
            tools.notify(2, 0, 1, 26, 2, 28, 13);
        }
        publishNow();
    }

    /** The sound channel moved: BT plays only while it is the channel. */
    void onChannelChanged() {
        if (StockSources.isBtShown()) {
            publishNow();
        }
    }

    private void onBtUpdate(int code, int[] ints, float[] flts, String[] strs) {
        switch (code) {
            case 0:
                title = firstString(strs);
                break;
            case 1:
                artist = firstString(strs);
                break;
            case 26:
                album = firstString(strs);
                break;
            case 2:
                totalMs = firstInt(ints);
                break;
            case 28:
                positionMs = firstInt(ints);
                break;
            case 13:
                btPlaying = ints != null && ints.length > 0 && ints[0] == 1;
                break;
            default:
                return;
        }
        if (btPlaying && CarStates.mAppID == Kind.MEDIA_BT.channel) {
            lastPlayingAtMs = SystemClock.elapsedRealtime();
        }
        if (StockSources.isBtShown()) {
            // The position arrives every second: the widget follows it
            publishNow();
        }
    }

    private void publishNow() {
        StockTrack t = buildTrack();
        current = t;
        if (t.playing) {
            lastPlayingAtMs = SystemClock.elapsedRealtime();
        }
        if (t.sameShown(lastPublished) && t.positionMs == lastPublished.positionMs) {
            return;
        }
        boolean trackChanged = !t.sameShown(lastPublished);
        if (!StockSources.publish(t)) {
            return; // the widget's listener is not connected yet; the next second's update retries
        }
        lastPublished = t;
        if (trackChanged) {
            Log.d(TAG, "bt " + t);
        }
    }

    private StockTrack buildTrack() {
        String shownTitle = title.trim().isEmpty() ? app.getString(R.string.car_bt_music) : title.trim();
        String key = "stock-bt:/" + Integer.toHexString(Objects.hash(title, artist, album));
        boolean playing = btPlaying && CarStates.mAppID == Kind.MEDIA_BT.channel;
        return new StockTrack(Kind.MEDIA_BT, key, shownTitle, artist.trim(), album.trim(),
                totalMs, positionMs, playing, false, null, null);
    }

    private static String firstString(String[] strs) {
        return strs != null && strs.length > 0 && strs[0] != null ? strs[0] : "";
    }

    private static long firstInt(int[] ints) {
        return ints != null && ints.length > 0 ? ints[0] : 0;
    }

    String dump() {
        StockTrack t = current;
        return "MEDIA_BT: phonePlaying=" + btPlaying + " lastPlayingAt=" + lastPlayingAtMs + " "
                + (t != null ? t : "no track");
    }
}
