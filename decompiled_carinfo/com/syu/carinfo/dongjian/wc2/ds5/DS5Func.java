package com.syu.carinfo.dongjian.wc2.ds5;

import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5Func {
    public static void C_CAR_COMPUTER_SET(int val1, int val2) {
        DataCanbus.PROXY.cmd(0, new int[]{val1, val2}, null, null);
    }

    public static void C_UNIT_SET(int val1, int val2) {
        DataCanbus.PROXY.cmd(1, new int[]{val1, val2}, null, null);
    }

    public static void C_TIME_FORMAT_SET(int val1, int val2, int val3, int val4, int val5, int val6) {
        DataCanbus.PROXY.cmd(2, new int[]{val1, val2, val3, val4, val5, val6}, null, null);
    }
}
