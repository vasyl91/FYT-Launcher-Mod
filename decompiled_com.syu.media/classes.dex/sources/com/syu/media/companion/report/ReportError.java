package com.syu.media.companion.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import chip.FinalChip;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ReportError implements Thread.UncaughtExceptionHandler {
    static ReportError mInstance;
    final String CARSH_DIR_PATH = "/sdcard/crash";
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    HashMap<String, String> infos;
    Context mContext;
    Thread.UncaughtExceptionHandler mDefaultHandler;
    String pkgName;

    public static ReportError getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ReportError(context);
        }
        return mInstance;
    }

    public ReportError(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.pkgName = applicationContext.getPackageName().replace(".", "_");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!handleException(th)) {
            if (this.mDefaultHandler == null) {
                this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            }
            this.mDefaultHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    private boolean handleException(Throwable th) {
        th.printStackTrace();
        if (th == null) {
            return false;
        }
        collectInfo();
        saveCarshException(th);
        return true;
    }

    void collectInfo() {
        if (this.infos == null) {
            this.infos = new HashMap<>();
        }
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String str2 = packageInfo.versionCode + FinalChip.BSP_PLATFORM_Null;
                this.infos.put("versionName", str);
                this.infos.put("versionCode", str2);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    void saveCarshException(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            String str = "crash-" + this.dateFormat.format(new Date()) + "-" + this.pkgName + ".txt";
            File file = new File("/sdcard/crash");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/crash/" + str);
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
