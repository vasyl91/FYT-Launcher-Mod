package com.sothree.slidinguppanel;

import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ScrollableViewHelper {
    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    /* JADX WARN: Code duplicated, block: B:32:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x008f  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    public int getScrollableViewScrollPosition(View view, boolean z) {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        int decoratedBottom;
        int bottom;
        int decoratedMeasuredHeight;
        int decoratedTop;
        if (view == null) {
            return 0;
        }
        if (!(view instanceof ScrollView)) {
            if (!(view instanceof ListView)) {
                if (view instanceof RecyclerView) {
                    recyclerView = (RecyclerView) view;
                    if (recyclerView.getChildCount() > 0) {
                        layoutManager = recyclerView.getLayoutManager();
                        if (recyclerView.getAdapter() == null) {
                            return 0;
                        }
                        if (z) {
                            View childAt = recyclerView.getChildAt(0);
                            decoratedMeasuredHeight = layoutManager.getDecoratedMeasuredHeight(childAt) * recyclerView.getChildLayoutPosition(childAt);
                            decoratedTop = layoutManager.getDecoratedTop(childAt);
                        } else {
                            View childAt2 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                            decoratedBottom = layoutManager.getDecoratedBottom(childAt2) + (layoutManager.getDecoratedMeasuredHeight(childAt2) * (recyclerView.getAdapter().getItemCount() - 1));
                            bottom = recyclerView.getBottom();
                        }
                    }
                }
                return 0;
            }
            ListView listView = (ListView) view;
            if (listView.getChildCount() <= 0) {
                if (view instanceof RecyclerView) {
                    recyclerView = (RecyclerView) view;
                    if (recyclerView.getChildCount() > 0) {
                        layoutManager = recyclerView.getLayoutManager();
                        if (recyclerView.getAdapter() == null) {
                            return 0;
                        }
                        if (z) {
                            View childAt3 = recyclerView.getChildAt(0);
                            decoratedMeasuredHeight = layoutManager.getDecoratedMeasuredHeight(childAt3) * recyclerView.getChildLayoutPosition(childAt3);
                            decoratedTop = layoutManager.getDecoratedTop(childAt3);
                        } else {
                            View childAt4 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                            decoratedBottom = layoutManager.getDecoratedBottom(childAt4) + (layoutManager.getDecoratedMeasuredHeight(childAt4) * (recyclerView.getAdapter().getItemCount() - 1));
                            bottom = recyclerView.getBottom();
                        }
                    }
                }
                return 0;
            }
            if (listView.getAdapter() == null) {
                return 0;
            }
            if (!z) {
                View childAt5 = listView.getChildAt(listView.getChildCount() - 1);
                return (childAt5.getBottom() + (childAt5.getHeight() * ((listView.getAdapter().getCount() - listView.getLastVisiblePosition()) - 1))) - listView.getBottom();
            }
            View childAt6 = listView.getChildAt(0);
            decoratedMeasuredHeight = childAt6.getHeight() * listView.getFirstVisiblePosition();
            decoratedTop = childAt6.getTop();
            return decoratedMeasuredHeight - decoratedTop;
        }
        if (z) {
            return view.getScrollY();
        }
        ScrollView scrollView = (ScrollView) view;
        decoratedBottom = scrollView.getChildAt(0).getBottom();
        bottom = scrollView.getScrollY() + scrollView.getHeight();
        return decoratedBottom - bottom;
    }
}
