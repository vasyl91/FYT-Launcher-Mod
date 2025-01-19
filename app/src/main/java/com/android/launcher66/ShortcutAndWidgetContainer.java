package com.android.launcher66;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.android.launcher66.CellLayout;

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

    public ShortcutAndWidgetContainer(Context context) {
        super(context);
        this.mTmpCellXY = new int[2];
        this.mInvertIfRtl = false;
        this.mWallpaperManager = WallpaperManager.getInstance(context);
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
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
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

    public void setupLp(CellLayout.LayoutParams lp) {
        lp.setup(this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
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

    public void measureChild(View child) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        int cellWidth = this.mCellWidth;
        int cellHeight = this.mCellHeight;
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();
        if (!lp.isFullscreen) {
            lp.setup(cellWidth, cellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
            if (!(child instanceof LauncherAppWidgetHostView)) {
                int cHeight = getCellContentHeight();
                int cellPaddingY = (int) Math.max(0.0f, (lp.height - cHeight) / 2.0f);
                int cellPaddingX = (int) (grid.edgeMarginPx / 2.0f);
                child.setPadding(cellPaddingX, LauncherApplication.sApp.getResources().getInteger(R.integer.image_cell_top) + cellPaddingY, cellPaddingX, 0);
            }
        } else {
            lp.x = 0;
            lp.y = 0;
            lp.width = getMeasuredWidth();
            lp.height = getMeasuredHeight();
        }
        int childWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
        int childheightMeasureSpec = View.MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
        child.measure(childWidthMeasureSpec, childheightMeasureSpec);
    }

    private boolean invertLayoutHorizontally() {
        return this.mInvertIfRtl && isLayoutRtl();
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                CellLayout.LayoutParams lp = (CellLayout.LayoutParams) child.getLayoutParams();
                int childLeft = lp.x;
                int childTop = lp.y;
                child.layout(childLeft, childTop, lp.width + childLeft, lp.height + childTop);
                if (lp.dropped) {
                    lp.dropped = false;
                    int[] cellXY = this.mTmpCellXY;
                    getLocationOnScreen(cellXY);
                    this.mWallpaperManager.sendWallpaperCommand(getWindowToken(), "android.home.drop", cellXY[0] + childLeft + (lp.width / 2), cellXY[1] + childTop + (lp.height / 2), 0, null);
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
