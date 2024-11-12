package com.android.launcher66;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.launcher66.DragController;
import com.android.launcher66.DropTarget;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ButtonDropTarget extends TextView implements DropTarget, DragController.DragListener {
    protected boolean mActive;
    private int mBottomDragPadding;
    protected int mHoverColor;
    protected Launcher mLauncher;
    protected SearchDropTargetBar mSearchDropTargetBar;
    protected TextView mText;
    protected final int mTransitionDuration;

    public ButtonDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHoverColor = 0;
        Resources r = getResources();
        this.mTransitionDuration = r.getInteger(R.integer.config_dropTargetBgTransitionDuration);
        this.mBottomDragPadding = r.getDimensionPixelSize(R.dimen.drop_target_drag_padding);
    }

    void setLauncher(Launcher launcher) {
        this.mLauncher = launcher;
    }

    @Override // com.android.launcher66.DropTarget
    public boolean acceptDrop(DropTarget.DragObject d) {
        return false;
    }

    public void setSearchDropTargetBar(SearchDropTargetBar searchDropTargetBar) {
        this.mSearchDropTargetBar = searchDropTargetBar;
    }

    protected Drawable getCurrentDrawable() {
        Drawable[] drawables = getCompoundDrawablesRelative();
        for (int i = 0; i < drawables.length; i++) {
            if (drawables[i] != null) {
                return drawables[i];
            }
        }
        return null;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDrop(DropTarget.DragObject d) {
    }

    @Override // com.android.launcher66.DropTarget
    public void onFlingToDelete(DropTarget.DragObject d, int x, int y, PointF vec) {
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragEnter(DropTarget.DragObject d) {
        d.dragView.setColor(this.mHoverColor);
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragOver(DropTarget.DragObject d) {
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragExit(DropTarget.DragObject d) {
        d.dragView.setColor(0);
    }

    @Override // com.android.launcher66.DragController.DragListener
    public void onDragStart(DragSource source, Object info, int dragAction) {
    }

    @Override // com.android.launcher66.DropTarget
    public boolean isDropEnabled() {
        return this.mActive;
    }

    @Override // com.android.launcher66.DragController.DragListener
    public void onDragEnd() {
    }

    @Override // com.android.launcher66.DropTarget
    public void getHitRectRelativeToDragLayer(Rect outRect) {
        super.getHitRect(outRect);
        outRect.bottom += this.mBottomDragPadding;
        int[] coords = new int[2];
        this.mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, coords);
        outRect.offsetTo(coords[0], coords[1]);
    }

    private boolean isRtl() {
        return getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    Rect getIconRect(int viewWidth, int viewHeight, int drawableWidth, int drawableHeight) {
        int left;
        int right;
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        Rect to = new Rect();
        dragLayer.getViewRectRelativeToSelf(this, to);
        if (isRtl()) {
            right = to.right - getPaddingRight();
            left = right - drawableWidth;
        } else {
            left = to.left + getPaddingLeft();
            right = left + drawableWidth;
        }
        int top = to.top + ((getMeasuredHeight() - drawableHeight) / 2);
        int bottom = top + drawableHeight;
        to.set(left, top, right, bottom);
        int xOffset = (-(viewWidth - drawableWidth)) / 2;
        int yOffset = (-(viewHeight - drawableHeight)) / 2;
        to.offset(xOffset, yOffset);
        return to;
    }

    @Override // com.android.launcher66.DropTarget
    public void getLocationInDragLayer(int[] loc) {
        this.mLauncher.getDragLayer().getLocationInDragLayer(this, loc);
    }
}
