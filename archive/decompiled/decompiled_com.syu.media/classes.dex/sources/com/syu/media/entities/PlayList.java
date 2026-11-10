package com.syu.media.entities;

import chip.FinalChip;
import java.sql.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J;\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,¨\u00066"}, d2 = {"Lcom/syu/media/entities/PlayList;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "component1", FinalChip.BSP_PLATFORM_Null, "component2", FinalChip.BSP_PLATFORM_Null, "component3", "Ljava/sql/Date;", "component4", "component5", "id", "title", "favorite", "creation", "playingIndex", "copy", "toString", "hashCode", "other", "equals", "a", "I", "getId", "()I", "setId", "(I)V", "b", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "c", "Z", "getFavorite", "()Z", "setFavorite", "(Z)V", "d", "Ljava/sql/Date;", "getCreation", "()Ljava/sql/Date;", "setCreation", "(Ljava/sql/Date;)V", "e", "getPlayingIndex", "setPlayingIndex", "f", "getUpdateTime", "setUpdateTime", "updateTime", "<init>", "(ILjava/lang/String;ZLjava/sql/Date;I)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PlayList {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String title;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean favorite;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Date creation;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int playingIndex;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public Date updateTime;

    public PlayList(int i, String str, boolean z, Date date, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(date, "creation");
        this.id = i;
        this.title = str;
        this.favorite = z;
        this.creation = date;
        this.playingIndex = i2;
        this.updateTime = date;
    }

    public static /* synthetic */ PlayList copy$default(PlayList playList, int i, String str, boolean z, Date date, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = playList.id;
        }
        if ((i3 & 2) != 0) {
            str = playList.title;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            z = playList.favorite;
        }
        boolean z2 = z;
        if ((i3 & 8) != 0) {
            date = playList.creation;
        }
        Date date2 = date;
        if ((i3 & 16) != 0) {
            i2 = playList.playingIndex;
        }
        return playList.copy(i, str2, z2, date2, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFavorite() {
        return this.favorite;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreation() {
        return this.creation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPlayingIndex() {
        return this.playingIndex;
    }

    public final PlayList copy(int id, String title, boolean favorite, Date creation, int playingIndex) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(creation, "creation");
        return new PlayList(id, title, favorite, creation, playingIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayList)) {
            return false;
        }
        PlayList playList = (PlayList) other;
        return this.id == playList.id && Intrinsics.areEqual(this.title, playList.title) && this.favorite == playList.favorite && Intrinsics.areEqual(this.creation, playList.creation) && this.playingIndex == playList.playingIndex;
    }

    public final Date getCreation() {
        return this.creation;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPlayingIndex() {
        return this.playingIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Date getUpdateTime() {
        return this.updateTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.title.hashCode() + (Integer.hashCode(this.id) * 31)) * 31;
        boolean z = this.favorite;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return Integer.hashCode(this.playingIndex) + ((this.creation.hashCode() + ((iHashCode + r0) * 31)) * 31);
    }

    public final void setCreation(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.creation = date;
    }

    public final void setFavorite(boolean z) {
        this.favorite = z;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPlayingIndex(int i) {
        this.playingIndex = i;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUpdateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updateTime = date;
    }

    public String toString() {
        return "PlayList(id=" + this.id + ", title=" + this.title + ", favorite=" + this.favorite + ", creation=" + this.creation + ", playingIndex=" + this.playingIndex + ')';
    }

    public /* synthetic */ PlayList(int i, String str, boolean z, Date date, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? FinalChip.BSP_PLATFORM_Null : str, z, date, i2);
    }
}
