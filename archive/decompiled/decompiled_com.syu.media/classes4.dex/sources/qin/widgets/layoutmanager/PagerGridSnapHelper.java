package qin.widgets.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class PagerGridSnapHelper extends SnapHelper {
    public RecyclerView a;

    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        this.a = recyclerView;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int position = layoutManager.getPosition(view);
        PagerConfig.Loge("findTargetSnapPosition, pos = " + position);
        return layoutManager instanceof PagerGridLayoutManager ? ((PagerGridLayoutManager) layoutManager).b(position) : new int[2];
    }

    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new PagerGridSmoothScroller(this.a);
        }
        return null;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0045  */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int iA;
        PagerConfig.Loge("findTargetSnapPosition, velocityX = " + i + ", velocityY" + i2);
        if (layoutManager == null || !(layoutManager instanceof PagerGridLayoutManager)) {
            iA = -1;
        } else {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (!pagerGridLayoutManager.canScrollHorizontally()) {
                if (pagerGridLayoutManager.canScrollVertically()) {
                    if (i2 > PagerConfig.getFlingThreshold()) {
                        iA = pagerGridLayoutManager.a();
                    } else if (i2 < (-PagerConfig.getFlingThreshold())) {
                        iA = pagerGridLayoutManager.b();
                    }
                }
                iA = -1;
            } else if (i > PagerConfig.getFlingThreshold()) {
                iA = pagerGridLayoutManager.a();
            } else if (i < (-PagerConfig.getFlingThreshold())) {
                iA = pagerGridLayoutManager.b();
            } else {
                iA = -1;
            }
        }
        PagerConfig.Loge("findTargetSnapPosition, target = " + iA);
        return iA;
    }

    public boolean onFling(int i, int i2) {
        boolean z;
        LinearSmoothScroller linearSmoothScrollerCreateSnapScroller;
        int iFindTargetSnapPosition;
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager == null || this.a.getAdapter() == null) {
            return false;
        }
        int flingThreshold = PagerConfig.getFlingThreshold();
        PagerConfig.Loge("minFlingVelocity = " + flingThreshold);
        if (Math.abs(i2) <= flingThreshold && Math.abs(i) <= flingThreshold) {
            return false;
        }
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (linearSmoothScrollerCreateSnapScroller = createSnapScroller(layoutManager)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            z = false;
        } else {
            linearSmoothScrollerCreateSnapScroller.setTargetPosition(iFindTargetSnapPosition);
            layoutManager.startSmoothScroll(linearSmoothScrollerCreateSnapScroller);
            z = true;
        }
        return z;
    }

    public void setFlingThreshold(int i) {
        PagerConfig.setFlingThreshold(i);
    }
}
