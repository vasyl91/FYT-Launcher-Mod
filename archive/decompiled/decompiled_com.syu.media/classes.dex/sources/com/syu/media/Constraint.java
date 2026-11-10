package com.syu.media;

import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"BA\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0005¢\u0006\u0002\u0010\nJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006#"}, d2 = {"Lcom/syu/media/Constraint;", FinalChip.BSP_PLATFORM_Null, "rootFolder", FinalChip.BSP_PLATFORM_Null, Media.FOLDER, Media.ALBUM, Media.ARTIST, "favorite", FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "()V", "value", "getAlbum", "()Ljava/lang/String;", "setAlbum", "(Ljava/lang/String;)V", "getArtist", "setArtist", "getFavorite", "()I", "setFavorite", "(I)V", "getFolder", "setFolder", "mFlag", "getMFlag", "setMFlag", "getRootFolder", "setRootFolder", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Constraint {
    public static final int FLAG_ALBUM = 2;
    public static final int FLAG_ARTIST = 4;
    public static final int FLAG_FAVORITE = 2;
    public static final int FLAG_FOLDER = 1;
    public static final int FLAG_NULL = 0;
    public static final int FLAG_ROOT = 1;
    private String album;
    private String artist;
    private int favorite;
    private String folder;
    private int mFlag;
    private String rootFolder;

    public Constraint() {
    }

    public final int getMFlag() {
        return this.mFlag;
    }

    public final void setMFlag(int i) {
        this.mFlag = i;
    }

    public final String getRootFolder() {
        return this.rootFolder;
    }

    public final void setRootFolder(String str) {
        this.rootFolder = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.mFlag |= 16;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final void setFolder(String str) {
        this.folder = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.mFlag |= 1;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final void setAlbum(String str) {
        this.album = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.mFlag |= 2;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final void setArtist(String str) {
        this.artist = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.mFlag |= 4;
    }

    public final int getFavorite() {
        return this.favorite;
    }

    public final void setFavorite(int i) {
        this.favorite = i;
        if (i == 1) {
            this.mFlag |= 32;
        }
    }

    public /* synthetic */ Constraint(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) == 0 ? str4 : null, (i2 & 16) != 0 ? 0 : i);
    }

    public Constraint(String str, String str2, String str3, String str4, int i) {
        this();
        setRootFolder(str);
        setFolder(str2);
        setAlbum(str3);
        setArtist(str4);
        setFavorite(i);
    }

    public boolean equals(Object other) {
        if (other instanceof Constraint) {
            Constraint constraint = (Constraint) other;
            return Intrinsics.areEqual(constraint.rootFolder, this.rootFolder) && Intrinsics.areEqual(constraint.folder, this.folder) && Intrinsics.areEqual(constraint.album, this.album) && Intrinsics.areEqual(constraint.artist, this.artist) && constraint.favorite == this.favorite && constraint.mFlag == this.mFlag;
        }
        return super.equals(other);
    }

    public int hashCode() {
        return (this.rootFolder + this.folder + this.album + this.artist + this.favorite).hashCode();
    }

    public String toString() {
        return "rootFolder: " + this.rootFolder + " folder: " + this.folder + "  album:" + this.album + "  artist:" + this.artist + "  favorite:" + this.favorite;
    }
}
