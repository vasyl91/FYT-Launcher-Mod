package com.android.launcher66;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.ref.WeakReference;

public class LauncherAppState {
    private static LauncherAppState INSTANCE = null;
    private static final String SHARED_PREFERENCES_KEY = "com.android.launcher66.prefs";
    private static final String TAG = "LauncherAppState";
    static boolean appsWidgetsDetach = true;
    private static Context sContext;
    private static WeakReference<LauncherProvider> sLauncherProvider;
    private AppFilter mAppFilter;
    private DynamicGrid mDynamicGrid;
    private IconCache mIconCache;
    private boolean mIsScreenLarge;
    private LauncherModel mModel;
    private float mScreenDensity;
    private WidgetPreviewLoader.CacheDb mWidgetPreviewCacheDb;
    private int mLongPressTimeout = 300;
    private final ContentObserver mFavoritesObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
        @Override
        public void onChange(boolean selfChange) {
            LauncherAppState.this.mModel.resetLoadedState(false, true);
            LauncherAppState.this.mModel.startLoaderFromBackground();
        }
    };

    public static LauncherAppState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LauncherAppState();
        }
        return INSTANCE;
    }

    public static LauncherAppState getInstanceNoCreate() {
        return INSTANCE;
    }

    public Context getContext() {
        return sContext;
    }

    public static void setApplicationContext(Context context) {
        if (sContext != null) {
            Log.w("Launcher", "setApplicationContext called twice! old=" + sContext + " new=" + context);
        }
        sContext = context.getApplicationContext();
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private LauncherAppState() {
        if (sContext == null) {
            throw new IllegalStateException("LauncherAppState inited before app context set");
        }
        Log.v("Launcher", "LauncherAppState inited");
        if (sContext.getResources().getBoolean(R.bool.debug_memory_enabled)) {
            MemoryTracker.startTrackingMe(sContext, "L");
        }
        this.mIsScreenLarge = isScreenLarge(sContext.getResources());
        this.mScreenDensity = sContext.getResources().getDisplayMetrics().density;
        this.mWidgetPreviewCacheDb = new WidgetPreviewLoader.CacheDb(sContext);
        this.mIconCache = new IconCache(sContext);
        appsWidgetsDetach = sContext.getResources().getBoolean(R.bool.apps_widgets_detach);
        this.mAppFilter = AppFilter.loadByName(sContext.getString(R.string.app_filter_class));
        this.mModel = new LauncherModel(this, this.mIconCache, this.mAppFilter);
        IntentFilter filter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addDataScheme("package");
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        filter2.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        filter2.addAction("android.intent.action.LOCALE_CHANGED");
        filter2.addAction("android.intent.action.CONFIGURATION_CHANGED");
        IntentFilter filter3 = new IntentFilter();
        filter3.addAction("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
        IntentFilter filter4 = new IntentFilter();
        filter4.addAction("android.search.action.SEARCHABLES_CHANGED");
        ContentResolver resolver = sContext.getContentResolver();
        resolver.registerContentObserver(LauncherSettings.Favorites.CONTENT_URI, true, this.mFavoritesObserver);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            sContext.registerReceiver(this.mModel, filter, Context.RECEIVER_EXPORTED);
            sContext.registerReceiver(this.mModel, filter2, Context.RECEIVER_EXPORTED);
            sContext.registerReceiver(this.mModel, filter3, Context.RECEIVER_EXPORTED);
            sContext.registerReceiver(this.mModel, filter4, Context.RECEIVER_EXPORTED);
        } else {
            sContext.registerReceiver(this.mModel, filter);
            sContext.registerReceiver(this.mModel, filter2);
            sContext.registerReceiver(this.mModel, filter3);
            sContext.registerReceiver(this.mModel, filter4);
        }
    }

    public void onTerminate() {
        sContext.unregisterReceiver(this.mModel);
        ContentResolver resolver = sContext.getContentResolver();
        resolver.unregisterContentObserver(this.mFavoritesObserver);
    }

    LauncherModel setLauncher(Launcher launcher) {
        if (this.mModel == null) {
            throw new IllegalStateException("setLauncher() called before init()");
        }
        this.mModel.initialize(launcher);
        return this.mModel;
    }

    public IconCache getIconCache() {
        return this.mIconCache;
    }

    LauncherModel getModel() {
        return this.mModel;
    }

    boolean shouldShowAppOrWidgetProvider(ComponentName componentName) {
        return this.mAppFilter == null || this.mAppFilter.shouldShowApp(componentName);
    }

    WidgetPreviewLoader.CacheDb getWidgetPreviewCacheDb() {
        return this.mWidgetPreviewCacheDb;
    }

    static void setLauncherProvider(LauncherProvider provider) {
        sLauncherProvider = new WeakReference<>(provider);
    }

    static LauncherProvider getLauncherProvider() {
        return sLauncherProvider.get();
    }

    public static String getSharedPreferencesKey() {
        return SHARED_PREFERENCES_KEY;
    }

    DeviceProfile initDynamicGrid(Context context, int minWidth, int minHeight, int width, int height, int availableWidth, int availableHeight) {
        if (this.mDynamicGrid == null) {
            this.mDynamicGrid = new DynamicGrid(context, context.getResources(), minWidth, minHeight, width, height, availableWidth, availableHeight);
        }
        DeviceProfile grid = this.mDynamicGrid.getDeviceProfile();
        Utilities.setIconSize(Launcher.app_icon_size);
        grid.updateFromConfiguration(context.getResources(), width, height, availableWidth, availableHeight);
        return grid;
    }

    public DynamicGrid getDynamicGrid() {
        return this.mDynamicGrid;
    }

    public boolean isScreenLarge() {
        return this.mIsScreenLarge;
    }

    public static boolean isScreenLarge(Resources res) {
        return res.getBoolean(R.bool.is_large_tablet);
    }

    public static boolean isScreenLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public float getScreenDensity() {
        return this.mScreenDensity;
    }

    public int getLongPressTimeout() {
        return this.mLongPressTimeout;
    }
}
