package com.android.launcher66;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Choreographer;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.FolderIcon.FolderRingAnimator;
import com.android.launcher66.Launcher.CustomContentCallbacks;
import com.android.launcher66.LauncherSettings.Favorites;
import com.android.launcher66.settings.CanbusAsyncTask;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.android.recycler.SimpleDividerDecoration;
import com.syu.util.WindowUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import share.Config;

/**
 * The workspace is a wide area with a wallpaper and a finite number of pages.
 * Each page contains a number of icons, folders or widgets the user can
 * interact with. A workspace is meant to be used with a fixed width only.
 */
public class Workspace extends SmoothPagedView
        implements DropTarget, DragSource, DragScroller, View.OnTouchListener,
        DragController.DragListener, LauncherTransitionable, ViewGroup.OnHierarchyChangeListener,
        Insettable {
    private static final String TAG = "Launcher.Workspace";

    // Y rotation to apply to the workspace screens
    private static final float WORKSPACE_OVERSCROLL_ROTATION = 24f;

    private static final int CHILDREN_OUTLINE_FADE_OUT_DELAY = 0;
    private static final int CHILDREN_OUTLINE_FADE_OUT_DURATION = 375;
    private static final int CHILDREN_OUTLINE_FADE_IN_DURATION = 100;

    private static final int BACKGROUND_FADE_OUT_DURATION = 350;
    private static final int ADJACENT_SCREEN_DROP_DURATION = 300;
    private static final int FLING_THRESHOLD_VELOCITY = 500;

    private static final float ALPHA_CUTOFF_THRESHOLD = 0.01f;

    // These animators are used to fade the children's outlines
    private ObjectAnimator mChildrenOutlineFadeInAnimation;
    private ObjectAnimator mChildrenOutlineFadeOutAnimation;
    private float mChildrenOutlineAlpha = 0;

    // These properties refer to the background protection gradient used for AllApps and Customize
    private ValueAnimator mBackgroundFadeInAnimation;
    private ValueAnimator mBackgroundFadeOutAnimation;
    private Drawable mBackground;
    boolean mDrawBackground = true;
    private float mBackgroundAlpha = 0;

    private static final long CUSTOM_CONTENT_GESTURE_DELAY = 200;
    private long mTouchDownTime = -1;
    private long mCustomContentShowTime = -1;

    private LayoutTransition mLayoutTransition;
    private final WallpaperManager mWallpaperManager;
    private IBinder mWindowToken;

    private int mOriginalDefaultPage;
    private int mDefaultPage;

    private ShortcutAndWidgetContainer mDragSourceInternal;
    private static boolean sAccessibilityEnabled;

    // The screen id used for the empty screen always present to the right.
    private final static long EXTRA_EMPTY_SCREEN_ID = -201;
    private final static long CUSTOM_CONTENT_SCREEN_ID = -301;

    private HashMap<Long, CellLayout> mWorkspaceScreens = new HashMap<Long, CellLayout>();
    private ArrayList<Long> mScreenOrder = new ArrayList<Long>();

    /**
     * CellInfo for the cell that is currently being dragged
     */
    private CellLayout.CellInfo mDragInfo;

    /**
     * Target drop area calculated during last acceptDrop call.
     */
    private int[] mTargetCell = new int[2];
    private int mDragOverX = -1;
    private int mDragOverY = -1;

    static Rect mLandscapeCellLayoutMetrics = null;
    static Rect mPortraitCellLayoutMetrics = null;

    CustomContentCallbacks mCustomContentCallbacks;
    boolean mCustomContentShowing;
    private float mLastCustomContentScrollProgress = -1f;
    private String mCustomContentDescription = "";

    /**
     * The CellLayout that is currently being dragged over
     */
    private CellLayout mDragTargetLayout = null;
    /**
     * The CellLayout that we will show as glowing
     */
    private CellLayout mDragOverlappingLayout = null;

    /**
     * The CellLayout which will be dropped to
     */
    private CellLayout mDropToLayout = null;

    private Launcher mLauncher;
    private IconCache mIconCache;
    private DragController mDragController;

    // These are temporary variables to prevent having to allocate a new object just to
    // return an (x, y) value from helper functions. Do NOT use them to maintain other state.
    private int[] mTempCell = new int[2];
    private int[] mTempPt = new int[2];
    private int[] mTempEstimate = new int[2];
    private float[] mDragViewVisualCenter = new float[2];
    private float[] mTempCellLayoutCenterCoordinates = new float[2];
    private Matrix mTempInverseMatrix = new Matrix();

    private SpringLoadedDragController mSpringLoadedDragController;
    private float mSpringLoadedShrinkFactor;
    private float mOverviewModeShrinkFactor;
    private int mOverviewModePageOffset;

    // State variable that indicates whether the pages are small (ie when you're
    // in all apps or customize mode)

    enum State { NORMAL, SPRING_LOADED, SMALL, OVERVIEW};
    private State mState = State.NORMAL;
    private boolean mIsSwitchingState = false;

    boolean mAnimatingViewIntoPlace = false;
    boolean mIsDragOccuring = false;
    boolean mChildrenLayersEnabled = true;

    private boolean mStripScreensOnPageStopMoving = false;

    /** Is the user is dragging an item near the edge of a page? */
    private boolean mInScrollArea = false;

    private HolographicOutlineHelper mOutlineHelper;
    private Bitmap mDragOutline = null;
    private final Rect mTempRect = new Rect();
    private final int[] mTempXY = new int[2];
    private int[] mTempVisiblePagesRange = new int[2];
    private boolean mOverscrollTransformsSet;
    private float mLastOverscrollPivotX;
    public static final int DRAG_BITMAP_PADDING = 2;
    private boolean mWorkspaceFadeInAdjacentScreens;

    WallpaperOffsetInterpolator mWallpaperOffset;
    private Runnable mDelayedResizeRunnable;
    private Runnable mDelayedSnapToPageRunnable;
    private Point mDisplaySize = new Point();
    private int mCameraDistance;

    // Variables relating to the creation of user folders by hovering shortcuts over shortcuts
    private static final int FOLDER_CREATION_TIMEOUT = 0;
    private static final int REORDER_TIMEOUT = 250;
    private final Alarm mFolderCreationAlarm = new Alarm();
    private final Alarm mReorderAlarm = new Alarm();
    private FolderRingAnimator mDragFolderRingAnimator = null;
    private FolderIcon mDragOverFolderIcon = null;
    private boolean mCreateUserFolderOnDrop = false;
    private boolean mAddToExistingFolderOnDrop = false;
    private DropTarget.DragEnforcer mDragEnforcer;
    private float mMaxDistanceForFolderCreation;

    // Variables relating to touch disambiguation (scrolling workspace vs. scrolling a widget)
    private float mXDown;
    private float mYDown;
    final static float START_DAMPING_TOUCH_SLOP_ANGLE = (float) Math.PI / 6;
    final static float MAX_SWIPE_ANGLE = (float) Math.PI / 3;
    final static float TOUCH_SLOP_DAMPING_FACTOR = 4;

    // Relating to the animation of items being dropped externally
    public static final int ANIMATE_INTO_POSITION_AND_DISAPPEAR = 0;
    public static final int ANIMATE_INTO_POSITION_AND_REMAIN = 1;
    public static final int ANIMATE_INTO_POSITION_AND_RESIZE = 2;
    public static final int COMPLETE_TWO_STAGE_WIDGET_DROP_ANIMATION = 3;
    public static final int CANCEL_TWO_STAGE_WIDGET_DROP_ANIMATION = 4;

    // Related to dragging, folder creation and reordering
    private static final int DRAG_MODE_NONE = 0;
    private static final int DRAG_MODE_CREATE_FOLDER = 1;
    private static final int DRAG_MODE_ADD_TO_FOLDER = 2;
    private static final int DRAG_MODE_REORDER = 3;
    private int mDragMode = DRAG_MODE_NONE;
    private int mLastReorderX = -1;
    private int mLastReorderY = -1;

    private SparseArray<Parcelable> mSavedStates;
    private final ArrayList<Integer> mRestoredPages = new ArrayList<Integer>();

    // These variables are used for storing the initial and final values during workspace animations
    private int mSavedScrollX;
    private float mSavedRotationY;
    private float mSavedTranslationX;

    private float mCurrentScale;
    private float mNewScale;
    private float[] mOldBackgroundAlphas;
    private float[] mOldAlphas;
    private float[] mNewBackgroundAlphas;
    private float[] mNewAlphas;
    private int mLastChildCount = -1;
    private float mTransitionProgress;

    private Runnable mDeferredAction;
    private boolean mDeferDropAfterUninstall;
    private boolean mUninstallSuccessful;

    private Animator mWorkspaceAnim;

    public static CellLayout[] customScreen = new CellLayout[LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count)];
    public static int apps_customepage_count = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count);
    private SharedPreferences mPrefs;
    public static AbsoluteLayout absoluteLayout;
    private Handler stripHandler = new Handler(Looper.getMainLooper());
    private Runnable stripAction;
    private static final long STRIP_DELAY = 2500;
    private Helpers helpers = new Helpers();
    public static final long CUSTOM_CONTENT_SCREEN_ID1 = -302;
    private View workspaceView;
    private boolean isDebug;
    private float widgetScaleFactor = 1.75f;
    public boolean backPressed = false;
    private boolean leftBar = false;
    private boolean widgetsVisible = false;
    public boolean widgetDropPip = false;
    private WindowManager widgetsWindowManager;
    private LayoutInflater widgetsLayoutInflater;
    private View absoluteTime;
    private View absoluteMusic;
    private View absoluteRadio;
    private WindowManager.LayoutParams radioParams;
    private WindowManager.LayoutParams musicParams;
    private WindowManager.LayoutParams timeParams;
    private View overlayBottomBar;
    private WindowManager.LayoutParams overlayWindowParams;
    private WindowManager overlayWindowManager;
    private View mBarMusicWidget;
    private View mBarDateWidget;
    private View mBarWeatherWidget;
    private ImageView showBarIcon;
    private ImageView bottomBarAllApps;
    private RecyclerView bottomBarRecycler;
    private ImageView bottomBarBg;
    private String selectedBackground;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> autoHideFuture;
    private boolean blackTintBar = false;
    private boolean widgetBar = false;
    private boolean autoHideBottomBar = false;  
    private int autoHideTimeout = 5;
    private boolean isOverlayShowing = false;
    private boolean isOverlayAnimating = false;
    boolean pipInitialized = false;
    private final Object overlayLock = new Object();

    private TextView titleText;
    private TextView artistText;
    private TextView cityText;
    private TextView weatherText;
    private TextView tempText;
    private TextView dateText;
    private TextView weekText;
    private int orientation;

    private final Runnable mBindPages = new Runnable() {
        @Override
        public void run() {
            mLauncher.getModel().bindRemainingSynchronousPages();
        }
    };

    /**
     * Used to inflate the Workspace from XML.
     *
     * @param context The application's context.
     * @param attrs The attributes set containing the Workspace's customization values.
     */
    public Workspace(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Used to inflate the Workspace from XML.
     *
     * @param context The application's context.
     * @param attrs The attributes set containing the Workspace's customization values.
     * @param defStyle Unused.
     */
    public Workspace(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContentIsRefreshable = false;

        mOutlineHelper = HolographicOutlineHelper.obtain(context);

        mDragEnforcer = new DropTarget.DragEnforcer(context);
        // With workspace, data is available straight from the get-go
        setDataIsReady();

        mLauncher = (Launcher) context;
        final Resources res = getResources();
        mWorkspaceFadeInAdjacentScreens = res.getBoolean(R.bool.config_workspaceFadeAdjacentScreens);
        mFadeInAdjacentScreens = false;
        mWallpaperManager = WallpaperManager.getInstance(context);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Workspace, defStyle, 0);
        mSpringLoadedShrinkFactor =
            res.getInteger(R.integer.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        mOverviewModeShrinkFactor =
                res.getInteger(R.integer.config_workspaceOverviewShrinkPercentage) / 100.0f;
        mOverviewModePageOffset = res.getDimensionPixelSize(R.dimen.overview_mode_page_offset);
        mCameraDistance = res.getInteger(R.integer.config_cameraDistance);
        mOriginalDefaultPage = mDefaultPage = a.getInt(R.styleable.Workspace_defaultScreen, 1);
        a.recycle();

        setOnHierarchyChangeListener(this);
        setHapticFeedbackEnabled(false);

        loadWorkspaceScreensFromProvider();

        initWorkspace();
        
        // Disable multitouch across the workspace/all apps/customize tray
        setMotionEventSplittingEnabled(true);
        setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
        isDebug = BuildConfig.DEBUG;
    }

    @Override
    public void setInsets(Rect insets) {
        mInsets.set(insets);
    }

    // estimate the size of a widget with spans hSpan, vSpan. return MAX_VALUE for each
    // dimension if unsuccessful
    public int[] estimateItemSize(int hSpan, int vSpan,
            ItemInfo itemInfo, boolean springLoaded) {
        int[] size = new int[2];
        if (getChildCount() > 0) {
            // Use the first non-custom page to estimate the child position
            CellLayout cl = (CellLayout) getChildAt(numCustomPages());
            Rect r = estimateItemPosition(cl, itemInfo, 0, 0, hSpan, vSpan);
            size[0] = r.width();
            size[1] = r.height();
            if (springLoaded) {
                size[0] *= mSpringLoadedShrinkFactor;
                size[1] *= mSpringLoadedShrinkFactor;
            }
            return size;
        } else {
            size[0] = Integer.MAX_VALUE;
            size[1] = Integer.MAX_VALUE;
            return size;
        }
    }

    public Rect estimateItemPosition(CellLayout cl, ItemInfo pendingInfo,
            int hCell, int vCell, int hSpan, int vSpan) {
        Rect r = new Rect();
        cl.cellToRect(hCell, vCell, hSpan, vSpan, r);
        return r;
    }

    public void onDragStart(final DragSource source, Object info, int dragAction) {
        mIsDragOccuring = true;
        updateChildrenLayersEnabled(false);
        mLauncher.lockScreenOrientation();
        mLauncher.onInteractionBegin();
        setChildrenBackgroundAlphaMultipliers(1f);
        // Prevent any Un/InstallShortcutReceivers from updating the db while we are dragging
        InstallShortcutReceiver.enableInstallQueue();
        UninstallShortcutReceiver.enableUninstallQueue();
        post(new Runnable() {
            @Override
            public void run() {
                if (mIsDragOccuring) {
                    addExtraEmptyScreenOnDrag();
                }
            }
        });
    }

    public void onDragEnd() {
        mIsDragOccuring = false;
        updateChildrenLayersEnabled(false);
        mLauncher.unlockScreenOrientation(false);

        // Re-enable any Un/InstallShortcutReceiver and now process any queued items
        InstallShortcutReceiver.disableAndFlushInstallQueue(getContext());
        UninstallShortcutReceiver.disableAndFlushUninstallQueue(getContext());

        removeExtraEmptyScreen();
        mDragSourceInternal = null;
        mLauncher.onInteractionEnd();

        mReorderAlarm.setOnAlarmListener(null);
    }

    /**
     * Initializes various states for this workspace.
     */
    protected void initWorkspace() {
        Context context = getContext();
        mCurrentPage = mDefaultPage;
        Launcher.setScreen(mCurrentPage);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        mIconCache = app.getIconCache();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        setChildrenDrawnWithCacheEnabled(true);

        // This is a bit of a hack to account for the fact that we translate the workspace
        // up a bit, and still need to draw the background covering the whole screen.
        setMinScale(mOverviewModeShrinkFactor - 0.2f);
        setupLayoutTransition();

        try {
            mBackground = ContextCompat.getDrawable(context, R.drawable.apps_customize_bg);
        } catch (Resources.NotFoundException e) {
            // In this case, we will skip drawing background protection
        }

        mWallpaperOffset = new WallpaperOffsetInterpolator();
        Display display = mLauncher.getWindowManager().getDefaultDisplay();
        display.getSize(mDisplaySize);

        mMaxDistanceForFolderCreation = (0.55f * grid.iconSizePx);
        mFlingThresholdVelocity = (int) (FLING_THRESHOLD_VELOCITY * mDensity);
    }

    private void loadWorkspaceScreensFromProvider() {
        ContentResolver resolver = mLauncher.getContentResolver();
        Cursor c = resolver.query(
            LauncherSettings.WorkspaceScreens.CONTENT_URI,
            new String[] { "_id", LauncherSettings.WorkspaceScreens.SCREEN_RANK },
            null, null,
            LauncherSettings.WorkspaceScreens.SCREEN_RANK + " ASC"
        );
        if (c == null) {
            Log.w(TAG, "loadWorkspaceScreensFromProvider: query returned null");
            return;
        }

        try {
            // Clear existing in-memory maps (start clean)
            mScreenOrder.clear();
            mWorkspaceScreens.clear();

            while (c.moveToNext()) {
                long screenId = c.getLong(0);
                int rank = c.getInt(1); // may be used if you need extra ordering checks

                // Create the CellLayout page for this persisted id
                CellLayout page = (CellLayout) LayoutInflater.from(getContext())
                        .inflate(R.layout.workspace_screen, this, false);

                // make sure layout params are correct for PagedView.
                PagedView.LayoutParams lp = new PagedView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
                page.setLayoutParams(lp);

                // put into maps and add view (append at end)
                mScreenOrder.add(screenId);
                mWorkspaceScreens.put(screenId, page);
                addView(page); // append (safe)
            }
        } finally {
            c.close();
        }
    }

    public void ensurePageExists(int pageIndex) {
        if (pageIndex < 0) {
            Log.w(TAG, "ensurePageExists: negative pageIndex=" + pageIndex);
            return;
        }

        // Fast path: already have page at that index
        if (getChildCount() > pageIndex) return;

        ContentResolver resolver = mLauncher.getContentResolver();

        while (getChildCount() <= pageIndex) {
            // we want to append at the end by default
            int requestedInsertIndex = getChildCount();

            // Persist a new screen row and get authoritative id
            long persistedId = createPersistedWorkspaceScreen(requestedInsertIndex);

            if (persistedId <= 0) {
                // Persistence failed. Log and create an ephemeral (negative) id to keep runtime stable.
                persistedId = -System.identityHashCode(new Object()); // unique negative value
                Log.w(TAG, "ensurePageExists: persistence failed - using ephemeral id=" + persistedId);
            }

            // create new page and ensure correct layout params for PagedView
            CellLayout newScreen = (CellLayout) LayoutInflater.from(getContext())
                    .inflate(R.layout.workspace_screen, this, false);

            // Use PagedView.LayoutParams so PagedView.onMeasure can cast safely
            PagedView.LayoutParams lp = new PagedView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            // Determine clamped index for safe insert
            int childCount = getChildCount();
            int clampedIndex = Math.max(0, Math.min(requestedInsertIndex, childCount));

            // Update mScreenOrder consistently BEFORE adding the view
            if (clampedIndex >= mScreenOrder.size()) {
                mScreenOrder.add(persistedId);
            } else {
                mScreenOrder.add(clampedIndex, persistedId);
            }

            mWorkspaceScreens.put(persistedId, newScreen);

            // Add view with explicit LayoutParams and clamped index to avoid ClassCastException and OOB
            try {
                addView(newScreen, clampedIndex, lp);
            } catch (IndexOutOfBoundsException ex) {
                Log.e(TAG, "ensurePageExists: addView failed at clampedIndex=" + clampedIndex
                        + " childCount=" + getChildCount(), ex);
                addView(newScreen, lp); // append as fallback
            }
        }
    }

    private long createPersistedWorkspaceScreen(int desiredRank) {
        Log.i(TAG, "createPersistedWorkspaceScreen: rank=" + desiredRank +
              " current mScreenOrder=" + mScreenOrder);

        ContentResolver resolver = mLauncher.getContentResolver();

        if (desiredRank < mScreenOrder.size()) {
            long existingScreenId = mScreenOrder.get(desiredRank);
            Log.i(TAG, "createPersistedWorkspaceScreen: reusing existing screen at rank="
                  + desiredRank + " id=" + existingScreenId);
            return existingScreenId;
        }

        long maxId = 0;
        Cursor c = null;
        try {
            c = resolver.query(
                LauncherSettings.WorkspaceScreens.CONTENT_URI,
                new String[]{LauncherSettings.WorkspaceScreens._ID},
                null, null, null
            );
            if (c != null) {
                while (c.moveToNext()) {
                    long id = c.getLong(0);
                    if (id > maxId) maxId = id;
                }
            }
        } finally {
            if (c != null) c.close();
        }

        for (Long id : mScreenOrder) {
            if (id > maxId) maxId = id;
        }

        long newId = maxId + 1;

        ContentValues cv = new ContentValues();
        cv.put(LauncherSettings.WorkspaceScreens._ID, newId);
        cv.put(LauncherSettings.WorkspaceScreens.SCREEN_RANK, desiredRank);

        Uri result;
        try {
            result = resolver.insert(LauncherSettings.WorkspaceScreens.CONTENT_URI, cv);
        } catch (Exception e) {
            Log.e(TAG, "createPersistedWorkspaceScreen: insert failed", e);
            return -1;
        }

        Log.i(TAG, "createPersistedWorkspaceScreen: created NEW screen id=" +
              newId + " rank=" + desiredRank);

        return newId;
    }

    private void setupLayoutTransition() {
        // We want to show layout transitions when pages are deleted, to close the gap.
        mLayoutTransition = new LayoutTransition();
        mLayoutTransition.enableTransitionType(LayoutTransition.DISAPPEARING);
        mLayoutTransition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
        mLayoutTransition.disableTransitionType(LayoutTransition.APPEARING);
        mLayoutTransition.disableTransitionType(LayoutTransition.CHANGE_APPEARING);
        setLayoutTransition(mLayoutTransition);
    }

    void enableLayoutTransitions() {
        setLayoutTransition(mLayoutTransition);
    }
    void disableLayoutTransitions() {
        setLayoutTransition(null);
    }

    @Override
    protected int getScrollMode() {
        return SmoothPagedView.X_LARGE_MODE;
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        if (!(child instanceof CellLayout)) {
            throw new IllegalArgumentException("A Workspace can only have CellLayout children.");
        }
        CellLayout cl = ((CellLayout) child);
        cl.setOnInterceptTouchListener(this);
        cl.setClickable(true);
        cl.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        super.onChildViewAdded(parent, child);
    }

    protected boolean shouldDrawChild(View child) {
        final CellLayout cl = (CellLayout) child;
        return super.shouldDrawChild(child) &&
            (mIsSwitchingState ||
             cl.getShortcutsAndWidgets().getAlpha() > 0 ||
             cl.getBackgroundAlpha() > 0);
    }

    /**
     * @return The open folder on the current screen, or null if there is none
     */
    public Folder getOpenFolder() {
        DragLayer dragLayer = mLauncher.getDragLayer();
        int count = dragLayer.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = dragLayer.getChildAt(i);
            if (child instanceof Folder) {
                Folder folder = (Folder) child;
                if (folder.getInfo().opened)
                    return folder;
            }
        }
        return null;
    }

    public boolean isTouchActive() {
        return mTouchState != TOUCH_STATE_REST;
    }

    public void removeAllWorkspaceScreens() {
        // Disable all layout transitions before removing all pages to ensure that we don't get the
        // transition animations competing with us changing the scroll when we add pages or the
        // custom content screen
        disableLayoutTransitions();

        // Since we increment the current page when we call addCustomContentPage via bindScreens
        // (and other places), we need to adjust the current page back when we clear the pages
        if (hasCustomContent()) {
            removeCustomContentPage();
        }

        // Remove the pages and clear the screen models
        removeAllViews();
        mScreenOrder.clear();
        mWorkspaceScreens.clear();

        // Re-enable the layout transitions
        enableLayoutTransitions();
    }

    public long insertNewWorkspaceScreenBeforeEmptyScreen(long screenId) {
        // Find the index to insert this view into.  If the empty screen exists, then
        // insert it before that.
        int insertIndex = mScreenOrder.indexOf(EXTRA_EMPTY_SCREEN_ID);
        if (insertIndex < 0) {
            insertIndex = mScreenOrder.size();
        }
        return insertNewWorkspaceScreen(screenId, insertIndex);
    }

    public long insertNewWorkspaceScreen(long screenId) {
        return insertNewWorkspaceScreen(screenId, getChildCount());
    }

    public long insertNewWorkspaceScreen(long screenId, int insertIndex) {
        // Check for duplicates
        if (mScreenOrder.contains(screenId)) {
            Log.e(TAG, "insertNewWorkspaceScreen: DUPLICATE! screen id=" + screenId + " already in mScreenOrder=" + mScreenOrder);
            return screenId;
        }
        
        if (mWorkspaceScreens.containsKey(screenId)) {
            Log.e(TAG, "insertNewWorkspaceScreen: screen id=" + screenId + " already in mWorkspaceScreens");
            return screenId;
        }

        // Check if an empty screen already exists
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            for (Long id : mWorkspaceScreens.keySet()) {
                CellLayout cl = mWorkspaceScreens.get(id);
                if (id >= 0 && cl.getShortcutsAndWidgets().getChildCount() == 0) {
                    Log.i(TAG, "insertNewWorkspaceScreen: empty screen already exists at id=" + id + ", skipping creation");
                    return id;
                }
            }
        }
        
        Log.i(TAG, "insertNewWorkspaceScreen: adding screen id=" + screenId + " at index=" + insertIndex);
        
        // Create the CellLayout
        CellLayout newScreen = (CellLayout) LayoutInflater.from(getContext())
                .inflate(R.layout.workspace_screen, this, false);
        
        newScreen.setOnLongClickListener(mLongClickListener);
        newScreen.setOnClickListener(mLauncher);
        newScreen.setSoundEffectsEnabled(false);
        
        // Add to data structures
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            mScreenOrder.remove(EXTRA_EMPTY_SCREEN_ID);
            Long maxScreen = Math.abs(Collections.max(mScreenOrder));
            if (maxScreen == 302) {
                screenId = 1;
            } else {
                screenId = maxScreen + 1;
            }
            // Persist
            try {
                ContentValues cv = new ContentValues();
                cv.put(LauncherSettings.WorkspaceScreens._ID, screenId); // dbInsertAndCheck requires _id
                cv.put(LauncherSettings.WorkspaceScreens.SCREEN_RANK, insertIndex);
                // LauncherSettings.WorkspaceScreens.CONTENT_URI == "content://com.android.launcher66.settings/workspaceScreens?notify=true"
                mLauncher.getContentResolver().insert(LauncherSettings.WorkspaceScreens.CONTENT_URI, cv);
                Log.i(TAG, "Persisted workspace screen to provider: id=" + screenId + " rank=" + insertIndex);
            } catch (Exception e) {
                // Don't crash if the provider insert fails — log and continue (but this is the important part).
                Log.w(TAG, "Failed to persist new workspace screen to provider: " + e);
            }
        }
        mScreenOrder.add(insertIndex, screenId);
        mWorkspaceScreens.put(screenId, newScreen);
        
        // Add view
        PagedView.LayoutParams lp = new PagedView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        );
        addView(newScreen, insertIndex, lp);
        
        Log.i(TAG, "insertNewWorkspaceScreen: final mScreenOrder=" + mScreenOrder);
        return screenId;
    }

    public void createUserPage() {
        cleanupAllResources();
        cancelPendingAutoHide();
        clearWidgetReferences();
        helpers.setInAllApps(false);
        helpers.setInWidgets(false);
        helpers.setInOverviewMode(false);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);
        blackTintBar = mPrefs.getBoolean(Keys.BLACK_BAR, false);
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
        orientation = getResources().getConfiguration().orientation;

        if (customScreen[0] != null) {
            mWorkspaceScreens.remove(CUSTOM_CONTENT_SCREEN_ID1);
            mScreenOrder.remove(CUSTOM_CONTENT_SCREEN_ID1);
            removeView(customScreen[0]);
        }

        customScreen[0] = (CellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_custom, (ViewGroup) null);
        CellLayout workspaceLayout = this.mLauncher.findViewById(R.id.workspace_custom);

        if (userLayout) {
            if (leftBar) {
                if (widgetBar) {
                    workspaceView = this.mLauncher.getLayoutInflater().inflate(R.layout.custom_layout_two_user_left, workspaceLayout, false);
                    customScreen[0].addView(workspaceView);
                } else {
                    workspaceView = this.mLauncher.getLayoutInflater().inflate(R.layout.custom_layout_one_user_left, workspaceLayout, false);
                    customScreen[0].addView(workspaceView);
                }
            } else {
                if (widgetBar) {
                    workspaceView = this.mLauncher.getLayoutInflater().inflate(R.layout.custom_layout_two_user, workspaceLayout, false);
                    customScreen[0].addView(workspaceView);
                } else {
                    workspaceView = this.mLauncher.getLayoutInflater().inflate(R.layout.custom_layout_one_user, workspaceLayout, false);
                    customScreen[0].addView(workspaceView);
                }
            }

            if (widgetBar) {
                mLauncher.removeCustomView("WS_Music_Two");
                mBarMusicWidget = workspaceView.findViewById(R.id.rl_music_two);
                mLauncher.initMusicBarView(mBarMusicWidget);
                mLauncher.preSetMusicWidgets();
                mBarWeatherWidget = workspaceView.findViewById(R.id.bar_widget_weather);
            }
            
            bottomBarAllApps = workspaceView.findViewById(R.id.rl_allapps);
            if (blackTintBar) {
                Helpers.applyColorFilterToImageView(bottomBarAllApps);
            }

            bottomBarRecycler = workspaceView.findViewById(R.id.recycler_view);
            
            bottomBarBg = workspaceView.findViewById(R.id.iv_list_bg);
            selectedBackground = mPrefs.getString(Keys.BAR_SELECTED_BACKGROUND, "app_list_bg");
            if (!selectedBackground.equals("app_list_bg")) {
                bottomBarBg.setImageResource(getResId(selectedBackground));
            }

            autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
            if (autoHideBottomBar) {
                toggleBottomBar();              
            }
        } else {
            workspaceView = this.mLauncher.getLayoutInflater().inflate(R.layout.custom_layout_one, workspaceLayout, false);
            customScreen[0].addView(workspaceView);

            TextView naviTextSize = (TextView) workspaceView.findViewById(R.id.tv_map);
            naviTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.mLauncher.textSizeTitle);
            TextView dateTextSize = (TextView) workspaceView.findViewById(R.id.date);
            dateTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.mLauncher.textSizeBasic);
            TextView weekTextSize = (TextView) workspaceView.findViewById(R.id.curWeek);
            weekTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.mLauncher.textSizeBasic);
            TextView titleTextSize = (TextView) workspaceView.findViewById(R.id.tv_musicName);
            titleTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.mLauncher.textSizeTitle);
            TextView artistTextSize = (TextView) workspaceView.findViewById(R.id.tv_artist);
            artistTextSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.mLauncher.textSizeArtist);

            View mUserMusicWidget = workspaceView.findViewById(R.id.rl_music);
            mLauncher.initMusicWidgetView(mUserMusicWidget);
            mLauncher.bindMusicWidgetOnclickListener(mUserMusicWidget);
            mLauncher.preSetMusicWidgets();
        }

        for (int i = 0; i < LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count); i++) {
            mWorkspaceScreens.put(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID1 - i), customScreen[i]);
            mScreenOrder.add(i, Long.valueOf(CUSTOM_CONTENT_SCREEN_ID1 - i));
            if (customScreen[i] != null) {
                ViewParent parent = customScreen[i].getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    if (userLayout) {
                        if (userStats == true)  {                          
                            Intent intent = new Intent(Keys.PIP_REMOVED);
                            LauncherApplication.sApp.sendBroadcast(intent);
                        }  
                    }
                    ((ViewGroup) parent).removeView(customScreen[i]);
                }
                addView(customScreen[i], i);
            }
        }

        if (userLayout) {
            if (leftBar) {
                absoluteLayout = (AbsoluteLayout) this.findViewById(R.id.user_layout_left);
            } else {
                absoluteLayout = (AbsoluteLayout) this.findViewById(R.id.user_layout);
            }  
        }
        int startPage = Integer.parseInt(mPrefs.getString(Keys.START_PAGE, "1"));
        if (getChildCount() >= startPage) {
            setCurrentPage(startPage - 1);
        } else {
            int index = getPageIndexForScreenId(CUSTOM_CONTENT_SCREEN_ID1);
            setCurrentPage(index);
        }

        if (userLayout && widgetBar) {
            // Music bar buttons
            mLauncher.bindMusicBarOnclickListener(mBarMusicWidget);

            // Weather
            mLauncher.initBarWeatherView(mBarWeatherWidget);

            mainHandler.post(() -> {
                mLauncher.updateWeather();              
            });

            // Bar text sizes
            setWidgetBarTextView(workspaceView);
        }

        new CanbusAsyncTask(LauncherApplication.sApp).execute();

        invalidate();
    }

    private void setWidgetBarTextView(View barView) {
        titleText = (TextView) barView.findViewById(R.id.tv_musicName_two);
        if (titleText != null) {
            adjustTextSize(titleText, 1.0f);
        }
        artistText = (TextView) barView.findViewById(R.id.tv_artist_two);
        if (artistText != null) {
            adjustTextSize(artistText, 1.0f);
        }
        cityText = (TextView) barView.findViewById(R.id.weather_city1);
        if (cityText != null) {
            adjustTextSize(cityText, 0.65f);
        }
        weatherText = (TextView) barView.findViewById(R.id.weather_weather1);
        if (weatherText != null) {
            adjustTextSize(weatherText, 0.65f);
        }
        tempText = (TextView) barView.findViewById(R.id.weather_temp1);
        if (tempText != null) {
            adjustTextSize(tempText, 0.65f);
        }
        if (blackTintBar) {
            if (titleText != null) {
                titleText.setTextColor(Color.BLACK);
            }
            if (artistText != null) {
                artistText.setTextColor(Color.BLACK);
            }
            if (cityText != null) {
                cityText.setTextColor(Color.BLACK);
            }
            if (weatherText != null) {
                weatherText.setTextColor(Color.BLACK);
            }
            if (tempText != null) {
                tempText.setTextColor(Color.BLACK);
            }
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (dateText != null) {
                    dateText.setTextColor(Color.BLACK);
                }
                if (weekText != null) {
                    weekText.setTextColor(Color.BLACK);
                }
            }
        }
    }

    private void adjustTextSize(View view, float targetSize) {
        view.post(() -> {
            if (!(view instanceof TextView)) return;

            TextView textView = (TextView) view;
            View parent = (View) textView.getParent();
            if (parent == null) return;

            int parentHeight = parent.getHeight();
            if (parentHeight <= 0) return;

            // Count TextViews in parent
            int textViewCount = 0;
            if (parent instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) parent;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    if (vg.getChildAt(i) instanceof TextView) {
                        textViewCount++;
                    }
                }
            }
            if (textViewCount == 0) return;

            // Real height constraint per TextView (in px)
            int targetHeight = (int) ((parentHeight / textViewCount) * targetSize);

            // Reserve space for TextView paddings so our measurement is the true text area
            int verticalPadding = textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
            int availableHeightForText = Math.max(0, targetHeight - verticalPadding);

            textView.setMaxHeight(targetHeight);

            float minSize = 1f;
            float maxSize = 300f;
            float bestSize = minSize;

            TextPaint paint = new TextPaint(textView.getPaint());

            // Use textView's resources for display metrics (safer than getResources())
            DisplayMetrics dm = textView.getResources().getDisplayMetrics();

            while (maxSize - minSize > 0.5f) {
                float testSize = (minSize + maxSize) / 2f;
                paint.setTextSize(
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP,
                        testSize,
                        dm
                    )
                );

                Paint.FontMetrics fm = paint.getFontMetrics();
                // Use full font bounds (bottom - top) to include descenders/extra glyph bounds
                float textHeight = fm.bottom - fm.top;

                if (textHeight <= availableHeightForText) {
                    bestSize = testSize;
                    minSize = testSize;
                } else {
                    maxSize = testSize;
                }
            }

            // Make sure TextView reserves font padding for descent/ascents
            textView.setIncludeFontPadding(true);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, bestSize);
        });
    }

    private static int getResId(String resName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return R.drawable.app_list_bg;
        }
    }

    public void toggleBottomBar() {
        synchronized (overlayLock) {
            // Prevent multiple simultaneous calls
            if (isOverlayAnimating) {
                return;
            }

            showBarIcon = workspaceView.findViewById(R.id.show_bar);

            if (bottomBarAllApps.getVisibility() == View.VISIBLE) {
                // Hide the normal bottom bar
                final int screenWidth = mLauncher.screenWidth;
                int collapsedWidth;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    collapsedWidth = (int) (0.071 * screenWidth);
                } else {
                    collapsedWidth = mLauncher.calculatedLeftBarWidth;
                }
                hideNormalBottomBar(collapsedWidth);
            } else {
                // Prevent showing if already showing or animating
                if (isOverlayShowing || isOverlayAnimating) {
                    return;
                }
                isOverlayAnimating = true;

                if (showBarIcon != null && showBarIcon.getVisibility() == View.VISIBLE) {
                    showBarIcon.animate()
                        .alpha(0f)
                        .setDuration(0)
                        .withEndAction(() -> showBarIcon.setVisibility(View.INVISIBLE))
                        .start();
                }
                if (bottomBarBg != null && bottomBarBg.getVisibility() == View.VISIBLE) {
                    bottomBarBg.animate()
                        .alpha(0f)
                        .setDuration(0)
                        .withEndAction(() -> bottomBarBg.setVisibility(View.INVISIBLE))
                        .start();
                }

                if (widgetBar) {
                    if (workspaceView != null) {
                        mBarMusicWidget = workspaceView.findViewById(R.id.rl_music_two);
                        mBarWeatherWidget = workspaceView.findViewById(R.id.bar_widget_weather);
                        if (mBarMusicWidget != null) mBarMusicWidget.setVisibility(View.INVISIBLE);
                        if (mBarWeatherWidget != null) mBarWeatherWidget.setVisibility(View.INVISIBLE);
                        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            mBarDateWidget = workspaceView.findViewById(R.id.bar_widget_date);
                            if (mBarDateWidget != null) mBarDateWidget.setVisibility(View.INVISIBLE);
                        }
                    }
                }
                // Show using overlay
                showOverlayBottomBar();
            }
        }
    }

    public void hideBottomBar() {
        final int screenWidth = mLauncher.screenWidth;
        int collapsedWidth;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            collapsedWidth = (int) (0.071 * screenWidth);
        } else {
            collapsedWidth = mLauncher.calculatedLeftBarWidth;
        }
        hideNormalBottomBar(collapsedWidth);      
        hideOverlayBottomBar(); 
    }

    private void hideNormalBottomBar(int collapsedWidth) {
        bottomBarRecycler.animate()
                .alpha(0f)
                .setDuration(0)
                .withEndAction(() -> bottomBarRecycler.setVisibility(View.INVISIBLE))
                .start();

        bottomBarAllApps.animate()
                .alpha(0f)
                .setDuration(0)
                .withEndAction(() -> {
                    bottomBarAllApps.setVisibility(View.INVISIBLE);
                    showBarIcon.setAlpha(0f);
                    showBarIcon.setVisibility(View.VISIBLE);
                    blackTintBar = mPrefs.getBoolean(Keys.BLACK_BAR, false);
                    if (blackTintBar) {
                        Helpers.applyColorFilterToImageView(showBarIcon);
                    } else {
                        Helpers.removeColorFilterFromImageView(showBarIcon);
                    }
                    showBarIcon.animate().alpha(0.5f).setDuration(0).start();
                })
                .start();

        if (widgetBar) {
            if (workspaceView != null) {
                mBarMusicWidget = workspaceView.findViewById(R.id.rl_music_two);
                mBarWeatherWidget = workspaceView.findViewById(R.id.bar_widget_weather);
                if (mBarMusicWidget != null) mBarMusicWidget.setVisibility(View.INVISIBLE);
                if (mBarWeatherWidget != null) mBarWeatherWidget.setVisibility(View.INVISIBLE);
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    mBarDateWidget = workspaceView.findViewById(R.id.bar_widget_date);
                    if (mBarDateWidget != null) mBarDateWidget.setVisibility(View.INVISIBLE);
                }
            }
        }

        final int screenWidth = mLauncher.screenWidth;
        final int screenHeight = mLauncher.screenHeight;
        int bottomBarHeight;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            bottomBarHeight = (int) (screenWidth * 0.142);
        } else {
            bottomBarHeight = (int) ((screenHeight - mLauncher.getStatusBarHeight()) * 0.1638);
        }
        Log.d("BottomBar", "Before: width=" + bottomBarBg.getWidth() + ", height=" + bottomBarBg.getHeight());
        ValueAnimator widthAnim = ValueAnimator.ofInt(bottomBarBg.getWidth(), collapsedWidth);
        widthAnim.addUpdateListener(animator -> {
            ViewGroup.LayoutParams params = bottomBarBg.getLayoutParams();
            params.width = (int) animator.getAnimatedValue();
            params.height = bottomBarHeight;
            bottomBarBg.setLayoutParams(params);
        });
        widthAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnim.setDuration(0);
        widthAnim.start();

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(showBarIcon, "scaleX", 1f, 0.85f, 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(showBarIcon, "scaleY", 1f, 0.85f, 1f);
        scaleDownX.setDuration(0);
        scaleDownY.setDuration(0);
        scaleDownX.start();
        scaleDownY.start();
        Log.d("BottomBar", "After: width=" + bottomBarBg.getWidth() + ", height=" + bottomBarBg.getHeight());
    }

    private void showOverlayBottomBar() {
        synchronized (overlayLock) {
            if (overlayBottomBar != null) {
                if (isOverlayShowing) {
                    return;
                } else {
                    cleanupOverlayImmediately();
                }
            }
            overlayWindowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

            // Calculate dimensions
            int screenWidth = mLauncher.screenWidth;
            int screenHeight = mLauncher.screenHeight;
            int bottomBarHeight;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                bottomBarHeight = (int) (screenWidth * 0.142);
            } else {
                bottomBarHeight = (int) ((screenHeight - mLauncher.getStatusBarHeight()) * 0.1638);
            }

            // Create overlay window parameters
            overlayWindowParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    bottomBarHeight,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                    PixelFormat.TRANSLUCENT
            );

            // Only touch layoutInDisplayCutoutMode on API 28+ (Android P) to avoid Lint/runtime issues
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                overlayWindowParams.layoutInDisplayCutoutMode =
                        WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            }

            overlayWindowParams.gravity = Gravity.BOTTOM;

            LayoutInflater inflater = LayoutInflater.from(getContext());

            // Choose layout based on widgetBar setting
            if (widgetBar) {
                overlayBottomBar = inflater.inflate(R.layout.custom_layout_two_user, null);
            } else {
                overlayBottomBar = inflater.inflate(R.layout.custom_layout_one_user, null);
            }

            overlayBottomBar.setOnApplyWindowInsetsListener((v, insets) -> {
                int bottomInset = insets.getSystemWindowInsetBottom();

                // Extend the bar into the nav bar area
                ViewGroup.LayoutParams lp = v.getLayoutParams();
                lp.height = bottomBarHeight + bottomInset;
                v.setLayoutParams(lp);

                // Optional: push content up so buttons stay visible
                v.setPadding(
                        v.getPaddingLeft(),
                        v.getPaddingTop(),
                        v.getPaddingRight(),
                        bottomInset
                );

                return insets.consumeSystemWindowInsets();
            });

            ImageView overlayAllApps = overlayBottomBar.findViewById(R.id.rl_allapps);
            blackTintBar = mPrefs.getBoolean(Keys.BLACK_BAR, false);
            if (blackTintBar) {
                Helpers.applyColorFilterToImageView(overlayAllApps);
            }

            // Setup the overlay view
            setupOverlayView(screenWidth, bottomBarHeight);

            // Add to window manager
            try {
                overlayWindowManager.addView(overlayBottomBar, overlayWindowParams);
                isOverlayShowing = true;
                overlayBottomBar.post(() ->
                        overlayBottomBar.requestApplyInsets()
                );
                showOverlayWithAnimation();
                setupAutoHideForOverlay();
            } catch (Exception e) {
                Log.e("OverlayBottomBar", "Failed to add overlay view", e);
                cleanupOverlayImmediately();
            } finally {
                isOverlayAnimating = false;
            }
            mainHandler.post(() -> {
                mLauncher.updateWeather();
                mLauncher.enableRecycler();
            });
        }
    }

    private void setupOverlayView(int screenWidth, int bottomBarHeight) {
        AbsoluteLayout userLayout = overlayBottomBar.findViewById(R.id.user_layout);
        if (userLayout != null) {
            userLayout.setVisibility(View.GONE);
        }
        
        RecyclerView overlayRecycler = overlayBottomBar.findViewById(R.id.recycler_view);
        ImageView overlayAllApps = overlayBottomBar.findViewById(R.id.rl_allapps);
        ImageView overlayBg = overlayBottomBar.findViewById(R.id.iv_list_bg);

        selectedBackground = mPrefs.getString(Keys.BAR_SELECTED_BACKGROUND, "app_list_bg");
        if (!selectedBackground.equals("app_list_bg")) {
            overlayBg.setImageResource(getResId(selectedBackground));
        }
        
        forceOriginalSizes(screenWidth, bottomBarHeight);
        
        // Setup RecyclerView
        overlayRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        if (bottomBarRecycler.getAdapter() != null) {
            setupRecyclerView(bottomBarRecycler, overlayRecycler);
        }
        
        // Setup widget bar if enabled
        if (widgetBar) {
            setupOverlayWidgetBar();
        }
        
        overlayAllApps.setOnClickListener(v -> {
            hideOverlayBottomBar();
            mLauncher.onClickAllAppsButton();
        });

        overlayBottomBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                hideOverlayBottomBar();
                return true;
            }
            return false;
        });
    }

    private void setupOverlayWidgetBar() {
        ViewGroup musicWidget = overlayBottomBar.findViewById(R.id.rl_music_two);
        if (musicWidget != null) {
            mLauncher.initMusicBarView(musicWidget);
            mLauncher.preSetMusicWidgets();
            mLauncher.bindMusicBarOnclickListener(musicWidget);
        }

        ViewGroup weatherWidget = overlayBottomBar.findViewById(R.id.bar_widget_weather);
        if (weatherWidget != null) {
            mLauncher.initBarWeatherView(weatherWidget);
            mLauncher.showWeatherInfo();
        }
        
        setWidgetBarTextView(overlayBottomBar);
    }

    private void forceOriginalSizes(int screenWidth, int bottomBarHeight) {
        if (widgetBar) {
            forceOriginalSizesLayoutTwo(screenWidth, bottomBarHeight);
        } else {
            forceOriginalSizesLayoutOne(screenWidth, bottomBarHeight);
        }
    }

    private void forceOriginalSizesLayoutOne(int screenWidth, int bottomBarHeight) {    
        int allAppsWidth, allAppsHeight;
        int recyclerWidth, recyclerHeight;
        int showBarWidth, showBarHeight;
        
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            allAppsWidth = (int) (screenWidth * 0.11);
            allAppsHeight = (int) (bottomBarHeight * 0.67);
            
            recyclerWidth = (int) (screenWidth * 0.8795);
            recyclerHeight = (int) (recyclerWidth * 0.142);
            
            showBarWidth = (int) (screenWidth * 0.06);
            showBarHeight = (int) (bottomBarHeight * 0.67);
        } else {
            allAppsWidth = (int) (screenWidth * 0.11);
            allAppsHeight = (int) (bottomBarHeight * 0.67);
            
            recyclerWidth = (int) (screenWidth * 0.8795);
            recyclerHeight = bottomBarHeight;
            
            showBarWidth = (int) (screenWidth * 0.06);
            showBarHeight = (int) (bottomBarHeight * 0.67);
        }
            
        // Apply forced dimensions
        ImageView overlayAllApps = overlayBottomBar.findViewById(R.id.rl_allapps);
        RecyclerView overlayRecycler = overlayBottomBar.findViewById(R.id.recycler_view);
        ImageView overlayShowBar = overlayBottomBar.findViewById(R.id.show_bar);
        ImageView overlayBg = overlayBottomBar.findViewById(R.id.iv_list_bg);
        
        // Force background to full size
        ViewGroup.LayoutParams bgParams = overlayBg.getLayoutParams();
        bgParams.width = screenWidth;
        bgParams.height = bottomBarHeight;
        overlayBg.setLayoutParams(bgParams);
        
        // Force all apps button size
        ViewGroup.LayoutParams allAppsParams = overlayAllApps.getLayoutParams();
        if (allAppsParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) allAppsParams;
            constraintParams.width = allAppsWidth;
            constraintParams.height = allAppsHeight;
            constraintParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayAllApps.setLayoutParams(constraintParams);
        }
        
        // Force recycler view size
        ViewGroup.LayoutParams recyclerParams = overlayRecycler.getLayoutParams();
        if (recyclerParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) recyclerParams;
            constraintParams.width = recyclerWidth;
            constraintParams.height = recyclerHeight;
            constraintParams.startToEnd = R.id.rl_allapps;
            constraintParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayRecycler.setLayoutParams(constraintParams);
        }
        
        // Force show bar icon size and position
        ViewGroup.LayoutParams showBarParams = overlayShowBar.getLayoutParams();
        if (showBarParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) showBarParams;
            constraintParams.width = showBarWidth;
            constraintParams.height = showBarHeight;
            constraintParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayShowBar.setLayoutParams(constraintParams);
        }
    }

    private void forceOriginalSizesLayoutTwo(int screenWidth, int bottomBarHeight) {
        int allAppsWidth, allAppsHeight;
        int recyclerWidth, recyclerHeight;
        int showBarWidth, showBarHeight;
        int musicWidgetWidth, dateWidgetWidth, weatherWidgetWidth;
        
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            allAppsWidth = (int) (screenWidth * 0.1);
            allAppsHeight = (int) (bottomBarHeight * 0.67);
            
            recyclerWidth = (int) (screenWidth * 0.4385);
            recyclerHeight = (int) (recyclerWidth * 0.295);
            
            showBarWidth = (int) (screenWidth * 0.06);
            showBarHeight = (int) (bottomBarHeight * 0.67);
            
            musicWidgetWidth = (int) (screenWidth * 0.295);
            dateWidgetWidth = (int) (screenWidth * 0.05);
            weatherWidgetWidth = (int) (screenWidth * 0.15);
        } else {
            allAppsWidth = (int) (screenWidth * 0.09);
            allAppsHeight = (int) (bottomBarHeight * 0.67);
            
            recyclerWidth = (int) (screenWidth * 0.4395);
            recyclerHeight = bottomBarHeight;
            
            showBarWidth = (int) (screenWidth * 0.06);
            showBarHeight = (int) (bottomBarHeight * 0.67);
            
            musicWidgetWidth = (int) (screenWidth * 0.28);
            dateWidgetWidth = (int) (screenWidth * 0.05);
            weatherWidgetWidth = (int) (screenWidth * 0.12);
        }
        
        // Apply forced dimensions
        ImageView overlayAllApps = overlayBottomBar.findViewById(R.id.rl_allapps);
        RecyclerView overlayRecycler = overlayBottomBar.findViewById(R.id.recycler_view);
        ImageView overlayShowBar = overlayBottomBar.findViewById(R.id.show_bar);
        ImageView overlayBg = overlayBottomBar.findViewById(R.id.iv_list_bg);
        ViewGroup musicWidget = overlayBottomBar.findViewById(R.id.rl_music_two);            
        ViewGroup weatherWidget = overlayBottomBar.findViewById(R.id.bar_widget_weather);
        
        // Force background to full size
        ViewGroup.LayoutParams bgParams = overlayBg.getLayoutParams();
        bgParams.width = screenWidth;
        bgParams.height = bottomBarHeight;
        overlayBg.setLayoutParams(bgParams);
        
        // Force all apps button size
        ViewGroup.LayoutParams allAppsParams = overlayAllApps.getLayoutParams();
        if (allAppsParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) allAppsParams;
            constraintParams.width = allAppsWidth;
            constraintParams.height = allAppsHeight;
            constraintParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayAllApps.setLayoutParams(constraintParams);
        }
        
        // Force recycler view size
        ViewGroup.LayoutParams recyclerParams = overlayRecycler.getLayoutParams();
        if (recyclerParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) recyclerParams;
            constraintParams.width = recyclerWidth;
            constraintParams.height = recyclerHeight;
            constraintParams.startToEnd = R.id.rl_allapps;
            constraintParams.endToStart = R.id.rl_music_two;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayRecycler.setLayoutParams(constraintParams);
        }
        
        // Force music widget size
        if (musicWidget != null) {
            ViewGroup.LayoutParams musicParams = musicWidget.getLayoutParams();
            if (musicParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) musicParams;
                constraintParams.width = musicWidgetWidth;
                constraintParams.height = bottomBarHeight;
                constraintParams.startToEnd = R.id.recycler_view;
                constraintParams.endToStart = R.id.bar_widget_date;
                constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
                constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                musicWidget.setLayoutParams(constraintParams);
            }
        }

        // Force date widget size
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ViewGroup dateWidget = overlayBottomBar.findViewById(R.id.bar_widget_date);
            if (dateWidget != null) {
                ViewGroup.LayoutParams dateParams = dateWidget.getLayoutParams();
                if (dateParams instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) dateParams;
                    constraintParams.width = dateWidgetWidth;
                    constraintParams.height = bottomBarHeight;
                    constraintParams.startToEnd = R.id.rl_music_two;
                    constraintParams.endToStart = R.id.bar_widget_weather;
                    constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
                    constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                    dateWidget.setLayoutParams(constraintParams);
                }
            }
        }        
        
        // Force weather widget size
        if (weatherWidget != null) {
            ViewGroup.LayoutParams weatherParams = weatherWidget.getLayoutParams();
            if (weatherParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) weatherParams;
                constraintParams.width = weatherWidgetWidth;
                constraintParams.height = bottomBarHeight;
                constraintParams.startToEnd = R.id.bar_widget_date;
                constraintParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
                constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
                constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                weatherWidget.setLayoutParams(constraintParams);
            }
        }
        
        // Force show bar icon size and position
        ViewGroup.LayoutParams showBarParams = overlayShowBar.getLayoutParams();
        if (showBarParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams constraintParams = (ConstraintLayout.LayoutParams) showBarParams;
            constraintParams.width = showBarWidth;
            constraintParams.height = showBarHeight;
            constraintParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            constraintParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            overlayShowBar.setLayoutParams(constraintParams);
        }
    }

    private void setupRecyclerView(RecyclerView mBottomRecycler, RecyclerView mOverlayRecycler) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(LauncherApplication.sApp);
        layoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.HORIZONTAL);
        mOverlayRecycler.setLayoutManager(layoutManager);
        
        // Check if decoration already added to prevent duplicates
        if (mOverlayRecycler.getTag() == null) {
            mOverlayRecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
                private int cachedSpacing = -1;
                private boolean hasCalculated = false;
                
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    
                    int itemCount = parent.getAdapter() != null ? parent.getAdapter().getItemCount() : 0;
                    if (itemCount == 0) return;
                    
                    // Only calculate once when view has actual width
                    if (!hasCalculated && view.getWidth() > 0) {
                        int itemWidth = view.getWidth();
                        
                        // Get available width
                        int availableWidth = (int) (mLauncher.screenWidth * 0.8795f);
                        if (widgetBar) {
                            availableWidth = (int) (mLauncher.screenWidth * 0.4395f);
                        }   
                        
                        // Calculate total width needed for all items
                        int totalItemsWidth = itemWidth * itemCount;
                        
                        // Calculate total spacing available
                        int totalSpacing = availableWidth - totalItemsWidth;  

                        // Distribute spacing: (itemCount + 1) gaps to include edges
                        int spacingPerGap = totalSpacing / (itemCount + 1);

                        int adjustedSpacing = spacingPerGap / 2;
                        if (spacingPerGap < 0) {
                            adjustedSpacing = (int) (spacingPerGap / 1.5f);
                        }
                        
                        cachedSpacing = adjustedSpacing;
                        hasCalculated = true;
                    }
                    
                    // Use cached spacing for all items (or 0 if not calculated yet)
                    outRect.left = cachedSpacing;
                    outRect.right = cachedSpacing;
                }
            });
            mOverlayRecycler.addItemDecoration(new SimpleDividerDecoration());
            mOverlayRecycler.setTag(1);
        }
        
        // Force recalculation after layout
        mOverlayRecycler.post(() -> {
            mOverlayRecycler.invalidateItemDecorations();
        });
        
        mOverlayRecycler.setAdapter(mBottomRecycler.getAdapter());
    }

    private void showOverlayWithAnimation() {
        if (overlayBottomBar == null) return;
        
        // Start with invisible and animate in
        overlayBottomBar.setAlpha(0f);
        overlayBottomBar.setVisibility(View.VISIBLE);
        
        overlayBottomBar.animate()
                .alpha(1f)
                .setDuration(250)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
                
        // Show all apps icon in overlay
        ImageView overlayAllApps = overlayBottomBar.findViewById(R.id.rl_allapps);
        ImageView overlayShowBar = overlayBottomBar.findViewById(R.id.show_bar);
        
        overlayShowBar.setVisibility(View.INVISIBLE);
        overlayAllApps.setVisibility(View.VISIBLE);
        overlayAllApps.setAlpha(1f);
        
        // Bounce animation for all apps icon
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(overlayAllApps, "scaleX", 1f, 1.1f, 1f);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(overlayAllApps, "scaleY", 1f, 1.1f, 1f);
        scaleUpX.setDuration(250);
        scaleUpY.setDuration(250);
        scaleUpX.start();
        scaleUpY.start();
    }

    public void hideOverlayBottomBar() {
        synchronized (overlayLock) {
            if (isOverlayAnimating) {
                return;
            }
            
            isOverlayAnimating = true;
            
            if (overlayBottomBar != null && overlayWindowManager != null) {
                // Clean up RecyclerView first to break the reference chain
                cleanupOverlayRecyclerView();
                
                // Cancel any pending auto-hide first
                cancelPendingAutoHide();
                
                // Animate out and remove
                overlayBottomBar.animate()
                        .alpha(0f)
                        .setDuration(0)
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .withEndAction(() -> {
                            synchronized (overlayLock) {
                                try {
                                    overlayWindowManager.removeView(overlayBottomBar);
                                } catch (Exception e) {
                                    Log.e("OverlayBottomBar", "Error removing overlay", e);
                                }
                                // Clear all overlay references
                                clearOverlayReferences();
                                isOverlayShowing = false;
                                isOverlayAnimating = false;
                            }
                        })
                        .start();
            } else {
                // No overlay to hide, just reset state
                isOverlayShowing = false;
                isOverlayAnimating = false;
            }
        }
        
        // Also make sure to cancel any pending auto-hide (outside sync for thread safety)
        cancelPendingAutoHide();

        if (showBarIcon != null && showBarIcon.getVisibility() == View.INVISIBLE) {
            showBarIcon.animate()
                .alpha(0.5f)
                .setDuration(0)
                .withEndAction(() -> showBarIcon.setVisibility(View.VISIBLE))
                .start();
                if (blackTintBar) {
                    Helpers.applyColorFilterToImageView(showBarIcon);
                } else {
                    Helpers.removeColorFilterFromImageView(showBarIcon);
                }
        }
        if (bottomBarBg != null && bottomBarBg.getVisibility() == View.INVISIBLE) {
            bottomBarBg.animate()
                .alpha(1f)
                .setDuration(0)
                .withEndAction(() -> bottomBarBg.setVisibility(View.VISIBLE))
                .start();
        }

        if (mLauncher != null) {
            new Handler(Looper.getMainLooper()).post(() -> {
                mLauncher.disableRecycler();
            });
        }
    }

    private void clearOverlayReferences() {
        if (mLauncher != null) {
            mLauncher.clearBarWidgetReferences();
            mLauncher.removeCustomView(Config.WS_Music_Two);
        }

        mLauncher.cleanWidgetBar();
        
        // Clear widget references that might point to overlay views
        clearWidgetReferences();
        
        // Clear overlay view references
        overlayBottomBar = null;
        overlayWindowParams = null;
        overlayWindowManager = null;
        
        // Re-initialize widget references to point to normal workspace views
        if (workspaceView != null && widgetBar) {
            mBarMusicWidget = workspaceView.findViewById(R.id.rl_music_two);
            mBarWeatherWidget = workspaceView.findViewById(R.id.bar_widget_weather);
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                mBarDateWidget = workspaceView.findViewById(R.id.bar_widget_date);
            }            
            
            // Re-initialize text views
            setWidgetBarTextView(workspaceView);
        }
    }

    private void cleanupOverlayImmediately() {
        synchronized (overlayLock) {
            if (overlayBottomBar != null && overlayWindowManager != null) {
                try {
                    cleanupOverlayRecyclerView();
                    overlayWindowManager.removeView(overlayBottomBar);
                } catch (Exception e) {
                    Log.e("OverlayBottomBar", "Error in immediate cleanup", e);
                }
            }
            clearOverlayReferences();
            isOverlayAnimating = false;
        }
        cancelPendingAutoHide();
    }

    private void cleanupOverlayRecyclerView() {
        if (overlayBottomBar == null) return;
        
        RecyclerView overlayRecycler = overlayBottomBar.findViewById(R.id.recycler_view);
        if (overlayRecycler != null) {
            // Clear adapter and break reference chain
            RecyclerView.Adapter adapter = overlayRecycler.getAdapter();
            if (adapter != null) {
                overlayRecycler.setAdapter(null);
            }
            
            // Clear layout manager
            overlayRecycler.setLayoutManager(null);
            
            // Remove all item decorations
            for (int i = overlayRecycler.getItemDecorationCount() - 1; i >= 0; i--) {
                overlayRecycler.removeItemDecorationAt(i);
            }
            
            // Clear all listeners
            overlayRecycler.clearOnScrollListeners();
            overlayRecycler.setOnTouchListener(null);
            overlayRecycler.setOnClickListener(null);
            
            // Remove all child views
            overlayRecycler.removeAllViews();
            
            // Clear the tag
            overlayRecycler.setTag(null);
        }
        
        // Enhanced widget cleanup
        cleanupOverlayWidgetBar();
    }

    private void cleanupOverlayWidgetBar() {
        if (overlayBottomBar == null) return;
        
        if (mLauncher != null) {
            mLauncher.clearBarWidgetReferences();
            mLauncher.removeCustomView(Config.WS_Music_Two);
        }
        
        // Cleanup music widget
        ViewGroup musicWidget = overlayBottomBar.findViewById(R.id.rl_music_two);
        if (musicWidget != null) {
            cleanupViewGroupRecursively(musicWidget);
        }
        
        // Cleanup weather widget  
        ViewGroup weatherWidget = overlayBottomBar.findViewById(R.id.bar_widget_weather);
        if (weatherWidget != null) {
            cleanupViewGroupRecursively(weatherWidget);
        }
        
        // Cleanup date widget
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ViewGroup dateWidget = overlayBottomBar.findViewById(R.id.bar_widget_date);
            if (dateWidget != null) {
                cleanupViewGroupRecursively(dateWidget);
            }
        } 
    }

    private void cleanupViewGroupRecursively(ViewGroup viewGroup) {
        if (viewGroup == null) return;
        
        // Clear listeners from the parent
        viewGroup.setOnClickListener(null);
        viewGroup.setOnTouchListener(null);
        viewGroup.setOnLongClickListener(null);
        
        // Recursively cleanup all children
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                cleanupViewGroupRecursively((ViewGroup) child);
            } else {
                // Clear listeners from child views
                child.setOnClickListener(null);
                child.setOnTouchListener(null);
                child.setOnLongClickListener(null);
            }
        }
    }

    private void cleanupAllResources() {
        // Cancel any pending operations
        cancelPendingAutoHide();
        
        // Clean up overlay
        if (isOverlayShowing) {
            cleanupOverlayImmediately();
        }
        
        // Clean up widget references
        clearWidgetReferences();
        
        // Clean up workspace view references
        if (workspaceView != null) {
            cleanupViewGroupRecursively((ViewGroup) workspaceView);
            workspaceView = null;
        }
        
        // Clear RecyclerView adapter references
        if (bottomBarRecycler != null) {
            bottomBarRecycler.setAdapter(null);
            bottomBarRecycler.setLayoutManager(null);
        }
        
        // Clear other view references
        bottomBarAllApps = null;
        bottomBarRecycler = null;
        bottomBarBg = null;
        showBarIcon = null;
        absoluteLayout = null;
    }

    private void setupAutoHideForOverlay() {
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        }
        autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        if (autoHideBottomBar) {
            scheduleAutoHide();
        }
    }

    public void scheduleAutoHide() {
        cancelPendingAutoHide(); 
        autoHideTimeout = mPrefs.getInt(Keys.AUTO_HIDE_TIMEOUT, 3);
        autoHideFuture = scheduler.schedule(() -> {
            synchronized (overlayLock) {
                if (isOverlayShowing && !isOverlayAnimating) {
                    mainHandler.post(() -> hideOverlayBottomBar());
                }
            }
        }, autoHideTimeout, TimeUnit.SECONDS);
    }

    public void cancelPendingAutoHide() {
        if (autoHideFuture != null && !autoHideFuture.isDone()) {
            autoHideFuture.cancel(false);
        }
    }

    public void clearWidgetReferences() {
        // Clear instance references
        mBarMusicWidget = null;
        mBarWeatherWidget = null; 
        mBarDateWidget = null;
        titleText = null;
        artistText = null;
        cityText = null;
        weatherText = null;
        tempText = null;
        dateText = null;
        weekText = null;
        
        if (mLauncher != null) {
            mLauncher.weatherCity1 = null;
            mLauncher.weatherImg1 = null;
            mLauncher.weatherWeather1 = null;
            mLauncher.weatherTemp1 = null;
        }
    }

    public void onWorkspaceDestroy() {
        mLauncher = null;
        mIconCache = null;
        mDragController = null;

        hideOverlayBottomBar();
        cancelPendingAutoHide();
        clearWidgetReferences();

        if (mBindPages != null) {
            removeCallbacks(mBindPages);
        }

        try {
            Class<?> dateClass = Class.forName("com.fyt.widget.Date");
            java.lang.reflect.Field dateField = dateClass.getDeclaredField("mDate");
            dateField.setAccessible(true);
            dateField.set(null, null);
        } catch (Exception e) {
            Log.w(TAG, "Could not clear static Date reference: " + e.getMessage());
        }
    }

    public void createCustomContentPage() {
        Log.i("PAGE", "createCustomContentPage()");
        CellLayout customScreen = (CellLayout)
                mLauncher.getLayoutInflater().inflate(R.layout.workspace_screen, null);

        mWorkspaceScreens.put(CUSTOM_CONTENT_SCREEN_ID, customScreen);
        mScreenOrder.add(0, CUSTOM_CONTENT_SCREEN_ID);

        addFullScreenPage(customScreen);

        // Ensure that the current page and default page are maintained.
        mDefaultPage = mOriginalDefaultPage + 1;

        // Update the custom content hint
        mLauncher.updateCustomContentHintVisibility();
        if (mRestorePage != INVALID_RESTORE_PAGE) {
            mRestorePage = mRestorePage + 1;
        } else {
            setCurrentPage(getCurrentPage() + 1);
        }
    }

    public void removeCustomContentPage() {
        CellLayout customScreen = getScreenWithId(CUSTOM_CONTENT_SCREEN_ID);
        if (customScreen == null) {
            throw new RuntimeException("Expected custom content screen to exist");
        }

        mWorkspaceScreens.remove(CUSTOM_CONTENT_SCREEN_ID);
        mScreenOrder.remove(CUSTOM_CONTENT_SCREEN_ID);
        removeView(customScreen);

        if (mCustomContentCallbacks != null) {
            mCustomContentCallbacks.onScrollProgressChanged(0);
            mCustomContentCallbacks.onHide();
        }

        mCustomContentCallbacks = null;

        // Ensure that the current page and default page are maintained.
        mDefaultPage = mOriginalDefaultPage - 1;

        // Update the custom content hint
        mLauncher.updateCustomContentHintVisibility();
        if (mRestorePage != INVALID_RESTORE_PAGE) {
            mRestorePage = mRestorePage - 1;
        } else {
            setCurrentPage(getCurrentPage() - 1);
        }
    }

    public void addToCustomContentPage(View customContent, CustomContentCallbacks callbacks,
            String description) {
        if (getPageIndexForScreenId(CUSTOM_CONTENT_SCREEN_ID) < 0) {
            throw new RuntimeException("Expected custom content screen to exist");
        }

        // Add the custom content to the full screen custom page
        CellLayout customScreen = getScreenWithId(CUSTOM_CONTENT_SCREEN_ID);
        int spanX = customScreen.getCountX();
        int spanY = customScreen.getCountY();
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(0, 0, spanX, spanY);
        lp.canReorder  = false;
        lp.isFullscreen = true;
        if (customContent instanceof Insettable) {
            ((Insettable)customContent).setInsets(mInsets);
        }
        customScreen.removeAllViews();
        customScreen.addViewToCellLayout(customContent, 0, 0, lp, true);
        mCustomContentDescription = description;

        mCustomContentCallbacks = callbacks;
    }

    public void addExtraEmptyScreenOnDrag() {
        boolean lastChildOnScreen = false;
        boolean childOnFinalScreen = false;

        if (mDragSourceInternal != null) {
            if (mDragSourceInternal.getChildCount() == 1) {
                lastChildOnScreen = true;
            }
            CellLayout cl = (CellLayout) mDragSourceInternal.getParent();
            if (indexOfChild(cl) == getChildCount() - 1) {
                childOnFinalScreen = true;
            }
        }

        // If this is the last item on the final screen
        if (lastChildOnScreen && childOnFinalScreen) {
            return;
        }
        if (!mWorkspaceScreens.containsKey(EXTRA_EMPTY_SCREEN_ID)) {
            insertNewWorkspaceScreen(EXTRA_EMPTY_SCREEN_ID);
        }
    }

    public boolean addExtraEmptyScreen() {
        if (!mWorkspaceScreens.containsKey(EXTRA_EMPTY_SCREEN_ID)) {
            insertNewWorkspaceScreen(EXTRA_EMPTY_SCREEN_ID);
            return true;
        }
        return false;
    }

    public void removeExtraEmptyScreen() {
        if (hasExtraEmptyScreen()) {
            CellLayout cl = mWorkspaceScreens.get(EXTRA_EMPTY_SCREEN_ID);
            mWorkspaceScreens.remove(EXTRA_EMPTY_SCREEN_ID);
            mScreenOrder.remove(EXTRA_EMPTY_SCREEN_ID);
            removeView(cl);
        }
    }

    public boolean hasExtraEmptyScreen() {
        int nScreens = getChildCount();
        nScreens = nScreens - numCustomPages();
        return mWorkspaceScreens.containsKey(EXTRA_EMPTY_SCREEN_ID) && nScreens > 1;
    }

    public long commitExtraEmptyScreen() {
        int index = getPageIndexForScreenId(EXTRA_EMPTY_SCREEN_ID);
        CellLayout cl = mWorkspaceScreens.get(EXTRA_EMPTY_SCREEN_ID);
        mWorkspaceScreens.remove(EXTRA_EMPTY_SCREEN_ID);
        mScreenOrder.remove(EXTRA_EMPTY_SCREEN_ID);

        long newId = LauncherAppState.getLauncherProvider().generateNewScreenId();
        mWorkspaceScreens.put(newId, cl);
        mScreenOrder.add(newId);

        // Update the page indicator marker
        if (getPageIndicator() != null) {
            getPageIndicator().updateMarker(index, getPageIndicatorMarker(index));
        }

        // Update the model for the new screen
        mLauncher.getModel().updateWorkspaceScreenOrder(mLauncher, mScreenOrder);

        return newId;
    }

    public CellLayout getScreenWithId(long screenId) {
        CellLayout layout = mWorkspaceScreens.get(screenId);
        return layout;
    }

    public long getIdForScreen(CellLayout layout) {
        // 1) Check existing mapping
        for (Map.Entry<Long, CellLayout> e : mWorkspaceScreens.entrySet()) {
            if (e.getValue() == layout) {
                return e.getKey();
            }
        }

        // 2) Infer ID from mScreenOrder / child index
        int index = indexOfChild(layout);
        if (index >= 0 && index < mScreenOrder.size()) {
            long screenId = mScreenOrder.get(index);
            // Repair missing map
            mWorkspaceScreens.put(screenId, layout);
            return screenId;
        }

        // 3) Check if layout is already present elsewhere in mScreenOrder
        for (Map.Entry<Long, CellLayout> entry : mWorkspaceScreens.entrySet()) {
            if (entry.getValue() != layout && mScreenOrder.contains(entry.getKey())) {
                continue; // skip IDs already assigned to other layouts
            }
        }

        // 4) Layout has no ID, assign a new ID 
        Long maxScreen = Math.abs(Collections.max(mScreenOrder));
        long newId;
        if (maxScreen == 302) {
            newId = 1;
        } else {
            newId = maxScreen + 1;
        }
        mScreenOrder.add(newId);
        mWorkspaceScreens.put(newId, layout);
        Log.i(TAG, "getIdForScreen(): assigned new virtual screenId=" + newId);
        return newId;
    }

    public int getPageIndexForScreenId(long screenId) {
        return indexOfChild(mWorkspaceScreens.get(screenId));
    }

    public long getScreenIdForPageIndex(int index) {
        if (0 <= index && index < mScreenOrder.size()) {
            return mScreenOrder.get(index);
        }
        return -1;
    }

    ArrayList<Long> getScreenOrder() {
        return mScreenOrder;
    }

    /**
     * This function might be called in multiple places. It's puropse is to avoid 
     * calling stripEmptyScreens() few times in a very short succesion
     */
    public void triggerStripEmptyScreens(String sourceClass, boolean instant) {
        Log.i(TAG, "triggerStripEmptyScreens called in: " + sourceClass);
        if (stripAction != null) {
            stripHandler.removeCallbacks(stripAction);
        }
        
        stripAction = () -> {
            stripEmptyScreens(sourceClass);
        };
        
        if (instant) {
            stripHandler.post(stripAction);
        } else {
            stripHandler.postDelayed(stripAction, STRIP_DELAY);
        }
    }

    public void stripEmptyScreens(String sourceClass) {
        Log.i(TAG, "stripEmptyScreens called in: " + sourceClass);
        if (isPageMoving()) {
            mStripScreensOnPageStopMoving = true;
            return;
        }

        int currentPage = getNextPage();
        ArrayList<Long> removeScreens = new ArrayList<>();
        CellLayout cl;

        // Detect empty screens (no widgets/shortcuts)
        for (Long id : mWorkspaceScreens.keySet()) {
            cl = mWorkspaceScreens.get(id);
            if (id >= 0 && cl.getShortcutsAndWidgets().getChildCount() == 0) {
                removeScreens.add(id);
            }
        }
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        
        ArrayList<Integer> customScreens = new ArrayList<>();
        if (mPrefs.getBoolean(Keys.USER_MUSIC, false)) {
            customScreens.add(mPrefs.getInt(Keys.MUSIC_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.USER_DATE, false)) {
            customScreens.add(mPrefs.getInt(Keys.DATE_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.USER_RADIO, false)) {
            customScreens.add(mPrefs.getInt(Keys.RADIO_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.PIP_DUAL, false)) {
            customScreens.add(mPrefs.getInt(Keys.PIP_DUAL_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.PIP_FIRST, false)) {
            customScreens.add(mPrefs.getInt(Keys.PIP_FIRST_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.PIP_SECOND, false)) {
            customScreens.add(mPrefs.getInt(Keys.PIP_SECOND_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.PIP_THIRD, false)) {
            customScreens.add(mPrefs.getInt(Keys.PIP_THIRD_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.PIP_FOURTH, false)) {
            customScreens.add(mPrefs.getInt(Keys.PIP_FOURTH_SCREEN, 1) - 1);
        }
        if (mPrefs.getBoolean(Keys.USER_STATS, false)) {
            customScreens.add(mPrefs.getInt(Keys.STATS_SCREEN, 1) - 1);
        }

        for (Integer rank : customScreens) {
            if (rank >= 0 && rank < mWorkspaceScreens.size()) {
                cl = ((CellLayout) getChildAt(rank));
                long customScreenId = getIdForScreen(cl);
                if (removeScreens.contains(customScreenId)) {
                    removeScreens.remove(customScreenId);
                }
            }
        }   

        cl = ((CellLayout) getChildAt(0));
        long customScreenId = getIdForScreen(cl);
        if (removeScreens.contains(customScreenId)) {
            removeScreens.remove(customScreenId);
        }

        int minScreens = 1 + numCustomPages();
        int pageShift = 0;

        // Take a snapshot of old screen order before removal
        ArrayList<Long> oldOrder = new ArrayList<>(mScreenOrder);

        // Remove empty screens
        for (Long id : removeScreens) {
            cl = mWorkspaceScreens.get(id);
            mWorkspaceScreens.remove(id);
            mScreenOrder.remove(id);

            if (getChildCount() > minScreens) {
                if (indexOfChild(cl) < currentPage) {
                    pageShift++;
                }
                removeView(cl);
            } else {
                // if this is the last non-custom content screen, convert it to the empty screen
                mWorkspaceScreens.put(EXTRA_EMPTY_SCREEN_ID, cl);
                mScreenOrder.add(EXTRA_EMPTY_SCREEN_ID);
            }
        }

        if (removeScreens.isEmpty()) {
            if (pageShift >= 0) setCurrentPage(currentPage - pageShift);
            return;
        }

        mLauncher.getModel().updateWorkspaceScreenOrder(mLauncher, mScreenOrder);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = prefs.edit();
        ContentResolver resolver = mLauncher.getContentResolver();

        ArrayList<Long> newOrder = new ArrayList<>(mScreenOrder);
        Log.i(TAG, "stripEmptyScreens: oldOrder=" + oldOrder + " newOrder=" + newOrder + " removed=" + removeScreens);

        final boolean[] prefsChanged = {false};

        BiConsumer<String, String> maybeShiftPref = (prefKey, enabledKey) -> {
            if (prefs.contains(prefKey) && (!prefs.contains(enabledKey) || prefs.getBoolean(enabledKey, false))) {
                int oldIndex = prefs.getInt(prefKey, 1) - 1;
                if (oldIndex < 0) {
                    return;
                }

                // Determine how many removed screens were before this index
                int removedBefore = 0;
                for (Long removedId : removeScreens) {
                    int removedRank = oldOrder.indexOf(removedId);
                    if (removedRank >= 0 && removedRank < oldIndex) removedBefore++;
                }
                int newIndex = Math.max(0, oldIndex - removedBefore);

                if (newIndex != oldIndex) {
                    editor.putInt(prefKey, newIndex + 1);
                    prefsChanged[0] = true;
                    Log.i(TAG, "Shifted pref " + prefKey + " from " + (oldIndex + 1) + " → " + (newIndex + 1));
                }
            }
        };

        maybeShiftPref.accept(Keys.MUSIC_SCREEN, Keys.USER_MUSIC);
        maybeShiftPref.accept(Keys.DATE_SCREEN, Keys.USER_DATE);
        maybeShiftPref.accept(Keys.RADIO_SCREEN, Keys.USER_RADIO);
        maybeShiftPref.accept(Keys.PIP_DUAL_SCREEN, Keys.PIP_DUAL);
        maybeShiftPref.accept(Keys.PIP_FIRST_SCREEN, Keys.PIP_FIRST);
        maybeShiftPref.accept(Keys.PIP_SECOND_SCREEN, Keys.PIP_SECOND);
        maybeShiftPref.accept(Keys.PIP_THIRD_SCREEN, Keys.PIP_THIRD);
        maybeShiftPref.accept(Keys.PIP_FOURTH_SCREEN, Keys.PIP_FOURTH);
        maybeShiftPref.accept(Keys.STATS_SCREEN, Keys.USER_STATS);
        editor.apply();

        for (int rank = 0; rank < newOrder.size(); rank++) {
            long screenId = newOrder.get(rank);
            ContentValues values = new ContentValues();
            values.put(LauncherSettings.WorkspaceScreens.SCREEN_RANK, rank);
            try {
                resolver.update(
                    LauncherSettings.WorkspaceScreens.CONTENT_URI,
                    values,
                    "_id=?",
                    new String[]{String.valueOf(screenId)}
                );
                Log.i(TAG, "Updated screenId=" + screenId + " → rank=" + rank);
            } catch (Exception e) {
                Log.w(TAG, "Failed to update screen rank for " + screenId, e);
            }
        }

        if (pageShift >= 0) {
            setCurrentPage(currentPage - pageShift);
        }

        mainHandler.postDelayed(() -> {
            if (!helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())) {
                Log.d("stripEmptyScreens", "startMapPip");
                WindowUtil.startMapPip(false);
            }
        }, 250);
    }

    // See implementation for parameter definition.
    void addInScreen(View child, long container, long screenId, int x, int y, int spanX, int spanY) {
        addInScreen(child, container, screenId, x, y, spanX, spanY, false, false);
    }

    // At bind time, we use the rank (screenId) to compute x and y for hotseat items.
    // See implementation for parameter definition.
    void addInScreenFromBind(View child, long container, long screenId, int x, int y, int spanX, int spanY) {
        addInScreen(child, container, screenId, x, y, spanX, spanY, false, true);
    }

    // See implementation for parameter definition.
    void addInScreen(View child, long container, long screenId, int x, int y, int spanX, int spanY, boolean insert) {
        addInScreen(child, container, screenId, x, y, spanX, spanY, insert, false);
    }

    /**
     * Adds the specified child in the specified screen. The position and dimension of
     * the child are defined by x, y, spanX and spanY.
     *
     * @param child The child to add in one of the workspace's screens.
     * @param screenId The screen in which to add the child.
     * @param x The X position of the child in the screen's grid.
     * @param y The Y position of the child in the screen's grid.
     * @param spanX The number of cells spanned horizontally by the child.
     * @param spanY The number of cells spanned vertically by the child.
     * @param insert When true, the child is inserted at the beginning of the children list.
     * @param computeXYFromRank When true, we use the rank (stored in screenId) to compute
     *                          the x and y position in which to place hotseat items. Otherwise
     *                          we use the x and y position to compute the rank.
     */
    void addInScreen(View child, long container, long screenId, int x, int y, int spanX, int spanY, boolean insert, boolean computeXYFromRank) {
        if (screenId < 0) {
            screenId = CUSTOM_CONTENT_SCREEN_ID1;
        }
        if (spanX <= 0 || spanY <= 0) {
            Log.e("WIDGET", "Invalid spans: " + spanX + "x" + spanY);
            return;
        }
        if (container == LauncherSettings.Favorites.CONTAINER_DESKTOP) {
            if (getScreenWithId(screenId) == null) {
                if (getScreenWithId(screenId) == null) {
                    Log.e(TAG, "Skipping child, screenId " + screenId + " not found");
                    // DEBUGGING - Print out the stack trace to see where we are adding from
                    new Throwable().printStackTrace();
                    return;
                }
            }
        }
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            // This should never happen
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }

        final CellLayout layout;
        if (container == LauncherSettings.Favorites.CONTAINER_HOTSEAT) {
            layout = mLauncher.getHotseat().getLayout();
            child.setOnKeyListener(null);

            // Hide folder title in the hotseat
            if (child instanceof FolderIcon) {
                ((FolderIcon) child).setTextVisible(false);
            }

            if (computeXYFromRank) {
                x = mLauncher.getHotseat().getCellXFromOrder((int) screenId);
                y = mLauncher.getHotseat().getCellYFromOrder((int) screenId);
            } else {
                screenId = mLauncher.getHotseat().getOrderInHotseat(x, y);
            }
        } else {
            // Show folder title if not in the hotseat
            if (child instanceof FolderIcon) {
                ((FolderIcon) child).setTextVisible(true);
            }
            layout = getScreenWithId(screenId);
            child.setOnKeyListener(new IconKeyEventListener());
        }

        ViewGroup.LayoutParams genericLp = child.getLayoutParams();
        CellLayout.LayoutParams lp;
        if (genericLp == null || !(genericLp instanceof CellLayout.LayoutParams)) {
            lp = new CellLayout.LayoutParams(x, y, spanX, spanY);
        } else {
            lp = (CellLayout.LayoutParams) genericLp;
            lp.cellX = x;
            lp.cellY = y;
            lp.cellHSpan = spanX;
            lp.cellVSpan = spanY;
        }

        if (spanX < 0 && spanY < 0) {
            lp.isLockedToGrid = false;
        }

        // Get the canonical child id to uniquely represent this view in this screen
        int childId = LauncherModel.getCellLayoutChildId(container, screenId, x, y, spanX, spanY);
        boolean markCellsAsOccupied = !(child instanceof Folder);
        if (!layout.addViewToCellLayout(child, insert ? 0 : -1, childId, lp, markCellsAsOccupied)) {
            // TODO: This branch occurs when the workspace is adding views
            // outside of the defined grid
            // maybe we should be deleting these items from the LauncherModel?
            Launcher.addDumpLog(TAG, "Failed to add to item at (" + lp.cellX + "," + lp.cellY + ") to CellLayout", true);
        }

        if (!(child instanceof Folder)) {
            child.setHapticFeedbackEnabled(false);
            child.setOnLongClickListener(mLongClickListener);
        }
        if (child instanceof DropTarget) {
            mDragController.addDropTarget((DropTarget) child);
        }
    }

    /**
     * Called directly from a CellLayout (not by the framework), after we've been added as a
     * listener via setOnInterceptTouchEventListener(). This allows us to tell the CellLayout
     * that it should intercept touch events, which is not something that is normally supported.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return (isSmall() || !isFinishedSwitchingState())
                || (!isSmall() && indexOfChild(v) != mCurrentPage);
    }

    public boolean isSwitchingState() {
        return mIsSwitchingState;
    }

    /** This differs from isSwitchingState in that we take into account how far the transition
     *  has completed. */
    public boolean isFinishedSwitchingState() {
        return !mIsSwitchingState || (mTransitionProgress > 0.5f);
    }

    protected void onWindowVisibilityChanged (int visibility) {
        mLauncher.onWindowVisibilityChanged(visibility);
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        if (isSmall() || !isFinishedSwitchingState()) {
            // when the home screens are shrunken, shouldn't allow side-scrolling
            return false;
        }
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            mXDown = ev.getX();
            mYDown = ev.getY();
            mTouchDownTime = System.currentTimeMillis();
            break;
        case MotionEvent.ACTION_POINTER_UP:
        case MotionEvent.ACTION_UP:
            if (mTouchState == TOUCH_STATE_REST) {
                final CellLayout currentPage = (CellLayout) getChildAt(mCurrentPage);
                if (!currentPage.lastDownOnOccupiedCell()) {
                    onWallpaperTap(ev);
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    protected void reinflateWidgetsIfNecessary() {
        final int clCount = getChildCount();
        for (int i = 0; i < clCount; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            ShortcutAndWidgetContainer swc = cl.getShortcutsAndWidgets();
            final int itemCount = swc.getChildCount();
            for (int j = 0; j < itemCount; j++) {
                View v = swc.getChildAt(j);
                if (v != null) {
                    if (v.getTag() instanceof LauncherAppWidgetInfo) {
                        LauncherAppWidgetInfo info = (LauncherAppWidgetInfo) v.getTag();
                        LauncherAppWidgetHostView lahv = (LauncherAppWidgetHostView) info.hostView;
                        if (lahv != null) {
                            mLauncher.removeAppWidget(info);
                            // Remove the current widget which is inflated with the wrong orientation
                            cl.removeView(lahv);
                            mLauncher.bindAppWidget(info);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void determineScrollingStart(MotionEvent ev) {
        if (!isFinishedSwitchingState()) return;

        float deltaX = ev.getX() - mXDown;
        float absDeltaX = Math.abs(deltaX);
        float absDeltaY = Math.abs(ev.getY() - mYDown);

        if (Float.compare(absDeltaX, 0f) == 0) return;

        float slope = absDeltaY / absDeltaX;
        float theta = (float) Math.atan(slope);

        if (absDeltaX > mTouchSlop || absDeltaY > mTouchSlop) {
            cancelCurrentPageLongPress();
        }

        boolean passRightSwipesToCustomContent =
                (mTouchDownTime - mCustomContentShowTime) > CUSTOM_CONTENT_GESTURE_DELAY;

        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);       
        boolean swipeInIgnoreDirection;
        if (userLayout) {
            swipeInIgnoreDirection = isLayoutRtl() ? deltaX < 0 : deltaX > 0;
        } else {
            swipeInIgnoreDirection = true;
        }
        if (theta > MAX_SWIPE_ANGLE) {
            // Above MAX_SWIPE_ANGLE, we don't want to ever start scrolling the workspace
            return;
        } else if (theta > START_DAMPING_TOUCH_SLOP_ANGLE) {
            // Above START_DAMPING_TOUCH_SLOP_ANGLE and below MAX_SWIPE_ANGLE, we want to
            // increase the touch slop to make it harder to begin scrolling the workspace. This
            // results in vertically scrolling widgets to more easily. The higher the angle, the
            // more we increase touch slop.
            theta -= START_DAMPING_TOUCH_SLOP_ANGLE;
            float extraRatio = (float)
                    Math.sqrt((theta / (MAX_SWIPE_ANGLE - START_DAMPING_TOUCH_SLOP_ANGLE)));
            super.determineScrollingStart(ev, 1 + TOUCH_SLOP_DAMPING_FACTOR * extraRatio);
        } else {
            // Below START_DAMPING_TOUCH_SLOP_ANGLE, we don't do anything special
            super.determineScrollingStart(ev);
        }
    }

    protected void onPageBeginMoving() {
        super.onPageBeginMoving();
        Log.i(TAG, "onPageBeginMoving()");
        if (getChildCount() > 1) {
            WindowUtil.removePinnedPip();
        }
        if (isHardwareAccelerated()) {
            updateChildrenLayersEnabled(false);
        } else {
            if (mNextPage != INVALID_PAGE) {
                // we're snapping to a particular screen
                enableChildrenCache(mCurrentPage, mNextPage);
            } else {
                // this is when user is actively dragging a particular screen, they might
                // swipe it either left or right (but we won't advance by more than one screen)
                enableChildrenCache(mCurrentPage - 1, mCurrentPage + 1);
            }
        }

        // Only show page outlines as we pan if we are on large screen
        if (LauncherAppState.getInstance().isScreenLarge()) {
            showOutlines();
        }

        // If we are not fading in adjacent screens, we still need to restore the alpha in case the
        // user scrolls while we are transitioning (should not affect dispatchDraw optimizations)
        if (!mWorkspaceFadeInAdjacentScreens) {
            for (int i = 0; i < getChildCount(); ++i) {
                ((CellLayout) getPageAt(i)).setShortcutAndWidgetAlpha(1f);
            }
        }
    }

    protected void onPageEndMoving() {
        super.onPageEndMoving(); 
        /*Log.d(TAG, "onPageEndMoving: " + "isInOverviewMode() = " + String.valueOf(helpers.isInOverviewMode())
                                       + "; openedFromOverviewBoolean() = " + String.valueOf(helpers.openedFromOverviewBoolean())
                                       + "; getChildCount() = " + String.valueOf(getChildCount())
                                       + "; isDragging() = " + String.valueOf(mDragController.isDragging())
                                       + "; allAppsVisibility() = " + String.valueOf(helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())));*/

        backPressed = false;

        mainHandler.postDelayed(()-> {
            if (!pipInitialized
                && !helpers.isInOverviewMode() 
                && !helpers.openedFromOverviewBoolean() 
                && getChildCount() > 1 
                && !mDragController.isDragging()
                && !helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())) {
                
                Log.d("onPageEndMoving", "openPinnedPip()");
                WindowUtil.openPinnedPip();
            }
            pipInitialized = false;
        }, 250);

        if (isHardwareAccelerated()) {
            updateChildrenLayersEnabled(false);
        } else {
            clearChildrenCache();
        }

        if (mDragController.isDragging()) {
            if (isSmall()) {
                // If we are in springloaded mode, then force an event to check if the current touch
                // is under a new page (to scroll to)
                mDragController.forceTouchMove();
            }
        } else {
            // If we are not mid-dragging, hide the page outlines if we are on a large screen
            if (LauncherAppState.getInstance().isScreenLarge()) {
                hideOutlines();
            }
        }

        if (mDelayedResizeRunnable != null) {
            mDelayedResizeRunnable.run();
            mDelayedResizeRunnable = null;
        }

        if (mDelayedSnapToPageRunnable != null) {
            mDelayedSnapToPageRunnable.run();
            mDelayedSnapToPageRunnable = null;
        }
        if (mStripScreensOnPageStopMoving) {
            triggerStripEmptyScreens("Workspace, onPageEndMoving()", false);
            mStripScreensOnPageStopMoving = false;
        }
    }

    @Override
    protected void notifyPageSwitchListener() {
        super.notifyPageSwitchListener();
        Launcher.setScreen(mCurrentPage);

        if (hasCustomContent() && getNextPage() == 0 && !mCustomContentShowing) {
            mCustomContentShowing = true;
            if (mCustomContentCallbacks != null) {
                mCustomContentCallbacks.onShow();
                mCustomContentShowTime = System.currentTimeMillis();
                mLauncher.updateVoiceButtonProxyVisible(false);
            }
        } else if (hasCustomContent() && getNextPage() != 0 && mCustomContentShowing) {
            mCustomContentShowing = false;
            if (mCustomContentCallbacks != null) {
                mCustomContentCallbacks.onHide();
                mLauncher.resetQSBScroll();
                mLauncher.updateVoiceButtonProxyVisible(false);
            }
        }
        if (getPageIndicator() != null) {
            getPageIndicator().setContentDescription(getPageIndicatorDescription());
        }
    }

    protected CustomContentCallbacks getCustomContentCallbacks() {
        return mCustomContentCallbacks;
    }

    protected void setWallpaperDimension() {
        String spKey = WallpaperCropActivity.getSharedPreferencesKey();
        SharedPreferences sp = mLauncher.getSharedPreferences(spKey, Context.MODE_MULTI_PROCESS);
        WallpaperPickerActivity.suggestWallpaperDimension(mLauncher.getResources(),
                sp, mLauncher.getWindowManager(), mWallpaperManager);
    }

    protected void snapToPage(int whichPage, Runnable r) {
        if (mDelayedSnapToPageRunnable != null) {
            mDelayedSnapToPageRunnable.run();
        }
        mDelayedSnapToPageRunnable = r;
        snapToPage(whichPage, SLOW_PAGE_SNAP_ANIMATION_DURATION);
    }

    protected void snapToScreenId(long screenId, Runnable r) {
        snapToPage(getPageIndexForScreenId(screenId), r);
    }

    class WallpaperOffsetInterpolator implements Choreographer.FrameCallback {
        float mFinalOffset = 0.0f;
        float mCurrentOffset = 0.5f; // to force an initial update
        boolean mWaitingForUpdate;
        Choreographer mChoreographer;
        Interpolator mInterpolator;
        boolean mAnimating;
        long mAnimationStartTime;
        float mAnimationStartOffset;
        private final int ANIMATION_DURATION = 250;
        // Don't use all the wallpaper for parallax until you have at least this many pages
        private final int MIN_PARALLAX_PAGE_SPAN = 3;
        int mNumScreens;

        public WallpaperOffsetInterpolator() {
            mChoreographer = Choreographer.getInstance();
            mInterpolator = new DecelerateInterpolator(1.5f);
        }

        @Override
        public void doFrame(long frameTimeNanos) {
            updateOffset(false);
        }

        private void updateOffset(boolean force) {
            if (mWaitingForUpdate || force) {
                mWaitingForUpdate = false;
                if (computeScrollOffset() && mWindowToken != null) {
                    try {
                        mWallpaperManager.setWallpaperOffsets(mWindowToken,
                                mWallpaperOffset.getCurrX(), 0.5f);
                        setWallpaperOffsetSteps();
                    } catch (IllegalArgumentException e) {
                        Log.e(TAG, "Error updating wallpaper offset: " + e);
                    }
                }
            }
        }

        public boolean computeScrollOffset() {
            final float oldOffset = mCurrentOffset;
            if (mAnimating) {
                long durationSinceAnimation = System.currentTimeMillis() - mAnimationStartTime;
                float t0 = durationSinceAnimation / (float) ANIMATION_DURATION;
                float t1 = mInterpolator.getInterpolation(t0);
                mCurrentOffset = mAnimationStartOffset +
                        (mFinalOffset - mAnimationStartOffset) * t1;
                mAnimating = durationSinceAnimation < ANIMATION_DURATION;
            } else {
                mCurrentOffset = mFinalOffset;
            }

            if (Math.abs(mCurrentOffset - mFinalOffset) > 0.0000001f) {
                scheduleUpdate();
            }
            if (Math.abs(oldOffset - mCurrentOffset) > 0.0000001f) {
                return true;
            }
            return false;
        }

        private float wallpaperOffsetForCurrentScroll() {
            if (getChildCount() <= 1) {
                return 0;
            }

            // Exclude the leftmost page
            int emptyExtraPages = numEmptyScreensToIgnore();
            int firstIndex = numCustomPages();
            // Exclude the last extra empty screen (if we have > MIN_PARALLAX_PAGE_SPAN pages)
            int lastIndex = getChildCount() - 1 - emptyExtraPages;
            if (isLayoutRtl()) {
                int temp = firstIndex;
                firstIndex = lastIndex;
                lastIndex = temp;
            }

            int firstPageScrollX = getScrollForPage(firstIndex);
            int scrollRange = getScrollForPage(lastIndex) - firstPageScrollX;
            if (scrollRange == 0) {
                return 0;
            } else {
                // TODO: do different behavior if it's  a live wallpaper?
                // Sometimes the left parameter of the pages is animated during a layout transition;
                // this parameter offsets it to keep the wallpaper from animating as well
                int offsetForLayoutTransitionAnimation = isLayoutRtl() ?
                        getPageAt(getChildCount() - 1).getLeft() - getFirstChildLeft() : 0;
                // Again, we adjust the wallpaper offset to be consistent between values of mLayoutScale
                int tempScrollX = getScrollX();
                if (/*mIsSupportCircular &&*/ tempScrollX < 0) {
                    tempScrollX = -tempScrollX;
                    tempScrollX *= (getChildCount() - 1);
                } else if (/*mIsSupportCircular &&*/ tempScrollX > scrollRange) {
                    tempScrollX = tempScrollX - scrollRange;
                    tempScrollX *= (getChildCount() - 1);
                }
                int adjustedScroll =
                        tempScrollX - firstPageScrollX - offsetForLayoutTransitionAnimation;
                float offset = Math.min(1, adjustedScroll / (float) scrollRange);
                offset = Math.max(0, offset);
                // Don't use up all the wallpaper parallax until you have at least
                // MIN_PARALLAX_PAGE_SPAN pages
                int numScrollingPages = getNumScreensExcludingEmptyAndCustom();
                int parallaxPageSpan = Math.max(MIN_PARALLAX_PAGE_SPAN, numScrollingPages - 1);
                // On RTL devices, push the wallpaper offset to the right if we don't have enough
                // pages (ie if numScrollingPages < MIN_PARALLAX_PAGE_SPAN)
                int padding = isLayoutRtl() ? parallaxPageSpan - numScrollingPages + 1 : 0;
                if(/*mIsSupportCircular &&*/ getScrollX() > scrollRange){
                    offset = 1 - offset;
                }
                return offset * (padding + numScrollingPages - 1) / parallaxPageSpan;
            }
        }

        private int numEmptyScreensToIgnore() {
            int numScrollingPages = getChildCount() - numCustomPages();
            if (numScrollingPages >= MIN_PARALLAX_PAGE_SPAN && hasExtraEmptyScreen()) {
                return 1;
            } else {
                return 0;
            }
        }

        private int getNumScreensExcludingEmptyAndCustom() {
            int numScrollingPages = getChildCount() - numEmptyScreensToIgnore() - numCustomPages();
            return numScrollingPages;
        }

        public void syncWithScroll() {
            float offset = wallpaperOffsetForCurrentScroll();
            mWallpaperOffset.setFinalX(offset);
            updateOffset(true);
        }

        public float getCurrX() {
            return mCurrentOffset;
        }

        public float getFinalX() {
            return mFinalOffset;
        }

        private void animateToFinal() {
            mAnimating = true;
            mAnimationStartOffset = mCurrentOffset;
            mAnimationStartTime = System.currentTimeMillis();
        }

        private void setWallpaperOffsetSteps() {
            // Set wallpaper offset steps (1 / (number of screens - 1))
            mWallpaperManager.setWallpaperOffsetSteps(1.0f / (getChildCount() - 1), 1.0f);
        }

        public void setFinalX(float x) {
            scheduleUpdate();
            mFinalOffset = Math.max(0f, Math.min(x, 1.0f));
            if (getNumScreensExcludingEmptyAndCustom() != mNumScreens) {
                if (mNumScreens > 0) {
                    // Don't animate if we're going from 0 screens
                    animateToFinal();
                }
                mNumScreens = getNumScreensExcludingEmptyAndCustom();
            }
        }

        private void scheduleUpdate() {
            if (!mWaitingForUpdate) {
                mChoreographer.postFrameCallback(this);
                mWaitingForUpdate = true;
            }
        }

        public void jumpToFinal() {
            mCurrentOffset = mFinalOffset;
        }
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        mWallpaperOffset.syncWithScroll();
        
        // Update PiP positions during fling animation
        WindowUtil.updatePipPositionsForScroll(mUnboundedScrollX);
    }

    void showOutlines() {
        if (!isSmall() && !mIsSwitchingState) {
            if (mChildrenOutlineFadeOutAnimation != null) mChildrenOutlineFadeOutAnimation.cancel();
            if (mChildrenOutlineFadeInAnimation != null) mChildrenOutlineFadeInAnimation.cancel();
            mChildrenOutlineFadeInAnimation = LauncherAnimUtils.ofFloat(this, "childrenOutlineAlpha", 1.0f);
            mChildrenOutlineFadeInAnimation.setDuration(CHILDREN_OUTLINE_FADE_IN_DURATION);
            mChildrenOutlineFadeInAnimation.start();
        }
    }

    void hideOutlines() {
        if (!isSmall() && !mIsSwitchingState) {
            if (mChildrenOutlineFadeInAnimation != null) mChildrenOutlineFadeInAnimation.cancel();
            if (mChildrenOutlineFadeOutAnimation != null) mChildrenOutlineFadeOutAnimation.cancel();
            mChildrenOutlineFadeOutAnimation = LauncherAnimUtils.ofFloat(this, "childrenOutlineAlpha", 0.0f);
            mChildrenOutlineFadeOutAnimation.setDuration(CHILDREN_OUTLINE_FADE_OUT_DURATION);
            mChildrenOutlineFadeOutAnimation.setStartDelay(CHILDREN_OUTLINE_FADE_OUT_DELAY);
            mChildrenOutlineFadeOutAnimation.start();
        }
    }

    public void showOutlinesTemporarily(boolean back) {
        if (!mIsPageMoving && !isTouchActive()) {
            backPressed = true;
            snapToPage(mCurrentPage);
        }
    }

    public void setChildrenOutlineAlpha(float alpha) {
        mChildrenOutlineAlpha = alpha;
        for (int i = 0; i < getChildCount(); i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            cl.setBackgroundAlpha(alpha);
        }
    }

    public float getChildrenOutlineAlpha() {
        return mChildrenOutlineAlpha;
    }

    void disableBackground() {
        mDrawBackground = false;
    }
    void enableBackground() {
        mDrawBackground = true;
    }

    private void animateBackgroundGradient(float finalAlpha, boolean animated) {
        if (mBackground == null) return;
        if (mBackgroundFadeInAnimation != null) {
            mBackgroundFadeInAnimation.cancel();
            mBackgroundFadeInAnimation = null;
        }
        if (mBackgroundFadeOutAnimation != null) {
            mBackgroundFadeOutAnimation.cancel();
            mBackgroundFadeOutAnimation = null;
        }
        float startAlpha = getBackgroundAlpha();
        if (finalAlpha != startAlpha) {
            if (animated) {
                mBackgroundFadeOutAnimation =
                        LauncherAnimUtils.ofFloat(this, startAlpha, finalAlpha);
                mBackgroundFadeOutAnimation.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        setBackgroundAlpha(((Float) animation.getAnimatedValue()).floatValue());
                    }
                });
                mBackgroundFadeOutAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
                mBackgroundFadeOutAnimation.setDuration(BACKGROUND_FADE_OUT_DURATION);
                mBackgroundFadeOutAnimation.start();
            } else {
                setBackgroundAlpha(finalAlpha);
            }
        }
    }

    public void setBackgroundAlpha(float alpha) {
        if (alpha != mBackgroundAlpha) {
            mBackgroundAlpha = alpha;
            invalidate();
        }
    }

    public float getBackgroundAlpha() {
        return mBackgroundAlpha;
    }

    float backgroundAlphaInterpolator(float r) {
        float pivotA = 0.1f;
        float pivotB = 0.4f;
        if (r < pivotA) {
            return 0;
        } else if (r > pivotB) {
            return 1.0f;
        } else {
            return (r - pivotA)/(pivotB - pivotA);
        }
    }

    private void updatePageAlphaValues(int screenCenter) {
        boolean isInOverscroll = (mOverScrollX < 0 || mOverScrollX > mMaxScrollX); // && !mIsSupportCircular;
        if (mWorkspaceFadeInAdjacentScreens &&
                mState == State.NORMAL &&
                !mIsSwitchingState &&
                !isInOverscroll) {
            for (int i = 0; i < getChildCount(); i++) {
                CellLayout child = (CellLayout) getChildAt(i);
                if (child != null) {
                    float scrollProgress = getScrollProgress(screenCenter, child, i);
                    float alpha = 1 - Math.abs(scrollProgress);
                    child.getShortcutsAndWidgets().setAlpha(alpha);
                    if (!mIsDragOccuring) {
                        child.setBackgroundAlphaMultiplier(
                                backgroundAlphaInterpolator(Math.abs(scrollProgress)));
                    } else {
                        child.setBackgroundAlphaMultiplier(1f);
                    }
                }
            }
        }
    }

    private void setChildrenBackgroundAlphaMultipliers(float a) {
        for (int i = 0; i < getChildCount(); i++) {
            CellLayout child = (CellLayout) getChildAt(i);
            child.setBackgroundAlphaMultiplier(a);
        }
    }

    public boolean hasCustomContent() {
        return (mScreenOrder.size() > 0 && mScreenOrder.get(0) == CUSTOM_CONTENT_SCREEN_ID);
    }

    public boolean hasMyCustomContent() {
        return this.mScreenOrder.size() > LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count) + (-1) && this.mScreenOrder.get(0).longValue() == CUSTOM_CONTENT_SCREEN_ID1;
    }

    public int numCustomPages() {
        return hasCustomContent() ? 1 : 0;
    }

    public boolean isOnOrMovingToCustomContent() {
        return hasCustomContent() && getNextPage() == 0;
    }

    private void updateStateForCustomContent(int screenCenter) {
        float translationX = 0;
        float progress = 0;
        if (hasCustomContent()) {
            int index = mScreenOrder.indexOf(CUSTOM_CONTENT_SCREEN_ID);

            int scrollDelta = getScrollX() - getScrollForPage(index) -
                    getLayoutTransitionOffsetForPage(index);
            float scrollRange = getScrollForPage(index + 1) - getScrollForPage(index);
            translationX = scrollRange - scrollDelta;
            progress = (scrollRange - scrollDelta) / scrollRange;

            if (isLayoutRtl()) {
                translationX = Math.min(0, translationX);
            } else {
                translationX = Math.max(0, translationX);
            }
            progress = Math.max(0, progress);
        }

        if (Float.compare(progress, mLastCustomContentScrollProgress) == 0) return;

        CellLayout cc = mWorkspaceScreens.get(CUSTOM_CONTENT_SCREEN_ID);
        if (progress > 0 && cc.getVisibility() != VISIBLE && !isSmall()) {
            cc.setVisibility(VISIBLE);
        }

        mLastCustomContentScrollProgress = progress;

        setBackgroundAlpha(progress * 0.8f);

        if (mLauncher.getHotseat() != null) {
            mLauncher.getHotseat().setTranslationX(translationX);
        }

        if (getPageIndicator() != null) {
            getPageIndicator().setTranslationX(translationX);
        }

        if (mCustomContentCallbacks != null) {
            mCustomContentCallbacks.onScrollProgressChanged(progress);
        }
    }

    @Override
    protected OnClickListener getPageIndicatorClickListener() {
        AccessibilityManager am = (AccessibilityManager)
                getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (!am.isTouchExplorationEnabled()) {
            return null;
        }
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                enterOverviewMode();
            }
        };
        return listener;
    }

    @Override
    protected void screenScrolled(int screenCenter) {
        final boolean isRtl = isLayoutRtl();
        super.screenScrolled(screenCenter);

        updatePageAlphaValues(screenCenter);
        updateStateForCustomContent(screenCenter);
        enableHwLayersOnVisiblePages();

        // Update PiP positions based on scroll
        WindowUtil.updatePipPositionsForScroll(mUnboundedScrollX);

        boolean shouldOverScroll = ((mOverScrollX < 0 && (!hasCustomContent() || isLayoutRtl())) ||
                (mOverScrollX > mMaxScrollX && (!hasCustomContent() || !isLayoutRtl())));

        if (shouldOverScroll) {
            int index = 0;
            float pivotX = 0f;
            final float leftBiasedPivot = 0.25f;
            final float rightBiasedPivot = 0.75f;
            final int lowerIndex = 0;
            final int upperIndex = getChildCount() - 1;

            final boolean isLeftPage = mOverScrollX < 0;
            index = (!isRtl && isLeftPage) || (isRtl && !isLeftPage) ? lowerIndex : upperIndex;
            pivotX = isLeftPage ? rightBiasedPivot : leftBiasedPivot;

            CellLayout cl = (CellLayout) getChildAt(index);
            if (cl != null) {
                float scrollProgress = getScrollProgress(screenCenter, cl, index);
                cl.setOverScrollAmount(Math.abs(scrollProgress), isLeftPage);
                float rotation = -WORKSPACE_OVERSCROLL_ROTATION * scrollProgress;
                cl.setRotationY(rotation);

                if (!mOverscrollTransformsSet || Float.compare(mLastOverscrollPivotX, pivotX) != 0) {
                    mOverscrollTransformsSet = true;
                    mLastOverscrollPivotX = pivotX;
                    cl.setCameraDistance(mDensity * mCameraDistance);
                    cl.setPivotX(cl.getMeasuredWidth() * pivotX);
                    cl.setPivotY(cl.getMeasuredHeight() * 0.5f);
                    cl.setOverscrollTransformsDirty(true);
                }
            } else {
                Log.w(TAG, "--Workspace.screenScrolled() cellLayout is null, index = " + index);
            }
        } else {
            if (mOverscrollTransformsSet) {
                mOverscrollTransformsSet = false;
                CellLayout firstLayout = (CellLayout) getChildAt(0);
                CellLayout lastLayout = getChildCount() > 0 ? (CellLayout) getChildAt(getChildCount() - 1) : null;
                if (firstLayout != null) {
                    firstLayout.resetOverscrollTransforms();
                }
                if (lastLayout != null) {
                    lastLayout.resetOverscrollTransforms();
                }
            }
        }
    }

    @Override
    protected void overScroll(float amount) {
        acceleratedOverScroll(amount);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mWindowToken = getWindowToken();
        computeScroll();
        mDragController.setWindowToken(mWindowToken);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mWindowToken = null;
    }

    protected void onResume() {
        if (getPageIndicator() != null) {
            // In case accessibility state has changed, we need to perform this on every
            // attach to window
            OnClickListener listener = getPageIndicatorClickListener();
            if (listener != null) {
                getPageIndicator().setOnClickListener(listener);
            }
        }
        AccessibilityManager am = (AccessibilityManager)
                getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        sAccessibilityEnabled = am.isEnabled();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (mFirstLayout && mCurrentPage >= 0 && mCurrentPage < getChildCount()) {
            mWallpaperOffset.syncWithScroll();
            mWallpaperOffset.jumpToFinal();
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the background gradient if necessary
        if (mBackground != null && mBackgroundAlpha > 0.0f && mDrawBackground) {
            int alpha = (int) (mBackgroundAlpha * 255);
            mBackground.setAlpha(alpha);
            mBackground.setBounds(getScrollX(), 0, getScrollX() + getMeasuredWidth(),
                    getMeasuredHeight());
            mBackground.draw(canvas);
        }

        super.onDraw(canvas);

        // Call back to LauncherModel to finish binding after the first draw
        post(mBindPages);
    }

    boolean isDrawingBackgroundGradient() {
        return (mBackground != null && mBackgroundAlpha > 0.0f && mDrawBackground);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        if (!mLauncher.isAllAppsVisible()) {
            final Folder openFolder = getOpenFolder();
            if (openFolder != null) {
                return openFolder.requestFocus(direction, previouslyFocusedRect);
            } else {
                return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
            }
        }
        return false;
    }

    @Override
    public int getDescendantFocusability() {
        if (isSmall()) {
            return ViewGroup.FOCUS_BLOCK_DESCENDANTS;
        }
        return super.getDescendantFocusability();
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        if (!mLauncher.isAllAppsVisible()) {
            final Folder openFolder = getOpenFolder();
            if (openFolder != null) {
                openFolder.addFocusables(views, direction);
            } else {
                super.addFocusables(views, direction, focusableMode);
            }
        }
    }

    public boolean isSmall() {
        return mState == State.SMALL || mState == State.SPRING_LOADED || mState == State.OVERVIEW;
    }

    void enableChildrenCache(int fromPage, int toPage) {
        if (fromPage > toPage) {
            final int temp = fromPage;
            fromPage = toPage;
            toPage = temp;
        }

        final int screenCount = getChildCount();

        fromPage = Math.max(fromPage, 0);
        toPage = Math.min(toPage, screenCount - 1);

        for (int i = fromPage; i <= toPage; i++) {
            final CellLayout layout = (CellLayout) getChildAt(i);
            layout.setChildrenDrawnWithCacheEnabled(true);
            layout.setChildrenDrawingCacheEnabled(true);
        }
    }

    void clearChildrenCache() {
        final int screenCount = getChildCount();
        for (int i = 0; i < screenCount; i++) {
            final CellLayout layout = (CellLayout) getChildAt(i);
            layout.setChildrenDrawnWithCacheEnabled(false);
            // In software mode, we don't want the items to continue to be drawn into bitmaps
            if (!isHardwareAccelerated()) {
                layout.setChildrenDrawingCacheEnabled(false);
            }
        }
    }

    private void updateChildrenLayersEnabled(boolean force) {
        boolean small = mState == State.SMALL || mState == State.OVERVIEW || mIsSwitchingState;
        boolean enableChildrenLayers = force || small || mAnimatingViewIntoPlace || isPageMoving();

        if (enableChildrenLayers != mChildrenLayersEnabled) {
            mChildrenLayersEnabled = enableChildrenLayers;
            if (mChildrenLayersEnabled) {
                enableHwLayersOnVisiblePages();
            } else {
                for (int i = 0; i < getPageCount(); i++) {
                    final CellLayout cl = (CellLayout) getChildAt(i);
                    cl.enableHardwareLayer(false);
                }
            }
        }
    }

    private void enableHwLayersOnVisiblePages() {
        if (mChildrenLayersEnabled) {
            final int screenCount = getChildCount();
            getVisiblePages(mTempVisiblePagesRange);
            int leftScreen = mTempVisiblePagesRange[0];
            int rightScreen = mTempVisiblePagesRange[1];
            if (leftScreen == rightScreen) {
                // make sure we're caching at least two pages always
                if (rightScreen < screenCount - 1) {
                    rightScreen++;
                } else if (leftScreen > 0) {
                    leftScreen--;
                }
            }

            final CellLayout customScreen = mWorkspaceScreens.get(CUSTOM_CONTENT_SCREEN_ID);
            for (int i = 0; i < screenCount; i++) {
                final CellLayout layout = (CellLayout) getPageAt(i);

                // enable layers between left and right screen inclusive, except for the
                // customScreen, which may animate its content during transitions.
                boolean enableLayer = layout != customScreen &&
                        leftScreen <= i && i <= rightScreen && shouldDrawChild(layout);
                layout.enableHardwareLayer(enableLayer);
            }
        }
    }

    public void buildPageHardwareLayers() {
        // force layers to be enabled just for the call to buildLayer
        updateChildrenLayersEnabled(true);
        if (getWindowToken() != null) {
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                CellLayout cl = (CellLayout) getChildAt(i);
                cl.buildHardwareLayer();
            }
        }
        updateChildrenLayersEnabled(false);
    }

    protected void onWallpaperTap(MotionEvent ev) {
        final int[] position = mTempCell;
        getLocationOnScreen(position);

        int pointerIndex = ev.getActionIndex();
        position[0] += (int) ev.getX(pointerIndex);
        position[1] += (int) ev.getY(pointerIndex);

        mWallpaperManager.sendWallpaperCommand(getWindowToken(),
                ev.getAction() == MotionEvent.ACTION_UP
                        ? WallpaperManager.COMMAND_TAP : WallpaperManager.COMMAND_SECONDARY_TAP,
                position[0], position[1], 0, null);
    }

    /*
     * This interpolator emulates the rate at which the perceived scale of an object changes
     * as its distance from a camera increases. When this interpolator is applied to a scale
     * animation on a view, it evokes the sense that the object is shrinking due to moving away
     * from the camera.
     */
    static class ZInterpolator implements TimeInterpolator {
        private float focalLength;

        public ZInterpolator(float foc) {
            focalLength = foc;
        }

        public float getInterpolation(float input) {
            return (1.0f - focalLength / (focalLength + input)) /
                (1.0f - focalLength / (focalLength + 1.0f));
        }
    }

    /*
     * The exact reverse of ZInterpolator.
     */
    static class InverseZInterpolator implements TimeInterpolator {
        private ZInterpolator zInterpolator;
        public InverseZInterpolator(float foc) {
            zInterpolator = new ZInterpolator(foc);
        }
        public float getInterpolation(float input) {
            return 1 - zInterpolator.getInterpolation(1 - input);
        }
    }

    /*
     * ZInterpolator compounded with an ease-out.
     */
    static class ZoomOutInterpolator implements TimeInterpolator {
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(0.75f);
        private final ZInterpolator zInterpolator = new ZInterpolator(0.13f);

        public float getInterpolation(float input) {
            return decelerate.getInterpolation(zInterpolator.getInterpolation(input));
        }
    }

    /*
     * InvereZInterpolator compounded with an ease-out.
     */
    static class ZoomInInterpolator implements TimeInterpolator {
        private final InverseZInterpolator inverseZInterpolator = new InverseZInterpolator(0.35f);
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(3.0f);

        public float getInterpolation(float input) {
            return decelerate.getInterpolation(inverseZInterpolator.getInterpolation(input));
        }
    }

    private final ZoomInInterpolator mZoomInInterpolator = new ZoomInInterpolator();

    /*
    *
    * We call these methods (onDragStartedWithItemSpans/onDragStartedWithSize) whenever we
    * start a drag in Launcher, regardless of whether the drag has ever entered the Workspace
    *
    * These methods mark the appropriate pages as accepting drops (which alters their visual
    * appearance).
    *
    */
    public void onDragStartedWithItem(View v) {
        final Canvas canvas = new Canvas();

        // The outline is used to visualize where the item will land if dropped
        mDragOutline = createDragOutline(v, canvas, DRAG_BITMAP_PADDING, 1.0f);
    }

    public void onDragStartedWithItem(PendingAddItemInfo info, Bitmap b, boolean clipAlpha) {
        final Canvas canvas = new Canvas();

        int[] size = estimateItemSize(info.spanX, info.spanY, info, false);

        // The outline is used to visualize where the item will land if dropped
        mDragOutline = createDragOutline(b, canvas, DRAG_BITMAP_PADDING, size[0],
                size[1], clipAlpha);
    }

    public void exitWidgetResizeMode() {
        DragLayer dragLayer = mLauncher.getDragLayer();
        dragLayer.clearAllResizeFrames();
    }

    private void initAnimationArrays() {
        final int childCount = getChildCount();
        if (mLastChildCount == childCount) return;

        mOldBackgroundAlphas = new float[childCount];
        mOldAlphas = new float[childCount];
        mNewBackgroundAlphas = new float[childCount];
        mNewAlphas = new float[childCount];
    }

    Animator getChangeStateAnimation(final State state, boolean animated) {
        return getChangeStateAnimation(state, animated, 0, -1);
    }

    @Override
    protected void getOverviewModePages(int[] range) {
        int start = numCustomPages();
        int end = getChildCount() - 1;

        range[0] = Math.max(0, Math.min(start, getChildCount() - 1));
        range[1] = Math.max(0,  end);
     }

    protected void onStartReordering() {
        super.onStartReordering();
        showOutlines();
        // Reordering handles its own animations, disable the automatic ones.
        disableLayoutTransitions();
    }

    protected void onEndReordering() {
        super.onEndReordering();

        hideOutlines();
        mScreenOrder.clear();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = ((CellLayout) getChildAt(i));
            mScreenOrder.add(getIdForScreen(cl));
        }

        mLauncher.getModel().updateWorkspaceScreenOrder(mLauncher, mScreenOrder);

        // Re-enable auto layout transitions for page deletion.
        enableLayoutTransitions();
    }

    public boolean isInOverviewMode() {
        return mState == State.OVERVIEW;
    }

    public boolean enterOverviewMode() {
        // Do not allow to enter if widget has been long clicked
        if (helpers.isWidgetClickedBool()) return false;

        helpers.setInOverviewMode(true);
        helpers.setListOpen(false);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats)  { 
            helpers.setForegroundAppOpened(false);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            Intent intentOverviewMode = new Intent(Keys.OVERVIEW_MODE_OPEN);
            LauncherApplication.sApp.sendBroadcast(intentOverviewMode);
        }
        if (mTouchState != TOUCH_STATE_REST) {
            return false;
        }
        if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.wallpaper_show)) {
            return true;
        }
        WindowUtil.removePip();
        exitWidgetResizeMode();
        enableOverviewMode(true, -1, true);
        return true;
    }

    public void exitOverviewMode(boolean animated) {
        exitOverviewMode(-1, animated);
    }

    public void exitOverviewMode(int snapPage, boolean animated) {
        helpers.setInOverviewMode(false);
        helpers.setListOpen(false);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats)  {        
            helpers.setForegroundAppOpened(false);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            Intent intentOverviewMode = new Intent(Keys.OVERVIEW_MODE_CLOSE);
            LauncherApplication.sApp.sendBroadcast(intentOverviewMode);
        }

        mainHandler.postDelayed(()-> {
            Log.d("exitOverviewMode", "startMapPip");
            WindowUtil.startMapPip(false);
        }, 250);

        enableOverviewMode(false, snapPage, animated);
    } 

    private void enableOverviewMode(boolean enable, int snapPage, boolean animated) {
        State finalState = Workspace.State.OVERVIEW;
        if (!enable) {
            finalState = Workspace.State.NORMAL;
        }

        if (mWorkspaceAnim != null) {
            mWorkspaceAnim.setDuration(0);
            mWorkspaceAnim.cancel();
            mWorkspaceAnim = null;
        }

        mWorkspaceAnim = getChangeStateAnimation(finalState, animated, 0, snapPage);
        if (mWorkspaceAnim != null) {
            onTransitionPrepare();
            mWorkspaceAnim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator arg0) {
                    onTransitionEnd();
                    mWorkspaceAnim = null;
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    mWorkspaceAnim = null;
                }
            });
            mWorkspaceAnim.start();
        }
    }

    int getOverviewModeTranslationY() {
        int childHeight = getNormalChildHeight();
        int viewPortHeight = getViewportHeight();
        int scaledChildHeight = (int) (mOverviewModeShrinkFactor * childHeight);

        int offset = (viewPortHeight - scaledChildHeight) / 2;
        int offsetDelta = mOverviewModePageOffset - offset + mInsets.top;

        return offsetDelta;
    }

    boolean shouldVoiceButtonProxyBeVisible() {
        if (isOnOrMovingToCustomContent()) {
            return false;
        }
        if (mState != State.NORMAL) {
            return false;
        }
        return true;
    }

    public void updateInteractionForState() {
        if (mState != State.NORMAL) {
            mLauncher.onInteractionBegin();
        } else {
            mLauncher.onInteractionEnd();
        }
    }

    private void setState(State state) {
        mState = state;
        updateInteractionForState();
        updateAccessibilityFlags();
    }

    private void updateAccessibilityFlags() {
        int accessible = mState == State.NORMAL ?
                View.IMPORTANT_FOR_ACCESSIBILITY_YES :
                View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS;
        setImportantForAccessibility(accessible);
    }

    Animator getChangeStateAnimation(final State state, boolean animated, int delay, int snapPage) {
        if (mState == state) {
            return null;
        }

        // Initialize animation arrays for the first time if necessary
        initAnimationArrays();

        AnimatorSet anim = animated ? LauncherAnimUtils.createAnimatorSet() : null;

        final State oldState = mState;
        final boolean oldStateIsNormal = (oldState == State.NORMAL);
        final boolean oldStateIsSpringLoaded = (oldState == State.SPRING_LOADED);
        final boolean oldStateIsSmall = (oldState == State.SMALL);
        final boolean oldStateIsOverview = (oldState == State.OVERVIEW);
        setState(state);
        final boolean stateIsNormal = (state == State.NORMAL);
        final boolean stateIsSpringLoaded = (state == State.SPRING_LOADED);
        final boolean stateIsSmall = (state == State.SMALL);
        final boolean stateIsOverview = (state == State.OVERVIEW);
        float finalBackgroundAlpha = (stateIsSpringLoaded || stateIsOverview) ? 1.0f : 0f;
        float finalHotseatAndPageIndicatorAlpha = (stateIsOverview || stateIsSmall) ? 0f : 1f;
        float finalOverviewPanelAlpha = stateIsOverview ? 1f : 0f;
        float finalSearchBarAlpha = !stateIsNormal ? 0f : 1f;
        float finalWorkspaceTranslationY = stateIsOverview ? getOverviewModeTranslationY() : 0;

        boolean workspaceToAllApps = (oldStateIsNormal && stateIsSmall);
        boolean allAppsToWorkspace = (oldStateIsSmall && stateIsNormal);
        boolean workspaceToOverview = (oldStateIsNormal && stateIsOverview);
        boolean overviewToWorkspace = (oldStateIsOverview && stateIsNormal);

        mNewScale = 1.0f;

        if (oldStateIsOverview) {
            disableFreeScroll(snapPage);
        } else if (stateIsOverview) {
            enableFreeScroll();
        }

        if (state != State.NORMAL) {
            if (stateIsSpringLoaded) {
                mNewScale = mSpringLoadedShrinkFactor;
            } else if (stateIsOverview) {
                mNewScale = mOverviewModeShrinkFactor;
            } else if (stateIsSmall){
                mNewScale = mOverviewModeShrinkFactor - 0.3f;
            }
            if (workspaceToAllApps) {
                updateChildrenLayersEnabled(false);
            }
        }

        final int duration;
        if (workspaceToAllApps) {
            duration = getResources().getInteger(R.integer.config_workspaceUnshrinkTime);
        } else if (workspaceToOverview || overviewToWorkspace) {
            duration = getResources().getInteger(R.integer.config_overviewTransitionTime);
        } else {
            duration = getResources().getInteger(R.integer.config_appsCustomizeWorkspaceShrinkTime);
        }

        for (int i = 0; i < getChildCount(); i++) {
            final CellLayout cl = (CellLayout) getChildAt(i);
            boolean isCurrentPage = (i == getNextPage());
            float initialAlpha = cl.getShortcutsAndWidgets().getAlpha();
            float finalAlpha = stateIsSmall ? 0f : 1f;

            // If we are animating to/from the small state, then hide the side pages and fade the
            // current page in
            if (!mIsSwitchingState) {
                if (workspaceToAllApps || allAppsToWorkspace) {
                    if (allAppsToWorkspace && isCurrentPage) {
                        initialAlpha = 0f;
                    } else if (!isCurrentPage) {
                        initialAlpha = finalAlpha = 0f;
                    }
                    cl.setShortcutAndWidgetAlpha(initialAlpha);
                }
            }

            mOldAlphas[i] = initialAlpha;
            mNewAlphas[i] = finalAlpha;
            if (animated) {
                mOldBackgroundAlphas[i] = cl.getBackgroundAlpha();
                mNewBackgroundAlphas[i] = finalBackgroundAlpha;
            } else {
                cl.setBackgroundAlpha(finalBackgroundAlpha);
                cl.setShortcutAndWidgetAlpha(finalAlpha);
            }
        }

        final View searchBar = mLauncher.getQsbBar();
        final View overviewPanel = mLauncher.getOverviewPanel();
        final View hotseat = mLauncher.getHotseat();
        if (animated) {
            anim.setDuration(duration);
            LauncherViewPropertyAnimator scale = new LauncherViewPropertyAnimator(this);
            scale.scaleX(mNewScale)
                .scaleY(mNewScale)
                .translationY(finalWorkspaceTranslationY)
                .setInterpolator(mZoomInInterpolator);
            anim.play(scale);
            for (int index = 0; index < getChildCount(); index++) {
                final int i = index;
                final CellLayout cl = (CellLayout) getChildAt(i);
                float currentAlpha = cl.getShortcutsAndWidgets().getAlpha();
                if (mOldAlphas[i] == 0 && mNewAlphas[i] == 0) {
                    cl.setBackgroundAlpha(mNewBackgroundAlphas[i]);
                    cl.setShortcutAndWidgetAlpha(mNewAlphas[i]);
                } else {
                    if (mOldAlphas[i] != mNewAlphas[i] || currentAlpha != mNewAlphas[i]) {
                        LauncherViewPropertyAnimator alphaAnim =
                            new LauncherViewPropertyAnimator(cl.getShortcutsAndWidgets());
                        alphaAnim.alpha(mNewAlphas[i])
                            .setInterpolator(mZoomInInterpolator);
                        anim.play(alphaAnim);
                    }
                    if (mOldBackgroundAlphas[i] != 0 ||
                        mNewBackgroundAlphas[i] != 0) {
                        ValueAnimator bgAnim =
                                LauncherAnimUtils.ofFloat(cl, 0f, 1f);
                        bgAnim.setInterpolator(mZoomInInterpolator);
                        bgAnim.addUpdateListener(new LauncherAnimatorUpdateListener() {
                                public void onAnimationUpdate(float a, float b) {
                                    cl.setBackgroundAlpha(
                                            a * mOldBackgroundAlphas[i] +
                                            b * mNewBackgroundAlphas[i]);
                                }
                            });
                        anim.play(bgAnim);
                    }
                }
            }
            ObjectAnimator pageIndicatorAlpha = null;
            if (getPageIndicator() != null) {
                pageIndicatorAlpha = ObjectAnimator.ofFloat(getPageIndicator(), "alpha",
                        finalHotseatAndPageIndicatorAlpha);
            }
            ObjectAnimator hotseatAlpha = ObjectAnimator.ofFloat(hotseat, "alpha",
                    finalHotseatAndPageIndicatorAlpha);
            ObjectAnimator searchBarAlpha = ObjectAnimator.ofFloat(searchBar,
                    "alpha", finalSearchBarAlpha);
            ObjectAnimator overviewPanelAlpha = ObjectAnimator.ofFloat(overviewPanel,
                    "alpha", finalOverviewPanelAlpha);

            overviewPanelAlpha.addListener(new AlphaUpdateListener(overviewPanel));
            hotseatAlpha.addListener(new AlphaUpdateListener(hotseat));
            searchBarAlpha.addListener(new AlphaUpdateListener(searchBar));

            if (workspaceToOverview) {
                hotseatAlpha.setInterpolator(new DecelerateInterpolator(2));
            } else if (overviewToWorkspace) {
                overviewPanelAlpha.setInterpolator(new DecelerateInterpolator(2));
            }

            if (getPageIndicator() != null) {
                pageIndicatorAlpha.addListener(new AlphaUpdateListener(getPageIndicator()));
            }

            anim.play(overviewPanelAlpha);
            anim.play(hotseatAlpha);
            anim.play(searchBarAlpha);
            anim.play(pageIndicatorAlpha);
            anim.setStartDelay(delay);
        } else {
            overviewPanel.setAlpha(finalOverviewPanelAlpha);
            AlphaUpdateListener.updateVisibility(overviewPanel);
            hotseat.setAlpha(finalHotseatAndPageIndicatorAlpha);
            AlphaUpdateListener.updateVisibility(hotseat);
            if (getPageIndicator() != null) {
                getPageIndicator().setAlpha(finalHotseatAndPageIndicatorAlpha);
                AlphaUpdateListener.updateVisibility(getPageIndicator());
            }
            searchBar.setAlpha(finalSearchBarAlpha);
            AlphaUpdateListener.updateVisibility(searchBar);
            updateCustomContentVisibility();
            setScaleX(mNewScale);
            setScaleY(mNewScale);
            setTranslationY(finalWorkspaceTranslationY);
        }
        mLauncher.updateVoiceButtonProxyVisible(false);

        if (stateIsSpringLoaded) {
            // Right now we're covered by Apps Customize
            // Show the background gradient immediately, so the gradient will
            // be showing once AppsCustomize disappears
            animateBackgroundGradient(getResources().getInteger(
                    R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100f, false);
        } else if (stateIsOverview) {
            animateBackgroundGradient(getResources().getInteger(
                    R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100f, true);
        } else {
            // Fade the background gradient away
            animateBackgroundGradient(0f, animated);
        }
        return anim;
    }

    static class AlphaUpdateListener implements AnimatorUpdateListener, AnimatorListener {
        View view;
        public AlphaUpdateListener(View v) {
            view = v;
        }

        @Override
        public void onAnimationUpdate(ValueAnimator arg0) {
            updateVisibility(view);
        }

        public static void updateVisibility(View view) {
            // We want to avoid the extra layout pass by setting the views to GONE unless
            // accessibility is on, in which case not setting them to GONE causes a glitch.
            int invisibleState = sAccessibilityEnabled ? GONE : INVISIBLE;
            if (view.getAlpha() < ALPHA_CUTOFF_THRESHOLD && view.getVisibility() != invisibleState) {
                view.setVisibility(invisibleState);
            } else if (view.getAlpha() > ALPHA_CUTOFF_THRESHOLD
                    && view.getVisibility() != VISIBLE) {
                view.setVisibility(VISIBLE);
            }
        }

        @Override
        public void onAnimationCancel(Animator arg0) {
        }

        @Override
        public void onAnimationEnd(Animator arg0) {
            updateVisibility(view);
        }

        @Override
        public void onAnimationRepeat(Animator arg0) {
        }

        @Override
        public void onAnimationStart(Animator arg0) {
            // We want the views to be visible for animation, so fade-in/out is visible
            view.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onLauncherTransitionPrepare(Launcher l, boolean animated, boolean toWorkspace) {
        onTransitionPrepare();
    }

    @Override
    public void onLauncherTransitionStart(Launcher l, boolean animated, boolean toWorkspace) {
    }

    @Override
    public void onLauncherTransitionStep(Launcher l, float t) {
        mTransitionProgress = t;
    }

    @Override
    public void onLauncherTransitionEnd(Launcher l, boolean animated, boolean toWorkspace) {
        onTransitionEnd();
    }

    private void onTransitionPrepare() {
        mIsSwitchingState = true;

        // Invalidate here to ensure that the pages are rendered during the state change transition.
        invalidate();

        updateChildrenLayersEnabled(false);
        hideCustomContentIfNecessary();
    }

    void updateCustomContentVisibility() {
        int visibility = mState == Workspace.State.NORMAL ? VISIBLE : INVISIBLE;
        if (hasCustomContent()) {
            mWorkspaceScreens.get(CUSTOM_CONTENT_SCREEN_ID).setVisibility(visibility);
        }
    }

    void showCustomContentIfNecessary() {
        boolean show  = mState == Workspace.State.NORMAL;
        if (show && hasCustomContent()) {
            mWorkspaceScreens.get(CUSTOM_CONTENT_SCREEN_ID).setVisibility(VISIBLE);
        }
    }

    void hideCustomContentIfNecessary() {
        boolean hide  = mState != Workspace.State.NORMAL;
        if (hide && hasCustomContent()) {
            mWorkspaceScreens.get(CUSTOM_CONTENT_SCREEN_ID).setVisibility(INVISIBLE);
        }
    }

    private void onTransitionEnd() {
        mIsSwitchingState = false;
        updateChildrenLayersEnabled(false);
        // The code in getChangeStateAnimation to determine initialAlpha and finalAlpha will ensure
        // ensure that only the current page is visible during (and subsequently, after) the
        // transition animation.  If fade adjacent pages is disabled, then re-enable the page
        // visibility after the transition animation.
        if (!mWorkspaceFadeInAdjacentScreens) {
            for (int i = 0; i < getChildCount(); i++) {
                final CellLayout cl = (CellLayout) getChildAt(i);
                cl.setShortcutAndWidgetAlpha(1f);
            }
        }
        showCustomContentIfNecessary();
    }

    @Override
    public View getContent() {
        return this;
    }

    /**
     * Draw the View v into the given Canvas.
     *
     * @param v the view to draw
     * @param destCanvas the canvas to draw on
     * @param padding the horizontal and vertical padding to use when drawing
     */
    private void drawDragView(View v, Canvas destCanvas, int padding, boolean pruneToDrawable) {
        final Rect clipRect = mTempRect;
        v.getDrawingRect(clipRect);

        boolean textVisible = false;

        destCanvas.save();
        if (v instanceof TextView && pruneToDrawable) {
            Drawable d = ((TextView) v).getCompoundDrawables()[1];
            clipRect.set(0, 0, d.getIntrinsicWidth() + padding, d.getIntrinsicHeight() + padding);
            destCanvas.translate(padding / 2, padding / 2);
            d.draw(destCanvas);
        } else {
            if (v instanceof FolderIcon) {
                // For FolderIcons the text can bleed into the icon area, and so we need to
                // hide the text completely (which can't be achieved by clipping).
                if (((FolderIcon) v).getTextVisible()) {
                    ((FolderIcon) v).setTextVisible(false);
                    textVisible = true;
                }
            } else if (v instanceof BubbleTextView) {
                final BubbleTextView tv = (BubbleTextView) v;
                clipRect.bottom = tv.getExtendedPaddingTop() - (int) BubbleTextView.PADDING_V +
                        tv.getLayout().getLineTop(0);
            } else if (v instanceof TextView) {
                final TextView tv = (TextView) v;
                clipRect.bottom = tv.getExtendedPaddingTop() - tv.getCompoundDrawablePadding() +
                        tv.getLayout().getLineTop(0);
            }
            destCanvas.translate(-v.getScrollX() + padding / 2, -v.getScrollY() + padding / 2);
            destCanvas.clipRect(clipRect);
            v.draw(destCanvas);

            // Restore text visibility of FolderIcon if necessary
            if (textVisible) {
                ((FolderIcon) v).setTextVisible(true);
            }
        }
        destCanvas.restore();
    }

    /**
     * Returns a new bitmap to show when the given View is being dragged around.
     * Responsibility for the bitmap is transferred to the caller.
     */
    public Bitmap createDragBitmap(View v, Canvas canvas, int padding) {
        Bitmap b;

        if (v instanceof TextView) {
            Drawable d = ((TextView) v).getCompoundDrawables()[1];
            b = Bitmap.createBitmap(d.getIntrinsicWidth() + padding,
                    d.getIntrinsicHeight() + padding, Bitmap.Config.ARGB_8888);
        } else {
            b = Bitmap.createBitmap(
                    v.getWidth() + padding, v.getHeight() + padding, Bitmap.Config.ARGB_8888);
        }

        canvas.setBitmap(b);
        drawDragView(v, canvas, padding, true);
        canvas.setBitmap(null);

        return b;
    }

    void startDrag(CellLayout.CellInfo cellInfo) {
        View child = cellInfo.cell;
        if (!child.isInTouchMode()) {
            return;
        }
        mDragInfo = cellInfo;
        child.setVisibility(INVISIBLE);
        CellLayout layout = (CellLayout) child.getParent().getParent();
        layout.prepareChildForDrag(child);
        child.clearFocus();
        child.setPressed(false);
        final Canvas canvas = new Canvas();
        
        // Identify view type for scaling
        boolean isWidget = false;
        if (child instanceof LauncherAppWidgetHostView) {
            final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) child;
            AppWidgetProviderInfo pinfo = hostView.getAppWidgetInfo();
            if (pinfo != null && pinfo.resizeMode != AppWidgetProviderInfo.RESIZE_NONE) {
                isWidget = true;
            }
        }
        
        float widgetScale = isWidget ? widgetScaleFactor : 1.0f;
        
        // Create scaled drag outline
        mDragOutline = createDragOutline(child, canvas, DRAG_BITMAP_PADDING, widgetScale);
        
        beginDragShared(child, this, widgetScale);
    }

    public void beginDragShared(View child, DragSource source, float widgetScale) {
        // Create original drag bitmap
        Bitmap originalBitmap = createDragBitmap(child, new Canvas(), DRAG_BITMAP_PADDING);
        Bitmap finalBitmap = originalBitmap;

        final int bmpWidth = originalBitmap.getWidth();
        final int bmpHeight = originalBitmap.getHeight();

        // Apply scaling only to widgets
        if (widgetScale != 1.0f) {
            int newWidth = (int)(originalBitmap.getWidth() * widgetScale);
            int newHeight = (int)(originalBitmap.getHeight() * widgetScale);
            Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(scaledBitmap);
            canvas.scale(widgetScale, widgetScale);
            canvas.drawBitmap(originalBitmap, 0, 0, null);
            originalBitmap.recycle();
            finalBitmap = scaledBitmap;
        }

        // Calculate position for the widgets
        float baseScale = mLauncher.getDragLayer().getLocationInDragLayer(child, mTempXY);
        int dragLayerX, dragLayerY;
        if (widgetScale != 1.0f) {
            float childCenterX = mTempXY[0] + (child.getWidth() * baseScale) / 2;
            float childCenterY = mTempXY[1] + (child.getHeight() * baseScale) / 2;
            dragLayerX = Math.round(childCenterX - finalBitmap.getWidth() / 2);
            dragLayerY = Math.round(childCenterY - finalBitmap.getHeight() / 2);
        } else {
            dragLayerX = Math.round(mTempXY[0] - (finalBitmap.getWidth() - baseScale * child.getWidth()) / 2);
            dragLayerY = Math.round(mTempXY[1] - (finalBitmap.getHeight() - baseScale * child.getHeight()) / 2 - DRAG_BITMAP_PADDING / 2);
        }

        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        Point dragVisualizeOffset = null;
        Rect dragRect = null;
        if (child instanceof BubbleTextView || child instanceof PagedViewIcon) {
            int iconSize = grid.iconSizePx;
            int top = child.getPaddingTop();
            int left = (bmpWidth - iconSize) / 2;
            int right = left + iconSize;
            int bottom = top + iconSize;
            dragLayerY += top;
            // Note: The drag region is used to calculate drag layer offsets, but the
            // dragVisualizeOffset in addition to the dragRect (the size) to position the outline.
            dragVisualizeOffset = new Point(-DRAG_BITMAP_PADDING / 2, DRAG_BITMAP_PADDING / 2);
            dragRect = new Rect(left, top, right, bottom);
        } else if (child instanceof FolderIcon) {
            int previewSize = grid.folderIconSizePx;
            dragRect = new Rect(0, child.getPaddingTop(), child.getWidth(), previewSize);
        }

        // Clear the pressed state if necessary
        if (child instanceof BubbleTextView) {
            BubbleTextView icon = (BubbleTextView) child;
            icon.clearPressedOrFocusedBackground();
        }

        // Start drag operation
        mDragController.startDrag(
            finalBitmap, 
            dragLayerX, 
            dragLayerY, 
            source, 
            child.getTag(),
            DragController.DRAG_ACTION_MOVE, 
            dragVisualizeOffset, 
            dragRect,
            1.0f
        );

        if (child.getParent() instanceof ShortcutAndWidgetContainer) {
            mDragSourceInternal = (ShortcutAndWidgetContainer) child.getParent();
        }
    }

    /**
     * Returns a new bitmap to be used as the object outline, e.g. to visualize the drop location.
     * Responsibility for the bitmap is transferred to the caller.
     */   
    private Bitmap createDragOutline(View v, Canvas canvas, int padding, float scale) {
        // Calculate scaled dimensions
        int width = (int)((v.getWidth() + padding) * scale);
        int height = (int)((v.getHeight() + padding) * scale);
        final Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        
        if (isDebug) {
            // Fill with a background color to see the bitmap bounds
            b.eraseColor(Color.RED);            
        }
        
        canvas.setBitmap(b);
        canvas.save();
        canvas.scale(scale, scale);
        drawDragView(v, canvas, padding, true);
        canvas.restore();

        if (!isDebug) {
        // Apply outline effect
            final int outlineColor = ContextCompat.getColor(getContext(), R.color.outline_color);
            mOutlineHelper.applyMediumExpensiveOutlineWithBlur(b, canvas, outlineColor, outlineColor);
        }
        canvas.setBitmap(null);
        return b;
    }
     
     /**
     * Returns a new bitmap to be used as the object outline, e.g. to visualize the drop location.
     * Responsibility for the bitmap is transferred to the caller.
     */
    private Bitmap createDragOutline(Bitmap orig, Canvas canvas, int padding, int w, int h, boolean clipAlpha) {
        final int outlineColor = ContextCompat.getColor(getContext(), R.color.outline_color);
        final Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);

        Rect src = new Rect(0, 0, orig.getWidth(), orig.getHeight());
        float scaleFactor = Math.min((w - padding) / (float) orig.getWidth(),
                (h - padding) / (float) orig.getHeight());
        int scaledWidth = (int) (scaleFactor * orig.getWidth());
        int scaledHeight = (int) (scaleFactor * orig.getHeight());
        Rect dst = new Rect(0, 0, scaledWidth, scaledHeight);

        // Center the image
        dst.offset((w - scaledWidth) / 2, (h - scaledHeight) / 2);

        canvas.drawBitmap(orig, src, dst, null);
        mOutlineHelper.applyMediumExpensiveOutlineWithBlur(b, canvas, outlineColor, outlineColor, clipAlpha);
        canvas.setBitmap(null);

        return b;
    }

    void addApplicationShortcut(ShortcutInfo info, CellLayout target, long container, long screenId,
            int cellX, int cellY, boolean insertAtFirst, int intersectX, int intersectY) {
        View view = mLauncher.createShortcut(R.layout.application, target, (ShortcutInfo) info);

        final int[] cellXY = new int[2];
        target.findCellForSpanThatIntersects(cellXY, 1, 1, intersectX, intersectY);
        addInScreen(view, container, screenId, cellXY[0], cellXY[1], 1, 1, insertAtFirst);

        LauncherModel.addOrMoveItemInDatabase(mLauncher, info, container, screenId, cellXY[0],
                cellXY[1]);
    }

    public boolean transitionStateShouldAllowDrop() {
        return ((!isSwitchingState() || mTransitionProgress > 0.5f) && mState != State.SMALL);
    }

    /**
     * {@inheritDoc}
     */
    public boolean acceptDrop(DragObject d) {
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout) {
            // If it's an external drop (e.g. from All Apps), check if it should be accepted
            CellLayout dropTargetLayout = mDropToLayout;
            if (d.dragSource != this) {
                // Don't accept the drop if we're not over a screen at time of drop
                if (dropTargetLayout == null) {
                    return false;
                }
                if (!transitionStateShouldAllowDrop()) return false;

                mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset,
                        d.dragView, mDragViewVisualCenter);

                // We want the point to be mapped to the dragTarget.
                if (mLauncher.isHotseatLayout(dropTargetLayout)) {
                    mapPointFromSelfToHotseatLayout(mLauncher.getHotseat(), mDragViewVisualCenter);
                } else {
                    mapPointFromSelfToChild(dropTargetLayout, mDragViewVisualCenter, null);
                }

                int spanX = 1;
                int spanY = 1;
                if (mDragInfo != null) {
                    final CellLayout.CellInfo dragCellInfo = mDragInfo;
                    spanX = dragCellInfo.spanX;
                    spanY = dragCellInfo.spanY;
                } else {
                    final ItemInfo dragInfo = (ItemInfo) d.dragInfo;
                    spanX = dragInfo.spanX;
                    spanY = dragInfo.spanY;
                }

                int minSpanX = spanX;
                int minSpanY = spanY;
                if (d.dragInfo instanceof PendingAddWidgetInfo) {
                    minSpanX = ((PendingAddWidgetInfo) d.dragInfo).minSpanX;
                    minSpanY = ((PendingAddWidgetInfo) d.dragInfo).minSpanY;
                }

                mTargetCell = findNearestArea((int) mDragViewVisualCenter[0],
                        (int) mDragViewVisualCenter[1], minSpanX, minSpanY, dropTargetLayout,
                        mTargetCell);
                float distance = dropTargetLayout.getDistanceFromCell(mDragViewVisualCenter[0],
                        mDragViewVisualCenter[1], mTargetCell);
                if (willCreateUserFolder((ItemInfo) d.dragInfo, dropTargetLayout,
                        mTargetCell, distance, true)) {
                    return true;
                }
                if (willAddToExistingUserFolder((ItemInfo) d.dragInfo, dropTargetLayout,
                        mTargetCell, distance)) {
                    return true;
                }

                int[] resultSpan = new int[2];
                mTargetCell = dropTargetLayout.createArea((int) mDragViewVisualCenter[0],
                        (int) mDragViewVisualCenter[1], minSpanX, minSpanY, spanX, spanY,
                        null, mTargetCell, resultSpan, CellLayout.MODE_ACCEPT_DROP);
                boolean foundCell = mTargetCell[0] >= 0 && mTargetCell[1] >= 0;

                // Don't accept the drop if there's no room for the item
                if (!foundCell) {
                    // Don't show the message if we are dropping on the AllApps button and the hotseat
                    // is full
                    boolean isHotseat = mLauncher.isHotseatLayout(dropTargetLayout);
                    if (mTargetCell != null && isHotseat) {
                        Hotseat hotseat = mLauncher.getHotseat();
                        if (hotseat.isAllAppsButtonRank(
                                hotseat.getOrderInHotseat(mTargetCell[0], mTargetCell[1]))) {
                            return false;
                        }
                    }

                    mLauncher.showOutOfSpaceMessage(isHotseat);
                    return false;
                }
            }

            long screenId = getIdForScreen(dropTargetLayout);
            if (screenId == EXTRA_EMPTY_SCREEN_ID) {
                commitExtraEmptyScreen();
            }

            return true;            
        }
        mLauncher.showOutOfSpaceMessage(false);
        return false; 
    }

    boolean willCreateUserFolder(ItemInfo info, CellLayout target, int[] targetCell, float
            distance, boolean considerTimeout) {
        if (distance > mMaxDistanceForFolderCreation) return false;
        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);

        if (dropOverView != null) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) dropOverView.getLayoutParams();
            if (lp.useTmpCoords && (lp.tmpCellX != lp.cellX || lp.tmpCellY != lp.tmpCellY)) {
                return false;
            }
        }

        boolean hasntMoved = false;
        if (mDragInfo != null) {
            hasntMoved = dropOverView == mDragInfo.cell;
        }

        if (dropOverView == null || hasntMoved || (considerTimeout && !mCreateUserFolderOnDrop)) {
            return false;
        }

        boolean aboveShortcut = (dropOverView.getTag() instanceof ShortcutInfo);
        boolean willBecomeShortcut =
                (info.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION ||
                info.itemType == LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT);

        return (aboveShortcut && willBecomeShortcut);
    }

    boolean willAddToExistingUserFolder(Object dragInfo, CellLayout target, int[] targetCell,
            float distance) {
        if (distance > mMaxDistanceForFolderCreation) return false;
        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);

        if (dropOverView != null) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) dropOverView.getLayoutParams();
            if (lp.useTmpCoords && (lp.tmpCellX != lp.cellX || lp.tmpCellY != lp.tmpCellY)) {
                return false;
            }
        }

        if (dropOverView instanceof FolderIcon) {
            FolderIcon fi = (FolderIcon) dropOverView;
            if (fi.acceptDrop(dragInfo)) {
                return true;
            }
        }
        return false;
    }

    boolean createUserFolderIfNecessary(View newView, long container, CellLayout target,
            int[] targetCell, float distance, boolean external, DragView dragView,
            Runnable postAnimationRunnable) {
        if (distance > mMaxDistanceForFolderCreation) return false;
        View v = target.getChildAt(targetCell[0], targetCell[1]);

        boolean hasntMoved = false;
        if (mDragInfo != null) {
            CellLayout cellParent = getParentCellLayoutForView(mDragInfo.cell);
            hasntMoved = (mDragInfo.cellX == targetCell[0] &&
                    mDragInfo.cellY == targetCell[1]) && (cellParent == target);
        }

        if (v == null || hasntMoved || !mCreateUserFolderOnDrop) return false;
        mCreateUserFolderOnDrop = false;
        final long screenId = (targetCell == null) ? mDragInfo.screenId : getIdForScreen(target);

        boolean aboveShortcut = (v.getTag() instanceof ShortcutInfo);
        boolean willBecomeShortcut = (newView.getTag() instanceof ShortcutInfo);

        if (aboveShortcut && willBecomeShortcut) {
            ShortcutInfo sourceInfo = (ShortcutInfo) newView.getTag();
            ShortcutInfo destInfo = (ShortcutInfo) v.getTag();
            // if the drag started here, we need to remove it from the workspace
            if (!external) {
                getParentCellLayoutForView(mDragInfo.cell).removeView(mDragInfo.cell);
            }

            Rect folderLocation = new Rect();
            float scale = mLauncher.getDragLayer().getDescendantRectRelativeToSelf(v, folderLocation);
            target.removeView(v);

            FolderIcon fi =
                mLauncher.addFolder(target, container, screenId, targetCell[0], targetCell[1]);
            destInfo.cellX = -1;
            destInfo.cellY = -1;
            sourceInfo.cellX = -1;
            sourceInfo.cellY = -1;

            // If the dragView is null, we can't animate
            boolean animate = dragView != null;
            if (animate) {
                fi.performCreateAnimation(destInfo, v, sourceInfo, dragView, folderLocation, scale,
                        postAnimationRunnable);
            } else {
                fi.addItem(destInfo);
                fi.addItem(sourceInfo);
            }
            return true;
        }
        return false;
    }

    boolean addToExistingFolderIfNecessary(View newView, CellLayout target, int[] targetCell,
            float distance, DragObject d, boolean external) {
        if (distance > mMaxDistanceForFolderCreation) return false;

        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);
        if (!mAddToExistingFolderOnDrop) return false;
        mAddToExistingFolderOnDrop = false;

        if (dropOverView instanceof FolderIcon) {
            FolderIcon fi = (FolderIcon) dropOverView;
            if (fi.acceptDrop(d.dragInfo)) {
                fi.onDrop(d);

                // if the drag started here, we need to remove it from the workspace
                if (!external) {
                    getParentCellLayoutForView(mDragInfo.cell).removeView(mDragInfo.cell);
                }
                return true;
            }
        }
        return false;
    }

    public void onDrop(final DragObject d) {      
        Log.i(TAG, "Screen order onDrop(): " + mScreenOrder);
        mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset, d.dragView,
                mDragViewVisualCenter);

        CellLayout dropTargetLayout = mDropToLayout;

        if (d.dragInfo instanceof Intent) {
            Intent intent = (Intent) d.dragInfo;
            PackageManager pm = mLauncher.getPackageManager();
            ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
            
            if (resolveInfo != null) {
                AppInfo appInfo = new AppInfo(pm, resolveInfo, mIconCache, new HashMap<>());
                ShortcutInfo shortcutInfo = new ShortcutInfo(appInfo);
                shortcutInfo.setIcon(mIconCache.getIcon(intent));
                shortcutInfo.spanX = 1;
                shortcutInfo.spanY = 1;
                d.dragInfo = shortcutInfo;
            } else {
                Log.e(TAG, "Failed to resolve intent: " + intent);
                return;
            }
        }

        // We want the point to be mapped to the dragTarget.
        if (dropTargetLayout != null) {
            if (mLauncher.isHotseatLayout(dropTargetLayout)) {
                Log.d(TAG,"onDrop()  is hotset layout mDragViewVisualCenter = "+mDragViewVisualCenter);
                mapPointFromSelfToHotseatLayout(mLauncher.getHotseat(), mDragViewVisualCenter);
            } else {
                mapPointFromSelfToChild(dropTargetLayout, mDragViewVisualCenter, null);
            }
        }

        int snapScreen = -1;
        boolean resizeOnDrop = false;
        if (d.dragSource != this) {
            Log.d(TAG,"onDrop()  d.dragSource = " + d.dragSource);
            final int[] touchXY = new int[] { (int) mDragViewVisualCenter[0],
                    (int) mDragViewVisualCenter[1] };
            onDropExternal(touchXY, d.dragInfo, dropTargetLayout, false, d);
            triggerStripEmptyScreens("Workspace, onDrop(), 1", true);
        } else if (mDragInfo != null) {
            final View cell = mDragInfo.cell;
            Log.d(TAG,"onDrop()  mDragInfo = " + mDragInfo);

            Runnable resizeRunnable = null;
            if (dropTargetLayout != null && !d.cancelled) {
                // Move internally
                boolean hasMovedLayouts = (getParentCellLayoutForView(cell) != dropTargetLayout);
                boolean hasMovedIntoHotseat = mLauncher.isHotseatLayout(dropTargetLayout);
                long container = hasMovedIntoHotseat ?
                        LauncherSettings.Favorites.CONTAINER_HOTSEAT :
                        LauncherSettings.Favorites.CONTAINER_DESKTOP;
                long screenId = (mTargetCell[0] < 0) ?
                        mDragInfo.screenId : getIdForScreen(dropTargetLayout);
                int spanX = mDragInfo != null ? mDragInfo.spanX : 1;
                int spanY = mDragInfo != null ? mDragInfo.spanY : 1;
                // First we find the cell nearest to point at which the item is
                // dropped, without any consideration to whether there is an item there.

                mTargetCell = findNearestArea((int) mDragViewVisualCenter[0], (int)
                        mDragViewVisualCenter[1], spanX, spanY, dropTargetLayout, mTargetCell);
                float distance = dropTargetLayout.getDistanceFromCell(mDragViewVisualCenter[0],
                        mDragViewVisualCenter[1], mTargetCell);

                // If the item being dropped is a shortcut and the nearest drop
                // cell also contains a shortcut, then create a folder with the two shortcuts.
                if (!mInScrollArea && createUserFolderIfNecessary(cell, container,
                        dropTargetLayout, mTargetCell, distance, false, d.dragView, null)) {
                    triggerStripEmptyScreens("Workspace, onDrop(), 2", false);
                    return;
                }

                if (addToExistingFolderIfNecessary(cell, dropTargetLayout, mTargetCell,
                        distance, d, false)) {
                    triggerStripEmptyScreens("Workspace, onDrop(), 3", false);
                    return;
                } else {
                    promptFolderFullIfNecessary(dropTargetLayout, mTargetCell, (ItemInfo) d.dragInfo);
                }

                // Aside from the special case where we're dropping a shortcut onto a shortcut,
                // we need to find the nearest cell location that is vacant
                ItemInfo item = (ItemInfo) d.dragInfo;
                int minSpanX = item.spanX;
                int minSpanY = item.spanY;
                if (item.minSpanX > 0 && item.minSpanY > 0) {
                    minSpanX = item.minSpanX;
                    minSpanY = item.minSpanY;
                }

                int[] resultSpan = new int[2];
                mTargetCell = dropTargetLayout.createArea((int) mDragViewVisualCenter[0],
                        (int) mDragViewVisualCenter[1], minSpanX, minSpanY, spanX, spanY, cell,
                        mTargetCell, resultSpan, CellLayout.MODE_ON_DROP);

                boolean foundCell = mTargetCell[0] >= 0 && mTargetCell[1] >= 0;

                // if the widget resizes on drop
                if (foundCell && (cell instanceof AppWidgetHostView) &&
                        (resultSpan[0] != item.spanX || resultSpan[1] != item.spanY)) {
                    resizeOnDrop = true;
                    item.spanX = resultSpan[0];
                    item.spanY = resultSpan[1];
                    AppWidgetHostView awhv = (AppWidgetHostView) cell;
                    AppWidgetResizeFrame.updateWidgetSizeRanges(awhv, mLauncher, resultSpan[0],
                            resultSpan[1]);
                }

                if (getScreenIdForPageIndex(mCurrentPage) != screenId && !hasMovedIntoHotseat) {
                    snapScreen = getPageIndexForScreenId(screenId);
                    snapToPage(snapScreen);
                }

                if (foundCell) {
                    final ItemInfo info = (ItemInfo) cell.getTag();
                    if (hasMovedLayouts) {
                        // Reparent the view
                        if(getParentCellLayoutForView(cell) != null){
                            getParentCellLayoutForView(cell).removeView(cell);
                        }else{
                            Log.w(TAG,"when onDrop,the parent cell layout is null!");
                        }
                        addInScreen(cell, container, screenId, mTargetCell[0], mTargetCell[1],
                                info.spanX, info.spanY);
                    }

                    // update the item's position after drop
                    CellLayout.LayoutParams lp = (CellLayout.LayoutParams) cell.getLayoutParams();
                    lp.cellX = lp.tmpCellX = mTargetCell[0];
                    lp.cellY = lp.tmpCellY = mTargetCell[1];
                    lp.cellHSpan = item.spanX;
                    lp.cellVSpan = item.spanY;
                    lp.isLockedToGrid = true;
                    cell.setId(LauncherModel.getCellLayoutChildId(container, mDragInfo.screenId,
                            mTargetCell[0], mTargetCell[1], mDragInfo.spanX, mDragInfo.spanY));

                    if (container != LauncherSettings.Favorites.CONTAINER_HOTSEAT &&
                            cell instanceof LauncherAppWidgetHostView) {
                        final CellLayout cellLayout = dropTargetLayout;
                        // We post this call so that the widget has a chance to be placed
                        // in its final location

                        final LauncherAppWidgetHostView hostView = (LauncherAppWidgetHostView) cell;
                        AppWidgetProviderInfo pinfo = hostView.getAppWidgetInfo();
                        if (pinfo != null) {
                            final Runnable addResizeFrame = new Runnable() {
                                public void run() {
                                    DragLayer dragLayer = mLauncher.getDragLayer();
                                    dragLayer.addResizeFrame(info, hostView, cellLayout);
                                }
                            };
                            resizeRunnable = (new Runnable() {
                                public void run() {
                                    if (!isPageMoving()) {
                                        addResizeFrame.run();
                                    } else {
                                        mDelayedResizeRunnable = addResizeFrame;
                                    }
                                }
                            });
                        }
                    }

                    LauncherModel.modifyItemInDatabase(mLauncher, info, container, screenId, lp.cellX,
                            lp.cellY, item.spanX, item.spanY);
                } else {
                    // If we can't find a drop location, we return the item to its original position
                    CellLayout.LayoutParams lp = (CellLayout.LayoutParams) cell.getLayoutParams();
                    mTargetCell[0] = lp.cellX;
                    mTargetCell[1] = lp.cellY;
                    CellLayout layout = (CellLayout) cell.getParent().getParent();
                    layout.markCellsAsOccupiedForView(cell);
                }
            }

            final CellLayout parent = (CellLayout) cell.getParent().getParent();
            final Runnable finalResizeRunnable = resizeRunnable;
            // Prepare it to be animated into its new position
            // This must be called after the view has been re-parented
            final Runnable onCompleteRunnable = new Runnable() {
                @Override
                public void run() {
                    mAnimatingViewIntoPlace = false;
                    updateChildrenLayersEnabled(false);
                    if (finalResizeRunnable != null) {
                        finalResizeRunnable.run();
                    }
                    triggerStripEmptyScreens("Workspace, onDrop(), 4", true);
                }
            };
            mAnimatingViewIntoPlace = true;
            if (d.dragView.hasDrawn()) {
                final ItemInfo info = (ItemInfo) cell.getTag();
                if (info.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET) {
                    int animationType = resizeOnDrop ? ANIMATE_INTO_POSITION_AND_RESIZE :
                            ANIMATE_INTO_POSITION_AND_DISAPPEAR;
                    animateWidgetDrop(info, parent, d.dragView,
                            onCompleteRunnable, animationType, cell, false);
                } else {
                    int duration = snapScreen < 0 ? -1 : ADJACENT_SCREEN_DROP_DURATION;
                    mLauncher.getDragLayer().animateViewIntoPosition(d.dragView, cell, duration,
                            onCompleteRunnable, this);
                }
            } else {
                d.deferDragViewCleanupPostAnimation = false;
                cell.setVisibility(VISIBLE);
            }
            parent.onDropChild(cell);
        }
    }

    public void setFinalScrollForPageChange(int pageIndex) {
        CellLayout cl = (CellLayout) getChildAt(pageIndex);
        if (cl != null) {
            mSavedScrollX = getScrollX();
            mSavedTranslationX = cl.getTranslationX();
            mSavedRotationY = cl.getRotationY();
            final int newX = getScrollForPage(pageIndex);
            setScrollX(newX);
            cl.setTranslationX(0f);
            cl.setRotationY(0f);
        }
    }

    public void resetFinalScrollForPageChange(int pageIndex) {
        if (pageIndex >= 0) {
            CellLayout cl = (CellLayout) getChildAt(pageIndex);
            setScrollX(mSavedScrollX);
            cl.setTranslationX(mSavedTranslationX);
            cl.setRotationY(mSavedRotationY);
        }
    }

    public void getViewLocationRelativeToSelf(View v, int[] location) {
        getLocationInWindow(location);
        int x = location[0];
        int y = location[1];

        v.getLocationInWindow(location);
        int vX = location[0];
        int vY = location[1];

        location[0] = vX - x;
        location[1] = vY - y;
    }

    public void onDragEnter(DragObject d) {
        mDragEnforcer.onDragEnter();
        mCreateUserFolderOnDrop = false;
        mAddToExistingFolderOnDrop = false;

        mDropToLayout = null;
        CellLayout layout = getCurrentDropLayout();
        setCurrentDropLayout(layout);
        setCurrentDragOverlappingLayout(layout);

        // Because we don't have space in the Phone UI (the CellLayouts run to the edge) we
        // don't need to show the outlines
        if (LauncherAppState.getInstance().isScreenLarge()) {
            showOutlines();
        }
    }

    /** Return a rect that has the cellWidth/cellHeight (left, top), and
     * widthGap/heightGap (right, bottom) */
    static Rect getCellLayoutMetrics(Launcher launcher, int orientation) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();

        Resources res = launcher.getResources();
        Display display = launcher.getWindowManager().getDefaultDisplay();
        Point smallestSize = new Point();
        Point largestSize = new Point();
        display.getCurrentSizeRange(smallestSize, largestSize);
        int countX = (int) grid.numColumns;
        int countY = (int) grid.numRows;
        int constrainedLongEdge = largestSize.y;
        int constrainedShortEdge = smallestSize.y;
        if (orientation == CellLayout.LANDSCAPE) {
            if (mLandscapeCellLayoutMetrics == null) {
                Rect padding = grid.getWorkspacePadding(CellLayout.LANDSCAPE);
                int width = constrainedLongEdge - padding.left - padding.right;
                int height = constrainedShortEdge - padding.top - padding.bottom;
                mLandscapeCellLayoutMetrics = new Rect();
                mLandscapeCellLayoutMetrics.set(
                        grid.calculateCellWidth(width, countX),
                        grid.calculateCellHeight(height, countY), 0, 0);
            }
            return mLandscapeCellLayoutMetrics;
        } else if (orientation == CellLayout.PORTRAIT) {
            if (mPortraitCellLayoutMetrics == null) {
                Rect padding = grid.getWorkspacePadding(CellLayout.PORTRAIT);
                int width = constrainedShortEdge - padding.left - padding.right;
                int height = constrainedLongEdge - padding.top - padding.bottom;
                mPortraitCellLayoutMetrics = new Rect();
                mPortraitCellLayoutMetrics.set(
                        grid.calculateCellWidth(width, countX),
                        grid.calculateCellHeight(height, countY), 0, 0);
            }
            return mPortraitCellLayoutMetrics;
        }
        return null;
    }

    public void onDragExit(DragObject d) {
        mDragEnforcer.onDragExit();

        // Here we store the final page that will be dropped to, if the workspace in fact
        // receives the drop
        if (mInScrollArea) {
            if (isPageMoving()) {
                // If the user drops while the page is scrolling, we should use that page as the
                // destination instead of the page that is being hovered over.
                mDropToLayout = (CellLayout) getPageAt(getNextPage());
            } else {
                mDropToLayout = mDragOverlappingLayout;
            }
        } else {
            mDropToLayout = mDragTargetLayout;
        }

        if (mDragMode == DRAG_MODE_CREATE_FOLDER) {
            mCreateUserFolderOnDrop = true;
        } else if (mDragMode == DRAG_MODE_ADD_TO_FOLDER) {
            mAddToExistingFolderOnDrop = true;
        }

        // Reset the scroll area and previous drag target
        onResetScrollArea();
        setCurrentDropLayout(null);
        setCurrentDragOverlappingLayout(null);

        mSpringLoadedDragController.cancel();

        if (!mIsPageMoving) {
            hideOutlines();
        }
    }

    void setCurrentDropLayout(CellLayout layout) {
        if (mDragTargetLayout != null) {
            mDragTargetLayout.revertTempState();
            mDragTargetLayout.onDragExit();
        }
        mDragTargetLayout = layout;
        if (mDragTargetLayout != null) {
            mDragTargetLayout.onDragEnter();
        }
        cleanupReorder(true);
        cleanupFolderCreation();
        setCurrentDropOverCell(-1, -1);
    }

    void setCurrentDragOverlappingLayout(CellLayout layout) {
        if (mDragOverlappingLayout != null) {
            mDragOverlappingLayout.setIsDragOverlapping(false);
        }
        mDragOverlappingLayout = layout;
        if (mDragOverlappingLayout != null) {
            mDragOverlappingLayout.setIsDragOverlapping(true);
        }
        invalidate();
    }

    void setCurrentDropOverCell(int x, int y) {
        if (x != mDragOverX || y != mDragOverY) {
            mDragOverX = x;
            mDragOverY = y;
            setDragMode(DRAG_MODE_NONE);
        }
    }

    void setDragMode(int dragMode) {
        if (dragMode != mDragMode) {
            if (dragMode == DRAG_MODE_NONE) {
                cleanupAddToFolder();
                // We don't want to cancel the re-order alarm every time the target cell changes
                // as this feels to slow / unresponsive.
                cleanupReorder(false);
                cleanupFolderCreation();
            } else if (dragMode == DRAG_MODE_ADD_TO_FOLDER) {
                cleanupReorder(true);
                cleanupFolderCreation();
            } else if (dragMode == DRAG_MODE_CREATE_FOLDER) {
                cleanupAddToFolder();
                cleanupReorder(true);
            } else if (dragMode == DRAG_MODE_REORDER) {
                cleanupAddToFolder();
                cleanupFolderCreation();
            }
            mDragMode = dragMode;
        }
    }

    private void cleanupFolderCreation() {
        if (mDragFolderRingAnimator != null) {
            mDragFolderRingAnimator.animateToNaturalState();
            mDragFolderRingAnimator = null;
        }
        mFolderCreationAlarm.setOnAlarmListener(null);
        mFolderCreationAlarm.cancelAlarm();
    }

    private void cleanupAddToFolder() {
        if (mDragOverFolderIcon != null) {
            mDragOverFolderIcon.onDragExit(null);
            mDragOverFolderIcon = null;
        }
    }

    private void cleanupReorder(boolean cancelAlarm) {
        // Any pending reorders are canceled
        if (cancelAlarm) {
            mReorderAlarm.cancelAlarm();
        }
        mLastReorderX = -1;
        mLastReorderY = -1;
    }

   /*
    *
    * Convert the 2D coordinate xy from the parent View's coordinate space to this CellLayout's
    * coordinate space. The argument xy is modified with the return result.
    *
    * if cachedInverseMatrix is not null, this method will just use that matrix instead of
    * computing it itself; we use this to avoid redundant matrix inversions in
    * findMatchingPageForDragOver
    *
    */
   void mapPointFromSelfToChild(View v, float[] xy, Matrix cachedInverseMatrix) {
       xy[0] = xy[0] - v.getLeft();
       xy[1] = xy[1] - v.getTop();
   }

   boolean isPointInSelfOverHotseat(int x, int y, Rect r) {
       if (r == null) {
           r = new Rect();
       }
       mTempPt[0] = x;
       mTempPt[1] = y;
       mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, mTempPt, true);

       LauncherAppState app = LauncherAppState.getInstance();
       DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
       r = grid.getHotseatRect();
       if (r.contains(mTempPt[0], mTempPt[1])) {
           return true;
       }
       return false;
   }

   void mapPointFromSelfToHotseatLayout(Hotseat hotseat, float[] xy) {
       mTempPt[0] = (int) xy[0];
       mTempPt[1] = (int) xy[1];
       mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, mTempPt, true);
       mLauncher.getDragLayer().mapCoordInSelfToDescendent(hotseat.getLayout(), mTempPt);

       xy[0] = mTempPt[0];
       xy[1] = mTempPt[1];
   }

   /*
    *
    * Convert the 2D coordinate xy from this CellLayout's coordinate space to
    * the parent View's coordinate space. The argument xy is modified with the return result.
    *
    */
   void mapPointFromChildToSelf(View v, float[] xy) {
       xy[0] += v.getLeft();
       xy[1] += v.getTop();
   }

   static private float squaredDistance(float[] point1, float[] point2) {
        float distanceX = point1[0] - point2[0];
        float distanceY = point2[1] - point2[1];
        return distanceX * distanceX + distanceY * distanceY;
   }

    /*
     *
     * This method returns the CellLayout that is currently being dragged to. In order to drag
     * to a CellLayout, either the touch point must be directly over the CellLayout, or as a second
     * strategy, we see if the dragView is overlapping any CellLayout and choose the closest one
     *
     * Return null if no CellLayout is currently being dragged over
     *
     */
    private CellLayout findMatchingPageForDragOver(
            DragView dragView, float originX, float originY, boolean exact) {
        // We loop through all the screens (ie CellLayouts) and see which ones overlap
        // with the item being dragged and then choose the one that's closest to the touch point
        final int screenCount = getChildCount();
        CellLayout bestMatchingScreen = null;
        float smallestDistSoFar = Float.MAX_VALUE;

        for (int i = 0; i < screenCount; i++) {
            // The custom content screen is not a valid drag over option
            if (mScreenOrder.get(i) == CUSTOM_CONTENT_SCREEN_ID) {
                continue;
            }

            CellLayout cl = (CellLayout) getChildAt(i);

            final float[] touchXy = {originX, originY};
            // Transform the touch coordinates to the CellLayout's local coordinates
            // If the touch point is within the bounds of the cell layout, we can return immediately
            cl.getMatrix().invert(mTempInverseMatrix);
            mapPointFromSelfToChild(cl, touchXy, mTempInverseMatrix);

            if (touchXy[0] >= 0 && touchXy[0] <= cl.getWidth() &&
                    touchXy[1] >= 0 && touchXy[1] <= cl.getHeight()) {
                return cl;
            }

            if (!exact) {
                // Get the center of the cell layout in screen coordinates
                final float[] cellLayoutCenter = mTempCellLayoutCenterCoordinates;
                cellLayoutCenter[0] = cl.getWidth()/2;
                cellLayoutCenter[1] = cl.getHeight()/2;
                mapPointFromChildToSelf(cl, cellLayoutCenter);

                touchXy[0] = originX;
                touchXy[1] = originY;

                // Calculate the distance between the center of the CellLayout
                // and the touch point
                float dist = squaredDistance(touchXy, cellLayoutCenter);

                if (dist < smallestDistSoFar) {
                    smallestDistSoFar = dist;
                    bestMatchingScreen = cl;
                }
            }
        }
        return bestMatchingScreen;
    }

    // This is used to compute the visual center of the dragView. This point is then
    // used to visualize drop locations and determine where to drop an item. The idea is that
    // the visual center represents the user's interpretation of where the item is, and hence
    // is the appropriate point to use when determining drop location.
    private float[] getDragViewVisualCenter(int x, int y, int xOffset, int yOffset,
            DragView dragView, float[] recycle) {
        float res[];
        if (recycle == null) {
            res = new float[2];
        } else {
            res = recycle;
        }

        // First off, the drag view has been shifted in a way that is not represented in the
        // x and y values or the x/yOffsets. Here we account for that shift.
        x += getResources().getDimensionPixelSize(R.dimen.dragViewOffsetX);
        y += getResources().getDimensionPixelSize(R.dimen.dragViewOffsetY);

        // These represent the visual top and left of drag view if a dragRect was provided.
        // If a dragRect was not provided, then they correspond to the actual view left and
        // top, as the dragRect is in that case taken to be the entire dragView.
        // R.dimen.dragViewOffsetY.
        int left = x - xOffset;
        int top = y - yOffset;

        // In order to find the visual center, we shift by half the dragRect
        res[0] = left + dragView.getDragRegion().width() / 2;
        res[1] = top + dragView.getDragRegion().height() / 2;

        return res;
    }

    private boolean isDragWidget(DragObject d) {
        return (d.dragInfo instanceof LauncherAppWidgetInfo ||
                d.dragInfo instanceof PendingAddWidgetInfo);
    }
    private boolean isExternalDragWidget(DragObject d) {
        return d.dragSource != this && isDragWidget(d);
    }

    public void onDragOver(DragObject d) {
        // Skip drag over events while we are dragging over side pages
        if (mInScrollArea || mIsSwitchingState || mState == State.SMALL) return;

        Rect r = new Rect();
        CellLayout layout = null;
        ItemInfo item = (ItemInfo) d.dragInfo;
        if (item == null) {
            mDragController.cancelDrag();
            return;
        }

        // Ensure that we have proper spans for the item that we are dropping
        if (item.spanX < 0 || item.spanY < 0) throw new RuntimeException("Improper spans found");
        mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset,
            d.dragView, mDragViewVisualCenter);

        final View child = (mDragInfo == null) ? null : mDragInfo.cell;
        // Identify whether we have dragged over a side page
        if (isSmall()) {
            if (mLauncher.getHotseat() != null && !isExternalDragWidget(d)) {
                if (isPointInSelfOverHotseat(d.x, d.y, r)) {
                    layout = mLauncher.getHotseat().getLayout();
                }
            }
            if (layout == null) {
                layout = findMatchingPageForDragOver(d.dragView, d.x, d.y, false);
            }
            if (layout != mDragTargetLayout) {
                setCurrentDropLayout(layout);
                setCurrentDragOverlappingLayout(layout);

                boolean isInSpringLoadedMode = (mState == State.SPRING_LOADED);
                if (isInSpringLoadedMode) {
                    if (mLauncher.isHotseatLayout(layout)) {
                        mSpringLoadedDragController.cancel();
                    } else {
                        mSpringLoadedDragController.setAlarm(mDragTargetLayout);
                    }
                }
            }
        } else {
            // Test to see if we are over the hotseat otherwise just use the current page
            if (mLauncher.getHotseat() != null && !isDragWidget(d)) {
                if (isPointInSelfOverHotseat(d.x, d.y, r)) {
                    layout = mLauncher.getHotseat().getLayout();
                }
            }
            if (layout == null) {
                layout = getCurrentDropLayout();
            }
            if (layout != mDragTargetLayout) {
                setCurrentDropLayout(layout);
                setCurrentDragOverlappingLayout(layout);
            }
        }

        // Handle the drag over
        if (mDragTargetLayout != null) {
            // We want the point to be mapped to the dragTarget.
            if (mLauncher.isHotseatLayout(mDragTargetLayout)) {
                mapPointFromSelfToHotseatLayout(mLauncher.getHotseat(), mDragViewVisualCenter);
            } else {
                mapPointFromSelfToChild(mDragTargetLayout, mDragViewVisualCenter, null);
            }

            ItemInfo info = (ItemInfo) d.dragInfo;

            int minSpanX = item.spanX;
            int minSpanY = item.spanY;
            if (item.minSpanX > 0 && item.minSpanY > 0) {
                minSpanX = item.minSpanX;
                minSpanY = item.minSpanY;
            }

            mTargetCell = findNearestArea((int) mDragViewVisualCenter[0],
                    (int) mDragViewVisualCenter[1], minSpanX, minSpanY,
                    mDragTargetLayout, mTargetCell);
            int reorderX = mTargetCell[0];
            int reorderY = mTargetCell[1];

            setCurrentDropOverCell(mTargetCell[0], mTargetCell[1]);

            float targetCellDistance = mDragTargetLayout.getDistanceFromCell(
                    mDragViewVisualCenter[0], mDragViewVisualCenter[1], mTargetCell);

            final View dragOverView = mDragTargetLayout.getChildAt(mTargetCell[0],
                    mTargetCell[1]);

            manageFolderFeedback(info, mDragTargetLayout, mTargetCell,
                    targetCellDistance, dragOverView);

            boolean nearestDropOccupied = mDragTargetLayout.isNearestDropLocationOccupied((int)
                    mDragViewVisualCenter[0], (int) mDragViewVisualCenter[1], item.spanX,
                    item.spanY, child, mTargetCell);

            if (!nearestDropOccupied) {
                mDragTargetLayout.visualizeDropLocation(child, mDragOutline,
                        (int) mDragViewVisualCenter[0], (int) mDragViewVisualCenter[1],
                        mTargetCell[0], mTargetCell[1], item.spanX, item.spanY, false,
                        d.dragView.getDragVisualizeOffset(), d.dragView.getDragRegion());
            } else if ((mDragMode == DRAG_MODE_NONE || mDragMode == DRAG_MODE_REORDER)
                    && !mReorderAlarm.alarmPending() && (mLastReorderX != reorderX ||
                    mLastReorderY != reorderY)) {

                // Otherwise, if we aren't adding to or creating a folder and there's no pending
                // reorder, then we schedule a reorder
                ReorderAlarmListener listener = new ReorderAlarmListener(mDragViewVisualCenter,
                        minSpanX, minSpanY, item.spanX, item.spanY, d.dragView, child);
                mReorderAlarm.setOnAlarmListener(listener);
                mReorderAlarm.setAlarm(REORDER_TIMEOUT);
            }

            if (mDragMode == DRAG_MODE_CREATE_FOLDER || mDragMode == DRAG_MODE_ADD_TO_FOLDER ||
                    !nearestDropOccupied) {
                if (mDragTargetLayout != null) {
                    mDragTargetLayout.revertTempState();
                }
            }
        }
    }

    private void manageFolderFeedback(ItemInfo info, CellLayout targetLayout,
            int[] targetCell, float distance, View dragOverView) {
        boolean userFolderPending = willCreateUserFolder(info, targetLayout, targetCell, distance,
                false);

        if (mDragMode == DRAG_MODE_NONE && userFolderPending &&
                !mFolderCreationAlarm.alarmPending()) {
            mFolderCreationAlarm.setOnAlarmListener(new
                    FolderCreationAlarmListener(targetLayout, targetCell[0], targetCell[1]));
            mFolderCreationAlarm.setAlarm(FOLDER_CREATION_TIMEOUT);
            return;
        }

        boolean willAddToFolder =
                willAddToExistingUserFolder(info, targetLayout, targetCell, distance);

        if (willAddToFolder && mDragMode == DRAG_MODE_NONE) {
            mDragOverFolderIcon = ((FolderIcon) dragOverView);
            mDragOverFolderIcon.onDragEnter(info);
            if (targetLayout != null) {
                targetLayout.clearDragOutlines();
            }
            setDragMode(DRAG_MODE_ADD_TO_FOLDER);
            return;
        }

        if (mDragMode == DRAG_MODE_ADD_TO_FOLDER && !willAddToFolder) {
            setDragMode(DRAG_MODE_NONE);
        }
        if (mDragMode == DRAG_MODE_CREATE_FOLDER && !userFolderPending) {
            setDragMode(DRAG_MODE_NONE);
        }

        return;
    }

    class FolderCreationAlarmListener implements OnAlarmListener {
        CellLayout layout;
        int cellX;
        int cellY;

        public FolderCreationAlarmListener(CellLayout layout, int cellX, int cellY) {
            this.layout = layout;
            this.cellX = cellX;
            this.cellY = cellY;
        }

        public void onAlarm(Alarm alarm) {
            if (mDragFolderRingAnimator != null) {
                // This shouldn't happen ever, but just in case, make sure we clean up the mess.
                mDragFolderRingAnimator.animateToNaturalState();
            }
            mDragFolderRingAnimator = new FolderRingAnimator(mLauncher, null);
            mDragFolderRingAnimator.setCell(cellX, cellY);
            mDragFolderRingAnimator.setCellLayout(layout);
            mDragFolderRingAnimator.animateToAcceptState();
            layout.showFolderAccept(mDragFolderRingAnimator);
            layout.clearDragOutlines();
            setDragMode(DRAG_MODE_CREATE_FOLDER);
        }
    }

    class ReorderAlarmListener implements OnAlarmListener {
        float[] dragViewCenter;
        int minSpanX, minSpanY, spanX, spanY;
        DragView dragView;
        View child;

        public ReorderAlarmListener(float[] dragViewCenter, int minSpanX, int minSpanY, int spanX,
                int spanY, DragView dragView, View child) {
            this.dragViewCenter = dragViewCenter;
            this.minSpanX = minSpanX;
            this.minSpanY = minSpanY;
            this.spanX = spanX;
            this.spanY = spanY;
            this.child = child;
            this.dragView = dragView;
        }

        public void onAlarm(Alarm alarm) {
            int[] resultSpan = new int[2];
            mTargetCell = findNearestArea((int) mDragViewVisualCenter[0],
                    (int) mDragViewVisualCenter[1], minSpanX, minSpanY, mDragTargetLayout,
                    mTargetCell);
            mLastReorderX = mTargetCell[0];
            mLastReorderY = mTargetCell[1];

            mTargetCell = mDragTargetLayout.createArea((int) mDragViewVisualCenter[0],
                (int) mDragViewVisualCenter[1], minSpanX, minSpanY, spanX, spanY,
                child, mTargetCell, resultSpan, CellLayout.MODE_DRAG_OVER);

            if (mTargetCell[0] < 0 || mTargetCell[1] < 0) {
                mDragTargetLayout.revertTempState();
            } else {
                setDragMode(DRAG_MODE_REORDER);
            }

            boolean resize = resultSpan[0] != spanX || resultSpan[1] != spanY;
            mDragTargetLayout.visualizeDropLocation(child, mDragOutline,
                (int) mDragViewVisualCenter[0], (int) mDragViewVisualCenter[1],
                mTargetCell[0], mTargetCell[1], resultSpan[0], resultSpan[1], resize,
                dragView.getDragVisualizeOffset(), dragView.getDragRegion());
        }
    }

    @Override
    public void getHitRectRelativeToDragLayer(Rect outRect) {
        // We want the workspace to have the whole area of the display (it will find the correct
        // cell layout to drop to in the existing drag/drop logic.
        mLauncher.getDragLayer().getDescendantRectRelativeToSelf(this, outRect);
    }

    /**
     * Add the item specified by dragInfo to the given layout.
     * @return true if successful
     */
    public boolean addExternalItemToScreen(ItemInfo dragInfo, CellLayout layout) {
        if (layout.findCellForSpan(mTempEstimate, dragInfo.spanX, dragInfo.spanY)) {
            onDropExternal(dragInfo.dropPos, (ItemInfo) dragInfo, (CellLayout) layout, false);
            return true;
        }
        mLauncher.showOutOfSpaceMessage(mLauncher.isHotseatLayout(layout));
        return false;
    }

    private void onDropExternal(int[] touchXY, Object dragInfo,
            CellLayout cellLayout, boolean insertAtFirst) {
        onDropExternal(touchXY, dragInfo, cellLayout, insertAtFirst, null);
    }

    /**
     * Drop an item that didn't originate on one of the workspace screens.
     * It may have come from Launcher (e.g. from all apps or customize), or it may have
     * come from another app altogether.
     *
     * NOTE: This can also be called when we are outside of a drag event, when we want
     * to add an item to one of the workspace screens.
     */
    private void onDropExternal(final int[] touchXY, final Object dragInfo,
            final CellLayout cellLayout, boolean insertAtFirst, DragObject d) {
        final Runnable exitSpringLoadedRunnable = new Runnable() {
            @Override
            public void run() {
                mLauncher.exitSpringLoadedDragModeDelayed(true, false, null);
            }
        };

        ItemInfo info = null;
        if (dragInfo instanceof Intent) {
            // Convert Intent to ShortcutInfo via ResolveInfo and AppInfo
            Intent intent = (Intent) dragInfo;
            PackageManager pm = mLauncher.getPackageManager();
            ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
            if (resolveInfo != null) {
                // Create AppInfo using ResolveInfo
                AppInfo appInfo = new AppInfo(pm, resolveInfo, mIconCache, new HashMap<>());
                // Create ShortcutInfo from AppInfo
                ShortcutInfo shortcutInfo = new ShortcutInfo(appInfo);
                // Set the icon using IconCache
                Bitmap icon = mIconCache.getIcon(intent);
                shortcutInfo.setIcon(icon);
                info = shortcutInfo;
            } else {
                Log.e(TAG, "Could not resolve intent: " + intent);
                return;
            }
        } else if (dragInfo instanceof ItemInfo) {
            info = (ItemInfo) dragInfo;
        } else {
            Log.e(TAG, "Invalid dragInfo type: " + dragInfo.getClass().getSimpleName());
            return;
        }

        int spanX = info.spanX;
        int spanY = info.spanY;
        if (mDragInfo != null) {
            spanX = mDragInfo.spanX;
            spanY = mDragInfo.spanY;
        }

        final long container = mLauncher.isHotseatLayout(cellLayout) ?
                LauncherSettings.Favorites.CONTAINER_HOTSEAT :
                    LauncherSettings.Favorites.CONTAINER_DESKTOP;
        final long screenId = getIdForScreen(cellLayout);
        if (!mLauncher.isHotseatLayout(cellLayout)
                && screenId != getScreenIdForPageIndex(mCurrentPage)
                && mState != State.SPRING_LOADED) {
            snapToScreenId(screenId, null);
        }

        if (info instanceof PendingAddItemInfo) {
            final PendingAddItemInfo pendingInfo = (PendingAddItemInfo) dragInfo;

            boolean findNearestVacantCell = true;
            if (pendingInfo.itemType == LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT) {
                mTargetCell = findNearestArea((int) touchXY[0], (int) touchXY[1], spanX, spanY,
                        cellLayout, mTargetCell);
                float distance = cellLayout.getDistanceFromCell(mDragViewVisualCenter[0],
                        mDragViewVisualCenter[1], mTargetCell);
                if (willCreateUserFolder((ItemInfo) d.dragInfo, cellLayout, mTargetCell,
                        distance, true) || willAddToExistingUserFolder((ItemInfo) d.dragInfo,
                                cellLayout, mTargetCell, distance)) {
                    findNearestVacantCell = false;
                } else {
                    promptFolderFullIfNecessary(cellLayout, mTargetCell, pendingInfo);
                }
            }

            final ItemInfo item = (ItemInfo) d.dragInfo;
            boolean updateWidgetSize = false;
            if (findNearestVacantCell) {
                int minSpanX = item.spanX;
                int minSpanY = item.spanY;
                if (item.minSpanX > 0 && item.minSpanY > 0) {
                    minSpanX = item.minSpanX;
                    minSpanY = item.minSpanY;
                }
                int[] resultSpan = new int[2];
                mTargetCell = cellLayout.createArea((int) mDragViewVisualCenter[0],
                        (int) mDragViewVisualCenter[1], minSpanX, minSpanY, info.spanX, info.spanY,
                        null, mTargetCell, resultSpan, CellLayout.MODE_ON_DROP_EXTERNAL);

                if (resultSpan[0] != item.spanX || resultSpan[1] != item.spanY) {
                    updateWidgetSize = true;
                }
                item.spanX = resultSpan[0];
                item.spanY = resultSpan[1];
            }

            Runnable onAnimationCompleteRunnable = new Runnable() {
                @Override
                public void run() {
                    // When dragging and dropping from customization tray, we deal with creating
                    // widgets/shortcuts/folders in a slightly different way
                    switch (pendingInfo.itemType) {
                    case LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET:
                        int span[] = new int[2];
                        span[0] = item.spanX;
                        span[1] = item.spanY;
                        mLauncher.addAppWidgetFromDrop((PendingAddWidgetInfo) pendingInfo,
                                container, screenId, mTargetCell, span, null);
                        break;
                    case LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT:
                        mLauncher.processShortcutFromDrop(pendingInfo.componentName,
                                container, screenId, mTargetCell, null);
                        break;
                    default:
                        throw new IllegalStateException("Unknown item type: " +
                                pendingInfo.itemType);
                    }
                }
            };
            View finalView = pendingInfo.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET
                    ? ((PendingAddWidgetInfo) pendingInfo).boundWidget : null;

            if (finalView instanceof AppWidgetHostView && updateWidgetSize) {
                AppWidgetHostView awhv = (AppWidgetHostView) finalView;
                AppWidgetResizeFrame.updateWidgetSizeRanges(awhv, mLauncher, item.spanX,
                        item.spanY);
            }

            int animationStyle = ANIMATE_INTO_POSITION_AND_DISAPPEAR;
            if (pendingInfo.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET &&
                    ((PendingAddWidgetInfo) pendingInfo).info.configure != null) {
                animationStyle = ANIMATE_INTO_POSITION_AND_REMAIN;
            }
            animateWidgetDrop(info, cellLayout, d.dragView, onAnimationCompleteRunnable,
                    animationStyle, finalView, true);
        } else {
            // This is for other drag/drop cases, like dragging from All Apps
            View view = null;

            switch (info.itemType) {
            case LauncherSettings.Favorites.ITEM_TYPE_APPLICATION:
            case LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT:
                if (info.container == NO_ID && info instanceof AppInfo) {
                    // Came from all apps -- make a copy
                    info = new ShortcutInfo((AppInfo) info);
                }
                // Ensure we're using the converted ShortcutInfo for Intent case
                view = mLauncher.createShortcut(R.layout.application, cellLayout, (ShortcutInfo) info);
                view.setTag(info); // Explicitly set the correct tag
                break;
            case LauncherSettings.Favorites.ITEM_TYPE_FOLDER:
                view = FolderIcon.fromXml(R.layout.folder_icon, mLauncher, cellLayout,
                        (FolderInfo) info, mIconCache);
                break;
            default:
                throw new IllegalStateException("Unknown item type: " + info.itemType);
            }

            // First we find the cell nearest to point at which the item is
            // dropped, without any consideration to whether there is an item there.
            if (touchXY != null) {
                mTargetCell = findNearestArea((int) touchXY[0], (int) touchXY[1], spanX, spanY,
                        cellLayout, mTargetCell);
                float distance = cellLayout.getDistanceFromCell(mDragViewVisualCenter[0],
                        mDragViewVisualCenter[1], mTargetCell);
                d.postAnimationRunnable = exitSpringLoadedRunnable;
                if (createUserFolderIfNecessary(view, container, cellLayout, mTargetCell, distance,
                        true, d.dragView, d.postAnimationRunnable)) {
                    return;
                }
                if (addToExistingFolderIfNecessary(view, cellLayout, mTargetCell, distance, d,
                        true)) {
                    return;
                }  else {
                    promptFolderFullIfNecessary(cellLayout, mTargetCell, info);
                }
            }

            if (touchXY != null) {
                // when dragging and dropping, just find the closest free spot
                mTargetCell = cellLayout.createArea((int) mDragViewVisualCenter[0],
                        (int) mDragViewVisualCenter[1], 1, 1, 1, 1,
                        null, mTargetCell, null, CellLayout.MODE_ON_DROP_EXTERNAL);
            } else {
                cellLayout.findCellForSpan(mTargetCell, 1, 1);
            }
            addInScreen(view, container, screenId, mTargetCell[0], mTargetCell[1], info.spanX,
                    info.spanY, insertAtFirst);
            cellLayout.onDropChild(view);
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) view.getLayoutParams();
            cellLayout.getShortcutsAndWidgets().measureChild(view);

            if (info instanceof ItemInfo) {
                LauncherModel.addOrMoveItemInDatabase(mLauncher, info, container, screenId,
                        lp.cellX, lp.cellY);
            } else {
                Log.e(TAG, "Attempted to save invalid item to database: " + info.getClass());
            }

            if (d.dragView != null) {
                // We wrap the animation call in the temporary set and reset of the current
                // cellLayout to its final transform -- this means we animate the drag view to
                // the correct final location.
                setFinalTransitionTransform(cellLayout);
                mLauncher.getDragLayer().animateViewIntoPosition(d.dragView, view,
                        exitSpringLoadedRunnable);
                resetTransitionTransform(cellLayout);
            }
        }
    }

    private String resolveTitle(Intent intent) {
        PackageManager pm = mLauncher.getPackageManager();
        ActivityInfo activityInfo = intent.resolveActivityInfo(pm, 0);
        return activityInfo != null ?
                activityInfo.loadLabel(pm).toString() :
                intent.getComponent().getClassName();
    }

    public Bitmap createWidgetBitmap(ItemInfo widgetInfo, View layout) {
        int[] unScaledSize = mLauncher.getWorkspace().estimateItemSize(widgetInfo.spanX,
                widgetInfo.spanY, widgetInfo, false);
        int visibility = layout.getVisibility();
        layout.setVisibility(VISIBLE);

        int width = MeasureSpec.makeMeasureSpec(unScaledSize[0], MeasureSpec.EXACTLY);
        int height = MeasureSpec.makeMeasureSpec(unScaledSize[1], MeasureSpec.EXACTLY);
        Bitmap b = Bitmap.createBitmap(unScaledSize[0], unScaledSize[1],
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        layout.measure(width, height);
        layout.layout(0, 0, unScaledSize[0], unScaledSize[1]);
        layout.draw(c);
        c.setBitmap(null);
        layout.setVisibility(visibility);
        return b;
    }

    private void getFinalPositionForDropAnimation(int[] loc, float[] scaleXY,
            DragView dragView, CellLayout layout, ItemInfo info, int[] targetCell,
            boolean external, boolean scale) {
        // Now we animate the dragView, (ie. the widget or shortcut preview) into its final
        // location and size on the home screen.
        int spanX = info.spanX;
        int spanY = info.spanY;

        Rect r = estimateItemPosition(layout, info, targetCell[0], targetCell[1], spanX, spanY);
        loc[0] = r.left;
        loc[1] = r.top;

        setFinalTransitionTransform(layout);
        float cellLayoutScale =
                mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(layout, loc, true);
        resetTransitionTransform(layout);

        float dragViewScaleX;
        float dragViewScaleY;
        if (scale) {
            dragViewScaleX = (1.0f * r.width()) / dragView.getMeasuredWidth();
            dragViewScaleY = (1.0f * r.height()) / dragView.getMeasuredHeight();
        } else {
            dragViewScaleX = 1f;
            dragViewScaleY = 1f;
        }

        // The animation will scale the dragView about its center, so we need to center about
        // the final location.
        loc[0] -= (dragView.getMeasuredWidth() - cellLayoutScale * r.width()) / 2;
        loc[1] -= (dragView.getMeasuredHeight() - cellLayoutScale * r.height()) / 2;

        scaleXY[0] = dragViewScaleX * cellLayoutScale;
        scaleXY[1] = dragViewScaleY * cellLayoutScale;
    }

    public void animateWidgetDrop(ItemInfo info, CellLayout cellLayout, DragView dragView,
            final Runnable onCompleteRunnable, int animationType, final View finalView,
            boolean external) {

        helpers.setWidgetDropPip(true);
        //helpers.setInWidgets(false);
        mainHandler.postDelayed(()-> {
            if (!helpers.isInOverviewMode()) {
                Log.d("animateWidgetDrop", "startMapPip");
                WindowUtil.startMapPip(false);
            }
        }, 250);

        Rect from = new Rect();
        mLauncher.getDragLayer().getViewRectRelativeToSelf(dragView, from);

        int[] finalPos = new int[2];
        float scaleXY[] = new float[2];
        boolean scalePreview = !(info instanceof PendingAddShortcutInfo);
        getFinalPositionForDropAnimation(finalPos, scaleXY, dragView, cellLayout, info, mTargetCell,
                external, scalePreview);

        Resources res = mLauncher.getResources();
        int duration = res.getInteger(R.integer.config_dropAnimMaxDuration) - 200;

        // In the case where we've prebound the widget, we remove it from the DragLayer
        if (finalView instanceof AppWidgetHostView && external) {
            Log.d(TAG, "6557954 Animate widget drop, final view is appWidgetHostView");
            mLauncher.getDragLayer().removeView(finalView);
        }
        if ((animationType == ANIMATE_INTO_POSITION_AND_RESIZE || external) && finalView != null) {
            Bitmap crossFadeBitmap = createWidgetBitmap(info, finalView);
            dragView.setCrossFadeBitmap(crossFadeBitmap);
            dragView.crossFade((int) (duration * 0.8f));
        } else if (info.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET && external) {
            scaleXY[0] = scaleXY[1] = Math.min(scaleXY[0],  scaleXY[1]);
        }

        DragLayer dragLayer = mLauncher.getDragLayer();
        if (animationType == CANCEL_TWO_STAGE_WIDGET_DROP_ANIMATION) {
            mLauncher.getDragLayer().animateViewIntoPosition(dragView, finalPos, 0f, 0.1f, 0.1f,
                    DragLayer.ANIMATION_END_DISAPPEAR, onCompleteRunnable, duration);
        } else {
            int endStyle;
            if (animationType == ANIMATE_INTO_POSITION_AND_REMAIN) {
                endStyle = DragLayer.ANIMATION_END_REMAIN_VISIBLE;
            } else {
                endStyle = DragLayer.ANIMATION_END_DISAPPEAR;;
            }

            Runnable onComplete = new Runnable() {
                @Override
                public void run() {
                    if (finalView != null) {
                        finalView.setVisibility(VISIBLE);
                    }
                    if (onCompleteRunnable != null) {
                        onCompleteRunnable.run();
                    }
                }
            };
            dragLayer.animateViewIntoPosition(dragView, from.left, from.top, finalPos[0],
                    finalPos[1], 1, 1, 1, scaleXY[0], scaleXY[1], onComplete, endStyle,
                    duration, this);
        }  
    }

    public void setFinalTransitionTransform(CellLayout layout) {
        if (isSwitchingState()) {
            mCurrentScale = getScaleX();
            setScaleX(mNewScale);
            setScaleY(mNewScale);
        }
    }
    public void resetTransitionTransform(CellLayout layout) {
        if (isSwitchingState()) {
            setScaleX(mCurrentScale);
            setScaleY(mCurrentScale);
        }
    }

    /**
     * Return the current {@link CellLayout}, correctly picking the destination
     * screen while a scroll is in progress.
     */
    public CellLayout getCurrentDropLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    /**
     * Return the current CellInfo describing our current drag; this method exists
     * so that Launcher can sync this object with the correct info when the activity is created/
     * destroyed
     *
     */
    public CellLayout.CellInfo getDragInfo() {
        return mDragInfo;
    }

    public int getRestorePage() {
        return getNextPage() - numCustomPages();
    }

    /**
     * Calculate the nearest cell where the given object would be dropped.
     *
     * pixelX and pixelY should be in the coordinate system of layout
     */
    private int[] findNearestArea(int pixelX, int pixelY,
            int spanX, int spanY, CellLayout layout, int[] recycle) {
        return layout.findNearestArea(
                pixelX, pixelY, spanX, spanY, recycle);
    }

    void setup(DragController dragController) {
        mSpringLoadedDragController = new SpringLoadedDragController(mLauncher);
        mDragController = dragController;

        // hardware layers on children are enabled on startup, but should be disabled until
        // needed
        updateChildrenLayersEnabled(false);
        setWallpaperDimension();
    }

    /**
     * Called at the end of a drag which originated on the workspace.
     */
    public void onDropCompleted(final View target, final DragObject d,
            final boolean isFlingToDelete, final boolean success) {
        if (mDeferDropAfterUninstall) {
            mDeferredAction = new Runnable() {
                    public void run() {
                        onDropCompleted(target, d, isFlingToDelete, success);
                        mDeferredAction = null;
                    }
                };
            return;
        }

        boolean beingCalledAfterUninstall = mDeferredAction != null;

        if (success && !(beingCalledAfterUninstall && !mUninstallSuccessful)) {
            if (target != this && mDragInfo != null) {
                CellLayout parentCell = getParentCellLayoutForView(mDragInfo.cell);
                if (parentCell != null) {
                    parentCell.removeView(mDragInfo.cell);
                }
                if (mDragInfo.cell instanceof DropTarget) {
                    mDragController.removeDropTarget((DropTarget) mDragInfo.cell);
                }
                // If we move the item to anything not on the Workspace, check if any empty
                // screens need to be removed. If we dropped back on the workspace, this will
                // be done post drop animation.
                triggerStripEmptyScreens("Workspace, onDropCompleted()", true);
            }
        } else if (mDragInfo != null) {
            CellLayout cellLayout;
            if (mLauncher.isHotseatLayout(target)) {
                cellLayout = mLauncher.getHotseat().getLayout();
            } else {
                cellLayout = getScreenWithId(mDragInfo.screenId);
            }
            if(cellLayout != null){
                cellLayout.onDropChild(mDragInfo.cell);
            }else{
                Log.w(TAG,"onDropCompleted: but cellLayout is null!");
            }
            /* @} */
        }
        if ((d.cancelled || (beingCalledAfterUninstall && !mUninstallSuccessful))
                && mDragInfo.cell != null) {
            mDragInfo.cell.setVisibility(VISIBLE);
        }
        mDragOutline = null;

        if (mDragInfo != null && mDragInfo.cell != null) {
            mDragInfo.cell = null;
        }
        mDragInfo = null;
    }

    public void deferCompleteDropAfterUninstallActivity() {
        mDeferDropAfterUninstall = true;
    }

    /// maybe move this into a smaller part
    public void onUninstallActivityReturned(boolean success) {
        mDeferDropAfterUninstall = false;
        mUninstallSuccessful = success;
        if (mDeferredAction != null) {
            mDeferredAction.run();
        }
    }

    void updateItemLocationsInDatabase(CellLayout cl) {
        int count = cl.getShortcutsAndWidgets().getChildCount();

        long screenId = getIdForScreen(cl);
        int container = Favorites.CONTAINER_DESKTOP;

        if (mLauncher.isHotseatLayout(cl)) {
            screenId = -1;
            container = Favorites.CONTAINER_HOTSEAT;
        }

        for (int i = 0; i < count; i++) {
            View v = cl.getShortcutsAndWidgets().getChildAt(i);
            ItemInfo info = (ItemInfo) v.getTag();
            // Null check required as the AllApps button doesn't have an item info
            if (info != null && info.requiresDbUpdate) {
                info.requiresDbUpdate = false;
                LauncherModel.modifyItemInDatabase(mLauncher, info, container, screenId, info.cellX,
                        info.cellY, info.spanX, info.spanY);
            }
        }
    }

    ArrayList<ComponentName> getUniqueComponents(boolean stripDuplicates, ArrayList<ComponentName> duplicates) {
        ArrayList<ComponentName> uniqueIntents = new ArrayList<ComponentName>();
        getUniqueIntents((CellLayout) mLauncher.getHotseat().getLayout(), uniqueIntents, duplicates, false);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            getUniqueIntents(cl, uniqueIntents, duplicates, false);
        }
        return uniqueIntents;
    }

    void getUniqueIntents(CellLayout cl, ArrayList<ComponentName> uniqueIntents,
            ArrayList<ComponentName> duplicates, boolean stripDuplicates) {
        int count = cl.getShortcutsAndWidgets().getChildCount();

        ArrayList<View> children = new ArrayList<View>();
        for (int i = 0; i < count; i++) {
            View v = cl.getShortcutsAndWidgets().getChildAt(i);
            children.add(v);
        }

        for (int i = 0; i < count; i++) {
            View v = children.get(i);
            try {
                ItemInfo info = (ItemInfo) v.getTag();
                // Null check required as the AllApps button doesn't have an item info
                if (info instanceof ShortcutInfo) {
                    ShortcutInfo si = (ShortcutInfo) info;
                    ComponentName cn = si.intent.getComponent();

                    Uri dataUri = si.intent.getData();
                    // If dataUri is not null / empty or if this component isn't one that would
                    // have previously showed up in the AllApps list, then this is a widget-type
                    // shortcut, so ignore it.
                    if (dataUri != null && !dataUri.equals(Uri.EMPTY)) {
                        continue;
                    }

                    if (!uniqueIntents.contains(cn)) {
                        uniqueIntents.add(cn);
                    } else {
                        if (stripDuplicates) {
                            cl.removeViewInLayout(v);
                            LauncherModel.deleteItemFromDatabase(mLauncher, si);
                        }
                        if (duplicates != null) {
                            duplicates.add(cn);
                        }
                    }
                }
                if (v instanceof FolderIcon) {
                    FolderIcon fi = (FolderIcon) v;
                    ArrayList<View> items = fi.getFolder().getItemsInReadingOrder();
                    for (int j = 0; j < items.size(); j++) {
                        if (items.get(j).getTag() instanceof ShortcutInfo) {
                            ShortcutInfo si = (ShortcutInfo) items.get(j).getTag();
                            ComponentName cn = si.intent.getComponent();

                            Uri dataUri = si.intent.getData();
                            // If dataUri is not null / empty or if this component isn't one that would
                            // have previously showed up in the AllApps list, then this is a widget-type
                            // shortcut, so ignore it.
                            if (dataUri != null && !dataUri.equals(Uri.EMPTY)) {
                                continue;
                            }

                            if (!uniqueIntents.contains(cn)) {
                                uniqueIntents.add(cn);
                            } else {
                                if (stripDuplicates) {
                                    fi.getFolderInfo().remove(si);
                                    LauncherModel.deleteItemFromDatabase(mLauncher, si);
                                }
                                if (duplicates != null) {
                                    duplicates.add(cn);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "ItemInfo error: " + e.getMessage());
            }
        }
    }

    void saveWorkspaceToDb() {
        saveWorkspaceScreenToDb((CellLayout) mLauncher.getHotseat().getLayout());
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            saveWorkspaceScreenToDb(cl);
        }
    }

    void saveWorkspaceScreenToDb(CellLayout cl) {
        int count = cl.getShortcutsAndWidgets().getChildCount();

        long screenId = getIdForScreen(cl);
        int container = Favorites.CONTAINER_DESKTOP;

        Hotseat hotseat = mLauncher.getHotseat();
        if (mLauncher.isHotseatLayout(cl)) {
            screenId = -1;
            container = Favorites.CONTAINER_HOTSEAT;
        }

        for (int i = 0; i < count; i++) {
            View v = cl.getShortcutsAndWidgets().getChildAt(i);
            ItemInfo info = (ItemInfo) v.getTag();
            // Null check required as the AllApps button doesn't have an item info
            if (info != null) {
                int cellX = info.cellX;
                int cellY = info.cellY;
                if (container == Favorites.CONTAINER_HOTSEAT) {
                    cellX = hotseat.getCellXFromOrder((int) info.screenId);
                    cellY = hotseat.getCellYFromOrder((int) info.screenId);
                }
                LauncherModel.addItemToDatabase(mLauncher, info, container, screenId, cellX,
                        cellY, false);
            }
            if (v instanceof FolderIcon) {
                FolderIcon fi = (FolderIcon) v;
                fi.getFolder().addItemLocationsInDatabase();
            }
        }
    }

    @Override
    public boolean supportsFlingToDelete() {
        return true;
    }

    @Override
    public void onFlingToDelete(DragObject d, int x, int y, PointF vec) {
        // Do nothing
    }

    @Override
    public void onFlingToDeleteCompleted() {
        // Do nothing
    }

    public boolean isDropEnabled() {
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Launcher.setScreen(mCurrentPage);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        // We don't dispatch restoreInstanceState to our children using this code path.
        // Some pages will be restored immediately as their items are bound immediately, and
        // others we will need to wait until after their items are bound.
        mSavedStates = container;
    }

    public void restoreInstanceStateForChild(int child) {
        if (mSavedStates != null) {
            mRestoredPages.add(child);
            CellLayout cl = (CellLayout) getChildAt(child);
            cl.restoreInstanceState(mSavedStates);
        }
    }

    public void restoreInstanceStateForRemainingPages() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            if (!mRestoredPages.contains(i)) {
                restoreInstanceStateForChild(i);
            }
        }
        mRestoredPages.clear();
        mSavedStates = null;
    }

    @Override
    public void scrollLeft() {
        if (!isSmall() && !mIsSwitchingState) {
            super.scrollLeft();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    @Override
    public void scrollRight() {
        if (!isSmall() && !mIsSwitchingState) {
            super.scrollRight();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    @Override
    public boolean onEnterScrollArea(int x, int y, int direction) {
        // Ignore the scroll area if we are dragging over the hot seat
        boolean isPortrait = !LauncherAppState.isScreenLandscape(getContext());
        if (mLauncher.getHotseat() != null && isPortrait) {
            Rect r = new Rect();
            mLauncher.getHotseat().getHitRect(r);
            if (r.contains(x, y)) {
                return false;
            }
        }

        boolean result = false;
        if (!isSmall() && !mIsSwitchingState && getOpenFolder() == null) {
            mInScrollArea = true;

            final int page = getNextPage() +
                       (direction == DragController.SCROLL_LEFT ? -1 : 1);
            // We always want to exit the current layout to ensure parity of enter / exit
            setCurrentDropLayout(null);

            if (0 <= page && page < getChildCount()) {
                // Ensure that we are not dragging over to the custom content screen
                if (getScreenIdForPageIndex(page) == CUSTOM_CONTENT_SCREEN_ID) {
                    return false;
                }

                CellLayout layout = (CellLayout) getChildAt(page);
                setCurrentDragOverlappingLayout(layout);

                // Workspace is responsible for drawing the edge glow on adjacent pages,
                // so we need to redraw the workspace when this may have changed.
                invalidate();
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean onExitScrollArea() {
        boolean result = false;
        if (mInScrollArea) {
            invalidate();
            CellLayout layout = getCurrentDropLayout();
            setCurrentDropLayout(layout);
            setCurrentDragOverlappingLayout(layout);

            result = true;
            mInScrollArea = false;
        }
        return result;
    }

    private void onResetScrollArea() {
        setCurrentDragOverlappingLayout(null);
        mInScrollArea = false;
    }

    /**
     * Returns a specific CellLayout
     */
    CellLayout getParentCellLayoutForView(View v) {
        ArrayList<CellLayout> layouts = getWorkspaceAndHotseatCellLayouts();
        for (CellLayout layout : layouts) {
            if (layout.getShortcutsAndWidgets().indexOfChild(v) > -1) {
                return layout;
            }
        }
        return null;
    }

    /**
     * Returns a list of all the CellLayouts in the workspace.
     */
    ArrayList<CellLayout> getWorkspaceAndHotseatCellLayouts() {
        ArrayList<CellLayout> layouts = new ArrayList<CellLayout>();
        int screenCount = getChildCount();
        for (int screen = 0; screen < screenCount; screen++) {
            layouts.add(((CellLayout) getChildAt(screen)));
        }
        if (mLauncher.getHotseat() != null) {
            layouts.add(mLauncher.getHotseat().getLayout());
        }
        return layouts;
    }

    /**
     * We should only use this to search for specific children.  Do not use this method to modify
     * ShortcutsAndWidgetsContainer directly. Includes ShortcutAndWidgetContainers from
     * the hotseat and workspace pages
     */
    ArrayList<ShortcutAndWidgetContainer> getAllShortcutAndWidgetContainers() {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts =
                new ArrayList<ShortcutAndWidgetContainer>();
        int screenCount = getChildCount();
        for (int screen = 0; screen < screenCount; screen++) {
            childrenLayouts.add(((CellLayout) getChildAt(screen)).getShortcutsAndWidgets());
        }
        if (mLauncher.getHotseat() != null) {
            childrenLayouts.add(mLauncher.getHotseat().getLayout().getShortcutsAndWidgets());
        }
        return childrenLayouts;
    }

    public Folder getFolderForTag(Object tag) {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts =
                getAllShortcutAndWidgetContainers();
        for (ShortcutAndWidgetContainer layout: childrenLayouts) {
            int count = layout.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = layout.getChildAt(i);
                if (child instanceof Folder) {
                    Folder f = (Folder) child;
                    if (f.getInfo() == tag && f.getInfo().opened) {
                        return f;
                    }
                }
            }
        }
        return null;
    }

    public View getViewForTag(Object tag) {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts =
                getAllShortcutAndWidgetContainers();
        for (ShortcutAndWidgetContainer layout: childrenLayouts) {
            int count = layout.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = layout.getChildAt(i);
                if (child.getTag() == tag) {
                    return child;
                }
            }
        }
        return null;
    }

    void clearDropTargets() {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts =
                getAllShortcutAndWidgetContainers();
        for (ShortcutAndWidgetContainer layout: childrenLayouts) {
            int childCount = layout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                View v = layout.getChildAt(j);
                if (v instanceof DropTarget) {
                    mDragController.removeDropTarget((DropTarget) v);
                }
            }
        }
    }

    // Removes ALL items that match a given package name, this is usually called when a package
    // has been removed and we want to remove all components (widgets, shortcuts, apps) that
    // belong to that package.
    void removeItemsByPackageName(final ArrayList<String> packages) {
        final HashSet<String> packageNames = new HashSet<String>();
        packageNames.addAll(packages);

        // Filter out all the ItemInfos that this is going to affect
        final HashSet<ItemInfo> infos = new HashSet<ItemInfo>();
        final HashSet<ComponentName> cns = new HashSet<ComponentName>();
        ArrayList<CellLayout> cellLayouts = getWorkspaceAndHotseatCellLayouts();
        for (CellLayout layoutParent : cellLayouts) {
            ViewGroup layout = layoutParent.getShortcutsAndWidgets();
            int childCount = layout.getChildCount();
            for (int i = 0; i < childCount; ++i) {
                View view = layout.getChildAt(i);
                try {
                    infos.add((ItemInfo) view.getTag());
                } catch (Exception e) {
                    Log.e(TAG, "removeItemsByPackageName error: " + e.getMessage());
                }

            }
        }
        LauncherModel.ItemInfoFilter filter = new LauncherModel.ItemInfoFilter() {
            @Override
            public boolean filterItem(ItemInfo parent, ItemInfo info,
                                      ComponentName cn) {
                if (packageNames.contains(cn.getPackageName())) {
                    cns.add(cn);
                    return true;
                }
                return false;
            }
        };
        LauncherModel.filterItemInfos(infos, filter);

        // Remove the affected components
        removeItemsByComponentName(cns);
    }

    // Removes items that match the application info specified, when applications are removed
    // as a part of an update, this is called to ensure that other widgets and application
    // shortcuts are not removed.
    void removeItemsByApplicationInfo(final ArrayList<AppInfo> appInfos) {
        // Just create a hash table of all the specific components that this will affect
        HashSet<ComponentName> cns = new HashSet<ComponentName>();
        for (AppInfo info : appInfos) {
            cns.add(info.componentName);
        }

        // Remove all the things
        removeItemsByComponentName(cns);
    }

    void removeItemsByComponentName(final HashSet<ComponentName> componentNames) {
        ArrayList<CellLayout> cellLayouts = getWorkspaceAndHotseatCellLayouts();
        for (final CellLayout layoutParent: cellLayouts) {
            final ViewGroup layout = layoutParent.getShortcutsAndWidgets();

            final HashMap<ItemInfo, View> children = new HashMap<ItemInfo, View>();
            for (int j = 0; j < layout.getChildCount(); j++) {
                final View view = layout.getChildAt(j);
                try {
                    children.put((ItemInfo) view.getTag(), view);
                } catch (Exception e) {
                    Log.i(TAG, "removeItemsByComponentName error: " + e.getMessage());
                }
            }

            final ArrayList<View> childrenToRemove = new ArrayList<View>();
            final HashMap<FolderInfo, ArrayList<ShortcutInfo>> folderAppsToRemove =
                    new HashMap<FolderInfo, ArrayList<ShortcutInfo>>();
            LauncherModel.ItemInfoFilter filter = new LauncherModel.ItemInfoFilter() {
                @Override
                public boolean filterItem(ItemInfo parent, ItemInfo info,
                                          ComponentName cn) {
                    if (parent instanceof FolderInfo) {
                        if (componentNames.contains(cn)) {
                            FolderInfo folder = (FolderInfo) parent;
                            ArrayList<ShortcutInfo> appsToRemove;
                            if (folderAppsToRemove.containsKey(folder)) {
                                appsToRemove = folderAppsToRemove.get(folder);
                            } else {
                                appsToRemove = new ArrayList<ShortcutInfo>();
                                folderAppsToRemove.put(folder, appsToRemove);
                            }
                            appsToRemove.add((ShortcutInfo) info);
                            return true;
                        }
                    } else {
                        if (componentNames.contains(cn)) {
                            childrenToRemove.add(children.get(info));
                            return true;
                        }
                    }
                    return false;
                }
            };
            LauncherModel.filterItemInfos(children.keySet(), filter);

            // Remove all the apps from their folders
            for (FolderInfo folder : folderAppsToRemove.keySet()) {
                ArrayList<ShortcutInfo> appsToRemove = folderAppsToRemove.get(folder);
                for (ShortcutInfo info : appsToRemove) {
                    folder.remove(info);
                }
            }

            // Remove all the other children
            for (View child : childrenToRemove) {
                // Note: We can not remove the view directly from CellLayoutChildren as this
                // does not re-mark the spaces as unoccupied.
                layoutParent.removeViewInLayout(child);
                if (child instanceof DropTarget) {
                    mDragController.removeDropTarget((DropTarget) child);
                }
            }

            if (childrenToRemove.size() > 0) {
                layout.requestLayout();
                layout.invalidate();
            }
        }

        // Strip all the empty screens
        triggerStripEmptyScreens("Workspace, removeItemsByComponentName()", false);
    }

    void updateShortcuts(ArrayList<AppInfo> apps) {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = getAllShortcutAndWidgetContainers();
        for (ShortcutAndWidgetContainer layout: childrenLayouts) {
            int childCount = layout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                final View view = layout.getChildAt(j);
                Object tag = view.getTag();
                try {
                     if (LauncherModel.isShortcutInfoUpdateable((ItemInfo) tag)) {
                        ShortcutInfo info = (ShortcutInfo) tag;

                        final Intent intent = info.intent;
                        final ComponentName name = intent.getComponent();
                        final int appCount = apps.size();
                        for (int k = 0; k < appCount; k++) {
                            AppInfo app = apps.get(k);
                            if (app.componentName.equals(name)) {
                                BubbleTextView shortcut = (BubbleTextView) view;
                                info.updateIcon(mIconCache);
                                info.title = app.title.toString();
                                shortcut.applyFromShortcutInfo(info, mIconCache);
                            }
                        }
                    }                   
                } catch (Exception e) {
                    Log.i(TAG, "updateShortcuts error: " + e.getMessage());
                }
            }
        }
    }

    private void moveToScreen(int page, boolean animate) {
        if (!isSmall()) {
            if (animate) {
                snapToPage(page);
            } else {
                setCurrentPage(page);
            }
        }
        View child = getChildAt(page);
        if (child != null) {
            child.requestFocus();
        }
    }

    void moveToDefaultScreen(boolean animate) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        int startPage = Integer.parseInt(mPrefs.getString("start_page", "1"));
        if (getChildCount() >= startPage) {
            moveToScreen(startPage - 1, animate);
        } else {
            int index = getPageIndexForScreenId(CUSTOM_CONTENT_SCREEN_ID1);
            moveToScreen(index, animate);
        }
    }

    void moveToCustomContentScreen(boolean animate) {
        if (hasCustomContent()) {
            int ccIndex = getPageIndexForScreenId(CUSTOM_CONTENT_SCREEN_ID);
            if (animate) {
                snapToPage(ccIndex);
            } else {
                setCurrentPage(ccIndex);
            }
            View child = getChildAt(ccIndex);
            if (child != null) {
                child.requestFocus();
            }
         }
    }

    @Override
    protected PageIndicator.PageMarkerResources getPageIndicatorMarker(int pageIndex) {
        long screenId = getScreenIdForPageIndex(pageIndex);
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            int count = mScreenOrder.size() - numCustomPages();
            if (count > 1) {
                return new PageIndicator.PageMarkerResources(R.drawable.ic_pageindicator_current,
                        R.drawable.ic_pageindicator_add);
            }
        }

        return super.getPageIndicatorMarker(pageIndex);
    }

    @Override
    public void syncPages() {
    }

    @Override
    public void syncPageItems(int page, boolean immediate) {
    }

    protected String getPageIndicatorDescription() {
        String settings = getResources().getString(R.string.settings_button_text);
        return getCurrentPageDescription() + ", " + settings;
    }

    protected String getCurrentPageDescription() {
        int page = (mNextPage != INVALID_PAGE) ? mNextPage : mCurrentPage;
        int delta = numCustomPages();
        if (hasCustomContent() && getNextPage() == 0) {
            return mCustomContentDescription;
        }
        return String.format(getContext().getString(R.string.workspace_scroll_format),
                page + 1 - delta, getChildCount() - delta);
    }

    public void getLocationInDragLayer(int[] loc) {
        mLauncher.getDragLayer().getLocationInDragLayer(this, loc);
    }

    /**
     * Base on database data, if no record in table favorites that screen
     * field equals to 'screenId', and it's container field equals CONTAINER_DESKTOP(-100)
     * then, we think the 'screenId' represented workspace is empty.
     *
     * Why we should use this method? Because some time the workspace has not bind
     * any item from database, method stripEmptyScreen(...) will remove all screens
     * from workspace.
     *
     * @param screenId
     * @return true if workspace is empty, otherwise false.
     */
    public boolean isEmptyScreenBaseDB(long screenId) {
        boolean ret = true;
        /* select _id from favorites where screen=screenId and container = -100; */
        ContentResolver contentResolver = mLauncher.getContentResolver();
        Uri contentUri = LauncherSettings.Favorites.CONTENT_URI;
        Cursor c = contentResolver.query(contentUri,
                new String[] {LauncherSettings.Favorites._ID},
                String.format("%s=? and %s=?", LauncherSettings.Favorites.SCREEN, LauncherSettings.Favorites.CONTAINER),
                new String[] {String.valueOf(screenId), String.valueOf(LauncherSettings.Favorites.CONTAINER_DESKTOP)}, null);
        if (c != null) {
            ret = (c.getCount() <= 0);
            c.close();
        }
        return ret;
    }

    /**
     * This method is cloned from stripEmptyScreens, but change the condition of
     * judging a screen whether it is empty or not.
     */
    public void stripEmptyScreensBaseOnDB() {
        if (isPageMoving()) {
            mStripScreensOnPageStopMoving = true;
            return;
        }

        int currentPage = getNextPage();
        ArrayList<Long> removeScreens = new ArrayList<Long>();
        for (Long id: mWorkspaceScreens.keySet()) {
            CellLayout cl = mWorkspaceScreens.get(id);
            if (id >= 0 && isEmptyScreenBaseDB(id)) {
                removeScreens.add(id);
            } else {
                Log.v(TAG, "not empty screen base on database, ignore screen id: " + id);
            }
        }

        // We enforce at least one page to add new items to. In the case that we remove the last
        // such screen, we convert the last screen to the empty screen
        int minScreens = 1 + numCustomPages();

        int pageShift = 0;
        for (Long id: removeScreens) {
            CellLayout cl = mWorkspaceScreens.get(id);
            mWorkspaceScreens.remove(id);
            mScreenOrder.remove(id);

            if (getChildCount() > minScreens) {
                if (indexOfChild(cl) < currentPage) {
                    pageShift++;
                }
                removeView(cl);
            } else {
                // if this is the last non-custom content screen, convert it to the empty screen
                mWorkspaceScreens.put(EXTRA_EMPTY_SCREEN_ID, cl);
                mScreenOrder.add(EXTRA_EMPTY_SCREEN_ID);
            }
        }

        if (!removeScreens.isEmpty()) {
            // Update the model if we have changed any screens
            mLauncher.getModel().updateWorkspaceScreenOrder(mLauncher, mScreenOrder);
        }

        if (pageShift >= 0) {
            setCurrentPage(currentPage - pageShift);
        }
        mainHandler.postDelayed(()-> {
            if (!helpers.isInOverviewMode()) {
                Log.d("stripEmptyScreensBaseOnDB", "startMapPip");
                WindowUtil.startMapPip(false);
            }
        }, 250);
    }

    private void promptFolderFullIfNecessary(CellLayout target, int[] targetCell, ItemInfo dragInfo) {
        if (dragInfo.itemType == LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT ||
                dragInfo.itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION) {
            View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);
            if (dropOverView instanceof FolderIcon) {
                FolderIcon fi = (FolderIcon) dropOverView;
                if (fi.getFolder().isFull()) {
                    Toast.makeText(getContext(), getContext().getResources().getString(R.string.prompt_folder_full),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean isReadyForOverviewMode() {
        return getNormalChildHeight() != 0;
    }
}