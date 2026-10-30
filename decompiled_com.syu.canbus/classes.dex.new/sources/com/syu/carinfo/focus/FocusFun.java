package com.syu.carinfo.focus;

import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class FocusFun {
    public static void C_SET_BUTTON_TOUCH(int type, int value) {
        DataCanbus.PROXY.cmd(0, new int[]{type, value}, null, null);
    }

    public static void C_REQUEST_AUTO(int type, int value) {
        DataCanbus.PROXY.cmd(0, new int[]{type, value}, null, null);
    }

    public static void C_CONTRAL(int type, int value) {
        DataCanbus.PROXY.cmd(1, new int[]{type, value}, null, null);
    }
}
