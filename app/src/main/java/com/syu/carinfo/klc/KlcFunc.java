package com.syu.carinfo.klc;

import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

public class KlcFunc {
    public static void SWITCH_MAIN_STATE(int val) {
        int channel = DataMain.sAppIdRequest;
        if (channel != val) {
            DataMain.PROXY.cmd(0, new int[]{val}, null, null);
        }
    }

    public static void C_CAR_PANNEL_SELECT(int val1) {
        DataCanbus.PROXY.cmd(0, val1);
    }

    public static void C_CAR_AIR(int val1, int val2) {
        DataCanbus.PROXY.cmd(2, val1, val2);
    }

    public static void C_CAR_CRASH(int val1, int val2) {
        DataCanbus.PROXY.cmd(3, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_COMFORT(int val1, int val2) {
        DataCanbus.PROXY.cmd(4, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_LOCK(int val1, int val2) {
        DataCanbus.PROXY.cmd(5, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_REMOTE(int val1, int val2) {
        DataCanbus.PROXY.cmd(6, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_LIGHT(int val1, int val2) {
        DataCanbus.PROXY.cmd(7, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_METER(int val1, int val2) {
        DataCanbus.PROXY.cmd(8, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_SPORT_MODE(int val1, int val2) {
        DataCanbus.PROXY.cmd(9, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_ONSTAR(int[] ints) {
        DataCanbus.PROXY.cmd(12, ints, null, null);
    }

    public static void C_CAR_BT(int val1, int val2) {
        DataCanbus.PROXY.cmd(13, new int[]{val1, val2}, null, null);
    }

    public static void C_CAR_ONSTAR_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(11, new int[]{val1, val2}, null, null);
    }

    public static void C_AIR_CONTROL_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(14, new int[]{val1, val2}, null, null);
    }
}
