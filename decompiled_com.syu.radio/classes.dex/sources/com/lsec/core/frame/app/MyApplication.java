package com.lsec.core.frame.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemProperties;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.WindowManager;
import com.lsec.core.frame.camera.MyCamera;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JListViewEx;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.CrashLog;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IConnectedMain;
import com.lsec.core.util.IUiNotify;
import com.lsec.core.util.InterfaceApp;
import com.lsec.core.util.LogScreen;
import com.lsec.core.util.Markup;
import com.lsec.core.util.MyFolder;
import com.lsec.core.util.ThreadMap;
import com.lsec.core.util.data.FinalChip;
import com.lsec.core.util.share.ShareHandler;
import com.syu.radio.db.Radio_Info;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyApplication extends Application implements InterfaceApp {
    public static ActivityManager mActivityManager;
    public static AssetManager mAssetManager;
    public static AudioManager mAudioManager;
    public static ContentResolver mContentResolver;
    public static String mStrApkID;
    public static String mStrZipFile;
    public static String mStrZipTag;
    public static WindowManager mWindowManager;
    public static MyApplication myApp;
    public static int sPage_WillBe = 0;
    public static int sPage_Current = 0;
    public static String mStrFolderAsset = null;
    public static int mIdCustomer = 2;
    public static int mIdPlatForm = 4;
    public static int mIdChip = 3;
    public static ArrayList<MyActivity> mActs = new ArrayList<>();
    public static boolean mIsOldService = false;
    public static boolean bIS240 = false;
    public static ArrayList<IUiNotify> mListUiNotify_Bt_786 = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Main_786 = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Bt = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Main = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Sound = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Sys = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Radio = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Location = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Amp = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Dvr = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Dvd = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Ipod = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Tv = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Canbus = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Canbox = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Gsensor = new ArrayList<>();
    public static ArrayList<IUiNotify> mListUiNotify_Steer = new ArrayList<>();
    public static ArrayList<IConnectedMain> mListConnectedMain = new ArrayList<>();

    public MyApplication() {
        myApp = this;
        LogScreen.mContext = myApp;
    }

    public void setAssetFolder(String strFolder) {
        mStrFolderAsset = strFolder;
    }

    public void ReadApkId() throws Throwable {
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
                            if (strTemp != null && strTemp.equals("apkid") && (str = xml.GetAttr("value")) != null) {
                                mStrApkID = str;
                                break;
                            }
                        } while (xml.NextItem());
                        xml.ExitItem();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Application
    public void onCreate() throws Throwable {
        CrashLog.getInstance(this);
        ReadApkId();
        String pkgName = getPackageName();
        int index = pkgName.lastIndexOf(".");
        if (index >= 0) {
            mStrZipTag = pkgName.substring(index + 1);
        }
        String strResName = "res_" + mStrZipTag + ".ogg";
        boolean bFoundZip = false;
        if (!TextUtils.isEmpty(mStrFolderAsset)) {
            mStrZipFile = "/oem/app/" + mStrApkID + "/assets/core_ogg/" + mStrFolderAsset + "/" + strResName;
            bFoundZip = new File(mStrZipFile).exists();
        }
        Log.d("HJT", "bFoundZip:" + bFoundZip + "-mStrZipFile:" + mStrZipFile);
        if (!bFoundZip) {
            mStrZipFile = "/oem/app/" + mStrApkID + "/assets/core_ogg/" + strResName;
            bFoundZip = new File(mStrZipFile).exists();
        }
        Log.d("HJT", "bFoundZip:" + bFoundZip + "-mStrZipFile:" + mStrZipFile);
        if (!bFoundZip) {
            mStrZipFile = "/odm/app/" + mStrApkID + "/assets/core_ogg/" + mStrFolderAsset + "/" + strResName;
            bFoundZip = new File(mStrZipFile).exists();
        }
        Log.d("HJT", "bFoundZip:" + bFoundZip + "-mStrZipFile:" + mStrZipFile);
        if (!bFoundZip) {
            mStrZipFile = "/odm/app/" + mStrApkID + "/assets/core_ogg/" + strResName;
            bFoundZip = new File(mStrZipFile).exists();
        }
        Log.d("HJT", "bFoundZip:" + bFoundZip + "-mStrZipFile:" + mStrZipFile);
        mAssetManager = getAssets();
        mActivityManager = (ActivityManager) getSystemService("activity");
        mWindowManager = (WindowManager) getSystemService("window");
        mAudioManager = (AudioManager) getSystemService("audio");
        mContentResolver = getContentResolver();
        try {
            mIdChip = ShareHandler.getInt(mContentResolver, 13, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mIdPlatForm = ShareHandler.getInt(mContentResolver, 10, 4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            mIdCustomer = ShareHandler.getInt(mContentResolver, 9, 2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        FuncUtils.getDisplayMetrics(this);
        if (!mIsOldService) {
            Main.DATA[7] = 1;
            Main.sAppIdRequest = 20;
        }
        if (Main.mConf_PlatForm == 5) {
            MyCamera.QUALITY_CVBSP = getIntField("QUALITY_CVBSP", CamcorderProfile.class);
            MyCamera.QUALITY_CVBSN = getIntField("QUALITY_CVBSN", CamcorderProfile.class);
        }
        super.onCreate();
    }

    public <T> int getIntField(String strField, Class<T> c) {
        int iRet = 0;
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            try {
                if (field.getName().equals(strField)) {
                    iRet = Integer.valueOf(field.getInt(c)).intValue();
                    break;
                }
                continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return iRet;
    }

    public MyActivity getTopActivity() {
        for (MyActivity act : mActs) {
            if (act.bTop) {
                return act;
            }
        }
        return null;
    }

    @Override // com.lsec.core.util.InterfaceApp
    public boolean isAppTop() {
        MyActivity act = getTopActivity();
        return act != null;
    }

    public static void remove(JGridView gridView, int position) {
        if (gridView != null && gridView.getList() != null) {
            gridView.getList().remove(position);
            for (int i = gridView.getCount(); i < gridView.getMaxRowDisp(); i++) {
                SparseArray<String> map = new SparseArray<>();
                gridView.getList().add(map);
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void clear(JGridView gridView) {
        if (gridView != null && gridView.getList() != null) {
            gridView.getList().clear();
            for (int i = gridView.getCount(); i < gridView.getMaxRowDisp(); i++) {
                SparseArray<String> map = new SparseArray<>();
                gridView.getList().add(map);
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void add2GridView(JGridView gridView, SparseArray<String> map) {
        if (gridView != null) {
            boolean bAdd = false;
            int iCount = gridView.getCount();
            if (iCount > 0 && iCount <= gridView.getMaxRowDisp()) {
                int i = 0;
                for (SparseArray<String> e : gridView.getList()) {
                    if (e.size() == 0) {
                        gridView.getList().remove(i);
                        gridView.getList().add(i, map);
                        bAdd = true;
                        break;
                    }
                    i++;
                }
            }
            if (!bAdd) {
                gridView.getList().add(map);
            }
        }
    }

    public static void add(JGridView gridView, SparseArray<String> map) {
        if (gridView != null) {
            add2GridView(gridView, map);
            gridView.notifyDataSetChanged();
        }
    }

    public static void resetList(JGridView gridView, List<SparseArray<String>> list) {
        if (gridView != null) {
            gridView.getList().clear();
            if (list != null) {
                for (SparseArray<String> map : list) {
                    add2GridView(gridView, map);
                }
            }
            for (int i = gridView.getCount(); i < gridView.getMaxRowDisp(); i++) {
                SparseArray<String> map2 = new SparseArray<>();
                gridView.getList().add(map2);
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void removeAll(JGridView gridView, List<SparseArray<String>> list) {
        if (gridView != null) {
            gridView.getList().removeAll(list);
            for (int i = gridView.getCount(); i < gridView.getMaxRowDisp(); i++) {
                SparseArray<String> map = new SparseArray<>();
                gridView.getList().add(map);
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void addAll(JGridView gridView, List<SparseArray<String>> list) {
        if (gridView != null) {
            if (list != null) {
                for (SparseArray<String> map : list) {
                    add2GridView(gridView, map);
                }
            }
            for (int i = gridView.getCount(); i < gridView.getMaxRowDisp(); i++) {
                SparseArray<String> map2 = new SparseArray<>();
                gridView.getList().add(map2);
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void resetList(JListViewEx listViewEx, List<MyFolder> listGroup) {
        if (listViewEx != null) {
            listViewEx.getList().clear();
            if (listGroup != null) {
                listViewEx.getList().addAll(listGroup);
            }
            listViewEx.notifyDataSetChanged();
        }
    }

    public static void resetList_Folder(JGridView gridView, List<MyFolder> listGroup) {
        if (gridView != null) {
            gridView.getList().clear();
            gridView.getListFolder().clear();
            if (listGroup != null) {
                for (MyFolder folder : listGroup) {
                    gridView.getListFolder().add(folder);
                    gridView.getList().add(folder.map);
                }
            }
            gridView.notifyDataSetChanged();
        }
    }

    public static void DeepCopy_FolderList(List<MyFolder> listSrc, List<MyFolder> listDst) {
        if (listSrc != null && listDst != null) {
            listDst.clear();
            for (MyFolder folder : listSrc) {
                MyFolder folderNew = new MyFolder();
                folderNew.map = folder.map;
                folderNew.array.addAll(folder.array);
                listDst.add(folderNew);
            }
        }
    }

    public void goHome() {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startAct(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startAct(Class<?> cls) {
        try {
            Intent intent = new Intent(myApp, cls);
            intent.addFlags(268435456);
            intent.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startAct(String pkgName, String className) {
        try {
            Intent intent = new Intent();
            intent.setClassName(pkgName, className);
            intent.addFlags(268435456);
            intent.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startAct(String strAction) {
        try {
            Intent intent = new Intent();
            intent.setAction(strAction);
            intent.addFlags(268435456);
            intent.addFlags(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServiceSafely(Intent intent) {
        try {
            startService(intent);
        } catch (Exception e) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    startForegroundService(intent);
                }
            } catch (Exception e2) {
            }
        }
    }

    public void startServiceSafely_Mobile(Intent intent) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.lsec.core.util.InterfaceApp
    public void requestAppIdRight() {
    }

    @Override // com.lsec.core.util.InterfaceApp
    public void onConnected_Main() {
    }

    public int getOrientation() {
        return getResources().getConfiguration().orientation;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo[] networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getAllNetworkInfo()) == null || networkInfo.length <= 0) {
            return false;
        }
        for (NetworkInfo networkInfo2 : networkInfo) {
            if (networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public IPageNotify getPageNotify(MyUi uiApp, int idPage) {
        JPage page;
        if (uiApp == null || (page = uiApp.mPages.get(idPage)) == null) {
            return null;
        }
        IPageNotify pageNotify = page.getNotify();
        return pageNotify;
    }

    public static void startThread(String strApp, String strThread, Runnable runnable, boolean bRemoveOther, int priority) {
        ThreadMap.startThread(String.valueOf(strApp) + "_" + strThread, runnable, bRemoveOther, priority);
    }

    public static void startThread(String strApp, String strThread, Runnable runnable, boolean bRemoveOther, int priority, long delayMillis) {
        ThreadMap.startThread(String.valueOf(strApp) + "_" + strThread, runnable, bRemoveOther, priority, delayMillis);
    }

    public static void removeThread(String strApp, String strThread, Runnable runnable) {
        ThreadMap.removeThreadRunnable(String.valueOf(strApp) + "_" + strThread, runnable);
    }

    public String getPlat() {
        String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        if (TextUtils.isEmpty(plat)) {
            return SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        }
        return plat;
    }

    public String getDevice() {
        return SystemProperties.get("ro.product.device", FinalChip.BSP_PLATFORM_Null);
    }

    public int[] getStyleableArrayId(String styleableName) {
        try {
            Class<?> loadClass = getClassLoader().loadClass(String.valueOf(getPackageName()) + ".R");
            for (Class<?> resClass : loadClass.getClasses()) {
                if (resClass.getName().equals(String.valueOf(getPackageName()) + ".R$styleable")) {
                    Field[] fields = resClass.getFields();
                    for (int j = 0; j < fields.length; j++) {
                        if (fields[j].getName().equals(styleableName)) {
                            return (int[]) fields[j].get(null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void jumpAct(String strName) {
    }

    @Override // com.lsec.core.util.InterfaceApp
    public boolean isFixVideoId(int videoId) {
        return true;
    }
}
