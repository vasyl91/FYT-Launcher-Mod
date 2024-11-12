package com.syu.jni;

import android.os.Bundle;

public class ToolsJni {
    public static int testJni() {
        int result = 0;
        if (SyuJniNative.bLoadLibOk) {
            Bundle inparam = new Bundle();
            Bundle outparam = new Bundle();
            inparam.putInt("test_param", 100);
            result = SyuJniNative.getInstance().syu_jni_command(0, inparam, outparam);
            if (outparam != null) {
                outparam.getDouble("test_param");
            }
        }
        return result;
    }

    public static int cmd_1_backcarMirror(int value) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return SyuJniNative.getInstance().syu_jni_command(1, inparam, null);
    }

    public static int cmd_2_soundMix(int value) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return SyuJniNative.getInstance().syu_jni_command(2, inparam, null);
    }

    public static int cmd_3_encarption_result() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(3, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 1);
        return result;
    }

    public static int cmd_4_audio_state() {
        if (!SyuJniNative.bLoadLibOk) {
            return 1;
        }
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(4, null, outparam);
        if (outparam == null) {
            return 1;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_5_turnoff_lcdc(int isClose) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", isClose);
        return SyuJniNative.getInstance().syu_jni_command(5, inparam, null);
    }

    public static int cmd_6_mute_amp(int mute) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", mute);
        return SyuJniNative.getInstance().syu_jni_command(6, inparam, null);
    }

    public static int cmd_7_get_amp_state() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(7, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_8_reset_gps() {
        if (SyuJniNative.bLoadLibOk) {
            return SyuJniNative.getInstance().syu_jni_command(8, null, null);
        }
        return 0;
    }

    public static int cmd_9_poweron_screen(int on) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return SyuJniNative.getInstance().syu_jni_command(9, inparam, null);
    }

    public static int cmd_10_little_hom(int on) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return SyuJniNative.getInstance().syu_jni_command(10, inparam, null);
    }

    public static int cmd_11_video_ntsc_pal(int on) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", on);
        return SyuJniNative.getInstance().syu_jni_command(11, inparam, null);
    }

    public static int cmd_12_get_usb_speed() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(12, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_13_write_usb_speed(int speed) {
        Bundle inparam = new Bundle();
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        inparam.putInt("param0", speed);
        return SyuJniNative.getInstance().syu_jni_command(13, inparam, null);
    }

    public static int cmd_14_set_backcar_type(int type) {
        if (!SyuJniNative.bLoadLibOk) {
            return 1;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", type);
        return SyuJniNative.getInstance().syu_jni_command(14, inparam, null);
    }

    public static int cmd_15_get_backcar_type() {
        Bundle outparam = new Bundle();
        try {
            if (!SyuJniNative.bLoadLibOk) {
                return 0;
            }
            SyuJniNative.getInstance().syu_jni_command(15, null, outparam);
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
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putInt("param0", color);
        inparam.putInt("param1", save);
        return SyuJniNative.getInstance().syu_jni_command(16, inparam, null);
    }

    public static int cmd_17_get_led_colors() {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(17, null, outparam);
        if (outparam == null) {
            return 0;
        }
        int result = outparam.getInt("param0", 0);
        return result;
    }

    public static int cmd_104_write_gamma(byte[] data) {
        if (!SyuJniNative.bLoadLibOk) {
            return 0;
        }
        Bundle inparam = new Bundle();
        inparam.putByteArray("param0", data);
        return SyuJniNative.getInstance().syu_jni_command(104, inparam, null);
    }

    public static int cmd_105_set_bl_adj(int value) {
        Bundle inparam = new Bundle();
        inparam.putInt("param0", value);
        return SyuJniNative.getInstance().syu_jni_command(105, inparam, null);
    }

    public static int cmd_110_set_bl_limit(int max, int min) {
        Bundle inparam = new Bundle();
        inparam.putInt("param0", max);
        inparam.putInt("param1", min);
        return SyuJniNative.getInstance().syu_jni_command(110, inparam, null);
    }

    public static int[] cmd_109_get_bl_limit() {
        int[] result = new int[3];
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(109, null, outparam);
        if (outparam != null) {
            result[0] = outparam.getInt("param0", 0);
            result[1] = outparam.getInt("param1", 0);
            result[2] = outparam.getInt("param2", 0);
        }
        return result;
    }

    public static int cmd_27_set_bl_param(int maxbl, int minbl, int defaultbl) {
        Bundle inparam = new Bundle();
        inparam.putInt("param3", maxbl);
        inparam.putInt("param4", minbl);
        inparam.putInt("param5", defaultbl);
        return SyuJniNative.getInstance().syu_jni_command(27, inparam, null);
    }

    public static int[] cmd_28_get_bl_param() {
        int[] result = new int[6];
        Bundle outparam = new Bundle();
        SyuJniNative.getInstance().syu_jni_command(28, null, outparam);
        if (outparam != null) {
            result[0] = outparam.getInt("param0");
            result[1] = outparam.getInt("param1");
            result[2] = outparam.getInt("param2");
            result[3] = outparam.getInt("param3");
            result[4] = outparam.getInt("param4");
            result[5] = outparam.getInt("param5");
        }
        return result;
    }
}
