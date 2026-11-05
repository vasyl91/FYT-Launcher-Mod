package org.apache.poi.poifs.crypt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum EncryptionMode {
    binaryRC4("org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionInfoBuilder", 1, 1, 0),
    cryptoAPI("org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionInfoBuilder", 4, 2, 4),
    standard("org.apache.poi.poifs.crypt.standard.StandardEncryptionInfoBuilder", 4, 2, 36),
    agile("org.apache.poi.poifs.crypt.agile.AgileEncryptionInfoBuilder", 4, 4, 64),
    xor("org.apache.poi.poifs.crypt.xor.XOREncryptionInfoBuilder", 0, 0, 0);

    public final String builder;
    public final int encryptionFlags;
    public final int versionMajor;
    public final int versionMinor;

    EncryptionMode(String str, int i, int i2, int i3) {
        this.builder = str;
        this.versionMajor = i;
        this.versionMinor = i2;
        this.encryptionFlags = i3;
    }
}
