package com.syu.media.entities;

import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/syu/media/entities/PlaylistAudioCrossRef;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "component1", "component2", "listId", "audioId", "copy", FinalChip.BSP_PLATFORM_Null, "toString", "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", "a", "I", "getListId", "()I", "b", "getAudioId", "<init>", "(II)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PlaylistAudioCrossRef {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int listId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int audioId;

    public PlaylistAudioCrossRef(int i, int i2) {
        this.listId = i;
        this.audioId = i2;
    }

    public static /* synthetic */ PlaylistAudioCrossRef copy$default(PlaylistAudioCrossRef playlistAudioCrossRef, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = playlistAudioCrossRef.listId;
        }
        if ((i3 & 2) != 0) {
            i2 = playlistAudioCrossRef.audioId;
        }
        return playlistAudioCrossRef.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getListId() {
        return this.listId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAudioId() {
        return this.audioId;
    }

    public final PlaylistAudioCrossRef copy(int listId, int audioId) {
        return new PlaylistAudioCrossRef(listId, audioId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaylistAudioCrossRef)) {
            return false;
        }
        PlaylistAudioCrossRef playlistAudioCrossRef = (PlaylistAudioCrossRef) other;
        return this.listId == playlistAudioCrossRef.listId && this.audioId == playlistAudioCrossRef.audioId;
    }

    public final int getAudioId() {
        return this.audioId;
    }

    public final int getListId() {
        return this.listId;
    }

    public int hashCode() {
        return Integer.hashCode(this.audioId) + (Integer.hashCode(this.listId) * 31);
    }

    public String toString() {
        return "PlaylistAudioCrossRef(listId=" + this.listId + ", audioId=" + this.audioId + ')';
    }
}
