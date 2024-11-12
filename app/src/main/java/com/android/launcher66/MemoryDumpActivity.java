package com.android.launcher66;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.android.launcher66.MemoryTracker;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class MemoryDumpActivity extends Activity {
    private static Exception e;
    private static Throwable th;
    private static final String TAG = "MemoryDumpActivity";

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static String zipUp(ArrayList<String> paths) throws Throwable {
        ZipOutputStream zos = null;
        byte[] buf = new byte[262144];
        String zipfilePath = String.format("%s/hprof-%d.zip", Environment.getExternalStorageDirectory(), Long.valueOf(System.currentTimeMillis()));
        ZipOutputStream zos2 = null;
        try {
            OutputStream os = new FileOutputStream(zipfilePath);
            zos = new ZipOutputStream(new BufferedOutputStream(os));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator<String> it = paths.iterator();
            while (it.hasNext()) {
                String filename = it.next();
                InputStream is = null;
                try {
                    InputStream is2 = new BufferedInputStream(new FileInputStream(filename));
                    try {
                        ZipEntry entry = new ZipEntry(filename);
                        zos.putNextEntry(entry);
                        while (true) {
                            int len = is2.read(buf, 0, 262144);
                            if (len <= 0) {
                                break;
                            }
                            zos.write(buf, 0, len);
                        }
                        zos.closeEntry();
                        is2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        is = is2;
                        is.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e2) {
                }
            }
            zos2 = zos;
        } catch (Throwable th4) {
            th = th4;
            zos2 = zos;
            if (zos2 != null) {
                try {
                    zos2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return zipfilePath;
    }

    public static void dumpHprofAndShare(Context context, MemoryTracker tracker) {
        String appVersion;
        StringBuilder body = new StringBuilder();
        ArrayList<String> paths = new ArrayList<>();
        int myPid = Process.myPid();
        int[] pids_orig = tracker.getTrackedProcesses();
        int[] pids_copy = Arrays.copyOf(pids_orig, pids_orig.length);
        for (int pid : pids_copy) {
            MemoryTracker.ProcessMemInfo info = tracker.getMemInfo(pid);
            if (info != null) {
                body.append("pid ").append(pid).append(":").append(" up=").append(info.getUptime()).append(" pss=").append(info.currentPss).append(" uss=").append(info.currentUss).append("\n");
            }
            if (pid == myPid) {
                String path = String.format("%s/launcher-memory-%d.ahprof", Environment.getExternalStorageDirectory(), Integer.valueOf(pid));
                Log.v(TAG, "Dumping memory info for process " + pid + " to " + path);
                try {
                    Debug.dumpHprofData(path);
                } catch (IOException e) {
                    Log.e(TAG, "error dumping memory:", e);
                }
                paths.add(path);
            }
        }
        String zipfile = null;
        try {
            zipfile = zipUp(paths);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
        if (zipfile != null) {
            Intent shareIntent = new Intent("android.intent.action.SEND");
            shareIntent.setType("application/zip");
            PackageManager pm = context.getPackageManager();
            shareIntent.putExtra("android.intent.extra.SUBJECT", String.format("Launcher memory dump (%d)", Integer.valueOf(myPid)));
            try {
                appVersion = pm.getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                appVersion = "?";
            }
            body.append("\nApp version: ").append(appVersion).append("\nBuild: ").append(Build.DISPLAY).append("\n");
            shareIntent.putExtra("android.intent.extra.TEXT", body.toString());
            File pathFile = new File(zipfile);
            Uri pathUri = Uri.fromFile(pathFile);
            shareIntent.putExtra("android.intent.extra.STREAM", pathUri);
            context.startActivity(shareIntent);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        startDump(this, new Runnable() { // from class: com.android.launcher66.MemoryDumpActivity.1
            @Override // java.lang.Runnable
            public void run() {
                MemoryDumpActivity.this.finish();
            }
        });
    }

    public static void startDump(Context context) {
        startDump(context, null);
    }

    public static void startDump(final Context context, final Runnable andThen) {
        ServiceConnection connection = new ServiceConnection() { // from class: com.android.launcher66.MemoryDumpActivity.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName className, IBinder service) {
                Log.v(MemoryDumpActivity.TAG, "service connected, dumping...");
                MemoryDumpActivity.dumpHprofAndShare(context, ((MemoryTracker.MemoryTrackerInterface) service).getService());
                context.unbindService(this);
                if (andThen != null) {
                    andThen.run();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName className) {
            }
        };
        Log.v(TAG, "attempting to bind to memory tracker");
        context.bindService(new Intent(context, (Class<?>) MemoryTracker.class), connection, 1);
    }
}
