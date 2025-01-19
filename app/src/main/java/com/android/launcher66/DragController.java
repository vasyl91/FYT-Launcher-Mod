package com.android.launcher66;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import com.android.launcher66.DropTarget;
import com.android.launcher66.R;
import com.syu.log.LogPreview;
import java.util.ArrayList;
import java.util.Iterator;

public class DragController {
    private static final float MAX_FLING_DEGREES = 35.0f;
    private static final boolean PROFILE_DRAWING_DURING_DRAG = false;
    private static final int RESCROLL_DELAY = 900;
    private static final int SCROLL_DELAY = 500;
    static final int SCROLL_LEFT = 0;
    static final int SCROLL_NONE = -1;
    private static final int SCROLL_OUTSIDE_ZONE = 0;
    static final int SCROLL_RIGHT = 1;
    private static final int SCROLL_WAITING_IN_ZONE = 1;
    private static final String TAG = "Launcher.DragController";
    private DropTarget.DragObject mDragObject;
    private DragScroller mDragScroller;
    private boolean mDragging;
    private DropTarget mFlingToDeleteDropTarget;
    protected int mFlingToDeleteThresholdVelocity;
    private Handler mHandler;
    private InputMethodManager mInputMethodManager;
    private DropTarget mLastDropTarget;
    private Launcher mLauncher;
    private int mMotionDownX;
    private int mMotionDownY;
    private View mMoveTarget;
    private View mScrollView;
    private int mScrollZone;
    private VelocityTracker mVelocityTracker;
    private IBinder mWindowToken;
    public static int DRAG_ACTION_MOVE = 0;
    public static int DRAG_ACTION_COPY = 1;
    private Rect mRectTemp = new Rect();
    private final int[] mCoordinatesTemp = new int[2];
    private ArrayList<DropTarget> mDropTargets = new ArrayList<>();
    private ArrayList<DragListener> mListeners = new ArrayList<>();
    private int mScrollState = 0;
    private ScrollRunnable mScrollRunnable = new ScrollRunnable();
    private int[] mLastTouch = new int[2];
    private long mLastTouchUpTime = -1;
    private int mDistanceSinceScroll = 0;
    private int[] mTmpPoint = new int[2];
    private Rect mDragLayerRect = new Rect();

    interface DragListener {
        void onDragEnd();

        void onDragStart(DragSource dragSource, Object obj, int i);
    }

    public DragController(Launcher launcher) {
        Resources r = launcher.getResources();
        this.mLauncher = launcher;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScrollZone = r.getDimensionPixelSize(R.dimen.scroll_zone);
        this.mVelocityTracker = VelocityTracker.obtain();
        float density = r.getDisplayMetrics().density;
        this.mFlingToDeleteThresholdVelocity = (int) (r.getInteger(R.integer.config_flingToDeleteMinVelocity) * density);
    }

    public boolean dragging() {
        return this.mDragging;
    }

    public void startDrag(View v, Bitmap bmp, DragSource source, Object dragInfo, int dragAction, Point extraPadding, float initialDragViewScale) {
        int[] loc = this.mCoordinatesTemp;
        this.mLauncher.getDragLayer().getLocationInDragLayer(v, loc);
        int viewExtraPaddingLeft = extraPadding != null ? extraPadding.x : 0;
        int viewExtraPaddingTop = extraPadding != null ? extraPadding.y : 0;
        int dragLayerX = loc[0] + v.getPaddingLeft() + viewExtraPaddingLeft + ((int) (((bmp.getWidth() * initialDragViewScale) - bmp.getWidth()) / 2.0f));
        int dragLayerY = loc[1] + v.getPaddingTop() + viewExtraPaddingTop + ((int) (((bmp.getHeight() * initialDragViewScale) - bmp.getHeight()) / 2.0f));
        startDrag(bmp, dragLayerX, dragLayerY, source, dragInfo, dragAction, null, null, initialDragViewScale);
        if (dragAction == DRAG_ACTION_MOVE) {
            v.setVisibility(View.GONE);
        }
    }

    public void startDrag(Bitmap b, int dragLayerX, int dragLayerY, DragSource source, Object dragInfo, int dragAction, Point dragOffset, Rect dragRegion, float initialDragViewScale) {
        LogPreview.show("startDrag...");
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) this.mLauncher.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        this.mInputMethodManager.hideSoftInputFromWindow(this.mWindowToken, 0);
        Iterator<DragListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            DragListener listener = it.next();
            listener.onDragStart(source, dragInfo, dragAction);
        }
        int registrationX = this.mMotionDownX - dragLayerX;
        int registrationY = this.mMotionDownY - dragLayerY;
        int dragRegionLeft = dragRegion == null ? 0 : dragRegion.left;
        int dragRegionTop = dragRegion == null ? 0 : dragRegion.top;
        this.mDragging = true;
        this.mDragObject = new DropTarget.DragObject();
        this.mDragObject.dragComplete = false;
        this.mDragObject.xOffset = this.mMotionDownX - (dragLayerX + dragRegionLeft);
        this.mDragObject.yOffset = this.mMotionDownY - (dragLayerY + dragRegionTop);
        this.mDragObject.dragSource = source;
        this.mDragObject.dragInfo = dragInfo;
        DropTarget.DragObject dragObject = this.mDragObject;
        DragView dragView = new DragView(this.mLauncher, b, registrationX, registrationY, 0, 0, b.getWidth(), b.getHeight(), initialDragViewScale);
        dragObject.dragView = dragView;
        if (dragOffset != null) {
            dragView.setDragVisualizeOffset(new Point(dragOffset));
        }
        if (dragRegion != null) {
            dragView.setDragRegion(new Rect(dragRegion));
        }
        this.mLauncher.getDragLayer().performHapticFeedback(0);
        dragView.show(this.mMotionDownX, this.mMotionDownY);
        handleMoveEvent(this.mMotionDownX, this.mMotionDownY);
    }

    Bitmap getViewBitmap(View v) {
        v.clearFocus();
        v.setPressed(false);
        boolean willNotCache = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);
        int color = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);
        float alpha = v.getAlpha();
        v.setAlpha(1.0f);
        if (color != 0) {
            v.destroyDrawingCache();
        }
        v.buildDrawingCache();
        Bitmap cacheBitmap = v.getDrawingCache();
        if (cacheBitmap == null) {
            Log.e(TAG, "failed getViewBitmap(" + v + ")", new RuntimeException());
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(cacheBitmap);
        v.destroyDrawingCache();
        v.setAlpha(alpha);
        v.setWillNotCacheDrawing(willNotCache);
        v.setDrawingCacheBackgroundColor(color);
        return createBitmap;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return this.mDragging;
    }

    public boolean isDragging() {
        return this.mDragging;
    }

    public void cancelDrag() {
        if (this.mDragging) {
            if (this.mLastDropTarget != null) {
                this.mLastDropTarget.onDragExit(this.mDragObject);
            }
            this.mDragObject.deferDragViewCleanupPostAnimation = false;
            this.mDragObject.cancelled = true;
            this.mDragObject.dragComplete = true;
            this.mDragObject.dragSource.onDropCompleted(null, this.mDragObject, false, false);
        }
        endDrag();
    }

    public void onAppsRemoved(ArrayList<AppInfo> appInfos, Context context) {
        if (this.mDragObject != null) {
            Object rawDragInfo = this.mDragObject.dragInfo;
            if (rawDragInfo instanceof ShortcutInfo) {
                ShortcutInfo dragInfo = (ShortcutInfo) rawDragInfo;
                Iterator<AppInfo> it = appInfos.iterator();
                while (it.hasNext()) {
                    AppInfo info = it.next();
                    if (dragInfo != null && dragInfo.intent != null) {
                        boolean isSameComponent = dragInfo.intent.getComponent().equals(info.componentName);
                        if (isSameComponent) {
                            cancelDrag();
                            return;
                        }
                    }
                }
            }
        }
    }

    private void endDrag() {
        if (this.mDragging) {
            this.mDragging = false;
            clearScrollRunnable();
            boolean isDeferred = false;
            if (this.mDragObject.dragView != null) {
                isDeferred = this.mDragObject.deferDragViewCleanupPostAnimation;
                if (!isDeferred) {
                    this.mDragObject.dragView.remove();
                }
                this.mDragObject.dragView = null;
            }
            if (!isDeferred) {
                Iterator<DragListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    DragListener listener = it.next();
                    listener.onDragEnd();
                }
            }
        }
        releaseVelocityTracker();
    }

    void onDeferredEndDrag(DragView dragView) {
        dragView.remove();
        if (this.mDragObject.deferDragViewCleanupPostAnimation) {
            Iterator<DragListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                DragListener listener = it.next();
                listener.onDragEnd();
            }
        }
    }

    void onDeferredEndFling(DropTarget.DragObject d) {
        d.dragSource.onFlingToDeleteCompleted();
    }

    private int[] getClampedDragLayerPos(float x, float y) {
        this.mLauncher.getDragLayer().getLocalVisibleRect(this.mDragLayerRect);
        this.mTmpPoint[0] = (int) Math.max(this.mDragLayerRect.left, Math.min(x, this.mDragLayerRect.right - 1));
        this.mTmpPoint[1] = (int) Math.max(this.mDragLayerRect.top, Math.min(y, this.mDragLayerRect.bottom - 1));
        return this.mTmpPoint;
    }

    long getLastGestureUpTime() {
        return this.mDragging ? System.currentTimeMillis() : this.mLastTouchUpTime;
    }

    void resetLastGestureUpTime() {
        this.mLastTouchUpTime = -1L;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        acquireVelocityTrackerAndAddMovement(ev);
        int action = ev.getAction();
        int[] dragLayerPos = getClampedDragLayerPos(ev.getX(), ev.getY());
        int dragLayerX = dragLayerPos[0];
        int dragLayerY = dragLayerPos[1];
        switch (action) {
            case 0:
                this.mMotionDownX = dragLayerX;
                this.mMotionDownY = dragLayerY;
                this.mLastDropTarget = null;
                break;
            case 1:
                this.mLastTouchUpTime = System.currentTimeMillis();
                if (this.mDragging) {
                    PointF vec = isFlingingToDelete(this.mDragObject.dragSource);
                    if (!DeleteDropTarget.willAcceptDrop(this.mDragObject.dragInfo)) {
                        vec = null;
                    }
                    if (vec != null) {
                        dropOnFlingToDeleteTarget(dragLayerX, dragLayerY, vec);
                    } else {
                        drop(dragLayerX, dragLayerY);
                    }
                }
                endDrag();
                break;
            case 3:
                cancelDrag();
                break;
        }
        return this.mDragging;
    }

    void setMoveTarget(View view) {
        this.mMoveTarget = view;
    }

    public boolean dispatchUnhandledMove(View focused, int direction) {
        return this.mMoveTarget != null && this.mMoveTarget.dispatchUnhandledMove(focused, direction);
    }

    private void clearScrollRunnable() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.mScrollState == 1) {
            this.mScrollState = 0;
            this.mScrollRunnable.setDirection(1);
            this.mDragScroller.onExitScrollArea();
            this.mLauncher.getDragLayer().onExitScrollArea();
        }
    }

    private void handleMoveEvent(int x, int y) {
        this.mDragObject.dragView.move(x, y);
        int[] coordinates = this.mCoordinatesTemp;
        DropTarget dropTarget = findDropTarget(x, y, coordinates);
        this.mDragObject.x = coordinates[0];
        this.mDragObject.y = coordinates[1];
        checkTouchMove(dropTarget);
        this.mDistanceSinceScroll = (int) (this.mDistanceSinceScroll + Math.sqrt(Math.pow(this.mLastTouch[0] - x, 2.0d) + Math.pow(this.mLastTouch[1] - y, 2.0d)));
        this.mLastTouch[0] = x;
        this.mLastTouch[1] = y;
        checkScrollState(x, y);
    }

    public void forceTouchMove() {
        int[] dummyCoordinates = this.mCoordinatesTemp;
        DropTarget dropTarget = findDropTarget(this.mLastTouch[0], this.mLastTouch[1], dummyCoordinates);
        this.mDragObject.x = dummyCoordinates[0];
        this.mDragObject.y = dummyCoordinates[1];
        checkTouchMove(dropTarget);
    }

    private void checkTouchMove(DropTarget dropTarget) {
        if (dropTarget != null) {
            if (this.mLastDropTarget != dropTarget) {
                if (this.mLastDropTarget != null) {
                    this.mLastDropTarget.onDragExit(this.mDragObject);
                }
                dropTarget.onDragEnter(this.mDragObject);
            }
            dropTarget.onDragOver(this.mDragObject);
        } else if (this.mLastDropTarget != null) {
            this.mLastDropTarget.onDragExit(this.mDragObject);
        }
        this.mLastDropTarget = dropTarget;
    }

    
    public void checkScrollState(int x, int y) {
        int slop = ViewConfiguration.get(this.mLauncher).getScaledWindowTouchSlop();
        int delay = this.mDistanceSinceScroll < slop ? RESCROLL_DELAY : 500;
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        boolean isRtl = dragLayer.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
        int forwardDirection = isRtl ? 1 : 0;
        int backwardsDirection = isRtl ? 0 : 1;
        if (x < this.mScrollZone) {
            if (this.mScrollState == 0) {
                this.mScrollState = 1;
                if (this.mDragScroller.onEnterScrollArea(x, y, forwardDirection)) {
                    dragLayer.onEnterScrollArea(forwardDirection);
                    this.mScrollRunnable.setDirection(forwardDirection);
                    this.mHandler.postDelayed(this.mScrollRunnable, delay);
                    return;
                }
                return;
            }
            return;
        }
        if (x > this.mScrollView.getWidth() - this.mScrollZone) {
            if (this.mScrollState == 0) {
                this.mScrollState = 1;
                if (this.mDragScroller.onEnterScrollArea(x, y, backwardsDirection)) {
                    dragLayer.onEnterScrollArea(backwardsDirection);
                    this.mScrollRunnable.setDirection(backwardsDirection);
                    this.mHandler.postDelayed(this.mScrollRunnable, delay);
                    return;
                }
                return;
            }
            return;
        }
        clearScrollRunnable();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.mDragging) {
            return false;
        }
        acquireVelocityTrackerAndAddMovement(ev);
        int action = ev.getAction();
        int[] dragLayerPos = getClampedDragLayerPos(ev.getX(), ev.getY());
        int dragLayerX = dragLayerPos[0];
        int dragLayerY = dragLayerPos[1];
        switch (action) {
            case 0:
                this.mMotionDownX = dragLayerX;
                this.mMotionDownY = dragLayerY;
                if (dragLayerX < this.mScrollZone || dragLayerX > this.mScrollView.getWidth() - this.mScrollZone) {
                    this.mScrollState = 1;
                    this.mHandler.postDelayed(this.mScrollRunnable, 500L);
                } else {
                    this.mScrollState = 0;
                }
                handleMoveEvent(dragLayerX, dragLayerY);
                break;
            case 1:
                handleMoveEvent(dragLayerX, dragLayerY);
                this.mHandler.removeCallbacks(this.mScrollRunnable);
                if (this.mDragging) {
                    PointF vec = isFlingingToDelete(this.mDragObject.dragSource);
                    if (!DeleteDropTarget.willAcceptDrop(this.mDragObject.dragInfo)) {
                        vec = null;
                    }
                    if (vec != null) {
                        dropOnFlingToDeleteTarget(dragLayerX, dragLayerY, vec);
                    } else {
                        drop(dragLayerX, dragLayerY);
                    }
                }
                endDrag();
                break;
            case 2:
                handleMoveEvent(dragLayerX, dragLayerY);
                break;
            case 3:
                this.mHandler.removeCallbacks(this.mScrollRunnable);
                cancelDrag();
                break;
        }
        return true;
    }

    private PointF isFlingingToDelete(DragSource source) {
        if (this.mFlingToDeleteDropTarget != null && source.supportsFlingToDelete()) {
            ViewConfiguration config = ViewConfiguration.get(this.mLauncher);
            this.mVelocityTracker.computeCurrentVelocity(1000, config.getScaledMaximumFlingVelocity());
            if (this.mVelocityTracker.getYVelocity() < this.mFlingToDeleteThresholdVelocity) {
                PointF vel = new PointF(this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
                PointF upVec = new PointF(0.0f, -1.0f);
                float theta = (float) Math.acos(((vel.x * upVec.x) + (vel.y * upVec.y)) / (vel.length() * upVec.length()));
                if (theta <= Math.toRadians(35.0d)) {
                    return vel;
                }
            }
            return null;
        }
        return null;
    }

    private void dropOnFlingToDeleteTarget(float x, float y, PointF vel) {
        int[] coordinates = this.mCoordinatesTemp;
        this.mDragObject.x = coordinates[0];
        this.mDragObject.y = coordinates[1];
        if (this.mLastDropTarget != null && this.mFlingToDeleteDropTarget != this.mLastDropTarget) {
            this.mLastDropTarget.onDragExit(this.mDragObject);
        }
        boolean accepted = false;
        this.mFlingToDeleteDropTarget.onDragEnter(this.mDragObject);
        this.mDragObject.dragComplete = true;
        this.mFlingToDeleteDropTarget.onDragExit(this.mDragObject);
        if (this.mFlingToDeleteDropTarget.acceptDrop(this.mDragObject)) {
            this.mFlingToDeleteDropTarget.onFlingToDelete(this.mDragObject, this.mDragObject.x, this.mDragObject.y, vel);
            accepted = true;
        }
        this.mDragObject.dragSource.onDropCompleted((View) this.mFlingToDeleteDropTarget, this.mDragObject, true, accepted);
    }

    private void drop(float x, float y) {
        final int[] coordinates = mCoordinatesTemp;
        final DropTarget dropTarget = findDropTarget((int) x, (int) y, coordinates);

        mDragObject.x = coordinates[0];
        mDragObject.y = coordinates[1];
        boolean accepted = false;
        if (dropTarget != null) {
            mDragObject.dragComplete = true;
            dropTarget.onDragExit(mDragObject);
            if (dropTarget.acceptDrop(mDragObject)) {
                dropTarget.onDrop(mDragObject);
                accepted = true;
            }
        }
        mDragObject.dragSource.onDropCompleted((View) dropTarget, mDragObject, false, accepted);
    }

    private DropTarget findDropTarget(int x, int y, int[] dropCoordinates) {
        final Rect r = mRectTemp;

        final ArrayList<DropTarget> dropTargets = mDropTargets;
        final int count = dropTargets.size();
        for (int i=count-1; i>=0; i--) {
            DropTarget target = dropTargets.get(i);
            if (!target.isDropEnabled())
                continue;

            target.getHitRectRelativeToDragLayer(r);

            mDragObject.x = x;
            mDragObject.y = y;
            if (r.contains(x, y)) {

                dropCoordinates[0] = x;
                dropCoordinates[1] = y;
                mLauncher.getDragLayer().mapCoordInSelfToDescendent((View) target, dropCoordinates);

                return target;
            }
        }
        return null;
    }

    public void setDragScoller(DragScroller scroller) {
        this.mDragScroller = scroller;
    }

    public void setWindowToken(IBinder token) {
        this.mWindowToken = token;
    }

    public void addDragListener(DragListener l) {
        this.mListeners.add(l);
    }

    public void removeDragListener(DragListener l) {
        this.mListeners.remove(l);
    }

    public void addDropTarget(DropTarget target) {
        this.mDropTargets.add(target);
    }

    public void removeDropTarget(DropTarget target) {
        this.mDropTargets.remove(target);
    }

    public void setFlingToDeleteDropTarget(DropTarget target) {
        this.mFlingToDeleteDropTarget = target;
    }

    private void acquireVelocityTrackerAndAddMovement(MotionEvent ev) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void setScrollView(View v) {
        this.mScrollView = v;
    }

    DragView getDragView() {
        return this.mDragObject.dragView;
    }

    private class ScrollRunnable implements Runnable {
        private int mDirection;

        ScrollRunnable() {
        }

        @Override
        public void run() {
            if (DragController.this.mDragScroller != null) {
                if (this.mDirection == 0) {
                    DragController.this.mDragScroller.scrollLeft();
                } else {
                    DragController.this.mDragScroller.scrollRight();
                }
                DragController.this.mScrollState = 0;
                DragController.this.mDistanceSinceScroll = 0;
                DragController.this.mDragScroller.onExitScrollArea();
                DragController.this.mLauncher.getDragLayer().onExitScrollArea();
                if (DragController.this.isDragging()) {
                    DragController.this.checkScrollState(DragController.this.mLastTouch[0], DragController.this.mLastTouch[1]);
                }
            }
        }

        void setDirection(int direction) {
            this.mDirection = direction;
        }
    }
}
