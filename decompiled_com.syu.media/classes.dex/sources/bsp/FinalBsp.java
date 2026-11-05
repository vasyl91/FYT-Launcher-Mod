package bsp;

import base.event.AutoKeyEvent;
import com.syu.media.ListCondition01;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FinalBsp {
    public static final int C_ARM_BAND = 1;
    public static final int C_HDMI_ONOFF = 0;
    public static final int GUESTURE_CODE_UP = 0;
    public static final int KEY_AIR_AC = 250;
    public static final int KEY_CODE_ALL_APPS = 230;
    public static final int KEY_CODE_BACK = 226;
    public static final int KEY_CODE_BASE = 220;
    public static final int KEY_CODE_CAMERA = 237;
    public static final int KEY_CODE_DIM = 234;
    public static final int KEY_CODE_EJECT = 231;
    public static final int KEY_CODE_HOME = 225;
    public static final int KEY_CODE_MENU = 229;
    public static final int KEY_CODE_MODE = 222;
    public static final int KEY_CODE_MUTE = 232;
    public static final int KEY_CODE_NAVI = 221;
    public static final int KEY_CODE_NEXT = 224;
    public static final int KEY_CODE_PHONE = 238;
    public static final int KEY_CODE_PLAYPAUSE = 236;
    public static final int KEY_CODE_POWER = 220;
    public static final int KEY_CODE_PREV = 223;
    public static final int KEY_CODE_RECENT_TASK = 235;
    public static final int KEY_CODE_RESERVE_0 = 253;
    public static final int KEY_CODE_RESERVE_10 = 263;
    public static final int KEY_CODE_RESERVE_11 = 264;
    public static final int KEY_CODE_RESERVE_12 = 265;
    public static final int KEY_CODE_RESERVE_13 = 266;
    public static final int KEY_CODE_RESERVE_14 = 267;
    public static final int KEY_CODE_RESERVE_15 = 268;
    public static final int KEY_CODE_RESERVE_16 = 269;
    public static final int KEY_CODE_RESERVE_17 = 270;
    public static final int KEY_CODE_RESERVE_18 = 271;
    public static final int KEY_CODE_RESERVE_19 = 272;
    public static final int KEY_CODE_RESERVE_2 = 255;
    public static final int KEY_CODE_RESERVE_3 = 256;
    public static final int KEY_CODE_RESERVE_4 = 257;
    public static final int KEY_CODE_RESERVE_5 = 258;
    public static final int KEY_CODE_RESERVE_6 = 259;
    public static final int KEY_CODE_RESERVE_7 = 260;
    public static final int KEY_CODE_RESERVE_8 = 261;
    public static final int KEY_CODE_RESERVE_9 = 262;
    public static final int KEY_CODE_RESERVE_BEGAIN = 253;
    public static final int KEY_CODE_VA = 233;
    public static final int KEY_CODE_VOL_DOWN = 228;
    public static final int KEY_CODE_VOL_UP = 227;
    public static final int MODULE_CODE_BSP = 0;
    public static final int U_AUDIO_FOCUS = 8;
    public static final int U_AUDIO_STATUS = 0;
    public static final int U_BACK_CAR = 4;
    public static final int U_BUTTON_EVENT = 2;
    public static final int U_BUTTON_FEEDBACK = 6;
    public static final int U_GUESTURE = 7;
    public static final int U_MEDIASERVER_DIED = 10;
    public static final int U_SET_VOL_STREAM = 3;
    public static final int U_TOUCH_STATUS = 5;
    public static final int U_TOUCH_VOLUME = 9;
    public static final int KEY_AIR_WIND_PLUS = 245;
    public static final int KEY_AIR_TEMP_MINUS = 246;
    public static final int KEY_AIR_TEMP_PLUS = 247;
    public static final int KEY_AIR_CYCLE = 248;
    public static final int KEY_AIR_FOOTHEADBODY = 249;
    public static final int KEY_RADIO = 251;
    public static final int KEY_BLACK_SCREEN = 252;
    public static final int KEY_CODE_TONE_PLUS = 239;
    public static final int KEY_CODE_TONE_MINUS = 240;
    public static final int KEY_CODE_BAND = 241;
    public static final int KEY_CODE_DVD = 242;
    public static final int KEY_CODE_PANORAMA = 243;
    public static final int KEY_AIR_WIND_MINUS = 244;
    public static final int KEY_CODE_RESERVE_1 = 254;
    public static final int[] LEARN_CODES = {KEY_AIR_WIND_PLUS, KEY_AIR_TEMP_MINUS, KEY_AIR_TEMP_PLUS, KEY_AIR_CYCLE, KEY_AIR_FOOTHEADBODY, 250, KEY_RADIO, KEY_BLACK_SCREEN, 253, KEY_CODE_TONE_PLUS, KEY_CODE_TONE_MINUS, KEY_CODE_BAND, KEY_CODE_DVD, KEY_CODE_PANORAMA, KEY_AIR_WIND_MINUS, KEY_CODE_RESERVE_1, 181, 182, 183, 184, 185, 186, AutoKeyEvent.KEYCODE_RECENT, 188, 189, 190, 191, ListCondition01.USB, 193, 194, 195, 196, 197, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339};

    public static class Gestrue {
        public static final int FIVE_LONG_PRESS = 13;
        public static final int FIVE_TAP = 12;
        public static final int FOUR_TAP = 11;
        public static final int NONE = 0;
        public static final int THREE_DOWN = 8;
        public static final int THREE_LEFT = 6;
        public static final int THREE_RIGHT = 5;
        public static final int THREE_TAP = 10;
        public static final int THREE_UP = 7;
        public static final int TWO_DOWN = 4;
        public static final int TWO_LEFT = 2;
        public static final int TWO_RIGHT = 1;
        public static final int TWO_TAP = 9;
        public static final int TWO_UP = 3;
    }

    public static class GestrueAction {
        public static final int END = 2;
        public static final int MOVE = 1;
        public static final int START = 0;
    }
}
