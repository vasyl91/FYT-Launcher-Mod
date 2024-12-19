package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0355_XP_QiYaK5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0355_XP_QiYaK5 extends CallbackCanbusBase {
    public static final int CMD_SET_CTRL = 1;
    public static final int C_CMD_AIR = 0;
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AQS = 30;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CLEAR_AIR = 29;
    public static final int U_AIR_CLIMATE = 21;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 12;
    public static final int U_AIR_REAR = 31;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_REAR_POWER = 38;
    public static final int U_AIR_REAR_WIN_LEV = 39;
    public static final int U_AIR_SEAT_HOT_LEFT = 42;
    public static final int U_AIR_SEAT_HOT_RIGHT = 43;
    public static final int U_AIR_SHOW = 41;
    public static final int U_AIR_TEMP_LEFT = 5;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 9;
    public static final int U_BTLINK_BTSTATE = 28;
    public static final int U_BTLINK_NAME = 24;
    public static final int U_BTLINK_NAVI_END_ADDR = 26;
    public static final int U_BTLINK_NAVI_END_NAME = 25;
    public static final int U_BTLINK_NAVI_END_TEL = 27;
    public static final int U_BTLINK_SPEAKING = 22;
    public static final int U_BTLINK_TALKING_TIME = 23;
    public static final int U_CARSET_BEGIN = 32;
    public static final int U_CARSET_END = 37;
    public static final int U_CARSET_GUIJI = 33;
    public static final int U_CARSET_RADAR = 34;
    public static final int U_CARSET_VIEW_FRONT = 35;
    public static final int U_CARSET_VIEW_REAR = 36;
    public static final int U_CAR_EQ_BASS = 45;
    public static final int U_CAR_EQ_MID = 46;
    public static final int U_CAR_EQ_ON = 44;
    public static final int U_CAR_EQ_TREB = 47;
    public static final int U_CAR_LANGUAGE = 48;
    public static final int U_CNT_MAX = 49;
    public static final int U_DOOR_BACK = 19;
    public static final int U_DOOR_BEGIN = 14;
    public static final int U_DOOR_END = 20;
    public static final int U_DOOR_ENGINE = 14;
    public static final int U_DOOR_FL = 15;
    public static final int U_DOOR_FR = 16;
    public static final int U_DOOR_RL = 17;
    public static final int U_DOOR_RR = 18;
    public static final int U_JUMP_SOS_PAGE = 40;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 14;
        DoorHelper.sUcDoorFl = 15;
        DoorHelper.sUcDoorFr = 16;
        DoorHelper.sUcDoorRl = 17;
        DoorHelper.sUcDoorRr = 18;
        DoorHelper.sUcDoorBack = 19;
        AirHelper.getInstance().buildUi(new Air_0355_XP_QiYaK5(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 14; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 14; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[41].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 14; i < 20; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 14; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 40:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 49) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 40) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }
}
