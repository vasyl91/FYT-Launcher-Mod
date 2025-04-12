package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.klc.KlcGl8AirControlAct;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.carinfo.xp.yinglang.KlcGl8_263_AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0263_XP1_15YingLang extends CallbackCanbusBase {
    public static final int U_AUTODRIVER_STARTTIP = 187;
    public static final int U_CNT_MAX = 197;
    public static final int U_D43_D1_B70 = 195;
    public static final int U_D4A_D1_D2 = 193;
    public static final int U_D4A_D3_D4 = 194;
    public static final int U_RAMP_ASSIST = 192;
    public static final int U_REAR_AIR_POWER = 188;
    public static final int U_REAR_SHOW_AIR = 196;
    public static final int U_REMOTE_POWER_AIR = 189;
    public static final int U_REMOTE_POWER_SEATBLOW = 190;
    public static final int U_REMOTE_POWER_SEATHEAT = 191;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 197; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65799) {
            //AirHelper.getInstance().buildUi(new Air_0263_RZC_FLB_Saiou3(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 721159 || DataCanbus.DATA[1000] == 786695 || DataCanbus.DATA[1000] == 393479) {
            //AirHelper.getInstance().buildUi(new Air_0263_RZC_GL8(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0263_RZC_XP1_15YingLang(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 115:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    break;
                }
            case 196:
                if (ints[0] > 0 && !KlcGl8_263_AirControlAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.KlcGl8_263_AirControlAct");
                    break;
                } else if (ints[0] == 0 && KlcGl8AirControlAct.mIsFront && KlcGl8_263_AirControlAct.mInstance != null) {
                    KlcGl8_263_AirControlAct.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 197) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
