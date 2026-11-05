package org.apache.poi.poifs.crypt;

import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum CipherAlgorithm {
    rc4(CipherProvider.rc4, "RC4", 26625, 64, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, -1, 20, "RC4", false),
    aes128(CipherProvider.aes, "AES", 26126, 128, new int[]{128}, 16, 32, "AES", false),
    aes192(CipherProvider.aes, "AES", 26127, 192, new int[]{192}, 16, 32, "AES", false),
    aes256(CipherProvider.aes, "AES", 26128, 256, new int[]{256}, 16, 32, "AES", false),
    rc2(null, "RC2", -1, 128, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, 8, 20, "RC2", false),
    des(null, "DES", -1, 64, new int[]{64}, 8, 32, "DES", false),
    des3(null, "DESede", -1, 192, new int[]{192}, 8, 32, "3DES", false),
    des3_112(null, "DESede", -1, 128, new int[]{128}, 8, 32, "3DES_112", true),
    rsa(null, "RSA", -1, 1024, new int[]{1024, 2048, 3072, 4096}, -1, -1, "", false);

    public final int[] allowedKeySize;
    public final int blockSize;
    public final int defaultKeySize;
    public final int ecmaId;
    public final int encryptedVerifierHashLength;
    public final String jceId;
    public final boolean needsBouncyCastle;
    public final CipherProvider provider;
    public final String xmlId;

    CipherAlgorithm(CipherProvider cipherProvider, String str, int i, int i2, int[] iArr, int i3, int i4, String str2, boolean z) {
        this.provider = cipherProvider;
        this.jceId = str;
        this.ecmaId = i;
        this.defaultKeySize = i2;
        this.allowedKeySize = (int[]) iArr.clone();
        this.blockSize = i3;
        this.encryptedVerifierHashLength = i4;
        this.xmlId = str2;
        this.needsBouncyCastle = z;
    }

    public static CipherAlgorithm fromEcmaId(int i) {
        for (CipherAlgorithm cipherAlgorithm : values()) {
            if (cipherAlgorithm.ecmaId == i) {
                return cipherAlgorithm;
            }
        }
        throw new EncryptedDocumentException("cipher algorithm " + i + " not found");
    }

    public static CipherAlgorithm fromXmlId(String str, int i) {
        for (CipherAlgorithm cipherAlgorithm : values()) {
            if (cipherAlgorithm.xmlId.equals(str)) {
                for (int i2 : cipherAlgorithm.allowedKeySize) {
                    if (i2 == i) {
                        return cipherAlgorithm;
                    }
                }
            }
        }
        throw new EncryptedDocumentException("cipher algorithm " + str + "/" + i + " not found");
    }
}
