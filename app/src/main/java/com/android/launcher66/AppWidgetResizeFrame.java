package com.android.launcher66;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.syu.ipc.data.FinalCanbus;

public class AppWidgetResizeFrame extends FrameLayout {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 1;
    private static Rect mTmpRect = new Rect();
    final int BACKGROUND_PADDING;
    final float DIMMED_HANDLE_ALPHA;
    final float RESIZE_THRESHOLD;
    final int SNAP_DURATION;
    private int mBackgroundPadding;
    private int mBaselineHeight;
    private int mBaselineWidth;
    private int mBaselineX;
    private int mBaselineY;
    private boolean mBottomBorderActive;
    private ImageView mBottomHandle;
    private int mBottomTouchRegionAdjustment;
    private CellLayout mCellLayout;
    private int mDeltaX;
    private int mDeltaXAddOn;
    private int mDeltaY;
    private int mDeltaYAddOn;
    int[] mDirectionVector;
    private DragLayer mDragLayer;
    int[] mLastDirectionVector;
    private Launcher mLauncher;
    private boolean mLeftBorderActive;
    private ImageView mLeftHandle;
    private int mMinHSpan;
    private int mMinVSpan;
    private int mResizeMode;
    private boolean mRightBorderActive;
    private ImageView mRightHandle;
    private int mRunningHInc;
    private int mRunningVInc;
    int[] mTmpPt;
    private boolean mTopBorderActive;
    private ImageView mTopHandle;
    private int mTopTouchRegionAdjustment;
    private int mTouchTargetWidth;
    private int mWidgetPaddingBottom;
    private int mWidgetPaddingLeft;
    private int mWidgetPaddingRight;
    private int mWidgetPaddingTop;
    private LauncherAppWidgetHostView mWidgetView;

    public AppWidgetResizeFrame(Context context, LauncherAppWidgetHostView widgetView, CellLayout cellLayout, DragLayer dragLayer) {
        super(context);
        this.mTopTouchRegionAdjustment = 0;
        this.mBottomTouchRegionAdjustment = 0;
        this.mDirectionVector = new int[2];
        this.mLastDirectionVector = new int[2];
        this.mTmpPt = new int[2];
        this.SNAP_DURATION = FinalCanbus.CAR_WC1_MZD6;
        this.BACKGROUND_PADDING = 24;
        this.DIMMED_HANDLE_ALPHA = 0.0f;
        this.RESIZE_THRESHOLD = 0.66f;
        this.mLauncher = (Launcher) context;
        this.mCellLayout = cellLayout;
        this.mWidgetView = widgetView;
        this.mResizeMode = widgetView.getAppWidgetInfo().resizeMode;
        this.mDragLayer = dragLayer;
        AppWidgetProviderInfo info = widgetView.getAppWidgetInfo();
        int[] result = Launcher.getMinSpanForWidget(this.mLauncher, info);
        this.mMinHSpan = result[0];
        this.mMinVSpan = result[1];
        setBackgroundResource(R.drawable.widget_resize_frame_holo);
        setPadding(0, 0, 0, 0);
        this.mLeftHandle = new ImageView(context);
        this.mLeftHandle.setImageResource(R.drawable.widget_resize_handle_left);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2, 19);
        addView(this.mLeftHandle, lp);
        this.mRightHandle = new ImageView(context);
        this.mRightHandle.setImageResource(R.drawable.widget_resize_handle_right);
        FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(-2, -2, 21);
        addView(this.mRightHandle, lp2);
        this.mTopHandle = new ImageView(context);
        this.mTopHandle.setImageResource(R.drawable.widget_resize_handle_top);
        FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(-2, -2, 49);
        addView(this.mTopHandle, lp3);
        this.mBottomHandle = new ImageView(context);
        this.mBottomHandle.setImageResource(R.drawable.widget_resize_handle_bottom);
        FrameLayout.LayoutParams lp4 = new FrameLayout.LayoutParams(-2, -2, 81);
        addView(this.mBottomHandle, lp4);
        Rect p = AppWidgetHostView.getDefaultPaddingForWidget(context, widgetView.getAppWidgetInfo().provider, null);
        this.mWidgetPaddingLeft = p.left;
        this.mWidgetPaddingTop = p.top;
        this.mWidgetPaddingRight = p.right;
        this.mWidgetPaddingBottom = p.bottom;
        if (this.mResizeMode == 1) {
            this.mTopHandle.setVisibility(View.GONE);
            this.mBottomHandle.setVisibility(android.view.View.GONE);
        } else if (this.mResizeMode == 2) {
            this.mLeftHandle.setVisibility(View.GONE);
            this.mRightHandle.setVisibility(android.view.View.GONE);
        }
        float density = this.mLauncher.getResources().getDisplayMetrics().density;
        this.mBackgroundPadding = (int) Math.ceil(24.0f * density);
        this.mTouchTargetWidth = this.mBackgroundPadding * 2;
        this.mCellLayout.markCellsAsUnoccupiedForView(this.mWidgetView);
    }

    public boolean beginResizeIfPointInRegion(int x, int y) {
        boolean horizontalActive = (this.mResizeMode & 1) != 0;
        boolean verticalActive = (this.mResizeMode & 2) != 0;
        this.mLeftBorderActive = x < this.mTouchTargetWidth && horizontalActive;
        this.mRightBorderActive = x > getWidth() - this.mTouchTargetWidth && horizontalActive;
        this.mTopBorderActive = y < this.mTouchTargetWidth + this.mTopTouchRegionAdjustment && verticalActive;
        this.mBottomBorderActive = y > (getHeight() - this.mTouchTargetWidth) + this.mBottomTouchRegionAdjustment && verticalActive;
        boolean anyBordersActive = this.mLeftBorderActive || this.mRightBorderActive || this.mTopBorderActive || this.mBottomBorderActive;
        this.mBaselineWidth = getMeasuredWidth();
        this.mBaselineHeight = getMeasuredHeight();
        this.mBaselineX = getLeft();
        this.mBaselineY = getTop();
        if (anyBordersActive) {
            this.mLeftHandle.setAlpha(this.mLeftBorderActive ? 1.0f : 0.0f);
            this.mRightHandle.setAlpha(this.mRightBorderActive ? 1.0f : 0.0f);
            this.mTopHandle.setAlpha(this.mTopBorderActive ? 1.0f : 0.0f);
            this.mBottomHandle.setAlpha(this.mBottomBorderActive ? 1.0f : 0.0f);
        }
        return anyBordersActive;
    }

    public void updateDeltas(int deltaX, int deltaY) {
        if (this.mLeftBorderActive) {
            this.mDeltaX = Math.max(-this.mBaselineX, deltaX);
            this.mDeltaX = Math.min(this.mBaselineWidth - (this.mTouchTargetWidth * 2), this.mDeltaX);
        } else if (this.mRightBorderActive) {
            this.mDeltaX = Math.min(this.mDragLayer.getWidth() - (this.mBaselineX + this.mBaselineWidth), deltaX);
            this.mDeltaX = Math.max((-this.mBaselineWidth) + (this.mTouchTargetWidth * 2), this.mDeltaX);
        }
        if (this.mTopBorderActive) {
            this.mDeltaY = Math.max(-this.mBaselineY, deltaY);
            this.mDeltaY = Math.min(this.mBaselineHeight - (this.mTouchTargetWidth * 2), this.mDeltaY);
        } else if (this.mBottomBorderActive) {
            this.mDeltaY = Math.min(this.mDragLayer.getHeight() - (this.mBaselineY + this.mBaselineHeight), deltaY);
            this.mDeltaY = Math.max((-this.mBaselineHeight) + (this.mTouchTargetWidth * 2), this.mDeltaY);
        }
    }

    public void visualizeResizeForDelta(int deltaX, int deltaY) {
        visualizeResizeForDelta(deltaX, deltaY, false);
    }

    private void visualizeResizeForDelta(int deltaX, int deltaY, boolean onDismiss) {
        updateDeltas(deltaX, deltaY);
        DragLayer.LayoutParams lp = (DragLayer.LayoutParams) getLayoutParams();
        if (this.mLeftBorderActive) {
            lp.x = this.mBaselineX + this.mDeltaX;
            lp.width = this.mBaselineWidth - this.mDeltaX;
        } else if (this.mRightBorderActive) {
            lp.width = this.mBaselineWidth + this.mDeltaX;
        }
        if (this.mTopBorderActive) {
            lp.y = this.mBaselineY + this.mDeltaY;
            lp.height = this.mBaselineHeight - this.mDeltaY;
        } else if (this.mBottomBorderActive) {
            lp.height = this.mBaselineHeight + this.mDeltaY;
        }
        resizeWidgetIfNeeded(onDismiss);
        requestLayout();
    }

    private void resizeWidgetIfNeeded(boolean onDismiss) {
        int xThreshold = this.mCellLayout.getCellWidth() + this.mCellLayout.getWidthGap();
        int yThreshold = this.mCellLayout.getCellHeight() + this.mCellLayout.getHeightGap();
        int deltaX = this.mDeltaX + this.mDeltaXAddOn;
        int deltaY = this.mDeltaY + this.mDeltaYAddOn;
        float hSpanIncF = ((1.0f * deltaX) / xThreshold) - this.mRunningHInc;
        float vSpanIncF = ((1.0f * deltaY) / yThreshold) - this.mRunningVInc;
        int hSpanInc = 0;
        int vSpanInc = 0;
        int cellXInc = 0;
        int cellYInc = 0;
        int countX = this.mCellLayout.getCountX();
        int countY = this.mCellLayout.getCountY();
        if (Math.abs(hSpanIncF) > 0.66f) {
            hSpanInc = Math.round(hSpanIncF);
        }
        if (Math.abs(vSpanIncF) > 0.66f) {
            vSpanInc = Math.round(vSpanIncF);
        }
        if (onDismiss || hSpanInc != 0 || vSpanInc != 0) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) this.mWidgetView.getLayoutParams();
            int spanX = lp.cellHSpan;
            int spanY = lp.cellVSpan;
            int cellX = lp.useTmpCoords ? lp.tmpCellX : lp.cellX;
            int cellY = lp.useTmpCoords ? lp.tmpCellY : lp.cellY;
            int hSpanDelta = 0;
            int vSpanDelta = 0;
            if (this.mLeftBorderActive) {
                cellXInc = Math.min(lp.cellHSpan - this.mMinHSpan, Math.max(-cellX, hSpanInc));
                hSpanInc = Math.max(-(lp.cellHSpan - this.mMinHSpan), Math.min(cellX, hSpanInc * (-1)));
                hSpanDelta = -hSpanInc;
            } else if (this.mRightBorderActive) {
                hSpanInc = Math.max(-(lp.cellHSpan - this.mMinHSpan), Math.min(countX - (cellX + spanX), hSpanInc));
                hSpanDelta = hSpanInc;
            }
            if (this.mTopBorderActive) {
                cellYInc = Math.min(lp.cellVSpan - this.mMinVSpan, Math.max(-cellY, vSpanInc));
                vSpanInc = Math.max(-(lp.cellVSpan - this.mMinVSpan), Math.min(cellY, vSpanInc * (-1)));
                vSpanDelta = -vSpanInc;
            } else if (this.mBottomBorderActive) {
                vSpanInc = Math.max(-(lp.cellVSpan - this.mMinVSpan), Math.min(countY - (cellY + spanY), vSpanInc));
                vSpanDelta = vSpanInc;
            }
            this.mDirectionVector[0] = 0;
            this.mDirectionVector[1] = 0;
            if (this.mLeftBorderActive || this.mRightBorderActive) {
                spanX += hSpanInc;
                cellX += cellXInc;
                if (hSpanDelta != 0) {
                    this.mDirectionVector[0] = this.mLeftBorderActive ? -1 : 1;
                }
            }
            if (this.mTopBorderActive || this.mBottomBorderActive) {
                spanY += vSpanInc;
                cellY += cellYInc;
                if (vSpanDelta != 0) {
                    this.mDirectionVector[1] = this.mTopBorderActive ? -1 : 1;
                }
            }
            if (onDismiss || vSpanDelta != 0 || hSpanDelta != 0) {
                if (onDismiss) {
                    this.mDirectionVector[0] = this.mLastDirectionVector[0];
                    this.mDirectionVector[1] = this.mLastDirectionVector[1];
                } else {
                    this.mLastDirectionVector[0] = this.mDirectionVector[0];
                    this.mLastDirectionVector[1] = this.mDirectionVector[1];
                }
                if (this.mCellLayout.createAreaForResize(cellX, cellY, spanX, spanY, this.mWidgetView, this.mDirectionVector, onDismiss)) {
                    lp.tmpCellX = cellX;
                    lp.tmpCellY = cellY;
                    lp.cellHSpan = spanX;
                    lp.cellVSpan = spanY;
                    this.mRunningVInc += vSpanDelta;
                    this.mRunningHInc += hSpanDelta;
                    if (!onDismiss) {
                        updateWidgetSizeRanges(this.mWidgetView, this.mLauncher, spanX, spanY);
                    }
                }
                this.mWidgetView.requestLayout();
            }
        }
    }

    static void updateWidgetSizeRanges(AppWidgetHostView widgetView, Launcher launcher, int spanX, int spanY) {
        getWidgetSizeRanges(launcher, spanX, spanY, mTmpRect);
        widgetView.updateAppWidgetSize(null, mTmpRect.left, mTmpRect.top, mTmpRect.right, mTmpRect.bottom);
    }

    static Rect getWidgetSizeRanges(Launcher launcher, int spanX, int spanY, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        Rect landMetrics = Workspace.getCellLayoutMetrics(launcher, 0);
        Rect portMetrics = Workspace.getCellLayoutMetrics(launcher, 1);
        float density = launcher.getResources().getDisplayMetrics().density;
        int cellWidth = landMetrics.left;
        int cellHeight = landMetrics.top;
        int widthGap = landMetrics.right;
        int heightGap = landMetrics.bottom;
        int landWidth = (int) (((spanX * cellWidth) + ((spanX - 1) * widthGap)) / density);
        int landHeight = (int) (((spanY * cellHeight) + ((spanY - 1) * heightGap)) / density);
        int cellWidth2 = portMetrics.left;
        int cellHeight2 = portMetrics.top;
        int widthGap2 = portMetrics.right;
        int heightGap2 = portMetrics.bottom;
        int portWidth = (int) (((spanX * cellWidth2) + ((spanX - 1) * widthGap2)) / density);
        int portHeight = (int) (((spanY * cellHeight2) + ((spanY - 1) * heightGap2)) / density);
        rect.set(portWidth, landHeight, landWidth, portHeight);
        return rect;
    }

    public void commitResize() {
        resizeWidgetIfNeeded(true);
        requestLayout();
    }

    public void onTouchUp() {
        int xThreshold = this.mCellLayout.getCellWidth() + this.mCellLayout.getWidthGap();
        int yThreshold = this.mCellLayout.getCellHeight() + this.mCellLayout.getHeightGap();
        this.mDeltaXAddOn = this.mRunningHInc * xThreshold;
        this.mDeltaYAddOn = this.mRunningVInc * yThreshold;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
        post(new Runnable() { 
            @Override
            public void run() {
                AppWidgetResizeFrame.this.snapToWidget(true);
            }
        });
    }

    public void snapToWidget(boolean animate) {
        DragLayer.LayoutParams lp = (DragLayer.LayoutParams) getLayoutParams();
        int newWidth = ((this.mWidgetView.getWidth() + (this.mBackgroundPadding * 2)) - this.mWidgetPaddingLeft) - this.mWidgetPaddingRight;
        int newHeight = ((this.mWidgetView.getHeight() + (this.mBackgroundPadding * 2)) - this.mWidgetPaddingTop) - this.mWidgetPaddingBottom;
        this.mTmpPt[0] = this.mWidgetView.getLeft();
        this.mTmpPt[1] = this.mWidgetView.getTop();
        this.mDragLayer.getDescendantCoordRelativeToSelf(this.mCellLayout.getShortcutsAndWidgets(), this.mTmpPt);
        int newX = (this.mTmpPt[0] - this.mBackgroundPadding) + this.mWidgetPaddingLeft;
        int newY = (this.mTmpPt[1] - this.mBackgroundPadding) + this.mWidgetPaddingTop;
        if (newY < 0) {
            this.mTopTouchRegionAdjustment = -newY;
        } else {
            this.mTopTouchRegionAdjustment = 0;
        }
        if (newY + newHeight > this.mDragLayer.getHeight()) {
            this.mBottomTouchRegionAdjustment = -((newY + newHeight) - this.mDragLayer.getHeight());
        } else {
            this.mBottomTouchRegionAdjustment = 0;
        }
        if (!animate) {
            lp.width = newWidth;
            lp.height = newHeight;
            lp.x = newX;
            lp.y = newY;
            this.mLeftHandle.setAlpha(1.0f);
            this.mRightHandle.setAlpha(1.0f);
            this.mTopHandle.setAlpha(1.0f);
            this.mBottomHandle.setAlpha(1.0f);
            requestLayout();
            return;
        }
        PropertyValuesHolder width = PropertyValuesHolder.ofInt("width", lp.width, newWidth);
        PropertyValuesHolder height = PropertyValuesHolder.ofInt("height", lp.height, newHeight);
        PropertyValuesHolder x = PropertyValuesHolder.ofInt("x", lp.x, newX);
        PropertyValuesHolder y = PropertyValuesHolder.ofInt("y", lp.y, newY);
        ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(lp, this, width, height, x, y);
        ObjectAnimator leftOa = LauncherAnimUtils.ofFloat(this.mLeftHandle, "alpha", 1.0f);
        ObjectAnimator rightOa = LauncherAnimUtils.ofFloat(this.mRightHandle, "alpha", 1.0f);
        ObjectAnimator topOa = LauncherAnimUtils.ofFloat(this.mTopHandle, "alpha", 1.0f);
        ObjectAnimator bottomOa = LauncherAnimUtils.ofFloat(this.mBottomHandle, "alpha", 1.0f);
        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                AppWidgetResizeFrame.this.requestLayout();
            }
        });
        AnimatorSet set = LauncherAnimUtils.createAnimatorSet();
        if (this.mResizeMode == 2) {
            set.playTogether(oa, topOa, bottomOa);
        } else if (this.mResizeMode == 1) {
            set.playTogether(oa, leftOa, rightOa);
        } else {
            set.playTogether(oa, leftOa, rightOa, topOa, bottomOa);
        }
        set.setDuration(150L);
        set.start();
    }
}
