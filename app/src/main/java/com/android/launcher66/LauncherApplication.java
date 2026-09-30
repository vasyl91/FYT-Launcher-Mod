package com.android.launcher66;

import android.SystemProperties;
import android.app.Activity;
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
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.ActionMode;
import android.view.Display;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.perf.BaselineProfileCompiler;
import com.android.launcher66.settings.AppListAutostartDialogFragment;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LauncherApplication extends Application {
    public static String bHideUniCar;
    public static Boolean frontview_endble;
    public static Boolean justfrontView;
    public static boolean mAppWallPaper;
    public static boolean mWallPaperUpdate;
    public static LauncherApplication sApp;
    public static String sSubplatform;
    private final String apkName = "firenze.apk";
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

    public String getApkPath() {
        return this.apkPath;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("LauncherApplication", "onCreate()");
        long start = SystemClock.elapsedRealtime();
        if (isWallpaperPickerProcess()) {
            initWallpaperPickerProcess();
            Log.d("LauncherApplication", "onCreate() in the wallpaper picker process: "
                    + (SystemClock.elapsedRealtime() - start) + "ms");
            return;
        }
        initData();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean logcatBoolean = prefs.getBoolean(Keys.LOGCAT_SERVICE, true);
        if (logcatBoolean) {
            LogcatWorker.get().start(this);
        }
        initProperties();
        sHandler = new Handler(Looper.getMainLooper());
        CrashHandler.getInstance(getApplicationContext());
        cfg();
        setupBase();
        initWindow();
        connectService();
        DataPack.init(this);
        // Only after a real restart, not after a wake from sleep; see the section at the end.
        // The boot is recorded here once, whatever the settings, for the guard and the autostart.
        boolean coldBoot = isMainProcess() && isFirstStartAfterColdBoot();
        coldBootStart = coldBoot;
        startBootFrontGuardIfColdBoot(coldBoot, prefs.getBoolean(Keys.LAUNCHER_HOME, true));
        if (coldBoot) {
            scheduleBootAutostart(prefs.getBoolean(Keys.LAUNCHER_HOME, true));
        }
        boolean isDebug = BuildConfig.DEBUG;
        if (isDebug) {
            enableStrictMode();
        }
        handler.postDelayed(() -> ServiceIntentGate.startIfAvailable(
                this,
                new Intent(this, WakeDetectionService.class),
                "wake detection"
        ), 1000);
        LeakCanaryInit.init();
        handler.postDelayed(this::runDeferredStartupWork,
                Math.max(DEFERRED_STARTUP_WORK_MS, bootStallDelayMs()));
        Log.d("LauncherApplication", "onCreate(): " + (SystemClock.elapsedRealtime() - start) + "ms");
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
        sActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        sWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        sResources = getResources();
        sAssetManager = sResources.getAssets();
        try {
            sScreenSizeId = getResources().getIntArray(R.array.screen_size)[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        sRootView = new View(this);
        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }
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
        appEnable(FytPackage.auxAction, justfrontView.booleanValue() ? 0 : 1);
        appEnable(FytPackage.frontvideoAction, frontview_endble.booleanValue() ? 1 : 0);
    }

    private void initData() {
        sApp = this;
        SkinManager.init(this);
        CrashHandler.getInstance(getApplicationContext());
        CustomIcons.loadIcons(this, R.xml.custom_icons);
        W3Utils.initialize(this);
        CarStates.getCar(this);
        this.apkPath = String.valueOf(sApp.getFilesDir().getAbsolutePath()) + File.separator + apkName;
        File file = new File(this.apkPath);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (!file.exists()) {
                FileUtil.copyFileFromAssets(this, apkName, this.apkPath);
            }
        }, 3000);
        initGaoDeCoverView();
        new ObjApp(getApplicationContext());
        sActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        sWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        sResources = getResources();
        sAssetManager = sResources.getAssets();
        try {
            sScreenSizeId = getResources().getIntArray(R.array.screen_size)[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        sRootView = new View(this);
    }


    public void removeGaoDeCoverView() {
        try {
            if (btn_floatView != null && btn_floatView.isAttachedToWindow()) {
                wm.removeView(btn_floatView);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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

    public static void appEnable(String packageName, int enable) {
        int state = enable == 0 ? 2 : 1;
        int appState = 3;
        if (state == 1) {
            appState = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        } else if (state == 2) {
            appState = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        }
        try {
            if (appState != 3) {
                if (appState != sApp.getPackageManager().getApplicationEnabledSetting(packageName)) {
                    sApp.getPackageManager().setApplicationEnabledSetting(packageName, appState, PackageManager.DONT_KILL_APP);
                }
            }
        } catch (Exception e) {
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

    public static boolean isAppTop() {
        List<ActivityManager.RunningTaskInfo> list = sActivityManager.getRunningTasks(1);
        if (list == null || list.size() <= 0) {
            return false;
        }
        return sApp.getPackageName().equals(list.get(0).baseActivity.getPackageName());
    }

    public void writeCanOgg() {
        InputStream assetIs = null;
        InputStream existingIs = null;
        FileOutputStream fos = null;

        try {
            assetIs = getAssets().open("Can_Back.ogg");
            if (assetIs == null) return;

            File outFile = getWritableCanBackFile();
            boolean bWrite = true;

            File existingFile = getReadableLegacyFile();
            if (existingFile != null && outFile.equals(existingFile)) {
                existingIs = new FileInputStream(existingFile);

                if (assetIs.markSupported()) {
                    assetIs.mark(assetIs.available());
                    bWrite = !ZipCompare.isSameZip(assetIs, existingIs);
                    assetIs.reset();
                }
            }

            if (!bWrite) return;

            File parent = outFile.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();

            fos = new FileOutputStream(outFile);
            byte[] buffer = new byte[4096];
            int len;

            while ((len = assetIs.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();

        } catch (Throwable t) {
            Log.w("LauncherApplication", "writeCanOgg failed safely", t);
        } finally {
            try { if (assetIs != null) assetIs.close(); } catch (Exception ignored) {}
            try { if (existingIs != null) existingIs.close(); } catch (Exception ignored) {}
            try { if (fos != null) fos.close(); } catch (Exception ignored) {}
        }
    }

    private static File getWritableCanBackFile() {
        if (hasSystemPrivileges()) {
            return new File("/sdcard/Can_Back.bin");
        }

        // Always scoped storage for non-system apps
        return new File(
            sApp.getExternalFilesDir(null),
            "Can_Back.bin"
        );
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
        } catch (Exception e) {
        }
    }

    private void defIntentSetForStartActivity(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public static void addRootView(Object obj) {
        if (obj != null && !ROOT_VIEW_OBJ.contains(obj)) {
            ROOT_VIEW_OBJ.add(obj);
        }
        if (!sIsRootViewAdd) {
            sIsRootViewAdd = true;
            sWindowManager.addView(sRootView, sRootViewLp);
        }
    }

    public static void removeRootView(Object obj) {
        if (obj != null && ROOT_VIEW_OBJ.contains(obj)) {
            ROOT_VIEW_OBJ.remove(obj);
        }
        if (sIsRootViewAdd && ROOT_VIEW_OBJ.size() == 0) {
            sIsRootViewAdd = false;
            sWindowManager.removeView(sRootView);
        }
    }

    public static IBinder rootViewWindowToken() {
        return sRootView.getWindowToken();
    }

    public static boolean hasSystemPrivileges() {
        ApplicationInfo ai = sApp.getApplicationInfo();

        if (ai.uid == 1000) {
            return true;
        }

        if ((ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
            return true;
        }

        return false;
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
    // Boot-time stall
    // ---------------------------------------------------------------------------------------------

    /**
     * Uptime by which this ROM's boot-time stall is over. At every cold boot the audioserver hangs
     * (FYT BT hands-free init), all 31 binder threads of system_server end up waiting for it, and
     * for about ten seconds every call from any app into system_server blocks: "binder thread pool
     * (31 threads) starved for 10104 ms", captures 28-09-2026 23:13 and 23:16, from ~23 s to ~36 s
     * of uptime. Work that is not needed for the first screen waits for this instead of freezing
     * the launcher in the middle of it.
     */
    public static final long BOOT_STALL_OVER_UPTIME_MS = 45_000L;

    /** Delay for work that can wait: until the boot-time stall is over, 0 when not booting. */
    public static long bootStallDelayMs() {
        return Math.max(0L, BOOT_STALL_OVER_UPTIME_MS - SystemClock.elapsedRealtime());
    }

    /** Whether this process start is the first one after a device restart (set in onCreate()). */
    private boolean coldBootStart;

    /** When not booting, the deferred startup work still runs after the first screen. */
    private static final long DEFERRED_STARTUP_WORK_MS = 3000L;

    /**
     * Startup work that neither the first screen nor the rest of the start needs. At a cold boot it
     * runs once the stall is over, by which time shared storage is mounted too: writeCanOgg() used
     * to run in onCreate() and failed with ENOENT on /sdcard at every boot. Its file work runs off
     * the main thread.
     */
    private void runDeferredStartupWork() {
        Thread canOgg = new Thread(this::writeCanOgg, "CanOggWriter");
        canOgg.setPriority(Thread.MIN_PRIORITY);
        canOgg.start();
        // A device restart always counts as a Baseline Profile usage session.
        BaselineProfileCompiler.scheduleIfNeeded(this, coldBootStart);
        VersionChecker.deleteInstalledUpdates(this);
    }

    // ---------------------------------------------------------------------------------------------
    // Autostart after the boot-time stall
    // ---------------------------------------------------------------------------------------------

    /*
     * The apps the user picked in AppListAutostartDialogFragment (stored under its
     * "boot_autostart_packages"), started once the boot-time stall is over.
     *
     * FYT SystemUI starts the apps on its own autostart list about three seconds after
     * BOOT_COMPLETED, which is exactly when the stall begins. The app's activity then takes the
     * top while system_server is starved, and the launcher's main thread waits ~11 s inside the
     * framework's own activityTopResumedStateLost() call, which no launcher code can avoid
     * (capture 28-09-2026 23:42, JamesDSP started at 50.2 s, launcher frozen until 02.2 s).
     * An app moved from FYT's list to this one starts after the stall instead.
     */

    /** Margin after the stall, so that the pane rebuild has usually finished as well. */
    private static final long BOOT_AUTOSTART_MARGIN_MS = 2000L;
    /**
     * Gap between two autostarted apps, and before the launcher comes back after the last one.
     * Each app gets it to come up on its own (JamesDSP closes its window after ~1.4 s) before the
     * next one competes with it for the CPU and for the top.
     */
    private static final long BOOT_AUTOSTART_GAP_MS = 3000L;

    private void scheduleBootAutostart(final boolean returnToLauncher) {
        final List<String> packages = AppListAutostartDialogFragment.getSelectedPackages(this);
        if (packages.isEmpty()) {
            return;
        }
        long delay = bootStallDelayMs() + BOOT_AUTOSTART_MARGIN_MS;
        Log.i(TAG, "Boot autostart of " + packages + " in " + delay + " ms, "
                + BOOT_AUTOSTART_GAP_MS + " ms apart");
        handler.postDelayed(() -> new Thread(() -> startBootAutostartApps(packages, returnToLauncher),
                "BootAutostart").start(), delay);
    }

    /**
     * Off the main thread: resolving and starting an app are both calls into system_server, and
     * the gaps are plain sleeps on this thread.
     */
    private void startBootAutostartApps(List<String> packages, boolean returnToLauncher) {
        PackageManager pm = getPackageManager();
        List<String> started = new ArrayList<>();
        for (String pkg : packages) {
            try {
                Intent launch = pm.getLaunchIntentForPackage(pkg);
                if (launch == null) {
                    // Uninstalled since it was picked: skipped, and no gap spent on it.
                    Log.w(TAG, "Boot autostart: " + pkg + " has no launch activity");
                    continue;
                }
                if (!started.isEmpty()) {
                    SystemClock.sleep(BOOT_AUTOSTART_GAP_MS);
                }
                launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(launch);
                started.add(pkg);
                Log.i(TAG, "Boot autostart: started " + pkg
                        + " (" + started.size() + "/" + packages.size() + ")");
            } catch (RuntimeException e) {
                Log.w(TAG, "Boot autostart of " + pkg + " failed", e);
            }
        }
        if (returnToLauncher && !started.isEmpty()) {
            SystemClock.sleep(BOOT_AUTOSTART_GAP_MS);
            returnToLauncherAfterAutostart(started);
        }
    }

    /**
     * The autostarted apps do not need to stay in front, as with FYT's autostart during the boot
     * guard. The launcher comes back only over one of them, never over something the user has
     * opened meanwhile, and -- the guard's rule, see waitForCover() -- only once that app is up,
     * or Android would never launch its activity.
     */
    private void returnToLauncherAfterAutostart(List<String> started) {
        ComponentName top = topActivity();
        if (top == null || !started.contains(top.getPackageName())) {
            return;
        }
        long deadline = SystemClock.uptimeMillis() + BOOT_FRONT_MAX_START_WAIT_MS;
        while (!isPackageRunning(top.getPackageName()) && SystemClock.uptimeMillis() < deadline) {
            SystemClock.sleep(BOOT_FRONT_STARTING_POLL_MS);
        }
        SystemClock.sleep(BOOT_FRONT_COVER_GRACE_MS);
        top = topActivity();
        if (top == null || !started.contains(top.getPackageName())) {
            return; // it closed itself meanwhile (JamesDSP does), or the user opened something
        }
        Log.i(TAG, "Boot autostart done, bringing the launcher back over " + top.flattenToShortString());
        bringLauncherToFront();
    }

    // ---------------------------------------------------------------------------------------------
    // Launcher in front after a device restart
    //
    // For BOOT_FRONT_WINDOW_MS after a cold boot nothing keeps the launcher down: whatever comes up
    // over it (FYT SystemUI's autostart apps, com.syu.ms restoring the last app, ...) is sent back
    // behind it as soon as it has started, as often as it takes. Left in front are only what the
    // user opens from the launcher and a few protected apps (reversing camera, phone, system
    // dialogs); see isProtectedCover(). Wakes from sleep are WakeDetectionService's job.
    // The checks run on their own thread, see bootFrontThread.
    // ---------------------------------------------------------------------------------------------

    /** A start later than this after the kernel booted is not a boot-time start. */
    private static final long COLD_BOOT_MAX_UPTIME_MS = 3 * 60 * 1000L;
    /** How long after the start the launcher is kept in front. */
    private static final long BOOT_FRONT_WINDOW_MS = 20000L;
    /** Regular re-check while the guard runs, besides the checks each pause of the launcher triggers. */
    private static final long BOOT_FRONT_CHECK_INTERVAL_MS = 1000L;
    /** First check after the launcher was paused; the system launches what paused it meanwhile. */
    private static final long BOOT_FRONT_PAUSE_CHECK_MS = 250L;
    /** Re-check interval while the covering app's process is still starting. */
    private static final long BOOT_FRONT_STARTING_POLL_MS = 150L;
    /** Longest wait for the covering app's process; after that the launcher comes back anyway. */
    private static final long BOOT_FRONT_MAX_START_WAIT_MS = 10000L;
    /**
     * Time a covering app gets once its process runs, before the launcher comes back: enough for
     * its onCreate(), where autostart activities (openpanorama, JamesDSP) start their service.
     */
    private static final long BOOT_FRONT_COVER_GRACE_MS = 800L;
    /** Minimum time between two pull-backs, and how many there may be at most. */
    private static final long BOOT_FRONT_MIN_PULL_GAP_MS = 400L;
    private static final int BOOT_FRONT_MAX_PULL_BACKS = 15;
    /** A pause of the launcher this soon after a touch or key press in it is the user's doing. */
    private static final long USER_ACTION_GRACE_MS = 1500L;
    /**
     * Never pulled back over, and checked before anything else: a reversing camera must stay
     * visible and a call reachable; system dialogs, recents and phone projection are opened on
     * purpose; vasyl.fytrating's WakeActivity is started by the launcher itself.
     */
    private static final List<String> PROTECTED_COVER_PACKAGES = Arrays.asList(
            "android",
            "com.android.systemui",
            "com.android.launcher3",                   // recents on this ROM
            "com.android.settings",
            "com.android.permissioncontroller",
            "com.google.android.permissioncontroller",
            "com.android.packageinstaller",
            "com.google.android.packageinstaller",
            "com.android.phone",
            "com.android.dialer",
            "com.android.incallui",
            "com.syu.ms",
            "com.syu.bt",
            "com.syu.canbus",
            "com.syu.carlink",
            "com.google.android.projection.gearhead",
            "vasyl.fytrating");
    /** Package name parts of camera apps (reversing, 360 view), which are protected as well. */
    private static final String[] PROTECTED_COVER_NAME_PARTS = {"camera", "panorama", "backcar", "reverse"};
    /** A random id the kernel creates at every boot; sleep and wake keep it. */
    private static final String BOOT_ID_PATH = "/proc/sys/kernel/random/boot_id";
    private static final String BOOT_STATE_PREFS = "launcher_boot_state";
    private static final String KEY_LAST_BOOT_ID = "last_boot_id";

    /**
     * The checks run on their own thread: each of them calls into system_server, which stalls for
     * seconds at boot while the audioserver hangs, and on the main thread every such call froze
     * the launcher along with it.
     */
    private HandlerThread bootFrontThread;
    private volatile Handler bootFrontHandler;
    /** For what belongs to the main thread: the windows of the input spy. */
    private final Handler bootFrontMainHandler = new Handler(Looper.getMainLooper());
    private final Object bootFrontLock = new Object();
    private volatile boolean bootFrontGuardActive;
    private long bootFrontDeadline;
    /** Resumed activities of this process, counted on the main thread; above 0 = launcher in front. */
    private volatile int resumedActivities;
    /** uptimeMillis() of the last touch or key press in one of this process' windows. */
    private volatile long lastUserInputUptime;
    private final List<WeakReference<Window>> spiedWindows = new ArrayList<>();
    private volatile int bootFrontPullBacks;
    private long lastPullBackUptime;
    /** What covers the launcher, when it was first seen, and since when its process runs (0 = not yet). */
    private ComponentName currentCover;
    private long coverSeenUptime;
    private long coverRunningUptime;

    /**
     * On the first start of the launcher process after a cold boot, keeps the launcher in front
     * for BOOT_FRONT_WINDOW_MS, if enabled (Keys.LAUNCHER_HOME).
     *
     * The caller records the boot even with the setting off. Otherwise switching it on in the
     * first minutes after boot would make the next process restart (crash, update) look like the
     * first start of this boot, and the launcher could be pulled over an app the user has opened.
     */
    private void startBootFrontGuardIfColdBoot(boolean coldBoot, boolean enabled) {
        if (!coldBoot) {
            return;
        }
        if (!enabled) {
            Log.i(TAG, "Cold boot, but LAUNCHER_HOME is off: launcher left where it is");
            return;
        }
        Log.i(TAG, "Cold boot, keeping the launcher in front for " + BOOT_FRONT_WINDOW_MS + " ms");
        bootFrontThread = new HandlerThread("BootFrontGuard");
        bootFrontThread.start();
        bootFrontHandler = new Handler(bootFrontThread.getLooper());
        bootFrontGuardActive = true;
        bootFrontDeadline = SystemClock.elapsedRealtime() + BOOT_FRONT_WINDOW_MS;
        // Lifecycle callbacks rather than isAppTop(): the launcher's own resumed state is exact,
        // while getRunningTasks() mixes in the tasks on the PiP panes' virtual displays.
        registerActivityLifecycleCallbacks(resumeTracker);
        scheduleBootFrontCheck(BOOT_FRONT_CHECK_INTERVAL_MS);
    }

    /**
     * For the launcher to call when it opens an app for the user. Honoured only right after a
     * touch or key press in the launcher: called from a pause or focus callback it also fired
     * when FYT SystemUI started its autostart apps, and ended the guard exactly when it was needed.
     */
    public void cancelBootFrontGuard() {
        if (!bootFrontGuardActive) {
            return;
        }
        if (!userActedRecently()) {
            Log.i(TAG, "Boot front guard: cancel ignored, no user input in the launcher just before");
            return;
        }
        stopBootFrontGuard("cancelled by the launcher after user input");
    }

    private boolean userActedRecently() {
        long last = lastUserInputUptime;
        return last > 0L && SystemClock.uptimeMillis() - last < USER_ACTION_GRACE_MS;
    }

    /** From the guard's thread or the main thread. */
    private void stopBootFrontGuard(String reason) {
        synchronized (bootFrontLock) {
            if (!bootFrontGuardActive) {
                return;
            }
            bootFrontGuardActive = false;
        }
        bootFrontHandler.removeCallbacks(bootFrontCheck);
        bootFrontThread.quitSafely();
        unregisterActivityLifecycleCallbacks(resumeTracker);
        bootFrontMainHandler.post(this::stopWatchingUserInput);
        Log.i(TAG, "Boot front guard finished: " + reason + " (pulled the launcher back "
                + bootFrontPullBacks + " time(s))");
    }

    private void scheduleBootFrontCheck(long delayMs) {
        Handler handler = bootFrontHandler;
        if (!bootFrontGuardActive || handler == null) {
            return;
        }
        handler.removeCallbacks(bootFrontCheck);
        handler.postDelayed(bootFrontCheck, delayMs);
    }

    /**
     * True only on the first start after a real restart. A wake from sleep keeps the kernel boot
     * id and does not reset elapsedRealtime(), which also counts the time spent asleep.
     */
    private boolean isFirstStartAfterColdBoot() {
        long uptime = SystemClock.elapsedRealtime();
        if (uptime > COLD_BOOT_MAX_UPTIME_MS) {
            Log.d(TAG, "Not a cold boot (uptime " + uptime + " ms), launcher left where it is");
            return false;
        }
        String bootId = readKernelBootId();
        if (bootId == null) {
            // boot_id not readable on this ROM: the uptime check alone decides.
            return true;
        }
        SharedPreferences prefs = getSharedPreferences(BOOT_STATE_PREFS, MODE_PRIVATE);
        if (bootId.equals(prefs.getString(KEY_LAST_BOOT_ID, null))) {
            // Same boot, only the process was restarted (crash, killed): already handled.
            Log.d(TAG, "Boot " + bootId + " already handled, launcher left where it is");
            return false;
        }
        prefs.edit().putString(KEY_LAST_BOOT_ID, bootId).apply();
        return true;
    }

    private static String readKernelBootId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOT_ID_PATH))) {
            String id = reader.readLine();
            return (id == null || id.trim().isEmpty()) ? null : id.trim();
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "Cannot read " + BOOT_ID_PATH + ": " + e);
            return null;
        }
    }

    private final Runnable bootFrontCheck = new Runnable() {
        @Override
        public void run() {
            if (!bootFrontGuardActive) {
                return;
            }
            if (SystemClock.elapsedRealtime() > bootFrontDeadline) {
                stopBootFrontGuard("time window over");
                return;
            }
            // The display, not PowerManager.isInteractive(): ACC off on FYT only switches the
            // display off and leaves the interactive state (and ACTION_SCREEN_OFF) alone, which is
            // also why WakeDetectionService watches the display.
            if (!isDefaultDisplayOn()) {
                stopBootFrontGuard("screen off");
                return;
            }
            long next = checkLauncherInFront();
            if (bootFrontGuardActive) {
                scheduleBootFrontCheck(next);
            }
        }
    };

    /** One check, on the guard's thread. Returns when the next one is due. */
    private long checkLauncherInFront() {
        if (resumedActivities > 0) {
            currentCover = null;
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        long now = SystemClock.uptimeMillis();
        ComponentName cover = topActivity();
        if (cover != null && getPackageName().equals(cover.getPackageName())) {
            // Our own task is on top and about to be resumed: at start, or right after a pull-back.
            return BOOT_FRONT_STARTING_POLL_MS;
        }
        String name = cover != null ? cover.flattenToShortString() : "an unknown activity";
        if (cover != null && !cover.equals(currentCover)) {
            currentCover = cover;
            coverSeenUptime = now;
            coverRunningUptime = 0L;
            Log.i(TAG, "Launcher covered by " + name
                    + (isProtectedCover(cover.getPackageName()) ? ", which is left in front" : ""));
        }
        if (cover != null && isProtectedCover(cover.getPackageName())) {
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        if (cover != null) {
            if (coverRunningUptime == 0L) {
                if (isPackageRunning(cover.getPackageName())) {
                    coverRunningUptime = now;
                } else if (now - coverSeenUptime < BOOT_FRONT_MAX_START_WAIT_MS) {
                    // Pulling back now would leave its activity unlaunched for good: Android 10
                    // only launches activities of the focused stack when their process comes up.
                    return BOOT_FRONT_STARTING_POLL_MS;
                } else {
                    Log.w(TAG, name + " did not start within " + BOOT_FRONT_MAX_START_WAIT_MS + " ms");
                    coverRunningUptime = now - BOOT_FRONT_COVER_GRACE_MS;
                }
            }
            long graceLeft = coverRunningUptime + BOOT_FRONT_COVER_GRACE_MS - now;
            if (graceLeft > 0L) {
                return graceLeft;
            }
        }
        if (lastPullBackUptime > 0L && now - lastPullBackUptime < BOOT_FRONT_MIN_PULL_GAP_MS) {
            return lastPullBackUptime + BOOT_FRONT_MIN_PULL_GAP_MS - now;
        }
        if (bootFrontPullBacks >= BOOT_FRONT_MAX_PULL_BACKS) {
            stopBootFrontGuard("keeps being covered by " + name + ", giving up");
            return BOOT_FRONT_CHECK_INTERVAL_MS;
        }
        bootFrontPullBacks++;
        lastPullBackUptime = now;
        Log.i(TAG, "Bringing the launcher back over " + name + " (" + bootFrontPullBacks + "/"
                + BOOT_FRONT_MAX_PULL_BACKS + ")");
        bringLauncherToFront();
        return BOOT_FRONT_PAUSE_CHECK_MS;
    }

    private static boolean isProtectedCover(String packageName) {
        if (PROTECTED_COVER_PACKAGES.contains(packageName)) {
            return true;
        }
        String lower = packageName.toLowerCase(Locale.ROOT);
        for (String part : PROTECTED_COVER_NAME_PARTS) {
            if (lower.contains(part)) {
                return true;
            }
        }
        return false;
    }

    private final ActivityLifecycleCallbacks resumeTracker = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityResumed(Activity activity) {
            resumedActivities++;
            watchUserInput(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (resumedActivities > 0) {
                resumedActivities--;
            }
            if (resumedActivities > 0 || !bootFrontGuardActive) {
                return;
            }
            if (userActedRecently()) {
                // The user opened something from the launcher: leave it in front.
                stopBootFrontGuard("the user opened something");
            } else {
                scheduleBootFrontCheck(BOOT_FRONT_PAUSE_CHECK_MS);
            }
        }

        @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}
        @Override public void onActivityStarted(Activity activity) {}
        @Override public void onActivityStopped(Activity activity) {}
        @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
        @Override public void onActivityDestroyed(Activity activity) {}
    };

    /**
     * Notes touches and key presses in the activity's window while the guard runs, so that an app
     * the user opens is told apart from one the system brings up. The wrapper forwards everything
     * unchanged and is taken out again when the guard ends.
     */
    private void watchUserInput(Activity activity) {
        Window window = activity.getWindow();
        Window.Callback callback = window != null ? window.getCallback() : null;
        if (callback == null || callback instanceof UserInputSpy) {
            return;
        }
        window.setCallback(new UserInputSpy(callback));
        spiedWindows.add(new WeakReference<>(window));
    }

    private void stopWatchingUserInput() {
        for (WeakReference<Window> ref : spiedWindows) {
            Window window = ref.get();
            // Only if nothing has wrapped our wrapper in the meantime.
            if (window != null && window.getCallback() instanceof UserInputSpy) {
                window.setCallback(((UserInputSpy) window.getCallback()).base);
            }
        }
        spiedWindows.clear();
    }

    private final class UserInputSpy implements Window.Callback {
        final Window.Callback base;

        UserInputSpy(Window.Callback base) {
            this.base = base;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            int action = event.getActionMasked();
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
                lastUserInputUptime = SystemClock.uptimeMillis();
            }
            return base.dispatchTouchEvent(event);
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            lastUserInputUptime = SystemClock.uptimeMillis();
            return base.dispatchKeyEvent(event);
        }

        @Override public boolean dispatchKeyShortcutEvent(KeyEvent event) { return base.dispatchKeyShortcutEvent(event); }
        @Override public boolean dispatchTrackballEvent(MotionEvent event) { return base.dispatchTrackballEvent(event); }
        @Override public boolean dispatchGenericMotionEvent(MotionEvent event) { return base.dispatchGenericMotionEvent(event); }
        @Override public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) { return base.dispatchPopulateAccessibilityEvent(event); }
        @Override public View onCreatePanelView(int featureId) { return base.onCreatePanelView(featureId); }
        @Override public boolean onCreatePanelMenu(int featureId, Menu menu) { return base.onCreatePanelMenu(featureId, menu); }
        @Override public boolean onPreparePanel(int featureId, View view, Menu menu) { return base.onPreparePanel(featureId, view, menu); }
        @Override public boolean onMenuOpened(int featureId, Menu menu) { return base.onMenuOpened(featureId, menu); }
        @Override public boolean onMenuItemSelected(int featureId, MenuItem item) { return base.onMenuItemSelected(featureId, item); }
        @Override public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) { base.onWindowAttributesChanged(attrs); }
        @Override public void onContentChanged() { base.onContentChanged(); }
        @Override public void onWindowFocusChanged(boolean hasFocus) { base.onWindowFocusChanged(hasFocus); }
        @Override public void onAttachedToWindow() { base.onAttachedToWindow(); }
        @Override public void onDetachedFromWindow() { base.onDetachedFromWindow(); }
        @Override public void onPanelClosed(int featureId, Menu menu) { base.onPanelClosed(featureId, menu); }
        @Override public boolean onSearchRequested() { return base.onSearchRequested(); }
        @Override public boolean onSearchRequested(SearchEvent searchEvent) { return base.onSearchRequested(searchEvent); }
        @Override public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) { return base.onWindowStartingActionMode(callback); }
        @Override public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) { return base.onWindowStartingActionMode(callback, type); }
        @Override public void onActionModeStarted(ActionMode mode) { base.onActionModeStarted(mode); }
        @Override public void onActionModeFinished(ActionMode mode) { base.onActionModeFinished(mode); }
        @Override public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) { base.onProvideKeyboardShortcuts(data, menu, deviceId); }
        @Override public void onPointerCaptureChanged(boolean hasCapture) { base.onPointerCaptureChanged(hasCapture); }
    }

    /**
     * Top activity of the most recently active task. The launcher runs as uid 1000, so this
     * includes other apps' tasks (for an ordinary app getRunningTasks() would hide them).
     */
    @SuppressWarnings("deprecation")
    private ComponentName topActivity() {
        try {
            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = am != null ? am.getRunningTasks(1) : null;
            return (tasks == null || tasks.isEmpty()) ? null : tasks.get(0).topActivity;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot read the top task: " + e);
            return null;
        }
    }

    /**
     * Whether a process with this package is up. Only uid 1000 sees other apps' processes here;
     * without it, or on any error, the answer is true so the guard never waits on a guess.
     */
    private boolean isPackageRunning(String packageName) {
        if (android.os.Process.myUid() != android.os.Process.SYSTEM_UID) {
            return true;
        }
        try {
            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> processes =
                    am != null ? am.getRunningAppProcesses() : null;
            if (processes == null) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo info : processes) {
                if (packageName.equals(info.processName)) {
                    return true;
                }
                if (info.pkgList != null) {
                    for (String pkg : info.pkgList) {
                        if (packageName.equals(pkg)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }

    /** Unknown counts as on, as in WakeDetectionService. */
    private boolean isDefaultDisplayOn() {
        DisplayManager dm = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        Display display = dm != null ? dm.getDisplay(Display.DEFAULT_DISPLAY) : null;
        return display == null || display.getState() == Display.STATE_ON;
    }

    /**
     * Same approach as WakeDetectionService.pressHomeButton(), which the wake logs show working
     * on this ROM: a live launcher gets its task moved to the front (no new intent, no second
     * ActivityRecord). The HOME intent is only the fallback when there is no launcher activity;
     * the launcher runs as uid 1000, so the explicit component still counts as a Home start.
     */
    private void bringLauncherToFront() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher != null && !launcher.isFinishing() && !launcher.isDestroyed()) {
            try {
                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                if (am != null) {
                    am.moveTaskToFront(launcher.getTaskId(), 0);
                    return;
                }
            } catch (RuntimeException e) {
                Log.w(TAG, "moveTaskToFront failed, falling back to the HOME intent", e);
            }
        }
        Intent home = new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_HOME)
                .setClass(this, Launcher.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            startActivity(home);
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot bring the launcher to front", e);
        }
    }

    /**
     * Every process of the app creates this class (before Android 9 the wallpaper picker process
     * also gets this far in onCreate()); only the launcher's own process runs the guard.
     */
    private boolean isMainProcess() {
        String processName = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            processName = Application.getProcessName();
        } else if (sActivityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> processes =
                    sActivityManager.getRunningAppProcesses();
            if (processes != null) {
                int pid = android.os.Process.myPid();
                for (ActivityManager.RunningAppProcessInfo info : processes) {
                    if (info.pid == pid) {
                        processName = info.processName;
                        break;
                    }
                }
            }
        }
        return processName == null || processName.equals(getPackageName());
    }
}
