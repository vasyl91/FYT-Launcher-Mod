package com.lsec.core.util;

import android.os.RemoteException;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class UiNotifyEventString extends UiNotifyEvent {
    private String mValue = FinalChip.BSP_PLATFORM_Null;
    private IModuleCallback mCallback = new IModuleCallback.Stub() { // from class: com.lsec.core.util.UiNotifyEventString.1
        @Override // com.syu.ipc.IModuleCallback
        public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
            if (strs != null && strs.length > 0) {
                String value = strs[0];
                if (value == null) {
                    if (UiNotifyEventString.this.mValue != null) {
                        UiNotifyEventString.this.mValue = value;
                        UiNotifyEventString.this.updateNotify(updateCode, ints, flts, strs);
                        return;
                    }
                    return;
                }
                if (!value.equals(UiNotifyEventString.this.mValue)) {
                    UiNotifyEventString.this.mValue = value;
                    UiNotifyEventString.this.updateNotify(updateCode, ints, flts, strs);
                }
            }
        }
    };

    public String getValue() {
        return this.mValue;
    }

    public void register(IRemoteToolkit toolkit, int moduleCode, int updateCode, int update) {
        try {
            IRemoteModule module = toolkit.getRemoteModule(moduleCode);
            module.register(this.mCallback, updateCode, update);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
