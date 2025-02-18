package com.android.launcher66;

import static android.content.Context.MODE_PRIVATE;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.SettingsActivity;
import com.android.recycler.AppListBean;
import com.syu.util.JLog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import share.Config;

public class AppsCustomizePagedView extends PagedViewWithDraggableItems implements View.OnClickListener, View.OnKeyListener, DragSource, PagedViewIcon.PressedCallback, PagedViewWidget.ShortPressListener, LauncherTransitionable {
    private static final boolean PERFORM_OVERSCROLL_ROTATION = true;
    static final int WIDGET_BOUND = 1;
    static final int WIDGET_INFLATED = 2;
    static final int WIDGET_NO_CLEANUP_REQUIRED = -1;
    static final int WIDGET_PRELOAD_PENDING = 0;
    static final int sLookAheadPageCount = 2;
    static final int sLookBehindPageCount = 2;
    private static final int sPageSleepDelay = 200;
    private Handler handler;
    private AccelerateInterpolator mAlphaInterpolator;
    private ArrayList<AppInfo> mApps;
    private Runnable mBindWidgetRunnable;
    CanvasCache mCachedAppWidgetPreviewCanvas;
    RectCache mCachedAppWidgetPreviewDestRect;
    PaintCache mCachedAppWidgetPreviewPaint;
    RectCache mCachedAppWidgetPreviewSrcRect;
    BitmapCache mCachedShortcutPreviewBitmap;
    CanvasCache mCachedShortcutPreviewCanvas;
    PaintCache mCachedShortcutPreviewPaint;
    private Canvas mCanvas;
    private int mClingFocusedX;
    private int mClingFocusedY;
    private int mContentHeight;
    private ContentType mContentType;
    private int mContentWidth;
    PendingAddWidgetInfo mCreateWidgetInfo;
    private ArrayList<Runnable> mDeferredPrepareLoadWidgetPreviewsTasks;
    private ArrayList<AsyncTaskPageData> mDeferredSyncWidgetPageItems;
    private DragController mDragController;
    private boolean mDraggingWidget;
    private boolean mHasShownAllAppsCling;
    private IconCache mIconCache;
    private boolean mInBulkBind;
    private boolean mInTransition;
    private Runnable mInflateWidgetRunnable;
    private Launcher mLauncher;
    private final LayoutInflater mLayoutInflater;
    private DecelerateInterpolator mLeftScreenAlphaInterpolator;
    private boolean mNeedToUpdatePageCountsAndInvalidateData;
    private int mNumAppsPages;
    private int mNumWidgetPages;
    private final PackageManager mPackageManager;
    private PagedViewIcon mPressedIcon;
    ArrayList<AppsCustomizeAsyncTask> mRunningTasks;
    private int mSaveInstanceStateItemIndex;
    private Rect mTmpRect;
    int mWidgetCleanupState;
    private int mWidgetCountX;
    private int mWidgetCountY;
    private int mWidgetHeightGap;
    private Toast mWidgetInstructionToast;
    int mWidgetLoadingId;
    WidgetPreviewLoader mWidgetPreviewLoader;
    private PagedViewCellLayout mWidgetSpacingLayout;
    private int mWidgetWidthGap;
    private ArrayList<Object> mWidgets;
    Workspace.ZInterpolator mZInterpolator;
    private static float CAMERA_DISTANCE = 6500.0f;
    private static float TRANSITION_SCALE_FACTOR = 0.74f;
    private static float TRANSITION_PIVOT = 0.65f;
    private static float TRANSITION_MAX_ROTATION = 22.0f;
    public static boolean DISABLE_ALL_APPS = LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_all_disable);
    private static String[] containsWidgets = {"com.syu.widget.DateTimeProvider", "com.syu.music.MAppWidget"};
    public static final String STATS_APP_FOREGROUND = "stats.app.foreground";
    public static PagedViewIcon icon;
    private Helpers helpers = new Helpers();

    public enum ContentType {
        Applications,
        Widgets;

        public static ContentType[] valuesCustom() {
            ContentType[] valuesCustom = values();
            int length = valuesCustom.length;
            ContentType[] contentTypeArr = new ContentType[length];
            System.arraycopy(valuesCustom, 0, contentTypeArr, 0, length);
            return contentTypeArr;
        }
    }

    public AppsCustomizePagedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContentType = ContentType.Applications;
        this.handler = new Handler(Looper.getMainLooper());
        this.mSaveInstanceStateItemIndex = -1;
        this.mZInterpolator = new Workspace.ZInterpolator(0.5f);
        this.mAlphaInterpolator = new AccelerateInterpolator(0.9f);
        this.mLeftScreenAlphaInterpolator = new DecelerateInterpolator(4.0f);
        this.mInflateWidgetRunnable = null;
        this.mBindWidgetRunnable = null;
        this.mWidgetCleanupState = -1;
        this.mWidgetLoadingId = -1;
        this.mCreateWidgetInfo = null;
        this.mDraggingWidget = false;
        this.mDeferredSyncWidgetPageItems = new ArrayList<>();
        this.mDeferredPrepareLoadWidgetPreviewsTasks = new ArrayList<>();
        this.mTmpRect = new Rect();
        this.mCachedShortcutPreviewBitmap = new BitmapCache();
        this.mCachedShortcutPreviewPaint = new PaintCache();
        this.mCachedShortcutPreviewCanvas = new CanvasCache();
        this.mCachedAppWidgetPreviewCanvas = new CanvasCache();
        this.mCachedAppWidgetPreviewSrcRect = new RectCache();
        this.mCachedAppWidgetPreviewDestRect = new RectCache();
        this.mCachedAppWidgetPreviewPaint = new PaintCache();
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mPackageManager = context.getPackageManager();
        this.mApps = new ArrayList<>();
        this.mWidgets = new ArrayList<>();
        this.mIconCache = LauncherAppState.getInstance().getIconCache();
        this.mCanvas = new Canvas();
        this.mRunningTasks = new ArrayList<>();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AppsCustomizePagedView, 0, 0);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        int i = grid.edgeMarginPx;
        this.mWidgetHeightGap = i;
        this.mWidgetWidthGap = i;
        this.mWidgetCountX = a.getInt(R.styleable.AppsCustomizePagedView_widgetCountX, 2);
        this.mWidgetCountY = a.getInt(R.styleable.AppsCustomizePagedView_widgetCountY, 2);
        this.mClingFocusedX = a.getInt(R.styleable.AppsCustomizePagedView_clingFocusedX, 0);
        this.mClingFocusedY = a.getInt(R.styleable.AppsCustomizePagedView_clingFocusedY, 0);
        a.recycle();
        this.mWidgetSpacingLayout = new PagedViewCellLayout(getContext());
        this.mFadeInAdjacentScreens = false;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setClipChildren(false);
    }

    @Override
    protected void init() {
        super.init();
        this.mCenterPagesVertically = false;
        Context context = getContext();
        Resources r = context.getResources();
        setDragSlopeThreshold(r.getInteger(R.integer.config_appsCustomizeDragSlopeThreshold) / 100.0f);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        app.getDynamicGrid().getDeviceProfile();
    }

    private int getMiddleComponentIndexOnCurrentPage() {
        if (getPageCount() <= 0) {
            return -1;
        }
        int currentPage = getCurrentPage();
        if (LauncherAppState.appsWidgetsDetach) {
            if (this.mContentType == ContentType.Applications) {
                AppsCustomizeCellLayout layout = (AppsCustomizeCellLayout) getPageAt(currentPage);
                ShortcutAndWidgetContainer childrenLayout = layout.getShortcutsAndWidgets();
                int numItemsPerPage = this.mCellCountX * this.mCellCountY;
                int childCount = childrenLayout.getChildCount();
                if (childCount <= 0) {
                    return -1;
                }
                int i = (currentPage * numItemsPerPage) + (childCount / 2);
                return i;
            }
            if (this.mContentType == ContentType.Widgets) {
                int numApps = this.mApps.size();
                PagedViewGridLayout layout2 = (PagedViewGridLayout) getPageAt(currentPage);
                int numItemsPerPage2 = this.mWidgetCountX * this.mWidgetCountY;
                int childCount2 = layout2.getChildCount();
                if (childCount2 <= 0) {
                    return -1;
                }
                int i2 = (currentPage * numItemsPerPage2) + numApps + (childCount2 / 2);
                return i2;
            }
            throw new RuntimeException("Invalid ContentType");
        }
        if (currentPage < this.mNumAppsPages) {
            AppsCustomizeCellLayout layout3 = (AppsCustomizeCellLayout) getPageAt(currentPage);
            ShortcutAndWidgetContainer childrenLayout2 = layout3.getShortcutsAndWidgets();
            int numItemsPerPage3 = this.mCellCountX * this.mCellCountY;
            int childCount3 = childrenLayout2.getChildCount();
            if (childCount3 <= 0) {
                return -1;
            }
            int i3 = (currentPage * numItemsPerPage3) + (childCount3 / 2);
            return i3;
        }
        int numApps2 = this.mApps.size();
        PagedViewGridLayout layout4 = (PagedViewGridLayout) getPageAt(currentPage);
        int numItemsPerPage4 = this.mWidgetCountX * this.mWidgetCountY;
        int childCount4 = layout4.getChildCount();
        if (childCount4 <= 0) {
            return -1;
        }
        int i4 = ((currentPage - this.mNumAppsPages) * numItemsPerPage4) + numApps2 + (childCount4 / 2);
        return i4;
    }

    int getSaveInstanceStateIndex() {
        if (this.mSaveInstanceStateItemIndex == -1) {
            this.mSaveInstanceStateItemIndex = getMiddleComponentIndexOnCurrentPage();
        }
        return this.mSaveInstanceStateItemIndex;
    }

    int getPageForComponent(int index) {
        if (index < 0) {
            return 0;
        }
        if (LauncherAppState.appsWidgetsDetach) {
            if (index < this.mApps.size()) {
                return index / (this.mCellCountX * this.mCellCountY);
            }
            return (index - this.mApps.size()) / (this.mWidgetCountX * this.mWidgetCountY);
        }
        if (index < this.mApps.size()) {
            return index / (this.mCellCountX * this.mCellCountY);
        }
        int numItemsPerPage = this.mWidgetCountX * this.mWidgetCountY;
        return DISABLE_ALL_APPS ? (index - this.mApps.size()) / numItemsPerPage : this.mNumAppsPages + ((index - this.mApps.size()) / numItemsPerPage);
    }

    void restorePageForIndex(int index) {
        if (index >= 0) {
            this.mSaveInstanceStateItemIndex = index;
        }
    }

    private void updatePageCounts() {
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.iswidgetpages)) {
            mNumWidgetPages = (int) Math.ceil(mWidgets.size() / (float) (mWidgetCountX * mWidgetCountY));
        } else {
            this.mNumWidgetPages = 0;
        }
        mNumAppsPages = (int) Math.ceil((float) mApps.size() / (mCellCountX * mCellCountY));
    }

    protected void onDataReady(int width, int height) {
        if (this.mWidgetPreviewLoader == null) {
            this.mWidgetPreviewLoader = new WidgetPreviewLoader(this.mLauncher);
        }
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        this.mWidgetSpacingLayout.setPadding(this.mPageLayoutPaddingLeft, this.mPageLayoutPaddingTop, this.mPageLayoutPaddingRight, this.mPageLayoutPaddingBottom);
        this.mCellCountX = grid.allAppsNumCols;
        this.mCellCountY = grid.allAppsNumRows;
        updatePageCounts();
        this.mContentWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mContentHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        Log.i("hy", "mContentWidth1111111:" + getMeasuredWidth() + "mContentHeight:" + getMeasuredHeight());
        int widthSpec = View.MeasureSpec.makeMeasureSpec(this.mContentWidth, MeasureSpec.AT_MOST);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, MeasureSpec.AT_MOST);
        this.mWidgetSpacingLayout.measure(widthSpec, heightSpec);
        AppsCustomizeTabHost host = getTabHost();
        boolean hostIsTransitioning = host.isTransitioning();
        int page = getPageForComponent(this.mSaveInstanceStateItemIndex);
        invalidatePageData(Math.max(0, page), hostIsTransitioning);
        if (!hostIsTransitioning) {
            post(new Runnable() { 
                @Override
                public void run() {
                    AppsCustomizePagedView.this.showAllAppsCling();
                }
            });
        }
    }

    void showAllAppsCling() {    
        if (!this.mHasShownAllAppsCling && isDataReady()) {
            this.mHasShownAllAppsCling = true;
            int[] offset = new int[2];
            int[] pos = this.mWidgetSpacingLayout.estimateCellPosition(this.mClingFocusedX, this.mClingFocusedY);
            this.mLauncher.getDragLayer().getLocationInDragLayer(this, offset);
            pos[0] = pos[0] + ((getMeasuredWidth() - this.mWidgetSpacingLayout.getMeasuredWidth()) / 2) + offset[0];
            pos[1] = pos[1] + (offset[1] - this.mLauncher.getDragLayer().getPaddingTop());
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        if (!isDataReady() && ((DISABLE_ALL_APPS || !this.mApps.isEmpty()) && !this.mWidgets.isEmpty())) {
            setDataIsReady();
            setMeasuredDimension(width, height);
            onDataReady(width, height);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private boolean isFilterWidgets(String appName) {
        for (int i = 0; i < containsWidgets.length; i++) {
            if (appName.contains(containsWidgets[i])) {
                return true;
            }
        }
        return false;
    }

    public void onPackagesUpdated(ArrayList<Object> widgetsAndShortcuts) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();

        // Get the list of widgets and shortcuts
        mWidgets.clear();
        for (Object o : widgetsAndShortcuts) {
            if (o instanceof AppWidgetProviderInfo) {
                AppWidgetProviderInfo widget = (AppWidgetProviderInfo) o;
                if (app.shouldShowAppOrWidgetProvider(widget.provider) && !isFilterWidgets(widget.provider.getClassName()) && (Config.CUSTOMER_ID != 8 || (!widget.provider.getPackageName().contains("antutu") && !widget.provider.getPackageName().contains("ludashi"))))  {
                    if (widget.minWidth > 0 && widget.minHeight > 0) {
                        int[] spanXY = Launcher.getSpanForWidget(this.mLauncher, widget);
                        int[] minSpanXY = Launcher.getMinSpanForWidget(this.mLauncher, widget);
                        int minSpanX = Math.min(spanXY[0], minSpanXY[0]);
                        int minSpanY = Math.min(spanXY[1], minSpanXY[1]);
                        if (minSpanX <= ((int) grid.numColumns) && minSpanY <= ((int) grid.numRows)) {
                            Boolean bFlag = true;
                            if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_design) && widget.provider.getPackageName() != null && widget.provider.getPackageName().contains("com.android.launcher")) {
                                bFlag = false;
                            }
                            if (bFlag.booleanValue()) {
                                if (widget.provider.getPackageName().contains("com.android.launcher")) {
                                    int a = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_launcher_packagename);
                                    String widgetpackagename = "com.android.launcher" + a;
                                    if (widget.provider.getPackageName().contains(widgetpackagename)) {
                                        this.mWidgets.add(widget);
                                    }
                                } else {
                                    this.mWidgets.add(widget);
                                }
                            }
                        }
                    }
                } else {
                    Log.i("WIDGET", "Widget " + widget.provider + " has invalid dimensions (" +
                          widget.minWidth + ", " + widget.minHeight + ")");
                }
            } 
        }
        updatePageCountsAndInvalidateData();
    }

    public void setBulkBind(boolean bulkBind) {
        if (bulkBind) {
            this.mInBulkBind = true;
            return;
        }
        this.mInBulkBind = false;
        if (this.mNeedToUpdatePageCountsAndInvalidateData) {
            updatePageCountsAndInvalidateData();
        }
    }

    private void updatePageCountsAndInvalidateData() {
        if (this.mInBulkBind) {
            this.mNeedToUpdatePageCountsAndInvalidateData = true;
            return;
        }
        updatePageCounts();
        invalidateOnDataChange();
        this.mNeedToUpdatePageCountsAndInvalidateData = false;
    }

    @Override
    public void onClick(View v) {
        if (this.mLauncher.isAllAppsVisible() && !this.mLauncher.getWorkspace().isSwitchingState()) {
            if (v instanceof PagedViewIcon) {
                helpers.setInOverviewMode(false);
                helpers.setListOpen(false);
                AppInfo appInfo = (AppInfo) v.getTag();
                if (this.mPressedIcon != null) {
                    this.mPressedIcon.lockDrawableState();
                }
                this.mLauncher.startActivitySafely(v, appInfo.intent, appInfo);
                this.mLauncher.getStats().recordLaunch(appInfo.intent);
                AppListBean bean = new AppListBean(appInfo.title.toString(), appInfo.getPackageName(), appInfo.getClassName());
                if (appInfo.getClassName().equals("com.android.launcher66.settings.SettingsActivity")) {
                    Intent settingsIntent = new Intent(this.mLauncher, SettingsActivity.class);
                    this.mLauncher.startActivity(settingsIntent);
                }
                this.mLauncher.refreshLeftCycle(bean);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                boolean userLayout = prefs.getBoolean("user_layout", false);
                boolean userStats = prefs.getBoolean("user_stats", false);
                if (userLayout && userStats)  {
                    SharedPreferences statsPrefs = AppsCustomizePagedView.this.getContext().getSharedPreferences("AppStatsPrefs", MODE_PRIVATE);
                    Set<String> apps = new HashSet<>(statsPrefs.getStringSet("stats_apps", new HashSet<String>()));
                    if (apps.contains(appInfo.getPackageName())) {
                        Launcher.mAppsCustomizeTabHost.setVisibility(View.GONE);
                        helpers.setAllAppsShouldBVisible(true);
                        helpers.setForegroundAppOpened(true);
                        helpers.setInAllApps(false);
                        helpers.setInRecent(false);
                        Intent intent = new Intent(STATS_APP_FOREGROUND);
                        LauncherApplication.sApp.sendBroadcast(intent);
                    }                    
                }
                return;
            }
            if (v instanceof PagedViewWidget) {
                if (this.mWidgetInstructionToast != null) {
                    this.mWidgetInstructionToast.cancel();
                }
                this.mWidgetInstructionToast = Toast.makeText(getContext(), R.string.long_press_widget_to_add, Toast.LENGTH_SHORT);
                this.mWidgetInstructionToast.show();
                float offsetY = getResources().getDimensionPixelSize(R.dimen.dragViewOffsetY);
                ImageView p = (ImageView) v.findViewById(R.id.widget_preview);
                AnimatorSet bounce = LauncherAnimUtils.createAnimatorSet();
                ValueAnimator tyuAnim = LauncherAnimUtils.ofFloat(p, "translationY", offsetY);
                tyuAnim.setDuration(125L);
                ValueAnimator tydAnim = LauncherAnimUtils.ofFloat(p, "translationY", 0.0f);
                tydAnim.setDuration(100L);
                bounce.play(tyuAnim).before(tydAnim);
                bounce.setInterpolator(new AccelerateInterpolator());
                bounce.start();
            }
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleAppsCustomizeKeyEvent(v, keyCode, event);
    }

    @Override
    protected void determineDraggingStart(MotionEvent ev) {
    }

    private void beginDraggingApplication(View v) {
        this.mLauncher.getWorkspace().onDragStartedWithItem(v);
        this.mLauncher.getWorkspace().beginDragShared(v, this);
    }

    Bundle getDefaultOptionsForWidget(Launcher launcher, PendingAddWidgetInfo info) {
        AppWidgetResizeFrame.getWidgetSizeRanges(this.mLauncher, info.spanX, info.spanY, this.mTmpRect);
        Rect padding = AppWidgetHostView.getDefaultPaddingForWidget(this.mLauncher, info.componentName, null);
        float density = getResources().getDisplayMetrics().density;
        int xPaddingDips = (int) ((padding.left + padding.right) / density);
        int yPaddingDips = (int) ((padding.top + padding.bottom) / density);
        Bundle options = new Bundle();
        options.putInt("appWidgetMinWidth", this.mTmpRect.left - xPaddingDips);
        options.putInt("appWidgetMinHeight", this.mTmpRect.top - yPaddingDips);
        options.putInt("appWidgetMaxWidth", this.mTmpRect.right - xPaddingDips);
        options.putInt("appWidgetMaxHeight", this.mTmpRect.bottom - yPaddingDips);
        return options;
    }

    private void preloadWidget(final PendingAddWidgetInfo info) {
        final AppWidgetProviderInfo pInfo = info.info;
        final Bundle options = getDefaultOptionsForWidget(this.mLauncher, info);
        if (pInfo.configure != null) {
            info.bindOptions = options;
            return;
        }
        this.mWidgetCleanupState = 0;
        this.mBindWidgetRunnable = new Runnable() { 
            @Override
            public void run() {
                AppsCustomizePagedView.this.mWidgetLoadingId = AppsCustomizePagedView.this.mLauncher.getAppWidgetHost().allocateAppWidgetId();
                if (options == null) {
                    if (AppWidgetManager.getInstance(AppsCustomizePagedView.this.mLauncher).bindAppWidgetIdIfAllowed(AppsCustomizePagedView.this.mWidgetLoadingId, info.componentName)) {
                        AppsCustomizePagedView.this.mWidgetCleanupState = 1;
                    }
                } else if (AppWidgetManager.getInstance(AppsCustomizePagedView.this.mLauncher).bindAppWidgetIdIfAllowed(AppsCustomizePagedView.this.mWidgetLoadingId, info.componentName, options)) {
                    AppsCustomizePagedView.this.mWidgetCleanupState = 1;
                }
            }
        };
        post(this.mBindWidgetRunnable);
        this.mInflateWidgetRunnable = new Runnable() { 
            @Override
            public void run() {
                if (AppsCustomizePagedView.this.mWidgetCleanupState == 1) {
                    AppWidgetHostView hostView = AppsCustomizePagedView.this.mLauncher.getAppWidgetHost().createView(AppsCustomizePagedView.this.getContext(), AppsCustomizePagedView.this.mWidgetLoadingId, pInfo);
                    info.boundWidget = hostView;
                    AppsCustomizePagedView.this.mWidgetCleanupState = 2;
                    hostView.setVisibility(View.INVISIBLE);
                    int[] unScaledSize = AppsCustomizePagedView.this.mLauncher.getWorkspace().estimateItemSize(info.spanX, info.spanY, info, false);
                    DragLayer.LayoutParams lp = new DragLayer.LayoutParams(unScaledSize[0], unScaledSize[1]);
                    lp.y = 0;
                    lp.x = 0;
                    lp.customPosition = true;
                    hostView.setLayoutParams(lp);
                    AppsCustomizePagedView.this.mLauncher.getDragLayer().addView(hostView);
                }
            }
        };
        post(this.mInflateWidgetRunnable);
    }

    @Override
    public void onShortPress(View v) {
        if (this.mCreateWidgetInfo != null) {
            cleanupWidgetPreloading(false);
        }
        this.mCreateWidgetInfo = new PendingAddWidgetInfo((PendingAddWidgetInfo) v.getTag());
        preloadWidget(this.mCreateWidgetInfo);
    }

    private void cleanupWidgetPreloading(boolean widgetWasAdded) {
        if (!widgetWasAdded) {
            PendingAddWidgetInfo info = this.mCreateWidgetInfo;
            this.mCreateWidgetInfo = null;
            if (this.mWidgetCleanupState == 0) {
                removeCallbacks(this.mBindWidgetRunnable);
                removeCallbacks(this.mInflateWidgetRunnable);
            } else if (this.mWidgetCleanupState == 1) {
                if (this.mWidgetLoadingId != -1) {
                    this.mLauncher.getAppWidgetHost().deleteAppWidgetId(this.mWidgetLoadingId);
                }
                removeCallbacks(this.mInflateWidgetRunnable);
            } else if (this.mWidgetCleanupState == 2) {
                if (this.mWidgetLoadingId != -1) {
                    this.mLauncher.getAppWidgetHost().deleteAppWidgetId(this.mWidgetLoadingId);
                }
                AppWidgetHostView widget = info.boundWidget;
                this.mLauncher.getDragLayer().removeView(widget);
            }
        }
        this.mWidgetCleanupState = -1;
        this.mWidgetLoadingId = -1;
        this.mCreateWidgetInfo = null;
        PagedViewWidget.resetShortPressTarget();
    }

    @Override
    public void cleanUpShortPress(View v) {
        if (!this.mDraggingWidget) {
            cleanupWidgetPreloading(false);
        }
    }

    private boolean beginDraggingWidget(View v) {
        Bitmap preview;
        this.mDraggingWidget = true;
        ImageView image = (ImageView) v.findViewById(R.id.widget_preview);
        PendingAddItemInfo createItemInfo = (PendingAddItemInfo) v.getTag();
        if (image.getDrawable() == null) {
            this.mDraggingWidget = false;
            return false;
        }
        float scale = 1.0f;
        Point previewPadding = null;
        if (createItemInfo instanceof PendingAddWidgetInfo) {
            if (this.mCreateWidgetInfo == null) {
                return false;
            }
            PendingAddWidgetInfo createWidgetInfo = this.mCreateWidgetInfo;
            createItemInfo = createWidgetInfo;
            int spanX = createItemInfo.spanX;
            int spanY = createItemInfo.spanY;
            int[] size = this.mLauncher.getWorkspace().estimateItemSize(spanX, spanY, createWidgetInfo, true);
            FastBitmapDrawable previewDrawable = (FastBitmapDrawable) image.getDrawable();
            int maxWidth = Math.min((int) (previewDrawable.getIntrinsicWidth() * 1.25f), size[0]);
            int maxHeight = Math.min((int) (previewDrawable.getIntrinsicHeight() * 1.25f), size[1]);
            int[] previewSizeBeforeScale = new int[1];
            preview = this.mWidgetPreviewLoader.generateWidgetPreview(createWidgetInfo.componentName, createWidgetInfo.previewImage, createWidgetInfo.icon, spanX, spanY, maxWidth, maxHeight, null, previewSizeBeforeScale);
            int previewWidthInAppsCustomize = Math.min(previewSizeBeforeScale[0], this.mWidgetPreviewLoader.maxWidthForWidgetPreview(spanX));
            scale = previewWidthInAppsCustomize / preview.getWidth();
            if (previewWidthInAppsCustomize < previewDrawable.getIntrinsicWidth()) {
                int padding = (previewDrawable.getIntrinsicWidth() - previewWidthInAppsCustomize) / 2;
                previewPadding = new Point(padding, 0);
            }
        } else {
            PendingAddShortcutInfo createShortcutInfo = (PendingAddShortcutInfo) v.getTag();
            Drawable icon = this.mIconCache.getFullResIcon(createShortcutInfo.shortcutActivityInfo);
            preview = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.mCanvas.setBitmap(preview);
            this.mCanvas.save();
            WidgetPreviewLoader.renderDrawableToBitmap(icon, preview, 0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            this.mCanvas.restore();
            this.mCanvas.setBitmap(null);
            createItemInfo.spanY = 1;
            createItemInfo.spanX = 1;
        }
        boolean clipAlpha = ((createItemInfo instanceof PendingAddWidgetInfo) && ((PendingAddWidgetInfo) createItemInfo).previewImage == 0) ? false : true;
        Bitmap outline = Bitmap.createScaledBitmap(preview, preview.getWidth(), preview.getHeight(), false);
        this.mLauncher.lockScreenOrientation();
        this.mLauncher.getWorkspace().onDragStartedWithItem(createItemInfo, outline, clipAlpha);
        this.mDragController.startDrag(image, preview, this, createItemInfo, DragController.DRAG_ACTION_COPY, previewPadding, scale);
        outline.recycle();
        preview.recycle();
        return true;
    }

    @Override
    protected boolean beginDragging(View v) {
        if (!super.beginDragging(v)) {
            return false;
        }
        if (v instanceof PagedViewIcon) {
            beginDraggingApplication(v);
        } else if ((v instanceof PagedViewWidget) && !beginDraggingWidget(v)) {
            return false;
        }
        postDelayed(new Runnable() { 
            @Override
            public void run() {
                if (AppsCustomizePagedView.this.mLauncher.getDragController().isDragging()) {
                    AppsCustomizePagedView.this.resetDrawableState();
                    AppsCustomizePagedView.this.mLauncher.enterSpringLoadedDragMode();
                }
            }
        }, 150L);
        return true;
    }

    private void endDragging(View target, boolean isFlingToDelete, boolean success) {
        if (isFlingToDelete || !success || (target != this.mLauncher.getWorkspace() && !(target instanceof DeleteDropTarget))) {
            this.mLauncher.exitSpringLoadedDragMode();
        }
        this.mLauncher.unlockScreenOrientation(false);
    }

    @Override
    public View getContent() {
        return null;
    }

    @Override
    public void onLauncherTransitionPrepare(Launcher l, boolean animated, boolean toWorkspace) {
        this.mInTransition = true;
        if (toWorkspace) {
            cancelAllTasks();
        }
    }

    @Override
    public void onLauncherTransitionStart(Launcher l, boolean animated, boolean toWorkspace) {
    }

    @Override
    public void onLauncherTransitionStep(Launcher l, float t) {
    }

    @Override
    public void onLauncherTransitionEnd(Launcher l, boolean animated, boolean toWorkspace) {
        this.mInTransition = false;
        Iterator<AsyncTaskPageData> it = this.mDeferredSyncWidgetPageItems.iterator();
        while (it.hasNext()) {
            AsyncTaskPageData d = it.next();
            onSyncWidgetPageItems(d);
        }
        this.mDeferredSyncWidgetPageItems.clear();
        Iterator<Runnable> it2 = this.mDeferredPrepareLoadWidgetPreviewsTasks.iterator();
        while (it2.hasNext()) {
            Runnable r = it2.next();
            r.run();
        }
        this.mDeferredPrepareLoadWidgetPreviewsTasks.clear();
        this.mForceDrawAllChildrenNextFrame = toWorkspace ? false : true;
    }

    @Override
    public void onDropCompleted(View target, DropTarget.DragObject d, boolean isFlingToDelete, boolean success) {
        if (!isFlingToDelete) {
            endDragging(target, false, success);
            if (!success) {
                boolean showOutOfSpaceMessage = false;
                if (target instanceof Workspace) {
                    int currentScreen = this.mLauncher.getCurrentWorkspaceScreen();
                    Workspace workspace = (Workspace) target;
                    CellLayout layout = (CellLayout) workspace.getChildAt(currentScreen);
                    ItemInfo itemInfo = (ItemInfo) d.dragInfo;
                    if (layout != null) {
                        layout.calculateSpans(itemInfo);
                        showOutOfSpaceMessage = !layout.findCellForSpan(null, itemInfo.spanX, itemInfo.spanY);
                    }
                }
                if (showOutOfSpaceMessage) {
                    this.mLauncher.showOutOfSpaceMessage(false);
                }
                d.deferDragViewCleanupPostAnimation = false;
            }
            cleanupWidgetPreloading(success);
            this.mDraggingWidget = false;
        }
    }

    @Override
    public void onFlingToDeleteCompleted() {
        endDragging(null, true, true);
        cleanupWidgetPreloading(false);
        this.mDraggingWidget = false;
    }

    @Override
    public boolean supportsFlingToDelete() {
        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAllTasks();
    }

    public void clearAllWidgetPages() {
        cancelAllTasks();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View v = getPageAt(i);
            if (v instanceof PagedViewGridLayout) {
                ((PagedViewGridLayout) v).removeAllViewsOnPage();
                this.mDirtyPageContent.set(i, true);
            }
        }
    }

    private void cancelAllTasks() {
        Iterator<AppsCustomizeAsyncTask> iter = this.mRunningTasks.iterator();
        while (iter.hasNext()) {
            AppsCustomizeAsyncTask task = iter.next();
            task.cancel(false);
            iter.remove();
            this.mDirtyPageContent.set(task.page, true);
            View v = getPageAt(task.page);
            if (v instanceof PagedViewGridLayout) {
                ((PagedViewGridLayout) v).removeAllViewsOnPage();
            }
        }
        this.mDeferredSyncWidgetPageItems.clear();
        this.mDeferredPrepareLoadWidgetPreviewsTasks.clear();
    }

    public void setContentType(ContentType type) {
        int page = getCurrentPage();
        if (LauncherAppState.appsWidgetsDetach) {
            if (this.mContentType != type) {
                page = 0;
            }
        } else if (type == ContentType.Widgets) {
            page = this.mNumAppsPages;
        } else {
            page = 0;
        }
        this.mContentType = type;
        invalidatePageData(page, true);
    }

    public ContentType getContentType() {
        return this.mContentType;
    }

    @Override
    protected void snapToPage(int whichPage, int delta, int duration) {
        super.snapToPage(whichPage, delta, duration);
        updateCurrentTab(whichPage);
        Iterator<AppsCustomizeAsyncTask> iter = this.mRunningTasks.iterator();
        while (iter.hasNext()) {
            AppsCustomizeAsyncTask task = iter.next();
            int pageIndex = task.page;
            if ((this.mNextPage > this.mCurrentPage && pageIndex >= this.mCurrentPage) || (this.mNextPage < this.mCurrentPage && pageIndex <= this.mCurrentPage)) {
                task.setThreadPriority(getThreadPriorityForPage(pageIndex));
            } else {
                task.setThreadPriority(19);
            }
        }
    }

    private void updateCurrentTab(int currentPage) {
        String tag;
        AppsCustomizeTabHost tabHost = getTabHost();
        if (tabHost != null && (tag = tabHost.getCurrentTabTag()) != null) {
            if (currentPage >= this.mNumAppsPages && !tag.equals(tabHost.getTabTagForContentType(ContentType.Widgets))) {
                tabHost.setCurrentTabFromContent(ContentType.Widgets);
            } else if (currentPage < this.mNumAppsPages && !tag.equals(tabHost.getTabTagForContentType(ContentType.Applications))) {
                tabHost.setCurrentTabFromContent(ContentType.Applications);
            }
        }
    }

    private void setVisibilityOnChildren(ViewGroup layout, int visibility) {
        int childCount = layout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            layout.getChildAt(i).setVisibility(visibility);
        }
    }

    private void setupPage(AppsCustomizeCellLayout layout) {
        layout.setGridSize(this.mCellCountX, this.mCellCountY);
        setVisibilityOnChildren(layout, 8);
        int widthSpec = View.MeasureSpec.makeMeasureSpec(this.mContentWidth, MeasureSpec.AT_MOST);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, MeasureSpec.AT_MOST);
        layout.setMinimumWidth(getPageContentWidth());
        layout.measure(widthSpec, heightSpec);
        setVisibilityOnChildren(layout, 0);
    }

    public void syncAppsPageItems(int page, boolean immediate) {
        boolean isRtl = isLayoutRtl();
        int numCells = this.mCellCountX * this.mCellCountY;
        int startIndex = page * numCells;
        int endIndex = Math.min(startIndex + numCells, this.mApps.size());
        AppsCustomizeCellLayout layout = (AppsCustomizeCellLayout) getPageAt(page);
        layout.removeAllViewsOnPage();
        ArrayList<Object> items = new ArrayList<>();
        ArrayList<Bitmap> images = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            AppInfo info = this.mApps.get(i);
            icon = (PagedViewIcon) this.mLayoutInflater.inflate(R.layout.apps_customize_application, (ViewGroup) layout, false);
            icon.applyFromApplicationInfo(info, true, this);
            icon.setOnClickListener(this);
            icon.setOnLongClickListener(this);
            icon.setOnTouchListener(this);
            icon.setOnKeyListener(this);
            int index = i - startIndex;
            int x = index % this.mCellCountX;
            int y = index / this.mCellCountX;
            if (isRtl) {
                x = (this.mCellCountX - x) - 1;
            }
            layout.addViewToCellLayout(icon, -1, i, new CellLayout.LayoutParams(x, y, 1, 1), false);
            items.add(info);
            images.add(info.iconBitmap);
        }

        enableHwLayersOnVisiblePages();
    }

    private int getWidgetPageLoadPriority(int page) {
        int toPage = this.mCurrentPage;
        if (this.mNextPage > -1) {
            toPage = this.mNextPage;
        }
        Iterator<AppsCustomizeAsyncTask> iter = this.mRunningTasks.iterator();
        int minPageDiff = Integer.MAX_VALUE;
        while (iter.hasNext()) {
            AppsCustomizeAsyncTask task = iter.next();
            minPageDiff = Math.abs(task.page - toPage);
        }
        int rawPageDiff = Math.abs(page - toPage);
        return rawPageDiff - Math.min(rawPageDiff, minPageDiff);
    }

    private int getThreadPriorityForPage(int page) {
        int pageDiff = getWidgetPageLoadPriority(page);
        if (pageDiff <= 0) {
            return 1;
        }
        return pageDiff <= 1 ? 19 : 19;
    }

    private int getSleepForPage(int page) {
        int pageDiff = getWidgetPageLoadPriority(page);
        return Math.max(0, pageDiff * 200);
    }

    
    public void prepareLoadWidgetPreviewsTask(int page, ArrayList<Object> widgets, int cellWidth, int cellHeight, int cellCountX) {
        Iterator<AppsCustomizeAsyncTask> iter = this.mRunningTasks.iterator();
        while (iter.hasNext()) {
            AppsCustomizeAsyncTask task = iter.next();
            int taskPage = task.page;
            if (taskPage < getAssociatedLowerPageBound(this.mCurrentPage) || taskPage > getAssociatedUpperPageBound(this.mCurrentPage)) {
                task.cancel(false);
                iter.remove();
            } else {
                task.setThreadPriority(getThreadPriorityForPage(taskPage));
            }
        }
        final int sleepMs = getSleepForPage(page);
        AsyncTaskPageData pageData = new AsyncTaskPageData(page, widgets, cellWidth, cellHeight, new AsyncTaskCallback() { 
            @Override
            public void run(AppsCustomizeAsyncTask task2, AsyncTaskPageData data) {
                try {
                    try {
                        Thread.sleep(sleepMs);
                    } finally {
                        if (task2.isCancelled()) {
                            data.cleanup(true);
                        }
                    }
                } catch (Exception e) {
                }
                AppsCustomizePagedView.this.loadWidgetPreviewsInBackground(task2, data);
            }
        }, new AsyncTaskCallback() { 
            @Override
            public void run(AppsCustomizeAsyncTask task2, AsyncTaskPageData data) {
                AppsCustomizePagedView.this.mRunningTasks.remove(task2);
                if (task2.isCancelled()) {
                    return;
                }
                AppsCustomizePagedView.this.onSyncWidgetPageItems(data);
            }
        }, this.mWidgetPreviewLoader);
        AppsCustomizeAsyncTask t = new AppsCustomizeAsyncTask(page, AsyncTaskPageData.Type.LoadWidgetPreviewData);
        t.setThreadPriority(getThreadPriorityForPage(page));
        t.execute(AsyncTask.THREAD_POOL_EXECUTOR, pageData);
        this.mRunningTasks.add(t);
    }

    private void setupPage(PagedViewGridLayout layout) {
        int widthSpec = View.MeasureSpec.makeMeasureSpec(this.mContentWidth, MeasureSpec.AT_MOST);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, MeasureSpec.AT_MOST);
        layout.setMinimumWidth(getPageContentWidth());
        layout.measure(widthSpec, heightSpec);
    }

    public void syncWidgetPageItems(final int page, final boolean immediate) {
        int numItemsPerPage = this.mWidgetCountX * this.mWidgetCountY;
        final ArrayList<Object> items = new ArrayList<>();
        int contentWidth = this.mContentWidth;
        final int cellWidth = (((contentWidth - this.mPageLayoutPaddingLeft) - this.mPageLayoutPaddingRight) - ((this.mWidgetCountX - 1) * this.mWidgetWidthGap)) / this.mWidgetCountX;
        int contentHeight = this.mContentHeight;
        final int cellHeight = (((contentHeight - this.mPageLayoutPaddingTop) - this.mPageLayoutPaddingBottom) - ((this.mWidgetCountY - 1) * this.mWidgetHeightGap)) / this.mWidgetCountY;
        Log.e("lxx", " mNumAppsPages = " + this.mNumAppsPages + " mNumWidgetPages = " + this.mNumWidgetPages + " LauncherAppState.appsWidgetsDetach = " + LauncherAppState.appsWidgetsDetach);
        int offset = LauncherAppState.appsWidgetsDetach ? page * numItemsPerPage : (page - this.mNumAppsPages) * numItemsPerPage;
        for (int i = offset; i < Math.min(offset + numItemsPerPage, this.mWidgets.size()); i++) {
            items.add(this.mWidgets.get(i));
        }
        final PagedViewGridLayout pagedViewGridLayout = (PagedViewGridLayout) getPageAt(page);
        pagedViewGridLayout.setColumnCount(pagedViewGridLayout.getCellCountX());
        JLog.getInstance().e("mWidgets size == " + items.size());
        for (int i2 = 0; i2 < items.size(); i2++) {
            Object rawInfo = items.get(i2);
            PagedViewWidget widget = (PagedViewWidget) this.mLayoutInflater.inflate(R.layout.apps_customize_widget, (ViewGroup) pagedViewGridLayout, false);
            if (rawInfo instanceof AppWidgetProviderInfo) {
                AppWidgetProviderInfo info = (AppWidgetProviderInfo) rawInfo;
                PendingAddItemInfo createItemInfo = new PendingAddWidgetInfo(info, null, null);
                int[] spanXY = Launcher.getSpanForWidget(this.mLauncher, info);
                createItemInfo.spanX = spanXY[0];
                createItemInfo.spanY = spanXY[1];
                int[] minSpanXY = Launcher.getMinSpanForWidget(this.mLauncher, info);
                createItemInfo.minSpanX = minSpanXY[0];
                createItemInfo.minSpanY = minSpanXY[1];
                JLog.getInstance().e("AppWidgetProviderInfo  " + i2 + "\n spanX == " + spanXY[0] + "  spanY = " + spanXY[1]);
                widget.applyFromAppWidgetProviderInfo(info, -1, spanXY, this.mWidgetPreviewLoader);
                widget.setTag(createItemInfo);
                widget.setShortPressListener(this);
            } else if (rawInfo instanceof ResolveInfo) {
                ResolveInfo info2 = (ResolveInfo) rawInfo;
                PendingAddItemInfo createItemInfo2 = new PendingAddShortcutInfo(info2.activityInfo);
                createItemInfo2.itemType = 1;
                createItemInfo2.componentName = new ComponentName(info2.activityInfo.packageName, info2.activityInfo.name);
                widget.applyFromResolveInfo(this.mPackageManager, info2, this.mWidgetPreviewLoader);
                widget.setTag(createItemInfo2);
            }
            widget.setOnClickListener(this);
            widget.setOnLongClickListener(this);
            widget.setOnTouchListener(this);
            widget.setOnKeyListener(this);
            int ix = i2 % this.mWidgetCountX;
            int iy = i2 / this.mWidgetCountX;
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams(GridLayout.spec(iy, GridLayout.START), GridLayout.spec(ix, GridLayout.TOP));
            lp.width = cellWidth;
            lp.height = cellHeight;
            lp.setGravity(8388659);
            if (ix > 0) {
                lp.leftMargin = this.mWidgetWidthGap;
            }
            if (iy > 0) {
                lp.topMargin = this.mWidgetHeightGap;
            }
            pagedViewGridLayout.addView(widget, lp);
            JLog.getInstance().e("ResolveInfo ");
        }
        pagedViewGridLayout.setOnLayoutListener(new Runnable() { 
            @Override
            public void run() {
                int maxPreviewWidth = cellWidth;
                int maxPreviewHeight = cellHeight;
                if (pagedViewGridLayout.getChildCount() > 0) {
                    PagedViewWidget w = (PagedViewWidget) pagedViewGridLayout.getChildAt(0);
                    int[] maxSize = w.getPreviewSize();
                    maxPreviewWidth = maxSize[0];
                    maxPreviewHeight = maxSize[1];
                }
                AppsCustomizePagedView.this.mWidgetPreviewLoader.setPreviewSize(maxPreviewWidth, maxPreviewHeight, AppsCustomizePagedView.this.mWidgetSpacingLayout);
                if (!immediate) {
                    if (AppsCustomizePagedView.this.mInTransition) {
                        AppsCustomizePagedView.this.mDeferredPrepareLoadWidgetPreviewsTasks.add(this);
                    } else {
                        AppsCustomizePagedView.this.prepareLoadWidgetPreviewsTask(page, items, maxPreviewWidth, maxPreviewHeight, AppsCustomizePagedView.this.mWidgetCountX);
                    }
                } else {
                    AsyncTaskPageData data = new AsyncTaskPageData(page, items, maxPreviewWidth, maxPreviewHeight, null, null, AppsCustomizePagedView.this.mWidgetPreviewLoader);
                    AppsCustomizePagedView.this.loadWidgetPreviewsInBackground(null, data);
                    AppsCustomizePagedView.this.onSyncWidgetPageItems(data);
                }
                pagedViewGridLayout.setOnLayoutListener(null);
            }
        });
    }

    
    public void loadWidgetPreviewsInBackground(AppsCustomizeAsyncTask task, AsyncTaskPageData data) {
        if (task != null) {
            task.syncThreadPriority();
        }
        ArrayList<Object> items = data.items;
        ArrayList<Bitmap> images = data.generatedImages;
        int count = items.size();
        for (int i = 0; i < count; i++) {
            if (task != null) {
                if (!task.isCancelled()) {
                    task.syncThreadPriority();
                } else {
                    return;
                }
            }
            images.add(this.mWidgetPreviewLoader.getPreview(items.get(i)));
        }
    }

    
    public void onSyncWidgetPageItems(AsyncTaskPageData data) {
        if (this.mInTransition) {
            this.mDeferredSyncWidgetPageItems.add(data);
            return;
        }
        try {
            int page = data.page;
            PagedViewGridLayout layout = (PagedViewGridLayout) getPageAt(page);
            ArrayList<Object> items = data.items;
            int count = items.size();
            for (int i = 0; i < count; i++) {
                PagedViewWidget widget = (PagedViewWidget) layout.getChildAt(i);
                if (widget != null) {
                    Bitmap preview = data.generatedImages.get(i);
                    widget.applyPreview(new FastBitmapDrawable(preview), i);
                }
            }
            enableHwLayersOnVisiblePages();
            Iterator<AppsCustomizeAsyncTask> iter = this.mRunningTasks.iterator();
            while (iter.hasNext()) {
                AppsCustomizeAsyncTask task = iter.next();
                int pageIndex = task.page;
                task.setThreadPriority(getThreadPriorityForPage(pageIndex));
            }
        } finally {
            data.cleanup(false);
        }
    }

    @Override
    public void syncPages() {
        if (LauncherAppState.appsWidgetsDetach) {
            disablePagedViewAnimations();
        }
        removeAllViews();
        cancelAllTasks();
        Context context = getContext();
        if (LauncherAppState.appsWidgetsDetach) {
            if (this.mContentType == ContentType.Applications) {
                for (int i = 0; i < this.mNumAppsPages; i++) {
                    AppsCustomizeCellLayout layout = new AppsCustomizeCellLayout(context);
                    setupPage(layout);
                    addView(layout, new PagedView.LayoutParams(-1, -1));
                }
            } else if (this.mContentType == ContentType.Widgets) {
                for (int j = 0; j < this.mNumWidgetPages; j++) {
                    PagedViewGridLayout layout2 = new PagedViewGridLayout(context, this.mWidgetCountX, this.mWidgetCountY);
                    setupPage(layout2);
                    addView(layout2, new PagedView.LayoutParams(-1, -1));
                }
            } else {
                throw new RuntimeException("Invalid ContentType");
            }
        } else {
            for (int j2 = 0; j2 < this.mNumWidgetPages; j2++) {
                PagedViewGridLayout layout3 = new PagedViewGridLayout(context, this.mWidgetCountX, this.mWidgetCountY);
                setupPage(layout3);
                addView(layout3, new PagedView.LayoutParams(-1, -1));
            }
            if (!DISABLE_ALL_APPS) {
                for (int i2 = 0; i2 < this.mNumAppsPages; i2++) {
                    AppsCustomizeCellLayout layout4 = new AppsCustomizeCellLayout(context);
                    setupPage(layout4);
                    addView(layout4, new PagedView.LayoutParams(-1, -1));
                }
            }
        }
        enablePagedViewAnimations();
    }

    @Override
    public void syncPageItems(int page, boolean immediate) {
        if (LauncherAppState.appsWidgetsDetach) {
            if (this.mContentType == ContentType.Widgets) {
                syncWidgetPageItems(page, immediate);
                return;
            } else {
                syncAppsPageItems(page, immediate);
                return;
            }
        }
        if (page < this.mNumAppsPages) {
            syncAppsPageItems(page, immediate);
        } else {
            syncWidgetPageItems(page, immediate);
        }
    }

    @Override
    View getPageAt(int index) {
        return getChildAt(indexToPage(index));
    }

    @Override
    protected int indexToPage(int index) {
        return (getChildCount() - index) - 1;
    }

    @Override
    protected void screenScrolled(int screenCenter) {
        float translationX;
        float interpolatedProgress;
        float alpha;
        boolean isOverscrollingFirstPage;
        boolean isOverscrollingLastPage;
        boolean isRtl = isLayoutRtl();
        super.screenScrolled(screenCenter);
        for (int i = 0; i < getChildCount(); i++) {
            View v = getPageAt(i);
            if (v != null) {
                float scrollProgress = getScrollProgress(screenCenter, v, i);
                float maxScrollProgress = Math.max(0.0f, scrollProgress);
                float minScrollProgress = Math.min(0.0f, scrollProgress);
                if (isRtl) {
                    translationX = maxScrollProgress * v.getMeasuredWidth();
                    interpolatedProgress = this.mZInterpolator.getInterpolation(Math.abs(maxScrollProgress));
                } else {
                    translationX = minScrollProgress * v.getMeasuredWidth();
                    interpolatedProgress = this.mZInterpolator.getInterpolation(Math.abs(minScrollProgress));
                }
                float scale = (1.0f - interpolatedProgress) + (TRANSITION_SCALE_FACTOR * interpolatedProgress);
                if (isRtl && scrollProgress > 0.0f) {
                    alpha = this.mAlphaInterpolator.getInterpolation(1.0f - Math.abs(maxScrollProgress));
                } else if (!isRtl && scrollProgress < 0.0f) {
                    alpha = this.mAlphaInterpolator.getInterpolation(1.0f - Math.abs(scrollProgress));
                } else {
                    alpha = this.mLeftScreenAlphaInterpolator.getInterpolation(1.0f - scrollProgress);
                }
                v.setCameraDistance(this.mDensity * CAMERA_DISTANCE);
                int pageWidth = v.getMeasuredWidth();
                int pageHeight = v.getMeasuredHeight();
                float xPivot = isRtl ? 1.0f - TRANSITION_PIVOT : TRANSITION_PIVOT;
                if (isRtl) {
                    isOverscrollingFirstPage = scrollProgress > 0.0f;
                } else {
                    isOverscrollingFirstPage = scrollProgress < 0.0f;
                }
                if (isRtl) {
                    isOverscrollingLastPage = scrollProgress < 0.0f;
                } else {
                    isOverscrollingLastPage = scrollProgress > 0.0f;
                }
                if (i == 0 && isOverscrollingFirstPage) {
                    v.setPivotX(pageWidth * xPivot);
                    v.setRotationY((-TRANSITION_MAX_ROTATION) * scrollProgress);
                    scale = 1.0f;
                    alpha = 1.0f;
                    translationX = 0.0f;
                } else if (i == getChildCount() - 1 && isOverscrollingLastPage) {
                    v.setPivotX((1.0f - xPivot) * pageWidth);
                    v.setRotationY((-TRANSITION_MAX_ROTATION) * scrollProgress);
                    scale = 1.0f;
                    alpha = 1.0f;
                    translationX = 0.0f;
                } else {
                    v.setPivotY(pageHeight / 2.0f);
                    v.setPivotX(pageWidth / 2.0f);
                    v.setRotationY(0.0f);
                }
                v.setTranslationX(translationX);
                v.setScaleX(scale);
                v.setScaleY(scale);
                v.setAlpha(alpha);
                if (alpha == 0.0f) {
                    v.setVisibility(View.INVISIBLE);
                } else if (v.getVisibility() != android.view.View.VISIBLE) {
                    v.setVisibility(android.view.View.VISIBLE);
                }
            }
        }
        enableHwLayersOnVisiblePages();
    }

    private void enableHwLayersOnVisiblePages() {
        int screenCount = getChildCount();
        getVisiblePages(this.mTempVisiblePagesRange);
        int leftScreen = this.mTempVisiblePagesRange[0];
        int rightScreen = this.mTempVisiblePagesRange[1];
        int forceDrawScreen = -1;
        if (leftScreen == rightScreen) {
            if (rightScreen < screenCount - 1) {
                rightScreen++;
                forceDrawScreen = rightScreen;
            } else if (leftScreen > 0) {
                leftScreen--;
                forceDrawScreen = leftScreen;
            }
        } else {
            forceDrawScreen = leftScreen + 1;
        }
        for (int i = 0; i < screenCount; i++) {
            View layout = getPageAt(i);
            if (leftScreen > i || i > rightScreen || (i != forceDrawScreen && !shouldDrawChild(layout))) {
                layout.setLayerType(android.view.View.LAYER_TYPE_NONE, null);
            }
        }
        for (int i2 = 0; i2 < screenCount; i2++) {
            View layout2 = getPageAt(i2);
            if (leftScreen <= i2 && i2 <= rightScreen && ((i2 == forceDrawScreen || shouldDrawChild(layout2)) && layout2.getLayerType() != android.view.View.LAYER_TYPE_HARDWARE)) {
                layout2.setLayerType(android.view.View.LAYER_TYPE_HARDWARE, null);
            }
        }
    }

    @Override
    protected void overScroll(float amount) {
        acceleratedOverScroll(amount);
    }

    public int getPageContentWidth() {
        return this.mContentWidth;
    }

    @Override
    protected void onPageEndMoving() {
        super.onPageEndMoving();
        this.mForceDrawAllChildrenNextFrame = true;
        this.mSaveInstanceStateItemIndex = -1;
    }

    public void setup(Launcher launcher, DragController dragController) {
        this.mLauncher = launcher;
        this.mDragController = dragController;
    }

    private void invalidateOnDataChange() {
        if (!isDataReady()) {
            requestLayout();
        } else {
            cancelAllTasks();
            invalidatePageData();
        }
    }

    public void setApps(ArrayList<AppInfo> list) {
        if (!DISABLE_ALL_APPS) {
            this.mApps = list;
            Collections.sort(this.mApps, LauncherModel.getAppNameComparator());
            updatePageCountsAndInvalidateData();
        }
    }

    public void refreshAppState() {
        if (this.mApps != null && !this.mApps.isEmpty()) {
            for (int i = 0; i < this.mApps.size(); i++) {
                AppInfo appInfo = this.mApps.get(i);
                Resources res = getResources();
                if ("com.syu.voice.VoiceLaunch".equals(appInfo.componentName.getClassName()) || "com.syu.voice.Launch".equals(appInfo.componentName.getClassName())) {
                    appInfo.iconBitmap = BitmapFactory.decodeResource(res, getResId("com_syu_voice_voicelaunch"));
                } else if ("com.syu.voice.VoiceSetup".equals(appInfo.componentName.getClassName())) {
                    appInfo.iconBitmap = BitmapFactory.decodeResource(res, getResId("com_syu_voice_voicesetup"));
                } else if ("com.syu.bt.act.ActBtAvStart".equals(appInfo.componentName.getClassName())) {
                    appInfo.iconBitmap = BitmapFactory.decodeResource(res, getResId("com_syu_btbav"));
                } else {
                    String bmpName = appInfo.getPackageName().replace(".", "_");
                    Bitmap bit = BitmapFactory.decodeResource(res, getResId(bmpName));
                    if (bit != null) {
                        appInfo.iconBitmap = bit;
                    } else {
                        try {
                            PackageManager pm = LauncherApplication.sApp.getPackageManager();
                            Log.d("LZP", "packageName:" + appInfo.getPackageName());
                            appInfo.iconBitmap = setIcon(pm.getApplicationIcon(appInfo.getPackageName()));
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            updatePageCountsAndInvalidateData();
        }
    }

    public int getResId(String resName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    private Bitmap setIcon(Drawable d) {
        return Utilities.createIconBitmap_minify(d);
    }

    private void addAppsWithoutInvalidate(ArrayList<AppInfo> list) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            AppInfo info = list.get(i);
            int index = Collections.binarySearch(this.mApps, info, LauncherModel.getAppNameComparator());
            if (index < 0) {
                this.mApps.add(-(index + 1), info);
            }
        }
    }

    public void addApps(ArrayList<AppInfo> list) {
        if (!DISABLE_ALL_APPS) {
            addAppsWithoutInvalidate(list);
            updatePageCountsAndInvalidateData();
        }
    }

    private int findAppByComponent(List<AppInfo> list, AppInfo item) {
        ComponentName removeComponent = item.intent.getComponent();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            AppInfo info = list.get(i);
            if (info.intent.getComponent().equals(removeComponent)) {
                return i;
            }
        }
        return -1;
    }

    private void removeAppsWithoutInvalidate(ArrayList<AppInfo> list) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            AppInfo info = list.get(i);
            int removeIndex = findAppByComponent(this.mApps, info);
            if (removeIndex > -1) {
                this.mApps.remove(removeIndex);
            }
        }
    }

    public void removeApps(ArrayList<AppInfo> appInfos) {
        if (!DISABLE_ALL_APPS) {
            removeAppsWithoutInvalidate(appInfos);
            updatePageCountsAndInvalidateData();
        }
    }

    public void updateApps(ArrayList<AppInfo> list) {
        if (!DISABLE_ALL_APPS) {
            removeAppsWithoutInvalidate(list);
            addAppsWithoutInvalidate(list);
            updatePageCountsAndInvalidateData();
        }
    }

    public void reset() {
        this.mSaveInstanceStateItemIndex = -1;
        AppsCustomizeTabHost tabHost = getTabHost();
        String tag = tabHost.getCurrentTabTag();
        if (tag != null && !tag.equals(tabHost.getTabTagForContentType(ContentType.Applications))) {
            tabHost.setCurrentTabFromContent(ContentType.Applications);
        }
        if (this.mCurrentPage != 0) {
            invalidatePageData(0);
        }
    }

    private AppsCustomizeTabHost getTabHost() {
        return (AppsCustomizeTabHost) this.mLauncher.findViewById(R.id.apps_customize_pane);
    }

    public void dumpState() {
    }

    private void dumpAppWidgetProviderInfoList(String tag, String label, ArrayList<Object> list) {
        Log.d(tag, String.valueOf(label) + " size=" + list.size());
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object i = it.next();
            if (i instanceof AppWidgetProviderInfo) {
                AppWidgetProviderInfo info = (AppWidgetProviderInfo) i;
                Log.d(tag, "   label=\"" + info.loadLabel(this.mPackageManager) + "\" previewImage=" + info.previewImage + " resizeMode=" + info.resizeMode + " configure=" + info.configure + " initialLayout=" + info.initialLayout + " minWidth=" + info.minWidth + " minHeight=" + info.minHeight);
            } else if (i instanceof ResolveInfo) {
                ResolveInfo info2 = (ResolveInfo) i;
                Log.d(tag, "   label=\"" + ((Object) info2.loadLabel(this.mPackageManager)) + "\" icon=" + info2.icon);
            }
        }
    }

    public void surrender() {
        cancelAllTasks();
    }

    @Override
    public void iconPressed(PagedViewIcon icon) {
        if (this.mPressedIcon != null) {
            this.mPressedIcon.resetDrawableState();
        }
        this.mPressedIcon = icon;
    }

    public void resetDrawableState() {
        Log.i("hy", "mAppsCustomizeContentresetDrawableState");
        if (this.mPressedIcon != null) {
            this.mPressedIcon.resetDrawableState();
            this.mPressedIcon = null;
        }
    }

    @Override
    protected int getAssociatedLowerPageBound(int page) {
        int count = getChildCount();
        int windowSize = Math.min(count, 5);
        int windowMinIndex = Math.max(Math.min(page - 2, count - windowSize), 0);
        return windowMinIndex;
    }

    @Override
    protected int getAssociatedUpperPageBound(int page) {
        int count = getChildCount();
        int windowSize = Math.min(count, 5);
        int windowMaxIndex = Math.min(Math.max(page + 2, windowSize - 1), count - 1);
        return windowMaxIndex;
    }

    @Override
    protected String getCurrentPageDescription() {
        int stringId;
        int count;
        int page = this.mNextPage != -1 ? this.mNextPage : this.mCurrentPage;
        if (LauncherAppState.appsWidgetsDetach) {
            if (this.mContentType == ContentType.Applications) {
                stringId = R.string.apps_customize_apps_scroll_format;
                count = this.mNumAppsPages;
            } else if (this.mContentType == ContentType.Widgets) {
                stringId = R.string.apps_customize_widgets_scroll_format;
                count = this.mNumWidgetPages;
            } else {
                throw new RuntimeException("Invalid ContentType");
            }
        } else if (page < this.mNumAppsPages) {
            stringId = R.string.apps_customize_apps_scroll_format;
            count = this.mNumAppsPages;
        } else {
            stringId = R.string.apps_customize_widgets_scroll_format;
            count = this.mNumWidgetPages;
        }
        return String.format(getContext().getString(stringId), Integer.valueOf(page + 1), Integer.valueOf(count));
    }
}
