package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0442_KSW_AUDI_Q5 extends CallbackCanbusBase {
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
    public static final int U_CAR_BACK_JUMP = 13;
    public static final int U_CAR_CAM_STATE = 7;
    public static final int U_CAR_CUR_SPEED = 15;
    public static final int U_CAR_DISTANCE_UNIT = 19;
    public static final int U_CAR_DRIVED_ENABLE = 14;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_GUIJI_STATE = 11;
    public static final int U_CAR_HANDBRAKE_STATE = 12;
    public static final int U_CAR_MIRROR_STATE = 8;
    public static final int U_CAR_OIL_REMAINED = 17;
    public static final int U_CAR_RADAR_STATE = 10;
    public static final int U_CAR_TEMP_UNIT = 18;
    public static final int U_CAR_TIRE_PRESSURE_FL = 21;
    public static final int U_CAR_TIRE_PRESSURE_FR = 22;
    public static final int U_CAR_TIRE_PRESSURE_RL = 23;
    public static final int U_CAR_TIRE_PRESSURE_RR = 24;
    public static final int U_CAR_TOTAL_MILE = 20;
    public static final int U_CAR_UI_STATE = 9;
    public static final int U_CNT_MAX = 47;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            switch (updateCode) {
                case 13:
                    showDashBoard(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
