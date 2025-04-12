package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XBS_Nissan_cedric extends CallbackCanbusBase {
    public static final int U_CARINF_D6B_D0_D1_D2_D3 = 98;
    public static final int U_CARINF_D6B_D4_D5 = 99;
    public static final int U_CARINF_D6B_D6_D7 = 100;
    public static final int U_CARINF_D6D_D0_B0 = 101;
    public static final int U_CARINF_D6D_D0_B1 = 102;
    public static final int U_CARINF_D6D_D0_B3 = 103;
    public static final int U_CARINF_D6D_D0_B4 = 104;
    public static final int U_CARINF_D6D_D1_B70 = 105;
    public static final int U_CARINF_D6D_D2_B70 = 106;
    public static final int U_CARINF_D93_D0_B70 = 107;
    public static final int U_CARINF_D93_D1_B70 = 108;
    public static final int U_CARINF_D93_D2_B70 = 109;
    public static final int U_CARINF_D93_D3_B70 = 110;
    public static final int U_CARINF_D93_D4_B70 = 111;
    public static final int U_CARINF_D93_D5_B70 = 112;
    public static final int U_CARINF_D93_D6_B70 = 113;
    public static final int U_CARINF_D93_D7_B70 = 114;
    public static final int U_CNT_MAX = 116;
    public static final int U_JUMP_SOS_PAGE = 115;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_XBS_Nissan_Cedric(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 115) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 116) {
            switch (updateCode) {
                case 115:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 116) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
