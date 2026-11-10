package com.syu.media.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import chip.FinalChip;
import com.syu.media.provider.Media;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b;\b\u0016\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\bG\u0010HB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\bG\u0010IJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\u0000R$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR$\u0010,\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\"\u00104\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00106\u001a\u0004\bD\u00108\"\u0004\bE\u0010:¨\u0006K"}, d2 = {"Lcom/syu/media/entities/MediaSource;", "Landroid/os/Parcelable;", FinalChip.BSP_PLATFORM_Null, "Landroid/graphics/Bitmap;", "getAlbumCover", "Landroid/os/Parcel;", "parcel", FinalChip.BSP_PLATFORM_Null, "flags", FinalChip.BSP_PLATFORM_Null, "writeToParcel", "describeContents", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "toString", "copy", "a", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "id", "b", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "c", "getDisplayName", "setDisplayName", Media.DISPLAY_NAME, "d", "getArtist", "setArtist", Media.ARTIST, "e", "getAlbum", "setAlbum", Media.ALBUM, "f", "getPath", "setPath", Media.PATH, "g", "getFolder", "setFolder", Media.FOLDER, "h", "I", "getDuration", "()I", "setDuration", "(I)V", Media.DURATION, "i", "Z", "getFavorite", "()Z", "setFavorite", "(Z)V", "favorite", "j", "getLength", "setLength", Media.LENGTH, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public class MediaSource implements Parcelable, Cloneable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Integer id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String title;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public String displayName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public String artist;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public String album;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public String path;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public String folder;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int duration;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public boolean favorite;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int length;

    /* JADX INFO: renamed from: com.syu.media.entities.MediaSource$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/syu/media/entities/MediaSource$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/syu/media/entities/MediaSource;", "Landroid/os/Parcel;", "parcel", "createFromParcel", FinalChip.BSP_PLATFORM_Null, "size", FinalChip.BSP_PLATFORM_Null, "newArray", "(I)[Lcom/syu/media/entities/MediaSource;", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements Parcelable.Creator<MediaSource> {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaSource createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaSource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaSource[] newArray(int size) {
            return new MediaSource[size];
        }
    }

    public MediaSource() {
        this.path = FinalChip.BSP_PLATFORM_Null;
        this.folder = FinalChip.BSP_PLATFORM_Null;
        this.duration = -1;
    }

    public Object clone() {
        return super.clone();
    }

    public final MediaSource copy() {
        Object objClone = clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.syu.media.entities.MediaSource");
        return (MediaSource) objClone;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        return other instanceof MediaSource ? Intrinsics.areEqual(this.path, ((MediaSource) other).path) : super.equals(other);
    }

    public final String getAlbum() {
        return this.album;
    }

    public Bitmap getAlbumCover() throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.path);
        Log.e("music", "----------------->>  getAlbumCover path: " + this.path + "  ---------------------");
        byte[] embeddedPicture = mediaMetadataRetriever.getEmbeddedPicture();
        Bitmap bitmapDecodeByteArray = embeddedPicture != null ? BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length) : null;
        mediaMetadataRetriever.release();
        return bitmapDecodeByteArray;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final String getFolder() {
        return this.folder;
    }

    public final Integer getId() {
        return this.id;
    }

    public final int getLength() {
        return this.length;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAlbum(String str) {
        this.album = str;
    }

    public final void setArtist(String str) {
        this.artist = str;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setFavorite(boolean z) {
        this.favorite = z;
    }

    public final void setFolder(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.folder = str;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setLength(int i) {
        this.length = i;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MediaSource(title=" + this.title + ", displayName=" + this.displayName + ", artist=" + this.artist + ", album=" + this.album + ", path=" + this.path + ", duration=" + this.duration + ", favorite=" + this.favorite + " )";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.id;
        Intrinsics.checkNotNull(num);
        parcel.writeInt(num.intValue());
        parcel.writeString(this.title);
        parcel.writeString(this.displayName);
        parcel.writeString(this.artist);
        parcel.writeString(this.album);
        parcel.writeString(this.path);
        parcel.writeString(this.folder);
        parcel.writeInt(this.duration);
        parcel.writeByte(this.favorite ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.length);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSource(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.id = Integer.valueOf(parcel.readInt());
        this.title = parcel.readString();
        this.displayName = parcel.readString();
        this.artist = parcel.readString();
        this.album = parcel.readString();
        String string = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string, "parcel.readString()");
        this.path = string;
        String string2 = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string2, "parcel.readString()");
        this.folder = string2;
        this.duration = parcel.readInt();
        this.favorite = parcel.readByte() != 0;
        this.length = parcel.readInt();
    }
}
