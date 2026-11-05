package com.syu.jni;

import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ToolsJni {
    private static int cmdCpu = -1;

    public static int testJni() {
        int result = 0;
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle inparam = new Bundle();
            Bundle outparam = new Bundle();
            inparam.putInt("test_param", 100);
            result = syuJniNative.syu_jni_command(0, inparam, outparam);
            if (outparam != null) {
                outparam.getDouble("test_param");
            }
        }
        return result;
    }

    public static int cmd_1_backcarMirror(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(1, inparam, null);
    }

    public static int cmd_2_soundMix(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(2, inparam, null);
    }

    public static int cmd_3_encarption_result() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(3, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 1);
        return result;
    }

    public static int cmd_4_audio_state() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 1;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(4, null, outparam);
        if (outparam == null) {
            return 1;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_5_turnoff_lcdc(int isClose) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", isClose);
        return syuJniNative.syu_jni_command(5, inparam, null);
    }

    public static int cmd_6_mute_amp(int mute) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", mute);
        return syuJniNative.syu_jni_command(6, inparam, null);
    }

    public static int cmd_7_get_amp_state() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(7, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_8_reset_gps() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            return syuJniNative.syu_jni_command(8, null, null);
        }
        return 0;
    }

    public static int cmd_9_poweron_screen(int on) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return syuJniNative.syu_jni_command(9, inparam, null);
    }

    public static int cmd_10_little_hom(int on) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return syuJniNative.syu_jni_command(10, inparam, null);
    }

    public static int cmd_11_video_ntsc_pal(int on) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return syuJniNative.syu_jni_command(11, inparam, null);
    }

    public static int cmd_12_get_usb_speed() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(12, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_13_write_usb_speed(int speed) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", speed);
        return syuJniNative.syu_jni_command(13, inparam, null);
    }

    public static int cmd_14_set_backcar_type(int type) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 1;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", type);
        return syuJniNative.syu_jni_command(14, inparam, null);
    }

    public static int cmd_15_get_backcar_type() {
        try {
            SyuJniNative syuJniNative = SyuJniNative.getInstance();
            if (syuJniNative == null) {
                return 0;
            }
            Bundle outparam = new Bundle();
            syuJniNative.syu_jni_command(15, null, outparam);
            if (outparam == null) {
                return 0;
            }
            int result = outparam.getInt("param0", 0);
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int cmd_16_set_led_colors(int color, int save) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", color);
        inparam.putInt("param1", save);
        return syuJniNative.syu_jni_command(16, inparam, null);
    }

    public static int cmd_17_get_led_colors() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(17, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_19_airplane_mode(int on) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return syuJniNative.syu_jni_command(19, inparam, null);
    }

    public static int cmd_22_set_video_mode(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(22, inparam, null);
    }

    public static void cmd_24_reset_8288a() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            syuJniNative.syu_jni_command(24, null, null);
        }
    }

    public static int cmd_25_get_video_mode() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(25, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_26_get_video_signal_on() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 1;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(26, null, outparam);
        if (outparam == null) {
            return 1;
        }
        int result = outparam.getInt("param0", 1);
        return result;
    }

    public static int cmd_27_set_bl_param(int maxbl, int minbl, int defaultbl) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param3", maxbl);
        inparam.putInt("param4", minbl);
        inparam.putInt("param5", defaultbl);
        return syuJniNative.syu_jni_command(27, inparam, null);
    }

    public static int[] cmd_28_get_bl_param() {
        int[] result = new int[6];
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle outparam = new Bundle();
            syuJniNative.syu_jni_command(28, null, outparam);
            if (outparam != null) {
                result[0] = outparam.getInt("param0");
                result[1] = outparam.getInt("param1");
                result[2] = outparam.getInt("param2");
                result[3] = outparam.getInt("param3");
                result[4] = outparam.getInt("param4");
                result[5] = outparam.getInt("param5");
            }
        }
        return result;
    }

    public static int cmd_29_acc_state_to_bsp(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(29, inparam, null);
    }

    public static void cmd_31_fan_en(int value) {
        if (cmdCpu != value) {
            cmdCpu = value;
            SyuJniNative syuJniNative = SyuJniNative.getInstance();
            if (syuJniNative != null) {
                Bundle inparam = new Bundle();
                inparam.putInt("param0", cmdCpu);
                syuJniNative.syu_jni_command(31, inparam, null);
            }
        }
    }

    public static int cmd_32_get_boot_reverse_status() {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle outparam = new Bundle();
        syuJniNative.syu_jni_command(32, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static void cmd_33_reset_videoIc(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle inparam = new Bundle();
            inparam.putInt("param0", 1);
            syuJniNative.syu_jni_command(33, inparam, null);
        }
    }

    public static int cmd_50_fm_ant_en(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(50, inparam, null);
    }

    public static byte[] cmd_101_getT132Parama() {
        byte[] result = new byte[16384];
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle outparam = new Bundle();
            outparam.putByteArray("param1", result);
            syuJniNative.syu_jni_command(101, null, outparam);
        }
        return result;
    }

    public static int cmd_104_write_gamma(byte[] data) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putByteArray("param0", data);
        return syuJniNative.syu_jni_command(104, inparam, null);
    }

    public static int cmd_105_set_bl_adj(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(105, inparam, null);
    }

    public static int[] cmd_109_get_bl_limit() {
        int[] result = new int[3];
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle outparam = new Bundle();
            syuJniNative.syu_jni_command(109, null, outparam);
            if (outparam != null) {
                result[0] = outparam.getInt("param0", 0);
                result[1] = outparam.getInt("param1", 0);
                result[2] = outparam.getInt("param2", 0);
            }
        }
        return result;
    }

    public static int cmd_110_set_bl_limit(int max, int min) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", max);
        inparam.putInt("param1", min);
        return syuJniNative.syu_jni_command(110, inparam, null);
    }

    public static int cmd_118_get_Touchscreen_Sensitivity(byte[] level0, byte[] level1, byte[] level2, byte[] level3, byte[] level4) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("touchlevelcnt", 5);
        inparam.putByteArray("paramalevel0", level0);
        inparam.putByteArray("paramalevel1", level1);
        inparam.putByteArray("paramalevel2", level2);
        inparam.putByteArray("paramalevel3", level3);
        inparam.putByteArray("paramalevel4", level4);
        syuJniNative.syu_jni_command(118, inparam, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("touchlevel", -1);
        return result;
    }

    public static int cmd_119_set_Touchscreen_Sensitivity(int selectid, byte[] level0, byte[] level1, byte[] level2, byte[] level3, byte[] level4) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("touchlevelcnt", 5);
        inparam.putInt("setlevel", selectid);
        inparam.putByteArray("paramalevel0", level0);
        inparam.putByteArray("paramalevel1", level1);
        inparam.putByteArray("paramalevel2", level2);
        inparam.putByteArray("paramalevel3", level3);
        inparam.putByteArray("paramalevel4", level4);
        syuJniNative.syu_jni_command(119, inparam, outparam);
        if (outparam == null) {
            return 0;
        }
        int touchlevel = outparam.getInt("touchlevel", -1);
        return touchlevel;
    }

    public static byte[] cmd_148_read_data(int size, int offset) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative != null) {
            Bundle inparam = new Bundle();
            Bundle Outparam = new Bundle();
            inparam.putInt("offset", offset);
            inparam.putInt("readsize", size);
            if (syuJniNative.syu_jni_command(148, inparam, Outparam) == 0) {
                return Outparam.getByteArray("appdata");
            }
        }
        return null;
    }

    public static int cmd_149_write_data(byte[] data, int offset) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putByteArray("writedata", data);
        inparam.putInt("offset", offset);
        return syuJniNative.syu_jni_command(149, inparam, null);
    }

    public static int cmd_153_gsensor_power_onoff(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(153, inparam, null);
    }

    public static int cmd_160_write_rotation_angle(int value) {
        SyuJniNative syuJniNative = SyuJniNative.getInstance();
        if (syuJniNative == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("param0", value);
        return syuJniNative.syu_jni_command(160, inparam, outparam);
    }

    public static int setVideoPos_Px5(int[] vals) {
        SyuJniNative syuJniNative;
        if (vals == null || vals.length != 4 || (syuJniNative = SyuJniNative.getInstance()) == null) {
            return 0;
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putIntArray("param0", vals);
        return syuJniNative.syu_jni_command(34, inparam, outparam);
    }
}
