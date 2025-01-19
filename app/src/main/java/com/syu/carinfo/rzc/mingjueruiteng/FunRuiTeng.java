package com.syu.carinfo.rzc.mingjueruiteng;

import com.syu.module.canbus.DataCanbus;

public class FunRuiTeng {
    public static void C_AIR_SET(int... param) {
        DataCanbus.PROXY.cmd(2, param, null, null);
    }

    public static void C_CARINFO_SET(int... param) {
        DataCanbus.PROXY.cmd(3, param, null, null);
    }
}
