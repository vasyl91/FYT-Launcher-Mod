package com.android.launcher66;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Writes a report of an uncaught exception to /sdcard/crash and ends the process; the system then
 * restarts the launcher without showing a crash dialog.
 *
 * The crash is also logged at error level with "FATAL EXCEPTION": the process ends here before
 * the platform's own handler could log it, so without this line a launcher crash only showed up
 * in logcat as System.err output.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";

    static CrashHandler mInstance;
    final String CARSH_DIR_PATH = "/sdcard/crash";
    /** HH (24 h): with the old hh, a crash at 13:05 overwrote the report of one at 01:05. */
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    HashMap<String, String> infos;
    Context mContext;
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
        // The old fallback looked up "the default handler" in uncaughtException(), where it
        // already was this one, and called itself without end. The process now always ends here.
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * Synchronized: a second thread crashing at the same time waits for the first report. The
     * process ends in any case, even if the report fails (an OutOfMemoryError while writing it,
     * say): an exception escaping from here would leave the process running with its crashed
     * thread dead, and for the main thread that is a frozen launcher instead of a restarted one.
     */
    @Override
    public synchronized void uncaughtException(Thread thread, Throwable ex) {
        try {
            Log.e(TAG, "FATAL EXCEPTION: " + thread.getName() + " (process " + Process.myPid() + ")", ex);
            if (ex != null) {
                collectInfo();
                saveCarshException(ex);
            }
        } catch (Throwable reportFailure) {
            Log.e(TAG, "Crash report failed", reportFailure);
        } finally {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    void collectInfo() {
        if (this.infos == null) {
            this.infos = new HashMap<>();
        }
        try {
            PackageManager pm = this.mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(this.mContext.getPackageName(), 0);
            if (pi != null) {
                this.infos.put("versionName", pi.versionName == null ? "null" : pi.versionName);
                this.infos.put("versionCode", String.valueOf(pi.versionCode));
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Log.w(TAG, "Cannot read the version for the crash report: " + e);
        }
    }

    void saveCarshException(Throwable ex) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            sb.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
        }
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter); // includes the causes
        printWriter.close();
        sb.append(writer);
        String fileName = "crash-" + this.dateFormat.format(new Date()) + "-" + this.pkgName + ".txt";
        File dir = new File(CARSH_DIR_PATH);
        if (!dir.exists() && !dir.mkdirs()) {
            Log.w(TAG, "Cannot create " + dir + ", crash report not saved");
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(new File(dir, fileName))) {
            fos.write(sb.toString().getBytes());
        } catch (Exception e) {
            Log.w(TAG, "Cannot save the crash report " + fileName + ": " + e);
        }
    }
}
