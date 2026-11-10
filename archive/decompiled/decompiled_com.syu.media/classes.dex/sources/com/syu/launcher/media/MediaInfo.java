package com.syu.launcher.media;

import android.graphics.drawable.Drawable;
import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b.\u0010/J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0011HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0011HÆ\u0001R\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/syu/launcher/media/MediaInfo;", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "hashCode", "isValidTime", "isValid", FinalChip.BSP_PLATFORM_Null, "toString", "Lcom/syu/launcher/media/Id3;", "component1", "Lcom/syu/launcher/media/PlayTime;", "component2", "Landroid/graphics/drawable/Drawable;", "component3", "Lcom/syu/launcher/media/MediaApp;", "component4", "id3", "playTime", Media.ICON, "mediaApp", "copy", "a", "Lcom/syu/launcher/media/Id3;", "getId3", "()Lcom/syu/launcher/media/Id3;", "setId3", "(Lcom/syu/launcher/media/Id3;)V", "b", "Lcom/syu/launcher/media/PlayTime;", "getPlayTime", "()Lcom/syu/launcher/media/PlayTime;", "setPlayTime", "(Lcom/syu/launcher/media/PlayTime;)V", "c", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "d", "Lcom/syu/launcher/media/MediaApp;", "getMediaApp", "()Lcom/syu/launcher/media/MediaApp;", "<init>", "(Lcom/syu/launcher/media/Id3;Lcom/syu/launcher/media/PlayTime;Landroid/graphics/drawable/Drawable;Lcom/syu/launcher/media/MediaApp;)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class MediaInfo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Id3 id3;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public PlayTime playTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Drawable icon;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MediaApp mediaApp;

    public MediaInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MediaInfo copy$default(MediaInfo mediaInfo, Id3 id3, PlayTime playTime, Drawable drawable, MediaApp mediaApp, int i, Object obj) {
        if ((i & 1) != 0) {
            id3 = mediaInfo.id3;
        }
        if ((i & 2) != 0) {
            playTime = mediaInfo.playTime;
        }
        if ((i & 4) != 0) {
            drawable = mediaInfo.icon;
        }
        if ((i & 8) != 0) {
            mediaApp = mediaInfo.mediaApp;
        }
        return mediaInfo.copy(id3, playTime, drawable, mediaApp);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Id3 getId3() {
        return this.id3;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlayTime getPlayTime() {
        return this.playTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Drawable getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MediaApp getMediaApp() {
        return this.mediaApp;
    }

    public final MediaInfo copy(Id3 id3, PlayTime playTime, Drawable icon, MediaApp mediaApp) {
        Intrinsics.checkNotNullParameter(id3, "id3");
        Intrinsics.checkNotNullParameter(playTime, "playTime");
        Intrinsics.checkNotNullParameter(mediaApp, "mediaApp");
        return new MediaInfo(id3, playTime, icon, mediaApp);
    }

    public boolean equals(Object other) {
        if (!(other instanceof MediaInfo)) {
            return super.equals(other);
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        return Intrinsics.areEqual(this.id3, mediaInfo.id3) && Intrinsics.areEqual(this.mediaApp, mediaInfo.mediaApp) && Intrinsics.areEqual(this.playTime, mediaInfo.playTime);
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final Id3 getId3() {
        return this.id3;
    }

    public final MediaApp getMediaApp() {
        return this.mediaApp;
    }

    public final PlayTime getPlayTime() {
        return this.playTime;
    }

    public int hashCode() {
        return new StringBuilder().append(this.mediaApp).append('-').append(this.id3).toString().hashCode();
    }

    public final boolean isValid() {
        return this.id3.isValid();
    }

    public final boolean isValidTime() {
        return this.id3.isValid() && this.playTime.isValid();
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final void setId3(Id3 id3) {
        Intrinsics.checkNotNullParameter(id3, "<set-?>");
        this.id3 = id3;
    }

    public final void setPlayTime(PlayTime playTime) {
        Intrinsics.checkNotNullParameter(playTime, "<set-?>");
        this.playTime = playTime;
    }

    public String toString() {
        return "MediaInfo: id3 = " + this.id3 + " time: " + this.playTime + " - icon: " + this.icon + "  " + this.mediaApp;
    }

    public MediaInfo(Id3 id3, PlayTime playTime, Drawable drawable, MediaApp mediaApp) {
        Intrinsics.checkNotNullParameter(id3, "id3");
        Intrinsics.checkNotNullParameter(playTime, "playTime");
        Intrinsics.checkNotNullParameter(mediaApp, "mediaApp");
        this.id3 = id3;
        this.playTime = playTime;
        this.icon = drawable;
        this.mediaApp = mediaApp;
    }

    public /* synthetic */ MediaInfo(Id3 id3, PlayTime playTime, Drawable drawable, MediaApp mediaApp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Id3(null, null, null, 0, 7, null) : id3, (i & 2) != 0 ? new PlayTime(0L, 0L, 3, null) : playTime, (i & 4) != 0 ? null : drawable, (i & 8) != 0 ? new MediaApp(null, null, null, 7, null) : mediaApp);
    }
}
