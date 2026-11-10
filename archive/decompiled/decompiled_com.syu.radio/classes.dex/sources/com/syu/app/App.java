package com.syu.app;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.lsec.core.frame.app.MyActivity;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.Conn;
import com.lsec.core.ipc.ConnSys;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.ipc.module.sys.Locate;
import com.lsec.core.ipc.module.sys.Sys;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IConnectedMain;
import com.lsec.core.util.IUiNotify;
import com.lsec.core.util.Markup;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.App_Radio;
import com.syu.radio.db.Radio_Info;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class App extends MyApplication {
    public static String mStrCustomer = FinalChip.BSP_PLATFORM_Null;
    public Conn mConn = null;
    public ConnSys mConnSys = null;
    public Runnable mRunnable_InitIpc = new Runnable() { // from class: com.syu.app.App.1
        @Override // java.lang.Runnable
        public void run() {
            App.this.initIpc();
        }
    };
    private IUiNotify notify_Main = new IUiNotify() { // from class: com.syu.app.App.2
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (IUiNotify uiNotify : App.mListUiNotify_Main) {
                uiNotify.onNotify(updateCode, ints, flts, strs);
            }
        }
    };
    private IUiNotify notify_Radio = new IUiNotify() { // from class: com.syu.app.App.3
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (IUiNotify uiNotify : App.mListUiNotify_Radio) {
                uiNotify.onNotify(updateCode, ints, flts, strs);
            }
        }
    };
    private IUiNotify notify_Sys = new IUiNotify() { // from class: com.syu.app.App.4
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (IUiNotify uiNotify : App.mListUiNotify_Sys) {
                uiNotify.onNotify(updateCode, ints, flts, strs);
            }
        }
    };
    private IUiNotify notify_Location = new IUiNotify() { // from class: com.syu.app.App.5
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (IUiNotify uiNotify : App.mListUiNotify_Location) {
                uiNotify.onNotify(updateCode, ints, flts, strs);
            }
        }
    };

    public static App getApp() {
        return (App) myApp;
    }

    @Override // com.lsec.core.frame.app.MyApplication, android.app.Application
    public void onCreate() throws Throwable {
        Log.d("theme", "  00  onCreate   ");
        ReadConf();
        setSelectTheme();
        Log.d("theme", "  01  onCreate mStrFolderAsset = " + MyApplication.mStrFolderAsset);
        super.onCreate();
        App_Radio.getInstance().onCreate(this);
        this.mRunnable_InitIpc.run();
    }

    public void setSelectTheme() {
        Log.d("theme", "  00  setThemeColor mStrCustomer = " + mStrCustomer);
        if (mStrCustomer.equals("TZY_NEW")) {
            String ss = SystemProperties.get("persist.fyt.themefortzy", "gradientpurple");
            MyApplication.mStrFolderAsset = "UI1";
            if (ss.equalsIgnoreCase("gradientpurple")) {
                MyApplication.mStrFolderAsset = "UI1";
                return;
            }
            if (ss.equalsIgnoreCase("spro")) {
                MyApplication.mStrFolderAsset = "UI1";
                return;
            }
            if (ss.equalsIgnoreCase("gradientblue")) {
                MyApplication.mStrFolderAsset = "UI4";
                return;
            }
            if (ss.equalsIgnoreCase("blackgold")) {
                MyApplication.mStrFolderAsset = "UI2";
                return;
            }
            if (ss.equalsIgnoreCase("black")) {
                MyApplication.mStrFolderAsset = "UI3";
                return;
            }
            if (ss.equalsIgnoreCase("dn_day")) {
                MyApplication.mStrFolderAsset = "UI5";
                return;
            } else if (ss.equalsIgnoreCase("dn_night")) {
                MyApplication.mStrFolderAsset = "UI6";
                return;
            } else {
                if (ss.equalsIgnoreCase("dn_auto")) {
                    MyApplication.mStrFolderAsset = "UI7";
                    return;
                }
                return;
            }
        }
        if (mStrCustomer.equals("YL_AUTO")) {
            DisplayMetrics metric = new DisplayMetrics();
            WindowManager mWindowManager = (WindowManager) getSystemService("window");
            mWindowManager.getDefaultDisplay().getMetrics(metric);
            int width = metric.widthPixels;
            int height = metric.heightPixels;
            double mScreenWchuH = (1.0d * ((double) width)) / ((double) height);
            Log.d("theme", " 00 App  *** 00 InitMapPage  screenWidth = " + width + " screenHeight = " + height + "  ** mScreenWchuH = " + mScreenWchuH);
            if (mScreenWchuH < 1.9d) {
                MyApplication.mStrFolderAsset = "UI1";
                return;
            } else {
                MyApplication.mStrFolderAsset = "UI2";
                return;
            }
        }
        if (mStrCustomer.equals("SYU_BBA")) {
            String ss2 = SystemProperties.get("persist.lsec.bbatype", "bba_ad");
            MyApplication.mStrFolderAsset = "UI3";
            if (ss2.equalsIgnoreCase("bba_lkss")) {
                MyApplication.mStrFolderAsset = "UI1";
                return;
            }
            if (ss2.equalsIgnoreCase("bba_lh")) {
                MyApplication.mStrFolderAsset = "UI2";
                return;
            }
            if (ss2.equalsIgnoreCase("bba_bm")) {
                MyApplication.mStrFolderAsset = "UI3";
                return;
            }
            if (ss2.equalsIgnoreCase("bba_bc")) {
                MyApplication.mStrFolderAsset = "UI4";
            } else if (ss2.equalsIgnoreCase("bba_ad")) {
                MyApplication.mStrFolderAsset = "UI5";
            } else if (ss2.equalsIgnoreCase("bba_id8")) {
                MyApplication.mStrFolderAsset = "UI6";
            }
        }
    }

    public void initIpc() {
        Main.mUiNotifyEvent.uiNotify = this.notify_Main;
        RadioM.mUiNotifyEvent.uiNotify = this.notify_Radio;
        Sys.mUiNotifyEvent.uiNotify = this.notify_Sys;
        Locate.mUiNotifyEvent.uiNotify = this.notify_Location;
        this.mConn = new Conn(getApp(), getApp());
        this.mConn.addObserver(Main.getInstance(), RegCode.mRegister_Main);
        this.mConn.addObserver(RadioM.getInstance(), RegCode.mRegister_Radio);
        this.mConnSys = new ConnSys(getApp(), getApp());
        this.mConnSys.addObserver(Sys.getInstance(), RegCode.mRegister_Sys);
        this.mConnSys.addObserver(Locate.getInstance(), RegCode.mRegister_Locate);
    }

    public void ReadConf() throws Throwable {
        String str;
        try {
            int id = getResources().getIdentifier("conf_platform", "raw", getPackageName());
            if (id >= 0) {
                String strXml = FuncUtils.readStrFromStream(getResources().openRawResource(id));
                if (!TextUtils.isEmpty(strXml)) {
                    Markup xml = new Markup();
                    xml.ReadXML(strXml);
                    if (xml.IntoItem()) {
                        do {
                            String strTemp = xml.GetAttr(Radio_Info.NAME);
                            if (strTemp != null) {
                                if (strTemp.equals("platform")) {
                                    String str2 = xml.GetAttr("value");
                                    if (str2 != null) {
                                        Main.initPlatForm(str2);
                                    }
                                } else if (strTemp.equals("old_service")) {
                                    String str3 = xml.GetAttr("value");
                                    if (str3 != null && str3.equals("1")) {
                                        mIsOldService = true;
                                    }
                                } else if (strTemp.equals("customer") && (str = xml.GetAttr("value")) != null) {
                                    mStrCustomer = str;
                                }
                            }
                        } while (xml.NextItem());
                        xml.ExitItem();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.lsec.core.frame.app.MyApplication, com.lsec.core.util.InterfaceApp
    public void requestAppIdRight() {
        MyActivity activity = getApp().getTopActivity();
        if (activity != null) {
            activity.requestAppIdRight();
        }
    }

    @Override // com.lsec.core.frame.app.MyApplication, com.lsec.core.util.InterfaceApp
    public void onConnected_Main() {
        for (IConnectedMain connectedMain : mListConnectedMain) {
            connectedMain.onConnected_Main();
        }
    }
}
