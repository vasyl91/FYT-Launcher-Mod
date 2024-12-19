package com.syu.carinfo.wc.ruijie15;

import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RJFunc {
    public static void C_REQUEST_CAR_INFO(int val1, int val2) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2}, null, null);
    }

    public static void C_CONTROL_ORD_CODE(int val1, int val2) {
        DataCanbus.PROXY.cmd(1, new int[]{val1, val2}, null, null);
    }

    public static void SET_TIPS_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(4, new int[]{val1, val2}, null, null);
    }

    public static void SET_CAR_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(5, new int[]{val1, val2}, null, null);
    }

    public static void C_SEAT_HEAT_LEFT(int val1) {
        DataCanbus.PROXY.cmd(2, new int[]{val1}, null, null);
    }

    public static void C_SEAT_HEAT_RIGHT(int val1) {
        DataCanbus.PROXY.cmd(3, new int[]{val1}, null, null);
    }
}
