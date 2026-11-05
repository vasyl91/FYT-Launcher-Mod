package syu.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexConstructor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R(\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00018\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lsyu/recyclerview/Node;", "T", "", "", "index", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "onClick", "tag", "", "onLongClick", "getViewType", "Lsyu/recyclerview/ViewHolder;", "onBindViewHolder", "spanSize", "", "toString", "onAdded", "onRemoved", "Lsyu/recyclerview/GroupNode;", "a", "Lsyu/recyclerview/GroupNode;", "getParent", "()Lsyu/recyclerview/GroupNode;", "setParent", "(Lsyu/recyclerview/GroupNode;)V", "parent", "b", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "data", "<init>", "()V", "Companion", "Library_release"}, k = 1, mv = {1, 7, 1})
public abstract class Node<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public GroupNode parent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Object data;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J6\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J>\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006JG\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J8\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0011J@\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f2\u0006\u0010\t\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0011¨\u0006\u0014"}, d2 = {"Lsyu/recyclerview/Node$Companion;", "", "target", "Ljava/lang/Class;", "Lsyu/recyclerview/Node;", "clazz", "Lsyu/recyclerview/GroupNode;", "parent", "createNode", "outclzObj", "", "array", "", "createNodes", "([Ljava/lang/Object;Ljava/lang/Class;Lsyu/recyclerview/GroupNode;)Ljava/util/List;", "", "list", "Lsyu/recyclerview/NodeAdapter;", "adapter", "createNodesWithAdapter", "Library_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Node createNode$default(Companion companion, Object obj, Class cls, GroupNode groupNode, int i, Object obj2) {
            if ((i & 4) != 0) {
                groupNode = null;
            }
            return companion.createNode(obj, cls, groupNode);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List createNodes$default(Companion companion, List list, Class cls, GroupNode groupNode, int i, Object obj) {
            if ((i & 4) != 0) {
                groupNode = null;
            }
            return companion.createNodes((List<?>) list, (Class<? extends Node<?>>) cls, (GroupNode<?>) groupNode);
        }

        public final Node<?> createNode(Object target, Class<? extends Node<?>> clazz, GroupNode<?> parent) throws IllegalAccessException, InstantiationException {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Node<?> nodeNewInstance = clazz.newInstance();
            Intrinsics.checkNotNull(nodeNewInstance, "null cannot be cast to non-null type syu.recyclerview.Node<kotlin.Any>");
            Node<?> node = nodeNewInstance;
            node.setData(target);
            node.setParent(parent);
            return node;
        }

        public final List<Node<?>> createNodes(List<?> list, Class<? extends Node<?>> clazz, GroupNode<?> parent) throws IllegalAccessException, InstantiationException {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                Companion companion = Node.INSTANCE;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
                Node<?> nodeCreateNode = companion.createNode(t, clazz, parent);
                if (nodeCreateNode != null) {
                    arrayList.add(nodeCreateNode);
                }
            }
            return CollectionsKt.toMutableList(arrayList);
        }

        public final List<Node<?>> createNodesWithAdapter(Object outclzObj, List<?> list, Class<? extends Node<?>> clazz, NodeAdapter adapter) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(outclzObj, "outclzObj");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                Companion companion = Node.INSTANCE;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
                Node<?> nodeCreateNode = companion.createNode(outclzObj, t, clazz, adapter.getMData());
                if (nodeCreateNode != null) {
                    arrayList.add(nodeCreateNode);
                }
            }
            return CollectionsKt.toMutableList(arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Node createNode$default(Companion companion, Object obj, Object obj2, Class cls, GroupNode groupNode, int i, Object obj3) {
            if ((i & 8) != 0) {
                groupNode = null;
            }
            return companion.createNode(obj, obj2, cls, groupNode);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List createNodes$default(Companion companion, Object[] objArr, Class cls, GroupNode groupNode, int i, Object obj) {
            if ((i & 4) != 0) {
                groupNode = null;
            }
            return companion.createNodes(objArr, (Class<? extends Node<?>>) cls, (GroupNode<?>) groupNode);
        }

        public final Node<?> createNode(Object outclzObj, Object target, Class<? extends Node<?>> clazz, GroupNode<?> parent) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(outclzObj, "outclzObj");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            T tNewInstance = new ReflexConstructor(clazz).params(outclzObj).newInstance();
            Intrinsics.checkNotNull(tNewInstance, "null cannot be cast to non-null type syu.recyclerview.Node<kotlin.Any>");
            Node<?> node = (Node) tNewInstance;
            node.setData(target);
            node.setParent(parent);
            return node;
        }

        public final List<Node<?>> createNodes(Object[] array, Class<? extends Node<?>> clazz, GroupNode<?> parent) throws IllegalAccessException, InstantiationException {
            Intrinsics.checkNotNullParameter(array, "array");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            ArrayList arrayList = new ArrayList();
            for (Object obj : array) {
                Companion companion = Node.INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                Node<?> nodeCreateNode = companion.createNode(obj, clazz, parent);
                if (nodeCreateNode != null) {
                    arrayList.add(nodeCreateNode);
                }
            }
            return CollectionsKt.toMutableList(arrayList);
        }

        public final List<Node<?>> createNodesWithAdapter(List<?> list, Class<? extends Node<?>> clazz, NodeAdapter adapter) throws IllegalAccessException, InstantiationException {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                Companion companion = Node.INSTANCE;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
                Node<?> nodeCreateNode = companion.createNode(t, clazz, adapter.getMData());
                if (nodeCreateNode != null) {
                    arrayList.add(nodeCreateNode);
                }
            }
            return CollectionsKt.toMutableList(arrayList);
        }
    }

    public T getData() {
        return (T) this.data;
    }

    public final GroupNode<?> getParent() {
        return this.parent;
    }

    public int getViewType() {
        return 0;
    }

    public final int index() {
        GroupNode groupNode = this.parent;
        if (groupNode != null) {
            return groupNode.indexOf(this);
        }
        return 0;
    }

    public void onAdded() {
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public boolean onLongClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return false;
    }

    public void onRemoved() {
    }

    public void setData(T t) {
        this.data = t;
    }

    public final void setParent(GroupNode<?> groupNode) {
        this.parent = groupNode;
    }

    public int spanSize() {
        return 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        T data = getData();
        return sb.append(data != null ? data.toString() : null).append(" - ").append(super.toString()).toString();
    }

    public void onClick(RecyclerView.ViewHolder holder, int position, Object tag) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(tag, "tag");
    }
}
