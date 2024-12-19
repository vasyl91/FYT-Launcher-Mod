package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_Baogu_Renault extends CallbackCanbusBase {
    public static final int U_AIR_AC = 7;
    public static final int U_AIR_AUTO = 9;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_CYCLE_AUTO = 19;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_SEAT_BLOW_LEFT = 22;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 23;
    public static final int U_AIR_SEAT_HEAT_LEFT = 20;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 21;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_MODE = 24;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND_LEVEL_LEFT = 16;
    public static final int U_CARINFO_BEGIN = 26;
    public static final int U_CARINFO_D71_D0_B0 = 31;
    public static final int U_CARINFO_D71_D0_B1 = 30;
    public static final int U_CARINFO_D71_D0_B2 = 29;
    public static final int U_CARINFO_D71_D0_B3 = 28;
    public static final int U_CARINFO_D71_D0_B54 = 27;
    public static final int U_CARINFO_D71_D10_B30 = 55;
    public static final int U_CARINFO_D71_D10_B65 = 54;
    public static final int U_CARINFO_D71_D10_B7 = 53;
    public static final int U_CARINFO_D71_D11_B4 = 59;
    public static final int U_CARINFO_D71_D11_B5 = 58;
    public static final int U_CARINFO_D71_D11_B6 = 57;
    public static final int U_CARINFO_D71_D11_B7 = 56;
    public static final int U_CARINFO_D71_D12_B0 = 60;
    public static final int U_CARINFO_D71_D1_B10 = 34;
    public static final int U_CARINFO_D71_D1_B2 = 33;
    public static final int U_CARINFO_D71_D1_B3 = 32;
    public static final int U_CARINFO_D71_D2_B10 = 41;
    public static final int U_CARINFO_D71_D2_B2 = 40;
    public static final int U_CARINFO_D71_D2_B3 = 39;
    public static final int U_CARINFO_D71_D2_B4 = 38;
    public static final int U_CARINFO_D71_D2_B5 = 37;
    public static final int U_CARINFO_D71_D2_B6 = 36;
    public static final int U_CARINFO_D71_D2_B7 = 35;
    public static final int U_CARINFO_D71_D3_B70 = 42;
    public static final int U_CARINFO_D71_D4_B70 = 43;
    public static final int U_CARINFO_D71_D5_B70 = 44;
    public static final int U_CARINFO_D71_D6_B70 = 45;
    public static final int U_CARINFO_D71_D7_B6 = 47;
    public static final int U_CARINFO_D71_D7_B7 = 46;
    public static final int U_CARINFO_D71_D8_B20 = 51;
    public static final int U_CARINFO_D71_D8_B5 = 50;
    public static final int U_CARINFO_D71_D8_B6 = 49;
    public static final int U_CARINFO_D71_D8_B7 = 48;
    public static final int U_CARINFO_D71_D9_B70 = 52;
    public static final int U_CARINFO_D81_AVG_FUEL = 61;
    public static final int U_CARINFO_D81_AVG_SPEED = 62;
    public static final int U_CARINFO_D81_DRIVED_MILE = 63;
    public static final int U_CARINFO_END = 64;
    public static final int U_CNT_MAX = 66;
    public static final int U_JUMP_SOS_PAGE = 65;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 66; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 65) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 65:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 66) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
