package com.android.launcher66;

import static com.syu.util.WindowUtil.PIP_REMOVED;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.syu.log.LogPreview;
import com.syu.util.JLog;
import com.syu.util.WindowUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import share.ResValue;

public class Workspace extends SmoothPagedView implements DropTarget, DragSource, DragScroller, View.OnTouchListener, DragController.DragListener, LauncherTransitionable, ViewGroup.OnHierarchyChangeListener, Insettable {
    private static final int ADJACENT_SCREEN_DROP_DURATION = 300;
    private static final float ALPHA_CUTOFF_THRESHOLD = 0.01f;
    public static final int ANIMATE_INTO_POSITION_AND_DISAPPEAR = 0;
    public static final int ANIMATE_INTO_POSITION_AND_REMAIN = 1;
    public static final int ANIMATE_INTO_POSITION_AND_RESIZE = 2;
    private static final int BACKGROUND_FADE_OUT_DURATION = 350;
    public static final int CANCEL_TWO_STAGE_WIDGET_DROP_ANIMATION = 4;
    private static final int CHILDREN_OUTLINE_FADE_IN_DURATION = 100;
    private static final int CHILDREN_OUTLINE_FADE_OUT_DELAY = 0;
    private static final int CHILDREN_OUTLINE_FADE_OUT_DURATION = 375;
    public static final int COMPLETE_TWO_STAGE_WIDGET_DROP_ANIMATION = 3;
    private static final long CUSTOM_CONTENT_GESTURE_DELAY = 200;
    private static final long CUSTOM_CONTENT_SCREEN_ID = -301;
    private static final long CUSTOM_CONTENT_SCREEN_ID1 = -302;
    private static final long CUSTOM_CONTENT_SCREEN_ID2 = -303;
    private static final long CUSTOM_CONTENT_SCREEN_ID3 = -304;
    private static final long CUSTOM_CONTENT_SCREEN_ID4 = -305;
    public static final int DRAG_BITMAP_PADDING = 2;
    private static final int DRAG_MODE_ADD_TO_FOLDER = 2;
    private static final int DRAG_MODE_CREATE_FOLDER = 1;
    private static final int DRAG_MODE_NONE = 0;
    private static final int DRAG_MODE_REORDER = 3;
    private static final long EXTRA_EMPTY_SCREEN_ID = -201;
    private static final int FLING_THRESHOLD_VELOCITY = 500;
    private static final int FOLDER_CREATION_TIMEOUT = 0;
    static final float MAX_SWIPE_ANGLE = 1.0471976f;
    private static final int REORDER_TIMEOUT = 250;
    static final float START_DAMPING_TOUCH_SLOP_ANGLE = 0.5235988f;
    private static final String TAG = "JLog";
    static final float TOUCH_SLOP_DAMPING_FACTOR = 4.0f;
    private static final float WORKSPACE_OVERSCROLL_ROTATION = 24.0f;
    private static boolean sAccessibilityEnabled;
    private boolean mAddToExistingFolderOnDrop;
    boolean mAnimatingViewIntoPlace;
    private Drawable mBackground;
    private float mBackgroundAlpha;
    private ValueAnimator mBackgroundFadeInAnimation;
    private ValueAnimator mBackgroundFadeOutAnimation;
    private final Runnable mBindPages;
    private int mCameraDistance;
    boolean mChildrenLayersEnabled;
    private float mChildrenOutlineAlpha;
    private ObjectAnimator mChildrenOutlineFadeInAnimation;
    private ObjectAnimator mChildrenOutlineFadeOutAnimation;
    private boolean mCreateUserFolderOnDrop;
    private float mCurrentScale;
    Launcher.CustomContentCallbacks mCustomContentCallbacks;
    private String mCustomContentDescription;
    private long mCustomContentShowTime;
    boolean mCustomContentShowing;
    private int mDefaultPage;
    private boolean mDeferDropAfterUninstall;
    private Runnable mDeferredAction;
    private Runnable mDelayedResizeRunnable;
    private Runnable mDelayedSnapToPageRunnable;
    private Point mDisplaySize;
    private DragController mDragController;
    private DropTarget.DragEnforcer mDragEnforcer;
    private FolderIcon.FolderRingAnimator mDragFolderRingAnimator;
    private CellLayout.CellInfo mDragInfo;
    private int mDragMode;
    private Bitmap mDragOutline;
    private FolderIcon mDragOverFolderIcon;
    private int mDragOverX;
    private int mDragOverY;
    private CellLayout mDragOverlappingLayout;
    private ShortcutAndWidgetContainer mDragSourceInternal;
    private CellLayout mDragTargetLayout;
    private float[] mDragViewVisualCenter;
    boolean mDrawBackground;
    private CellLayout mDropToLayout;
    private final Alarm mFolderCreationAlarm;
    private IconCache mIconCache;
    private boolean mInScrollArea;
    boolean mIsDragOccuring;
    private boolean mIsSwitchingState;
    private int mLastChildCount;
    private float mLastCustomContentScrollProgress;
    private float mLastOverscrollPivotX;
    private int mLastReorderX;
    private int mLastReorderY;
    private Launcher mLauncher;
    private LayoutTransition mLayoutTransition;
    private float mMaxDistanceForFolderCreation;
    private float[] mNewAlphas;
    private float[] mNewBackgroundAlphas;
    private float mNewScale;
    private float[] mOldAlphas;
    private float[] mOldBackgroundAlphas;
    private int mOriginalDefaultPage;
    private HolographicOutlineHelper mOutlineHelper;
    private boolean mOverscrollTransformsSet;
    private int mOverviewModePageOffset;
    private float mOverviewModeShrinkFactor;
    private final Alarm mReorderAlarm;
    private final ArrayList<Integer> mRestoredPages;
    private float mSavedRotationY;
    private int mSavedScrollX;
    private SparseArray<Parcelable> mSavedStates;
    private float mSavedTranslationX;
    private ArrayList<Long> mScreenOrder;
    private SpringLoadedDragController mSpringLoadedDragController;
    private float mSpringLoadedShrinkFactor;
    private State mState;
    private boolean mStripScreensOnPageStopMoving;
    private int[] mTargetCell;
    private int[] mTempCell;
    private float[] mTempCellLayoutCenterCoordinates;
    private int[] mTempEstimate;
    private Matrix mTempInverseMatrix;
    private int[] mTempPt;
    private final Rect mTempRect;
    private int[] mTempVisiblePagesRange;
    private final int[] mTempXY;
    private long mTouchDownTime;
    private float mTransitionProgress;
    private boolean mUninstallSuccessful;
    private final WallpaperManager mWallpaperManager;
    WallpaperOffsetInterpolator mWallpaperOffset;
    private IBinder mWindowToken;
    private boolean mWorkspaceFadeInAdjacentScreens;
    private HashMap<Long, CellLayout> mWorkspaceScreens;
    private float mXDown;
    private float mYDown;
    private final ZoomInInterpolator mZoomInInterpolator;
    static Rect mLandscapeCellLayoutMetrics = null;
    static Rect mPortraitCellLayoutMetrics = null;
    public static MCellLayout[] customScreen = new MCellLayout[LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count)];
    public static int apps_customepage_count = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count);
    private Context mContext;
    public static TextView instantaneousConsumption;
    public static TextView drivingMileage;
    public static AbsoluteLayout absoluteLayout;

    enum State {
        NORMAL,
        SPRING_LOADED,
        SMALL,
        OVERVIEW;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public Workspace(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Workspace(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        this.mChildrenOutlineAlpha = 0.0f;
        this.mDrawBackground = true;
        this.mBackgroundAlpha = 0.0f;
        this.mTouchDownTime = -1L;
        this.mCustomContentShowTime = -1L;
        this.mWorkspaceScreens = new HashMap<>();
        this.mScreenOrder = new ArrayList<>();
        this.mTargetCell = new int[2];
        this.mDragOverX = -1;
        this.mDragOverY = -1;
        this.mLastCustomContentScrollProgress = -1.0f;
        this.mCustomContentDescription = "";
        this.mDragTargetLayout = null;
        this.mDragOverlappingLayout = null;
        this.mDropToLayout = null;
        this.mTempCell = new int[2];
        this.mTempPt = new int[2];
        this.mTempEstimate = new int[2];
        this.mDragViewVisualCenter = new float[2];
        this.mTempCellLayoutCenterCoordinates = new float[2];
        this.mTempInverseMatrix = new Matrix();
        this.mState = State.NORMAL;
        this.mIsSwitchingState = false;
        this.mAnimatingViewIntoPlace = false;
        this.mIsDragOccuring = false;
        this.mChildrenLayersEnabled = true;
        this.mStripScreensOnPageStopMoving = false;
        this.mInScrollArea = false;
        this.mDragOutline = null;
        this.mTempRect = new Rect();
        this.mTempXY = new int[2];
        this.mTempVisiblePagesRange = new int[2];
        this.mDisplaySize = new Point();
        this.mFolderCreationAlarm = new Alarm();
        this.mReorderAlarm = new Alarm();
        this.mDragFolderRingAnimator = null;
        this.mDragOverFolderIcon = null;
        this.mCreateUserFolderOnDrop = false;
        this.mAddToExistingFolderOnDrop = false;
        this.mDragMode = 0;
        this.mLastReorderX = -1;
        this.mLastReorderY = -1;
        this.mRestoredPages = new ArrayList<>();
        this.mLastChildCount = -1;
        this.mBindPages = () -> Launcher.getModel().bindRemainingSynchronousPages();
        this.mZoomInInterpolator = new ZoomInInterpolator();
        this.mContentIsRefreshable = false;
        this.mOutlineHelper = HolographicOutlineHelper.obtain(context);
        this.mDragEnforcer = new DropTarget.DragEnforcer(context);
        setDataIsReady();
        this.mLauncher = (Launcher) context;
        Resources res = getResources();
        this.mWorkspaceFadeInAdjacentScreens = res.getBoolean(R.bool.config_workspaceFadeAdjacentScreens);
        this.mFadeInAdjacentScreens = false;
        this.mWallpaperManager = WallpaperManager.getInstance(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Workspace, defStyle, 0);
        this.mSpringLoadedShrinkFactor = res.getInteger(R.integer.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        this.mOverviewModeShrinkFactor = res.getInteger(R.integer.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.mOverviewModePageOffset = res.getDimensionPixelSize(R.dimen.overview_mode_page_offset);
        this.mCameraDistance = res.getInteger(R.integer.config_cameraDistance);
        int i = a.getInt(0, 1);
        this.mDefaultPage = i;
        this.mOriginalDefaultPage = i;
        a.recycle();
        setOnHierarchyChangeListener(this);
        setHapticFeedbackEnabled(false);
        initWorkspace();
        setMotionEventSplittingEnabled(true);
        setImportantForAccessibility(1);
    }

    @Override // com.android.launcher66.Insettable
    public void setInsets(Rect insets) {
        this.mInsets.set(insets);
    }

    public int[] estimateItemSize(int hSpan, int vSpan, ItemInfo itemInfo, boolean springLoaded) {
        int[] size = new int[2];
        if (getChildCount() > 0) {
            CellLayout cl = (CellLayout) getChildAt(numCustomPages());
            Rect r = estimateItemPosition(cl, itemInfo, 0, 0, hSpan, vSpan);
            size[0] = r.width();
            size[1] = r.height();
            if (springLoaded) {
                size[0] = (int) (size[0] * this.mSpringLoadedShrinkFactor);
                size[1] = (int) (size[1] * this.mSpringLoadedShrinkFactor);
            }
        } else {
            size[0] = Integer.MAX_VALUE;
            size[1] = Integer.MAX_VALUE;
        }
        return size;
    }

    public Rect estimateItemPosition(CellLayout cl, ItemInfo pendingInfo, int hCell, int vCell, int hSpan, int vSpan) {
        Rect r = new Rect();
        cl.cellToRect(hCell, vCell, hSpan, vSpan, r);
        return r;
    }

    @Override // com.android.launcher66.DragController.DragListener
    public void onDragStart(DragSource source, Object info, int dragAction) {
        this.mIsDragOccuring = true;
        updateChildrenLayersEnabled(false);
        this.mLauncher.lockScreenOrientation();
        this.mLauncher.onInteractionBegin();
        setChildrenBackgroundAlphaMultipliers(1.0f);
        InstallShortcutReceiver.enableInstallQueue();
        UninstallShortcutReceiver.enableUninstallQueue();
        post(() -> {
            if (Workspace.this.mIsDragOccuring) {
                Workspace.this.addExtraEmptyScreenOnDrag();
            }
        });
    }

    @Override // com.android.launcher66.DragController.DragListener
    public void onDragEnd() {
        this.mIsDragOccuring = false;
        updateChildrenLayersEnabled(false);
        this.mLauncher.unlockScreenOrientation(false);
        InstallShortcutReceiver.disableAndFlushInstallQueue(getContext());
        UninstallShortcutReceiver.disableAndFlushUninstallQueue(getContext());
        removeExtraEmptyScreen();
        this.mDragSourceInternal = null;
        this.mLauncher.onInteractionEnd();
    }

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
        //setChildrenDrawnWithCacheEnabled(true);
        setMinScale(this.mOverviewModeShrinkFactor - 0.2f);
        setupLayoutTransition();
        try {
            this.mBackground = ContextCompat.getDrawable(getContext(), R.drawable.apps_customize_bg);
        } catch (Resources.NotFoundException e) {
        }
        this.mWallpaperOffset = new WallpaperOffsetInterpolator();
        Display display = this.mLauncher.getWindowManager().getDefaultDisplay();
        display.getSize(this.mDisplaySize);
        this.mMaxDistanceForFolderCreation = 0.55f * grid.iconSizePx;
        this.mFlingThresholdVelocity = (int) (500.0f * this.mDensity);
    }

    private void setupLayoutTransition() {
        this.mLayoutTransition = new LayoutTransition();
        this.mLayoutTransition.enableTransitionType(3);
        this.mLayoutTransition.enableTransitionType(1);
        this.mLayoutTransition.disableTransitionType(2);
        this.mLayoutTransition.disableTransitionType(0);
        setLayoutTransition(this.mLayoutTransition);
    }

    void enableLayoutTransitions() {
        setLayoutTransition(this.mLayoutTransition);
    }

    void disableLayoutTransitions() {
        setLayoutTransition(null);
    }

    @Override // com.android.launcher66.SmoothPagedView
    protected int getScrollMode() {
        return 1;
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View parent, View child) {
        if (!(child instanceof CellLayout)) {
            throw new IllegalArgumentException("A Workspace can only have CellLayout children.");
        }
        CellLayout cl = (CellLayout) child;
        cl.setOnInterceptTouchListener(this);
        cl.setClickable(true);
        cl.setImportantForAccessibility(2);
        super.onChildViewAdded(parent, child);
    }

    @Override // com.android.launcher66.PagedView
    protected boolean shouldDrawChild(View child) {
        CellLayout cl = (CellLayout) child;
        return super.shouldDrawChild(child) && (this.mIsSwitchingState || cl.getShortcutsAndWidgets().getAlpha() > 0.0f || cl.getBackgroundAlpha() > 0.0f);
    }

    Folder getOpenFolder() {
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        int count = dragLayer.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = dragLayer.getChildAt(i);
            if (child instanceof Folder) {
                Folder folder = (Folder) child;
                if (folder.getInfo().opened) {
                    return folder;
                }
            }
        }
        return null;
    }

    boolean isTouchActive() {
        return this.mTouchState != 0;
    }

    public void removeAllWorkspaceScreens() {
        disableLayoutTransitions();
        if (hasCustomContent()) {
            removeCustomContentPage();
        }
        removeAllViews();
        this.mScreenOrder.clear();
        this.mWorkspaceScreens.clear();
        enableLayoutTransitions();
    }

    public long insertNewWorkspaceScreenBeforeEmptyScreen(long screenId) {
        int insertIndex = this.mScreenOrder.indexOf(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
        if (insertIndex < 0) {
            insertIndex = this.mScreenOrder.size();
        }
        return insertNewWorkspaceScreen(screenId, insertIndex);
    }

    public long insertNewWorkspaceScreen(long screenId) {
        return insertNewWorkspaceScreen(screenId, getChildCount());
    }

    public long insertNewWorkspaceScreen(long screenId, int insertIndex) {
        if (!this.mWorkspaceScreens.containsKey(Long.valueOf(screenId))) {
            CellLayout newScreen = (CellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) null);
            newScreen.setOnLongClickListener(this.mLongClickListener);
            newScreen.setOnClickListener(this.mLauncher);
            newScreen.setSoundEffectsEnabled(false);
            this.mWorkspaceScreens.put(Long.valueOf(screenId), newScreen);
            this.mScreenOrder.add(insertIndex, Long.valueOf(screenId));
            addView(newScreen, insertIndex);
        }
        return screenId;
    }

    public void createUserPage() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean leftBar = prefs.getBoolean("left_bar", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (customScreen[0] == null) {
            if (userLayout) {
                if (leftBar) {
                    customScreen[0] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_custom_user_left, (ViewGroup) null);
                } else {
                    customScreen[0] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_custom_user, (ViewGroup) null);
                }
            } else {
                customScreen[0] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_custom, (ViewGroup) null);
            }
        }
        if (customScreen.length > 1 && customScreen[1] == null && ResValue.getInstance().workspace_custom1 != 0) {
            customScreen[1] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(ResValue.getInstance().workspace_custom1, (ViewGroup) null);
        }
        if (customScreen.length > 2 && customScreen[2] == null && ResValue.getInstance().workspace_custom1 != 0) {
            customScreen[2] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(ResValue.getInstance().workspace_custom2, (ViewGroup) null);
        }
        if (customScreen.length > 3 && customScreen[3] == null && ResValue.getInstance().workspace_custom1 != 0) {
            customScreen[3] = (MCellLayout) this.mLauncher.getLayoutInflater().inflate(ResValue.getInstance().workspace_custom3, (ViewGroup) null);
        }
        for (int i = 0; i < LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count); i++) {
            this.mWorkspaceScreens.put(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID1 - i), customScreen[i]);
            this.mScreenOrder.add(i, Long.valueOf(CUSTOM_CONTENT_SCREEN_ID1 - i));
            if (customScreen[i] != null) {
                ViewParent parent = customScreen[i].getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    if (userLayout) {
                        if (userStats == true)  {                          
                            Intent intent = new Intent(PIP_REMOVED);
                            LauncherApplication.sApp.sendBroadcast(intent);
                        }  
                    }
                    ((ViewGroup) parent).removeView(customScreen[i]);
                }
                addView(customScreen[i], i);
            }
        }

        if (userLayout) {
            int mapTopLeftX, mapTopLeftY, mapTopRightX, mapBottomLeftY, leftBarSize;
            int margin = Integer.parseInt(prefs.getString("layout_margin", "10"));
            boolean userDate = prefs.getBoolean("user_date", false);
            boolean userMusic = prefs.getBoolean("user_music", false);
            boolean userRadio = prefs.getBoolean("user_radio", false);
            
            int mapMinWidth = 561;
            int mapMinHeight = 284;      
            int dateMinWidth = 561;
            int dateMinHeight = 145;
            int musicMinWidth = 320;
            int musicMinHeight = 284;
            int radioMinWidth = 320;
            int radioMinHeight = 145;

            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                leftBarSize = 100;
                mapMinHeight = 284;
                musicMinHeight = 284;
            } else if (getResources().getDisplayMetrics().widthPixels == 1280
                    || getResources().getDisplayMetrics().widthPixels == 1920) {
                leftBarSize = 110;
                mapMinHeight = 340;
                musicMinHeight = 340;
            } else {
                leftBarSize = 142;
                mapMinHeight = 340;
                musicMinHeight = 340;               
            }  

            if (leftBar) {
                absoluteLayout = (AbsoluteLayout) this.findViewById(R.id.user_layout_left);
                mapTopLeftX = prefs.getInt("mapTopLeftX", margin) + leftBarSize;
                mapTopRightX = prefs.getInt("mapTopRightX", margin + mapMinWidth) + leftBarSize;
            } else {
                absoluteLayout = (AbsoluteLayout) this.findViewById(R.id.user_layout);
                mapTopLeftX = prefs.getInt("mapTopLeftX", margin);
                mapTopRightX = prefs.getInt("mapTopRightX", margin + mapMinWidth);
            }  

            mapTopLeftY = prefs.getInt("mapTopLeftY", margin + dateMinHeight + margin);
            mapBottomLeftY = prefs.getInt("mapBottomLeftY", margin + dateMinHeight + margin + mapMinHeight);
            
            int mapHeight = mapBottomLeftY - mapTopLeftY;
            int mapWidth = mapTopRightX - mapTopLeftX;

            ImageView map = new ImageView(mContext);
            map.setId(R.id.iv_map1);
            map.setBackgroundResource(R.drawable.ic_map_corner);
            map.setLayoutParams(new AbsoluteLayout.LayoutParams(mapWidth, mapHeight, mapTopLeftX, mapTopLeftY));
            absoluteLayout.addView(map); 
            if (userDate == true)  {
                int dateTopLeftX, dateTopRightX;
                if (leftBar) {
                    dateTopLeftX = prefs.getInt("dateTopLeftX", margin) + leftBarSize;
                    dateTopRightX = prefs.getInt("dateTopRightX", margin + dateMinWidth) + leftBarSize;
                } else {
                    dateTopLeftX = prefs.getInt("dateTopLeftX", margin);
                    dateTopRightX = prefs.getInt("dateTopRightX", margin + dateMinWidth);
                }
                int dateTopLeftY = prefs.getInt("dateTopLeftY", margin);
                int dateBottomLeftY = prefs.getInt("dateBottomLeftY", margin + dateMinHeight);
                
                int dateHeight = dateBottomLeftY - dateTopLeftY;
                int dateWidth = dateTopRightX - dateTopLeftX;
                
                View absoluteTime = this.mLauncher.getLayoutInflater().inflate(R.layout.absolute_time, (ViewGroup) null);
                absoluteTime.setLayoutParams(new AbsoluteLayout.LayoutParams(dateWidth, dateHeight, dateTopLeftX, dateTopLeftY)); 
                absoluteLayout.addView(absoluteTime);

            } 
            if (userMusic == true)  {
                int musicTopLeftX, musicTopRightX;
                if (leftBar) {
                    musicTopLeftX = prefs.getInt("musicTopLeftX", margin + mapMinWidth + margin) + leftBarSize;
                    musicTopRightX = prefs.getInt("musicTopRightX", margin + mapMinWidth + margin + musicMinWidth) + leftBarSize;
                } else {
                    musicTopLeftX = prefs.getInt("musicTopLeftX", margin + mapMinWidth + margin);
                    musicTopRightX = prefs.getInt("musicTopRightX", margin + mapMinWidth + margin + musicMinWidth);
                }
                int musicTopLeftY = prefs.getInt("musicTopLeftY", margin + radioMinHeight + margin);
                int musicBottomLeftY = prefs.getInt("musicBottomLeftY", margin + radioMinHeight + margin + musicMinHeight);  
                
                int musicHeight = musicBottomLeftY - musicTopLeftY; 
                int musicWidth = musicTopRightX - musicTopLeftX;
                
                View absoluteMusic = this.mLauncher.getLayoutInflater().inflate(R.layout.absolute_music, (ViewGroup) null);
                absoluteMusic.setLayoutParams(new AbsoluteLayout.LayoutParams(musicWidth, musicHeight, musicTopLeftX, musicTopLeftY)); 
                absoluteLayout.addView(absoluteMusic);
            }
            if (userRadio == true)  {
                int radioTopLeftX, radioTopRightX;
                if (leftBar) {
                    radioTopLeftX = prefs.getInt("radioTopLeftX", margin + dateMinWidth + margin) + leftBarSize;
                    radioTopRightX = prefs.getInt("radioTopRightX", margin + dateMinWidth + margin  + radioMinWidth) + leftBarSize;
                } else {
                    radioTopLeftX = prefs.getInt("radioTopLeftX", margin + dateMinWidth + margin);
                    radioTopRightX = prefs.getInt("radioTopRightX", margin + dateMinWidth + margin  + radioMinWidth);
                }
                int radioTopLeftY = prefs.getInt("radioTopLeftY", margin); 
                int radioBottomLeftY = prefs.getInt("radioBottomLeftY", margin + radioMinHeight);   
                
                int radioHeight = radioBottomLeftY - radioTopLeftY; 
                int radioWidth = radioTopRightX - radioTopLeftX; 
                
                View absoluteRadio = this.mLauncher.getLayoutInflater().inflate(R.layout.absolute_radio, (ViewGroup) null);
                absoluteRadio.setLayoutParams(new AbsoluteLayout.LayoutParams(radioWidth, radioHeight, radioTopLeftX, radioTopLeftY)); 
                absoluteLayout.addView(absoluteRadio);
            }
        }  
        this.mLauncher.launchCanbus();  
        invalidate();
    }

    public void createCustomContentPage() {
        CellLayout customScreen2 = (CellLayout) this.mLauncher.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) null);
        Log.i("hy", "createCustomContentPage");
        this.mWorkspaceScreens.put(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID), customScreen2);
        this.mScreenOrder.add(apps_customepage_count, Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
        customScreen2.setPadding(0, 0, 0, 0);
        addFullScreenPage(customScreen2);
        this.mDefaultPage = this.mOriginalDefaultPage + 1;
        this.mLauncher.updateCustomContentHintVisibility();
        if (this.mRestorePage != -1001) {
            this.mRestorePage++;
        } else {
            setCurrentPage(getCurrentPage() + 1);
        }
    }

    public void removeCustomContentPage() {
        CellLayout customScreen2 = getScreenWithId(CUSTOM_CONTENT_SCREEN_ID);
        if (customScreen2 != null) {
            this.mWorkspaceScreens.remove(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
            this.mScreenOrder.remove(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
            removeView(customScreen2);
            if (this.mCustomContentCallbacks != null) {
                this.mCustomContentCallbacks.onScrollProgressChanged(0.0f);
                this.mCustomContentCallbacks.onHide();
            }
            this.mCustomContentCallbacks = null;
            this.mDefaultPage = this.mOriginalDefaultPage - 1;
            this.mLauncher.updateCustomContentHintVisibility();
            if (this.mRestorePage != -1001) {
                this.mRestorePage--;
            } else {
                setCurrentPage(getCurrentPage() - 1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addToCustomContentPage(View view, Launcher.CustomContentCallbacks callbacks, String description) {
        if (getPageIndexForScreenId(CUSTOM_CONTENT_SCREEN_ID) < 0) {
            throw new RuntimeException("Expected custom content screen to exist");
        }
        CellLayout customScreen2 = getScreenWithId(CUSTOM_CONTENT_SCREEN_ID);
        int spanX = customScreen2.getCountX();
        int spanY = customScreen2.getCountY();
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(0, 0, spanX, spanY);
        lp.canReorder = false;
        lp.isFullscreen = true;
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(this.mInsets);
        }
        customScreen2.removeAllViews();
        customScreen2.addViewToCellLayout(view, 0, 0, lp, true);
        this.mCustomContentDescription = description;
        this.mCustomContentCallbacks = callbacks;
    }

    public void addExtraEmptyScreenOnDrag() {
        boolean lastChildOnScreen = false;
        boolean childOnFinalScreen = false;
        if (this.mDragSourceInternal != null) {
            if (this.mDragSourceInternal.getChildCount() == 1) {
                lastChildOnScreen = true;
            }
            CellLayout cl = (CellLayout) this.mDragSourceInternal.getParent();
            if (indexOfChild(cl) == getChildCount() - 1) {
                childOnFinalScreen = true;
            }
        }
        if ((!lastChildOnScreen || !childOnFinalScreen) && !this.mWorkspaceScreens.containsKey(Long.valueOf(EXTRA_EMPTY_SCREEN_ID)) && LauncherApplication.sApp.getResources().getBoolean(R.bool.page_increase)) {
            insertNewWorkspaceScreen(EXTRA_EMPTY_SCREEN_ID);
        }
    }

    public boolean addExtraEmptyScreen() {
        if (this.mWorkspaceScreens.containsKey(Long.valueOf(EXTRA_EMPTY_SCREEN_ID))) {
            return false;
        }
        insertNewWorkspaceScreen(EXTRA_EMPTY_SCREEN_ID);
        return true;
    }

    public void removeExtraEmptyScreen() {
        if (hasExtraEmptyScreen()) {
            CellLayout cl = this.mWorkspaceScreens.get(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
            this.mWorkspaceScreens.remove(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
            this.mScreenOrder.remove(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
            removeView(cl);
        }
    }

    public boolean hasExtraEmptyScreen() {
        int nScreens = getChildCount();
        return this.mWorkspaceScreens.containsKey(Long.valueOf(EXTRA_EMPTY_SCREEN_ID)) && nScreens - numCustomPages() > 1;
    }

    public long commitExtraEmptyScreen() {
        int index = getPageIndexForScreenId(EXTRA_EMPTY_SCREEN_ID);
        CellLayout cl = this.mWorkspaceScreens.get(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
        this.mWorkspaceScreens.remove(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
        this.mScreenOrder.remove(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
        long newId = LauncherAppState.getLauncherProvider().generateNewScreenId();
        this.mWorkspaceScreens.put(Long.valueOf(newId), cl);
        this.mScreenOrder.add(Long.valueOf(newId));
        if (getPageIndicator() != null) {
            getPageIndicator().updateMarker(index, getPageIndicatorMarker(index));
        }
        Launcher.getModel().updateWorkspaceScreenOrder(this.mLauncher, this.mScreenOrder);
        return newId;
    }

    public CellLayout getScreenWithId(long screenId) {
        CellLayout layout = this.mWorkspaceScreens.get(Long.valueOf(screenId));
        return layout;
    }

    public long getIdForScreen(CellLayout layout) {
        Iterator<Long> iter = this.mWorkspaceScreens.keySet().iterator();
        while (iter.hasNext()) {
            long id = iter.next().longValue();
            if (this.mWorkspaceScreens.get(Long.valueOf(id)) == layout) {
                return id;
            }
        }
        return -1L;
    }

    public int getPageIndexForScreenId(long screenId) {
        return indexOfChild(this.mWorkspaceScreens.get(Long.valueOf(screenId)));
    }

    public long getScreenIdForPageIndex(int index) {
        if (index < 0 || index >= this.mScreenOrder.size()) {
            return -1L;
        }
        return this.mScreenOrder.get(index).longValue();
    }

    ArrayList<Long> getScreenOrder() {
        return this.mScreenOrder;
    }

    public void stripEmptyScreens() {
        if (isPageMoving()) {
            this.mStripScreensOnPageStopMoving = true;
            return;
        }
        int currentPage = getNextPage();
        ArrayList<Long> removeScreens = new ArrayList<>();
        for (Long id : this.mWorkspaceScreens.keySet()) {
            CellLayout cl = this.mWorkspaceScreens.get(id);
            if (cl != null && id.longValue() >= 0 && cl.getShortcutsAndWidgets().getChildCount() == 0) {
                removeScreens.add(id);
            }
        }
        int minScreens = numCustomPages() + 1;
        int pageShift = 0;
        Iterator<Long> it = removeScreens.iterator();
        while (it.hasNext()) {
            Long id2 = it.next();
            CellLayout cl2 = this.mWorkspaceScreens.get(id2);
            this.mWorkspaceScreens.remove(id2);
            this.mScreenOrder.remove(id2);
            if (getChildCount() > minScreens) {
                if (indexOfChild(cl2) < currentPage) {
                    pageShift++;
                }
                if (cl2 != null) {
                    cl2.setBackgroundAlpha(0.0f);
                }
                removeView(cl2);
            } else {
                this.mWorkspaceScreens.put(Long.valueOf(EXTRA_EMPTY_SCREEN_ID), cl2);
                this.mScreenOrder.add(Long.valueOf(EXTRA_EMPTY_SCREEN_ID));
            }
        }
        if (!removeScreens.isEmpty()) {
            Launcher.getModel().updateWorkspaceScreenOrder(this.mLauncher, this.mScreenOrder);
        }
        if (pageShift >= 0) {
            setCurrentPage(currentPage - pageShift);
        }
    }

    void addInScreen(View child, long container, long screenId, int x, int y, int spanX, int spanY) {
        JLog.getInstance().e("addInScreen-1  screenId = " + screenId + " x = " + x + " y = " + y);
        addInScreen(child, container, screenId, x, y, spanX, spanY, false, false);
    }

    void addInScreenFromBind(View child, long container, long screenId, int x, int y, int spanX, int spanY) {
        JLog.getInstance().e("addInScreen-2  screenId = " + screenId + " x = " + x + " y = " + y);
        addInScreen(child, container, screenId, x, y, spanX, spanY, false, true);
    }

    void addInScreen(View child, long container, long screenId, int x, int y, int spanX, int spanY, boolean insert) {
        JLog.getInstance().e("addInScreen-3  screenId = " + screenId + " x = " + x + " y = " + y);
        addInScreen(child, container, screenId, x, y, spanX, spanY, insert, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void addInScreen(View view, long container, long screenId, int x, int y, int spanX, int spanY, boolean insert, boolean computeXYFromRank) {
        CellLayout.LayoutParams lp;
        if (container == -100 && getScreenWithId(screenId) == null) {
            Log.e(TAG, "Skipping child, screenId " + screenId + " not found");
            insertNewWorkspaceScreen(screenId);
        }
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }
        if (view instanceof FolderIcon) {
            ((FolderIcon) view).setTextVisible(true);
        }
        CellLayout layout = getScreenWithId(screenId);
        view.setOnKeyListener(new IconKeyEventListener());
        ViewGroup.LayoutParams genericLp = view.getLayoutParams();
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
        int childId = LauncherModel.getCellLayoutChildId(container, screenId, x, y, spanX, spanY);
        boolean markCellsAsOccupied = !(view instanceof Folder);
        if (!layout.addViewToCellLayout(view, insert ? 0 : -1, childId, lp, markCellsAsOccupied)) {
            Launcher.addDumpLog(TAG, "Failed to add to item at (" + lp.cellX + "," + lp.cellY + ") to CellLayout", true);
        }
        if (!(view instanceof Folder)) {
            view.setHapticFeedbackEnabled(false);
            view.setOnLongClickListener(this.mLongClickListener);
        }
        if (view instanceof DropTarget) {
            this.mDragController.addDropTarget((DropTarget) view);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return (isSmall() || !isFinishedSwitchingState())
                || (!isSmall() && indexOfChild(v) != mCurrentPage);
    }

    public boolean isSwitchingState() {
        return this.mIsSwitchingState;
    }

    public boolean isFinishedSwitchingState() {
        return !this.mIsSwitchingState || this.mTransitionProgress > 0.5f;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        this.mLauncher.onWindowVisibilityChanged(visibility);
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View focused, int direction) {
        if (isSmall() || !isFinishedSwitchingState()) {
            return false;
        }
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction() & 255) {
            case 0:
                this.mXDown = ev.getX();
                this.mYDown = ev.getY();
                this.mTouchDownTime = System.currentTimeMillis();
                break;
            case 1:
            case 6:
                if (this.mTouchState == 0) {
                    CellLayout currentPage = (CellLayout) getChildAt(this.mCurrentPage);
                    if (!currentPage.lastDownOnOccupiedCell()) {
                        onWallpaperTap(ev);
                        break;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    protected void reinflateWidgetsIfNecessary() {
        int clCount = getChildCount();
        for (int i = 0; i < clCount; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            ShortcutAndWidgetContainer swc = cl.getShortcutsAndWidgets();
            int itemCount = swc.getChildCount();
            for (int j = 0; j < itemCount; j++) {
                View v = swc.getChildAt(j);
                if (v.getTag() instanceof LauncherAppWidgetInfo) {
                    LauncherAppWidgetInfo info = (LauncherAppWidgetInfo) v.getTag();
                    LauncherAppWidgetHostView lahv = (LauncherAppWidgetHostView) info.hostView;
                    if (lahv != null && lahv.orientationChangedSincedInflation()) {
                        this.mLauncher.removeAppWidget(info);
                        cl.removeView(lahv);
                        this.mLauncher.bindAppWidget(info);
                    }
                }
            }
        }
    }

    @Override // com.android.launcher66.PagedView
    protected void determineScrollingStart(MotionEvent ev) {
        boolean swipeInIgnoreDirection;
        if (isFinishedSwitchingState()) {
            float deltaX = ev.getX() - this.mXDown;
            float absDeltaX = Math.abs(deltaX);
            float absDeltaY = Math.abs(ev.getY() - this.mYDown);
            if (Float.compare(absDeltaX, 0.0f) != 0) {
                float slope = absDeltaY / absDeltaX;
                float theta = (float) Math.atan(slope);
                if (absDeltaX > this.mTouchSlop || absDeltaY > this.mTouchSlop) {
                    cancelCurrentPageLongPress();
                }
                boolean passRightSwipesToCustomContent = this.mTouchDownTime - this.mCustomContentShowTime > CUSTOM_CONTENT_GESTURE_DELAY;
                if (isLayoutRtl()) {
                    swipeInIgnoreDirection = deltaX < 0.0f;
                } else {
                    swipeInIgnoreDirection = deltaX > 0.0f;
                }
                if (!(swipeInIgnoreDirection && getScreenIdForPageIndex(getCurrentPage()) == CUSTOM_CONTENT_SCREEN_ID && passRightSwipesToCustomContent) && theta <= MAX_SWIPE_ANGLE) {
                    if (theta > START_DAMPING_TOUCH_SLOP_ANGLE) {
                        float extraRatio = (float) Math.sqrt((theta - START_DAMPING_TOUCH_SLOP_ANGLE) / START_DAMPING_TOUCH_SLOP_ANGLE);
                        super.determineScrollingStart(ev, 1.0f + (TOUCH_SLOP_DAMPING_FACTOR * extraRatio));
                    } else {
                        super.determineScrollingStart(ev);
                    }
                }
            }
        }
    }

    @Override // com.android.launcher66.PagedView
    protected void onPageBeginMoving() {
        super.onPageBeginMoving();
        if (isHardwareAccelerated()) {
            updateChildrenLayersEnabled(false);
        } else if (this.mNextPage != -1) {
            enableChildrenCache(this.mCurrentPage, this.mNextPage);
        } else {
            enableChildrenCache(this.mCurrentPage - 1, this.mCurrentPage + 1);
        }
        if (LauncherAppState.getInstance().isScreenLarge()) {
            showOutlines();
        }
        if (!this.mWorkspaceFadeInAdjacentScreens) {
            for (int i = 0; i < getChildCount(); i++) {
                ((CellLayout) getPageAt(i)).setShortcutAndWidgetAlpha(1.0f);
            }
        }
    }

    @Override // com.android.launcher66.PagedView
    protected void onPageEndMoving() {
        super.onPageEndMoving();
        if (isHardwareAccelerated()) {
            updateChildrenLayersEnabled(false);
        } else {
            clearChildrenCache();
        }
        if (this.mDragController.isDragging()) {
            if (isSmall()) {
                this.mDragController.forceTouchMove();
            }
        } else if (LauncherAppState.getInstance().isScreenLarge()) {
            hideOutlines();
        }
        if (this.mDelayedResizeRunnable != null) {
            this.mDelayedResizeRunnable.run();
            this.mDelayedResizeRunnable = null;
        }
        if (this.mDelayedSnapToPageRunnable != null) {
            this.mDelayedSnapToPageRunnable.run();
            this.mDelayedSnapToPageRunnable = null;
        }
        if (this.mStripScreensOnPageStopMoving) {
            stripEmptyScreens();
            this.mStripScreensOnPageStopMoving = false;
        }
    }

    @Override // com.android.launcher66.PagedView
    protected void notifyPageSwitchListener() {
        super.notifyPageSwitchListener();
        Launcher.setScreen(this.mCurrentPage);
        if (hasCustomContent() && getNextPage() == 0 && !this.mCustomContentShowing) {
            this.mCustomContentShowing = true;
            if (this.mCustomContentCallbacks != null) {
                this.mCustomContentCallbacks.onShow();
                this.mCustomContentShowTime = System.currentTimeMillis();
                this.mLauncher.updateVoiceButtonProxyVisible(false);
            }
        } else if (hasCustomContent() && getNextPage() != 0 && this.mCustomContentShowing) {
            this.mCustomContentShowing = false;
            if (this.mCustomContentCallbacks != null) {
                this.mCustomContentCallbacks.onHide();
                this.mLauncher.resetQSBScroll();
                this.mLauncher.updateVoiceButtonProxyVisible(false);
            }
        }
        if (getPageIndicator() != null) {
            getPageIndicator().setContentDescription(getPageIndicatorDescription());
        }
    }

    protected Launcher.CustomContentCallbacks getCustomContentCallbacks() {
        return this.mCustomContentCallbacks;
    }

    protected void setWallpaperDimension() {
        String spKey = WallpaperCropActivity.getSharedPreferencesKey();
        SharedPreferences sp = this.mLauncher.getSharedPreferences(spKey, 0);
        WallpaperPickerActivity.suggestWallpaperDimension(this.mLauncher.getResources(), sp, this.mLauncher.getWindowManager(), this.mWallpaperManager);
    }

    protected void snapToPage(int whichPage, Runnable r) {
        LogPreview.show("snapToPage");
        if (this.mDelayedSnapToPageRunnable != null) {
            this.mDelayedSnapToPageRunnable.run();
        }
        this.mDelayedSnapToPageRunnable = r;
        snapToPage(whichPage, 950);
    }

    protected void snapToScreenId(long screenId, Runnable r) {
        snapToPage(getPageIndexForScreenId(screenId), r);
    }

    class WallpaperOffsetInterpolator implements Choreographer.FrameCallback {
        boolean mAnimating;
        float mAnimationStartOffset;
        long mAnimationStartTime;
        int mNumScreens;
        boolean mWaitingForUpdate;
        float mFinalOffset = 0.0f;
        float mCurrentOffset = 0.5f;
        private final int ANIMATION_DURATION = 250;
        private final int MIN_PARALLAX_PAGE_SPAN = 3;
        Choreographer mChoreographer = Choreographer.getInstance();
        Interpolator mInterpolator = new DecelerateInterpolator(1.5f);

        public WallpaperOffsetInterpolator() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            updateOffset(false);
        }

        private void updateOffset(boolean force) {
            if (this.mWaitingForUpdate || force) {
                this.mWaitingForUpdate = false;
                if (computeScrollOffset() && Workspace.this.mWindowToken != null) {
                    try {
                        Workspace.this.mWallpaperManager.setWallpaperOffsets(Workspace.this.mWindowToken, Workspace.this.mWallpaperOffset.getCurrX(), 0.5f);
                        setWallpaperOffsetSteps();
                    } catch (IllegalArgumentException e) {
                        Log.e(Workspace.TAG, "Error updating wallpaper offset: " + e);
                    }
                }
            }
        }

        public boolean computeScrollOffset() {
            float oldOffset = this.mCurrentOffset;
            if (this.mAnimating) {
                long durationSinceAnimation = System.currentTimeMillis() - this.mAnimationStartTime;
                float t0 = ((float) durationSinceAnimation) / 250.0f;
                float t1 = this.mInterpolator.getInterpolation(t0);
                this.mCurrentOffset = this.mAnimationStartOffset + ((this.mFinalOffset - this.mAnimationStartOffset) * t1);
                this.mAnimating = durationSinceAnimation < 250;
            } else {
                this.mCurrentOffset = this.mFinalOffset;
            }
            if (Math.abs(this.mCurrentOffset - this.mFinalOffset) > 1.0E-7f) {
                scheduleUpdate();
            }
            return Math.abs(oldOffset - this.mCurrentOffset) > 1.0E-7f;
        }

        private float wallpaperOffsetForCurrentScroll() {
            if (Workspace.this.getChildCount() <= 1) {
                return 0.0f;
            }
            int emptyExtraPages = numEmptyScreensToIgnore();
            int firstIndex = Workspace.this.numCustomPages();
            int lastIndex = (Workspace.this.getChildCount() - 1) - emptyExtraPages;
            if (Workspace.this.isLayoutRtl()) {
                firstIndex = lastIndex;
                lastIndex = firstIndex;
            }
            int firstPageScrollX = Workspace.this.getScrollForPage(firstIndex);
            int scrollRange = Workspace.this.getScrollForPage(lastIndex) - firstPageScrollX;
            if (scrollRange == 0) {
                return 0.0f;
            }
            int offsetForLayoutTransitionAnimation = Workspace.this.isLayoutRtl() ? Workspace.this.getPageAt(Workspace.this.getChildCount() - 1).getLeft() - Workspace.this.getFirstChildLeft() : 0;
            int adjustedScroll = (Workspace.this.getScrollX() - firstPageScrollX) - offsetForLayoutTransitionAnimation;
            float offset = Math.min(1.0f, adjustedScroll / scrollRange);
            float offset2 = Math.max(0.0f, offset);
            int numScrollingPages = getNumScreensExcludingEmptyAndCustom();
            int parallaxPageSpan = Math.max(3, numScrollingPages - 1);
            int padding = Workspace.this.isLayoutRtl() ? (parallaxPageSpan - numScrollingPages) + 1 : 0;
            return (((padding + numScrollingPages) - 1) * offset2) / parallaxPageSpan;
        }

        private int numEmptyScreensToIgnore() {
            int numScrollingPages = Workspace.this.getChildCount() - Workspace.this.numCustomPages();
            return (numScrollingPages < 3 || !Workspace.this.hasExtraEmptyScreen()) ? 0 : 1;
        }

        private int getNumScreensExcludingEmptyAndCustom() {
            int numScrollingPages = (Workspace.this.getChildCount() - numEmptyScreensToIgnore()) - Workspace.this.numCustomPages();
            return numScrollingPages;
        }

        public void syncWithScroll() {
            float offset = wallpaperOffsetForCurrentScroll();
            Workspace.this.mWallpaperOffset.setFinalX(offset);
            updateOffset(true);
        }

        public float getCurrX() {
            return this.mCurrentOffset;
        }

        public float getFinalX() {
            return this.mFinalOffset;
        }

        private void animateToFinal() {
            this.mAnimating = true;
            this.mAnimationStartOffset = this.mCurrentOffset;
            this.mAnimationStartTime = System.currentTimeMillis();
        }

        private void setWallpaperOffsetSteps() {
            Workspace.this.mWallpaperManager.setWallpaperOffsetSteps(1.0f / (Workspace.this.getChildCount() - 1), 1.0f);
        }

        public void setFinalX(float x) {
            scheduleUpdate();
            this.mFinalOffset = Math.max(0.0f, Math.min(x, 1.0f));
            if (getNumScreensExcludingEmptyAndCustom() != this.mNumScreens) {
                if (this.mNumScreens > 0) {
                    animateToFinal();
                }
                this.mNumScreens = getNumScreensExcludingEmptyAndCustom();
            }
        }

        private void scheduleUpdate() {
            if (!this.mWaitingForUpdate) {
                this.mChoreographer.postFrameCallback(this);
                this.mWaitingForUpdate = true;
            }
        }

        public void jumpToFinal() {
            this.mCurrentOffset = this.mFinalOffset;
        }
    }

    @Override // com.android.launcher66.SmoothPagedView, com.android.launcher66.PagedView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.mWallpaperOffset.syncWithScroll();
    }

    void showOutlines() {
        if (!isSmall() && !this.mIsSwitchingState) {
            if (this.mChildrenOutlineFadeOutAnimation != null) {
                this.mChildrenOutlineFadeOutAnimation.cancel();
            }
            if (this.mChildrenOutlineFadeInAnimation != null) {
                this.mChildrenOutlineFadeInAnimation.cancel();
            }
            this.mChildrenOutlineFadeInAnimation = LauncherAnimUtils.ofFloat(this, "childrenOutlineAlpha", 1.0f);
            this.mChildrenOutlineFadeInAnimation.setDuration(100L);
            this.mChildrenOutlineFadeInAnimation.start();
        }
    }

    void hideOutlines() {
        if (!isSmall() && !this.mIsSwitchingState) {
            if (this.mChildrenOutlineFadeInAnimation != null) {
                this.mChildrenOutlineFadeInAnimation.cancel();
            }
            if (this.mChildrenOutlineFadeOutAnimation != null) {
                this.mChildrenOutlineFadeOutAnimation.cancel();
            }
            this.mChildrenOutlineFadeOutAnimation = LauncherAnimUtils.ofFloat(this, "childrenOutlineAlpha", 0.0f);
            this.mChildrenOutlineFadeOutAnimation.setDuration(375L);
            this.mChildrenOutlineFadeOutAnimation.setStartDelay(0L);
            this.mChildrenOutlineFadeOutAnimation.start();
        }
    }

    public void showOutlinesTemporarily() {
        if (!this.mIsPageMoving && !isTouchActive()) {
            snapToPage(this.mCurrentPage);
        }
    }

    public void setChildrenOutlineAlpha(float alpha) {
        this.mChildrenOutlineAlpha = alpha;
        for (int i = 0; i < getChildCount(); i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            cl.setBackgroundAlpha(alpha);
        }
    }

    public float getChildrenOutlineAlpha() {
        return this.mChildrenOutlineAlpha;
    }

    void disableBackground() {
        this.mDrawBackground = false;
    }

    void enableBackground() {
        this.mDrawBackground = true;
    }

    private void animateBackgroundGradient(float finalAlpha, boolean animated) {
        if (this.mBackground != null) {
            if (this.mBackgroundFadeInAnimation != null) {
                this.mBackgroundFadeInAnimation.cancel();
                this.mBackgroundFadeInAnimation = null;
            }
            if (this.mBackgroundFadeOutAnimation != null) {
                this.mBackgroundFadeOutAnimation.cancel();
                this.mBackgroundFadeOutAnimation = null;
            }
            float startAlpha = getBackgroundAlpha();
            if (finalAlpha != startAlpha) {
                if (animated) {
                    this.mBackgroundFadeOutAnimation = LauncherAnimUtils.ofFloat(this, startAlpha, finalAlpha);
                    this.mBackgroundFadeOutAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.Workspace.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Workspace.this.setBackgroundAlpha(((Float) animation.getAnimatedValue()).floatValue());
                        }
                    });
                    this.mBackgroundFadeOutAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
                    this.mBackgroundFadeOutAnimation.setDuration(350L);
                    this.mBackgroundFadeOutAnimation.start();
                    return;
                }
                setBackgroundAlpha(finalAlpha);
            }
        }
    }

    public void setBackgroundAlpha(float alpha) {
        if (alpha != this.mBackgroundAlpha) {
            this.mBackgroundAlpha = alpha;
            invalidate();
        }
    }

    public float getBackgroundAlpha() {
        return this.mBackgroundAlpha;
    }

    float backgroundAlphaInterpolator(float r) {
        if (r < 0.1f) {
            return 0.0f;
        }
        if (r <= 0.4f) {
            return (r - 0.1f) / (0.4f - 0.1f);
        }
        return 1.0f;
    }

    private void updatePageAlphaValues(int screenCenter) {
        boolean isInOverscroll = this.mOverScrollX < 0 || this.mOverScrollX > this.mMaxScrollX;
        if (this.mWorkspaceFadeInAdjacentScreens && this.mState == State.NORMAL && !this.mIsSwitchingState && !isInOverscroll) {
            for (int i = 0; i < getChildCount(); i++) {
                CellLayout child = (CellLayout) getChildAt(i);
                if (child != null) {
                    float scrollProgress = getScrollProgress(screenCenter, child, i);
                    float alpha = 1.0f - Math.abs(scrollProgress);
                    child.getShortcutsAndWidgets().setAlpha(alpha);
                    if (!this.mIsDragOccuring) {
                        child.setBackgroundAlphaMultiplier(backgroundAlphaInterpolator(Math.abs(scrollProgress)));
                    } else {
                        child.setBackgroundAlphaMultiplier(1.0f);
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
        return this.mScreenOrder.size() > apps_customepage_count + 1 && this.mScreenOrder.get(apps_customepage_count).longValue() == CUSTOM_CONTENT_SCREEN_ID;
    }

    public boolean hasMyCustomContent() {
        return this.mScreenOrder.size() > LauncherApplication.sApp.getResources().getInteger(R.integer.apps_customepage_count) + (-1) && this.mScreenOrder.get(0).longValue() == CUSTOM_CONTENT_SCREEN_ID1;
    }

    public int numCustomPages() {
        if (hasCustomContent()) {
            return apps_customepage_count + 1;
        }
        return 0;
    }

    public boolean isOnOrMovingToCustomContent() {
        return hasCustomContent() && getNextPage() == 0;
    }

    private void updateStateForCustomContent(int screenCenter) {
        float translationX = 0.0f;
        float progress = 0.0f;
        if (hasCustomContent()) {
            int index = this.mScreenOrder.indexOf(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
            int scrollDelta = (getScrollX() - getScrollForPage(index)) - getLayoutTransitionOffsetForPage(index);
            float scrollRange = getScrollForPage(index + 1) - getScrollForPage(index);
            float translationX2 = scrollRange - scrollDelta;
            float progress2 = (scrollRange - scrollDelta) / scrollRange;
            if (isLayoutRtl()) {
                translationX = Math.min(0.0f, translationX2);
            } else {
                translationX = Math.max(0.0f, translationX2);
            }
            progress = Math.max(0.0f, progress2);
        }
        if (Float.compare(progress, this.mLastCustomContentScrollProgress) != 0) {
            CellLayout cc = this.mWorkspaceScreens.get(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
            if (cc != null && progress > 0.0f && cc.getVisibility() != View.VISIBLE && !isSmall()) {
                cc.setVisibility(View.VISIBLE);
            }
            this.mLastCustomContentScrollProgress = progress;
            setBackgroundAlpha(0.8f * progress);
            if (this.mLauncher.getHotseat() != null) {
                this.mLauncher.getHotseat().setTranslationX(translationX);
            }
            if (getPageIndicator() != null) {
                getPageIndicator().setTranslationX(translationX);
            }
            if (this.mCustomContentCallbacks != null) {
                this.mCustomContentCallbacks.onScrollProgressChanged(progress);
            }
        }
    }

    @Override // com.android.launcher66.PagedView
    protected View.OnClickListener getPageIndicatorClickListener() {
        AccessibilityManager am = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (!am.isTouchExplorationEnabled()) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.android.launcher66.Workspace.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Workspace.this.enterOverviewMode();
            }
        };
    }

    @Override // com.android.launcher66.PagedView
    protected void screenScrolled(int screenCenter) {
        boolean isRtl = isLayoutRtl();
        super.screenScrolled(screenCenter);
        updatePageAlphaValues(screenCenter);
        updateStateForCustomContent(screenCenter);
        enableHwLayersOnVisiblePages();
        boolean shouldOverScroll = (this.mOverScrollX < 0 && (!hasCustomContent() || isLayoutRtl())) || (this.mOverScrollX > this.mMaxScrollX && !(hasCustomContent() && isLayoutRtl()));
        if (shouldOverScroll) {
            int upperIndex = getChildCount() - 1;
            boolean isLeftPage = this.mOverScrollX < 0;
            int index = ((isRtl || !isLeftPage) && (!isRtl || isLeftPage)) ? upperIndex : 0;
            float pivotX = isLeftPage ? 0.75f : 0.25f;
            CellLayout cl = (CellLayout) getChildAt(index);
            float scrollProgress = getScrollProgress(screenCenter, cl, index);
            cl.setOverScrollAmount(Math.abs(scrollProgress), isLeftPage);
            float f = (-24.0f) * scrollProgress;
            if (!this.mOverscrollTransformsSet || Float.compare(this.mLastOverscrollPivotX, pivotX) != 0) {
                this.mOverscrollTransformsSet = true;
                this.mLastOverscrollPivotX = pivotX;
                cl.setCameraDistance(this.mDensity * this.mCameraDistance);
                cl.setPivotX(cl.getMeasuredWidth() * pivotX);
                cl.setPivotY(cl.getMeasuredHeight() * 0.5f);
                cl.setOverscrollTransformsDirty(true);
                return;
            }
            return;
        }
        if (this.mOverscrollTransformsSet) {
            this.mOverscrollTransformsSet = false;
            ((CellLayout) getChildAt(apps_customepage_count - 1)).resetOverscrollTransforms();
            ((CellLayout) getChildAt(getChildCount() - 1)).resetOverscrollTransforms();
        }
    }

    @Override // com.android.launcher66.PagedView
    protected void overScroll(float amount) {
        acceleratedOverScroll(amount);
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mWindowToken = getWindowToken();
        computeScroll();
        this.mDragController.setWindowToken(this.mWindowToken);
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mWindowToken = null;
    }

    protected void onResume() {
        View.OnClickListener listener;
        if (getPageIndicator() != null && (listener = getPageIndicatorClickListener()) != null) {
            getPageIndicator().setOnClickListener(listener);
        }
        AccessibilityManager am = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        sAccessibilityEnabled = am.isEnabled();
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mFirstLayout && this.mCurrentPage >= 0 && this.mCurrentPage < getChildCount()) {
            this.mWallpaperOffset.syncWithScroll();
            this.mWallpaperOffset.jumpToFinal();
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBackground != null && this.mBackgroundAlpha > 0.0f && this.mDrawBackground) {
            int alpha = (int) (this.mBackgroundAlpha * 255.0f);
            this.mBackground.setAlpha(alpha);
            this.mBackground.setBounds(getScrollX(), 0, getScrollX() + getMeasuredWidth(), getMeasuredHeight());
            this.mBackground.draw(canvas);
        }
        super.onDraw(canvas);
        post(this.mBindPages);
    }

    boolean isDrawingBackgroundGradient() {
        return this.mBackground != null && this.mBackgroundAlpha > 0.0f && this.mDrawBackground;
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        if (!this.mLauncher.isAllAppsVisible()) {
            Folder openFolder = getOpenFolder();
            if (openFolder != null) {
                return openFolder.requestFocus(direction, previouslyFocusedRect);
            }
            return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (isSmall()) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        if (!this.mLauncher.isAllAppsVisible()) {
            Folder openFolder = getOpenFolder();
            if (openFolder != null) {
                openFolder.addFocusables(views, direction);
            } else {
                super.addFocusables(views, direction, focusableMode);
            }
        }
    }

    public boolean isSmall() {
        return this.mState == State.SMALL || this.mState == State.SPRING_LOADED || this.mState == State.OVERVIEW;
    }

    void enableChildrenCache(int fromPage, int toPage) {
        if (fromPage > toPage) {
            fromPage = toPage;
            toPage = fromPage;
        }
        int screenCount = getChildCount();
        int fromPage2 = Math.max(fromPage, 0);
        int toPage2 = Math.min(toPage, screenCount - 1);
        for (int i = fromPage2; i <= toPage2; i++) {
            CellLayout layout = (CellLayout) getChildAt(i);
            layout.setChildrenDrawnWithCacheEnabled(true);
            layout.setChildrenDrawingCacheEnabled(true);
        }
    }

    void clearChildrenCache() {
        int screenCount = getChildCount();
        for (int i = 0; i < screenCount; i++) {
            CellLayout layout = (CellLayout) getChildAt(i);
            layout.setChildrenDrawnWithCacheEnabled(false);
            if (!isHardwareAccelerated()) {
                layout.setChildrenDrawingCacheEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChildrenLayersEnabled(boolean force) {
        boolean enableChildrenLayers = true;
        boolean small = this.mState == State.SMALL || this.mState == State.OVERVIEW || this.mIsSwitchingState;
        if (!force && !small && !this.mAnimatingViewIntoPlace && !isPageMoving()) {
            enableChildrenLayers = false;
        }
        if (enableChildrenLayers != this.mChildrenLayersEnabled) {
            this.mChildrenLayersEnabled = enableChildrenLayers;
            if (this.mChildrenLayersEnabled) {
                enableHwLayersOnVisiblePages();
                return;
            }
            for (int i = 0; i < getPageCount(); i++) {
                CellLayout cl = (CellLayout) getChildAt(i);
                cl.enableHardwareLayer(false);
            }
        }
    }

    private void enableHwLayersOnVisiblePages() {
        if (this.mChildrenLayersEnabled) {
            int screenCount = getChildCount();
            getVisiblePages(this.mTempVisiblePagesRange);
            int leftScreen = this.mTempVisiblePagesRange[0];
            int rightScreen = this.mTempVisiblePagesRange[1];
            if (leftScreen == rightScreen) {
                if (rightScreen < screenCount - 1) {
                    rightScreen++;
                } else if (leftScreen > 0) {
                    leftScreen--;
                }
            }
            CellLayout customScreen2 = this.mWorkspaceScreens.get(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID));
            int i = 0;
            while (i < screenCount) {
                CellLayout layout = (CellLayout) getPageAt(i);
                boolean enableLayer = layout != customScreen2 && leftScreen <= i && i <= rightScreen && shouldDrawChild(layout);
                layout.enableHardwareLayer(enableLayer);
                i++;
            }
        }
    }

    public void buildPageHardwareLayers() {
        updateChildrenLayersEnabled(true);
        if (getWindowToken() != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                CellLayout cl = (CellLayout) getChildAt(i);
                cl.buildHardwareLayer();
            }
        }
        updateChildrenLayersEnabled(false);
    }

    protected void onWallpaperTap(MotionEvent ev) {
        int[] position = this.mTempCell;
        getLocationOnScreen(position);
        int pointerIndex = ev.getActionIndex();
        position[0] = position[0] + ((int) ev.getX(pointerIndex));
        position[1] = position[1] + ((int) ev.getY(pointerIndex));
        this.mWallpaperManager.sendWallpaperCommand(getWindowToken(), ev.getAction() == 1 ? "android.wallpaper.tap" : "android.wallpaper.secondaryTap", position[0], position[1], 0, null);
    }

    static class ZInterpolator implements TimeInterpolator {
        private float focalLength;

        public ZInterpolator(float foc) {
            this.focalLength = foc;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return (1.0f - (this.focalLength / (this.focalLength + input))) / (1.0f - (this.focalLength / (this.focalLength + 1.0f)));
        }
    }

    static class InverseZInterpolator implements TimeInterpolator {
        private ZInterpolator zInterpolator;

        public InverseZInterpolator(float foc) {
            this.zInterpolator = new ZInterpolator(foc);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return 1.0f - this.zInterpolator.getInterpolation(1.0f - input);
        }
    }

    static class ZoomOutInterpolator implements TimeInterpolator {
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(0.75f);
        private final ZInterpolator zInterpolator = new ZInterpolator(0.13f);

        ZoomOutInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return this.decelerate.getInterpolation(this.zInterpolator.getInterpolation(input));
        }
    }

    static class ZoomInInterpolator implements TimeInterpolator {
        private final InverseZInterpolator inverseZInterpolator = new InverseZInterpolator(0.35f);
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(3.0f);

        ZoomInInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return this.decelerate.getInterpolation(this.inverseZInterpolator.getInterpolation(input));
        }
    }

    public void onDragStartedWithItem(View v) {
        Canvas canvas = new Canvas();
        this.mDragOutline = createDragOutline(v, canvas, 2);
    }

    public void onDragStartedWithItem(PendingAddItemInfo info, Bitmap b, boolean clipAlpha) {
        Canvas canvas = new Canvas();
        int[] size = estimateItemSize(info.spanX, info.spanY, info, false);
        this.mDragOutline = createDragOutline(b, canvas, 2, size[0], size[1], clipAlpha);
    }

    public void exitWidgetResizeMode() {
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        dragLayer.clearAllResizeFrames();
    }

    private void initAnimationArrays() {
        int childCount = getChildCount();
        if (this.mLastChildCount != childCount) {
            this.mOldBackgroundAlphas = new float[childCount];
            this.mOldAlphas = new float[childCount];
            this.mNewBackgroundAlphas = new float[childCount];
            this.mNewAlphas = new float[childCount];
        }
    }

    Animator getChangeStateAnimation(State state, boolean animated) {
        return getChangeStateAnimation(state, animated, 0, -1);
    }

    @Override // com.android.launcher66.PagedView
    protected void getOverviewModePages(int[] range) {
        int start = numCustomPages();
        int end = getChildCount() - 1;
        range[0] = Math.max(0, Math.min(start, getChildCount() - 1));
        range[1] = Math.max(0, end);
    }

    @Override // com.android.launcher66.PagedView
    protected void onStartReordering() {
        super.onStartReordering();
        showOutlines();
        disableLayoutTransitions();
    }

    @Override // com.android.launcher66.PagedView
    protected void onEndReordering() {
        super.onEndReordering();
        hideOutlines();
        this.mScreenOrder.clear();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            this.mScreenOrder.add(Long.valueOf(getIdForScreen(cl)));
        }
        Launcher.getModel().updateWorkspaceScreenOrder(this.mLauncher, this.mScreenOrder);
        enableLayoutTransitions();
    }

    public boolean isInOverviewMode() {
        return this.mState == State.OVERVIEW;
    }

    public boolean enterOverviewMode() {
        if (this.mTouchState != 0) {
            return false;
        }
        if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.wallpaper_show)) {
            return true;
        }
        WindowUtil.removePip(null);
        enableOverviewMode(true, -1, true);
        return true;
    }

    public void exitOverviewMode(boolean animated) {
        exitOverviewMode(-1, animated);
    }

    public void exitOverviewMode(int snapPage, boolean animated) {
        WindowUtil.startMapPip(null, false);
        enableOverviewMode(false, snapPage, animated);
    }

    private void enableOverviewMode(boolean enable, int snapPage, boolean animated) {
        this.mLauncher.setButtonVisible(true);
        State finalState = State.OVERVIEW;
        if (!enable) {
            finalState = State.NORMAL;
        }
        Animator workspaceAnim = getChangeStateAnimation(finalState, animated, 0, snapPage);
        if (workspaceAnim != null) {
            onTransitionPrepare();
            workspaceAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Workspace.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator arg0) {
                    Workspace.this.onTransitionEnd();
                }
            });
            workspaceAnim.start();
        }
    }

    int getOverviewModeTranslationY() {
        int childHeight = getNormalChildHeight();
        int viewPortHeight = getViewportHeight();
        int scaledChildHeight = (int) (this.mOverviewModeShrinkFactor * childHeight);
        int offset = (viewPortHeight - scaledChildHeight) / 2;
        int offsetDelta = this.mOverviewModePageOffset - (offset / 4);
        return offsetDelta;
    }

    boolean shouldVoiceButtonProxyBeVisible() {
        return !isOnOrMovingToCustomContent() && this.mState == State.NORMAL;
    }

    public void updateInteractionForState() {
        if (this.mState != State.NORMAL) {
            this.mLauncher.onInteractionBegin();
        } else {
            this.mLauncher.onInteractionEnd();
        }
    }

    private void setState(State state) {
        this.mState = state;
        updateInteractionForState();
        updateAccessibilityFlags();
    }

    private void updateAccessibilityFlags() {
        int accessible = this.mState == State.NORMAL ? 1 : 4;
        setImportantForAccessibility(accessible);
    }

    Animator getChangeStateAnimation(State state, boolean animated, AppsCustomizePagedView.ContentType content) {
        return getChangeStateAnimation(state, animated, 0, -1, content);
    }

    Animator getChangeStateAnimation(State state, boolean animated, int delay, int snapPage, AppsCustomizePagedView.ContentType contentType) {
        int duration;
        if (this.mState == state) {
            return null;
        }
        Log.i("hy", "state111111" + state);
        initAnimationArrays();
        AnimatorSet anim = animated ? LauncherAnimUtils.createAnimatorSet() : null;
        State oldState = this.mState;
        boolean oldStateIsNormal = oldState == State.NORMAL;
        if (oldState == State.SPRING_LOADED) {
        }
        boolean oldStateIsSmall = oldState == State.SMALL;
        boolean oldStateIsOverview = oldState == State.OVERVIEW;
        setState(state);
        boolean stateIsNormal = state == State.NORMAL;
        boolean stateIsSpringLoaded = state == State.SPRING_LOADED;
        boolean stateIsSmall = state == State.SMALL;
        boolean stateIsOverview = state == State.OVERVIEW;
        float finalBackgroundAlpha = (stateIsSpringLoaded || stateIsOverview) ? 1.0f : 0.0f;
        float finalHotseatAndPageIndicatorAlpha = (stateIsOverview || stateIsSmall) ? 0.0f : 1.0f;
        float finalOverviewPanelAlpha = contentType == AppsCustomizePagedView.ContentType.Widgets ? 1.0f : 0.0f;
        float finalSearchBarAlpha = !stateIsNormal ? 0.0f : 1.0f;
        float finalWorkspaceTranslationY = stateIsOverview ? getOverviewModeTranslationY() : 0;
        boolean workspaceToAllApps = oldStateIsNormal && stateIsSmall;
        boolean allAppsToWorkspace = oldStateIsSmall && stateIsNormal;
        boolean workspaceToOverview = oldStateIsNormal && stateIsOverview;
        boolean overviewToWorkspace = oldStateIsOverview && stateIsNormal;
        this.mNewScale = 1.0f;
        if (oldStateIsOverview) {
            disableFreeScroll(snapPage);
        } else if (stateIsOverview) {
            enableFreeScroll();
        }
        if (state != State.NORMAL) {
            if (stateIsSpringLoaded) {
                this.mNewScale = this.mSpringLoadedShrinkFactor;
            } else if (stateIsOverview) {
                this.mNewScale = this.mOverviewModeShrinkFactor;
            } else if (stateIsSmall) {
                this.mNewScale = this.mOverviewModeShrinkFactor - 0.3f;
            }
            if (workspaceToAllApps) {
                updateChildrenLayersEnabled(false);
            }
        }
        if (workspaceToAllApps) {
            duration = getResources().getInteger(R.integer.config_workspaceUnshrinkTime);
        } else if (workspaceToOverview || overviewToWorkspace) {
            duration = getResources().getInteger(R.integer.config_overviewTransitionTime);
        } else {
            duration = getResources().getInteger(R.integer.config_appsCustomizeWorkspaceShrinkTime);
        }
        int i = 0;
        while (i < getChildCount()) {
            CellLayout cl = (CellLayout) getChildAt(i);
            boolean isCurrentPage = i == getNextPage();
            float initialAlpha = cl.getShortcutsAndWidgets().getAlpha();
            float finalAlpha = stateIsSmall ? 0.0f : 1.0f;
            if (!this.mIsSwitchingState && (workspaceToAllApps || allAppsToWorkspace)) {
                if ((!allAppsToWorkspace || !isCurrentPage) && !isCurrentPage) {
                    finalAlpha = 0.0f;
                }
                initialAlpha = 0.0f;
                cl.setShortcutAndWidgetAlpha(0.0f);
            }
            this.mOldAlphas[i] = initialAlpha;
            this.mNewAlphas[i] = finalAlpha;
            if (animated) {
                this.mOldBackgroundAlphas[i] = cl.getBackgroundAlpha();
                this.mNewBackgroundAlphas[i] = finalBackgroundAlpha;
            } else {
                cl.setBackgroundAlpha(finalBackgroundAlpha);
                cl.setShortcutAndWidgetAlpha(finalAlpha);
            }
            i++;
        }
        View searchBar = this.mLauncher.getQsbBar();
        View overviewPanel = this.mLauncher.getOverviewPanel();
        if (animated) {
            anim.setDuration(duration);
            LauncherViewPropertyAnimator scale = new LauncherViewPropertyAnimator(this);
            scale.scaleX(this.mNewScale).scaleY(this.mNewScale).translationY(finalWorkspaceTranslationY).setInterpolator(this.mZoomInInterpolator);
            anim.play(scale);
            for (int index = 0; index < getChildCount(); index++) {
                final int i2 = index;
                final CellLayout cl2 = (CellLayout) getChildAt(i2);
                float currentAlpha = cl2.getShortcutsAndWidgets().getAlpha();
                if (this.mOldAlphas[i2] == 0.0f && this.mNewAlphas[i2] == 0.0f) {
                    cl2.setBackgroundAlpha(this.mNewBackgroundAlphas[i2]);
                    cl2.setShortcutAndWidgetAlpha(this.mNewAlphas[i2]);
                } else {
                    if (this.mOldAlphas[i2] != this.mNewAlphas[i2] || currentAlpha != this.mNewAlphas[i2]) {
                        LauncherViewPropertyAnimator alphaAnim = new LauncherViewPropertyAnimator(cl2.getShortcutsAndWidgets());
                        alphaAnim.alpha(this.mNewAlphas[i2]).setInterpolator(this.mZoomInInterpolator);
                        anim.play(alphaAnim);
                    }
                    if (this.mOldBackgroundAlphas[i2] != 0.0f || this.mNewBackgroundAlphas[i2] != 0.0f) {
                        ValueAnimator bgAnim = LauncherAnimUtils.ofFloat(cl2, 0.0f, 1.0f);
                        bgAnim.setInterpolator(this.mZoomInInterpolator);
                        bgAnim.addUpdateListener(new LauncherAnimatorUpdateListener() { // from class: com.android.launcher66.Workspace.6
                            @Override // com.android.launcher66.LauncherAnimatorUpdateListener
                            public void onAnimationUpdate(float a, float b) {
                                cl2.setBackgroundAlpha((Workspace.this.mOldBackgroundAlphas[i2] * a) + (Workspace.this.mNewBackgroundAlphas[i2] * b));
                            }
                        });
                        anim.play(bgAnim);
                    }
                }
            }
            ObjectAnimator pageIndicatorAlpha = null;
            if (getPageIndicator() != null) {
                pageIndicatorAlpha = ObjectAnimator.ofFloat(getPageIndicator(), "alpha", finalHotseatAndPageIndicatorAlpha);
            }
            ObjectAnimator searchBarAlpha = ObjectAnimator.ofFloat(searchBar, "alpha", finalSearchBarAlpha);
            ObjectAnimator overviewPanelAlpha = ObjectAnimator.ofFloat(overviewPanel, "alpha", finalOverviewPanelAlpha);
            overviewPanelAlpha.addListener(new AlphaUpdateListener(overviewPanel));
            searchBarAlpha.addListener(new AlphaUpdateListener(searchBar));
            if (!workspaceToOverview && overviewToWorkspace) {
                overviewPanelAlpha.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            if (getPageIndicator() != null) {
                pageIndicatorAlpha.addListener(new AlphaUpdateListener(getPageIndicator()));
            }
            anim.play(overviewPanelAlpha);
            anim.play(searchBarAlpha);
            anim.play(pageIndicatorAlpha);
            anim.setStartDelay(delay);
        } else {
            overviewPanel.setAlpha(finalOverviewPanelAlpha);
            AlphaUpdateListener.updateVisibility(overviewPanel);
            if (getPageIndicator() != null) {
                getPageIndicator().setAlpha(finalHotseatAndPageIndicatorAlpha);
                AlphaUpdateListener.updateVisibility(getPageIndicator());
            }
            searchBar.setAlpha(finalSearchBarAlpha);
            AlphaUpdateListener.updateVisibility(searchBar);
            updateCustomContentVisibility();
            setScaleX(this.mNewScale);
            setScaleY(this.mNewScale);
            setTranslationY(finalWorkspaceTranslationY);
        }
        this.mLauncher.updateVoiceButtonProxyVisible(false);
        if (stateIsSpringLoaded) {
            animateBackgroundGradient(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, false);
            return anim;
        }
        if (stateIsOverview) {
            animateBackgroundGradient(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, true);
            return anim;
        }
        animateBackgroundGradient(0.0f, animated);
        return anim;
    }

    Animator getChangeStateAnimation(State state, boolean animated, int delay, int snapPage) {
        int duration;
        if (this.mState == state) {
            return null;
        }
        Log.i("hy", "state222222" + state);
        initAnimationArrays();
        AnimatorSet anim = animated ? LauncherAnimUtils.createAnimatorSet() : null;
        State oldState = this.mState;
        boolean oldStateIsNormal = oldState == State.NORMAL;
        if (oldState == State.SPRING_LOADED) {
        }
        boolean oldStateIsSmall = oldState == State.SMALL;
        boolean oldStateIsOverview = oldState == State.OVERVIEW;
        setState(state);
        boolean stateIsNormal = state == State.NORMAL;
        boolean stateIsSpringLoaded = state == State.SPRING_LOADED;
        boolean stateIsSmall = state == State.SMALL;
        boolean stateIsOverview = state == State.OVERVIEW;
        float finalBackgroundAlpha = (stateIsSpringLoaded || stateIsOverview) ? 1.0f : 0.0f;
        float finalHotseatAndPageIndicatorAlpha = (stateIsOverview || stateIsSmall) ? 0.0f : 1.0f;
        float finalOverviewPanelAlpha = stateIsOverview ? 1.0f : 0.0f;
        float finalSearchBarAlpha = !stateIsNormal ? 0.0f : 1.0f;
        float finalWorkspaceTranslationY = stateIsOverview ? getOverviewModeTranslationY() : 0;
        boolean workspaceToAllApps = oldStateIsNormal && stateIsSmall;
        boolean allAppsToWorkspace = oldStateIsSmall && stateIsNormal;
        boolean workspaceToOverview = oldStateIsNormal && stateIsOverview;
        boolean overviewToWorkspace = oldStateIsOverview && stateIsNormal;
        this.mNewScale = 1.0f;
        if (oldStateIsOverview) {
            disableFreeScroll(snapPage);
        } else if (stateIsOverview) {
            enableFreeScroll();
        }
        if (state != State.NORMAL) {
            if (stateIsSpringLoaded) {
                this.mNewScale = this.mSpringLoadedShrinkFactor;
            } else if (stateIsOverview) {
                this.mNewScale = this.mOverviewModeShrinkFactor;
            } else if (stateIsSmall) {
                this.mNewScale = this.mOverviewModeShrinkFactor - 0.3f;
            }
            if (workspaceToAllApps) {
                updateChildrenLayersEnabled(false);
            }
        }
        if (workspaceToAllApps) {
            duration = getResources().getInteger(R.integer.config_workspaceUnshrinkTime);
        } else if (workspaceToOverview || overviewToWorkspace) {
            duration = getResources().getInteger(R.integer.config_overviewTransitionTime);
        } else {
            duration = getResources().getInteger(R.integer.config_appsCustomizeWorkspaceShrinkTime);
        }
        int i = 0;
        while (i < getChildCount()) {
            CellLayout cl = (CellLayout) getChildAt(i);
            boolean isCurrentPage = i == getNextPage();
            float initialAlpha = cl.getShortcutsAndWidgets().getAlpha();
            float finalAlpha = stateIsSmall ? 0.0f : 1.0f;
            if (!this.mIsSwitchingState && (workspaceToAllApps || allAppsToWorkspace)) {
                if (allAppsToWorkspace && isCurrentPage) {
                    initialAlpha = 0.0f;
                } else if (!isCurrentPage) {
                    finalAlpha = 0.0f;
                    initialAlpha = 0.0f;
                }
                cl.setShortcutAndWidgetAlpha(initialAlpha);
            }
            this.mOldAlphas[i] = initialAlpha;
            this.mNewAlphas[i] = finalAlpha;
            if (animated) {
                this.mOldBackgroundAlphas[i] = cl.getBackgroundAlpha();
                this.mNewBackgroundAlphas[i] = finalBackgroundAlpha;
            } else {
                cl.setBackgroundAlpha(finalBackgroundAlpha);
                cl.setShortcutAndWidgetAlpha(finalAlpha);
            }
            i++;
        }
        View searchBar = this.mLauncher.getQsbBar();
        View overviewPanel = this.mLauncher.getOverviewPanel();
        if (animated) {
            anim.setDuration(duration);
            LauncherViewPropertyAnimator scale = new LauncherViewPropertyAnimator(this);
            scale.scaleX(this.mNewScale).scaleY(this.mNewScale).translationY(finalWorkspaceTranslationY).setInterpolator(this.mZoomInInterpolator);
            anim.play(scale);
            for (int index = 0; index < getChildCount(); index++) {
                final int i2 = index;
                final CellLayout cl2 = (CellLayout) getChildAt(i2);
                float currentAlpha = cl2.getShortcutsAndWidgets().getAlpha();
                if (this.mOldAlphas[i2] == 0.0f && this.mNewAlphas[i2] == 0.0f) {
                    cl2.setBackgroundAlpha(this.mNewBackgroundAlphas[i2]);
                    cl2.setShortcutAndWidgetAlpha(this.mNewAlphas[i2]);
                } else {
                    if (this.mOldAlphas[i2] != this.mNewAlphas[i2] || currentAlpha != this.mNewAlphas[i2]) {
                        LauncherViewPropertyAnimator alphaAnim = new LauncherViewPropertyAnimator(cl2.getShortcutsAndWidgets());
                        alphaAnim.alpha(this.mNewAlphas[i2]).setInterpolator(this.mZoomInInterpolator);
                        anim.play(alphaAnim);
                    }
                    if (this.mOldBackgroundAlphas[i2] != 0.0f || this.mNewBackgroundAlphas[i2] != 0.0f) {
                        ValueAnimator bgAnim = LauncherAnimUtils.ofFloat(cl2, 0.0f, 1.0f);
                        bgAnim.setInterpolator(this.mZoomInInterpolator);
                        bgAnim.addUpdateListener(new LauncherAnimatorUpdateListener() { // from class: com.android.launcher66.Workspace.7
                            @Override // com.android.launcher66.LauncherAnimatorUpdateListener
                            public void onAnimationUpdate(float a, float b) {
                                cl2.setBackgroundAlpha((Workspace.this.mOldBackgroundAlphas[i2] * a) + (Workspace.this.mNewBackgroundAlphas[i2] * b));
                            }
                        });
                        anim.play(bgAnim);
                    }
                }
            }
            ObjectAnimator pageIndicatorAlpha = null;
            if (getPageIndicator() != null) {
                pageIndicatorAlpha = ObjectAnimator.ofFloat(getPageIndicator(), "alpha", finalHotseatAndPageIndicatorAlpha);
            }
            ObjectAnimator searchBarAlpha = ObjectAnimator.ofFloat(searchBar, "alpha", finalSearchBarAlpha);
            ObjectAnimator overviewPanelAlpha = ObjectAnimator.ofFloat(overviewPanel, "alpha", finalOverviewPanelAlpha);
            overviewPanelAlpha.addListener(new AlphaUpdateListener(overviewPanel));
            searchBarAlpha.addListener(new AlphaUpdateListener(searchBar));
            if (!workspaceToOverview && overviewToWorkspace) {
                overviewPanelAlpha.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            if (getPageIndicator() != null) {
                pageIndicatorAlpha.addListener(new AlphaUpdateListener(getPageIndicator()));
            }
            anim.play(overviewPanelAlpha);
            anim.play(searchBarAlpha);
            anim.play(pageIndicatorAlpha);
            anim.setStartDelay(delay);
        } else {
            overviewPanel.setAlpha(finalOverviewPanelAlpha);
            AlphaUpdateListener.updateVisibility(overviewPanel);
            if (getPageIndicator() != null) {
                getPageIndicator().setAlpha(finalHotseatAndPageIndicatorAlpha);
                AlphaUpdateListener.updateVisibility(getPageIndicator());
            }
            searchBar.setAlpha(finalSearchBarAlpha);
            AlphaUpdateListener.updateVisibility(searchBar);
            updateCustomContentVisibility();
            setScaleX(this.mNewScale);
            setScaleY(this.mNewScale);
            setTranslationY(finalWorkspaceTranslationY);
        }
        this.mLauncher.updateVoiceButtonProxyVisible(false);
        if (stateIsSpringLoaded) {
            animateBackgroundGradient(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, false);
            return anim;
        }
        if (stateIsOverview) {
            animateBackgroundGradient(getResources().getInteger(R.integer.config_appsCustomizeSpringLoadedBgAlpha) / 100.0f, true);
            return anim;
        }
        animateBackgroundGradient(0.0f, animated);
        return anim;
    }

    static class AlphaUpdateListener implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        View view;

        public AlphaUpdateListener(View v) {
            this.view = v;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator arg0) {
            updateVisibility(this.view);
        }

        public static void updateVisibility(View view) {
            int invisibleState = Workspace.sAccessibilityEnabled ? 8 : 4;
            if (view.getAlpha() < Workspace.ALPHA_CUTOFF_THRESHOLD && view.getVisibility() != View.INVISIBLE) {
                view.setVisibility(View.INVISIBLE);
            } else if (view.getAlpha() > Workspace.ALPHA_CUTOFF_THRESHOLD && view.getVisibility() != View.VISIBLE) {
                view.setVisibility(android.view.View.VISIBLE);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator arg0) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator arg0) {
            updateVisibility(this.view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator arg0) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator arg0) {
            this.view.setVisibility(View.VISIBLE);
        }
    }

    @Override // com.android.launcher66.LauncherTransitionable
    public void onLauncherTransitionPrepare(Launcher l, boolean animated, boolean toWorkspace) {
        onTransitionPrepare();
    }

    @Override // com.android.launcher66.LauncherTransitionable
    public void onLauncherTransitionStart(Launcher l, boolean animated, boolean toWorkspace) {
    }

    @Override // com.android.launcher66.LauncherTransitionable
    public void onLauncherTransitionStep(Launcher l, float t) {
        this.mTransitionProgress = t;
    }

    @Override // com.android.launcher66.LauncherTransitionable
    public void onLauncherTransitionEnd(Launcher l, boolean animated, boolean toWorkspace) {
        onTransitionEnd();
    }

    private void onTransitionPrepare() {
        this.mIsSwitchingState = true;
        invalidate();
        updateChildrenLayersEnabled(false);
        hideCustomContentIfNecessary();
    }

    void updateCustomContentVisibility() {
        int visibility = this.mState == State.NORMAL ? 0 : 4;
        if (hasCustomContent()) {
            Objects.requireNonNull(this.mWorkspaceScreens.get(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID))).setVisibility(View.VISIBLE);
        }
    }

    void showCustomContentIfNecessary() {
        boolean show = this.mState == State.NORMAL;
        if (show && hasCustomContent()) {
            Objects.requireNonNull(this.mWorkspaceScreens.get(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID))).setVisibility(View.VISIBLE);
        }
    }

    void hideCustomContentIfNecessary() {
        boolean hide = this.mState != State.NORMAL;
        if (hide && hasCustomContent()) {
            Objects.requireNonNull(this.mWorkspaceScreens.get(Long.valueOf(CUSTOM_CONTENT_SCREEN_ID))).setVisibility(View.INVISIBLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTransitionEnd() {
        this.mIsSwitchingState = false;
        updateChildrenLayersEnabled(false);
        if (!this.mWorkspaceFadeInAdjacentScreens) {
            for (int i = 0; i < getChildCount(); i++) {
                CellLayout cl = (CellLayout) getChildAt(i);
                cl.setShortcutAndWidgetAlpha(1.0f);
            }
        }
        showCustomContentIfNecessary();
    }

    @Override // com.android.launcher66.LauncherTransitionable
    public View getContent() {
        return this;
    }

    private void drawDragView(View v, Canvas destCanvas, int padding, boolean pruneToDrawable) {
        Rect clipRect = this.mTempRect;
        v.getDrawingRect(clipRect);
        boolean textVisible = false;
        destCanvas.save();
        if ((v instanceof TextView) && pruneToDrawable) {
            int index = LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign);
            Drawable d = ((TextView) v).getCompoundDrawables()[index];
            LogPreview.show("index:" + index);
            clipRect.set(0, 0, d.getIntrinsicWidth() + padding, d.getIntrinsicHeight() + padding);
            destCanvas.translate((float) padding / 2, (float) padding / 2);
            d.draw(destCanvas);
        } else {
            if (v instanceof FolderIcon) {
                if (((FolderIcon) v).getTextVisible()) {
                    ((FolderIcon) v).setTextVisible(false);
                    textVisible = true;
                }
            } else if (v instanceof BubbleTextView) {
                TextView tv = (TextView) v;
                clipRect.bottom = (tv.getExtendedPaddingTop() - 3) + ((BubbleTextView) v).getLayout().getLineTop(0);
            } else if (v instanceof TextView) {
                TextView tv = (TextView) v;
                clipRect.bottom = (tv.getExtendedPaddingTop() - tv.getCompoundDrawablePadding()) + tv.getLayout().getLineTop(0);
            }
            destCanvas.translate((-v.getScrollX()) + ((float) padding / 2), (-v.getScrollY()) + ((float) padding / 2));
            destCanvas.clipRect(clipRect);
            v.draw(destCanvas);
            if (textVisible) {
                ((FolderIcon) v).setTextVisible(true);
            }
        }
        destCanvas.restore();
    }

    public Bitmap createDragBitmap(View v, Canvas canvas, int padding) {
        Bitmap b;
        if (v instanceof TextView) {
            int index = LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign);
            Drawable d = ((TextView) v).getCompoundDrawables()[index];
            LogPreview.show("width:" + v.getClass().getName());
            LogPreview.show("index" + index);
            b = Bitmap.createBitmap(d.getIntrinsicWidth() + padding, d.getIntrinsicHeight() + padding, Bitmap.Config.ARGB_8888);
        } else {
            b = Bitmap.createBitmap(v.getWidth() + padding, v.getHeight() + padding, Bitmap.Config.ARGB_8888);
        }
        canvas.setBitmap(b);
        drawDragView(v, canvas, padding, true);
        canvas.setBitmap(null);
        return b;
    }

    private Bitmap createDragOutline(View v, Canvas canvas, int padding) {
        int outlineColor = ContextCompat.getColor(getContext(), R.color.outline_color);
        Bitmap b = Bitmap.createBitmap(v.getWidth() + padding, v.getHeight() + padding, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        drawDragView(v, canvas, padding, true);
        this.mOutlineHelper.applyMediumExpensiveOutlineWithBlur(b, canvas, outlineColor, outlineColor);
        canvas.setBitmap(null);
        return b;
    }

    private Bitmap createDragOutline(Bitmap orig, Canvas canvas, int padding, int w, int h, boolean clipAlpha) {
        int outlineColor = ContextCompat.getColor(getContext(), R.color.outline_color);
        Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        Rect src = new Rect(0, 0, orig.getWidth(), orig.getHeight());
        float scaleFactor = Math.min((w - padding) / orig.getWidth(), (h - padding) / orig.getHeight());
        int scaledWidth = (int) (orig.getWidth() * scaleFactor);
        int scaledHeight = (int) (orig.getHeight() * scaleFactor);
        Rect dst = new Rect(0, 0, scaledWidth, scaledHeight);
        dst.offset((w - scaledWidth) / 2, (h - scaledHeight) / 2);
        canvas.drawBitmap(orig, src, dst, null);
        this.mOutlineHelper.applyMediumExpensiveOutlineWithBlur(b, canvas, outlineColor, outlineColor, clipAlpha);
        canvas.setBitmap(null);
        return b;
    }

    void startDrag(CellLayout.CellInfo cellInfo) {
        View child = cellInfo.cell;
        if (child.isInTouchMode()) {
            this.mDragInfo = cellInfo;
            child.setVisibility(View.INVISIBLE);
            CellLayout layout = (CellLayout) child.getParent().getParent();
            layout.prepareChildForDrag(child);
            child.clearFocus();
            child.setPressed(false);
            Canvas canvas = new Canvas();
            this.mDragOutline = createDragOutline(child, canvas, 2);
            beginDragShared(child, this);
        }
    }

    public void beginDragShared(View child, DragSource source) {
        Bitmap b = createDragBitmap(child, new Canvas(), 2);
        int bmpWidth = b.getWidth();
        int bmpHeight = b.getHeight();
        float scale = this.mLauncher.getDragLayer().getLocationInDragLayer(child, this.mTempXY);
        int dragLayerX = Math.round(this.mTempXY[0] - ((bmpWidth - (child.getWidth() * scale)) / 2.0f));
        int dragLayerY = Math.round((this.mTempXY[1] - ((bmpHeight - (bmpHeight * scale)) / 2.0f)) - 1.0f);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        Point dragVisualizeOffset = null;
        Rect dragRect = null;
        if ((child instanceof BubbleTextView) || (child instanceof PagedViewIcon)) {
            int iconSize = grid.iconSizePx;
            int top = child.getPaddingTop();
            int left = (bmpWidth - iconSize) / 2;
            int right = left + iconSize;
            int bottom = top + iconSize;
            dragLayerY += top;
            dragVisualizeOffset = new Point(-1, 1);
            dragRect = new Rect(left, top, right, bottom);
        } else if (child instanceof FolderIcon) {
            int previewSize = grid.folderIconSizePx;
            dragRect = new Rect(0, child.getPaddingTop(), child.getWidth(), previewSize);
        }
        if (child instanceof BubbleTextView) {
            BubbleTextView icon = (BubbleTextView) child;
            icon.clearPressedOrFocusedBackground();
        }
        this.mDragController.startDrag(b, dragLayerX, dragLayerY, source, child.getTag(), DragController.DRAG_ACTION_MOVE, dragVisualizeOffset, dragRect, scale);
        if (child.getParent() instanceof ShortcutAndWidgetContainer) {
            this.mDragSourceInternal = (ShortcutAndWidgetContainer) child.getParent();
        }
        b.recycle();
    }

    void addApplicationShortcut(ShortcutInfo info, CellLayout target, long container, long screenId, int cellX, int cellY, boolean insertAtFirst, int intersectX, int intersectY) {
        View view = this.mLauncher.createShortcut(R.layout.application, target, info);
        int[] cellXY = new int[2];
        target.findCellForSpanThatIntersects(cellXY, 1, 1, intersectX, intersectY);
        addInScreen(view, container, screenId, cellXY[0], cellXY[1], 1, 1, insertAtFirst);
        LauncherModel.addOrMoveItemInDatabase(this.mLauncher, info, container, screenId, cellXY[0], cellXY[1]);
    }

    public boolean transitionStateShouldAllowDrop() {
        return (!isSwitchingState() || this.mTransitionProgress > 0.5f) && this.mState != State.SMALL;
    }

    @Override // com.android.launcher66.DropTarget
    public boolean acceptDrop(DropTarget.DragObject d) {
        int spanX;
        int spanY;
        CellLayout dropTargetLayout = this.mDropToLayout;
        if (d.dragSource != this) {
            if (dropTargetLayout == null || !transitionStateShouldAllowDrop()) {
                return false;
            }
            this.mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset, d.dragView, this.mDragViewVisualCenter);
            if (!this.mLauncher.isHotseatLayout(dropTargetLayout)) {
                mapPointFromSelfToChild(dropTargetLayout, this.mDragViewVisualCenter, null);
            }
            if (this.mDragInfo != null) {
                CellLayout.CellInfo dragCellInfo = this.mDragInfo;
                spanX = dragCellInfo.spanX;
                spanY = dragCellInfo.spanY;
            } else {
                ItemInfo dragInfo = (ItemInfo) d.dragInfo;
                spanX = dragInfo.spanX;
                spanY = dragInfo.spanY;
            }
            int minSpanX = spanX;
            int minSpanY = spanY;
            if (d.dragInfo instanceof PendingAddWidgetInfo) {
                minSpanX = ((PendingAddWidgetInfo) d.dragInfo).minSpanX;
                minSpanY = ((PendingAddWidgetInfo) d.dragInfo).minSpanY;
            }
            this.mTargetCell = findNearestArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], minSpanX, minSpanY, dropTargetLayout, this.mTargetCell);
            float distance = dropTargetLayout.getDistanceFromCell(this.mDragViewVisualCenter[0], this.mDragViewVisualCenter[1], this.mTargetCell);
            if (willCreateUserFolder((ItemInfo) d.dragInfo, dropTargetLayout, this.mTargetCell, distance, true) || willAddToExistingUserFolder((ItemInfo) d.dragInfo, dropTargetLayout, this.mTargetCell, distance)) {
                return true;
            }
            int[] resultSpan = new int[2];
            this.mTargetCell = dropTargetLayout.createArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], minSpanX, minSpanY, spanX, spanY, null, this.mTargetCell, resultSpan, 3);
            boolean foundCell = this.mTargetCell[0] >= 0 && this.mTargetCell[1] >= 0;
            if (!foundCell) {
                boolean isHotseat = this.mLauncher.isHotseatLayout(dropTargetLayout);
                if (this.mTargetCell != null) {
                }
                this.mLauncher.showOutOfSpaceMessage(isHotseat);
                return false;
            }
        }
        long screenId = getIdForScreen(dropTargetLayout);
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            commitExtraEmptyScreen();
        }
        return true;
    }

    boolean willCreateUserFolder(ItemInfo info, CellLayout target, int[] targetCell, float distance, boolean considerTimeout) {
        if (distance > this.mMaxDistanceForFolderCreation) {
            return false;
        }
        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);
        if (dropOverView != null) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) dropOverView.getLayoutParams();
            if (lp.useTmpCoords && (lp.tmpCellX != lp.cellX || lp.tmpCellY != lp.tmpCellY)) {
                return false;
            }
        }
        boolean hasntMoved = false;
        if (this.mDragInfo != null) {
            hasntMoved = dropOverView == this.mDragInfo.cell;
        }
        if (dropOverView == null || hasntMoved) {
            return false;
        }
        if (considerTimeout && !this.mCreateUserFolderOnDrop) {
            return false;
        }
        boolean aboveShortcut = dropOverView.getTag() instanceof ShortcutInfo;
        boolean willBecomeShortcut = info.itemType == 0 || info.itemType == 1;
        return aboveShortcut && willBecomeShortcut;
    }

    boolean willAddToExistingUserFolder(Object dragInfo, CellLayout target, int[] targetCell, float distance) {
        if (distance > this.mMaxDistanceForFolderCreation) {
            return false;
        }
        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);
        if (dropOverView != null) {
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) dropOverView.getLayoutParams();
            if (lp.useTmpCoords && (lp.tmpCellX != lp.cellX || lp.tmpCellY != lp.tmpCellY)) {
                return false;
            }
        }
        if (!(dropOverView instanceof FolderIcon)) {
            return false;
        }
        FolderIcon fi = (FolderIcon) dropOverView;
        return fi.acceptDrop(dragInfo);
    }

    boolean createUserFolderIfNecessary(View newView, long container, CellLayout target, int[] targetCell, float distance, boolean external, DragView dragView, Runnable postAnimationRunnable) {
        if (distance > this.mMaxDistanceForFolderCreation) {
            return false;
        }
        View v = target.getChildAt(targetCell[0], targetCell[1]);
        boolean hasntMoved = false;
        if (this.mDragInfo != null) {
            CellLayout cellParent = getParentCellLayoutForView(this.mDragInfo.cell);
            hasntMoved = this.mDragInfo.cellX == targetCell[0] && this.mDragInfo.cellY == targetCell[1] && cellParent == target;
        }
        if (v == null || hasntMoved || !this.mCreateUserFolderOnDrop) {
            return false;
        }
        this.mCreateUserFolderOnDrop = false;
        long screenId = targetCell == null ? this.mDragInfo.screenId : getIdForScreen(target);
        boolean aboveShortcut = v.getTag() instanceof ShortcutInfo;
        boolean willBecomeShortcut = newView.getTag() instanceof ShortcutInfo;
        if (aboveShortcut && willBecomeShortcut) {
            ShortcutInfo sourceInfo = (ShortcutInfo) newView.getTag();
            ShortcutInfo destInfo = (ShortcutInfo) v.getTag();
            if (!external) {
                getParentCellLayoutForView(this.mDragInfo.cell).removeView(this.mDragInfo.cell);
            }
            Rect folderLocation = new Rect();
            float scale = this.mLauncher.getDragLayer().getDescendantRectRelativeToSelf(v, folderLocation);
            target.removeView(v);
            FolderIcon fi = this.mLauncher.addFolder(target, container, screenId, targetCell[0], targetCell[1]);
            destInfo.cellX = -1;
            destInfo.cellY = -1;
            sourceInfo.cellX = -1;
            sourceInfo.cellY = -1;
            boolean animate = dragView != null;
            if (animate) {
                fi.performCreateAnimation(destInfo, v, sourceInfo, dragView, folderLocation, scale, postAnimationRunnable);
            } else {
                fi.addItem(destInfo);
                fi.addItem(sourceInfo);
            }
            return true;
        }
        return false;
    }

    boolean addToExistingFolderIfNecessary(View newView, CellLayout target, int[] targetCell, float distance, DropTarget.DragObject d, boolean external) {
        if (distance > this.mMaxDistanceForFolderCreation) {
            return false;
        }
        View dropOverView = target.getChildAt(targetCell[0], targetCell[1]);
        if (!this.mAddToExistingFolderOnDrop) {
            return false;
        }
        this.mAddToExistingFolderOnDrop = false;
        if (!(dropOverView instanceof FolderIcon)) {
            return false;
        }
        FolderIcon fi = (FolderIcon) dropOverView;
        if (!fi.acceptDrop(d.dragInfo)) {
            return false;
        }
        fi.onDrop(d);
        if (!external) {
            getParentCellLayoutForView(this.mDragInfo.cell).removeView(this.mDragInfo.cell);
        }
        return true;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDrop(DropTarget.DragObject d) {
        final LauncherAppWidgetHostView hostView;
        AppWidgetProviderInfo pinfo;
        this.mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset, d.dragView, this.mDragViewVisualCenter);
        final CellLayout dropTargetLayout = this.mDropToLayout;
        if (dropTargetLayout != null && !this.mLauncher.isHotseatLayout(dropTargetLayout)) {
            mapPointFromSelfToChild(dropTargetLayout, this.mDragViewVisualCenter, null);
        }
        int snapScreen = -1;
        boolean resizeOnDrop = false;
        if (d.dragSource != this) {
            int[] touchXY = {(int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1]};
            onDropExternal(touchXY, d.dragInfo, dropTargetLayout, false, d);
            return;
        }
        if (this.mDragInfo != null) {
            View cell = this.mDragInfo.cell;
            Runnable resizeRunnable = null;
            if (dropTargetLayout != null && !d.cancelled) {
                boolean hasMovedLayouts = getParentCellLayoutForView(cell) != dropTargetLayout;
                boolean hasMovedIntoHotseat = this.mLauncher.isHotseatLayout(dropTargetLayout);
                long container = hasMovedIntoHotseat ? -101 : -100;
                long screenId = this.mTargetCell[0] < 0 ? this.mDragInfo.screenId : getIdForScreen(dropTargetLayout);
                int spanX = this.mDragInfo != null ? this.mDragInfo.spanX : 1;
                int spanY = this.mDragInfo != null ? this.mDragInfo.spanY : 1;
                this.mTargetCell = findNearestArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], spanX, spanY, dropTargetLayout, this.mTargetCell);
                float distance = dropTargetLayout.getDistanceFromCell(this.mDragViewVisualCenter[0], this.mDragViewVisualCenter[1], this.mTargetCell);
                if (!this.mInScrollArea && createUserFolderIfNecessary(cell, container, dropTargetLayout, this.mTargetCell, distance, false, d.dragView, null)) {
                    stripEmptyScreens();
                    return;
                }
                if (addToExistingFolderIfNecessary(cell, dropTargetLayout, this.mTargetCell, distance, d, false)) {
                    stripEmptyScreens();
                    return;
                }
                ItemInfo item = (ItemInfo) d.dragInfo;
                int minSpanX = item.spanX;
                int minSpanY = item.spanY;
                if (item.minSpanX > 0 && item.minSpanY > 0) {
                    minSpanX = item.minSpanX;
                    minSpanY = item.minSpanY;
                }
                int[] resultSpan = new int[2];
                this.mTargetCell = dropTargetLayout.createArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], minSpanX, minSpanY, spanX, spanY, cell, this.mTargetCell, resultSpan, 1);
                boolean foundCell = this.mTargetCell[0] >= 0 && this.mTargetCell[1] >= 0;
                if (foundCell && (cell instanceof AppWidgetHostView) && (resultSpan[0] != item.spanX || resultSpan[1] != item.spanY)) {
                    resizeOnDrop = true;
                    item.spanX = resultSpan[0];
                    item.spanY = resultSpan[1];
                    AppWidgetHostView awhv = (AppWidgetHostView) cell;
                    AppWidgetResizeFrame.updateWidgetSizeRanges(awhv, this.mLauncher, resultSpan[0], resultSpan[1]);
                }
                if (getScreenIdForPageIndex(this.mCurrentPage) != screenId && !hasMovedIntoHotseat) {
                    snapScreen = getPageIndexForScreenId(screenId);
                    snapToPage(snapScreen);
                }
                if (foundCell) {
                    final ItemInfo info = (ItemInfo) cell.getTag();
                    if (hasMovedLayouts) {
                        getParentCellLayoutForView(cell).removeView(cell);
                        addInScreen(cell, container, screenId, this.mTargetCell[0], this.mTargetCell[1], info.spanX, info.spanY);
                    }
                    CellLayout.LayoutParams lp = (CellLayout.LayoutParams) cell.getLayoutParams();
                    int i = this.mTargetCell[0];
                    lp.tmpCellX = i;
                    lp.cellX = i;
                    int i2 = this.mTargetCell[1];
                    lp.tmpCellY = i2;
                    lp.cellY = i2;
                    lp.cellHSpan = item.spanX;
                    lp.cellVSpan = item.spanY;
                    lp.isLockedToGrid = true;
                    cell.setId(LauncherModel.getCellLayoutChildId(container, this.mDragInfo.screenId, this.mTargetCell[0], this.mTargetCell[1], this.mDragInfo.spanX, this.mDragInfo.spanY));
                    if (container != -101 && (cell instanceof LauncherAppWidgetHostView) && (pinfo = (hostView = (LauncherAppWidgetHostView) cell).getAppWidgetInfo()) != null && pinfo.resizeMode != 0) {

                        final Runnable addResizeFrame = () -> {
                            DragLayer dragLayer = Workspace.this.mLauncher.getDragLayer();
                            dragLayer.addResizeFrame(info, hostView, dropTargetLayout);
                        };
                        resizeRunnable = () -> {
                            if (!Workspace.this.isPageMoving()) {
                                addResizeFrame.run();
                            } else {
                                Workspace.this.mDelayedResizeRunnable = addResizeFrame;
                            }
                        };
                    }
                    LauncherModel.modifyItemInDatabase(this.mLauncher, info, container, screenId, lp.cellX, lp.cellY, item.spanX, item.spanY);
                } else {
                    CellLayout.LayoutParams lp2 = (CellLayout.LayoutParams) cell.getLayoutParams();
                    this.mTargetCell[0] = lp2.cellX;
                    this.mTargetCell[1] = lp2.cellY;
                    CellLayout layout = (CellLayout) cell.getParent().getParent();
                    layout.markCellsAsOccupiedForView(cell);
                }
            }
            CellLayout parent = (CellLayout) cell.getParent().getParent();
            final Runnable finalResizeRunnable = resizeRunnable;
            Runnable onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.Workspace.10
                @Override // java.lang.Runnable
                public void run() {
                    Workspace.this.mAnimatingViewIntoPlace = false;
                    Workspace.this.updateChildrenLayersEnabled(false);
                    if (finalResizeRunnable != null) {
                        finalResizeRunnable.run();
                    }
                    Workspace.this.stripEmptyScreens();
                }
            };
            this.mAnimatingViewIntoPlace = true;
            if (d.dragView.hasDrawn()) {
                ItemInfo info2 = (ItemInfo) cell.getTag();
                if (info2.itemType == 4) {
                    int animationType = resizeOnDrop ? 2 : 0;
                    animateWidgetDrop(info2, parent, d.dragView, onCompleteRunnable, animationType, cell, false);
                } else {
                    int duration = snapScreen < 0 ? -1 : 300;
                    this.mLauncher.getDragLayer().animateViewIntoPosition(d.dragView, cell, duration, onCompleteRunnable, this);
                }
            } else {
                d.deferDragViewCleanupPostAnimation = false;
                cell.setVisibility(android.view.View.VISIBLE);
            }
            parent.onDropChild(cell);
        }
    }

    public void setFinalScrollForPageChange(int pageIndex) {
        CellLayout cl = (CellLayout) getChildAt(pageIndex);
        if (cl != null) {
            this.mSavedScrollX = getScrollX();
            this.mSavedTranslationX = cl.getTranslationX();
            this.mSavedRotationY = cl.getRotationY();
            int newX = getScrollForPage(pageIndex);
            setScrollX(newX);
            cl.setTranslationX(0.0f);
            cl.setRotationY(0.0f);
        }
    }

    public void resetFinalScrollForPageChange(int pageIndex) {
        if (pageIndex >= 0) {
            CellLayout cl = (CellLayout) getChildAt(pageIndex);
            setScrollX(this.mSavedScrollX);
            cl.setTranslationX(this.mSavedTranslationX);
            cl.setRotationY(this.mSavedRotationY);
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

    @Override // com.android.launcher66.DropTarget
    public void onDragEnter(DropTarget.DragObject d) {
        this.mDragEnforcer.onDragEnter();
        this.mCreateUserFolderOnDrop = false;
        this.mAddToExistingFolderOnDrop = false;
        this.mDropToLayout = null;
        CellLayout layout = getCurrentDropLayout();
        setCurrentDropLayout(layout);
        setCurrentDragOverlappingLayout(layout);
        if (LauncherAppState.getInstance().isScreenLarge()) {
            showOutlines();
        }
    }

    static Rect getCellLayoutMetrics(Launcher launcher, int orientation) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        launcher.getResources();
        Display display = launcher.getWindowManager().getDefaultDisplay();
        Point smallestSize = new Point();
        Point largestSize = new Point();
        display.getCurrentSizeRange(smallestSize, largestSize);
        int countX = (int) grid.numColumns;
        int countY = (int) grid.numRows;
        int constrainedLongEdge = largestSize.y;
        int constrainedShortEdge = smallestSize.y;
        if (orientation == 0) {
            if (mLandscapeCellLayoutMetrics == null) {
                Rect padding = grid.getWorkspacePadding(0);
                int width = (constrainedLongEdge - padding.left) - padding.right;
                int height = (constrainedShortEdge - padding.top) - padding.bottom;
                mLandscapeCellLayoutMetrics = new Rect();
                mLandscapeCellLayoutMetrics.set(grid.calculateCellWidth(width, countX), grid.calculateCellHeight(height, countY), 0, 0);
            }
            return mLandscapeCellLayoutMetrics;
        }
        if (orientation == 1) {
            if (mPortraitCellLayoutMetrics == null) {
                Rect padding2 = grid.getWorkspacePadding(1);
                int width2 = (constrainedShortEdge - padding2.left) - padding2.right;
                int height2 = (constrainedLongEdge - padding2.top) - padding2.bottom;
                mPortraitCellLayoutMetrics = new Rect();
                mPortraitCellLayoutMetrics.set(grid.calculateCellWidth(width2, countX), grid.calculateCellHeight(height2, countY), 0, 0);
            }
            return mPortraitCellLayoutMetrics;
        }
        return null;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragExit(DropTarget.DragObject d) {
        this.mDragEnforcer.onDragExit();
        if (this.mInScrollArea) {
            if (isPageMoving()) {
                this.mDropToLayout = (CellLayout) getPageAt(getNextPage());
            } else {
                this.mDropToLayout = this.mDragOverlappingLayout;
            }
        } else {
            this.mDropToLayout = this.mDragTargetLayout;
        }
        if (this.mDragMode == 1) {
            this.mCreateUserFolderOnDrop = true;
        } else if (this.mDragMode == 2) {
            this.mAddToExistingFolderOnDrop = true;
        }
        onResetScrollArea();
        setCurrentDropLayout(null);
        setCurrentDragOverlappingLayout(null);
        this.mSpringLoadedDragController.cancel();
        if (!this.mIsPageMoving) {
            hideOutlines();
        }
    }

    void setCurrentDropLayout(CellLayout layout) {
        if (this.mDragTargetLayout != null) {
            this.mDragTargetLayout.revertTempState();
            this.mDragTargetLayout.onDragExit();
        }
        this.mDragTargetLayout = layout;
        if (this.mDragTargetLayout != null) {
            this.mDragTargetLayout.onDragEnter();
        }
        cleanupReorder(true);
        cleanupFolderCreation();
        setCurrentDropOverCell(-1, -1);
    }

    void setCurrentDragOverlappingLayout(CellLayout layout) {
        if (this.mDragOverlappingLayout != null) {
            this.mDragOverlappingLayout.setIsDragOverlapping(false);
        }
        this.mDragOverlappingLayout = layout;
        if (this.mDragOverlappingLayout != null) {
            this.mDragOverlappingLayout.setIsDragOverlapping(true);
        }
        invalidate();
    }

    void setCurrentDropOverCell(int x, int y) {
        if (x != this.mDragOverX || y != this.mDragOverY) {
            this.mDragOverX = x;
            this.mDragOverY = y;
            setDragMode(0);
        }
    }

    void setDragMode(int dragMode) {
        if (dragMode != this.mDragMode) {
            if (dragMode == 0) {
                cleanupAddToFolder();
                cleanupReorder(false);
                cleanupFolderCreation();
            } else if (dragMode == 2) {
                LogPreview.show("DRAG_MODE_ADD_TO_FOLDER");
                cleanupReorder(true);
                cleanupFolderCreation();
            } else if (dragMode == 1) {
                cleanupAddToFolder();
                cleanupReorder(true);
            } else if (dragMode == 3) {
                cleanupAddToFolder();
                cleanupFolderCreation();
            }
            this.mDragMode = dragMode;
        }
    }

    private void cleanupFolderCreation() {
        if (this.mDragFolderRingAnimator != null) {
            this.mDragFolderRingAnimator.animateToNaturalState();
            this.mDragFolderRingAnimator = null;
        }
        this.mFolderCreationAlarm.setOnAlarmListener(null);
        this.mFolderCreationAlarm.cancelAlarm();
    }

    private void cleanupAddToFolder() {
        if (this.mDragOverFolderIcon != null) {
            this.mDragOverFolderIcon.onDragExit(null);
            this.mDragOverFolderIcon = null;
        }
    }

    private void cleanupReorder(boolean cancelAlarm) {
        if (cancelAlarm) {
            this.mReorderAlarm.cancelAlarm();
        }
        this.mLastReorderX = -1;
        this.mLastReorderY = -1;
    }

    void mapPointFromSelfToChild(View v, float[] xy, Matrix cachedInverseMatrix) {
        xy[0] = xy[0] - v.getLeft();
        xy[1] = xy[1] - v.getTop();
    }

    boolean isPointInSelfOverHotseat(int x, int y, Rect r) {
        if (r == null) {
            new Rect();
        }
        this.mTempPt[0] = x;
        this.mTempPt[1] = y;
        this.mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, this.mTempPt, true);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        Rect r2 = grid.getHotseatRect();
        return r2.contains(this.mTempPt[0], this.mTempPt[1]);
    }

    void mapPointFromSelfToHotseatLayout(Hotseat hotseat, float[] xy) {
        this.mTempPt[0] = (int) xy[0];
        this.mTempPt[1] = (int) xy[1];
        this.mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, this.mTempPt, true);
        this.mLauncher.getDragLayer().mapCoordInSelfToDescendent(hotseat.getLayout(), this.mTempPt);
        xy[0] = this.mTempPt[0];
        xy[1] = this.mTempPt[1];
    }

    void mapPointFromChildToSelf(View v, float[] xy) {
        xy[0] = xy[0] + v.getLeft();
        xy[1] = xy[1] + v.getTop();
    }

    private static float squaredDistance(float[] point1, float[] point2) {
        float distanceX = point1[0] - point2[0];
        float distanceY = point2[1] - point2[1];
        return (distanceX * distanceX) + (distanceY * distanceY);
    }

    private CellLayout findMatchingPageForDragOver(DragView dragView, float originX, float originY, boolean exact) {
        int screenCount = getChildCount();
        CellLayout bestMatchingScreen = null;
        float smallestDistSoFar = Float.MAX_VALUE;
        for (int i = 0; i < screenCount; i++) {
            if (this.mScreenOrder.get(i).longValue() != CUSTOM_CONTENT_SCREEN_ID) {
                CellLayout cl = (CellLayout) getChildAt(i);
                float[] touchXy = {originX, originY};
                cl.getMatrix().invert(this.mTempInverseMatrix);
                mapPointFromSelfToChild(cl, touchXy, this.mTempInverseMatrix);
                if (touchXy[0] < 0.0f || touchXy[0] > cl.getWidth() || touchXy[1] < 0.0f || touchXy[1] > cl.getHeight()) {
                    if (!exact) {
                        float[] cellLayoutCenter = this.mTempCellLayoutCenterCoordinates;
                        cellLayoutCenter[0] = (float) cl.getWidth() / 2;
                        cellLayoutCenter[1] = (float) cl.getHeight() / 2;
                        mapPointFromChildToSelf(cl, cellLayoutCenter);
                        touchXy[0] = originX;
                        touchXy[1] = originY;
                        float dist = squaredDistance(touchXy, cellLayoutCenter);
                        if (dist < smallestDistSoFar) {
                            smallestDistSoFar = dist;
                            bestMatchingScreen = cl;
                        }
                    }
                } else {
                    return cl;
                }
            }
        }
        return bestMatchingScreen;
    }

    private float[] getDragViewVisualCenter(int x, int y, int xOffset, int yOffset, DragView dragView, float[] recycle) {
        float[] res;
        if (recycle == null) {
            res = new float[2];
        } else {
            res = recycle;
        }
        int left = (x + getResources().getDimensionPixelSize(R.dimen.dragViewOffsetX)) - xOffset;
        int top = (y + getResources().getDimensionPixelSize(R.dimen.dragViewOffsetY)) - yOffset;
        res[0] = ((float) dragView.getDragRegion().width() / 2) + left;
        res[1] = ((float) dragView.getDragRegion().height() / 2) + top;
        return res;
    }

    private boolean isDragWidget(DropTarget.DragObject d) {
        return (d.dragInfo instanceof LauncherAppWidgetInfo) || (d.dragInfo instanceof PendingAddWidgetInfo);
    }

    private boolean isExternalDragWidget(DropTarget.DragObject d) {
        return d.dragSource != this && isDragWidget(d);
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragOver(DropTarget.DragObject d) {
        if (!this.mInScrollArea && !this.mIsSwitchingState && this.mState != State.SMALL) {
            Rect r = new Rect();
            CellLayout layout = null;
            ItemInfo item = (ItemInfo) d.dragInfo;
            if (item.spanX < 0 || item.spanY < 0) {
                throw new RuntimeException("Improper spans found");
            }
            this.mDragViewVisualCenter = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset, d.dragView, this.mDragViewVisualCenter);
            View child = this.mDragInfo == null ? null : this.mDragInfo.cell;
            if (isSmall()) {
                if (this.mLauncher.getHotseat() != null && !isExternalDragWidget(d)) {
                    isPointInSelfOverHotseat(d.x, d.y, r);
                }
                if (layout == null) {
                    layout = findMatchingPageForDragOver(d.dragView, d.x, d.y, false);
                }
                if (layout != this.mDragTargetLayout) {
                    setCurrentDropLayout(layout);
                    setCurrentDragOverlappingLayout(layout);
                    boolean isInSpringLoadedMode = this.mState == State.SPRING_LOADED;
                    if (isInSpringLoadedMode) {
                        if (this.mLauncher.isHotseatLayout(layout)) {
                            this.mSpringLoadedDragController.cancel();
                        } else {
                            this.mSpringLoadedDragController.setAlarm(this.mDragTargetLayout);
                        }
                    }
                }
            } else {
                if (this.mLauncher.getHotseat() != null && !isDragWidget(d)) {
                    isPointInSelfOverHotseat(d.x, d.y, r);
                }
                if (layout == null) {
                    layout = getCurrentDropLayout();
                }
                if (layout != this.mDragTargetLayout) {
                    setCurrentDropLayout(layout);
                    setCurrentDragOverlappingLayout(layout);
                }
            }
            if (this.mDragTargetLayout != null) {
                if (!this.mLauncher.isHotseatLayout(this.mDragTargetLayout)) {
                    mapPointFromSelfToChild(this.mDragTargetLayout, this.mDragViewVisualCenter, null);
                }
                ItemInfo info = (ItemInfo) d.dragInfo;
                int minSpanX = item.spanX;
                int minSpanY = item.spanY;
                if (item.minSpanX > 0 && item.minSpanY > 0) {
                    minSpanX = item.minSpanX;
                    minSpanY = item.minSpanY;
                }
                this.mTargetCell = findNearestArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], minSpanX, minSpanY, this.mDragTargetLayout, this.mTargetCell);
                int reorderX = this.mTargetCell[0];
                int reorderY = this.mTargetCell[1];
                setCurrentDropOverCell(this.mTargetCell[0], this.mTargetCell[1]);
                float targetCellDistance = this.mDragTargetLayout.getDistanceFromCell(this.mDragViewVisualCenter[0], this.mDragViewVisualCenter[1], this.mTargetCell);
                View dragOverView = this.mDragTargetLayout.getChildAt(this.mTargetCell[0], this.mTargetCell[1]);
                if (getResources().getBoolean(R.bool.supportFolder)) {
                    manageFolderFeedback(info, this.mDragTargetLayout, this.mTargetCell, targetCellDistance, dragOverView);
                }
                boolean nearestDropOccupied = this.mDragTargetLayout.isNearestDropLocationOccupied((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], item.spanX, item.spanY, child, this.mTargetCell);
                if (!nearestDropOccupied) {
                    this.mDragTargetLayout.visualizeDropLocation(child, this.mDragOutline, (int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], this.mTargetCell[0], this.mTargetCell[1], item.spanX, item.spanY, false, d.dragView.getDragVisualizeOffset(), d.dragView.getDragRegion());
                } else if ((this.mDragMode == 0 || this.mDragMode == 3) && !this.mReorderAlarm.alarmPending() && (this.mLastReorderX != reorderX || this.mLastReorderY != reorderY)) {
                    ReorderAlarmListener listener = new ReorderAlarmListener(this.mDragViewVisualCenter, minSpanX, minSpanY, item.spanX, item.spanY, d.dragView, child);
                    this.mReorderAlarm.setOnAlarmListener(listener);
                    this.mReorderAlarm.setAlarm(250L);
                }
                if ((this.mDragMode == 1 || this.mDragMode == 2 || !nearestDropOccupied) && this.mDragTargetLayout != null) {
                    this.mDragTargetLayout.revertTempState();
                }
            }
        }
    }

    private void manageFolderFeedback(ItemInfo info, CellLayout targetLayout, int[] targetCell, float distance, View dragOverView) {
        boolean userFolderPending = willCreateUserFolder(info, targetLayout, targetCell, distance, false);
        LogPreview.show("userFolderPending:" + userFolderPending);
        if (this.mDragMode == 0 && userFolderPending && !this.mFolderCreationAlarm.alarmPending()) {
            this.mFolderCreationAlarm.setOnAlarmListener(new FolderCreationAlarmListener(targetLayout, targetCell[0], targetCell[1]));
            this.mFolderCreationAlarm.setAlarm(0L);
            return;
        }
        boolean willAddToFolder = willAddToExistingUserFolder(info, targetLayout, targetCell, distance);
        if (willAddToFolder && this.mDragMode == 0) {
            this.mDragOverFolderIcon = (FolderIcon) dragOverView;
            this.mDragOverFolderIcon.onDragEnter(info);
            if (targetLayout != null) {
                targetLayout.clearDragOutlines();
            }
            setDragMode(2);
            return;
        }
        if (this.mDragMode == 2 && !willAddToFolder) {
            setDragMode(0);
        }
        if (this.mDragMode == 1 && !userFolderPending) {
            setDragMode(0);
        }
    }

    class FolderCreationAlarmListener implements OnAlarmListener {
        int cellX;
        int cellY;
        CellLayout layout;

        public FolderCreationAlarmListener(CellLayout layout, int cellX, int cellY) {
            this.layout = layout;
            this.cellX = cellX;
            this.cellY = cellY;
        }

        @Override
        public void onAlarm(Alarm alarm) {
            if (mDragFolderRingAnimator != null) {
                // This shouldn't happen ever, but just in case, make sure we clean up the mess.
                mDragFolderRingAnimator.animateToNaturalState();
            }
            mDragFolderRingAnimator = new FolderIcon.FolderRingAnimator(mLauncher, null);
            mDragFolderRingAnimator.setCell(cellX, cellY);
            mDragFolderRingAnimator.setCellLayout(layout);
            mDragFolderRingAnimator.animateToAcceptState();
            layout.showFolderAccept(mDragFolderRingAnimator);
            layout.clearDragOutlines();
            setDragMode(DRAG_MODE_CREATE_FOLDER);
        }
    }

    class ReorderAlarmListener implements OnAlarmListener {
        View child;
        DragView dragView;
        float[] dragViewCenter;
        int minSpanX;
        int minSpanY;
        int spanX;
        int spanY;

        public ReorderAlarmListener(float[] dragViewCenter, int minSpanX, int minSpanY, int spanX, int spanY, DragView dragView, View child) {
            this.dragViewCenter = dragViewCenter;
            this.minSpanX = minSpanX;
            this.minSpanY = minSpanY;
            this.spanX = spanX;
            this.spanY = spanY;
            this.child = child;
            this.dragView = dragView;
        }

        @Override // com.android.launcher66.OnAlarmListener
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

    @Override // com.android.launcher66.DropTarget
    public void getHitRectRelativeToDragLayer(Rect outRect) {
        this.mLauncher.getDragLayer().getDescendantRectRelativeToSelf(this, outRect);
    }

    public boolean addExternalItemToScreen(ItemInfo dragInfo, CellLayout layout) {
        if (layout.findCellForSpan(this.mTempEstimate, dragInfo.spanX, dragInfo.spanY)) {
            onDropExternal(dragInfo.dropPos, dragInfo, layout, false);
            return true;
        }
        this.mLauncher.showOutOfSpaceMessage(this.mLauncher.isHotseatLayout(layout));
        return false;
    }

    private void onDropExternal(int[] touchXY, Object dragInfo, CellLayout cellLayout, boolean insertAtFirst) {
        onDropExternal(touchXY, dragInfo, cellLayout, insertAtFirst, null);
    }

    private void onDropExternal(int[] touchXY, Object dragInfo, CellLayout cellLayout, boolean insertAtFirst, DropTarget.DragObject d) {
        View view;
        View finalView;
        Runnable exitSpringLoadedRunnable = new Runnable() { // from class: com.android.launcher66.Workspace.11
            @Override // java.lang.Runnable
            public void run() {
                Workspace.this.mLauncher.exitSpringLoadedDragModeDelayed(true, false, null);
            }
        };
        ItemInfo info = (ItemInfo) dragInfo;
        int spanX = info.spanX;
        int spanY = info.spanY;
        if (this.mDragInfo != null) {
            spanX = this.mDragInfo.spanX;
            spanY = this.mDragInfo.spanY;
        }
        final long container = mLauncher.isHotseatLayout(cellLayout) ?
                LauncherSettings.Favorites.CONTAINER_HOTSEAT :
                LauncherSettings.Favorites.CONTAINER_DESKTOP;
        final long screenId = getIdForScreen(cellLayout);
        if (!this.mLauncher.isHotseatLayout(cellLayout) && screenId != getScreenIdForPageIndex(this.mCurrentPage) && this.mState != State.SPRING_LOADED) {
            snapToScreenId(screenId, null);
        }
        if (info instanceof PendingAddItemInfo) {
            final PendingAddItemInfo pendingInfo = (PendingAddItemInfo) dragInfo;
            boolean findNearestVacantCell = true;
            if (pendingInfo.itemType == 1) {
                this.mTargetCell = findNearestArea(touchXY[0], touchXY[1], spanX, spanY, cellLayout, this.mTargetCell);
                float distance = cellLayout.getDistanceFromCell(this.mDragViewVisualCenter[0], this.mDragViewVisualCenter[1], this.mTargetCell);
                if (willCreateUserFolder((ItemInfo) d.dragInfo, cellLayout, this.mTargetCell, distance, true) || willAddToExistingUserFolder((ItemInfo) d.dragInfo, cellLayout, this.mTargetCell, distance)) {
                    findNearestVacantCell = false;
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
                this.mTargetCell = cellLayout.createArea((int) this.mDragViewVisualCenter[0], (int) this.mDragViewVisualCenter[1], minSpanX, minSpanY, info.spanX, info.spanY, null, this.mTargetCell, resultSpan, 2);
                if (resultSpan[0] != item.spanX || resultSpan[1] != item.spanY) {
                    updateWidgetSize = true;
                }
                item.spanX = resultSpan[0];
                item.spanY = resultSpan[1];
            }

            Runnable onAnimationCompleteRunnable = () -> {
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
            };
            if (pendingInfo.itemType == 4) {
                finalView = ((PendingAddWidgetInfo) pendingInfo).boundWidget;
            } else {
                finalView = null;
            }
            if ((finalView instanceof AppWidgetHostView) && updateWidgetSize) {
                AppWidgetHostView awhv = (AppWidgetHostView) finalView;
                AppWidgetResizeFrame.updateWidgetSizeRanges(awhv, this.mLauncher, item.spanX, item.spanY);
            }
            int animationStyle = 0;
            if (pendingInfo.itemType == 4 && ((PendingAddWidgetInfo) pendingInfo).info.configure != null) {
                animationStyle = 1;
            }
            animateWidgetDrop(info, cellLayout, d.dragView, onAnimationCompleteRunnable, animationStyle, finalView, true);
            return;
        }
        switch (info.itemType) {
            case LauncherSettings.Favorites.ITEM_TYPE_APPLICATION:
            case LauncherSettings.Favorites.ITEM_TYPE_SHORTCUT:
                if (info.container == NO_ID && info instanceof AppInfo) {
                    // Came from all apps -- make a copy
                    info = new ShortcutInfo((AppInfo) info);
                }
                view = mLauncher.createShortcut(R.layout.application, cellLayout,
                        (ShortcutInfo) info);
                break;
            case LauncherSettings.Favorites.ITEM_TYPE_FOLDER:
                view = FolderIcon.fromXml(R.layout.folder_icon, mLauncher, cellLayout,
                        (FolderInfo) info, mIconCache);
                break;
            default:
                throw new IllegalStateException("Unknown item type: " + info.itemType);
        }
        if (touchXY != null) {
            this.mTargetCell = findNearestArea(touchXY[0], touchXY[1], spanX, spanY, cellLayout, this.mTargetCell);
            float distance2 = cellLayout.getDistanceFromCell(this.mDragViewVisualCenter[0], this.mDragViewVisualCenter[1], this.mTargetCell);
            d.postAnimationRunnable = exitSpringLoadedRunnable;
            if (createUserFolderIfNecessary(view, container, cellLayout, this.mTargetCell, distance2, true, d.dragView, d.postAnimationRunnable) || addToExistingFolderIfNecessary(view, cellLayout, this.mTargetCell, distance2, d, true)) {
                return;
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
        addInScreen(view, container, screenId, this.mTargetCell[0], this.mTargetCell[1], info.spanX, info.spanY, insertAtFirst);
        cellLayout.onDropChild(view);
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) view.getLayoutParams();
        cellLayout.getShortcutsAndWidgets().measureChild(view);
        LauncherModel.addOrMoveItemInDatabase(this.mLauncher, info, container, screenId, lp.cellX, lp.cellY);
        if (d.dragView != null) {
            setFinalTransitionTransform(cellLayout);
            this.mLauncher.getDragLayer().animateViewIntoPosition(d.dragView, view, exitSpringLoadedRunnable);
            resetTransitionTransform(cellLayout);
        }
    }

    public Bitmap createWidgetBitmap(ItemInfo widgetInfo, View layout) {
        int[] unScaledSize = this.mLauncher.getWorkspace().estimateItemSize(widgetInfo.spanX, widgetInfo.spanY, widgetInfo, false);
        int visibility = layout.getVisibility();
        layout.setVisibility(android.view.View.VISIBLE);
        int width = View.MeasureSpec.makeMeasureSpec(unScaledSize[0], MeasureSpec.EXACTLY);
        int height = View.MeasureSpec.makeMeasureSpec(unScaledSize[1], MeasureSpec.EXACTLY);
        Bitmap b = Bitmap.createBitmap(unScaledSize[0], unScaledSize[1], Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        layout.measure(width, height);
        layout.layout(0, 0, unScaledSize[0], unScaledSize[1]);
        layout.draw(c);
        c.setBitmap(null);
        layout.setVisibility(visibility);
        return b;
    }

    private void getFinalPositionForDropAnimation(int[] loc, float[] scaleXY, DragView dragView, CellLayout layout, ItemInfo info, int[] targetCell, boolean external, boolean scale) {
        float dragViewScaleX;
        float dragViewScaleY;
        int spanX = info.spanX;
        int spanY = info.spanY;
        Rect r = estimateItemPosition(layout, info, targetCell[0], targetCell[1], spanX, spanY);
        loc[0] = r.left;
        loc[1] = r.top;
        setFinalTransitionTransform(layout);
        float cellLayoutScale = this.mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(layout, loc, true);
        resetTransitionTransform(layout);
        if (scale) {
            dragViewScaleX = (1.0f * r.width()) / dragView.getMeasuredWidth();
            dragViewScaleY = (1.0f * r.height()) / dragView.getMeasuredHeight();
        } else {
            dragViewScaleX = 1.0f;
            dragViewScaleY = 1.0f;
        }
        loc[0] = (int) (loc[0] - ((dragView.getMeasuredWidth() - (r.width() * cellLayoutScale)) / 2.0f));
        loc[1] = (int) (loc[1] - ((dragView.getMeasuredHeight() - (r.height() * cellLayoutScale)) / 2.0f));
        scaleXY[0] = dragViewScaleX * cellLayoutScale;
        scaleXY[1] = dragViewScaleY * cellLayoutScale;
    }

    public void animateWidgetDrop(ItemInfo info, CellLayout cellLayout, DragView dragView, final Runnable onCompleteRunnable, int animationType, final View finalView, boolean external) {
        int endStyle;
        Rect from = new Rect();
        this.mLauncher.getDragLayer().getViewRectRelativeToSelf(dragView, from);
        int[] finalPos = new int[2];
        float[] scaleXY = new float[2];
        boolean scalePreview = !(info instanceof PendingAddShortcutInfo);
        getFinalPositionForDropAnimation(finalPos, scaleXY, dragView, cellLayout, info, this.mTargetCell, external, scalePreview);
        Resources res = this.mLauncher.getResources();
        int duration = res.getInteger(R.integer.config_dropAnimMaxDuration) - 200;
        if ((finalView instanceof AppWidgetHostView) && external) {
            Log.d(TAG, "6557954 Animate widget drop, final view is appWidgetHostView");
            this.mLauncher.getDragLayer().removeView(finalView);
        }
        if ((animationType == 2 || external) && finalView != null) {
            Bitmap crossFadeBitmap = createWidgetBitmap(info, finalView);
            dragView.setCrossFadeBitmap(crossFadeBitmap);
            dragView.crossFade((int) (duration * 0.8f));
        } else if (info.itemType == 4 && external) {
            float min = Math.min(scaleXY[0], scaleXY[1]);
            scaleXY[1] = min;
            scaleXY[0] = min;
        }
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        if (animationType == 4) {
            this.mLauncher.getDragLayer().animateViewIntoPosition(dragView, finalPos, 0.0f, 0.1f, 0.1f, 0, onCompleteRunnable, duration);
            return;
        }
        if (animationType == 1) {
            endStyle = 2;
        } else {
            endStyle = 0;
        }
        Runnable onComplete = () -> {
            if (finalView != null) {
                finalView.setVisibility(View.VISIBLE);
            }
            if (onCompleteRunnable != null) {
                onCompleteRunnable.run();
            }
        };
        dragLayer.animateViewIntoPosition(dragView, from.left, from.top, finalPos[0], finalPos[1], 1.0f, 1.0f, 1.0f, scaleXY[0], scaleXY[1], onComplete, endStyle, duration, this);
    }

    public void setFinalTransitionTransform(CellLayout layout) {
        if (isSwitchingState()) {
            this.mCurrentScale = getScaleX();
            setScaleX(this.mNewScale);
            setScaleY(this.mNewScale);
        }
    }

    public void resetTransitionTransform(CellLayout layout) {
        if (isSwitchingState()) {
            setScaleX(this.mCurrentScale);
            setScaleY(this.mCurrentScale);
        }
    }

    public CellLayout getCurrentDropLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    public CellLayout.CellInfo getDragInfo() {
        return this.mDragInfo;
    }

    public int getRestorePage() {
        return getNextPage() - numCustomPages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] findNearestArea(int pixelX, int pixelY, int spanX, int spanY, CellLayout layout, int[] recycle) {
        return layout.findNearestArea(pixelX, pixelY, spanX, spanY, recycle);
    }

    void setup(DragController dragController) {
        this.mSpringLoadedDragController = new SpringLoadedDragController(this.mLauncher);
        this.mDragController = dragController;
        updateChildrenLayersEnabled(false);
        setWallpaperDimension();
    }

    @Override // com.android.launcher66.DragSource
    public void onDropCompleted(final View target, final DropTarget.DragObject d, final boolean isFlingToDelete, final boolean success) {
        if (this.mDeferDropAfterUninstall) {
            this.mDeferredAction = new Runnable() { // from class: com.android.launcher66.Workspace.14
                @Override // java.lang.Runnable
                public void run() {
                    Workspace.this.onDropCompleted(target, d, isFlingToDelete, success);
                    Workspace.this.mDeferredAction = null;
                }
            };
            return;
        }
        boolean beingCalledAfterUninstall = this.mDeferredAction != null;
        if (success && (!beingCalledAfterUninstall || this.mUninstallSuccessful)) {
            if (target != this && this.mDragInfo != null) {
                CellLayout parentCell = getParentCellLayoutForView(this.mDragInfo.cell);
                if (parentCell != null) {
                    parentCell.removeView(this.mDragInfo.cell);
                }
                if (this.mDragInfo.cell instanceof DropTarget) {
                    this.mDragController.removeDropTarget((DropTarget) this.mDragInfo.cell);
                }
                stripEmptyScreens();
            }
        } else if (this.mDragInfo != null) {
            CellLayout cellLayout = getScreenWithId(this.mDragInfo.screenId);
            cellLayout.onDropChild(this.mDragInfo.cell);
        }
        if ((d.cancelled || (beingCalledAfterUninstall && !this.mUninstallSuccessful)) && this.mDragInfo.cell != null) {
            this.mDragInfo.cell.setVisibility(android.view.View.VISIBLE);
        }
        Runnable onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.Workspace.15
            @Override // java.lang.Runnable
            public void run() {
                Workspace.this.mLauncher.exitSpringLoadedDragModeDelayed(true, true, null);
            }
        };
        onCompleteRunnable.run();
        this.mDragOutline = null;
        this.mDragInfo = null;
    }

    public void deferCompleteDropAfterUninstallActivity() {
        this.mDeferDropAfterUninstall = true;
    }

    public void onUninstallActivityReturned(boolean success) {
        this.mDeferDropAfterUninstall = false;
        this.mUninstallSuccessful = success;
        if (this.mDeferredAction != null) {
            this.mDeferredAction.run();
        }
    }

    void updateItemLocationsInDatabase(CellLayout cl) {
        int count = cl.getShortcutsAndWidgets().getChildCount();
        long screenId = getIdForScreen(cl);
        int container = -100;
        if (this.mLauncher.isHotseatLayout(cl)) {
            screenId = -1;
            container = -101;
        }
        for (int i = 0; i < count; i++) {
            View v = cl.getShortcutsAndWidgets().getChildAt(i);
            ItemInfo info = (ItemInfo) v.getTag();
            if (info != null && info.requiresDbUpdate) {
                info.requiresDbUpdate = false;
                LauncherModel.modifyItemInDatabase(this.mLauncher, info, container, screenId, info.cellX, info.cellY, info.spanX, info.spanY);
            }
        }
    }

    ArrayList<ComponentName> getUniqueComponents(boolean stripDuplicates, ArrayList<ComponentName> duplicates) {
        ArrayList<ComponentName> uniqueIntents = new ArrayList<>();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            getUniqueIntents(cl, uniqueIntents, duplicates, false);
        }
        return uniqueIntents;
    }

    void getUniqueIntents(CellLayout cl, ArrayList<ComponentName> uniqueIntents, ArrayList<ComponentName> duplicates, boolean stripDuplicates) {
        int count = cl.getShortcutsAndWidgets().getChildCount();
        ArrayList<View> children = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            children.add(cl.getShortcutsAndWidgets().getChildAt(i));
        }
        for (int i2 = 0; i2 < count; i2++) {
            View v = children.get(i2);
            Object so = v.getTag();
            if (so instanceof ItemInfo) {
                ItemInfo info = (ItemInfo) so;
                if (info instanceof ShortcutInfo) {
                    ShortcutInfo si = (ShortcutInfo) info;
                    ComponentName cn2 = si.intent.getComponent();
                    Uri dataUri = si.intent.getData();
                    if (dataUri == null || dataUri.equals(Uri.EMPTY)) {
                        if (!uniqueIntents.contains(cn2)) {
                            uniqueIntents.add(cn2);
                        } else {
                            if (stripDuplicates) {
                                cl.removeViewInLayout(v);
                                LauncherModel.deleteItemFromDatabase(this.mLauncher, si);
                            }
                            if (duplicates != null) {
                                duplicates.add(cn2);
                            }
                        }
                    }
                }
                if (v instanceof FolderIcon) {
                    FolderIcon fi = (FolderIcon) v;
                    ArrayList<View> items = fi.getFolder().getItemsInReadingOrder();
                    for (int j = 0; j < items.size(); j++) {
                        if (items.get(j).getTag() instanceof ShortcutInfo) {
                            ShortcutInfo si2 = (ShortcutInfo) items.get(j).getTag();
                            ComponentName cn3 = si2.intent.getComponent();
                            Uri dataUri2 = si2.intent.getData();
                            if (dataUri2 == null || dataUri2.equals(Uri.EMPTY)) {
                                if (!uniqueIntents.contains(cn3)) {
                                    uniqueIntents.add(cn3);
                                } else {
                                    if (stripDuplicates) {
                                        fi.getFolderInfo().remove(si2);
                                        LauncherModel.deleteItemFromDatabase(this.mLauncher, si2);
                                    }
                                    if (duplicates != null) {
                                        duplicates.add(cn3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void saveWorkspaceToDb() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            CellLayout cl = (CellLayout) getChildAt(i);
            saveWorkspaceScreenToDb(cl);
        }
    }

    void saveWorkspaceScreenToDb(CellLayout cl) {
        int count = cl.getShortcutsAndWidgets().getChildCount();
        long screenId = getIdForScreen(cl);
        int container = LauncherSettings.Favorites.CONTAINER_DESKTOP;
        if (this.mLauncher.isHotseatLayout(cl)) {
            screenId = -1;
            container = LauncherSettings.Favorites.CONTAINER_HOTSEAT;
        }
        for (int i = 0; i < count; i++) {
            View v = cl.getShortcutsAndWidgets().getChildAt(i);
            ItemInfo info = null;
            Object so = v.getTag();
            if (so instanceof ItemInfo) {
                info = (ItemInfo) so;
            }
            if (info != null) {
                int cellX = info.cellX;
                int cellY = info.cellY;
                LauncherModel.addItemToDatabase(this.mLauncher, info, container, screenId, cellX, cellY, false);
            }
            if (v instanceof FolderIcon) {
                FolderIcon fi = (FolderIcon) v;
                fi.getFolder().addItemLocationsInDatabase();
            }
        }
    }

    @Override // com.android.launcher66.DragSource
    public boolean supportsFlingToDelete() {
        return true;
    }

    @Override // com.android.launcher66.DropTarget
    public void onFlingToDelete(DropTarget.DragObject d, int x, int y, PointF vec) {
    }

    @Override // com.android.launcher66.DragSource
    public void onFlingToDeleteCompleted() {
    }

    @Override // com.android.launcher66.DropTarget
    public boolean isDropEnabled() {
        return true;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Launcher.setScreen(this.mCurrentPage);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        this.mSavedStates = container;
    }

    public void restoreInstanceStateForChild(int child) {
        if (this.mSavedStates != null) {
            this.mRestoredPages.add(Integer.valueOf(child));
            CellLayout cl = (CellLayout) getChildAt(child);
            cl.restoreInstanceState(this.mSavedStates);
        }
    }

    public void restoreInstanceStateForRemainingPages() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            if (!this.mRestoredPages.contains(Integer.valueOf(i))) {
                restoreInstanceStateForChild(i);
            }
        }
        this.mRestoredPages.clear();
        this.mSavedStates = null;
    }

    @Override // com.android.launcher66.PagedView, com.android.launcher66.DragScroller
    public void scrollLeft() {
        if (!isSmall() && !this.mIsSwitchingState) {
            super.scrollLeft();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    @Override // com.android.launcher66.PagedView, com.android.launcher66.DragScroller
    public void scrollRight() {
        if (!isSmall() && !this.mIsSwitchingState) {
            super.scrollRight();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    @Override // com.android.launcher66.DragScroller
    public boolean onEnterScrollArea(int x, int y, int direction) {
        boolean isPortrait = !LauncherAppState.isScreenLandscape(getContext());
        if (this.mLauncher.getHotseat() != null && isPortrait) {
            Rect r = new Rect();
            this.mLauncher.getHotseat().getHitRect(r);
            if (r.contains(x, y)) {
                return false;
            }
        }
        boolean result = false;
        if (!isSmall() && !this.mIsSwitchingState && getOpenFolder() == null) {
            this.mInScrollArea = true;
            int page = getNextPage() + (direction == DragController.SCROLL_LEFT ? -1 : 1);
            setCurrentDropLayout(null);
            if (page >= 0 && page < getChildCount()) {
                if (getScreenIdForPageIndex(page) == CUSTOM_CONTENT_SCREEN_ID) {
                    return false;
                }
                CellLayout layout = (CellLayout) getChildAt(page);
                setCurrentDragOverlappingLayout(layout);
                invalidate();
                result = true;
            }
        }
        return result;
    }

    @Override // com.android.launcher66.DragScroller
    public boolean onExitScrollArea() {
        if (!this.mInScrollArea) {
            return false;
        }
        invalidate();
        CellLayout layout = getCurrentDropLayout();
        setCurrentDropLayout(layout);
        setCurrentDragOverlappingLayout(layout);
        this.mInScrollArea = false;
        return true;
    }

    private void onResetScrollArea() {
        setCurrentDragOverlappingLayout(null);
        this.mInScrollArea = false;
    }

    CellLayout getParentCellLayoutForView(View v) {
        ArrayList<CellLayout> layouts = getWorkspaceAndHotseatCellLayouts();
        Iterator<CellLayout> it = layouts.iterator();
        while (it.hasNext()) {
            CellLayout layout = it.next();
            if (layout.getShortcutsAndWidgets().indexOfChild(v) > -1) {
                return layout;
            }
        }
        return null;
    }

    ArrayList<CellLayout> getWorkspaceAndHotseatCellLayouts() {
        ArrayList<CellLayout> layouts = new ArrayList<>();
        int screenCount = getChildCount();
        for (int screen = 0; screen < screenCount; screen++) {
            layouts.add((CellLayout) getChildAt(screen));
        }
        this.mLauncher.getHotseat();
        return layouts;
    }

    ArrayList<ShortcutAndWidgetContainer> getAllShortcutAndWidgetContainers() {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = new ArrayList<>();
        int screenCount = getChildCount();
        for (int screen = 0; screen < screenCount; screen++) {
            childrenLayouts.add(((CellLayout) getChildAt(screen)).getShortcutsAndWidgets());
        }
        this.mLauncher.getHotseat();
        return childrenLayouts;
    }

    public Folder getFolderForTag(Object tag) {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = getAllShortcutAndWidgetContainers();
        Iterator<ShortcutAndWidgetContainer> it = childrenLayouts.iterator();
        while (it.hasNext()) {
            ShortcutAndWidgetContainer layout = it.next();
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
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = getAllShortcutAndWidgetContainers();
        Iterator<ShortcutAndWidgetContainer> it = childrenLayouts.iterator();
        while (it.hasNext()) {
            ShortcutAndWidgetContainer layout = it.next();
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
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = getAllShortcutAndWidgetContainers();
        Iterator<ShortcutAndWidgetContainer> it = childrenLayouts.iterator();
        while (it.hasNext()) {
            ShortcutAndWidgetContainer layout = it.next();
            int childCount = layout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                KeyEvent.Callback childAt = layout.getChildAt(j);
                if (childAt instanceof DropTarget) {
                    this.mDragController.removeDropTarget((DropTarget) childAt);
                }
            }
        }
    }

    void removeItemsByPackageName(ArrayList<String> packages) {
        final HashSet<String> packageNames = new HashSet<>();
        packageNames.addAll(packages);
        HashSet<ItemInfo> infos = new HashSet<>();
        final HashSet<ComponentName> cns = new HashSet<>();
        ArrayList<CellLayout> cellLayouts = getWorkspaceAndHotseatCellLayouts();
        Iterator<CellLayout> it = cellLayouts.iterator();
        while (it.hasNext()) {
            CellLayout layoutParent = it.next();
            ViewGroup layout = layoutParent.getShortcutsAndWidgets();
            int childCount = layout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = layout.getChildAt(i);
                Object object = view.getTag();
                if (object instanceof ItemInfo) {
                    infos.add((ItemInfo) object);
                }
            }
        }
        LauncherModel.ItemInfoFilter filter = new LauncherModel.ItemInfoFilter() { // from class: com.android.launcher66.Workspace.16
            @Override // com.android.launcher66.LauncherModel.ItemInfoFilter
            public boolean filterItem(ItemInfo parent, ItemInfo info, ComponentName cn2) {
                if (!packageNames.contains(cn2.getPackageName())) {
                    return false;
                }
                cns.add(cn2);
                return true;
            }
        };
        LauncherModel.filterItemInfos(infos, filter);
        removeItemsByComponentName(cns);
    }

    void removeItemsByApplicationInfo(ArrayList<AppInfo> appInfos) {
        HashSet<ComponentName> cns = new HashSet<>();
        Iterator<AppInfo> it = appInfos.iterator();
        while (it.hasNext()) {
            AppInfo info = it.next();
            cns.add(info.componentName);
        }
        removeItemsByComponentName(cns);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void removeItemsByComponentName(final HashSet<ComponentName> componentNames) {
        ArrayList<CellLayout> cellLayouts = getWorkspaceAndHotseatCellLayouts();
        Iterator<CellLayout> it = cellLayouts.iterator();
        while (it.hasNext()) {
            CellLayout next = it.next();
            ShortcutAndWidgetContainer layout = next.getShortcutsAndWidgets();
            final HashMap<ItemInfo, View> children = new HashMap<>();
            for (int j = 0; j < layout.getChildCount(); j++) {
                View view = layout.getChildAt(j);
                Object object = view.getTag();
                if (object instanceof ItemInfo) {
                    children.put((ItemInfo) object, view);
                }
            }
            final ArrayList<View> childrenToRemove = new ArrayList<>();
            final HashMap<FolderInfo, ArrayList<ShortcutInfo>> folderAppsToRemove = new HashMap<>();
            LauncherModel.ItemInfoFilter filter = new LauncherModel.ItemInfoFilter() { // from class: com.android.launcher66.Workspace.17
                @Override // com.android.launcher66.LauncherModel.ItemInfoFilter
                public boolean filterItem(ItemInfo parent, ItemInfo info, ComponentName cn2) {
                    ArrayList<ShortcutInfo> appsToRemove;
                    if (parent instanceof FolderInfo) {
                        if (componentNames.contains(cn2)) {
                            FolderInfo folder = (FolderInfo) parent;
                            if (folderAppsToRemove.containsKey(folder)) {
                                appsToRemove = (ArrayList) folderAppsToRemove.get(folder);
                            } else {
                                appsToRemove = new ArrayList<>();
                                folderAppsToRemove.put(folder, appsToRemove);
                            }
                            appsToRemove.add((ShortcutInfo) info);
                            return true;
                        }
                    } else if (componentNames.contains(cn2)) {
                        childrenToRemove.add((View) children.get(info));
                        return true;
                    }
                    return false;
                }
            };
            LauncherModel.filterItemInfos(children.keySet(), filter);
            for (FolderInfo folder : folderAppsToRemove.keySet()) {
                ArrayList<ShortcutInfo> appsToRemove = folderAppsToRemove.get(folder);
                Iterator<ShortcutInfo> it2 = appsToRemove.iterator();
                while (it2.hasNext()) {
                    ShortcutInfo info = it2.next();
                    folder.remove(info);
                }
            }
            Iterator<View> it3 = childrenToRemove.iterator();
            while (it3.hasNext()) {
                View next2 = it3.next();
                next.removeViewInLayout(next2);
                if (next2 instanceof DropTarget) {
                    this.mDragController.removeDropTarget((DropTarget) next2);
                }
            }
            if (childrenToRemove.size() > 0) {
                layout.requestLayout();
                layout.invalidate();
            }
        }
        stripEmptyScreens();
    }

    void updateShortcuts(ArrayList<AppInfo> apps) {
        ArrayList<ShortcutAndWidgetContainer> childrenLayouts = getAllShortcutAndWidgetContainers();
        Iterator<ShortcutAndWidgetContainer> it = childrenLayouts.iterator();
        while (it.hasNext()) {
            ShortcutAndWidgetContainer layout = it.next();
            int childCount = layout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                View view = layout.getChildAt(j);
                Object tag = view.getTag();
                if ((tag instanceof ItemInfo) && LauncherModel.isShortcutInfoUpdateable((ItemInfo) tag)) {
                    ShortcutInfo info = (ShortcutInfo) tag;
                    Intent intent = info.intent;
                    ComponentName name = intent.getComponent();
                    int appCount = apps.size();
                    for (int k = 0; k < appCount; k++) {
                        AppInfo app = apps.get(k);
                        if (app.componentName.equals(name)) {
                            BubbleTextView shortcut = (BubbleTextView) view;
                            info.updateIcon(this.mIconCache);
                            info.title = app.title.toString();
                            shortcut.applyFromShortcutInfo(info, this.mIconCache);
                        }
                    }
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
        moveToScreen(this.mDefaultPage, animate);
    }

    void moveToCustomContentScreen(boolean animate) {
        LogPreview.show("moveToCustomContentScreen");
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

    void moveToCustomScreen(boolean animate, int screenId) {
        LogPreview.show("moveToCustomScreen");
        if (hasCustomContent()) {
            int ccIndex = getPageIndexForScreenId(screenId);
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

    @Override // com.android.launcher66.PagedView
    protected PageIndicator.PageMarkerResources getPageIndicatorMarker(int pageIndex) {
        long screenId = getScreenIdForPageIndex(pageIndex);
        if (screenId == EXTRA_EMPTY_SCREEN_ID) {
            int count = this.mScreenOrder.size() - numCustomPages();
            if (count > 1) {
                if (LauncherApplication.sApp.getResources().getBoolean(R.bool.app_indicator)) {
                    return new PageIndicator.PageMarkerResources(ResValue.getInstance().indicator_lightbar, ResValue.getInstance().indicator_normalbar);
                }
                return new PageIndicator.PageMarkerResources(ResValue.getInstance().ic_pageindicator_current, R.drawable.ic_pageindicator_add);
            }
        }
        return super.getPageIndicatorMarker(pageIndex);
    }

    @Override // com.android.launcher66.PagedView
    public void syncPages() {
    }

    @Override // com.android.launcher66.PagedView
    public void syncPageItems(int page, boolean immediate) {
    }

    @Override // com.android.launcher66.PagedView
    protected String getPageIndicatorDescription() {
        String settings = getResources().getString(R.string.settings_button_text);
        return getCurrentPageDescription() + ", " + settings;
    }

    @Override // com.android.launcher66.PagedView
    protected String getCurrentPageDescription() {
        int page = (mNextPage != INVALID_PAGE) ? mNextPage : mCurrentPage;
        int delta = numCustomPages();
        if (hasCustomContent() && getNextPage() == 0) {
            return mCustomContentDescription;
        }
        return String.format(getContext().getString(R.string.workspace_scroll_format),
                page + 1 - delta, getChildCount() - delta);
    }

    @Override // com.android.launcher66.DropTarget
    public void getLocationInDragLayer(int[] loc) {
        mLauncher.getDragLayer().getLocationInDragLayer(this, loc);
    }
}