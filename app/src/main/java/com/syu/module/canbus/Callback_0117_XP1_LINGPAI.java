package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.ToastInfo;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0117_XP1_LINGPAI extends CallbackCanbusBase {
    public static final int U_AIR_AC = 32;
    public static final int U_AIR_ACMAX = 43;
    public static final int U_AIR_AUTO = 28;
    public static final int U_AIR_BEGIN = 27;
    public static final int U_AIR_BLOW_BODY_LEFT = 34;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_UP_LEFT = 36;
    public static final int U_AIR_CYCLE = 29;
    public static final int U_AIR_CYCLE_AUTO = 41;
    public static final int U_AIR_ECO = 42;
    public static final int U_AIR_END = 48;
    public static final int U_AIR_FRONT_DEFROST = 30;
    public static final int U_AIR_POWER = 39;
    public static final int U_AIR_REAR_CONTRL = 44;
    public static final int U_AIR_REAR_DEFROST = 31;
    public static final int U_AIR_SEATHEAT_LEFT = 46;
    public static final int U_AIR_SEATHEAT_RIGHT = 47;
    public static final int U_AIR_SYNC = 40;
    public static final int U_AIR_TEMP_LEFT = 33;
    public static final int U_AIR_TEMP_RIGHT = 38;
    public static final int U_AIR_TEMP_UNIT = 45;
    public static final int U_AIR_WIND_LEVEL_LEFT = 37;
    public static final int U_CARINDO_COMPASS_CAL = 96;
    public static final int U_CARINDO_COMPASS_POINT = 95;
    public static final int U_CARINFO_AMP_MODE = 107;
    public static final int U_CARINFO_AURO_DOOR_LOCK = 65;
    public static final int U_CARINFO_AURO_UNLOCK_ON_EXIT = 66;
    public static final int U_CARINFO_AUTO_ADJUST_SPEED_SOUND = 109;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 101;
    public static final int U_CARINFO_AUTO_ANTI_HIGH_BEAM = 62;
    public static final int U_CARINFO_AUTO_BRAKE = 99;
    public static final int U_CARINFO_AUTO_SEAT_START = 78;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_BRAKE_LIST_ENABLE = 98;
    public static final int U_CARINFO_BRAKE_PARK_SENSE = 93;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 84;
    public static final int U_CARINFO_CD_CURRENT_INDEX = 113;
    public static final int U_CARINFO_CD_PLAYMODE = 112;
    public static final int U_CARINFO_CD_PLAY_TIME = 114;
    public static final int U_CARINFO_CD_PLAY_TOTALTIME = 115;
    public static final int U_CARINFO_CD_STATE = 111;
    public static final int U_CARINFO_CD_TOTAL_INDEX = 116;
    public static final int U_CARINFO_COMPASS_DEVIATION_VALUE = 97;
    public static final int U_CARINFO_CORNERLING_LIGHTS = 59;
    public static final int U_CARINFO_DAYTIME_LIGHTS = 58;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 105;
    public static final int U_CARINFO_ENGINE_OFF_POWER_DELAY = 76;
    public static final int U_CARINFO_FIRST_PRESS_KEY_UNLOCK = 71;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LIGHT = 56;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LOCK = 67;
    public static final int U_CARINFO_FRONT_COLLISION_WARN = 87;
    public static final int U_CARINFO_FRONT_COLLISION_WARN_AUTO_BRAKE = 88;
    public static final int U_CARINFO_FRONT_PARK_VOL = 85;
    public static final int U_CARINFO_GREETING_LIGHT = 64;
    public static final int U_CARINFO_HEADLIGHT_DELAYED = 55;
    public static final int U_CARINFO_HEADLIGHT_DELAYED_ENGINE = 75;
    public static final int U_CARINFO_HEADLIGHT_ILLUMI_ON_APPROACH = 57;
    public static final int U_CARINFO_HEADLIGHT_SENSI = 63;
    public static final int U_CARINFO_HORN_LOCK = 68;
    public static final int U_CARINFO_HORN_REMOTE = 73;
    public static final int U_CARINFO_INTER_CARLIGHT = 106;
    public static final int U_CARINFO_LANE_DEVIATION_CALI = 90;
    public static final int U_CARINFO_LANE_DEVIATION_WARN = 94;
    public static final int U_CARINFO_LANG = 49;
    public static final int U_CARINFO_MIRROR_DIMMING = 61;
    public static final int U_CARINFO_PARKVIEW_DYNAMIC_GUIDE_LINE = 81;
    public static final int U_CARINFO_PARKVIEW_STATIC_GUIDE_LINE = 82;
    public static final int U_CARINFO_PARK_SENSE = 79;
    public static final int U_CARINFO_PASSIVE_ENTRY = 72;
    public static final int U_CARINFO_POWER_LEFT_GATE_ALERT = 70;
    public static final int U_CARINFO_RAIN_SENS_WIPERS = 91;
    public static final int U_CARINFO_RAMP_START_ASSIST = 83;
    public static final int U_CARINFO_REAR_BRAKE_PARK_AUTO = 92;
    public static final int U_CARINFO_REAR_BRAKE_PARK_SENSE = 80;
    public static final int U_CARINFO_REAR_PARK_VOL = 86;
    public static final int U_CARINFO_REMOTE_DOOR_UNLOCK = 74;
    public static final int U_CARINFO_REMOTE_TIP_SOUND = 108;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 77;
    public static final int U_CARINFO_SMART_KEY_SETTINGS = 69;
    public static final int U_CARINFO_SURROUND = 110;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 89;
    public static final int U_CARINFO_TIRE_JACKS = 102;
    public static final int U_CARINFO_TRANSPORT_MODE = 103;
    public static final int U_CARINFO_UNIT_DISTANCE = 52;
    public static final int U_CARINFO_UNIT_FUEL = 51;
    public static final int U_CARINFO_UNIT_PRESS = 54;
    public static final int U_CARINFO_UNIT_TEMP = 53;
    public static final int U_CARINFO_UNIT_UNIT = 50;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 104;
    public static final int U_CARINFO_WIN_LIST = 100;
    public static final int U_CARINFO_WIPER_WITH_HEADLIGHT = 60;
    public static final int U_CNT_MAX = 117;
    public static final int U_DOOR_BACK = 25;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 26;
    public static final int U_DOOR_ENGINE = 20;
    public static final int U_DOOR_FL = 21;
    public static final int U_DOOR_FR = 22;
    public static final int U_DOOR_RL = 23;
    public static final int U_DOOR_RR = 24;
    ShowSeriviceInfos infos;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 20; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 117) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (100 == updateCode && DataCanbus.DATA[99] == 1) {
            updatedateInfos(DataCanbus.DATA[updateCode]);
        }
    }

    private void updatedateInfos(int i) {
        int resid = -1;
        switch (i) {
            case 0:
                resid = R.string.str_117_bnr_zyg_1;
                break;
            case 1:
                resid = R.string.str_117_bnr_zyg_2;
                break;
            case 2:
                resid = R.string.str_117_bnr_zyg_3;
                break;
            case 3:
                resid = R.string.str_117_bnr_zyg_4;
                break;
            case 4:
                resid = R.string.str_117_bnr_zyg_5;
                break;
            case 5:
                resid = R.string.str_117_bnr_zyg_6;
                break;
            case 6:
                resid = R.string.str_117_bnr_zyg_7;
                break;
            case 7:
                resid = R.string.str_117_bnr_zyg_8;
                break;
        }
        if (resid > -1) {
            String string = LauncherApplication.getInstance().getString(resid);
            if (this.infos == null) {
                this.infos = new ShowSeriviceInfos();
            }
            this.infos.setText(string);
            HandlerRemove.getInstance().post(this.infos);
        }
    }

    public class ShowSeriviceInfos implements Runnable {
        private String string;

        public ShowSeriviceInfos() {
        }

        public void setText(String str) {
            this.string = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastInfo.showToast(LauncherApplication.getInstance(), this.string);
        }
    }
}
