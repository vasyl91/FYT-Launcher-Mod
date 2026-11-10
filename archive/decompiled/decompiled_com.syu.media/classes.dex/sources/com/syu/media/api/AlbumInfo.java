package com.syu.media.api;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/syu/media/api/AlbumInfo;", "Lcom/syu/media/api/MediaGroup;", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "d", "Ljava/lang/String;", "getAlbum", "()Ljava/lang/String;", "setAlbum", "(Ljava/lang/String;)V", Media.ALBUM, "e", "getArtist", "setArtist", Media.ARTIST, "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public class AlbumInfo extends MediaGroup {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public String album = FinalChip.BSP_PLATFORM_Null;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public String artist = FinalChip.BSP_PLATFORM_Null;

    public boolean equals(Object other) {
        return other instanceof AlbumInfo ? Intrinsics.areEqual(((AlbumInfo) other).album, this.album) : super.equals(other);
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final void setAlbum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.album = str;
    }

    public final void setArtist(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.artist = str;
    }
}
