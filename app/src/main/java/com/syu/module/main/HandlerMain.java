package com.syu.module.main;

import com.android.launcher66.LauncherApplication;
import com.syu.util.HandlerHelper;
import com.syu.util.HandlerRemove;

public class HandlerMain {
    private static final Runnable REQEUST_APP_ID = new Runnable() { 
        @Override
        public void run() {
            if (LauncherApplication.isAppTop() && DataMain.PROXY.getI(0, -100) != DataMain.sAppIdRequest) {
                DataMain.PROXY.cmd(0, DataMain.sAppIdRequest);
                HandlerRemove.getInstance().postDelayed(this, 1000L);
            }
        }
    };

    public static void update(int updateCode, int[] ints) {
        if (ints != null && ints.length != 0 && DataMain.DATA[updateCode] != ints[0]) {
            DataMain.DATA[updateCode] = ints[0];
            DataMain.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int value) {
        if (DataMain.DATA[updateCode] != value) {
            DataMain.DATA[updateCode] = value;
            DataMain.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        if ((ints != null && ints.length != 0) || (strs != null && strs.length != 0)) {
            if (ints != null && DataMain.DATA[updateCode] != ints[0]) {
                DataMain.DATA[updateCode] = ints[0];
            }
            DataMain.NOTIFY_EVENTS[updateCode].onNotify(ints, flts, strs);
        }
    }

    public static void requestAppIdByOnTop(int value) {
        DataMain.sAppIdRequest = value;
        DataMain.PROXY.cmd(0, DataMain.sAppIdRequest);
        HandlerHelper.removeCallbacks(HandlerRemove.getInstance(), REQEUST_APP_ID);
        HandlerHelper.postDelayed(HandlerRemove.getInstance(), REQEUST_APP_ID, 300L);
    }
}
