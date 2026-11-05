package org.apache.commons.codec.digest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum HmacAlgorithms {
    HMAC_MD5("HmacMD5"),
    HMAC_SHA_1("HmacSHA1"),
    HMAC_SHA_256("HmacSHA256"),
    HMAC_SHA_384("HmacSHA384"),
    HMAC_SHA_512("HmacSHA512");

    private final String algorithm;

    HmacAlgorithms(String str) {
        this.algorithm = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.algorithm;
    }
}
