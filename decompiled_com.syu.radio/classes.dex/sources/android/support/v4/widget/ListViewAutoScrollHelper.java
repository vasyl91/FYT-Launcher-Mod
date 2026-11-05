package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(ListView target) {
        super(target);
        this.mTarget = target;
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public void scrollTargetBy(int deltaX, int deltaY) {
        View firstView;
        ListView target = this.mTarget;
        int firstPosition = target.getFirstVisiblePosition();
        if (firstPosition != -1 && (firstView = target.getChildAt(0)) != null) {
            int newTop = firstView.getTop() - deltaY;
            target.setSelectionFromTop(firstPosition, newTop);
        }
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int direction) {
        return false;
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int direction) {
        ListView target = this.mTarget;
        int itemCount = target.getCount();
        if (itemCount == 0) {
            return false;
        }
        int childCount = target.getChildCount();
        int firstPosition = target.getFirstVisiblePosition();
        int lastPosition = firstPosition + childCount;
        if (direction > 0) {
            if (lastPosition >= itemCount) {
                View lastView = target.getChildAt(childCount - 1);
                if (lastView.getBottom() <= target.getHeight()) {
                    return false;
                }
            }
        } else {
            if (direction >= 0) {
                return false;
            }
            if (firstPosition <= 0) {
                View firstView = target.getChildAt(0);
                if (firstView.getTop() >= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
