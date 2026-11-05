package syu.recyclerview;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R.\u0010\u0014\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, d2 = {"Lsyu/recyclerview/NodeDiffAdapter;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "", "Lsyu/recyclerview/Node;", "a", "Ljava/util/List;", "getOldList", "()Ljava/util/List;", "setOldList", "(Ljava/util/List;)V", "oldList", "b", "getNewList", "setNewList", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class NodeDiffAdapter extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public List oldList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public List newList;

    /* JADX WARN: Illegal instructions before constructor call */
    public NodeDiffAdapter() {
        List list = null;
        this(list, list, 3, list);
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return areItemsTheSame(oldItemPosition, newItemPosition);
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        List list = this.oldList;
        Object data = null;
        Object data2 = (list == null || oldItemPosition >= list.size()) ? null : ((Node) list.get(oldItemPosition)).getData();
        List list2 = this.newList;
        if (list2 != null && newItemPosition < list2.size()) {
            data = ((Node) list2.get(newItemPosition)).getData();
        }
        if (data2 == null || data == null) {
            return false;
        }
        return Intrinsics.areEqual(data2, data);
    }

    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

    public final List<Node<?>> getNewList() {
        return this.newList;
    }

    public int getNewListSize() {
        List list = this.newList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final List<Node<?>> getOldList() {
        return this.oldList;
    }

    public int getOldListSize() {
        List list = this.oldList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void setNewList(List<? extends Node<?>> list) {
        this.newList = list;
    }

    public final void setOldList(List<? extends Node<?>> list) {
        this.oldList = list;
    }

    public NodeDiffAdapter(List<? extends Node<?>> list, List<? extends Node<?>> list2) {
        this.oldList = list;
        this.newList = list2;
    }

    public /* synthetic */ NodeDiffAdapter(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}
