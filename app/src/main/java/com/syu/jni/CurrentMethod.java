package com.syu.jni;

public class CurrentMethod {
    static final boolean bDebug = false;

    public static void gotoAdjustMode(boolean b) {
        try {
            ToolsJni.cmd_105_set_bl_adj(b ? 1 : 0);
        } catch (Exception e) {
        }
    }

    public static void setBlLimit(int min, int max) {
        try {
            ToolsJni.cmd_110_set_bl_limit(max, min);
        } catch (Exception e) {
        }
    }

    public static int[] readBlLimit() {
        int[] read = new int[3];
        try {
            int[] read2 = ToolsJni.cmd_109_get_bl_limit();
            return read2;
        } catch (Exception e) {
            return read;
        }
    }
}
