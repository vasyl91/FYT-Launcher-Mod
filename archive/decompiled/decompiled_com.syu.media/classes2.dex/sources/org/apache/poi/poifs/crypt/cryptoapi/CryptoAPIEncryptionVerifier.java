package org.apache.poi.poifs.crypt.cryptoapi;

import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CryptoAPIEncryptionVerifier extends StandardEncryptionVerifier implements Cloneable {
    protected CryptoAPIEncryptionVerifier(LittleEndianInput littleEndianInput, CryptoAPIEncryptionHeader cryptoAPIEncryptionHeader) {
        super(littleEndianInput, cryptoAPIEncryptionHeader);
    }

    protected CryptoAPIEncryptionVerifier(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        super(cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setSalt(byte[] bArr) {
        super.setSalt(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifierHash(byte[] bArr) {
        super.setEncryptedVerifierHash(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public CryptoAPIEncryptionVerifier clone() throws CloneNotSupportedException {
        return (CryptoAPIEncryptionVerifier) super.clone();
    }
}
