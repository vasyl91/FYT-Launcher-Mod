package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.launcher66.CellLayout;
import com.syu.log.LogPreview;
import java.util.ArrayList;
import java.util.Iterator;

public class DragLayer extends FrameLayout implements ViewGroup.OnHierarchyChangeListener {
    public static final int ANIMATION_END_DISAPPEAR = 0;
    public static final int ANIMATION_END_FADE_OUT = 1;
    public static final int ANIMATION_END_REMAIN_VISIBLE = 2;
    private View mAnchorView;
    private int mAnchorViewInitialScrollX;
    private TimeInterpolator mCubicEaseOutInterpolator;
    private AppWidgetResizeFrame mCurrentResizeFrame;
    private DragController mDragController;
    private ValueAnimator mDropAnim;
    private DragView mDropView;
    private ValueAnimator mFadeOutAnim;
    private Rect mHitRect;
    private boolean mHoverPointClosesFolder;
    private boolean mInScrollArea;
    private final Rect mInsets;
    private Launcher mLauncher;
    private Drawable mLeftHoverDrawable;
    private int mQsbIndex;
    private final ArrayList<AppWidgetResizeFrame> mResizeFrames;
    private Drawable mRightHoverDrawable;
    private int[] mTmpXY;
    private TouchCompleteListener mTouchCompleteListener;
    private int mWorkspaceIndex;
    private int mXDown;
    private int mYDown;

    public interface TouchCompleteListener {
        void onTouchComplete();
    }

    public DragLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTmpXY = new int[2];
        this.mResizeFrames = new ArrayList<>();
        this.mDropAnim = null;
        this.mFadeOutAnim = null;
        this.mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5f);
        this.mDropView = null;
        this.mAnchorViewInitialScrollX = 0;
        this.mAnchorView = null;
        this.mHoverPointClosesFolder = false;
        this.mHitRect = new Rect();
        this.mWorkspaceIndex = -1;
        this.mQsbIndex = -1;
        this.mInsets = new Rect();
        setMotionEventSplittingEnabled(false);
        setChildrenDrawingOrderEnabled(true);
        setOnHierarchyChangeListener(this);
        this.mLeftHoverDrawable = getResources().getDrawable(R.drawable.page_hover_left_holo);
        this.mRightHoverDrawable = getResources().getDrawable(R.drawable.page_hover_right_holo);
    }

    public void setup(Launcher launcher, DragController controller) {
        this.mLauncher = launcher;
        this.mDragController = controller;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return this.mDragController.dispatchKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        final int n = getChildCount();
        for (int i = 0; i < n; i++) {
            final View child = getChildAt(i);
            final FrameLayout.LayoutParams flp = (FrameLayout.LayoutParams) child.getLayoutParams();
            if (child instanceof Insettable) {
                ((Insettable)child).setInsets(insets);
            } else {
                flp.topMargin += (insets.top - mInsets.top);
                flp.leftMargin += (insets.left - mInsets.left);
                flp.rightMargin += (insets.right - mInsets.right);
                flp.bottomMargin += (insets.bottom - mInsets.bottom);
            }
            child.setLayoutParams(flp);
        }
        mInsets.set(insets);
        return true; 
    }

    private boolean isEventOverFolderTextRegion(Folder folder, MotionEvent ev) {
        getDescendantRectRelativeToSelf(folder.getEditTextRegion(), this.mHitRect);
        return this.mHitRect.contains((int) ev.getX(), (int) ev.getY());
    }

    private boolean isEventOverFolder(Folder folder, MotionEvent ev) {
        getDescendantRectRelativeToSelf(folder, this.mHitRect);
        return this.mHitRect.contains((int) ev.getX(), (int) ev.getY());
    }

    private boolean handleTouchDown(MotionEvent ev, boolean intercept) {
        Rect hitRect = new Rect();
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        Iterator<AppWidgetResizeFrame> it = this.mResizeFrames.iterator();
        while (it.hasNext()) {
            AppWidgetResizeFrame child = it.next();
            child.getHitRect(hitRect);
            if (hitRect.contains(x, y) && child.beginResizeIfPointInRegion(x - child.getLeft(), y - child.getTop())) {
                this.mCurrentResizeFrame = child;
                this.mXDown = x;
                this.mYDown = y;
                requestDisallowInterceptTouchEvent(true);
                return true;
            }
        }
        Folder currentFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (currentFolder != null && !this.mLauncher.isFolderClingVisible() && intercept) {
            if (currentFolder.isEditingName() && !isEventOverFolderTextRegion(currentFolder, ev)) {
                currentFolder.dismissEditingName();
                return true;
            }
            getDescendantRectRelativeToSelf(currentFolder, hitRect);
            if (!isEventOverFolder(currentFolder, ev)) {
                this.mLauncher.closeFolder();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0) {
            if (handleTouchDown(ev, true)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            if (this.mTouchCompleteListener != null) {
                this.mTouchCompleteListener.onTouchComplete();
            }
            this.mTouchCompleteListener = null;
        }
        clearAllResizeFrames();
        return this.mDragController.onInterceptTouchEvent(ev);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent ev) {
        Folder currentFolder;
        LogPreview.show("onInterceptHoverEvent");
        if (this.mLauncher == null || this.mLauncher.getWorkspace() == null || (currentFolder = this.mLauncher.getWorkspace().getOpenFolder()) == null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (!accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = ev.getAction();
        switch (action) {
            case 7:
                break;
            case 8:
            default:
                return false;
            case 9:
                boolean isOverFolder = isEventOverFolder(currentFolder, ev);
                if (!isOverFolder) {
                    sendTapOutsideFolderAccessibilityEvent(currentFolder.isEditingName());
                    this.mHoverPointClosesFolder = true;
                    return true;
                }
                if (!isOverFolder) {
                    return true;
                }
                this.mHoverPointClosesFolder = false;
                break;
        }
        boolean isOverFolder2 = isEventOverFolder(currentFolder, ev);
        if (!isOverFolder2 && !this.mHoverPointClosesFolder) {
            sendTapOutsideFolderAccessibilityEvent(currentFolder.isEditingName());
            this.mHoverPointClosesFolder = true;
            return true;
        }
        if (!isOverFolder2) {
            return true;
        }
        this.mHoverPointClosesFolder = false;
        return false;
    }

    private void sendTapOutsideFolderAccessibilityEvent(boolean isEditingName) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            int stringId = isEditingName ? R.string.folder_tap_to_rename : R.string.folder_tap_to_close;
            AccessibilityEvent event = AccessibilityEvent.obtain(8);
            onInitializeAccessibilityEvent(event);
            event.getText().add(getContext().getString(stringId));
            accessibilityManager.sendAccessibilityEvent(event);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Folder currentFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (currentFolder != null) {
            if (child == currentFolder) {
                return super.onRequestSendAccessibilityEvent(child, event);
            }
            return false;
        }
        return super.onRequestSendAccessibilityEvent(child, event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> childrenForAccessibility) {
        Folder currentFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (currentFolder != null) {
            childrenForAccessibility.add(currentFolder);
        } else {
            super.addChildrenForAccessibility(childrenForAccessibility);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        boolean handled = false;
        int action = ev.getAction();
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        if (action == 0) {
            if (handleTouchDown(ev, false)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            if (this.mTouchCompleteListener != null) {
                this.mTouchCompleteListener.onTouchComplete();
            }
            this.mTouchCompleteListener = null;
        }
        if (this.mCurrentResizeFrame != null) {
            handled = true;
            switch (action) {
                case 1:
                case 3:
                    this.mCurrentResizeFrame.visualizeResizeForDelta(x - this.mXDown, y - this.mYDown);
                    this.mCurrentResizeFrame.onTouchUp();
                    this.mCurrentResizeFrame = null;
                    break;
                case 2:
                    LogPreview.show("MotionEvent.ACTION_MOVE");
                    this.mCurrentResizeFrame.visualizeResizeForDelta(x - this.mXDown, y - this.mYDown);
                    break;
            }
        }
        if (handled) {
            return true;
        }
        return this.mDragController.onTouchEvent(ev);
    }

    public float getDescendantRectRelativeToSelf(View descendant, Rect r) {
        this.mTmpXY[0] = 0;
        this.mTmpXY[1] = 0;
        float scale = getDescendantCoordRelativeToSelf(descendant, this.mTmpXY);
        r.set(this.mTmpXY[0], this.mTmpXY[1], (int) (this.mTmpXY[0] + (descendant.getMeasuredWidth() * scale)), (int) (this.mTmpXY[1] + (descendant.getMeasuredHeight() * scale)));
        return scale;
    }

    public float getLocationInDragLayer(View child, int[] loc) {
        loc[0] = 0;
        loc[1] = 0;
        return getDescendantCoordRelativeToSelf(child, loc);
    }

    public float getDescendantCoordRelativeToSelf(View descendant, int[] coord) {
        return getDescendantCoordRelativeToSelf(descendant, coord, false);
    }

    public float getDescendantCoordRelativeToSelf(View descendant, int[] coord, boolean includeRootScroll) {
        return Utilities.getDescendantCoordRelativeToParent(descendant, this, coord, includeRootScroll);
    }

    public float mapCoordInSelfToDescendent(View descendant, int[] coord) {
        return Utilities.mapCoordInSelfToDescendent(descendant, this, coord);
    }

    public void getViewRectRelativeToSelf(View v, Rect r) {
        int[] loc = new int[2];
        getLocationInWindow(loc);
        int x = loc[0];
        int y = loc[1];
        v.getLocationInWindow(loc);
        int vX = loc[0];
        int vY = loc[1];
        int left = vX - x;
        int top = vY - y;
        r.set(left, top, v.getMeasuredWidth() + left, v.getMeasuredHeight() + top);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View focused, int direction) {
        return this.mDragController.dispatchUnhandledMove(focused, direction);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean customPosition;
        public int x;
        public int y;

        public LayoutParams(int width, int height) {
            super(width, height);
            this.customPosition = false;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return this.height;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return this.x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return this.y;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            FrameLayout.LayoutParams flp = (FrameLayout.LayoutParams) child.getLayoutParams();
            if (flp instanceof LayoutParams) {
                LayoutParams lp = (LayoutParams) flp;
                if (lp.customPosition) {
                    child.layout(lp.x, lp.y, lp.x + lp.width, lp.y + lp.height);
                }
            }
        }
    }

    public void clearAllResizeFrames() {
        if (this.mResizeFrames.size() > 0) {
            Iterator<AppWidgetResizeFrame> it = this.mResizeFrames.iterator();
            while (it.hasNext()) {
                AppWidgetResizeFrame frame = it.next();
                frame.commitResize();
                removeView(frame);
            }
            this.mResizeFrames.clear();
        }
    }

    public boolean hasResizeFrames() {
        return this.mResizeFrames.size() > 0;
    }

    public boolean isWidgetBeingResized() {
        return this.mCurrentResizeFrame != null;
    }

    public void addResizeFrame(ItemInfo itemInfo, LauncherAppWidgetHostView widget, CellLayout cellLayout) {
        AppWidgetResizeFrame resizeFrame = new AppWidgetResizeFrame(getContext(), widget, cellLayout, this);
        LayoutParams lp = new LayoutParams(-1, -1);
        lp.customPosition = true;
        addView(resizeFrame, lp);
        this.mResizeFrames.add(resizeFrame);
        resizeFrame.snapToWidget(false);
    }

    public void animateViewIntoPosition(DragView dragView, View child) {
        animateViewIntoPosition(dragView, child, null);
    }

    public void animateViewIntoPosition(DragView dragView, int[] pos, float alpha, float scaleX, float scaleY, int animationEndStyle, Runnable onFinishRunnable, int duration) {
        Rect r = new Rect();
        getViewRectRelativeToSelf(dragView, r);
        int fromX = r.left;
        int fromY = r.top;
        animateViewIntoPosition(dragView, fromX, fromY, pos[0], pos[1], alpha, 1.0f, 1.0f, scaleX, scaleY, onFinishRunnable, animationEndStyle, duration, null);
    }

    public void animateViewIntoPosition(DragView dragView, View child, Runnable onFinishAnimationRunnable) {
        animateViewIntoPosition(dragView, child, -1, onFinishAnimationRunnable, null);
    }

    public void animateViewIntoPosition(DragView dragView, final View child, int duration, final Runnable onFinishAnimationRunnable, View anchorView) {
        int toY;
        int toX;
        ShortcutAndWidgetContainer parentChildren = (ShortcutAndWidgetContainer) child.getParent();
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();
        parentChildren.measureChild(child);
        Rect r = new Rect();
        getViewRectRelativeToSelf(dragView, r);
        float childScale = child.getScaleX();
        int[] coord = {lp.x + ((int) ((child.getMeasuredWidth() * (1.0f - childScale)) / 2.0f)), lp.y + ((int) ((child.getMeasuredHeight() * (1.0f - childScale)) / 2.0f))};
        float scale = getDescendantCoordRelativeToSelf((View) child.getParent(), coord) * childScale;
        int toX2 = coord[0];
        int toY2 = coord[1];
        if (child instanceof TextView) {
            TextView tv = (TextView) child;
            toY = (int) ((toY2 + Math.round(tv.getPaddingTop() * scale)) - ((dragView.getMeasuredHeight() * (1.0f - scale)) / 2.0f));
            toX = toX2 - ((dragView.getMeasuredWidth() - Math.round(child.getMeasuredWidth() * scale)) / 2);
        } else if (child instanceof FolderIcon) {
            toY = (int) (((int) ((toY2 + Math.round((child.getPaddingTop() - dragView.getDragRegionTop()) * scale)) - ((2.0f * scale) / 2.0f))) - (((1.0f - scale) * dragView.getMeasuredHeight()) / 2.0f));
            toX = toX2 - ((dragView.getMeasuredWidth() - Math.round(child.getMeasuredWidth() * scale)) / 2);
        } else {
            toY = toY2 - (Math.round((dragView.getHeight() - child.getMeasuredHeight()) * scale) / 2);
            toX = toX2 - (Math.round((dragView.getMeasuredWidth() - child.getMeasuredWidth()) * scale) / 2);
        }
        int fromX = r.left;
        int fromY = r.top;
        child.setVisibility(View.INVISIBLE);
        Runnable onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.DragLayer.1
            @Override // java.lang.Runnable
            public void run() {
                child.setVisibility(View.VISIBLE);
                if (onFinishAnimationRunnable != null) {
                    onFinishAnimationRunnable.run();
                }
            }
        };
        animateViewIntoPosition(dragView, fromX, fromY, toX, toY, 1.0f, 1.0f, 1.0f, scale, scale, onCompleteRunnable, 0, duration, anchorView);
    }

    public void animateViewIntoPosition(DragView view, int fromX, int fromY, int toX, int toY, float finalAlpha, float initScaleX, float initScaleY, float finalScaleX, float finalScaleY, Runnable onCompleteRunnable, int animationEndStyle, int duration, View anchorView) {
        Rect from = new Rect(fromX, fromY, view.getMeasuredWidth() + fromX, view.getMeasuredHeight() + fromY);
        Rect to = new Rect(toX, toY, view.getMeasuredWidth() + toX, view.getMeasuredHeight() + toY);
        animateView(view, from, to, finalAlpha, initScaleX, initScaleY, finalScaleX, finalScaleY, duration, null, null, onCompleteRunnable, animationEndStyle, anchorView);
    }

    public void animateView(final DragView view, final Rect from, final Rect to, final float finalAlpha, final float initScaleX, final float initScaleY, final float finalScaleX, final float finalScaleY, int duration, final Interpolator motionInterpolator, final Interpolator alphaInterpolator, Runnable onCompleteRunnable, int animationEndStyle, View anchorView) {
        float dist = (float) Math.sqrt(Math.pow(to.left - from.left, 2.0d) + Math.pow(to.top - from.top, 2.0d));
        Resources res = getResources();
        float maxDist = res.getInteger(R.integer.config_dropAnimMaxDist);
        if (duration < 0) {
            int duration2 = res.getInteger(R.integer.config_dropAnimMaxDuration);
            if (dist < maxDist) {
                duration2 = (int) (duration2 * this.mCubicEaseOutInterpolator.getInterpolation(dist / maxDist));
            }
            duration = Math.max(duration2, res.getInteger(R.integer.config_dropAnimMinDuration));
        }
        TimeInterpolator interpolator = null;
        if (alphaInterpolator == null || motionInterpolator == null) {
            interpolator = this.mCubicEaseOutInterpolator;
        }
        final float initAlpha = view.getAlpha();
        final float dropViewScale = view.getScaleX();
        ValueAnimator.AnimatorUpdateListener updateCb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.DragLayer.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int i;
                float percent = ((Float) animation.getAnimatedValue()).floatValue();
                int width = view.getMeasuredWidth();
                int height = view.getMeasuredHeight();
                float alphaPercent = alphaInterpolator == null ? percent : alphaInterpolator.getInterpolation(percent);
                float motionPercent = motionInterpolator == null ? percent : motionInterpolator.getInterpolation(percent);
                float initialScaleX = initScaleX * dropViewScale;
                float initialScaleY = initScaleY * dropViewScale;
                float scaleX = (finalScaleX * percent) + ((1.0f - percent) * initialScaleX);
                float scaleY = (finalScaleY * percent) + ((1.0f - percent) * initialScaleY);
                float alpha = (finalAlpha * alphaPercent) + (initAlpha * (1.0f - alphaPercent));
                float fromLeft = from.left + (((initialScaleX - 1.0f) * width) / 2.0f);
                float fromTop = from.top + (((initialScaleY - 1.0f) * height) / 2.0f);
                int x = (int) (Math.round((to.left - fromLeft) * motionPercent) + fromLeft);
                int y = (int) (Math.round((to.top - fromTop) * motionPercent) + fromTop);
                int scrollX = x - DragLayer.this.mDropView.getScrollX();
                if (DragLayer.this.mAnchorView != null) {
                    i = DragLayer.this.mAnchorViewInitialScrollX - DragLayer.this.mAnchorView.getScrollX();
                } else {
                    i = 0;
                }
                int xPos = scrollX + i;
                int yPos = y - DragLayer.this.mDropView.getScrollY();
                DragLayer.this.mDropView.setTranslationX(xPos);
                DragLayer.this.mDropView.setTranslationY(yPos);
                DragLayer.this.mDropView.setScaleX(scaleX);
                DragLayer.this.mDropView.setScaleY(scaleY);
                DragLayer.this.mDropView.setAlpha(alpha);
            }
        };
        animateView(view, updateCb, duration, interpolator, onCompleteRunnable, animationEndStyle, anchorView);
    }

    public void animateView(DragView view, ValueAnimator.AnimatorUpdateListener updateCb, int duration, TimeInterpolator interpolator, final Runnable onCompleteRunnable, final int animationEndStyle, View anchorView) {
        if (this.mDropAnim != null) {
            this.mDropAnim.cancel();
        }
        if (this.mFadeOutAnim != null) {
            this.mFadeOutAnim.cancel();
        }
        this.mDropView = view;
        this.mDropView.cancelAnimation();
        this.mDropView.resetLayoutParams();
        if (anchorView != null) {
            this.mAnchorViewInitialScrollX = anchorView.getScrollX();
        }
        this.mAnchorView = anchorView;
        this.mDropAnim = new ValueAnimator();
        this.mDropAnim.setInterpolator(interpolator);
        this.mDropAnim.setDuration(duration);
        this.mDropAnim.setFloatValues(0.0f, 1.0f);
        this.mDropAnim.addUpdateListener(updateCb);
        this.mDropAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.DragLayer.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (onCompleteRunnable != null) {
                    onCompleteRunnable.run();
                }
                switch (animationEndStyle) {
                    case 0:
                        DragLayer.this.clearAnimatedView();
                        break;
                    case 1:
                        DragLayer.this.fadeOutDragView();
                        break;
                }
            }
        });
        this.mDropAnim.start();
    }

    public void clearAnimatedView() {
        if (this.mDropAnim != null) {
            this.mDropAnim.cancel();
        }
        if (this.mDropView != null) {
            this.mDragController.onDeferredEndDrag(this.mDropView);
        }
        this.mDropView = null;
        invalidate();
    }

    public View getAnimatedView() {
        return this.mDropView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fadeOutDragView() {
        this.mFadeOutAnim = new ValueAnimator();
        this.mFadeOutAnim.setDuration(150L);
        this.mFadeOutAnim.setFloatValues(0.0f, 1.0f);
        this.mFadeOutAnim.removeAllUpdateListeners();
        this.mFadeOutAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.DragLayer.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = ((Float) animation.getAnimatedValue()).floatValue();
                float alpha = 1.0f - percent;
                DragLayer.this.mDropView.setAlpha(alpha);
            }
        });
        this.mFadeOutAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.DragLayer.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (DragLayer.this.mDropView != null) {
                    DragLayer.this.mDragController.onDeferredEndDrag(DragLayer.this.mDropView);
                }
                DragLayer.this.mDropView = null;
                DragLayer.this.invalidate();
            }
        });
        this.mFadeOutAnim.start();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View parent, View child) {
        updateChildIndices();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View parent, View child) {
        updateChildIndices();
    }

    private void updateChildIndices() {
        if (this.mLauncher != null) {
            this.mWorkspaceIndex = indexOfChild(this.mLauncher.getWorkspace());
            this.mQsbIndex = indexOfChild(this.mLauncher.getSearchBar());
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int childCount, int i) {
        return i;
    }

    void onEnterScrollArea(int direction) {
        this.mInScrollArea = true;
        invalidate();
    }

    void onExitScrollArea() {
        this.mInScrollArea = false;
        invalidate();
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mInScrollArea && !LauncherAppState.getInstance().isScreenLarge()) {
            Workspace workspace = this.mLauncher.getWorkspace();
            int width = getMeasuredWidth();
            Rect childRect = new Rect();
            getDescendantRectRelativeToSelf(workspace.getChildAt(0), childRect);
            int page = workspace.getNextPage();
            boolean isRtl = isLayoutRtl();
            CellLayout leftPage = (CellLayout) workspace.getChildAt(isRtl ? page + 1 : page - 1);
            CellLayout rightPage = (CellLayout) workspace.getChildAt(isRtl ? page - 1 : page + 1);
            if (leftPage != null && leftPage.getIsDragOverlapping()) {
                this.mLeftHoverDrawable.setBounds(0, childRect.top, this.mLeftHoverDrawable.getIntrinsicWidth(), childRect.bottom);
                this.mLeftHoverDrawable.draw(canvas);
            } else if (rightPage != null && rightPage.getIsDragOverlapping()) {
                this.mRightHoverDrawable.setBounds(width - this.mRightHoverDrawable.getIntrinsicWidth(), childRect.top, width, childRect.bottom);
                this.mRightHoverDrawable.draw(canvas);
            }
        }
    }

    public void setTouchCompleteListener(TouchCompleteListener listener) {
        this.mTouchCompleteListener = listener;
    }
}
