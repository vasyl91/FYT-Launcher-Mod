package com.syu.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    static CrashHandler mInstance;
    final String CARSH_DIR_PATH = "/sdcard/crash";
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    HashMap<String, String> infos;
    Context mContext;
    Thread.UncaughtExceptionHandler mDefaultHandler;
    String pkgName;

    public static CrashHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CrashHandler(context);
        }
        return mInstance;
    }

    public CrashHandler(Context context) {
        this.mContext = context.getApplicationContext();
        this.pkgName = this.mContext.getPackageName().replace(".", "_");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex)) {
            if (this.mDefaultHandler == null) {
                this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            }
            this.mDefaultHandler.uncaughtException(thread, ex);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        collectInfo();
        saveCarshException(ex);
        return true;
    }

    void collectInfo() {
        if (this.infos == null) {
            this.infos = new HashMap<>();
        }
        try {
            PackageManager pm = this.mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(this.mContext.getPackageName(), 1);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = String.valueOf(pi.versionCode);
                this.infos.put("versionName", versionName);
                this.infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    void saveCarshException(Throwable ex) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + "=" + value + "\n");
        }
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        for (Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        try {
            String time = this.dateFormat.format(new Date());
            String fileName = "crash-" + time + "-" + this.pkgName + ".txt";
            File dir = new File("/sdcard/crash");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("/sdcard/crash/" + fileName);
            fos.write(sb.toString().getBytes());
            fos.close();
        } catch (Exception e) {
        }
    }
}
