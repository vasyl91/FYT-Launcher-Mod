package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_BNR_HavaH6;
import com.syu.ui.air.Air_0439_BNR_Haval_H9;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_BNR_Haval_H6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE_LEFT = 18;
    public static final int U_AIR_BLOW_WIN_LEFT = 15;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_AUTO = 70;
    public static final int U_AIR_REAR_BODY = 71;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_REAR_FOOT = 72;
    public static final int U_AIR_REAR_POWER = 69;
    public static final int U_AIR_REAR_TEMP = 74;
    public static final int U_AIR_REAR_WIND_LEVEL = 73;
    public static final int U_AIR_TEMP_LEFT = 67;
    public static final int U_AIR_TEMP_RIGHT = 68;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CARINFO2_ALTITUDE = 65;
    public static final int U_CARINFO_D10_D0_D1 = 35;
    public static final int U_CARINFO_D10_D2_B70 = 36;
    public static final int U_CARINFO_D10_D3_B70 = 37;
    public static final int U_CARINFO_D10_D4_B70 = 38;
    public static final int U_CARINFO_D10_D5_B70 = 39;
    public static final int U_CARINFO_D10_D6_B70 = 40;
    public static final int U_CARINFO_D11_D0_B70 = 41;
    public static final int U_CARINFO_D11_D1_B70 = 42;
    public static final int U_CARINFO_D11_D2_B70 = 43;
    public static final int U_CARINFO_D12_D0_B70 = 44;
    public static final int U_CARINFO_D12_D1_B70 = 45;
    public static final int U_CARINFO_D12_D2_B70 = 46;
    public static final int U_CARINFO_D12_D3_B70 = 47;
    public static final int U_CARINFO_D12_D4_B70 = 48;
    public static final int U_CARINFO_D13_D0_B30 = 50;
    public static final int U_CARINFO_D13_D0_B74 = 49;
    public static final int U_CARINFO_D13_D1_B30 = 52;
    public static final int U_CARINFO_D13_D1_B74 = 51;
    public static final int U_CARINFO_D13_D2_B30 = 54;
    public static final int U_CARINFO_D13_D2_B74 = 53;
    public static final int U_CARINFO_D13_D3_B30 = 56;
    public static final int U_CARINFO_D13_D3_B74 = 55;
    public static final int U_CARINFO_D31_D0_B70 = 57;
    public static final int U_CARINFO_D31_D1_B70 = 58;
    public static final int U_CARINFO_D31_D2_B70 = 59;
    public static final int U_CARINFO_D31_D3_B70 = 60;
    public static final int U_CARINFO_D31_D4_B70 = 61;
    public static final int U_CARINFO_D31_D5_B70 = 62;
    public static final int U_CARINFO_D31_D6_B70 = 63;
    public static final int U_CARINFO_D31_D7_B70 = 64;
    public static final int U_CARINFO_D4_D3_B0 = 24;
    public static final int U_CARINFO_D4_D3_B1 = 25;
    public static final int U_CARINFO_D4_D4_B10 = 26;
    public static final int U_CARINFO_D4_D4_B2 = 27;
    public static final int U_CARINFO_D4_D4_B3 = 28;
    public static final int U_CARINFO_D4_D4_B4 = 29;
    public static final int U_CARINFO_D4_D4_B5 = 30;
    public static final int U_CARINFO_D4_D4_B6 = 31;
    public static final int U_CARINFO_D4_D5_B0 = 32;
    public static final int U_CARINFO_D4_D5_B1 = 33;
    public static final int U_CARINFO_D4_D5_B2 = 34;
    public static final int U_CARINFO_DOMEDELAY = 21;
    public static final int U_CARINFO_FOLLOWHOME = 22;
    public static final int U_CARINFO_POWERSAVE = 23;
    public static final int U_CNT_MAX = 75;
    public static final int U_JUMP_CARSEAT_SET = 66;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 75; i++) {
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
        if (DataCanbus.DATA[1000] == 16384439) {
            AirHelper.getInstance().buildUi(new Air_0439_BNR_Haval_H9(LauncherApplication.getInstance()));
            for (int i3 = 7; i3 < 20; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i4 = 67; i4 <= 74; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        AirHelper.getInstance().buildUi(new Air_0439_BNR_HavaH6(LauncherApplication.getInstance()));
        for (int i5 = 7; i5 < 20; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 20; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void showCotrolSeat(int updateCode, int[] ints) {
        if (updateCode == 66) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !BNRActivityHavaH8SeatSetAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct");
            } else if (BNRActivityHavaH8SeatSetAct.mIsFront && BNRActivityHavaH8SeatSetAct.mInstance != null) {
                BNRActivityHavaH8SeatSetAct.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 75) {
            switch (updateCode) {
                case 66:
                    showCotrolSeat(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
