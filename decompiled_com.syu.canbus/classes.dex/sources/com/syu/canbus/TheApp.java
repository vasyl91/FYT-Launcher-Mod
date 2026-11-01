package com.syu.canbus;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.syu.canbus.cfg.CfgCustom;
import com.syu.canbus.warn.DataPack;
import com.syu.module.MsToolkitConnection;
import com.syu.module.canbus.ConnectionCanbus;
import com.syu.module.canbus.up.ConnectionCanUp;
import com.syu.module.main.ConnectionMain;
import com.syu.module.sound.ConnectionSound;
import com.syu.ui.air.AirHelper;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Show_BenzHelper;
import com.syu.ui.carvol.CarVolHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.util.DebugView;
import com.syu.util.ObjApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TheApp extends Application {
    private static ActivityManager sActivityManager;
    private static TheApp sApp;
    private static AssetManager sAssetManager;
    private static Handler sHandler;
    private static boolean sIsRootViewAdd;
    private static Resources sResources;
    private static View sRootView;
    private static WindowManager.LayoutParams sRootViewLp;
    private static WindowManager sWindowManager;
    private static int sScreenSizeId = 0;
    private static final ArrayList<Object> ROOT_VIEW_OBJ = new ArrayList<>();

    public static TheApp getInstance() {
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

    @Override // android.app.Application
    public void onCreate() {
        sHandler = new Handler();
        CrashHandler.getInstance(getApplicationContext());
        writeCanOgg();
        cfg();
        initStatic();
        setupBase();
        initWindow();
        connectService();
        DataPack.init(this);
    }

    private void cfg() {
        CfgCustom.cfgCustom();
    }

    private void initStatic() {
        sApp = this;
        ObjApp.init(this);
        sActivityManager = (ActivityManager) getSystemService("activity");
        sWindowManager = (WindowManager) getSystemService("window");
        sResources = getResources();
        sAssetManager = sResources.getAssets();
        try {
            sScreenSizeId = getResources().getIntArray(R.array.screen_size)[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        sRootView = new View(this);
    }

    private void setupBase() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.height = -1;
        lp.width = -1;
        lp.format = 1;
        lp.type = 2006;
        lp.flags = 56;
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

    public static int getConfiguration() {
        return sApp.getResources().getConfiguration().orientation;
    }

    public static boolean isPortrait() {
        return getConfiguration() == 1;
    }

    private void initWindow() {
        Configuration config = getResources().getConfiguration();
        int smallestScreenWidth = config.smallestScreenWidthDp;
        Log.v("zed", " TheApp.getScreenWidth() == " + getScreenWidth() + "  TheApp.getScreenHeight() = " + getScreenHeight() + "  smallestScreenWidth = " + smallestScreenWidth);
        AirHelper.getInstance().initWindow(this);
        DoorHelper.getInstance().initWindow(this);
        ParkingHelper.getInstance().initWindow(this);
        Air_BenzHelper.getInstance().initWindow(this);
        Show_BenzHelper.getInstance().initWindow(this);
        CarVolHelper.getInstance().initWindow(this);
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
        intent.addFlags(131072);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.addFlags(16777216);
        intent.addFlags(268435456);
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
