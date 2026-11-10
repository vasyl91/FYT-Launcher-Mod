package com.yanzhenjie.recyclerview;

import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.yanzhenjie.recyclerview.ExpandableAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ExpandableAdapter<VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
    private static final int TYPE_CHILD = 2;
    private static final int TYPE_PARENT = 1;
    private final SparseBooleanArray mExpandItemArray = new SparseBooleanArray();
    private final List<Integer> mParentViewType = new ArrayList();

    public abstract void bindChildHolder(VH vh, int i, int i2);

    public abstract void bindParentHolder(VH vh, int i);

    public abstract int childItemCount(int i);

    public int childItemViewType(int i, int i2) {
        return 2;
    }

    public abstract VH createChildHolder(ViewGroup viewGroup, int i);

    public abstract VH createParentHolder(ViewGroup viewGroup, int i);

    @Deprecated
    public final void onBindViewHolder(VH vh, int i) {
    }

    public abstract int parentItemCount();

    public int parentItemViewType(int i) {
        return 1;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ViewHolder) viewHolder, i, (List<Object>) list);
    }

    public final boolean isExpanded(int i) {
        return this.mExpandItemArray.get(i, false);
    }

    public final void expandParent(int i) {
        if (isExpanded(i)) {
            return;
        }
        this.mExpandItemArray.append(i, true);
        notifyItemRangeInserted(positionFromParentPosition(i) + 1, childItemCount(i));
    }

    public final void collapseParent(int i) {
        if (isExpanded(i)) {
            this.mExpandItemArray.append(i, false);
            notifyItemRangeRemoved(positionFromParentPosition(i) + 1, childItemCount(i));
        }
    }

    public final void notifyParentChanged(int i) {
        notifyItemChanged(positionFromParentPosition(i));
    }

    public final void notifyParentInserted(int i) {
        notifyItemInserted(positionFromParentPosition(i));
    }

    public final void notifyParentRemoved(int i) {
        notifyItemRemoved(positionFromParentPosition(i));
    }

    public final void notifyChildChanged(int i, int i2) {
        notifyItemChanged(positionFromChildPosition(i, i2));
    }

    public final void notifyChildInserted(int i, int i2) {
        notifyItemInserted(positionFromChildPosition(i, i2));
    }

    public final void notifyChildRemoved(int i, int i2) {
        notifyItemRemoved(positionFromChildPosition(i, i2));
    }

    private int positionFromParentPosition(int i) {
        int iParentItemCount = parentItemCount();
        int iChildItemCount = 0;
        for (int i2 = 0; i2 < iParentItemCount; i2++) {
            iChildItemCount++;
            if (i == i2) {
                return iChildItemCount - 1;
            }
            if (isExpanded(i2)) {
                iChildItemCount += childItemCount(i2);
            }
        }
        throw new IllegalStateException("The parent position is invalid: " + i);
    }

    private int positionFromChildPosition(int i, int i2) {
        int iParentItemCount = parentItemCount();
        int iChildItemCount = 0;
        for (int i3 = 0; i3 < iParentItemCount; i3++) {
            iChildItemCount++;
            if (i == i3) {
                if (i2 < childItemCount(i)) {
                    return (iChildItemCount + (i2 + 1)) - 1;
                }
                throw new IllegalStateException("The child position is invalid: " + i2);
            }
            if (isExpanded(i3)) {
                iChildItemCount += childItemCount(i3);
            }
        }
        throw new IllegalStateException("The parent position is invalid: " + i);
    }

    public final int getItemCount() {
        int iParentItemCount = parentItemCount();
        for (int i = 0; i < iParentItemCount; i++) {
            if (isExpanded(i)) {
                iParentItemCount += childItemCount(i);
            }
        }
        return iParentItemCount;
    }

    public final int getItemViewType(int i) {
        int iParentItemPosition = parentItemPosition(i);
        if (isParentItem(i)) {
            int iParentItemViewType = parentItemViewType(iParentItemPosition);
            checkViewType(iParentItemViewType);
            if (!this.mParentViewType.contains(Integer.valueOf(iParentItemViewType))) {
                this.mParentViewType.add(Integer.valueOf(iParentItemViewType));
            }
            return iParentItemViewType;
        }
        int iChildItemViewType = childItemViewType(iParentItemPosition, childItemPosition(i));
        checkViewType(iChildItemViewType);
        return iChildItemViewType;
    }

    private void checkViewType(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(String.format(Locale.US, "The value [%d] is reserved, please replace it with other values.", Integer.valueOf(i)));
        }
    }

    public final boolean isParentItem(int i) {
        int iParentItemCount = parentItemCount();
        int iChildItemCount = 0;
        for (int i2 = 0; i2 < iParentItemCount; i2++) {
            if (iChildItemCount == i) {
                return true;
            }
            iChildItemCount++;
            if (isExpanded(i2)) {
                iChildItemCount += childItemCount(i2);
            }
        }
        return false;
    }

    public final int parentItemPosition(int i) {
        int iChildItemCount = 0;
        for (int i2 = 0; i2 < parentItemCount(); i2++) {
            iChildItemCount++;
            if (isExpanded(i2)) {
                iChildItemCount += childItemCount(i2);
            }
            if (i < iChildItemCount) {
                return i2;
            }
        }
        throw new IllegalStateException("The adapter position is not a parent type: " + i);
    }

    public final int childItemPosition(int i) {
        int iChildItemCount;
        int iParentItemCount = parentItemCount();
        int iChildItemCount2 = 0;
        for (int i2 = 0; i2 < iParentItemCount; i2++) {
            iChildItemCount2++;
            if (isExpanded(i2) && i < (iChildItemCount2 = iChildItemCount2 + (iChildItemCount = childItemCount(i2)))) {
                return iChildItemCount - (iChildItemCount2 - i);
            }
        }
        throw new IllegalStateException("The adapter position is invalid: " + i);
    }

    public final VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.mParentViewType.contains(Integer.valueOf(i)) ? (VH) createParentHolder(viewGroup, i) : (VH) createChildHolder(viewGroup, i);
    }

    public final void onBindViewHolder(VH vh, int i, List<Object> list) {
        int iParentItemPosition = parentItemPosition(i);
        if (isParentItem(i)) {
            bindParentHolder(vh, iParentItemPosition, list);
        } else {
            bindChildHolder(vh, iParentItemPosition, childItemPosition(i), list);
        }
    }

    public void bindParentHolder(VH vh, int i, List<Object> list) {
        bindParentHolder(vh, i);
    }

    public void bindChildHolder(VH vh, int i, int i2, List<Object> list) {
        bindChildHolder(vh, i, i2);
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        private ExpandableAdapter mAdapter;

        public ViewHolder(View view, ExpandableAdapter expandableAdapter) {
            super(view);
            this.mAdapter = expandableAdapter;
        }

        public final boolean isParentItem() {
            return this.mAdapter.isParentItem(getAdapterPosition());
        }

        public final int parentItemPosition() {
            return this.mAdapter.parentItemPosition(getAdapterPosition());
        }

        public final int childItemPosition() {
            if (isParentItem()) {
                throw new IllegalStateException("This item is not a child item.");
            }
            return this.mAdapter.childItemPosition(getAdapterPosition());
        }

        public final boolean isParentExpanded() {
            return this.mAdapter.isExpanded(parentItemPosition());
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.yanzhenjie.recyclerview.ExpandableAdapter.1
                public int getSpanSize(int i) {
                    if (ExpandableAdapter.this.isParentItem(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i);
                    }
                    return 1;
                }
            });
        }
    }

    public void onViewAttachedToWindow(VH vh) {
        if (isParentItem(vh.getAdapterPosition())) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = ((ViewHolder) vh).itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams.setFullSpan(true);
            }
        }
    }
}
