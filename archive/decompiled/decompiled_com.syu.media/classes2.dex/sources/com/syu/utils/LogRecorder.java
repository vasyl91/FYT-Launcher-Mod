package com.syu.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LogRecorder extends BroadcastReceiver {
    public static LogRecorder h;
    public long e;
    public final int g;
    public final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    public final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd");
    public String c = "";
    public String d = "";
    public RecordThread f = null;

    public class RecordThread extends Thread {
        public Process a;
        public BufferedReader b = null;
        public boolean c = true;
        public final String d;
        public FileOutputStream e;

        public RecordThread() {
            this.d = null;
            this.e = null;
            try {
                this.e = new FileOutputStream(new File(LogRecorder.this.d, LogRecorder.this.a.format(new Date()) + ".log"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.d = "logcat  *:I | grep " + LogRecorder.this.g;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String line;
            while (this.c) {
                try {
                    try {
                        this.a = Runtime.getRuntime().exec(this.d);
                        LogRecorder.this.e = SystemClock.elapsedRealtime();
                        this.b = new BufferedReader(new InputStreamReader(this.a.getInputStream()), 1024);
                        while (this.c && (line = this.b.readLine()) != null) {
                            if (this.e == null) {
                                this.e = new FileOutputStream(new File(LogRecorder.this.d, LogRecorder.this.a.format(new Date()) + ".log"));
                            }
                            if (!this.c) {
                                break;
                            }
                            int length = line.length();
                            if (length != 0 && this.e != null && line.contains(LogRecorder.this.g + "")) {
                                this.e.write((line + "\n").getBytes());
                                if (SystemClock.elapsedRealtime() - LogRecorder.this.e >= 5000) {
                                    this.e.flush();
                                    LogRecorder.this.e = SystemClock.elapsedRealtime();
                                }
                                if (length >= 524288) {
                                    this.e.flush();
                                    this.e.close();
                                    this.e = null;
                                }
                            }
                        }
                        Process process = this.a;
                        if (process != null) {
                            process.destroy();
                            this.a = null;
                        }
                        BufferedReader bufferedReader = this.b;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                this.b = null;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            this.b = null;
                        }
                        fileOutputStream = this.e;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            this.e = null;
                        }
                    } catch (Throwable th) {
                        Process process2 = this.a;
                        if (process2 != null) {
                            process2.destroy();
                            this.a = null;
                        }
                        BufferedReader bufferedReader2 = this.b;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                this.b = null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            this.b = null;
                        }
                        FileOutputStream fileOutputStream2 = this.e;
                        if (fileOutputStream2 == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        this.e = null;
                        throw th;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    Process process3 = this.a;
                    if (process3 != null) {
                        process3.destroy();
                        this.a = null;
                    }
                    BufferedReader bufferedReader3 = this.b;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                            this.b = null;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        this.b = null;
                    }
                    fileOutputStream = this.e;
                    if (fileOutputStream != null) {
                    }
                }
            }
        }

        public void stopLogs() {
            this.c = false;
        }
    }

    public LogRecorder(Context context) {
        init(context);
        this.g = Process.myPid();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this, intentFilter2);
    }

    public static LogRecorder getInstance(Context context) {
        if (h == null) {
            h = new LogRecorder(context);
        }
        return h;
    }

    public boolean expired(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -5);
        try {
            return this.b.parse(str).before(calendar.getTime());
        } catch (ParseException unused) {
            return false;
        }
    }

    public void init(Context context) {
        StringBuilder sbAppend;
        SimpleDateFormat simpleDateFormat;
        Date date;
        String strReplace = context.getPackageName().replace(".", "_");
        if (Environment.getExternalStorageState().equals("mounted")) {
            StringBuilder sbAppend2 = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str = File.separator;
            this.c = sbAppend2.append(str).append("autoLog").append(str).append(strReplace).toString();
            sbAppend = new StringBuilder().append(this.c).append(str);
            simpleDateFormat = this.b;
            date = new Date();
        } else {
            StringBuilder sbAppend3 = new StringBuilder().append(context.getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            this.c = sbAppend3.append(str2).append("autoLog").append(str2).append(strReplace).toString();
            sbAppend = new StringBuilder().append(this.c).append(str2);
            simpleDateFormat = this.b;
            date = new Date();
        }
        this.d = sbAppend.append(simpleDateFormat.format(date)).toString();
        File file = new File(this.d);
        if (!file.exists()) {
            file.mkdirs();
            return;
        }
        for (File file2 : new File(this.c).listFiles()) {
            if (file2.isDirectory() && expired(file2.getName())) {
                file2.delete();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent == null ? "" : intent.getAction();
        Log.e("LogRecord", "  onReceive :  " + intent.toString());
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.TIME_TICK".equals(action) || !"android.intent.action.DATE_CHANGED".equals(action)) {
            return;
        }
        this.d = this.b.format(new Date());
    }

    public void start() {
        if (this.f == null) {
            this.f = new RecordThread();
        }
        this.f.start();
    }

    public void stop() {
        RecordThread recordThread = this.f;
        if (recordThread != null) {
            recordThread.stopLogs();
            this.f = null;
        }
    }
}
