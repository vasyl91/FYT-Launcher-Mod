package com.syu.carinfo.focus.yl;

import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FFuncYLFocus {
    public static void C_SET_CONTROT(int modeType, int modeCmd) {
        DataCanbus.PROXY.cmd(3, modeType, modeCmd);
    }

    public static void C_CD_LIST_SELECT(int position) {
        DataCanbus.PROXY.cmd(5, position);
    }

    public static void C_CMD_REQUEST(int cmdCode) {
        DataCanbus.PROXY.cmd(0, cmdCode);
    }
}