package com.syu.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import chip.FinalChip;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static CrashHandler f;
    public final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    public HashMap b;
    public final String c;
    public final Context d;
    public Thread.UncaughtExceptionHandler e;

    public CrashHandler(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        this.c = applicationContext.getPackageName().replace(".", "_");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstance(Context context) {
        if (f == null) {
            f = new CrashHandler(context);
        }
        return f;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        if (th == null) {
            z = false;
        } else {
            if (this.b == null) {
                this.b = new HashMap();
            }
            try {
                PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 1);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "null";
                    }
                    String str2 = packageInfo.versionCode + FinalChip.BSP_PLATFORM_Null;
                    this.b.put("versionName", str);
                    this.b.put("versionCode", str2);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry entry : this.b.entrySet()) {
                stringBuffer.append(((String) entry.getKey()) + "=" + ((String) entry.getValue()) + "\n");
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
                String str3 = "crash-" + this.a.format(new Date()) + "-" + this.c + ".txt";
                File file = new File("/sdcard/crash");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/crash/" + str3);
                fileOutputStream.write(stringBuffer.toString().getBytes());
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
            z = true;
        }
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(1);
        } else {
            if (this.e == null) {
                this.e = Thread.getDefaultUncaughtExceptionHandler();
            }
            this.e.uncaughtException(thread, th);
        }
    }
}
