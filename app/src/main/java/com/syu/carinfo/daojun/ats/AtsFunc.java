package com.syu.carinfo.daojun.ats;

import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

public class AtsFunc {
    public static int G_ONSTART_STATUS() {
        return 0;
    }

    public static void SWITCH_MAIN_STATE(int val) {
        int channel = DataMain.DATA[0];
        if (channel != val) {
            DataMain.PROXY.cmd(0, new int[]{val}, null, null);
        }
    }

    public static void CAR_AIR_CONTROL(int val1, int val2) {
        DataCanbus.PROXY.cmd(1, new int[]{val1, val2}, null, null);
    }

    public static void CAR_COMM_CONTROL(int val1, int val2) {
        DataCanbus.PROXY.cmd(3, new int[]{val1, val2}, null, null);
    }

    public static void CAR_ON_START_CTL(int val1) {
        DataCanbus.PROXY.cmd(5, val1);
    }

    public static void CAR_ON_START_CALL(int[] ints) {
        DataCanbus.PROXY.cmd(6, ints, null, null);
    }

    public static void CAR_WARNN_VOL(int val1) {
        DataCanbus.PROXY.cmd(7, val1);
    }

    public static void C_CAR_LANGUAGE_SETUP(int val1) {
        DataCanbus.PROXY.cmd(96, val1);
    }

    public static void C_REQUEST_CAR_INFO(int val1) {
        DataCanbus.PROXY.cmd(8, val1);
    }
}
