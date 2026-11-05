package qin.x_core.client.java;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import qin.utils.Utils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class XCore implements XCoreRemote.OnInitListener {
    public final String a;
    public final SparseArray b = new SparseArray();
    public final XCoreRemote.OnInitListener c;
    public XCoreRemote remote;

    public static class BundleBuilder {
        public final Bundle a = new Bundle();

        public Bundle build() {
            return this.a;
        }

        public BundleBuilder enableAtOnce(boolean z) {
            this.a.putInt("atonce", z ? 1 : 0);
            return this;
        }

        public BundleBuilder putByteArray(byte... bArr) {
            this.a.putByteArray("byteArray", bArr);
            return this;
        }

        public BundleBuilder putCmdId(int i) {
            this.a.putInt("cmd_id", i);
            return this;
        }

        public BundleBuilder putCmdIds(int... iArr) {
            this.a.putIntArray("cmd_ids", iArr);
            return this;
        }

        public BundleBuilder putFloatArray(float... fArr) {
            this.a.putFloatArray("floatArray", fArr);
            return this;
        }

        public BundleBuilder putIntArray(int... iArr) {
            this.a.putIntArray("intArray", iArr);
            return this;
        }

        public BundleBuilder putIntArrayList(ArrayList<Integer> arrayList) {
            this.a.putIntegerArrayList("intList", arrayList);
            return this;
        }

        public BundleBuilder putLongArray(long... jArr) {
            this.a.putLongArray("longArray", jArr);
            return this;
        }

        public BundleBuilder putModule(int i) {
            this.a.putInt("module_id", i);
            return this;
        }

        public BundleBuilder putPackage(String str) {
            if (Utils.isEmptyStr(str)) {
                return this;
            }
            this.a.putString("package", str);
            return this;
        }

        public BundleBuilder putStringArray(String... strArr) {
            this.a.putStringArray("stringArray", strArr);
            return this;
        }

        public BundleBuilder putStringArrayList(ArrayList<String> arrayList) {
            this.a.putStringArrayList("stringList", arrayList);
            return this;
        }
    }

    public XCore(Context context, String str, String str2, String str3, XCoreRemote.OnInitListener onInitListener) {
        this.a = null;
        this.c = null;
        this.a = Utils.isEmptyStr(str) ? "com.syu.ms" : str;
        this.c = onInitListener;
        if (Utils.isEmptyStr(str) || Utils.isEmptyStr(str2)) {
            this.remote = new XCoreRemote(context, str3, null, null, this);
        } else {
            this.remote = new XCoreRemote(context, str3, str, str2, this);
        }
        this.remote.initSdk();
    }

    public static String appKeyOf(Bundle bundle) {
        return bundle.getString("app_key", "");
    }

    public static byte[] byteParamsOf(Bundle bundle) {
        return bundle.getByteArray("byteArray");
    }

    public static int cmdIdOf(Bundle bundle) {
        return bundle.getInt("cmd_id", -1);
    }

    public static int[] cmdIdsOf(Bundle bundle) {
        return bundle.getIntArray("cmd_ids");
    }

    public static float[] floatParamsOf(Bundle bundle) {
        return bundle.getFloatArray("floatArray");
    }

    public static ArrayList<Integer> intArrayListOf(Bundle bundle) {
        return bundle.getIntegerArrayList("intList");
    }

    public static int[] intParamsOf(Bundle bundle) {
        return bundle.getIntArray("intArray");
    }

    public static long[] longParamsOf(Bundle bundle) {
        return bundle.getLongArray("longArray");
    }

    public static int moduleOf(Bundle bundle) {
        return bundle.getInt("module_id", -1);
    }

    public static String packageOf(Bundle bundle) {
        return bundle.getString("package", "");
    }

    public static ArrayList<String> stringArrayListOf(Bundle bundle) {
        return bundle.getStringArrayList("stringList");
    }

    public static String[] stringParamsOf(Bundle bundle) {
        return bundle.getStringArray("stringArray");
    }

    public boolean addObserver(DataObserver dataObserver) {
        this.remote.addDataObserver(dataObserver);
        return isConnected();
    }

    public void command(int i, int i2, byte... bArr) {
        command(i, i2, null, null, bArr, null, null, null);
    }

    public void commandIntegerList(int i, int i2, ArrayList<Integer> arrayList) {
        command(i, i2, null, null, null, null, arrayList, null);
    }

    public void commandStringList(int i, int i2, ArrayList<String> arrayList) {
        command(i, i2, null, null, null, null, null, arrayList);
    }

    public void commandValue(int i, int i2, float... fArr) {
        command(i, i2, fArr, null, null, null, null, null);
    }

    public boolean isConnected() {
        XCoreRemote xCoreRemote = this.remote;
        if (xCoreRemote == null) {
            return false;
        }
        return xCoreRemote.isConnected();
    }

    public boolean observeModule(int i, int... iArr) {
        ArrayList arrayList = (ArrayList) this.b.get(i, null);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.put(i, arrayList);
        }
        for (int i2 : iArr) {
            if (!arrayList.contains(Integer.valueOf(i2))) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        boolean zIsConnected = isConnected();
        if (zIsConnected) {
            this.remote.observe(i, iArr);
        }
        return zIsConnected;
    }

    @Override // qin.x_core.client.java.XCoreRemote.OnInitListener
    public void onConnected(String str, Boolean bool) {
        Log.e("XCore", "==> onConnected service: " + str + " isConnected: " + bool);
        if (Utils.equals(str, this.a) && bool.booleanValue()) {
            if (this.b.size() > 0) {
                for (int i = 0; i < this.b.size(); i++) {
                    int iKeyAt = this.b.keyAt(i);
                    List list = (List) this.b.get(iKeyAt, null);
                    if (list != null) {
                        int[] iArr = new int[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            iArr[i2] = ((Integer) list.get(i2)).intValue();
                        }
                        this.remote.observe(iKeyAt, iArr);
                    }
                }
            }
            XCoreRemote.OnInitListener onInitListener = this.c;
            if (onInitListener != null) {
                onInitListener.onConnected(str, bool);
            }
        }
    }

    @Override // qin.x_core.client.java.XCoreRemote.OnInitListener
    public void onLicensed(String str, Boolean bool) {
        Log.e("XCore", "==> onLicensed service: " + str + " license: " + bool);
        XCoreRemote.OnInitListener onInitListener = this.c;
        if (onInitListener != null) {
            onInitListener.onLicensed(str, bool);
        }
    }

    public boolean removeObserver(DataObserver dataObserver) {
        this.remote.removeDataObserver(dataObserver);
        return isConnected();
    }

    public void command(int i, int i2, float[] fArr, String[] strArr, byte[] bArr, int[] iArr, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        XCoreRemote xCoreRemote = this.remote;
        if (xCoreRemote != null) {
            xCoreRemote.command(i, i2, fArr, strArr, bArr, iArr, arrayList, arrayList2);
        }
    }

    public void commandValue(int i, int i2, int... iArr) {
        command(i, i2, null, null, null, iArr, null, null);
    }

    public void command(int i, int i2, String... strArr) {
        command(i, i2, null, strArr, null, null, null, null);
    }
}
