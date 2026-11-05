package com.lsec.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class CrashLog implements Thread.UncaughtExceptionHandler {
    public static final String CARSH_DIR_PATH = "/sdcard/crash";
    static CrashLog mInstance;
    Context mContext;
    Thread.UncaughtExceptionHandler mDefaultHandler;
    String mVersionCode;
    String pkgName;

    public static CrashLog getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CrashLog(context);
        }
        return mInstance;
    }

    public CrashLog(Context context) {
        this.mContext = context.getApplicationContext();
        this.pkgName = this.mContext.getPackageName().replace(".", "_");
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
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

    private boolean handleException(Throwable ex) throws Throwable {
        if (ex == null) {
            return false;
        }
        collectInfo();
        saveCrashException(ex);
        return true;
    }

    void collectInfo() {
        try {
            PackageManager pm = this.mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(this.mContext.getPackageName(), 1);
            if (pi != null) {
                this.mVersionCode = new StringBuilder(String.valueOf(pi.versionCode)).toString();
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    void saveCrashException(Throwable ex) throws Throwable {
        StringBuffer sb = new StringBuffer();
        Writer writer = new StringWriter();
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(writer);
                try {
                    ex.printStackTrace(printWriter2);
                    for (Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter2);
                    }
                    if (printWriter2 != null) {
                        try {
                            printWriter2.close();
                            printWriter = printWriter2;
                        } catch (Exception e) {
                            e.printStackTrace();
                            printWriter = printWriter2;
                        }
                    } else {
                        printWriter = printWriter2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        String result = writer.toString();
        sb.append(result);
        File dir = new File(CARSH_DIR_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = "crash-" + this.pkgName + "-" + this.mVersionCode + ".txt";
        File file = new File("/sdcard/crash/" + fileName);
        if (file.exists()) {
            return;
        }
        FileOutputStream fos = null;
        try {
            try {
                FileOutputStream fos2 = new FileOutputStream("/sdcard/crash/" + fileName);
                try {
                    fos2.write(sb.toString().getBytes());
                    if (fos2 != null) {
                        try {
                            fos2.close();
                            fos = fos2;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            fos = fos2;
                        }
                    } else {
                        fos = fos2;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fos = fos2;
                    e.printStackTrace();
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }
}
