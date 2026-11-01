package com.syu.carinfo.rzc.mingjueruiteng;

import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class FunRuiTeng {
    public static void C_AIR_SET(int... param) {
        DataCanbus.PROXY.cmd(2, param, null, null);
    }

    public static void C_CARINFO_SET(int... param) {
        DataCanbus.PROXY.cmd(3, param, null, null);
    }
}
