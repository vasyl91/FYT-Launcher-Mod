package com.syu.media.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.media.entities.MediaSource;
import com.syu.media.ipc.PlaybackBinder;
import com.syu.media.player.IPlayer;
import com.syu.media.player.Player;
import com.syu.media.provider.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bG\u0010HJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0016\u0010\u0017\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J \u0010\u001a\u001a\u00020\u00152\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\u00152\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001e\u0010\u001f\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001e\u0010!\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u001bH\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0004H\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u000bH\u0016J\b\u00107\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0012H\u0016J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u001bH\u0016J\u0018\u0010@\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001bH\u0016R\"\u0010A\u001a\u00020\u00058\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/syu/media/service/PlaybackService;", "Landroid/app/Service;", "Lcom/syu/media/player/IPlayer;", "Lcom/syu/media/player/IPlayer$Callback;", "Lcom/syu/media/player/IPlayer$Callback2;", "Lcom/syu/media/player/Player;", "setupPlayer", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", FinalChip.BSP_PLATFORM_Null, "onDestroy", "Landroid/view/Surface;", "surface", "setSurface", "onCreate", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", Media.LIST_TABLE, "setPlayList", FinalChip.BSP_PLATFORM_Null, "play", "playList", FinalChip.BSP_PLATFORM_Null, Media.PATH, "playListWithPath", FinalChip.BSP_PLATFORM_Null, "id", "playListWithId", "startIndex", "playListWithIndex", "source", "playListWithSource", "playSource", "playLast", "playNext", "pause", "isPlaying", "getProgress", "getPlayingSong", "getPlayMode", "getPlayList", NotificationCompat.CATEGORY_PROGRESS, "seekTo", "playMode", "setPlayMode", "audioSessionId", "callback", "registerCallback", "unregisterCallback", "registerCallback2", "unregisterCallback2", "removeCallbacks", "removeCallback2s", "reset", "releasePlayer", Media.SONG_TABLE, "onSongChanged", "onPlayStatusChanged", "mode", "onPlayModeChanged", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "onVideoSizeChanged", "player", "Lcom/syu/media/player/Player;", "getPlayer", "()Lcom/syu/media/player/Player;", "setPlayer", "(Lcom/syu/media/player/Player;)V", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public class PlaybackService extends Service implements IPlayer, IPlayer.Callback, IPlayer.Callback2 {
    public PlaybackBinder a;
    protected Player player;

    @Override // com.syu.media.player.IPlayer
    public int audioSessionId() {
        return getPlayer().audioSessionId();
    }

    @Override // com.syu.media.player.IPlayer
    public List<MediaSource> getPlayList() {
        return getPlayer().getPlayList();
    }

    @Override // com.syu.media.player.IPlayer
    public int getPlayMode() {
        return getPlayer().getPlayMode();
    }

    public Player getPlayer() {
        Player player = this.player;
        if (player != null) {
            return player;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player");
        return null;
    }

    @Override // com.syu.media.player.IPlayer
    public MediaSource getPlayingSong() {
        return getPlayer().getPlayingSong();
    }

    @Override // com.syu.media.player.IPlayer
    public int getProgress() {
        return getPlayer().getProgress();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean isPlaying() {
        return getPlayer().isPlaying();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        setPlayer(setupPlayer());
        this.a = new PlaybackBinder(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        releasePlayer();
        super.onDestroy();
    }

    public void onPlayModeChanged(int mode) {
        Player.Companion companion = Player.INSTANCE;
        if (companion.getDEBUG()) {
            Log.e(companion.getTAG(), "onPlayModeChanged----------->>  " + mode);
        }
        PlaybackBinder playbackBinder = this.a;
        if (playbackBinder != null) {
            playbackBinder.onPlayModeChanged(mode);
        }
    }

    public void onPlayStatusChanged(boolean isPlaying) {
        Player.Companion companion = Player.INSTANCE;
        if (companion.getDEBUG()) {
            Log.e(companion.getTAG(), "onPlayStatusChanged----------->>  " + isPlaying);
        }
        PlaybackBinder playbackBinder = this.a;
        if (playbackBinder != null) {
            playbackBinder.onPlayStatusChanged(isPlaying);
        }
    }

    public void onSongChanged(MediaSource song) {
        Intrinsics.checkNotNullParameter(song, Media.SONG_TABLE);
        Player.Companion companion = Player.INSTANCE;
        if (companion.getDEBUG()) {
            Log.e(companion.getTAG(), "onSongChanged ----------->>  " + song);
        }
        PlaybackBinder playbackBinder = this.a;
        if (playbackBinder != null) {
            playbackBinder.onSongChanged(song);
        }
    }

    @Override // com.syu.media.player.IPlayer.Callback2
    public void onVideoSizeChanged(int width, int height) {
        PlaybackBinder playbackBinder = this.a;
        if (playbackBinder != null) {
            playbackBinder.onVideoSizeChanged(width, height);
        }
    }

    public boolean pause() {
        return getPlayer().pause();
    }

    public boolean play() {
        return getPlayer().play();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playLast() {
        return getPlayer().playLast();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playList(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        return getPlayer().playList(list);
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playListWithId(List<MediaSource> list, int id) {
        return getPlayer().playListWithId(list, id);
    }

    public boolean playListWithIndex(List<MediaSource> list, int startIndex) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        return getPlayer().playListWithIndex(list, startIndex);
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playListWithPath(List<MediaSource> list, String path) {
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        return getPlayer().playListWithPath(list, path);
    }

    public boolean playListWithSource(List<MediaSource> list, MediaSource source) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(source, "source");
        return getPlayer().playListWithSource(list, source);
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playNext() {
        return getPlayer().playNext();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean playSource(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getPlayer().playSource(source);
    }

    @Override // com.syu.media.player.IPlayer
    public void registerCallback(IPlayer.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPlayer().registerCallback(callback);
    }

    @Override // com.syu.media.player.IPlayer
    public void registerCallback2(IPlayer.Callback2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPlayer().registerCallback2(callback);
    }

    @Override // com.syu.media.player.IPlayer
    public void releasePlayer() {
        getPlayer().releasePlayer();
    }

    @Override // com.syu.media.player.IPlayer
    public void removeCallback2s() {
        getPlayer().removeCallback2s();
    }

    @Override // com.syu.media.player.IPlayer
    public void removeCallbacks() {
        getPlayer().removeCallbacks();
    }

    @Override // com.syu.media.player.IPlayer
    public void reset() {
        getPlayer().reset();
    }

    @Override // com.syu.media.player.IPlayer
    public boolean seekTo(int progress) {
        return getPlayer().seekTo(progress);
    }

    @Override // com.syu.media.player.IPlayer
    public void setPlayList(List<MediaSource> list) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        getPlayer().setPlayList(list);
    }

    @Override // com.syu.media.player.IPlayer
    public void setPlayMode(int playMode) {
        getPlayer().setPlayMode(playMode);
    }

    public void setPlayer(Player player) {
        Intrinsics.checkNotNullParameter(player, "<set-?>");
        this.player = player;
    }

    @Override // com.syu.media.player.IPlayer
    public void setSurface(Surface surface) {
        getPlayer().setSurface(surface);
    }

    public Player setupPlayer() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Player player = new Player(applicationContext, 0, 2, null);
        player.registerCallback(this);
        return player;
    }

    @Override // com.syu.media.player.IPlayer
    public void unregisterCallback(IPlayer.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPlayer().unregisterCallback(callback);
    }

    @Override // com.syu.media.player.IPlayer
    public void unregisterCallback2(IPlayer.Callback2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPlayer().unregisterCallback2(callback);
    }
}
