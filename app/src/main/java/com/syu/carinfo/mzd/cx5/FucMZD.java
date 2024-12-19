package com.syu.carinfo.mzd.cx5;

import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FucMZD {
    public static void C_MZD_CX5_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2}, null, null);
    }
}
