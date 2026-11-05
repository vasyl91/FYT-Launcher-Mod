package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BorderItemDecoration extends RecyclerView.ItemDecoration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Drawer mDrawer;
    private final int mHeight;
    private final int mWidth;

    public BorderItemDecoration(int i) {
        this(i, 4, 4);
    }

    public BorderItemDecoration(int i, int i2, int i3) {
        int iRound = Math.round(i2 / 2.0f);
        this.mWidth = iRound;
        int iRound2 = Math.round(i3 / 2.0f);
        this.mHeight = iRound2;
        this.mDrawer = new ColorDrawer(i, iRound, iRound2);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.mWidth;
        int i2 = this.mHeight;
        rect.set(i, i2, i, i2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        canvas.save();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = layoutManager.getChildAt(i);
            this.mDrawer.drawLeft(childAt, canvas);
            this.mDrawer.drawTop(childAt, canvas);
            this.mDrawer.drawRight(childAt, canvas);
            this.mDrawer.drawBottom(childAt, canvas);
        }
        canvas.restore();
    }
}
