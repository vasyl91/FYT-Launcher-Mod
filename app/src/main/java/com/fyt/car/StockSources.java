package com.fyt.car;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.MediaFavoriteController;
import com.android.launcher66.MediaTransportController;
import com.android.launcher66.NotificationListener;
import com.fyt.car.StockKindArbiter.Kind;
import com.syu.car.CarStates;
import com.syu.remote.RemoteTools;
import com.syu.widget.DateMusicProvider;
import com.syu.widget.DateRadioProvider;
import com.syu.widget.Widget;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FYT's stock sources behind the music widget: which one is shown, what its overlay (radio, on
 * the 7870 BT too) holds, how it is controlled, which page of it opens and when it is started
 * again after the panes were rebuilt.
 *
 * <pre>
 *   source        unit          data                             state kept in
 *   SYU_MUSIC     7862, 8581    com.syu.music's intents          MusicService fields (as ever)
 *   MEDIA_MUSIC   7870          IPlayer of com.syu.media         MusicService fields
 *   MEDIA_ONLINE  7870          IPlayer of com.syu.media         MusicService fields
 *   MEDIA_BT      7870          com.syu.ms module 2              StockBtSource
 *   RADIO         both          com.syu.ms module 1              StockRadioSource
 * </pre>
 *
 * Everything that asks "what does the widget show" asks in the same order: the overlay
 * ({@link #shownOverlay()}), then the com.syu.media player (MusicService.isSyuMediaSource()),
 * then the code that has always served com.syu.music.
 *
 * Main thread, except the plain readers ({@link #isSyuMediaUnit()}, {@link #shownKind()} ...),
 * which read what the main thread wrote.
 */
public final class StockSources {

    private static final String TAG = "StockSources";
    private static final String RADIO_PKG = "com.syu.radio";

    /** Pages of com.syu.media's one activity, by action (its MainAct filters). */
    private static final String PAGE_MUSIC = "com.syu.music";
    private static final String PAGE_ONLINE = "com.syu.online";
    private static final String PAGE_BT = "com.syu.btmusic";
    private static final String PAGE_RADIO = "com.syu.radio";

    /**
     * How long after the channel moved the shown source off a player that player's "playing" is
     * still taken for the moment before its pause, not for a start: com.syu.media pauses on the
     * channel's change, which reaches it and the launcher at about the same time.
     */
    private static final long PLAYER_SETTLE_MS = 1500L;

    /** Resume: the channel is waited for this long, then given a moment to settle. */
    private static final long RESUME_POLL_MS = 100L;
    private static final long RESUME_WAIT_MAX_MS = 1500L;
    private static final long RESUME_SETTLE_MS = 400L;

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    // main thread
    private static boolean sStarted;
    private static Context sApp;
    private static RemoteTools sTools;
    private static StockKindArbiter sArbiter;
    private static StockRadioSource sRadio;
    private static StockBtSource sBt;
    /** When the shown source last changed with the channel, for stale reads of a player. */
    private static long sChannelChangeAtMs;
    private static final Map<Kind, Long> sLeftAtMs = new ConcurrentHashMap<>();
    private static final Map<Kind, Long> sUserPausedAtMs = new ConcurrentHashMap<>();
    private static final Map<Kind, Boolean> sResumePending = new ConcurrentHashMap<>();
    private static String sLastResume = "none";

    // read from any thread
    private static volatile Kind sShown = Kind.SYU_MUSIC;
    private static volatile boolean sSyuMediaUnit;
    private static volatile int sSyuMediaUid = -1;
    private static volatile ComponentName sRadioAppComponent;
    private static final Map<String, ComponentName> sPages = new ConcurrentHashMap<>();
    private static volatile ComponentName sMediaLauncher;

    private StockSources() {
    }

    /**
     * Starts the sources, once per process: main thread, FYT units only (CarStates is the link to
     * com.syu.ms). Which unit this is is found out on a thread of its own; until then
     * {@link #isSyuMediaUnit()} is false, i.e. everything is as it was before 7870 support.
     */
    public static void init(Context context) {
        if (sStarted || !LauncherApplication.isFytDevice()) {
            return;
        }
        sStarted = true;
        sApp = context.getApplicationContext();
        sTools = CarStates.getCar(sApp).getTools();
        sArbiter = new StockKindArbiter(false, CarStates.mAppID);
        sShown = sArbiter.shown();
        sRadio = new StockRadioSource(sApp);
        sRadio.start(sTools);
        sBt = new StockBtSource(sApp);
        sBt.start(sTools);
        Log.d(TAG, "started, channel " + CarStates.mAppID + ", shown " + sShown);
        if (sShown == Kind.RADIO) {
            // Started with the radio on: no channel change will say so
            sRadio.onActivated();
        }
        Thread probe = new Thread(StockSources::probeDevice, "StockSourcesProbe");
        probe.setDaemon(true);
        probe.start();
    }

    /** Off the main thread: package lookups are binder calls. */
    private static void probeDevice() {
        PackageManager pm = sApp.getPackageManager();
        boolean unit = false;
        int uid = -1;
        try {
            unit = pm.resolveService(new Intent("com.syu.media.music.MusicService")
                    .setPackage(MusicService.MEDIA_PKG), 0) != null;
            if (unit) {
                uid = pm.getApplicationInfo(MusicService.MEDIA_PKG, 0).uid;
                for (String page : new String[]{PAGE_MUSIC, PAGE_ONLINE, PAGE_BT, PAGE_RADIO}) {
                    ResolveInfo info = pm.resolveActivity(
                            new Intent(page).setPackage(MusicService.MEDIA_PKG), 0);
                    if (info != null && info.activityInfo != null) {
                        sPages.put(page, new ComponentName(info.activityInfo.packageName,
                                info.activityInfo.name));
                    }
                }
                Intent launch = pm.getLaunchIntentForPackage(MusicService.MEDIA_PKG);
                sMediaLauncher = launch != null ? launch.getComponent() : null;
            } else {
                Intent radio = pm.getLaunchIntentForPackage(RADIO_PKG);
                sRadioAppComponent = radio != null ? radio.getComponent() : null;
            }
        } catch (RuntimeException | PackageManager.NameNotFoundException e) {
            Log.w(TAG, "device lookup failed: " + e);
        }
        sSyuMediaUid = uid;
        sSyuMediaUnit = unit;
        boolean result = unit;
        MAIN.post(() -> onDeviceResolved(result));
    }

    private static void onDeviceResolved(boolean unit) {
        Log.d(TAG, "device: " + (unit ? "7870 (com.syu.media)" : "com.syu.music unit"));
        Kind before = sArbiter.shown();
        if (sArbiter.setSyuMediaUnit(unit)) {
            onShownChanged(before, sArbiter.shown(), "device resolved", false, false);
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Readers
    // ---------------------------------------------------------------------------------------------

    public static boolean isFyt() {
        return LauncherApplication.isFytDevice();
    }

    /**
     * A 7870: com.syu.media is the stock player. False until the lookup at the start has
     * answered, i.e. the behavior before 7870 support.
     */
    public static boolean isSyuMediaUnit() {
        return sSyuMediaUnit;
    }

    /** The uid of com.syu.media on a 7870, else -1. */
    public static int syuMediaUid() {
        return sSyuMediaUid;
    }

    public static Kind shownKind() {
        return sShown;
    }

    /** The shown source when it is an MCU overlay (radio, on the 7870 BT too), else null. */
    public static Kind shownOverlay() {
        Kind kind = sShown;
        return kind.overlay ? kind : null;
    }

    /** The radio is the shown source: the one thing a 7862 has on top of com.syu.music. */
    public static boolean radioShown() {
        return sShown == Kind.RADIO;
    }

    static boolean isRadioShown() {
        return sShown == Kind.RADIO;
    }

    static boolean isBtShown() {
        return sShown == Kind.MEDIA_BT;
    }

    /** The channel the shown source plays on. */
    public static int shownChannel() {
        return sShown.channel;
    }

    /** What the overlay shown holds; null without one or before it has anything. */
    public static StockTrack shownOverlayTrack() {
        Kind kind = sShown;
        if (kind == Kind.RADIO) {
            StockRadioSource radio = sRadio;
            return radio != null ? radio.current() : null;
        }
        if (kind == Kind.MEDIA_BT) {
            StockBtSource bt = sBt;
            return bt != null ? bt.current() : null;
        }
        return null;
    }

    /** Whether the overlay shown plays: read live, the channel moves between publications. */
    public static boolean isShownPlaying() {
        Kind kind = sShown;
        if (kind == Kind.RADIO) {
            return CarStates.mAppID == Kind.RADIO.channel;
        }
        if (kind == Kind.MEDIA_BT) {
            StockBtSource bt = sBt;
            return bt != null && bt.isPhonePlaying() && CarStates.mAppID == Kind.MEDIA_BT.channel;
        }
        return MusicService.state.booleanValue();
    }

    static RemoteTools tools() {
        return sTools;
    }

    // ---------------------------------------------------------------------------------------------
    // Channel and source changes
    // ---------------------------------------------------------------------------------------------

    /** The MCU's sound channel changed (CarStates, module 0 code 0). Main thread. */
    public static void onAppIdChanged(int appId) {
        if (!sStarted) {
            return;
        }
        long now = SystemClock.elapsedRealtime();
        int previous = sArbiter.lastChannel();
        if (previous != appId) {
            Kind left = stockKindOfChannel(previous);
            if (left != null) {
                sLeftAtMs.put(left, now);
            }
        }
        Kind before = sArbiter.shown();
        if (sArbiter.onChannel(appId)) {
            onShownChanged(before, sArbiter.shown(), "channel " + appId, true, false);
        } else if (before == Kind.RADIO) {
            sRadio.onChannelChanged();
        } else if (before == Kind.MEDIA_BT) {
            sBt.onChannelChanged();
        }
    }

    /**
     * Whether the state of a com.syu.media player is for the source shown. A player that reports
     * it plays takes the source over at once, without waiting for the channel: but not on a read
     * taken before the channel moved off it or just after (a player paused by the channel was
     * read as playing a moment earlier; it flickered back onto the widget for a second).
     */
    static boolean acceptSyuMedia(Kind kind, boolean playing, long sampledAtMs) {
        if (!sStarted) {
            return kind == Kind.MEDIA_MUSIC;
        }
        Kind before = sArbiter.shown();
        if (kind == before) {
            return true;
        }
        if (playing && sampledAtMs >= sChannelChangeAtMs + PLAYER_SETTLE_MS
                && sArbiter.onPlayerPlaying(kind)) {
            onShownChanged(before, kind, "player " + kind + " plays", false, true);
            return true;
        }
        return false;
    }

    private static void onShownChanged(Kind before, Kind after, String reason,
            boolean channelDriven, boolean playerTookOver) {
        sShown = after;
        if (channelDriven) {
            sChannelChangeAtMs = SystemClock.elapsedRealtime();
        }
        Log.d(TAG, "shown " + after + " <- " + reason + " (was " + before + ")");
        if (after == Kind.RADIO) {
            sRadio.onActivated();
        } else if (after == Kind.MEDIA_BT) {
            sBt.onActivated();
        } else if (after.isMediaPlayer()) {
            SyuMediaClient client = SyuMediaClient.of(after);
            if (client != null && !playerTookOver) {
                // Its last state may be stale (other sources had the widget meanwhile): read again
                client.republish();
            }
        } else if (before.overlay && !isSyuMediaUnit()) {
            // The radio gives the widget back to com.syu.music, which sends its update by itself
            // only while it plays
            NotificationListener.onStockOverlayHidden();
        }
        if (before.overlay != after.overlay) {
            Log.d(TAG, "favorite " + (after.overlay ? "greyed out for " + after : "back for " + after));
        }
        if (sApp != null) {
            MediaFavoriteController.onStockFavoriteChanged(sApp);
            Widget.widgetUpdate(sApp, DateMusicProvider.class);
            Widget.widgetUpdate(sApp, DateRadioProvider.class);
        }
    }

    /**
     * Hands a track to the music widget.
     *
     * @return false when it could not be delivered (the listener is not connected yet): the
     *         caller sends it again later
     */
    static boolean publish(StockTrack t) {
        if (NotificationListener.getInstance() == null) {
            return false;
        }
        if (t.playing) {
            NotificationListener.onStockSourceUpdate(t);
        } else {
            NotificationListener.onStockSourcePaused(t);
        }
        return true;
    }

    private static Kind stockKindOfChannel(int channel) {
        if (sArbiter == null || !sArbiter.isSyuMediaUnit()) {
            return null;
        }
        switch (channel) {
            case StockKindArbiter.CH_MUSIC:
                return Kind.MEDIA_MUSIC;
            case StockKindArbiter.CH_ONLINE:
                return Kind.MEDIA_ONLINE;
            case StockKindArbiter.CH_BT:
                return Kind.MEDIA_BT;
            default:
                return null;
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Control
    // ---------------------------------------------------------------------------------------------

    /** The package a transport button of the widget is aimed at while an overlay is shown. */
    public static String overlayPackage() {
        Kind overlay = shownOverlay();
        if (overlay == null) {
            return null;
        }
        return overlay == Kind.RADIO && !isSyuMediaUnit() ? RADIO_PKG : MusicService.MEDIA_PKG;
    }

    /**
     * Previous, next or play/pause for the overlay shown (MediaTransportController.ACTION_*).
     * Sent as the pages of the sources send them: LauncherRadioWidget's commands for the radio,
     * com.syu.media's BluetoothController's for BT.
     *
     * @return false when no overlay is shown or the commands cannot be sent
     */
    public static boolean control(String action) {
        Kind overlay = shownOverlay();
        RemoteTools tools = sTools;
        if (overlay == null || tools == null || action == null) {
            return false;
        }
        boolean previous = MediaTransportController.ACTION_PREVIOUS.equals(action);
        boolean next = MediaTransportController.ACTION_NEXT.equals(action);
        boolean playPause = MediaTransportController.ACTION_PLAY_PAUSE.equals(action);
        if (!previous && !next && !playPause) {
            return false;
        }
        if (overlay != Kind.RADIO) {
            return controlBt(action);
        }
        final boolean playing = CarStates.mAppID == Kind.RADIO.channel;
        if ((next || previous) && !playing) {
            // As LauncherRadioWidget's buttons: only a radio that plays changes station
            Log.d(TAG, "control RADIO " + (next ? "next" : "previous") + " ignored: the radio is not playing");
            return false;
        }
        send(() -> {
            if (next) {
                tools.sendInt(1, 0, 0);
                Log.d(TAG, "control RADIO next -> module 1 cmd 0");
            } else if (previous) {
                tools.sendInt(1, 1, 0);
                Log.d(TAG, "control RADIO previous -> module 1 cmd 1");
            } else {
                tools.sendInt(0, 0, playing ? 0 : 1);
                Log.d(TAG, "control RADIO " + (playing ? "pause -> channel 0" : "play -> channel 1"));
            }
        });
        return true;
    }

    private static Handler sControl;

    /**
     * Commands to com.syu.ms are binder calls: they go out on a thread of their own, in the order
     * they were given.
     */
    private static void send(Runnable commands) {
        Handler handler;
        synchronized (StockSources.class) {
            if (sControl == null) {
                HandlerThread thread = new HandlerThread("StockControl");
                thread.start();
                sControl = new Handler(thread.getLooper());
            }
            handler = sControl;
        }
        handler.post(() -> {
            try {
                commands.run();
            } catch (RuntimeException e) {
                Log.w(TAG, "command to com.syu.ms failed: " + e);
            }
        });
    }

    /**
     * BT audio of a 7870, over com.syu.ms module 2, as com.syu.media's BluetoothController sends
     * it (0 previous, 1 next, 2 play/pause, 27 play). Also for the BT page's buttons of the home
     * screen, which have com.syu.bt's service to call elsewhere.
     *
     * @return false off a 7870, or when the commands cannot be sent
     */
    public static boolean controlBt(String action) {
        RemoteTools tools = sTools;
        if (!sSyuMediaUnit || tools == null || action == null) {
            return false;
        }
        if (MediaTransportController.ACTION_PREVIOUS.equals(action)) {
            send(() -> {
                tools.sendInt(2, 0);
                Log.d(TAG, "control MEDIA_BT previous -> module 2 cmd 0");
            });
        } else if (MediaTransportController.ACTION_NEXT.equals(action)) {
            send(() -> {
                tools.sendInt(2, 1);
                Log.d(TAG, "control MEDIA_BT next -> module 2 cmd 1");
            });
        } else if (MediaTransportController.ACTION_PLAY_PAUSE.equals(action)) {
            if (CarStates.mAppID != Kind.MEDIA_BT.channel) {
                // From another channel: the channel first, then play, as com.syu.media does
                send(() -> {
                    tools.sendInt(0, 0, Kind.MEDIA_BT.channel);
                    tools.sendInt(2, 27);
                    Log.d(TAG, "control MEDIA_BT play -> channel 3, module 2 cmd 27");
                });
            } else {
                if (sBt != null && sBt.isPhonePlaying()) {
                    sUserPausedAtMs.put(Kind.MEDIA_BT, SystemClock.elapsedRealtime());
                }
                send(() -> {
                    tools.sendInt(2, 2);
                    Log.d(TAG, "control MEDIA_BT play/pause -> module 2 cmd 2");
                });
            }
        } else {
            return false;
        }
        return true;
    }

    /** The user paused a com.syu.media player with a launcher button: it is not started again. */
    static void onUserPaused(Kind kind) {
        sUserPausedAtMs.put(kind, SystemClock.elapsedRealtime());
    }

    // ---------------------------------------------------------------------------------------------
    // Pages
    // ---------------------------------------------------------------------------------------------

    /**
     * The page of the shown source to open when the widget is tapped: the right page of
     * com.syu.media on a 7870, com.syu.radio on a 7862 while the radio is shown. Null where
     * the usual code (com.syu.music, a session's app) opens it.
     */
    public static Intent pageIntent(Context context) {
        if (!sStarted) {
            return null;
        }
        Kind kind = sShown;
        if (!sSyuMediaUnit) {
            ComponentName radio = sRadioAppComponent;
            if (kind == Kind.RADIO && radio != null) {
                return new Intent(Intent.ACTION_MAIN).setComponent(radio)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            return null;
        }
        return mediaPage(pageAction(kind));
    }

    private static String pageAction(Kind kind) {
        switch (kind) {
            case MEDIA_ONLINE:
                return PAGE_ONLINE;
            case MEDIA_BT:
                return PAGE_BT;
            case RADIO:
                return PAGE_RADIO;
            default:
                return PAGE_MUSIC;
        }
    }

    /**
     * A page of com.syu.media ("com.syu.music", "com.syu.radio", "com.syu.btmusic",
     * "com.syu.online"); null off a 7870. The page that cannot be found opens the app itself.
     */
    public static Intent mediaPage(String action) {
        if (!sSyuMediaUnit) {
            return null;
        }
        ComponentName component = sPages.get(action);
        Intent intent;
        if (component != null) {
            intent = new Intent(action).setComponent(component);
        } else if (sMediaLauncher != null) {
            intent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
                    .setComponent(sMediaLauncher);
        } else {
            intent = new Intent(action).setPackage(MusicService.MEDIA_PKG);
        }
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /** The page of the BT music player of a 7870 (BTAV pages); null elsewhere. */
    public static Intent btPage() {
        return mediaPage(PAGE_BT);
    }

    // ---------------------------------------------------------------------------------------------
    // Resume after the launcher put the channel back
    // ---------------------------------------------------------------------------------------------

    /**
     * NotificationListener sent a stock channel back after the panes were rebuilt (and only then:
     * a player that leaves the channel by itself, "back" in its screen, is not sent back).
     * com.syu.media pauses on every loss of audio focus, which the panes' apps cause, and the
     * channel returning does not start it again: this does, once, when StockResumePolicy says so.
     */
    public static void onStockChannelRestored(int channel) {
        if (!sStarted || !sSyuMediaUnit) {
            return;
        }
        MAIN.post(() -> startResume(channel));
    }

    private static void startResume(int channel) {
        Kind target = stockKindOfChannel(channel);
        if (target == null) {
            return;
        }
        long now = SystemClock.elapsedRealtime();
        if (!wantsResume(target, now)) {
            return;
        }
        if (sResumePending.put(target, Boolean.TRUE) != null) {
            return; // already on its way
        }
        awaitChannel(target, channel, now);
    }

    private static boolean wantsResume(Kind target, long now) {
        long lastPlaying = lastPlayingAtMs(target);
        long leftAt = longOf(sLeftAtMs.get(target));
        long userPaused = longOf(sUserPausedAtMs.get(target));
        boolean resume = StockResumePolicy.shouldResume(lastPlaying, leftAt, now, userPaused);
        if (!resume) {
            Log.d(TAG, "no resume of " + target + " (played " + ago(now, lastPlaying) + " ago, left "
                    + ago(now, leftAt) + " ago, user paused " + ago(now, userPaused) + " ago)");
        }
        return resume;
    }

    private static void awaitChannel(Kind target, int channel, long startedAt) {
        long now = SystemClock.elapsedRealtime();
        if (CarStates.mAppID == channel) {
            MAIN.postDelayed(() -> resumeNow(target, channel), RESUME_SETTLE_MS);
            return;
        }
        if (now - startedAt > RESUME_WAIT_MAX_MS) {
            sResumePending.remove(target);
            Log.d(TAG, "no resume of " + target + ": the channel did not come back (now "
                    + CarStates.mAppID + ")");
            return;
        }
        MAIN.postDelayed(() -> awaitChannel(target, channel, startedAt), RESUME_POLL_MS);
    }

    private static void resumeNow(Kind target, int channel) {
        sResumePending.remove(target);
        if (CarStates.mAppID != channel || !wantsResume(target, SystemClock.elapsedRealtime())) {
            return;
        }
        sLastResume = target + " at " + SystemClock.elapsedRealtime() + " after channel restore " + channel;
        if (target == Kind.MEDIA_BT) {
            // Its own audio focus handler starts it with command 27 when the phone's player has
            // stopped
            if (sBt.isPhonePlaying()) {
                Log.d(TAG, "resume MEDIA_BT not needed: it plays");
                return;
            }
            Log.d(TAG, "resume MEDIA_BT after channel restore " + channel);
            send(() -> sTools.sendInt(2, 27));
            return;
        }
        SyuMediaClient client = SyuMediaClient.of(target);
        if (client != null) {
            client.resumeIfStopped(channel);
        }
    }

    private static long lastPlayingAtMs(Kind kind) {
        if (kind == Kind.MEDIA_BT) {
            return sBt != null ? sBt.lastPlayingAtMs() : 0;
        }
        SyuMediaClient client = SyuMediaClient.of(kind);
        return client != null ? client.lastPlayingAtMs() : 0;
    }

    private static long longOf(Long value) {
        return value != null ? value : 0L;
    }

    private static String ago(long now, long at) {
        return at > 0 ? (now - at) + "ms" : "never";
    }

    // ---------------------------------------------------------------------------------------------
    // Diagnostics
    // ---------------------------------------------------------------------------------------------

    /** For `adb shell am broadcast -a dumpMediaDebug`. */
    public static String dump() {
        StringBuilder sb = new StringBuilder("StockSources: ");
        if (!sStarted) {
            return sb.append("not started (not an FYT unit)").toString();
        }
        sb.append("channel=").append(CarStates.mAppID).append(" shown=").append(sShown)
                .append(" syuMediaUnit=").append(sSyuMediaUnit).append(" uid=").append(sSyuMediaUid)
                .append(" lastResume=").append(sLastResume);
        sb.append("\n  ").append(sRadio.dump());
        sb.append("\n  ").append(sBt.dump());
        for (Kind kind : new Kind[]{Kind.MEDIA_MUSIC, Kind.MEDIA_ONLINE}) {
            SyuMediaClient client = SyuMediaClient.of(kind);
            sb.append("\n  ").append(client != null ? client.dump() : kind + ": not started");
        }
        sb.append("\n  MusicService: '").append(MusicService.music_name).append("' state=")
                .append(MusicService.state).append(" path=").append(MusicService.music_path)
                .append(" syuMediaSource=").append(MusicService.isSyuMediaSource());
        return sb.toString();
    }
}
