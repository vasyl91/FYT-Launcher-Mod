package com.syu.media.entities;

import chip.FinalChip;
import com.syu.media.provider.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/syu/media/entities/AudioWithPlayLists;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;", "component1", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/PlayList;", "component2", Media.SONG_TABLE, "lists", "copy", FinalChip.BSP_PLATFORM_Null, "toString", FinalChip.BSP_PLATFORM_Null, "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", "a", "Lcom/syu/media/entities/AudioSource;", "getSong", "()Lcom/syu/media/entities/AudioSource;", "b", "Ljava/util/List;", "getLists", "()Ljava/util/List;", "<init>", "(Lcom/syu/media/entities/AudioSource;Ljava/util/List;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class AudioWithPlayLists {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final AudioSource song;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final List lists;

    public AudioWithPlayLists(AudioSource audioSource, List<PlayList> list) {
        Intrinsics.checkNotNullParameter(audioSource, Media.SONG_TABLE);
        Intrinsics.checkNotNullParameter(list, "lists");
        this.song = audioSource;
        this.lists = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioWithPlayLists copy$default(AudioWithPlayLists audioWithPlayLists, AudioSource audioSource, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            audioSource = audioWithPlayLists.song;
        }
        if ((i & 2) != 0) {
            list = audioWithPlayLists.lists;
        }
        return audioWithPlayLists.copy(audioSource, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AudioSource getSong() {
        return this.song;
    }

    public final List<PlayList> component2() {
        return this.lists;
    }

    public final AudioWithPlayLists copy(AudioSource song, List<PlayList> lists) {
        Intrinsics.checkNotNullParameter(song, Media.SONG_TABLE);
        Intrinsics.checkNotNullParameter(lists, "lists");
        return new AudioWithPlayLists(song, lists);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioWithPlayLists)) {
            return false;
        }
        AudioWithPlayLists audioWithPlayLists = (AudioWithPlayLists) other;
        return Intrinsics.areEqual(this.song, audioWithPlayLists.song) && Intrinsics.areEqual(this.lists, audioWithPlayLists.lists);
    }

    public final List<PlayList> getLists() {
        return this.lists;
    }

    public final AudioSource getSong() {
        return this.song;
    }

    public int hashCode() {
        return this.lists.hashCode() + (this.song.hashCode() * 31);
    }

    public String toString() {
        return "AudioWithPlayLists(song=" + this.song + ", lists=" + this.lists + ')';
    }
}
