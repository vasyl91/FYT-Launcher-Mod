package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.launcher66.CellLayout;

public class MCellLayout extends CellLayout implements View.OnLongClickListener {
    public MCellLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnLongClickListener(this);
    }

    public MCellLayout(Context context) {
        super(context);
        setOnLongClickListener(this);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.layout(left, top, (left + r) - l, (top + b) - t);
        }
    }

    @Override
    boolean existsEmptyCell() {
        return false;
    }

    @Override
    public boolean animateChildToPosition(View child, int cellX, int cellY, int duration, int delay, boolean permanent, boolean adjustOccupied) {
        return false;
    }

    @Override
    public boolean addViewToCellLayout(View child, int index, int childId, CellLayout.LayoutParams params, boolean markCells) {
        if (params.cellX < 0 || params.cellX > getCountX() || params.cellY < 0 || params.cellY > getCountY()) {
            return false;
        }
        if (params.cellHSpan < 0) {
            params.cellHSpan = getCountX();
        }
        if (params.cellVSpan < 0) {
            params.cellVSpan = getCountY();
        }
        child.setId(childId);
        if (markCells) {
            markCellsAsOccupiedForView(child);
        }
        return true;
    }

    @Override
    int[] createArea(int pixelX, int pixelY, int minSpanX, int minSpanY, int spanX, int spanY, View dragView, int[] result, int[] resultSpan, int mode) {
        return new int[]{-1, -1};
    }

    @Override
    public boolean onLongClick(View v) {
        if (!(v instanceof MCellLayout) || Launcher.getWorkSpace().isInOverviewMode()) {
            return true;
        }
        if (Launcher.getWorkSpace().enterOverviewMode()) {
            if (Launcher.getLauncher() != null) {
                Launcher.getLauncher().hideHotseat(true);
            }
            Launcher.getWorkSpace().performHapticFeedback(0, 1);
            return true;
        }
        if (Launcher.getLauncher() != null) {
            Launcher.getLauncher().showHotseat(true);
        }
        return false;
    }
}
