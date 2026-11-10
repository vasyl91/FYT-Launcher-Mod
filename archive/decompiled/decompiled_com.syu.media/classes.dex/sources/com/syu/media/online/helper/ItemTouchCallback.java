package com.syu.media.online.helper;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemTouchCallback.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/syu/media/online/helper/ItemTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "()V", "getMovementFlags", FinalChip.BSP_PLATFORM_Null, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", FinalChip.BSP_PLATFORM_Null, "target", "onSwiped", FinalChip.BSP_PLATFORM_Null, "direction", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemTouchCallback extends ItemTouchHelper.Callback {
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NotImplementedError */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) throws NotImplementedError {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NotImplementedError */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) throws NotImplementedError {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NotImplementedError */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) throws NotImplementedError {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
