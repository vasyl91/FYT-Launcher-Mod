package com.lsec.core.ipc786.module.cb;

import android.os.RemoteException;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc786.module.Main786;
import com.lsec.core.util.IpcUtil;
import com.syu.ipc.ICallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Main786_CB extends ICallback.Stub {
    private static Main786_CB INSTANCE = new Main786_CB();

    public static Main786_CB getInstance() {
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
            if (this.updateCode >= 0 && this.updateCode < 100) {
                switch (this.updateCode) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 11:
                    case 16:
                    case 25:
                        Main786.update(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Main.DATA[this.updateCode] = this.ints[0];
                        }
                        Main.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                }
            }
        }
    }
}
