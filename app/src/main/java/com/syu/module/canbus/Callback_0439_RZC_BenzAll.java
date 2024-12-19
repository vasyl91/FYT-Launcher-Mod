package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_BenzAll;
import com.syu.ui.air.Air_0452_RZC_Beiqi_Bj90;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_BenzAll extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_DOW = 35;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_HORIZONTAL = 34;
    public static final int U_AIR_BLOW_MODE = 29;
    public static final int U_AIR_BLOW_UP = 33;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DISPLAY_FLAG = 32;
    public static final int U_AIR_DUAL = 22;
    public static final int U_AIR_END = 39;
    public static final int U_AIR_FLOW_MODE = 44;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_FRONT_MAX = 31;
    public static final int U_AIR_LEFTSEAT_HEAT = 24;
    public static final int U_AIR_LEFTSEAT_ICE = 25;
    public static final int U_AIR_POWER = 30;
    public static final int U_AIR_REAR = 28;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_REAR_POWER = 36;
    public static final int U_AIR_REAR_TEMP = 38;
    public static final int U_AIR_REAR_WIND_LEVEL = 37;
    public static final int U_AIR_REST = 43;
    public static final int U_AIR_RIGHTSEAT_HEAT = 26;
    public static final int U_AIR_RIGHTSEAT_ICE = 27;
    public static final int U_AIR_SHOW = 23;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CARASSIST_BEGIN = 40;
    public static final int U_CARASSIST_STATUS = 41;
    public static final int U_CARINF_D1_D1_B70 = 45;
    public static final int U_CARINF_D2_D1_B70 = 46;
    public static final int U_CARINF_D2_D2_B70 = 47;
    public static final int U_CARINF_D2_D3_B70 = 48;
    public static final int U_CARINF_D3_D1_B70 = 49;
    public static final int U_CARINF_D3_D2_B70 = 50;
    public static final int U_CARINF_D41_D80_B70 = 51;
    public static final int U_CARSET_D41_D80_D3_B70 = 52;
    public static final int U_CARSET_D41_D80_D4_B70 = 53;
    public static final int U_CNT_MAX = 54;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_RADARBEEP_STATUS = 42;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 54; i++) {
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
        if (DataCanbus.DATA[1000] == 7274948) {
            AirHelper.getInstance().buildUi(new Air_0452_RZC_Beiqi_Bj90(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 39; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[43].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            return;
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_BenzAll(LauncherApplication.getInstance()));
        for (int i5 = 10; i5 < 39; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 39; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 54) {
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
