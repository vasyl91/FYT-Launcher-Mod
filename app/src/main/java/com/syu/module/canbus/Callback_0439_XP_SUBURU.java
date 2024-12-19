package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XP_SUBURU;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XP_SUBURU extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 21;
    public static final int U_AIR_MAXAC = 13;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 22;
    public static final int U_AIR_SHOW = 17;
    public static final int U_AIR_SYNC = 12;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_TEMP_UNIT = 23;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CAREQ_BAL = 42;
    public static final int U_CAREQ_BASS = 43;
    public static final int U_CAREQ_FAD = 41;
    public static final int U_CAREQ_MID = 44;
    public static final int U_CAREQ_SYS = 39;
    public static final int U_CAREQ_TREB = 45;
    public static final int U_CAREQ_VOL = 40;
    public static final int U_CARINFO_AUTO_LOCK = 35;
    public static final int U_CARINFO_AUTO_UNLOCK = 36;
    public static final int U_CARINFO_BEGIN = 25;
    public static final int U_CARINFO_CAR_STEER_BUTTON = 37;
    public static final int U_CARINFO_DEFOGGER = 31;
    public static final int U_CARINFO_END = 38;
    public static final int U_CARINFO_HAZARD_WARN = 33;
    public static final int U_CARINFO_INTERIOR_LIGHT = 30;
    public static final int U_CARINFO_LEFT_BLIND = 27;
    public static final int U_CARINFO_ONE_TOUCH = 32;
    public static final int U_CARINFO_PARK_SYS = 28;
    public static final int U_CARINFO_RAB_SYS = 29;
    public static final int U_CARINFO_RELOCK = 34;
    public static final int U_CARINFO_RIGHT_BLIND = 26;
    public static final int U_CNT_MAX = 47;
    public static final int U_JUMP_SOS_PAGE = 46;

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
        AirHelper.getInstance().buildUi(new Air_0439_XP_SUBURU(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 46:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 47) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 46) {
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
