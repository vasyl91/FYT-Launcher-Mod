package com.yanzhenjie.recyclerview.touch;

import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultItemTouchHelper extends ItemTouchHelper {
    private ItemTouchHelperCallback mItemTouchHelperCallback;

    public DefaultItemTouchHelper() {
        this(new ItemTouchHelperCallback());
    }

    private DefaultItemTouchHelper(ItemTouchHelperCallback itemTouchHelperCallback) {
        super(itemTouchHelperCallback);
        this.mItemTouchHelperCallback = itemTouchHelperCallback;
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        this.mItemTouchHelperCallback.setOnItemMoveListener(onItemMoveListener);
    }

    public OnItemMoveListener getOnItemMoveListener() {
        return this.mItemTouchHelperCallback.getOnItemMoveListener();
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        this.mItemTouchHelperCallback.setOnItemMovementListener(onItemMovementListener);
    }

    public OnItemMovementListener getOnItemMovementListener() {
        return this.mItemTouchHelperCallback.getOnItemMovementListener();
    }

    public void setLongPressDragEnabled(boolean z) {
        this.mItemTouchHelperCallback.setLongPressDragEnabled(z);
    }

    public boolean isLongPressDragEnabled() {
        return this.mItemTouchHelperCallback.isLongPressDragEnabled();
    }

    public void setItemViewSwipeEnabled(boolean z) {
        this.mItemTouchHelperCallback.setItemViewSwipeEnabled(z);
    }

    public boolean isItemViewSwipeEnabled() {
        return this.mItemTouchHelperCallback.isItemViewSwipeEnabled();
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        this.mItemTouchHelperCallback.setOnItemStateChangedListener(onItemStateChangedListener);
    }

    public OnItemStateChangedListener getOnItemStateChangedListener() {
        return this.mItemTouchHelperCallback.getOnItemStateChangedListener();
    }
}
