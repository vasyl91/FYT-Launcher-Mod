package org.apache.poi.poifs.crypt.xor;

import java.io.IOException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XOREncryptionInfoBuilder implements EncryptionInfoBuilder {
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        encryptionInfo.setHeader(new XOREncryptionHeader());
        encryptionInfo.setVerifier(new XOREncryptionVerifier(littleEndianInput));
        XORDecryptor xORDecryptor = new XORDecryptor();
        xORDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(xORDecryptor);
        XOREncryptor xOREncryptor = new XOREncryptor();
        xOREncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(xOREncryptor);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        encryptionInfo.setHeader(new XOREncryptionHeader());
        encryptionInfo.setVerifier(new XOREncryptionVerifier());
        XORDecryptor xORDecryptor = new XORDecryptor();
        xORDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(xORDecryptor);
        XOREncryptor xOREncryptor = new XOREncryptor();
        xOREncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(xOREncryptor);
    }
}
