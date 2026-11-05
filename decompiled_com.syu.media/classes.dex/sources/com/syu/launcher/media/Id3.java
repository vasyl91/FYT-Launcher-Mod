package com.syu.launcher.media;

import chip.FinalChip;
import com.syu.media.provider.Media;
import com.syu.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0012\u001a\u00020\u000bHÖ\u0001R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/syu/launcher/media/Id3;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "isValid", "other", "equals", FinalChip.BSP_PLATFORM_Null, "toString", "component1", "component2", "component3", FinalChip.BSP_PLATFORM_Null, "component4", "title", Media.ARTIST, Media.ALBUM, "playState", "copy", "hashCode", "a", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "b", "getArtist", "setArtist", "c", "getAlbum", "setAlbum", "d", "I", "getPlayState", "()I", "setPlayState", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class Id3 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public String title;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String artist;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public String album;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int playState;

    public Id3(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, Media.ARTIST);
        Intrinsics.checkNotNullParameter(str3, Media.ALBUM);
        this.title = str;
        this.artist = str2;
        this.album = str3;
        this.playState = i;
    }

    public static /* synthetic */ Id3 copy$default(Id3 id3, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = id3.title;
        }
        if ((i2 & 2) != 0) {
            str2 = id3.artist;
        }
        if ((i2 & 4) != 0) {
            str3 = id3.album;
        }
        if ((i2 & 8) != 0) {
            i = id3.playState;
        }
        return id3.copy(str, str2, str3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPlayState() {
        return this.playState;
    }

    public final Id3 copy(String title, String artist, String album, int playState) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, Media.ARTIST);
        Intrinsics.checkNotNullParameter(album, Media.ALBUM);
        return new Id3(title, artist, album, playState);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Id3)) {
            return super.equals(other);
        }
        Id3 id3 = (Id3) other;
        return Intrinsics.areEqual(id3.title, this.title) && Utils.equals(id3.album, this.album) && Utils.equals(id3.artist, this.artist) && id3.playState == this.playState;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final int getPlayState() {
        return this.playState;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.playState) + ((this.album.hashCode() + ((this.artist.hashCode() + (this.title.hashCode() * 31)) * 31)) * 31);
    }

    public final boolean isValid() {
        String str = this.title;
        return !(str == null || str.length() == 0);
    }

    public final void setAlbum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.album = str;
    }

    public final void setArtist(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.artist = str;
    }

    public final void setPlayState(int i) {
        this.playState = i;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "Id3: " + this.title + " - " + this.artist + " - " + this.album + "  time: playState: " + this.playState + "  ";
    }

    public /* synthetic */ Id3(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? FinalChip.BSP_PLATFORM_Null : str, (i2 & 2) != 0 ? FinalChip.BSP_PLATFORM_Null : str2, (i2 & 4) != 0 ? FinalChip.BSP_PLATFORM_Null : str3, i);
    }
}
