package net.lingala.zip4j.io;

import com.lsec.core.frame.app.Zip4jUtilFunc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipJni {
    private static ZipJni INSTANCE;
    private static boolean bLoadOnce = false;

    public native void decryptData(int[] iArr, byte[] bArr, int i, int i2);

    public native void initKeyByTxt(String str, Zip4jUtilFunc zip4jUtilFunc);

    public native void initKeyDefault();

    public native void initKeys(int[] iArr, byte[] bArr, String str, int i);

    private ZipJni() {
    }

    public static ZipJni getInstance() {
        if (INSTANCE == null && !bLoadOnce) {
            bLoadOnce = true;
            try {
                System.loadLibrary("ZipUtil");
                INSTANCE = new ZipJni();
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
            } catch (Throwable th) {
            }
        }
        return INSTANCE;
    }
}
