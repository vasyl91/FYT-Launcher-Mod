package com.yanzhenjie.recyclerview.touch;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private boolean isItemViewSwipeEnabled;
    private boolean isLongPressDragEnabled;
    private OnItemMoveListener onItemMoveListener;
    private OnItemMovementListener onItemMovementListener;
    private OnItemStateChangedListener onItemStateChangedListener;

    public void setLongPressDragEnabled(boolean z) {
        this.isLongPressDragEnabled = z;
    }

    public boolean isLongPressDragEnabled() {
        return this.isLongPressDragEnabled;
    }

    public void setItemViewSwipeEnabled(boolean z) {
        this.isItemViewSwipeEnabled = z;
    }

    public boolean isItemViewSwipeEnabled() {
        return this.isItemViewSwipeEnabled;
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        this.onItemMoveListener = onItemMoveListener;
    }

    public OnItemMoveListener getOnItemMoveListener() {
        return this.onItemMoveListener;
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        this.onItemMovementListener = onItemMovementListener;
    }

    public OnItemMovementListener getOnItemMovementListener() {
        return this.onItemMovementListener;
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        this.onItemStateChangedListener = onItemStateChangedListener;
    }

    public OnItemStateChangedListener getOnItemStateChangedListener() {
        return this.onItemStateChangedListener;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        OnItemMovementListener onItemMovementListener = this.onItemMovementListener;
        if (onItemMovementListener != null) {
            return makeMovementFlags(onItemMovementListener.onDragFlags(recyclerView, viewHolder), this.onItemMovementListener.onSwipeFlags(recyclerView, viewHolder));
        }
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (layoutManager.getOrientation() == 0) {
                return makeMovementFlags(15, 3);
            }
            return makeMovementFlags(15, 12);
        }
        if (layoutManager instanceof LinearLayoutManager) {
            if (layoutManager.getOrientation() == 0) {
                return makeMovementFlags(12, 3);
            }
            return makeMovementFlags(3, 12);
        }
        return makeMovementFlags(0, 0);
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        float fAbs;
        int width;
        if (i == 1) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            float f3 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int orientation = layoutManager.getOrientation();
                if (orientation == 0) {
                    fAbs = Math.abs(f2);
                    width = viewHolder.itemView.getHeight();
                } else if (orientation == 1) {
                    fAbs = Math.abs(f);
                    width = viewHolder.itemView.getWidth();
                }
                f3 = 1.0f - (fAbs / width);
            }
            viewHolder.itemView.setAlpha(f3);
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        OnItemMoveListener onItemMoveListener = this.onItemMoveListener;
        if (onItemMoveListener != null) {
            return onItemMoveListener.onItemMove(viewHolder, viewHolder2);
        }
        return false;
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        OnItemMoveListener onItemMoveListener = this.onItemMoveListener;
        if (onItemMoveListener != null) {
            onItemMoveListener.onItemDismiss(viewHolder);
        }
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
        OnItemStateChangedListener onItemStateChangedListener = this.onItemStateChangedListener;
        if (onItemStateChangedListener == null || i == 0) {
            return;
        }
        onItemStateChangedListener.onSelectedChanged(viewHolder, i);
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        OnItemStateChangedListener onItemStateChangedListener = this.onItemStateChangedListener;
        if (onItemStateChangedListener != null) {
            onItemStateChangedListener.onSelectedChanged(viewHolder, 0);
        }
    }
}
