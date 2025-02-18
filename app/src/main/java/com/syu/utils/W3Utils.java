package com.syu.utils;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.NonNull;

import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;
import com.syu.util.FytPackage;
import com.syu.utils.W3DialogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class W3Utils implements Callback.OnRefreshLisenter {
    public static final String CLD_MAP_PKG_FORMAT = "cld\\.navi\\.(c|k|p)\\d+\\.mainframe";
    static List<String> mFilterApps;
    Context mContext;
    Dialog mDialog = null;
    RemoteTools mTools;
    static W3Utils utils = null;
    static boolean mHasFilter = false;
    static int maxCount = 0;
    static boolean enable = false;

    static {
        mFilterApps = null;
        mFilterApps = new ArrayList();
        addFilterApp(FytPackage.carAction);
        addFilterApp("com.syu.radio");
        addFilterApp("cn.com.tiros.android.navidog");
        addFilterApp("cn.com.tiros.android.navidog4x");
        addFilterApp("com.autonavi.xmgd.navigator");
        addFilterApp("com.baidu.navi");
        addFilterApp("cld.navi.mobile.mainframe");
        addFilterApp("com.mapbar.android.mapbarmap");
        addFilterApp("com.mapbar.android.carnavi");
        addFilterApp("title.navi");
        addFilterApp("com.mxnavi.mxnavi");
        addFilterApp(FytPackage.GaodeACTION);
        addFilterApp(FytPackage.GMAPS);
        addFilterApp(FytPackage.WAZE);
        addFilterApp("cn.kuwo.player");
        addFilterApp("cn.kuwo.kwmusichd");
        addFilterApp(FytPackage.KWACTION);
        addFilterApp("com.kuwo.kwmusiccar");
        addFilterApp("com.kugou.android");
        addFilterApp("com.duomi.android");
        addFilterApp("cmccwm.mobilemusic");
        addFilterApp("fm.xiami.main");
        addFilterApp("com.tencent.qqmusic");
        addFilterApp("com.tencent.qqmusicpad");
        addFilterApp("com.tencent.karaoke");
        addFilterApp("com.ximalaya.ting.android");
        addFilterApp("com.ting.mp3.android");
        addFilterApp("com.qiyi.video");
        addFilterApp("com.tencent.qqlivehd");
        addFilterApp("com.youku.pad");
        addFilterApp(FytPackage.YKACTION);
        addFilterApp("com.tudou.xoom.android");
        addFilterApp("com.sds.android.ttpod");
        addFilterApp("tv.pps.mobile");
        addFilterApp("com.baidu.video");
        addFilterApp("com.letv.android.client");
        addFilterApp("com.sohu.sohuvideo");
    }

    public static void removeFilterApp(String pkg) {
        if (pkg != null && pkg.length() > 0 && mFilterApps != null) {
            mFilterApps.remove(pkg);
        }
    }

    public static void addFilterApp(String pkg) {
        if (pkg != null && pkg.length() > 0) {
            if (mFilterApps == null) {
                mFilterApps = new ArrayList();
            }
            if (!mFilterApps.contains(pkg)) {
                mFilterApps.add(pkg);
            }
        }
    }

    public static W3Utils initialize(Context context) {
        String value = "";
        try {
            value = (String) Tools.callMethod(null, Tools.getMethod("android.os.SystemProperties", "get", new Class[]{String.class, String.class}), "ro.client.foreign", "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
        enable = !"true".equals(value);
        if (utils == null) {
            utils = new W3Utils(context);
        }
        return utils;
    }

    public static W3Utils getUtils() {
        return utils;
    }

    W3Utils(@NonNull Context context) {
        this.mTools = null;
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        if (enable) {
            this.mTools = new RemoteTools(this.mContext, "com.syu.unicar.ToolkitService", "com.syu.unicar");
            this.mTools.enableModule(0, 2);
            this.mTools.addRefreshLisenter(0, this, 2);
            this.mTools.bind();
        }
    }

    void setDialog(Dialog mDialog) {
        this.mDialog = mDialog;
    }

    int getRunCount(String pkg) {
        SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
        return preferences.getInt(pkg, 0);
    }

    int saveRunCount(String pkg, int count) {
        if (count < 0) {
            return -1;
        }
        SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
        int old = preferences.getInt(pkg, 0);
        if (old == count) {
            return old;
        }
        preferences.edit().putInt(pkg, count).commit();
        return count;
    }

    void clean() {
        SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
        preferences.edit().clear().commit();
    }

    @Override
    public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (updateCode == 2 && ints != null && ints.length > 0) {
            boolean filter = ints[0] == 1;
            if (filter != mHasFilter) {
                mHasFilter = filter;
            }
            if (ints.length > 1) {
                maxCount = ints[1];
            }
            clean();
        }
    }

    public boolean startActivitySafely(Intent intent, int... flags) {
        if (this.mContext == null || intent == null) {
            return false;
        }
        if (flags != null && flags.length > 0) {
            for (int flag : flags) {
                intent.addFlags(flag);
            }
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        }
        try {
            this.mContext.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean startActivitySafelyForAction(String action, String pkg, int... flags) {
        if (action == null || action.length() <= 0) {
            return false;
        }
        Intent intent = new Intent(action);
        if (pkg != null && pkg.length() > 0) {
            intent.setPackage(pkg);
        }
        boolean success = startActivitySafely(intent, flags);
        return success;
    }

    public boolean startActivitySafelyForComponentName(String clazz, String pkg, int... flags) {
        boolean hasClazz = clazz != null && clazz.length() > 0;
        boolean hasPkg = pkg != null && pkg.length() > 0;
        if (!hasClazz || !hasPkg) {
            return false;
        }
        Intent intent = new Intent();
        ComponentName c = new ComponentName(pkg, clazz);
        intent.setComponent(c);
        boolean success = startActivitySafely(intent, flags);
        return success;
    }

    void check(Intent intent) {
        ComponentName c;
        if (intent != null) {
            String pkg = intent.getPackage();
            if ((pkg == null || pkg.length() <= 0) && (c = intent.getComponent()) != null) {
                pkg = c.getPackageName();
            }
            if (pkg != null && pkg.length() > 0) {
                int count = getRunCount(pkg);
                if (mHasFilter) {
                    if ((mFilterApps.contains(pkg) || matcher(pkg)) && count < maxCount && this.mDialog != null) {
                        this.mDialog.show();
                        int countNew = count + 1;
                        saveRunCount(pkg, countNew);
                    }
                }
            }
        }
    }

    public void check(Intent intent, int title, int msg, int positive, int negative) {
        if (enable) {
            if (this.mDialog == null) {
                this.mDialog = new W3DialogUtils.CustomDialog(this.mContext);
            }
            if (this.mDialog != null && (this.mDialog instanceof W3DialogUtils.CustomDialog)) {
                W3DialogUtils.CustomDialog dialog = (W3DialogUtils.CustomDialog) this.mDialog;
                dialog.setTitle(title);
                dialog.setMsg(msg);
                dialog.setButton(positive, negative);
            }
            if (this.mDialog != null && !this.mDialog.isShowing()) {
                check(intent);
            }
        }
    }

    public void check(Intent intent, String title, String msg, String positive, String negative) {
        if (enable) {
            if (this.mDialog == null) {
                this.mDialog = new W3DialogUtils.CustomDialog(this.mContext);
            }
            if (this.mDialog != null && (this.mDialog instanceof W3DialogUtils.CustomDialog)) {
                W3DialogUtils.CustomDialog dialog = (W3DialogUtils.CustomDialog) this.mDialog;
                dialog.setTitle(title);
                dialog.setMsg(msg);
                dialog.setButton(positive, negative);
            }
            if (this.mDialog != null && !this.mDialog.isShowing()) {
                check(intent);
            }
        }
    }

    static boolean matcher(String pkg) {
        Pattern pattern = Pattern.compile(CLD_MAP_PKG_FORMAT);
        Matcher matcher = pattern.matcher(pkg);
        return matcher.matches();
    }
}
