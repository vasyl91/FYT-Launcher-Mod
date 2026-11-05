package syu.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003OPQB\u0011\u0012\b\b\u0002\u0010L\u001a\u00020\u001d¢\u0006\u0004\bM\u0010NJ\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u001c\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u001a\u0010\f\u001a\u00020\t2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\"\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\u0014\u0010\r\u001a\u00020\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J$\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\"\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J*\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00062\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\u001c\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\nH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u001f\u00100\u001a\u0006\u0012\u0002\b\u00030+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010G\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0017\u0010K\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010B\u001a\u0004\bJ\u0010D¨\u0006R"}, d2 = {"Lsyu/recyclerview/NodeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lsyu/recyclerview/ViewHolder;", "Lsyu/recyclerview/IGroup;", "Lsyu/recyclerview/Node;", "node", "", "add", "position", "", "", "list", "addAll", "remove", "size", "nodeAt", "replace", "replaceWithoutNotify", "", "tag", "findNode", "addByTag", "addAllByTag", "removeByTag", "nodeAtByTag", "replaceByTag", "replaceByTagWithoutNotify", "clear", "data", "", "contains", "lastNode", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "getItemCount", "getItemViewType", "Lsyu/recyclerview/GroupNode;", "b", "Lkotlin/Lazy;", "getMData", "()Lsyu/recyclerview/GroupNode;", "mData", "Lsyu/recyclerview/NodeAdapter$OnItemClickListener;", "c", "Lsyu/recyclerview/NodeAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lsyu/recyclerview/NodeAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lsyu/recyclerview/NodeAdapter$OnItemClickListener;)V", "onItemClickListener", "Lsyu/recyclerview/NodeAdapter$OnItemLongClickListener;", "d", "Lsyu/recyclerview/NodeAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lsyu/recyclerview/NodeAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lsyu/recyclerview/NodeAdapter$OnItemLongClickListener;)V", "onItemLongClickListener", "e", "Ljava/lang/Object;", "getMTag", "()Ljava/lang/Object;", "setMTag", "(Ljava/lang/Object;)V", "mTag", "Ljava/lang/Object;", "f", "getLock", "lock", "isStandard", "<init>", "(Z)V", "OnItemClickListener", "OnItemLongClickListener", "TreeSpanSizeLookup", "Library_release"}, k = 1, mv = {1, 7, 1})
public class NodeAdapter extends RecyclerView.Adapter<ViewHolder> implements IGroup {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy mData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public OnItemClickListener onItemClickListener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public OnItemLongClickListener onItemLongClickListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Object mTag;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Object lock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH&¨\u0006\t"}, d2 = {"Lsyu/recyclerview/NodeAdapter$OnItemClickListener;", "", "onClick", "", "positionOfView", "", "positionOfData", "node", "Lsyu/recyclerview/Node;", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int positionOfView, int positionOfData, Node<?> node);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH&¨\u0006\t"}, d2 = {"Lsyu/recyclerview/NodeAdapter$OnItemLongClickListener;", "", "onLongClick", "", "positionOfView", "", "positionOfData", "node", "Lsyu/recyclerview/Node;", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnItemLongClickListener {
        void onLongClick(int positionOfView, int positionOfData, Node<?> node);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lsyu/recyclerview/NodeAdapter$TreeSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "a", "I", "getSpanCount", "()I", "spanCount", "<init>", "(Lsyu/recyclerview/NodeAdapter;I)V", "Library_release"}, k = 1, mv = {1, 7, 1})
    public final class TreeSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final int spanCount;

        public TreeSpanSizeLookup(int i) {
            this.spanCount = i;
        }

        public final int getSpanCount() {
            return this.spanCount;
        }

        public int getSpanSize(int position) {
            Node nodeAccess$dataAt = NodeAdapter.access$dataAt(NodeAdapter.this, position);
            int iSpanSize = nodeAccess$dataAt != null ? nodeAccess$dataAt.spanSize() : 1;
            if (iSpanSize <= 0) {
                return 1;
            }
            return this.spanCount / iSpanSize;
        }
    }

    public NodeAdapter() {
        this(false, 1, null);
    }

    public static final Node access$dataAt(NodeAdapter nodeAdapter, int i) {
        return nodeAdapter.getMData().nodeAt(i);
    }

    public static final boolean b(ViewHolder viewHolder, NodeAdapter nodeAdapter, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(nodeAdapter, "this$0");
        int layoutPosition = viewHolder.getLayoutPosition();
        Node<?> nodeNodeAt = nodeAdapter.getMData().nodeAt(layoutPosition);
        int iIndex = nodeNodeAt != null ? nodeNodeAt.index() : 0;
        Node<?> nodeNodeAt2 = nodeAdapter.getMData().nodeAt(layoutPosition);
        if (nodeNodeAt2 == null) {
            return false;
        }
        OnItemLongClickListener onItemLongClickListener = nodeAdapter.onItemLongClickListener;
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onLongClick(layoutPosition, iIndex, nodeNodeAt2);
        }
        return nodeNodeAt2.onLongClick(viewHolder, iIndex);
    }

    public final void a(final ViewHolder viewHolder) {
        if (!((RecyclerView.ViewHolder) viewHolder).itemView.hasOnClickListeners()) {
            ((RecyclerView.ViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: syu.recyclerview.NodeAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NodeAdapter.a(viewHolder, this, view);
                }
            });
        }
        if (((RecyclerView.ViewHolder) viewHolder).itemView.isLongClickable()) {
            return;
        }
        ((RecyclerView.ViewHolder) viewHolder).itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: syu.recyclerview.NodeAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return NodeAdapter.b(viewHolder, this, view);
            }
        });
    }

    @Override // syu.recyclerview.IGroup
    public int add(Node<?> node) {
        int iAdd;
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            iAdd = getMData().add(node);
        }
        return iAdd;
    }

    @Override // syu.recyclerview.IGroup
    public void addAll(int position, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().addAll(position, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addAllByTag(Object tag, int position, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().addAllByTag(tag, position, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public int addByTag(Object tag, Node<?> node) {
        int iAddByTag;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            iAddByTag = getMData().addByTag(tag, node);
        }
        return iAddByTag;
    }

    @Override // syu.recyclerview.IGroup
    public void clear() {
        synchronized (this.lock) {
            getMData().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public boolean contains(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return getMData().contains(data);
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> findNode(Object tag) {
        Node<?> nodeFindNode;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.lock) {
            nodeFindNode = getMData().findNode(tag);
        }
        return nodeFindNode;
    }

    public int getItemCount() {
        return getMData().size();
    }

    public int getItemViewType(int position) {
        Node<?> nodeNodeAt = getMData().nodeAt(position);
        if (nodeNodeAt != null) {
            return nodeNodeAt.getViewType();
        }
        return 0;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final GroupNode<?> getMData() {
        return (GroupNode) this.mData.getValue();
    }

    public final Object getMTag() {
        return this.mTag;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.onItemLongClickListener;
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> lastNode() {
        return getMData().lastNode();
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> nodeAt(int position) {
        Node<?> nodeNodeAt;
        synchronized (this.lock) {
            nodeNodeAt = getMData().nodeAt(position);
        }
        return nodeNodeAt;
    }

    @Override // syu.recyclerview.IGroup
    public Node<?> nodeAtByTag(Object tag, int position) {
        Node<?> nodeNodeAtByTag;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.lock) {
            nodeNodeAtByTag = getMData().nodeAtByTag(tag, position);
        }
        return nodeNodeAtByTag;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (!this.a) {
            GridLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = layoutManager;
                gridLayoutManager.setSpanSizeLookup(new TreeSpanSizeLookup(gridLayoutManager.getSpanCount()));
            }
        }
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // syu.recyclerview.IGroup
    public void remove(int position) {
        synchronized (this.lock) {
            getMData().remove(position);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, int position) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.lock) {
            getMData().removeByTag(tag, position);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replace(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().replace(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replaceByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().removeByTag(tag, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replaceByTagWithoutNotify(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().replaceByTagWithoutNotify(tag, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void replaceWithoutNotify(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().replaceWithoutNotify(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setMTag(Object obj) {
        this.mTag = obj;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public final void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override // syu.recyclerview.IGroup
    public int size() {
        return getMData().size();
    }

    public NodeAdapter(boolean z) {
        this.a = z;
        this.mData = LazyKt.lazy(new Function0<GroupNode<Object>>() { // from class: syu.recyclerview.NodeAdapter$mData$2
            {
                super(0);
            }

            public final GroupNode<Object> invoke() {
                GroupNode<Object> groupNode = new GroupNode<>();
                groupNode.setAdapter(this.a);
                return groupNode;
            }
        });
        this.lock = new Object();
    }

    public static final void a(ViewHolder viewHolder, NodeAdapter nodeAdapter, View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(nodeAdapter, "this$0");
        int layoutPosition = viewHolder.getLayoutPosition();
        Node<?> nodeNodeAt = nodeAdapter.getMData().nodeAt(layoutPosition);
        int iIndex = nodeNodeAt != null ? nodeNodeAt.index() : 0;
        Node<?> nodeNodeAt2 = nodeAdapter.getMData().nodeAt(layoutPosition);
        if (nodeNodeAt2 != null) {
            OnItemClickListener onItemClickListener = nodeAdapter.onItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onClick(layoutPosition, iIndex, nodeNodeAt2);
            }
            Object obj = nodeAdapter.mTag;
            if (obj != null) {
                nodeNodeAt2.onClick(viewHolder, iIndex, obj);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                nodeNodeAt2.onClick(viewHolder, iIndex);
            }
        }
    }

    @Override // syu.recyclerview.IGroup
    public void add(int position, Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            getMData().add(position, node);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addAll(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().addAll(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addAllByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().addAllByTag(tag, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void addByTag(Object tag, int position, Node<?> node) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            addByTag(tag, position, node);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Node<?> nodeNodeAt = getMData().nodeAt(position);
        if (nodeNodeAt != null) {
            nodeNodeAt.onBindViewHolder(holder);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewHolder viewHolderCreateViewHolder = ViewHolder.INSTANCE.createViewHolder(parent, viewType);
        a(viewHolderCreateViewHolder);
        return viewHolderCreateViewHolder;
    }

    @Override // syu.recyclerview.IGroup
    public void remove(int position, int size) {
        synchronized (this.lock) {
            getMData().remove(position, size);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, int position, int size) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.lock) {
            getMData().removeByTag(tag, position, size);
            Unit unit = Unit.INSTANCE;
        }
    }

    public /* synthetic */ NodeAdapter(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @Override // syu.recyclerview.IGroup
    public void remove(List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().remove(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, List<Node<?>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (this.lock) {
            getMData().removeByTag(tag, list);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void remove(Node<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            getMData().remove(node);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // syu.recyclerview.IGroup
    public void removeByTag(Object tag, Node<?> node) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.lock) {
            getMData().removeByTag(tag, node);
            Unit unit = Unit.INSTANCE;
        }
    }
}
