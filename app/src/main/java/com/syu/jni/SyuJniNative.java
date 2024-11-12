package com.syu.jni;

public class SyuJniNative {
    private static final SyuJniNative INSTANCE = new SyuJniNative();
    public static final int JNI_EXE_CMD_0_TEST = 0;
    public static final int JNI_EXE_CMD_104_WRITE_GAMMA = 104;
    public static final int JNI_EXE_CMD_105_SET_BL_ADJ = 105;
    public static final int JNI_EXE_CMD_106_SET_BL_LIMIT = 106;
    public static final int JNI_EXE_CMD_107_GET_BL_PARAM = 107;
    public static final int JNI_EXE_CMD_109_GET_BL_DUTY = 109;
    public static final int JNI_EXE_CMD_10_LITTLE_HOM = 10;
    public static final int JNI_EXE_CMD_110_SET_BL_DUTY = 110;
    public static final int JNI_EXE_CMD_112_IS_AREAACTIVED = 112;
    public static final int JNI_EXE_CMD_113_ACTIVE_AREA = 113;
    public static final int JNI_EXE_CMD_114_GET_ACTIVEKEY = 114;
    public static final int JNI_EXE_CMD_11_VIDEO_NTSC_PAL = 11;
    public static final int JNI_EXE_CMD_12_GET_USB_SPEED = 12;
    public static final int JNI_EXE_CMD_13_SET_USB_SPEED = 13;
    public static final int JNI_EXE_CMD_14_SET_BACKCAR_TYPE = 14;
    public static final int JNI_EXE_CMD_15_GET_BACKCAR_TYPE = 15;
    public static final int JNI_EXE_CMD_161_GET_SMITYPE = 161;
    public static final int JNI_EXE_CMD_162_SET_SMITYPE = 162;
    public static final int JNI_EXE_CMD_16_SET_LED_COLORS = 16;
    public static final int JNI_EXE_CMD_17_GET_LED_COLORS = 17;
    public static final int JNI_EXE_CMD_1_BACKCAR_MIRROR = 1;
    public static final int JNI_EXE_CMD_27_SET_BL_PARAM = 27;
    public static final int JNI_EXE_CMD_28_GET_BL_PARAM = 28;
    public static final int JNI_EXE_CMD_2_SOUND_MIX = 2;
    public static final int JNI_EXE_CMD_3_ENCARPTION_RESULT = 3;
    public static final int JNI_EXE_CMD_4_AUDIO_STATE = 4;
    public static final int JNI_EXE_CMD_5_TURNOFF_LCDC = 5;
    public static final int JNI_EXE_CMD_6_MUTE_AMP = 6;
    public static final int JNI_EXE_CMD_7_AMP_MUTE_STATE = 7;
    public static final int JNI_EXE_CMD_8_RESET_GPS = 8;
    public static final int JNI_EXE_CMD_9_POWERON_SCREEN = 9;
    public static boolean bLoadLibOk;

    public native int syu_jni_command(int i, Object obj, Object obj2);

    static {
        bLoadLibOk = true;
        try {
            System.loadLibrary("syu_jni");
        } catch (Throwable th) {
            bLoadLibOk = false;
        }
    }

    public static SyuJniNative getInstance() {
        return INSTANCE;
    }
}
