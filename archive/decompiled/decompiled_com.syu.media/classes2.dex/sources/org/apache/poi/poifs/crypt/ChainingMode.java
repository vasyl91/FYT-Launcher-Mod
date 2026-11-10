package org.apache.poi.poifs.crypt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum ChainingMode {
    ecb("ECB", 1),
    cbc("CBC", 2),
    cfb("CFB8", 3);

    public final int ecmaId;
    public final String jceId;

    ChainingMode(String str, int i) {
        this.jceId = str;
        this.ecmaId = i;
    }
}
