package com.syu.media;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/syu/media/ConstraintState;", FinalChip.BSP_PLATFORM_Null, "rootFolder", FinalChip.BSP_PLATFORM_Null, Media.FOLDER, Media.ALBUM, Media.ARTIST, "favorite", FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlbum", "()Ljava/lang/String;", "setAlbum", "(Ljava/lang/String;)V", "getArtist", "setArtist", "getFavorite", "()I", "setFavorite", "(I)V", "getFolder", "setFolder", "getRootFolder", "setRootFolder", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ConstraintState {
    private String album;
    private String artist;
    private int favorite;
    private String folder;
    private String rootFolder;

    public ConstraintState() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ ConstraintState copy$default(ConstraintState constraintState, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = constraintState.rootFolder;
        }
        if ((i2 & 2) != 0) {
            str2 = constraintState.folder;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = constraintState.album;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = constraintState.artist;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = constraintState.favorite;
        }
        return constraintState.copy(str, str5, str6, str7, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRootFolder() {
        return this.rootFolder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFolder() {
        return this.folder;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getFavorite() {
        return this.favorite;
    }

    public final ConstraintState copy(String rootFolder, String folder, String album, String artist, int favorite) {
        return new ConstraintState(rootFolder, folder, album, artist, favorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConstraintState)) {
            return false;
        }
        ConstraintState constraintState = (ConstraintState) other;
        return Intrinsics.areEqual(this.rootFolder, constraintState.rootFolder) && Intrinsics.areEqual(this.folder, constraintState.folder) && Intrinsics.areEqual(this.album, constraintState.album) && Intrinsics.areEqual(this.artist, constraintState.artist) && this.favorite == constraintState.favorite;
    }

    public int hashCode() {
        String str = this.rootFolder;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.folder;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.album;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.artist;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Integer.hashCode(this.favorite);
    }

    public String toString() {
        return "ConstraintState(rootFolder=" + this.rootFolder + ", folder=" + this.folder + ", album=" + this.album + ", artist=" + this.artist + ", favorite=" + this.favorite + ')';
    }

    public ConstraintState(String str, String str2, String str3, String str4, int i) {
        this.rootFolder = str;
        this.folder = str2;
        this.album = str3;
        this.artist = str4;
        this.favorite = i;
    }

    public /* synthetic */ ConstraintState(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) == 0 ? str4 : null, (i2 & 16) != 0 ? 0 : i);
    }

    public final String getRootFolder() {
        return this.rootFolder;
    }

    public final void setRootFolder(String str) {
        this.rootFolder = str;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final void setFolder(String str) {
        this.folder = str;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final void setAlbum(String str) {
        this.album = str;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final void setArtist(String str) {
        this.artist = str;
    }

    public final int getFavorite() {
        return this.favorite;
    }

    public final void setFavorite(int i) {
        this.favorite = i;
    }
}
