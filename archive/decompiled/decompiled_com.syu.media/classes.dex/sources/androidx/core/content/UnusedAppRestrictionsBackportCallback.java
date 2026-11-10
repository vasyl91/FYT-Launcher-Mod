package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.mCallback = iUnusedAppRestrictionsBackportCallback;
    }

    public void onResult(boolean z, boolean z2) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(z, z2);
    }
}
