package com.syu.media.entities;

import chip.FinalChip;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/syu/media/entities/PlaylistWithVideo;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "isEmpty", "Lcom/syu/media/entities/VideoSource;", Media.VIDEO_TABLE, FinalChip.BSP_PLATFORM_Null, "addSong", "Lcom/syu/media/entities/PlayList;", "component1", FinalChip.BSP_PLATFORM_Null, "component2", Media.LIST_TABLE, "videos", "copy", FinalChip.BSP_PLATFORM_Null, "toString", "hashCode", "other", "equals", "a", "Lcom/syu/media/entities/PlayList;", "getList", "()Lcom/syu/media/entities/PlayList;", "setList", "(Lcom/syu/media/entities/PlayList;)V", "b", "Ljava/util/List;", "getVideos", "()Ljava/util/List;", "setVideos", "(Ljava/util/List;)V", "c", "I", "getVideoOfNum", "()I", "setVideoOfNum", "(I)V", "videoOfNum", "<init>", "(Lcom/syu/media/entities/PlayList;Ljava/util/List;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PlaylistWithVideo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public PlayList list;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public List videos;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int videoOfNum;

    public PlaylistWithVideo(PlayList playList, List<VideoSource> list) {
        Intrinsics.checkNotNullParameter(playList, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(list, "videos");
        this.list = playList;
        this.videos = list;
        this.videoOfNum = list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaylistWithVideo copy$default(PlaylistWithVideo playlistWithVideo, PlayList playList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            playList = playlistWithVideo.list;
        }
        if ((i & 2) != 0) {
            list = playlistWithVideo.videos;
        }
        return playlistWithVideo.copy(playList, list);
    }

    public final int addSong(VideoSource video) {
        Intrinsics.checkNotNullParameter(video, Media.VIDEO_TABLE);
        if (this.videos.contains(video)) {
            return this.videos.indexOf(video);
        }
        if (!this.videos.add(video)) {
            return -1;
        }
        int size = this.videos.size();
        this.videoOfNum = size;
        return size - 1;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PlayList getList() {
        return this.list;
    }

    public final List<VideoSource> component2() {
        return this.videos;
    }

    public final PlaylistWithVideo copy(PlayList list, List<VideoSource> videos) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(videos, "videos");
        return new PlaylistWithVideo(list, videos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaylistWithVideo)) {
            return false;
        }
        PlaylistWithVideo playlistWithVideo = (PlaylistWithVideo) other;
        return Intrinsics.areEqual(this.list, playlistWithVideo.list) && Intrinsics.areEqual(this.videos, playlistWithVideo.videos);
    }

    public final PlayList getList() {
        return this.list;
    }

    public final int getVideoOfNum() {
        return this.videoOfNum;
    }

    public final List<VideoSource> getVideos() {
        return this.videos;
    }

    public int hashCode() {
        return this.videos.hashCode() + (this.list.hashCode() * 31);
    }

    public final boolean isEmpty() {
        return !this.videos.isEmpty();
    }

    public final void setList(PlayList playList) {
        Intrinsics.checkNotNullParameter(playList, "<set-?>");
        this.list = playList;
    }

    public final void setVideoOfNum(int i) {
        this.videoOfNum = i;
    }

    public final void setVideos(List<VideoSource> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.videos = list;
    }

    public String toString() {
        return "PlaylistWithVideo(list=" + this.list + ", videos=" + this.videos + ')';
    }

    public /* synthetic */ PlaylistWithVideo(PlayList playList, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(playList, (i & 2) != 0 ? new ArrayList() : list);
    }
}
