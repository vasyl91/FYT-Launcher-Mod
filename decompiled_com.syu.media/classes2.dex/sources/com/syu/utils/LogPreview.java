package com.syu.utils;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LogPreview {
    public static LogPreview k;
    public boolean a;
    public String b;
    public final WindowManager c;
    public WindowManager.LayoutParams d;
    public TextView e;
    public FrameLayout f;
    public final Context g;
    public final Handler h;
    public final StringBuffer i = new StringBuffer();
    public final HandlerThread j;

    public LogPreview(Context context, String str) {
        HandlerThread handlerThread = new HandlerThread("check work");
        this.j = handlerThread;
        Log.e("Logs", "LogPreview === LogPreview swith = " + str);
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.c = (WindowManager) applicationContext.getSystemService("window");
        init();
        this.h = new Handler(Looper.getMainLooper());
        this.b = str;
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() { // from class: com.syu.utils.LogPreview.1
            @Override // java.lang.Runnable
            public void run() {
                LogPreview.this.checkDebug();
                Log.e("Logs", "mDebug === " + LogPreview.this.a);
                LogPreview.this.h.post(new Runnable() { // from class: com.syu.utils.LogPreview.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogPreview logPreview = LogPreview.this;
                        boolean z = logPreview.a;
                        ViewParent parent = logPreview.f.getParent();
                        if (z) {
                            if (parent == null) {
                                LogPreview logPreview2 = LogPreview.this;
                                logPreview2.c.addView(logPreview2.f, logPreview2.d);
                                return;
                            }
                            return;
                        }
                        if (parent != null) {
                            LogPreview logPreview3 = LogPreview.this;
                            logPreview3.c.removeView(logPreview3.f);
                        }
                    }
                });
                handler.removeCallbacks(this);
                handler.postDelayed(this, 25000L);
            }
        });
    }

    public static LogPreview getInstance(Context context, String str) {
        if (k == null) {
            k = new LogPreview(context, str);
        }
        return k;
    }

    public static void show(String str) {
        LogPreview logPreview = k;
        if (logPreview == null) {
            return;
        }
        logPreview.showLogLine(str);
    }

    public void checkDebug() {
        String str = this.b;
        if (str == null || str.isEmpty()) {
            return;
        }
        this.a = new File(this.b).exists();
    }

    public void destroy() {
        HandlerThread handlerThread = this.j;
        if (handlerThread != null) {
            try {
                handlerThread.getLooper().quit();
                this.j.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void init() {
        this.d = new WindowManager.LayoutParams(-1, -1, 0, 0, 2038, 56, 1);
        this.f = new FrameLayout(this.g);
        TextView textView = new TextView(this.g);
        this.e = textView;
        textView.setGravity(83);
        this.e.setTextColor(-16711936);
        this.f.addView(this.e, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setDebugSwith(String str) {
        this.b = str;
    }

    public void showLogLine(String str) {
        if (this.a) {
            if (this.i.length() >= 20480) {
                this.i.replace(0, 4096, "");
            }
            this.i.append(str + "\n");
            this.h.post(new Runnable() { // from class: com.syu.utils.LogPreview.2
                @Override // java.lang.Runnable
                public void run() {
                    LogPreview logPreview = LogPreview.this;
                    logPreview.e.setText(logPreview.i.toString());
                }
            });
        }
    }
}
