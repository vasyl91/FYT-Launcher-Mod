package qin.x_core.client.java;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import qin.x_core.aidl.IModule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class Proxy {
    public final Context a;
    public final IModule b;
    public final RemoteCallback c;

    public Proxy(Context context, IModule iModule, RemoteCallback remoteCallback) {
        this.b = null;
        this.c = null;
        this.a = context;
        this.b = iModule;
        this.c = remoteCallback;
    }

    public void command(int i, float[] fArr, String[] strArr, byte[] bArr, int[] iArr, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        try {
            Log.e("XCore", "XCore command module:" + this.b.id() + " cmdId: " + i + " ints: " + Arrays.toString(iArr));
            if (this.b != null) {
                XCore.BundleBuilder bundleBuilderPutCmdId = new XCore.BundleBuilder().putPackage(this.a.getPackageName()).putModule(this.b.id()).putCmdId(i);
                bundleBuilderPutCmdId.putIntArray(iArr);
                bundleBuilderPutCmdId.putFloatArray(fArr);
                bundleBuilderPutCmdId.putStringArray(strArr);
                bundleBuilderPutCmdId.putByteArray(bArr);
                bundleBuilderPutCmdId.putIntArrayList(arrayList);
                bundleBuilderPutCmdId.putStringArrayList(arrayList2);
                this.b.command(bundleBuilderPutCmdId.build());
            }
        } catch (Exception unused) {
        }
    }

    public Bundle valueOf(int i, int i2, int... iArr) {
        try {
            return this.b.valueOf(new XCore.BundleBuilder().putPackage(this.a.getPackageName()).putModule(this.b.id()).putCmdIds(i).putIntArray(iArr).build());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
