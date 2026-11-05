package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS = {android.R.attr.listDivider};
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;

    public FlexboxItemDecoration(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDrawable = drawable;
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        drawHorizontalDecorations(canvas, parent);
        drawVerticalDecorations(canvas, parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!needsHorizontalDecoration() && !needsVerticalDecoration()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        setOffsetAlongMainAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        setOffsetAlongCrossAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    private void setOffsetAlongCrossAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines) {
        if (flexLines.size() == 0 || layoutManager.getPositionToFlexLineIndex(position) == 0) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsHorizontalDecoration()) {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            } else {
                outRect.top = this.mDrawable.getIntrinsicHeight();
                outRect.bottom = 0;
                return;
            }
        }
        if (needsVerticalDecoration()) {
            if (layoutManager.isLayoutRtl()) {
                outRect.right = this.mDrawable.getIntrinsicWidth();
                outRect.left = 0;
            } else {
                outRect.left = this.mDrawable.getIntrinsicWidth();
                outRect.right = 0;
            }
        }
    }

    private void setOffsetAlongMainAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines, int flexDirection) {
        if (isFirstItemInLine(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsVerticalDecoration()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else if (layoutManager.isLayoutRtl()) {
                outRect.right = this.mDrawable.getIntrinsicWidth();
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.mDrawable.getIntrinsicWidth();
                outRect.right = 0;
                return;
            }
        }
        if (!needsHorizontalDecoration()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (flexDirection == 3) {
            outRect.bottom = this.mDrawable.getIntrinsicHeight();
            outRect.top = 0;
        } else {
            outRect.top = this.mDrawable.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i;
        int i2;
        if (needsVerticalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int top = parent.getTop() - parent.getPaddingTop();
            int bottom2 = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = parent.getChildAt(i3);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.isLayoutRtl()) {
                    intrinsicWidth = childAt.getRight() + layoutParams.rightMargin;
                    left = this.mDrawable.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    intrinsicWidth = left - this.mDrawable.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    iMax = childAt.getTop() - layoutParams.topMargin;
                    bottom = childAt.getBottom();
                    i = layoutParams.bottomMargin;
                } else {
                    if (flexDirection == 3) {
                        int iMin = Math.min(childAt.getBottom() + layoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom2);
                        iMax = childAt.getTop() - layoutParams.topMargin;
                        i2 = iMin;
                    } else {
                        iMax = Math.max((childAt.getTop() - layoutParams.topMargin) - this.mDrawable.getIntrinsicHeight(), top);
                        bottom = childAt.getBottom();
                        i = layoutParams.bottomMargin;
                    }
                    this.mDrawable.setBounds(intrinsicWidth, iMax, left, i2);
                    this.mDrawable.draw(canvas);
                }
                i2 = bottom + i;
                this.mDrawable.setBounds(intrinsicWidth, iMax, left, i2);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView parent) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int iMin;
        int left2;
        if (needsHorizontalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = parent.getLeft() - parent.getPaddingLeft();
            int right2 = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = parent.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + layoutParams.bottomMargin;
                    top = this.mDrawable.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - layoutParams.topMargin;
                    intrinsicHeight = top - this.mDrawable.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.isLayoutRtl()) {
                        iMin = Math.min(childAt.getRight() + layoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), right2);
                        left2 = childAt.getLeft() - layoutParams.leftMargin;
                    } else {
                        left = Math.max((childAt.getLeft() - layoutParams.leftMargin) - this.mDrawable.getIntrinsicWidth(), left3);
                        right = childAt.getRight();
                        i = layoutParams.rightMargin;
                    }
                    this.mDrawable.setBounds(left2, intrinsicHeight, iMin, top);
                    this.mDrawable.draw(canvas);
                } else {
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    right = childAt.getRight();
                    i = layoutParams.rightMargin;
                }
                int i3 = left;
                iMin = right + i;
                left2 = i3;
                this.mDrawable.setBounds(left2, intrinsicHeight, iMin, top);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 1) > 0;
    }

    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 2) > 0;
    }

    private boolean isFirstItemInLine(int position, List<FlexLine> flexLines, FlexboxLayoutManager layoutManager) {
        int positionToFlexLineIndex = layoutManager.getPositionToFlexLineIndex(position);
        if ((positionToFlexLineIndex == -1 || positionToFlexLineIndex >= layoutManager.getFlexLinesInternal().size() || layoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex != position) && position != 0) {
            return flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).mLastIndex == position - 1;
        }
        return true;
    }
}
