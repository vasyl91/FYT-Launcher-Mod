package com.android.launcher66;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemProperties;
import android.view.WindowManager;
import android.widget.TextView;
import com.fyt.skin.SkinManager;
import com.fyt.skin.util.FileUtil;
import com.syu.car.CarStates;
import com.syu.util.CustomIcons;
import com.syu.util.FytPackage;
import com.syu.util.Utils;
import com.syu.utils.W3Utils;
import java.io.File;
import org.litepal.LitePalApplication;

public class LauncherApplication extends LitePalApplication {
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

    public String getApkPath() {
        return this.apkPath;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
        initProperties();
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
        LauncherAppState.setApplicationContext(this);
        LauncherAppState.getInstance();
        CarStates.getCar(this);
        this.apkPath = String.valueOf(sApp.getFilesDir().getAbsolutePath()) + File.separator + "firenze.apk";
        File file = new File(this.apkPath);
        if (!file.exists()) {
            FileUtil.copyFileFromAssets(this, "firenze.apk", this.apkPath);
        }
        mAppWallPaper = Utils.getSp().getBoolean("mAppWallPaper", true);
        mWallPaperUpdate = Utils.getSp().getBoolean("mWallPaperUpdate", true);
        initGaoDeCoverView();
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
}
