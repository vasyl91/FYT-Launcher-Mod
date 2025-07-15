package com.android.launcher66;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.LogcatService;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LauncherApplication extends Application {
    public static String bHideUniCar;
    public static String bHideUniCar_New;
    public static String bPlatform;
    public static Boolean frontview_endble;
    public static Boolean justfrontView;
    public static boolean mAppWallPaper;
    public static String mSimUsableFlow;
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

    public String getApkPath() {
        return this.apkPath;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("LauncherApplication", "onCreate()");
        long start = SystemClock.elapsedRealtime();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean logcatBoolean = prefs.getBoolean("logcat_service", true);
        boolean isDebug = BuildConfig.DEBUG;
        if (logcatBoolean && isDebug) {
            startService(new Intent(this, LogcatService.class));
        }
        initData();
        initProperties();
        sHandler = new Handler(Looper.getMainLooper());
        CrashHandler.getInstance(getApplicationContext());
        writeCanOgg();
        cfg();
        setupBase();
        initWindow();
        connectService();
        DataPack.init(this);
        if (isDebug) {
            enableStrictMode();
        }
        handler.postDelayed(() -> {
            startService(new Intent(this, WakeDetectionService.class));
        }, 1000);
        Log.d("LauncherApplication", "onCreate(): " + (SystemClock.elapsedRealtime() - start) + "ms");
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
        this.apkPath = String.valueOf(sApp.getFilesDir().getAbsolutePath()) + File.separator + "firenze.apk";
        File file = new File(this.apkPath);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (!file.exists()) {
                FileUtil.copyFileFromAssets(this, "firenze.apk", this.apkPath);
            }
        }, 3000);
        //mAppWallPaper = Utils.getSp().getBoolean("mAppWallPaper", true);
        //mWallPaperUpdate = Utils.getSp().getBoolean("mWallPaperUpdate", true);
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

    public void addGaoDeCoverView() {
        this.wm.addView(this.btn_floatView, this.params);
    }

    public void removeGaoDeCoverView() {
        this.wm.removeView(this.btn_floatView);
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

    public static int getScreenWidth() {
        int result = sWindowManager.getDefaultDisplay().getWidth();
        return result;
    }

    public static int getScreenHeight() {
        int result = sWindowManager.getDefaultDisplay().getHeight();
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
        try {
            AssetManager assetManager = getAssets();
            InputStream is = assetManager.open("Can_Back.ogg");
            if (is != null) {
                boolean bWrite = true;
                File file = new File("/sdcard/Can_Back.bin");
                FileInputStream fileInputStream = null;
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    is.mark(is.available());
                    bWrite = !ZipCompare.isSameZip(is, fileInputStream);
                    is.reset();
                }
                if (bWrite) {
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = is.read(buffer);
                        if (len == -1) {
                            break;
                        } else {
                            fos.write(buffer, 0, len);
                        }
                    }
                    fos.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Configuration config = getResources().getConfiguration();
        int smallestScreenWidth = config.smallestScreenWidthDp;
        Log.i("SCREEN", " LauncherApplication.getScreenWidth() == " + getScreenWidth() + "  LauncherApplication.getScreenHeight() = " + getScreenHeight() + "  smallestScreenWidth = " + smallestScreenWidth);
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
}
