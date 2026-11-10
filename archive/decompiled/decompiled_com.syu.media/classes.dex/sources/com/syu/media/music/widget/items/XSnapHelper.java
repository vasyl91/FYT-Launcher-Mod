package com.syu.media.music.widget.items;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XSnapHelper.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/syu/media/music/widget/items/XSnapHelper;", "Landroidx/recyclerview/widget/SnapHelper;", "()V", "calculateDistanceToFinalSnap", FinalChip.BSP_PLATFORM_Null, "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", FinalChip.BSP_PLATFORM_Null, "velocityX", "velocityY", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class XSnapHelper extends SnapHelper {
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (!(layoutManager instanceof XLayoutManager)) {
            return null;
        }
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            Log.d("LZP", "findSnapView :etPosition: " + layoutManager.getPosition(targetView));
            iArr[0] = ((XLayoutManager) layoutManager).calculateDistanceToPosition(layoutManager.getPosition(targetView));
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = ((XLayoutManager) layoutManager).calculateDistanceToPosition(layoutManager.getPosition(targetView));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof XLayoutManager)) {
            return null;
        }
        int fixedScrollPosition = ((XLayoutManager) layoutManager).getFixedScrollPosition();
        Log.d("LZP", "findSnapView pos:" + fixedScrollPosition);
        if (fixedScrollPosition != -1) {
            return layoutManager.findViewByPosition(fixedScrollPosition);
        }
        return null;
    }
}
