package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.accord9.wc.Accord9HBackCamera;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0037_WC2_Accord9 extends CallbackCanbusBase {
    public static final int U_CAR_CAMERA_MODE = 4;
    public static final int U_CAR_RIGHTCAMERA_STATE = 2;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 1;
    public static final int U_CAR_SCREEN_COLOR = 3;
    public static final int U_CNT_MAX = 5;
    public static final int U_CURRENT_SPEED = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 5; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1021) {
            int value = ints[0];
            if (value == 1 && !Accord9HBackCamera.isFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.accord9.wc.Accord9HBackCamera");
                return;
            } else {
                if (value == 0 && Accord9HBackCamera.isFront && Accord9HBackCamera.mInstance != null) {
                    Accord9HBackCamera.mInstance.finish();
                    return;
                }
                return;
            }
        }
        if (updateCode >= 0 && updateCode < 5) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
