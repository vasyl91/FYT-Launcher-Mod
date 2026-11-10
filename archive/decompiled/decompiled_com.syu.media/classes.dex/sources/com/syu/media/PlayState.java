package com.syu.media;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/syu/media/PlayState;", FinalChip.BSP_PLATFORM_Null, "dataId", FinalChip.BSP_PLATFORM_Null, "playPath", FinalChip.BSP_PLATFORM_Null, "playMode", "currentPlayTime", ConstantsKt.LAST_PLAY_TIME, "fragPage", "playListFlag", "isPlaying", FinalChip.BSP_PLATFORM_Null, "(ILjava/lang/String;IIIIIZ)V", "getCurrentPlayTime", "()I", "setCurrentPlayTime", "(I)V", "getDataId", "setDataId", "getFragPage", "setFragPage", "()Z", "setPlaying", "(Z)V", "getLastPlayTime", "setLastPlayTime", "getPlayListFlag", "setPlayListFlag", "getPlayMode", "setPlayMode", "getPlayPath", "()Ljava/lang/String;", "setPlayPath", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class PlayState {
    private int currentPlayTime;
    private int dataId;
    private int fragPage;
    private boolean isPlaying;
    private int lastPlayTime;
    private int playListFlag;
    private int playMode;
    private String playPath;

    public PlayState() {
        this(0, null, 0, 0, 0, 0, 0, false, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDataId() {
        return this.dataId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlayPath() {
        return this.playPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPlayMode() {
        return this.playMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCurrentPlayTime() {
        return this.currentPlayTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLastPlayTime() {
        return this.lastPlayTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFragPage() {
        return this.fragPage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPlayListFlag() {
        return this.playListFlag;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final PlayState copy(int dataId, String playPath, int playMode, int currentPlayTime, int lastPlayTime, int fragPage, int playListFlag, boolean isPlaying) {
        Intrinsics.checkNotNullParameter(playPath, "playPath");
        return new PlayState(dataId, playPath, playMode, currentPlayTime, lastPlayTime, fragPage, playListFlag, isPlaying);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayState)) {
            return false;
        }
        PlayState playState = (PlayState) other;
        return this.dataId == playState.dataId && Intrinsics.areEqual(this.playPath, playState.playPath) && this.playMode == playState.playMode && this.currentPlayTime == playState.currentPlayTime && this.lastPlayTime == playState.lastPlayTime && this.fragPage == playState.fragPage && this.playListFlag == playState.playListFlag && this.isPlaying == playState.isPlaying;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((((((((Integer.hashCode(this.dataId) * 31) + this.playPath.hashCode()) * 31) + Integer.hashCode(this.playMode)) * 31) + Integer.hashCode(this.currentPlayTime)) * 31) + Integer.hashCode(this.lastPlayTime)) * 31) + Integer.hashCode(this.fragPage)) * 31) + Integer.hashCode(this.playListFlag)) * 31;
        boolean z = this.isPlaying;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "PlayState(dataId=" + this.dataId + ", playPath=" + this.playPath + ", playMode=" + this.playMode + ", currentPlayTime=" + this.currentPlayTime + ", lastPlayTime=" + this.lastPlayTime + ", fragPage=" + this.fragPage + ", playListFlag=" + this.playListFlag + ", isPlaying=" + this.isPlaying + ')';
    }

    public PlayState(int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "playPath");
        this.dataId = i;
        this.playPath = str;
        this.playMode = i2;
        this.currentPlayTime = i3;
        this.lastPlayTime = i4;
        this.fragPage = i5;
        this.playListFlag = i6;
        this.isPlaying = z;
    }

    public /* synthetic */ PlayState(int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -1 : i, (i7 & 2) != 0 ? FinalChip.BSP_PLATFORM_Null : str, (i7 & 4) != 0 ? 0 : i2, (i7 & 8) != 0 ? 0 : i3, (i7 & 16) != 0 ? 0 : i4, (i7 & 32) != 0 ? 1 : i5, (i7 & 64) != 0 ? 0 : i6, (i7 & 128) == 0 ? z : false);
    }

    public final int getDataId() {
        return this.dataId;
    }

    public final void setDataId(int i) {
        this.dataId = i;
    }

    public final String getPlayPath() {
        return this.playPath;
    }

    public final void setPlayPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playPath = str;
    }

    public final int getPlayMode() {
        return this.playMode;
    }

    public final void setPlayMode(int i) {
        this.playMode = i;
    }

    public final int getCurrentPlayTime() {
        return this.currentPlayTime;
    }

    public final void setCurrentPlayTime(int i) {
        this.currentPlayTime = i;
    }

    public final int getLastPlayTime() {
        return this.lastPlayTime;
    }

    public final void setLastPlayTime(int i) {
        this.lastPlayTime = i;
    }

    public final int getFragPage() {
        return this.fragPage;
    }

    public final void setFragPage(int i) {
        this.fragPage = i;
    }

    public final int getPlayListFlag() {
        return this.playListFlag;
    }

    public final void setPlayListFlag(int i) {
        this.playListFlag = i;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }
}
