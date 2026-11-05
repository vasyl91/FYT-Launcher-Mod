package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.yanzhenjie.recyclerview.x.R;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class AdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;
    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private RecyclerView.Adapter mAdapter;
    private LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemMenuClickListener mOnItemMenuClickListener;
    private SwipeMenuCreator mSwipeMenuCreator;
    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFootViews = new SparseArrayCompat<>();

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    AdapterWrapper(Context context, RecyclerView.Adapter adapter) {
        this.mInflater = LayoutInflater.from(context);
        this.mAdapter = adapter;
    }

    public RecyclerView.Adapter getOriginAdapter() {
        return this.mAdapter;
    }

    void setSwipeMenuCreator(SwipeMenuCreator swipeMenuCreator) {
        this.mSwipeMenuCreator = swipeMenuCreator;
    }

    void setOnItemMenuClickListener(OnItemMenuClickListener onItemMenuClickListener) {
        this.mOnItemMenuClickListener = onItemMenuClickListener;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public int getItemCount() {
        return getHeaderCount() + getContentItemCount() + getFooterCount();
    }

    private int getContentItemCount() {
        return this.mAdapter.getItemCount();
    }

    public int getItemViewType(int i) {
        if (isHeader(i)) {
            return this.mHeaderViews.keyAt(i);
        }
        if (isFooter(i)) {
            return this.mFootViews.keyAt((i - getHeaderCount()) - getContentItemCount());
        }
        return this.mAdapter.getItemViewType(i - getHeaderCount());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = (View) this.mHeaderViews.get(i);
        if (view != null) {
            return new ViewHolder(view);
        }
        View view2 = (View) this.mFootViews.get(i);
        if (view2 != null) {
            return new ViewHolder(view2);
        }
        final RecyclerView.ViewHolder viewHolderOnCreateViewHolder = this.mAdapter.onCreateViewHolder(viewGroup, i);
        if (this.mOnItemClickListener != null) {
            viewHolderOnCreateViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yanzhenjie.recyclerview.AdapterWrapper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AdapterWrapper.this.mOnItemClickListener.onItemClick(view3, viewHolderOnCreateViewHolder.getAdapterPosition());
                }
            });
        }
        if (this.mOnItemLongClickListener != null) {
            viewHolderOnCreateViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yanzhenjie.recyclerview.AdapterWrapper.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    AdapterWrapper.this.mOnItemLongClickListener.onItemLongClick(view3, viewHolderOnCreateViewHolder.getAdapterPosition());
                    return true;
                }
            });
        }
        if (this.mSwipeMenuCreator == null) {
            return viewHolderOnCreateViewHolder;
        }
        View viewInflate = this.mInflater.inflate(R.layout.x_recycler_view_item, viewGroup, false);
        ((ViewGroup) viewInflate.findViewById(R.id.swipe_content)).addView(viewHolderOnCreateViewHolder.itemView);
        try {
            Field declaredField = getSupperClass(viewHolderOnCreateViewHolder.getClass()).getDeclaredField("itemView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(viewHolderOnCreateViewHolder, viewInflate);
        } catch (Exception unused) {
        }
        return viewHolderOnCreateViewHolder;
    }

    private Class<?> getSupperClass(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == null || superclass.equals(Object.class)) ? cls : getSupperClass(superclass);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (isHeaderOrFooter(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        int headerCount = i - getHeaderCount();
        if ((view instanceof SwipeMenuLayout) && this.mSwipeMenuCreator != null) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
            SwipeMenu swipeMenu = new SwipeMenu(swipeMenuLayout);
            SwipeMenu swipeMenu2 = new SwipeMenu(swipeMenuLayout);
            this.mSwipeMenuCreator.onCreateMenu(swipeMenu, swipeMenu2, headerCount);
            SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.getChildAt(0);
            if (swipeMenu.hasMenuItems()) {
                swipeMenuView.setOrientation(swipeMenu.getOrientation());
                swipeMenuView.createMenu(viewHolder, swipeMenu, swipeMenuLayout, 1, this.mOnItemMenuClickListener);
            } else if (swipeMenuView.getChildCount() > 0) {
                swipeMenuView.removeAllViews();
            }
            SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.getChildAt(2);
            if (swipeMenu2.hasMenuItems()) {
                swipeMenuView2.setOrientation(swipeMenu2.getOrientation());
                swipeMenuView2.createMenu(viewHolder, swipeMenu2, swipeMenuLayout, -1, this.mOnItemMenuClickListener);
            } else if (swipeMenuView2.getChildCount() > 0) {
                swipeMenuView2.removeAllViews();
            }
        }
        this.mAdapter.onBindViewHolder(viewHolder, headerCount, list);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.yanzhenjie.recyclerview.AdapterWrapper.3
                public int getSpanSize(int i) {
                    if (AdapterWrapper.this.isHeaderOrFooter(i)) {
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

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (isHeaderOrFooter(viewHolder)) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams.setFullSpan(true);
                return;
            }
            return;
        }
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    public boolean isHeaderOrFooter(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof ViewHolder) {
            return true;
        }
        return isHeaderOrFooter(viewHolder.getAdapterPosition());
    }

    public boolean isHeaderOrFooter(int i) {
        return isHeader(i) || isFooter(i);
    }

    public boolean isHeader(int i) {
        return i >= 0 && i < getHeaderCount();
    }

    public boolean isFooter(int i) {
        return i >= getHeaderCount() + getContentItemCount();
    }

    public void addHeaderView(View view) {
        this.mHeaderViews.put(getHeaderCount() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addHeaderViewAndNotify(View view) {
        addHeaderView(view);
        notifyItemInserted(getHeaderCount() - 1);
    }

    public void removeHeaderViewAndNotify(View view) {
        int iIndexOfValue = this.mHeaderViews.indexOfValue(view);
        if (iIndexOfValue == -1) {
            return;
        }
        this.mHeaderViews.removeAt(iIndexOfValue);
        notifyItemRemoved(iIndexOfValue);
    }

    public void addFooterView(View view) {
        this.mFootViews.put(getFooterCount() + BASE_ITEM_TYPE_FOOTER, view);
    }

    public void addFooterViewAndNotify(View view) {
        addFooterView(view);
        notifyItemInserted(((getHeaderCount() + getContentItemCount()) + getFooterCount()) - 1);
    }

    public void removeFooterViewAndNotify(View view) {
        int iIndexOfValue = this.mFootViews.indexOfValue(view);
        if (iIndexOfValue == -1) {
            return;
        }
        this.mFootViews.removeAt(iIndexOfValue);
        notifyItemRemoved(getHeaderCount() + getContentItemCount() + iIndexOfValue);
    }

    public int getHeaderCount() {
        return this.mHeaderViews.size();
    }

    public int getFooterCount() {
        return this.mFootViews.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public final void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
    }

    public long getItemId(int i) {
        if (isHeaderOrFooter(i)) {
            return (-i) - 1;
        }
        return this.mAdapter.getItemId(i - getHeaderCount());
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (isHeaderOrFooter(viewHolder)) {
            return;
        }
        this.mAdapter.onViewRecycled(viewHolder);
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        if (isHeaderOrFooter(viewHolder)) {
            return false;
        }
        return this.mAdapter.onFailedToRecycleView(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (isHeaderOrFooter(viewHolder)) {
            return;
        }
        this.mAdapter.onViewDetachedFromWindow(viewHolder);
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }
}
