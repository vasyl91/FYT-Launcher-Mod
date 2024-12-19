package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.klc.KlcGl8AirControlAct;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.carinfo.xp.yinglang.KlcGl8_263_AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0263_RZC_FLB_Saiou3;
import com.syu.ui.air.Air_0263_RZC_GL8;
import com.syu.ui.air.Air_0263_RZC_XP1_15YingLang;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0263_XP1_15YingLang extends CallbackCanbusBase {
    public static final int U_AC_AUTO = 295;
    public static final int U_AIR_END = 112;
    public static final int U_AUTODRIVER_STARTTIP = 281;
    public static final int U_CNT_MAX = 302;
    public static final int U_D43_D1_B70 = 301;
    public static final int U_D4A_D1_D2 = 299;
    public static final int U_D4A_D3_D4 = 300;
    public static final int U_FRONT_BLOW_MODE = 293;
    public static final int U_GL8_AIR_END = 297;
    public static final int U_GL8_AIR_START = 286;
    public static final int U_GL8_END = 301;
    public static final int U_GL8_START = 280;
    public static final int U_RAMP_ASSIST = 298;
    public static final int U_REAR_AIR_POWER = 282;
    public static final int U_REAR_BLOW_AUTO = 288;
    public static final int U_REAR_BLOW_FOOT = 290;
    public static final int U_REAR_BLOW_MODE = 291;
    public static final int U_REAR_BLOW_UP = 289;
    public static final int U_REAR_SHOW_AIR = 292;
    public static final int U_REAR_TEMP = 287;
    public static final int U_REAR_WIND_LEVEL = 294;
    public static final int U_REMOTE_POWER_AIR = 283;
    public static final int U_REMOTE_POWER_SEATBLOW = 284;
    public static final int U_REMOTE_POWER_SEATHEAT = 285;
    public static final int U_WIND_LEVEL_LEFT_AUTO = 296;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 302; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 113;
        DoorHelper.sUcDoorFl = 114;
        DoorHelper.sUcDoorFr = 115;
        DoorHelper.sUcDoorRl = 116;
        DoorHelper.sUcDoorRr = 117;
        DoorHelper.sUcDoorBack = 118;
        if (DataCanbus.DATA[1000] == 65799) {
            AirHelper.getInstance().buildUi(new Air_0263_RZC_FLB_Saiou3(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 721159 || DataCanbus.DATA[1000] == 786695 || DataCanbus.DATA[1000] == 393479) {
            AirHelper.getInstance().buildUi(new Air_0263_RZC_GL8(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0263_RZC_XP1_15YingLang(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 113; i2 < 119; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 87; i3 < 112; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i4 = 286; i4 < 297; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 113; i < 119; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 112; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 286; i3 < 297; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
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
                    break;
                }
            case 292:
                if (ints[0] > 0 && !KlcGl8_263_AirControlAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.KlcGl8_263_AirControlAct");
                    break;
                } else if (ints[0] == 0 && KlcGl8AirControlAct.mIsFront && KlcGl8_263_AirControlAct.mInstance != null) {
                    KlcGl8_263_AirControlAct.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 302) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
