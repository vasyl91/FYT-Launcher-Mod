package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_00345_WC2_GM2;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0345_WC2_ShuPingJunWei extends CallbackCanbusBase {
    public static final int U_24GHZ_RADAR_SET = 19;
    public static final int U_AIR_AC_HY = 73;
    public static final int U_AIR_AC_ON = 72;
    public static final int U_AIR_AIR_QULITY = 74;
    public static final int U_AIR_BEGIN = 71;
    public static final int U_AIR_BLOW_AUTO_LEFT = 81;
    public static final int U_AIR_BLOW_AUTO_REAR = 85;
    public static final int U_AIR_BLOW_BODY_LEFT = 79;
    public static final int U_AIR_BLOW_BODY_REAR = 86;
    public static final int U_AIR_BLOW_FOOT_LEFT = 80;
    public static final int U_AIR_BLOW_FOOT_REAR = 87;
    public static final int U_AIR_BLOW_FRONT_MODE = 113;
    public static final int U_AIR_BLOW_REAR_MODE = 114;
    public static final int U_AIR_BLOW_UP_LEFT = 78;
    public static final int U_AIR_BLOW_WIN_LEFT = 104;
    public static final int U_AIR_CYCLE_AUTO = 76;
    public static final int U_AIR_CYCLE_TYPE = 75;
    public static final int U_AIR_END = 90;
    public static final int U_AIR_FRONT_DEFROST = 77;
    public static final int U_AIR_FRONT_GL6_DEFROST = 142;
    public static final int U_AIR_HEAT_LEFT = 108;
    public static final int U_AIR_HEAT_RIGHT = 109;
    public static final int U_AIR_MODE_SET = 1;
    public static final int U_AIR_POWER_ON = 71;
    public static final int U_AIR_QUALITY_SENSOR1 = 2;
    public static final int U_AIR_QUALITY_SENSOR2 = 3;
    public static final int U_AIR_REAR_DEFROST = 99;
    public static final int U_AIR_SEAT_BLOW_LEFT = 103;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 102;
    public static final int U_AIR_SEAT_HEAT_LEFT = 101;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 100;
    public static final int U_AIR_SHOW = 143;
    public static final int U_AIR_SYNC = 98;
    public static final int U_AIR_SYNC_ON = 110;
    public static final int U_AIR_TEMP_LEFT = 83;
    public static final int U_AIR_TEMP_LEFT_REAR = 88;
    public static final int U_AIR_TEMP_RIGHT = 84;
    public static final int U_AIR_WIND_LEVEL_LEFT = 82;
    public static final int U_AIR_WIND_LEVEL_REAR = 89;
    public static final int U_AIR_WIND_MODE = 105;
    public static final int U_ANJIXING_BT_NUMBER = 64;
    public static final int U_ANJIXING_BT_PASSWORD = 63;
    public static final int U_ANJIXING_NUMBER = 62;
    public static final int U_ANJIXING_PHONE_FLAG = 53;
    public static final int U_ANJIXING_PHONE_HOUR = 54;
    public static final int U_ANJIXING_PHONE_MINUTE = 55;
    public static final int U_ANJIXING_PHONE_NUMBER = 141;
    public static final int U_ANJIXING_PHONE_SECOND = 56;
    public static final int U_ANJIXING_PHONE_TYPE = 52;
    public static final int U_ANJIXING_SHENGYU_DAY = 60;
    public static final int U_ANJIXING_SHENGYU_MOUNTH = 59;
    public static final int U_ANJIXING_SHENGYU_TIME = 57;
    public static final int U_ANJIXING_SHENGYU_YEAR = 58;
    public static final int U_ANJIXING_STATE = 51;
    public static final int U_ANJIXING_TTS = 139;
    public static final int U_ANJIXING_TTS_SHOW = 140;
    public static final int U_ANJIXING_WARN_TYPE = 61;
    public static final int U_AUTO_CRUISE_CONTROL = 112;
    public static final int U_AUTO_FANGZHUANG = 66;
    public static final int U_AUTO_FRONT_GOFOG_ON = 11;
    public static final int U_AUTO_HEAT_SEAT = 6;
    public static final int U_AUTO_LUOSUO = 28;
    public static final int U_AUTO_MIRROR_FOLDING = 23;
    public static final int U_AUTO_MIRROR_QINGXIE = 22;
    public static final int U_AUTO_REAR_GOFOG_ON = 12;
    public static final int U_AUTO_SEAT_TONGFENG_SET = 5;
    public static final int U_AUTO_UNLOCK_SHOUDONG = 31;
    public static final int U_AUTO_UNLOCK_ZIDONG = 29;
    public static final int U_AUTO_WIND_MODE = 0;
    public static final int U_AUTO_YUGUA = 69;
    public static final int U_AUTO_YUSHUA_SHEDING = 25;
    public static final int U_AUTO_ZOOM_TEMP_SET = 4;
    public static final int U_BOCHE_HELP_SYSTEM_SET = 15;
    public static final int U_BOCHE_SYSTEM_SET_TUOKA = 18;
    public static final int U_CAR_CURRENT_SPEED = 13;
    public static final int U_CAR_STATE_NOTIFY = 67;
    public static final int U_CAR_TYPE_SELECT = 65;
    public static final int U_CEMANG_WARN_SYSTEM_SET = 16;
    public static final int U_CNT_MAX = 144;
    public static final int U_CUR_SPEED = 106;
    public static final int U_DELAY_TO_LOCK_SET = 30;
    public static final int U_DOOR_BACK = 96;
    public static final int U_DOOR_BEGIN = 91;
    public static final int U_DOOR_END = 97;
    public static final int U_DOOR_ENGINE = 91;
    public static final int U_DOOR_FL = 92;
    public static final int U_DOOR_FR = 93;
    public static final int U_DOOR_RL = 94;
    public static final int U_DOOR_RR = 95;
    public static final int U_DRIVER_KEY_AUTO_SHIBIE = 37;
    public static final int U_DRIVER_PERSONAL_SET = 24;
    public static final int U_DRIVER_SEAT_YIWEI = 20;
    public static final int U_ECO_ZHISHI_SET = 45;
    public static final int U_ENGINE_SPEED = 107;
    public static final int U_FANGZHUANG_WARN_TYPE_SET = 17;
    public static final int U_FORGET_KEY = 41;
    public static final int U_FRONT_LEFT_HIGH_WARN_INFO = 124;
    public static final int U_FRONT_LEFT_LOW_WARN_INFO = 125;
    public static final int U_FRONT_LEFT_PRESS = 120;
    public static final int U_FRONT_LEFT_WARN_INFO = 126;
    public static final int U_FRONT_RIGHT_HIGH_WARN_INFO = 127;
    public static final int U_FRONT_RIGHT_LOW_WARN_INFO = 128;
    public static final int U_FRONT_RIGHT_PRESS = 121;
    public static final int U_FRONT_RIGHT_WARN_INFO = 129;
    public static final int U_LEARVER_CAR_LOCK = 40;
    public static final int U_LOCATION_LIGHTS = 138;
    public static final int U_LOOKING_FOR_LIGHT = 43;
    public static final int U_LUOSUO_DELAY_SET = 44;
    public static final int U_NEAR_CAR_UNLOCK = 39;
    public static final int U_PREVENT_ANTI_LOCK = 137;
    public static final int U_PREVENT_AUTO_LUOSUO = 27;
    public static final int U_REAR_LEFT_HIGH_WARN_INFO = 130;
    public static final int U_REAR_LEFT_LOW_WARN_INFO = 131;
    public static final int U_REAR_LEFT_PRESS = 122;
    public static final int U_REAR_LEFT_WARN_INFO = 132;
    public static final int U_REAR_RIGHT_HIGH_WARN_INFO = 133;
    public static final int U_REAR_RIGHT_LOW_WARN_INFO = 134;
    public static final int U_REAR_RIGHT_PRESS = 123;
    public static final int U_REAR_RIGHT_WARN_INFO = 135;
    public static final int U_REAR_ZOOM_TEMP_SET = 10;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 36;
    public static final int U_REMOTE_HUAYIMEN_SET = 42;
    public static final int U_REMOTE_LOCK_FEEDBACK = 32;
    public static final int U_REMOTE_LOCK_SET = 34;
    public static final int U_REMOTE_START_AIR = 14;
    public static final int U_REMOTE_START_SEAT_AUTO_HEAT1 = 68;
    public static final int U_REMOTE_START_SEAT_AUTO_HOT = 8;
    public static final int U_REMOTE_START_SEAT_AUTO_TONFEGN = 7;
    public static final int U_REMOTE_UNLOCK_AUTO_LOCK = 35;
    public static final int U_REMOTE_UNLOCK_FEEDBACK = 33;
    public static final int U_REMOTE_WINDOW_CONTROL = 70;
    public static final int U_SETTING_ASSIST = 111;
    public static final int U_SHUNSHI_YOUHAO = 9;
    public static final int U_SOUND_CMD_REQUEST = 50;
    public static final int U_SPEED_MODE_BEIGUANG_SET = 49;
    public static final int U_SPEED_MODE_FADONGJI_SET = 48;
    public static final int U_SPEED_MODE_SET = 47;
    public static final int U_WARN_ENABLE = 136;
    public static final int U_YIBIAO_INFO_SET = 46;
    public static final int U_YUANCHENG_START_SET = 38;
    public static final int U_ZHUANGXIANG_GUANZHU_QINGXIE = 26;
    public static final int U_ZHUANGXIANG_GUANZHU_YIWEI = 21;
    public static String btNumber;
    public static String btPassWord;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 91;
        DoorHelper.sUcDoorFl = 92;
        DoorHelper.sUcDoorFr = 93;
        DoorHelper.sUcDoorRl = 94;
        DoorHelper.sUcDoorRr = 95;
        DoorHelper.sUcDoorBack = 96;
        AirHelper.getInstance().buildUi(new Air_00345_WC2_GM2(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 91; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 71; i3 < 90; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 91; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 71; i2 < 90; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 62:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 63:
                if (strs != null && strs.length > 0) {
                    btPassWord = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 64:
                if (strs != null && strs.length > 0) {
                    btNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 144) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
