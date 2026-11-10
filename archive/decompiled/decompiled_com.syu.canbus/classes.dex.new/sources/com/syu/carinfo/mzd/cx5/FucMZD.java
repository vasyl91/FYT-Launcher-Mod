package com.syu.carinfo.mzd.cx5;

import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class FucMZD {
    public static void C_MZD_CX5_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2}, null, null);
    }
}
