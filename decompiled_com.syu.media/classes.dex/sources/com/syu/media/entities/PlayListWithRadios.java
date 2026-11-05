package com.syu.media.entities;

import chip.FinalChip;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/syu/media/entities/PlayListWithRadios;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/PlayList;", "component1", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/RadioSource;", "component2", Media.LIST_TABLE, "radios", "copy", FinalChip.BSP_PLATFORM_Null, "toString", FinalChip.BSP_PLATFORM_Null, "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", "a", "Lcom/syu/media/entities/PlayList;", "getList", "()Lcom/syu/media/entities/PlayList;", "setList", "(Lcom/syu/media/entities/PlayList;)V", "b", "Ljava/util/List;", "getRadios", "()Ljava/util/List;", "setRadios", "(Ljava/util/List;)V", "<init>", "(Lcom/syu/media/entities/PlayList;Ljava/util/List;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PlayListWithRadios {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public PlayList list;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public List radios;

    public PlayListWithRadios(PlayList playList, List<RadioSource> list) {
        Intrinsics.checkNotNullParameter(playList, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(list, "radios");
        this.list = playList;
        this.radios = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayListWithRadios copy$default(PlayListWithRadios playListWithRadios, PlayList playList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            playList = playListWithRadios.list;
        }
        if ((i & 2) != 0) {
            list = playListWithRadios.radios;
        }
        return playListWithRadios.copy(playList, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PlayList getList() {
        return this.list;
    }

    public final List<RadioSource> component2() {
        return this.radios;
    }

    public final PlayListWithRadios copy(PlayList list, List<RadioSource> radios) {
        Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        Intrinsics.checkNotNullParameter(radios, "radios");
        return new PlayListWithRadios(list, radios);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayListWithRadios)) {
            return false;
        }
        PlayListWithRadios playListWithRadios = (PlayListWithRadios) other;
        return Intrinsics.areEqual(this.list, playListWithRadios.list) && Intrinsics.areEqual(this.radios, playListWithRadios.radios);
    }

    public final PlayList getList() {
        return this.list;
    }

    public final List<RadioSource> getRadios() {
        return this.radios;
    }

    public int hashCode() {
        return this.radios.hashCode() + (this.list.hashCode() * 31);
    }

    public final void setList(PlayList playList) {
        Intrinsics.checkNotNullParameter(playList, "<set-?>");
        this.list = playList;
    }

    public final void setRadios(List<RadioSource> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.radios = list;
    }

    public String toString() {
        return "PlayListWithRadios(list=" + this.list + ", radios=" + this.radios + ')';
    }

    public /* synthetic */ PlayListWithRadios(PlayList playList, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(playList, (i & 2) != 0 ? new ArrayList() : list);
    }
}
