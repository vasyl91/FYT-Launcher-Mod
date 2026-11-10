package org.apache.poi.poifs.crypt;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum HashAlgorithm {
    none("", 0, "", 0, "", false),
    sha1(MessageDigestAlgorithms.SHA_1, 32772, "SHA1", 20, "HmacSHA1", false),
    sha256(MessageDigestAlgorithms.SHA_256, 32780, "SHA256", 32, "HmacSHA256", false),
    sha384(MessageDigestAlgorithms.SHA_384, 32781, "SHA384", 48, "HmacSHA384", false),
    sha512(MessageDigestAlgorithms.SHA_512, 32782, "SHA512", 64, "HmacSHA512", false),
    md5(MessageDigestAlgorithms.MD5, -1, MessageDigestAlgorithms.MD5, 16, "HmacMD5", false),
    md2(MessageDigestAlgorithms.MD2, -1, MessageDigestAlgorithms.MD2, 16, "Hmac-MD2", true),
    md4("MD4", -1, "MD4", 16, "Hmac-MD4", true),
    ripemd128("RipeMD128", -1, "RIPEMD-128", 16, "HMac-RipeMD128", true),
    ripemd160("RipeMD160", -1, "RIPEMD-160", 20, "HMac-RipeMD160", true),
    whirlpool("Whirlpool", -1, "WHIRLPOOL", 64, "HMac-Whirlpool", true),
    sha224("SHA-224", -1, "SHA224", 28, "HmacSHA224", true);

    public final int ecmaId;
    public final String ecmaString;
    public final int hashSize;
    public final String jceHmacId;
    public final String jceId;
    public final boolean needsBouncyCastle;

    HashAlgorithm(String str, int i, String str2, int i2, String str3, boolean z) {
        this.jceId = str;
        this.ecmaId = i;
        this.ecmaString = str2;
        this.hashSize = i2;
        this.jceHmacId = str3;
        this.needsBouncyCastle = z;
    }

    public static HashAlgorithm fromEcmaId(int i) {
        for (HashAlgorithm hashAlgorithm : values()) {
            if (hashAlgorithm.ecmaId == i) {
                return hashAlgorithm;
            }
        }
        throw new EncryptedDocumentException("hash algorithm not found");
    }

    public static HashAlgorithm fromEcmaId(String str) {
        for (HashAlgorithm hashAlgorithm : values()) {
            if (hashAlgorithm.ecmaString.equals(str)) {
                return hashAlgorithm;
            }
        }
        throw new EncryptedDocumentException("hash algorithm not found");
    }

    public static HashAlgorithm fromString(String str) {
        for (HashAlgorithm hashAlgorithm : values()) {
            if (hashAlgorithm.ecmaString.equalsIgnoreCase(str) || hashAlgorithm.jceId.equalsIgnoreCase(str)) {
                return hashAlgorithm;
            }
        }
        throw new EncryptedDocumentException("hash algorithm not found");
    }
}
