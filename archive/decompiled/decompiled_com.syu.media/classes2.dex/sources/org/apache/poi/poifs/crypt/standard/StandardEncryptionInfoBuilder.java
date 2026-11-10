package org.apache.poi.poifs.crypt.standard;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StandardEncryptionInfoBuilder implements EncryptionInfoBuilder {
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        littleEndianInput.readInt();
        StandardEncryptionHeader standardEncryptionHeader = new StandardEncryptionHeader(littleEndianInput);
        encryptionInfo.setHeader(standardEncryptionHeader);
        encryptionInfo.setVerifier(new StandardEncryptionVerifier(littleEndianInput, standardEncryptionHeader));
        if (encryptionInfo.getVersionMinor() == 2) {
            if (encryptionInfo.getVersionMajor() == 3 || encryptionInfo.getVersionMajor() == 4) {
                Decryptor standardDecryptor = new StandardDecryptor();
                standardDecryptor.setEncryptionInfo(encryptionInfo);
                encryptionInfo.setDecryptor(standardDecryptor);
            }
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        if (cipherAlgorithm != CipherAlgorithm.aes128 && cipherAlgorithm != CipherAlgorithm.aes192 && cipherAlgorithm != CipherAlgorithm.aes256) {
            throw new EncryptedDocumentException("Standard encryption only supports AES128/192/256.");
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        if (hashAlgorithm != HashAlgorithm.sha1) {
            throw new EncryptedDocumentException("Standard encryption only supports SHA-1.");
        }
        if (chainingMode == null) {
            chainingMode = ChainingMode.ecb;
        }
        if (chainingMode != ChainingMode.ecb) {
            throw new EncryptedDocumentException("Standard encryption only supports ECB chaining.");
        }
        if (i == -1) {
            i = cipherAlgorithm.defaultKeySize;
        }
        if (i2 == -1) {
            i2 = cipherAlgorithm.blockSize;
        }
        boolean z = false;
        for (int i3 : cipherAlgorithm.allowedKeySize) {
            z |= i3 == i;
        }
        if (!z) {
            throw new EncryptedDocumentException("KeySize " + i + " not allowed for Cipher " + cipherAlgorithm);
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        int i4 = i;
        int i5 = i2;
        ChainingMode chainingMode2 = chainingMode;
        encryptionInfo.setHeader(new StandardEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2));
        encryptionInfo.setVerifier(new StandardEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2));
        StandardDecryptor standardDecryptor = new StandardDecryptor();
        standardDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(standardDecryptor);
        StandardEncryptor standardEncryptor = new StandardEncryptor();
        standardEncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(standardEncryptor);
    }
}
