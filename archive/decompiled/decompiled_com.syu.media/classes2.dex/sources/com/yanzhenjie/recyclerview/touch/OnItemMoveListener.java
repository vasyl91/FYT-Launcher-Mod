package com.yanzhenjie.recyclerview.touch;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface OnItemMoveListener {
    void onItemDismiss(RecyclerView.ViewHolder viewHolder);

    boolean onItemMove(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);
}
