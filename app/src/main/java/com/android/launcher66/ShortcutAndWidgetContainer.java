package com.android.launcher66;

import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
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
    private float widgetScaleFactor = 1.75f;

    public ShortcutAndWidgetContainer(Context context) {
        super(context);
        mContext = context;
        mLauncher = Launcher.getLauncher();
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

    public void setupLp(CellLayout.LayoutParams lp, View child) {
        if (child instanceof LauncherAppWidgetHostView) {
            final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) child;
            AppWidgetProviderInfo pinfo = hostView.getAppWidgetInfo();
            if (pinfo != null && pinfo.resizeMode == AppWidgetProviderInfo.RESIZE_NONE) {
                lp.setup(mCellWidth, mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
            } else {
                // Resizable widgets have their own scale
                lp.setup(mCellWidth, mCellHeight, invertLayoutHorizontally(), mCountX, widgetScaleFactor, widgetScaleFactor);                   
            }
        } else {
            lp.setup(this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
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
        if (!lp.isFullscreen) {
            final DeviceProfile profile = mLauncher.getDeviceProfile();

            if (child instanceof LauncherAppWidgetHostView) {
                final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) child;
                AppWidgetProviderInfo pinfo = hostView.getAppWidgetInfo();
                if (pinfo != null && pinfo.resizeMode == AppWidgetProviderInfo.RESIZE_NONE) {
                    lp.setup(mCellWidth, mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
                } else {
                    // Resizable widgets have their own scale  
                    lp.setup(mCellWidth, mCellHeight, invertLayoutHorizontally(), mCountX, widgetScaleFactor, widgetScaleFactor);                
                }
            } else {
                LauncherAppState app = LauncherAppState.getInstance();
                DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
                lp.setup(mCellWidth, mCellHeight, this.mWidthGap, this.mHeightGap, invertLayoutHorizontally(), this.mCountX);
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

                if (child instanceof LauncherAppWidgetHostView) {
                    final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) child;
                    AppWidgetProviderInfo pinfo = hostView.getAppWidgetInfo();
                    if (pinfo != null && pinfo.resizeMode != AppWidgetProviderInfo.RESIZE_NONE) {
                        LauncherAppWidgetHostView lahv = (LauncherAppWidgetHostView) child;

                        // Scale and center the widget to fit within its cells.
                        float scaleX = widgetScaleFactor;
                        float scaleY = widgetScaleFactor;

                        Rect p = AppWidgetHostView.getDefaultPaddingForWidget(mContext, hostView.getAppWidgetInfo().provider, null);
                        float density = this.mLauncher.getResources().getDisplayMetrics().density;
                        int mBackgroundPadding = (int) Math.ceil(24.0f * density);

                        lahv.setScaleToFit(Math.min(scaleX, scaleY));
                        lahv.setTranslationForCentering(-(lp.width - (lp.width * scaleX)) / 2.0f,
                                (-(lp.height - (lp.height * scaleY)) / 2.0f) + (mBackgroundPadding / 2.0f));
                    }
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
