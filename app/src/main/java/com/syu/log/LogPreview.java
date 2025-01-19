package com.syu.log;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.File;

public class LogPreview {
    static LogPreview instance;
    String debugSwith;
    TextView logPreview;
    Context mContext;
    boolean mDebug;
    Handler mHandler;
    WindowManager.LayoutParams mParams;
    FrameLayout rootView;
    WindowManager wm;
    StringBuffer logs = new StringBuffer();
    HandlerThread checkWork = new HandlerThread("check work");

    public static LogPreview getInstance(Context mContext, String swith) {
        if (instance == null) {
            instance = new LogPreview(mContext, swith);
        }
        return instance;
    }

    LogPreview(Context mContext, String swith) {
        this.mContext = mContext.getApplicationContext();
        this.wm = (WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE);
        init();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.debugSwith = swith;
        this.checkWork.start();
        final Handler handler = new Handler(this.checkWork.getLooper());
        Runnable check = new Runnable() { 
            @Override
            public void run() {
                LogPreview.this.checkDebug();
                LogPreview.this.mHandler.post(new Runnable() { 
                    @Override
                    public void run() {
                        if (LogPreview.this.mDebug) {
                            if (LogPreview.this.rootView.getParent() == null) {
                                LogPreview.this.wm.addView(LogPreview.this.rootView, LogPreview.this.mParams);
                            }
                        } else if (LogPreview.this.rootView.getParent() != null) {
                            LogPreview.this.wm.removeView(LogPreview.this.rootView);
                        }
                    }
                });
                handler.removeCallbacks(this);
                handler.postDelayed(this, 25000L);
            }
        };
        handler.post(check);
    }

    public void init() {
        this.mParams = new WindowManager.LayoutParams(-1, -1, 0, 0, 2003, 56, 1);
        this.rootView = new FrameLayout(this.mContext);
        this.logPreview = new TextView(this.mContext);
        this.logPreview.setGravity(83);
        this.logPreview.setTextColor(-16711936);
        this.rootView.addView(this.logPreview, new FrameLayout.LayoutParams(-1, -2));
    }

    public void checkDebug() {
        if (this.debugSwith != null && !this.debugSwith.isEmpty()) {
            File file = new File(this.debugSwith);
            this.mDebug = file.exists();
        }
    }

    public void setDebugSwith(String debugSwith) {
        this.debugSwith = debugSwith;
    }

    public void showLogLine(String log) {
        if (this.mDebug) {
            if (this.logs.length() >= 20480) {
                this.logs.replace(0, 4096, "");
            }
            this.logs.append(log + "\n");
            this.mHandler.post(new Runnable() { 
                @Override
                public void run() {
                    LogPreview.this.logPreview.setText(LogPreview.this.logs.toString());
                }
            });
        }
    }

    public void destroy() {
        if (this.checkWork != null) {
            try {
                this.checkWork.getLooper().quit();
                this.checkWork.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void show(String msg) {
        if (instance != null) {
            instance.showLogLine(msg);
        }
    }
}
