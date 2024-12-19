package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0255_rzc_xp1_fengshenax7;
import com.syu.ui.door.DoorHelper;
import java.lang.reflect.Array;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0255_RZC_XP1_FengShenAX7 extends CallbackCanbusBase {
    public static int[][] LIST_EX1_EN = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 31, 10);
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_TEMPERATURE_LEFT = 16;
    public static final int U_AIR_WIND_LEVEL = 15;
    public static final int U_CARSET_BEGIN = 26;
    public static final int U_CARSET_BLIND_PORT = 24;
    public static final int U_CARSET_D29_D0_B0 = 33;
    public static final int U_CARSET_D29_D0_B1 = 32;
    public static final int U_CARSET_D29_D0_B2 = 31;
    public static final int U_CARSET_D29_D0_B3 = 30;
    public static final int U_CARSET_D29_D0_B4 = 29;
    public static final int U_CARSET_D29_D0_B5 = 28;
    public static final int U_CARSET_D29_D0_B76 = 27;
    public static final int U_CARSET_D29_D1_B3 = 38;
    public static final int U_CARSET_D29_D1_B4 = 37;
    public static final int U_CARSET_D29_D1_B5 = 36;
    public static final int U_CARSET_D29_D1_B6 = 35;
    public static final int U_CARSET_D29_D1_B7 = 34;
    public static final int U_CARSET_D29_D2_B1 = 45;
    public static final int U_CARSET_D29_D2_B2 = 44;
    public static final int U_CARSET_D29_D2_B3 = 43;
    public static final int U_CARSET_D29_D2_B4 = 42;
    public static final int U_CARSET_D29_D2_B5 = 41;
    public static final int U_CARSET_D29_D2_B6 = 40;
    public static final int U_CARSET_D29_D2_B7 = 39;
    public static final int U_CARSET_D29_D3_B30 = 47;
    public static final int U_CARSET_D29_D3_B74 = 46;
    public static final int U_CARSET_D29_D4_B30 = 50;
    public static final int U_CARSET_D29_D4_B4 = 49;
    public static final int U_CARSET_D29_D4_B75 = 48;
    public static final int U_CARSET_D29_D5_B74 = 51;
    public static final int U_CARSET_D29_D6_B1 = 66;
    public static final int U_CARSET_D29_D6_B42 = 55;
    public static final int U_CARSET_D29_D6_B5 = 54;
    public static final int U_CARSET_D29_D6_B6 = 53;
    public static final int U_CARSET_D29_D6_B7 = 52;
    public static final int U_CARSET_D29_D7_B3 = 59;
    public static final int U_CARSET_D29_D7_B4 = 58;
    public static final int U_CARSET_D29_D7_B5 = 57;
    public static final int U_CARSET_D29_D7_B76 = 56;
    public static final int U_CARSET_D29_D8_B10 = 62;
    public static final int U_CARSET_D29_D8_B42 = 61;
    public static final int U_CARSET_D29_D8_B75 = 60;
    public static final int U_CARSET_D29_D9_B5 = 65;
    public static final int U_CARSET_D29_D9_B6 = 64;
    public static final int U_CARSET_D29_D9_B7 = 63;
    public static final int U_CARSET_D40_D0_B70 = 67;
    public static final int U_CARSET_D40_D1_B70 = 68;
    public static final int U_CARSET_D40_D2_D3 = 69;
    public static final int U_CARSET_D40_D4_D5 = 70;
    public static final int U_CARSET_D40_D6_B70 = 71;
    public static final int U_CARSET_D40_D7_B70 = 72;
    public static final int U_CARSET_D40_D8_D9 = 73;
    public static final int U_CARSET_D41_N0_ALL = 74;
    public static final int U_CARSET_MODE = 25;
    public static final int U_CARSET_TRUNAUTO_RCAM = 23;
    public static final int U_CNT_MAX = 75;
    public static final int U_CUR_SPEED = 18;
    public static final int U_CUR_SPEED_NOTIFFTIME = 20;
    public static final int U_ENGINE_SPEED = 19;
    public static final int U_ENGINE_SPEED_NOTIFFTIME = 21;
    public static final int U_TURN_CAM_STATUS = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 75; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0255_rzc_xp1_fengshenax7(LauncherApplication.getInstance()));
        for (int i4 = 6; i4 < 17; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 6; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 74) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            for (int i = 0; i < 10; i++) {
                LIST_EX1_EN[ints[0]][i] = ints[i + 1];
            }
        } else if (updateCode >= 0 && updateCode < 75) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
