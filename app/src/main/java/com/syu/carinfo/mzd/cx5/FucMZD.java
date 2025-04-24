package com.syu.carinfo.mzd.cx5;

import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class FucMZD {
    public static void C_MZD_CX5_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2}, null, null);
    }
}
