package com.syu.media.music.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SpinSnapHelper extends SnapHelper {
    private int mDirection;

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        Log.d("skid", "calculateDistanceToFinalSnap");
        if (!(layoutManager instanceof SpinLayoutManager)) {
            return null;
        }
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = ((SpinLayoutManager) layoutManager).calculateDistanceToPosition(layoutManager.getPosition(view));
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = ((SpinLayoutManager) layoutManager).calculateDistanceToPosition(layoutManager.getPosition(view));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        Log.d("skid", "findTargetSnapPosition");
        if (layoutManager.canScrollHorizontally()) {
            this.mDirection = i;
            return -1;
        }
        this.mDirection = i2;
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof SpinLayoutManager)) {
            return null;
        }
        Log.d("skid", "findSnapView");
        SpinLayoutManager spinLayoutManager = (SpinLayoutManager) layoutManager;
        int i = this.mDirection;
        int fixedScrollPosition = spinLayoutManager.getFixedScrollPosition(i, i != 0 ? 0.8f : 0.5f);
        this.mDirection = 0;
        if (fixedScrollPosition != -1) {
            return layoutManager.findViewByPosition(fixedScrollPosition);
        }
        return null;
    }
}
