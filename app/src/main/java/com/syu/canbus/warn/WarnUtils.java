package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WarnUtils {
    static int LocationX = 0;
    static int LocationY = 0;
    private static final Runnable SHOW = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.1
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            LauncherApplication.addRootView(window);
            if (LauncherApplication.rootViewWindowToken() == null) {
                HandlerUI.getInstance().postDelayed(this, 1L);
            } else if (!window.isShowing()) {
                if (DataCanbus.DATA[1000] == 131522) {
                    window.showAtLocation(LauncherApplication.getInstance().getRootView(), 3, 0, 0);
                } else {
                    window.showAtLocation(LauncherApplication.getInstance().getRootView(), 17, WarnUtils.LocationX, WarnUtils.LocationY);
                }
            }
        }
    };
    private static final Runnable WINDOW_HIDE = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.2
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            if (window.isShowing()) {
                window.dismiss();
            }
        }
    };
    private static PopupWindow sPopupWindow;

    public static PopupWindow getWindow() {
        if (sPopupWindow == null) {
            Context context = LauncherApplication.getInstance();
            PopupWindow window = new PopupWindow(context);
            window.setFocusable(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (DataCanbus.DATA[1000] == 131522) {
                window.setWidth(LauncherApplication.getScreenWidth());
                window.setHeight(230);
            } else if (DataCanbus.DATA[1000] == 196774) {
                window.setWidth(1024);
                window.setHeight(540);
            } else {
                window.setWidth(-2);
                window.setHeight(-2);
            }
            sPopupWindow = window;
        }
        return sPopupWindow;
    }

    public static void setLocation(int x, int y) {
        LocationX = x;
        LocationY = y;
    }

    public static void postDelayedSingle(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    public static void postDimiss(int delay) {
        postDelayedSingle(WINDOW_HIDE, delay);
    }

    public static void showWindow() {
        HandlerUI.getInstance().post(SHOW);
    }
}
