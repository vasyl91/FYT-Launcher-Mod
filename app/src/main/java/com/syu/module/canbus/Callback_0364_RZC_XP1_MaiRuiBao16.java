package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.carinfo.xp.yinglang.XpMrbAirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0364_RZC_XP1_MaiRuiBao16 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 191;
    public static final int U_JUMP_AIRCONTRL = 190;
    public static final int U_RAMP_ASSIST = 189;
    public static final int U_WIFI_NAME = 187;
    public static final int U_WIFI_PSWORD = 188;
    public static String WifiName;
    public static String WifiPsword;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 191; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0359_XP1_16mairuibao(LauncherApplication.getInstance()));
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
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 187:
                if (strs != null && strs.length > 0) {
                    WifiName = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 188:
                if (strs != null && strs.length > 0) {
                    WifiPsword = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 190:
                int value = ints[0];
                if (value == 1 && !XpMrbAirControlAct.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.XpMrbAirControlAct");
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 191) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
