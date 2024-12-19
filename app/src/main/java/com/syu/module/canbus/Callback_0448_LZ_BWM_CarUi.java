package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar;
import com.syu.carinfo.ksw.audiq5.LZBmwCarinfoAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0448_LZ_BMW;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0448_LZ_BWM_CarUi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 27;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_AUTO_LEFT = 35;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 39;
    public static final int U_AIR_BLOW_BODY_LEFT = 33;
    public static final int U_AIR_BLOW_BODY_RIGHT = 37;
    public static final int U_AIR_BLOW_FOOT_LEFT = 34;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 38;
    public static final int U_AIR_BLOW_UP_LEFT = 32;
    public static final int U_AIR_BLOW_UP_RIGHT = 36;
    public static final int U_AIR_CYCLE = 28;
    public static final int U_AIR_DUAL = 31;
    public static final int U_AIR_END = 46;
    public static final int U_AIR_FRONT_DEFROST = 29;
    public static final int U_AIR_POWER = 26;
    public static final int U_AIR_REAR_DEFROST = 30;
    public static final int U_AIR_SEAT_HEAT_LEFT = 44;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 45;
    public static final int U_AIR_TEMP_LEFT = 40;
    public static final int U_AIR_TEMP_RIGHT = 41;
    public static final int U_AIR_WIND_AUTO_LEFT = 43;
    public static final int U_AIR_WIND_LEVEL_LEFT = 42;
    public static final int U_CAR_AUX_AUTO_HAND = 56;
    public static final int U_CAR_AUX_KEYNUM = 54;
    public static final int U_CAR_AUX_POSITION = 55;
    public static final int U_CAR_BACKCAR_DELAY = 59;
    public static final int U_CAR_BACKCAR_TYPE = 58;
    public static final int U_CAR_BACK_JUMP = 13;
    public static final int U_CAR_BELT = 47;
    public static final int U_CAR_CAM_STATE = 7;
    public static final int U_CAR_CARUI_STATE = 53;
    public static final int U_CAR_CAR_BT_TYPE = 57;
    public static final int U_CAR_CUR_SPEED = 15;
    public static final int U_CAR_D13_D7_B70 = 61;
    public static final int U_CAR_D13_D8_B70 = 62;
    public static final int U_CAR_DISTANCE_UNIT = 19;
    public static final int U_CAR_DRIVED_ENABLE = 14;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_EVO_STATE = 52;
    public static final int U_CAR_GUIJI_STATE = 11;
    public static final int U_CAR_HANDBRAKE_STATE = 12;
    public static final int U_CAR_IDRIVE_STATE = 50;
    public static final int U_CAR_JUMPCARINFO = 60;
    public static final int U_CAR_LANG_STATE = 49;
    public static final int U_CAR_MIRROR_STATE = 8;
    public static final int U_CAR_OIL_REMAINED = 17;
    public static final int U_CAR_OUTSIDE_TEMP = 48;
    public static final int U_CAR_RADAR_STATE = 10;
    public static final int U_CAR_SCREEN_STATE = 51;
    public static final int U_CAR_TEMP_UNIT = 18;
    public static final int U_CAR_TIRE_PRESSURE_FL = 21;
    public static final int U_CAR_TIRE_PRESSURE_FR = 22;
    public static final int U_CAR_TIRE_PRESSURE_RL = 23;
    public static final int U_CAR_TIRE_PRESSURE_RR = 24;
    public static final int U_CAR_TOTAL_MILE = 20;
    public static final int U_CAR_UI_STATE = 9;
    public static final int U_CNT_MAX = 63;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 63; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 65984 || DataCanbus.DATA[1000] == 262592 || DataCanbus.DATA[1000] == 197056 || DataCanbus.DATA[1000] == 131520) {
            AirHelper.getInstance().buildUi(new Air_0448_LZ_BMW(LauncherApplication.getInstance()));
            for (int i3 = 25; i3 < 46; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 25; i2 < 46; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showDashBoard(int updateCode, int[] ints) {
        int value = ints[0];
        if (value == 1 && !KswAudiQ5Backcar.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar");
        } else if (KswAudiQ5Backcar.mIsFront && value == 0 && KswAudiQ5Backcar.mIsFront && KswAudiQ5Backcar.mInstance != null) {
            KswAudiQ5Backcar.mInstance.finish();
        }
    }

    private void showDashBoardYage10(int updateCode, int[] ints) {
        int value = ints[0];
        if (value == 1 && !LZBmwCarinfoAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ksw.audiq5.LZBmwCarinfoAct");
        } else if (LZBmwCarinfoAct.mIsFront && value == 0 && LZBmwCarinfoAct.mIsFront && LZBmwCarinfoAct.mInstance != null) {
            LZBmwCarinfoAct.mInstance.finish();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 63) {
            switch (updateCode) {
                case 13:
                    showDashBoard(updateCode, ints);
                    break;
                case 60:
                    showDashBoardYage10(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
