package com.syu.carinfo.dongjian.ga6;

import com.syu.module.canbus.DataCanbus;

public class GA6Func {
    public static void C_CAR_CARINFO_CMD(int val1, int val2, int val3) {
        DataCanbus.PROXY.cmd(1, new int[]{val1, val2, val3}, null, null);
    }

    public static void C_AIR_SEAT_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(2, new int[]{val1, val2}, null, null);
    }
}
