package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0025_DJ_Saiou3;
import com.syu.ui.air.Air_0025_XP1_GM_H;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0025_XP1_GM_H extends CallbackCanbusBase {
    public static final int U_AIR_AC = 93;
    public static final int U_AIR_AC_MAX = 94;
    public static final int U_AIR_AQS_ON = 108;
    public static final int U_AIR_AUTO = 88;
    public static final int U_AIR_AUTO_WIN = 133;
    public static final int U_AIR_BEGIN = 87;
    public static final int U_AIR_BLOW_AUTO_LEFT = 110;
    public static final int U_AIR_BLOW_BODY_LEFT = 100;
    public static final int U_AIR_BLOW_BODY_RIGHT = 104;
    public static final int U_AIR_BLOW_FOOT_LEFT = 101;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 105;
    public static final int U_AIR_BLOW_UP_LEFT = 99;
    public static final int U_AIR_BLOW_UP_RIGHT = 103;
    public static final int U_AIR_BLOW_WIND_LEFT = 111;
    public static final int U_AIR_CYCLE = 89;
    public static final int U_AIR_DUAL = 87;
    public static final int U_AIR_ECO_ON = 109;
    public static final int U_AIR_END = 112;
    public static final int U_AIR_FRONT_DEFROST = 91;
    public static final int U_AIR_POWER_ON = 107;
    public static final int U_AIR_REAR_DEFROST = 92;
    public static final int U_AIR_SEAT_HEAT_LEFT = 95;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 96;
    public static final int U_AIR_SHOW = 90;
    public static final int U_AIR_TEMP_LEFT = 97;
    public static final int U_AIR_TEMP_RIGHT = 98;
    public static final int U_AIR_WIND_LEVEL_LEFT = 102;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 106;
    public static final int U_CNT_MAX = 134;
    public static final int U_REAR_AIR_AUTO = 128;
    public static final int U_REAR_AIR_BEGIN = 124;
    public static final int U_REAR_AIR_BLOW_FOOT = 126;
    public static final int U_REAR_AIR_BLOW_HEAD = 127;
    public static final int U_REAR_AIR_BLOW_MODE = 130;
    public static final int U_REAR_AIR_END = 132;
    public static final int U_REAR_AIR_POWER = 125;
    public static final int U_REAR_AIR_TEMP_LEFT = 129;
    public static final int U_REAR_AIR_WIND_LEVEL = 131;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 134; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 113;
        DoorHelper.sUcDoorFl = 114;
        DoorHelper.sUcDoorFr = 115;
        DoorHelper.sUcDoorRl = 116;
        DoorHelper.sUcDoorRr = 117;
        DoorHelper.sUcDoorBack = 118;
        if (DataCanbus.DATA[1000] == 2359321) {
            for (int i2 = 87; i2 < 112; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            AirHelper.getInstance().buildUi(new Air_0025_DJ_Saiou3(LauncherApplication.getInstance()));
        } else {
            for (int i3 = 87; i3 < 112; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            AirHelper.getInstance().buildUi(new Air_0025_XP1_GM_H(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 113; i4 < 119; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 113; i < 119; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        if (DataCanbus.sCanbusId == 2162713) {
            for (int i2 = 124; i2 < 132; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        } else if (DataCanbus.sCanbusId == 2359321) {
            for (int i3 = 87; i3 < 112; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        } else {
            for (int i4 = 87; i4 < 112; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 18:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 134) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
