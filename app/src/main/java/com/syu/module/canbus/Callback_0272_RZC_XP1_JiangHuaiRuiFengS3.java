package com.syu.module.canbus;

import android.content.SharedPreferences;
import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.ruifengs3.JhRuiFengS3TireAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0272_RZC_JiangHuai_S3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0272_RZC_XP1_JiangHuaiRuiFengS3 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 19;
    public static final int U_AIR_BLOW_MODE = 21;
    public static final int U_AIR_BLOW_UP_LEFT = 18;
    public static final int U_AIR_BLOW_WIN_LEFT = 20;
    public static final int U_AIR_CYCLE = 15;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_REAR_DEFROST = 16;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 22;
    public static final int U_CAR_AUTOLOCK = 35;
    public static final int U_CAR_INTERLIGHT = 34;
    public static final int U_CAR_LOCALIGHT = 37;
    public static final int U_CAR_OUTLIGHT = 33;
    public static final int U_CAR_PROMPTLL = 36;
    public static final int U_CAR_TISHIVOL = 32;
    public static final int U_CNT_MAX = 38;
    public static final int U_DOOR_BACK = 30;
    public static final int U_DOOR_BEGIN = 25;
    public static final int U_DOOR_END = 31;
    public static final int U_DOOR_ENGINE = 25;
    public static final int U_DOOR_FL = 26;
    public static final int U_DOOR_FR = 27;
    public static final int U_DOOR_RL = 28;
    public static final int U_DOOR_RR = 29;
    public static final int U_PRESSURE_FL = 1;
    public static final int U_PRESSURE_FR = 2;
    public static final int U_PRESSURE_RL = 3;
    public static final int U_PRESSURE_RR = 4;
    public static final int U_TEMP_FL = 5;
    public static final int U_TEMP_FR = 6;
    public static final int U_TEMP_RL = 7;
    public static final int U_TEMP_RR = 8;
    public static final int U_WARNING_FL = 9;
    public static final int U_WARNING_FR = 10;
    public static final int U_WARNING_RL = 11;
    public static final int U_WARNING_RR = 12;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        JhRuiFengS3TireAct.bNotShowingWarning = getShowWarningConfig();
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 38; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 25;
        DoorHelper.sUcDoorFl = 26;
        DoorHelper.sUcDoorFr = 27;
        DoorHelper.sUcDoorRl = 28;
        DoorHelper.sUcDoorRr = 29;
        DoorHelper.sUcDoorBack = 30;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 25; i2 < 31; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0272_RZC_JiangHuai_S3(LauncherApplication.getInstance()));
        for (int i3 = 13; i3 < 25; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 25; i < 31; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 13; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    boolean getShowWarningConfig() {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0272RuiFengS3", 0);
        if (sp == null) {
            return false;
        }
        boolean b = sp.getBoolean("showwarning", false);
        return b;
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 38) {
            HandlerCanbus.update(updateCode, ints);
            if ((updateCode == 12 || updateCode == 11 || updateCode == 10 || updateCode == 9) && !JhRuiFengS3TireAct.bNotShowingWarning) {
                if ((DataCanbus.DATA[12] != 0 || DataCanbus.DATA[11] != 0 || DataCanbus.DATA[10] != 0 || DataCanbus.DATA[9] != 0) && !JhRuiFengS3TireAct.bFront) {
                    try {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.ruifengs3.JhRuiFengS3IndexAct");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
