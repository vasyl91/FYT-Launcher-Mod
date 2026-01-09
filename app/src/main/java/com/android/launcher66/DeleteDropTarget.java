package com.android.launcher66;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import android.widget.ImageView;
import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.Set;

public class DeleteDropTarget extends ButtonDropTarget {
    private static final int DELETE_ANIMATION_DURATION = 285;
    private static final int FLING_DELETE_ANIMATION_DURATION = 350;
    private static final float FLING_TO_DELETE_FRICTION = 0.035f;
    private static final int MODE_FLING_DELETE_TO_TRASH = 0;
    private static final int MODE_FLING_DELETE_ALONG_VECTOR = 1;

    private final int mFlingDeleteMode = MODE_FLING_DELETE_ALONG_VECTOR;

    private ColorStateList mOriginalTextColor;
    private TransitionDrawable mUninstallDrawable;
    private TransitionDrawable mRemoveDrawable;
    private TransitionDrawable mCurrentDrawable;

    private boolean mWaitingForUninstall = false;

    // Overlay related
    private WindowManager mWindowManager;
    // Keep a strong reference while the overlay is active, but ALWAYS clear it on removal.
    private ImageView mOverlayView;
    private WindowManager.LayoutParams mOverlayParams;
    private boolean mOverlayAdded = false;

    // Transparent placeholder drawable instance used inside the view for hit testing.
    private PlaceholderDrawable mPlaceholderDrawable;

    // Resource ids (used to create separate placeholder instances)
    private final int mUninstallResId = R.drawable.uninstall_target_selector;
    private final int mRemoveResId = R.drawable.remove_target_selector;

    public DeleteDropTarget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DeleteDropTarget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mOriginalTextColor = getTextColors();
        mHoverColor = ContextCompat.getColor(getContext(), R.color.delete_target_hover_tint);

        Drawable uninstall = ContextCompat.getDrawable(getContext(), mUninstallResId);
        Drawable remove = ContextCompat.getDrawable(getContext(), mRemoveResId);

        if (uninstall instanceof TransitionDrawable) {
            mUninstallDrawable = (TransitionDrawable) uninstall;
            mUninstallDrawable.setCrossFadeEnabled(true);
        } else if (uninstall != null && uninstall.getConstantState() != null) {
            // fallback wrap
            Drawable d = uninstall.getConstantState().newDrawable(getContext().getResources()).mutate();
            mUninstallDrawable = new TransitionDrawable(new Drawable[]{d, d});
        }

        if (remove instanceof TransitionDrawable) {
            mRemoveDrawable = (TransitionDrawable) remove;
            mRemoveDrawable.setCrossFadeEnabled(true);
        } else if (remove != null && remove.getConstantState() != null) {
            Drawable d = remove.getConstantState().newDrawable(getContext().getResources()).mutate();
            mRemoveDrawable = new TransitionDrawable(new Drawable[]{d, d});
        }

        // Choose default current drawable similar to original behavior
        mCurrentDrawable = mRemoveDrawable != null ? mRemoveDrawable : mUninstallDrawable;

        mWindowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

        // Remove the text in the Phone UI in landscape (same behavior as original)
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!LauncherAppState.getInstance().isScreenLarge()) {
                setText("");
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        // ensure overlay is fully removed and dereferenced when the view is detached
        removeOverlay();
        super.onDetachedFromWindow();
    }

    private boolean isAllAppsApplication(DragSource source, Object info) {
        return (source instanceof AppsCustomizePagedView) && (info instanceof AppInfo);
    }
    private boolean isAllAppsWidget(DragSource source, Object info) {
        if (source instanceof AppsCustomizePagedView) {
            if (info instanceof PendingAddItemInfo) {
                PendingAddItemInfo addInfo = (PendingAddItemInfo) info;
                switch (addInfo.itemType) {
                    case LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT:
                    case LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET:
                        return true;
                }
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
        if (mCurrentDrawable != null) {
            mCurrentDrawable.startTransition(mTransitionDuration);
            // Guarded overlay access
            if (mOverlayView != null) mOverlayView.invalidate();
        }
        setTextColor(mHoverColor);
    }
    private void resetHoverColor() {
        if (mCurrentDrawable != null) {
            mCurrentDrawable.resetTransition();
            if (mOverlayView != null) mOverlayView.invalidate();
        }
        setTextColor(mOriginalTextColor);
    }

    @Override
    public boolean acceptDrop(DragObject d) {
        return willAcceptDrop(d.dragInfo);
    }

    public static boolean willAcceptDrop(Object info) {
        if (info instanceof ItemInfo) {
            ItemInfo item = (ItemInfo) info;
            if (item.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET ||
                    item.itemType == LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT) {
                return true;
            }

            if (!AppsCustomizePagedView.DISABLE_ALL_APPS &&
                    item.itemType == LauncherSettings.Favorites.ITEM_TYPE_FOLDER) {
                return true;
            }

            if (!AppsCustomizePagedView.DISABLE_ALL_APPS &&
                    item.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION &&
                    item instanceof AppInfo) {
                AppInfo appInfo = (AppInfo) info;
                return (appInfo.flags & AppInfo.DOWNLOADED_FLAG) != 0;
            }

            if (item.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION &&
                item instanceof ShortcutInfo) {
                if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
                    ShortcutInfo shortcutInfo = (ShortcutInfo) info;
                    return (shortcutInfo.flags & AppInfo.DOWNLOADED_FLAG) != 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Create and set a transparent placeholder drawable (from the same resource) so that:
     * - the view keeps the same intrinsic size for layout/hit-testing
     * - the placeholder does not draw (transparent)
     * The overlay is used to draw the visible TransitionDrawable.
     */
    private void setPlaceholderForResource(int resId) {
        Drawable src = ContextCompat.getDrawable(getContext(), resId);
        if (src == null) {
            // fallback: clear
            mPlaceholderDrawable = null;
            setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
            return;
        }

        Drawable delegate;
        if (src.getConstantState() != null) {
            delegate = src.getConstantState().newDrawable(getContext().getResources()).mutate();
        } else {
            // if no constant state, try to use the original (safe fallback)
            delegate = src.mutate();
        }

        // Wrap the delegate with a placeholder that is transparent but reports size.
        mPlaceholderDrawable = new PlaceholderDrawable(delegate);
        // Set as compound drawable so the view retains the hit area / layout footprint.
        setCompoundDrawablesRelativeWithIntrinsicBounds(mPlaceholderDrawable, null, null, null);
        // Ensure delegate receives the correct callback and bounds immediately.
        mPlaceholderDrawable.ensureDelegateCallbackAndBounds();
    }

    @Override
    public void onDragStart(DragSource source, Object info, int dragAction) {
        boolean isVisible = true;
        boolean useUninstallLabel = !AppsCustomizePagedView.DISABLE_ALL_APPS &&
                isAllAppsApplication(source, info);

        // If we are dragging an application from AppsCustomize, only show control if we can
        // delete the app (it was downloaded), and rename to "uninstall" in such case.
        // Hide the delete target if it is a widget from AppsCustomize.
        if (!willAcceptDrop(info) || isAllAppsWidget(source, info)) {
            isVisible = false;
        }
        Log.i("DeleteDropTarget", String.valueOf(isVisible));

        // Choose the visual drawable for the overlay.
        TransitionDrawable visual = useUninstallLabel ? mUninstallDrawable : mRemoveDrawable;
        if (visual == null) {
            visual = mCurrentDrawable; // fallback
        }
        mCurrentDrawable = visual;

        // Create and set transparent placeholder (separate instance) for hit-testing/layout
        int placeholderRes = useUninstallLabel ? mUninstallResId : mRemoveResId;
        setPlaceholderForResource(placeholderRes);

        // Show overlay that actually draws the selector above other windows.
        showOverlayDrawable(mCurrentDrawable);

        mActive = isVisible;
        resetHoverColor(); // overlay will reflect current transition state

        // Maintain parent visibility & text label behavior
        ((ViewGroup) getParent()).setVisibility(isVisible ? VISIBLE : GONE);
        if (getText().length() > 0) {
            setText(useUninstallLabel ? R.string.delete_target_uninstall_label
                : R.string.delete_target_label);
        }
    }

    @Override
    public void onDragEnd() {
        super.onDragEnd();
        mActive = false;

        // remove overlay drawable
        removeOverlay();

        // clear placeholder
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        mPlaceholderDrawable = null;
    }

    public void onDragEnter(DragObject d) {
        super.onDragEnter(d);
        setHoverColor();
    }

    public void onDragExit(DragObject d) {
        super.onDragExit(d);
        if (!d.dragComplete) {
            resetHoverColor();
        } else {
            d.dragView.setColor(mHoverColor);
        }
    }

    private void animateToTrashAndCompleteDrop(final DragObject d) {
        final DragLayer dragLayer = mLauncher.getDragLayer();
        final Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);
        final Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(),
                mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicWidth() : 0,
                mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicHeight() : 0);
        final float scale = (float) to.width() / from.width();

        mSearchDropTargetBar.deferOnDragEnd();
        deferCompleteDropIfUninstalling(d);

        Runnable onAnimationEndRunnable = new Runnable() {
            @Override
            public void run() {
                completeDrop(d);
                mSearchDropTargetBar.onDragEnd();
                mLauncher.exitSpringLoadedDragMode();
            }
        };
        dragLayer.animateView(d.dragView, from, to, scale, 1f, 1f, 0.1f, 0.1f,
                DELETE_ANIMATION_DURATION, new DecelerateInterpolator(2),
                new LinearInterpolator(), onAnimationEndRunnable,
                DragLayer.ANIMATION_END_DISAPPEAR, null);
    }

    private void deferCompleteDropIfUninstalling(DragObject d) {
        mWaitingForUninstall = false;
        if (isUninstallFromWorkspace(d)) {
            if (d.dragSource instanceof Folder) {
                ((Folder) d.dragSource).deferCompleteDropAfterUninstallActivity();
            } else if (d.dragSource instanceof Workspace) {
                ((Workspace) d.dragSource).deferCompleteDropAfterUninstallActivity();
            }
            mWaitingForUninstall = true;
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
        // remove overlay and placeholder here as well to ensure immediate cleanup
        removeOverlay();
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        mPlaceholderDrawable = null;
    }

    /**
     * Creates an animation from the current drag view to the delete trash icon.
     */
    private AnimatorUpdateListener createFlingToTrashAnimatorListener(final DragLayer dragLayer,
            DragObject d, PointF vel, ViewConfiguration config) {
        final Rect to = getIconRect(d.dragView.getMeasuredWidth(), d.dragView.getMeasuredHeight(),
                mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicWidth() : 0,
                mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicHeight() : 0);
        final Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);

        // Calculate how far along the velocity vector we should put the intermediate point on
        // the bezier curve
        float velocity = Math.abs(vel.length());
        float vp = Math.min(1f, velocity / (config.getScaledMaximumFlingVelocity() / 2f));
        int offsetY = (int) (-from.top * vp);
        int offsetX = 0;
        if (vel.x != 0) {
            offsetX = (int) (offsetY / (vel.y / vel.x));
        }
        final float y2 = from.top + offsetY;                        // intermediate t/l
        final float x2 = from.left + offsetX;
        final float x1 = from.left;                                 // drag view t/l
        final float y1 = from.top;
        final float x3 = to.left;                                   // delete target t/l
        final float y3 = to.top;

        final TimeInterpolator scaleAlphaInterpolator = new TimeInterpolator() {
            @Override
            public float getInterpolation(float t) {
                return t * t * t * t * t * t * t * t;
            }
        };
        return new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final DragView dragView = (DragView) dragLayer.getAnimatedView();
                float t = ((Float) animation.getAnimatedValue()).floatValue();
                float tp = scaleAlphaInterpolator.getInterpolation(t);
                float initialScale = dragView.getInitialScale();
                float finalAlpha = 0.5f;
                float scale = dragView.getScaleX();
                float x1o = ((1f - scale) * dragView.getMeasuredWidth()) / 2f;
                float y1o = ((1f - scale) * dragView.getMeasuredHeight()) / 2f;
                float x = (1f - t) * (1f - t) * (x1 - x1o) + 2 * (1f - t) * t * (x2 - x1o) +
                        (t * t) * x3;
                float y = (1f - t) * (1f - t) * (y1 - y1o) + 2 * (1f - t) * t * (y2 - x1o) +
                        (t * t) * y3;

                dragView.setTranslationX(x);
                dragView.setTranslationY(y);
                dragView.setScaleX(initialScale * (1f - tp));
                dragView.setScaleY(initialScale * (1f - tp));
                dragView.setAlpha(finalAlpha + (1f - finalAlpha) * (1f - tp));
            }
        };
    }

    private static class FlingAlongVectorAnimatorUpdateListener implements AnimatorUpdateListener {
        private DragLayer mDragLayer;
        private PointF mVelocity;
        private Rect mFrom;
        private long mPrevTime;
        private boolean mHasOffsetForScale;
        private float mFriction;

        private final TimeInterpolator mAlphaInterpolator = new DecelerateInterpolator(0.75f);

        public FlingAlongVectorAnimatorUpdateListener(DragLayer dragLayer, PointF vel, Rect from,
                long startTime, float friction) {
            mDragLayer = dragLayer;
            mVelocity = vel;
            mFrom = from;
            mPrevTime = startTime;
            mFriction = 1f - (dragLayer.getResources().getDisplayMetrics().density * friction);
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
    private AnimatorUpdateListener createFlingAlongVectorAnimatorListener(final DragLayer dragLayer,
            DragObject d, PointF vel, final long startTime, final int duration,
            ViewConfiguration config) {
        final Rect from = new Rect();
        dragLayer.getViewRectRelativeToSelf(d.dragView, from);

        return new FlingAlongVectorAnimatorUpdateListener(dragLayer, vel, from, startTime,
                FLING_TO_DELETE_FRICTION);
    }

    public void onFlingToDelete(final DragObject d, int x, int y, PointF vel) {
        final boolean isAllApps = d.dragSource instanceof AppsCustomizePagedView;

        d.dragView.setColor(0);
        d.dragView.updateInitialScaleToCurrentScale();
        if (isAllApps) {
            resetHoverColor();
        }

        if (mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            mSearchDropTargetBar.deferOnDragEnd();
            mSearchDropTargetBar.finishAnimations();
        }

        final ViewConfiguration config = ViewConfiguration.get(mLauncher);
        final DragLayer dragLayer = mLauncher.getDragLayer();
        final int duration = FLING_DELETE_ANIMATION_DURATION;
        final long startTime = AnimationUtils.currentAnimationTimeMillis();

        final TimeInterpolator tInterpolator = new TimeInterpolator() {
            private int mCount = -1;
            private float mOffset = 0f;

            @Override
            public float getInterpolation(float t) {
                if (mCount < 0) {
                    mCount++;
                } else if (mCount == 0) {
                    mOffset = Math.min(0.5f, (float) (AnimationUtils.currentAnimationTimeMillis() -
                            startTime) / duration);
                    mCount++;
                }
                return Math.min(1f, mOffset + t);
            }
        };
        AnimatorUpdateListener updateCb = null;
        if (mFlingDeleteMode == MODE_FLING_DELETE_TO_TRASH) {
            updateCb = createFlingToTrashAnimatorListener(dragLayer, d, vel, config);
        } else if (mFlingDeleteMode == MODE_FLING_DELETE_ALONG_VECTOR) {
            updateCb = createFlingAlongVectorAnimatorListener(dragLayer, d, vel, startTime,
                    duration, config);
        }
        deferCompleteDropIfUninstalling(d);

        Runnable onAnimationEndRunnable = new Runnable() {
            @Override
            public void run() {
                if (!isAllApps) {
                    mLauncher.exitSpringLoadedDragMode();
                    completeDrop(d);
                }
                mLauncher.getDragController().onDeferredEndFling(d);
            }
        };
        dragLayer.animateView(d.dragView, updateCb, duration, tInterpolator, onAnimationEndRunnable,
                DragLayer.ANIMATION_END_DISAPPEAR, null);
    }

    private void showOverlayDrawable(TransitionDrawable drawable) {
        if (drawable == null) return;

        mCurrentDrawable = drawable;

        if (mOverlayView == null) {
            mOverlayView = new ImageView(getContext());
            mOverlayView.setScaleType(ImageView.ScaleType.CENTER);
            mOverlayView.setImageDrawable(mCurrentDrawable);

            int windowType = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                    | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;

            mOverlayParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    windowType,
                    flags,
                    PixelFormat.TRANSLUCENT);
            mOverlayParams.gravity = Gravity.TOP | Gravity.START;
        } else {
            mOverlayView.setImageDrawable(mCurrentDrawable);
        }

        updateOverlayPosition();

        if (!mOverlayAdded) {
            try {
                mWindowManager.addView(mOverlayView, mOverlayParams);
                mOverlayAdded = true;
            } catch (Exception e) {
                Log.w("DeleteDropTarget", "Failed to add overlay view: " + e);
                // If adding failed, ensure we don't keep a dangling reference to the ImageView/params
                // which could be detached or otherwise problematic.
                if (mOverlayView != null) {
                    try {
                        mOverlayView.setImageDrawable(null);
                    } catch (Exception ignore) {}
                    mOverlayView = null;
                }
                mOverlayParams = null;
                mOverlayAdded = false;
            }
        } else {
            try {
                mWindowManager.updateViewLayout(mOverlayView, mOverlayParams);
            } catch (Exception e) {
                Log.w("DeleteDropTarget", "Failed to update overlay layout: " + e);
            }
        }
    }

    /**
     * Safely remove overlay and release references to avoid leaks.
     */
    private void removeOverlay() {
        // If overlay was added to WindowManager, remove it.
        if (mOverlayView != null && mOverlayAdded) {
            try {
                mWindowManager.removeViewImmediate(mOverlayView);
            } catch (Exception e) {
                Log.w("DeleteDropTarget", "Failed to remove overlay view: " + e);
            } finally {
                mOverlayAdded = false;
            }
        }

        // Clear drawable and dereference the view & params so it can be GC'd.
        if (mOverlayView != null) {
            try {
                mOverlayView.setImageDrawable(null);
            } catch (Exception ignore) {}
            mOverlayView = null;
        }
        mOverlayParams = null;
    }

    private void updateOverlayPosition() {
        if (mOverlayParams == null || mOverlayView == null) return;

        int[] loc = new int[2];
        this.getLocationOnScreen(loc);
        int viewLeft = loc[0];
        int viewTop = loc[1];

        int drawableWidth = mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicWidth() : mOverlayView.getMeasuredWidth();
        int drawableHeight = mCurrentDrawable != null ? mCurrentDrawable.getIntrinsicHeight() : mOverlayView.getMeasuredHeight();

        int x = viewLeft + (getWidth() - drawableWidth) / 2;
        int y = viewTop + (drawableHeight / 2);

        mOverlayParams.x = x;
        mOverlayParams.y = y;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mOverlayAdded && mOverlayView != null) {
            updateOverlayPosition();
            try {
                mWindowManager.updateViewLayout(mOverlayView, mOverlayParams);
            } catch (Exception e) {
                Log.w("DeleteDropTarget", "Failed to update overlay during layout: " + e);
            }
        }

        // Also ensure placeholder delegate has up-to-date bounds & callback
        if (mPlaceholderDrawable != null) {
            mPlaceholderDrawable.ensureDelegateCallbackAndBounds();
        }
    }

    /**
     * Transparent placeholder that reports the intrinsic size/bounds of its delegate
     * but does not draw anything. We forward the view callback & bounds to the delegate
     * from setBounds() / ensureDelegateCallbackAndBounds().
     */
    private static class PlaceholderDrawable extends Drawable {
        private final Drawable mDelegate;

        PlaceholderDrawable(Drawable delegate) {
            mDelegate = delegate;
        }

        @Override
        public void draw(Canvas canvas) {
            // intentionally blank (transparent)
            // ensure delegate gets callback (in case callback was set after construction)
            ensureDelegateCallbackAndBounds();
        }

        @Override
        public void setAlpha(int alpha) {
            if (mDelegate != null) mDelegate.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            if (mDelegate != null) mDelegate.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }

        @Override
        public int getIntrinsicWidth() {
            return mDelegate != null ? mDelegate.getIntrinsicWidth() : -1;
        }

        @Override
        public int getIntrinsicHeight() {
            return mDelegate != null ? mDelegate.getIntrinsicHeight() : -1;
        }

        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            super.setBounds(left, top, right, bottom);
            if (mDelegate != null) {
                mDelegate.setBounds(left, top, right, bottom);
                // Forward the callback to the delegate (getCallback() is final on Drawable)
                if (getCallback() != null) {
                    mDelegate.setCallback(getCallback());
                }
            }
        }

        /**
         * Ensure delegate has the same callback and bounds as this placeholder.
         * Call this after setCompoundDrawables... to immediately synchronize.
         */
        void ensureDelegateCallbackAndBounds() {
            if (mDelegate == null) return;
            if (getCallback() != null) {
                mDelegate.setCallback(getCallback());
            }
            // forward current bounds
            Rect b = getBounds();
            mDelegate.setBounds(b.left, b.top, b.right, b.bottom);
        }
    }
}