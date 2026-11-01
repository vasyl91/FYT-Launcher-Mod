package com.android.launcher66;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.launcher66.settings.BottomBarDimensions;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.SettingsActivity;
import com.android.recycler.AppListAdapter;
import com.android.recycler.AppListBean;
import com.android.recycler.AppMultiple;
import com.android.recycler.LeftAppListAdapter;
import com.android.recycler.LeftAppMultiple;
import com.android.recycler.SimpleDividerDecoration;
import com.syu.util.FytPackage;
import com.syu.util.Utils;
import com.syu.util.WindowUtil;
import org.litepal.LitePal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import share.Config;

/**
 * The bottom and the left app bar: reading their rows from the database once the app list is
 * bound, building the adapters, the snapshots that show the last bars at once after a start,
 * the icons, the item decorations, and keeping them up to date when apps are added, updated or
 * removed. Split out of Launcher, which keeps the entry points other classes call.
 */
final class LauncherAppBars {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherAppBars(Launcher launcher) {
        mLauncher = launcher;
    }

    /** Guards the check-and-insert of the extra bottom rows; see ensureBottomRows(). */
    private static final Object BOTTOM_ROWS_LOCK = new Object();

    static final long POST_RESUME_APP_DATA_REFRESH_THROTTLE_MS = 1200L;

    AppListAdapter mAppListAdapter;

    List<AppListBean> mAppListData;

    RecyclerView mRecyclerView;

    LeftAppListAdapter mLeftAppListAdapter;

    List<AppListBean> mLeftAppListData;

    /*
     * Bar snapshots: the bottom and left bars as they were last shown, drawn at start while the
     * app list is still loading. See prefetchBarSnapshots().
     */
    /** True while setupRecyclerView()/setupLeftRecyclerView() run to show a snapshot. */
    boolean mApplyingBarSnapshot;

    BarSnapshotStore.Snapshot mBottomBarSnapshot;

    List<AppMultiple> mBottomBarSnapshotRows;

    BarSnapshotStore.Snapshot mLeftBarSnapshot;

    List<LeftAppMultiple> mLeftBarSnapshotRows;

    boolean mLeftBarSnapshotSaved;

    long mSavedLeftBarSnapshotSignature;

    /**
     * Snapshots read but not on screen yet: the bars' recycler views only exist once the workspace
     * page holding them has been bound (createUserPage), which is later than the read. At 22:27 the
     * read was done at 19.9 s, the views appeared at 21.4 s.
     */
    BarSnapshotStore.Snapshot mPendingBottomSnapshot;

    List<AppMultiple> mPendingBottomSnapshotRows;

    BarSnapshotStore.Snapshot mPendingLeftSnapshot;

    List<LeftAppMultiple> mPendingLeftSnapshotRows;

    int mBarSnapshotAttempts;

    long mBarSnapshotReadAtMs;

    static final long BAR_SNAPSHOT_RETRY_MS = 50L;

    static final int BAR_SNAPSHOT_MAX_ATTEMPTS = 200;

// 10 s
    final Runnable mApplyPendingBarSnapshots = this::applyPendingBarSnapshots;

    final AtomicBoolean atomicInitAppData = new AtomicBoolean(false);

    Handler appDataHandler = new Handler(Looper.getMainLooper());

    Runnable pendingAction;

    static final long APP_DATA_DELAY = 1500;

    static final long APP_DATA_FAST_DELAY = 120;

    static final int MAX_INIT_RETRIES = 10;

    /** Last resort if bindAllApplications() never arrives; see initAppData(). */
    static final long ALL_APPS_BIND_BACKSTOP_MS = 6000L;

    /** Bounded re-checks, so a genuinely stuck loader still ends in a usable home. */
    static final int MAX_ALL_APPS_BACKSTOP_CHECKS = 10;

    boolean mAwaitingAllAppsBind = false;

    int mAllAppsBackstopChecks = 0;

    int mInitRetryCount = 0;

    boolean mIsInitializingAppData = false;

    boolean mPostResumeAppDataRefreshPending = false;

    boolean mPostResumeAppDataDirty = true;

    long mLastPostResumeAppDataRefreshMs = 0L;

    final Map<String, Bitmap> mAppIconBitmapCache = new HashMap<>();

    boolean mLeftRecyclerLayoutPending = false;

    long mLastAppListSourceSignature = Long.MIN_VALUE;

    long mLastLeftAppListSourceSignature = Long.MIN_VALUE;

    /** Slots the left bar has room for; -1 until first asked, then kept up to date by its layout manager. */
    int mLeftCapacity = -1;

    /**
     * Slots the left bar shows: what its height has room for, as the layout manager last worked it
     * out. Before the first measure of a run it is the value stored for this orientation.
     */
    int leftCapacity() {
        if (mLeftCapacity < 0) {
            mLeftCapacity = Launcher.EvenVerticalLayoutManager.loadCapacity(
                    mLauncher.getApplicationContext(),
                    mLauncher.orientation == Configuration.ORIENTATION_PORTRAIT);
        }
        return mLeftCapacity;
    }

    Launcher.EvenVerticalLayoutManager newLeftLayoutManager() {
        Launcher.EvenVerticalLayoutManager layoutManager =
                new Launcher.EvenVerticalLayoutManager(mLauncher.getApplicationContext(), leftCapacity());
        layoutManager.setCapacityListener(this::onLeftCapacityChanged);
        return layoutManager;
    }

    /**
     * The left bar's room changed (a turn of the screen, a lower or higher bottom bar): the list is
     * built again so that it has as many apps as fit now, from the apps the database remembers.
     */
    void onLeftCapacityChanged(int capacity) {
        if (capacity == mLeftCapacity) {
            return;
        }
        Log.d(Launcher.TAG, "Left bar capacity " + mLeftCapacity + " -> " + capacity);
        mLeftCapacity = capacity;
        mLastLeftAppListSourceSignature = Long.MIN_VALUE;
        if (AllAppsList.data == null || AllAppsList.data.isEmpty()) {
            return; // the first real build is still to come and will use the new capacity
        }
        refreshLeftBar(null);
    }

    /**
     * Slots the bottom bar shows with these settings: what fits at the icon size, never fewer than
     * the bar showed before. Pure, so it can be asked before anything is measured.
     */
    int bottomCapacity(boolean currentUserLayout, boolean currentWidgetBar) {
        return BarCapacity.bottomCapacity(mLauncher.mPrefs, mLauncher.orientation,
                currentUserLayout, currentWidgetBar);
    }

    boolean shouldUseLeftRecycler() {
        SharedPreferences prefs = mLauncher.mPrefs != null
                ? mLauncher.mPrefs
                : PreferenceManager.getDefaultSharedPreferences(mLauncher);
        boolean currentUserLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean currentLeftBar = prefs.getBoolean(Keys.LEFT_BAR, false);
        return !currentUserLayout || currentLeftBar;
    }

    void refreshRecyclerDecorationsAfterLayout(RecyclerView recyclerView) {
        if (recyclerView == null) return;
        recyclerView.invalidateItemDecorations();
        recyclerView.requestLayout();
        recyclerView.post(() -> {
            recyclerView.invalidateItemDecorations();
            recyclerView.requestLayout();
        });
        recyclerView.postDelayed(() -> {
            recyclerView.invalidateItemDecorations();
            recyclerView.requestLayout();
        }, HomeLayoutRecovery.HOME_LAYOUT_HEALTH_RETRY_MS);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        recyclerView.invalidateItemDecorations();
                    }
                });
    }

    void clearRecyclerDecorations(RecyclerView recyclerView) {
        if (recyclerView == null) return;
        for (int i = recyclerView.getItemDecorationCount() - 1; i >= 0; i--) {
            recyclerView.removeItemDecorationAt(i);
        }
        recyclerView.setTag(null);
    }

    /**
     * Makes sure mRecyclerView and the other views of the inline bottom bar carry the dynamic bar
     * height instead of their XML layout_constraintDimensionRatio / layout_constraintHeight_percent.
     *
     * Workspace owns the per-view rules (it inflates the bar and also sizes the auto-hide overlay
     * from the same height); this only re-applies them whenever the recycler is (re)bound. The
     * call is idempotent and requests a layout only when a value changed. With
     * Keys.RESIZABLE_BOTTOM_BAR off it does nothing and the XML stays in charge.
     */
    boolean ensureResizableBottomBar(String source) {
        if (mLauncher.mWorkspace == null || mLauncher.mPrefs == null || !BottomBarDimensions.isResizable(mLauncher.mPrefs)) {
            return false;
        }
        // When something changed, Workspace also invalidates the recycler's item decorations, and
        // every caller rebinds or refreshes the recycler right after - no extra
        // refreshRecyclerDecorationsAfterLayout() (and its listeners) needed here.
        return mLauncher.mWorkspace.applyResizableBottomBar(source);
    }

    void installBottomRecyclerDecorations(RecyclerView recyclerView) {
        if (recyclerView == null) return;
        if (Integer.valueOf(1).equals(recyclerView.getTag()) && recyclerView.getItemDecorationCount() > 0) {
            return;
        }
        clearRecyclerDecorations(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);

                int itemCount = parent.getAdapter() != null ? parent.getAdapter().getItemCount() : 0;
                if (itemCount == 0) {
                    outRect.left = 0;
                    outRect.right = 0;
                    return;
                }

                int itemWidth = view.getWidth();
                if (itemWidth <= 0) {
                    itemWidth = getFallbackRecyclerItemSize();
                }

                int availableWidth = parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight();
                if (availableWidth <= 0) {
                    availableWidth = parent.getMeasuredWidth() - parent.getPaddingLeft() - parent.getPaddingRight();
                }
                if (availableWidth <= 0) {
                    availableWidth = (int) (mLauncher.screenWidth * (mLauncher.widgetBar ? 0.4395f : 0.8795f));
                }

                int totalItemsWidth = itemWidth * itemCount;
                int totalSpacing = Math.max(0, availableWidth - totalItemsWidth);
                int spacingPerGap = totalSpacing / (itemCount + 1);
                int adjustedSpacing = Math.max(0, spacingPerGap / 2);
                outRect.left = adjustedSpacing;
                outRect.right = adjustedSpacing;
            }
        });
        recyclerView.addItemDecoration(new SimpleDividerDecoration());
        recyclerView.setTag(1);
    }

    void installLeftRecyclerDecorations(RecyclerView recyclerView) {
        if (recyclerView == null) return;
        if (Integer.valueOf(1).equals(recyclerView.getTag()) && recyclerView.getItemDecorationCount() > 0) {
            return;
        }
        clearRecyclerDecorations(recyclerView);
        recyclerView.addItemDecoration(new SimpleDividerDecoration());
        recyclerView.setTag(1);
    }

    int getFallbackRecyclerItemSize() {
        if (Launcher.app_icon_size > 0) {
            return Launcher.app_icon_size;
        }
        int baseDimension = Math.max(Launcher.orientationDimension, Math.max(Launcher.screenWidth, Launcher.screenHeight));
        if (baseDimension <= 0) {
            DisplayMetrics metrics = mLauncher.getResources().getDisplayMetrics();
            baseDimension = Math.max(metrics.widthPixels, metrics.heightPixels);
        }
        return Math.max(1, mLauncher.calculateDimension(baseDimension, 6.6));
    }

    void requestPostResumeAppDataRefresh() {
        if (!atomicInitAppData.get()) {
            return;
        }

        if (!mPostResumeAppDataDirty) {
            return;
        }

        long now = SystemClock.uptimeMillis();
        long elapsed = now - mLastPostResumeAppDataRefreshMs;
        if (!mPostResumeAppDataRefreshPending && elapsed >= POST_RESUME_APP_DATA_REFRESH_THROTTLE_MS) {
            runPostResumeAppDataRefresh();
            return;
        }

        if (mPostResumeAppDataRefreshPending) {
            return;
        }

        mPostResumeAppDataRefreshPending = true;
        long delay = Math.max(0L, POST_RESUME_APP_DATA_REFRESH_THROTTLE_MS - elapsed);
        mLauncher.mHandler.postDelayed(() -> {
            mPostResumeAppDataRefreshPending = false;
            runPostResumeAppDataRefresh();
        }, delay);
    }

    void runPostResumeAppDataRefresh() {
        if (!mPostResumeAppDataDirty) {
            return;
        }
        mPostResumeAppDataDirty = false;
        mLastPostResumeAppDataRefreshMs = SystemClock.uptimeMillis();
        mLauncher.bg.execute(() -> {
            int capacity = bottomCapacity(mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false),
                    mLauncher.mPrefs.getBoolean(Keys.WIDGET_BAR, false));
            List<AppMultiple> data = ensureBottomRows(BarRows.bottom(), capacity);
            List<LeftAppMultiple> left = BarRows.left(BarCapacity.LEFT_MEMORY);
            mLauncher.runOnUiThread(() -> {
                refreshCycle(data);
                refreshLeftBar(left);
            });
        });
    }

    public void triggerAppData() {
        markAppDataDirty();
        if (pendingAction != null) {
            appDataHandler.removeCallbacks(pendingAction);
        }
        
        pendingAction = new Runnable() {
            @Override
            public void run() {
                initAppData();
            }
        };
        
        appDataHandler.postDelayed(pendingAction, getAppDataDelayMs());
    }

    void markAppDataDirty() {
        mPostResumeAppDataDirty = true;
    }

    long getAppDataDelayMs() {
        if (mLauncher.mWorkspace != null
                && mLauncher.mWorkspace.isLaidOut()
                && AllAppsList.data != null
                && !AllAppsList.data.isEmpty()
                && mLauncher.mWorkspace.findViewById(R.id.recycler_view) != null) {
            return APP_DATA_FAST_DELAY;
        }
        return APP_DATA_DELAY;
    }

    /** Fires only if the app list never arrives, so a broken load still leaves a usable home. */
    final Runnable mAllAppsBindBackstop = new Runnable() {
        @Override
        public void run() {
            if (!mAwaitingAllAppsBind) return;

            // The loader's step 2 only begins once the main looper goes idle, and on this hardware
            // that has been measured at over eleven seconds after the workspace bind. Giving up on
            // a flat timer installed an empty app list that was replaced a second later, so the
            // fallback now only applies when the model itself says it is finished.
            if (mLauncher.mModel != null && !mLauncher.mModel.isAllAppsLoaded()
                    && mAllAppsBackstopChecks++ < MAX_ALL_APPS_BACKSTOP_CHECKS) {
                mLauncher.mHandler.postDelayed(this, ALL_APPS_BIND_BACKSTOP_MS);
                return;
            }

            Log.w(Launcher.TAG, "bindAllApplications() never arrived, initializing with defaults");
            mAwaitingAllAppsBind = false;
            mAllAppsBackstopChecks = 0;
            mInitRetryCount = 0;
            forceInitializeWithDefaults();
        }
    };

    public void initAppData() {
        // Prevent re-entrant calls — but schedule a deferred retry so the refresh is not lost
        if (mIsInitializingAppData) {
            Log.i(Launcher.TAG, "initAppData() already in progress, scheduling deferred retry");
            mLauncher.mHandler.postDelayed(() -> {
                if (!mIsInitializingAppData) {
                    initAppData();
                }
            }, 3500);
            return;
        }
        
        // The app list is delivered by bindAllApplications(), and the model only starts loading it
        // once the main looper goes idle. Polling for it on a 1 s timer kept the looper busy, so the
        // poll was delaying the very thing it was waiting for -- measured as 6.8 s of
        // "waited ... for previous step to finish binding", ten wasted attempts, and a
        // forceInitializeWithDefaults() pass that was immediately redone.
        if (LauncherApplication.isFytDevice() && (AllAppsList.data == null || AllAppsList.data.isEmpty())) {
            if (!mAwaitingAllAppsBind) {
                mAwaitingAllAppsBind = true;
                Log.i(Launcher.TAG, "initAppData(): app list not bound yet, waiting for bindAllApplications()");
            }
            mLauncher.mHandler.removeCallbacks(mAllAppsBindBackstop);
            mLauncher.mHandler.postDelayed(mAllAppsBindBackstop, ALL_APPS_BIND_BACKSTOP_MS);
            return;
        }
        mAwaitingAllAppsBind = false;
        mAllAppsBackstopChecks = 0;
        mLauncher.mHandler.removeCallbacks(mAllAppsBindBackstop);

        mIsInitializingAppData = true;
        mInitRetryCount++;
        Log.i(Launcher.TAG, "initAppData() started (attempt " + mInitRetryCount + ")");
        
        if (LauncherApplication.isFytDevice()) {
            if (!checkDependenciesReady()) {
                Log.w(Launcher.TAG, "Dependencies not ready, will retry...");
                mIsInitializingAppData = false;
                
                if (mInitRetryCount < MAX_INIT_RETRIES) {
                    mLauncher.mHandler.postDelayed(() -> initAppData(), 1000);
                } else {
                    Log.e(Launcher.TAG, "Max retries reached, initializing with defaults");
                    mInitRetryCount = 0;
                    forceInitializeWithDefaults();
                }
                return;
            }            
        } else {
            forceInitializeWithDefaults();
        }
        
        // bottom recycler
        if (mLauncher.mWorkspace == null) {
            Log.i(Launcher.TAG, "mWorkspace null on initAppData(), reinitializing workspace");
            mLauncher.mWorkspace = (Workspace) mLauncher.mDragLayer.findViewById(R.id.workspace);
        }
        
        // Ensure adapter is created before finding RecyclerView
        if (mAppListAdapter == null) {
            mAppListAdapter = new AppListAdapter(mLauncher, Collections.emptyList());
        }
        
        mRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (mRecyclerView == null) {
            Log.e(Launcher.TAG, "RecyclerView not found in workspace! Waiting for layout...");
            
            // Reset flag before early return so retry can work
            mIsInitializingAppData = false;
            
            if (mInitRetryCount < MAX_INIT_RETRIES) {
                // Wait for the workspace to be laid out properly
                if (mLauncher.mWorkspace.getViewTreeObserver().isAlive()) {
                    mLauncher.mWorkspace.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (mLauncher.mWorkspace != null) {
                                mLauncher.mWorkspace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            initAppData();
                        }
                    });
                } else {
                    mLauncher.mHandler.postDelayed(() -> initAppData(), 1000);
                }
            } else {
                Log.e(Launcher.TAG, "Max retries reached for RecyclerView, resetting");
                mInitRetryCount = 0;
            }
            return; 
        }
        
        Log.d(Launcher.TAG, "All dependencies ready, proceeding with setup");
        setupRecyclerView(mRecyclerView);
        mLauncher.mHandler.post(() -> {
            setupLeftRecyclerView();
            mIsInitializingAppData = false;
        });
        
        // Reset retry count on success
        mInitRetryCount = 0;
    }

    /** The database only has to prove itself once; see checkDependenciesReady(). */
    static volatile boolean sDatabaseProbeOk = false;

    boolean checkDependenciesReady() {
        // Check if AllAppsList is populated
        if (AllAppsList.data == null || AllAppsList.data.isEmpty()) {
            Log.w(Launcher.TAG, "AllAppsList not ready");
            return false;
        }
        
        // Check if database is accessible.
        // This is a real SQLite query on the main thread, and initAppData() can run it several
        // times a second while retrying -- measured at ~60 ms of blocked main thread per burst.
        // A database that has opened once does not become unavailable again, so probe once.
        if (!sDatabaseProbeOk) {
            try {
                // The bottom bar's rows: usually read already (BarRows.preload()).
                BarRows.bottom();
                sDatabaseProbeOk = true;
            } catch (Exception e) {
                Log.w(Launcher.TAG, "Database not ready: " + e.getMessage());
                return false;
            }
        }
        
        // Check if PackageManager is ready
        try {
            PackageManager pm = mLauncher.getPackageManager();
            if (pm == null) {
                Log.w(Launcher.TAG, "PackageManager not ready");
                return false;
            }
        } catch (Exception e) {
            Log.w(Launcher.TAG, "PackageManager error: " + e.getMessage());
            return false;
        }
        
        // Check if workspace is laid out
        if (mLauncher.mWorkspace == null || !mLauncher.mWorkspace.isLaidOut()) {
            Log.w(Launcher.TAG, "Workspace not laid out yet");
            return false;
        }
        
        return true;
    }

    void forceInitializeWithDefaults() {
        // Last resort: initialize with empty data and let user configure
        mIsInitializingAppData = true;
        
        if (mAppListAdapter == null) {
            mAppListAdapter = new AppListAdapter(mLauncher, Collections.emptyList());
        }
        
        mLauncher.mHandler.postDelayed(() -> {
            mRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
            if (mRecyclerView != null) {
                setupRecyclerView(mRecyclerView);
                setupLeftRecyclerView();
            }
            mIsInitializingAppData = false;
        }, 500);
    }

    void setupRecyclerView(RecyclerView recyclerView) {
        Log.d(Launcher.TAG, "setupRecyclerView started");

        // Force visibility
        recyclerView.setVisibility(View.VISIBLE);

        // Do not recreate the LayoutManager if the correct one is already attached —
        // setLayoutManager() detaches all children and causes a visible flicker.
        RecyclerView.LayoutManager existingLm = recyclerView.getLayoutManager();
        boolean lmOk = (existingLm instanceof LinearLayoutManager)
                && ((LinearLayoutManager) existingLm).getOrientation() == RecyclerView.HORIZONTAL;
        if (!lmOk) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(mLauncher.getApplicationContext());
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
        }

        // Re-setting the SAME adapter still rebinds all rows.
        if (recyclerView.getAdapter() != mAppListAdapter) {
            recyclerView.setAdapter(mAppListAdapter);
        }
        // No change/remove/add animations = no flicker when notifyDataSetChanged() is called.
        if (recyclerView.getItemAnimator() != null) {
            recyclerView.setItemAnimator(null);
        }

        // Dynamic bar height instead of the XML ratio/percent (no-op unless the feature is on).
        ensureResizableBottomBar("setupRecyclerView");

        installBottomRecyclerDecorations(recyclerView);

        Log.d(Launcher.TAG, "RecyclerView setup complete - Adapter: " + (mAppListAdapter != null) +
                ", ItemCount: " + (mAppListAdapter != null ? mAppListAdapter.getItemCount() : 0) +
                ", Visibility: " + recyclerView.getVisibility());

        // Initialize app data
        initializeAppList();

        if (!mApplyingBarSnapshot) { // a snapshot is only the bar; the rest waits for the app data
            mLauncher.requestCustomElementsSetup("setupRecyclerView");
        }

        // One call instead of two — each one adds an OnGlobalLayoutListener + 2 postDelayed
        refreshRecyclerDecorationsAfterLayout(recyclerView);

        boolean autoHideBottomBar = mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        if (autoHideBottomBar) {
            disableRecycler();
        }
    }

    void setupLeftRecyclerView() {
        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.leftBar = mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false);

        if (!(mLauncher.userLayout && mLauncher.leftBar || !mLauncher.userLayout)) {
            return;
        }

        RecyclerView mLeftRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);

        if (mLeftRecyclerView == null) {
            if (mLeftRecyclerLayoutPending) {
                Log.d(Launcher.TAG, "Left RecyclerView lookup already pending, skipping duplicate");
                return;
            }
            // Normal while the pages are being (re)created, e.g. recreateView(): the next layout pass has it.
            Log.d(Launcher.TAG, "Left RecyclerView not inflated yet, waiting for layout");
            mLeftRecyclerLayoutPending = true;
            if (mLauncher.mWorkspace.getViewTreeObserver().isAlive()) {
                mLauncher.mWorkspace.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (mLauncher.mWorkspace != null) {
                            mLauncher.mWorkspace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        mLeftRecyclerLayoutPending = false;
                        setupLeftRecyclerView();
                    }
                });
            } else {
                mLauncher.mHandler.postDelayed(() -> {
                    mLeftRecyclerLayoutPending = false;
                    setupLeftRecyclerView();
                }, 500);
            }
            return;
        }
        mLeftRecyclerLayoutPending = false;

        Log.d(Launcher.TAG, "Setting up left RecyclerView");

        mLeftRecyclerView.setVisibility(View.VISIBLE);

        // Initialize adapter FIRST, before any layout might occur
        if (mLeftAppListAdapter == null) {
            mLeftAppListAdapter = new LeftAppListAdapter(mLauncher, Collections.emptyList());
        }

        if (mLeftRecyclerView.getLayoutManager() instanceof Launcher.EvenVerticalLayoutManager) {
            Launcher.EvenVerticalLayoutManager existing =
                    (Launcher.EvenVerticalLayoutManager) mLeftRecyclerView.getLayoutManager();
            existing.setCapacityListener(this::onLeftCapacityChanged);
            existing.setMaxItems(leftCapacity());
        } else {
            mLeftRecyclerView.setLayoutManager(newLeftLayoutManager());
        }

        if (mLeftRecyclerView.getAdapter() != mLeftAppListAdapter) {
            mLeftRecyclerView.setAdapter(mLeftAppListAdapter);
        }
        if (mLeftRecyclerView.getItemAnimator() != null) {
            mLeftRecyclerView.setItemAnimator(null);
        }

        installLeftRecyclerDecorations(mLeftRecyclerView);

        // Initialize left app data
        initializeLeftAppData();

        mLeftRecyclerView.requestLayout();
    }

    Map<String, AppInfo> buildAppInfoLookup() {
        Map<String, AppInfo> lookup = new HashMap<>();
        // snapshot(): the loader thread changes AllAppsList.data without a lock (nothing else
        // synchronizes on it), and the indexed copy used here before threw while an app was
        // being removed, which skipped the whole refresh and left the lookup empty.
        List<AppInfo> snapshot = AllAppsList.snapshot();

        for (AppInfo app : snapshot) {
            if (app == null || TextUtils.isEmpty(app.getPackageName())) {
                continue;
            }
            lookup.put(appLookupKey(app.getPackageName(), app.getClassName()), app);
        }
        return lookup;
    }

    String appLookupKey(String packageName, String className) {
        return packageName + "/" + (className == null ? "" : className);
    }

    AppInfo findAppInfo(Map<String, AppInfo> lookup, String packageName, String className) {
        if (lookup == null || TextUtils.isEmpty(packageName)) {
            return null;
        }
        return lookup.get(appLookupKey(packageName, className));
    }

    boolean isPackageInstalledCached(Map<String, Boolean> cache, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        Boolean cached = cache.get(packageName);
        if (cached != null) {
            return cached;
        }
        boolean installed = mLauncher.helpers.isPackageInstalled(packageName);
        cache.put(packageName, installed);
        return installed;
    }

    long appendStringSignature(long signature, String value) {
        return (signature * 31L) + (value == null ? 0L : value.hashCode());
    }

    int getAllAppsDataSize() {
        return AllAppsList.data == null ? 0 : AllAppsList.data.size();
    }

    long calculateAppRowsSignature(List<AppMultiple> rows, boolean currentUserLayout,
                                   boolean currentWidgetBar, int capacity) {
        long signature = 1125899906842597L;
        signature = (signature * 31L) + (currentUserLayout ? 1L : 0L);
        signature = (signature * 31L) + (currentWidgetBar ? 1L : 0L);
        signature = (signature * 31L) + mLauncher.orientation;
        signature = (signature * 31L) + capacity;
        signature = (signature * 31L) + getAllAppsDataSize();
        if (rows == null) {
            return signature;
        }
        signature = (signature * 31L) + rows.size();
        for (AppMultiple row : rows) {
            if (row == null) {
                signature *= 31L;
                continue;
            }
            signature = (signature * 31L) + row.id;
            signature = (signature * 31L) + row.index;
            signature = appendStringSignature(signature, row.name);
            signature = appendStringSignature(signature, row.packageName);
            signature = appendStringSignature(signature, row.className);
        }
        return signature;
    }

    long calculateLeftAppRowsSignature(List<LeftAppMultiple> rows, int capacity) {
        long signature = 1469598103934665603L;
        signature = (signature * 31L) + (mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false) ? 1L : 0L);
        signature = (signature * 31L) + (mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false) ? 1L : 0L);
        signature = (signature * 31L) + capacity;
        signature = (signature * 31L) + getAllAppsDataSize();
        if (rows == null) {
            return signature;
        }
        signature = (signature * 31L) + rows.size();
        for (LeftAppMultiple row : rows) {
            if (row == null) {
                signature *= 31L;
                continue;
            }
            signature = (signature * 31L) + row.id;
            signature = (signature * 31L) + row.index;
            signature = appendStringSignature(signature, row.name);
            signature = appendStringSignature(signature, row.packageName);
            signature = appendStringSignature(signature, row.className);
        }
        return signature;
    }

    void initializeLeftAppData() {
        if (mApplyingBarSnapshot) {
            applyLeftBarSnapshot();
            return;
        }
        final int capacity = leftCapacity();
        List<LeftAppMultiple> leftAppData = BarRows.left(BarCapacity.LEFT_MEMORY);
        long sourceSignature = calculateLeftAppRowsSignature(leftAppData, capacity);
        if (sourceSignature == mLastLeftAppListSourceSignature
                && mLeftAppListAdapter != null
                && mLeftAppListAdapter.getItemCount() > 0
                && mLeftAppListData != null
                && !mLeftAppListData.isEmpty()) {
            Log.d(Launcher.TAG, "initializeLeftAppData: unchanged, skipping rebuild");
            return;
        }

        boolean hasExistingLeftListData = hasCurrentLeftAppListData();
        if ((leftAppData == null || leftAppData.isEmpty()) && hasExistingLeftListData) {
            Log.w(Launcher.TAG, "initializeLeftAppData: empty rows during refresh, keeping current left app list");
            scheduleAppListInitializationRetry("initializeLeftEmptyRows");
            return;
        }
        List<AppListBean> nextLeftAppListData = new ArrayList<AppListBean>();
        BarSnapshotCollector leftSnapshot = new BarSnapshotCollector();
        
        // Ensure adapter exists
        if (mLeftAppListAdapter == null) {
            mLeftAppListData = nextLeftAppListData;
            mLeftAppListAdapter = new LeftAppListAdapter(mLauncher, mLeftAppListData);
            
            RecyclerView mLeftRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);
            if (mLeftRecyclerView != null) {
                mLeftRecyclerView.setAdapter(mLeftAppListAdapter);
            }
        }

        Map<String, AppInfo> appInfoLookup = buildAppInfoLookup();
        Map<String, Boolean> installCache = new HashMap<>();
        
        if (leftAppData != null && !leftAppData.isEmpty()) {
            for (LeftAppMultiple multiple : leftAppData) {
                if (nextLeftAppListData.size() >= capacity) {
                    break; // the rest of the remembered apps do not fit
                }
                if (TextUtils.isEmpty(multiple.packageName)
                        || TextUtils.isEmpty(multiple.name)
                        || !isPackageInstalledCached(installCache, multiple.packageName)) {
                    continue;
                }
                
                AppInfo allApp = findAppInfo(appInfoLookup, multiple.packageName, multiple.className);
                if (allApp != null) {
                    AppListBean ab = new AppListBean(
                        allApp.title.toString(),
                        allApp.iconBitmap,
                        multiple.packageName,
                        multiple.className
                    );
                    nextLeftAppListData.add(ab);
                    leftSnapshot.add((long) multiple.id, multiple.packageName, multiple.className,
                            allApp.title.toString(), allApp.iconBitmap);
                    continue;
                }
                
                // If not found in AllAppsList but package is installed, load icon from package manager.
                // Strict variant: returns null for uninstalled/unresolvable components, so the row is
                // dropped (and the remaining icons re-flow) instead of showing the "add app" icon.
                Bitmap icon = loadLeftBarIconStrict(multiple.packageName, multiple.className);
                if (icon != null) {
                    AppListBean ab = new AppListBean(
                        multiple.name,
                        icon,
                        multiple.packageName,
                        multiple.className
                    );
                    nextLeftAppListData.add(ab);
                    leftSnapshot.usedFallbackIcon = true;
                }
            }
        }
        
        if (mLeftAppListAdapter != null) {
            mLeftAppListData = nextLeftAppListData;
            mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
            mLastLeftAppListSourceSignature = sourceSignature;
            Log.d(Launcher.TAG, "Left app data initialized with " + mLeftAppListData.size() + " items");
            saveLeftBarSnapshot(leftAppData, capacity, leftSnapshot);
        }
    }

    // =====================================================================================
    // BAR SNAPSHOTS - the bars as last shown, drawn at start until the app list is bound
    // =====================================================================================

    /** Entries of one bar as they are built, with the name and icon each one shows. */
    static final class BarSnapshotCollector {
        final List<BarSnapshotStore.Item> items = new ArrayList<>();
        /** An icon came from the PackageManager fallback: not the launcher's look, not saved. */
        boolean usedFallbackIcon;

        void add(long rowDbId, String packageName, String className, String name, Bitmap icon) {
            items.add(new BarSnapshotStore.Item(rowDbId, packageName, className, name, icon));
        }
    }

    /**
     * Reads the bar snapshots in the background and shows them as soon as they are read.
     *
     * Both bars used to stay empty until the whole app list was loaded -- 37.4 s and 45.7 s of
     * uptime in captures 29-09-2026 20:51 and 21:40, against a first frame at ~23 s. Waiting for
     * initAppData() would not do either: at 21:40 it ran 13 ms before the main thread got stuck
     * for 11.8 s in the pane build (createVirtualDisplay during the boot-time freeze), so anything
     * posted after it would have waited as long. This starts in onCreate(), and each bar is shown
     * as soon as its view exists (see applyPendingBarSnapshots()). Once the app list is bound,
     * initAppData() builds the real bars as before and they replace the snapshot (same icons,
     * unless an app changed meanwhile).
     */
    void prefetchBarSnapshots() {
        if (!LauncherApplication.isFytDevice()) {
            return; // other devices build the bars at once (forceInitializeWithDefaults())
        }
        final Context appContext = mLauncher.getApplicationContext();
        final boolean currentUserLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        final boolean currentWidgetBar = mLauncher.mPrefs.getBoolean(Keys.WIDGET_BAR, false);
        final boolean currentLeftBar = mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false);
        final int currentOrientation = mLauncher.orientation;
        // On the main thread, before the thread starts: both read the preferences and the screen
        // size the way the bars will when they are built.
        final int currentBottomCapacity = bottomCapacity(currentUserLayout, currentWidgetBar);
        final int currentLeftCapacity = leftCapacity();
        Thread prefetch = new Thread(() -> {
            List<AppMultiple> bottomRows = null;
            List<LeftAppMultiple> leftRows = null;
            BarSnapshotStore.Snapshot bottom = null;
            BarSnapshotStore.Snapshot left = null;
            try {
                bottomRows = queryBottomAppRows();
                BarSnapshotStore.Snapshot s = BarSnapshotStore.load(appContext, BarSnapshotStore.BOTTOM);
                if (s != null && bottomRows != null && s.signature == bottomBarSnapshotSignature(
                        bottomRows, currentUserLayout, currentWidgetBar, currentOrientation,
                        currentBottomCapacity)) {
                    bottom = s;
                }
                leftRows = BarRows.left(BarCapacity.LEFT_MEMORY);
                s = BarSnapshotStore.load(appContext, BarSnapshotStore.LEFT);
                if (s != null && leftRows != null && s.signature == leftBarSnapshotSignature(
                        leftRows, currentUserLayout, currentLeftBar, currentLeftCapacity)) {
                    left = s;
                }
            } catch (RuntimeException e) {
                Log.w(Launcher.TAG, "Bar snapshots not read", e);
            }
            Log.d(Launcher.TAG, "Bar snapshots: bottom " + (bottom != null ? bottom.items.size() + " items" : "none/outdated")
                    + ", left " + (left != null ? left.items.size() + " items" : "none/outdated"));
            if (bottom == null && left == null) {
                return;
            }
            final BarSnapshotStore.Snapshot bottomSnapshot = bottom;
            final List<AppMultiple> bottomSnapshotRows = bottomRows;
            final BarSnapshotStore.Snapshot leftSnapshot = left;
            final List<LeftAppMultiple> leftSnapshotRows = leftRows;
            mLauncher.mHandler.post(() -> {
                mPendingBottomSnapshot = bottomSnapshot;
                mPendingBottomSnapshotRows = bottomSnapshotRows;
                mPendingLeftSnapshot = leftSnapshot;
                mPendingLeftSnapshotRows = leftSnapshotRows;
                mBarSnapshotAttempts = 0;
                mBarSnapshotReadAtMs = SystemClock.uptimeMillis();
                applyPendingBarSnapshots();
            });
        }, "BarSnapshotPrefetch");
        prefetch.start();
    }

    /**
     * Shows the pending snapshots through the usual setup, so the bars look exactly as they will
     * once the real lists are there. A bar whose view is not there yet is tried again shortly; a
     * bar that already has data ends the wait for that bar.
     */
    void applyPendingBarSnapshots() {
        mLauncher.mHandler.removeCallbacks(mApplyPendingBarSnapshots);
        if (mLauncher.isDestroyed() || mLauncher.isFinishing() || mLauncher.mWorkspace == null) {
            clearPendingBarSnapshots();
            return;
        }
        if (mPendingBottomSnapshot != null) {
            RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
            if (hasCurrentAppListData()) {
                Log.i(Launcher.TAG, "Bottom bar snapshot not needed: the bar was built first, "
                        + (SystemClock.uptimeMillis() - mBarSnapshotReadAtMs) + " ms after reading it");
                mPendingBottomSnapshot = null;
                mPendingBottomSnapshotRows = null;
            } else if (recycler != null) {
                if (mAppListAdapter == null) {
                    mAppListAdapter = new AppListAdapter(mLauncher, Collections.emptyList());
                }
                mRecyclerView = recycler;
                mBottomBarSnapshot = mPendingBottomSnapshot;
                mBottomBarSnapshotRows = mPendingBottomSnapshotRows;
                mPendingBottomSnapshot = null;
                mPendingBottomSnapshotRows = null;
                mApplyingBarSnapshot = true;
                try {
                    setupRecyclerView(recycler);
                } finally {
                    mApplyingBarSnapshot = false;
                    mBottomBarSnapshot = null;
                    mBottomBarSnapshotRows = null;
                }
                Log.i(Launcher.TAG, "Bottom bar shown from snapshot (" + (mAppListData != null ? mAppListData.size() : 0)
                        + " items), " + (SystemClock.uptimeMillis() - mBarSnapshotReadAtMs) + " ms after reading it");
            }
        }
        // Only once the left recycler exists: setupLeftRecyclerView() would otherwise wait for a
        // layout pass and then build the bar the normal way, with PackageManager icons.
        if (mPendingLeftSnapshot != null) {
            if (hasCurrentLeftAppListData()) {
                Log.i(Launcher.TAG, "Left bar snapshot not needed: the bar was built first, "
                        + (SystemClock.uptimeMillis() - mBarSnapshotReadAtMs) + " ms after reading it");
                mPendingLeftSnapshot = null;
                mPendingLeftSnapshotRows = null;
            } else if (mLauncher.mWorkspace.findViewById(R.id.left_recycler_view) != null) {
                mLeftBarSnapshot = mPendingLeftSnapshot;
                mLeftBarSnapshotRows = mPendingLeftSnapshotRows;
                mPendingLeftSnapshot = null;
                mPendingLeftSnapshotRows = null;
                mApplyingBarSnapshot = true;
                try {
                    setupLeftRecyclerView();
                } finally {
                    mApplyingBarSnapshot = false;
                    mLeftBarSnapshot = null;
                    mLeftBarSnapshotRows = null;
                }
                Log.i(Launcher.TAG, "Left bar shown from snapshot (" + (mLeftAppListData != null ? mLeftAppListData.size() : 0)
                        + " items), " + (SystemClock.uptimeMillis() - mBarSnapshotReadAtMs) + " ms after reading it");
            }
        }
        if (mPendingBottomSnapshot == null && mPendingLeftSnapshot == null) {
            return;
        }
        if (++mBarSnapshotAttempts >= BAR_SNAPSHOT_MAX_ATTEMPTS) {
            Log.w(Launcher.TAG, "Bar snapshot views never appeared, snapshot dropped");
            clearPendingBarSnapshots();
            return;
        }
        mLauncher.mHandler.postDelayed(mApplyPendingBarSnapshots, BAR_SNAPSHOT_RETRY_MS);
    }

    void clearPendingBarSnapshots() {
        mLauncher.mHandler.removeCallbacks(mApplyPendingBarSnapshots);
        mPendingBottomSnapshot = null;
        mPendingBottomSnapshotRows = null;
        mPendingLeftSnapshot = null;
        mPendingLeftSnapshotRows = null;
    }

    /**
     * The bottom bar from its snapshot. Leaves mLastAppListSourceSignature and
     * finishAppListInitialization() alone: the real list still replaces this one, and nothing that
     * waits for the app data (PiP) starts early.
     */
    void applyBottomBarSnapshot() {
        BarSnapshotStore.Snapshot snapshot = mBottomBarSnapshot;
        List<AppMultiple> rows = mBottomBarSnapshotRows;
        if (snapshot == null || rows == null || mAppListAdapter == null) {
            return;
        }
        Map<Long, AppMultiple> rowsById = new HashMap<>();
        for (AppMultiple row : rows) {
            if (row != null) {
                rowsById.put((long) row.id, row);
            }
        }
        List<AppListBean> beans = new ArrayList<AppListBean>();
        for (BarSnapshotStore.Item item : snapshot.items) {
            AppListBean bean = new AppListBean(item.name, item.icon, item.packageName, item.className);
            AppMultiple row = rowsById.get(item.rowDbId);
            if (row != null) {
                bean.rowId = row.rowId();
                bean.slot = row.index;
            }
            beans.add(bean);
        }
        mAppListData = beans;
        mAppListAdapter.notifyDataSetChanged(mAppListData);
    }

    /** The left bar from its snapshot; same rules as applyBottomBarSnapshot(). */
    void applyLeftBarSnapshot() {
        BarSnapshotStore.Snapshot snapshot = mLeftBarSnapshot;
        List<LeftAppMultiple> rows = mLeftBarSnapshotRows;
        if (snapshot == null || rows == null || mLeftAppListAdapter == null) {
            return;
        }
        Map<Long, LeftAppMultiple> rowsById = new HashMap<>();
        for (LeftAppMultiple row : rows) {
            if (row != null) {
                rowsById.put((long) row.id, row);
            }
        }
        List<AppListBean> beans = new ArrayList<AppListBean>();
        for (BarSnapshotStore.Item item : snapshot.items) {
            AppListBean bean = new AppListBean(item.name, item.icon, item.packageName, item.className);
            LeftAppMultiple row = rowsById.get(item.rowDbId);
            if (row != null) {
                bean.rowId = row.rowId();
            }
            beans.add(bean);
        }
        mLeftAppListData = beans;
        mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
    }

    /** Saves the bottom bar as just built, unless it is the same as the last one saved. */
    void saveBottomBarSnapshot(List<AppMultiple> rows, boolean currentUserLayout,
                                       boolean currentWidgetBar, int capacity, BarSnapshotCollector snapshot) {
        if (rows == null || snapshot == null || snapshot.usedFallbackIcon
                || !LauncherApplication.isFytDevice()
                || AllAppsList.data == null || AllAppsList.data.isEmpty()) {
            return; // only a bar built from the real app list is worth showing next time
        }
        long signature = bottomBarSnapshotSignature(rows, currentUserLayout, currentWidgetBar,
                mLauncher.orientation, capacity);
        if (mLauncher.mBottomBarSnapshotSaved && signature == mLauncher.mSavedBottomBarSnapshotSignature) {
            return;
        }
        mLauncher.mBottomBarSnapshotSaved = true;
        mLauncher.mSavedBottomBarSnapshotSignature = signature;
        BarSnapshotStore.saveAsync(mLauncher.getApplicationContext(), BarSnapshotStore.BOTTOM, signature, snapshot.items);
    }

    /** Saves the left bar as just built, unless it is the same as the last one saved. */
    void saveLeftBarSnapshot(List<LeftAppMultiple> rows, int capacity, BarSnapshotCollector snapshot) {
        if (rows == null || snapshot == null || snapshot.usedFallbackIcon
                || !LauncherApplication.isFytDevice()
                || AllAppsList.data == null || AllAppsList.data.isEmpty()) {
            return;
        }
        long signature = leftBarSnapshotSignature(rows, mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false),
                mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false), capacity);
        if (mLeftBarSnapshotSaved && signature == mSavedLeftBarSnapshotSignature) {
            return;
        }
        mLeftBarSnapshotSaved = true;
        mSavedLeftBarSnapshotSignature = signature;
        BarSnapshotStore.saveAsync(mLauncher.getApplicationContext(), BarSnapshotStore.LEFT, signature, snapshot.items);
    }

    /**
     * What the bottom bar is built from, apart from the app list itself (which
     * calculateAppRowsSignature() includes): its rows and the layout settings. A snapshot is shown
     * only while this is unchanged. Pure; also used off the main thread.
     */
    long bottomBarSnapshotSignature(List<AppMultiple> rows, boolean currentUserLayout,
                                            boolean currentWidgetBar, int currentOrientation,
                                            int capacity) {
        long signature = 7046029254386353131L;
        signature = (signature * 31L) + (currentUserLayout ? 1L : 0L);
        signature = (signature * 31L) + (currentWidgetBar ? 1L : 0L);
        signature = (signature * 31L) + currentOrientation;
        signature = (signature * 31L) + capacity;
        if (rows == null) {
            return signature;
        }
        signature = (signature * 31L) + rows.size();
        for (AppMultiple row : rows) {
            if (row == null) {
                signature *= 31L;
                continue;
            }
            signature = (signature * 31L) + row.id;
            signature = (signature * 31L) + row.index;
            signature = appendStringSignature(signature, row.name);
            signature = appendStringSignature(signature, row.packageName);
            signature = appendStringSignature(signature, row.className);
        }
        return signature;
    }

    /** As bottomBarSnapshotSignature(), for the left bar. */
    long leftBarSnapshotSignature(List<LeftAppMultiple> rows, boolean currentUserLayout,
                                          boolean currentLeftBar, int capacity) {
        long signature = -3750763034362895579L;
        signature = (signature * 31L) + (currentUserLayout ? 1L : 0L);
        signature = (signature * 31L) + (currentLeftBar ? 1L : 0L);
        signature = (signature * 31L) + capacity;
        if (rows == null) {
            return signature;
        }
        signature = (signature * 31L) + rows.size();
        for (LeftAppMultiple row : rows) {
            if (row == null) {
                signature *= 31L;
                continue;
            }
            signature = (signature * 31L) + row.id;
            signature = (signature * 31L) + row.index;
            signature = appendStringSignature(signature, row.name);
            signature = appendStringSignature(signature, row.packageName);
            signature = appendStringSignature(signature, row.className);
        }
        return signature;
    }

    boolean hasCurrentAppListData() {
        return mAppListAdapter != null
                && mAppListAdapter.getItemCount() > 0
                && mAppListData != null
                && !mAppListData.isEmpty();
    }

    boolean hasCurrentLeftAppListData() {
        return mLeftAppListAdapter != null
                && mLeftAppListAdapter.getItemCount() > 0
                && mLeftAppListData != null
                && !mLeftAppListData.isEmpty();
    }

    void scheduleAppListInitializationRetry(String source) {
        Log.w(Launcher.TAG, "Scheduling app list initialization retry: " + source);
        mLauncher.mHandler.postDelayed(() -> {
            if (!mLauncher.mPaused && !mIsInitializingAppData) {
                initAppData();
            }
        }, 1000L);
    }

    // =====================================================================================
    // BOTTOM BAR - single source of truth for row -> bean mapping
    // =====================================================================================

    List<AppMultiple> queryBottomAppRows() {
        try {
            return BarRows.bottom();
        } catch (Exception e) {
            Log.e(Launcher.TAG, "Database error while reading AppMultiple: " + e.getMessage());
            return null;
        }
    }

    /**
     * Makes sure the database has a row for every slot the bar has room for. The first eight come
     * with createDefaultAppEntries(); a bar that holds more gets the rest here, empty ("+"), the
     * first time it is asked for them. Whether a slot is there is told by its index, not by the
     * number of rows (index is not unique). A row is never removed: when the bar gets lower again
     * or turned, the extra slots come back with the apps they were given.
     *
     * Returns the rows to build from: the ones passed in, or all of them read again after a write.
     * May run off the main thread; the lock keeps two callers from adding the same slot twice.
     */
    List<AppMultiple> ensureBottomRows(List<AppMultiple> rows, int capacity) {
        if (rows == null || rows.isEmpty() || missingBottomSlots(rows, capacity).isEmpty()) {
            return rows;
        }
        synchronized (BOTTOM_ROWS_LOCK) {
            // Read again under the lock: the rows in hand may predate another caller's write.
            List<AppMultiple> current = queryBottomAppRows();
            if (current == null || current.isEmpty()) {
                return rows;
            }
            List<Integer> missing = missingBottomSlots(current, capacity);
            if (missing.isEmpty()) {
                return current;
            }
            for (int slot : missing) {
                new AppMultiple(slot, "", FytPackage.AddAction, "").save();
            }
            BarRows.invalidate();
            Log.d(Launcher.TAG, "ensureBottomRows: added slots " + missing + " for capacity " + capacity);
            List<AppMultiple> reread = queryBottomAppRows();
            return reread != null && !reread.isEmpty() ? reread : current;
        }
    }

    /** Slots from the default rows up to the capacity that no row has as its index. */
    private List<Integer> missingBottomSlots(List<AppMultiple> rows, int capacity) {
        List<Integer> missing = new ArrayList<>();
        if (capacity <= BarCapacity.DEFAULT_BOTTOM_ROWS) {
            return missing;
        }
        boolean[] present = new boolean[capacity];
        for (AppMultiple row : rows) {
            if (row != null && row.index >= 0 && row.index < capacity) {
                present[row.index] = true;
            }
        }
        for (int slot = BarCapacity.DEFAULT_BOTTOM_ROWS; slot < capacity; slot++) {
            if (!present[slot]) {
                missing.add(slot);
            }
        }
        return missing;
    }

    /**
     * The ONLY place where AppMultiple rows are turned into AppListBeans.
     * Every bean carries the rowId and slot of the row it came from, so neither the
     * adapter nor the picker dialog ever has to reverse-engineer a database index from
     * a list position.
     *
     * IMPORTANT: a slot is {@link AppMultiple#index} - the logical slot of the row - NOT the
     * position of the row inside the query result and NOT the adapter position. The visible list
     * is compacted, so those three numbers do not match once the capacity hides some slots
     * (BarCapacity.isBottomSlotVisible()).
     *
     * {@code snapshot}, if given, records each entry as it is shown.
     */
    List<AppListBean> buildBottomAppBeans(List<AppMultiple> rows,
                                                  Map<String, AppInfo> appInfoLookup,
                                                  Map<String, Boolean> installCache,
                                                  int capacity,
                                                  BarSnapshotCollector snapshot) {
        List<AppListBean> beans = new ArrayList<AppListBean>();
        if (rows == null || rows.isEmpty()) {
            return beans;
        }

        for (AppMultiple row : rows) {
            if (row == null || !BarCapacity.isBottomSlotVisible(row.index, capacity)) {
                continue;
            }

            String beanName;
            Bitmap beanIcon;
            if (FytPackage.AppAction.equals(row.packageName)) {
                beanIcon = BitmapFactory.decodeResource(mLauncher.getResources(), R.drawable.ic_apps);
                beanName = Utils.getNameToStr("car_app");

            } else if (FytPackage.AddAction.equals(row.packageName)
                    || !isPackageInstalledCached(installCache, row.packageName)) {
                // empty slot, or a slot whose package is gone -> "+" placeholder,
                // but keep the stored package/class so the regression guard below
                // still counts it the same way the old code did.
                beanIcon = BitmapFactory.decodeResource(mLauncher.getResources(), R.drawable.icon_add);
                beanName = row.name;

            } else {
                AppInfo allApp = findAppInfo(appInfoLookup, row.packageName, row.className);
                if (allApp != null) {
                    beanName = allApp.title.toString();
                    beanIcon = allApp.iconBitmap;
                } else {
                    // Installed but not in AllAppsList (transient during a package update) -
                    // load straight from PackageManager so the icon does not disappear.
                    beanIcon = loadAppIconFromPackageManager(row.packageName, row.className);
                    beanName = row.name;
                    if (snapshot != null) {
                        snapshot.usedFallbackIcon = true;
                    }
                }
            }

            AppListBean bean = new AppListBean(beanName, beanIcon, row.packageName, row.className);
            bean.rowId = row.rowId();
            bean.slot = row.index;
            beans.add(bean);
            if (snapshot != null) {
                snapshot.add((long) row.id, row.packageName, row.className, beanName, beanIcon);
            }
        }
        return beans;
    }

    /** Installed, real (non-placeholder) rows that SHOULD be visible in the current layout. */
    int countInstalledBottomRows(List<AppMultiple> rows,
                                         Map<String, Boolean> installCache,
                                         int capacity) {
        if (rows == null) {
            return 0;
        }
        int installed = 0;
        for (AppMultiple row : rows) {
            if (row == null || !BarCapacity.isBottomSlotVisible(row.index, capacity)) {
                continue;
            }
            if (!FytPackage.AddAction.equals(row.packageName)
                    && !FytPackage.AppAction.equals(row.packageName)
                    && isPackageInstalledCached(installCache, row.packageName)) {
                installed++;
            }
        }
        return installed;
    }

    int countRealBeans(List<AppListBean> beans) {
        if (beans == null) {
            return 0;
        }
        int real = 0;
        for (AppListBean bean : beans) {
            if (bean == null) {
                continue;
            }
            if (!FytPackage.AddAction.equals(bean.packageName)
                    && !FytPackage.AppAction.equals(bean.packageName)) {
                real++;
            }
        }
        return real;
    }

    void initializeAppList() {
        if (mApplyingBarSnapshot) {
            applyBottomBarSnapshot();
            return;
        }
        Log.d(Launcher.TAG, "initializeAppList");

        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.widgetBar = mLauncher.mPrefs.getBoolean(Keys.WIDGET_BAR, false);

        // Worked out once for this rebuild: the rows to add, the visible slots, the regression
        // guard and the signatures all go by the same number.
        final int capacity = bottomCapacity(mLauncher.userLayout, mLauncher.widgetBar);
        List<AppMultiple> appData = ensureBottomRows(queryBottomAppRows(), capacity);

        long sourceSignature = calculateAppRowsSignature(appData, mLauncher.userLayout,
                mLauncher.widgetBar, capacity);
        if (sourceSignature == mLastAppListSourceSignature && hasCurrentAppListData()) {
            Log.d(Launcher.TAG, "initializeAppList: unchanged, skipping rebuild");
            finishAppListInitialization();
            return;
        }

        boolean hasExistingAppListData = hasCurrentAppListData();

        if (appData == null || appData.isEmpty()) {
            if (hasExistingAppListData) {
                Log.w(Launcher.TAG, "initializeAppList: empty app rows during refresh, keeping current app list");
                scheduleAppListInitializationRetry("emptyAppRows");
                finishAppListInitialization();
                return;
            }

            Log.w(Launcher.TAG, "Creating default app entries (appData or AllAppsList not ready)");
            mAppListData = new ArrayList<AppListBean>();
            createDefaultAppEntries();

            // Read the freshly inserted rows back: only the query gives us real rowIds.
            appData = ensureBottomRows(queryBottomAppRows(), capacity);
            if (appData == null || appData.isEmpty()) {
                Log.e(Launcher.TAG, "initializeAppList: defaults written but cannot be read back");
                finishAppListInitialization();
                return;
            }
            sourceSignature = calculateAppRowsSignature(appData, mLauncher.userLayout,
                    mLauncher.widgetBar, capacity);
            hasExistingAppListData = false;
        }

        Map<String, AppInfo> appInfoLookup = buildAppInfoLookup();
        Map<String, Boolean> installCache = new HashMap<>();

        BarSnapshotCollector bottomSnapshot = new BarSnapshotCollector();
        List<AppListBean> nextAppListData =
                buildBottomAppBeans(appData, appInfoLookup, installCache, capacity, bottomSnapshot);

        // Regression guard: if the new list has fewer real-app entries than the DB rows
        // that are actually installed, AllAppsList.data was transiently incomplete
        // (e.g. during a package update). Keep the current list to avoid wiping the bar.
        boolean safeToUpdate = true;
        if (hasExistingAppListData) {
            int installedDbCount = countInstalledBottomRows(appData, installCache, capacity);
            int newRealCount = countRealBeans(nextAppListData);
            if (newRealCount < installedDbCount) {
                Log.w(Launcher.TAG, "initializeAppList: new list (" + newRealCount
                        + " real apps) is fewer than installed DB entries (" + installedDbCount
                        + ") - AllAppsList may be incomplete, keeping current list");
                safeToUpdate = false;
            }
        }

        if (mAppListAdapter != null && safeToUpdate) {
            mAppListData = nextAppListData;
            mAppListAdapter.notifyDataSetChanged(mAppListData);
            mLastAppListSourceSignature = sourceSignature;
            saveBottomBarSnapshot(appData, mLauncher.userLayout, mLauncher.widgetBar, capacity, bottomSnapshot);
        } else if (!safeToUpdate) {
            scheduleAppListInitializationRetry("incompleteAllAppsList");
        }

        finishAppListInitialization();
    }

    void finishAppListInitialization() {
        mLastPostResumeAppDataRefreshMs = SystemClock.uptimeMillis();
        mPostResumeAppDataDirty = false;
        atomicInitAppData.set(true);
        if (!mLauncher.onResumePip) {
            mLauncher.onResumePip = false;
            mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
            if (mLauncher.userLayout) {
                mLauncher.mPipStarter.initPip("initializeAppList()", null, false);
                mLauncher.mHandler.postDelayed(() -> {
                    Log.d("initializeAppList()", "openPinnedPip()");
                    WindowUtil.openPinnedPip();
                }, 1500); 
            }
        }
        mLauncher.mHomeRecovery.scheduleHomeLayoutWatchdog("appListInitialized", !mLauncher.isAllAppsVisible());
    }

    void refreshRecyclerViewDecorations() {
        if (mLauncher.mWorkspace == null) {
            return;
        }
        // Refresh main recycler view
        mRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (mRecyclerView != null) {
            // Re-apply the dynamic bar height first so the rebind below sizes the icons against it.
            // (Workspace skips this if the bar was inflated for another orientation.)
            ensureResizableBottomBar("configuration");
        }
        if (mRecyclerView != null && mAppListAdapter != null) {
            mAppListAdapter.notifyDataSetChanged();
            rebuildBottomBarForCapacity();
        }
        
        // Refresh left recycler view
        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.leftBar = mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (mLauncher.userLayout && mLauncher.leftBar || !mLauncher.userLayout) {
            RecyclerView mLeftRecyclerView = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);
            if (mLeftRecyclerView != null && mLeftAppListAdapter != null) {
                mLeftAppListAdapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * The room for the bottom bar's slots may have changed without the rows having done so (the
     * bar height, the widget bar, a turn of the screen): rebuilds the list when the capacity is no
     * longer the one it was built for. refreshCycle() compares signatures, which include the
     * capacity, so nothing is rebuilt - and nothing loops - while the capacity stays the same.
     */
    void rebuildBottomBarForCapacity() {
        if (!hasCurrentAppListData()) {
            return; // nothing built yet; the first build uses the current capacity
        }
        List<AppMultiple> rows = queryBottomAppRows();
        if (rows != null && !rows.isEmpty()) {
            refreshCycle(rows);
        }
    }

    public void refreshCycle(List<AppMultiple> data) {
        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.widgetBar = mLauncher.mPrefs.getBoolean(Keys.WIDGET_BAR, false);

        final int capacity = bottomCapacity(mLauncher.userLayout, mLauncher.widgetBar);
        data = ensureBottomRows(data, capacity);
        long sourceSignature = calculateAppRowsSignature(data, mLauncher.userLayout,
                mLauncher.widgetBar, capacity);
        if (sourceSignature == mLastAppListSourceSignature && hasCurrentAppListData()) {
            Log.d(Launcher.TAG, "refreshCycle: unchanged, skipping adapter rebuild");
            return;
        }

        boolean hasExistingAppListData = hasCurrentAppListData();

        if (data == null || data.isEmpty()) {
            // Never blank the bar on an empty read - either keep what is on screen or
            // let initializeAppList() create the defaults.
            if (hasExistingAppListData) {
                Log.w(Launcher.TAG, "refreshCycle: empty app rows during refresh, keeping current list");
                scheduleAppListInitializationRetry("refreshCycleEmptyRows");
            } else {
                scheduleAppListInitializationRetry("refreshCycleNoRows");
            }
            return;
        }

        Map<String, AppInfo> appInfoLookup = buildAppInfoLookup();
        Map<String, Boolean> installCache = new HashMap<>();

        BarSnapshotCollector bottomSnapshot = new BarSnapshotCollector();
        List<AppListBean> nextAppListData =
                buildBottomAppBeans(data, appInfoLookup, installCache, capacity, bottomSnapshot);

        // Same regression guard as initializeAppList(): only swap the list in when it is
        // at least as complete as the database says it should be.
        boolean safeToUpdate = true;
        if (hasExistingAppListData) {
            int installedDbCount = countInstalledBottomRows(data, installCache, capacity);
            int newRealCount = countRealBeans(nextAppListData);
            if (newRealCount < installedDbCount) {
                Log.w(Launcher.TAG, "refreshCycle: new list (" + newRealCount
                        + " real apps) fewer than installed DB entries (" + installedDbCount
                        + ") - keeping current list to avoid blank bar");
                safeToUpdate = false;
            }
        }

        if (safeToUpdate && mAppListAdapter != null) {
            mAppListData = nextAppListData;
            mAppListAdapter.notifyDataSetChanged(mAppListData);
            mLastAppListSourceSignature = sourceSignature;
            saveBottomBarSnapshot(data, mLauncher.userLayout, mLauncher.widgetBar, capacity, bottomSnapshot);
        } else if (!safeToUpdate) {
            scheduleAppListInitializationRetry("refreshCycleIncompleteAllAppsList");
        }
    }

    public void refreshLeftCycle(AppListBean bean) {
        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.leftBar = mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (!(mLauncher.userLayout && mLauncher.leftBar || !mLauncher.userLayout)) return;
        
        Log.d(Launcher.TAG, "--------------->>>   refreshLeftCycle");
        // The database off the main thread (StrictMode, a tap on every app opened), in order
        LEFT_CYCLE_WRITER.execute(() -> {
            List<LeftAppMultiple> topRows;
            try {
                topRows = writeLeftCycle(bean);
            } catch (RuntimeException e) {
                Log.w(Launcher.TAG, "refreshLeftCycle: left bar rows not written", e);
                return;
            }
            mLauncher.mHandler.post(() -> refreshLeftBar(topRows));
        });
    }

    private static final ExecutorService LEFT_CYCLE_WRITER =
            Executors.newSingleThreadExecutor(r -> new Thread(r, "LeftCycleWriter"));

    /** The opened app first in the left bar's rows; returns the rows to show. */
    private List<LeftAppMultiple> writeLeftCycle(AppListBean bean) {
        // Get all physical rows from database
        List<LeftAppMultiple> physical = LitePal.order("id asc").find(LeftAppMultiple.class);
        
        // Ensure we have enough placeholder rows: the bar remembers LEFT_MEMORY apps, installs from
        // before that held fewer rows and get the rest here, after the ones they have (id order).
        if (physical.size() < BarCapacity.LEFT_MEMORY) {
            int need = BarCapacity.LEFT_MEMORY - physical.size();
            for (int i = 0; i < need; i++) {
                new LeftAppMultiple(0, "", "", "").save();
            }
            BarRows.invalidate();
            physical = LitePal.order("id asc").find(LeftAppMultiple.class);
        }
        
        // Create a list of currently installed apps (excluding placeholders)
        List<LeftAppMultiple> currentInstalled = new ArrayList<>();
        Map<String, Boolean> installCache = new HashMap<>();
        for (LeftAppMultiple row : physical) {
            if (!TextUtils.isEmpty(row.packageName)
                    && !TextUtils.isEmpty(row.name)
                    && isPackageInstalledCached(installCache, row.packageName)) {
                currentInstalled.add(row);
            }
        }
        
        // Remove the app if it already exists in current list
        Iterator<LeftAppMultiple> iterator = currentInstalled.iterator();
        while (iterator.hasNext()) {
            LeftAppMultiple existing = iterator.next();
            if (bean.packageName.equals(existing.packageName) && 
                bean.className.equals(existing.className)) {
                iterator.remove();
                break;
            }
        }
        
        // Create new desired order: new app at position 0, then existing apps
        List<LeftAppMultiple> desired = new ArrayList<>(BarCapacity.LEFT_MEMORY);
        desired.add(new LeftAppMultiple(0, bean.name, bean.packageName, bean.className));
        
        // Add existing installed apps until we reach BarCapacity.LEFT_MEMORY
        for (LeftAppMultiple existing : currentInstalled) {
            if (desired.size() >= BarCapacity.LEFT_MEMORY) break;
            desired.add(existing);
        }
        
        // Fill remaining slots with empty placeholders if needed
        while (desired.size() < BarCapacity.LEFT_MEMORY) {
            desired.add(new LeftAppMultiple(0, "", "", ""));
        }
        
        // Update database with new order
        for (int i = 0; i < BarCapacity.LEFT_MEMORY; i++) {
            LeftAppMultiple src = desired.get(i);
            LeftAppMultiple dst = physical.get(i);
            
            ContentValues v = new ContentValues();
            v.put("name", src.name);
            v.put("packageName", src.packageName);
            v.put("className", src.className);
            LitePal.update(LeftAppMultiple.class, v, dst.id);
            BarRows.invalidate();
        }
        
        return BarRows.left(BarCapacity.LEFT_MEMORY);
    }

    public void refreshLeftBar(@Nullable List<LeftAppMultiple> leftAppData) {
        mLauncher.userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        mLauncher.leftBar = mLauncher.mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (!(mLauncher.userLayout && mLauncher.leftBar || !mLauncher.userLayout)) return;

        Log.d(Launcher.TAG, "--------------->>>   refreshLeftBar");

        final int capacity = leftCapacity();
        final List<LeftAppMultiple> src = (leftAppData != null && !leftAppData.isEmpty())
                ? leftAppData
                : BarRows.left(BarCapacity.LEFT_MEMORY);
        long sourceSignature = calculateLeftAppRowsSignature(src, capacity);
        if (sourceSignature == mLastLeftAppListSourceSignature
                && mLeftAppListAdapter != null
                && mLeftAppListAdapter.getItemCount() > 0
                && mLeftAppListData != null
                && !mLeftAppListData.isEmpty()) {
            Log.d(Launcher.TAG, "refreshLeftBar: unchanged, skipping adapter rebuild");
            return;
        }

        boolean hasExistingLeftListData = hasCurrentLeftAppListData();
        List<AppListBean> nextLeftAppListData = new ArrayList<>();
        BarSnapshotCollector leftSnapshot = new BarSnapshotCollector();

        Map<String, AppInfo> appInfoLookup = buildAppInfoLookup();
        Map<String, Boolean> installCache = new HashMap<>();

        if ((src == null || src.isEmpty()) && hasExistingLeftListData) {
            Log.w(Launcher.TAG, "refreshLeftBar: empty rows during refresh, keeping current list");
            scheduleAppListInitializationRetry("refreshLeftBarEmptyRows");
            return;
        }

        int added = 0;
        for (LeftAppMultiple row : src) {
            if (added >= capacity) break;
            if (!isPackageInstalledCached(installCache, row.packageName)) continue;

            AppListBean bean = null;
            String beanName = null;
            Bitmap beanIcon = null;

            AppInfo app = findAppInfo(appInfoLookup, row.packageName, row.className);
            if (app != null) {
                beanName = app.title != null ? app.title.toString() : "";
                beanIcon = app.iconBitmap;
                bean = new AppListBean(
                        beanName,
                        beanIcon,
                        row.packageName,
                        row.className
                );
            } else {
                Bitmap icon = loadLeftBarIconStrict(row.packageName, row.className);
                if (icon != null) {
                    beanName = row.name != null ? row.name : "";
                    beanIcon = icon;
                    leftSnapshot.usedFallbackIcon = true;
                    bean = new AppListBean(
                            beanName,
                            beanIcon,
                            row.packageName,
                            row.className
                    );
                }
            }

            if (bean == null) {
                continue;
            }

            // Same rule as the bottom bar: the bean remembers which physical row it came
            // from. The visible left list is compacted (rows whose package is gone are
            // skipped), so the adapter position is NOT the row position.
            bean.rowId = row.rowId();
            nextLeftAppListData.add(bean);
            leftSnapshot.add((long) row.id, row.packageName, row.className, beanName, beanIcon);
            added++;
        }
        if (mLeftAppListAdapter != null) {
            mLeftAppListData = nextLeftAppListData;
            mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
            mLastLeftAppListSourceSignature = sourceSignature;
            saveLeftBarSnapshot(src, capacity, leftSnapshot);
        }
    }

    /**
     * Clears every left-bar row pointing at one of the just-uninstalled packages and compacts the
     * remaining rows upwards, mirroring the ordering logic of refreshLeftCycle().
     * Returns true when the database was actually modified.
     */
    boolean pruneLeftBarRows(ArrayList<String> packageNames) {
        if (packageNames == null || packageNames.isEmpty()) {
            return false;
        }
        List<LeftAppMultiple> physical = LitePal.order("id asc").find(LeftAppMultiple.class);
        if (physical == null || physical.isEmpty()) {
            return false;
        }

        List<LeftAppMultiple> survivors = new ArrayList<>();
        boolean removed = false;
        for (LeftAppMultiple row : physical) {
            if (row == null || TextUtils.isEmpty(row.packageName)) {
                continue;
            }
            if (packageNames.contains(row.packageName)) {
                removed = true;
                continue;
            }
            survivors.add(row);
        }
        if (!removed) {
            return false;
        }

        for (int i = 0; i < physical.size(); i++) {
            LeftAppMultiple dst = physical.get(i);
            ContentValues v = new ContentValues();
            if (i < survivors.size()) {
                LeftAppMultiple src = survivors.get(i);
                v.put("name", src.name == null ? "" : src.name);
                v.put("packageName", src.packageName == null ? "" : src.packageName);
                v.put("className", src.className == null ? "" : src.className);
            } else {
                v.put("name", "");
                v.put("packageName", "");
                v.put("className", "");
            }
            LitePal.update(LeftAppMultiple.class, v, dst.id);
            BarRows.invalidate();
        }

        mLastLeftAppListSourceSignature = Long.MIN_VALUE;
        Log.d(Launcher.TAG, "pruneLeftBarRows: left bar compacted after uninstall of " + packageNames);
        return true;
    }

    /**
     * Immediately turns every bottom-bar tile whose package was just uninstalled into the
     * "+" placeholder, instead of waiting for the delayed triggerAppData() rebuild.
     *
     * The AppMultiple row itself is deliberately NOT touched: the slot must survive an
     * uninstall, it just becomes empty. That is also why the row signature does not
     * change on its own and why the signature has to be invalidated by hand here.
     *
     * @return true if anything visible changed
     */
    boolean pruneBottomBarBeans(ArrayList<String> packageNames) {
        if (packageNames == null || packageNames.isEmpty()
                || mAppListData == null || mAppListData.isEmpty()) {
            return false;
        }

        List<AppListBean> next = new ArrayList<AppListBean>(mAppListData.size());
        boolean changed = false;
        Bitmap addIcon = null;

        for (AppListBean bean : mAppListData) {
            if (bean == null) {
                continue;
            }
            if (bean.packageName == null || !packageNames.contains(bean.packageName)) {
                next.add(bean);
                continue;
            }

            if (addIcon == null) {
                addIcon = BitmapFactory.decodeResource(mLauncher.getResources(), R.drawable.icon_add);
            }

            AppListBean placeholder = new AppListBean("", addIcon, FytPackage.AddAction, "");
            placeholder.rowId = bean.rowId;
            placeholder.slot = bean.slot;
            next.add(placeholder);
            changed = true;

            if (bean.rowId > 0L) {
                ContentValues v = new ContentValues();
                v.put("name", "");
                v.put("packageName", FytPackage.AddAction);
                v.put("className", "");
                try {
                    LitePal.update(AppMultiple.class, v, bean.rowId);
                    BarRows.invalidate();
                } catch (Exception e) {
                    Log.e(Launcher.TAG, "pruneBottomBarBeans: failed to clear row " + bean.rowId, e);
                }
            } else {
                Log.w(Launcher.TAG, "pruneBottomBarBeans: bean for " + bean.packageName
                        + " has no rowId, slot cleared in memory only");
            }
        }

        if (!changed) {
            return false;
        }

        mAppListData = next;
        if (mAppListAdapter != null) {
            mAppListAdapter.notifyDataSetChanged(mAppListData);
        }
        mLastAppListSourceSignature = Long.MIN_VALUE;
        Log.d(Launcher.TAG, "pruneBottomBarBeans: slots emptied after uninstall of " + packageNames);
        return true;
    }

    /** In-memory counterpart of pruneLeftBarRows(): drops the tiles right away. */
    boolean pruneLeftBarBeans(ArrayList<String> packageNames) {
        if (packageNames == null || packageNames.isEmpty()
                || mLeftAppListData == null || mLeftAppListData.isEmpty()) {
            return false;
        }

        List<AppListBean> next = new ArrayList<AppListBean>(mLeftAppListData.size());
        boolean changed = false;
        for (AppListBean bean : mLeftAppListData) {
            if (bean == null) {
                continue;
            }
            if (bean.packageName != null && packageNames.contains(bean.packageName)) {
                changed = true;
                continue;
            }
            next.add(bean);
        }

        if (!changed) {
            return false;
        }

        mLeftAppListData = next;
        if (mLeftAppListAdapter != null) {
            mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
        }
        mLastLeftAppListSourceSignature = Long.MIN_VALUE;
        return true;
    }

    /**
     * Writes the first eight rows of the bottom bar. Only the rows matter: initializeAppList()
     * reads them back (BarRows) and builds the beans from them, for whatever capacity the bar has.
     */
    void createDefaultAppEntries() {
        String appName1 = Utils.getNameToStr("car_navi");
        String appName2 = Utils.getNameToStr("car_music");
        String appName3 = Utils.getNameToStr("car_video");
        String appName4 = Utils.getNameToStr("car_radio");
        String appName5 = Utils.getNameToStr("car_bt");
        String appName6 = Utils.getNameToStr("car_eq");
        String appName7 = Utils.getNameToStr("car_settings");
        String appName8 = Utils.getNameToStr("");

        if (mLauncher.helpers.isPackageInstalled(FytPackage.naviAction)) {
            new AppMultiple(0, appName1, FytPackage.naviAction, "com.syu.onekeynavi.MainActivity").save();
        } else {
            new AppMultiple(0, "", FytPackage.AddAction, "").save();
        }

        if (mLauncher.helpers.isPackageInstalled("com.syu.music")) {
            new AppMultiple(1, appName2, "com.syu.music", "com.syu.app.Activity_All").save();
        } else {
            new AppMultiple(1, "", FytPackage.AddAction, "").save();
        }

        if (mLauncher.helpers.isPackageInstalled("com.syu.video")) {
            new AppMultiple(2, appName3, "com.syu.video", "com.syu.video.main.VideoListActivity").save();
        } else {
            new AppMultiple(2, "", FytPackage.AddAction, "").save();
        }

        if (mLauncher.helpers.isPackageInstalled("com.syu.radio")) {
            new AppMultiple(3, appName4, "com.syu.radio", "com.syu.radio.Launch").save();
        } else {
            new AppMultiple(3, "", FytPackage.AddAction, "").save();
        }

        if (mLauncher.helpers.isPackageInstalled("com.syu.bt")) {
            new AppMultiple(4, appName5, "com.syu.bt", "com.syu.bt.BtAct").save();
        } else {
            new AppMultiple(4, "", FytPackage.AddAction, "").save();
        }

        if (mLauncher.helpers.isPackageInstalled("com.android.launcher66")) {
            new AppMultiple(5, appName6, "com.android.launcher66", "com.android.launcher66.settings.SettingsActivity").save();
        } else {
            new AppMultiple(5, "", FytPackage.AddAction, "").save();
        }

        new AppMultiple(6, appName7, "com.syu.settings", "com.syu.settings.MainActivity").save();

        new AppMultiple(7, appName8, FytPackage.AddAction, "").save();
        BarRows.invalidate();
    }

    public void enableRecycler() {
        if (mRecyclerView != null) {
            mRecyclerView.setEnabled(true);
            mRecyclerView.setClickable(true);
            mRecyclerView.setLongClickable(true);
            mRecyclerView.setVisibility(View.VISIBLE);
            Log.i(Launcher.TAG, "Recycler enabled");
        }
    }

    public void disableRecycler() {
        if (mRecyclerView != null) {
            mRecyclerView.setEnabled(false);
            mRecyclerView.setClickable(false);
            mRecyclerView.setLongClickable(false);
            mRecyclerView.setVisibility(View.GONE);
            Log.i(Launcher.TAG, "Recycler disabled");
        }
    }

    /**
     * Returns true if any of the given package names is currently configured as a bottom-bar
     * shortcut (stored in AppMultiple) or left-bar shortcut (LeftAppMultiple).
     * Used to avoid needlessly re-running initAppData for unrelated package change events.
     */
    boolean isPackageInBottomBar(ArrayList<String> packageNames) {
        if (packageNames == null || packageNames.isEmpty()) return false;
        if (mAppListData != null) {
            for (AppListBean bean : mAppListData) {
                if (packageNames.contains(bean.packageName)) return true;
            }
        }
        if (mLeftAppListData != null) {
            for (AppListBean bean : mLeftAppListData) {
                if (packageNames.contains(bean.packageName)) return true;
            }
        }
        return false;
    }

    boolean isAppInfoInBottomBar(ArrayList<AppInfo> appInfos) {
        if (appInfos == null || appInfos.isEmpty()) return false;
        ArrayList<String> pkgs = new ArrayList<>();
        for (AppInfo ai : appInfos) pkgs.add(ai.getPackageName());
        return isPackageInBottomBar(pkgs);
    }

    Bitmap loadAppIconFromPackageManager(String packageName, String className) {
        String cacheKey = appIconCacheKey(packageName, className);
        Bitmap cached = mAppIconBitmapCache.get(cacheKey);
        if (cached != null) {
            return cached;
        }

        try {
            PackageManager pm = mLauncher.getPackageManager();
            ComponentName component = new ComponentName(packageName, className);
            Drawable drawable = pm.getActivityIcon(component);
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                int width = Math.max(1, drawable.getIntrinsicWidth());
                int height = Math.max(1, drawable.getIntrinsicHeight());
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
            if (bitmap != null) {
                mAppIconBitmapCache.put(cacheKey, bitmap);
            }
            return bitmap;
        } catch (Exception e) {
            Log.e(Launcher.TAG, "Error loading icon for " + packageName + ": " + e.getMessage());
            return BitmapFactory.decodeResource(mLauncher.getResources(), R.drawable.icon_add);
        }
    }

    /**
     * Strict icon loader used ONLY by the left bar. Returns null when the package/component can
     * no longer be resolved (e.g. it has just been uninstalled) instead of falling back to the
     * "add app" placeholder icon that the bottom bar legitimately uses.
     */
    Bitmap loadLeftBarIconStrict(String packageName, String className) {
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        PackageManager pm = mLauncher.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 0);
        } catch (Exception e) {
            // Package gone -> caller must drop this row completely.
            return null;
        }

        String cacheKey = appIconCacheKey(packageName, className);
        Bitmap cached = mAppIconBitmapCache.get(cacheKey);
        if (cached != null && !cached.isRecycled()) {
            return cached;
        }

        Drawable drawable = null;
        try {
            if (!TextUtils.isEmpty(className)) {
                drawable = pm.getActivityIcon(new ComponentName(packageName, className));
            }
        } catch (Exception e) {
            drawable = null;
        }
        if (drawable == null) {
            // Activity renamed but package still installed -> fall back to its launch component.
            try {
                Intent launch = pm.getLaunchIntentForPackage(packageName);
                if (launch != null && launch.getComponent() != null) {
                    drawable = pm.getActivityIcon(launch.getComponent());
                }
            } catch (Exception e) {
                drawable = null;
            }
        }
        if (drawable == null) {
            Log.w(Launcher.TAG, "loadLeftBarIconStrict: no icon for " + packageName + "/" + className);
            return null;
        }

        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable && ((BitmapDrawable) drawable).getBitmap() != null) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            int width = Math.max(1, drawable.getIntrinsicWidth());
            int height = Math.max(1, drawable.getIntrinsicHeight());
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        if (bitmap != null) {
            mAppIconBitmapCache.put(cacheKey, bitmap);
        }
        return bitmap;
    }

    String appIconCacheKey(String packageName, String className) {
        return String.valueOf(packageName) + "/" + String.valueOf(className);
    }

    void clearAppIconBitmapCache() {
        mAppIconBitmapCache.clear();
    }
}
