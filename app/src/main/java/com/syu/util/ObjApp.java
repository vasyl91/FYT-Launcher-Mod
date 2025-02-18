package com.syu.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;

public class ObjApp {
    private static ContentResolver sContentResolver;
    private static DebugView sDebugView;
    private static PackageManager sPackageManager;
    private static final Point sPoint = new Point();
    private static Resources sResources;
    private static WindowManager sWindowManager;

    public ObjApp(Context context) {
        sDebugView = new DebugView(context);
        sResources = context.getResources();
        sPackageManager = context.getPackageManager();
        sWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        sContentResolver = context.getContentResolver();
        sWindowManager.getDefaultDisplay().getSize(sPoint);
    }

    public static int getWidth() {
        return sPoint.x;
    }

    public static int getHeight() {
        return sPoint.y;
    }

    public static DebugView getMsgView() {
        return sDebugView;
    }

    public static Resources getResources() {
        return sResources;
    }

    public static PackageManager getPackageManager() {
        return sPackageManager;
    }

    public static WindowManager getWindowManager() {
        return sWindowManager;
    }

    public static ContentResolver getContentResolver() {
        return sContentResolver;
    }
}
