package com.android.launcher66;

import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class ShortcutAndWidgetContainer extends ViewGroup {
    static final String TAG = "CellLayoutChildren";
    private int mCellHeight;
    private int mCellWidth;
    private int mCountX;
    private int mCountY;
    private int mHeightGap;
    private boolean mInvertIfRtl;
    private boolean mIsHotseatLayout;
    private final int[] mTmpCellXY;
    private final WallpaperManager mWallpaperManager;
    private int mWidthGap;
    private Launcher mLauncher;
    private Context mContext;
    private final float widgetScaleFactor = ScreenScale.widgetScale();

    private boolean mRowPadding = true;

    void setRowPadding(boolean rowPadding) {
        mRowPadding = rowPadding;
    }

    /** The size of the icons of this page (IconFit); 0 leaves every icon at its standard size. */
    private int mFitIconPx;

    /** The size this page gives its icons, 0 for the standard one (a folder that follows the home screen asks it). */
    int fitIconPx() {
        return mFitIconPx;
    }

    /** The page's size for its icons, smaller than the standard one where a denser grid needs it (IconFit). */
    void setFitIconPx(int px) {
        if (px != mFitIconPx) {
            mFitIconPx = px;
            requestLayout();
        }
    }

    /** Where the first cell lies in this container: beside a bar at the left, below one at the top (WorkspaceGrid). */
    private int mGridOffsetX;
    private int mGridOffsetY;

    /**
     * The bars' strips at the left and at the top of the page. The container itself keeps the whole page,
     * because the launcher's own elements are placed in it by pixels; only the cells start further in.
     */
    void setGridOffset(int x, int y) {
        if (x != mGridOffsetX || y != mGridOffsetY) {
            mGridOffsetX = x;
            mGridOffsetY = y;
            requestLayout();
        }
    }

    /**
     * The same, from the page's own measure, just before it measures this container: the container is measured
     * again (its children's places are computed there), without asking the whole window for another pass.
     */
    void setGridOffsetWhileMeasuring(int x, int y) {
        if (x != mGridOffsetX || y != mGridOffsetY) {
            mGridOffsetX = x;
            mGridOffsetY = y;
            forceLayout();
        }
    }

    public ShortcutAndWidgetContainer(Context context) {
        super(context);
        mContext = context;
        mLauncher = (Launcher) context;
        this.mTmpCellXY = new int[2];
        this.mInvertIfRtl = false;
        this.mWallpaperManager = WallpaperManager.getInstance(context);
        setChildrenDrawingOrderEnabled(true);
    }

    /** The order the children are drawn and touched in, computed when asked for; null when it has to be (see getChildDrawingOrder). */
    private int[] mDrawOrder;

    /** The widgets came or went, or "Allow widgets to overlap" changed: the order is worked out again. */
    void invalidateDrawOrder() {
        mDrawOrder = null;
        invalidate();
    }

    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        mDrawOrder = null;
    }

    @Override
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        mDrawOrder = null;
    }

    /**
     * With "Allow widgets to overlap" the widgets are drawn over the icons and folders, and so take the touch first (a view's
     * touch is offered to the child drawn last); in each kind the order of adding is kept. Without it, the order is the
     * children's own.
     */
    @Override
    protected int getChildDrawingOrder(int childCount, int drawingPosition) {
        int[] order = mDrawOrder;
        if (order == null || order.length != childCount) {
            order = new int[childCount];
            boolean widgetsOnTop = FreeformWidgets.overlapOn(getContext());
            int next = 0;
            if (widgetsOnTop) {
                for (int i = 0; i < childCount; i++) {
                    if (!(getChildAt(i) instanceof LauncherAppWidgetHostView)) {
                        order[next++] = i;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    if (getChildAt(i) instanceof LauncherAppWidgetHostView) {
                        order[next++] = i;
                    }
                }
            } else {
                for (int i = 0; i < childCount; i++) {
                    order[i] = i;
                }
            }
            mDrawOrder = order;
        }
        return order[drawingPosition];
    }

    public void setCellDimensions(int cellWidth, int cellHeight, int widthGap, int heightGap, int countX, int countY) {
        this.mCellWidth = cellWidth;
        this.mCellHeight = cellHeight;
        this.mWidthGap = widthGap;
        this.mHeightGap = heightGap;
        this.mCountX = countX;
        this.mCountY = countY;
    }

    public View getChildAt(int x, int y) {
        int count = getChildCount();
        CellLayout parent = getParent() instanceof CellLayout ? (CellLayout) getParent() : null;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (parent != null && !parent.takesCells(child)) {
                continue;   // the statistics window: what lies in the cell is the icon under it
            }
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();
            if (lp.cellX <= x && x < lp.cellX + lp.cellHSpan && lp.cellY <= y && y < lp.cellY + lp.cellVSpan) {
                return child;
            }
        }
        return null;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSpecSize, heightSpecSize);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                measureChild(child);
            }
        }
    }

    /**
     * The pixels {x, y, width, height} that the cells {cellX, cellY} spanning spanX x spanY have in this container, as an item
     * in those cells is laid out (the area a freely placed widget is limited to, FreeformWidgets).
     */
    int[] cellAreaRect(int cellX, int cellY, int spanX, int spanY) {
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(cellX, cellY, spanX, spanY);
        lp.rowPadding = mRowPadding;
        lp.setup(this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
        keepInGrid(lp);
        offsetToGrid(lp);
        return new int[] {lp.x, lp.y, lp.width, lp.height};
    }

    /** A widget placed freely has the pixels of its frame, whatever its cells are (FreeformWidgets). */
    private void applyFreeform(CellLayout parent, View child, CellLayout.LayoutParams lp) {
        int[] rect = parent == null ? null : parent.freeformRect(child);
        if (rect != null) {
            lp.x = rect[0];
            lp.y = rect[1];
            lp.width = rect[2];
            lp.height = rect[3];
        }
    }

    public void setupLp(CellLayout.LayoutParams lp, View child) {
        CellLayout parent = (CellLayout) getParent();
        applyFreeform(parent, child, lp);

        // Check if this is a user widget - preserve exact positioning
        if (parent != null && parent.isPixelPlaced(child)) {
            // For user widgets, preserve the exact position and size
            int[] position = parent.getUserWidgetPosition(child);
            if (position != null) {
                lp.x = position[0];
                lp.y = position[1];
                lp.width = position[2];
                lp.height = position[3];
            }
            // Don't recalculate based on cells for user widgets
            return;
        }
        
        // Normal setup for other views
        if (LauncherAppWidgetHostView.isScaled(child)) {
            // Widgets have their own scale
            lp.rowPadding = mRowPadding;
            lp.setup(mCellWidth, mCellHeight, invertLayoutHorizontally(), mCountX, widgetScaleFactor, widgetScaleFactor);
        } else {
            lp.rowPadding = mRowPadding;
            lp.setup(this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
            keepInGrid(lp);
        }
        offsetToGrid(lp);
    }

    /**
     * After setup() from cells, before the offset: the padding of the first rows draws an item lower, and one that
     * reaches the last row would reach past the grid by it (PageFit.heightInGrid()).
     */
    private void keepInGrid(CellLayout.LayoutParams lp) {
        if (!lp.isLockedToGrid || mCountY <= 0) {
            return;
        }
        int gridBottom = mCountY * mCellHeight + (mCountY - 1) * mHeightGap;
        lp.height = PageFit.heightInGrid(lp.y, lp.height, lp.rowPaddingApplied, gridBottom);
    }

    /** After every setup() from cells: setup() counts from the container's corner, the cells start beside the bars. */
    private void offsetToGrid(CellLayout.LayoutParams lp) {
        if (lp.isLockedToGrid) {
            lp.x += mGridOffsetX;
            lp.y += mGridOffsetY;
        }
    }

    public void setInvertIfRtl(boolean invert) {
        this.mInvertIfRtl = invert;
    }

    public void setIsHotseat(boolean isHotseat) {
        this.mIsHotseatLayout = isHotseat;
    }

    int getCellContentWidth() {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        return Math.min(getMeasuredHeight(), this.mIsHotseatLayout ? grid.hotseatCellWidthPx : grid.cellWidthPx);
    }

    int getCellContentHeight() {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        return Math.min(getMeasuredHeight(), this.mIsHotseatLayout ? grid.hotseatCellHeightPx : grid.cellHeightPx);
    }

    private boolean invertLayoutHorizontally() {
        return this.mInvertIfRtl && isLayoutRtl();
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    public void measureChild(View child) {
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();
        CellLayout parent = (CellLayout) getParent();
        applyFreeform(parent, child, lp);

        // Check if this is a user widget (or one placed freely) - preserve exact sizing
        if (parent != null && parent.isPixelPlaced(child)) {
            // Use the exact width and height already set
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            int childheightMeasureSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
            child.measure(childWidthMeasureSpec, childheightMeasureSpec);
            return;
        }
        
        // Normal measurement for other views
        if (!lp.isFullscreen) {
            final DeviceProfile profile = mLauncher.getDeviceProfile();

            if (LauncherAppWidgetHostView.isScaled(child)) {
                // Widgets have their own scale
                lp.rowPadding = mRowPadding;
                lp.setup(mCellWidth, mCellHeight, invertLayoutHorizontally(), mCountX, widgetScaleFactor, widgetScaleFactor);
                offsetToGrid(lp);
            } else {
                LauncherAppState app = LauncherAppState.getInstance();
                DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
                lp.rowPadding = mRowPadding;
                lp.setup(mCellWidth, mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
                keepInGrid(lp);
                offsetToGrid(lp);
                // The icon in the size its page has for it, before the child is measured (IconFit)
                if (!mIsHotseatLayout) {
                    if (child instanceof BubbleTextView) {
                        ((BubbleTextView) child).setFitIconPx(mFitIconPx);
                    } else if (child instanceof FolderIcon) {
                        ((FolderIcon) child).setFitIconPx(mFitIconPx, Utilities.sIconTextureWidth);
                    }
                }
                int cHeight = getCellContentHeight();
                int cellPaddingY = (int) Math.max(0.0f, (lp.height - cHeight) / 2.0f);
                int cellPaddingX = (int) (grid.edgeMarginPx / 2.0f);
                child.setPadding(cellPaddingX, cellPaddingY, cellPaddingX, 0);
            }
        } else {
            lp.x = 0;
            lp.y = 0;
            lp.width = getMeasuredWidth();
            lp.height = getMeasuredHeight();
        }
        int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
        int childheightMeasureSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
        child.measure(childWidthMeasureSpec, childheightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();

                CellLayout parent = (CellLayout) getParent();
                applyFreeform(parent, child, lp);
                if (parent != null && parent.isPixelPlaced(child)) {
                    // Use the exact stored position
                    int childLeft = lp.x;
                    int childTop = lp.y;
                    child.layout(childLeft, childTop, childLeft + lp.width, childTop + lp.height);
                    continue;
                }

                if (LauncherAppWidgetHostView.isScaled(child)) {
                    LauncherAppWidgetHostView lahv = (LauncherAppWidgetHostView) child;

                    // Scale and center the widget to fit within its cells: scaled about its
                    // centre, then moved back so it starts at the top left of its cells.
                    float scaleX = widgetScaleFactor;
                    float scaleY = widgetScaleFactor;

                    lahv.setScaleToFit(Math.min(scaleX, scaleY));
                    lahv.setTranslationForCentering(-(lp.width - (lp.width * scaleX)) / 2.0f,
                            -(lp.height - (lp.height * scaleY)) / 2.0f);
                }

                int childLeft = lp.x;
                int childTop = lp.y;
                child.layout(childLeft, childTop, childLeft + lp.width, childTop + lp.height);

                if (lp.dropped) {
                    lp.dropped = false;

                    final int[] cellXY = mTmpCellXY;
                    getLocationOnScreen(cellXY);
                    mWallpaperManager.sendWallpaperCommand(getWindowToken(),
                            WallpaperManager.COMMAND_DROP,
                            cellXY[0] + childLeft + lp.width / 2,
                            cellXY[1] + childTop + lp.height / 2, 0, null);
                }
            }
        }
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (child != null) {
            Rect r = new Rect();
            child.getDrawingRect(r);
            requestRectangleOnScreen(r);
        }
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.cancelLongPress();
        }
    }

    @Override
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            view.setDrawingCacheEnabled(enabled);
            if (!view.isHardwareAccelerated() && enabled) {
                view.buildDrawingCache(true);
            }
        }
    }

    @Override
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        super.setChildrenDrawnWithCacheEnabled(enabled);
    }
}
