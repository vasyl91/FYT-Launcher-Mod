package com.syu.media.player;

import android.view.Surface;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.media.entities.MediaSource;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u000212J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\u0011\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&J\u001e\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u0003H&J\"\u0010\u0015\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001e\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0019\u001a\u00020\u0006H&J\b\u0010\u001a\u001a\u00020\u000bH&J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006H&J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u001eH&J\b\u0010$\u001a\u00020\u001eH&J\b\u0010%\u001a\u00020\u001eH&J\b\u0010&\u001a\u00020\u001eH&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0003H&J\u0016\u0010)\u001a\u00020\u001e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0003H&J\u0012\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010.H&J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H&¨\u00063"}, d2 = {"Lcom/syu/media/player/IPlayer;", FinalChip.BSP_PLATFORM_Null, "audioSessionId", FinalChip.BSP_PLATFORM_Null, "getPlayList", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/MediaSource;", "getPlayMode", "getPlayingSong", "getProgress", "isPlaying", FinalChip.BSP_PLATFORM_Null, "pause", "play", "playLast", "playList", Media.LIST_TABLE, "playListWithId", "id", "playListWithIndex", "startIndex", "playListWithPath", Media.PATH, FinalChip.BSP_PLATFORM_Null, "playListWithSource", "source", "playNext", "playSource", Media.SONG_TABLE, "registerCallback", FinalChip.BSP_PLATFORM_Null, "callback", "Lcom/syu/media/player/IPlayer$Callback;", "registerCallback2", "Lcom/syu/media/player/IPlayer$Callback2;", "releasePlayer", "removeCallback2s", "removeCallbacks", "reset", "seekTo", NotificationCompat.CATEGORY_PROGRESS, "setPlayList", "setPlayMode", "playMode", "setSurface", "surface", "Landroid/view/Surface;", "unregisterCallback", "unregisterCallback2", "Callback", "Callback2", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IPlayer {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/syu/media/player/IPlayer$Callback;", FinalChip.BSP_PLATFORM_Null, "onPlayModeChanged", FinalChip.BSP_PLATFORM_Null, "mode", FinalChip.BSP_PLATFORM_Null, "onPlayStatusChanged", "isPlaying", FinalChip.BSP_PLATFORM_Null, "onSongChanged", Media.SONG_TABLE, "Lcom/syu/media/entities/MediaSource;", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Callback {
        void onPlayModeChanged(int mode);

        void onPlayStatusChanged(boolean isPlaying);

        void onSongChanged(MediaSource song);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/syu/media/player/IPlayer$Callback2;", FinalChip.BSP_PLATFORM_Null, "onVideoSizeChanged", FinalChip.BSP_PLATFORM_Null, Media.VIDEO_WIDTH, FinalChip.BSP_PLATFORM_Null, Media.VIDEO_HEIGHT, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Callback2 {
        void onVideoSizeChanged(int width, int height);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean playList$default(IPlayer iPlayer, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playList");
            }
            if ((i & 1) != 0) {
                list = new ArrayList();
            }
            return iPlayer.playList(list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean playListWithId$default(IPlayer iPlayer, List list, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playListWithId");
            }
            if ((i2 & 1) != 0) {
                list = null;
            }
            return iPlayer.playListWithId(list, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean playListWithPath$default(IPlayer iPlayer, List list, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playListWithPath");
            }
            if ((i & 1) != 0) {
                list = null;
            }
            return iPlayer.playListWithPath(list, str);
        }
    }

    int audioSessionId();

    List<MediaSource> getPlayList();

    int getPlayMode();

    MediaSource getPlayingSong();

    int getProgress();

    boolean isPlaying();

    boolean pause();

    boolean play();

    boolean playLast();

    boolean playList(List<MediaSource> list);

    boolean playListWithId(List<MediaSource> list, int id);

    boolean playListWithIndex(List<MediaSource> list, int startIndex);

    boolean playListWithPath(List<MediaSource> list, String path);

    boolean playListWithSource(List<MediaSource> list, MediaSource source);

    boolean playNext();

    boolean playSource(MediaSource song);

    void registerCallback(Callback callback);

    void registerCallback2(Callback2 callback);

    void releasePlayer();

    void removeCallback2s();

    void removeCallbacks();

    void reset();

    boolean seekTo(int progress);

    void setPlayList(List<MediaSource> list);

    void setPlayMode(int playMode);

    void setSurface(Surface surface);

    void unregisterCallback(Callback callback);

    void unregisterCallback2(Callback2 callback);
}
