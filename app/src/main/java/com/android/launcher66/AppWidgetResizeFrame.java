package com.android.launcher66;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Rect;
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
    private boolean mRightBorderActive;
    private ImageView mRightHandle;
    private int mRunningHInc;
    private int mRunningVInc;
    int[] mTmpPt;
    private boolean mTopBorderActive;
    private ImageView mTopHandle;
    private int mTopTouchRegionAdjustment;
    private int mLeftTouchRegionAdjustment;
    private int mRightTouchRegionAdjustment;
    private int mTouchTargetWidth;
    private int mWidgetPaddingBottom;
    private int mWidgetPaddingLeft;
    private int mWidgetPaddingRight;
    private int mWidgetPaddingTop;
    private LauncherAppWidgetHostView mWidgetView;
    /** A handle of a freely placed widget's frame was moved since the frame was shown (resizeFreeform). */
    private boolean mFreeformMoved;
    /** In the middle of the frame: fits the widget's content to its cells, or stops doing so. */
    private ImageView mFitToggle;

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
        this.mDragLayer = dragLayer;
        // Any widget may be made as small as one cell, whatever it gives as its smallest size
        // or resize mode: the user decides.
        this.mMinHSpan = 1;
        this.mMinVSpan = 1;
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
        // The same share of the screen everywhere: 40 dp were 5 % of the shorter side on an FYT unit
        // (1200 x 2000 at 240 dpi) but 10.4 % on the phone it looked right on (1080 x 2340 at 450 dpi).
        int toggleSize = ScreenScale.referencePx(context, 40.0f);
        int togglePadding = ScreenScale.referencePx(context, 8.0f);
        this.mFitToggle = new ImageView(context);
        this.mFitToggle.setImageResource(R.drawable.ic_widget_fit);
        this.mFitToggle.setPadding(togglePadding, togglePadding, togglePadding, togglePadding);
        this.mFitToggle.setContentDescription(context.getString(R.string.widget_fit_toggle));
        addView(this.mFitToggle, new FrameLayout.LayoutParams(toggleSize, toggleSize,
                android.view.Gravity.CENTER));
        showFitState();
        Rect p = AppWidgetHostView.getDefaultPaddingForWidget(context, widgetView.getAppWidgetInfo().provider, null);
        this.mWidgetPaddingLeft = p.left;
        this.mWidgetPaddingTop = p.top;
        this.mWidgetPaddingRight = p.right;
        this.mWidgetPaddingBottom = p.bottom;
        float density = this.mLauncher.getResources().getDisplayMetrics().density;
        this.mBackgroundPadding = (int) Math.ceil(24.0f * density);
        this.mTouchTargetWidth = this.mBackgroundPadding * 2;
        this.mCellLayout.markCellsAsUnoccupiedForView(this.mWidgetView);
    }

    private void showFitState() {
        this.mFitToggle.setBackgroundResource(this.mWidgetView.isFitContent()
                ? R.drawable.widget_fit_toggle_on : R.drawable.widget_fit_toggle_off);
    }

    /** Whether x, y (in this frame) is on the fit toggle; checked before the borders. */
    public boolean isOnFitToggle(int x, int y) {
        return x >= this.mFitToggle.getLeft() && x < this.mFitToggle.getRight()
                && y >= this.mFitToggle.getTop() && y < this.mFitToggle.getBottom();
    }

    /** Fits the widget's content to its cells, or stops; remembered for this widget. */
    public void toggleFit() {
        boolean fit = !this.mWidgetView.isFitContent();
        this.mWidgetView.setFitContent(fit);
        WidgetFit.set(getContext(), this.mWidgetView.getAppWidgetId(), fit);
        showFitState();
        performHapticFeedback(android.view.HapticFeedbackConstants.VIRTUAL_KEY);
    }

    public boolean beginResizeIfPointInRegion(int x, int y) {
        this.mLeftBorderActive = x < this.mTouchTargetWidth + this.mLeftTouchRegionAdjustment;
        this.mRightBorderActive = x > (getWidth() - this.mTouchTargetWidth) + this.mRightTouchRegionAdjustment;
        this.mTopBorderActive = y < this.mTouchTargetWidth + this.mTopTouchRegionAdjustment;
        this.mBottomBorderActive = y > (getHeight() - this.mTouchTargetWidth) + this.mBottomTouchRegionAdjustment;
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

    /**
     * The frame may move its own padding past the screen's edges, on both axes: it is that much
     * larger than the widget all round, so a widget as wide (or tall) as the screen has its frame
     * reach beyond it. Kept on the screen, it stopped short of the last cell's threshold and the
     * widget snapped back to one cell less.
     */
    public void updateDeltas(int deltaX, int deltaY) {
        int overhang = this.mBackgroundPadding;
        if (this.mLeftBorderActive) {
            this.mDeltaX = Math.max(-this.mBaselineX - overhang, deltaX);
            this.mDeltaX = Math.min(this.mBaselineWidth - (this.mTouchTargetWidth * 2), this.mDeltaX);
        } else if (this.mRightBorderActive) {
            this.mDeltaX = Math.min(this.mDragLayer.getWidth() + overhang - (this.mBaselineX + this.mBaselineWidth), deltaX);
            this.mDeltaX = Math.max((-this.mBaselineWidth) + (this.mTouchTargetWidth * 2), this.mDeltaX);
        }
        if (this.mTopBorderActive) {
            this.mDeltaY = Math.max(-this.mBaselineY - overhang, deltaY);
            this.mDeltaY = Math.min(this.mBaselineHeight - (this.mTouchTargetWidth * 2), this.mDeltaY);
        } else if (this.mBottomBorderActive) {
            this.mDeltaY = Math.min(this.mDragLayer.getHeight() + overhang - (this.mBaselineY + this.mBaselineHeight), deltaY);
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

    /**
     * "Freeform widgets": the widget follows the frame's pixels instead of stepping from cell to cell, and the frame is put
     * back round the rectangle the widget got (ResizeGeometry): where the page limits the size or refuses it, the frame
     * does not run on with the finger.
     *
     * @return whether the widget is placed freely and this took care of the resize
     */
    private boolean resizeFreeform(boolean onDismiss) {
        if (!FreeformWidgets.enabled(getContext())) {
            return false;
        }
        int[] before = mCellLayout.freeformRect(this.mWidgetView);
        if (before == null) {
            return false;
        }
        if (onDismiss && !this.mFreeformMoved) {
            // Put away with no handle moved (a tap beside it): nothing to write. The frame's own rectangle was taken as
            // a resize and moved the widget to it (the owner's log of 2026-11-27: "resized" with no resize)
            return true;
        }
        DragLayer.LayoutParams frame = (DragLayer.LayoutParams) getLayoutParams();
        this.mTmpPt[0] = 0;
        this.mTmpPt[1] = 0;
        this.mDragLayer.getDescendantCoordRelativeToSelf(this.mCellLayout.getShortcutsAndWidgets(), this.mTmpPt);
        // The widget's frame is the rectangle it is seen in (FreeformLayout): the resize frame lies round it by its own
        // padding, with no scale and no padding of the widget to count
        int[] pad = new int[4];
        int[] asked = ResizeGeometry.widgetOf(new int[] {frame.x, frame.y, frame.width, frame.height},
                this.mBackgroundPadding, pad, 1f, this.mTmpPt[0], this.mTmpPt[1]);
        int[] got = FreeformWidgets.resizeTo(this.mCellLayout, this.mWidgetView, asked[0], asked[1], asked[2],
                asked[3], onDismiss);
        this.mFreeformMoved = !onDismiss;
        // The frame round what the widget has: the new rectangle, or the one it kept when the resize was refused
        int[] round = ResizeGeometry.frameOf(got != null ? got : before, this.mBackgroundPadding, pad, 1f,
                this.mTmpPt[0], this.mTmpPt[1]);
        frame.x = round[0];
        frame.y = round[1];
        frame.width = round[2];
        frame.height = round[3];
        if (onDismiss) {
            this.mCellLayout.markCellsAsOccupiedForView(this.mWidgetView);
            ItemInfo info = (ItemInfo) this.mWidgetView.getTag();
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) this.mWidgetView.getLayoutParams();
            if (info != null) {
                info.cellX = lp.cellX;
                info.cellY = lp.cellY;
                info.spanX = lp.cellHSpan;
                info.spanY = lp.cellVSpan;
                LauncherModel.modifyItemInDatabase(this.mLauncher, info, info.container, info.screenId, lp.cellX,
                        lp.cellY, lp.cellHSpan, lp.cellVSpan);
            }
        }
        this.mWidgetView.requestLayout();
        return true;
    }

    private void resizeWidgetIfNeeded(boolean onDismiss) {
        if (resizeFreeform(onDismiss)) {
            return;
        }
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
        // The widget and what it pushed aside lie wholly in the page (PageFit)
        mCellLayout.resolveOverlappingItems("widget resized");
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
        int newWidth;
        int newHeight;
        int newX;
        int newY;

        int[] free = mCellLayout.freeformRect(mWidgetView);
        if (free != null) {
            // A widget placed freely: round its frame, the rectangle it is seen in (FreeformLayout), not round the view's
            // place, which is the old one until the page has laid it out again after a drop
            mTmpPt[0] = free[0];
            mTmpPt[1] = free[1];
            mDragLayer.getDescendantCoordRelativeToSelf(mCellLayout.getShortcutsAndWidgets(), mTmpPt);
            newX = mTmpPt[0] - mBackgroundPadding;
            newY = mTmpPt[1] - mBackgroundPadding;
            newWidth = free[2] + 2 * mBackgroundPadding;
            newHeight = free[3] + 2 * mBackgroundPadding;
        } else if (mWidgetView instanceof LauncherAppWidgetHostView) {
            final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) mWidgetView;
            if (LauncherAppWidgetHostView.isScaled(hostView)) {
                float scale = hostView.getScaleToFit();
                
                // Get actual scaled dimensions of the widget
                int scaledWidth = (int) (mWidgetView.getWidth() * scale);
                int scaledHeight = (int) (mWidgetView.getHeight() * scale);
                
                // Use the same coordinate calculation method as non-resizable widgets
                mTmpPt[0] = mWidgetView.getLeft();
                mTmpPt[1] = mWidgetView.getTop();
                mDragLayer.getDescendantCoordRelativeToSelf(mCellLayout.getShortcutsAndWidgets(), mTmpPt);
                
                // Position frame to match the widget position exactly
                newX = mTmpPt[0] - mBackgroundPadding;
                newY = mTmpPt[1] - mBackgroundPadding;
                newWidth = scaledWidth + 2 * mBackgroundPadding;
                newHeight = scaledHeight + 2 * mBackgroundPadding;              
            } else {
                newWidth = ((mWidgetView.getWidth() + (mBackgroundPadding * 2)) - mWidgetPaddingLeft - mWidgetPaddingRight);
                newHeight = ((mWidgetView.getHeight() + (mBackgroundPadding * 2)) - mWidgetPaddingTop - mWidgetPaddingBottom);

                mTmpPt[0] = mWidgetView.getLeft();
                mTmpPt[1] = mWidgetView.getTop();
                mDragLayer.getDescendantCoordRelativeToSelf(mCellLayout.getShortcutsAndWidgets(), mTmpPt);
                newX = (mTmpPt[0] - mBackgroundPadding) + mWidgetPaddingLeft;
                newY = (mTmpPt[1] - mBackgroundPadding) + mWidgetPaddingTop;                
            }
        } else {
            newWidth = ((mWidgetView.getWidth() + (mBackgroundPadding * 2)) - mWidgetPaddingLeft - mWidgetPaddingRight);
            newHeight = ((mWidgetView.getHeight() + (mBackgroundPadding * 2)) - mWidgetPaddingTop - mWidgetPaddingBottom);

            mTmpPt[0] = mWidgetView.getLeft();
            mTmpPt[1] = mWidgetView.getTop();
            mDragLayer.getDescendantCoordRelativeToSelf(mCellLayout.getShortcutsAndWidgets(), mTmpPt);
            newX = (mTmpPt[0] - mBackgroundPadding) + mWidgetPaddingLeft;
            newY = (mTmpPt[1] - mBackgroundPadding) + mWidgetPaddingTop;
        }

        // Adjust touch regions if near edges: the part of the frame past the screen cannot be
        // touched, so its border regions move in by that much (both axes alike).
        if (newX < 0) {
            mLeftTouchRegionAdjustment = -newX;
        } else {
            mLeftTouchRegionAdjustment = 0;
        }
        if (newX + newWidth > mDragLayer.getWidth()) {
            mRightTouchRegionAdjustment = -((newX + newWidth) - mDragLayer.getWidth());
        } else {
            mRightTouchRegionAdjustment = 0;
        }
        if (newY < 0) {
            mTopTouchRegionAdjustment = -newY;
        } else {
            mTopTouchRegionAdjustment = 0;
        }
        if (newY + newHeight > mDragLayer.getHeight()) {
            mBottomTouchRegionAdjustment = -((newY + newHeight) - mDragLayer.getHeight());
        } else {
            mBottomTouchRegionAdjustment = 0;
        }

        if (!animate) {
            lp.width = newWidth;
            lp.height = newHeight;
            lp.x = newX;
            lp.y = newY;
            mLeftHandle.setAlpha(1.0f);
            mRightHandle.setAlpha(1.0f);
            mTopHandle.setAlpha(1.0f);
            mBottomHandle.setAlpha(1.0f);
            requestLayout();
            return;
        }

        PropertyValuesHolder width = PropertyValuesHolder.ofInt("width", lp.width, newWidth);
        PropertyValuesHolder height = PropertyValuesHolder.ofInt("height", lp.height, newHeight);
        PropertyValuesHolder x = PropertyValuesHolder.ofInt("x", lp.x, newX);
        PropertyValuesHolder y = PropertyValuesHolder.ofInt("y", lp.y, newY);
        ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(lp, this, width, height, x, y);
        ObjectAnimator leftOa = LauncherAnimUtils.ofFloat(mLeftHandle, "alpha", 1.0f);
        ObjectAnimator rightOa = LauncherAnimUtils.ofFloat(mRightHandle, "alpha", 1.0f);
        ObjectAnimator topOa = LauncherAnimUtils.ofFloat(mTopHandle, "alpha", 1.0f);
        ObjectAnimator bottomOa = LauncherAnimUtils.ofFloat(mBottomHandle, "alpha", 1.0f);
        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                requestLayout();
            }
        });
        AnimatorSet set = LauncherAnimUtils.createAnimatorSet();
        set.playTogether(oa, leftOa, rightOa, topOa, bottomOa);
        set.setDuration(150L);
        set.start();
    }
}
