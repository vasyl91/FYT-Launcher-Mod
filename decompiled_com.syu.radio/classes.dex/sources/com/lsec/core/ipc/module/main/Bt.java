package com.lsec.core.ipc.module.main;

import android.content.ContentValues;
import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Bt extends IModuleCallback.Stub implements IConnStateListener {
    public static String sID3Album;
    public static String sId3Artist;
    public static String sId3Title;
    public static int sLastPhoneState;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Bt INSTANCE = new Bt();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[100];
    public static String sPhoneNumber = FinalChip.BSP_PLATFORM_Null;
    public static String sPhoneNumberHoldOn = FinalChip.BSP_PLATFORM_Null;
    public static String sDevName = FinalChip.BSP_PLATFORM_Null;
    public static String sPhoneName = FinalChip.BSP_PLATFORM_Null;
    public static String sDevPin = FinalChip.BSP_PLATFORM_Null;
    public static String sDevAddr = FinalChip.BSP_PLATFORM_Null;
    public static String sPhoneAddr = FinalChip.BSP_PLATFORM_Null;
    public static String sChoiceAddr = FinalChip.BSP_PLATFORM_Null;
    public static ContentValues values = new ContentValues();
    public static ContentValues values3rd = new ContentValues();

    private Bt() {
    }

    public static Bt getInstance() {
        return INSTANCE;
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void phoneNumber(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (IpcUtil.strsOk(strs, 2)) {
                if (strs[0] == null) {
                    sPhoneNumberHoldOn = FinalChip.BSP_PLATFORM_Null;
                } else {
                    sPhoneNumberHoldOn = strs[0];
                }
                if (strs[1] == null) {
                    sPhoneNumber = FinalChip.BSP_PLATFORM_Null;
                } else {
                    sPhoneNumber = strs[1];
                }
            } else {
                sPhoneNumberHoldOn = FinalChip.BSP_PLATFORM_Null;
                if (strs[0] == null) {
                    sPhoneNumber = FinalChip.BSP_PLATFORM_Null;
                } else {
                    sPhoneNumber = strs[0];
                }
            }
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void phoneName(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sPhoneName = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sPhoneName)) {
                sPhoneName = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void devName(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sDevName = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sDevName)) {
                sDevName = strs[0];
                sDevName = sDevName.replace("\n", FinalChip.BSP_PLATFORM_Null);
                sDevName = sDevName.replace("\r", FinalChip.BSP_PLATFORM_Null);
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void devPin(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sDevPin = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sDevPin)) {
                sDevPin = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void phoneAddr(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sPhoneAddr = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sPhoneAddr)) {
                sPhoneAddr = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void localAddr(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sDevAddr = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sDevAddr)) {
                sDevAddr = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Title(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sId3Title = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sId3Title)) {
                sId3Title = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Artist(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sId3Artist = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sId3Artist)) {
                sId3Artist = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Album(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                sID3Album = FinalChip.BSP_PLATFORM_Null;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            } else if (!strs[0].equals(sID3Album)) {
                sID3Album = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(2));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 0; i < 100; i++) {
                PROXY.register(callback, i, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onDisconnected() {
        PROXY.setRemoteModule(null);
    }

    private class Runnable_Update implements Runnable {
        public float[] flts;
        public int[] ints;
        public String[] strs;
        public int updateCode;

        public Runnable_Update(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.updateCode = updateCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.updateCode >= 0 && this.updateCode < 100) {
                switch (this.updateCode) {
                    case 0:
                        Bt.id3Title(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 1:
                        Bt.id3Artist(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 2:
                    case 11:
                    case 12:
                    case 13:
                    case 20:
                    case 21:
                    case 28:
                    case 29:
                        Bt.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 3:
                    case 4:
                        break;
                    case 5:
                    case 9:
                    case 10:
                    case 17:
                    case 18:
                    case 19:
                    case 23:
                    case 24:
                    case 25:
                    case 27:
                    default:
                        if (IpcUtil.intsOk(this.ints, 1) && this.ints[0] != Bt.DATA[this.updateCode]) {
                            if (this.updateCode == 9) {
                                Bt.sLastPhoneState = Bt.DATA[this.updateCode];
                            }
                            Bt.DATA[this.updateCode] = this.ints[0];
                        }
                        Bt.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 6:
                        Bt.phoneAddr(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 7:
                        Bt.phoneName(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 8:
                        Bt.phoneNumber(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 14:
                        Bt.localAddr(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 15:
                        Bt.devName(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 16:
                        Bt.devPin(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 22:
                        if (IpcUtil.strsOk(this.strs, 2)) {
                            Bt.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        }
                        break;
                    case 26:
                        Bt.id3Album(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                }
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
