package com.syu.media.ipc;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.media.BaseMediaApp;
import com.syu.media.ICallback;
import com.syu.media.ICallback2;
import com.syu.media.IPlayer;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.provider.Media;
import com.syu.media.service.PlaybackService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u00100\u001a\u00020+¢\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0016R\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/syu/media/ipc/PlaybackBinder;", "Lcom/syu/media/IPlayer$Stub;", "Lcom/syu/media/player/IPlayer$Callback;", "Lcom/syu/media/player/IPlayer$Callback2;", FinalChip.BSP_PLATFORM_Null, "play", FinalChip.BSP_PLATFORM_Null, Media.LIST_TABLE, "id", FinalChip.BSP_PLATFORM_Null, "playListWithId", FinalChip.BSP_PLATFORM_Null, Media.PATH, "playWithPath", "playWithId", "playLast", "playNext", "pause", "isPlaying", "getProgress", "Lcom/syu/media/entities/MediaSource;", "getPlayingSong", "getPlayMode", NotificationCompat.CATEGORY_PROGRESS, "seekTo", "playMode", "setPlayMode", "audioSessionId", "Lcom/syu/media/ICallback;", "callback", "registerCallback", "unregisterCallback", "Lcom/syu/media/ICallback2;", "registerCallback2", "unregisterCallback2", Media.SONG_TABLE, "onSongChanged", "onPlayStatusChanged", "mode", "onPlayModeChanged", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "onVideoSizeChanged", "Lcom/syu/media/service/PlaybackService;", "a", "Lcom/syu/media/service/PlaybackService;", "getService", "()Lcom/syu/media/service/PlaybackService;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Lcom/syu/media/service/PlaybackService;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class PlaybackBinder extends IPlayer.Stub implements com.syu.media.player.IPlayer.Callback, com.syu.media.player.IPlayer.Callback2 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final PlaybackService service;
    public final PlayCallbackList b;
    public final VideoCallbackList c;

    public PlaybackBinder(PlaybackService playbackService) {
        Intrinsics.checkNotNullParameter(playbackService, NotificationCompat.CATEGORY_SERVICE);
        this.service = playbackService;
        this.b = new PlayCallbackList();
        this.c = new VideoCallbackList();
    }

    @Override // com.syu.media.IPlayer
    public int audioSessionId() {
        return this.service.audioSessionId();
    }

    @Override // com.syu.media.IPlayer
    public int getPlayMode() {
        return this.service.getPlayMode();
    }

    @Override // com.syu.media.IPlayer
    public MediaSource getPlayingSong() {
        return this.service.getPlayingSong();
    }

    @Override // com.syu.media.IPlayer
    public int getProgress() {
        return this.service.getProgress();
    }

    public final PlaybackService getService() {
        return this.service;
    }

    @Override // com.syu.media.IPlayer
    public boolean isPlaying() {
        return this.service.isPlaying();
    }

    @Override // com.syu.media.player.IPlayer.Callback
    public void onPlayModeChanged(int mode) {
        this.b.onPlayModeChanged(mode);
    }

    @Override // com.syu.media.player.IPlayer.Callback
    public void onPlayStatusChanged(boolean isPlaying) {
        this.b.onPlayStatusChanged(isPlaying);
    }

    @Override // com.syu.media.player.IPlayer.Callback
    public void onSongChanged(MediaSource song) {
        Intrinsics.checkNotNullParameter(song, Media.SONG_TABLE);
        this.b.onSongChanged(song);
    }

    @Override // com.syu.media.player.IPlayer.Callback2
    public void onVideoSizeChanged(int width, int height) {
        this.c.onVideoSizeChanged(width, height);
    }

    @Override // com.syu.media.IPlayer
    public boolean pause() {
        return this.service.pause();
    }

    @Override // com.syu.media.IPlayer
    public boolean play() {
        return this.service.play();
    }

    @Override // com.syu.media.IPlayer
    public boolean playLast() {
        return this.service.playLast();
    }

    @Override // com.syu.media.IPlayer
    public void playListWithId(int list, int id) {
        List<AudioSource> listListOfAllAudio;
        StringBuilder sb;
        PlayListWithAudios playListWithAudiosPlayListById;
        Log.e("music", "------------>>> playListWithId list: " + list + " id: " + id);
        if (this.service.getApplication() instanceof BaseMediaApp) {
            Object application = this.service.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.syu.media.BaseMediaApp");
            BaseMediaApp baseMediaApp = (BaseMediaApp) application;
            if (list == 2) {
                listListOfAllAudio = baseMediaApp.getDatabase().mediaDao().listOfAllAudio();
                if (listListOfAllAudio != null) {
                    sb = new StringBuilder("------------>>> playListWithId all list size: ");
                    Log.e("music", sb.append(listListOfAllAudio.size()).toString());
                    this.service.playListWithId(TypeIntrinsics.asMutableList(listListOfAllAudio), id);
                    baseMediaApp.getDatabase().mediaDao().updateAudioPlayList(listListOfAllAudio);
                }
            } else if (list != 3) {
                List<MediaSource> playList = this.service.getPlayList();
                if ((playList == null || playList.size() == 0) && (playListWithAudiosPlayListById = baseMediaApp.getDatabase().mediaDao().playListById(1)) != null) {
                    Log.e("music", "------------>>> playListWithId playList size: " + playListWithAudiosPlayListById.getAudios().size());
                    PlaybackService playbackService = this.service;
                    List<AudioSource> audios = playListWithAudiosPlayListById.getAudios();
                    Intrinsics.checkNotNull(audios, "null cannot be cast to non-null type kotlin.collections.MutableList<com.syu.media.entities.MediaSource>");
                    playbackService.playListWithId(TypeIntrinsics.asMutableList(audios), id);
                }
            } else {
                listListOfAllAudio = baseMediaApp.getDatabase().mediaDao().listOfFavorite();
                if (listListOfAllAudio != null) {
                    sb = new StringBuilder("------------>>> playListWithId Favorite list size: ");
                    Log.e("music", sb.append(listListOfAllAudio.size()).toString());
                    this.service.playListWithId(TypeIntrinsics.asMutableList(listListOfAllAudio), id);
                    baseMediaApp.getDatabase().mediaDao().updateAudioPlayList(listListOfAllAudio);
                }
            }
            StringBuilder sb2 = new StringBuilder("------------>>> playList ");
            List<MediaSource> playList2 = this.service.getPlayList();
            Log.e("music", sb2.append(playList2 != null ? Integer.valueOf(playList2.size()) : null).toString());
            List<MediaSource> playList3 = this.service.getPlayList();
            if (playList3 != null) {
                for (MediaSource mediaSource : playList3) {
                    Integer id2 = mediaSource.getId();
                    if (id2 != null && id2.intValue() == id) {
                        Log.e("music", "------------>>> playListWithId to play: " + mediaSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                        this.service.playListWithSource(playList3, mediaSource);
                    }
                }
            }
        }
    }

    @Override // com.syu.media.IPlayer
    public boolean playNext() {
        return this.service.playNext();
    }

    @Override // com.syu.media.IPlayer
    public void playWithId(int id) {
        this.service.playListWithId(null, id);
    }

    @Override // com.syu.media.IPlayer
    public void playWithPath(String path) {
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        this.service.playListWithPath(null, path);
    }

    @Override // com.syu.media.IPlayer
    public void registerCallback(ICallback callback) {
        this.b.register(callback);
    }

    @Override // com.syu.media.IPlayer
    public void registerCallback2(ICallback2 callback) {
        this.c.register(callback);
    }

    @Override // com.syu.media.IPlayer
    public boolean seekTo(int progress) {
        return this.service.seekTo(progress);
    }

    @Override // com.syu.media.IPlayer
    public void setPlayMode(int playMode) {
        this.service.setPlayMode(playMode);
    }

    @Override // com.syu.media.IPlayer
    public void unregisterCallback(ICallback callback) {
        this.b.unregister(callback);
    }

    @Override // com.syu.media.IPlayer
    public void unregisterCallback2(ICallback2 callback) {
        this.c.unregister(callback);
    }
}
