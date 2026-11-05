package qin.widgets.layoutmanager;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class PagerGridSmoothScroller extends LinearSmoothScroller {
    public final RecyclerView a;

    public PagerGridSmoothScroller(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.a = recyclerView;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return PagerConfig.getMillisecondsPreInch() / displayMetrics.densityDpi;
    }

    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] iArrB = ((PagerGridLayoutManager) layoutManager).b(this.a.getChildAdapterPosition(view));
            int i = iArrB[0];
            int i2 = iArrB[1];
            PagerConfig.Logi("dx = " + i);
            PagerConfig.Logi("dy = " + i2);
            int iCalculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i), Math.abs(i2)));
            if (iCalculateTimeForScrolling > 0) {
                action.update(i, i2, iCalculateTimeForScrolling, ((LinearSmoothScroller) this).mDecelerateInterpolator);
            }
        }
    }
}
