package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0022_XP1_Focus2012;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0022_XP1_Focus2012 extends CallbackCanbusBase {
    public static final int U_AUTO_REQUEST = 98;
    public static final int U_BT_STATE = 91;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_END = 100;
    public static final int U_CARSET_BRIGHTNESS = 106;
    public static final int U_CARSET_D24_D1_B6 = 113;
    public static final int U_CARSET_D24_D1_B7 = 114;
    public static final int U_CARSET_D24_D3_B20 = 116;
    public static final int U_CARSET_D24_D3_B53 = 115;
    public static final int U_CARSET_D24_D5_B2 = 117;
    public static final int U_CARSET_D24_D5_B3 = 118;
    public static final int U_CARSET_D24_D5_B5 = 119;
    public static final int U_CARSET_D24_D5_B6 = 120;
    public static final int U_CARSET_D27_B70 = 121;
    public static final int U_CARSET_INFORMATION = 104;
    public static final int U_CARSET_INTERIORLIGHTING = 110;
    public static final int U_CARSET_RAINSENSOR = 112;
    public static final int U_CARSET_TOWSYSTEM = 103;
    public static final int U_CARSET_TURNLIGHT = 109;
    public static final int U_CARSET_TYREMONITOR = 111;
    public static final int U_CARSET_UNIT = 107;
    public static final int U_CARSET_VOICEMODE = 108;
    public static final int U_CARSET_WARNING = 105;
    public static final int U_CAR_ENGINE_SPEED = 102;
    public static final int U_CAR_SPEED = 101;
    public static final int U_CAR_WARN = 99;
    public static final int U_CNT_MAX = 122;
    public static final int U_CUR_WORK_MODE = 95;
    public static final int U_DISPLAY_MODE = 90;
    public static final int U_LINE_GROUP = 88;
    public static final int U_LIST_INFO = 93;
    public static final int U_MODE_STATE = 96;
    public static final int U_PARM_WARM = 92;
    public static final int U_PHONE_STATE = 97;
    public static final int U_PHONE_TIME = 94;
    public static final int U_PLAY_TIME = 89;
    public static final int U_SCREEN_ICON = 87;
    public static final int U_SCREEN_ID = 86;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 34;
        DoorHelper.sUcDoorFl = 29;
        DoorHelper.sUcDoorFr = 30;
        DoorHelper.sUcDoorRl = 31;
        DoorHelper.sUcDoorRr = 32;
        DoorHelper.sUcDoorBack = 33;
        AirHelper.getInstance().buildUi(new Air_0022_XP1_Focus2012(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 37; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 87 || updateCode == 88 || updateCode == 93 || updateCode == 99 || updateCode == 98) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        } else if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
