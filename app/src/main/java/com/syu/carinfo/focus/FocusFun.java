package com.syu.carinfo.focus;

import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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