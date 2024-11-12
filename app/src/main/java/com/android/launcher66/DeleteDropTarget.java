package com.android.launcher66;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.android.launcher66.DropTarget;
import com.syu.ipc.data.FinalCanbus;
import com.syu.util.JLog;
import java.util.List;
import java.util.Set;

public class DeleteDropTarget extends ButtonDropTarget {
    private TransitionDrawable mCurrentDrawable;
    private final int mFlingDeleteMode;
    private ColorStateList mOriginalTextColor;
    private TransitionDrawable mRemoveDrawable;
    private TransitionDrawable mUninstallDrawable;
    private boolean mWaitingForUninstall;
    private static int DELETE_ANIMATION_DURATION = 285;
    private static int FLING_DELETE_ANIMATION_DURATION = 350;
    private static float FLING_TO_DELETE_FRICTION = 0.035f;
    private static int MODE_FLING_DELETE_TO_TRASH = 0;
    private static int MODE_FLING_DELETE_ALONG_VECTOR = 1;

    public DeleteDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DeleteDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFlingDeleteMode = MODE_FLING_DELETE_ALONG_VECTOR;
        this.mWaitingForUninstall = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mOriginalTextColor = getTextColors();
        Resources r = getResources();
        this.mHoverColor = r.getColor(R.color.delete_target_hover_tint);
        this.mUninstallDrawable = (TransitionDrawable) r.getDrawable(R.drawable.uninstall_target_selector);
        this.mRemoveDrawable = (TransitionDrawable) r.getDrawable(R.drawable.remove_target_selector);
        this.mRemoveDrawable.setCrossFadeEnabled(true);
        this.mUninstallDrawable.setCrossFadeEnabled(true);
        this.mCurrentDrawable = (TransitionDrawable) getCurrentDrawable();
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == 2 && !LauncherAppState.getInstance().isScreenLarge()) {
            setText("");
        }
    }

    private boolean isAllAppsApplication(DragSource source, Object info) {
        return (source instanceof AppsCustomizePagedView) && (info instanceof AppInfo);
    }

    private boolean isAllAppsWidget(DragSource source, Object info) {
        if ((source instanceof AppsCustomizePagedView) && (info instanceof PendingAddItemInfo)) {
            PendingAddItemInfo addInfo = (PendingAddItemInfo) info;
            switch (addInfo.itemType) {
                case 1:
                case 4:
                    return true;
            }
        }
        return false;
    }

    private boolean isDragSourceWorkspaceOrFolder(DragObject d) {
        return (d.dragSource instanceof Workspace) || (d.dragSource instanceof Folder);
    }

    private boolean isWorkspaceOrFolderApplication(DragObject d) {
        return isDragSourceWorkspaceOrFolder(d) && (d.dragInfo instanceof ShortcutInfo);
    }

    private boolean isWorkspaceOrFolderWidget(DragObject d) {
        return isDragSourceWorkspaceOrFolder(d) && (d.dragInfo instanceof LauncherAppWidgetInfo);
    }

    private boolean isWorkspaceFolder(DragObject d) {
        return (d.dragSource instanceof Workspace) && (d.dragInfo instanceof FolderInfo);
    }

    private void setHoverColor() {
        this.mCurrentDrawable.startTransition(this.mTransitionDuration);
        setTextColor(this.mHoverColor);
    }

    private void resetHoverColor() {
        this.mCurrentDrawable.resetTransition();
        setTextColor(this.mOriginalTextColor);
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DropTarget
    public boolean acceptDrop(DragObject d) {
        return willAcceptDrop(d.dragInfo);
    }

    public static boolean willAcceptDrop(Object info) {
        if (info instanceof ShortcutInfo) {
            ShortcutInfo si = (ShortcutInfo) info;
            if (si.title.equals(Launcher.mLauncher.getResources().getString(R.string.apps))) {
                return false;
            }
        }
        if (info instanceof ItemInfo) {
            ItemInfo item = (ItemInfo) info;
            if (item.itemType == 4) {
                return info.toString().substring(0, 9).contains("AppWidget");
            }
            if (item.itemType == 1) {
                return true;
            }
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && item.itemType == 2) {
                return true;
            }
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && item.itemType == 0 && (item instanceof AppInfo)) {
                AppInfo appInfo = (AppInfo) info;
                return (appInfo.flags & 1) != 0;
            }
            if (item.itemType == 0 && (item instanceof ShortcutInfo)) {
                if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
                    return true;
                }
                ShortcutInfo shortcutInfo = (ShortcutInfo) info;
                return (shortcutInfo.flags & 1) != 0;
            }
        }
        JLog.getInstance().e("DeleteDropTarget willAcceptDrop false");
        return false;
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DragController.DragListener
    public void onDragStart(DragSource source, Object info, int dragAction) {
        boolean isVisible = true;
        boolean useUninstallLabel = !AppsCustomizePagedView.DISABLE_ALL_APPS && isAllAppsApplication(source, info);
        if (!willAcceptDrop(info) || isAllAppsWidget(source, info)) {
            isVisible = false;
        }
        this.mLauncher.appTextVisible(false);
        if (useUninstallLabel) {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, this.mUninstallDrawable, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, this.mRemoveDrawable, (Drawable) null, (Drawable) null);
        }
        this.mCurrentDrawable = (TransitionDrawable) getCurrentDrawable();
        this.mActive = isVisible;
        resetHoverColor();
        ((ViewGroup) getParent()).setVisibility(isVisible ? View.VISIBLE : View.GONE);
        if (getText().length() > 0) {
            setText(useUninstallLabel ? R.string.delete_target_uninstall_label : R.string.delete_target_label);
        }
        JLog.getInstance().e("DeleteDropTarget onDragStart isVisible = " + isVisible + "width = " + getWidth() + " height = " + getHeight());
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DragController.DragListener
    public void onDragEnd() {
        super.onDragEnd();
        this.mLauncher.appTextVisible(true);
        this.mActive = false;
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DropTarget
    public void onDragEnter(DragObject d) {
        super.onDragEnter(d);
        setHoverColor();
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DropTarget
    public void onDragExit(DragObject d) {
        super.onDragExit(d);
        if (!d.dragComplete) {
            resetHoverColor();
        } else {
            d.dragView.setColor(this.mHoverColor);
        }
    }

    private void animateToTrashAndCompleteDrop(final DragObject d) {
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(), this.mCurrentDrawable.getIntrinsicWidth(), this.mCurrentDrawable.getIntrinsicHeight());
        float scale = to.width() / from.width();
        this.mSearchDropTargetBar.deferOnDragEnd();
        deferCompleteDropIfUninstalling(d);
        Runnable onAnimationEndRunnable = new Runnable() { // from class: com.android.launcher66.DeleteDropTarget.1
            @Override // java.lang.Runnable
            public void run() {
                DeleteDropTarget.this.completeDrop(d);
                DeleteDropTarget.this.mSearchDropTargetBar.onDragEnd();
                if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_all_disable)) {
                    DeleteDropTarget.this.mLauncher.exitSpringLoadedDragMode();
                }
            }
        };
        dragLayer.animateView(d.dragView, from, to, scale, 1.0f, 1.0f, 0.1f, 0.1f, DELETE_ANIMATION_DURATION, new DecelerateInterpolator(2.0f), new LinearInterpolator(), onAnimationEndRunnable, 0, null);
    }

    private void deferCompleteDropIfUninstalling(DragObject d) {
        this.mWaitingForUninstall = false;
        if (isUninstallFromWorkspace(d)) {
            if (d.dragSource instanceof Folder) {
                ((Folder) d.dragSource).deferCompleteDropAfterUninstallActivity();
            } else if (d.dragSource instanceof Workspace) {
                ((Workspace) d.dragSource).deferCompleteDropAfterUninstallActivity();
            }
            this.mWaitingForUninstall = true;
        }
    }

    private boolean isUninstallFromWorkspace(DragObject d) {
        if (AppsCustomizePagedView.DISABLE_ALL_APPS && isWorkspaceOrFolderApplication(d)) {
            ShortcutInfo shortcut = (ShortcutInfo) d.dragInfo;
            if (shortcut.intent != null && shortcut.intent.getComponent() != null) {
                Set<String> categories = shortcut.intent.getCategories();
                boolean includesLauncherCategory = false;
                if (categories != null) {
                    for (String category : categories) {
                        if (category.equals(Intent.CATEGORY_LAUNCHER)) {
                            includesLauncherCategory = true;
                            break;
                        }
                    }
                }
                return includesLauncherCategory;
            }
        }
        return false;
    }

    private void completeDrop(DragObject d) {
        ItemInfo item = (ItemInfo) d.dragInfo;
        boolean wasWaitingForUninstall = mWaitingForUninstall;
        mWaitingForUninstall = false;
        if (isAllAppsApplication(d.dragSource, item)) {
            // Uninstall the application if it is being dragged from AppsCustomize
            AppInfo appInfo = (AppInfo) item;
            mLauncher.startApplicationUninstallActivity(appInfo.componentName, appInfo.flags);
        } else if (isUninstallFromWorkspace(d)) {
            ShortcutInfo shortcut = (ShortcutInfo) item;
            if (shortcut.intent != null && shortcut.intent.getComponent() != null) {
                final ComponentName componentName = shortcut.intent.getComponent();
                final DragSource dragSource = d.dragSource;
                int flags = AppInfo.initFlags(
                    ShortcutInfo.getPackageInfo(getContext(), componentName.getPackageName()));
                mWaitingForUninstall =
                    mLauncher.startApplicationUninstallActivity(componentName, flags);
                if (mWaitingForUninstall) {
                    final Runnable checkIfUninstallWasSuccess = new Runnable() {
                        @Override
                        public void run() {
                            mWaitingForUninstall = false;
                            String packageName = componentName.getPackageName();
                            List<ResolveInfo> activities =
                                    AllAppsList.findActivitiesForPackage(getContext(), packageName);
                            boolean uninstallSuccessful = activities.size() == 0;
                            if (dragSource instanceof Folder) {
                                ((Folder) dragSource).
                                    onUninstallActivityReturned(uninstallSuccessful);
                            } else if (dragSource instanceof Workspace) {
                                ((Workspace) dragSource).
                                    onUninstallActivityReturned(uninstallSuccessful);
                            }
                        }
                    };
                    mLauncher.addOnResumeCallback(checkIfUninstallWasSuccess);
                }
            }
        } else if (isWorkspaceOrFolderApplication(d)) {
            LauncherModel.deleteItemFromDatabase(mLauncher, item);
        } else if (isWorkspaceFolder(d)) {
            // Remove the folder from the workspace and delete the contents from launcher model
            FolderInfo folderInfo = (FolderInfo) item;
            mLauncher.removeFolder(folderInfo);
            LauncherModel.deleteFolderContentsFromDatabase(mLauncher, folderInfo);
        } else if (isWorkspaceOrFolderWidget(d)) {
            // Remove the widget from the workspace
            mLauncher.removeAppWidget((LauncherAppWidgetInfo) item);
            LauncherModel.deleteItemFromDatabase(mLauncher, item);

            final LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) item;
            final LauncherAppWidgetHost appWidgetHost = mLauncher.getAppWidgetHost();
            if (appWidgetHost != null) {
                // Deleting an app widget ID is a void call but writes to disk before returning
                // to the caller...
                new Thread("deleteAppWidgetId") {
                    public void run() {
                        appWidgetHost.deleteAppWidgetId(launcherAppWidgetInfo.appWidgetId);
                    }
                }.start();
            }
        }
        if (wasWaitingForUninstall && !mWaitingForUninstall) {
            if (d.dragSource instanceof Folder) {
                ((Folder) d.dragSource).onUninstallActivityReturned(false);
            } else if (d.dragSource instanceof Workspace) {
                ((Workspace) d.dragSource).onUninstallActivityReturned(false);
            }
        }
    }

    public void onDrop(DragObject d) {
        animateToTrashAndCompleteDrop(d);
    }

    private ValueAnimator.AnimatorUpdateListener createFlingToTrashAnimatorListener(final DragLayer dragLayer, DragObject d, PointF vel, ViewConfiguration config) {
        Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(), this.mCurrentDrawable.getIntrinsicWidth(), this.mCurrentDrawable.getIntrinsicHeight());
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        float velocity = Math.abs(vel.length());
        float vp = Math.min(1.0f, velocity / (config.getScaledMaximumFlingVelocity() / 2.0f));
        int offsetY = (int) ((-from.top) * vp);
        int offsetX = (int) (offsetY / (vel.y / vel.x));
        final float y2 = from.top + offsetY;
        final float x2 = from.left + offsetX;
        final float x1 = from.left;
        final float y1 = from.top;
        final float x3 = to.left;
        final float y3 = to.top;
        final TimeInterpolator scaleAlphaInterpolator = new TimeInterpolator() { // from class: com.android.launcher66.DeleteDropTarget.4
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float t) {
                return t * t * t * t * t * t * t * t;
            }
        };
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.DeleteDropTarget.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                DragView dragView = (DragView) dragLayer.getAnimatedView();
                float t = ((Float) animation.getAnimatedValue()).floatValue();
                float tp = scaleAlphaInterpolator.getInterpolation(t);
                float initialScale = dragView.getInitialScale();
                float scale = dragView.getScaleX();
                float x1o = ((1.0f - scale) * dragView.getMeasuredWidth()) / 2.0f;
                float y1o = ((1.0f - scale) * dragView.getMeasuredHeight()) / 2.0f;
                float x = ((1.0f - t) * (1.0f - t) * (x1 - x1o)) + (2.0f * (1.0f - t) * t * (x2 - x1o)) + (t * t * x3);
                float y = ((1.0f - t) * (1.0f - t) * (y1 - y1o)) + (2.0f * (1.0f - t) * t * (y2 - x1o)) + (t * t * y3);
                dragView.setTranslationX(x);
                dragView.setTranslationY(y);
                dragView.setScaleX((1.0f - tp) * initialScale);
                dragView.setScaleY((1.0f - tp) * initialScale);
                dragView.setAlpha(((1.0f - 0.5f) * (1.0f - tp)) + 0.5f);
            }
        };
    }

    private static class FlingAlongVectorAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final TimeInterpolator mAlphaInterpolator = new DecelerateInterpolator(0.75f);
        private DragLayer mDragLayer;
        private float mFriction;
        private Rect mFrom;
        private boolean mHasOffsetForScale;
        private long mPrevTime;
        private PointF mVelocity;

        public FlingAlongVectorAnimatorUpdateListener(DragLayer dragLayer, PointF vel, Rect from, long startTime, float friction) {
            this.mDragLayer = dragLayer;
            this.mVelocity = vel;
            this.mFrom = from;
            this.mPrevTime = startTime;
            this.mFriction = 1.0f - (dragLayer.getResources().getDisplayMetrics().density * friction);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            final DragView dragView = (DragView) mDragLayer.getAnimatedView();
            float t = ((Float) animation.getAnimatedValue()).floatValue();
            long curTime = AnimationUtils.currentAnimationTimeMillis();

            if (!mHasOffsetForScale) {
                mHasOffsetForScale = true;
                float scale = dragView.getScaleX();
                float xOffset = ((scale - 1f) * dragView.getMeasuredWidth()) / 2f;
                float yOffset = ((scale - 1f) * dragView.getMeasuredHeight()) / 2f;

                mFrom.left += xOffset;
                mFrom.top += yOffset;
            }

            mFrom.left += (mVelocity.x * (curTime - mPrevTime) / 1000f);
            mFrom.top += (mVelocity.y * (curTime - mPrevTime) / 1000f);

            dragView.setTranslationX(mFrom.left);
            dragView.setTranslationY(mFrom.top);
            dragView.setAlpha(1f - mAlphaInterpolator.getInterpolation(t));

            mVelocity.x *= mFriction;
            mVelocity.y *= mFriction;
            mPrevTime = curTime;
        }
    };

    private ValueAnimator.AnimatorUpdateListener createFlingAlongVectorAnimatorListener(DragLayer dragLayer, DragObject d, PointF vel, long startTime, int duration, ViewConfiguration config) {
        Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        return new FlingAlongVectorAnimatorUpdateListener(dragLayer, vel, from, startTime, FLING_TO_DELETE_FRICTION);
    }

    @Override // com.android.launcher66.ButtonDropTarget, com.android.launcher66.DropTarget
    public void onFlingToDelete(final DragObject d, int x, int y, PointF vel) {
        final boolean isAllApps = d.dragSource instanceof AppsCustomizePagedView;
        d.dragView.setColor(0);
        d.dragView.updateInitialScaleToCurrentScale();
        if (isAllApps) {
            resetHoverColor();
        }
        if (this.mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            this.mSearchDropTargetBar.deferOnDragEnd();
            this.mSearchDropTargetBar.finishAnimations();
        }
        ViewConfiguration config = ViewConfiguration.get(this.mLauncher);
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        final int duration = FLING_DELETE_ANIMATION_DURATION;
        final long startTime = AnimationUtils.currentAnimationTimeMillis();
        TimeInterpolator tInterpolator = new TimeInterpolator() { // from class: com.android.launcher66.DeleteDropTarget.6
            private int mCount = -1;
            private float mOffset = 0.0f;

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float t) {
                if (this.mCount < 0) {
                    this.mCount++;
                } else if (this.mCount == 0) {
                    this.mOffset = Math.min(0.5f, ((float) (AnimationUtils.currentAnimationTimeMillis() - startTime)) / duration);
                    this.mCount++;
                }
                return Math.min(1.0f, this.mOffset + t);
            }
        };
        ValueAnimator.AnimatorUpdateListener updateCb = null;
        if (this.mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            updateCb = createFlingToTrashAnimatorListener(dragLayer, d, vel, config);
        } else if (this.mFlingDeleteMode == MODE_FLING_DELETE_ALONG_VECTOR) {
            updateCb = createFlingAlongVectorAnimatorListener(dragLayer, d, vel, startTime, duration, config);
        }
        deferCompleteDropIfUninstalling(d);
        Runnable onAnimationEndRunnable = new Runnable() { // from class: com.android.launcher66.DeleteDropTarget.7
            @Override // java.lang.Runnable
            public void run() {
                if (!isAllApps) {
                    DeleteDropTarget.this.mLauncher.exitSpringLoadedDragMode();
                    DeleteDropTarget.this.completeDrop(d);
                }
                DeleteDropTarget.this.mLauncher.getDragController().onDeferredEndFling(d);
            }
        };
        dragLayer.animateView(d.dragView, updateCb, duration, tInterpolator, onAnimationEndRunnable, 0, null);
    }
}
