package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;

import com.android.launcher66.DropTarget;

public class InfoDropTarget extends ButtonDropTarget {
    private TransitionDrawable mDrawable;
    private ColorStateList mOriginalTextColor;

    public InfoDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InfoDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mOriginalTextColor = getTextColors();
        Resources r = getResources();
        this.mHoverColor = ContextCompat.getColor(getContext(), R.color.info_target_hover_tint);
        this.mDrawable = (TransitionDrawable) getCurrentDrawable();
        if (this.mDrawable != null) {
            this.mDrawable.setCrossFadeEnabled(true);
        }
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == 2 && !LauncherAppState.getInstance().isScreenLarge()) {
            setText("");
        }
    }

    private boolean isFromAllApps(DragSource source) {
        return source instanceof AppsCustomizePagedView;
    }

    @Override
    public boolean acceptDrop(DropTarget.DragObject d) {
        ComponentName componentName = null;
        if (d.dragInfo instanceof AppInfo) {
            componentName = ((AppInfo) d.dragInfo).componentName;
        } else if (d.dragInfo instanceof ShortcutInfo) {
            componentName = ((ShortcutInfo) d.dragInfo).intent.getComponent();
        } else if (d.dragInfo instanceof PendingAddItemInfo) {
            componentName = ((PendingAddItemInfo) d.dragInfo).componentName;
        }
        if (componentName != null) {
            this.mLauncher.startApplicationDetailsActivity(componentName);
        }
        d.deferDragViewCleanupPostAnimation = false;
        return false;
    }

    @Override
    public void onDragStart(DragSource source, Object info, int dragAction) {
        boolean isVisible = true;
        if (!isFromAllApps(source)) {
            isVisible = false;
        }
        this.mActive = isVisible;
        this.mDrawable.resetTransition();
        setTextColor(this.mOriginalTextColor);
        ((ViewGroup) getParent()).setVisibility(isVisible ? View.VISIBLE : android.view.View.GONE);
    }

    @Override
    public void onDragEnd() {
        super.onDragEnd();
        this.mActive = false;
    }

    @Override
    public void onDragEnter(DropTarget.DragObject d) {
        super.onDragEnter(d);
        this.mDrawable.startTransition(this.mTransitionDuration);
        setTextColor(this.mHoverColor);
    }

    @Override
    public void onDragExit(DropTarget.DragObject d) {
        super.onDragExit(d);
        if (!d.dragComplete) {
            this.mDrawable.resetTransition();
            setTextColor(this.mOriginalTextColor);
        }
    }
}
