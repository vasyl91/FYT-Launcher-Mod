package com.android.recycler;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Spacing between bar items.
 *
 * The previous version hard-coded dividerHeight = 0 with no way to change it, so
 * getItemOffsets() always wrote an empty Rect - a no-op on both the bottom and the left
 * bar. It also applied the offset to outRect.left unconditionally, which is the wrong
 * axis for the vertically scrolling left bar, and it inset the very first item, which
 * would have pushed the whole bar off-centre.
 *
 * The no-arg constructor still produces exactly the same no-op, so existing call sites
 * in Launcher.installBottomRecyclerDecorations() / installLeftRecyclerDecorations()
 * behave identically. Pass a pixel value to actually get a gap.
 */
public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {

    private final int dividerSizePx;

    /** No spacing - preserves the historical behaviour. */
    public SimpleDividerDecoration() {
        this(0);
    }

    /**
     * @param dividerSizePx gap inserted BEFORE every item except the first, in pixels.
     *                      Applied horizontally or vertically depending on the layout
     *                      manager's orientation.
     */
    public SimpleDividerDecoration(int dividerSizePx) {
        this.dividerSizePx = Math.max(0, dividerSizePx);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 0);

        if (dividerSizePx == 0) {
            return;
        }

        int position = parent.getChildAdapterPosition(view);
        if (position == RecyclerView.NO_POSITION || position == 0) {
            // No leading gap: the bottom bar is centred by the spacing decoration
            // installed alongside this one, and an extra inset on item 0 would skew it.
            return;
        }

        if (isVertical(parent)) {
            outRect.top = dividerSizePx;
        } else {
            outRect.left = dividerSizePx;
        }
    }

    private boolean isVertical(RecyclerView parent) {
        RecyclerView.LayoutManager lm = parent.getLayoutManager();
        if (lm instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) lm).getOrientation() == RecyclerView.VERTICAL;
        }
        return lm != null && lm.canScrollVertically();
    }
}
