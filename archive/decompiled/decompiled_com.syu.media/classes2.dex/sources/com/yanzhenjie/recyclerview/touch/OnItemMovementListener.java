package com.yanzhenjie.recyclerview.touch;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface OnItemMovementListener {
    public static final int DOWN = 2;
    public static final int INVALID = 0;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int UP = 1;

    int onDragFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

    int onSwipeFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);
}
