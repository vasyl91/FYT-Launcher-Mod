package syu.recyclerview;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\bF\u0010GJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001c\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0017J\u0014\u0010\f\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J*\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001c\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\"\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001a\u0010\u0019\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0012\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u000e\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R*\u0010/\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R.\u0010\u001b\u001a\u0004\u0018\u00018\u00002\b\u00107\u001a\u0004\u0018\u00018\u00008\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00101\u001a\u0004\b9\u00103\"\u0004\b:\u00105R*\u0010=\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R!\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\t8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lsyu/recyclerview/GroupNode;", "T", "Lsyu/recyclerview/Node;", "Lsyu/recyclerview/IGroup;", "node", "", "add", "position", "", "", "list", "addAll", "remove", "size", "nodeAt", "", "tag", "nodeAtByTag", "findNode", "addByTag", "addAllByTag", "removeByTag", "replaceByTag", "replaceByTagWithoutNotify", "replace", "replaceWithoutNotify", "clear", "data", "", "contains", "indexOf", "positionOf", "onExpanded", "onCollapsed", "loadChildren", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onClick", "lastNode", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lsyu/recyclerview/ViewHolder;", "c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "adapter", "d", "Ljava/lang/Object;", "getMTag", "()Ljava/lang/Object;", "setMTag", "(Ljava/lang/Object;)V", "mTag", "value", "e", "getData", "setData", "f", "Z", "isExpanded", "()Z", "setExpanded", "(Z)V", "g", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "children", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 7, 1})
public class GroupNode<T> extends Node<T> implements IGroup {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public RecyclerView.Adapter adapter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Object mTag;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Object data;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean isExpanded;
    public final ArrayList g = new ArrayList();

    public final GroupNode a(Object obj) {
        Node<?> nodeFindNode = findNode(obj);
        if (nodeFindNode instanceof GroupNode) {
            return (GroupNode) nodeFindNode;
        }
        return null;
    }

    @Override // syu.recyclerview.IGroup
    public int add(Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.g.add(node);
        node.onAdded();
        int iIndexOf = indexOf(node);
        if (this.isExpanded && getParent() != null) {
            GroupNode<?> parent = getParent();
            Intrinsics.checkNotNull(parent);
            iIndexOf += parent.indexOf(this) + 1;
            GroupNode<?> parent2 = getParent();
            Intrinsics.checkNotNull(parent2);
            parent2.add(iIndexOf, node);
        }
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(iIndexOf);
        }
        return iIndexOf;
    }

    @Override // syu.recyclerview.IGroup
    public void addAll(int position, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (position >= 0) {
            this.g.size();
        }
        boolean z = this.g.size() == 0;
        ArrayList arrayList = this.g;
        if (z) {
            arrayList.addAll(list);
        } else {
            arrayList.addAll(position, list);
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).onAdded();
        }
        if (this.isExpanded && getParent() != null) {
            GroupNode<?> parent = getParent();
            Intrinsics.checkNotNull(parent);
            int iIndexOf = parent.indexOf(this) + position + 1;
            GroupNode<?> parent2 = getParent();
            Intrinsics.checkNotNull(parent2);
            parent2.addAll(iIndexOf, list);
        }
        if (z) {
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        RecyclerView.Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            adapter2.notifyItemRangeChanged(position, this.g.size() - position);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addAllByTag(Object tag, int position, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.addAll(position, list);
        }
    }

    @Override // syu.recyclerview.IGroup
    public int addByTag(Object tag, Node<?> node) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            return groupNodeA.add(node);
        }
        return 0;
    }

    @Override // syu.recyclerview.IGroup
    public void clear() {
        if (!this.g.isEmpty()) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).onRemoved();
            }
        }
        this.g.clear();
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // syu.recyclerview.IGroup
    public boolean contains(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return a(data) != null;
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> findNode(Object tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(tag, ((Node) this.g.get(i)).getData())) {
                return (Node) this.g.get(i);
            }
        }
        return null;
    }

    public final RecyclerView.Adapter<ViewHolder> getAdapter() {
        return this.adapter;
    }

    public final List<Node<?>> getChildren() {
        return this.g;
    }

    @Override // syu.recyclerview.Node
    public T getData() {
        return (T) this.data;
    }

    public final Object getMTag() {
        return this.mTag;
    }

    public final int indexOf(Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return this.g.indexOf(node);
    }

    /* JADX INFO: renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> lastNode() {
        if (this.g.size() == 0) {
            return null;
        }
        return (Node) CollectionsKt.last(this.g);
    }

    public List<Node<?>> loadChildren() {
        return new ArrayList();
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> nodeAt(int position) {
        if (position >= 0 && position < this.g.size()) {
            return (Node) this.g.get(position);
        }
        return null;
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> nodeAtByTag(Object tag, int position) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            return groupNodeA.nodeAt(position);
        }
        return null;
    }

    @Override // syu.recyclerview.Node
    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        setExpanded(!this.isExpanded);
        Log.e("Test", "onClick ---------->> isExpanded : " + this.isExpanded + "  " + position);
    }

    public final void onCollapsed() {
        GroupNode<?> parent = getParent();
        if (parent != null) {
            Log.e("Qin", "item: " + getData() + " onCollapsed : from: " + (parent.indexOf(this) + 1) + "  size: " + this.g.size());
            parent.remove(this.g);
        }
        for (Node node : this.g) {
            if (node instanceof GroupNode) {
                ((GroupNode) node).onCollapsed();
            }
        }
    }

    public final void onExpanded() {
        for (Node node : this.g) {
            if (node instanceof GroupNode) {
                ((GroupNode) node).onExpanded();
            }
        }
        GroupNode<?> parent = getParent();
        if (parent != null) {
            parent.addAll(parent.indexOf(this) + 1, this.g);
        }
    }

    public final int positionOf(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(((Node) this.g.get(i)).getData(), data)) {
                return i;
            }
        }
        return -1;
    }

    @Override // syu.recyclerview.IGroup
    public void remove(int position) {
        int size;
        RecyclerView.Adapter adapter;
        if (position >= 0) {
            this.g.size();
        }
        ((Node) this.g.get(position)).onRemoved();
        if (this.adapter != null && (size = this.g.size() - position) > 0 && (adapter = this.adapter) != null) {
            adapter.notifyItemRangeRemoved(position, size);
        }
        Node<?> nodeNodeAt = nodeAt(position);
        if (nodeNodeAt != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), nodeNodeAt)) {
                    it.remove();
                    break;
                }
            }
        }
        if (!this.isExpanded || getParent() == null) {
            return;
        }
        GroupNode<?> parent = getParent();
        Intrinsics.checkNotNull(parent);
        int iIndexOf = parent.indexOf(this) + position + 1;
        GroupNode<?> parent2 = getParent();
        Intrinsics.checkNotNull(parent2);
        parent2.remove(iIndexOf);
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, int position) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.remove(position);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replace(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        clear();
        addAll(list);
    }

    @Override // syu.recyclerview.IGroup
    public void replaceByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.replace(list);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replaceByTagWithoutNotify(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.replaceWithoutNotify(list);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replaceWithoutNotify(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (!this.g.isEmpty()) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).onRemoved();
            }
        }
        this.g.clear();
        this.g.addAll(list);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((Node) it2.next()).onAdded();
        }
    }

    public final void setAdapter(RecyclerView.Adapter<ViewHolder> adapter) {
        this.adapter = adapter;
    }

    @Override // syu.recyclerview.Node
    public void setData(T t) {
        if (Intrinsics.areEqual(t, this.data)) {
            return;
        }
        this.data = t;
        clear();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new GroupNode$data$1(this, null), 3, (Object) null);
    }

    public final void setExpanded(boolean z) {
        if (z != this.isExpanded) {
            this.isExpanded = z;
            if (z) {
                onExpanded();
            } else {
                onCollapsed();
            }
        }
    }

    public final void setMTag(Object obj) {
        this.mTag = obj;
    }

    @Override // syu.recyclerview.IGroup
    public int size() {
        return this.g.size();
    }

    @Override // syu.recyclerview.IGroup
    public void add(int position, Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (position >= 0) {
            this.g.size();
        }
        this.g.add(position, node);
        node.onAdded();
        if (this.isExpanded && getParent() != null) {
            GroupNode<?> parent = getParent();
            Intrinsics.checkNotNull(parent);
            int iIndexOf = parent.indexOf(this) + position + 1;
            GroupNode<?> parent2 = getParent();
            Intrinsics.checkNotNull(parent2);
            parent2.add(iIndexOf, node);
        }
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemRangeChanged(position, this.g.size() - position);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addAll(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        addAll(this.g.size(), list);
    }

    @Override // syu.recyclerview.IGroup
    public void addAllByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.addAll(list);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addByTag(Object tag, int position, Node<?> node) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.add(position, node);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void remove(int position, int size) {
        if (position >= 0) {
            this.g.size();
        }
        if (position + size > this.g.size()) {
            size = this.g.size() - position;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.g.get(position + i));
        }
        if (arrayList.size() > 0) {
            remove(arrayList);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, int position, int size) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.remove(position, size);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void remove(List<Node<?>> list) {
        GroupNode<?> parent;
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.g.containsAll(list)) {
            int iIndexOf = this.g.indexOf(list.get(0));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).onRemoved();
            }
            if (iIndexOf >= 0 && this.adapter != null) {
                int size = list.size();
                Log.e("Qin", "item: " + getData() + " remove : position: " + iIndexOf + "  size: " + size);
                if (size > 0 && (adapter = this.adapter) != null) {
                    adapter.notifyItemRangeRemoved(iIndexOf, size);
                }
            }
            Iterator it2 = this.g.iterator();
            while (it2.hasNext()) {
                if (list.contains(it2.next())) {
                    it2.remove();
                }
            }
        }
        if (!this.isExpanded || (parent = getParent()) == null) {
            return;
        }
        parent.remove(list);
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.remove(list);
        }
    }

    @Override // syu.recyclerview.IGroup
    public void remove(Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (this.g.contains(node)) {
            int iIndexOf = this.g.indexOf(node);
            node.onRemoved();
            if (iIndexOf >= 0) {
                int size = this.g.size() - iIndexOf;
                RecyclerView.Adapter adapter = this.adapter;
                if (adapter != null) {
                    adapter.notifyItemRangeRemoved(iIndexOf, size);
                }
            }
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), node)) {
                    it.remove();
                    break;
                }
            }
        }
        if (!this.isExpanded || getParent() == null) {
            return;
        }
        GroupNode<?> parent = getParent();
        Intrinsics.checkNotNull(parent);
        parent.remove(node);
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, Node<?> node) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        GroupNode groupNodeA = a(tag);
        if (groupNodeA != null) {
            groupNodeA.remove(node);
        }
    }
}
