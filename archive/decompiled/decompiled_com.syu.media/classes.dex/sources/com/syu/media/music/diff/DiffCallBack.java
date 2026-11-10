package com.syu.media.music.diff;

import androidx.recyclerview.widget.DiffUtil;
import chip.FinalChip;
import com.syu.media.api.AlbumInfo;
import com.syu.media.api.ArtistInfo;
import com.syu.media.api.FolderInfo;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.entities.RadioSource;
import com.syu.media.music.items.SpinItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: DiffCallBack.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/syu/media/music/diff/DiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", FinalChip.BSP_PLATFORM_Null, "oldItemPosition", FinalChip.BSP_PLATFORM_Null, "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiffCallBack extends DiffUtil.Callback {
    private final List<Node<?>> newData;
    private final List<Node<?>> oldData;

    public DiffCallBack(List<? extends Node<?>> list, List<? extends Node<?>> list2) {
        Intrinsics.checkNotNullParameter(list, "oldData");
        Intrinsics.checkNotNullParameter(list2, "newData");
        this.oldData = list;
        this.newData = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldData.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newData.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Object data = this.oldData.get(oldItemPosition).getData();
        Object data2 = this.newData.get(newItemPosition).getData();
        if ((data instanceof RadioSource) && (data2 instanceof RadioSource)) {
            return Intrinsics.areEqual(((RadioSource) data).getCom.syu.media.provider.Media.PATH java.lang.String(), ((RadioSource) data2).getCom.syu.media.provider.Media.PATH java.lang.String());
        }
        if ((data instanceof SpinItem) && (data2 instanceof SpinItem)) {
            AudioSource audioSource = (AudioSource) ((SpinItem) data).getData();
            String path = audioSource != null ? audioSource.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
            AudioSource audioSource2 = (AudioSource) ((SpinItem) data2).getData();
            return Intrinsics.areEqual(path, audioSource2 != null ? audioSource2.getCom.syu.media.provider.Media.PATH java.lang.String() : null);
        }
        if ((data instanceof AlbumInfo) && (data2 instanceof AlbumInfo)) {
            return Intrinsics.areEqual(((AlbumInfo) data).getCom.syu.media.provider.Media.ALBUM java.lang.String(), ((AlbumInfo) data2).getCom.syu.media.provider.Media.ALBUM java.lang.String());
        }
        if ((data instanceof ArtistInfo) && (data2 instanceof ArtistInfo)) {
            return Intrinsics.areEqual(((ArtistInfo) data).getName(), ((ArtistInfo) data2).getName());
        }
        if ((data instanceof FolderInfo) && (data2 instanceof FolderInfo)) {
            return Intrinsics.areEqual(((FolderInfo) data).getPath(), ((FolderInfo) data2).getPath());
        }
        if ((data instanceof MediaSource) && (data2 instanceof MediaSource)) {
            return Intrinsics.areEqual(((MediaSource) data).getId(), ((MediaSource) data2).getId());
        }
        return Intrinsics.areEqual(this.oldData.get(oldItemPosition), this.newData.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual(this.oldData.get(oldItemPosition), this.newData.get(newItemPosition));
    }
}
