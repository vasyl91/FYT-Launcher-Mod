package com.syu.carinfo.haozheng.bmw;

import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BmwFunc {
    public static void CAR_SYSTEM_SET(int val1, int val2, int val3, int val4, int val5) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2, val3, val4, val5}, null, null);
    }

    public static void CAR_TIME_SET(int val1, int val2, int val3, int val4, int val5) {
        DataCanbus.PROXY.cmd(1, new int[]{val1, val2, val3, val4, val5}, null, null);
    }

    public static void CAR_CONTROL_SET(int val1, int val2) {
        DataCanbus.PROXY.cmd(2, new int[]{val1, val2}, null, null);
    }
}
