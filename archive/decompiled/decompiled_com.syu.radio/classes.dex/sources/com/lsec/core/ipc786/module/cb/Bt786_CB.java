package com.lsec.core.ipc786.module.cb;

import android.os.RemoteException;
import com.lsec.core.ipc.module.main.Bt;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc786.module.Bt786;
import com.lsec.core.util.IpcUtil;
import com.syu.ipc.ICallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Bt786_CB extends ICallback.Stub {
    private static Bt786_CB INSTANCE = new Bt786_CB();

    public static Bt786_CB getInstance() {
        return INSTANCE;
    }

    @Override // com.syu.ipc.ICallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
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
            switch (this.updateCode) {
                case 4:
                case 9:
                case 11:
                case 12:
                case 23:
                    Bt786.update(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 5:
                    Bt786.phoneNumber(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 6:
                    Bt786.devName(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 7:
                case 10:
                case 16:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                default:
                    if (IpcUtil.intsOk(this.ints, 1) && this.updateCode < 50 && this.ints[0] != Bt.DATA[this.updateCode]) {
                        if (this.updateCode == 1) {
                            Bt.sLastPhoneState = Bt.DATA[this.updateCode];
                        }
                        Bt.DATA[this.updateCode] = this.ints[0];
                    }
                    Bt.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 8:
                    Bt786.devPin(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 13:
                    if (IpcUtil.strsOk(this.strs, 2)) {
                        Bt.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                    }
                    break;
                case 14:
                    Bt786.phoneName(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 15:
                    Bt786.localAddr(this.updateCode, this.ints, this.flts, this.strs);
                    break;
                case 17:
                    Bt786.phoneAddr(this.updateCode, this.ints, this.flts, this.strs);
                    break;
            }
        }
    }
}
