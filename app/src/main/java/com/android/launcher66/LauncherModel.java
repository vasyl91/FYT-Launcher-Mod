package com.android.launcher66;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.core.content.IntentCompat;
import android.util.Log;
import android.util.Pair;
import com.android.launcher66.InstallWidgetReceiver;
import com.android.launcher66.LauncherSettings;
import com.android.launcher66.config.ProviderConfig;
import com.android.recycler.AppMultiple;
import com.syu.car.CustomFilter;
import com.syu.log.LogPreview;
import com.syu.util.CustomIcons;
import com.syu.util.FytPackage;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.litepal.LitePal;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class LauncherModel extends BroadcastReceiver {
    public static final Comparator<AppInfo> APP_INSTALL_TIME_COMPARATOR;
    static final boolean DEBUG_LOADERS = false;
    private static final int ITEMS_CHUNK = 6;
    private static final int MAIN_THREAD_BINDING_RUNNABLE = 1;
    private static final int MAIN_THREAD_NORMAL_RUNNABLE = 0;
    static final String TAG = "Launcher.Model";
    public static final boolean UPGRADE_USE_MORE_APPS_FOLDER = false;
    static final ArrayList<Runnable> mDeferredBindRunnables;
    static final ArrayList<LauncherAppWidgetInfo> sBgAppWidgets;
    static final HashMap<Object, byte[]> sBgDbIconCache;
    static final HashMap<Long, FolderInfo> sBgFolders;
    static final HashMap<Long, ItemInfo> sBgItemsIdMap;
    static final Object sBgLock;
    static final ArrayList<ItemInfo> sBgWorkspaceItems;
    static final ArrayList<Long> sBgWorkspaceScreens;
    private static final Handler sWorker;
    private static final HandlerThread sWorkerThread = new HandlerThread("launcher-loader");
    private boolean mAllAppsLoaded;
    private final LauncherAppState mApp;
    private AppFilter mAppFilter;
    private final boolean mAppsCanBeOnRemoveableStorage;
    AllAppsList mBgAllAppsList;
    private WeakReference<Callbacks> mCallbacks;
    private Bitmap mDefaultIcon;
    boolean mFirstUse;
    private volatile boolean mFlushingWorkerThread;
    private IconCache mIconCache;
    private boolean mIsLoaderTaskRunning;
    private LoaderTask mLoaderTask;
    protected int mPreviousConfigMcc;
    private boolean mWorkspaceLoaded;
    private final Object mLock = new Object();
    private DeferredHandler mHandler = new DeferredHandler();
    Runnable reload = new Runnable() { // from class: com.android.launcher66.LauncherModel.1
        @Override // java.lang.Runnable
        public void run() {
            LauncherModel.this.forceReload();
        }
    };

    public interface Callbacks {
        void bindAddScreens(ArrayList<Long> arrayList);

        void bindAllApplications(ArrayList<AppInfo> arrayList);

        void bindAppWidget(LauncherAppWidgetInfo launcherAppWidgetInfo);

        void bindAppsAdded(ArrayList<Long> arrayList, ArrayList<ItemInfo> arrayList2, ArrayList<ItemInfo> arrayList3, ArrayList<AppInfo> arrayList4);

        void bindAppsUpdated(ArrayList<AppInfo> arrayList);

        void bindComponentsRemoved(ArrayList<String> arrayList, ArrayList<AppInfo> arrayList2, boolean z);

        void bindFolders(HashMap<Long, FolderInfo> hashMap);

        void bindItems(ArrayList<ItemInfo> arrayList, int i, int i2, boolean z);

        void bindPackagesUpdated(ArrayList<Object> arrayList);

        void bindScreens(ArrayList<Long> arrayList);

        void bindSearchablesChanged();

        void dumpLogsToLocalData();

        void finishBindingItems(boolean z);

        int getCurrentWorkspaceScreen();

        boolean isAllAppsButtonRank(int i);

        void onPageBoundSynchronously(int i);

        boolean setLoadOnResume();

        void startBinding();
    }

    public interface ItemInfoFilter {
        boolean filterItem(ItemInfo itemInfo, ItemInfo itemInfo2, ComponentName componentName);
    }

    static {
        sWorkerThread.start();
        sWorker = new Handler(sWorkerThread.getLooper());
        mDeferredBindRunnables = new ArrayList<>();
        sBgLock = new Object();
        sBgItemsIdMap = new HashMap<>();
        sBgWorkspaceItems = new ArrayList<>();
        sBgAppWidgets = new ArrayList<>();
        sBgFolders = new HashMap<>();
        sBgDbIconCache = new HashMap<>();
        sBgWorkspaceScreens = new ArrayList<>();
        APP_INSTALL_TIME_COMPARATOR = new Comparator<AppInfo>() { // from class: com.android.launcher66.LauncherModel.2
            @Override // java.util.Comparator
            public final int compare(AppInfo a, AppInfo b) {
                if (a.firstInstallTime < b.firstInstallTime) {
                    return 1;
                }
                if (a.firstInstallTime > b.firstInstallTime) {
                    return -1;
                }
                return 0;
            }
        };
    }

    LauncherModel(LauncherAppState app, IconCache iconCache, AppFilter appFilter) {
        this.mFirstUse = true;
        Context context = app.getContext();
        String spKey = LauncherAppState.getSharedPreferencesKey();
        SharedPreferences sp = context.getSharedPreferences(spKey, 0);
        this.mFirstUse = sp.getBoolean("first_use", true);
        this.mAppsCanBeOnRemoveableStorage = Environment.isExternalStorageRemovable();
        this.mApp = app;
        this.mAppFilter = appFilter;
        this.mBgAllAppsList = new AllAppsList(iconCache, appFilter);
        this.mIconCache = iconCache;
        this.mDefaultIcon = Utilities.createIconBitmap(this.mIconCache.getFullResDefaultActivityIcon(), context);
        Resources res = context.getResources();
        Configuration config = res.getConfiguration();
        this.mPreviousConfigMcc = config.mcc;
        if (appFilter != null) {
            appFilter.register();
            if (appFilter instanceof CustomFilter) {
                ((CustomFilter) appFilter).setCallback(new CustomFilter.RefreshCallback() { // from class: com.android.launcher66.LauncherModel.3
                    @Override // com.syu.car.CustomFilter.RefreshCallback
                    public void onRefresh() {
                        if ((LauncherModel.this.mLoaderTask == null || !LauncherModel.this.mLoaderTask.isLaunching()) && LauncherModel.sWorker != null) {
                            LauncherModel.sWorker.removeCallbacks(LauncherModel.this.reload);
                            LauncherModel.sWorker.postDelayed(LauncherModel.this.reload, 100L);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnMainThread(Runnable r) {
        runOnMainThread(r, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnMainThread(Runnable r, int type) {
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            this.mHandler.post(r);
        } else {
            r.run();
        }
    }

    private static void runOnWorkerThread(Runnable r) {
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            r.run();
        } else {
            sWorker.post(r);
        }
    }

    static boolean findNextAvailableIconSpaceInScreen(ArrayList<ItemInfo> items, int[] xy, long screen) {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        int xCount = (int) grid.numColumns;
        int yCount = (int) grid.numRows;
        boolean[][] occupied = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, xCount, yCount);
        for (int i = 0; i < items.size(); i++) {
            ItemInfo item = items.get(i);
            if (item.container == -100 && item.screenId == screen) {
                int cellX = item.cellX;
                int cellY = item.cellY;
                int spanX = item.spanX;
                int spanY = item.spanY;
                for (int x = cellX; x >= 0 && x < cellX + spanX && x < xCount; x++) {
                    for (int y = cellY; y >= 0 && y < cellY + spanY && y < yCount; y++) {
                        occupied[x][y] = true;
                    }
                }
            }
        }
        return CellLayout.findVacantCell(xy, 1, 1, xCount, yCount, occupied);
    }

    static Pair<Long, int[]> findNextAvailableIconSpace(Context context, String name, Intent launchIntent, int firstScreenIndex, ArrayList<Long> workspaceScreens) {
        LauncherAppState app = LauncherAppState.getInstance();
        LauncherModel model = app.getModel();
        synchronized (app) {
            if (sWorkerThread.getThreadId() != Process.myTid()) {
                model.flushWorkerThread();
            }
            ArrayList<ItemInfo> items = getItemsInLocalCoordinates(context);
            int firstScreenIndex2 = Math.min(firstScreenIndex, workspaceScreens.size());
            int count = workspaceScreens.size();
            for (int screen = firstScreenIndex2; screen < count && 0 == 0; screen++) {
                int[] tmpCoordinates = new int[2];
                if (findNextAvailableIconSpaceInScreen(items, tmpCoordinates, workspaceScreens.get(screen).longValue())) {
                    return new Pair<>(workspaceScreens.get(screen), tmpCoordinates);
                }
            }
            return null;
        }
    }

    public void addAndBindAddedApps(Context context, ArrayList<ItemInfo> workspaceApps, ArrayList<AppInfo> allAppsApps) {
        Callbacks cb = this.mCallbacks != null ? this.mCallbacks.get() : null;
        addAndBindAddedApps(context, workspaceApps, cb, allAppsApps);
    }

    public void addAndBindAddedApps(final Context context, final ArrayList<ItemInfo> workspaceApps, final Callbacks callbacks, final ArrayList<AppInfo> allAppsApps) {
        LogPreview.show("addAndBindAddedApps");
        if (!workspaceApps.isEmpty() || !allAppsApps.isEmpty()) {
            Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.4
                @Override // java.lang.Runnable
                public void run() {
                    ShortcutInfo shortcutInfo;
                    final ArrayList<ItemInfo> addedShortcutsFinal = new ArrayList<>();
                    final ArrayList<Long> addedWorkspaceScreensFinal = new ArrayList<>();
                    ArrayList<Long> workspaceScreens = new ArrayList<>();
                    TreeMap<Integer, Long> orderedScreens = LauncherModel.loadWorkspaceScreensDb(context);
                    for (Integer i : orderedScreens.keySet()) {
                        workspaceScreens.add(Long.valueOf(orderedScreens.get(i).longValue()));
                    }
                    if (workspaceScreens.size() <= 0) {
                        workspaceScreens.add(1L);
                    }
                    synchronized (LauncherModel.sBgLock) {
                        Iterator<ItemInfo> iter = workspaceApps.iterator();
                        while (iter.hasNext()) {
                            ItemInfo a = iter.next();
                            String name = a.title.toString();
                            Intent launchIntent = a.getIntent();
                            if (!LauncherModel.shortcutExists(context, name, launchIntent)) {
                                Pair<Long, int[]> coords = LauncherModel.findNextAvailableIconSpace(context, name, launchIntent, 0, workspaceScreens);
                                if (coords == null) {
                                    LauncherProvider lp = LauncherAppState.getLauncherProvider();
                                    for (int numPagesToAdd = Math.max(1, 1 - workspaceScreens.size()); numPagesToAdd > 0; numPagesToAdd--) {
                                        long screenId = lp.generateNewScreenId() + workspaceScreens.get(0).longValue();
                                        workspaceScreens.add(Long.valueOf(screenId));
                                        addedWorkspaceScreensFinal.add(Long.valueOf(screenId));
                                    }
                                    coords = LauncherModel.findNextAvailableIconSpace(context, name, launchIntent, 0, workspaceScreens);
                                }
                                if (coords == null) {
                                    throw new RuntimeException("Coordinates should not be null");
                                }
                                if (a instanceof ShortcutInfo) {
                                    shortcutInfo = (ShortcutInfo) a;
                                } else if (a instanceof AppInfo) {
                                    shortcutInfo = ((AppInfo) a).makeShortcut();
                                } else {
                                    throw new RuntimeException("Unexpected info type");
                                }
                                LauncherModel.addItemToDatabase(context, shortcutInfo, -100L, ((Long) coords.first).longValue(), ((int[]) coords.second)[0], ((int[]) coords.second)[1], false);
                                addedShortcutsFinal.add(shortcutInfo);
                            }
                        }
                    }
                    LauncherModel.this.updateWorkspaceScreenOrder(context, workspaceScreens);
                    if ((addedShortcutsFinal != null && !addedShortcutsFinal.isEmpty()) || (allAppsApps != null && !allAppsApps.isEmpty())) {
                        LauncherModel launcherModel = LauncherModel.this;
                        final Callbacks callbacks2 = callbacks;
                        final ArrayList arrayList = allAppsApps;
                        launcherModel.runOnMainThread(new Runnable() { // from class: com.android.launcher66.LauncherModel.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Callbacks cb;
                                if (LauncherModel.this.mCallbacks != null) {
                                    cb = (Callbacks) LauncherModel.this.mCallbacks.get();
                                } else {
                                    cb = null;
                                }
                                if (callbacks2 == cb && cb != null) {
                                    ArrayList<ItemInfo> addAnimated = new ArrayList<>();
                                    ArrayList<ItemInfo> addNotAnimated = new ArrayList<>();
                                    if (!addedShortcutsFinal.isEmpty()) {
                                        ItemInfo info = (ItemInfo) addedShortcutsFinal.get(addedShortcutsFinal.size() - 1);
                                        long lastScreenId = info.screenId;
                                        Iterator it = addedShortcutsFinal.iterator();
                                        while (it.hasNext()) {
                                            ItemInfo i2 = (ItemInfo) it.next();
                                            if (i2.screenId == lastScreenId) {
                                                addAnimated.add(i2);
                                            } else {
                                                addNotAnimated.add(i2);
                                            }
                                        }
                                    }
                                    callbacks2.bindAppsAdded(addedWorkspaceScreensFinal, addNotAnimated, addAnimated, arrayList);
                                }
                            }
                        });
                    }
                }
            };
            runOnWorkerThread(r);
        }
    }

    public Bitmap getFallbackIcon() {
        return Bitmap.createBitmap(this.mDefaultIcon);
    }

    public void unbindItemInfosAndClearQueuedBindRunnables() {
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            throw new RuntimeException("Expected unbindLauncherItemInfos() to be called from the main thread");
        }
        mDeferredBindRunnables.clear();
        this.mHandler.cancelAllRunnablesOfType(1);
        unbindWorkspaceItemsOnMainThread();
    }

    void unbindWorkspaceItemsOnMainThread() {
        final ArrayList<ItemInfo> tmpWorkspaceItems = new ArrayList<>();
        final ArrayList<ItemInfo> tmpAppWidgets = new ArrayList<>();
        synchronized (sBgLock) {
            tmpWorkspaceItems.addAll(sBgWorkspaceItems);
            tmpAppWidgets.addAll(sBgAppWidgets);
        }
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = tmpWorkspaceItems.iterator();
                while (it.hasNext()) {
                    ItemInfo item = (ItemInfo) it.next();
                    item.unbind();
                }
                Iterator it2 = tmpAppWidgets.iterator();
                while (it2.hasNext()) {
                    ItemInfo item2 = (ItemInfo) it2.next();
                    item2.unbind();
                }
            }
        };
        runOnMainThread(r);
    }

    static void addOrMoveItemInDatabase(Context context, ItemInfo item, long container, long screenId, int cellX, int cellY) {
        if (item.container == -1) {
            addItemToDatabase(context, item, container, screenId, cellX, cellY, false);
        } else {
            moveItemInDatabase(context, item, container, screenId, cellX, cellY);
        }
    }

    static void checkItemInfoLocked(long itemId, ItemInfo item, StackTraceElement[] stackTrace) {
        ItemInfo modelItem = sBgItemsIdMap.get(Long.valueOf(itemId));
        if (modelItem != null && item != modelItem) {
            if ((modelItem instanceof ShortcutInfo) && (item instanceof ShortcutInfo)) {
                ShortcutInfo modelShortcut = (ShortcutInfo) modelItem;
                ShortcutInfo shortcut = (ShortcutInfo) item;
                if (modelShortcut.title.toString().equals(shortcut.title.toString()) && modelShortcut.intent.filterEquals(shortcut.intent) && modelShortcut.id == shortcut.id && modelShortcut.itemType == shortcut.itemType && modelShortcut.container == shortcut.container && modelShortcut.screenId == shortcut.screenId && modelShortcut.cellX == shortcut.cellX && modelShortcut.cellY == shortcut.cellY && modelShortcut.spanX == shortcut.spanX && modelShortcut.spanY == shortcut.spanY) {
                    if (modelShortcut.dropPos != null || shortcut.dropPos != null) {
                        if (modelShortcut.dropPos != null && shortcut.dropPos != null && modelShortcut.dropPos[0] == shortcut.dropPos[0] && modelShortcut.dropPos[1] == shortcut.dropPos[1]) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            String msg = "item: " + (item != null ? item.toString() : "null") + "modelItem: " + (modelItem != null ? modelItem.toString() : "null") + "Error: ItemInfo passed to checkItemInfo doesn't match original";
            RuntimeException e = new RuntimeException(msg);
            if (stackTrace != null) {
                e.setStackTrace(stackTrace);
            }
        }
    }

    static void checkItemInfo(final ItemInfo item) {
        final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        final long itemId = item.id;
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LauncherModel.sBgLock) {
                    LauncherModel.checkItemInfoLocked(itemId, item, stackTrace);
                }
            }
        };
        runOnWorkerThread(r);
    }

    static void updateItemInDatabaseHelper(Context context, final ContentValues values, final ItemInfo item, String callingFunction) {
        final long itemId = item.id;
        final Uri uri = LauncherSettings.Favorites.getContentUri(itemId, false);
        final ContentResolver cr = context.getContentResolver();
        final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.7
            @Override // java.lang.Runnable
            public void run() {
                cr.update(uri, values, null, null);
                LauncherModel.updateItemArrays(item, itemId, stackTrace);
            }
        };
        runOnWorkerThread(r);
    }

    static void updateItemsInDatabaseHelper(Context context, final ArrayList<ContentValues> valuesList, final ArrayList<ItemInfo> items, String callingFunction) {
        final ContentResolver cr = context.getContentResolver();
        final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.8
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<ContentProviderOperation> ops = new ArrayList<>();
                int count = items.size();
                for (int i = 0; i < count; i++) {
                    ItemInfo item = (ItemInfo) items.get(i);
                    long itemId = item.id;
                    Uri uri = LauncherSettings.Favorites.getContentUri(itemId, false);
                    ContentValues values = (ContentValues) valuesList.get(i);
                    ops.add(ContentProviderOperation.newUpdate(uri).withValues(values).build());
                    LauncherModel.updateItemArrays(item, itemId, stackTrace);
                }
                try {
                    cr.applyBatch(ProviderConfig.AUTHORITY, ops);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        runOnWorkerThread(r);
    }

    static void updateItemArrays(ItemInfo item, long itemId, StackTraceElement[] stackTrace) {
        synchronized (sBgLock) {
            checkItemInfoLocked(itemId, item, stackTrace);
            if (item.container != -100 && item.container != -101 && !sBgFolders.containsKey(Long.valueOf(item.container))) {
                String msg = "item: " + item + " container being set to: " + item.container + ", not in the list of folders";
                Log.e(TAG, msg);
            }
            ItemInfo modelItem = sBgItemsIdMap.get(Long.valueOf(itemId));
            if (modelItem.container == -100 || modelItem.container == -101) {
                switch (modelItem.itemType) {
                    case 0:
                    case 1:
                    case 2:
                        if (!sBgWorkspaceItems.contains(modelItem)) {
                            sBgWorkspaceItems.add(modelItem);
                            break;
                        }
                        break;
                }
            } else {
                sBgWorkspaceItems.remove(modelItem);
            }
        }
    }

    public void flushWorkerThread() {
        this.mFlushingWorkerThread = true;
        Runnable waiter = new Runnable() { // from class: com.android.launcher66.LauncherModel.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    notifyAll();
                    LauncherModel.this.mFlushingWorkerThread = false;
                }
            }
        };
        synchronized (waiter) {
            runOnWorkerThread(waiter);
            if (this.mLoaderTask != null) {
                synchronized (this.mLoaderTask) {
                    this.mLoaderTask.notify();
                }
            }
            boolean success = false;
            while (!success) {
                try {
                    waiter.wait();
                    success = true;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static void moveItemInDatabase(Context context, ItemInfo item, long container, long screenId, int cellX, int cellY) {
        item.container = container;
        item.cellX = cellX;
        item.cellY = cellY;
        if (!(context instanceof Launcher) || screenId >= 0 || container != -101) {
            item.screenId = screenId;
        }
        ContentValues values = new ContentValues();
        values.put(Stats.EXTRA_CONTAINER, Long.valueOf(item.container));
        values.put(Stats.EXTRA_CELLX, Integer.valueOf(item.cellX));
        values.put(Stats.EXTRA_CELLY, Integer.valueOf(item.cellY));
        values.put(Stats.EXTRA_SCREEN, Long.valueOf(item.screenId));
        updateItemInDatabaseHelper(context, values, item, "moveItemInDatabase");
    }

    static void moveItemsInDatabase(Context context, ArrayList<ItemInfo> items, long container, int screen) {
        ArrayList<ContentValues> contentValues = new ArrayList<>();
        int count = items.size();
        for (int i = 0; i < count; i++) {
            ItemInfo item = items.get(i);
            item.container = container;
            if (!(context instanceof Launcher) || screen >= 0 || container != -101) {
                item.screenId = screen;
            }
            ContentValues values = new ContentValues();
            values.put(Stats.EXTRA_CONTAINER, Long.valueOf(item.container));
            values.put(Stats.EXTRA_CELLX, Integer.valueOf(item.cellX));
            values.put(Stats.EXTRA_CELLY, Integer.valueOf(item.cellY));
            values.put(Stats.EXTRA_SCREEN, Long.valueOf(item.screenId));
            contentValues.add(values);
        }
        updateItemsInDatabaseHelper(context, contentValues, items, "moveItemInDatabase");
    }

    static void modifyItemInDatabase(Context context, ItemInfo item, long container, long screenId, int cellX, int cellY, int spanX, int spanY) {
        item.container = container;
        item.cellX = cellX;
        item.cellY = cellY;
        item.spanX = spanX;
        item.spanY = spanY;
        if (!(context instanceof Launcher) || screenId >= 0 || container != -101) {
            item.screenId = screenId;
        }
        ContentValues values = new ContentValues();
        values.put(Stats.EXTRA_CONTAINER, Long.valueOf(item.container));
        values.put(Stats.EXTRA_CELLX, Integer.valueOf(item.cellX));
        values.put(Stats.EXTRA_CELLY, Integer.valueOf(item.cellY));
        values.put("spanX", Integer.valueOf(item.spanX));
        values.put("spanY", Integer.valueOf(item.spanY));
        values.put(Stats.EXTRA_SCREEN, Long.valueOf(item.screenId));
        updateItemInDatabaseHelper(context, values, item, "modifyItemInDatabase");
    }

    static void updateItemInDatabase(Context context, ItemInfo item) {
        ContentValues values = new ContentValues();
        item.onAddToDatabase(values);
        item.updateValuesWithCoordinates(values, item.cellX, item.cellY);
        updateItemInDatabaseHelper(context, values, item, "updateItemInDatabase");
    }

    static boolean shortcutExists(Context context, String title, Intent intent) {
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(LauncherSettings.Favorites.CONTENT_URI, new String[]{"title", "intent"}, "title=? and intent=?", new String[]{title, intent.toUri(0)}, null);
        try {
            boolean result = c.moveToFirst();
            return result;
        } finally {
            c.close();
        }
    }

    static ArrayList<ItemInfo> getItemsInLocalCoordinates(Context context) {
        ArrayList<ItemInfo> items = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(LauncherSettings.Favorites.CONTENT_URI, new String[]{LauncherSettings.BaseLauncherColumns.ITEM_TYPE, Stats.EXTRA_CONTAINER, Stats.EXTRA_SCREEN, Stats.EXTRA_CELLX, Stats.EXTRA_CELLY, "spanX", "spanY"}, null, null, null);
        int itemTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ITEM_TYPE);
        int containerIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CONTAINER);
        int screenIndex = c.getColumnIndexOrThrow(Stats.EXTRA_SCREEN);
        int cellXIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLX);
        int cellYIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLY);
        int spanXIndex = c.getColumnIndexOrThrow("spanX");
        int spanYIndex = c.getColumnIndexOrThrow("spanY");
        while (c.moveToNext()) {
            try {
                ItemInfo item = new ItemInfo();
                item.cellX = c.getInt(cellXIndex);
                item.cellY = c.getInt(cellYIndex);
                item.spanX = Math.max(1, c.getInt(spanXIndex));
                item.spanY = Math.max(1, c.getInt(spanYIndex));
                item.container = c.getInt(containerIndex);
                item.itemType = c.getInt(itemTypeIndex);
                item.screenId = c.getInt(screenIndex);
                items.add(item);
            } catch (Exception e) {
                items.clear();
            } finally {
                c.close();
            }
        }
        return items;
    }

    FolderInfo getFolderById(Context context, HashMap<Long, FolderInfo> folderList, long id) {
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(LauncherSettings.Favorites.CONTENT_URI, null, "_id=? and (itemType=? or itemType=?)", new String[]{String.valueOf(id), String.valueOf(2)}, null);
        try {
            if (c.moveToFirst()) {
                int itemTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ITEM_TYPE);
                int titleIndex = c.getColumnIndexOrThrow("title");
                int containerIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CONTAINER);
                int screenIndex = c.getColumnIndexOrThrow(Stats.EXTRA_SCREEN);
                int cellXIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLX);
                int cellYIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLY);
                FolderInfo folderInfo = null;
                switch (c.getInt(itemTypeIndex)) {
                    case 2:
                        folderInfo = findOrMakeFolder(folderList, id);
                        break;
                }
                folderInfo.title = c.getString(titleIndex);
                folderInfo.id = id;
                folderInfo.container = c.getInt(containerIndex);
                folderInfo.screenId = c.getInt(screenIndex);
                folderInfo.cellX = c.getInt(cellXIndex);
                folderInfo.cellY = c.getInt(cellYIndex);
                return folderInfo;
            }
            c.close();
            return null;
        } finally {
            c.close();
        }
    }

    static void addItemToDatabase(Context context, final ItemInfo item, long container, long screenId, int cellX, int cellY, final boolean notify) {
        item.container = container;
        item.cellX = cellX;
        item.cellY = cellY;
        if (!(context instanceof Launcher) || screenId >= 0 || container != -101) {
            item.screenId = screenId;
        }
        final ContentValues values = new ContentValues();
        final ContentResolver cr = context.getContentResolver();
        item.onAddToDatabase(values);
        item.id = LauncherAppState.getLauncherProvider().generateNewItemId();
        values.put("_id", Long.valueOf(item.id));
        item.updateValuesWithCoordinates(values, item.cellX, item.cellY);
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.10
            @Override // java.lang.Runnable
            public void run() {
                cr.insert(notify ? LauncherSettings.Favorites.CONTENT_URI : LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION, values);
                synchronized (LauncherModel.sBgLock) {
                    LauncherModel.checkItemInfoLocked(item.id, item, null);
                    LauncherModel.sBgItemsIdMap.put(Long.valueOf(item.id), item);
                    switch (item.itemType) {
                        case 2:
                            LauncherModel.sBgFolders.put(Long.valueOf(item.id), (FolderInfo) item);
                        case 0:
                        case 1:
                            if (item.container == -100 || item.container == -101) {
                                LauncherModel.sBgWorkspaceItems.add(item);
                                break;
                            } else if (!LauncherModel.sBgFolders.containsKey(Long.valueOf(item.container))) {
                                String msg = "adding item: " + item + " to a folder that  doesn't exist";
                                Log.e(LauncherModel.TAG, msg);
                                break;
                            }
                            break;
                        case 4:
                            LauncherModel.sBgAppWidgets.add((LauncherAppWidgetInfo) item);
                            break;
                    }
                }
            }
        };
        runOnWorkerThread(r);
    }

    static int getCellLayoutChildId(long container, long screen, int localCellX, int localCellY, int spanX, int spanY) {
        return ((((int) container) & 255) << 24) | ((((int) screen) & 255) << 16) | ((localCellX & 255) << 8) | (localCellY & 255);
    }

    static void deleteItemFromDatabase(Context context, final ItemInfo item) {
        LogPreview.show("deleteItemFromDatabase");
        final ContentResolver cr = context.getContentResolver();
        final Uri uriToDelete = LauncherSettings.Favorites.getContentUri(item.id, false);
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.11
            @Override // java.lang.Runnable
            public void run() {
                cr.delete(uriToDelete, null, null);
                synchronized (LauncherModel.sBgLock) {
                    switch (item.itemType) {
                        case 0:
                        case 1:
                            LauncherModel.sBgWorkspaceItems.remove(item);
                            break;
                        case 2:
                            LauncherModel.sBgFolders.remove(Long.valueOf(item.id));
                            for (ItemInfo info : LauncherModel.sBgItemsIdMap.values()) {
                                if (info.container == item.id) {
                                    String msg = "deleting a folder (" + item + ") which still contains items (" + info + ")";
                                    Log.e(LauncherModel.TAG, msg);
                                }
                            }
                            LauncherModel.sBgWorkspaceItems.remove(item);
                            break;
                        case 4:
                            LauncherModel.sBgAppWidgets.remove((LauncherAppWidgetInfo) item);
                            break;
                    }
                    LauncherModel.sBgItemsIdMap.remove(Long.valueOf(item.id));
                    LauncherModel.sBgDbIconCache.remove(item);
                }
            }
        };
        runOnWorkerThread(r);
    }

    void updateWorkspaceScreenOrder(Context context, ArrayList<Long> screens) {
        final ArrayList<Long> screensCopy = new ArrayList<>(screens);
        final ContentResolver cr = context.getContentResolver();
        final Uri uri = LauncherSettings.WorkspaceScreens.CONTENT_URI;
        Iterator<Long> iter = screensCopy.iterator();
        while (iter.hasNext()) {
            long id = iter.next().longValue();
            if (id < 0) {
                iter.remove();
            }
        }
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.12
            @Override // java.lang.Runnable
            public void run() {
                cr.delete(uri, null, null);
                int count = screensCopy.size();
                ContentValues[] values = new ContentValues[count];
                for (int i = 0; i < count; i++) {
                    ContentValues v = new ContentValues();
                    long screenId = ((Long) screensCopy.get(i)).longValue();
                    v.put("_id", Long.valueOf(screenId));
                    v.put("screenRank", Integer.valueOf(i));
                    values[i] = v;
                }
                cr.bulkInsert(uri, values);
                synchronized (LauncherModel.sBgLock) {
                    LauncherModel.sBgWorkspaceScreens.clear();
                    LauncherModel.sBgWorkspaceScreens.addAll(screensCopy);
                }
            }
        };
        runOnWorkerThread(r);
    }

    static void deleteFolderContentsFromDatabase(Context context, final FolderInfo info) {
        final ContentResolver cr = context.getContentResolver();
        Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.13
            @Override // java.lang.Runnable
            public void run() {
                cr.delete(LauncherSettings.Favorites.getContentUri(info.id, false), null, null);
                synchronized (LauncherModel.sBgLock) {
                    LauncherModel.sBgItemsIdMap.remove(Long.valueOf(info.id));
                    LauncherModel.sBgFolders.remove(Long.valueOf(info.id));
                    LauncherModel.sBgDbIconCache.remove(info);
                    LauncherModel.sBgWorkspaceItems.remove(info);
                }
                cr.delete(LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION, "container=" + info.id, null);
                synchronized (LauncherModel.sBgLock) {
                    Iterator<ShortcutInfo> it = info.contents.iterator();
                    while (it.hasNext()) {
                        ItemInfo childInfo = it.next();
                        LauncherModel.sBgItemsIdMap.remove(Long.valueOf(childInfo.id));
                        LauncherModel.sBgDbIconCache.remove(childInfo);
                    }
                }
            }
        };
        runOnWorkerThread(r);
    }

    public void initialize(Callbacks callbacks) {
        synchronized (this.mLock) {
            this.mCallbacks = new WeakReference<>(callbacks);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Callbacks callbacks;
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_CHANGED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_ADDED".equals(action)) {
            String packageName = intent.getData().getSchemeSpecificPart();
            boolean replacing = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            int op = 0;
            if (packageName != null && packageName.length() != 0) {
                if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
                    op = 2;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    List<AppMultiple> appData = LitePal.where("packageName = ?", packageName).find(AppMultiple.class);
                    if (appData.size() > 0) {
                        for (int i = 0; i < appData.size(); i++) {
                            AppMultiple multiple = appData.get(i);
                            ContentValues values = new ContentValues();
                            values.put("name", "");
                            values.put("packageName", FytPackage.AddAction);
                            values.put("className", "");
                            LitePal.update(AppMultiple.class, values, multiple.id);
                        }
                        Launcher.getLauncher().refreshCycle(LitePal.findAll(AppMultiple.class, new long[0]));
                    }
                    if (!replacing) {
                        op = 3;
                    }
                } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    op = !replacing ? 1 : 2;
                }
                if (op != 0) {
                    enqueuePackageUpdated(new PackageUpdatedTask(op, new String[]{packageName}));
                    return;
                }
                return;
            }
            return;
        }
        if (Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action)) {
            String[] packages = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            enqueuePackageUpdated(new PackageUpdatedTask(1, packages));
            startLoaderFromBackground();
            return;
        }
        if (Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action)) {
            String[] packages2 = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            enqueuePackageUpdated(new PackageUpdatedTask(4, packages2));
            return;
        }
        if ("android.intent.action.LOCALE_CHANGED".equals(action)) {
            if (Launcher.getLauncher() != null) {
                Launcher.getLauncher().updateView();
            }
            forceReload();
            return;
        }
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
            Configuration currentConfig = context.getResources().getConfiguration();
            int delay = this.mFirstUse ? 300000 : 0;
            if (SystemClock.elapsedRealtime() > delay && this.mPreviousConfigMcc != currentConfig.mcc) {
                Log.d(TAG, "Reload apps on config change. curr_mcc:" + currentConfig.mcc + " prevmcc:" + this.mPreviousConfigMcc);
                forceReload();
            }
            if (this.mFirstUse) {
                String spKey = LauncherAppState.getSharedPreferencesKey();
                SharedPreferences sp = LauncherApplication.sApp.getSharedPreferences(spKey, 0);
                sp.edit().putBoolean("first_use", false).apply();
                this.mFirstUse = false;
            }
            this.mPreviousConfigMcc = currentConfig.mcc;
            return;
        }
        if ("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED".equals(action) || "android.search.action.SEARCHABLES_CHANGED".equals(action)) {
            if (this.mCallbacks != null && (callbacks = this.mCallbacks.get()) != null) {
                callbacks.bindSearchablesChanged();
                return;
            }
            return;
        }
        if (action.equals("com.syu.launcherdisplayico")) {
            Log.i("hy", "action111111111");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceReload() {
        resetLoadedState(true, true);
        startLoaderFromBackground();
    }

    public void resetLoadedState(boolean resetAllAppsLoaded, boolean resetWorkspaceLoaded) {
        synchronized (this.mLock) {
            stopLoaderLocked();
            if (resetAllAppsLoaded) {
                this.mAllAppsLoaded = false;
            }
            if (resetWorkspaceLoaded) {
                this.mWorkspaceLoaded = false;
            }
        }
    }

    public void startLoaderFromBackground() {
        Callbacks callbacks;
        boolean runLoader = false;
        if (this.mCallbacks != null && (callbacks = this.mCallbacks.get()) != null && !callbacks.setLoadOnResume()) {
            runLoader = true;
        }
        if (runLoader) {
            startLoader(false, -1);
        }
    }

    private boolean stopLoaderLocked() {
        boolean isLaunching = false;
        LoaderTask oldTask = this.mLoaderTask;
        if (oldTask != null) {
            if (oldTask.isLaunching()) {
                isLaunching = true;
            }
            oldTask.stopLocked();
        }
        return isLaunching;
    }

    public void startLoader(boolean isLaunching, int synchronousBindPage) {
        synchronized (this.mLock) {
            mDeferredBindRunnables.clear();
            if (this.mCallbacks != null && this.mCallbacks.get() != null) {
                boolean isLaunching2 = isLaunching || stopLoaderLocked();
                this.mLoaderTask = new LoaderTask(this.mApp.getContext(), isLaunching2);
                if (synchronousBindPage > -1 && this.mAllAppsLoaded && this.mWorkspaceLoaded) {
                    this.mLoaderTask.runBindSynchronousPage(synchronousBindPage);
                } else {
                    sWorkerThread.setPriority(5);
                    sWorker.post(this.mLoaderTask);
                }
            }
        }
    }

    void bindRemainingSynchronousPages() {
        if (!mDeferredBindRunnables.isEmpty()) {
            Iterator<Runnable> it = mDeferredBindRunnables.iterator();
            while (it.hasNext()) {
                Runnable r = it.next();
                this.mHandler.post(r, 1);
            }
            mDeferredBindRunnables.clear();
        }
    }

    public void stopLoader() {
        synchronized (this.mLock) {
            if (this.mLoaderTask != null) {
                this.mLoaderTask.stopLocked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TreeMap<Integer, Long> loadWorkspaceScreensDb(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri screensUri = LauncherSettings.WorkspaceScreens.CONTENT_URI;
        Cursor sc = contentResolver.query(screensUri, null, null, null, null);
        TreeMap<Integer, Long> orderedScreens = new TreeMap<>();
        try {
            int idIndex = sc.getColumnIndexOrThrow("_id");
            int rankIndex = sc.getColumnIndexOrThrow("screenRank");
            while (sc.moveToNext()) {
                try {
                    long screenId = sc.getLong(idIndex);
                    int rank = sc.getInt(rankIndex);
                    orderedScreens.put(Integer.valueOf(rank), Long.valueOf(screenId));
                } catch (Exception e) {
                    Launcher.addDumpLog(TAG, "Desktop items loading interrupted - invalid screens: " + e, true);
                }
            }
            return orderedScreens;
        } finally {
            sc.close();
        }
    }

    public boolean isAllAppsLoaded() {
        return this.mAllAppsLoaded;
    }

    boolean isLoadingWorkspace() {
        synchronized (this.mLock) {
            if (this.mLoaderTask != null) {
                return this.mLoaderTask.isLoadingWorkspace();
            }
            return false;
        }
    }

    private class LoaderTask implements Runnable {
        private Context mContext;
        private boolean mIsLaunching;
        private boolean mIsLoadingAndBindingWorkspace;
        private HashMap<Object, CharSequence> mLabelCache = new HashMap<>();
        private boolean mLoadAndBindStepFinished;
        private boolean mStopped;

        LoaderTask(Context context, boolean isLaunching) {
            this.mContext = context;
            this.mIsLaunching = isLaunching;
        }

        boolean isLaunching() {
            return this.mIsLaunching;
        }

        boolean isLoadingWorkspace() {
            return this.mIsLoadingAndBindingWorkspace;
        }

        private boolean loadAndBindWorkspace() {
            LogPreview.show("loadAndBindWorkspace");
            this.mIsLoadingAndBindingWorkspace = true;
            boolean isUpgradePath = false;
            if (!LauncherModel.this.mWorkspaceLoaded) {
                isUpgradePath = loadWorkspace();
                synchronized (this) {
                    if (this.mStopped) {
                        return isUpgradePath;
                    }
                    LauncherModel.this.mWorkspaceLoaded = true;
                }
            }
            bindWorkspace(-1, isUpgradePath);
            return isUpgradePath;
        }

        private void waitForIdle() {
            synchronized (this) {
                LauncherModel.this.mHandler.postIdle(new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (LoaderTask.this) {
                            LoaderTask.this.mLoadAndBindStepFinished = true;
                            LoaderTask.this.notify();
                        }
                    }
                });
                while (!this.mStopped && !this.mLoadAndBindStepFinished && !LauncherModel.this.mFlushingWorkerThread) {
                    try {
                        wait(1000L);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        void runBindSynchronousPage(int synchronousBindPage) {
            LogPreview.show("runBindSynchronousPage");
            if (synchronousBindPage >= 0) {
                if (LauncherModel.this.mAllAppsLoaded && LauncherModel.this.mWorkspaceLoaded) {
                    synchronized (LauncherModel.this.mLock) {
                        if (LauncherModel.this.mIsLoaderTaskRunning) {
                            throw new RuntimeException("Error! Background loading is already running");
                        }
                    }
                    LauncherModel.this.mHandler.flush();
                    bindWorkspace(synchronousBindPage, false);
                    onlyBindAllApps();
                    return;
                }
                throw new RuntimeException("Expecting AllApps and Workspace to be loaded");
            }
            throw new RuntimeException("Should not call runBindSynchronousPage() without valid page index");
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LauncherModel.this.mLock) {
                LauncherModel.this.mIsLoaderTaskRunning = true;
            }
            synchronized (LauncherModel.this.mLock) {
                Process.setThreadPriority(this.mIsLaunching ? 0 : 10);
            }
            loadAndBindWorkspace();
            if (!this.mStopped) {
                synchronized (LauncherModel.this.mLock) {
                    if (this.mIsLaunching) {
                        Process.setThreadPriority(10);
                    }
                }
                waitForIdle();
                loadAndBindAllApps();
                synchronized (LauncherModel.this.mLock) {
                    Process.setThreadPriority(0);
                }
            }
            synchronized (LauncherModel.sBgLock) {
                for (Object key : LauncherModel.sBgDbIconCache.keySet()) {
                    LauncherModel.this.updateSavedIcon(this.mContext, (ShortcutInfo) key, LauncherModel.sBgDbIconCache.get(key));
                }
                LauncherModel.sBgDbIconCache.clear();
            }
            if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
                verifyApplications();
            }
            this.mContext = null;
            synchronized (LauncherModel.this.mLock) {
                if (LauncherModel.this.mLoaderTask == this) {
                    LauncherModel.this.mLoaderTask = null;
                }
                LauncherModel.this.mIsLoaderTaskRunning = false;
            }
        }

        public void stopLocked() {
            synchronized (this) {
                this.mStopped = true;
                notify();
            }
        }

        Callbacks tryGetCallbacks(Callbacks oldCallbacks) {
            synchronized (LauncherModel.this.mLock) {
                if (this.mStopped) {
                    return null;
                }
                if (LauncherModel.this.mCallbacks == null) {
                    return null;
                }
                Callbacks callbacks = (Callbacks) LauncherModel.this.mCallbacks.get();
                if (callbacks != oldCallbacks) {
                    return null;
                }
                if (callbacks == null) {
                    Log.w(LauncherModel.TAG, "no mCallbacks");
                    return null;
                }
                return callbacks;
            }
        }

        private void verifyApplications() {
            Context context = LauncherModel.this.mApp.getContext();
            ArrayList<ItemInfo> added = new ArrayList<>();
            synchronized (LauncherModel.sBgLock) {
                Iterator<AppInfo> it = AllAppsList.data.iterator();
                while (it.hasNext()) {
                    AppInfo app = it.next();
                    ArrayList<ItemInfo> tmpInfos = LauncherModel.this.getItemInfoForComponentName(app.componentName);
                    if (tmpInfos.isEmpty()) {
                        added.add(app);
                        Log.e(LauncherModel.TAG, "Missing Application on load: " + app);
                    }
                }
            }
            if (!added.isEmpty()) {
                Callbacks cb = LauncherModel.this.mCallbacks != null ? (Callbacks) LauncherModel.this.mCallbacks.get() : null;
                LauncherModel.this.addAndBindAddedApps(context, added, cb, null);
            }
        }

        private boolean checkItemDimensions(ItemInfo info) {
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            return info.cellX + info.spanX > ((int) grid.numColumns) || info.cellY + info.spanY > ((int) grid.numRows);
        }

        private boolean checkItemPlacement(HashMap<Long, ItemInfo[][]> occupied, ItemInfo item, AtomicBoolean deleteOnItemOverlap) {
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            int countX = (int) grid.numColumns;
            int countY = (int) grid.numRows;
            long containerIndex = item.screenId;
            if (item.container == -101) {
                if (LauncherModel.this.mCallbacks == null || ((Callbacks) LauncherModel.this.mCallbacks.get()).isAllAppsButtonRank((int) item.screenId)) {
                    deleteOnItemOverlap.set(true);
                    return false;
                }
                if (occupied.containsKey(-101)) {
                    if (occupied.get(-101)[(int) item.screenId][0] != null) {
                        Log.e(LauncherModel.TAG, "Error loading shortcut into hotseat " + item + " into position (" + item.screenId + ":" + item.cellX + "," + item.cellY + ") occupied by " + occupied.get(-101)[(int) item.screenId][0]);
                        return false;
                    }
                } else {
                    ItemInfo[][] items = (ItemInfo[][]) Array.newInstance((Class<?>) ItemInfo.class, countX + 1, countY + 1);
                    items[(int) item.screenId][0] = item;
                    occupied.put(-101L, items);
                    return true;
                }
            } else if (item.container != -100) {
                return true;
            }
            if (!occupied.containsKey(Long.valueOf(item.screenId))) {
                occupied.put(Long.valueOf(item.screenId), (ItemInfo[][]) Array.newInstance((Class<?>) ItemInfo.class, countX + 1, countY + 1));
            }
            ItemInfo[][] screens = occupied.get(Long.valueOf(item.screenId));
            for (int x = item.cellX; x < item.cellX + item.spanX; x++) {
                for (int y = item.cellY; y < item.cellY + item.spanY; y++) {
                    if (screens[x][y] != null) {
                        Log.e(LauncherModel.TAG, "Error loading shortcut " + item + " into cell (" + containerIndex + "-" + item.screenId + ":" + x + "," + y + ") occupied by " + screens[x][y]);
                        return false;
                    }
                }
            }
            for (int x2 = item.cellX; x2 < item.cellX + item.spanX; x2++) {
                for (int y2 = item.cellY; y2 < item.cellY + item.spanY; y2++) {
                    screens[x2][y2] = item;
                }
            }
            return true;
        }

        private void clearSBgDataStructures() {
            synchronized (LauncherModel.sBgLock) {
                LauncherModel.sBgWorkspaceItems.clear();
                LauncherModel.sBgAppWidgets.clear();
                LauncherModel.sBgFolders.clear();
                LauncherModel.sBgItemsIdMap.clear();
                LauncherModel.sBgDbIconCache.clear();
                LauncherModel.sBgWorkspaceScreens.clear();
            }
        }

        private boolean loadWorkspace() {
            int itemType = 0;
            ShortcutInfo info;
            Context context = this.mContext;
            ContentResolver contentResolver = context.getContentResolver();
            PackageManager manager = context.getPackageManager();
            AppWidgetManager widgets = AppWidgetManager.getInstance(context);
            boolean isSafeMode = manager.isSafeMode();
            LauncherAppState app = LauncherAppState.getInstance();
            DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            LauncherAppState.getLauncherProvider().loadDefaultFavoritesIfNecessary(0);
            boolean loadedOldDb = LauncherAppState.getLauncherProvider().justLoadedOldDb();
            synchronized (LauncherModel.sBgLock) {
                clearSBgDataStructures();
                ArrayList<Long> itemsToRemove = new ArrayList<>();
                Uri contentUri = LauncherSettings.Favorites.CONTENT_URI;
                Cursor c = contentResolver.query(contentUri, null, null, null, null);
                HashMap<Long, ItemInfo[][]> occupied = new HashMap<>();
                try {
                    int idIndex = c.getColumnIndexOrThrow("_id");
                    int intentIndex = c.getColumnIndexOrThrow("intent");
                    int titleIndex = c.getColumnIndexOrThrow("title");
                    int iconTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ICON_TYPE);
                    int iconIndex = c.getColumnIndexOrThrow("icon");
                    int iconPackageIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ICON_PACKAGE);
                    int iconResourceIndex = c.getColumnIndexOrThrow("iconResource");
                    int containerIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CONTAINER);
                    int itemTypeIndex = c.getColumnIndexOrThrow(LauncherSettings.BaseLauncherColumns.ITEM_TYPE);
                    int appWidgetIdIndex = c.getColumnIndexOrThrow("appWidgetId");
                    int appWidgetProviderIndex = c.getColumnIndexOrThrow(LauncherSettings.Favorites.APPWIDGET_PROVIDER);
                    int screenIndex = c.getColumnIndexOrThrow(Stats.EXTRA_SCREEN);
                    int cellXIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLX);
                    int cellYIndex = c.getColumnIndexOrThrow(Stats.EXTRA_CELLY);
                    int spanXIndex = c.getColumnIndexOrThrow("spanX");
                    int spanYIndex = c.getColumnIndexOrThrow("spanY");
                    while (!this.mStopped && c.moveToNext()) {
                        AtomicBoolean deleteOnItemOverlap = new AtomicBoolean(false);
                        try {
                            itemType = c.getInt(itemTypeIndex);
                        } catch (Exception e) {
                            Launcher.addDumpLog(LauncherModel.TAG, "Desktop items loading interrupted: " + e, true);
                        }
                        switch (itemType) {
                            case 0:
                            case 1:
                                long id = c.getLong(idIndex);
                                String intentDescription = c.getString(intentIndex);
                                try {
                                    Intent intent = Intent.parseUri(intentDescription, 0);
                                    ComponentName cn2 = intent.getComponent();
                                    if (cn2 != null && !LauncherModel.this.isValidPackageComponent(manager, cn2)) {
                                        if (!LauncherModel.this.mAppsCanBeOnRemoveableStorage) {
                                            Launcher.addDumpLog(LauncherModel.TAG, "Invalid package removed: " + cn2, true);
                                            itemsToRemove.add(Long.valueOf(id));
                                        } else {
                                            Launcher.addDumpLog(LauncherModel.TAG, "Invalid package found: " + cn2, true);
                                        }
                                    } else {
                                        if (itemType == 0) {
                                            info = LauncherModel.this.getShortcutInfo(manager, intent, context, c, iconIndex, titleIndex, this.mLabelCache);
                                        } else {
                                            info = LauncherModel.this.getShortcutInfo(c, context, iconTypeIndex, iconPackageIndex, iconResourceIndex, iconIndex, titleIndex);
                                            if (intent.getAction() != null && intent.getCategories() != null && intent.getAction().equals("android.intent.action.MAIN") && intent.getCategories().contains("android.intent.category.LAUNCHER")) {
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                                            }
                                        }
                                        if (info != null) {
                                            info.id = id;
                                            info.intent = intent;
                                            int container = c.getInt(containerIndex);
                                            info.container = container;
                                            info.screenId = c.getInt(screenIndex);
                                            info.cellX = c.getInt(cellXIndex);
                                            info.cellY = c.getInt(cellYIndex);
                                            info.spanX = 1;
                                            info.spanY = 1;
                                            if (container == -100 && checkItemDimensions(info)) {
                                                Launcher.addDumpLog(LauncherModel.TAG, "Skipped loading out of bounds shortcut: " + info + ", " + grid.numColumns + "x" + grid.numRows, true);
                                            } else {
                                                deleteOnItemOverlap.set(false);
                                                if (!checkItemPlacement(occupied, info, deleteOnItemOverlap)) {
                                                    if (deleteOnItemOverlap.get()) {
                                                        itemsToRemove.add(Long.valueOf(id));
                                                    }
                                                } else {
                                                    switch (container) {
                                                        case -101:
                                                        case -100:
                                                            LauncherModel.sBgWorkspaceItems.add(info);
                                                            break;
                                                        default:
                                                            LauncherModel.findOrMakeFolder(LauncherModel.sBgFolders, container).add(info);
                                                            break;
                                                    }
                                                    LauncherModel.sBgItemsIdMap.put(Long.valueOf(info.id), info);
                                                    LauncherModel.this.queueIconToBeChecked(LauncherModel.sBgDbIconCache, info, c, iconIndex);
                                                }
                                            }
                                        } else {
                                            throw new RuntimeException("Unexpected null ShortcutInfo");
                                        }
                                    }
                                } catch (URISyntaxException e2) {
                                    Launcher.addDumpLog(LauncherModel.TAG, "Invalid uri: " + intentDescription, true);
                                }
                                break;
                            case 2:
                                long id2 = c.getLong(idIndex);
                                FolderInfo folderInfo = LauncherModel.findOrMakeFolder(LauncherModel.sBgFolders, id2);
                                folderInfo.title = c.getString(titleIndex);
                                folderInfo.id = id2;
                                int container2 = c.getInt(containerIndex);
                                folderInfo.container = container2;
                                folderInfo.screenId = c.getInt(screenIndex);
                                folderInfo.cellX = c.getInt(cellXIndex);
                                folderInfo.cellY = c.getInt(cellYIndex);
                                folderInfo.spanX = 1;
                                folderInfo.spanY = 1;
                                if (container2 == -100 && checkItemDimensions(folderInfo)) {
                                    Log.d(LauncherModel.TAG, "Skipped loading out of bounds folder");
                                } else {
                                    deleteOnItemOverlap.set(false);
                                    if (!checkItemPlacement(occupied, folderInfo, deleteOnItemOverlap)) {
                                        if (deleteOnItemOverlap.get()) {
                                            itemsToRemove.add(Long.valueOf(id2));
                                        }
                                    } else {
                                        switch (container2) {
                                            case -101:
                                            case -100:
                                                LauncherModel.sBgWorkspaceItems.add(folderInfo);
                                                break;
                                        }
                                        LauncherModel.sBgItemsIdMap.put(Long.valueOf(folderInfo.id), folderInfo);
                                        LauncherModel.sBgFolders.put(Long.valueOf(folderInfo.id), folderInfo);
                                    }
                                }
                                break;
                            case 4:
                                int appWidgetId = c.getInt(appWidgetIdIndex);
                                String savedProvider = c.getString(appWidgetProviderIndex);
                                long id3 = c.getLong(idIndex);
                                AppWidgetProviderInfo provider = widgets.getAppWidgetInfo(appWidgetId);
                                if (!isSafeMode && (provider == null || provider.provider == null || provider.provider.getPackageName() == null)) {
                                    String log = "Deleting widget that isn't installed anymore: id=" + id3 + " appWidgetId=" + appWidgetId;
                                    Log.e(LauncherModel.TAG, log);
                                    Launcher.addDumpLog(LauncherModel.TAG, log, false);
                                    itemsToRemove.add(Long.valueOf(id3));
                                } else {
                                    LauncherAppWidgetInfo appWidgetInfo = new LauncherAppWidgetInfo(appWidgetId, provider.provider);
                                    appWidgetInfo.id = id3;
                                    appWidgetInfo.screenId = c.getInt(screenIndex);
                                    appWidgetInfo.cellX = c.getInt(cellXIndex);
                                    appWidgetInfo.cellY = c.getInt(cellYIndex);
                                    appWidgetInfo.spanX = c.getInt(spanXIndex);
                                    appWidgetInfo.spanY = c.getInt(spanYIndex);
                                    int[] minSpan = Launcher.getMinSpanForWidget(context, provider);
                                    appWidgetInfo.minSpanX = minSpan[0];
                                    appWidgetInfo.minSpanY = minSpan[1];
                                    int container3 = c.getInt(containerIndex);
                                    if (container3 != -100 && container3 != -101) {
                                        Log.e(LauncherModel.TAG, "Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
                                    } else {
                                        appWidgetInfo.container = c.getInt(containerIndex);
                                        if (container3 == -100 && checkItemDimensions(appWidgetInfo)) {
                                            Log.d(LauncherModel.TAG, "Skipped loading out of bounds app widget");
                                        } else {
                                            deleteOnItemOverlap.set(false);
                                            if (!checkItemPlacement(occupied, appWidgetInfo, deleteOnItemOverlap)) {
                                                if (deleteOnItemOverlap.get()) {
                                                    itemsToRemove.add(Long.valueOf(id3));
                                                }
                                            } else {
                                                String providerName = provider.provider.flattenToString();
                                                if (!providerName.equals(savedProvider)) {
                                                    ContentValues values = new ContentValues();
                                                    values.put(LauncherSettings.Favorites.APPWIDGET_PROVIDER, providerName);
                                                    String[] args = {Integer.toString(c.getInt(idIndex))};
                                                    contentResolver.update(contentUri, values, "_id= ?", args);
                                                }
                                                LauncherModel.sBgItemsIdMap.put(Long.valueOf(appWidgetInfo.id), appWidgetInfo);
                                                LauncherModel.sBgAppWidgets.add(appWidgetInfo);
                                            }
                                        }
                                    }
                                }
                                break;
                        }
                    }
                    if (this.mStopped) {
                        clearSBgDataStructures();
                        return false;
                    }
                    if (itemsToRemove.size() > 0) {
                        ContentProviderClient client = contentResolver.acquireContentProviderClient(LauncherSettings.Favorites.CONTENT_URI);
                        Iterator<Long> it = itemsToRemove.iterator();
                        while (it.hasNext()) {
                            long id4 = it.next().longValue();
                            try {
                                client.delete(LauncherSettings.Favorites.getContentUri(id4, false), null, null);
                            } catch (RemoteException e3) {
                                Log.w(LauncherModel.TAG, "Could not remove id = " + id4);
                            }
                        }
                    }
                    if (!loadedOldDb) {
                        TreeMap<Integer, Long> orderedScreens = LauncherModel.loadWorkspaceScreensDb(this.mContext);
                        for (Integer i : orderedScreens.keySet()) {
                            LauncherModel.sBgWorkspaceScreens.add(orderedScreens.get(i));
                        }
                        ArrayList<Long> unusedScreens = new ArrayList<>(LauncherModel.sBgWorkspaceScreens);
                        for (ItemInfo item : LauncherModel.sBgItemsIdMap.values()) {
                            long screenId = item.screenId;
                            if (item.container == -100 && unusedScreens.contains(Long.valueOf(screenId))) {
                                unusedScreens.remove(Long.valueOf(screenId));
                            }
                        }
                        if (unusedScreens.size() != 0) {
                            LauncherModel.sBgWorkspaceScreens.removeAll(unusedScreens);
                            LauncherModel.this.updateWorkspaceScreenOrder(context, LauncherModel.sBgWorkspaceScreens);
                        }
                    } else {
                        long maxScreenId = 0;
                        for (ItemInfo item2 : LauncherModel.sBgItemsIdMap.values()) {
                            long screenId2 = item2.screenId;
                            if (item2.container == -100 && !LauncherModel.sBgWorkspaceScreens.contains(Long.valueOf(screenId2))) {
                                LauncherModel.sBgWorkspaceScreens.add(Long.valueOf(screenId2));
                                if (screenId2 > maxScreenId) {
                                    maxScreenId = screenId2;
                                }
                            }
                        }
                        Collections.sort(LauncherModel.sBgWorkspaceScreens);
                        LauncherAppState.getLauncherProvider().updateMaxScreenId(maxScreenId);
                        LauncherModel.this.updateWorkspaceScreenOrder(context, LauncherModel.sBgWorkspaceScreens);
                        long maxItemId = 0;
                        Iterator<ItemInfo> it2 = LauncherModel.sBgItemsIdMap.values().iterator();
                        while (it2.hasNext()) {
                            maxItemId = Math.max(maxItemId, it2.next().id);
                        }
                        LauncherAppState.getLauncherProvider().updateMaxItemId(maxItemId);
                    }
                    return loadedOldDb;
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        }

        private void filterCurrentWorkspaceItems(int currentScreen, ArrayList<ItemInfo> allWorkspaceItems, ArrayList<ItemInfo> currentScreenItems, ArrayList<ItemInfo> otherScreenItems) {
            Iterator<ItemInfo> iter = allWorkspaceItems.iterator();
            while (iter.hasNext()) {
                ItemInfo i = iter.next();
                if (i == null) {
                    iter.remove();
                }
            }
            if (currentScreen < 0) {
                currentScreenItems.addAll(allWorkspaceItems);
            }
            Set<Long> itemsOnScreen = new HashSet<>();
            Collections.sort(allWorkspaceItems, new Comparator<ItemInfo>() { // from class: com.android.launcher66.LauncherModel.LoaderTask.2
                @Override // java.util.Comparator
                public int compare(ItemInfo lhs, ItemInfo rhs) {
                    return (int) (lhs.container - rhs.container);
                }
            });
            Iterator<ItemInfo> it = allWorkspaceItems.iterator();
            while (it.hasNext()) {
                ItemInfo info = it.next();
                if (info.container == -100) {
                    if (info.screenId == currentScreen) {
                        currentScreenItems.add(info);
                        itemsOnScreen.add(Long.valueOf(info.id));
                    } else {
                        otherScreenItems.add(info);
                    }
                } else if (info.container == -101) {
                    currentScreenItems.add(info);
                    itemsOnScreen.add(Long.valueOf(info.id));
                } else if (itemsOnScreen.contains(Long.valueOf(info.container))) {
                    currentScreenItems.add(info);
                    itemsOnScreen.add(Long.valueOf(info.id));
                } else {
                    otherScreenItems.add(info);
                }
            }
        }

        private void filterCurrentAppWidgets(int currentScreen, ArrayList<LauncherAppWidgetInfo> appWidgets, ArrayList<LauncherAppWidgetInfo> currentScreenWidgets, ArrayList<LauncherAppWidgetInfo> otherScreenWidgets) {
            if (currentScreen < 0) {
                currentScreenWidgets.addAll(appWidgets);
            }
            Iterator<LauncherAppWidgetInfo> it = appWidgets.iterator();
            while (it.hasNext()) {
                LauncherAppWidgetInfo widget = it.next();
                if (widget != null) {
                    if (widget.container == -100 && widget.screenId == currentScreen) {
                        currentScreenWidgets.add(widget);
                    } else {
                        otherScreenWidgets.add(widget);
                    }
                }
            }
        }

        private void filterCurrentFolders(int currentScreen, HashMap<Long, ItemInfo> itemsIdMap, HashMap<Long, FolderInfo> folders, HashMap<Long, FolderInfo> currentScreenFolders, HashMap<Long, FolderInfo> otherScreenFolders) {
            if (currentScreen < 0) {
                currentScreenFolders.putAll(folders);
            }
            Iterator<Long> it = folders.keySet().iterator();
            while (it.hasNext()) {
                long id = it.next().longValue();
                ItemInfo info = itemsIdMap.get(Long.valueOf(id));
                FolderInfo folder = folders.get(Long.valueOf(id));
                if (info != null && folder != null) {
                    if (info.container == -100 && info.screenId == currentScreen) {
                        currentScreenFolders.put(Long.valueOf(id), folder);
                    } else {
                        otherScreenFolders.put(Long.valueOf(id), folder);
                    }
                }
            }
        }

        private void sortWorkspaceItemsSpatially(ArrayList<ItemInfo> workspaceItems) {
            LauncherAppState app = LauncherAppState.getInstance();
            final DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
            Collections.sort(workspaceItems, new Comparator<ItemInfo>() { // from class: com.android.launcher66.LauncherModel.LoaderTask.3
                @Override // java.util.Comparator
                public int compare(ItemInfo lhs, ItemInfo rhs) {
                    int cellCountX = (int) grid.numColumns;
                    int cellCountY = (int) grid.numRows;
                    int screenOffset = cellCountX * cellCountY;
                    int containerOffset = screenOffset * 6;
                    long lr = (lhs.container * containerOffset) + (lhs.screenId * screenOffset) + (lhs.cellY * cellCountX) + lhs.cellX;
                    long rr = (rhs.container * containerOffset) + (rhs.screenId * screenOffset) + (rhs.cellY * cellCountX) + rhs.cellX;
                    return (int) (lr - rr);
                }
            });
        }

        private void bindWorkspaceScreens(final Callbacks oldCallbacks, final ArrayList<Long> orderedScreens) {
            Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.4
                @Override // java.lang.Runnable
                public void run() {
                    Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                    if (callbacks != null) {
                        callbacks.bindScreens(orderedScreens);
                    }
                }
            };
            LauncherModel.this.runOnMainThread(r, 1);
        }

        private void bindWorkspaceItems(final Callbacks oldCallbacks, final ArrayList<ItemInfo> workspaceItems, ArrayList<LauncherAppWidgetInfo> appWidgets, final HashMap<Long, FolderInfo> folders, ArrayList<Runnable> deferredBindRunnables) {
            boolean postOnMainThread = deferredBindRunnables != null;
            int N = workspaceItems.size();
            for (int i = 0; i < N; i += 6) {
                final int start = i;
                final int chunkSize = i + 6 <= N ? 6 : N - i;
                Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                        if (callbacks != null) {
                            callbacks.bindItems(workspaceItems, start, start + chunkSize, false);
                        }
                    }
                };
                if (!postOnMainThread) {
                    LauncherModel.this.runOnMainThread(r, 1);
                } else {
                    deferredBindRunnables.add(r);
                }
            }
            if (!folders.isEmpty()) {
                Runnable r2 = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                        if (callbacks != null) {
                            callbacks.bindFolders(folders);
                        }
                    }
                };
                if (!postOnMainThread) {
                    LauncherModel.this.runOnMainThread(r2, 1);
                } else {
                    deferredBindRunnables.add(r2);
                }
            }
            int N2 = appWidgets.size();
            for (int i2 = 0; i2 < N2; i2++) {
                final LauncherAppWidgetInfo widget = appWidgets.get(i2);
                Runnable r3 = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                        if (callbacks != null) {
                            callbacks.bindAppWidget(widget);
                        }
                    }
                };
                if (!postOnMainThread) {
                    LauncherModel.this.runOnMainThread(r3, 1);
                } else {
                    deferredBindRunnables.add(r3);
                }
            }
        }

        private void bindWorkspace(int synchronizeBindPage, final boolean isUpgradePath) {
            LogPreview.show("bindWorkspace");
            final long t = SystemClock.uptimeMillis();
            final Callbacks oldCallbacks = (Callbacks) LauncherModel.this.mCallbacks.get();
            if (oldCallbacks == null) {
                Log.w(LauncherModel.TAG, "LoaderTask running with no launcher");
                return;
            }
            boolean isLoadingSynchronously = synchronizeBindPage > -1;
            final int currentScreen = isLoadingSynchronously ? synchronizeBindPage : oldCallbacks.getCurrentWorkspaceScreen();
            LauncherModel.this.unbindWorkspaceItemsOnMainThread();
            ArrayList<ItemInfo> workspaceItems = new ArrayList<>();
            ArrayList<LauncherAppWidgetInfo> appWidgets = new ArrayList<>();
            HashMap<Long, FolderInfo> folders = new HashMap<>();
            HashMap<Long, ItemInfo> itemsIdMap = new HashMap<>();
            ArrayList<Long> orderedScreenIds = new ArrayList<>();
            synchronized (LauncherModel.sBgLock) {
                workspaceItems.addAll(LauncherModel.sBgWorkspaceItems);
                appWidgets.addAll(LauncherModel.sBgAppWidgets);
                folders.putAll(LauncherModel.sBgFolders);
                itemsIdMap.putAll(LauncherModel.sBgItemsIdMap);
                orderedScreenIds.addAll(LauncherModel.sBgWorkspaceScreens);
            }
            ArrayList<ItemInfo> currentWorkspaceItems = new ArrayList<>();
            ArrayList<ItemInfo> otherWorkspaceItems = new ArrayList<>();
            ArrayList<LauncherAppWidgetInfo> currentAppWidgets = new ArrayList<>();
            ArrayList<LauncherAppWidgetInfo> otherAppWidgets = new ArrayList<>();
            HashMap<Long, FolderInfo> currentFolders = new HashMap<>();
            HashMap<Long, FolderInfo> otherFolders = new HashMap<>();
            filterCurrentWorkspaceItems(currentScreen, workspaceItems, currentWorkspaceItems, otherWorkspaceItems);
            filterCurrentAppWidgets(currentScreen, appWidgets, currentAppWidgets, otherAppWidgets);
            filterCurrentFolders(currentScreen, itemsIdMap, folders, currentFolders, otherFolders);
            sortWorkspaceItemsSpatially(currentWorkspaceItems);
            sortWorkspaceItemsSpatially(otherWorkspaceItems);
            LauncherModel.this.runOnMainThread(new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.8
                @Override // java.lang.Runnable
                public void run() {
                    Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                    if (callbacks != null) {
                        callbacks.startBinding();
                    }
                }
            }, 1);
            bindWorkspaceScreens(oldCallbacks, orderedScreenIds);
            bindWorkspaceItems(oldCallbacks, currentWorkspaceItems, currentAppWidgets, currentFolders, null);
            if (isLoadingSynchronously) {
                LauncherModel.this.runOnMainThread(new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                        if (callbacks != null) {
                            callbacks.onPageBoundSynchronously(currentScreen);
                        }
                    }
                }, 1);
            }
            LauncherModel.mDeferredBindRunnables.clear();
            bindWorkspaceItems(oldCallbacks, otherWorkspaceItems, otherAppWidgets, otherFolders, isLoadingSynchronously ? LauncherModel.mDeferredBindRunnables : null);
            Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.10
                @Override // java.lang.Runnable
                public void run() {
                    Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                    if (callbacks != null) {
                        callbacks.finishBindingItems(isUpgradePath);
                    }
                    LoaderTask.this.mIsLoadingAndBindingWorkspace = false;
                }
            };
            if (!isLoadingSynchronously) {
                LauncherModel.this.runOnMainThread(r, 1);
            } else {
                LauncherModel.mDeferredBindRunnables.add(r);
            }
        }

        private void loadAndBindAllApps() {
            if (!LauncherModel.this.mAllAppsLoaded) {
                loadAllApps();
                synchronized (this) {
                    if (!this.mStopped) {
                        LauncherModel.this.mAllAppsLoaded = true;
                    }
                }
                return;
            }
            onlyBindAllApps();
        }

        private void onlyBindAllApps() {
            final Callbacks oldCallbacks = (Callbacks) LauncherModel.this.mCallbacks.get();
            if (oldCallbacks == null) {
                Log.w(LauncherModel.TAG, "LoaderTask running with no launcher (onlyBindAllApps)");
                return;
            }
            final ArrayList<AppInfo> list = (ArrayList) AllAppsList.data.clone();
            Runnable r = new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.11
                @Override // java.lang.Runnable
                public void run() {
                    SystemClock.uptimeMillis();
                    Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                    if (callbacks != null) {
                        callbacks.bindAllApplications(list);
                    }
                }
            };
            boolean isRunningOnMainThread = LauncherModel.sWorkerThread.getThreadId() != Process.myTid();
            if (!isRunningOnMainThread) {
                LauncherModel.this.mHandler.post(r);
            } else {
                r.run();
            }
        }

        private void loadAllApps() {
            final Callbacks oldCallbacks = (Callbacks) LauncherModel.this.mCallbacks.get();
            if (oldCallbacks == null) {
                Log.w(LauncherModel.TAG, "LoaderTask running with no launcher (loadAllApps)");
                return;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
            mainIntent.addCategory("android.intent.category.LAUNCHER");
            LauncherModel.this.mBgAllAppsList.clear();
            List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
            if (apps != null && !apps.isEmpty()) {
                Collections.sort(apps, new ShortcutNameComparator(packageManager, this.mLabelCache));
                for (int i = 0; i < apps.size(); i++) {
                    ResolveInfo app = apps.get(i);
                    LauncherModel.this.mBgAllAppsList.add(new AppInfo(packageManager, app, LauncherModel.this.mIconCache, this.mLabelCache));
                }
                final ArrayList<AppInfo> added = LauncherModel.this.mBgAllAppsList.added;
                LauncherModel.this.mBgAllAppsList.added = new ArrayList<>();
                LauncherModel.this.mHandler.post(new Runnable() { // from class: com.android.launcher66.LauncherModel.LoaderTask.12
                    @Override // java.lang.Runnable
                    public void run() {
                        SystemClock.uptimeMillis();
                        Callbacks callbacks = LoaderTask.this.tryGetCallbacks(oldCallbacks);
                        if (callbacks != null) {
                            callbacks.bindAllApplications(added);
                        } else {
                            Log.i(LauncherModel.TAG, "not binding apps: no Launcher activity");
                        }
                    }
                });
            }
        }

        public void dumpState() {
            synchronized (LauncherModel.sBgLock) {
                Log.d(LauncherModel.TAG, "mLoaderTask.mContext=" + this.mContext);
                Log.d(LauncherModel.TAG, "mLoaderTask.mIsLaunching=" + this.mIsLaunching);
                Log.d(LauncherModel.TAG, "mLoaderTask.mStopped=" + this.mStopped);
                Log.d(LauncherModel.TAG, "mLoaderTask.mLoadAndBindStepFinished=" + this.mLoadAndBindStepFinished);
                Log.d(LauncherModel.TAG, "mItems size=" + LauncherModel.sBgWorkspaceItems.size());
            }
        }
    }

    void enqueuePackageUpdated(PackageUpdatedTask task) {
        sWorker.post(task);
    }

    private class PackageUpdatedTask implements Runnable {
        public static final int OP_ADD = 1;
        public static final int OP_NONE = 0;
        public static final int OP_REMOVE = 3;
        public static final int OP_UNAVAILABLE = 4;
        public static final int OP_UPDATE = 2;
        int mOp;
        String[] mPackages;

        public PackageUpdatedTask(int op, String[] packages) {
            this.mOp = op;
            this.mPackages = packages;
        }

        @Override // java.lang.Runnable
        public void run() {
            final Callbacks callbacks;
            Callbacks cb;
            Context context = LauncherModel.this.mApp.getContext();
            String[] packages = this.mPackages;
            int N = packages.length;
            switch (this.mOp) {
                case 1:
                    for (String str : packages) {
                        LauncherModel.this.mBgAllAppsList.addPackage(context, str);
                    }
                    break;
                case 2:
                    for (int i = 0; i < N; i++) {
                        LauncherModel.this.mBgAllAppsList.updatePackage(context, packages[i]);
                        WidgetPreviewLoader.removePackageFromDb(LauncherModel.this.mApp.getWidgetPreviewCacheDb(), packages[i]);
                    }
                    break;
                case 3:
                case 4:
                    for (int i2 = 0; i2 < N; i2++) {
                        LauncherModel.this.mBgAllAppsList.removePackage(packages[i2]);
                        WidgetPreviewLoader.removePackageFromDb(LauncherModel.this.mApp.getWidgetPreviewCacheDb(), packages[i2]);
                    }
                    break;
            }
            ArrayList<AppInfo> added = null;
            ArrayList<AppInfo> modified = null;
            final ArrayList<AppInfo> removedApps = new ArrayList<>();
            if (LauncherModel.this.mBgAllAppsList.added.size() > 0) {
                added = new ArrayList<>(LauncherModel.this.mBgAllAppsList.added);
                LauncherModel.this.mBgAllAppsList.added.clear();
            }
            if (LauncherModel.this.mBgAllAppsList.modified.size() > 0) {
                modified = new ArrayList<>(LauncherModel.this.mBgAllAppsList.modified);
                LauncherModel.this.mBgAllAppsList.modified.clear();
            }
            if (LauncherModel.this.mBgAllAppsList.removed.size() > 0) {
                removedApps.addAll(LauncherModel.this.mBgAllAppsList.removed);
                LauncherModel.this.mBgAllAppsList.removed.clear();
            }
            if (LauncherModel.this.mCallbacks != null) {
                callbacks = (Callbacks) LauncherModel.this.mCallbacks.get();
            } else {
                callbacks = null;
            }
            if (callbacks == null) {
                Log.w(LauncherModel.TAG, "Nobody to tell about the new app.  Launcher is probably loading.");
                return;
            }
            if (added != null) {
                if (LauncherModel.this.mCallbacks != null) {
                    cb = (Callbacks) LauncherModel.this.mCallbacks.get();
                } else {
                    cb = null;
                }
                if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
                    LauncherModel.this.addAndBindAddedApps(context, new ArrayList<>(), cb, added);
                } else {
                    ArrayList<ItemInfo> addedInfos = new ArrayList<>(added);
                    LauncherModel.this.addAndBindAddedApps(context, addedInfos, cb, added);
                }
            }
            if (modified != null) {
                final ArrayList<AppInfo> modifiedFinal = modified;
                Iterator<AppInfo> it = modifiedFinal.iterator();
                while (it.hasNext()) {
                    AppInfo a = it.next();
                    ArrayList<ItemInfo> infos = LauncherModel.this.getItemInfoForComponentName(a.componentName);
                    Iterator<ItemInfo> it2 = infos.iterator();
                    while (it2.hasNext()) {
                        ItemInfo i3 = it2.next();
                        if (LauncherModel.isShortcutInfoUpdateable(i3)) {
                            ShortcutInfo info = (ShortcutInfo) i3;
                            info.title = a.title.toString();
                            LauncherModel.updateItemInDatabase(context, info);
                        }
                    }
                }
                LauncherModel.this.mHandler.post(new Runnable() { // from class: com.android.launcher66.LauncherModel.PackageUpdatedTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks cb2;
                        if (LauncherModel.this.mCallbacks != null) {
                            cb2 = (Callbacks) LauncherModel.this.mCallbacks.get();
                        } else {
                            cb2 = null;
                        }
                        if (callbacks == cb2 && cb2 != null) {
                            callbacks.bindAppsUpdated(modifiedFinal);
                        }
                    }
                });
            }
            if (this.mOp == 3 || !removedApps.isEmpty()) {
                final boolean packageRemoved = this.mOp == 3;
                final ArrayList<String> removedPackageNames = new ArrayList<>(Arrays.asList(packages));
                if (packageRemoved) {
                    Iterator<String> it3 = removedPackageNames.iterator();
                    while (it3.hasNext()) {
                        String pn = it3.next();
                        ArrayList<ItemInfo> infos2 = LauncherModel.this.getItemInfoForPackageName(pn);
                        Iterator<ItemInfo> it4 = infos2.iterator();
                        while (it4.hasNext()) {
                            ItemInfo i4 = it4.next();
                            LauncherModel.deleteItemFromDatabase(context, i4);
                        }
                    }
                    String spKey = LauncherAppState.getSharedPreferencesKey();
                    SharedPreferences sp = context.getSharedPreferences(spKey, 0);
                    InstallShortcutReceiver.removeFromInstallQueue(sp, removedPackageNames);
                } else {
                    Iterator<AppInfo> it5 = removedApps.iterator();
                    while (it5.hasNext()) {
                        ArrayList<ItemInfo> infos3 = LauncherModel.this.getItemInfoForComponentName(it5.next().componentName);
                        Iterator<ItemInfo> it6 = infos3.iterator();
                        while (it6.hasNext()) {
                            ItemInfo i5 = it6.next();
                            LauncherModel.deleteItemFromDatabase(context, i5);
                        }
                    }
                }
                LauncherModel.this.mHandler.post(new Runnable() { // from class: com.android.launcher66.LauncherModel.PackageUpdatedTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Callbacks cb2;
                        if (LauncherModel.this.mCallbacks != null) {
                            cb2 = (Callbacks) LauncherModel.this.mCallbacks.get();
                        } else {
                            cb2 = null;
                        }
                        if (callbacks == cb2 && cb2 != null) {
                            callbacks.bindComponentsRemoved(removedPackageNames, removedApps, packageRemoved);
                        }
                    }
                });
            }
            final ArrayList<Object> widgetsAndShortcuts = LauncherModel.getSortedWidgetsAndShortcuts(context);
            LauncherModel.this.mHandler.post(new Runnable() { // from class: com.android.launcher66.LauncherModel.PackageUpdatedTask.3
                @Override // java.lang.Runnable
                public void run() {
                    Callbacks cb2;
                    if (LauncherModel.this.mCallbacks != null) {
                        cb2 = (Callbacks) LauncherModel.this.mCallbacks.get();
                    } else {
                        cb2 = null;
                    }
                    if (callbacks == cb2 && cb2 != null) {
                        callbacks.bindPackagesUpdated(widgetsAndShortcuts);
                    }
                }
            });
            LauncherModel.this.mHandler.post(new Runnable() { // from class: com.android.launcher66.LauncherModel.PackageUpdatedTask.4
                @Override // java.lang.Runnable
                public void run() {
                    Callbacks cb2;
                    if (LauncherModel.this.mCallbacks != null) {
                        cb2 = (Callbacks) LauncherModel.this.mCallbacks.get();
                    } else {
                        cb2 = null;
                    }
                    if (callbacks == cb2 && cb2 != null) {
                        callbacks.dumpLogsToLocalData();
                    }
                }
            });
        }
    }

    public static ArrayList<Object> getSortedWidgetsAndShortcuts(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList<Object> widgetsAndShortcuts = new ArrayList<>();
        widgetsAndShortcuts.addAll(AppWidgetManager.getInstance(context).getInstalledProviders());
        Intent shortcutsIntent = new Intent("android.intent.action.CREATE_SHORTCUT");
        widgetsAndShortcuts.addAll(packageManager.queryIntentActivities(shortcutsIntent, 0));
        Collections.sort(widgetsAndShortcuts, new WidgetAndShortcutNameComparator(packageManager));
        return widgetsAndShortcuts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidPackageComponent(PackageManager pm, ComponentName cn2) {
        if (cn2 == null) {
            return false;
        }
        try {
            PackageInfo pi = pm.getPackageInfo(cn2.getPackageName(), 0);
            if (pi.applicationInfo.enabled) {
                return pm.getActivityInfo(cn2, 0) != null;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public ShortcutInfo getShortcutInfo(PackageManager manager, Intent intent, Context context) {
        return getShortcutInfo(manager, intent, context, (Cursor) null, -1, -1, (HashMap<Object, CharSequence>) null);
    }

    public ShortcutInfo getShortcutInfo(PackageManager manager, Intent intent, Context context, Cursor c, int iconIndex, int titleIndex, HashMap<Object, CharSequence> labelCache) {
        ComponentName componentName = intent.getComponent();
        ShortcutInfo info = new ShortcutInfo();
        if (componentName != null && !isValidPackageComponent(manager, componentName)) {
            Log.d(TAG, "Invalid package found in getShortcutInfo: " + componentName);
            return null;
        }
        try {
            PackageInfo pi = manager.getPackageInfo(componentName.getPackageName(), 0);
            info.initFlagsAndFirstInstallTime(pi);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, "getPackInfo failed for package " + componentName.getPackageName());
        }
        Bitmap icon = null;
        ResolveInfo resolveInfo = null;
        ComponentName oldComponent = intent.getComponent();
        Intent newIntent = new Intent(intent.getAction(), (Uri) null);
        newIntent.addCategory("android.intent.category.LAUNCHER");
        newIntent.setPackage(oldComponent.getPackageName());
        List<ResolveInfo> infos = manager.queryIntentActivities(newIntent, 0);
        for (ResolveInfo i : infos) {
            ComponentName cn2 = new ComponentName(i.activityInfo.packageName, i.activityInfo.name);
            if (cn2.equals(oldComponent)) {
                resolveInfo = i;
            }
        }
        if (resolveInfo == null) {
            resolveInfo = manager.resolveActivity(intent, 0);
        }
        if (resolveInfo != null) {
            icon = this.mIconCache.getIcon(componentName, resolveInfo, labelCache);
            info.setIconResid(CustomIcons.getIcon(resolveInfo.activityInfo));
        }
        if (icon == null && c != null) {
            icon = getIconFromCursor(c, iconIndex, context);
        }
        if (icon == null) {
            icon = getFallbackIcon();
            info.usingFallbackIcon = true;
        }
        info.setIcon(icon);
        if (resolveInfo != null) {
            ComponentName key = getComponentNameFromResolveInfo(resolveInfo);
            if (labelCache != null && labelCache.containsKey(key)) {
                info.title = labelCache.get(key);
            } else {
                info.title = resolveInfo.activityInfo.loadLabel(manager);
                if (labelCache != null) {
                    labelCache.put(key, info.title);
                }
            }
        }
        if (info.title == null && c != null) {
            info.title = c.getString(titleIndex);
        }
        if (info.title == null) {
            info.title = componentName.getClassName();
        }
        info.itemType = 0;
        return info;
    }

    static ArrayList<ItemInfo> filterItemInfos(Collection<ItemInfo> infos, ItemInfoFilter f) {
        LauncherAppWidgetInfo info;
        ComponentName cn2;
        HashSet<ItemInfo> filtered = new HashSet<>();
        for (ItemInfo i : infos) {
            if (i instanceof ShortcutInfo) {
                ShortcutInfo info2 = (ShortcutInfo) i;
                ComponentName cn3 = info2.intent.getComponent();
                if (cn3 != null && f.filterItem(null, info2, cn3)) {
                    filtered.add(info2);
                }
            } else if (i instanceof FolderInfo) {
                FolderInfo info3 = (FolderInfo) i;
                Iterator<ShortcutInfo> it = info3.contents.iterator();
                while (it.hasNext()) {
                    ShortcutInfo s = it.next();
                    ComponentName cn4 = s.intent.getComponent();
                    if (cn4 != null && f.filterItem(info3, s, cn4)) {
                        filtered.add(s);
                    }
                }
            } else if ((i instanceof LauncherAppWidgetInfo) && (cn2 = (info = (LauncherAppWidgetInfo) i).providerName) != null && f.filterItem(null, info, cn2)) {
                filtered.add(info);
            }
        }
        return new ArrayList<>(filtered);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ItemInfo> getItemInfoForPackageName(final String pn) {
        ItemInfoFilter filter = new ItemInfoFilter() { // from class: com.android.launcher66.LauncherModel.14
            @Override // com.android.launcher66.LauncherModel.ItemInfoFilter
            public boolean filterItem(ItemInfo parent, ItemInfo info, ComponentName cn2) {
                return cn2.getPackageName().equals(pn);
            }
        };
        return filterItemInfos(sBgItemsIdMap.values(), filter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ItemInfo> getItemInfoForComponentName(final ComponentName cname) {
        ItemInfoFilter filter = new ItemInfoFilter() { // from class: com.android.launcher66.LauncherModel.15
            @Override // com.android.launcher66.LauncherModel.ItemInfoFilter
            public boolean filterItem(ItemInfo parent, ItemInfo info, ComponentName cn2) {
                return cn2.equals(cname);
            }
        };
        return filterItemInfos(sBgItemsIdMap.values(), filter);
    }

    public static boolean isShortcutInfoUpdateable(ItemInfo i) {
        if (i instanceof ShortcutInfo) {
            ShortcutInfo info = (ShortcutInfo) i;
            Intent intent = info.intent;
            ComponentName name = intent.getComponent();
            if (info.itemType == 0 && "android.intent.action.MAIN".equals(intent.getAction()) && name != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShortcutInfo getShortcutInfo(Cursor c, Context context, int iconTypeIndex, int iconPackageIndex, int iconResourceIndex, int iconIndex, int titleIndex) {
        Bitmap icon = null;
        ShortcutInfo info = new ShortcutInfo();
        info.itemType = 1;
        info.title = c.getString(titleIndex);
        int iconType = c.getInt(iconTypeIndex);
        switch (iconType) {
            case 0:
                String packageName = c.getString(iconPackageIndex);
                String resourceName = c.getString(iconResourceIndex);
                PackageManager packageManager = context.getPackageManager();
                info.customIcon = false;
                try {
                    Resources resources = packageManager.getResourcesForApplication(packageName);
                    if (resources != null) {
                        int id = resources.getIdentifier(resourceName, null, null);
                        icon = Utilities.createIconBitmap(this.mIconCache.getFullResIcon(resources, id), context);
                    }
                } catch (Exception e) {
                }
                if (icon == null) {
                    icon = getIconFromCursor(c, iconIndex, context);
                }
                if (icon == null) {
                    icon = getFallbackIcon();
                    info.usingFallbackIcon = true;
                    break;
                }
                break;
            case 1:
                icon = getIconFromCursor(c, iconIndex, context);
                if (icon == null) {
                    icon = getFallbackIcon();
                    info.customIcon = false;
                    info.usingFallbackIcon = true;
                    break;
                } else {
                    info.customIcon = true;
                    break;
                }
            default:
                icon = getFallbackIcon();
                info.usingFallbackIcon = true;
                info.customIcon = false;
                break;
        }
        info.setIcon(icon);
        return info;
    }

    Bitmap getIconFromCursor(Cursor c, int iconIndex, Context context) {
        byte[] data = c.getBlob(iconIndex);
        try {
            return Utilities.createIconBitmap(BitmapFactory.decodeByteArray(data, 0, data.length), context);
        } catch (Exception e) {
            return null;
        }
    }

    ShortcutInfo addShortcut(Context context, Intent data, long container, int screen, int cellX, int cellY, boolean notify) {
        ShortcutInfo info = infoFromShortcutIntent(context, data, null);
        if (info == null) {
            return null;
        }
        addItemToDatabase(context, info, container, screen, cellX, cellY, notify);
        return info;
    }

    AppWidgetProviderInfo findAppWidgetProviderInfoWithComponent(Context context, ComponentName component) {
        List<AppWidgetProviderInfo> widgets = AppWidgetManager.getInstance(context).getInstalledProviders();
        for (AppWidgetProviderInfo info : widgets) {
            if (info.provider.equals(component)) {
                return info;
            }
        }
        return null;
    }

    List<InstallWidgetReceiver.WidgetMimeTypeHandlerData> resolveWidgetsForMimeType(Context context, String mimeType) {
        PackageManager packageManager = context.getPackageManager();
        List<InstallWidgetReceiver.WidgetMimeTypeHandlerData> supportedConfigurationActivities = new ArrayList<>();
        Intent supportsIntent = new Intent(InstallWidgetReceiver.ACTION_SUPPORTS_CLIPDATA_MIMETYPE);
        supportsIntent.setType(mimeType);
        List<AppWidgetProviderInfo> widgets = AppWidgetManager.getInstance(context).getInstalledProviders();
        HashMap<ComponentName, AppWidgetProviderInfo> configurationComponentToWidget = new HashMap<>();
        for (AppWidgetProviderInfo info : widgets) {
            configurationComponentToWidget.put(info.configure, info);
        }
        List<ResolveInfo> activities = packageManager.queryIntentActivities(supportsIntent, 65536);
        for (ResolveInfo info2 : activities) {
            ActivityInfo activityInfo = info2.activityInfo;
            ComponentName infoComponent = new ComponentName(activityInfo.packageName, activityInfo.name);
            if (configurationComponentToWidget.containsKey(infoComponent)) {
                supportedConfigurationActivities.add(new InstallWidgetReceiver.WidgetMimeTypeHandlerData(info2, configurationComponentToWidget.get(infoComponent)));
            }
        }
        return supportedConfigurationActivities;
    }

    ShortcutInfo infoFromShortcutIntent(Context context, Intent data, Bitmap fallbackIcon) {
        Intent intent = (Intent) data.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        String name = data.getStringExtra("android.intent.extra.shortcut.NAME");
        Parcelable bitmap = data.getParcelableExtra("android.intent.extra.shortcut.ICON");
        if (intent == null) {
            Log.e(TAG, "Can't construct ShorcutInfo with null intent");
            return null;
        }
        Bitmap icon = null;
        boolean customIcon = false;
        Intent.ShortcutIconResource iconResource = null;
        if (bitmap != null && (bitmap instanceof Bitmap)) {
            icon = Utilities.createIconBitmap(new FastBitmapDrawable((Bitmap) bitmap), context);
            customIcon = true;
        } else {
            Parcelable extra = data.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            if (extra != null && (extra instanceof Intent.ShortcutIconResource)) {
                try {
                    iconResource = (Intent.ShortcutIconResource) extra;
                    PackageManager packageManager = context.getPackageManager();
                    Resources resources = packageManager.getResourcesForApplication(iconResource.packageName);
                    int id = resources.getIdentifier(iconResource.resourceName, null, null);
                    icon = Utilities.createIconBitmap(this.mIconCache.getFullResIcon(resources, id), context);
                } catch (Exception e) {
                    Log.w(TAG, "Could not load shortcut icon: " + extra);
                }
            }
        }
        ShortcutInfo info = new ShortcutInfo();
        if (icon == null) {
            if (fallbackIcon != null) {
                icon = fallbackIcon;
            } else {
                icon = getFallbackIcon();
                info.usingFallbackIcon = true;
            }
        }
        info.setIcon(icon);
        info.title = name;
        info.intent = intent;
        info.customIcon = customIcon;
        info.iconResource = iconResource;
        return info;
    }

    boolean queueIconToBeChecked(HashMap<Object, byte[]> cache, ShortcutInfo info, Cursor c, int iconIndex) {
        if (!this.mAppsCanBeOnRemoveableStorage || info.customIcon || info.usingFallbackIcon) {
            return false;
        }
        cache.put(info, c.getBlob(iconIndex));
        return true;
    }

    void updateSavedIcon(Context context, ShortcutInfo info, byte[] data) {
        boolean needSave;
        if (data != null) {
            try {
                Bitmap saved = BitmapFactory.decodeByteArray(data, 0, data.length);
                Bitmap loaded = info.getIcon(this.mIconCache);
                needSave = !saved.sameAs(loaded);
            } catch (Exception e) {
                needSave = true;
            }
        } else {
            needSave = true;
        }
        if (needSave) {
            Log.d(TAG, "going to save icon bitmap for info=" + info);
            updateItemInDatabase(context, info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FolderInfo findOrMakeFolder(HashMap<Long, FolderInfo> folders, long id) {
        FolderInfo folderInfo = folders.get(Long.valueOf(id));
        if (folderInfo == null) {
            FolderInfo folderInfo2 = new FolderInfo();
            folders.put(Long.valueOf(id), folderInfo2);
            return folderInfo2;
        }
        return folderInfo;
    }

    public static final Comparator<AppInfo> getAppNameComparator() {
        final Collator collator = Collator.getInstance();
        return new Comparator<AppInfo>() { // from class: com.android.launcher66.LauncherModel.16
            @Override // java.util.Comparator
            public final int compare(AppInfo a, AppInfo b) {
                int result = collator.compare(a.title.toString().trim(), b.title.toString().trim());
                if (result == 0) {
                    return a.componentName.compareTo(b.componentName);
                }
                return result;
            }
        };
    }

    public static final Comparator<AppWidgetProviderInfo> getWidgetNameComparator() {
        final Collator collator = Collator.getInstance();
        return new Comparator<AppWidgetProviderInfo>() { // from class: com.android.launcher66.LauncherModel.17
            @Override // java.util.Comparator
            public final int compare(AppWidgetProviderInfo a, AppWidgetProviderInfo b) {
                return collator.compare(a.label.toString().trim(), b.label.toString().trim());
            }
        };
    }

    static ComponentName getComponentNameFromResolveInfo(ResolveInfo info) {
        return info.activityInfo != null ? new ComponentName(info.activityInfo.packageName, info.activityInfo.name) : new ComponentName(info.serviceInfo.packageName, info.serviceInfo.name);
    }

    public static class ShortcutNameComparator implements Comparator<ResolveInfo> {
        private Collator mCollator;
        private HashMap<Object, CharSequence> mLabelCache;
        private PackageManager mPackageManager;

        ShortcutNameComparator(PackageManager pm) {
            this.mPackageManager = pm;
            this.mLabelCache = new HashMap<>();
            this.mCollator = Collator.getInstance();
        }

        ShortcutNameComparator(PackageManager pm, HashMap<Object, CharSequence> labelCache) {
            this.mPackageManager = pm;
            this.mLabelCache = labelCache;
            this.mCollator = Collator.getInstance();
        }

        @Override // java.util.Comparator
        public final int compare(ResolveInfo a, ResolveInfo b) {
            CharSequence labelA;
            CharSequence labelB;
            ComponentName keyA = LauncherModel.getComponentNameFromResolveInfo(a);
            ComponentName keyB = LauncherModel.getComponentNameFromResolveInfo(b);
            if (this.mLabelCache.containsKey(keyA)) {
                labelA = this.mLabelCache.get(keyA);
            } else {
                labelA = a.loadLabel(this.mPackageManager).toString().trim();
                this.mLabelCache.put(keyA, labelA);
            }
            if (this.mLabelCache.containsKey(keyB)) {
                labelB = this.mLabelCache.get(keyB);
            } else {
                labelB = b.loadLabel(this.mPackageManager).toString().trim();
                this.mLabelCache.put(keyB, labelB);
            }
            return this.mCollator.compare(labelA, labelB);
        }
    }

    public static class WidgetAndShortcutNameComparator implements Comparator<Object> {
        private PackageManager mPackageManager;
        private HashMap<Object, String> mLabelCache = new HashMap<>();
        private Collator mCollator = Collator.getInstance();

        WidgetAndShortcutNameComparator(PackageManager pm) {
            this.mPackageManager = pm;
        }

        @Override // java.util.Comparator
        public final int compare(Object a, Object b) {
            String labelA;
            String labelB;
            if (this.mLabelCache.containsKey(a)) {
                labelA = this.mLabelCache.get(a);
            } else {
                labelA = a instanceof AppWidgetProviderInfo ? ((AppWidgetProviderInfo) a).label : ((ResolveInfo) a).loadLabel(this.mPackageManager).toString().trim();
                this.mLabelCache.put(a, labelA);
            }
            if (this.mLabelCache.containsKey(b)) {
                labelB = this.mLabelCache.get(b);
            } else {
                labelB = b instanceof AppWidgetProviderInfo ? ((AppWidgetProviderInfo) b).label : ((ResolveInfo) b).loadLabel(this.mPackageManager).toString().trim();
                this.mLabelCache.put(b, labelB);
            }
            return this.mCollator.compare(labelA, labelB);
        }
    }

    public void dumpState() {
        Log.d(TAG, "mCallbacks=" + this.mCallbacks);
        AppInfo.dumpApplicationInfoList(TAG, "mAllAppsList.data", AllAppsList.data);
        AppInfo.dumpApplicationInfoList(TAG, "mAllAppsList.added", this.mBgAllAppsList.added);
        AppInfo.dumpApplicationInfoList(TAG, "mAllAppsList.removed", this.mBgAllAppsList.removed);
        AppInfo.dumpApplicationInfoList(TAG, "mAllAppsList.modified", this.mBgAllAppsList.modified);
        if (this.mLoaderTask != null) {
            this.mLoaderTask.dumpState();
        } else {
            Log.d(TAG, "mLoaderTask=null");
        }
    }
}
