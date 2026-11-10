package org.apache.commons.codec.digest;

import org.apache.commons.codec.Charsets;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Crypt {
    public static String crypt(byte[] bArr) {
        return crypt(bArr, (String) null);
    }

    public static String crypt(byte[] bArr, String str) {
        if (str == null) {
            return Sha2Crypt.sha512Crypt(bArr);
        }
        if (str.startsWith("$6$")) {
            return Sha2Crypt.sha512Crypt(bArr, str);
        }
        if (str.startsWith("$5$")) {
            return Sha2Crypt.sha256Crypt(bArr, str);
        }
        if (str.startsWith("$1$")) {
            return Md5Crypt.md5Crypt(bArr, str);
        }
        return UnixCrypt.crypt(bArr, str);
    }

    public static String crypt(String str) {
        return crypt(str, (String) null);
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(Charsets.UTF_8), str2);
    }
}
