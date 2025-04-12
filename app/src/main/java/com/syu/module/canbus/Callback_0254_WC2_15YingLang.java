package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0254_WC2_15YingLang extends CallbackCanbusBase {
    public static final int U_24GHZ_RADAR_SET = 116;
    public static final int U_AIR_MODE_SET = 98;
    public static final int U_AIR_QUALITY_SENSOR1 = 99;
    public static final int U_AIR_QUALITY_SENSOR2 = 100;
    public static final int U_ANJIXING_BT_NUMBER = 161;
    public static final int U_ANJIXING_BT_PASSWORD = 160;
    public static final int U_ANJIXING_NUMBER = 159;
    public static final int U_ANJIXING_PHONE_FLAG = 150;
    public static final int U_ANJIXING_PHONE_HOUR = 151;
    public static final int U_ANJIXING_PHONE_MINUTE = 152;
    public static final int U_ANJIXING_PHONE_SECOND = 153;
    public static final int U_ANJIXING_PHONE_TYPE = 149;
    public static final int U_ANJIXING_SHENGYU_DAY = 157;
    public static final int U_ANJIXING_SHENGYU_MOUNTH = 156;
    public static final int U_ANJIXING_SHENGYU_TIME = 154;
    public static final int U_ANJIXING_SHENGYU_YEAR = 155;
    public static final int U_ANJIXING_STATE = 148;
    public static final int U_ANJIXING_WARN_TYPE = 158;
    public static final int U_AUTO_CRUISE_CONTROL = 164;
    public static final int U_AUTO_FRONT_GOFOG_ON = 108;
    public static final int U_AUTO_HEAT_SEAT = 103;
    public static final int U_AUTO_LUOSUO = 125;
    public static final int U_AUTO_MIRROR_FOLDING = 120;
    public static final int U_AUTO_MIRROR_QINGXIE = 119;
    public static final int U_AUTO_REAR_GOFOG_ON = 109;
    public static final int U_AUTO_SEAT_TONGFENG_SET = 102;
    public static final int U_AUTO_UNLOCK_SHOUDONG = 128;
    public static final int U_AUTO_UNLOCK_ZIDONG = 126;
    public static final int U_AUTO_WIND_MODE = 97;
    public static final int U_AUTO_YUSHUA_SHEDING = 122;
    public static final int U_AUTO_ZOOM_TEMP_SET = 101;
    public static final int U_BOCHE_HELP_SYSTEM_SET = 112;
    public static final int U_BOCHE_SYSTEM_SET_TUOKA = 115;
    public static final int U_CAR_CURRENT_SPEED = 110;
    public static final int U_CAR_TYPE_SELECT = 162;
    public static final int U_CEMANG_WARN_SYSTEM_SET = 113;
    public static final int U_CNT_MAX = 182;
    public static final int U_DELAY_TO_LOCK_SET = 127;
    public static final int U_DRIVER_KEY_AUTO_SHIBIE = 134;
    public static final int U_DRIVER_PERSONAL_SET = 121;
    public static final int U_DRIVER_SEAT_YIWEI = 117;
    public static final int U_ECO_ZHISHI_SET = 142;
    public static final int U_FANGZHUANG_WARN_TYPE_SET = 114;
    public static final int U_FORGET_KEY = 138;
    public static final int U_FRONT_LEFT_HIGH_WARN_INFO = 169;
    public static final int U_FRONT_LEFT_LOW_WARN_INFO = 170;
    public static final int U_FRONT_LEFT_PRESS = 165;
    public static final int U_FRONT_LEFT_WARN_INFO = 171;
    public static final int U_FRONT_RIGHT_HIGH_WARN_INFO = 172;
    public static final int U_FRONT_RIGHT_LOW_WARN_INFO = 173;
    public static final int U_FRONT_RIGHT_PRESS = 166;
    public static final int U_FRONT_RIGHT_WARN_INFO = 174;
    public static final int U_LEARVER_CAR_LOCK = 137;
    public static final int U_LOOKING_FOR_LIGHT = 140;
    public static final int U_LUOSUO_DELAY_SET = 141;
    public static final int U_NEAR_CAR_UNLOCK = 136;
    public static final int U_PREVENT_AUTO_LUOSUO = 124;
    public static final int U_REAR_LEFT_HIGH_WARN_INFO = 175;
    public static final int U_REAR_LEFT_LOW_WARN_INFO = 176;
    public static final int U_REAR_LEFT_PRESS = 167;
    public static final int U_REAR_LEFT_WARN_INFO = 177;
    public static final int U_REAR_RIGHT_HIGH_WARN_INFO = 178;
    public static final int U_REAR_RIGHT_LOW_WARN_INFO = 179;
    public static final int U_REAR_RIGHT_PRESS = 168;
    public static final int U_REAR_RIGHT_WARN_INFO = 180;
    public static final int U_REAR_ZOOM_TEMP_SET = 107;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 133;
    public static final int U_REMOTE_HUAYIMEN_SET = 139;
    public static final int U_REMOTE_LOCK_FEEDBACK = 129;
    public static final int U_REMOTE_LOCK_SET = 131;
    public static final int U_REMOTE_START_AIR = 111;
    public static final int U_REMOTE_START_SEAT_AUTO_HOT = 105;
    public static final int U_REMOTE_START_SEAT_AUTO_TONFEGN = 104;
    public static final int U_REMOTE_UNLOCK_AUTO_LOCK = 132;
    public static final int U_REMOTE_UNLOCK_FEEDBACK = 130;
    public static final int U_SETTING_ASSIST = 163;
    public static final int U_SHUNSHI_YOUHAO = 106;
    public static final int U_SOUND_CMD_REQUEST = 147;
    public static final int U_SPEED_MODE_BEIGUANG_SET = 146;
    public static final int U_SPEED_MODE_FADONGJI_SET = 145;
    public static final int U_SPEED_MODE_SET = 144;
    public static final int U_WARN_ENABLE = 181;
    public static final int U_YIBIAO_INFO_SET = 143;
    public static final int U_YUANCHENG_START_SET = 135;
    public static final int U_ZHUANGXIANG_GUANZHU_QINGXIE = 123;
    public static final int U_ZHUANGXIANG_GUANZHU_YIWEI = 118;
    public static String btNumber;
    public static String btPassWord;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 182; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0254_WC2_15YingLang(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 159:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 160:
                if (strs != null && strs.length > 0) {
                    btPassWord = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 161:
                if (strs != null && strs.length > 0) {
                    btNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 182) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
