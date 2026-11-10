package com.syu.media.radio.diff;

import androidx.recyclerview.widget.DiffUtil;
import chip.FinalChip;
import com.syu.radio.entities.RadioStation;
import com.syu.radio.entities.Station;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.Node;

/* JADX INFO: compiled from: DiffCallBack.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/syu/media/radio/diff/DiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", FinalChip.BSP_PLATFORM_Null, "Lsyu/recyclerview/Node;", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", FinalChip.BSP_PLATFORM_Null, "oldItemPosition", FinalChip.BSP_PLATFORM_Null, "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        if ((this.oldData.get(oldItemPosition).getData() instanceof Station) && (this.newData.get(newItemPosition).getData() instanceof Station)) {
            Object data = this.oldData.get(oldItemPosition).getData();
            if (data == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.syu.radio.entities.Station");
            }
            int id = ((Station) data).getId();
            Object data2 = this.newData.get(newItemPosition).getData();
            if (data2 != null) {
                return id == ((Station) data2).getId();
            }
            throw new NullPointerException("null cannot be cast to non-null type com.syu.radio.entities.Station");
        }
        if ((this.oldData.get(oldItemPosition).getData() instanceof RadioStation) && (this.newData.get(newItemPosition).getData() instanceof RadioStation)) {
            Object data3 = this.oldData.get(oldItemPosition).getData();
            if (data3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.syu.radio.entities.RadioStation");
            }
            Integer id2 = ((RadioStation) data3).getId();
            Object data4 = this.newData.get(newItemPosition).getData();
            if (data4 != null) {
                return Intrinsics.areEqual(id2, ((RadioStation) data4).getId());
            }
            throw new NullPointerException("null cannot be cast to non-null type com.syu.radio.entities.RadioStation");
        }
        return Intrinsics.areEqual(this.oldData.get(oldItemPosition), this.newData.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual(this.oldData.get(oldItemPosition), this.newData.get(newItemPosition));
    }
}
