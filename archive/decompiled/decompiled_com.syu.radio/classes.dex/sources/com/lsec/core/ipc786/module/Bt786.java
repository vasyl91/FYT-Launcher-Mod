package com.lsec.core.ipc786.module;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.lsec.core.ipc.IConn;
import com.lsec.core.ipc.module.main.Bt;
import com.lsec.core.ipc786.module.cb.Bt786_CB;
import com.lsec.core.util.InterfaceApp;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.ICallback;
import com.syu.ipc.IRegisterCallBack;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Bt786 extends IConn {
    public static IRegisterCallBack mRegisterCallBack = null;
    public static String ACTION_BT_CONNECT_SERVER = "com.syu.ms.bt";
    public static Bt786 hInstance = null;

    public Bt786(InterfaceApp interfaceApp, Context context, IRegisterCallBack registerCallBack) {
        super(interfaceApp, context);
        initAction(ACTION_BT_CONNECT_SERVER);
        hInstance = this;
        mRegisterCallBack = registerCallBack;
    }

    @Override // com.lsec.core.ipc.IConn, android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        super.onServiceConnected(name, service);
        ICallback callback = Bt786_CB.getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 0; i < 50; i++) {
            if (i == 29) {
                registerCallback(callback, i, false);
            } else {
                registerCallback(callback, i, true);
            }
        }
    }

    public static void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && Bt.DATA[updateCode] != ints[0]) {
            Bt.DATA[updateCode] = ints[0];
            Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void phoneNumber(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sPhoneNumber = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sPhoneNumber)) {
                Bt.sPhoneNumber = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void devPin(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sDevPin = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sDevPin)) {
                Bt.sDevPin = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void devName(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sDevName = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sDevName)) {
                Bt.sDevName = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void phoneName(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sPhoneName = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sPhoneName)) {
                Bt.sPhoneName = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void localAddr(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sDevAddr = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sDevAddr)) {
                Bt.sDevAddr = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void phoneAddr(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                Bt.sPhoneAddr = FinalChip.BSP_PLATFORM_Null;
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(Bt.sPhoneAddr)) {
                Bt.sPhoneAddr = strs[0];
                Bt.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void cmdStatic(int cmdCode, int[] intData, float[] fltData, String[] strData) {
        if (hInstance != null) {
            hInstance.cmd(cmdCode, intData, fltData, strData);
        }
    }

    public static void cmdBt(int cmd, int value, String str) {
        if (str != null) {
            cmdStatic(cmd, null, null, new String[]{str});
            return;
        }
        if (str == null && value == -2) {
            cmdStatic(cmd, null, null, null);
        } else if (str == null && value != -2) {
            cmdStatic(cmd, new int[]{value}, null, null);
        }
    }
}
