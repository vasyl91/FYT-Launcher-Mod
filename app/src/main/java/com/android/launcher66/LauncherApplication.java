package com.android.launcher66;

import android.SystemProperties;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.perf.BaselineProfileCompiler;
import com.android.launcher66.settings.CrashLogger;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.LogcatWorker;
import com.android.launcher66.settings.VersionChecker;
import com.android.launcher66.settings.WakeDetectionService;
import com.fyt.skin.SkinManager;
import com.fyt.skin.util.FileUtil;
import com.syu.canbus.ZipCompare;
import com.syu.canbus.cfg.CfgCustom;
import com.syu.canbus.warn.DataPack;
import com.syu.car.CarStates;
import com.syu.module.MsToolkitConnection;
import com.syu.module.canbus.ConnectionCanbus;
import com.syu.module.canbus.up.ConnectionCanUp;
import com.syu.module.main.ConnectionMain;
import com.syu.module.sound.ConnectionSound;
import com.syu.util.CustomIcons;
import com.syu.util.DebugView;
import com.syu.util.FytPackage;
import com.syu.util.ObjApp;
import com.syu.util.Utils;
import com.syu.utils.W3Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LauncherApplication extends Application {
    public static String bHideUniCar;
    public static Boolean frontview_endble;
    public static Boolean justfrontView;
    public static boolean mAppWallPaper;
    public static boolean mWallPaperUpdate;
    public static LauncherApplication sApp;
    public static String sSubplatform;
    private static final String APK_NAME = "firenze.apk";
    private String apkPath;
    private TextView btn_floatView;
    private WindowManager.LayoutParams params;
    private Typeface typeface;
    private WindowManager wm;
    public static Handler handler = new Handler(Looper.getMainLooper());
    public static boolean sForeign = false;
    public static boolean isHaveDvd = false;
    public static int appWidget_Host_Id = 0;
    public static float shadow_Large_Radius = 0.0f;
    public static float shadow_Small_Radius = 0.0f;
    private static ActivityManager sActivityManager;
    private static AssetManager sAssetManager;
    private static Handler sHandler;
    private static boolean sIsRootViewAdd;
    private static Resources sResources;
    private static View sRootView;
    private static WindowManager.LayoutParams sRootViewLp;
    private static WindowManager sWindowManager;
    private static int sScreenSizeId = 0;
    private static final ArrayList<Object> ROOT_VIEW_OBJ = new ArrayList<>();
    private static final String TAG = "LauncherApplication";
    // The wallpaper picker runs in its own process (android:process=":wallpaper_chooser" in the
    // manifest), which creates this class too; see initWallpaperPickerProcess().
    private static final String WALLPAPER_PICKER_PROCESS_SUFFIX = ":wallpaper_chooser";

    /** The first start after a device restart; see ColdStart. Null in the wallpaper picker's process. */
    private ColdStart coldStart;

    public String getApkPath() {
        return this.apkPath;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        // First, so that a crash anywhere below is written to Launcher66_Logs too.
        CrashLogger.install(this);
        long start = SystemClock.elapsedRealtime();
        if (isWallpaperPickerProcess()) {
            initWallpaperPickerProcess();
            Log.d(TAG, "onCreate() in the wallpaper picker process: "
                    + (SystemClock.elapsedRealtime() - start) + "ms");
            return;
        }
        initData();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // First start after a device restart (not a wake from sleep): the launcher is kept in
        // front and the autostart is scheduled, see ColdStart.
        coldStart = ColdStart.start(this, prefs);
        initProperties();
        sHandler = new Handler(Looper.getMainLooper());
        cfg();
        setupBase();
        initWindow();
        connectService();
        DataPack.init(this);
        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }
        // Two binder calls (resolveService, startService), so off the main thread: at a cold boot
        // they could block it during the boot-time stall (see ColdStart).
        handler.postDelayed(() -> new Thread(() -> ServiceIntentGate.startIfAvailable(
                this,
                new Intent(this, WakeDetectionService.class),
                "wake detection"
        ), "StartWakeDetection").start(), 1000);
        LeakCanaryInit.init();
        handler.postDelayed(this::runDeferredStartupWork,
                Math.max(DEFERRED_STARTUP_WORK_MS, ColdStart.bootStallDelayMs()));
        Log.d(TAG, "onCreate(): " + (SystemClock.elapsedRealtime() - start) + "ms");
    }

    /**
     * True in the wallpaper picker's own process. Application.getProcessName() needs
     * Android 9, so older releases keep the full setup there, as before.
     */
    private static boolean isWallpaperPickerProcess() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            return false;
        }
        String processName = Application.getProcessName();
        return processName != null && processName.endsWith(WALLPAPER_PICKER_PROCESS_SUFFIX);
    }

    /**
     * Minimal setup for the wallpaper picker's process. The rest of onCreate() sets up the
     * launcher itself (CAN bus connections, services, file copies, overlay windows, logcat
     * capture), none of which the picker uses. In this process it only duplicated the
     * launcher's own work: about 0.3 s on the main thread during the picker's cold start, plus
     * CAN bus class loading on a background thread while the picker was starting.
     * The fields set here are the cheap ones that this class's static helpers read.
     */
    private void initWallpaperPickerProcess() {
        sApp = this;
        // Kept: cheap, and the skin may style views in this process too.
        SkinManager.init(this);
        CrashHandler.getInstance(getApplicationContext());
        sHandler = new Handler(Looper.getMainLooper());
        initStaticFields();
        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }
    }

    /** The system services and resources this class's static helpers read; in every process. */
    private void initStaticFields() {
        sActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        sWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        sResources = getResources();
        sAssetManager = sResources.getAssets();
        try {
            sScreenSizeId = sResources.getIntArray(R.array.screen_size)[0];
        } catch (RuntimeException e) {
            Log.w(TAG, "No screen size id", e);
        }
        sRootView = new View(this);
    }

    private void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build());
    }

    private void initProperties() {
        sSubplatform = SystemProperties.get("sys.fyt.subplatform", "0");
        sForeign = true;
        frontview_endble = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.zh_frontview_enable", true));
        justfrontView = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.justfrontView", false));
        appWidget_Host_Id = Utils.getNameToInteger("appwidget_host_id") + 1024;
        boolean textShadow = Utils.getNameToBool("apps_textview_shadow");
        if (textShadow) {
            shadow_Large_Radius = 4.0f;
            shadow_Small_Radius = 1.75f;
        }
        // Package manager calls, so off the main thread: at a cold boot they can block it for
        // seconds during the boot-time stall (see ColdStart). Nothing waits for them.
        final int auxEnable = justfrontView.booleanValue() ? 0 : 1;
        final int frontVideoEnable = frontview_endble.booleanValue() ? 1 : 0;
        new Thread(() -> {
            appEnable(FytPackage.auxAction, auxEnable);
            appEnable(FytPackage.frontvideoAction, frontVideoEnable);
        }, "AppEnable").start();
    }

    private void initData() {
        sApp = this;
        SkinManager.init(this);
        CrashHandler.getInstance(getApplicationContext());
        CustomIcons.loadIcons(this, R.xml.custom_icons);
        W3Utils.initialize(this);
        CarStates.getCar(this);
        this.apkPath = new File(getFilesDir(), APK_NAME).getAbsolutePath();
        // Copied once, 3 s after the start as before, but off the main thread: the file is large,
        // and at a cold boot this falls into the boot-time stall.
        handler.postDelayed(() -> new Thread(this::copyApkIfMissing, "ApkCopy").start(), 3000);
        initGaoDeCoverView();
        new ObjApp(getApplicationContext());
        initStaticFields();
    }


    /**
     * Copies the APK asset next to its final name first and renames it once it is complete and on
     * disk: whoever reads getApkPath() meanwhile finds no file rather than half of one, and a copy
     * cut off by a full storage, the process ending or a power cut is never taken for a finished
     * one at the next start (only exists() is checked).
     */
    private void copyApkIfMissing() {
        File target = new File(apkPath);
        if (target.exists()) {
            return;
        }
        File partial = new File(apkPath + ".partial");
        // Left by a copy that was cut off: removed first, so it can never be renamed into place.
        if (partial.exists() && !partial.delete()) {
            Log.w(TAG, "Cannot delete the stale " + partial);
            return;
        }
        try {
            // FileUtil reports whether the whole asset was written; the length alone did not
            // tell a complete copy from one cut off by a full storage.
            if (FileUtil.copyFileFromAssets(this, APK_NAME, partial.getAbsolutePath())
                    && partial.length() > 0
                    && syncToDisk(partial)
                    && partial.renameTo(target)) {
                return;
            }
            Log.w(TAG, "Copy of " + APK_NAME + " failed");
        } catch (RuntimeException e) {
            Log.w(TAG, "Copy of " + APK_NAME + " failed", e);
        }
        if (partial.exists() && !partial.delete()) {
            Log.w(TAG, "Cannot delete " + partial);
        }
    }

    /**
     * fsync before the rename: a head unit can lose power at any moment, and without it the
     * rename could reach the storage before the data, leaving an empty file under the final name.
     */
    private static boolean syncToDisk(File file) {
        try (FileOutputStream out = new FileOutputStream(file, true)) {
            out.getFD().sync();
            return true;
        } catch (IOException e) {
            Log.w(TAG, "Cannot sync " + file, e);
            return false;
        }
    }

    public void removeGaoDeCoverView() {
        try {
            if (btn_floatView != null && btn_floatView.isAttachedToWindow()) {
                wm.removeView(btn_floatView);
            }
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Cannot remove the GaoDe cover view", e);
        }
    }

    private void initGaoDeCoverView() {
        this.btn_floatView = new TextView(sApp);
        this.btn_floatView.setBackgroundColor(Color.parseColor("#ffffff"));
        this.wm = (WindowManager) sApp.getSystemService(Context.WINDOW_SERVICE);
        this.params = new WindowManager.LayoutParams();
        this.params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        this.params.format = 1;
        this.params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        this.params.width = 45;
        this.params.height = 45;
        this.params.x = InstallShortcutReceiver.NEW_SHORTCUT_BOUNCE_DURATION;
        this.params.y = -230;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    /** Enables (enable != 0) or disables a package, if it is not in that state already. */
    public static void appEnable(String packageName, int enable) {
        int state = enable == 0
                ? PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                : PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        try {
            PackageManager pm = sApp.getPackageManager();
            if (pm.getApplicationEnabledSetting(packageName) != state) {
                pm.setApplicationEnabledSetting(packageName, state, PackageManager.DONT_KILL_APP);
            }
        } catch (RuntimeException e) { // not installed on this unit, or not allowed
            Log.d(TAG, "appEnable(" + packageName + ", " + enable + ") skipped: " + e);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        LauncherAppState.getInstance().onTerminate();
    }

    public static LauncherApplication getInstance() {
        return sApp;
    }

    public static Resources getRes() {
        return sResources;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static int getScreenSizeId() {
        return sScreenSizeId;
    }

    public void postDelayed(Runnable runnable, int delay) {
        if (runnable != null) {
            sHandler.postDelayed(runnable, delay);
        }
    }

    public void removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            sHandler.removeCallbacks(runnable);
        }
    }

    public int isScreensOriatationPortrait() {
        int result = getResources().getConfiguration().orientation;
        return result;
    }

    public static void showWindow(PopupWindow window, int gravity, int x, int y) {
        window.showAtLocation(sRootView, gravity, x, y);
    }

    /**
     * Whether the launcher's task is the most recently active one, of any display: the PiP panes'
     * virtual displays count too. That is on purpose: HandlerMain re-sends the launcher's app id to
     * the MCU while this is true, and com.syu.ms decides the same thing from getRunningTasks(1),
     * panes included. Judged by the screen alone (see DefaultDisplayTask) the two could keep
     * overriding each other.
     */
    @SuppressWarnings("deprecation")
    public static boolean isAppTop() {
        List<ActivityManager.RunningTaskInfo> list =
                sActivityManager != null ? sActivityManager.getRunningTasks(1) : null;
        if (list == null || list.isEmpty()) {
            return false;
        }
        // baseActivity is null for a task without activities.
        ComponentName base = list.get(0).baseActivity;
        return base != null && sApp.getPackageName().equals(base.getPackageName());
    }

    /**
     * Copies the Can_Back.ogg asset to Can_Back.bin, unless the existing file has the same content.
     * File work: runs off the main thread, see runDeferredStartupWork().
     */
    public void writeCanOgg() {
        File outFile = getWritableCanBackFile();
        if (outFile == null) {
            Log.w(TAG, "writeCanOgg: no writable storage");
            return;
        }
        try (InputStream asset = getAssets().open("Can_Back.ogg")) {
            if (sameAsLegacyFile(asset, outFile)) {
                return;
            }
            File parent = outFile.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                Log.w(TAG, "writeCanOgg: cannot create " + parent);
            }
            try (FileOutputStream out = new FileOutputStream(outFile)) {
                byte[] buffer = new byte[4096];
                int len;
                while ((len = asset.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
            }
        } catch (Throwable t) {
            Log.w(TAG, "writeCanOgg failed safely", t);
        }
    }

    /**
     * Whether outFile is the legacy file and already holds the asset's content. The asset stream
     * is reset afterwards, so it can still be copied.
     */
    private static boolean sameAsLegacyFile(InputStream asset, File outFile) throws IOException {
        File existing = getReadableLegacyFile();
        if (existing == null || !outFile.equals(existing) || !asset.markSupported()) {
            return false;
        }
        try (InputStream existingIn = new FileInputStream(existing)) {
            asset.mark(asset.available());
            boolean same = ZipCompare.isSameZip(asset, existingIn);
            asset.reset();
            return same;
        }
    }

    /** /sdcard for the system build, else the app's scoped storage; null if that is unavailable. */
    private static File getWritableCanBackFile() {
        if (hasSystemPrivileges()) {
            return new File("/sdcard/Can_Back.bin");
        }
        File dir = sApp.getExternalFilesDir(null);
        return dir != null ? new File(dir, "Can_Back.bin") : null;
    }

    private static File getReadableLegacyFile() {
        if (!hasSystemPrivileges()) {
            return null;
        }
        File legacy = new File("/sdcard/Can_Back.bin");
        return legacy.exists() && legacy.canRead() ? legacy : null;
    }

    private void cfg() {
        CfgCustom.cfgCustom();
    }

    private void setupBase() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.height = -1;
        lp.width = -1;
        lp.format = 1;
        lp.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        sRootViewLp = lp;
        sRootView = new View(this);
        DebugView msgView = ObjApp.getMsgView();
        if (msgView.isDbg()) {
            ObjApp.getWindowManager().addView(msgView, msgView.getWindowLayoutParams());
        }
    }

    public View getRootView() {
        return sRootView;
    }

    public static Context getAppContext() {
        return sApp;
    }

    public static int getConfiguration() {
        return sApp.getResources().getConfiguration().orientation;
    }

    public static boolean isPortrait() {
        return getConfiguration() == 1;
    }

    private void initWindow() {
        Log.i("SCREEN", " LauncherApplication.getScreenWidth() == " + getScreenWidth() + "  LauncherApplication.getScreenHeight() = " + getScreenHeight() + "  smallestScreenWidth = " + getSmallestScreenWidth());
    }

    public static int getScreenHeight() {
        return getRealScreenSize().y;
    }

    public static int getScreenWidth() {
        return getRealScreenSize().x;
    }

    public static int getSmallestScreenWidth() {
        Configuration config = getAppContext().getResources().getConfiguration();
        return config.smallestScreenWidthDp;
    }

    public static Point getRealScreenSize() {
        if (sWindowManager == null) return new Point(0, 0);

        Display display = sWindowManager.getDefaultDisplay();
        Point screenSize = new Point();

        display.getRealSize(screenSize);
        return screenSize;
    }

    private void connectService() {
        MsToolkitConnection.getInstance().addObserver(ConnectionCanbus.getInstance());
        MsToolkitConnection.getInstance().addObserver(ConnectionMain.getInstance());
        MsToolkitConnection.getInstance().addObserver(ConnectionSound.getInstance());
        MsToolkitConnection.getInstance().addObserver(ConnectionCanUp.getInstance());
        MsToolkitConnection.getInstance().connect(this);
    }

    public void activityByIntentName(String value) {
        try {
            Intent intent = new Intent(value);
            defIntentSetForStartActivity(intent);
            startActivity(intent);
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot start " + value + ": " + e);
        }
    }

    private void defIntentSetForStartActivity(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * The flag is set only once the window is really there. It used to be set before addView(),
     * so a failed addView() (no overlay permission, no window manager in this process) left it
     * set, and the matching removeRootView() then crashed on a view that was never added.
     */
    public static void addRootView(Object obj) {
        if (obj != null && !ROOT_VIEW_OBJ.contains(obj)) {
            ROOT_VIEW_OBJ.add(obj);
        }
        if (!sIsRootViewAdd && sWindowManager != null && sRootViewLp != null) {
            try {
                sWindowManager.addView(sRootView, sRootViewLp);
                sIsRootViewAdd = true;
            } catch (RuntimeException e) {
                Log.w(TAG, "Cannot add the root view", e);
            }
        }
    }

    public static void removeRootView(Object obj) {
        if (obj != null && ROOT_VIEW_OBJ.contains(obj)) {
            ROOT_VIEW_OBJ.remove(obj);
        }
        if (sIsRootViewAdd && ROOT_VIEW_OBJ.size() == 0) {
            sIsRootViewAdd = false;
            try {
                sWindowManager.removeView(sRootView);
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "Root view was not attached", e);
            }
        }
    }

    public static IBinder rootViewWindowToken() {
        return sRootView.getWindowToken();
    }

    public static boolean hasSystemPrivileges() {
        ApplicationInfo ai = sApp.getApplicationInfo();
        return ai.uid == android.os.Process.SYSTEM_UID || (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    public static boolean isFytDevice() {
        String board = SystemProperties.get("ro.product.board");
        String manufacturer = SystemProperties.get("ro.product.manufacturer");
        String platform = SystemProperties.get("ro.fyt.platform");
        String displayId = Build.DISPLAY;

        return (board != null && board.toUpperCase().contains("FYT")) ||
               (manufacturer != null && manufacturer.toUpperCase().contains("FYT")) ||
               (platform != null && !platform.isEmpty()) ||
               (displayId != null && displayId.toUpperCase().contains("FYT"));
    }

    public static boolean isServiceRunning(Class<? extends Service> serviceClass) {
        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            for (ActivityManager.RunningServiceInfo service : runningServices) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // ---------------------------------------------------------------------------------------------
    // Deferred startup work
    // ---------------------------------------------------------------------------------------------

    /** When not booting, the deferred startup work still runs after the first screen. */
    private static final long DEFERRED_STARTUP_WORK_MS = 3000L;

    /**
     * Startup work that neither the first screen nor the rest of the start needs. At a cold boot it
     * runs once the boot-time stall is over, by which time shared storage is mounted too:
     * writeCanOgg() used to run in onCreate() and failed with ENOENT on /sdcard at every boot. Its
     * file work runs off the main thread.
     */
    private void runDeferredStartupWork() {
        Thread canOgg = new Thread(this::writeCanOgg, "CanOggWriter");
        canOgg.setPriority(Thread.MIN_PRIORITY);
        canOgg.start();
        // A device restart always counts as a Baseline Profile usage session.
        BaselineProfileCompiler.scheduleIfNeeded(this, coldStart != null && coldStart.isColdBoot());
        VersionChecker.deleteInstalledUpdates(this);
    }
}
